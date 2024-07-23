<!-- # sezioni/layout/header -->
<!-- Header -->


<header class="header ">
    <nav class="navbar container-fluid">
        
        <div class="d-flex justify-content-start">
            <a href="#" class="header__nav-toggle" style="" data-toggle="collapse-main-nav" data-target="#main-nav" aria-controls="main-nav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="icon i-navicon" title="Mostra"></span>
                <span class="icon i-close icon--open" title="Nascondi"></span> 
                
                <span class="header__nav-toggle__label d-none d-md-inline d-print-inline">Menu</span>
            </a>

            <a class="navbar-brand" style="margin-left:4.5rem" href="${company_url}" title="Torna alla home">
                <picture>
                    <img src="${css_folder}/../img/logo.png" alt="Allerta Meteo Emilia-Romagna" >
                </picture>
                <span>
                    <span class="navbar-brand__heading">Allerta Meteo Emilia-Romagna</span>
                    <span class="navbar-brand__lead">Sito ufficiale gestito dall'Agenzia per la sicurezza territoriale e la protezione civile e da ARPAE</span>
                </span>
            </a>
        </div>

		<@liferay_portlet["runtime"] portletName="AllertaHeaderPortlet" />

    </nav>
</header>
<!-- Header -->
<!-- / sezioni/layout/header -->
