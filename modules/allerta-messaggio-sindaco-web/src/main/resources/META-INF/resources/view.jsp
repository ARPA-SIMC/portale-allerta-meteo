<%@ include file="./init.jsp"%>


<div class="container">

<div class="row">
	<div class="col-12">
		<h2>Prepara e invia la comunicazione</h2>
	</div>
</div>
<div class="row">
	<div class="col-12">
		<h4 ><a data-toggle="collapse" href="#commInfo"  aria-expanded="false"
			aria-controls=commInfo"><span class"icon i-info-circle">Maggiori informazioni</span></a></h4>
	</div>	
	<div class="col-12 collapse" id="commInfo">
		Con questo strumento puoi comunicare agli utenti la situazione di allerta prevista, la fase di protezione civile attivata nel tuo comune e i comportamenti da tenere per ridurre i rischi legati ad essa.
		<br/>
		Ti invitiamo a seguire i suggerimenti presenti nella sezione laterale destra della pagina.
		
	</div>
</div>

<portlet:actionURL name="/allertaer/comunicazioni/invia" var="inviaUrl">
</portlet:actionURL>


<aui:form method="post" name="fmInvia" action="<%=inviaUrl.toString() %>" enctype="multipart/form-data">

	<aui:input name="step" type="hidden"></aui:input>
		
	<div class="row">
		<div class="col-12">
			<liferay-util:include page="/parts/stepWizard.jsp" servletContext="<%=getServletContext() %>"></liferay-util:include>
		</div>		
	</div>

	<div class="row">
		<div class="col-12">
			<aui:button-row>
				<c:if test="${messaggioBean.step > 1 }">				
					<button class="btn btn-default" 
						onclick="<portlet:namespace/>submitComunicazione('off')">Indietro</button>				
					
				</c:if>
				
				<c:choose>
					<c:when test="${messaggioBean.step == 3 }">
						<button class="btn btn-primary" 
							onclick="<portlet:namespace/>submitComunicazione('send')">Conferma e Invia</button>				
					</c:when>
					<c:when test="${messaggioBean.step < 3 }">
						<button class="btn btn-primary" 
							onclick="<portlet:namespace/>submitComunicazione('on')">Avanti</button>			
						
					</c:when>		
					<c:otherwise>
						
					</c:otherwise>
				</c:choose>
					
			</aui:button-row>
		</div>
	</div>

</aui:form>

<script type="text/javascript">
function <portlet:namespace/>submitComunicazione(step) {
	$("#<portlet:namespace/>step").val(step);
	submitForm(document.forms.<portlet:namespace/>fmInvia);
}
</script>

</div>