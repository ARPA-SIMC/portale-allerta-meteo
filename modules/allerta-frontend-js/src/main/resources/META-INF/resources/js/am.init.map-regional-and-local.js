
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
        MapDataServer2.init();
    
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
        		 
        			 
        		 var versione = mapComponent.attr("data-versione")
        		 var TERR = (versione=="1"? TERRITORY : TERRITORY2)
        		 //var mapComponent =  $('[data-toggle=forecast-map]');
        		 
        		 console.log( mapComponent.attr("data-initialized") );
        		 
        		 // Init the map if not yet done
 	             if( ! mapComponent.attr("data-initialized") ) {
 	            	
 	            	 var map;
 	            	// create the controller
 	            	 if (versione=="1")
	                 map = new ForecastMap({
	                    context: context,
	                    center: TERR.REGION_LAT_LNG,
	                    territory: TERR,
	                    container: mapComponent,
	                    version: versione,
	                    mapContainer: $(".map-component__map", mapComponent),
	                    comune: mapComponent.attr("data-comune"),
	                    rtdataControl: ( !! mapComponent.attr("data-comune") )
	                });
 	            	 else
 	            		map = new ForecastMap2({
 		                    context: context,
 		                    center: TERR.REGION_LAT_LNG,
 		                    territory: TERR,
 		                    container: mapComponent,
 		                    version: versione,
 		                    mapContainer: $(".map-component__map", mapComponent),
 		                    comune: mapComponent.attr("data-comune"),
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
 	            
        	 } else { // Monitoraggio
        		 
        		 var mapComponent =  $('[data-toggle=monitoring-map]');
        		 
        		// if( ! mapComponent.attr("data-initialized") ) {
	            	
	        		 var rtdata = mapComponent.attr("data-scenarios").split("|");
	                
		             // create the controller
		             var map = new MonitoringMap({
		                dataScenarios: rtdata, // keys of the data filers to manage, that is "radar","idrometrico","precipitazioni", "cumulata-6h"
		                center: mapComponent.attr("data-comune-latlng")
		                    ? mapComponent.attr("data-comune-latlng") 
		                    : TERRITORY2.REGION_LAT_LNG,
		                territory: TERRITORY2,
		                container: mapComponent,
		                mapContainer: $(".map-component__map", mapComponent),
		                comune: mapComponent.attr("data-comune"),
		                refreshTool: true,
		                currentScenario: 'radar', // change me with radar
		                renderScenarioOnLoad: true
		               // searchTool: true,
		               // searchToolPosition: "topleft"
		             });
		             
		             // now I'm initialized
			         mapComponent.attr("data-initialized", true);
			         
        		 //} else {
 	            	
 	            	//$(this).data("mapComponent").refresh();  
 	            //}
    
            } else {
            	// create the controller
                var map = new BackofficeMonitoringMap({
                    center: TERRITORY2.REGION_LAT_LNG,
                    territory: TERRITORY2,
                    container: mapComponent,
                    mapContainer: $(".map-component__map", mapComponent),
                    currentScenario: 'radar', // change me with radar
                    renderScenarioOnLoad: true
                });
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
