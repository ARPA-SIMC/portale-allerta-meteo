<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="./init.jsp"%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

<%
	HttpServletRequest loginRequest = 
				PortalUtil.getOriginalServletRequest(
						PortalUtil.getHttpServletRequest(renderRequest));


	User u = themeDisplay.getUser();
	boolean logged = u!=null && !u.isDefaultUser();
%>

<portlet:actionURL name="/allerta/user-login" var="loginURL">
	<portlet:param name="redirect" value="<%=loginRequest.getParameter("redirect") %>"/>
</portlet:actionURL>

<portlet:renderURL var="regURL">
	<portlet:param name="mvcRenderCommandName" value="/allerta/user-reg"/>
</portlet:renderURL>

<portlet:renderURL var="forgotURL">
	<portlet:param name="mvcRenderCommandName" value="/allerta/forgot-password"/>
</portlet:renderURL>

<main class="page main page--login" id="main-content">

<div class="container d-flex pt-5">
	<div class="row w-100 justify-content-between">
		<h1 class="col-12 col-lg-8">Area riservata Allerta Meteo</h1>

		<p class="col-12 lead"></p>
	</div>
</div>




<style>
.ricordami {
	margin-right:0.5em;
}
.occhio {
	float: right;
	position: relative;
	top: 2.8rem;
	left: -0.4rem;
	cursor: pointer;
	z-index: 10;
}
</style>

<div class="container d-flex">
	<!-- Login screen -->
	<div class="u-content-container py-md-4">
		<div class="row flex-md-row">
			<div class="col-12 col-md-12">
			
				<p>L'accesso &egrave; riservato. Per rimanere aggiornato seguici su 
				<a href="https://twitter.com/AllertaMeteoRER" target="_blank">Twitter</a> 
				e <a target="_blank" href="https://t.me/AllertaMeteoEMR">Telegram</a>.

				</p>
				
				<c:if test="<%=logged %>">
				<p>Hai effettuato il login con successo, <b><%=(u.getFirstName()!=null?u.getFirstName():"")+" "+(u.getLastName()!=null?u.getLastName():"") %></b>.</p>
				</c:if>
				<c:if test="<%=!logged %>">
				<aui:form action="<%=loginURL%>" method="post" name="fm1"
					cssClass="u-section--gray u-section--rounded-corners p-3 p-lg-4">
					<h2 class="sr-only">Inserisci username e password per accedere</h2>
					<div class="form-group">
						<div class="row">
							

							<!-- input -->
							<div class="col-12 col-md-9">
								<aui:input 
									name="userName" 
									type="text"
									class="form-control" 
									placeholder=""
									value="">
									<aui:validator name="required"></aui:validator>
								</aui:input>
								
							</div>
						</div>
						<!-- /.row -->
					</div>
					<!-- /.form-group  -->

					<div class="form-group">
						<div class="row">
							
							<!-- input -->
							<div class="col-12 col-md-9">
								<i class="far fa-eye occhio" id="togglePassword"></i>
								<aui:input 
									name="password" 
									type="password"
									class="form-control" 
									placeholder="" 
									aria-describedby="idPasswordMessage"
									value="">
									<aui:validator name="required"></aui:validator>
								</aui:input>
								
						
							</div>
							<div class="col-12">
							
								<aui:input cssClass="ricordami"
									formName="ricordami"
									label="Ricordami"
									name="ricordami" 
									type="checkbox"
									class="form-control" 
									placeholder="" 
									value="">
								</aui:input>
						
							</div>
							<!-- messaggio -->
							<div class="col-12">
								<small class="help-block" id="idPasswordMessage" role="alert">
									<a href="<%=forgotURL %>"
									title="Recupera la password">Hai dimenticato la password?</a>
								</small>
							</div>


						</div>
						<!-- /.row -->
					</div>
					<!-- /.form-group  -->
					<div class="form-group">
						<div class="row">
							<div class="col-12">
								<aui:button type="submit" value="Accedi"
									cssClass="btn btn-primary btn-lg"></aui:button>
							</div>
						</div>
					</div>

				</aui:form>
				</c:if>
			</div>

		</div>


	</div>
	<!-- / Login screen -->
</div>

<script type="text/javascript">
const togglePassword = document.querySelector('#togglePassword');
const password = document.querySelector('#_AllertaUserRegistration_password');

togglePassword.addEventListener('click', function (e) {
    // toggle the type attribute
    const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
    password.setAttribute('type', type);
    // toggle the eye slash icon
    this.classList.toggle('fa-eye-slash');
});

</script>

</main>