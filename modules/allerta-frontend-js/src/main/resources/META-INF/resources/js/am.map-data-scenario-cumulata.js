am = am || {};

am.MapDataScenarioCumulata = (function($){

    /**
     * @class MapDataScenarioCumulata
     * @extends MapDataScenarioCumulata
     * ---
     * The concrete subclass of MapDataScenario to manage common features for pioggia cumulata
     */
    function MapDataScenarioCumulata(options){
        
        options.label = 'Pioggia cumulata delle ultime '+options.cumulataHoursAmount+'H';

        // Call constructor of superclass to initialize superclass-derived members.
        MapDataScenarioImmagini.call(this, options); 
    
    }
    // Inherit from MapDataScenario
    MapDataScenarioCumulata.prototype = Object.create(MapDataScenarioImmagini.prototype);
    MapDataScenarioCumulata.prototype.constructor = MapDataScenarioCumulata;


    MapDataScenarioImmagini.prototype.renderTo = function(imageViewer, asyncUpdateCallback){
        if( console)  console.log("[MapDataScenarioCumulata.renderTo] Sto per essere aggiunto alla mappa o refreshato");
    
        if( imageViewer )
         this.viewer = imageViewer;
    
        // ask for the list of latest images
        var param = {}; 
        MapDataServer.query(this.key, {}, (function(data){

            // clear any previous data
            this.imgKeys = [];
            this.imgData = [];

            // init images 
            var pid = 0;
	        for(var id in data) {
                pid = moment(data[id]._fineCumulazione, "MMM DD, YYYY h:mm:ss A", "en").valueOf()
                this.imgKeys.push(pid);
                this.imgData[pid] = data[id];
                this.imgData[pid].label = '';
                	//this.options.label
                // NOTE: in the api, the field is actually "inzio" instead of "inizio"
                //+ ' dal '+ moment( this.imgData[ this.imgKeys[this.imgKeys.length - 1] ]._inzioCumulazione, "MMM DD, YYYY h:mm:ss A", "en").format("DD/MM/YYYY HH:mm") 
                //+ ' al ' + moment( this.imgData[ this.imgKeys[this.imgKeys.length - 1] ]._fineCumulazione, "MMM DD, YYYY h:mm:ss A", "en").format("DD/MM/YYYY HH:mm");
            }
            this.imgKeys.sort();

            this.renderData({
                ts: this.imgKeys[this.imgKeys.length - 1],
                img: this.imgData[ this.imgKeys[this.imgKeys.length - 1] ]._imgData,
                label: this.imgData[ this.imgKeys[this.imgKeys.length - 1] ].label
            }, asyncUpdateCallback);

            // refresh data every 5 minutes
            this.refreshInterval = setTimeout( this.refresh.bind(this), 5*MINUTES);

        }).bind(this));

    }

    /**
     * 
     * 
     * Render the slides for this scenario to be animated depending on the input parameters
     * @method renderSlidesForAnimation
     * @param {Swiper} wheelSwiper The instance of swiper where to put the new slide
     * @param {Number} value Hours (or reference to the value) to animate
     * @param {Number} step The animation step size
     * @param {Boolean} future True if we animate the future, false if the past.
     */
    MapDataScenarioCumulata.prototype.renderSlidesForAnimation = function(wheelSwiper, howLong, step, future){
       
        if( wheelSwiper ){
				
            var now = moment( this.imgKeys[this.imgKeys.length-1] ); // get the last available

            if( wheelSwiper.slides.length < 1){ // init slides just one time

                var start = moment(now);
                var ts = +start;
    
                var label = "", ts, date;
                var n = this.imgKeys.length - 1;
                a = this.imgKeys.length - 1;
    
                wheelSwiper.removeAllSlides();
    
                for(; a >= 0; --a){
    
                    date = moment(new Date(this.imgKeys[a]));
                    label = date.format("DD/MM/YY HH:mm");
                    ts = date.valueOf();
                    
                    wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="'+ts+'" data-slide="'+ (a) +'">'+label+'</a></div>');
                }
            }
            
        }
      
    }

        /**
     * Returns the options (time ranges) for the animation
     * @method getAnimationOptions
     * @return {Array<Object>} An array of object with two fields "value" and "label" to build the UI component
     */
    MapDataScenarioCumulata.prototype.getAnimationOptions = function(){

        if( this.imgKeys ){

            let options = [], j=0, J=this.imgKeys.length, itemInizioCumulata;
            for( ; j < J ; ++j  ){
                itemInizioCumulata = moment( this.imgData[ this.imgKeys[j] ]._inzioCumulazione, "MMM DD, YYYY h:mm:ss A", "en");
                options.unshift({
                    value: j+1,
                    label: ' dal '+ itemInizioCumulata.format("DD/MM/YYYY HH:mm")
                        +  ' al ' + itemInizioCumulata.add({"hours":  this.options.cumulataHoursAmount }).format("DD/MM/YYYY HH:mm")
                });
            }
            return options;
        } else 
            return [];
    }


    /**
     * For cumulata, the starting is the slide identified by the dropdown value
     */
    MapDataScenarioCumulata.prototype.getAnimationStartingSlide = function(wheelSwiper, value ){
        return parseInt(value);
    }
    /**
     * For cumulata, ending slide is dinamically set up depending on the dropdown
     */
    MapDataScenarioCumulata.prototype.getAnimationEndingSlide = function(wheelSwiper, value ){
        return value - 1; 
    }

    
    
  
    return MapDataScenarioCumulata;
})(jQuery);

// Global scope
var MapDataScenarioCumulata = am.MapDataScenarioCumulata