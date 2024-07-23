<%@page import="allerta.catasto.search.CatastoSearchHelper"%>
<%@page import="allerta.catasto.search.CatastoDisplayTerms"%>
<%@page import="allerta.catasto.search.CatastoSearchContainer"%>
<%@page import="allerta.catasto.bean.CatastoBean"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp"%>

<%
CatastoBean bean = new CatastoBean(request);

boolean readonly = bean.isReadonly();

String eventi[] = { "Criticità idraulica", "Criticità idrogeologica", "Criticità per temporali", "Vento",
		"Temperature estreme", "Neve", "Pioggia che gela", "Stato del mare", "Criticità costiera" };

PortletURL portletURL = renderResponse.createRenderURL();
String portletURLString = portletURL.toString();

CatastoSearchContainer catastoSearchContainer = new CatastoSearchContainer(renderRequest, portletURL);
CatastoDisplayTerms displayTerms = (CatastoDisplayTerms)catastoSearchContainer.getDisplayTerms();

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

%>

<portlet:renderURL var="creaUrl">
				<portlet:param name="mvcRenderCommandName" value="/allertaer/catasto/compila"/>
				<portlet:param name="id" value="0"/>	
</portlet:renderURL>


<aui:form action="<%= portletURLString %>" method="post" name="smsService">

	
		<div class="row">

			
			<div class="col-md-3">
				<label class="control-label" for="datetimepicker1">Data evento da:</label>
				
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
				<label class="control-label" for="datetimepicker2">Data evento a:</label>
				
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
			
			<div class="col-md-2">
				<label class="control-label" for="categoriaFilter">Fenomeno:</label>
				<div class='input-group' id="comuneFilter">
				<aui:select label="" name="categoriaFilter" value="<%=displayTerms.getCategoriaFilter() %>">
					<aui:option value="0" label=" "></aui:option>
					<aui:option value="1" label="<%=eventi[0] %>"></aui:option>
					<aui:option value="2" label="<%=eventi[1] %>"></aui:option>
					<aui:option value="3" label="<%=eventi[2] %>"></aui:option>
					<aui:option value="4" label="<%=eventi[3] %>"></aui:option>
					<aui:option value="5" label="<%=eventi[4] %>"></aui:option>
					<aui:option value="6" label="<%=eventi[5] %>"></aui:option>
					<aui:option value="7" label="<%=eventi[6] %>"></aui:option>
					<aui:option value="8" label="<%=eventi[7] %>"></aui:option>
					<aui:option value="9" label="<%=eventi[8] %>"></aui:option>
				</aui:select>
				</div>
			</div>
			<div class="col-md-2">
				<label class="control-label" for="comuneFilter">Comune:</label>
				<div class='input-group' id="comuneFilter">
	                   <aui:input 
							type="text" 
							class="form-control" 
							name="comuneFilter"
							label=""
							value="<%=displayTerms.getComuneFilter() %>"
							/>
	              </div>
			</div>
			<div class="col-md-2">
				<label class="control-label" for="areaFilter">Area:</label>
								<div class='input-group' id="areaFilter">
	                   <aui:input 
							type="text" 
							class="form-control" 
							name="areaFilter"
							label=""
							value="<%=displayTerms.getAreaFilter() %>"
							/>
	              </div>
			</div>
		</div>
		<div class="row">
		
			<div class="col-md-2" style='text-align: center;margin-top: 25px;'>
				<button class="btn btn-primary"
					id='aggiorna'>
					Aggiorna
				</button>
			</div>
			
			<div class="col-md-2" style='text-align: center;margin-top: 25px;'>
				<button class="btn btn-primary" onclick="esportaExcel();return false;"
					id='aggiorna'>
					Esporta Excel
				</button>
			</div>
			
			<c:if test="<%=!readonly %>">
				<div class="col-md-2"  style='text-align: center;margin-top: 25px;'>
					<a href="<%=creaUrl %>"
						class="btn btn-primary"><i class="icon i-pencil"></i>Nuova segnalazione</a>
				</div>
			</c:if>
		
		</div> 
	
	</aui:form>	


