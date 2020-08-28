am = am || {};

am.MapDataScenarioRadar = (function($){

    /**
     * @class MapDataScenarioRadar
     * @extends MapDataScenarioRadar
     * ---
     * The concrete subclass of MapDataScenario to manage common features for all sensors (idrometrico, precipitazione, pressione, temperatura, umidita)
     */
    function MapDataScenarioRadar(options){


        // Call constructor of superclass to initialize superclass-derived members.
        MapDataScenario.call(this, options); 
    
        this.baseLayers.bacini = null;
        this.baseLayers.reticolo = null;
    
        // Radar images
        this.imgKeys = [];
        this.imgData = [];
        this.bounds = null;

        // startupZoom
        this.startupZoom = 8;
    }
    // Inherit from MapDataScenario
    MapDataScenarioRadar.prototype = Object.create(MapDataScenario.prototype);
    MapDataScenarioRadar.prototype.constructor = MapDataScenarioRadar;
    MapDataScenarioRadar.prototype.normalizeValue = function(v){
        return v && v.toFixed(2);
    }
    MapDataScenarioRadar.prototype.renderTo = function(map, asyncUpdateCallback){
        if( console)  console.log("[MapDataScenarioRadar.renderTo] Sto per essere aggiunto alla mappa o refreshato");
    
        if( map )
         this.map = map;
    
        // if I should render my base layers
        if( this.options.baseLayers ){
            // no base layers for radar
        }
    
        // ask for the list of latest images
        var param = {}; //@fixme eventuali parametri
        MapDataServer.query("radar", {}, (function(data){

            // init images 
            var pid = 0;
	        for(var id in data.images) {
                pid = +id * 1000
                this.imgKeys.push(pid);
                this.imgData[pid] = data.images[id];
            }
            this.imgKeys.sort();

            // setup bounds: just revert lng,lat to lat,lng and it works
            let corner1 = new L.latLng(data.bounds[1], data.bounds[0]);
            let corner2 = new L.latLng(data.bounds[3], data.bounds[2]);
            this.bounds = L.latLngBounds(corner1, corner2);

            this.renderData({
                ts: this.imgKeys[this.imgKeys.length - 1],
                img: this.imgData[ this.imgKeys[this.imgKeys.length - 1] ]
            } , asyncUpdateCallback);

        }).bind(this));

    }

    /**
     * For the Radar, we already have all the images, then no AJAX call is needed.
     * Just get the correct image to display, and call back ;-)
     */
    MapDataScenarioRadar.prototype.query = function(queryParams, callback){
        var img = null;
        if( queryParams.ts ){ // if the target timestamp is specified
            img = this.imgData[ queryParams.ts ];
        }
        callback({
            ts: queryParams.ts,
            img: img
        }, callback, queryParams);
    }
    
    /**
     * Render this scenario data on map. Called by renderTo and callable after each new query
     * @method renderData
     */
    MapDataScenarioRadar.prototype.renderData = function(data, asyncUpdateCallback){
        
        
        // remove previous data
        var i=0,I=this.dataLayers.length;
        for(;i<I;++i){
            this.map.removeLayer( this.dataLayers[i] ); 
        }
        this.dataLayers = [];

        // draw radar img
        let l = L.imageOverlay( "data:image/png;base64,"+data.img, this.bounds);
        l.addTo(this.map);
        this.dataLayers.push(l);
        

        // Invoca callback (es. per lasciare a MapDataRender l'onere di piazzare la data mostrata sulla mappa (if any))
        if( asyncUpdateCallback instanceof Function){
            asyncUpdateCallback( data, new Date( +data.ts) );
        } else if( console ) console.log("[MapDataScenarioRadar:renderTo] Cannot call the asyncUpdateCallback: it's not a function. Skipping!");
       
    };
    
    MapDataScenarioRadar.prototype.unrenderFrom = function(map, justData){
        if( map )
           this.map = map;
    
        if( console)  console.log("[MapDataScenarioRadar.unrenderFrom] Sto per essere tolto dalla mappa o refreshato");
    
        // Remove all data layers
        var i=0,I=this.dataLayers.length;
        for(;i<I;++i){
            this.map.removeLayer( this.dataLayers[i] ); 
        }
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
    MapDataScenarioRadar.prototype.renderSlidesForAnimation = function(wheelSwiper, hours, step, future){
       
        if( wheelSwiper ){
				
            if( !step )
                step = 15;
            
            var now =  moment(); //.format("DD/MM/YYYY HH:mm");
            
            var start = moment(now).subtract({"hours": hours});
            var ts = +start
            
            for(var a = 0; a < this.imgKeys.length; a++)
                if(this.imgKeys[a] >= ts)
                    break;

            var label = "", ts, date;
            var i = a;
            var n = this.imgKeys.length - a + 1;
            a = this.imgKeys.length - 1;

            wheelSwiper.removeAllSlides();
            

            for(; a >= i; --a){

                date = moment(new Date(this.imgKeys[a]));
                label = date.format("DD/MM/YY HH:mm");
                ts = date.valueOf();
                
                if( future ){
                    wheelSwiper.appendSlide('<div class="swiper-slide"><a href="#" data-val="'+ts+'" data-slide="'+(wheelSwiper.activeIndex+i)+'">'+label+'</a></div>');
                } else {
                    wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="'+ts+'" data-slide="'+ (a - i) +'">'+label+'</a></div>');
                }
            }
        }
      
    }

    /**
     * Returns the options (time ranges) for the animation
     * @method getAnimationOptions
     * @return {Array<Object>} An array of object with two fields "value" and "label" to build the UI component
     */
    MapDataScenarioRadar.prototype.getAnimationOptions = function(){
        return [
            { 'value':'1', 'label':'Ultima 1 ora'},
            { 'value':'2', 'label':'Ultime 2 ore'},
            { 'value':'3', 'label':'Ultime 3 ore'},
            { 'value':'4', 'label':'Ultime 4 ore'},
            { 'value':'5', 'label':'Ultime 5 ore'},
            { 'value':'6', 'label':'Ultime 6 ore'},
            { 'value':'7', 'label':'Ultime 7 ore'},
            { 'value':'8', 'label':'Ultime 8 ore'},
            { 'value':'9', 'label':'Ultime 9 ore'},
            { 'value':'10', 'label':'Ultime 10 ore'},
            { 'value':'11', 'label':'Ultime 11 ore'},
            { 'value':'12', 'label':'Ultime 12 ore'},
            { 'value':'13', 'label':'Ultime 13 ore'},
            { 'value':'14', 'label':'Ultime 14 ore'},
            { 'value':'15', 'label':'Ultime 15 ore'},
            { 'value':'16', 'label':'Ultime 16 ore'},
            { 'value':'17', 'label':'Ultime 17 ore'},
            { 'value':'18', 'label':'Ultime 18 ore'},
            { 'value':'19', 'label':'Ultime 19 ore'},
            { 'value':'20', 'label':'Ultime 20 ore'},
            { 'value':'21', 'label':'Ultime 21 ore'},
            { 'value':'22', 'label':'Ultime 22 ore'},
            { 'value':'23', 'label':'Ultime 23 ore'},
            { 'value':'24', 'label':'Ultime 24 ore'}
        ];
    }

    /**
     * For radar, starting slide is always the first visible slide.
     */
    MapDataScenarioRadar.prototype.getAnimationStartingSlide = function(wheelSwiper, value ){
        return 0;
    }
    /**
     * For radar, ending slide is always the last visible slide.
     */
    MapDataScenarioRadar.prototype.getAnimationEndingSlide = function(wheelSwiper, value ){
        return wheelSwiper.slides.length -1;
    }

    return MapDataScenarioRadar;
})(jQuery);

// Global scope
var MapDataScenarioRadar = am.MapDataScenarioRadar