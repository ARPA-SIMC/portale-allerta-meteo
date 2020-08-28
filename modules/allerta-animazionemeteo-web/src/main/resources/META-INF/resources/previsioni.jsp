<%@ include file="./init.jsp" %>

<%
	AnimazioneBean animBean = (AnimazioneBean) renderRequest.getAttribute("AnimazioneBean");
	String animType = (String) renderRequest.getAttribute("AnimType");
%>


	<script type="text/javascript">
   	
		var img_list = <%=animBean.retriveImg(animType)%>;
		
		var intervalId;
		
		function loadAnimation( animUrl) {
			
			console.log('clear interval');
			
			clearInterval( intervalId);
			
			location.href= animUrl;
		}
			
		$(document ).ready(function() {
				
			console.log('previsioni-start');
			
			var week = [ "Domenica", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato" ];
	
			var cnt;
			var ix;
			var img;
			var txt;
			var iday, day;
			
			ix	= 0;
			cnt = document.getElementById("animazione_previ");
			cnt.innerHTML = "";
			
			txt = document.createElement("div");
			img = document.createElement("img");
			cnt.appendChild(txt);
			cnt.appendChild(img);
				
			iday = new Date
			iday = new Date(iday.getFullYear(), iday.getMonth(), iday.getDate(), 0, 0, 0, 0);
			
			day = new Date( +iday + 3 * 60 * 60 * 1000);
			
			txt.innerHTML = week[day.getDay()]  + " ore " + ((ix % 8) + 1) * 3 + " UTC";
			img.src = "data:image/png;base64," + img_list[ix]._data;
			
			intervalId = setInterval(function() {
					
				if(!img_list[ix + 1])
					ix = 0;
					
				img.src = "data:image/png;base64," + img_list[ix++]._data;		
				day = new Date(+iday + (ix * 3) * 60 * 60 * 1000) ;
				
				txt.innerHTML = week[day.getDay()] + " ore " + ((ix % 8) + 1) * 3 + " UTC";
			}, 2000);
		});
	</script>
	
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
					Previsioni di precipitazione, copertura nuvolosa, velocità e direzione del vento in Emilia-Romagna
					e nel nord Italia, fino a 72 e con dettaglio ogni 3 ore, realizzate	in modo completamente automatico utilizzando il modello
					meteorologico numerico ad area limitata 
					<a href='http://www.arpa.emr.it/dettaglio_generale.asp?id=2584&amp;idlivello=32'>Cosmo-Lami</a>,
					realizzato in consorzio tra 
					<a href="http://www.protezionecivile.it/" /> <!--img src="/sim/img/logo_dpcn.png" alt="logo DPCN" /></a-->
					<a href="http://www.protezionecivile.it/">Dipartimento protezione civile nazionale</a>, 
					<a href="http://www.aeronautica.difesa.it/">USAM Aeronautica Militare</a>, 
					<a href="http://www.arpa.piemonte.it/ ">Arpa Piemonte</a>, Arpa Emilia-Romagna.
					<br/>
					Il tempo coordinato universale, conosciuto anche come tempo civile e abbreviato con la sigla UTC è il fuso orario di
					riferimento da cui sono calcolati tutti gli altri fusi orari del mondo. In Italia, quando è in vigore l'ora
					solare, si usa l'orario CET che è pari a UTC +1 ora, mentre quando è in vigore l'ora legale si usa l'orario CEST che è pari a UTC +2 ore.
				</p>
				
				<hr />
				
				<div class="col-12">
				
					<div id="animazione_previ" style="text-align: center; padding-bottom: 15px;" >
						<div>
							<small id="didascalia">attendere il caricamento delle
								immagini</small>
						</div>
	
						<img id="img_animazione_previ" alt="animazione"
							src="/o/allerta-theme/img/loadingAnimation2.gif" />
					</div>            		
            	</div>	
            	
            	<div class="col-12">
					<small>Emissione di <%=animBean.days().get(0) %></small>
				</div>
            		
            		
            	<div class="col-12">
		
            		<hr class="pb-3">
            		
            		<c:set 	
            			var="images" 
						value="<%=animBean.retriveImgView(animType) %>"
						scope="request" />
            		
            		<c:set 	
            			var="days" 
						value="<%=animBean.days()%>"
						scope="request" />
						
					<div class="row">	
						
						<c:forEach items="${images}" var="image" varStatus="loop">
							
							<c:if test="${loop.index % 8==0 }">
								<div class="col-12" style="padding-bottom: 15px;padding-top: 15px;">
									<h5>previsioni per <c:out value="${days.get(loop.index / 8) }" /> </h5>
								</div>
							</c:if>
						
							<div class="col-3">
								<div class="portlet-column portlet-column-only span3" style="text-align: center;">
									<h6 class="meteo">
										ore	<c:out value="${((loop.index%8)+1)*3}" /> UTC
									</h6>
									
									<portlet:renderURL var="animUrl">
										<portlet:param name="name" value="<%=animType %>"/>
										<portlet:param name="id" value="${loop.index }"/>
										<portlet:param name="mvcPath" value="/animeteo.jsp"/>
									</portlet:renderURL>
							
									<a href="javascript:loadAnimation('<%=animUrl%>')">
										<img src="data:image/png;base64,${image.getData()}" />
									</a>
								</div>
							</div>
						</c:forEach>
					
					</div>
            	
				</div>
				
				<div class="col-12">
		
            		<hr class="pb-3">
            		
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
            		
	         			<div class="col-12" style="padding-bottom: 15px;padding-top: 15px;">
							<h5>Le altre mappe disponibili</h5>
						</div>
				
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
		
	</div>
   
 </main>  