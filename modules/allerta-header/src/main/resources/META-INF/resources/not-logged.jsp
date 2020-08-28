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
%>

<li class="nav-item"><a
	class="nav-link  header__personal-nav__toggle" href="/login?redirect=<%=themeDisplay.getURLCurrent()%>">
		<span class="icon i-sign-in" title="Accedi"></span> <span
		class="d-none d-lg-inline-block d-print-inline-block ">Accedi</span>
</a></li>


