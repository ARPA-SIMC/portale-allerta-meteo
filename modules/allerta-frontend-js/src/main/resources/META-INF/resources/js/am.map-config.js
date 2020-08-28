// Code Module object
var am = {};

// Default geo stuff
var TERRITORY = {  
    // Coordinate centrali della regione
    REGION_LAT_LNG: [44.2655, 11.00214], //  [44.4655, 11.00214],
    RETION_LAT_LNG_FOR_RTDATA: [ 44.437616940601565, 10.445251464843752],
  
    areaMarkerPosition: {
      'A' : [43.996352, 11.910119], // A
        'A1': [43.793334, 12.004003], // A1
        'A2': [44.123454, 11.884489], // A2
      'B': [44.116989, 12.342916], // B
        'B1': [44.150814, 12.133067], // B1
        'B2': [44.107114, 12.441954], // B2
      'C': [44.278539, 11.270582], // C
        'C1': [44.125353, 11.065230], // C1
        'C2': [44.342121, 11.356992], // C2
      'D': [44.745207, 11.94185], // D
        'D1': [44.762820, 11.481542], // D1
        'D2': [44.694005, 12.179353], // D2
      'E': [44.364870, 10.466681], // E
        'E1': [44.315812, 10.342393], // E1
        'E2': [44.442764, 10.687246], // E2
      'F': [44.841100, 10.759347], // F
        'G': [44.509301, 9.632699], // G
      
      'G1': [44.451723, 9.616408], // G1
      'G2': [44.610308, 10.090104], // G2
      'H': [44.986566, 9.952704], // H2
        'H1': [44.911445, 9.597796], // H1
        'H2': [44.927302, 10.126673], // H2
    },
    
    // Patacche macro aree @fixme Non dovrebbero piu servire
    stickyLevelIconLatLng_subarea : [
      [43.793334, 12.004003, 'A1','A1'], // A1
      [44.123454, 11.884489, 'A2','A2'], // A2
      [44.150814, 12.133067, 'B1','B1'], // B1
      [44.107114, 12.441954, 'B2','B2'], // B2
      [44.125353, 11.065230, 'C1','C1'], // C1
      [44.342121, 11.356992, 'C2','C2'], // C2
      [44.762820, 11.481542, 'D1','D1'], // D1
      [44.694005, 12.179353, 'D2','D2'], // D2
      [44.315812, 10.342393, 'E1','E1'], // E1
      [44.442764, 10.687246, 'E2','E2'], // E2
      [44.841100, 10.759347, 'F1','F'], // F
      [44.451723, 9.616408, 'G1','G1'], // G1
      [44.610308, 10.090104, 'G2','G2'], // G2
      [44.911445, 9.597796, 'H1','H1'], // H1
      [44.927302, 10.126673,'H2','H2'], // H2
      
    ],
    //Add patacche macro aree @fixme Non dovrebbero piu servire
    stickyLevelIconLatLng_macroarea : [
      [43.996352, 11.910119, 'A'], // A
      [44.116989, 12.342916, 'B'], // B
      [44.278539, 11.270582, 'C'], // C
      [44.745207, 11.94185, 'D'], // D
      [44.364870, 10.466681, 'E'], // E
      [44.841100, 10.759347, 'F'], // F
      [44.509301, 9.632699, 'G'], // G
      [44.986566, 9.952704,'H'], // H2
    ],
    
    // Aree di allertamento (riempite in MapServer::init con i dati dei comuni)
    A: [],
    B: [],
    C: [],
    D: [],
    E: [],
    F: [],
    G: [],
    H: [],
    A1: [],
    A2: [],
    B1: [],
    B2: [],
    C1: [],
    C2: [],
    D1: [],
    D2: [],
    E1: [],
    E2: [],
    G1: [],
    G2: [],
    H1: [],
    H2: [],
  };
  
  var red = '#BD0026';
  var orange = '#E69F00';
  var yellow = '#EFF200';
  var green = '#009E73';
  var lineColor = '#444444';
  var lineWeight = 1;
  var fillOpacity = 0.65;
  var imagesPath = '/o/allerta-previsioni/img/leaflet';
  
  var MAP_STYLE = {
    levelStyle: [
      {color: '#888888', fillColor: '#ffffff', weight: lineWeight, fillOpacity: fillOpacity }, // grey
      {color: lineColor, fillColor: green, weight: lineWeight, fillOpacity: fillOpacity}, // green
      {color: lineColor, fillColor: yellow, weight: lineWeight, fillOpacity: fillOpacity}, // yellow
      {color: lineColor, fillColor: orange, weight: lineWeight, fillOpacity: fillOpacity}, // orange
      {color: lineColor, fillColor: red, weight: lineWeight, fillOpacity: fillOpacity} // red
    ],
    featureOnMouseOver: { fillOpacity: 1, weight:3 },
    featureOnMouseOut: { fillOpacity: fillOpacity, weight: lineWeight},
    areaAllertamento:  { weight: 5, color: '#000000', fillOpacity: 0 },
    selectedStyle: {
      // color: '#415e80', fillColor: '#415e80', 
      weight: 5, fillOpacity: 1
    },
    defaultLineWeight: lineWeight,
    defaultFillOpacity: fillOpacity,
    phenoWidth: 45,
    areaLabelWidth: 25,
    accesibiliyIcon:{
      "rossa": imagesPath+"/accessibilita-rossa.png",
      "arancione": imagesPath+"/accessibilita-arancione.png",
      "gialla": imagesPath+"/accessibilita-gialla.png",
      "verde": imagesPath+"/accessibilita-verde.png",
      "nullo": imagesPath+"/accessibilita-nullo.png",
    },
    markerIcon: {
      // @fixme L'url del marker
      //iconUrl: '/weballerte-theme/images/allerta/marker-icon.png',
      iconUrl: imagesPath+'/marker-icon.png',
      // iconRetinaUrl: './assets/img/map/marker-icon@2x.png',
      iconAnchor: [22, 94],
      popupAnchor: [-3, -76],	
    },
  
    // usate per i rtdata
    rtdata:{
      defaultStyle: {'color': '#000', 'weight': 1,'opacity': 1,'fillOpacity': .5},
      bacini:{
        defaultColor: '#46d77e',
        colors : ["#e7c6ea", "#0000FF", "#FF8000", "#d79a47", "#804000", "#FF8000", "#fd0be5", "#768ffc", "#454801", "#0099ff", "#a71036", "#f71e9c", "#1a37bc", "#1601b9", "#6b9462", "#1172eb", "#E71DB9", "#fafbb5", "#0f1325", "#f4370a", "#2fc3d7", "#99c940", "#b0a49c", "#844448", "#557822", "#66102f", "#b60b5b", "#586c2f", "#a7a89b" ],
      },
      reticolo: {
        style: {
            "clickable": true,
            "color": "#5291EF", 
            "fillColor": "transparent",
            "weight": 3,
            "opacity": 0.7,
            "fillOpacity": 0.5
        },
        hover: {
          "color": "#000099", 
          "fillOpacity": 0.9,
          "weight": 5,
        }
      },
      regione:{
        style: {
          "color": "#5291EF", 
          "fillColor": "transparent",
          "weight": 3
        }
      }
    }
  };
  
  /**
   * Used to zoom the map depending on the viewport size (see Allerta-Meteo media-breakpoints in //assets/scss/_variables.scss )
   * @constant MAP_BREAKPOINT_ZOOM
   */
  var MAP_BREAKPOINT_ZOOM = {
    "sm": 7,
    "md": 7,
    "lg": 8
  };
  
  var PHENOMENON_SCENARIO = {
    idraulica: "idraulica",
    idrogeologica: "idrogeologica",
    temporali: "temporali",
    vento: "vento",
    neve: "neve",
    temperatureEstremeAlte: "temperature-estreme-alte",
    temperatureEstremeBasse: "temperature-estreme-basse",
    mareggiate: "mareggiate",
    ghiaccioPioggiaGela: "ghiaccio-pioggia-gela",
    statoMare: "stato-mare",
    valanghe: "valanghe",
    generale: "generale"
  } 
  
  
  var ALERT_LEVEL = ["nullo","verde","gialla","arancione","rossa"];
  var ALERT_LEVEL_TEXT = ["Non pertinente", "Assenza di fenomeni significativi prevedibili", "Fenomeni localizzati", "Fenomeni diffusi", "Fenomeni ingenti ed estesi"];
  var ALERT_LEVEL_CSS_CLASS = ["alert-sign--null","alert-sign--green","alert-sign--yellow","alert-sign--orange","alert-sign--red"];
  
  var BACKOFFICE_PHENOMENON_SCENARIO = {
    monitoring: "monitoring"
  }
    
  // This is NOW time for real time data maps
  var RT_DATA_NOW = new Date;
  RT_DATA_NOW.setMilliseconds(0)
  RT_DATA_NOW.setSeconds(0)
  RT_DATA_NOW.setMinutes(RT_DATA_NOW.getMinutes()<31?0:30);
  
  var RT_DATA_DATE_LABEL_FORMAT = "DD/MM/YYYY HH:mm";
  /**
   * Interface basic definition for MapRTDataLayer
   * @param {String} key 
   * @param {Object} data 
   */
  var MapRTDataLayer = function(key, data){
    return{
      key: key,
      data: data
    }
  };
  

