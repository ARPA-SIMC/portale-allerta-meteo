am = am || {};

am.MapDataScenarioFactory = (function($){

    /**
     * @class MapDataScenarioFactory
     * ---
     * The singleton factory of MapDataScenario instances
     */
    const MapDataScenarioFactory = (function(){
    return{
        create: function(k, options){
        switch(k){
            case 'precipitazioni':
                return new MapDataScenarioPrecipitazioni(options);
            case 'idrometrico':
                return new MapDataScenarioIdrometrico(options);
            case 'temperature':
                return new MapDataScenarioTemperature(options);
            case 'pressione':
                return new MapDataScenarioPressione(options);
            case 'vento':
                return new MapDataScenarioVento(options);
            case 'umidita':
                return new MapDataScenarioUmidita(options);

            case 'radar':
                return new MapDataScenarioRadar(options);                                        
            case 'cumulata-6h':
            case 'cumulata-48h':
                options.cumulataHoursAmount = parseInt(k.split("-")[1]);
                return new MapDataScenarioCumulata(options);
            case 'anim-mare':
                return new MapDataScenarioAnimazioneMare(options);
                
            case '': // @FIXME qua ci vanno aggiunti i costruttori degli altri scenari di dati
            default:
            return null;
        }
        },
        getBaseLayer: function(k){
        return MapDataServer.getLayer(k);
        },
        /**
         * Creates the base layer asked in input and return it as a Leaflet GeoJson Layer
         * @param {String} k The key of the base layer to return, one of "bacini", "reticolo", "regione", "comuni", "areeallertamento"
         * @return {Leaflet.Layer} 
         */
        getBaseLayerAsLeafletGeoJson: function(k){
        
        var styleCount=0; // used for styling accumulation

        var l = L.geoJson( this.getBaseLayer(k), {
            style: (function (feature) {
            var s = MAP_STYLE.rtdata.defaultStyle;
            switch(k){
                case 'reticolo':
                s = MAP_STYLE.rtdata.reticolo.style;
                break;
                case 'regione':
                s = MAP_STYLE.rtdata.regione.style;
                break;
            }
            jQuery.data( feature, 'originalStyle', s );
            return s;

            }).bind(this),
            onEachFeature: (function(feature, layer){

            switch( k ){
                case 'bacini':
                var color = (feature.properties.BACINO_AGG.indexOf("Pianura")<0)
                    ? MAP_STYLE.rtdata.bacini.colors[styleCount++] 
                    : MAP_STYLE.rtdata.bacini.defaultColor;
                layer.setStyle({fillColor: color });  
                break;
                case 'reticolo':
                if (feature.properties) {
                    var popupString = '<div class="popup">'+feature.properties.ETICHETTA+'</div>';
                    layer.bindPopup(popupString);
                }
                layer.on('mouseover', function() {
                    layer.setStyle(MAP_STYLE.rtdata.reticolo.hover);
                });
                layer.on('mouseout', function () {
                    layer.setStyle(MAP_STYLE.rtdata.reticolo.style);
                });
                break;
                break;
                default:
                
            }
            
            }).bind(this)
        });
        
        return l;
        }
    }
    })();
  
    
    return MapDataScenarioFactory;
})(jQuery);

// Global scope
var MapDataScenarioFactory = am.MapDataScenarioFactory