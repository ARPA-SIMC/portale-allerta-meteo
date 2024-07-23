am = am || {};

am.MapDataScenarioPrecipitazioni = (function($) {

	/**
	 * @class MapDataScenarioPrecipitazioni
	 * @extends MapDataScenarioSensore --- The concrete subclass of
	 *          MapDataScenarioSensore to manage Precipitazioni Level
	 */
	function MapDataScenarioPrecipitazioni(options) {
		// force settings
		if (options.baseLayers) {
			options.baseLayers = {};
			options.baseLayers.bacini = true;
			options.baseLayers.reticolo = true;
			options.baseLayers.regione = false;
		}

		// Call constructor of superclass to initialize superclass-derived
		// members.
		MapDataScenarioSensore.call(this, options);
		this.timespan.step = 15;

	}
	// Inherit from MapDataScenario
	MapDataScenarioPrecipitazioni.prototype = Object
			.create(MapDataScenarioSensore.prototype);
	MapDataScenarioPrecipitazioni.prototype.constructor = MapDataScenarioPrecipitazioni;

	MapDataScenarioPrecipitazioni.prototype.getSensorMarkerBackground = function(
			soglia1, soglia2, soglia3, ilValore) {
		var classe = ' marker--sensor preci'

		if (ilValore <= .5) {
			classe2 = '_0'
		} else if (ilValore <= 1) {
			classe2 = '_1'
		} else if (ilValore <= 2) {
			classe2 = '_2'
		} else if (ilValore <= 5) {
			classe2 = '_3'
		} else if (ilValore <= 10) {
			classe2 = '_4'
		} else if (ilValore <= 20) {
			classe2 = '_5'
		} else if (ilValore <= 30) {
			classe2 = '_6'
		} else if (ilValore <= 50) {
			classe2 = '_7'
		} else if (ilValore <= 70) {
			classe2 = '_8'
		} else if (ilValore <= 100) {
			classe2 = '_9'
		} else if (ilValore <= 150) {
			classe2 = '_10'
		} else {
			classe2 = '_11'
		}

		return classe.concat(classe2);
	}

	MapDataScenarioPrecipitazioni.prototype.normalizeValue = function(v) {
		v = Math.round((v) * 10) / 10;
		if (!isNaN(v))
			v = v.toFixed(1)
		return v;
	}

	return MapDataScenarioPrecipitazioni;
})(jQuery);

// Global scope
var MapDataScenarioPrecipitazioni = am.MapDataScenarioPrecipitazioni