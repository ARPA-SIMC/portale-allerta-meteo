<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="./init.jsp"%>

<%
	HttpServletRequest loginRequest = 
				PortalUtil.getOriginalServletRequest(
						PortalUtil.getHttpServletRequest(renderRequest));
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
		<h1 class="col-12 col-lg-8">Accedi ad Allerta Meteo</h1>

		<p class="col-12 lead"></p>
	</div>
</div>

<style>
.ricordami {
	margin-right:0.5em;
}
</style>

<div class="container d-flex">
	<!-- Login screen -->
	<div class="u-content-container py-md-4">
		<div class="row flex-md-row-reverse">
			<div class="col-12 col-md-6">

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
			</div>
			<div class="col-12 col-md-6">
				<h2>Non hai un account?</h2>
				<p class="pr-lg-5">Registrati ad Allerta Meteo Emilia-Romagna
					per ricevere aggiornamenti sulle previsioni e la situazione di
					allerta nei tuoi luoghi preferiti.</p>
				<div class="my-3">
					<a href="<%=regURL%>" class="btn btn-secondary btn-lg">Registrati</a>
				</div>
			</div>
		</div>


	</div>
	<!-- / Login screen -->
</div>

</main>