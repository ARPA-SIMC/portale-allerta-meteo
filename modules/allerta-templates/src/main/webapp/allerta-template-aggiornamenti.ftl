<main class="page main page--index-3-cols" id="main-content">

	<div class="page__head">
        
        <div class="container d-flex">
            <div class="row w-100 justify-content-between">
                <h1 class="col-12 col-lg-12">Archivio</h1>
                
                
            </div>

            
        </div>
            <div class="breadcrumb-container">
                <div class="container d-flex">
                    <nav class="row" aria-label="Hai percorso">
                        <ol class="breadcrumb">
            
                            <li class="breadcrumb-item">
                                <a href="/">Home</a>
                            </li>
            
                            <li class="breadcrumb-item active" aria-current="page">Archivio</li>
            
                        </ol>
                    </nav>
                </div>
            </div>
    </div>
    
     <div class="container page__body">
     
     	<div class="row"> 
     	
        	<div class="col-12 col-lg-8 order-0 order-lg-1 page__content" id="page-content">
            	${processor.processColumn("column-1", "portlet-column-content portlet-column-content-only")}
            </div>
            
            <div class="col-12 col-lg-3 pt-lg-4 order-1 order-lg-0 page__sidebar">
                                
		        <h2 class="mb-4">
		            <span class="icon i-feed" title="Icona archivio"></span>
		            Archivio
		        </h2>
        
		        <div class="bg-gray-200 p-4">   
		            <h3 class="mb-4">Vai alle sezioni specifiche</h3>
		            <nav role="navigation" class="nav-vertical ">
		                <ul class="nav flex-column">
		                    <li class="nav-item">
		                        <a class="nav-link " href="/allerte-e-bollettini">
		                            <span class="nav-vertical__item-label">Allerte e bollettini meteo</span>
		                        </a>    
		                    </li>

                                    <li class="nav-item">
		                        <a class="nav-link " href="/allerte-e-bollettini-valanghe">
		                            <span class="nav-vertical__item-label">Allerte e bollettini valanghe</span>
		                        </a>    
		                    </li>
		                    
		                    <li class="nav-item">
		                        <a class="nav-link" href="/monitoraggio-eventi">
		                            <span class="nav-vertical__item-label">Monitoraggi</span>
		                        </a>    
		                    </li>
		                    
		                    <li class="nav-item">
		                        <a class="nav-link " href="/comunicazioni">
		                            <span class="nav-vertical__item-label">Notizie</span>
		                        </a>    
		                    </li>
		                    
		                    <li class="nav-item">
		                        <a class="nav-link " href="/archivio-report-post-evento">
		                            <span class="nav-vertical__item-label">Report post evento</span>
		                        </a>    
		                    </li>
		                                    
		                </ul>
		                                    
		            </nav>
		                                        
		        </div>
    
    	</div>	
    	
    	<div class="col-12 col-lg-1 order-2">
    		${processor.processColumn("column-2", "portlet-column-content portlet-column-content-only")}
    	</div>        	
	

</main>