<!-- # sezioni/layout/header -->
<!-- Header -->


<header class="header ">
    <nav class="navbar container-fluid">
        
        <div class="d-flex justify-content-start">
            <a href="#" class="header__nav-toggle" style="" data-toggle="collapse-main-nav" data-target="#main-nav" aria-controls="main-nav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="icon i-navicon" title="<#if w3c_language_id == 'en-GB'>Show<#else>Mostra</#if>"></span>
                <span class="icon i-close icon--open" title="<#if w3c_language_id == 'en-GB'>Hide<#else>Nascondi</#if>"></span> 
                
                <span class="header__nav-toggle__label d-none d-md-inline d-print-inline">Menu</span>
            </a>

            <a class="navbar-brand" style="margin-left:4.5rem" href="${company_url}" title="<#if w3c_language_id == 'en-GB'>Back to home<#else>Torna alla home</#if>">
                <picture>
                    <img src="${css_folder}/../img/logo.png" alt="Allerta Meteo Emilia-Romagna" >
                </picture>
                <span>
                    <span class="navbar-brand__heading">Allerta Meteo Emilia-Romagna</span>
                    <span class="navbar-brand__lead"><#if w3c_language_id == 'en-GB'>Official website managed by Agenzia per la sicurezza territoriale e la protezione civile and by ARPAE<#else>Sito ufficiale gestito dall'Agenzia per la sicurezza territoriale e la protezione civile e da ARPAE</#if></span>
                </span>
            </a>
        </div>
	<div style="display: flex;align-items: center;">
		<@liferay_portlet["runtime"] portletName="AllertaHeaderPortlet" />
		
		<div class="language-selector"><@liferay_portlet["runtime"] portletName="com_liferay_site_navigation_language_web_portlet_SiteNavigationLanguagePortlet" /></div>
		
		
	</div>
    </nav>
</header>
<!-- Header -->
<!-- / sezioni/layout/header -->
