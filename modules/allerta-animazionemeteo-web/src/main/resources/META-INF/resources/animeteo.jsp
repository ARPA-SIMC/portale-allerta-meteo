<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="./init.jsp"%>

<%
	AnimazioneBean animBean = (AnimazioneBean) renderRequest.getAttribute("AnimazioneBean");
	int id = ParamUtil.getInteger(renderRequest, "id");
	String animType = (String) renderRequest.getAttribute("AnimType");
%>
<script type="text/javascript">

	var id =<%=id%>;
	var testImg = <%= animBean.retriveBigImg(animType)%>;  
		
</script>

<script src="<%=request.getContextPath()%>/js/arpa.js?v=0.1s"></script>

<main class="page main page--previsioni" id="main-content">

<div class="page__head">

	<div class="container d-flex">
		<div class="row w-100 justify-content-between">
			<h1 class="col-12 col-lg-12">Animazione meteo</h1>

			<p class="col-12 lead"></p>
		</div>
	</div>

	<div class="breadcrumb-container">
		<div class="container d-flex">
			<nav class="row" aria-label="Hai percorso">
				<ol class="breadcrumb">

					<li class="breadcrumb-item"><a href="/">Home</a></li>

					<li class="breadcrumb-item active" aria-current="page">Animazione
						meteo</li>

				</ol>
			</nav>
		</div>
	</div>
</div>

<div class="container page__body">
	<div class="row">
		<div class="col-12 page__content" id="page-content">

			<p>
				Previsioni di precipitazione, copertura nuvolosa, velocità e
				direzione del vento in Emilia-Romagna e nel nord Italia, fino a 72 e
				con dettaglio ogni 3 ore, realizzate in modo completamente
				automatico utilizzando il modello meteorologico numerico ad area
				limitata <a
					href='http://www.arpa.emr.it/dettaglio_generale.asp?id=2584&amp;idlivello=32'>Cosmo-Lami</a>,
				realizzato in consorzio tra <a
					href="http://www.protezionecivile.it/" />
				<!--img src="/sim/img/logo_dpcn.png" alt="logo DPCN" /></a-->
				<a href="http://www.protezionecivile.it/">Dipartimento
					protezione civile nazionale</a>, <a
					href="http://www.aeronautica.difesa.it/">USAM Aeronautica
					Militare</a>, <a href="http://www.arpa.piemonte.it/ ">Arpa Piemonte</a>,
				Arpa Emilia-Romagna. <br /> Il tempo coordinato universale,
				conosciuto anche come tempo civile e abbreviato con la sigla UTC è
				il fuso orario di riferimento da cui sono calcolati tutti gli altri
				fusi orari del mondo. In Italia, quando è in vigore l'ora solare, si
				usa l'orario CET che è pari a UTC +1 ora, mentre quando è in vigore
				l'ora legale si usa l'orario CEST che è pari a UTC +2 ore.
			</p>

			<div class="col-12">
				<small>Emissione <%=animBean.days().get(0)%></small>
			</div>

			<div class="col-12">

				<div style="text-align: center; padding-bottom: 15px;">

					<h6 class="meteo" id="image-label">
						ore
						<%=(((id % 8) + 1) * 3)%>
						UTC
					</h6>

					<img id="img_animazione_previ" alt="animazione"
						src="data:image/jpg;base64,<%=animBean.retriveBigImg(animType, id).getData()%>" />
				</div>

			</div>

		</div>

	</div>

	<div class="row flex-column-reverse flex-md-row map-toolbar">
	
		<div class="col-12 col-md-6">
		
			<div class="map-toolbar__animation">
			
				<div class="form-group map-animation-dropdown">
				
					<label for="animation__timespan--dato-osservato--idrometrico">
						Animazione </label>
						
					<div class="input-group">
					
						<select id="animation__timespan--dato-osservato--idrometrico"
							class="form-control map-animation__timespan">
							
							<option value="3">prossime 3 ore</option>
							<option value="6">prossime 6 ore</option>
							<option value="9">prossime 9 ore</option>
							<option value="12">prossime 12 ore</option>
							<option value="15">prossime 15 ore</option>
							<option value="18">prossime 18 ore</option>
							<option value="21">prossime 21 ore</option>
							<option value="24">prossime 24 ore</option>
							<option value="27">prossime 27 ore</option>
							<option value="30">prossime 30 ore</option>
							<option value="33">prossime 33 ore</option>
							<option value="36">prossime 36 ore</option>
							<option value="39">prossime 39 ore</option>
							<option value="42">prossime 42 ore</option>
							<option value="45">prossime 45 ore</option>
							<option value="48">prossime 48 ore</option>
							<option value="51">prossime 51 ore</option>
							<option value="54">prossime 54 ore</option>
							<option value="57">prossime 57 ore</option>
							<option value="60">prossime 60 ore</option>
							<option value="63">prossime 63 ore</option>
							<option value="66">prossime 66 ore</option>
							<option value="69">prossime 69 ore</option>
							<option value="72" selected="selected">prossime 72 ore</option>
						</select>
						
						<div class="input-group-append">
						     <a href="#map-toolbar__time-player--dato-osservato--anim-meteo" title="Lancia/Ferma l'animazione"
						         data-source="#animation__timespan--dato-osservato--anim-mare"
						         data-toggle="animate-data" class="btn btn-primary map-animation__toggle">
						         <span class="icon i-play-rounded-corner map-animation__toggle__play" title="Lancia l'animazione"></span>
						         <span class="icon i-stop map-animation__toggle__stop" title="Ferma l'animazione"></span>
						     </a>
						 </div>						
						
						<!-- 
						<div class="input-group-append">
						
							<div class="btn btn-primary map-animation__toggle">
							
								<a href="#" class="map-animation__toggle__play">
									<i class="fa fa-play"></i>
								</a>
								
							 	<a href="#" class="map-animation__toggle__stop">
									<i class="fa fa-stop"></i>
								</a>
							</div>
						</div>
						 -->
					</div>

				</div>
			</div>
		</div>
		
		<!--
		<div class="col-12 col-md-6">
		 
			<div class="map-toolbar__timewheel-player"
				id="#map-toolbar__timewheel-player--dato-osservato--idrometrico">
				
			
				<div class="swiper-container" data-toggle="timewheel">
					<div class="swiper-wrapper">
				
					</div>
				</div>
				
				<div class="swiper-button-prev" aria-disabled="false" tabindex="0" role="button" aria-label="Previous slide"></div>
				
				<div class="swiper-button-next" aria-disabled="false" tabindex="0" role="button" aria-label="Next slide"></div>
				
			</div>
		
		</div>
		-->
		<div class="col-12 col-md-6">	
          <div class="map-toolbar__timewheel-player" id="#map-toolbar__timewheel-player--dato-osservato--anim-meteo">
              <div class="swiper-button-prev"></div>
              <div class="swiper-container" data-toggle="timewheel">
                  <div class="swiper-wrapper">
                      <!-- Qui vengono messe le slide via JS in base ai dati ricevuti dal server --->
                  </div>
              </div>
              <div class="swiper-button-next"></div>
          </div>
        </div>		
	</div>

</div>

</main>
