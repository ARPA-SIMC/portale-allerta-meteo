<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="allerta.verifica.web.bean.VerificaSearchHelper"%>
<%@page import="allerta.verifica.web.bean.VerificaDisplayTerms"%>
<%@page import="allerta.verifica.web.bean.VerificaSearchContainer"%>
<%@page import="allerta.verifica.web.bean.VerificaAllertaBean"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp"%>

<%
VerificaAllertaBean bean = new VerificaAllertaBean(request);

PortletURL portletURL = renderResponse.createRenderURL();
String portletURLString = portletURL.toString();

VerificaSearchContainer verificaSearchContainer = new VerificaSearchContainer(renderRequest, portletURL);
VerificaDisplayTerms displayTerms = (VerificaDisplayTerms)verificaSearchContainer.getDisplayTerms();

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

User u = PortalUtil.getUser(request);
long[] rol = u.getRoleIds();
boolean modifica = false;
int k;
if (rol!=null) {
	for (k=0; k<rol.length; k++)
		if (rol[k]==1993255 || rol[k]==20161 || rol[k]==168321) modifica=true;
}

%>

<aui:form action="<%= portletURLString %>" method="post" name="smsService">

	
		<div class="row">

			
			<div class="col-md-3">
				<label class="control-label" for="datetimepicker1">Da:</label>
				
				<div class='input-group date' id="datetimepicker1">
	                   <aui:input 
							type="text" 
							class="form-control" 
							name="dataInvioDa"
							label=""
							placeholder="gg/mm/aaaa" />
	                   <span class="input-group-addon">
	                       <i class="far fa-calendar-minus"></i>
	                   </span>
	               </div>
	               
	               <script type="text/javascript">
		            $(function () {
		                $('#datetimepicker1').datetimepicker({
		                	format: 'DD/MM/YYYY',
		                	 icons: {
		                		 time: "far fa-clock",
		                         date: "far fa-calendar-minus",
		                         up: "fa fa-arrow-up",
		                         down: "fa fa-arrow-down"
		                     }
		                });
		            });
		        </script>
			</div>
			
			<div class="col-md-3">
				<label class="control-label" for="datetimepicker2">A:</label>
				
				<div class='input-group date' id="datetimepicker2">
	                   <aui:input 
							type="text" 
							class="form-control" 
							name="dataInvioA"
							label=""
							placeholder="gg/mm/aaaa" />
	                   <span class="input-group-addon">
	                       <i class="far fa-calendar-minus"></i>
	                   </span>
	               </div>
	               
	               <script type="text/javascript">
		            $(function () {
		                $('#datetimepicker2').datetimepicker({
		                	format: 'DD/MM/YYYY',
		                	 icons: {
		                		 time: "far fa-clock",
		                         date: "far fa-calendar-minus",
		                         up: "fa fa-arrow-up",
		                         down: "fa fa-arrow-down"
		                     }
		                });
		            });
		        </script>
			</div>
		
			<div class="col-md-3" style='text-align: center;margin-top: 25px;'>
				<button class="btn btn-primary"
					id='aggiorna'>
					Aggiorna
				</button>
			</div>
			
			<div class="col-md-3" style='text-align: center;margin-top: 25px;'>
				<button class="btn btn-primary" onclick="esportaExcel();return false;"
					id='aggiorna'>
					Esporta Excel
				</button>
			</div>
		
		</div>
	
	</aui:form>	


<div class="row">
	<div class="col-12">
		<h2>Elenco verifiche allerte</h2>
		<div class="row">
		</div>
			
	</div>

	<liferay-ui:search-container 
						searchContainer="<%= verificaSearchContainer %>" 
						total="<%=VerificaSearchHelper.getVerificheCount(displayTerms) %>"  >
					
					<liferay-ui:search-container-results 
						results="<%= VerificaSearchHelper.getVerifiche(displayTerms,verificaSearchContainer.getStart(), verificaSearchContainer.getEnd()) %>" 
				        />
				        
					  <liferay-ui:search-container-row className="allerta.verifica.model.Verifica" modelVar="ver" >
					  
						<liferay-ui:search-container-column-text property="titolo" name="Documento" />
						<liferay-ui:search-container-column-text name="Valido da" >
						<%=(ver.getDataInizio()!=null?sdf.format(ver.getDataInizio()):"") %>
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Stato">
						<%=(ver.getStato()==0?"In compilazione":(ver.getStato()==1?"Consolidato":"")) %>
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Ultima modifica">
						<%=(ver.getModifiedDate()!=null && ver.getModifiedDate().after(ver.getCreateDate())?sdf.format(ver.getModifiedDate()):"") %>
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Azioni" >
						<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>">
	
	
	<c:choose>
	

	
  		<c:when test="<%= ver.getStato()==0 && modifica %>">

			
				<portlet:renderURL var="compilaUrl">
				<portlet:param name="mvcRenderCommandName" value="/allertaer/verifica/compila"/>
				<portlet:param name="id" value="<%=String.valueOf(ver.getId()) %>"/>	
			</portlet:renderURL>
			<liferay-ui:icon message="Modifica" url="<%= compilaUrl.toString() %>"/>
		
			<portlet:actionURL var="bloccaUrl" name="/allertaer/verifica/consolida">
				<portlet:param name="id" value="<%=String.valueOf(ver.getId()) %>"/>	
			</portlet:actionURL>
			<liferay-ui:icon message="Consolida" url="<%= bloccaUrl.toString() %>"/>
			
  		</c:when>
  		
  	
  		<c:otherwise>
  		
  				<portlet:renderURL var="compilaUrl">
				<portlet:param name="mvcRenderCommandName" value="/allertaer/verifica/compila"/>
				<portlet:param name="id" value="<%=String.valueOf(ver.getId()) %>"/>	
			</portlet:renderURL>

			<liferay-ui:icon message="Consulta" url="<%= compilaUrl.toString() %>"/>
  		
  			<c:when test="<%= modifica %>">
  				<portlet:actionURL var="sbloccaUrl" name="/allertaer/verifica/sblocca">
					<portlet:param name="id" value="<%=String.valueOf(ver.getId()) %>"/>	
				</portlet:actionURL>
				<liferay-ui:icon message="Sblocca" url="<%= sbloccaUrl.toString() %>"/>
			</c:when>
  		
  		</c:otherwise>
  	</c:choose>

	
</liferay-ui:icon-menu>
						</liferay-ui:search-container-column-text>

						
						
					</liferay-ui:search-container-row>
				
					<liferay-ui:search-iterator  paginate="<%= true %>"  />
					
				</liferay-ui:search-container>
				
				<script type="text/javascript">
			
			
			function esportaExcel(e) {
				var da = $('[name="_allerta_verifica_web_AllertaVerificaWebPortlet_dataInvioDa"]').val()
				var a = $('[name="_allerta_verifica_web_AllertaVerificaWebPortlet_dataInvioA"]').val()
				da = da.split(" ")[0]
				a = a.split(" ")[0]
				window.open('/o/report/verifica/excel?datada='+da+'&dataa='+a,'_blank')
			}
			
			
	
		</script>
	
</div>