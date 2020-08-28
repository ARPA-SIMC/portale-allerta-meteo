am = am || {};

am.MapDataScenarioUmidita = (function($){

    /**
     * @class MapDataScenarioUmidita
     * @extends MapDataScenarioSensore
     * ---
     * The concrete subclass of MapDataScenarioSensore to manage Umidita Level
     */
    function MapDataScenarioUmidita(options){
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
    MapDataScenarioUmidita.prototype = Object.create(MapDataScenarioSensore.prototype);
    MapDataScenarioUmidita.prototype.constructor = MapDataScenarioUmidita;
    
    MapDataScenarioUmidita.prototype.getSensorMarkerBackground= function(soglia1, soglia2, soglia3, ilValore) {
        var classe=' marker--sensor umid'

        if (ilValore<=20) {classe2='_0'}
        else if (ilValore<=40) {classe2='_1'}
        else if (ilValore<=60) {classe2='_2'}
        else if (ilValore<=80) {classe2='_3'}
        else if (ilValore<=90) {classe2='_4'}
        else {classe2='_5'}

        return classe.concat(classe2)
    }

    MapDataScenarioUmidita.prototype.normalizeValue = function(v){
      return Math.round(v);
    }
  
    
    return MapDataScenarioUmidita;
})(jQuery);

// Global scope
var MapDataScenarioUmidita = am.MapDataScenarioUmidita