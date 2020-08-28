am = am || {};

am.MapDataRender = (function($){


    /**
     * @class MapDataRender
     * ---
     * Class that manages a set of MapDataScenario to rendering data (activating/deactivating depending on filter, ecc.)
     * Options paramater properties:
     * @param {Leaflet.Map} map The Leaflet Map instance where to render data to
     * @param {HTMLElement|Element|String} filterUiContext The DOM element where to search for filtering elements
     * @param {Array<String>} dataScenarios An array of key representing the scenario to be managed.
     * @param {String} currentScenario The key of the scenario to be set as current on init
     * @param {Boolean} renderScenarioOnLoad True to render the param currentScenario on load
     * @param {Boolean} searchTool True to add a search tool on the map (it allows to search on every feature rendered by current scenarios)
     * @param {Boolean} baseLayers False to avoid the rendering of MapDataScenario base layer, default true
     * @param {Function} onDataUpdated Function to call when a data scenario updates its data
     */
    function MapDataRender(options){

        if( console ) console.log("[MapDataRender] Creating a new instance of me! ");

        // apply defaults
        this.options = options || {};
        if( !this.options.map ){
            throw "[MapDataRender#"+this.id+"] No Leaflet Map provided, sorry! ";
        }

        // store the map viewer where to put data
        this.map = this.options.map;
        if( !this.options.dataScenarios )
            this.options.dataScenarios = [];

        if( !(this.options.baseLayers===false) ) {
            this.options.baseLayers = true;
        }

        // image viewer (in case any scenario needs it). Will be init on demand
        this.imageViewer = null; 


        // I should have an ID
        this.id = this.options.id 
        if( !this.id )
            this.id = "MapDataRender--"+Math.floor(Math.random() * 10);


        this.scenarios = {}; // Associative Array<MapDataScenario>
        var i=0,I= this.options.dataScenarios.length, k = null;
        for(;i<I;++i){
            k = this.options.dataScenarios[i];
            if( console ) 
                console.log("[MapDataRender#"+this.id+"] Creating an instance of MapDataScenario for: "+k);

            // create the scenario
            this.scenarios[ k ] = MapDataScenarioFactory.create( k, {
                key: k,
                map: this.map,
                baseLayers: this.options.baseLayers
            });

            // if the scenario needs an image viewer (eg. cumulata-48h, cumulata-6h, anim-mare)
            if( this.scenarios[k].getNeededViewerType() == 'image'){
                // create the image viewer
                if( !this.imageViewer ){
                    this.initImageViewer();
                }
                // give it to it
                this.scenarios[k].setViewer( this.imageViewer );
            } 
            
        }
        // Current Data Scenario ID (String)
        this.currentScenario = this.options.currentScenario;


        // add feature search (if needed)
        this.searchTool = null;
        this.searchLayer = null;
        if( this.options.searchTool ){
            this.searchLayer = new L.LayerGroup();
            this.searchTool = new L.Control.Search({
                layer: this.searchLayer,
                zoom: 12,
                position: "topright"
            });
            this.map.addControl( this.searchLayer );
            this.map.addControl( this.searchTool );
            // Try to prevent Chrome's auto-fill overlay // see https://stackoverflow.com/a/15917221/9015970
            $('.search-input',  this.searchTool.getContainer() ).attr("autocomplete", "new-password");

            // hide it by default (it will be shown when the current data scenario is loaded, depending on the scenario type, if something is searchable or not)
            $(this.searchTool.getContainer()).hide();
        }
        
        

        // init me
        this.init();
    }
    MapDataRender.prototype.init = function(){
        // Setup filtering
        this.initFiltering();

        // If a scenario is passed, then render it
        if( this.options.renderScenarioOnLoad && this.currentScenario ){

            if( console ) console.log("[MapDataRender#"+this.id+"] Activating current scenario: '"+this.currentScenario+"'");

            this.renderScenario(this.currentScenario);
            this.map.setZoom( this.scenarios[this.currentScenario].getStartupZoom() );

            // make the filter for the current scenario active
            $('[data-trigger=rtdata-filter][data-filter='+this.currentScenario+']', $(this.options.filterUiContext)).each(function(){
                
                if( $(this).is("a") )
                    $(this).addClass("active");
            
            })
            if( console ) console.log("[MapDataRender#"+this.id+"] Scenario '"+this.currentScenario+"' is now the active one.");
        }

    }
    MapDataRender.prototype.initFiltering = function(){
        if( this.options.filterUiContext ){

            var f = $('[data-trigger=rtdata-filter]', $(this.options.filterUiContext));
            var _this = this;
            if( f.is("select") ){ // if it's a dropown
                $(f).on("change", function(e){
                    e.preventDefault();
                    _this.renderScenario( $(this).val() );
                });
            } else { // if it's a set of link
                $(f).on("click", function(e){
                    e.preventDefault();
                    _this.renderScenario( $(this).attr("data-filter") );

                    // now this filter is active
                    $(this).parent().siblings().find("a").removeClass("active");
                    $(this).addClass("active");

                    if( console ) console.log("[MapDataRender#"+_this.id+"] ... rt data '"+$(this).attr("data-filter")+"' is the active one now!");

                });
            }
            
        }   
    }
    MapDataRender.prototype.renderScenario = function(scenarioKey){

        if( console ) console.log("[MapDataRender::"+this.id+"] Renderizing data scenario: "+scenarioKey);

        for( var k in this.scenarios ){
            if( this.scenarios.hasOwnProperty(k) && k != scenarioKey){ 
                if(  this.scenarios[k] )
                    this.scenarios[k].unrenderFrom( 
                        (this.scenarios[k].getNeededViewerType() == 'image')? this.imageViewer : this.searchLayer || this.map
                    ); 
                else // check also if this.scenarios[k] exists (maybe there is still no development for that sublcass )
                    if( k!=scenarioKey && console) 
                        console.warn("[MapDataRender#"+this.id+"] Skiping the removal of '"+k+"' MapDataScenario. Perhaps MapDataScenarioFactory returned no concrete implementation of MapDataScenario for '"+k+"'. ");
            }
        }

        if( this.scenarios[scenarioKey] ){
            
            // if this scenario needs and Image Viewer, create it
            var neededViewer = this.scenarios[scenarioKey].getNeededViewerType()
            if( neededViewer == 'image' && !this.imageViewer ){
                this.initImageViewer();
            }

            // switch to the needed viewer (map or image)
            this.switchViewer( this.scenarios[scenarioKey].getNeededViewerType() );

            // render the scenario on the proper viewer (imageViewer or map)
            this.scenarios[scenarioKey].renderTo( 
                (neededViewer == 'image')? this.imageViewer : this.searchLayer || this.map, 
                this.options.onDataUpdated 
            );
            
            // show/hide tools (search, zoom, legends) depending on the scenario data source (if any)
            this.refreshControlsVisibility();
            
        } else if( scenarioKey && console ) 
            console.warn("[MapDataRender#"+this.id+"] Someone tried to render a RTDataScenario that's not initalized: "+scenarioKey);

        this.currentScenario = scenarioKey;
        if(console) console.log("[MapDataRender#"+this.id+"] Scenario "+scenarioKey+" rendered!");
    }
    /**
     * @method refreshCurrentScenario
     * @param {Function} asyncRefreshCallback Function to call on scenario data updated
     */
    MapDataRender.prototype.refreshCurrentScenario = function(asyncRefreshCallback){
        this.refreshScenario(this.currentScenario, (function(data, ts){
            
            // Once here, data rendering is over so trigger the event
            if( this.options.onAfterDataRendered instanceof Function)
                this.options.onAfterDataRendered();

            // show/hide tools (search, zoom, legends) depending on the scenario data source (if any)
            this.refreshControlsVisibility();

            // call back
            if( asyncRefreshCallback instanceof Function)
                asyncRefreshCallback( data, ts );


        }).bind(this));
    }

    /**
     * Show or hide search (if any). If the current scenario is a sensor then show it, else hide it.
     * @method refreshControlsVisibility
     */
    MapDataRender.prototype.refreshControlsVisibility = function(){
        if( this.searchTool) {
            if( this.scenarios[this.currentScenario].isDataSearchable() ){
                $(this.searchTool.getContainer()).show();
            } else {
                $(this.searchTool.getContainer()).hide();
            }
        }
        
    }
    /**
     * @method refreshCurrentScenario
     * @param {String} k The key name of the scenario to refresh
     * @param {Function} asyncRefreshCallback Function to call on scenario data updated. If null,
     *  the one passed as input will be used (this.options.asyncRefreshCallback).
     */
    MapDataRender.prototype.refreshScenario = function(k, asyncRefreshCallback){

        // switch to the needed viewer
        this.switchViewer( this.scenarios[k].getNeededViewerType() );

        // setup default callback if needed
        if( !asyncRefreshCallback ){
            asyncRefreshCallback = this.options.onDataUpdated;
        }

        // ask the current scenario for 
        if( this.scenarios[k] )
            this.scenarios[k].refresh(asyncRefreshCallback);
    }
    /**
     * @method getCurrentScenario
     * @returns the instance of MapDataScenario's subclass currently on map
     */
    MapDataRender.prototype.getCurrentScenario = function(){
        return this.scenarios[this.currentScenario];
    }
  
    /**
     * Add layers to the search layer group to make it searchable
     * @method addToSearchLayer
     */
    MapDataRender.prototype.addToSearchLayer = function(layers, clear){
        if( clear )
            this.searchLayer.clearLayers();
        let i=0, I=layers.length;
        for(;i<I;++i)
            this.searchLayer.addLayer(layers[i]);
    }


    // ##################################

    /**
     * Switch between a map viewer (Leaflet) to a simple image viewer. 
     * Some data scenario are simply png/base64 images, so the MapRTRender switch between leaflet and 
     * an image viewer (keeping the UI appearance) depending on the current rendered scenario 
     * @method switchViewer
     */
    MapDataRender.prototype.switchViewer = function(viewer){
        if( viewer == 'image'){
            
            // first init 
            if( !this.imageViewer ){
                this.initImageViewer();
            }

            // hide the map
            $( this.map.getContainer() ).hide();

            // show and refresh map
            this.imageViewer.show();

        } else {

            // hide image viewer (if any)
            if( this.imageViewer )
                this.imageViewer.hide();

            // show and refresh map
            $( this.map.getContainer() ).show();
            this.map.invalidateSize();
        }
    }
    // ##################################
    /**
     * Initialize an image viewer (a simple div) to render scenarios who needs a simple image viewer instead of a Leaflet Map
     * @method initImageViewer
     */
    MapDataRender.prototype.initImageViewer = function(){

        // ##### Image Viewer Inner Class
            var MapDataRenderImageViewer = function(brotherElement){
                $(brotherElement).after('<div class="u-map-section__map-side map-component__image-viewer" style="display:none"><div class="map-component__image-viewer__lead"></div><img class="map-component__image-viewer__img" src=""/></div>');
                this.container = $(brotherElement).next();
            }
            MapDataRenderImageViewer.prototype.show = function(){
                $(this.container).show();
            }
            MapDataRenderImageViewer.prototype.hide = function(){
                $(this.container).hide();
            }
            MapDataRenderImageViewer.prototype.clear = function(){
                $('.map-component__image-viewer__img', this.container).attr("src", '');
                $('.map-component__image-viewer__lead', this.container).html( '' );
            }
            MapDataRenderImageViewer.prototype.setImage = function(imgUrl){
                $('.map-component__image-viewer__img', this.container).attr("src", imgUrl);
            }
            MapDataRenderImageViewer.prototype.setLabel = function(label){
                label = jQuery.trim(label);
                if(label){
                    $('.map-component__image-viewer__lead', this.container).html( label );
                }
            }
        // ##### / Image Viewer Inner Class

        this.imageViewer = new MapDataRenderImageViewer( $(this.map.getContainer()) );
        
        $(this.map.getContainer()).next();
    }




    return MapDataRender;
})(jQuery);

// Global scope
var MapDataRender = am.MapDataRender