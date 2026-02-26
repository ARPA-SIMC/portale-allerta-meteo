<%@page import="it.eng.allerter.service.LogInternoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowInstance"%>
<%@page import="com.liferay.portal.kernel.exception.NoSuchWorkflowInstanceLinkException"%>
<%@page import="com.liferay.portal.kernel.model.WorkflowInstanceLink"%>
<%@page import="com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="it.eng.allerter.model.AllertaParametro"%>
<%@page
    import="it.eng.allerter.service.AllertaParametroLocalServiceUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@page
    import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="it.eng.allerter.service.AllertaStatoLocalServiceUtil"%>
<%@page import="it.eng.allerter.service.AllertaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="it.eng.allerter.model.Allerta"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:defineObjects />
<theme:defineObjects />

<%
    Allerta feedback = null;

    String currentLanguage = LanguageUtil.getLanguageId(request);
    boolean isEnglish = currentLanguage.startsWith("en");
    Locale currentLocale = isEnglish ? Locale.ENGLISH : Locale.ITALY;
    String prefix = isEnglish?"/en":"";

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", currentLocale);
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMMM yyyy", currentLocale);

    if (request.getAttribute("allerta") != null)
        feedback = (Allerta) request.getAttribute("allerta");

    String sintesi = isEnglish && feedback.getSintesiEng() != null && !feedback.getSintesiEng().isEmpty() ?
        feedback.getSintesiEng() : feedback.getSintesi();

    if (sintesi!=null) {
        sintesi = sintesi.replaceAll("\r\n", "<br/>");
        sintesi = sintesi.replaceAll("\r", "<br/>");
        sintesi = sintesi.replaceAll("\n", "<br/>");
        int index = 0;
        while (sintesi.contains("+++")) {
            if (index++ % 2 == 0 ) sintesi = sintesi.replaceFirst("\\+\\+\\+", "<b>");
            else sintesi= sintesi.replaceFirst("\\+\\+\\+", "</b>");
        }
    }

    String titolo = isEnglish && feedback.getTitoloEng() != null && !feedback.getTitoloEng().isEmpty() ?
        feedback.getTitoloEng() : feedback.getTitolo();


    List<Long> stati = new ArrayList<Long>();
    List<String> classi = new ArrayList<String>();

    String vedi = "";
    String hash = "<p>" + LanguageUtil.get(request, "file-hash-sha256") + ": " + feedback.getHash() + "</p>";

    if (feedback != null && feedback.getTipoAllerta())
        vedi = isEnglish?"VIEW ALERT":"VEDI L'ALLERTA";
    else
        vedi = isEnglish?"VIEW BULLETIN":"VEDI IL BOLLETTINO";


    String displaynone = (feedback.getStato() == WorkflowConstants.STATUS_APPROVED ? "" : "display:none");
    String notdisplaynone = (feedback.getStato() != WorkflowConstants.STATUS_APPROVED ? "" : "display:none");
    String stato = LanguageUtil.get(request, "in-review");

    if (feedback.getStato() == WorkflowConstants.STATUS_APPROVED)
        stato = LanguageUtil.get(request, "approved");
    if (feedback.getStato() == WorkflowConstants.STATUS_DRAFT)
        stato = LanguageUtil.get(request, "in-progress");
    if (feedback.getStato() == WorkflowConstants.STATUS_DENIED)
        stato = LanguageUtil.get(request, "rejected");

    System.out.println(stato);

    String pdfLink = feedback.getLink();
    String previewPdfLink = pdfLink += "?previewFile=1";

    String sintesiLink = "";
    String modificaLink = "";
    
	long wflMonitoraggioPlid = 0;
	long workflowTaskId = 0;
	
    

    try {
        AllertaParametro ap = AllertaParametroLocalServiceUtil
                .fetchAllertaParametro("ALLERTA_RUOLI_SINTESI_LINK");

        if (ap != null && ap.getValore() != null && user != null) {

            String[] ruoli = ap.getValore().split(",");

            long roles[] = user.getRoleIds();

            boolean trovato = false;

            for (String s : ruoli)
                for (long r : roles) {
                    if (r == Long.parseLong(s))
                        trovato = true;
                }

            if (trovato) {

                AllertaParametro ap2 = AllertaParametroLocalServiceUtil
                        .fetchAllertaParametro("ALLERTA_SINTESI_LINK");
                if (ap2 != null && ap2.getValore() != null) {
                    //sintesiLink = ap2.getValore() + "?allerta=" + feedback.getAllertaId();
                    sintesiLink="/allerte-e-bollettini?p_p_id=AllertaCompilaSbPortlet&p_p_lifecycle=0&_AllertaCompilaSbPortlet_mvcRenderCommandName=%2Fallertaer%2Fallerta%2Fcompila&_AllertaCompilaSbPortlet_allertaId="+
                            feedback.getAllertaId()+"&_AllertaCompilaSbPortlet_sintesi=true";

                    sintesiLink = "<a href=\"" + sintesiLink + "\">" + (isEnglish?"Edit document summary":"Modifica sintesi documento") + "</a>";
                    sintesiLink = "<div class=\"allerta-boll-documento__sintesi\">" + sintesiLink + "</div>";
                }

            }

        }

        ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_RUOLI_MODIFICA_LINK");

        if (feedback.getStato() == WorkflowConstants.STATUS_DRAFT && ap != null && ap.getValore() != null
                && user != null) {

            String[] ruoli = ap.getValore().split(",");

            long roles[] = user.getRoleIds();

            boolean trovato = false;

            for (String s : ruoli)
                for (long r : roles) {
                    if (r == Long.parseLong(s))
                        trovato = true;
                }

            if (trovato) {

                AllertaParametro ap2 = AllertaParametroLocalServiceUtil
                        .fetchAllertaParametro("ALLERTA_MODIFICA_LINK");

                if (ap2 != null && ap2.getValore() != null) {

                    modificaLink = ap2.getValore() + "?allerta=" + feedback.getAllertaId();
                    modificaLink = "<a href=\"" + modificaLink + "\">" + LanguageUtil.get(request, "edit-document") + "</a>";
                    modificaLink = "<div class=\"allerta-boll-documento__modifica\">" + modificaLink + "</div>";
                }

            }

        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    
    wflMonitoraggioPlid = PortalUtil.getPlidFromPortletId(feedback.getGroupId(), false, AllertaKeys.AllertaCompilaSbPortlet);

	try {
		if (feedback.getStato()==1 || feedback.getStato()==1000) {
			//in approvazione?
			long allertaId = feedback.getAllertaId();
			boolean hasWfl = 
					WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(
							feedback.getCompanyId(), 
							feedback.getGroupId(), 
							Allerta.class.getName(), 
							allertaId);
			if (hasWfl) {
				WorkflowInstanceLink wil= null;
				
				try {
					wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
										feedback.getCompanyId(), 
										feedback.getGroupId(), 
										Allerta.class.getName(), 
										allertaId);
					
				} catch( NoSuchWorkflowInstanceLinkException nse) {
					
				}
				
				if( wil != null) { 
					WorkflowInstance workflowInstance = 
	           			 WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), wil.getWorkflowInstanceId());
					List<WorkflowTask> ls = WorkflowTaskManagerUtil.getWorkflowTasksByWorkflowInstance(themeDisplay.getCompanyId(), 0L, workflowInstance.getWorkflowInstanceId(), false, -1, -1, null);
					if (ls!=null) {
	       			 for (WorkflowTask wt : ls) { 
	       				 if (!wt.isCompleted()) {
	       					 
	       					boolean taskPerm = WorkflowPermissionUtil.hasPermission(
			                		themeDisplay.getPermissionChecker(), 
			                		feedback.getGroupId(), 
			                		Allerta.class.getName(), 
			                		allertaId, 
			                		wt.getName());
	       					
	       					if (!taskPerm) continue;
	       					 
	           				 LogInternoLocalServiceUtil.log("workflow", "test", "taskId->"+wt.getWorkflowTaskId(), null);
	           				 workflowTaskId = wt.getWorkflowTaskId();
	       					 break;
	       				 }
	       			 }
	       		 }
				}
			}
		}

	} catch (Exception e) {
		LogInternoLocalServiceUtil.log("bottettinoJsp", "task", e, "");
	}


    
