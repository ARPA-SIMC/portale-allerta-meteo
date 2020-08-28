<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="it.eng.allertaer.allertebollettini.portlet.config.ReportPostEventoConfiguration"%>
	
<%@ include file="./init.jsp"%>
<%
ReportPostEventoConfiguration myConfiguration=
        				(ReportPostEventoConfiguration) renderRequest.getAttribute(ReportPostEventoConfiguration.class.getName());

String myConfigurationItem= StringPool.BLANK;
String defaultValue = "";

  if (Validator.isNotNull(myConfiguration)) {
      myConfigurationItem = portletPreferences.getValue("renderTypeItem", myConfiguration.renderTypeItem());
      defaultValue = myConfigurationItem != null ? myConfigurationItem : "no-item-selected";
  }
%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />


<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />
    <div class="portlet-configuration-body-content">
        <div class="container-fluid-1280">
            <div class="col-md-4">
	            <aui:fieldset>
	                <aui:select name="preferences--renderTypeItem--" label="Tipo Rendering">
					    <aui:option value="Home" selected="<%=defaultValue.equals("Home") %>">Home</aui:option>
					    <aui:option value="Interna" selected="<%=defaultValue.equals("Interna") %>">Interna</aui:option>
					    <aui:option value="Destra" selected="<%=defaultValue.equals("Destra") %>">Destra</aui:option>
					</aui:select>          
	            </aui:fieldset><br/>
            </div>
        </div>
    </div>

    <aui:button-row>
        <aui:button cssClass="btn-lg" type="submit" />
    </aui:button-row>
</aui:form>