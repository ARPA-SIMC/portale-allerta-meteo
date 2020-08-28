<%@ include file="../init.jsp" %>

<%
String monitoraggioStatus = (String)request.getAttribute("monitoraggioStatus");

%>
<portlet:actionURL var="salvaURL" name="/allertaer/gestione-monitoraggio/salva">
	<portlet:param name="redirect" value=""/>		
</portlet:actionURL>

<main class="page main" id="main-content">

	<div class="container page__body" >

		<aui:form method="post" name="fmStazioni" action="<%= salvaURL.toString()%>">
		
		
			<div class="row">
			
				<div class="col-12">
				
					<h1>Gestione mappa di monitoraggio</h1>
					
					<br/>
					
					<p>
						<i class="fa fa-info-circle"></i> 
						Questa impostazione render&agrave; visibile o nascosta la scheda che contiene la mappa
						di monitoraggio accessibile dall'utente (cio&egrave; quella con Radar, Idrometri e Pluviometri) in tutti i punti del
						portale dov'&egrave; visualizzata, ovvero:
					</p>
					<ul class="standard-list">
						<li>Home page</li>
						<li>Pagine dei singoli comuni</li>
						<li>Sezione Monitoraggio Eventi</li>
					</ul>
					<br/>
					<h2 style="font-size: 1.25em !important; font-weight: bold;">
						Cambia la visibilit&agrave; della mappa di monitoraggio
					</h2>
					
					<div>
						<input
							type="radio"
							id="monitoraggioAcceso"
							name="<portlet:namespace/>monitoraggioAttivo"
							value="true"
							/> Rendi visibile la mappa di monitoraggio
							<br/>
						<input
							type="radio"
							id="monitoraggioSpento"
							name="<portlet:namespace/>monitoraggioAttivo"
							value="false"
							/> Nascondi la mappa di monitoraggio
					
					</div>
					
					<br/>
					
					<button 
						type="submit" 
						class="btn btn-primary">Salva Impostazioni
					</button>
													
				</div>
			</div>
			
			<script type="text/javascript">
			
			(function($) {
				   
				var status = '<%=monitoraggioStatus%>';
				
				console.log('status', status);
				
				if( status == 'true')
					$('#monitoraggioAcceso').attr('checked', 'checked');
				else
					$('#monitoraggioSpento').attr('checked', 'checked');
			
			})(jQuery);	
			
			</script>
		
		</aui:form>
		
	</div>
	
</main>