%>

<style type="text/css">
.mb-2 {
    display: none !important;
}

.metadata-author {
    display: none;
}

.separator {
    display: none;
}

.asset-details {
    display: none;
}

.panel {
    background: none !important;
}
</style>

<liferay-portlet:actionURL 
	 	var="approveUrl" 
	 	name="/allertaer/allerta/workflow"
	 	portletName="<%=AllertaKeys.AllertaCompilaSbPortlet%>"
		plid="<%=wflMonitoraggioPlid %>">
	<liferay-portlet:param name="cmd" value="approve"/> 	
	<liferay-portlet:param name="allertaId" value="<%=String.valueOf(feedback.getAllertaId()) %>"/>
		<liferay-portlet:param name="taskId" value="<%=String.valueOf(workflowTaskId) %>" />
</liferay-portlet:actionURL>

 <liferay-portlet:actionURL 
	 	var="rejectUrl" 
	 	name="/allertaer/allerta/workflow"
	 	portletName="<%=AllertaKeys.AllertaCompilaSbPortlet%>"
		plid="<%=wflMonitoraggioPlid %>">
	<liferay-portlet:param name="cmd" value="reject"/> 	
	<liferay-portlet:param name="allertaId" value="<%=String.valueOf(feedback.getAllertaId()) %>"/>
		<liferay-portlet:param name="taskId" value="<%=String.valueOf(workflowTaskId) %>" />
