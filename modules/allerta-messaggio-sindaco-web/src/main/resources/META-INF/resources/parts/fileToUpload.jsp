<%@ include file="../init.jsp"%>

	
<aui:input name="fileHash" type="hidden"></aui:input>
	
<div class="row">
	<div class="col-9">
		<aui:input name="fileUpload" class="fileUpload" type="file" 
			label="Allega documento" ></aui:input>   
    			
	</div>
	<div class="col-3">
		<label>&nbsp;</label>
		<button class="btn btn-primary" type="button" onclick="<portlet:namespace/>uplodaFile()" >Carica</button>
	</div>
</div>


<div class="row">
	<div class="col-12">
		<h4>Documenti allegati alla comunicazione</h4>
		<table class="table table-hover table-bordered" >
			<tr>
				<th>Nome</th>
				<th></th>
			</tr>
			<c:forEach items="${messaggioBean.uploadedFiles }" var="file">
				<tr>
					<td>${file.title }</td>
					<td>
						<button class="btn btn-danger" onclick="<portlet:namespace/>deleteFile('${file.hash }')" >Rimuovi</button>
					</td>
					
				</tr>
			</c:forEach>
			
		</table>
	</div>
</div>



<script type="text/javascript">
function <portlet:namespace/>uplodaFile() {
	
	$("#<portlet:namespace/>step").val('upload');	
	document.forms.<portlet:namespace/>fmInvia.submit();
	
}

function <portlet:namespace/>deleteFile(hash) {
	$("#<portlet:namespace/>fileHash").val(hash);
	$("#<portlet:namespace/>step").val('delete');	
	document.forms.<portlet:namespace/>fmInvia.submit();
}
</script>

