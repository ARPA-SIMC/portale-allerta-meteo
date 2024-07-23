am = am || {};

am.DataMap = (function ($) {
    /**
     * @class DataMap
     * Manages the interaction on map for a single RTData (eg. Pluviometri, Livello indrometrico, vento, ecc.). Options parameter: 
     * @inheritdoc MapComponent 
     * @param {String} key The key of the rtdata to work on
     * @param {Boolean} toolbar True to show the toolbar associated to this kind of rt data, default false
     * @param {Boolean} refreshTool True to show the control for refreshing data on map
     */
    function DataMap(options) {

        if (!options)
            options = {};
        options.center = TERRITORY.RETION_LAT_LNG_FOR_RTDATA;

        // setup superclass stuff
        MapComponent.call(this, options);

        // apply defaults
        this.key = this.options.key;
        if (!this.key) {
            throw "[DataMap] No 'key' passed in the constructor. You should tell me what data scenario I should render! ";
        }

        // I should have an ID
        if ($(this.options.container)) {
            this.id = $(this.options.container).attr("id");
        } else
            this.id = "am-autogen-" + this.options.context;

        // this will be an instance of MapDataRender to manage data
        this.dataRender = null;
        this.layers = {
            terrain: null
        };

        // internal toolbar components (initialized later, if any)
        this.dtp = null;
        this.wheelSwiper = null;

        // internal semaphores
        this.latestAvailableTimeIsKnown = false;
        this.reloadingData = false;

        this.init();

    }
    // Inherit from MapComponent
    DataMap.prototype = Object.create(MapComponent.prototype);
    DataMap.prototype.constructor = DataMap;
    DataMap.prototype.init = function () {
        this.render();
        this.initToolbar();
    }
    DataMap.prototype.render = function () {

    	if( 
    		this.mapContainerId != "map--animazione--radar" &&
    		this.mapContainerId != "map--animazione--nowcasting" &&
    		this.mapContainerId != "map--dato-osservato--pressione" &&
    		this.mapContainerId != "map--dato-osservato--umidita" &&
    		this.mapContainerId != "map--dato-osservato--vento" &&
    		this.mapContainerId != "map--dato-osservato--temperatura" &&
    		this.mapContainerId != "map--dato-osservato--precipitazioni" &&
    		this.mapContainerId != "map--dato-osservato--idrometrico"
    		
    		)
    		$("#" + this.mapContainerId).empty();


        this.map = L.map(this.mapContainerId, {
            dragging: !L.Browser.mobile, // disable dragging with one thumb on mobile device
            touchZoom: L.Browser.mobile, // enable dragging with two thumbs on mobile device
            scrollWheelZoom: false, // disable scroll with the mouse wheel, it's enabled just with CTRL+wheel (see the superclass MapComponent)
            closePopupOnClick: false
        });
        this.map.setView(this.options.center, this.options.zoom);
        this.map.zoomControl.setPosition('bottomright');
        this.attachZoomBehaviour();


        // add base terrain layer
        if (this.options.terrainLayer)
            this.layers.terrain = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://openstreetmap.org">OpenStreetMap</a>',
                maxZoom: 18
            }).addTo(this.map);


        // add refresh (if needed)
        if (this.options.refreshTool) {
            this.refreshTool = L.control.rtdataUpdate().addTo(this.map);
            $('[data-trigger=refresh]', this.refreshTool.getContainer()).on("click", this.handleDataRefresh.bind(this));
        }

        // create data render
        this.dataRender = new MapDataRender({
            filterUiContext: $(this.options.container),
            map: this.map,
            dataScenarios: this.options.dataScenarios,
            currentScenario: this.key,
            renderScenarioOnLoad: false, // && this.options.renderScenarioOnLoad,
            searchTool: this.options.searchTool,
            onAfterDataRendered: this.onAfterDataRendered.bind(this)
        });

        // add legend bottoleft
        this.legend = L.control.legend({
            legendType: "observed-data-guide--" + this.key
        });
        this.legend.addTo(this.map);
        this.setupMapGuideModal();
        // add specific data legend
        this.observedDataSpecificLegend = L.control.observedDataSpecificLegend({
            legendType: "observed-data-specific--" + this.key
        });
        this.observedDataSpecificLegend.addTo(this.map);

        // Loading icon
        this.loading = L.control.loadingStatus({});
        this.loading.addTo(this.map);


        // Refresh to fit viewport size on loading
        this.refresh();



        // Code for debug
        // setInterval( (function(){
        //     if(console) console.log(this.map.getCenter());
        // }).bind(this), 5000 );
    }
    /**
     * Filter out my own modal map-guide from un-needed stuff
     * @method setupMapGuideModal
     */
    DataMap.prototype.setupMapGuideModal = function () {

        if (this.legend) {
            var c = $('.modal--map-guide--rtdata');
            var scenario = this.currentScenario;
            var _this = this;
            $('[data-if=legend]', $(c)).each(function () {

                // if there's rtdata
                if (_this.options.dataScenarios) {
                    // hide everything but what is releated to "rtdata" or to one of the scenario
                    if ($(this).attr("data-when") == 'rtdata' || _this.options.dataScenarios.indexOf($(this).attr("data-when")) > -1) {
                        $(this).show();
                    } else {
                        $(this).hide();
                        $(this).attr("aria-hidden", "true");
                    }
                }

            });
        }

    }

    DataMap.prototype.initToolbar = function () {
        var toolbarUi = $('.map-component__panel .map-toolbar', this.mapContainer);

        // NOTE: there are inner functions where "this" should be the jQuery Element, so "_this" will be the instance of DataMap
        var _this = this;

        var currentScenario = this.dataRender.getCurrentScenario();

        // Time Wheel Player
        // ---
        // We're using  https://idangero.us/swiper/ v.4.5
        $('[data-toggle=timewheel]', toolbarUi).each(function () {
            // build the Swiper for the time wheel
            _this.wheelSwiper = new Swiper($(this), {
                direction: 'horizontal',
                slidesPerView: 3,
                spaceBetween: 0,
                initialSlide: 1,
                breakpointsInverse: true,
                breakpoints: {
                    1200: {
                        slidesPerView: 5,
                        spaceBetween: 0,
                    },

                },
                autoPlay: 300,
                centeredSlides: true,
                a11y: true,
                // prevButton: $(this).prev(),
                // nextButton: $(this).next(),
                navigation: {
                    prevEl: $(this).prev(),
                    nextEl: $(this).next()
                },
                grabCursor: true,
                on: {
                    slideChangeTransitionEnd: function (sw) {
                        // Qua triggero l'evento della slide cliccata: anche se è uno slide end, per la UX è lo stesso evento
                        if (_this.wheelSwiper && !_this.isReloadingData())
                            $(_this.wheelSwiper).trigger("wheelchanged.swa.wheel", [_this.wheelSwiper, _this.wheelSwiper.activeIndex]);
                    }
                }
            });

            // legame con la input del giorno di riferimento
            $(document).on("click", '.map-toolbar__timewheel-player .swiper-container .swiper-slide a', function (e) {
                e.preventDefault();
                if ($(this).attr("data-slide") == 'false') {
                    return;
                }

                var me = parseInt($(this).attr("data-slide"));
                _this.wheelSwiper.slideTo(me);

            });

            $(_this.wheelSwiper).on("wheelchanged.swa.wheel", _this.onWheelChanged.bind(_this));

            
        });

        // Datetime picker 
        // ---
        // we're using the porting for BS4 of https://eonasdan.github.io/bootstrap-datetimepicker/#bootstrap-3-datepicker-v4-docs

        $('[data-toggle=datetimepicker]', toolbarUi).each(function () {
            var d = new Date
            d.setMilliseconds(0)
            d.setSeconds(0)
            d.setMinutes(d.getMinutes() < 31 ? 0 : 30)

            _this.dtp = $(this).datetimepicker({
                //debug: true, // delete me when going online
                locale: 'it',
                icons: {
                    time: 'icon i-clock-o',
                    date: 'icon i-calendar',
                    up: 'icon i-arrow-up',
                    down: 'icon i-arrow-down',
                    previous: 'icon i-chevron-left',
                    next: 'icon i-chevron-right',
                    today: 'icon i-calendar-check-o',
                    clear: 'icon i-trash',
                    close: 'icon i-times'
                },
                focusOnShow: false,
                allowInputToggle: false,
                stepping: 30,
                minDate: currentScenario.getTimespanMin(),
                maxDate: currentScenario.getTimespanMax(),
                date: d
            });
            $(this).datetimepickerAriaPatch(); // patch for ARIA accessibility (keyboard navigation)

            // Bound DateTimePicker to the Wheel (and vicevers)
            $(this).on("dp.change", function () {

                if (!_this.isReloadingData()) {
                    _this.reinitDateTimePickerWheel(_this.getDateTimePickerTS())
                    _this.onWheelChanged(_this.wheelSwiper, 5)
                } else {
                    if (console)
                        console.log("[DataMap / Handler of dp.change] We're realoding data, so DateTimePicker change has no effect on the Time Wheel");
                }

            });
            //
        });

        // Animation
        // ---

        // setup the animation toolbal
        $('[data-toggle=animate-data]', toolbarUi).each(function () {

            // get a ref to the dropdown
            _this.animationDropdown = $($(this).attr("data-source"));

            // attach change handler
            $(_this.animationDropdown).on("change", function () {
                _this.resetAnimationWheel(); // stop and reposition the cursor
                _this.reinitAnimationWheel(_this.getAnimationDropdownValue()); // recreate slides for the animation/navigation
            });

            // when user click to start/stop the animation
            $(this).on("click", function () {
                $(this).toggleClass("is-on");
                if ($(this).hasClass("is-on")) {
                    _this.animationPlay();
                } else {
                    // stop the animation
                    _this.animationStop();
                }
            });
        });


        // first setup
        this.loading.show();
        this.reloadingData = true;
        this.dataRender.refreshCurrentScenario((function (data, datetime) {

        	
            // Refresh timestamp of the last update time
            this.refreshDataTimestamp(datetime);

            // Reinit Timewheel slides
            if (this.dtp) { // If I have a datetimepicker 
                this.reinitDateTimePickerWheel(datetime);
                this.setDateTimePickerTS(datetime);
            } else if (this.animationDropdown) { // if I have an animation dropdown

                this.reinitAnimationDropdownValues(this.dataRender.getCurrentScenario().getAnimationOptions());
                this.reinitAnimationWheel(this.getAnimationDropdownValue());
            }

            // Fix the zoom to the correct one for this data
            this.map.setZoom(this.dataRender.getCurrentScenario().getStartupZoom());


            // Now I end the reloading data task.
            this.latestAvailableTimeIsKnown = true;
            this.reloadingData = false;
            if (console) console.log("[DataMap.dataRender.onDataUpdated] End reloading data");
            this.loading.hide();

        }).bind(this));


        //Provo a forzare la prima data al caricamento della pagina
        _this.reinitDateTimePickerWheel(_this.getDateTimePickerTS())
        
    }
    DataMap.prototype.refreshDataTimestamp = function (d) {
        if (this.refreshTool) {
            $(".map-rtdata-update__datetime", $(this.refreshTool.getContainer())).html(moment(d).format("DD/MM/YYYY HH:mm"));
        }
    }
    DataMap.prototype.handleDataRefresh = function (e) {
        e.preventDefault();
        if (this.refreshTool) {
            this.dataRender.refreshCurrentScenario((function (data, datetime) {
                this.refreshDataTimestamp(datetime);
            }).bind(this));
        }
    }
    /**
     * Tells if an ajax call is being handled to avoid loops. 
     * Note that the timewheel and the datetimepicker is sync (when you click a slide, the dtp gets aligned, when you change the dtp slides are aligned)
     */
    DataMap.prototype.isReloadingData = function () {
        return this.reloadingData;
    }
    DataMap.prototype.onWheelChanged = function (event, swiper) {

        if (this.isReloadingData()) {
            if (console) console.log("[DataMap:onWheelChanged] Still realoding data, avoid multiple requests");
            return;
        }


        if (this.dtp) { // If we have a Date Time Picker

            // @fixme: se aggiorniamo il date time picker, questo non può più essere il punto di riferimento da cui calcolare 
            // perché cambia ad ogni reload. Da capire se dobbiamo mantere così
            var ts = this.getDateTimePickerTS()
            i = swiper.activeIndex
            switch (i) {
                case 0:
                    ts -= 48 * HOURS
                    break
                case 1:
                    ts -= 24 * HOURS
                    break
                case 2:
                    ts -= 12 * HOURS
                    break
                case 3:
                    ts -= 1 * HOURS
                    break
                case 4:
                    ts -= 30 * MINUTES
                    break
                case 5:
                    break
                case 6:
                    ts += 30 * MINUTES
                    break
                case 7:
                    ts += 1 * HOURS
                    break
                case 8:
                    ts += 12 * HOURS
                    break
                case 9:
                    ts += 24 * HOURS
                    break
                case 10:
                    ts += 48 * HOURS
                    break
                /*
            case 12:
                ts += 15 * 60 * 1000*/
            }

            // Fix timezone
            ts += new Date().getTimezoneOffset() * MINUTES; //60 * 1000

        } else {
            // If we have an animation tool, each slide has it's own timestamp as data attribute
            var ts = $('[data-slide=' + swiper.activeIndex + ']', $(swiper.$el)).attr("data-val");
        }


        // Query the current scenario object for new data

        // begin the reloading taks

        if (console) console.log("[DataMap:onWheelChanged] Ricalcolo le slide e chiedo al server i dati per: " + moment(parseInt(ts)).format());

        this.loading.show();
        this.reloadingData = true;

        this.dataRender.getCurrentScenario().query({
            ts: ts,
            latestAvailableTimeIsKnown: this.latestAvailableTimeIsKnown
        }, (function (data, asyncCallback, queryParam) { // When the Server returns data

            if (console) console.log("[DataMap:onWheelChanged] Son tornati i dati dal server");

            // If there is a DatetimePicker, update the value
            if (this.dtp) {
                if (!this.latestAvailableTimeIsKnown) { // first data retrival, we use the time provided by the server
                    ts = this.dataRender.getCurrentScenario().formatUpdateDatetime(data[0].time);
                }
            }

            if (console) console.log("[DataMap:onWheelChanged] Renderizzo i nuovi dati");

            // Ask the MapDataScenario to render the new data
            this.dataRender.getCurrentScenario().renderData(data, asyncCallback, queryParam);

            // end the reloading taks
            this.reloadingData = false;
            this.loading.hide();
        }).bind(this));

    }
    /**
     * Handler called after the current scenario data has been rendered: updates the search index
     * @method onAfterDataRendered
     */
    DataMap.prototype.onAfterDataRendered = function () {
        let cs = this.dataRender.getCurrentScenario();
        if (cs.isDataSearchable())
            this.dataRender.addToSearchLayer(this.dataRender.getCurrentScenario().getDataLayers(), true);

        if (cs.isInteractive()) {
            $(this.map.zoomControl.getContainer()).show();
            this.enableMapInteraction();
        } else {
            $(this.map.zoomControl.getContainer()).hide();
            this.freezeMapInteraction();
        }

    }

    /*
     * ========================= 
     * Methods to manage the DateTimePicker
     * =========================
     */

    /**
     * @method getDateTimePickerTS
     */
    DataMap.prototype.getDateTimePickerTS = function () {
        var d = this.dtp.data("DateTimePicker").date();
        return d.valueOf(); // return the timestamp
    }
    /**
     * @method SetDateTimePickerTS
     */
    DataMap.prototype.setDateTimePickerTS = function (ts) {
        this.dtp.data("DateTimePicker").date(ts);
        if (console)
            console.log("[DataMap:setDateTimePickerTS] New dtp date is " + moment(new Date(ts)).format());
    }

    /**
     * Called when the DateTimePicker value changes
     * @method reinitDateTimePickerWheel
     */
    DataMap.prototype.reinitDateTimePickerWheel = function (ts) {


        var label
        var now = +new Date
        var inputDateTime = new Date(ts);
        this.wheelSwiper.removeAllSlides();

        if (ts <= now - 48 * HOURS)
            this.wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="+48h" data-slide="10">' + moment(inputDateTime).add(2, 'day').format(RT_DATA_DATE_LABEL_FORMAT) + '</a></div>');

        if (ts <= now - 24 * HOURS)
            this.wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="+24h" data-slide="9">' + moment(inputDateTime).add(1, 'day').format(RT_DATA_DATE_LABEL_FORMAT) + '</a></div>');

        if (ts <= now - 12 * HOURS)
            this.wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="+12h" data-slide="8">' + moment(inputDateTime).add(12, 'hour').format(RT_DATA_DATE_LABEL_FORMAT) + '</a></div>');

        if (ts <= now - 60 * MINUTES)
            this.wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="+60min" data-slide="7">' + moment(inputDateTime).add(1, 'hour').format(RT_DATA_DATE_LABEL_FORMAT) + '</a></div>');

        if (ts <= now - 30 * MINUTES)
            this.wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="+30min" data-slide="6">' + moment(inputDateTime).add(30, 'minute').format(RT_DATA_DATE_LABEL_FORMAT) + '</a></div>');

        var dt = moment(new Date(ts)).format(RT_DATA_DATE_LABEL_FORMAT)
        this.wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="' + dt + '" data-slide="5">' + dt + '</a></div>');

        this.wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="-30min" data-slide="4">' + moment(inputDateTime).subtract(30, 'minute').format(RT_DATA_DATE_LABEL_FORMAT) + '</a></div>');
        this.wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="-60min" data-slide="3">' + moment(inputDateTime).subtract(1, 'hour').format(RT_DATA_DATE_LABEL_FORMAT) + '</a></div>');
        this.wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="-12h" data-slide="2">' + moment(inputDateTime).subtract(12, 'hour').format(RT_DATA_DATE_LABEL_FORMAT) + '</a></div>');
        this.wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="-24h" data-slide="1">' + moment(inputDateTime).subtract(1, 'day').format(RT_DATA_DATE_LABEL_FORMAT) + '</a></div>');
        this.wheelSwiper.prependSlide('<div class="swiper-slide"><a href="#" data-val="-48h" data-slide="0">' + moment(inputDateTime).subtract(2, 'day').format(RT_DATA_DATE_LABEL_FORMAT) + '</a></div>');

        this.wheelSwiper.slideTo(5) // always slide to the center (that is the latest data available).
    }



    /*
     * ========================= 
     * Methods to manage the Animation 
     * =========================
     */

    DataMap.prototype.reinitAnimationDropdownValues = function (values) {
        let options = '', i = 0, I = values.length;
        for (; i < I; ++i) {
            options += '<option value="' + values[i].value + '">' + values[i].label + '</option>';
        }
        $(this.animationDropdown).html(options);
    }

    /**
     * @method getAnimationDropdownValue
     */
    DataMap.prototype.getAnimationDropdownValue = function () {
        return parseInt(this.animationDropdown.val());
    }
    /**
     * @method resetAnimationWheel
     */
    DataMap.prototype.resetAnimationWheel = function () {
        this.animationPlayable = false;
        this.wheelSwiper.slideTo(0);
    }
    /**
     * Recreate slides 
     * @method reinitAnimationWheel
     */
    DataMap.prototype.reinitAnimationWheel = function (value, step, future) {
        if (this.wheelSwiper) {

            if (!step)
                step = 15;

            // clear
            this.wheelSwiper.removeAllSlides();

            // Ask the scenario to render the correct amount of slides
            var cs = this.dataRender.getCurrentScenario();
            cs.renderSlidesForAnimation(this.wheelSwiper, value, step, future);

            // reposition
            if (future)
                this.wheelSwiper.slideTo(0);
            else
                this.wheelSwiper.slideTo(cs.getAnimationEndingSlide(this.wheelSwiper, value, step, future));
        }
    }

    DataMap.prototype.doAnimation = function () {
        if (this.wheelSwiper && this.animationPlayable) {

            if (this.wheelSwiper.isEnd) {
                this.wheelSwiper.slideTo(
                    this.dataRender.getCurrentScenario().getAnimationStartingSlide(
                        this.wheelSwiper,
                        this.getAnimationDropdownValue()
                    )
                );
            } else {
                this.wheelSwiper.slideNext();
            }

            if (this.wheelSwiper.isEnd) {
                $('[data-toggle=animate-data]', this.options.toolbarUi).trigger("click");
            } else {
                setTimeout(this.doAnimation.bind(this), 1000);
            }
        }
    }
    DataMap.prototype.animationPlay = function () {
        // disable source controller UI
        $(this.animationDropdown).prop("disabled", true);
        // Start 
        this.animationPlayable = true;
        this.doAnimation();
    }
    DataMap.prototype.animationStop = function () {
        // enable source controller UI
        $(this.animationDropdown).prop("disabled", false);
        // stop (at the next interval)
        this.animationPlayable = false;
    }



    DataMap.prototype.onBeforePrint = function () {

        if( this.wheelSwiper ){
            $('*:not(.am) .am').css("width", "262mm");
            this.wheelSwiper.update();
            this.wheelSwiper.slideReset(0, false);

            setTimeout( (function(){
                $('*:not(.am) .am').css("width", "");
                this.wheelSwiper.update();
                this.wheelSwiper.slideReset(0, false);
            }).bind(this), 5000)
            // var avg = Math.floor(this.wheelSwiper.slides.length / 2);
            // var i = this.wheelSwiper.activeIndex;
            // var x = 0;
            // if( i == avg){
            //     x = 0;
            // } else if( i > avg) {
            //     x -= i*87;
            // } else {
            //     x = i*87;
            // }

            // $(".swiper-wrapper", this.wheelSwiper.$el).css("transform: translate3d(0, 0, 0)");
            // setTimeout( (function(){
            //     //this.wheelSwiper.slideToClosest(0, false);
            //     this.wheelSwiper.updateSize();
            // }).bind(this), 200);  
                      
        }

        // Pan the map to left (the width on a 13" screen is bigger than the width on A4 sheet)
        // this.map.panBy(new L.Point(120, 0));
    }

    return DataMap;
})(jQuery);

// Global scope
var DataMap = am.DataMap