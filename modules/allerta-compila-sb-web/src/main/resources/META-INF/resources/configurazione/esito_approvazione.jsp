<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="it.eng.allerta.utils.AllertaKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ include file="../init.jsp" %>

<%

	HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));

	String cmd = httpReq.getParameter("cmd");
	
	String status = httpReq.getParameter("status");
	if (status==null) status = "ok";

	
	String testo = "ko".equals(status)?("Si è verificato un problema durante l'operazione."):("Operazione completata con successo");
%>

<main class="page main" id="main-content">

	<div class="container page__body" >
		<div class="esito-approvazione esito-approvazione-<%=cmd%> esito-approvazione-<%=status%>">
			<%=testo %>
		</div>
	</div>
	
</main>