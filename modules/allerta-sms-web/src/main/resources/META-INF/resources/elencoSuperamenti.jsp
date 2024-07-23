<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.eng.sms.search.SuperamentiHelper"%>
<%@page import="it.eng.sms.search.SuperamentiDisplayTerms"%>
<%@page import="it.eng.sms.search.SuperamentiSearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="./init.jsp" %>

<%

	PortletURL portletURL = renderResponse.createRenderURL();
	String portletURLString = portletURL.toString();
	
	SuperamentiSearchContainer superamentiSearchContainer = new SuperamentiSearchContainer(renderRequest, portletURL);
	SuperamentiDisplayTerms displayTerms = (SuperamentiDisplayTerms)superamentiSearchContainer.getDisplayTerms();
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
%>

<style>
td, th { padding: 5px !important; font-size: 90% !important}
	
	.tooltip2 {
    	position: relative;
    	display: inline-block;
    	border-bottom: 1px dotted black;
	}
	
	.tooltip2 .tooltiptext {
	    visibility: hidden;
	    width: 240px;
	    background-color: #555;
	    color: #fff;
	    text-align: center;
	    border-radius: 6px;
	    padding: 5px 0;
	    position: absolute;
	    z-index: 1;
	    bottom: 125%;
	    left: 50%;
	    margin-left: -120px;
	    opacity: 0;
	    transition: opacity 0.3s;
	}
	
	.tooltip2:hover .tooltiptext {
	    visibility: visible;
	    opacity: 1;
	}
	
	.lfr-search-container {
		overflow:unset;
	}
</style>

<div class="container">



<aui:form action="<%= portletURLString %>" method="post" name="superamentiService">

		<div class="row">

			<div class="col-md-3">
		
				<aui:select name="tipo">
					<aui:option value=""> </aui:option>
					<aui:option value="idro">Solo idro</aui:option>
					<aui:option value="pluvio">Solo pluvio</aui:option>
				</aui:select>
			</div>
			
			<div class="col-md-2">
		
				<aui:select name="soglia">
					<aui:option value=""> </aui:option>
					<aui:option value="1">1</aui:option>
					<aui:option value="2">2</aui:option>
					<aui:option value="3">3</aui:option>
				</aui:select>
			</div>
		
			<div class="col-md-3">
				<label class="control-label" for="datetimepicker1">Data da:</label>
				
				<div class='input-group date' id="datetimepicker1">
	                   <aui:input 
							type="text" 
							class="form-control" 
							name="dataDa"
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
				<label class="control-label" for="datetimepicker2">Data a:</label>
				
				<div class='input-group date' id="datetimepicker2">
	                   <aui:input 
							type="text" 
							class="form-control" 
							name="dataA"
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
		
			
			
		
	</div>
	
	<div class="row">
	
			<div class="col-md-3">
				<aui:input 
					name="stazione" 
				/>
			</div>

			<div class="col-md-2">
				<aui:input 
					name="provincia" 
				/>
			</div>
		
			<div class="col-md-3">
				<aui:input 
					name="comune" 
				/>
			</div>
			
			<div class="col-md-2">
				<aui:input 
					name="bacino" 
				/>
			</div>
			
			<div class="col-md-2">
				<aui:input 
					name="zona" 
				/>
			</div>
		
	</div>
	<div class="row">
	<div class="col-md-3" style='text-align: center;margin-top: 25px;'>
				<button
					id='aggiorna'>
					Aggiorna
				</button>
			</div>
	</div>
	
