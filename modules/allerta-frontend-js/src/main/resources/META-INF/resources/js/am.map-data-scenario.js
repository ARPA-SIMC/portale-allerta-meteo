am = am || {};

am.MapDataScenario = (function($){

    /**
     * @class MapDataScenario
     * ---
     * The Abstract Class for managing Real Time Data Scenario on map.
     * Create one subclass for all the data to be shown on map
     */
    function MapDataScenario(options){
        // apply defaults
        this.options = options || {};
        this.key = this.options.key;
        if( ! this.key ){
        throw "[MapDataScenario] No 'key' passed in the constructor. You should tell me what data scenario I should be! ";
        }
        if( typeof this.options.baseLayers === "boolean" && !(this.options.baseLayers===false) ) {
            this.options.baseLayers = true;
        }
    
        // store the map where I'll be rendered
        this.map = this.options.map;

        
        this.styles = this.options.styles || MAP_STYLE;
        
        this.baseLayers = {};
        this.dataLayers = []; // here goes all the dyanmic stuff that should be added/removed
    
        this.timespan = {
            min: null,
            max: null,
            step: 30
        };

        // default correct zoom for this data
        this.startupZoom = 8;
    }
    MapDataScenario.prototype.renderBaseLayers = function(){}
    MapDataScenario.prototype.renderTo = function(map){}
    MapDataScenario.prototype.unrenderFrom = function(map, justData){}
    MapDataScenario.prototype.refresh = function(asyncUpdateCallback){
        this.unrenderFrom(this.map);
        this.renderTo(this.map, asyncUpdateCallback);
    }
    MapDataScenario.prototype.normalizeValue = function(v){}
    MapDataScenario.prototype.getSensorMarkerBackground = function(soglia1, soglia2, soglia3, ilValore, ilTipo,){}
    MapDataScenario.prototype.getDataLayers  = function(){
        return this.dataLayers;
    }
    MapDataScenario.prototype.getTimespan = function(v){
        return this.timespan;
    }
    MapDataScenario.prototype.getTimespanMin = function(v){
        return this.timespan.min;
    }
    MapDataScenario.prototype.getTimespanMax = function(v){
        return this.timespan.max;
    }

    MapDataScenario.prototype.getTimestamp = function(){

        var d = new Date
        d.setMilliseconds(0)
        d.setSeconds(0)
        d.setMinutes(d.getMinutes()<31?0:30)
        
        // Tira indietro di 2 ore perché nel db sono UTC
        /*
        if (moment(d).isDST())
            d.setHours(d.getHours() - 2); // Solare
        else
            d.setHours(d.getHours() - 1); // Legale
		*/
        
        if (moment(d).isDST())
            d.setHours(d.getHours() - 1); // Solare
        else
            d.setHours(d.getHours() ); // Legale
        
        ts = +d
        return ts; 
    };
    /**
     * Get new data from server for my RTData scenario
     * @method query 
     */
    MapDataScenario.prototype.query = function(param, callback, callbackArgs){
      
      // Query the server for data
      MapDataServer.query(this.key, param, (function(data, callbackArgs, queryParam){
        callback(data, callbackArgs, queryParam);
      }).bind(this), callbackArgs);
    }
    MapDataScenario.prototype.formatUpdateDatetime = function(ts){
        let tsD = new Date( +ts)
        
        /*originale
        if (moment(tsD).isDST())
            tsD.setHours(tsD.getHours() + 2);
        else
            tsD.setHours(tsD.getHours() + 1);
        */
        
        if (moment(tsD).isDST())
            tsD.setHours(tsD.getHours() + 1);
        else
            tsD.setHours(tsD.getHours());
        
        // @fixme This is just to debug the code, remove me!
        //tsD = new Date(); 
    
        return tsD; 
    }

    /**
     * Render the slides for this scenario to be animated depending on the input parameters
     * @abstract
     * 
     * @method renderSlidesForAnimation
     * @param {Swiper} wheelSwiper The instance of swiper where to put the new slide
     * @param {Number} hours Hours to animate
     * @param {Number} step The animation step size
     * @param {Boolean} future True if we animate the future, false if the past.
     */
    MapDataScenario.prototype.renderSlidesForAnimation = function(wheel, hours, step, future ){
        throw "[MapDataScenario.renderSlidesForAnimation] This method has not been developed in the subclass "+this.key+" before to be invoked!";
    }
    /**
     * Return the correct slide index to start which the animation should start from
     * @abstract
     * 
     * @method getAnimationStartingSlide
     * @param {Swiper} wheelSwiper The instance of swiper
     * @param {Number} value The current value of the Animation controller dropdown
     */
    MapDataScenario.prototype.getAnimationStartingSlide = function(wheelSwiper, value){
        throw "[MapDataScenario.getAnimationStartingSlide] This method has not been developed in the subclass "+this.key+" before to be invoked!";
    }
    
    /**
     * Return the correct slide index to start which the animation should start from
     * @abstract
     * 
     * @method getAnimationEndingSlide
     * @param {Swiper} wheelSwiper The instance of swiper
     * @param {Number} value The current value of the Animation controller dropdown
     */
    MapDataScenario.prototype.getAnimationEndingSlide = function(wheelSwiper, value){
        throw "[MapDataScenario.getAnimationEndingSlide] This method has not been developed in the subclass "+this.key+" before to be invoked!";
    }

    /**
     * Get the startup zoom for this data. Useful when you render this data for the first time or you want to reset it.
     * @method getStartupZoom
     * @return {Number}
     */
    MapDataScenario.prototype.getStartupZoom = function(){
        return this.startupZoom;
    }

    
    /**
     * Tells if this data scenario is searchable (so far, it means it is provided by a sensor). Subclasses can ovverride this method
     * @method isDataSearchable
     * @return {Boolean}
     */
    MapDataScenario.prototype.isDataSearchable = function(){
        return false;
    }


    /**
     * Tells if this data scenario needs an underlying geographical terrain layer. Subclasses can ovverride this method
     * @method needsTerrainLayer
     * @return {Boolean}
     */
    MapDataScenario.prototype.needsTerrainLayer = function(){
        return true
    }

    /**
     * Tells if this data is zoomable
     * @method isZoomable
     * @return {Boolean}
     */
    MapDataScenario.prototype.isZoomable = function(){
        return true
    }

    /**
     * Tells if this data is zoomable
     * @method needsLegends
     * @return {Boolean}
     */
    MapDataScenario.prototype.needsLegends = function(){
        return true
    }

    /**
     * Tells if this data is interactive (zoomable and draggable)
     * @method isInteractive
     * @return {Boolean}
     */
    MapDataScenario.prototype.isInteractive = function(){
        return true
    }


    /**
     * Returns the needed viewer type, one of "map" (default) or "image".
     * Subclasses can ovverride this method
     * @method getNeededViewerType
     * @return {String}
     */
    MapDataScenario.prototype.getNeededViewerType = function(){
        return "map";
    }

    /**
     * Set the current viewer. The viewer can be a Leaflet Map (default) or an Image viewer.
     * Subclasses can ovverride this method (eg. see MapDataScenarioImmagini ) 
     * @method setViewer
     */
    MapDataScenario.prototype.setViewer = function(map){
        this.map = map;
    }

    /**
     * Returns the options (time ranges) for the animation
     * @method getAnimationOptions
     * @return {Array<Object>} An array of object with two fields "value" and "label" to build the UI component
     */
    MapDataScenario.prototype.getAnimationOptions = function(){
        return [];
    }

  
    

    return MapDataScenario;
})(jQuery);

// Global scope
var MapDataScenario = am.MapDataScenario