<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileVersion"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileVersion"%>
<%@page import="com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.model.UserNotificationEvent"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileEntry"%>
<%@ include file="../../init.jsp" %>

<%
DLFileEntry entry = (DLFileEntry) request.getAttribute("entry");

long wflMonitoraggioPlid = PortalUtil.getPlidFromPortletId(entry.getGroupId(), false, AllertaKeys.AllertaStrumentiComunePortlet);

long workflowTaskId = ParamUtil.getLong(request, "workflowTaskId");
long userNotificationEventId = ParamUtil.getLong(request, "userNotificationEventId");

if(entry.getStatus() == WorkflowConstants.STATUS_APPROVED || entry.getStatus() == WorkflowConstants.STATUS_DENIED) {
	workflowTaskId = 0;
	userNotificationEventId = 0;
}

Role sindaco = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "SINDACO");
Role delegato = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "DELEGATO SINDACO");

if( ! (
		RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), sindaco.getRoleId()) ||
		RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), delegato.getRoleId())
	) ) {
	
	workflowTaskId = 0;
	userNotificationEventId = 0;
}

String queryString = "";
FileEntry fileEntry = DLAppServiceUtil.getFileEntry(entry.getFileEntryId());
FileVersion fileVersion = fileEntry.getFileVersion();

String previewPdfLink =DLUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, queryString);

String pdfLink = previewPdfLink;

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
						entry.getGroupId(), 
						DLFileEntry.class.getName(), 
						entry.getFileEntryId());
		
		if( !hasWfl)
			workflowTaskId = 0;
		else {
			 WorkflowTask task = WorkflowTaskManagerUtil.getWorkflowTask(themeDisplay.getCompanyId(), workflowTaskId);
			 
             boolean taskPerm = WorkflowPermissionUtil.hasPermission(
				                		themeDisplay.getPermissionChecker(), 
				                		entry.getGroupId(), 
				                		DLFileEntry.class.getName(), 
				                		entry.getFileEntryId(), 
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
	 	name="/allertaer/comune/workflow"
	 	portletName="<%=AllertaKeys.AllertaStrumentiComunePortlet%>"
		plid="<%=wflMonitoraggioPlid %>">
	<liferay-portlet:param name="cmd" value="approve"/> 	
	<liferay-portlet:param name="entryId" value="<%=String.valueOf(entry.getFileEntryId()) %>"/>
		<liferay-portlet:param name="taskId" value="<%=String.valueOf(workflowTaskId) %>" />
</liferay-portlet:actionURL>

 <liferay-portlet:actionURL 
	 	var="rejectUrl" 
	 	name="/allertaer/comune/workflow"
	 	portletName="<%=AllertaKeys.AllertaStrumentiComunePortlet%>"
		plid="<%=wflMonitoraggioPlid %>">
	<liferay-portlet:param name="cmd" value="reject"/> 	
	<liferay-portlet:param name="entryId" value="<%=String.valueOf(entry.getFileEntryId()) %>"/>
		<liferay-portlet:param name="taskId" value="<%=String.valueOf(workflowTaskId) %>" />
</liferay-portlet:actionURL>


<main class="page main page--single-doc" id="main-content">

	<div class="page__head">
		<div class="container d-flex">
			<div class="row w-100 justify-content-between">
				<h1 class="col-12 col-lg-10"><%=entry.getTitle()%>  <%=entry.getStatus()  %></h1>
			</div>
		</div>
	
		<div class="breadcrumb-container">
			<div class="container d-flex">
				<nav class="row" aria-label="Hai percorso">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="/">Home</a></li>
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
				
				<br/><br/>
			
		<%} %>
	
			<div class="col-12 col-md-9 col-lg-10">
			
				<div class="page__content" id="page-content">
	
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