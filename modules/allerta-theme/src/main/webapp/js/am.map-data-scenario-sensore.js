am = am || {};

am.MapDataScenarioSensore = (function($){

    /**
     * @class MapDataScenarioSensore
     * @extends MapDataScenarioSensore
     * ---
     * The concrete subclass of MapDataScenario to manage common features for all sensors (idrometrico, precipitazione, pressione, temperatura, umidita)
     */
    function MapDataScenarioSensore(options){
        // Call constructor of superclass to initialize superclass-derived members.
        MapDataScenario.call(this, options); 
    
        this.baseLayers.bacini = null;
        this.baseLayers.reticolo = null;
    
    
        // Setup time span for animation or date filter selection (on map toolbar)
        this.timespan = {
            min: moment().subtract(5,'days'),
            max: moment().add(1,'days'),
        };
    }
    // Inherit from MapDataScenario
    MapDataScenarioSensore.prototype = Object.create(MapDataScenario.prototype);
    MapDataScenarioSensore.prototype.constructor = MapDataScenarioSensore;
    MapDataScenarioSensore.prototype.normalizeValue = function(v){
        return v && v.toFixed(2);
    }
    MapDataScenarioSensore.prototype.renderTo = function(map, asyncUpdateCallback){
        if( console)  console.log("[MapDataScenarioSensore.renderTo] Sto per essere aggiunto alla mappa o refreshato");
    
        if( map )
         this.map = map;
    
        // if I should render my base layers
        if( this.options.baseLayers ){

            if( typeof this.options.baseLayers === "boolean" ){
                this.options.baseLayers = {
                    bacini: true,
                    reticolo: true,
                    regione: true
                }
            }

            // add bacini ==> aka lands!
            if( this.options.baseLayers.bacini && !this.baseLayers.bacini )
                this.baseLayers.bacini = MapDataScenarioFactory.getBaseLayerAsLeafletGeoJson('bacini'); 

            if( this.baseLayers.bacini)
                this.baseLayers.bacini.addTo(this.map);
            
            // add reticolo ==> aka rivers!
            if( this.options.baseLayers.reticolo && !this.baseLayers.reticolo )
                this.baseLayers.reticolo = MapDataScenarioFactory.getBaseLayerAsLeafletGeoJson('reticolo');

            if ( this.baseLayers.reticolo)
                this.baseLayers.reticolo.addTo(this.map);

            // add reticolo ==> aka region bounds!
            if( this.options.baseLayers.regione && !this.baseLayers.regione )
                this.baseLayers.regione = MapDataScenarioFactory.getBaseLayerAsLeafletGeoJson('regione');

            if ( this.baseLayers.regione)
                this.baseLayers.regione.addTo(this.map);

        }
    
        // Chiedo i dati aggiornati
        var param = {
            ts: this.getTimestamp(),
            latestAvailableTimeIsKnown: false
        }; //@fixme eventuali parametri
        this.query(param, this.renderData.bind(this), asyncUpdateCallback);

        // attach map popup to open graph sensors
    	this.map.on('popupopen', (function(e){
            if( $('#map-popup--js-open-sensor-graph').length ){ // only if it's the popup to open a sensor graph
                var id= $('#map-popup--js-open-sensor-graph').attr('data-request');
                var variabile = $('#map-popup--js-open-sensor-graph')[0].innerHTML;
                this.openSensorGraph(id, variabile);
            }
        }).bind(this));
    
    }
    
    /**
     * Render this scenario data on map. Called by renderTo and callable after each new query
     * @method renderData
     */
    MapDataScenarioSensore.prototype.renderData = function(data, asyncUpdateCallback){
        var tsOriginal = data[0].time;
        var ts = data.shift().time;
        var vl, htm, cls, ic;

        // remove previous data
        var i=0,I=this.dataLayers.length;
        for(;i<I;++i){
            this.map.removeLayer( this.dataLayers[i] ); 
        }
        this.dataLayers = [];

        // Renderizza i vari sensori
        for(var a = 0; a < data.length; a++) {
        
            htm = this.getMarkerHTML(data[a]); 
            vl = data[a].value;
            cls = '' //'myDivIcon ' 
                + ( (htm && htm !="0.0") || vl!==null 
                    ? this.getSensorMarkerBackground( data[a].soglia1, data[a].soglia2, data[a].soglia3, htm ) + ' _'+3600 
                    : "marker--sensor nd");
        
            ic = L.divIcon({
                iconSize: this.getIconSize(),
                html: vl===null?'':htm,
                className: cls
            });
            
            var zindexCalculate = data[a].ordinamento != 0 ? data[a].ordinamento*100 :  (vl ? Math.ceil(vl) : 0);
            var mk = new L.marker(new L.LatLng(data[a].lat/100000, data[a].lon/100000), {
                icon: ic, 
                riseOnHover: true, 
                riseOffset: 10000, 
                title:data[a].nomestaz, 
                zIndexOffset: zindexCalculate*-1
            });
        
            mk.bindPopup("<div id='map-popup--js-open-sensor-graph' data-request=\"" + data[a].idstazione + "\"></div>");
            mk.addTo(this.map);
            this.dataLayers.push(mk);
        }
        
        //this.map.addLayer( this.dataLayers ); 
        

        // Invoca callback (es. per lasciare a MapDataRender l'onere di piazzare la data mostrata sulla mappa (if any))
        if( asyncUpdateCallback instanceof Function){
            asyncUpdateCallback( data, this.formatUpdateDatetime(ts) );
        } else if( console ) console.log("[MapDataScenarioSensore:renderTo] Cannot call the asyncUpdateCallback: it's not a function. Skipping!");
    
    };
    
    MapDataScenarioSensore.prototype.unrenderFrom = function(map, justData){
        if( map )
           this.map = map;
    
        if( console)  console.log("[MapDataScenarioSensore.unrenderFrom] Sto per essere tolto dalla mappa o refreshato");
    
        // Remove all data layers
        var i=0,I=this.dataLayers.length;
        for(;i<I;++i){
            this.map.removeLayer( this.dataLayers[i] ); 
        }
    
        // Remove base layers (if any)
        // bacini ==> means lands!
        if( !justData ){
            if( this.baseLayers.bacini )
                this.map.removeLayer( this.baseLayers.bacini );
            if( this.baseLayers.reticolo )
                this.map.removeLayer( this.baseLayers.reticolo );
        }
        
    }
   
 
    /**
     * Opens the detailed graph for a sensor
     */
    MapDataScenarioSensore.prototype.openSensorGraph = function(id, variabile) {
        this.map.closePopup();

        var variabile = SENSOR_KEY_MAP[this.key];

        var width = 980;
        var height = 700;
        var left = parseInt((screen.availWidth/2) - (width/2))
        var top = parseInt((screen.availHeight/2) - (height/2))
    
        var windowsFeatures = "width="+width+",height="+height+",status,resizable,left="+left+",top="+top+",screenX="+left+",screenY="+top+",scrollbars=yes";

        if( this.key == 'precipitazionixx' ){ // Precipitazioni
            window.open(MapDataServer.getSensorGraphApiUrl(this.key) + "&r=" + id + "/" + variabile + "/" + moment().subtract(2, 'days').format("YYYY-MM-DD") + "/" + moment().format("YYYY-MM-DD") +
                    "&stazione=" + id + "&variabile="+ variabile		
                    , 'myWin', windowsFeatures)
        } else { // TUTTO IL RESTO @CHECKME
        	
        	popUpUrl = graficoUrl + "&r=" + id + "/" + variabile + "/" + moment().subtract(2, 'days').format("YYYY-MM-DD") + "/" + moment().format("YYYY-MM-DD") +
            "&stazione=" + id + "&variabile="+ variabile;
        	
        	console.log( popUpUrl);

            window.open( popUpUrl, 'myWin', windowsFeatures);
        	//popUpMaxed(popUpUrl);
            
        	/*
            window.open(MapDataServer.getSensorGraphApiUrl(this.key) + "&r=" + id + "/" + variabile + "/" + moment().subtract(2, 'days').format("YYYY-MM-DD") + "/" + moment().format("YYYY-MM-DD") +
                    "&stazione=" + id + "&variabile="+ variabile		
                    , 'myWin', windowsFeatures)*/
        }
    
    }

    /**
     * Returns CSS classes to skin the sensor's marker background
     * @method getSensorMarkerBackground 
     */
    MapDataScenarioSensore.prototype.getSensorMarkerBackground = function(soglia1, soglia2, soglia3, ilValore) {
        throw "[MapDataScenarioSensore:getSensorMarkerBackground] Abstract method: sublcass has no implementation, check it please!"
    }

    /**
     * Returns an Array<Number> with the marker icon size
     * @method getIconSize 
     */
    MapDataScenarioSensore.prototype.getIconSize = function(){
        return [36, 14]; // default, all but wind
    }
    /**
     * Returns the HTML (or simple text) to be but in the marker
     * @method getMarkerHTML 
     */
    MapDataScenarioSensore.prototype.getMarkerHTML = function(item){
        return this.normalizeValue(item.value);  // default, all but wind
    }

    

    /**
     * @fixme Questo è solo un esempio, perché gli idrometri non hanno un'animazione
     * 
     * Render the slides for this scenario to be animated depending on the input parameters
     * @method renderSlidesForAnimation
     * @param {Swiper} wheelSwiper The instance of swiper where to put the new slide
     * @param {Number} hours Hours to animate
     * @param {Number} step The animation step size
     * @param {Boolean} future True if we animate the future, false if the past.
     */
    MapDataScenarioSensore.prototype.renderSlidesForAnimation = function(wheelSwiper, hours, step, future){
        var label = "";
        var i=0, I = hours * (60/step); // default step of 15minutes
        var now =  moment(); //.format("DD/MM/YYYY HH:mm");
        var start = now.subtract(hours,"h");
        var unit = "m";
        
        for(;i<I;++i){
            
            if( future ){
                label = start.add( step, unit).format(RT_DATA_DATE_LABEL_FORMAT);
                wheelSwiper.appendSlide('<div class="swiper-slide"><a href="#" data-val="'+label+'" data-slide="'+(this.wheelSwiper.activeIndex+i)+'">'+label+'</a></div>');
            } else {
                label = start.subtract( step, unit).format(RT_DATA_DATE_LABEL_FORMAT);
                wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="'+label+'" data-slide="'+(I-i-1)+'">'+label+'</a></div>');
            }
        }
    }

    /**
     * Overloading: sensors are searchable
     * @method isDataSearchable
     * @return {Boolean}
     */
    MapDataScenarioSensore.prototype.isDataSearchable = function(){
        return true;
    }
    

    return MapDataScenarioSensore;
})(jQuery);

// Global scope
var MapDataScenarioSensore = am.MapDataScenarioSensore