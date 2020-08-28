<%@ include file="./init.jsp" %>

<%
	AnimazioneBean animBean = (AnimazioneBean) renderRequest.getAttribute("AnimazioneBean");
	String animType = (String) renderRequest.getAttribute("AnimType");
%>

<main class="page main page--previsioni" id="main-content">

	<div class="page__head">
                
        <div class="container d-flex">
            <div class="row w-100 justify-content-between">
                <h1 class="col-12 col-lg-12" >Animazione meteo</h1>
                
                <p class="col-12 lead">
                    
                </p>
            </div>

            
        </div>
        <div class="breadcrumb-container">
            <div class="container d-flex">
                <nav class="row" aria-label="Hai percorso">
                    <ol class="breadcrumb">
        
                       <li class="breadcrumb-item">
                           <a href="/">Home</a>
                       </li>
       
                       <li class="breadcrumb-item active" aria-current="page">Animazione meteo</li>
        
                    </ol>
                </nav>
            </div>
        </div>
   </div>
   
   
   <div class="container page__body">
		<div class="row"> 
        	<div class="col-12 page__content" id="page-content">

				<p>
					Previsioni di precipitazione, copertura nuvolosa, velocità e direzione del vento in Emilia-Romagna e nel nord Italia, fino a 72 e
					con dettaglio ogni 3 ore, realizzate in modo completamente automatico utilizzando il modello meteorologico numerico ad area limitata 
					<a href="http://www.arpa.emr.it/dettaglio_generale.asp?id=2584&amp;idlivello=32">Cosmo-Lami</a>, realizzato in consorzio tra 
					<a href="http://www.protezionecivile.it/"></a> 
					<a href="http://www.protezionecivile.it/">Dipartimento protezione civile nazionale</a>, 
					<a href="http://www.aeronautica.difesa.it/">USAM Aeronautica Militare</a>, 
					<a href="http://www.arpa.piemonte.it/ ">Arpa Piemonte</a>, Arpa Emilia-Romagna.
					<br/><br/>
					Selezionare il tipo di fenomeno da visualizzare
				</p>
				
				<portlet:renderURL var="precipitazioniUrl">
					<portlet:param name="name" value="preci" />
					<portlet:param name="mvcPath" value="/previsioni.jsp"/>
				</portlet:renderURL>
				
				<portlet:renderURL var="nuovoleUrl">
					<portlet:param name="name" value="nuv" />
					<portlet:param name="mvcPath" value="/previsioni.jsp"/>
				</portlet:renderURL>
				
				<portlet:renderURL var="ventoUrl">
					<portlet:param name="name" value="wind" />
					<portlet:param name="mvcPath" value="/previsioni.jsp"/>
				</portlet:renderURL>
				
				<div class="row py-4">
				
					<div class="col-12 col-lg-4 pb-4 d-flex flex-column align-items-center">
						<a href="<%=precipitazioniUrl%>">
							<span>Previsione di precipitazione cumulate su 3 ore</span>
							<br/>
							<img src="data:image/png;base64,<%=animBean.retrieveImgHome("preciHome") %>" />
						</a>
					</div>
					
					<div class="col-12 col-lg-4 pb-4 d-flex flex-column align-items-center">
						<a href="<%=nuovoleUrl%>">
							<span>Previsione di copertura nuvolosa ogni 3 ore</span>
							<br/>
							<img src="data:image/png;base64,<%=animBean.retrieveImgHome("nuvHome") %>" />
						</a>
					</div>
					
					<div class="col-12 col-lg-4 pb-4 d-flex flex-column align-items-center">
						<a href="<%=ventoUrl%>">
							<span>Previsione del vento ogni 3 ore</span>
							<br/>
							<img src="data:image/png;base64,<%=animBean.retrieveImgHome("windHome") %>" />
						</a>
					</div>
				
				</div>
				
			</div>
			
		</div>
		
	</div>
	
</main>