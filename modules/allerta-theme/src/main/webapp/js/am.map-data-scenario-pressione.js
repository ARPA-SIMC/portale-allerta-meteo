am = am || {};

am.MapDataScenarioPressione = (function($){

    /**
     * @class MapDataScenarioPressione
     * @extends MapDataScenarioSensore
     * ---
     * The concrete subclass of MapDataScenarioSensore to manage Pressione Level
     */
    function MapDataScenarioPressione(options){
        
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
    MapDataScenarioPressione.prototype = Object.create(MapDataScenarioSensore.prototype);
    MapDataScenarioPressione.prototype.constructor = MapDataScenarioPressione;
    
    MapDataScenarioPressione.prototype.getSensorMarkerBackground= function(soglia1, soglia2, soglia3, ilValore) {
        var classe=' marker--sensor pressione'
        return classe;
    }

    MapDataScenarioPressione.prototype.normalizeValue = function(v){
        return Math.round(v/100);
    }
  
    
    return MapDataScenarioPressione;
})(jQuery);

// Global scope
var MapDataScenarioPressione = am.MapDataScenarioPressione