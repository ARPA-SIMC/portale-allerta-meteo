am = am || {};

am.MapDataScenarioDirezioneOnda = (function($){

    /**
     * @class MapDataScenarioDirezioneOnda
     * @extends MapDataScenarioSensore
     * ---
     * The concrete subclass of MapDataScenarioSensore to manage Pressione Level
     */
    function MapDataScenarioDirezioneOnda(options){
        
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
    MapDataScenarioDirezioneOnda.prototype = Object.create(MapDataScenarioSensore.prototype);
    MapDataScenarioDirezioneOnda.prototype.constructor = MapDataScenarioDirezioneOnda;
    
    MapDataScenarioDirezioneOnda.prototype.getSensorMarkerBackground= function(soglia1, soglia2, soglia3, ilValore) {
        var classe=' marker--sensor livellomare'
        return classe;
    }

    MapDataScenarioDirezioneOnda.prototype.normalizeValue = function(v){
        return v;
    }
  
    
    return MapDataScenarioDirezioneOnda;
})(jQuery);

// Global scope
var MapDataScenarioDirezioneOnda = am.MapDataScenarioDirezioneOnda