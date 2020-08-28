/**
 * ###################################################
 * Leaflet Controls (Extensions for AM)
 */


  /**
  * Leaflet Control for general legends to be placed on map
  */
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



  
  /**
   * ###################################################
   */
  