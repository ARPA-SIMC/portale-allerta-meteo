<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.eng.sms.search.CittadiniHelper"%>
<%@page import="it.eng.sms.search.CittadiniDisplayTerms"%>
<%@page import="it.eng.sms.search.CittadiniSearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="./init.jsp" %>

<%

	PortletURL portletURL = renderResponse.createRenderURL();
	String portletURLString = portletURL.toString();
	
	CittadiniSearchContainer cittadiniSearchContainer = new CittadiniSearchContainer(renderRequest, portletURL);
	CittadiniDisplayTerms displayTerms = (CittadiniDisplayTerms)cittadiniSearchContainer.getDisplayTerms();
	
	
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



<aui:form action="<%= portletURLString %>" method="post" name="cittadiniService">

		<div class="row">
		

	
			<div class="col-md-2">
				<aui:input 
					name="comune" 
					label="Comune"
				/>
			</div>

			<div class="col-md-2">
				<aui:input 
					name="cognome"
					label="Cognome" 
				/>
			</div>
		
			<div class="col-md-2">
				<aui:input 
					name="nome" 
					label="Nome"
				/>
			</div>
			
			<div class="col-md-2">
				<aui:input 
					name="email" 
					label="Email"
				/>
			</div>
			
			<div class="col-md-2">
				<aui:input 
					name="tel" 
					label="Telefoni"
				/>
			</div>
			
						
		
			<div class="col-md-2" style='text-align: center;margin-top: 25px;'>
				<button
					id='aggiorna'>
					Aggiorna
				</button>
			</div>
		
	</div>
	
</aui:form>
	
	<div class="row" style="margin-top:50px;">
		<div class="col-md-12">
			<h2>Cittadini iscritti al portale</h2>
		</div>
	</div>
	
	
	<div class="row">
	
		<div class="col-md-12">
			<a href='javascript:exportAsExcel();'>Scarica in formato Excel</a>
		</div>
	
		<div class="col-md-12 cittadini-results" >
	
			<liferay-ui:search-container 
					delta="15"
					searchContainer="<%= cittadiniSearchContainer %>" 
					total="<%=CittadiniHelper.getTotalCittadiniCount(displayTerms) %>"  >
				
				<liferay-ui:search-container-results 
					results="<%= CittadiniHelper.getCittadini(displayTerms,cittadiniSearchContainer.getStart(), cittadiniSearchContainer.getEnd()) %>" 
			        />
			        
				 <liferay-ui:search-container-row className="it.eng.sms.bean.Cittadini" modelVar="cittadini" >
				 
				 	<liferay-ui:search-container-column-text property="comune" name="Comune"/>
					<liferay-ui:search-container-column-text property="cognome" name="Cognome" />
					<liferay-ui:search-container-column-text property="nome" name="Nome"/>
					<liferay-ui:search-container-column-text property="email" name="Email"/>
					<liferay-ui:search-container-column-text property="telefoni" name="Telefoni"/>
										
				</liferay-ui:search-container-row>
			
				<liferay-ui:search-iterator  paginate="<%= true %>"  />
				
			</liferay-ui:search-container>
		</div>
	</div>

	
	


<liferay-portlet:resourceURL var="cittadiniExport">
</liferay-portlet:resourceURL>

<script>

function exportAsExcel() {
	
	var url = '<%=cittadiniExport%>';
	url += '&<portlet:namespace />source=cittadini';
	
	console.log( 'exportAsExcel clicked', url);
	
	 $('#<portlet:namespace/>cittadiniService')[0].action = url;
	 $('#<portlet:namespace/>cittadiniService')[0].submit();
}



</script>

<script>

	
	$(document).ready( function(){
		
		$('#aggiorna').click(function() {
			
			 var url = '<%=portletURLString%>';
			 
			 console.log( 'aggiorna clicked', url);
			  
			  $('#<portlet:namespace/>cittadiniService')[0].action = url;
			  $('#<portlet:namespace/>cittadiniService')[0].submit();
		});
				

		

		
		
	});
</script>

