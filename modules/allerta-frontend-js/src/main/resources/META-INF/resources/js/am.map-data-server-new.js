am = am || {};
am.MapDataServer2 = (function($){

/**
 * @class MapDataServer 
 * ---
 * Singleton Model object who takes care of:
 * - Ajax call
 * - creating url
 * - setup glogal variables
 * - get TERRITORY2 stuff
 * - 
 * 
 */
const MapDataServer = (function(){

    // semaphore (just init one time)
    var _initialized = false;


    // default REST urls (change this for integration)
    var _root = location.protocol + "//" + location.hostname + ":"+location.port+"/o";
    var _urls = {
        // Oggi // Originale: api/jsonws/allerta-sb-portlet.allerta/get-stato-allerta
        'get-stato-allerta': _root + '/api/allerta/get-stato-allerta', //'?q=get-stato-allerta', 
        // Domani // Originale: api/jsonws/allerta-sb-portlet.allerta/get-stato-allerta-domani
        'get-stato-allerta-domani': _root + '/api/allerta/get-stato-allerta-domani', //'?q=get-stato-allerta-domani',
        // Monitoraggio? Boh @FIXME, originale: /api/jsonws/bollettino-sb-portlet.bollettino/get-allarmi
        'get-allarmi': _root + '/api/allerta/get-allarmi', //+'?q=get-allarmi',

        // Idrometri @CHECKME
        'idrometrico': _root + '/api/allerta/get-sensor-values', //+'?q=idrometrico',
        // Precipitazioni @CHECKME
        'precipitazioni': _root + '/api/allerta/get-sensor-values',// +'?q=precipitazioni',
        
        'temperature': _root+'/api/allerta/get-sensor-values',
        'umidita': _root+'/api/allerta/get-sensor-values',
        'pressione': _root+'/api/allerta/get-sensor-values', //getsensorvaluesnotime
        'vento': _root+'/api/allerta/get-sensor-values',
        'vento-direzione': _root+'/api/allerta/get-sensor-values',
        'altezzaonda': _root+'/api/allerta/get-sensor-values',
        'direzioneonda': _root+'/api/allerta/get-sensor-values',
        'livellomare': _root+'/api/allerta/get-sensor-values',
        
        // Querystring per i dati via jpg/base64
        'cumulata-6h':  _root + '/api/allerta/get-pioggia-cumulata-6',
        'cumulata-24h':  _root + '/api/allerta/get-pioggia-cumulata-24',
        'cumulata-48h': _root + '/api/allerta/get-pioggia-cumulata-48', //_root+'?q=cumulata-48h',
        
        // Radar @CHECKME
        'radar': _root + '/api/allerta/get-all-radar-images', //_root + '/api/allerta/getlastimages' //+'?q=radar-getlastimages'    
        'nowcasting': _root + '/api/allerta/get-nowcasting',
        
        'animeteo-preci': _root + '/api/allerta/get-all-animeteo-preci',
        'animeteo-nuv': _root + '/api/allerta/get-all-animeteo-nuv',
        'animeteo-wind': _root + '/api/allerta/get-all-animeteo-wind',
        'animeteo-mare': _root + '/api/allerta/get-altezza-onda',
        'animeteo-swanita': _root + '/api/allerta/get-altezza-onda-swanita',
        'animeteo-adriac': _root + '/api/allerta/get-altezza-onda-adriac'
    };

    // pivate method
    function _setupTerritoryAreas(){
        if( console ) console.log("[MapDataServer] Initializing TERRITORY2 areas" );

        var i=0, I=ER2.features.length;
        for(;i<I;++i){
        	console.log(ER2.features[i].properties.NOME+" sta in "+ER2.features[i].properties.NOME_1);
        	TERRITORY2[ER2.features[i].properties.NOME_1].push(ER2.features[i].properties.NOME);
        	if (ER2.features[i].properties.VALANGHE)
        		TERRITORY2[ER2.features[i].properties.VALANGHE].push(ER2.features[i].properties.NOME);
        }
        
    }

    // Public API
    return {
        // Init method
        init: function(){
        // check if there is all the file we need
        if( ! ER || ! AreeIdro2 || !bacini || !reticolo){
            throw "[MapServer::init] Error: some geo data file is missing!";
        }
        if( !_initialized ){
            // fill territory global object
            _setupTerritoryAreas();
        }
        
        },
        // get some layer data. Nota: ritorna le variabili globali in cui ci sono i JSON di default
        getLayer: function(what){
            switch(what.toLowerCase()){
                case 'areeallertamento':
                return AreeIdro2;
                case 'bacini':
                return bacini;
                case 'reticolo':
                return reticolo;
                case 'regione':
                return regione_layer;
                case 'comuni':
                return ER2;
            }
        },
        /**
         * Query the server for data
         * @param {String} what The code of what you need, @fixme
         * @param {Any} queryParam The parameters, relating on "what" parameter @fixme
         * @param {Function} callback The callback closure to call when the server responds. It will be call with three parameters 
         *  (i) data returned by the server
         *  (ii) the callbackArgs 
         *  (iii) the queryParam object passed in
         * @param {Any} callbackArgs Arguments to pass to callback. 
         
         */
        query: function(what, queryParam, callback, callbackArgs){
            /*
            // Original Code
            if(opt.scenarioId == 1) 					
                url = root + "api/jsonws/allerta-sb-portlet.allerta/get-stato-allerta-domani";
            else if(opt.scenarioId == 3) 	 
                url 	= root + "/api/jsonws/bollettino-sb-portlet.bollettino/get-allarmi"
            else
                url = root + "api/jsonws/allerta-sb-portlet.allerta/get-stato-allerta";
            */
        	
        	var url = _urls[what];

        	switch(what) {
        	
        		case 'idrometrico' :
        			if( !queryParam.latestAvailableTimeIsKnown)
        				url += '-no-time';
        			url += '?variabile=254,0,0/1,-,-,-/B13215';
        			break;
        			
        		case 'pressione' :
        			if( !queryParam.latestAvailableTimeIsKnown)
        				url += '-no-time';
        			url += '?variabile=254,0,0/1,-,-,-/B10004';
        			break;
        			
        		case 'livellomare' :
        			if( !queryParam.latestAvailableTimeIsKnown)
        				url += '-no-time';
        			url += '?variabile=254,0,0/101,-,-,-/B22037';
        			break;
        			
        		case 'altezzaonda' :
        			if( !queryParam.latestAvailableTimeIsKnown)
        				url += '-no-time';
        			url += '?variabile=0,0,1800/1,-,-,-/M00002';
        			break;
        			
        		case 'direzioneonda' :
        			if( !queryParam.latestAvailableTimeIsKnown)
        				url += '-no-time';
        			url += '?variabile=200,0,1800/1,-,-,-/M00001';
        			break;
        			
        		case 'umidita' :
        			if( !queryParam.latestAvailableTimeIsKnown)
        				url += '-no-time';
        			url += '?variabile=254,0,0/103,2000,-,-/B13003';
        			break;
        			
        		case 'temperature' :
        			if( !queryParam.latestAvailableTimeIsKnown)
        				url += '-no-time';
        			url += '?variabile=254,0,0/103,2000,-,-/B12101';
        			break;     
        			
        		case 'precipitazioni' :
        			if( !queryParam.latestAvailableTimeIsKnown)
        				url += '-no-time';
        			url += '?variabile=1,0,3600/1,-,-,-/B13011';
        			break;
        			
        		case 'vento' :
        			if( !queryParam.latestAvailableTimeIsKnown)
        				url += '-no-time';
        			url += '?variabile=254,0,0/103,10000,-,-/B11002';
        			break;
        			
        		case 'vento-direzione' :
        			if( !queryParam.latestAvailableTimeIsKnown)
        				url += '-no-time';
        			url += '?variabile=254,0,0/103,10000,-,-/B11001';
        			break;              			
        	}
        	
        	if( queryParam && queryParam.ts) {
        		queryParam.time = queryParam.ts;
        		url += '&time=' + queryParam.time ;
        	}
        	
            var data = null;
            switch(what){
                
                case 'anim-mare':
                case 'swanita':
                case 'adriac':
                    if( altezzaOndaImg ){
                        callback(altezzaOndaImg, callbackArgs, queryParam)
                    } else {
                        if( console )
                            console.error('[MapDataServer] Error in retrieving data: "'+what+'" should be defined in tha pages, but they are not!"');
                    }
                    break;
                default: // ajax call

                    // Call server
                    $.ajax({
                        url: url,
                        data: queryParam,
                        dataType : "json",
                        contentType: "application/json; charset=utf-8",
                        success: action = function(data) {
                            callback(data, callbackArgs, queryParam)
                        },
                        error: function (error) {
                            alert('[MapDataServer] Error in calling the server: ' + eval(error));
                        }
                    });
            }
        },
        /**
         * Get the area details by Comune's name
         * @param {String} comune The name of the Comune
         * @returns {Object} An object like { index: 1, label: "A1" }
         */
        getAreaOfComune: function(comune){
        	
        	var x = ["A1","A2","B1","B2","C1","C2","D1","D2","D3","E1","E2",
        			"F1","F2","F3","G1","G2","H1","H2"]
        	
        	var k;
        	
        	let n=null, a=null;
            if (TERRITORY2.A1.length==0) _setupTerritoryAreas();
        	
        	for (k=0; k<x.length; k++)
        		if (TERRITORY2[x[k]].indexOf(comune) > -1) {
        			n = k;
        			a = x[k];
        		}
        	
        
        

        return{ index: n, label: a };
        },
        
        getAreaValangheOfComune: function(comune) {
        	var x = ["V1","V2","V3"]
    	
    	var k;
    	
    	let n=null, a=null;
        if (TERRITORY2.V1.length==0) _setupTerritoryAreas();
    	
    	for (k=0; k<x.length; k++)
    		if (TERRITORY2[x[k]].indexOf(comune) > -1) {
    			n = 18+k;
    			a = x[k];
    		}
    	
    
    

    	return{ index: n, label: a };
        },
        
        /**
         * Return the correct url for the page of Comune passed in
         * @param {String} fName Name of the Comune
         * @param {String} fArea The area's name of the Comune
         * @param {String} fLatLng The coords as string in the form lat|lng
         */
        getComunePageUrl: function(fName, fArea, fLatlng) {
            // Valeriano, modifico l stringa di puntamneto al singolo luogo 
            var url_weballerte = fName.replace(/[&\/\\#,+()$~%.":*?<>{}]/g, '').replace(/['\s]/g, "-").toLowerCase(); 
            var name_comune = fName.replace(/[&\/\\#,+()$~%.'":*?<>{}]/g, '').replace(/\s/g, "").toUpperCase();
            // return '/web/'+url_weballerte+'/';
            url_weballerte = url_weballerte.replace('sant-agata-bolognese','santagata-bolognese')
            url_weballerte = url_weballerte.replace('forlì','forli')
            return "/web/"+url_weballerte+"/home";
            //return "/web/"+name_comune+"/home?a="+fArea+"&l="+fLatlng;
        },

        /**
         * Return the correct API to call for the specified sensor graph API
         * @return {String} The correct base url
         */
        getSensorGraphApiUrl: function(key){
            return SENSOR_GRAPH_URL_PREFIX+SENSOR_GRAPH_URL_SUFFIX[key];
        }
    }
})();
  
  
return MapDataServer;
})(jQuery);
// Global Scope
var MapDataServer2 = am.MapDataServer2;