<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.exception.ContactBirthdayException"%>
<%@page import="com.liferay.portal.kernel.exception.PhoneNumberException"%>
<%@page import="com.liferay.portal.kernel.exception.UserEmailAddressException"%>
<%@page import="it.eng.allerta.utils.AllertaTracker"%>
<%@page import="it.eng.allerta.configuration.AllertaBaseConfiguration"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="init.jsp"%>
<%@taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>

<%
String portalUrl = PortalUtil.getPortalURL(request);

AllertaBaseConfiguration allertaConfig = AllertaTracker.getAllertaBaseConfiguration(themeDisplay.getCompanyId()); 

%>
<portlet:actionURL name="/allerta/user-save" var="saveURL">
</portlet:actionURL>


<portlet:resourceURL var="captchaURL">	
</portlet:resourceURL>

<main class="page main page--login" id="main-content">

<div class="container pt-5">
	<div class="row w-100 justify-content-between">
		<h1 class="col-12 col-lg-8">Registrati</h1>

		<p class="col-12 lead"></p>
	</div>
</div>

<div class="container">
	<!-- Login screen -->
	<div class="u-content-container py-md-4">
		<div class="row flex-md-row-reverse">
			<div class="col-12 col-md-12">
				
				<liferay-ui:error exception="<%=CaptchaTextException.class %>"
					message="Captcha Errato"></liferay-ui:error>
				
				<liferay-ui:error exception="<%=UserEmailAddressException.MustNotBeDuplicate.class %>"
					message="Indirizzo email già in uso"></liferay-ui:error>

				<liferay-ui:error exception="<%=PhoneNumberException.class %>"
					message="Numero di telefono errato"></liferay-ui:error>

				<liferay-ui:error exception="<%=ContactBirthdayException.class %>"
					message="Data di nascita non valida"></liferay-ui:error>

				<aui:form action="<%=saveURL%>" method="post" name="fm1"
					cssClass="u-section--gray u-section--rounded-corners p-3 p-lg-4">
					<div class="form-group">
						<div class="row">
					
							<!-- input -->
							<div class="col-12 col-md-6">
								<aui:input 
									name="email" 
									type="text"
									class="form-control" 
									placeholder="Inserire un indirizzo Email"
									value="">
									<aui:validator name="required"></aui:validator>
								</aui:input>
								
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="row">
					
							<!-- input -->
							<div class="col-12 col-md-6">
								<aui:input 
									name="username" 
									type="text"
									class="form-control" 
									placeholder="Inserire un nome utente"
									label="Username"
									value="">
									<aui:validator name="required"></aui:validator>
								</aui:input>
								
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="row">
					
							<!-- input -->
							<div class="col-12 col-md-6">
								<aui:input 
									name="telefono" 
									type="text"
									class="form-control" 
									placeholder="Inserire un numero di telefono"
									label="Telefono"
									value="">
								</aui:input>
								
							</div>
							<div class="col-12 col-md-6 mt-5">
								<i class="icon i-info-circle"></i> Inserisci un numero di telefono senza prefisso internazionale
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="row">
					
							<!-- input -->
							<div class="col-12 col-md-6">
								<aui:input 
									name="nome" 
									type="text"
									class="form-control" 
									placeholder="Inserire un nome"
									label="Nome"
									value="">
									<aui:validator name="required"></aui:validator>
								</aui:input>
								
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="row">
					
							<!-- input -->
							<div class="col-12 col-md-6">
								<aui:input 
									name="cognome" 
									type="text"
									class="form-control" 
									placeholder="Inserire un cognome"
									label="Cognome"
									value="">
									<aui:validator name="required"></aui:validator>
								</aui:input>
								
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="row">
					
							<!-- input -->
							<div class="col-12 col-md-6">
								<aui:input 
									name="dataNascita" 
									type="date"
									class="form-control" 
									placeholder=""
									label="Data di Nascita"
									value="">
									<aui:validator name="required"></aui:validator>
								</aui:input>
								
							</div>
							<div class="col-12 col-md-6 mt-5">
								<i class="icon i-info-circle"></i> 
								Devi essere maggiorenne per poterti registrare, inserisci la data nel formato (gg/mm/aaaa)
								 es. 19/10/1975.
							</div>	
						</div>
					</div>
					
						
					<div class="form-group">
						<div class="row">
							<div class="col-12 col-md-6">
							
								<liferay-captcha:captcha url="<%=captchaURL %>"></liferay-captcha:captcha>
						
					
			<%-- <script type="text/javascript">
     			function verifyCaptcha(response) {
     				$("#<portlet:namespace/>g-response").val(response);     				
      			};
    		</script>
			 <script src="https://www.google.com/recaptcha/api.js" async defer></script>
								
			 <div class="g-recaptcha" data-sitekey="<%=allertaConfig.reCaptchaKey()%>"
			 	data-callback="verifyCaptcha"></div>
			<aui:input 
				name="g-response" 
				type="hidden">
				<aui:validator name="required"></aui:validator>
			</aui:input> --%>
							
  
  							</div>
  						</div>
  					</div>
  
					
					<div class="form-group">
						<div class="row">
					
							<!-- input -->
							<div class="col-12 col-md-6">
								
								<aui:input 
									name="privacy" 
									type="checkbox"
									class="form-control" 
									placeholder=""
									label="Informativa sulla privacy">
									<aui:validator name="required"></aui:validator>
								</aui:input>
								
							</div>
							<div class="col-12 col-md-6">
								<p>
								Ho letto e accettato
								<a href="<%=portalUrl%>/informativa" target="_blank">Informativa sulla privacy</a> e
								<a href="<%=portalUrl%>/cookie" target="_blank">Utilizzo dei Cookie</a>
								</p>
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<div class="row">
							<div class="col-12">
								<aui:button type="submit" value="Registrati"
									cssClass="btn btn-primary btn-lg"></aui:button>
							</div>
						</div>
					</div>

				</aui:form>
			</div>
			
		</div>


	</div>
	<!-- / Login screen -->
</div>

</main>