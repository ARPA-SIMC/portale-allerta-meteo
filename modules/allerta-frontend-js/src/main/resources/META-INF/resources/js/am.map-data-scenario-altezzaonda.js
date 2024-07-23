am = am || {};

am.MapDataScenarioAltezzaOnda = (function($){

    /**
     * @class MapDataScenarioAltezzaOnda
     * @extends MapDataScenarioSensore
     * ---
     * The concrete subclass of MapDataScenarioSensore to manage Pressione Level
     */
    function MapDataScenarioAltezzaOnda(options){
        
        // force settings
        if( options.baseLayers ){
            options.baseLayers = {};
            options.baseLayers.bacini = false;
            options.baseLayers.reticolo = false;
            options.baseLayers.regione = true;
        }
        

        // Call constructor of superclass to initialize superclass-derived members.
        MapDataScenarioSensore.call(this, options); 
    
    }
    // Inherit from MapDataScenario
    MapDataScenarioAltezzaOnda.prototype = Object.create(MapDataScenarioSensore.prototype);
    MapDataScenarioAltezzaOnda.prototype.constructor = MapDataScenarioAltezzaOnda;
    
    MapDataScenarioAltezzaOnda.prototype.getSensorMarkerBackground= function(soglia1, soglia2, soglia3, ilValore) {
        var classe=' marker--sensor livellomare'
        return classe;
    }

    MapDataScenarioAltezzaOnda.prototype.normalizeValue = function(v){
        return v;
    }
  
    
    return MapDataScenarioAltezzaOnda;
})(jQuery);

// Global scope
var MapDataScenarioAltezzaOnda = am.MapDataScenarioAltezzaOnda