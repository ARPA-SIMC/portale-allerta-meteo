<%@ include file="../init.jsp"%>
<%
	MapModelBean mapModelBean = (MapModelBean) renderRequest.getAttribute("MapModelBean");
%>
	

<!-- Solo se si è sulla pagina del singolo comune -->
 <div class="map-component__panel__situation" id="mcps--oggi">
     <div class="pb-2">
         <h3><liferay-ui:message key="allertaprevisioniweb_comune9" /> <%=mapModelBean.getSiteName() %></h3>
         <div class="map-component__panel__area-allertamento"></div>
         <div class="map-component__panel__situation__phenomena"></div>
     </div>

     <div id="mcps__accordion--oggi" class="map-component__panel__situation__accordion" >
         <h3>
             <a data-toggle="collapse" href="#mcps-info--oggi" aria-expanded="true" aria-controls="mcps-info--oggi">
                 <span class="icon i-plus-square-o u-collapsible-icon--expand" title="<liferay-ui:message key="allertaprevisioniweb_espandi" />"></span>
                 <span class="icon i-minus-square-o u-collapsible-icon--collapse" title="<liferay-ui:message key="allertaprevisioniweb_chiudi" />"></span>
                 <liferay-ui:message key="allertaprevisioniweb_iep" />
             </a>
         </h3>
         <ul id="mcps-info--oggi" class="map-component__panel__situation__info nav collapse show" data-parent="#mcps__accordion--oggi"></ul>
         <h3>
             <a  data-toggle="collapse" href="#mcps-risk--oggi" aria-expanded="true" aria-controls="mcps-risk--oggi" >
                 <span class="icon i-plus-square-o u-collapsible-icon--expand" title="<liferay-ui:message key="allertaprevisioniweb_espandi" />"></span>
                 <span class="icon i-minus-square-o u-collapsible-icon--collapse" title="<liferay-ui:message key="allertaprevisioniweb_chiudi" />"></span>
                 <liferay-ui:message key="allertaprevisioniweb_scenari" />
             </a>
         </h3>
         <ul id="mcps-risk--oggi" class="map-component__panel__situation__risk nav collapse show" data-parent="#mcps__accordion--oggi"></ul>
     </div>
 </div>
 <!-- / Solo se si è sulla pagina del singolo comune -->