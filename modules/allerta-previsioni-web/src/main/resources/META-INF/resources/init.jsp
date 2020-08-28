<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@page import="it.eng.allerta.previsioni.bean.MapModelBean"%>

<%@page import="it.eng.allerta.previsioni.bean.GestioneBean"%>
<%@page import="it.eng.allerta.previsioni.bean.Giorno"%>
<%@page import="it.eng.allerta.previsioni.bean.Previsioni"%>