</aui:form>
	
	<div class="row" style="margin-top:50px;">
		<div class="col-md-12">
			<h2>Superamenti</h2>
		</div>
	</div>
	
	
	<div class="row">
	
		<div class="col-md-12">
			<a href='javascript:exportAsExcel();'>Scarica in formato Excel</a>
		</div>
	
		<div class="col-md-12 superamenti-results" >
	
			<liferay-ui:search-container 
					delta="15"
					searchContainer="<%= superamentiSearchContainer %>" 
					total="<%=SuperamentiHelper.getTotalSuperamentiCount(displayTerms) %>"  >
				
				<liferay-ui:search-container-results 
					results="<%= SuperamentiHelper.getSuperamenti(displayTerms,superamentiSearchContainer.getStart(), superamentiSearchContainer.getEnd()) %>" 
			        />
			        
				 <liferay-ui:search-container-row className="it.eng.sms.bean.Superamenti" modelVar="superamenti" >
				 
					 <%
				         String dat = superamenti.getCreatedate() != null ? sdf.format(superamenti.getCreatedate()) : "";
						String liv = "";
						String sog = ""+superamenti.getSogliaregola();
						if (superamenti.getTipo().equals("idro")) {
							liv = ""+superamenti.getSoglia();
							sog+=" m";
						} else {
							if (superamenti.getSoglia()==1) liv = "30 mm/h";
							else liv = "70 mm/3h";
							sog+=" mm";
						}
						sog = sog.replace(".",",");
				    
			         %>
				 
					<liferay-ui:search-container-column-text property="tipo" name="Tipo" />
					<liferay-ui:search-container-column-text value="<%= dat %>" name="Data e ora locale"/>
					<liferay-ui:search-container-column-text property="name" name="Stazione"/>
					<liferay-ui:search-container-column-text property="bacino" name="Bacino"/>
					<liferay-ui:search-container-column-text property="provincia" name="Provincia"/>
					<liferay-ui:search-container-column-text property="comune" name="Comune"/>
					<liferay-ui:search-container-column-text property="zona" name="Zona"/>
					<liferay-ui:search-container-column-text property="soglia" name="Soglia"/>
					<liferay-ui:search-container-column-text property="livello" name="Livello rilevato"/>
					<liferay-ui:search-container-column-text value="<%= sog %>" name="Livello soglia"/>
					
				</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator  paginate="<%= true %>"  />
				
			</liferay-ui:search-container>
		</div>
	</div>

	<div class="row" style="display:none;">
	
		<div class="col-md-3"> 
			Da
			<input
				type="text" 
				class="form-control" 
				name="<portlet:namespace/>invioDa"
				/>
		</div>
		
		<div class="col-md-3"> 
			A
			<input
				type="text" 
				class="form-control" 
				name="<portlet:namespace/>invioA"
				/>
		</div>
		
		<div class="col-md-6"> 
			Testo
			<input
				type="text" 
				class="form-control" 
				name="<portlet:namespace/>testo"
				/>
		</div>
	</div>
	


<liferay-portlet:resourceURL var="superamentiExport">
</liferay-portlet:resourceURL>

<script>

function exportAsExcel() {
	
	var url = '<%=superamentiExport%>';
	//url += '&<portlet:namespace />tipo=' + $('#<portlet:namespace />tipo').val();
	//url += '&<portlet:namespace />sottotipo=' + $('#<portlet:namespace />sottotipo').val();
	//url += '&<portlet:namespace />nome=' + $('#<portlet:namespace />nome').val();
	//url += '&<portlet:namespace />numero=' + $('#<portlet:namespace />numero').val();
	//url += '&<portlet:namespace />stato=' + $('#<portlet:namespace />stato').val();
	//url += '&<portlet:namespace />dataInvioDa=' + $('#<portlet:namespace />dataInvioDa').val();
	//url += '&<portlet:namespace />dataInvioA=' + $('#<portlet:namespace />dataInvioA').val();
	url += '&<portlet:namespace />source=superamenti';
	
	console.log( 'exportAsExcel clicked', url);
	
	 $('#<portlet:namespace/>superamentiService')[0].action = url;
	 $('#<portlet:namespace/>superamentiService')[0].submit();
}



</script>

<script>

	
	$(document).ready( function(){
		
		$('#aggiorna').click(function() {
			
			 var url = '<%=portletURLString%>';
			 
			 console.log( 'aggiorna clicked', url);
			  
			  $('#<portlet:namespace/>superamentiService')[0].action = url;
			  $('#<portlet:namespace/>superamentiService')[0].submit();
		});
				

		

		
		
	});
</script>

