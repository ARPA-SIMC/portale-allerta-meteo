<main class="page main page--index" id="main-content">

	<div class="page__head">
	   <div class="container d-flex">
	        <div class="row w-100 justify-content-between">
	            <h1 class="col-12 col-lg-12">Report Post Evento</h1>
	            <p class="col-12 lead">
	            	I Report Post Evento
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

				<div class="alert-info">
					<p style="font-weight:bold;margin-left:10px;"><i class="fa fa-info-circle"></i> Cos'&egrave; un report post-evento?</p>
					<p style="margin-left:10px;">
						Al verificarsi di eventi particolarmente intensi o eventi che provocano danni sul territorio regionale, 
						e per una maggiore comprensione degli eventi stessi, vengono elaborati dei Rapporti tecnici che descrivono puntualmente 
						l'evoluzione dei fenomeni occorsi.<br/>
						Le relazioni contengono le analisi dei dati meteo e le descrizioni dettagliate degli eventi verificatisi, insieme ai principali effetti e danni accaduti sul territorio.
					</p>
				</div>
                                
				<p></p>
				
				<div>
				  	<a href="https://allertameteo.regione.emilia-romagna.it/compila-allerta-portlet/feed?feed=monitoraggi" target="_blank" class="btn btn-transparent" title="RSS dei contenuti">
				     	<span class="icon i-rss" title="Icona RSS"></span> <span>RSS</span> 
				     	<span class="icon i-external-link-square u-open-external" title="Apre una nuova finestra"></span>
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