// Sensoristica
  var HOURS = 60*60*1000;
  var MINUTES = 60*1000;


  var SENSOR_KEY_MAP = {
  "precipitazioni": "1,0,1800/1,-,-,-/B13011",
  "idrometrico": "254,0,0/1,-,-,-/B13215",
  "temperature": "254,0,0/103,2000,-,-/B12101",
  "vento": "254,0,0/103,10000,-,-/B11002",
  "umidita": "254,0,0/103,2000,-,-/B13003",
  "pressione": "254,0,0/1,-,-,-/B10004",

}
  var SENSOR_GRAPH_URL_PREFIX = "https://allertameteo.regione.emilia-romagna.it/";
  var SENSOR_GRAPH_URL_AUTH = 'JVfpiilj'; // @FIXME: Sembra che questo codice cambi di continuo, quindi se il grafico in popup non funziona qualcosa: aggiornate il codice
  var SENSOR_GRAPH_URL_SUFFIX = {
  "precipitazioni": "precipitazioni?p_auth="+SENSOR_GRAPH_URL_AUTH+"&p_p_id=rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_vUvhrQ9NcjJP&p_p_lifecycle=1&p_p_state=exclusive&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_vUvhrQ9NcjJP__facesViewIdRender=%2FWEB-INF%2Fviews%2Fgrafico.xhtml",
  "idrometrico":    "livello-idrometrico?p_auth="+SENSOR_GRAPH_URL_AUTH+"&p_p_id=rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_Ojh3RPAc2Bj6&p_p_lifecycle=1&p_p_state=exclusive&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_Ojh3RPAc2Bj6__facesViewIdRender=%2FWEB-INF%2Fviews%2Fgrafico.xhtml",
  "temperature":    "temperature?p_auth="+SENSOR_GRAPH_URL_AUTH+"&p_p_id=rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_fxT5ffBPiPtA&p_p_lifecycle=1&p_p_state=exclusive&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_fxT5ffBPiPtA__facesViewIdRender=%2FWEB-INF%2Fviews%2Fgrafico.xhtml",
  "vento":          "vento?p_auth="+SENSOR_GRAPH_URL_AUTH+"&p_p_id=rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_XXvymfyKJ7aj&p_p_lifecycle=1&p_p_state=exclusive&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_XXvymfyKJ7aj__facesViewIdRender=%2FWEB-INF%2Fviews%2Fgrafico.xhtml",
  "umidita":        "umidita?p_auth="+SENSOR_GRAPH_URL_AUTH+"&p_p_id=rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_OwEpGfSrLcQO&p_p_lifecycle=1&p_p_state=exclusive&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_OwEpGfSrLcQO__facesViewIdRender=%2FWEB-INF%2Fviews%2Fgrafico.xhtml",
  "pressione":      "pressione?p_auth="+SENSOR_GRAPH_URL_AUTH+"&p_p_id=rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_wuBims5NpnDt&p_p_lifecycle=1&p_p_state=exclusive&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_rt_dati_WAR_datiTempoRealeprevPiogportlet_INSTANCE_wuBims5NpnDt__facesViewIdRender=%2FWEB-INF%2Fviews%2Fgrafico.xhtml",
}