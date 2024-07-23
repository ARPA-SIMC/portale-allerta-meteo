<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.captcha.Captcha"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="./init.jsp"%>
<%@taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>

<%
	HttpServletRequest loginRequest = 
				PortalUtil.getOriginalServletRequest(
						PortalUtil.getHttpServletRequest(renderRequest));

%>

<portlet:actionURL name="/allerta/reset-password" var="resetURL">
	<portlet:param name="redirect" value="<%=loginRequest.getParameter("redirect") %>"/>
</portlet:actionURL>

<portlet:renderURL var="regURL">
	<portlet:param name="mvcRenderCommandName" value="/allerta/user-reg"/>
</portlet:renderURL>

<portlet:resourceURL var="captchaURL">	
</portlet:resourceURL>

<main class="page main page--login" id="main-content">

<div class="container d-flex pt-5">
	<div class="row w-100 justify-content-between">
		<h1 class="col-12 col-lg-8">Password Scaduta o Dimenticata</h1>

		<p class="col-12 lead"></p>
	</div>
</div>

<div class="container d-flex">
	<!-- Login screen -->
	<div class="u-content-container py-md-4">
		<div class="row flex-md-row-reverse">
			<div class="col-12 col-md-12">
			
			<liferay-ui:error exception="<%=CaptchaTextException.class %>"
				message="Captcha Errato"></liferay-ui:error>
				<aui:form action="<%=resetURL%>" method="post" name="fm1"
					cssClass="u-section--gray u-section--rounded-corners p-3 p-lg-4">
					
					<div class="form-group">
						<div class="row">
							

							<!-- input -->
							<div class="col-12 col-md-9">
								<aui:input 
									name="screenName" 
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
							
							
                				<liferay-captcha:captcha url="<%=captchaURL %>"></liferay-captcha:captcha>
						
							</div>
							

						</div>
						<!-- /.row -->
					</div>
					<!-- /.form-group  -->
					<div class="form-group">
						<div class="row">
							<div class="col-12">
								<aui:button type="submit" value="Invia Nuova Password"
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