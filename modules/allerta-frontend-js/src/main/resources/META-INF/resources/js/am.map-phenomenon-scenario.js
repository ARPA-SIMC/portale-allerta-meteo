am = am || {};

am.MapPhenomenonScenario = (function($){


    /**
     * MapScenario
     * ---
     * Setup data for a scenario that needs to be shown on forecast map. 
     * Each Phenomen has its own MapScenario. Also the "general" is a MapScenario.
     * It exposes getters to make the map's interaction code clearer
     * 
     * Options parameters:
     * @param {String} id The id of this scenario
    */
    function MapPhenomenonScenario(options){
        this.id = options.id;
        this.scenario = [ [], [], [], [], [] ];
        this.accessibilita = {}; // usato come array associativo
        this.maxRiskLevel = 0; // max risk level, viene aggiornato nel setup della ForecastMap::initScenarios
    }
    MapPhenomenonScenario.prototype.addComuniToLevel = function(comuni, level){
        if(! $.isArray(comuni)){
        comuni = [comuni];
        }
        this.scenario[level] = this.scenario[level].concat(comuni);
    }
    MapPhenomenonScenario.prototype.getComuneLevel = function(comune){
        for(var i=4;i>=0;--i){
        if( this.scenario[i].indexOf(comune) > -1 )
            return i;
        }
        return 0;
    }
    MapPhenomenonScenario.prototype.setAccessibilityLevelForArea = function(areaName, level){
        this.accessibilita[areaName] = level;
    }
    MapPhenomenonScenario.prototype.getAccessibilityLevelForArea = function(areaName){
        return this.accessibilita[areaName];
    }
    MapPhenomenonScenario.prototype.getAccessibilityAlertLevels = function(areaName){
        return this.accessibilita;
    }
    MapPhenomenonScenario.prototype.getMaxRiskLevel = function(){
        return this.maxRiskLevel;
    }
    MapPhenomenonScenario.prototype.setMaxRiskLevel = function(r){
        this.maxRiskLevel = r;
    }
    

    return MapPhenomenonScenario;
})(jQuery);

// Global scope
var MapPhenomenonScenario = am.MapPhenomenonScenario