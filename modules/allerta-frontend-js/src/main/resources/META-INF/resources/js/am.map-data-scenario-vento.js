am = am || {};

am.MapDataScenarioVento = (function($){

    /**
     * @class MapDataScenarioVento
     * @extends MapDataScenarioSensore
     * ---
     * The concrete subclass of MapDataScenarioSensore to manage Vento Level
     */
    function MapDataScenarioVento(options){
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
    MapDataScenarioVento.prototype = Object.create(MapDataScenarioSensore.prototype);
    MapDataScenarioVento.prototype.constructor = MapDataScenarioVento;
    
    MapDataScenarioVento.prototype.getSensorMarkerBackground= function(soglia1, soglia2, soglia3, ilValore) {
    	return ' marker--wind '
	}
	
	/**
     * Render the Wind scenario data on map. Called by renderTo and callable after each new query.
	 * For the Wind, we need two separate ajax call, one for wind velocity (the actual value) and one for the direction.
     * @method renderData
     */
    MapDataScenarioVento.prototype.renderData = function(dataValues, asyncUpdateCallback, queryParam){
		var tsLatest = dataValues[0].time;
		var ts = null; 

		if( tsLatest )
			ts = dataValues.shift().time;
		else
			ts = queryParam.ts;

        var vl, htm, cls, ic;

        // remove previous dataValues
        var i=0,I=this.dataLayers.length;
        for(;i<I;++i){
            this.map.removeLayer( this.dataLayers[i] ); 
        }
		this.dataLayers = [];
		
		// call again for wind direction
		var param = {
            ts: ts,
            latestAvailableTimeIsKnown: true
		};
		MapDataServer.query("vento-direzione", param, (function(dataDirections, asyncUpdateCallback){

			// Mapping wind values and wind directions
			for(var a = 0; a < dataDirections.length; a++)	
				dataDirections[dataDirections[a].idstazione] = dataDirections[a]
	
			// Loop on value and create sensor markers
			for(var a = 0; a < dataValues.length; a++) {
					
				if( dataDirections[ dataValues[a].idstazione ] ){ // just if we have the direction value

					htm = "<div class='divSVG'><svg style='overflow:visible;position:relative;top:-16px;left:-16px' xmlns='http://www.w3.org/2000/svg' version='1.1'>" 
						+ this.sventolaBarba(dataValues[a].value || 0, dataDirections[dataValues[a].idstazione].value || 0) 
						+ "</svg></div>"
					vl = dataValues[a].value;
					cls = ( (htm && htm !="0.0") || vl!==null 
							? this.getSensorMarkerBackground()
							: "marker--sensor nd");
	
					ic = L.divIcon({
						iconSize: this.getIconSize(),
						html: vl===null?'':htm,
						className: cls
					});
					
					var zindexCalculate = dataValues[a].ordinamento != 0 ? dataValues[a].ordinamento*100 :  (vl ? Math.ceil(vl) : 0);
					var mk = new L.marker(new L.LatLng(dataValues[a].lat/100000, dataValues[a].lon/100000), {
						icon: ic, 
						riseOnHover: true, 
						riseOffset: 10000, 
						title:dataValues[a].nomestaz, 
						zIndexOffset: zindexCalculate*-1
					});
	
					mk.bindPopup("<div id='map-popup--js-open-sensor-graph' data-request=\"" + dataValues[a].idstazione + "\">"+dataValues[a].idvariabile+"</div>");
					mk.addTo(this.map);
					this.dataLayers.push(mk);

				}
				
			}
		
			// Invoca callback (es. per lasciare a MapDataRender l'onere di piazzare la dataValues mostrata sulla mappa (if any))
			if( asyncUpdateCallback instanceof Function){
				asyncUpdateCallback( dataValues, this.formatUpdateDatetime(ts) );
			} else if( console ) console.log("[MapDataScenarioVento:renderTo] Cannot call the asyncUpdateCallback: it's not a function. Skipping!");
		
		}).bind(this), asyncUpdateCallback);
    
	};
	

    MapDataScenarioVento.prototype.normalizeValue = function(v){
        return null;
	}
	
    MapDataScenarioVento.prototype.getIconSize = function(){
        return [32, 32]; 
	}
	
	/**
	 * Draw the wind SVG
	 * @method sventolaBarba
	 */
	MapDataScenarioVento.prototype.sventolaBarba = function(velocita, direzione){
		let colore, 
			scale, 
			nodi,
			lAltezza,
			triangoli,
			lineaCorta,
			lineeLunghe,
			resto,
			offset;

		if (velocita<0.3) {colore="#CCCCCC"; scale='.3'}
		else if (velocita<1.6) {colore="#00FFFF"; scale='.4'}
		else if (velocita<3.4) {colore="#1CB8A5"; scale='.5'}
		else if (velocita<5.5) {colore="#00FF00"; scale='.6'}
		else if (velocita<8) {colore="#6BA531"; scale='.65'}
		else if (velocita<10.8) {colore="#008C30"; scale='.7'}
		else if (velocita<13.9) {colore="#FF0000"; scale='.75'}
		else if (velocita<17.2) {colore="#FF7F00"; scale='.8'}
		else if (velocita<20.8) {colore="#FFFF00"; scale='.85'}
		else if (velocita<24.5) {colore="#BF9213"; scale='.9'}
		else if (velocita<28.5) {colore="#FF00FF"; scale='.95'}
		else if (velocita<32.7) {colore="#7A11B2"; scale='1'}
		else  {colore="#0000FF"; scale='1'}
		
		nodi=Math.round(velocita*1.94254);
	
		if (nodi < 1) {
			return "<circle cx='32' cy='32' r='3' stroke='#CCCCCC' /><circle cx='32' cy='32' r='5' fill='none' stroke='black' stroke-width='1' />";
		} else {
			var theSVG="<g transform='rotate("+direzione+ " 32 32)'><line x1='32' y1='7' x2='32' y2='32' style='stroke: black; stroke-width:2' /><circle cx='32' cy='32' r='5' fill='"+colore+"' fill-opacity='.5' stroke='black' stroke-width='2' />"
	
			lAltezza=7;
	
			triangoli=0;
			lineaCorta=0;
	
			lineeLunghe=Math.floor(nodi/10);
			resto=nodi-(lineeLunghe*10);
	
			if ((resto >= 3) && (resto<=7)) {
				lineaCorta=1;
			}
	
			if (resto >= 8)  {
				lineeLunghe++
			}
	
			triangoli=Math.floor(lineeLunghe/5);
			lineeLunghe=lineeLunghe-(triangoli*5);
	
			//disegnamo i triangoli
			for (i=0; i<triangoli; i++) {
				theSVG=theSVG+"<polygon fill='black'  points='32,"+(lAltezza+(i*7))+" 42,"+(lAltezza+(i*7)+3)+" 32,"+(lAltezza+(i*7)+6)+"' />"
			}
			lAltezza=lAltezza+(8*(triangoli))
	
			//disegnamo le linee lunghe
			for (i=0; i<lineeLunghe; i++) {
					theSVG=theSVG+ "<g transform='rotate(-17 32 "+(lAltezza+(i*2.5))+")'><line x1='32' y1='"+(lAltezza+(i*2.5))+"' x2='42' y2='"+(lAltezza+(i*2.5))+"' style='stroke:black;stroke-width:2;' /></g>";
	
			}
			lAltezza=lAltezza+(2.5*(lineeLunghe-1));
			//
	
			offset=(lineeLunghe==0)?3:0;
	
			//disegnamo le linee corte
			lAltezza=lAltezza+3+offset;
			for (i=0; i<lineaCorta; i++) {
				theSVG=theSVG+ "<g transform='rotate(-17 32 "+(lAltezza+(i*2.5))+")'><line x1='32' y1='"+(lAltezza+(i*2.5))+"' x2='39' y2='"+(lAltezza+(i*2.5))+"' style='stroke:black;stroke-width:1.5;' /></g>";
			}
	
	
	
			/*if (Rvelocita>0) {
				return theSVG+"</g><g transform='translate(32,48)'><ellipse cx='0' cy='-4' ry='7' rx='16' style='fill:#666; opacity: .5' /><text class='laRaff' font-weight='bold' fill='#FFF' text-anchor='middle'>"+Rvelocita+"</text></g></svg></div>"
			} else {*/
				return theSVG+"</g>";
			//}
		}
	}

    
  
    
    return MapDataScenarioVento;
})(jQuery);

// Global scope
var MapDataScenarioVento = am.MapDataScenarioVento




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