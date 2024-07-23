<main class="page main page--index" id="main-content">

	<div class="page__head">
	   <div class="container d-flex">
	        <div class="row w-100 justify-content-between">
	            <h1 class="col-12 col-lg-12">Allerte e bollettini</h1>
	            <p class="col-12 lead">
	            	Tutti i documenti di allerta meteo idrogeologica e idraulica e i bollettini di vigilanza
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

				<h2>Lista di allerte e bollettini di vigilanza</h2>

				<p style="font-size: 1.35rem">Vai all'<a href="/archivio-meteo" >archivio completo di allerte e bollettini meteo</a>.</p>
				
				<div>
				  	<a href="/compila-allerta-portlet/feed?feed=allerte-bollettini" target="_blank" class="btn btn-transparent" title="RSS Allerte e Bollettini">
				     	<span class="icon i-rss" title="Icona RSS"></span> <span>RSS</span> 
				     	<span class="icon i-external-link-square u-open-external" title="RSS Allerte e Bollettini"></span>
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