<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@ include file="./init.jsp"%>

<portlet:actionURL name="/allerta/user-login" var="loginURL">
	<portlet:param name="redirectTo" value="LAST_PATH" />
	<portlet:param name="fillBean" value="true" />
</portlet:actionURL>

<%
Role cittadino = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "CITTADINO");
Role sindaco = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "SINDACO");
%>

<div class="pt-2">

<%if ( themeDisplay.isSignedIn()) {
	
	if( RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), cittadino.getRoleId()) ) {%>
	
	 <liferay-util:include page="/part/link-statici-idro.jsp" />
	 <liferay-util:include page="/part/link-statici-cittadino.jsp" />

  <%} else if( RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), sindaco.getRoleId()) ) {
	  
	  
	  %>
	  
	  <liferay-util:include page="/sindaco.jsp" portletId="<%=AllertaKeys.AllertaStrumentiSindacoPortlet%>" ></liferay-util:include>
	 
<%  } 
	 
} else { %>

	<h2>Accedi agli strumenti riservati</h2>
	<div class="row">
		<aui:form action="<%=loginURL%>" method="post" name="fm1"
					cssClass="u-section--gray u-section--rounded-corners p-3 p-lg-4">

			<h2 class="sr-only">Inserisci username e password per accedere</h2>
			<div class="form-group">
				<div class="row">

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

			</div>

			<div class="form-group">
				<div class="row">

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
						<small class="help-block" id="idPasswordMessage" role="alert">
							<a href="./register-password-screen.php"
							title="Recupera la password">Ha dimenticato la password?</a>
						</small>
					</div>


				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-12">
						<aui:button type="submit" value="Accedi"
									cssClass="btn btn-secondarylg"></aui:button>
					</div>
				</div>
			</div>

		</aui:form>
	</div>
</div>

<%}%>