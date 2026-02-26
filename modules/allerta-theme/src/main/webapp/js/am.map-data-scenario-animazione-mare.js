am = am || {};

am.MapDataScenarioAnimazioneMare = (function($){

    /**
     * @class MapDataScenarioAnimazioneMare
     * @extends MapDataScenarioAnimazioneMare
     * ---
     * The concrete subclass of MapDataScenario to manage common features for pioggia AnimazioneMare
     */
    function MapDataScenarioAnimazioneMare(options){
        
        options.label = 'Altezza onda ';

        // Call constructor of superclass to initialize superclass-derived members.
        MapDataScenarioImmagini.call(this, options); 
    
    }
    // Inherit from MapDataScenario
    MapDataScenarioAnimazioneMare.prototype = Object.create(MapDataScenarioImmagini.prototype);
    MapDataScenarioAnimazioneMare.prototype.constructor = MapDataScenarioAnimazioneMare;


    MapDataScenarioAnimazioneMare.prototype.renderTo = function(imageViewer, asyncUpdateCallback){
        if( console)  console.log("[MapDataScenarioAnimazioneMare.renderTo] Sto per essere aggiunto alla mappa o refreshato");
    
        if( imageViewer )
         this.viewer = imageViewer;
    
        // ask for the list of latest images
        var param = {}; 
        MapDataServer.query(this.key, {}, (function(data){

            // clear any previous data
            this.imgKeys = [];
            this.imgData = [];

            // init images 
            var pid = 0, ts = null;
	        for(var id in data) {
                
                ts = moment(data[id]._ts_UTC*1000);
                if( ts.isDST() )
                    ts.add({ "hours":2 });
                else
                    ts.add({ "hours":1 });

                pid = ts.valueOf();
                this.imgKeys.push(pid);
                this.imgData[pid] = data[id];
                this.imgData[pid].label = this.options.label+ ' '+data[id]._text_LOC;
            }
            this.imgKeys.sort();

            this.renderData({
                ts: this.imgKeys[this.imgKeys.length - 1],
                img: this.imgData[ this.imgKeys[this.imgKeys.length - 1] ]._imgData,
                label:this.imgData[ this.imgKeys[this.imgKeys.length - 1] ].label
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
    MapDataScenarioAnimazioneMare.prototype.renderSlidesForAnimation = function(wheelSwiper, howLong, step, future){
       
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
                    
                    wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="'+this.imgKeys[a]+'" data-slide="'+ (a) +'">'+label+'</a></div>');
                }
            }
            
        }
      
    }

        /**
     * Returns the options (time ranges) for the animation
     * @method getAnimationOptions
     * @return {Array<Object>} An array of object with two fields "value" and "label" to build the UI component
     */
    MapDataScenarioAnimazioneMare.prototype.getAnimationOptions = function(){

        if( this.imgKeys ){

            let options = [], j=0, J=this.imgKeys.length;
            for( ; j < J ; ++j  ){
                options.unshift({ // use ".push()" if you need reverse order
                    value: j+1,
                    label: "da "+this.imgData[ this.imgKeys[j]]._text_LOC
                });
            }
            return options;
        } else 
            return [];
    }


    /**
     * For cumulata, the starting is the slide identified by the dropdown value
     */
    MapDataScenarioAnimazioneMare.prototype.getAnimationStartingSlide = function(wheelSwiper, value ){
        return parseInt(value);
    }
    /**
     * For cumulata, ending slide is dinamically set up depending on the dropdown
     */
    MapDataScenarioAnimazioneMare.prototype.getAnimationEndingSlide = function(wheelSwiper, value ){
        return value - 1; 
    }

    
    
  
    return MapDataScenarioAnimazioneMare;
})(jQuery);

// Global scope
var MapDataScenarioAnimazioneMare = am.MapDataScenarioAnimazioneMare