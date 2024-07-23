<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="./init.jsp"%>


<%
long loginPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), 
		false, AllertaKeys.AllertaUserRegistration);

PortletURL loginUrl = PortletURLFactoryUtil.create(request, AllertaKeys.AllertaUserRegistration, 
		loginPlid, PortletRequest.RENDER_PHASE);



String completeUrl = request.getAttribute("CURRENT_COMPLETE_URL").toString().toLowerCase();
boolean sitoPrivato = !completeUrl.contains("allertameteo.");

%>

<li class="nav-item"><c:if test="<%=sitoPrivato %>"><a
	class="nav-link  header__personal-nav__toggle" href="/login?redirect=<%=themeDisplay.getURLCurrent()%>">
		<span class="icon i-sign-in" title="Area riservata"></span> <span
		class="d-none d-lg-inline-block d-print-inline-block ">Area riservata</span>
</a></c:if></li>


