am = am || {};

am.MapDataScenarioLivelloMare = (function($){

    /**
     * @class MapDataScenarioLivelloMare
     * @extends MapDataScenarioSensore
     * ---
     * The concrete subclass of MapDataScenarioSensore to manage Pressione Level
     */
    function MapDataScenarioLivelloMare(options){
        
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
    MapDataScenarioLivelloMare.prototype = Object.create(MapDataScenarioSensore.prototype);
    MapDataScenarioLivelloMare.prototype.constructor = MapDataScenarioLivelloMare;
    
    MapDataScenarioLivelloMare.prototype.getSensorMarkerBackground= function(soglia1, soglia2, soglia3, ilValore) {
        var classe=' marker--sensor livellomare'
        return classe;
    }

    MapDataScenarioLivelloMare.prototype.normalizeValue = function(v){
        return v;
    }
  
    
    return MapDataScenarioLivelloMare;
})(jQuery);

// Global scope
var MapDataScenarioLivelloMare = am.MapDataScenarioLivelloMare