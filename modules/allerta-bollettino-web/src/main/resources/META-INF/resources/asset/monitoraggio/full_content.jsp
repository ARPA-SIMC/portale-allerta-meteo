<%@page import="it.eng.allerter.service.LogInternoLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.permission.WorkflowPermissionUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowInstance"%>
<%@page import="com.liferay.portal.kernel.exception.NoSuchWorkflowInstanceLinkException"%>
<%@page import="com.liferay.portal.kernel.model.WorkflowInstanceLink"%>
<%@page import="com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil"%>
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
try {
	pdfLink = feedback.getLink();
} catch (Exception e) {
	e.printStackTrace();
}
String previewPdfLink = pdfLink += "?previewFile=1";

//long loginPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), false, AllertaKeys.AllertaLogin);

String loginPortletId = AllertaKeys.AllertaLogin;

String socialPortletId = AllertaKeys.AllertaSocialPortlet;

long wflMonitoraggioPlid = PortalUtil.getPlidFromPortletId(feedback.getGroupId(), false, AllertaKeys.AllertaCompilaMonitoraggioPortlet);
long workflowTaskId = 0;

try {
	if (feedback.getStato()==1 || feedback.getStato()==1000) {
		//in approvazione?
		long allertaId = feedback.getBollettinoId();
		boolean hasWfl = 
				WorkflowInstanceLinkLocalServiceUtil.hasWorkflowInstanceLink(
						feedback.getCompanyId(), 
						feedback.getGroupId(), 
						Bollettino.class.getName(), 
						allertaId);
		if (hasWfl) {
			WorkflowInstanceLink wil= null;
			
			try {
				wil = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
									feedback.getCompanyId(), 
									feedback.getGroupId(), 
									Bollettino.class.getName(), 
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
		                		Bollettino.class.getName(), 
		                		allertaId, 
		                		wt.getName());
       					
       					if (!taskPerm) continue;
       					 
           				 LogInternoLocalServiceUtil.log("workflowMonitoraggio", "test", "taskId->"+wt.getWorkflowTaskId(), null);
           				 workflowTaskId = wt.getWorkflowTaskId();
       					 break;
       				 }
       			 }
       		 }
			}
		}
	}

} catch (Exception e) {
	LogInternoLocalServiceUtil.log("bottettinoMonitoraggioJsp", "task", e, "");
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
						<a
							href="<%=pdfLink %>"
							class="btn btn-lg btn-primary" data-toggle="liferay-modal"> <span
							class="icon i-file-pdf-o" aria-hidden="true"></span> VEDI IL MONITORAGGIO
						</a>
					</div>
	
	
					<hr>
			
			
                   
					<section class="px-lg-3">
						<p class="sr-only">Di seguito ulteriori risorse e strumenti
							utili correlati a questo documento.</p>
						<div class="row"></div>
					</section>
	
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
		
			<div class="col-12 col-lg-2">
		  		<liferay-portlet:runtime portletName="<%=socialPortletId %>" />     
            </div>
            		
		</div>
	</div>

</main>
