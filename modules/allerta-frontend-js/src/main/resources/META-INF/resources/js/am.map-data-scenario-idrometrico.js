am = am || {};

am.MapDataScenarioIdrometrico = (function($){

    /**
     * @class MapDataScenarioIdrometrico
     * @extends MapDataScenarioSensore
     * ---
     * The concrete subclass of MapDataScenarioSesnore to manage Idrometric Level
     */
    function MapDataScenarioIdrometrico(options){
        // force settings
        if( options.baseLayers ){
          options.baseLayers = {};
          options.baseLayers.bacini = true;
          options.baseLayers.reticolo = true;
          options.baseLayers.regione = false;
        }
        // Call constructor of superclass to initialize superclass-derived members.
        MapDataScenarioSensore.call(this, options); 
        this.timespan.step = 15;
    }
    // Inherit from MapDataScenario
    MapDataScenarioIdrometrico.prototype = Object.create(MapDataScenarioSensore.prototype);
    MapDataScenarioIdrometrico.prototype.constructor = MapDataScenarioIdrometrico;
    
    MapDataScenarioIdrometrico.prototype.getSensorMarkerBackground= function(soglia1, soglia2, soglia3, ilValore) {
        var classe=' marker--sensor idro'
        if(soglia1 ==0 && soglia2 == 0 && soglia3 == 0)
           classe2='_ns';
        else if(ilValore>soglia3 && soglia3!=0)
            classe2='_3';
        else if(ilValore>soglia2 && soglia2!=0)
          classe2='_2';
        else if(ilValore>soglia1 && soglia1!=0)
          classe2='_1';
        else
          classe2='_0'
        return classe.concat(classe2);
    }

    
  
    
    return MapDataScenarioIdrometrico;
})(jQuery);

// Global scope
var MapDataScenarioIdrometrico = am.MapDataScenarioIdrometrico