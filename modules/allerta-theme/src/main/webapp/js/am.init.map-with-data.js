(function($){
    
    /**
     * INITIALIZATION for Previsioni e dati's map
     */
    $(document).ready(function () {

        // Init areas and get basic data layer
        MapDataServer.init();

        // Init all map components
        var mapComponents = [];


        // Init Data Map (eg. Previsioni e dati » Livello Idrometrico)
        $('[data-toggle=data-map]').each(function(){
            var mapComponent =  $(this);
            // Init the map if not yet done
            if( ! mapComponent.attr("data-initialized") ){

                // Get the data to display
                var rtdata = mapComponent.attr("data-scenarios").split("|"); // Note: this should be one element, but we let the code generic
                
                // create the controller
                var map = new DataMap({
                    dataScenarios: rtdata, // key of data, Note: this should be one element, but we let the code generic
                    center: TERRITORY.REGION_LAT_LNG,
                    territory: TERRITORY,
                    container: mapComponent,
                    mapContainer: $(".map-component__map", mapComponent),
                    refreshTool: false,
                    searchTool: true,
                    key: rtdata[0],
                    terrainLayer: ( rtdata[0]!= 'cumulata-6h' && rtdata[0]!= 'cumulata-48h' && rtdata[0]!= 'anim-mare'),
                    renderScenarioOnLoad: true
                });
                

            }
                
            // now I'm initialized
            mapComponent.attr("data-initialized", true);

            // Resize handler
            $(window).resize(function(){
            var i=0, I=mapComponents.length;
            for(;i<I;++i)
                mapComponents[i].refresh();

            });
        });
 
    });
})(jQuery);