am = am || {};

am.MonitoringMap = (function($){


    /**
     * @class MonitoringMap
     * @extends MapComponent
     * --
     * Manages the interaction for the Monitoraggio Map. Options parameter: 
     * @inheritdoc MapComponent 
     * @param {Boolean} refreshTool True to show the control for refreshing data on map
     * @param {Boolean} searchTool True to show the control for searching stuff on map
     * @param {Array<string>} dataScenarios Keys of real time data to load
     */
    function MonitoringMap(options){
        // setup superclass stuff
        MapComponent.call(this, options);

        this.id = this.options.id; 

        // this will be an instance of MapDataRender to manage data
        this.dataRender = null; 
        this.layers = {
            terrain: null
        }; 
        this.init();
    }
    // Inherit from MapComponent
    MonitoringMap.prototype = Object.create(MapComponent.prototype);
    MonitoringMap.prototype.constructor = MonitoringMap;
    MonitoringMap.prototype.init = function(){
        this.render(); 
    }
    MonitoringMap.prototype.render = function(){

        $("#"+this.mapContainerId).empty();
        this.map = L.map(this.mapContainerId,{
            dragging: !L.Browser.mobile, // disable dragging with one thumb on mobile device
            touchZoom: L.Browser.mobile, // enable dragging with two thumbs on mobile device
            scrollWheelZoom: false, // disable scroll with the mouse wheel, it's enabled just with CTRL+wheel (see the superclass MapComponent)
            closePopupOnClick: false
        });
        this.map.setView(this.options.center, this.options.zoom);
        this.map.zoomControl.setPosition('bottomright');
        this.attachZoomBehaviour();


        // add base terrain layer
        if( this.options.terrainLayer )
        this.layers.terrain = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="https://openstreetmap.org">OpenStreetMap</a>',
            maxZoom: 18
        }).addTo(this.map);

        // create data render
        this.dataRender = new MapDataRender({
            filterUiContext: $(this.options.container),
            map: this.map,
            dataScenarios: this.options.dataScenarios,
            currentScenario: this.options.currentScenario,
            renderScenarioOnLoad: this.options.renderScenarioOnLoad,
            onDataUpdated: (function(data, datetime){
            this.refreshDataTimestamp(datetime);
            }).bind(this)
        });

        // create all needed Leaflet controls

        // add legend
        this.legend = L.control.legend({
            legendType: "monitoraggio"
        });
        this.legend.addTo(this.map);
        this.setupMapGuideModal();

        // add real time data reresher (if needed)
        if( this.options.refreshTool ){
            this.refreshTool = L.control.rtdataUpdate().addTo(this.map);
            $('[data-trigger=refresh]', this.refreshTool.getContainer() ).on("click", this.handleDataRefresh.bind(this) );
        }

        // if the map is on a Comune, re-center
        if(this.options.comune) {

            // add the marker
            
            // Create an Icon
            this.styles.markerIcon.iconAnchor = new L.Point(23, 47);
            var pin = new L.Icon(this.styles.markerIcon);
            
            L.marker(this.options.center, { icon: pin }).addTo(this.map);

            // Center the map on me: correct lat lng should be passed in on constructor
            this.options.zoom = 9;
            
            // repan the map
            setTimeout((function(){
                this.map.setView( this.options.center, this.options.zoom );
            }).bind(this), 500);
        }

        // fit the current loading size and zoom
        this.refresh();
    }
    MonitoringMap.prototype.refreshDataTimestamp = function(d){
        if( this.refreshTool ){
            $(".map-rtdata-update__datetime", $(this.refreshTool.getContainer())) .html( moment(d).format("DD/MM/YYYY HH:mm") );
        }
    }
    MonitoringMap.prototype.handleDataRefresh = function(e){
        e.preventDefault();
        if( this.refreshTool ){
            this.dataRender.refreshCurrentScenario((function(data, datetime){
                this.refreshDataTimestamp(datetime);
            }).bind(this));
        }
    }

    /**
     * Filter out my own modal map-guide from un-needed stuff
     * @method setupMapGuideModal
     */
    MonitoringMap.prototype.setupMapGuideModal = function(){

        if( this.legend ) {
            var c = $('.modal--map-guide--monitoring');
            var scenario = this.currentScenario;
            var _this = this;
            $('[data-if=legend]', $(c)).each(function(){
            
                // if there's rtdata
                if( _this.options.dataScenarios ){
                    // hide everything but what is releated to "rtdata" or to one of the scenario
                    if( $(this).attr("data-when") == 'rtdata' || _this.options.dataScenarios.indexOf( $(this).attr("data-when") ) > -1 ){
                        $(this).show();
                    } else {
                        $(this).hide();
                        $(this).attr("aria-hidden", "true");
                    }
                }

            });
        }
        
    }
  
    
    return MonitoringMap;
})(jQuery);

// Global scope
var MonitoringMap = am.MonitoringMap