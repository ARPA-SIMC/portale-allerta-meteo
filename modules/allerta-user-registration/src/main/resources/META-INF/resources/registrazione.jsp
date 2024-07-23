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


</main>