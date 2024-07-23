am = am || {};
am.MapDataServer = (function($){

/**
 * @class MapDataServer 
 * ---
 * Singleton Model object who takes care of:
 * - Ajax call
 * - creating url
 * - setup glogal variables
 * - get TERRITORY stuff
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
        'idrometrico': _root + '/api/allerta/get-last-images', //+'?q=idrometrico',
        // Precipitazioni @CHECKME
        'precipitazioni': _root + '/api/allerta/get-last-images',// +'?q=precipitazioni',
        
        'temperature': _root+'/api/allerta/get-last-images',
        'umidita': _root+'/api/allerta/get-last-images',
        'pressione': _root+'/api/allerta/get-last-images', //getsensorvaluesnotime
        'vento': _root+'/api/allerta/get-last-images',
        'vento-direzione': _root+'/api/allerta/get-last-images',
        
        // Querystring per i dati via jpg/base64
        'cumulata-6h':  _root + '/api/allerta/get-pioggia-cumulata-6',
        'cumulata-48h': _root + '/api/allerta/get-pioggia-cumulata-48', //_root+'?q=cumulata-48h',
        
        // Radar @CHECKME
        'radar': _root + '/api/allerta/get-all-radar-images', //_root + '/api/allerta/getlastimages' //+'?q=radar-getlastimages'    
        'nowcasting': _root + '/api/allerta/get-nowcasting'
    
    };

    // pivate method
    function _setupTerritoryAreas(){
        if( console ) console.log("[MapDataServer] Initializing TERRITORY areas" );

        var i=0, I=ER.features.length;
        for(;i<I;++i){
        //console.log(ER.features[i].properties.NOME+" sta in "+ER.features[i].properties.NOME_2);
        switch(ER.features[i].properties.NOME_2){
        case 'Emil-A':
            TERRITORY.A.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("A1") === 0)
            TERRITORY.A1.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("A2") === 0)
            TERRITORY.A2.push(ER.features[i].properties.NOME);
            break;
        case 'Emil-B':
            TERRITORY.B.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("B1") === 0)
            TERRITORY.B1.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("B2") === 0)
            TERRITORY.B1.push(ER.features[i].properties.NOME);
            break;
        case 'Emil-C':
            TERRITORY.C.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("C1") === 0)
            TERRITORY.C1.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("C2") === 0)
            TERRITORY.C2.push(ER.features[i].properties.NOME);
            break;
        case 'Emil-D':
            TERRITORY.D.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("D1") === 0)
            TERRITORY.D1.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("D2") === 0)
            TERRITORY.D2.push(ER.features[i].properties.NOME);
            break;
        case 'Emil-E':
            TERRITORY.E.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("E1") === 0)
            TERRITORY.E1.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("E2") === 0)
            TERRITORY.E2.push(ER.features[i].properties.NOME);
            break;
        case 'Emil-F':
            TERRITORY.F.push(ER.features[i].properties.NOME);
            break;
        case 'Emil-G':
            TERRITORY.G.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("G1") === 0)
            TERRITORY.G1.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("G2") === 0)
            TERRITORY.G2.push(ER.features[i].properties.NOME);
            break;
        case 'Emil-H':
            TERRITORY.H.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("H1") === 0)
            TERRITORY.H1.push(ER.features[i].properties.NOME);
            if( ER.features[i].properties.NOME_1 && ER.features[i].properties.NOME_1.indexOf("H2") === 0)
            TERRITORY.H2.push(ER.features[i].properties.NOME);
            break;
        }
        }
        
    }

    // Public API
    return {
        // Init method
        init: function(){
        // check if there is all the file we need
        if( ! ER || ! AreeIdro || !bacini || !reticolo){
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
                return AreeIdro;
                case 'bacini':
                return bacini;
                case 'reticolo':
                return reticolo;
                case 'regione':
                return regione_layer;
                case 'comuni':
                return ER;
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
        			url += '?variabile=254,0,0/1,-,-,-/B13215';
        			break;
        			
        		case 'pressione' :
        			url += '?variabile=254,0,0/1,-,-,-/B10004';
        			break;
        			
        		case 'umidita' :
        			url += '?variabile=254,0,0/103,2000,-,-/B13003';
        			break;
        			
        		case 'temperature' :
        			url += '?variabile=254,0,0/103,2000,-,-/B12101';
        			break;     
        			
        		case 'precipitazioni' :
        			url += '?variabile=1,0,3600/1,-,-,-/B13011';
        			break;
        			
        		case 'vento' :
        			url += '?variabile=254,0,0/103,10000,-,-/B11002';
        			break;
        			
        		case 'vento-direzione' :
        			url += '?variabile=254,0,0/103,10000,-,-/B11001';
        			break;              			
        	}
        	
        	if( queryParam && queryParam.ts)
        		queryParam.time = queryParam.ts;
        	
            var data = null;
            switch(what){
                
                case 'anim-mare':
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
        let n=null, a=null;
        if( TERRITORY.A1.indexOf(comune) > -1) {     n = 1; a = "A1"; }
        else if (TERRITORY.A2.indexOf(comune)> -1 ){ n = 2; a = "A2"; }
        else if (TERRITORY.B1.indexOf(comune)> -1 ){ n = 4; a = "B1"; }
        else if (TERRITORY.B2.indexOf(comune)> -1 ){ n = 5; a = "B2"; }
        else if (TERRITORY.C1.indexOf(comune)> -1 ){ n = 7; a = "C1"; }
        else if (TERRITORY.C2.indexOf(comune)> -1 ){ n = 8; a = "C2"; }
        else if (TERRITORY.D1.indexOf(comune)> -1 ){ n = 10; a = "D1"; }
        else if (TERRITORY.D2.indexOf(comune)> -1 ){ n = 11; a = "D2"; }
        else if (TERRITORY.E1.indexOf(comune)> -1 ){ n = 13; a = "E1"; }
        else if (TERRITORY.E2.indexOf(comune)> -1 ){ n = 14; a = "E2"; }
        else if (TERRITORY.F.indexOf(comune)> -1 ){  n = 15; a = "F"; }
        else if (TERRITORY.G1.indexOf(comune)> -1 ){ n = 17; a = "G1"; }
        else if (TERRITORY.G2.indexOf(comune)> -1 ){ n = 18; a = "G2"; }
        else if (TERRITORY.H1.indexOf(comune)> -1 ){ n = 20; a = "H1"; }
        else if (TERRITORY.H2.indexOf(comune)> -1 ){ n = 21; a = "H2"; }

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

            return "./comune.php?c="+name_comune+"&a="+fArea+"&l="+fLatlng;
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
var MapDataServer = am.MapDataServer;