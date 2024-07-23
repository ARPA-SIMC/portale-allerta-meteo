<main class="page main page--index" id="main-content">

	<div class="page__head">
	   <div class="container d-flex">
	        <div class="row w-100 justify-content-between">
	            <h1 class="col-12 col-lg-12">Monitoraggio Eventi</h1>
	            <p class="col-12 lead">
	            </p>
	        </div>
	    </div>
	    
		<div class="breadcrumb-container">
	        <div class="container d-flex">
	            <nav class="row" aria-label="Hai percorso">
	              	${processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")}
	            </nav>
	        </div>
	    </div>
	</div>
    
    <div class="container page__body">
    
	    <div class="row"> 
	        <div class="col-12 col-lg-8 page__content" id="page-content">

				<h2>Documenti di monitoraggio</h2>
                                
				<p>Documenti di Monitoraggio meteo, idrologico e idraulico, emessi periodicamente dal Centro Funzionale di Arpae , contenenti un aggiornamento sulle caratteristiche, localizzazione ed evoluzione a breve termine dei fenomeni di pioggia e dei fenomeni di piena in atto.</p>
                
                <p></p>
                
                <p style="font-size: 1.35rem">Vai all'<a href="/archivio-monitoraggi" >archivio completo dei documenti di monitoraggio</a>.</p>
                
				
				<div>
				  	<a href="/compila-allerta-portlet/feed?feed=monitoraggi" target="_blank" class="btn btn-transparent" title="RSS Documenti di monitoraggio">
				     	<span class="icon i-rss" title="Icona RSS"></span> <span>RSS</span> 
				     	<span class="icon i-external-link-square u-open-external" title="RSS Documenti di monitoraggio"></span>
				 	</a>
				</div>
                
                
				${processor.processColumn("column-2", "portlet-column-content portlet-column-content-only")}
                        
			</div>
                        
			<div class="col-12 col-lg-4">
				${processor.processColumn("column-3", "portlet-column-content portlet-column-content-only")}
		
			</div>
		</div>
		
     </div>
    
</main>