<main class="page main page--index" id="main-content">

	<div class="page__head">
	
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
	    
	    	<div class="col-4 col-lg-4 page__content">
	    		${processor.processColumn("column-2", "portlet-column-content portlet-column-content-only")}
	        </div>
	        
	        <div class="col-8 col-lg-8 page__content">
	        	${processor.processColumn("column-3", "portlet-column-content portlet-column-content-only")}
	        </div>
	    </div>
	    
	</div>   
	

</main>