am = am || {};

am.MapDataScenarioImmagini = (function($){

    /**
     * @class MapDataScenarioImmagini
     * @extends MapDataScenarioImmagini
     * ---
     * The concrete subclass of MapDataScenario to manage common features for all sensors (idrometrico, precipitazione, pressione, temperatura, umidita)
     */
    function MapDataScenarioImmagini(options){


        // Call constructor of superclass to initialize superclass-derived members.
        MapDataScenario.call(this, options); 
    
        this.baseLayers.bacini = null;
        this.baseLayers.reticolo = null;
    
        // Radar images
        this.imgKeys = [];
        this.imgData = [];
        
        // startupZoom
        this.startupZoom = 8;
    }
    // Inherit from MapDataScenario
    MapDataScenarioImmagini.prototype = Object.create(MapDataScenario.prototype);
    MapDataScenarioImmagini.prototype.constructor = MapDataScenarioImmagini;
    MapDataScenarioImmagini.prototype.normalizeValue = function(v){
        return v && v.toFixed(2);
    }
    MapDataScenarioImmagini.prototype.renderTo = function(imageViewer, asyncUpdateCallback){
        if( console)  console.log("[MapDataScenarioImmagini.renderTo] Sto per essere aggiunto alla mappa o refreshato");
    
        if( imageViewer )
         this.viewer = imageViewer;
    
        // ask for the list of latest images
        var param = {}; 
        MapDataServer.query(this.key, {}, (function(data){

           // todo

        }).bind(this));

    }

    /**
     * For the Radar, we already have all the images, then no AJAX call is needed.
     * Just get the correct image to display, and call back ;-)
     */
    MapDataScenarioImmagini.prototype.query = function(queryParams, callback){
        var imgData = null;
        if( queryParams.ts ){ // if the target timestamp is specified
            imgData = this.imgData[ queryParams.ts ];
        }
        
        callback({
            ts: queryParams.ts,
            img: imgData._imgData,
            label: imgData.label
        }, callback, queryParams);
        
    }
    
    /**
     * Render this scenario data on map. Called by renderTo and callable after each new query
     * @method renderData
     */
    MapDataScenarioImmagini.prototype.renderData = function(data, asyncUpdateCallback){
        
        // remove previous data
        this.viewer.clear();
        
        // draw images in the current map bounds
        this.viewer.setImage('data:image/png;base64,'+data.img);
        this.viewer.setLabel( data.label);
      
        // Invoca callback (es. per lasciare a MapDataRender l'onere di piazzare la data mostrata sulla mappa (if any))
        if( asyncUpdateCallback instanceof Function){
            asyncUpdateCallback( data, this.formatUpdateDatetime(data.ts) );
        } else if( console ) console.log("[MapDataScenarioImmagini:renderTo] Cannot call the asyncUpdateCallback: it's not a function. Skipping!");
       
    };


    
    MapDataScenarioImmagini.prototype.unrenderFrom = function(viewer, justData){
        if(viewer)
            this.viewer = viewer;
    
        if( this.viewer )
            this.viewer.clear();
    }


    
    /**
     * Tells if this data scenario needs an underlying geographical terrain layer. Subclasses can ovverride this method
     * @method needsTerrainLayer
     * @return {Boolean}
     */
    MapDataScenarioImmagini.prototype.needsTerrainLayer = function(){
        return false
    }

    /**
     * Tells if this data is zoomable
     * @method isZoomable
     * @return {Boolean}
     */
    MapDataScenarioImmagini.prototype.isZoomable = function(){
        return false
    }

    /**
     * Tells if this data is zoomable
     * @method needsLegends
     * @return {Boolean}
     */
    MapDataScenarioImmagini.prototype.needsLegends = function(){
        return false
    }

    /**
     * Tells if this data is interactive (zoomable and draggable)
     * @method isInteractive
     * @return {Boolean}
     */
    MapDataScenarioImmagini.prototype.isInteractive = function(){
        return false;
    }


    MapDataScenarioImmagini.prototype.getNeededViewerType = function(){
        return "image";
    }
    MapDataScenarioImmagini.prototype.setViewer = function(viewer){
        this.viewer = viewer;
    }
    MapDataScenarioImmagini.prototype.refresh = function(asyncUpdateCallback){
        this.unrenderFrom(this.viewer);
        this.renderTo(this.viewer, asyncUpdateCallback);
    }

    return MapDataScenarioImmagini;
})(jQuery);

// Global scope
var MapDataScenarioImmagini = am.MapDataScenarioImmagini