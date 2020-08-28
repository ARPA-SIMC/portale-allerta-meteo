<%@ include file="../init.jsp"%>

<portlet:actionURL name="updateJournalAssets" var="updateJournalAssetsURL"></portlet:actionURL>
<portlet:actionURL name="configureDocumentsFolder" var="configureDocumentsFolderURL"></portlet:actionURL>

<div class="container">

	<div class="row">
		<div class="col-lg-12">
			<aui:form name="fm1" method="post" action="">
				<table class="table table-autofit table-list">


					<tr>
						<td><aui:button type="button" cssClass="btn btn-primary"
								onClick='<%=portletDisplay.getNamespace() + "updateJournalAssets();"%>'
								value="Aggiorna Journal Assets"></aui:button></td>

					</tr>
					
					
					<tr>
						<td><aui:button type="button" cssClass="btn btn-primary"
								onClick='javascript:doConfiguration()'
								value="Avvia Configurazione DL"></aui:button></td>

					</tr>


				</table>
			</aui:form>
		</div>

	</div>
</div>


<script type="text/javascript">

	function <portlet:namespace/>updateJournalAssets() {
		document.forms.<portlet:namespace/>fm1.action = '<%=updateJournalAssetsURL.toString()%>';
		document.forms.<portlet:namespace/>fm1.submit();
	}
	
	function doConfiguration() {
		document.forms.<portlet:namespace/>fm1.action = '<%=configureDocumentsFolderURL.toString()%>';
		document.forms.<portlet:namespace/>fm1.submit();
	}
	
</script>