<div class="row">
	<div class="col-12">
		<h2>Catasto segnalazioni</h2>
		<div class="row">
		</div>
			
	</div>

	<liferay-ui:search-container 
						searchContainer="<%= catastoSearchContainer %>" 
						total="<%=CatastoSearchHelper.getVerificheCount(displayTerms) %>"  >
					
					<liferay-ui:search-container-results 
						results="<%= CatastoSearchHelper.getVerifiche(displayTerms,catastoSearchContainer.getStart(), catastoSearchContainer.getEnd()) %>" 
				        />
				        
					  <liferay-ui:search-container-row className="allerta.catasto.model.Segnalazione" modelVar="ver" >
					  
						<liferay-ui:search-container-column-text property="id" name="ID" orderable="true" orderableProperty="id" />
						<liferay-ui:search-container-column-text name="Data evento" orderable="true" orderableProperty="dataEvento" >
						<%=(ver.getDataEvento()!=null?sdf2.format(ver.getDataEvento()):"") %>
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Fenomeno" orderable="true" orderableProperty="categoria">
						<%=(ver.getCategoria()>=1 && ver.getCategoria()<=9?eventi[((int)ver.getCategoria())-1]:"") %>
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Comune" property="comune" orderable="true" orderableProperty="comune" />
						<liferay-ui:search-container-column-text name="Area" property="area" orderable="true" orderableProperty="area"  />
					
					
						<liferay-ui:search-container-column-text name="Ultima modifica" orderable="true" orderableProperty="modifiedDate">
						<%=(ver.getModifiedDate()!=null?sdf.format(ver.getModifiedDate()):"") %>
						</liferay-ui:search-container-column-text>
					
						<liferay-ui:search-container-column-text name="Azioni" >
						<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>">
	
	
	<c:choose>
  		<c:when test="<%=!readonly %>">
	  		<portlet:renderURL var="compilaUrl">
				<portlet:param name="mvcRenderCommandName" value="/allertaer/catasto/compila"/>
				<portlet:param name="id" value="<%=String.valueOf(ver.getId()) %>"/>	
			</portlet:renderURL>
			
			<portlet:actionURL var="deleteUrl" name="/allertaer/catasto/delete">
				<portlet:param name="id" value="<%=String.valueOf(ver.getId()) %>"/>
			</portlet:actionURL>
		
			<liferay-ui:icon message="Modifica" url="<%= compilaUrl.toString() %>"/>
		
			<liferay-ui:icon message="Cancella" url="<%= deleteUrl.toString() %>"/>
				
  		</c:when>
  		
  	
  		<c:otherwise>
  		<portlet:renderURL var="consultaUrl">
				<portlet:param name="mvcRenderCommandName" value="/allertaer/catasto/compila"/>
				<portlet:param name="id" value="<%=String.valueOf(ver.getId()) %>"/>	
			</portlet:renderURL>
		
			<liferay-ui:icon message="Consulta" url="<%= consultaUrl.toString() %>"/>
		
  		</c:otherwise>
  	</c:choose>

	
</liferay-ui:icon-menu>
						</liferay-ui:search-container-column-text>

						
						
					</liferay-ui:search-container-row>
				
					<liferay-ui:search-iterator  paginate="<%= true %>"  />
					
				</liferay-ui:search-container>
				
		<script type="text/javascript">
			
			
			function esportaExcel(e) {
				var da = $('[name="_allerta_catasto_web_AllertaCatastoWebPortlet_dataInvioDa"]').val()
				var a = $('[name="_allerta_catasto_web_AllertaCatastoWebPortlet_dataInvioA"]').val()
				if (da && da.split(" ")[0]) da = da.split(" ")[0]
				if (a && a.split(" ")[0]) a = a.split(" ")[0]
				window.open('/o/report/catasto/excel?datada='+da+'&dataa='+a,'_blank')
			}
			
			
	
		</script>
	
</div>