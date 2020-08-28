am = am || {};

am.BackofficeMonitoringMap = (function($){

    /**
     * @class BackofficeMonitoringMap - Front-end, Interaction
     * @extends MapComponent
     * ---
     * Map Styling and Interaction for a single instance of Forecast Map (oggi, domani).
     *
     * Option parameters properties:
     * @inheritdoc MapComponent
     * @param {String} context One of "oggi", "domani"
     * @param {String} legendType The key of the legend html to load from the DOM.
     * @param {Boolean} rtdataControl True to load also the Real Time Data dropdown
    */
    function BackofficeMonitoringMap(options){

        // setup superclass stuff
        MapComponent.call(this, options);
    
        // Array<MapPhenomenonScenario>: create a MapPhenomenonScenario instance for each phenomenon
        this.scenarios = {};
        for(var k in BACKOFFICE_PHENOMENON_SCENARIO){
            if (BACKOFFICE_PHENOMENON_SCENARIO.hasOwnProperty(k)) {
                this.scenarios[BACKOFFICE_PHENOMENON_SCENARIO[k]] = new MapPhenomenonScenario({
                    id: k
                });
            }
        }
        // Current Scenario ID (String)
        this.currentScenario = null;
  

        // References to the layers
        this.layers = {
            terrain: null,
            aree: null,
            comuni: null,
            accessibility: null // Accessibility icon layer
        };
  
        this.comunePopup = []; // @checkme we don't need this anymore?
    
        // Selected Comuni 
        this.selectedNames = [];
        this.selectedLayers = [];

        this.areaData = [
            { name: 'A', latLng: TERRITORY.areaMarkerPosition['A'], phenos : [] },    // 0
            { name: 'A1', latLng: TERRITORY.areaMarkerPosition['A1'], phenos : [] },  // 1
            { name: 'A2', latLng: TERRITORY.areaMarkerPosition['A2'], phenos : [] },  // 2
            { name: "B", latLng: TERRITORY.areaMarkerPosition['B'], phenos : [] },    // 3
            { name: "B1", latLng: TERRITORY.areaMarkerPosition['B1'], phenos : [] },  // 4
            { name: "B2", latLng: TERRITORY.areaMarkerPosition['B2'], phenos : [] },  // 5
            { name: "C", latLng: TERRITORY.areaMarkerPosition['C'], phenos : [] },    // 6
            { name: "C1", latLng: TERRITORY.areaMarkerPosition['C1'], phenos : [] },  // 7
            { name: "C2", latLng: TERRITORY.areaMarkerPosition['C2'], phenos : [] },  // 8
            { name: "D", latLng: TERRITORY.areaMarkerPosition['D'], phenos : [] },    // 9
            { name: "D1", latLng: TERRITORY.areaMarkerPosition['D1'], phenos : [] },  // 10
            { name: "D2", latLng: TERRITORY.areaMarkerPosition['D2'], phenos : [] },  // 11
            { name: "E", latLng: TERRITORY.areaMarkerPosition['E'], phenos : [] },    // 12
            { name: "E1", latLng: TERRITORY.areaMarkerPosition['E1'], phenos : [] },  // 13
            { name: "E2", latLng: TERRITORY.areaMarkerPosition['E2'], phenos : [] },  // 14
            { name: "F", latLng: TERRITORY.areaMarkerPosition['F'], phenos : [] },    // 15
            { name: "G", latLng: TERRITORY.areaMarkerPosition['G'], phenos : [] },    // 16
            { name: "G1", latLng: TERRITORY.areaMarkerPosition['G1'], phenos : [] },  // 17  
            { name: "G2", latLng: TERRITORY.areaMarkerPosition['G2'], phenos : [] },  // 18
            { name: "H", latLng: TERRITORY.areaMarkerPosition['H'], phenos : [] },    // 19
            { name: "H1", latLng: TERRITORY.areaMarkerPosition['H1'], phenos : [] },  // 20
            { name: "H2", latLng: TERRITORY.areaMarkerPosition['H2'], phenos : [] }   // 21
        ];

        // go init the map
        this.init();
    
    }
    // Inherit from MapComponent
    BackofficeMonitoringMap.prototype = Object.create(MapComponent.prototype);
    BackofficeMonitoringMap.prototype.constructor = BackofficeMonitoringMap;
  
    
    /**
     * @method inTheSameComune Return true if the Comune's name is the same taking into account accent and strange characthers
     * @param {String} a The name of the first comune
     * @param {String} b The name of the second comune
     */
    BackofficeMonitoringMap.prototype.inTheSameComune = function(a, b) {
        var f = function(s) {
            switch(s) {
                case "à": return "a";
                case "è": return "e";
                case "ì": return "i";
                case "ò": return "o";
                case "ù": return "u";
            }
        }
        return a.toUpperCase().replace(/\s+|'/g, "").replace(/[àèìòù]/g, f) == b.replace(/\s+|'/g, "").replace(/[àèìòù]/g, f)
    }
    /**
     * @method init Call the server for this context ("oggi", "domani") data
     */
    BackofficeMonitoringMap.prototype.init = function(){
  
        // call server
        MapDataServer.query( "get-allarmi", null,  (function(data, args){
            // then init scenario
            this.initScenarios(data);
            
            // set my default scenario
            this.currentScenario = 'monitoring'; 

            // then render the default scenario (monitoring)
            this.render();

            // render the only scenario available
            this.renderScenario(this.scenarios[this.currentScenario]);
             
            // refresh me (for fit viewport size)
            this.refresh();

        }).bind(this));
  
    }
    /**
     * @method initScenarios Setup all the phenomenon scenario from server's data
     * @param data JSON from the server
     */
    BackofficeMonitoringMap.prototype.initScenarios = function(data){
        
        for(var a = 0, lev = 0; a < data.length; a++) {
            obj = data[a]
    
            if (obj.color === "green")      lev = 1;
            else if(obj.color === "yellow") lev = 2;
            else if(obj.color === "orange") lev = 3;
            else if(obj.color === "red")    lev = 4;
            else lev = 0;
            
            this.scenarios['monitoring'].addComuniToLevel( obj.comune, lev ); 
        }

    }
    /**
     * @method render Renders the map, attach event handlers, selection, overlay and stuff like this
     */
    BackofficeMonitoringMap.prototype.render = function(){
      
        // build the map
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
  
        // add feature-tooltip div (used on feature mouse over)
        $(this.options.mapContainer).append('<div class="map-component__feature-tooltip"></div>');
  
        // add base terrain layer
        if( this.options.terrainLayer )
            this.layers.terrain = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://openstreetmap.org">OpenStreetMap</a>',
                maxZoom: 18
            }).addTo(this.map);
  
        // add aree allertamento // NO NEED FOR THIS
        // this.layers.aree = L.geoJson(MapDataServer.getLayer("areeAllertamento"), {
        //     style: (function (feature) {
        //         return this.styles.areaAllertamento;
        //     }).bind(this)
        // }).addTo(this.map);
  
        // add comuni and, for each one: (i) apply the current scenario style, (ii) setup interactions (popup, ecc.)
        this.layers.comuni = L.geoJson(ER, {
            style: (function (feature) {
  
                // return the skin of this feature depending on its level in the current scenario
                var lev = this.scenarios[ this.currentScenario ].getComuneLevel( feature.properties.NOME );
                return this.styles.levelStyle[ lev ];
            }).bind(this),
            onEachFeature: (function (feature, layer) { 
          
                // get feature's data
                var fName = feature.properties.NOME;
                var fAreaCodeLabel = feature.properties.NOME_1;
                var fLatlng = layer.getBounds().getCenter();
                var fArea = MapDataServer.getAreaOfComune(fName);
                var fAreaData = this.areaData[fArea.index];
                var fUrl = MapDataServer.getComunePageUrl(fName, fArea.label, fLatlng.lat+"|"+fLatlng.lng );
  
                // setup the popup content 
                var phenosHtml = '', 
                    J = fAreaData.phenos.length, 
                    j = 0,
                    color = '',
                    numEv = 0; 
                for(;j<J;++j){
                    var color = fAreaData.phenos[j].match(/[^-]+$/)[0];
                    var pheno = fAreaData.phenos[j].substring(0, fAreaData.phenos[j].indexOf("-"+color)); // fAreaData.phenos[j].split("-")[0];
        
                    if (color != "green" && color != "white"){
                        numEv++;
        
                        phenosHtml += ($('.'+fAreaData.phenos[j]+"-tpl" ).html()) 
                            ? $('.'+fAreaData.phenos[j]+"-tpl" ).html() 
                            : "";
                    }
                }
  
                // Create the popup for selection
                var p = L.popup({ autoPan: true, keepInView:true, className: 'map-popup', closeButton: true, minWidth: (numEv*this.styles.phenoWidth) }) 
                    .setContent(
                            '<h4>' + fName + '</h4>'
                            + '<div class="map-popup__lead">Area '+fAreaData.name+'</div>'
                            + '<div class="map-popup__phenos">'+phenosHtml+'</div>' // style="width: '+ (numEv*this.styles.phenoWidth) +'px;"
                            + '<a class="btn btn-xs btn-default go-to-loc-page" href="'+fUrl+'"> Vai a '+fName +' <span class="icon i-angle-right"></span></a>'
                    );	
                layer.bindPopup(p);
                this.comunePopup.push(p);					
                jQuery.data( p, 'layerEl',  layer );
                
            
  
                // onMouseOver/Out: a tooltip over the feature
                layer.on('mouseover', (function(e) {
                    $('.map-component__feature-tooltip', $(this.options.mapContainer) ).html(feature.properties.NOME);
                    $('.map-component__feature-tooltip', $(this.options.mapContainer) ).css({
                        top: (e.containerPoint.y+15)+"px", 
                        left: (e.containerPoint.x+15)+"px"
                    }).show();
                    layer.setStyle( this.styles.featureOnMouseOver);
                }).bind(this));
                layer.on('mouseout', (function(e) {
                    $('.map-component__feature-tooltip', $(this.options.mapContainer) ).hide();
                    // if this Comune is not selected, revert the style to default
                    if( this.selectedNames.indexOf(layer.feature.properties.NOME) < 0 ){
                    layer.setStyle( this.styles.featureOnMouseOut);
                    }
                }).bind(this));
  
            }).bind(this)
        }).addTo(this.map);
  
  
        // setup BS4's tooltip on popup opens
        this.map.on('popupopen', (function(e) {
            if(e.popup && e.popup.options.className == 'map-popup'){
  
                // unselect any other comune
                this.selectedNames = [];
                this.selectedLayers = [];
  
                // hide map tooltip on 
                $('.map-component__feature-tooltip', $(this.options.mapContainer) ).hide();
  
                // if( lastComunePopup ) // REMOVE ME: non serve piu
                // 	map.closePopup( lastComunePopup );
                // lastComunePopup = e.popup;
                // //hideAreaLabels();
  
                // render the selected style on the feature
                var layerEl = jQuery.data(e.popup, "layerEl");
                layerEl.setStyle( this.styles.selectedStyle );
                this.selectedNames.push( layerEl.feature.properties.NOME );
                this.selectedLayers.push( layerEl );
  
                // attach tooltip on popup inner content
                $(e.popup._wrapper).find("[data-toggle=tooltip]").tooltip();
            }
        }).bind(this));
        this.map.on('popupclose', (function(e) {
            // Clear the selection style
            if( e.popup.options.className == 'map-popup' ){  
                var layerEl = jQuery.data(e.popup, "layerEl");
  
                // unselect me
                var i = this.selectedNames.indexOf(layerEl.feature.properties.NOME);
                if( i > -1 ){
                    this.selectedNames.splice( i, 1 );
                    this.selectedLayers.splice( i, 1 );
                }
  
                // revert style to default
                layerEl.setStyle({
                    weight: this.styles.defaultLineWeight,
                    fillOpacity: this.styles.defaultFillOpacity
                });
            }
        }).bind(this));
  
    }
  
   
    /**
     * @method renderScenario Renders a specific MapPhenomenonScenario
     */
    BackofficeMonitoringMap.prototype.renderScenario = function(scenario){
        if( this.layers.comuni && scenario.getComuneLevel ){

            // Change the style depending on the scenario
            this.layers.comuni.eachLayer( (function (layer) {  
            	if(  layer.feature.properties.NOME == 'MODENA')
            		console.log('Modena Trovato');
            	if(  layer.feature.properties.NOME == 'ARGELATO')
            		console.log('ARGELATO Trovato');
                var lev = scenario.getComuneLevel( layer.feature.properties.NOME );
                if( lev == undefined){
                    if( console ) 
                        console.log("[BackofficeMonitoringMap#"+this.id+"] ERROR: Comune '"+layer.feature.properties.NOME+"' not found in any of the '"+scenario.id+" levels'");
                    lev = 0;
                }
                layer.setStyle( this.styles.levelStyle[ lev ] );
            }).bind(this) );

            // If there's any Comune selected, render it as selected
            if( this.selectedLayers.length ){
                var i=0, I= this.selectedLayers.length;
                for(;i<I;++i){
                    this.selectedLayers[i].setStyle(this.styles.selectedStyle);
                }
            }
        }
    }
    
    
    
    return BackofficeMonitoringMap;
})(jQuery);

// Global scope
var BackofficeMonitoringMap = am.BackofficeMonitoringMap