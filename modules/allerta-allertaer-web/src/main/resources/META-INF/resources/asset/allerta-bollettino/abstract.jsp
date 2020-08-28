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
<%@page import="it.eng.allerter.model.AllertaStato"%>

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
<%@taglib uri="http://liferay.com/tld/journal" prefix="liferay-journal"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />
<theme:defineObjects />

<%
	Allerta feedback = null;

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.ITALY);
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMMM yyyy", Locale.ITALY);

	if (request.getAttribute("allerta") != null)
		feedback = (Allerta) request.getAttribute("allerta");

	DynamicQuery dyn = DynamicQueryFactoryUtil.forClass(AllertaStato.class)
			.add(PropertyFactoryUtil.forName("allertaId").eq(feedback.getAllertaId()));

	List<AllertaStato> bb = AllertaStatoLocalServiceUtil.dynamicQuery(dyn);
	List<Long> stati = new ArrayList<Long>();
	List<String> classi = new ArrayList<String>();

	String vedi = "";
	String hash = "<p>Hash del file (SHA-256): " + feedback.getHash() + "</p>";

	if (feedback != null && feedback.getTipoAllerta())
		vedi = "VEDI L'ALLERTA";
	else
		vedi = "VEDI IL BOLLETTINO";

	for (AllertaStato b : bb) {

		if (b.getStatoId() != 1000 && b.getStatoId() != 0) {

			boolean trovato = false;

			for (Long l : stati)
				if (l.equals(b.getEventoId())) {
					trovato = true;
				}

			if (!trovato) {

				stati.add(b.getEventoId());

				if (b.getEventoId() == 1)
					classi.add(".idraulica");
				if (b.getEventoId() == 2)
					classi.add(".idrogeologica");
				if (b.getEventoId() == 3)
					classi.add(".temporali");
				if (b.getEventoId() == 4)
					classi.add(".vento");
				if (b.getEventoId() == 5)
					classi.add(".temperature");
				if (b.getEventoId() == 6)
					classi.add(".neve");
				if (b.getEventoId() == 7)
					classi.add(".ghiaccio");
				if (b.getEventoId() == 8)
					classi.add(".mare");
				if (b.getEventoId() == 9)
					classi.add(".costiera");
			}

		}
	}

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
					sintesiLink="/allerte-e-bollettini?p_p_id=AllertaCompilaSbPortlet&p_p_lifecycle=0&_AllertaCompilaSbPortlet_mvcRenderCommandName=%2Fallertaer%2Fallerta%2Fcompila&_AllertaCompilaSbPortlet_allertaId="+
							feedback.getAllertaId()+"&_AllertaCompilaSbPortlet_sintesi=true";
							
					sintesiLink = "<a href=\"" + sintesiLink + "\">Modifica sintesi documento</a>";
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
					modificaLink = "<a href=\"" + modificaLink + "\">Modifica documento</a>";
					modificaLink = "<div class=\"allerta-boll-documento__modifica\">" + modificaLink + "</div>";
				}

			}

		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	

	long wflMonitoraggioPlid = PortalUtil.getPlidFromPortletId(feedback.getGroupId(), false, AllertaKeys.AllertaCompilaSbPortlet);
	long workflowTaskId = ParamUtil.getLong(request, "workflowTaskId");
	long userNotificationEventId = ParamUtil.getLong(request, "userNotificationEventId");
	
	
	if(feedback.getStato() == WorkflowConstants.STATUS_APPROVED || feedback.getStato() == WorkflowConstants.STATUS_DENIED) {
		workflowTaskId = 0;
		userNotificationEventId = 0;
	}
	
	if( userNotificationEventId > 0) {
		
		DynamicQuery query = UserNotificationEventLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("userNotificationEventId").eq(userNotificationEventId));
		
		List<UserNotificationEvent> unevt = UserNotificationEventLocalServiceUtil.dynamicQuery(query);
		
		if( unevt.size() > 0) {
			
			UserNotificationEvent evt = unevt.get(0);
			
			JSONObject payload = JSONFactoryUtil.createJSONObject(evt.getPayload());
			workflowTaskId = payload.getLong("workflowTaskId");
			
			boolean hasWfl = 
					WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(
							themeDisplay.getCompanyId(), 
							feedback.getGroupId(), 
							Allerta.class.getName(), 
							feedback.getAllertaId());
			
			if( !hasWfl)
				workflowTaskId = 0;
			else {
				 WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), workflowTaskId);
				 
	             boolean taskPerm = WorkflowPermissionUtil.hasPermission(
					                		themeDisplay.getPermissionChecker(), 
					                		feedback.getGroupId(), 
					                		Allerta.class.getName(), 
					                		feedback.getAllertaId(), 
					                		task.getName());
	             
	             if( !taskPerm)
	            	 workflowTaskId = 0;
			}
		}
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
				<h1 class="col-12 col-lg-10"><%=feedback.getTitolo()%></h1>
			</div>
		</div>

		<div class="breadcrumb-container">
			<div class="container d-flex">
				<nav class="row" aria-label="Hai percorso">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="/">Home</a></li>
						<li class="breadcrumb-item"><a href="/allerte-e-bollettini">Allerte
								e bollettini</a></li>
						<li class="breadcrumb-item active" aria-current="page"><%=feedback.getTitolo()%></li>
					</ol>
				</nav>
			</div>
		</div>
	</div>

	<div class="container page__body">
		<div class="row">
	
			<%if( workflowTaskId > 0) { %>
			<div class="col-6 ">
				<a href="<%=approveUrl %>" class="btn btn-primary"> Approva </a>
			</div>
			<div class="col-6 ">
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
						<%=(feedback.getSintesi()!=null && !feedback.getSintesi().equals("")?
								feedback.getSintesi(): feedback.getDescrizioneMeteo())%>
					</div>

					<div class="page--single-doc__desc"></div>

					<div class="page--single-doc__hash">
						Hash del file (SHA-256):
						<%=feedback.getHash()%></div>


					<h3 hidden aria-hidden="true">Strumenti di supporto</h3>
					<h4 hidden aria-hidden="true">Finestre modali di anteprima dei
						documenti</h4>
						
					<div class="row">
						<div class="col-12">
							<h3>Anteprima del PDF</h3>
							<p>
								(non riesci a vederlo bene? <a data-beforeload="pdf-viewer"
									href="<%=pdfLink%>" title="Scarica il PDF"> <span
									class="icon i-donwload" aria-hidden="true"></span> Scarica il
									PDF
								</a>).
							</p>

						</div>
					</div>				
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
					
				</div>
			</div>
		</div>
	</div>



</main>
