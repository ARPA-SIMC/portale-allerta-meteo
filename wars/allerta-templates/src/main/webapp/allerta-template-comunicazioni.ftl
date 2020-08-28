<main class="page main page--index" id="main-content">

	<div class="page__head">
	   <div class="container d-flex">
	        <div class="row w-100 justify-content-between">
	            <h1 class="col-12 col-lg-12">Comunicazioni</h1>
	            <p class="col-12 lead">
					Tutte le comunicazioni pubblicate dalla Protezione Civile Regionale
	            </p>
	        </div>
	    </div>
	    
	    <div class="breadcrumb-container">
            <div class="container d-flex">
                <nav class="row" aria-label="Hai percorso">
                    <ol class="breadcrumb">
        
                        <li class="breadcrumb-item">
                            <a href="/">Home</a>
                        </li>
        
                        <li class="breadcrumb-item active" aria-current="page">Comunicazioni</li>
        
                    </ol>
                </nav>
            </div>
        </div>
	    
	</div>
    
    <div class="container page__body">
    
	    <div class="row"> 
	        <div class="col-12 col-lg-8 page__content" id="page-content">

				${processor.processColumn("column-2", "portlet-column-content portlet-column-content-only")}
                        
			</div>
                        
			<div class="col-12 col-lg-4">
				${processor.processColumn("column-3", "portlet-column-content portlet-column-content-only")}
		
			</div>
		</div>
		
     </div>
    
</main>