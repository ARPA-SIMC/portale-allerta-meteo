am = am || {};

am.MapComponent = (function($){


    /**
     * @class MapComponent
     * ---
     * Superclass for all the map component. There are three subclass ForecastMap (oggi, domani), 
     * MonitoringMap (monitoraggio), DataMap (previsioni e dati).
     * @param {String} id A unique id (if needed)
     * @param {Element|HTMLElement|String} container The outer div of the MapComponent (the one with class="map-component")
     * @param {Element|HTMLElement|String} mapContainer the div where to put the map
     * @param {Array<Lat,Lng>} center To center the map
     * @param {Boolean} terrainLayer True to show Open Steeet Map terrain layer (default true)
     * @param {Number} zoom startup zoom level, default 8
     * @param {Object} styles Map layer skin (default STYLES global object)
     * @param {Object} breakpointZoom Zoom level for breakpoints "sm", "md", "lg"
     */

    function MapComponent(options){

        // apply defaults
        this.options = options || {};

   
        // overloadable options
        if( this.options.terrainLayer == undefined )
            this.options.terrainLayer = true; 
        if( !this.options.zoom )
            this.options.zoom = 8;
    
        if( !this.options.center.lat ){
        // If not an object try for a string lat|lng format
        if( this.options.center.indexOf("|") > -1 )
            this.options.center = this.options.center.split("|");
        } 
    
        // apply default map styles if not specified
        this.styles = this.options.styles;
        if( !this.styles )
            this.styles = MAP_STYLE;
    
        // apply default brakpoint zoom
        if( !this.options.breakpointZoom )
            this.options.breakpointZoom = MAP_BREAKPOINT_ZOOM;
        
    
        // I should have an ID
        if( $(this.options.container) ){
            this.id = $(this.options.container).attr("id");
        } else 
            this.id = "am-autogen-"+this.options.context;
    
        // Leaflet map object
        this.map  = null;
        // geo coordinates, layers, and stuff
        this.territory = options.territory;
        // view properties
        this.mapContainerId = $(options.mapContainer).attr("id");

        // map interaction can be freezed programmatically (eg. you need to display static images with no interaction)
        this.interactionFreezed = false;

        // Attach onBeforePrint handler
        window.addEventListener("beforeprint", this.onBeforePrint.bind(this));
    }



    /**
     * Apply the correct zoom interaction behaviour
     * Call this method immediately after creating the Leaflet map.
     * @method attachZoomBehaviour
     */
    MapComponent.prototype.attachZoomBehaviour = function(){
        // Mousewheel zoom just when CTRL is pressed
        if( this.map ){
        
            var mwHandler = (function (event) { 

                if( ! this.interactionFreezed ){

                    event.preventDefault();
                    event.stopPropagation();
                    
            
                    if (event.ctrlKey == true) {
                        event.preventDefault();
                        this.map.scrollWheelZoom.enable();
                        $("#"+this.mapContainerId).removeClass('leaflet-map-scroll');
                    } else {
                        this.map.scrollWheelZoom.disable();
                        $("#"+this.mapContainerId).addClass('leaflet-map-scroll');
                        setTimeout((function(){
                            $("#"+this.mapContainerId).removeClass('leaflet-map-scroll');
                            this.map.scrollWheelZoom.enable();
                        }).bind(this), 1000);
                    }
                }
            }).bind(this);
        
            //  setTimeout((function(){
            //   this.map.scrollWheelZoom.disable();
            // }).bind(this), 1000);
        
            var cnt = this.map.getContainer();
        
            // IE9, Chrome, Safari, Opera, FF > 2018
            cnt.addEventListener("wheel", mwHandler, false);
        
            // IE5/6/7, Chrome, Safari, Opera < 2018
            // @todo Will be done just if needed
    
        } else {
            if( console ) console.warn("[MapComponent:attachZoomBehaviour] No map where to apply the zoom behaviour");
        }
        
    }

    MapComponent.prototype.freezeMapInteraction = function(){
        if( this.map ){
            this.interactionFreezed = true;
            this.map.dragging.disable();
            this.map.touchZoom.disable();
            this.map.doubleClickZoom.disable();
            this.map.scrollWheelZoom.disable();
        }
    }

    MapComponent.prototype.enableMapInteraction = function(){
        if( this.map ){
            this.map.dragging.enable();
            this.map.touchZoom.enable();
            this.map.doubleClickZoom.enable();
            this.map.scrollWheelZoom.enable();

            this.interactionFreezed = false;
        }
    }
    /**
     * Handler for the request for printing the page: it pans the map to fit the A4's viewport
     * @fixme This is not supported by Safari and Opera (see: https://www.w3schools.com/jsref/event_onbeforeprint.asp )
     * @method attachZoomBehaviour
     */
    MapComponent.prototype.onBeforePrint = function(){
    
        if( this.map ){
            // Pan the map to left (the width on a 13" screen is bigger than the width on A4 sheet)
            this.map.panBy(new L.Point(50, 0));
        }
    }

    // Public API
    /**
     * @method refresh Refresh the view. Call this when something outside changes.
     */
    MapComponent.prototype.refresh = function(){
        if( this.map ){
            // Refresh Leaflet stuff
            this.map.invalidateSize();

            // if we're not on a Comune's page, fit zoom level
            if( !this.options.comune ){ 
                var w = $(window).width();
                if( w  < 768 ){
                    this.map.setZoom( this.options.breakpointZoom.sm );
                } else if( w < 992 ) {
                    this.map.setZoom( this.options.breakpointZoom.md );
                } else {
                    this.map.setZoom( this.options.breakpointZoom.lg );
                }
            }
        }
    };

    /**
     * Subclasses must implement this method to filter out its own modal map-guide from un-needed stuff
     * @method setupMapGuideModal
     */
    MapComponent.prototype.setupMapGuideModal = function(){
        throw "[MapComponent::setupMapGuideModal] Implement me!"
    }
  
    
    return MapComponent;
})(jQuery);

// Global scope
var MapComponent = am.MapComponent