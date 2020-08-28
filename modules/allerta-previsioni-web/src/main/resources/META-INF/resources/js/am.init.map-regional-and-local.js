
(function($){

  
    /**
     * INITIALIZATION
     */
    $(document).ready(function () {
    	
    	  // Import Check
        if (
        		typeof MapDataServer === 'undefined' || MapDataServer === null || !MapDataServer ||
        		typeof ForecastMap === 'undefined' || ForecastMap === null  || !ForecastMap ||
        		typeof MonitoringMap === 'undefined' || MonitoringMap === null || !MonitoringMap  
        ){
        	console.error('Some AM classes is missing. Quit');
        	return;
            //throw "Some AM classes is missing. Quit!";
        }


        // Init areas and get basic data layer
        MapDataServer.init();
    
        // Init all map components
        var mapComponents = [];
        
        $('[data-toggle="tab"]').on("click", function() {
        	
        	var context = $(this).attr("href");
        	
        	console.log('tab clicked', context);
        	
        	 if( context == '#tab--oggi' || context == '#tab--domani' ) {
        		 
        		 var mapComponent;
        		 
        		 if( context == '#tab--oggi')
        			 mapComponent = $('#map-component--oggi');
        		 else 
        			 mapComponent = $('#map-component--domani');
        		 
        			 
        		 //var mapComponent =  $('[data-toggle=forecast-map]');
        		 
        		 console.log( mapComponent.attr("data-initialized") );
        		 
        		 // Init the map if not yet done
 	             if( ! mapComponent.attr("data-initialized") ) {
 	            	
 	            	// create the controller
	                var map = new ForecastMap({
	                    context: context,
	                    center: TERRITORY.REGION_LAT_LNG,
	                    territory: TERRITORY,
	                    container: mapComponent,
	                    mapContainer: $(".map-component__map", mapComponent),
	                    comune: COMUNE,
	                    rtdataControl: ( !! mapComponent.attr("data-comune") )
	                });
	        
	                // add a scope reference (just in case) and store a ref in the tab head's data
	                mapComponents.push(map);
	                $(this).data("mapComponent", map);
	                
	                // now I'm initialized
		            mapComponent.attr("data-initialized", true);
 	            	
 	             } //else {
	            	
	          //  	$(this).data("mapComponent").refresh();  
	         //   }
 	            
 	          
 	            
        	 } else if (context == '#tab--monitoraggio' ) { // Monitoraggio
        		 
        		 var mapComponent =  $('[data-toggle=monitoring-map]');
        		 
        		 if( ! mapComponent.attr("data-initialized") ) {
	            	
	        		 var rtdata = mapComponent.attr("data-scenarios").split("|");
	                
		             // create the controller
		             var map = new MonitoringMap({
		                dataScenarios: rtdata, // keys of the data filers to manage, that is "radar","idrometrico","precipitazioni", "cumulata-6h"
		                center: mapComponent.attr("data-comune-latlng")
		                    ? mapComponent.attr("data-comune-latlng") 
		                    : TERRITORY.REGION_LAT_LNG,
		                territory: TERRITORY,
		                container: mapComponent,
		                mapContainer: $(".map-component__map", mapComponent),
		                comune: mapComponent.attr("data-comune"),
		                refreshTool: true,
		                currentScenario: 'radar', // change me with radar
		                renderScenarioOnLoad: true
		             });
		             
		             // now I'm initialized
			         mapComponent.attr("data-initialized", true);
			         
        		 //} else {
 	            	
 	            	//$(this).data("mapComponent").refresh();  
 	            }
    
            } else {
            	
            	 var mapComponent =  $('[data-toggle=backoffice-monitoring-map]');
            	 
            	 if( ! mapComponent.attr("data-initialized") ) {
	            	// create the controller
	                var map = new BackofficeMonitoringMap({
	                    center: TERRITORY.REGION_LAT_LNG,
	                    territory: TERRITORY,
	                    container: mapComponent,
	                    mapContainer: $(".map-component__map", mapComponent),
	                    currentScenario: 'radar', // change me with radar
	                    renderScenarioOnLoad: true
	                });
	                
	             // now I'm initialized
			         mapComponent.attr("data-initialized", true);
            	 }
                
                
            }
        	
        });
        
        
        $('[data-toggle=monitoring-map]').removeAttr("data-initialized");
        $('[data-toggle=forecast-map]').removeAttr("data-initialized");
         
        $('[data-toggle="tab"] :first ').click();
	
	        // Resize handler
	        $(window).resize(function(){
	            var i=0, I=mapComponents.length;
	            for(;i<I;++i)
	                mapComponents[i].refresh();
	            
	        });
	    
	        // Load current active tab
	        if( $(this).parent().hasClass("active") ){
	            $('[data-toggle="tab"][href="#'+$(this).parent().attr("id")+'"]').trigger("shown.bs.tab"); 
	            
	           
	        }
	    
	        // Scroll to the correct viewport when clicking a tab
	        $('[href="#'+$(this).parent().attr("id")+'"]').on("click",function(){
	            if( $(this).attr("data-toggle") == "tab" ){
	            $('body,html').animate({
	                scrollTop: $(this).offset().top
	            }, 250);
	            }
	        });
        
        
            
     
        
        
    });  

})(jQuery);
