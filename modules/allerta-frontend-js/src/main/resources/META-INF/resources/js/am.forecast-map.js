am = am || {};

am.ForecastMap = (function($){

    /**
     * @class ForecastMap - Front-end, Interaction
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
    function ForecastMap(options){

        // setup superclass stuff
        MapComponent.call(this, options);
    
        // Array<MapPhenomenonScenario>: create a MapPhenomenonScenario instance for each phenomenon
        this.scenarios = {};
        for(var k in PHENOMENON_SCENARIO){
            if (PHENOMENON_SCENARIO.hasOwnProperty(k)) {
                this.scenarios[PHENOMENON_SCENARIO[k]] = new MapPhenomenonScenario({
                    id: k
                });
            }
        }
        // Current Scenario ID (String)
        this.currentScenario = null;
  
  
        // data about area of allertamento (name, marker position, phenomenos in the current context (that is "oggi" or "domani") )
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
  
        // References to the layers
        this.layers = {
            terrain: null,
            aree: null,
            comuni: null,
            accessibility: null // Accessibility icon layer
        };
  
        // switch's flag
        this.accessibilityIsShown = false;
    
        this.comunePopup = []; // @checkme we don't need this anymore?
    
        // Selected Comuni 
        this.selectedNames = [];
        this.selectedLayers = [];
    
        // if rtdata required, an instance of MapDataRender will be created in ForecasMap::render method
        this.rtdataRender = null;
        
        // Apply default rtdatascenarios (used only if this.options.rtdataControl is true )
        if( !this.options.rtdataScenarios ){
            this.options.rtdataScenarios = ['idrometrico'];  
            // @fixme with the following commented line when all these MapDataScenario's subclass will be developed
            this.options.rtdataScenarios = ['precipitazioni', 'idrometrico', 'temperature','umidita','pressione','vento','livellomare','altezzaonda','direzioneonda'];
        }

        // go init the map
        this.init();
    
    }
    // Inherit from MapComponent
    ForecastMap.prototype = Object.create(MapComponent.prototype);
    ForecastMap.prototype.constructor = ForecastMap;
  
    
    /**
     * @method areaData Get an Area object by area name (es. "A1")
     * @param {String} name The name of the area to look for
     */
    ForecastMap.prototype.getAreaDataByName = function(name){
        var i=0, I=this.areaData.length;
        for(;i<I;++i){
            if( this.areaData[i].name == name)
                return this.areaData[i];
        }
    };
    /**
     * @method inTheSameComune Return true if the Comune's name is the same taking into account accent and strange characthers
     * @param {String} a The name of the first comune
     * @param {String} b The name of the second comune
     */
    ForecastMap.prototype.inTheSameComune = function(a, b) {
        var f = function(s) {
            switch(s) {
                case "à": return "a";
                case "è": return "e";
                case "ì": return "i";
                case "ò": return "o";
                case "ù": return "u";
            }
        }
        return a.toUpperCase().replace(/\s+|'/g, "").replace(/[àèìòù]/g, f) == b.toUpperCase().replace(/\s+|'/g, "").replace(/[àèìòù]/g, f)
    }
    /**
     * @method init Call the server for this context ("oggi", "domani") data
     */
    ForecastMap.prototype.init = function(){
  
        // call server
        MapDataServer.query( (this.options.context=='#tab--oggi')? "get-stato-allerta":"get-stato-allerta-domani", null,  (function(data, args){
            // then init scenario
            this.initScenarios(data);
            
            // set my default scenario
            this.currentScenario = 'generale'; 

            // then render the default scenario (generale)
            this.render();

            // attach filtering events (if any)
            this.initFiltering();

            // refresh me (for fit viewport size)
            this.refresh();

        }).bind(this));
  
    }
    /**
     * @method initScenarios Setup all the phenomenon scenario from server's data
     * @param data JSON from the server
     */
    ForecastMap.prototype.initScenarios = function(data){
      
        var map = { 
            "A":-1, "A1": 0, "A2": 1, "B": -1, "B1": 2, "B2": 3, "C": -1, "C1": 4, "C2": 5, "D":  -1, "D1": 6, "D2": 7, 
            "E":  -1,	"E1": 8, "E2": 9, "F": -1, "F1": 10, "G":  -1, "G1": 11, "G2": 12, "H":  -1, "H1": 13,	"H2": 14
        }
        var mapNew = { 
            "A":0, "A1": 1, "A2": 2, "B": 3, "B1": 4, "B2": 5, "C": 6, "C1": 7, "C2": 8, "D":  9, "D1": 10, "D2": 11, 
            "E": 12,	"E1": 13, "E2": 14, "F": 15, "F1": 15, "G":  16, "G1": 17, "G2": 18, "H":  19, "H1": 20,	"H2": 21
        }
        var mapScenario = {
            0: TERRITORY.A1, 
            1: TERRITORY.A2, 
            2: TERRITORY.B1, 
            3: TERRITORY.B2, 
            4: TERRITORY.C1, 
            5: TERRITORY.C2, 
            6: TERRITORY.D1, 
            7: TERRITORY.D2, 
            8: TERRITORY.E1, 
            9: TERRITORY.E2, 
            10: TERRITORY.F, 
            11: TERRITORY.G1, 
            12: TERRITORY.G2, 
            13: TERRITORY.H1, 
            14: TERRITORY.H2
        };
        var mapEventi = {
              "idro": 						"idraulica",
              "idrogeo":  					"idrogeologica",
              "temperature-estreme-basse": 	"temperature-estreme-basse",
              "temperature-estreme":			"temperature-estreme-alte"
        };
        var subAreeAc = {
           0: 'A1', // A1
           1: 'A2', // A2
           2: 'B1', // B1
           3: 'B2', // B2
           4: 'C1', // C1
           5: 'C2', // C2
           6: 'D1', // D1
           7: 'D2', // D2
           8: 'E1', // E1
           9: 'E2' , // E2
           10: 'F1', // F
           11: 'G1', // G1
           12: 'G2', // G2
           13: 'H1', // H1
           14:'H2' // H2
        };
      
        var obj, ls, mx; // usati come variabili di appoggio
        var prop, ix, areaName;  // usati all'interno del loop sui fenomeni di ogni area
        var vettMaxGenerale = {}; // usato come array associativo
     
        // Mi assicuro che nelle aree non siano associati già altri fenomeni
        for(i=0;i< this.areaData[i].length;i++)
            this.areaData[i].phenos = []
  
  
        for(var a = 0; a < data.length; a++) { // Loop sulle Aree, ognuna ha indicazione dei fenomeni
            obj = data[a]
            mx = 0
  
            // Parsing degli eventi
            for(var id in mapEventi)
                obj.eventi = obj.eventi.replace(new RegExp(id + ":", "g"), mapEventi[id] + ":")
  
            ls = obj.eventi.replace(/:/g, "-").split(",")
  
            if (obj.area.length > 1 && !mapNew[obj.area]) continue;
            
            // Metto i fenomeni previsti nell'array con i dettagli sulle aree
            if(obj.area.length > 1) 						
                this.areaData[mapNew[obj.area]].phenos = this.areaData[mapNew[obj.area]].phenos.concat(ls)
            else{
                if(obj.area!='F'){
                    this.areaData[mapNew[obj.area+'1']].phenos = this.areaData[mapNew[obj.area+'1']].phenos.concat(ls)
                    this.areaData[mapNew[obj.area+'2']].phenos = this.areaData[mapNew[obj.area+'2']].phenos.concat(ls)
                } else
                    this.areaData[mapNew['F1']].phenos = this.areaData[mapNew['F1']].phenos.concat(ls)
            }
  
            // Mappo il naming delle aree e recupero i comuni di quella area/sottoarea
            areaName = obj.area;
            if( areaName == 'F1')
                areaName = 'F';
            
            if (TERRITORY[areaName].length==0) MapDataServer.init()
            comuniInArea = TERRITORY[areaName];
           
  
            // Loop sui fenomeni previsti per quest'area
            for(var b = 0; b < ls.length; b++) {
  
                var type 	= ls[b].match(/(.+?)-?[^-]+$/)[1]
                var color = ls[b].match(/[^-]+$/)[0]
  
                prop = type;
  
                switch(color) {
                    case "white": 	ix = 0; break;
                    case "green": 	ix = 1; break;
                    case "yellow": 	ix = 2; break;
                    case "orange": 	ix = 3; break;
                    case "red": 	ix = 4; break;
                }
  
                // Aggiungo i comuni di questa area/sottoarea allo scenario di questo evento //Era: SCENARI[scenarioId][prop][ix] = SCENARI[scenarioId][prop][ix].concat(area)
                this.scenarios[prop].addComuniToLevel(comuniInArea, ix); 

                // Aggiorno il livello di rischio dell'accessibilità per quest'area per questo fenomeno // Era // this.accessibilita[prop][obj.area] = ix
                this.scenarios[prop].setAccessibilityLevelForArea(areaName, ix);

                // Aggiorno il livello di rischio massimo per questo fenomeno nel suo scenario
                if( ix > this.scenarios[prop].getMaxRiskLevel() ){
                    this.scenarios[prop].setMaxRiskLevel(ix);
                }
  
                // update the max level
                if(mx < ix)
                    mx = ix
            }
         
            // salvo il livello max di allerta per ogni area 
            vettMaxGenerale[ obj.area ] = mx;
        }
  
        // === Gestione dello scenario generale ==
        // Aggiungo allo scenario generale la lista di comuni della sottoarea+areaF (tanto un comune è almeno in una sottoarea o in F, quindi li copro tutti) 
        // secondo il livello max.
        // Se il comune è di una sottoarea, allora controllo se il livello max dell'area padre (es. A1 => A) è più alto.
        // @checkme I marker di accessibilità sono quelli di livello più basso, come nelle sottoaree. Bisogna capire se questo ha senso per il cliente (ma non vedo alternative)
        var maxRiskGenerale = 0;
        for( var areaName in vettMaxGenerale){
            if( vettMaxGenerale.hasOwnProperty(areaName) ){
                var maxRiskArea = 0, destAreaName = areaName;
                if( areaName.length > 1 ||  areaName == 'F'){
  
                    maxRiskArea = vettMaxGenerale[ areaName ];
                    if( areaName.length > 1 ){
                        var parentAreaName = areaName.substr(0,1);
                        maxRiskArea = Math.max(vettMaxGenerale[areaName], vettMaxGenerale[parentAreaName]);
                    }
                    
                    if (destAreaName == 'F1')
                        destAreaName = 'F';
  
                    // aggiungi i comuni di quell'area al rispettivo livello max di allerta nello scenario generale
                    this.scenarios['generale'].addComuniToLevel( TERRITORY[ destAreaName ], maxRiskArea); 
  
                    // salvo il livello max per i marker di accessibilità
                    this.scenarios['generale'].setAccessibilityLevelForArea( destAreaName, maxRiskArea);
  
                    if( maxRiskArea > maxRiskGenerale){
                        maxRiskGenerale = maxRiskArea;
                    }
                }
            }
        }
        // salvo il livello max livello di rischio generale
        this.scenarios['generale'].setMaxRiskLevel( maxRiskGenerale );
        // === Fine gestione dello scenario generale ==
    }
    /**
     * @method render Renders the map, attach event handlers, selection, overlay and stuff like this
     */
    ForecastMap.prototype.render = function(){
      
    	if( this.mapContainerId == undefined) return;
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
  
        // add aree allertamento
        this.layers.aree = L.geoJson(MapDataServer.getLayer("areeAllertamento"), {
            style: (function (feature) {
                return this.styles.areaAllertamento;
            }).bind(this)
        }).addTo(this.map);
  
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
    
                        // If the map is applied on a Comune and I'm that Comune, show specific contents in panel
                        if( this.options.comune && this.inTheSameComune(fName,this.options.comune) ) {
                            
                            
                            // - Tabelle scenario
                            $('.map-component__panel__situation__risk', $(this.options.container) ).append(
                                '<li class="nav-item">'+$('.map-legend__phenomenon-guides [data-when='+pheno+']').html()+'</li>'
                            );
                            
                            // - Informati e preparati
                            // the logic is custom (some page is valid for multiple phenomenon)
                            if( pheno  == 'stato-mare' ||  pheno  == 'mareggiate'){
                                pheno = 'mareggiate-stato-mare';
                            } else if(pheno=='temperature-estreme-basse' || pheno=='temperature-estreme-alte'){
                                pheno = 'temperature-estreme';
                            } 

                            // append it if not already in
                            if( $('.map-component__panel__situation__info .nav-link--iep-'+pheno, $(this.options.container)).length == 0 ){
                                $('.map-component__panel__situation__info', $(this.options.container) ).append(
                                    '<li class="nav-item">'+$('.map-infopages-tpl [data-when='+pheno+']').html()+'</li>'
                                );
                            }

                        }
      
                    }
                }
  
                // If the map is applied on a Comune and I'm that Comune
                if( this.options.comune && this.inTheSameComune(fName,this.options.comune) ) {
  
                    // Show specific contents in panel
                    // - Phenomena
                    if( phenosHtml == ""){
                        $('.map-component__panel__situation__phenomena', $(this.options.container) ).append( ALERT_LEVEL_TEXT[1] );
                        // if no phenomena, hide the rest of panel's info
                        $('.map-component__panel__situation__info, .map-component__panel__situation__risk ', $(this.options.container) ).parent().hide();
            
                    } else{
                        $('.map-component__panel__situation__phenomena', $(this.options.container) ).append( phenosHtml );
                    }
    
                    // Echo area allertamento in the panel
                    $('.map-component__panel__area-allertamento',  $(this.options.container)).append("Area di allertamento "+fAreaCodeLabel);

                    // Center the map on me (the pan is done as the last action of the rendering, se the end of the method)
                    this.options.center= [fLatlng.lat, fLatlng.lng];
                    this.options.zoom = 9;
                
                    // Create an Icon
                    this.styles.markerIcon.iconAnchor = new L.Point(23, 47);
                    var pin = new L.Icon(this.styles.markerIcon);
                    L.marker(fLatlng, { icon: pin }).addTo(this.map);
    
                    // Style me as selected
                    layer.setStyle(this.styles.selectedStyle);
                    this.selectedNames.push(fName);
                    this.selectedLayers.push(layer);
    
                } else {
  
                    // Create the popup for selection
                    var p = L.popup({ autoPan: true, keepInView:true, className: 'map-popup', closeButton: true, minWidth: (numEv*this.styles.phenoWidth) }) 
                        .setContent(
                                '<h4>' + fName + '</h4>'
                                + '<div class="map-popup__lead">Zona '+fAreaData.name+'</div>'
                                + '<div class="map-popup__phenos">'+phenosHtml+'</div>' // style="width: '+ (numEv*this.styles.phenoWidth) +'px;"
                                + '<a class="btn btn-xs btn-default go-to-loc-page" href="'+fUrl+'"> Vai a '+fName +' <span class="icon i-angle-right"></span></a>'
                        );	
                    layer.bindPopup(p);
                    this.comunePopup.push(p);					
                    jQuery.data( p, 'layerEl',  layer );
                    
                }
  
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
  
  
        // add all Leaflet controls
        L.Control.legend = L.Control.extend({
            options: { position: 'bottomleft', legendType: 'previsioni' },
            initialize: function (options ) {
              L.Util.setOptions(this, options);
            },
            onAdd: function (map) {
                let $ = jQuery.noConflict();
                
                // happens after added to map
                var container = L.DomUtil.create('div', 'map-legend-control');
                $(container).html( $('.map-templates .map-legend--'+this.options.legendType+'-tpl').html() );
                // expand/collapse (for > md breakpoint )
                $('.map-legend__toggle', $(container)).on("click", function(e){
                    e.preventDefault();
                    $('.map-legend__toggable', $(container)).toggle();
                    $(this).toggleClass("is-expanded");
                });


                return container;
            },
          });
          L.control.legend = function(id, opts){
            return new L.Control.legend(id, opts);
          }

          /**
          * Leaflet Control for specific data legend (shown on topleft, in coherence with ARPAE private tools)
          */
          L.Control.observedDataSpecificLegend = L.Control.extend({
            options: { position: 'topleft', legendType: 'observed-data-specific' },
            initialize: function (options ) {
              L.Util.setOptions(this, options);
            },
            onAdd: function (map) {
                let $ = jQuery.noConflict();
                
                // happens after added to map
                var container = L.DomUtil.create('div', 'map-legend-control');
                $(container).html( $('.map-templates .map-legend--'+this.options.legendType+'-tpl').html() );

                return container;
            },
          });
          L.control.observedDataSpecificLegend = function(id, opts){
            return new L.Control.observedDataSpecificLegend(id, opts);
          }

          
          /**
           * Leaflet Control for accessibility Toggle
           */
          L.Control.accessibilityToggle = L.Control.extend({
            options: { position: 'topright' },
            initialize: function (options ) {
              L.Util.setOptions(this, options);
            },
            onAdd: function (map) {
                let $ = jQuery.noConflict();

                // happens after added to map
                var container = L.DomUtil.create('div', 'map-accessibility-toggle-control');
                $(container).html( $('.map-templates .map-accessibility-toggle-tpl').html() );
                $('[data-toggle="tooltip"]', $(container)).tooltip();
                return container;
            },
          });
          L.control.accessibilityToggle = function(id, opts){
            return new L.Control.accessibilityToggle(id, opts);
          }
          
          /**
          * Leaflet Control for specific data legends to be placed on map ()
          */
          L.Control.dataLegend = L.Control.extend({
            options: { position: 'bottomleft', dataKey: '' },
            initialize: function (options ) {
              L.Util.setOptions(this, options);
            },
            onAdd: function (map) {
                let $ = jQuery.noConflict();
                // happens after added to map
                var container = L.DomUtil.create('div', 'map-data-legend-control');
                $(container).html( $('.map-templates .map-data-legend--'+this.options.dataKey+'-tpl').html() );

                return container;
            },
          });
          L.control.dataLegend = function(id, opts){
            return new L.Control.dataLegend(id, opts);
          }

          
          
          /**
          * Switch to display real time data on map
          */
          L.Control.rtdataSwitch = L.Control.extend({
            options: { position: 'topleft' },
            initialize: function (options ) {
              L.Util.setOptions(this, options);
            },
            onAdd: function (map) {
                let $ = jQuery.noConflict();
                // happens after added to map
                var container = L.DomUtil.create('div', 'map-rtdata-dropdown');
                $(container).html( $('.map-templates .map-rtdata-dropdown-tpl').html() );
                $(container).find("*[data-toggle=tooltip]").tooltip();

                return container;
            },
          });
          L.control.rtdataSwitch = function(id, opts){
            return new L.Control.rtdataSwitch(id, opts);
          }
          
          /**
           * Leaflet Control that places a "refresh" button (for real time data) on the map
           */
          L.Control.rtdataUpdate = L.Control.extend({
            options: { position: 'topright' },
            interval: null,
            initialize: function (options ) {
              L.Util.setOptions(this, options);
            },
            onAdd: function (map) {
                let $ = jQuery.noConflict();
                // happens after added to map
                var container = L.DomUtil.create('div', 'map-rtdata-update');
                $(container).html( $('.map-templates .map-rtdata-update-tpl').html() );

                this.interval = setInterval(function(){
                  $('.btn', container ).click();
                  if( console )
                    console.log("[Leaflet.Control.rtdataUpdate] Refreshing current visualized data at "+moment(new Date()).format() );
                }, 5 * MINUTES);
                return container;
            },
          });
          L.control.rtdataUpdate = function(id, opts){
            return new L.Control.rtdataUpdate(id, opts);
          }
            


          /**
          * Leaflet Control for loading icon
          */
         L.Control.loadingStatus = L.Control.extend({
          options: { position: 'bottomleft', dataKey: '' },
          initialize: function (options ) {
            L.Util.setOptions(this, options);
          },
          onAdd: function (map) {
              let $ = jQuery.noConflict();
              // happens after added to map
              var container = L.DomUtil.create('div', 'map-data-loading');
              $(container).hide();
              $(container).html( '<span class="icon i-spinner" title="Caricamento dati in corso"></span>' );
              return container;
          },
          show: function(){
            jQuery(this._container).show();
          },
          hide: function(){
            jQuery(this._container).hide();
          }
        });
        L.control.loadingStatus = function(id, opts){
          return new L.Control.loadingStatus(id, opts);
        }
  
        // setup accessibility layer
        this.layers.accessibility = new L.layerGroup();
        L.control.accessibilityToggle().addTo(this.map);
        this.refreshAccessibilityLayer(); // Refresh accessibility layer (for the default scenario)
        $('[data-toggle=toggle-accessibility]', $(this.options.mapContainer) ).on("click", {me: this}, function(e){
            e.preventDefault();
            var _this = e.data.me;
            if( _this.accessibilityIsShown ){
                _this.hideAccessibilityLayer();
                $(this).removeClass('toggle-accessibility--on');
            } else {
                _this.showAccessibilityLayer();
                $(this).addClass('toggle-accessibility--on');
            }
        });
        this.showAccessibilityLayer();
        $('.toggle-accessibility', $(this.options.mapContainer) ).addClass('toggle-accessibility--on');
        $('[data-toggle=toggle-accessibility]', $(this.options.mapContainer) ).on("dblclick", function(e){
            // avoid zooming when dbclicking on the accessibility toggle
            e.preventDefault();
            e.stopPropagation();
        });
      
        // add legend
        this.legend = L.control.legend({
            legendType: "previsioni"
        });
        this.legend.addTo(this.map);
        this.refreshLegend();
        this.setupMapGuideModal();

        // add real time data activator (if needed)
        if( this.options.rtdataControl ){
            var rtswitch = L.control.rtdataSwitch().addTo(this.map);
            // Create a MapRTData Render
            this.rtdataRender = new MapDataRender({
                id: 'MapDataRender--'+this.id,
                dataScenarios: this.options.rtdataScenarios,
                map: this.map,
                filterUiContext: rtswitch.getContainer(),
                baseLayers: false // don't want bacini, reticolo ecc.
            });
        }
  
        // if the map is on a Comune, re-center
        if(this.options.comune) {
            

            // Create an Icon
            this.styles.markerIcon.iconAnchor = new L.Point(23, 47);
            var pin = new L.Icon(this.styles.markerIcon);
            
            L.marker(this.options.center, { icon: pin }).addTo(this.map);

            // Center the map on me: correct lat lng should be passed in on constructor
            
            // repan the map
            setTimeout((function(){
                this.map.setView( this.options.center, 10 );
            }).bind(this), 500);
        	/*
            setTimeout((function(){
                //this.map.panTo(  );	
                this.map.setView( this.options.center, this.options.zoom );
            }).bind(this), 500);*/
        }
    }
  
    /**
     * @method initFiltering Setup the filter handlers on this map.
     * A filter is an application of a MapPhenomenonScenario that should be already loaded in this.map.scenarios array
     */
    ForecastMap.prototype.initFiltering = function(){
        var _this = this;

        // Attach handler
        $('[data-trigger=map-filter]', $(this.options.container)).click( function(e){
            e.preventDefault();
  
            var filterKey = $(this).attr("data-filter");
            
            if( console ) console.log("[ForecastMap#"+_this.id+"] User pressed the filter '"+filterKey+"' on "+ _this.id);
            
            // get the required scenario (quit if doesn't exists)
            var newScenario = _this.scenarios[filterKey];
            if(!newScenario){
                if( console ) 
                    console.error("[ForecastMap#"+_this.id+"] Error: phenomenon scenario '"+filterKey+"' not defined for "+ _this.id);
                return;          
            }
    
            // apply styles
            _this.renderScenario( newScenario );
    
            // the scenario has changed
            _this.currentScenario = filterKey;
    
            // refreh access
            _this.refreshAccessibilityLayer();
    
            // refresh legend (if any)
            _this.refreshLegend();
    
            // now this filter is active
            $(this).parent().siblings().find("a").removeClass("active");
            $(this).addClass("active");
    
            if( console ) console.log("[ForecastMap#"+_this.id+"] ... filter '"+filterKey+"' applied ");
  
        });
  
        // Setup risk level on each filter
        $('[data-trigger=map-filter]', $(this.options.container)).each(function(){
            var filterKey = $(this).attr("data-filter");
            if( _this.scenarios[filterKey] ){
                var maxLev = _this.scenarios[filterKey].getMaxRiskLevel();
                var alertSign = $('.alert-sign', $(this));
                $(alertSign).data("animCount", 0);
                $(alertSign).data("animMax", maxLev );
                $(alertSign)
                    .removeClass('alert-sign--')
                    .attr("title", ALERT_LEVEL_TEXT[maxLev]);

                // Animate the level clor
                $(alertSign).data("animInterval", setInterval((function(){
                    let c = $(this).data("animCount");
                    let m = $(this).data("animMax");
                    if(c <= m ){
                        if( c-1 >= 0)
                            $(this).removeClass( ALERT_LEVEL_CSS_CLASS[ c -1 ] );
                        $(this).addClass( ALERT_LEVEL_CSS_CLASS[ c ])
                        $(this).data("animCount", c + 1);
                    } else {
                        clearInterval( $(this).data("animInterval") );
                    }
                }).bind(alertSign), 250) );

            } else {
                if( console ) console.warn("[ForecastMap#"+_this.id+"] There is no phenomenon scenario for '"+filterKey+"' filter. Please check it! ");
            }
        });
  
      // make the filter for the current scenario active
      $('[data-trigger=map-filter][data-filter='+this.currentScenario+']', $(this.options.container)).addClass("active");
    }
    /**
     * @method renderScenario Renders a specific MapPhenomenonScenario
     */
    ForecastMap.prototype.renderScenario = function(scenario){
        if( this.layers.comuni && scenario.getComuneLevel ){

            // Change the style depending on the scenario
            this.layers.comuni.eachLayer( (function (layer) {  
                var lev = scenario.getComuneLevel( layer.feature.properties.NOME );
                if( lev == undefined){
                    if( console ) 
                        console.log("[ForecastMap#"+this.id+"] ERROR: Comune '"+layer.feature.properties.NOME+"' not found in any of the '"+scenario.id+" levels'");
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
    /**
     * Refresh legend depending on the scenario
     * @method refreshLegend 
     */
    ForecastMap.prototype.refreshLegend = function(){
        if( this.legend ) {
            var c = this.legend.getContainer();
            var scenario = this.currentScenario;
            $('[data-if=filter]', $(c)).each(function(){
            
                if( $(this).attr("data-when") == scenario ){
                    $(this).show();
                } else {
                    $(this).hide();
                }

                if( scenario != 'generale' && $(this).attr("data-when") == "!generale" ){
                    $(this).show();
                } 
            });
        }
    }
     /**
     * Refresh accessibility icons
     * @method refreshAccessibilityLayer 
     */
    ForecastMap.prototype.refreshAccessibilityLayer = function(){
        // Refresh accessibility icons
        if( this.layers.accessibility ){

            //this.hideAccessibilityLayer(true);
            this.map.removeLayer(this.layers.accessibility);
            this.layers.accessibility.clearLayers();

            // get accessibility items for this scenario, loop on them and render a marker for each one
            var acLevel = this.scenarios[this.currentScenario].getAccessibilityAlertLevels();
            for( var areaName in acLevel ){
                if (acLevel.hasOwnProperty(areaName)) {
                
                    var color = ALERT_LEVEL[ acLevel[areaName] ];
                    var desc = ALERT_LEVEL_TEXT[ acLevel[areaName] ];
                    var iconSrc = this.styles.accesibiliyIcon[color];
                    var latlng = this.getAreaDataByName(areaName).latLng;

                    this.layers.accessibility.addLayer( new L.Marker( latlng, {
                        icon: new L.DivIcon({
                            className: 'accessibility-icon',
                            html: '<div>'
                                + '<div class="map-divicon-text" style="display:block; position: relative; z-index:2; text-align: center; width: 32px; font-size: 10.5px; font-weight: bold; ">'
                                +   areaName
                                + '</div>'
                                + '<img class="map-divicon-image" style="display:block; margin-top:-16px; position: relative; z-index:1;" src='+iconSrc+' alt="'+desc+'"/>'+
                            '</div>',
                            iconAnchor: new L.Point(23, 62)
                        })
                    }));

                }
            }
            if( this.accessibilityIsShown )
                this.showAccessibilityLayer();
        }
    }
    /**
     * Used when the user toggles the accessibility toggle on map
     * @method showAccessibilityLayer
     */
    ForecastMap.prototype.showAccessibilityLayer = function(){
        if( this.layers.accessibility ) {
            this.layers.accessibility.addTo(this.map);
            this.accessibilityIsShown = true;
        }
    }
    /**
     * Used when the user toggles the accessibility toggle on map
     * @method hideAccessibilityLayer
     */
    ForecastMap.prototype.hideAccessibilityLayer = function(){
        if( this.layers.accessibility && this.map.hasLayer(this.layers.accessibility) ){
            this.map.removeLayer(this.layers.accessibility);
            this.accessibilityIsShown = false;
        }
    }



    /**
     * Filter out my own modal map-guide from un-needed stuff
     * @method setupMapGuideModal
     */
    ForecastMap.prototype.setupMapGuideModal = function(){

        if( this.legend ) {
            var c = $('.modal--map-guide--forecast');
            var scenario = this.currentScenario;
            var _this = this;
            $('[data-if=legend]', $(c)).each(function(){
            
                // if there's rtdata
                if( _this.options.rtdataControl ){
                    // hide everything but what is releated to "rtdata" or to one of the scenario
                    if( $(this).attr("data-when") == 'rtdata' || _this.options.rtdataScenarios.indexOf( $(this).attr("data-when") ) > -1 ){
                        $(this).show();
                    } else {
                        $(this).hide();
                        $(this).attr("aria-hidden", "true");
                    }
                }

            });
        }
        
    }
    
    return ForecastMap;
})(jQuery);

// Global scope
var ForecastMap = am.ForecastMap