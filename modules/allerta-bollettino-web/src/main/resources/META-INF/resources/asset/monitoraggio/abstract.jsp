<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.UserNotificationEvent"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserNotificationEventLocalService"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.notifications.UserNotificationManagerUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.eng.bollettino.service.BollettinoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="it.eng.bollettino.model.Bollettino"%>
<%@ include file="../../init.jsp" %>
<%

Bollettino feedback=null;
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm",Locale.ITALIAN);
SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMMM yyyy",Locale.ITALIAN);

if(request.getAttribute("bollettino")!=null)
 feedback = (Bollettino)request.getAttribute("bollettino");

String displaynone = (feedback.getStato()==WorkflowConstants.STATUS_APPROVED?"":"display:none");
String notdisplaynone = (feedback.getStato()!=WorkflowConstants.STATUS_APPROVED?"":"display:none");

Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
Folder dir=null;
String pdfLink = "#";

Date c = null;

try {
	pdfLink = feedback.getLink();
} catch (Exception e) {
	e.printStackTrace();
}

String previewPdfLink = pdfLink + "?previewFile=1";

long wflMonitoraggioPlid = PortalUtil.getPlidFromPortletId(feedback.getGroupId(), false, AllertaKeys.AllertaCompilaMonitoraggioPortlet);

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
						Bollettino.class.getName(), 
						feedback.getBollettinoId());
		
		if( !hasWfl)
			workflowTaskId = 0;
		else {
			 WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), workflowTaskId);
			 
             boolean taskPerm = WorkflowPermissionUtil.hasPermission(
				                		themeDisplay.getPermissionChecker(), 
				                		feedback.getGroupId(), 
				                		Bollettino.class.getName(), 
				                		feedback.getBollettinoId(), 
				                		task.getName());
             
             if( !taskPerm)
            	 workflowTaskId = 0;
		}
	}
}

%>


<style type="text/css">
	.mb-2 {
		display:none !important;
	}
	
	.metadata-author {
		display:none;
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
	
	.task-content-actions {
		display:none;
	}
		
</style>

 <liferay-portlet:actionURL 
	 	var="approveUrl" 
	 	name="/allertaer/monitoraggio/workflow"
	 	portletName="<%=AllertaKeys.AllertaCompilaMonitoraggioPortlet%>"
		plid="<%=wflMonitoraggioPlid %>">
	<liferay-portlet:param name="cmd" value="approve"/> 	
	<liferay-portlet:param name="bollettinoId" value="<%=String.valueOf(feedback.getBollettinoId()) %>"/>
		<liferay-portlet:param name="taskId" value="<%=String.valueOf(workflowTaskId) %>" />
</liferay-portlet:actionURL>

 <liferay-portlet:actionURL 
	 	var="rejectUrl" 
	 	name="/allertaer/monitoraggio/workflow"
	 	portletName="<%=AllertaKeys.AllertaCompilaMonitoraggioPortlet%>"
		plid="<%=wflMonitoraggioPlid %>">
	<liferay-portlet:param name="cmd" value="reject"/> 	
	<liferay-portlet:param name="bollettinoId" value="<%=String.valueOf(feedback.getBollettinoId()) %>"/>
		<liferay-portlet:param name="taskId" value="<%=String.valueOf(workflowTaskId) %>" />
</liferay-portlet:actionURL>

<main class="page main page--single-doc" id="main-content">

	<div class="page__head">
		<div class="container d-flex">
			<div class="row w-100 justify-content-between">
				<h1 class="col-12 col-lg-10">Monitoraggio N. <%=feedback.getNumero()%></h1>
			</div>
		</div>
	
		<div class="breadcrumb-container">
			<div class="container d-flex">
				<nav class="row" aria-label="Hai percorso">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="/">Home</a></li>
						<li class="breadcrumb-item"><a href="/monitoraggio-eventi">Monitoraggio eventi</a></li>
						<li class="breadcrumb-item active" aria-current="page">Monitoraggio N. <%=feedback.getNumero()%></li>
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
						<span class="icon i-clock" title="Icona orologio"></span>
						Emanato il <%=(feedback.getDataEmissione() != null ? sdf2.format(feedback.getDataEmissione()) : "---")%>
								alle <%=(feedback.getDataEmissione() != null ? sdf.format(feedback.getDataEmissione()) : "---")%>
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
						<%=feedback.getNoteMeteo()%>
					</div>
					
					<div class="page--single-doc__desc"></div>
					
					<div class="page--single-doc__hash">Hash del file (SHA-256): <%=feedback.getHash()%></div>
	
	
					<div class="page--single-doc__cta">
						<a
							href="<%=pdfLink %>"
							class="btn btn-lg btn-primary" data-toggle="pdf-viewer"> <span
							class="icon i-file-pdf-o" aria-hidden="true"></span> VEDI IL MONITORAGGIO
						</a>
					</div>
	               
					<section class="px-lg-3">
						<p class="sr-only">Di seguito ulteriori risorse e strumenti
							utili correlati a questo documento.</p>
						<div class="row"></div>
					</section>
	
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
