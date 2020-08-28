<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta content="text/html; charset=UTF-8" http-equiv="content-type">

    <!-- SEO -->
   	<title>${the_title} - ${company_name}</title>
    <meta property="og:locale" content="it_IT">
    <meta property="og:site_name" content="${company_name}">
    <meta property="og:title" content="${the_title}">
    <meta property="og:type" content="article">
    <meta property="og:url" content="[FIXME: URL DELLA PAGINA]">
    <meta property="og:image" content="[FIXME: URL DELL'IMMAGINE DELLA PAGINA oppure URL DEL LOGO DI ALLERTA METEO COME IMMAGINE DI DEFAULT]">
    <meta property="og:description" content="[FIXME: DESC DELLA PAGINA]">
    
    <meta name="twitter:card" content="summary_large_image">
    <meta name="twitter:site" content="@AllertaMeteoRER">
    <meta name="twitter:description" content="[FIXME: DESC DELLA PAGINA]">
    <meta name="twitter:creator" content="@AllertaMeteoRER">
    <meta name="twitter:title" content="[FIXME: TITOLO DELLA PAGINA] - [FIXME: URL DELLA PAGINA]">
    <meta name="twitter:image:src" content="[FIXME: URL DELL'IMMAGINE DELLA PAGINA oppure URL DEL LOGO DI ALLERTA METEO COME IMMAGINE DI DEFAULT]">
    <meta name="twitter:domain" content="https://allertameteo.regione.emilia-romagna.it">
  	
    <!-- assets -->

    <link href="${css_folder}/allerta/bootstrap.css?v=0.4" rel='stylesheet' type='text/css' >
    <link href="${css_folder}/allerta/swiper.css?v=0.4" rel='stylesheet' type='text/css' >
    <link href="${css_folder}/allerta/leaflet.css?v=0.4" rel='stylesheet' type='text/css' >
    <link href="${css_folder}/allerta/allerta-meteo.css?v=0.5" rel='stylesheet' type='text/css' media="screen">
    <link href="${css_folder}/icons/style.css?v=0.4" rel='stylesheet' type='text/css' >
    <link href="${css_folder}/allerta/allerta-meteo--print.css?v=0.4" rel='stylesheet' type='text/css' media="print">


    <link rel="shortcut icon" href="${css_folder}/../img/favicon.ico">

	<@liferay_util["include"] page=top_head_include />

	   
</head>

<body class="${css_class}">

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="am" >

	<@liferay_portlet["runtime"]
			portletName="AllertaLeftMenuPortlet"
		/>
	
	<div class="page-wrapper">

	<#include "${full_templates_path}/brand.ftl" />
	
	<#include "${full_templates_path}/header.ftl" />
	
	<h1 class="hide-accessible">${the_title}</h1>

	<main class="page main " id="main-content">

        <#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
		 
	</main>

	<#include "${full_templates_path}/footer.ftl" />
	
	</div>
	
</div>

  <!-- assets -->
 	<script src="${javascript_folder}/jquery-1.12.0.js"></script>
 	<script src="${javascript_folder}/moment.min.js"></script>   	          		
	<script src="${javascript_folder}/moment-locale-it.js"></script>   	
	<!--          		
	<script src="${javascript_folder}/bootstrap.bundle.min.js"></script>
	-->
	<script src="${javascript_folder}/swiper.min.js"></script>
	<script src="${javascript_folder}/am.theme.js"></script>
	
	<script src="${javascript_folder}/leaflet.js"></script>
	<script src="${javascript_folder}/leaflet-search.src.js"></script>	 
	<script src="${javascript_folder}/bootstrap-datetimepicker.js"></script>
	
	<script src="${javascript_folder}/am.data.aree-idro.js"></script>
	<script src="${javascript_folder}/am.data.comuni.js"></script>
	<script src="${javascript_folder}/am.data.regione.js"></script>
	<script src="${javascript_folder}/am.data.bacini.js"></script>
	<script src="${javascript_folder}/am.data.reticolo.js"></script>
	
	<script src="${javascript_folder}/am.aria.bootstrap-datetimepicker.js"></script>
	
	<script src="${javascript_folder}/am.map-config.js?v=0.5"></script>
	<script src="${javascript_folder}/am.leaflet-controls.js"></script>
	<script src="${javascript_folder}/am.map-data-server.js?v=0.1a"></script>
	
	<script src="${javascript_folder}/am.map-data-scenario.js"></script>
	<script src="${javascript_folder}/am.map-data-scenario-sensore.js?v=0.3"></script>
    <script src="${javascript_folder}/am.map-data-scenario-precipitazioni.js"></script>
    <script src="${javascript_folder}/am.map-data-scenario-pressione.js"></script>
    <script src="${javascript_folder}/am.map-data-scenario-umidita.js"></script>
    <script src="${javascript_folder}/am.map-data-scenario-temperature.js"></script>
    <script src="${javascript_folder}/am.map-data-scenario-vento.js"></script>
	<script src="${javascript_folder}/am.map-data-scenario-idrometrico.js?v=0.2"></script>
	<script src="${javascript_folder}/am.map-phenomenon-scenario.js"></script>
	<script src="${javascript_folder}/am.map-data-scenario-radar.js"></script>
	<script src="${javascript_folder}/am.map-data-scenario-immagini.js"></script>
	<script src="${javascript_folder}/am.map-data-scenario-cumulata.js"></script>
    <script src="${javascript_folder}/am.map-data-scenario-factory.js"></script>
    
    <script src="${javascript_folder}/am.map-data-render.js"></script>
	
	<script src="${javascript_folder}/am.map-component.js"></script>
	<script src="${javascript_folder}/am.data-map.js?v=0.5"></script>
	
   	<script src="${javascript_folder}/am.forecast-map.js?v=0.2"></script>
   	<script src="${javascript_folder}/am.monitoring-map.js"></script>
 
   	<!--
   	<script src="${javascript_folder}/am.init.map-regional-and-local.js"></script>
   	-->
   	
   	      

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

</body>
</html>