</liferay-portlet:actionURL>

<main class="page main page--single-doc" id="main-content">

    <div class="page__head">
        <div class="container d-flex">
            <div class="row w-100 justify-content-between">
                <h1 class="col-12 col-lg-10"><%=titolo%></h1>
            </div>
        </div>

        <div class="breadcrumb-container">
            <div class="container d-flex">
                <nav class="row" aria-label="<liferay-ui:message key="breadcrumb" />">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="<%= prefix %>/"><liferay-ui:message key="home" /></a></li>
                        <li class="breadcrumb-item"><a href="<%= prefix %>/allerte-e-bollettini"><liferay-ui:message key="alerts-and-bulletins" /></a></li>
                        <li class="breadcrumb-item active" aria-current="page"><%=titolo%></li>
                    </ol>
                </nav>
            </div>
        </div>
    </div>

    <div class="container page__body">
        <div class="row">
        
        <%if( workflowTaskId > 0) { %>
			<div class="col-6 " style="text-align: center;">
				<a href="<%=approveUrl %>" class="btn btn-primary"> Approva </a>
			</div>
			<div class="col-6 " style="text-align: center;">
				<a href="<%=rejectUrl %>" class="btn btn-primary"> Rifiuta </a>
			</div>
		<%} %>
 

            <div class="col-12 col-md-9 col-lg-10">
                <div class="page__content" id="page-content">

                    <div class="page--single-doc__emitted">
                        <span class="icon i-clock" title="<liferay-ui:message key="clock-icon" />"></span> <liferay-ui:message key="issued-on" />
                        <%=(feedback.getDataEmissione() != null ? sdf2.format(feedback.getDataEmissione()) : "---")%>
                        <liferay-ui:message key="at" />
                        <%=(feedback.getDataEmissione() != null ? sdf.format(feedback.getDataEmissione()) : "---")%>
                    </div>
                    <div class="page--single-doc__validity">
                        <liferay-ui:message key="valid-from" />
                        <%=sdf.format(feedback.getDataInizio())%>
                        <liferay-ui:message key="on" />
                        <%=sdf2.format(feedback.getDataInizio())%>
                        <liferay-ui:message key="until" />
                        <%=sdf.format(feedback.getDataFine())%>
                        <liferay-ui:message key="on" />
                        <%=sdf2.format(feedback.getDataFine())%>
                    </div>

                    <div class="page--single-doc__summary">
                        <%=(sintesi!=null && !sintesi.equals("")?
                                sintesi: feedback.getDescrizioneMeteo())%>

                        <%=(sintesiLink!=null?sintesiLink:"") %>
                    </div>

                    <div class="page--single-doc__desc"></div>

                    <div class="page--single-doc__hash">
                        <liferay-ui:message key="file-hash-sha256" />:
                        <%=feedback.getHash()%></div>

					<c:if test="<%=feedback.getStato()!=0 %>">
					<div class="row">
						<div class="col-12" style="min-height:600px;">
							
							<object class="pdf-viewer" data-beforeload="pdf-viewer"
								data="<%=pdfLink%>" type="application/pdf" style="width:100%;height:100%">
								<p class="p-3">
									Sembra che il tuo browser non riesca a visualizzare i PDF qui
									dentro. <a data-beforeload="pdf-url" href="<%=previewPdfLink%>"
										class="btn btn-sm btn-default"> <span
										class="icon i-download" aria-hidden="true"></span>>Scarica il
										PDF sul tuo dispositivo
									</a>
								</p>
							</object>
						</div>
					</div>
					</c:if>

					<c:if test="<%=feedback.getStato()==0 %>">
                    <div class="page--single-doc__cta">
                        <a href="<%=pdfLink%>" class="btn btn-lg btn-primary"
                            data-toggle="liferay-modal"> <span class="icon i-file-pdf-o"
                            aria-hidden="true"></span> <%=vedi%>
                        </a>
                    </div>


                    <hr>



                    <section class="px-lg-3">
                        <p class="sr-only"><liferay-ui:message key="additional-resources-description" /></p>
                        <div class="row"></div>
                    </section>

                    <h3 hidden aria-hidden="true"><liferay-ui:message key="support-tools" /></h3>
                    <h4 hidden aria-hidden="true"><liferay-ui:message key="document-preview-modals" /></h4>

                    <div class="modal modal-pdf-viewer" tabindex="-1" role="dialog"
                        id="modal-pdf-viewer">
                        <div class="modal-dialog modal-xxl" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">
                                        <liferay-ui:message key="pdf-preview" /> (<liferay-ui:message key="cant-see-it" /> <a
                                            data-beforeload="pdf-viewer"
                                            href="<%=pdfLink %>"
                                            title="<liferay-ui:message key="download-pdf" />"> <span class="icon i-donwload"
                                            aria-hidden="true"></span> <liferay-ui:message key="download-pdf" />
                                        </a>).
                                    </h5>
                                    <button type="button" class="close" data-dismiss="modal"
                                        aria-label="<liferay-ui:message key="close" />">
                                        <span class="icon i-close"
                                            title="<liferay-ui:message key="close-modal-icon" />"></span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <object class="modal__pdf-viewer" data-beforeload="pdf-viewer"
                                        data="<%=pdfLink %>"
                                        type="application/pdf">
                                        <p class="p-3">
                                            <liferay-ui:message key="browser-cant-display-pdf" /> <a data-beforeload="pdf-url"
                                                href="<%=pdfLink %>"
                                                class="btn btn-sm btn-default"> <span
                                                class="icon i-download" aria-hidden="true"></span><liferay-ui:message key="download-pdf-to-device" />
                                            </a>
                                        </p>
                                    </object>
                                </div>

                            </div>
                        </div>
                    </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</main>