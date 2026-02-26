<%@page import="it.eng.allerter.service.LogInternoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowInstance"%>
<%@page import="com.liferay.portal.kernel.exception.NoSuchWorkflowInstanceLinkException"%>
<%@page import="com.liferay.portal.kernel.model.WorkflowInstanceLink"%>
<%@page import="it.eng.allerter.model.AllertaValanghe"%>
<%@page import="com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.model.UserNotificationEvent"%>
<%@page import="com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page
	import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
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

<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="it.eng.allerter.service.AllertaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@taglib uri="http://liferay.com/tld/journal" prefix="liferay-journal"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />
<theme:defineObjects />

<%
	AllertaValanghe feedback = null;

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.ITALY);
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMMM yyyy", Locale.ITALY);

	if (request.getAttribute("allerta") != null)
		feedback = (AllertaValanghe) request.getAttribute("allerta");
	
	String sintesi = feedback.getSintesi();
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

	List<Long> stati = new ArrayList<Long>();
	List<String> classi = new ArrayList<String>();

	String vedi = "";
	String hash = "<p>Hash del file (SHA-256): " + feedback.getHash() + "</p>";

	if (feedback != null && feedback.getTipoAllerta())
		vedi = "VEDI L'ALLERTA VALANGHE";
	else
		vedi = "VEDI IL BOLLETTINO VALANGHE";

	

	String displaynone = (feedback.getStato() == WorkflowConstants.STATUS_APPROVED ? "" : "display:none");
	String notdisplaynone = (feedback.getStato() != WorkflowConstants.STATUS_APPROVED ? "" : "display:none");
	String stato = "In revisione";

	if (feedback.getStato() == WorkflowConstants.STATUS_APPROVED)
		stato = "Approvata";
	if (feedback.getStato() == WorkflowConstants.STATUS_DRAFT)
		stato = "In lavorazione";
	if (feedback.getStato() == WorkflowConstants.STATUS_DENIED)
		stato = "Respinta";

	System.out.println(stato);

	String pdfLink = feedback.getLink();
	String previewPdfLink = pdfLink += "?previewFile=1";
	
	String sintesiLink = "";
	String modificaLink = "";

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
					sintesiLink="/allerte-e-bollettini-valanghe?p_p_id=AllertaValangheCompilaSbPortlet&p_p_lifecycle=0&_AllertaValangheCompilaSbPortlet_mvcRenderCommandName=%2Fallertaer%2Fallerta_valanghe%2Fcompila&_AllertaValangheCompilaSbPortlet_allertaValangheId="+
							feedback.getAllertaValangheId()+"&_AllertaValangheCompilaSbPortlet_sintesi=true";
							
					sintesiLink = "<a href=\"" + sintesiLink + "\">Modifica sintesi documento</a>";
					sintesiLink = "<div class=\"allerta-boll-documento__sintesi\">" + sintesiLink + "</div>";
				}

			}

		}


	} catch (Exception e) {
		e.printStackTrace();
	}

	

	long wflMonitoraggioPlid = PortalUtil.getPlidFromPortletId(feedback.getGroupId(), false, AllertaKeys.AllertaValangheCompilaSbPortlet);
	long workflowTaskId = 0;

	try {
		if (feedback.getStato()==1 || feedback.getStato()==1000) {
			//in approvazione?
			long allertaId = feedback.getAllertaValangheId();
			boolean hasWfl = 
					WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(
							feedback.getCompanyId(), 
							feedback.getGroupId(), 
							AllertaValanghe.class.getName(), 
							allertaId);
			if (hasWfl) {
				WorkflowInstanceLink wil= null;
				
				try {
					wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
										feedback.getCompanyId(), 
										feedback.getGroupId(), 
										AllertaValanghe.class.getName(), 
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
			                		AllertaValanghe.class.getName(), 
			                		allertaId, 
			                		wt.getName());
	       					
	       					if (!taskPerm) continue;
	       					 
	           				 LogInternoLocalServiceUtil.log("workflowValanghe", "test", "taskId->"+wt.getWorkflowTaskId(), null);
	           				 workflowTaskId = wt.getWorkflowTaskId();
	       					 break;
	       				 }
	       			 }
	       		 }
				}
			}
		}

	} catch (Exception e) {
		LogInternoLocalServiceUtil.log("bottettinoValangheJsp", "task", e, "");
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
	 	name="/allertaer/allerta_valanghe/workflow"
	 	portletName="<%=AllertaKeys.AllertaValangheCompilaSbPortlet%>"
		plid="<%=wflMonitoraggioPlid %>">
	<liferay-portlet:param name="cmd" value="approve"/> 	
	<liferay-portlet:param name="allertaValangheId" value="<%=String.valueOf(feedback.getAllertaValangheId()) %>"/>
		<liferay-portlet:param name="taskId" value="<%=String.valueOf(workflowTaskId) %>" />
</liferay-portlet:actionURL>

 <liferay-portlet:actionURL 
	 	var="rejectUrl" 
	 	name="/allertaer/allerta_valanghe/workflow"
	 	portletName="<%=AllertaKeys.AllertaValangheCompilaSbPortlet%>"
		plid="<%=wflMonitoraggioPlid %>">
	<liferay-portlet:param name="cmd" value="reject"/> 	
	<liferay-portlet:param name="allertaValangheId" value="<%=String.valueOf(feedback.getAllertaValangheId()) %>"/>
		<liferay-portlet:param name="taskId" value="<%=String.valueOf(workflowTaskId) %>" />
</liferay-portlet:actionURL>

<main class="page main page--single-doc" id="main-content">

	<div class="page__head">
		<div class="container d-flex">
			<div class="row w-100 justify-content-between">
				<h1 class="col-12 col-lg-10"><%=feedback.getTitolo()%></h1>
			</div>
		</div>

		<div class="breadcrumb-container">
			<div class="container d-flex">
				<nav class="row" aria-label="Hai percorso">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="/">Home</a></li>
						<li class="breadcrumb-item"><a href="/allerte-e-bollettini-valanghe">Allerte e bollettini valanghe</a></li>
						<li class="breadcrumb-item active" aria-current="page"><%=feedback.getTitolo()%></li>
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
						<span class="icon i-clock" title="Icona orologio"></span> Emanato
						il
						<%=(feedback.getDataEmissione() != null ? sdf2.format(feedback.getDataEmissione()) : "---")%>
						alle
						<%=(feedback.getDataEmissione() != null ? sdf.format(feedback.getDataEmissione()) : "---")%>
					</div>
					<div class="page--single-doc__validity">
						Valida dalle
						<%=sdf.format(feedback.getDataInizio())%>
						del
						<%=sdf2.format(feedback.getDataInizio())%>
						fino alle
						<%=sdf.format(feedback.getDataFine())%>
						del
						<%=sdf2.format(feedback.getDataFine())%>
					</div>

					<div class="page--single-doc__summary">
						<%=sintesi!=null && !"".equals(sintesi)?feedback.getSintesi():feedback.getDescrizioneFenomeni() %>
					
						<%=(sintesiLink!=null?sintesiLink:"") %>
					</div>

					<div class="page--single-doc__desc"></div>

					<div class="page--single-doc__hash">
						Hash del file (SHA-256):
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


					<h3 hidden aria-hidden="true">Strumenti di supporto</h3>
					<h4 hidden aria-hidden="true">Finestre modali di anteprima dei
						documenti</h4>
						
					<div class="modal modal-pdf-viewer" tabindex="-1" role="dialog"
						id="modal-pdf-viewer">
						<div class="modal-dialog modal-xxl" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title">
										Anteprima del PDF (non riesci a vederlo bene? <a
											data-beforeload="pdf-viewer"
											href="<%=pdfLink %>"
											title="Scarica il PDF"> <span class="icon i-donwload"
											aria-hidden="true"></span> Scarica il PDF
										</a>).
									</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Chiudi">
										<span class="icon i-close"
											title="Icona del bottone che chiude la finestra modale"></span>
									</button>
								</div>
								<div class="modal-body">
									<object class="modal__pdf-viewer" data-beforeload="pdf-viewer"
										data="<%=pdfLink %>"
										type="application/pdf">
										<p class="p-3">
											Sembra che il tuo browser non riesca a visualizzare i PDF qui
											dentro. <a data-beforeload="pdf-url"
												href="<%=pdfLink %>"
												class="btn btn-sm btn-default"> <span
												class="icon i-download" aria-hidden="true"></span>>Scarica il
												PDF sul tuo dispositivo
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
