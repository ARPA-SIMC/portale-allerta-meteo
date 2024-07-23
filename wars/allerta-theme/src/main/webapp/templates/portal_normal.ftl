<!DOCTYPE html>

<#include init />
<#assign

    skipmenu = false
/>
<#assign

    grafico = layout_friendly_url?contains("grafico-sensori")
/>
<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

    <meta charset="utf-8">
    <#if grafico>
        <meta name="viewport" content="minimum-scale=0.25">
    <#else> 
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </#if>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta content="text/html; charset=UTF-8" http-equiv="content-type">

    <!-- SEO -->
    <meta property="og:locale" content="it_IT">
    <meta property="og:site_name" content="${company_name}">
    <meta property="og:title" content="${the_title}">
    <meta property="og:type" content="article">
    <meta property="og:url" content="https://allertameteo.regione.emilia-romagna.it${layout_friendly_url}">
    <meta property="og:image" content="/o/allerta-theme/img/logo.png">
    <meta property="og:description" content="${page.getDescription(locale)}">
    
    <meta name="twitter:card" content="summary_large_image">
    <meta name="twitter:site" content="@AllertaMeteoRER">
    <meta name="twitter:description" content="${page.getDescription(locale)}">
    <meta name="twitter:creator" content="@AllertaMeteoRER">
    <meta name="twitter:title" content="${the_title} - ${layout_friendly_url}">
    <meta name="twitter:image:src" content="/o/allerta-theme/img/logo.png">
    <meta name="twitter:domain" content="https://allertameteo.regione.emilia-romagna.it">
  	
    <!-- assets 

    <link href="${css_folder}/allerta/bootstrap.css?v=0.4" rel='stylesheet' type='text/css' >
    <link href="${css_folder}/allerta/swiper.css?v=0.4" rel='stylesheet' type='text/css' >
    <link href="${css_folder}/allerta/leaflet.css?v=0.4" rel='stylesheet' type='text/css' >
    <link href="${css_folder}/allerta/allerta-meteo.css?v=0.8" rel='stylesheet' type='text/css' media="screen">
    
    <link href="${css_folder}/icons/style.css?v=0.5" rel='stylesheet' type='text/css' >
   -->
   
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
 
	 
	<script data-senna-track="permanent" async defer crossorigin="anonymous" src="https://connect.facebook.net/it_IT/sdk.js#xfbml=1&version=v6.0"></script>
	
	

	<@liferay_util["include"] page=top_head_include />
	
	<link rel="shortcut icon" href="${css_folder}/../img/favicon.ico">
	

</head>

<body class="${css_class}">

<#if !skipmenu >
<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />
</#if>

<div class="am" >

	<#if !skipmenu >
	<@liferay_portlet["runtime"]
			portletName="AllertaLeftMenuPortlet"
		/>
	</#if>
	
	<div class="page-wrapper">

	<#if !skipmenu >
	<#include "${full_templates_path}/brand.ftl" />
	
	<#include "${full_templates_path}/header.ftl" />
	</#if>
	
	<h1 class="hide-accessible">${the_title}</h1>


	<#if selectable>
		<@liferay_util["include"] page=content_include />
	<#else>
		${portletDisplay.recycle()}

		${portletDisplay.setTitle(the_title)}

		<@liferay_theme["wrap-portlet"] page="portlet.ftl">
			<@liferay_util["include"] page=content_include />
		</@>
	
		 
	
	</#if>
	 <#if !skipmenu >  	
	<#include "${full_templates_path}/footer.ftl" />
	</#if>
	</div>
	 
</div>   	

 <#if !skipmenu >  	     
<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />
</#if>

<script type="text/javascript">

   if (Liferay && FB) Liferay.on('endNavigate', function(event) {
			if (FB) FB.XFBML.parse(); 
		});
		else
	window.checkExists = setInterval(function() {
   if (Liferay) {
      console.log("Exists!");
      Liferay.on('endNavigate', function(event) {
			if (FB) FB.XFBML.parse(); 
		});
      
      clearInterval(window.checkExists);
   }
}, 1000);
		
	</script>

</body>
</html>
