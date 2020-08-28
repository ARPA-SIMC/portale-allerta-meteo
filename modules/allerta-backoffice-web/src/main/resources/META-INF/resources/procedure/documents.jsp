<%@ include file="../init.jsp"%>

<portlet:actionURL name="configureDocumentsFolder" var="configureDocumentsFolderURL"></portlet:actionURL>


<div class="container">

	<div class="row">
		<div class="col-lg-12">
			<aui:form name="fm1" method="post" action="">
				<table class="table table-autofit table-list">


					<tr>
						<td><aui:button type="button" cssClass="btn btn-primary"
								onClick='javascript:doConfiguration()'
								value="Avvia Configurazione"></aui:button></td>

					</tr>


				</table>
			</aui:form>
		</div>

	</div>
</div>


<script type="text/javascript">
	function doConfiguration() {
		document.forms.<portlet:namespace/>fm1.action = '<%=configureDocumentsFolderURL.toString()%>';
		document.forms.<portlet:namespace/>fm1.submit();
	}
	
	
	
</script>