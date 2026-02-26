am = am || {};

am.MapDataScenarioTemperature = (function($){

    /**
     * @class MapDataScenarioTemperature
     * @extends MapDataScenarioSensore
     * ---
     * The concrete subclass of MapDataScenarioSensore to manage Precipitazioni Level
     */
    function MapDataScenarioTemperature(options){
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
    MapDataScenarioTemperature.prototype = Object.create(MapDataScenarioSensore.prototype);
    MapDataScenarioTemperature.prototype.constructor = MapDataScenarioTemperature;
    
    MapDataScenarioTemperature.prototype.getSensorMarkerBackground= function(soglia1, soglia2, soglia3, ilValore) {
        var classe=' marker--sensor temp'

        if (ilValore >= 40) {
            return classe.concat('_p40')
        } else if (ilValore <= -20) {
            return classe.concat('_p-20')
        } else if (Math.floor(ilValore)%2) {
            return  classe+'_p'.concat(Math.floor(ilValore-1))
        } else {
            return  classe+'_p'.concat(Math.floor(ilValore))
        }   
    }
    MapDataScenarioTemperature.prototype.normalizeValue = function(v){
        if(v == null)
            v = "";
        else {
            v-=273.15;
            v=Math.round((v)*10)/10;
        }
        return v;
    }
    
  
    
    return MapDataScenarioTemperature;
})(jQuery);

// Global scope
var MapDataScenarioTemperature = am.MapDataScenarioTemperature




/* 

case 'B12101': //temperatura
		if(value.v == null)
			ilValore = ""
		else {
			ilValore=value.v-273.15;
			ilValore=Math.round((ilValore)*10)/10;
		}
		break;
	case 'B12030':
		ilValore=value.v-273.15;
		ilValore=Math.round((ilValore)*10)/10;
		break;
	case 'B10004': // Pressione
		ilValore=value.v/100;
		ilValore=Math.round(ilValore);
		break;
	case 'B13215': //livello idro
		ilValore=value.v;
		ilValore=ilValore && ilValore.toFixed(2);

		break;
	case 'B13011': // precipitazioni
		ilValore=value.v;
		ilValore=Math.round((ilValore)*10)/10;
		if(!isNaN(ilValore))
			ilValore = ilValore.toFixed(1)
		break;
	case 'B14198':
		ilValore=value.v;
		ilValore=(ilValore<0)?0:Math.round((ilValore)*10)/10;
		break;

	case 'B11001': //velocit� del vento
		ilValore=value.v;
		ilValore=(ilValore<0)?0:Math.round((ilValore)*10)/10;
		break;
	case 'B13013': //neve
		ilValore=value.v;
		ilValore=(ilValore<0)?0:Math.round(ilValore*10)/10;
		break;

	default:
		ilValore=Math.round(value.v);
	}







*/