/**
 * ARIA Accessibility patches for the module Bootstrap Datetimepicker https://eonasdan.github.io/bootstrap-datetimepicker/
 * It allows keyboard navigation with TAB, ARROWS, ENTER, ESC
 * 
 * USING
 * - After instanciatin $(mydiv).datetimepicker( ... ), just to $(mydiv).datetimepickerAriaPatch();
 * 
 * @author Roberto Maggi <roberto.maggi@eng.it>
 */

 (function (factory) {
    'use strict';
    if (typeof define === 'function' && define.amd) {
        // AMD is used - Register as an anonymous module.
        define(['jquery', 'moment'], factory);
    } else if (typeof exports === 'object') {
        module.exports = factory(require('jquery'), require('moment'));
    } else {
        // Neither AMD nor CommonJS used. Use global variables.
        if (typeof jQuery === 'undefined') {
            throw 'bootstrap-datetimepickerAriaPatch requires jQuery to be loaded first';
        }
        if (typeof moment === 'undefined') {
            throw 'bootstrap-datetimepickerAriaPatch requires Moment.js to be loaded first';
        }
        factory(jQuery, moment);
    }
}(function ($, moment) {
    'use strict';
    if (!$.fn.datetimepicker) {
        throw new Error('bootstrap-datetimepickerAriaPatch requires bootstrap-datetimepicker.js to be loaded first');
    }

   
    // overlod default keyboard navigation
    $.fn.datetimepicker.prototype.constructor.defaults.keyBinds = {
        up: function (widget) {
            if (!widget) {
                return;
            }
            var d = this.date() || this.getMoment();
            if (widget.find('.datepicker').is(':visible')) {
                this.date(d.clone().subtract(7, 'd'));
            } else {
                this.date(d.clone().add(this.stepping(), 'm'));
            }
            $(this.keyboardNav.DayPicker.nav[0], $(widget))[0].focus(); 
        },
        down: function (widget) {
            if (!widget) {
                this.show();
                return;
            }
            var d = this.date() || this.getMoment();
            if (widget.find('.datepicker').is(':visible')) {
                this.date(d.clone().add(7, 'd'));
            } else {
                this.date(d.clone().subtract(this.stepping(), 'm'));
            }
            $(this.keyboardNav.DayPicker.nav[0], $(widget))[0].focus(); 
        },
        'control up': function (widget) {
            if (!widget) {
                return;
            }
            var d = this.date() || this.getMoment();
            if (widget.find('.datepicker').is(':visible')) {
                this.date(d.clone().subtract(1, 'y'));
            } else {
                this.date(d.clone().add(1, 'h'));
            }
        },
        'control down': function (widget) {
            if (!widget) {
                return;
            }
            var d = this.date() || this.getMoment();
            if (widget.find('.datepicker').is(':visible')) {
                this.date(d.clone().add(1, 'y'));
            } else {
                this.date(d.clone().subtract(1, 'h'));
            }
        },
        left: function (widget) {
            if (!widget) {
                return;
            }
            var d = this.date() || this.getMoment();
            if (widget.find('.datepicker').is(':visible')) {
                this.date(d.clone().subtract(1, 'd'));
            }
            $(this.keyboardNav.DayPicker.nav[0], $(widget))[0].focus(); 
        },
        right: function (widget) {
            if (!widget) {
                return;
            }
            var d = this.date() || this.getMoment();
            if (widget.find('.datepicker').is(':visible')) {
                this.date(d.clone().add(1, 'd'));
            }
            $(this.keyboardNav.DayPicker.nav[0], $(widget))[0].focus(); 
        },
        pageUp: function (widget) {
            if (!widget) {
                return;
            }
            var d = this.date() || this.getMoment();
            if (widget.find('.datepicker').is(':visible')) {
                this.date(d.clone().subtract(1, 'M'));
            }
        },
        pageDown: function (widget) {
            if (!widget) {
                return;
            }
            var d = this.date() || this.getMoment();
            if (widget.find('.datepicker').is(':visible')) {
                this.date(d.clone().add(1, 'M'));
            }
        },
        enter: function (widget) {
            //if( keyboardNavDatePicker[keyboardNavDatePicker_curr] == '.btn[data-action="togglePicker"]' ){
            if( this.keyboardNav.DayPicker.index == 0 ){
                this.hide();
            } else {
                let f = widget.find('[data-action]:focus')
                if(f.length)
                    $(f[0]).click();
            }

        },
        escape: function () {
            this.hide();
        },
        'control space': function (widget) {
            if (!widget) {
                return;
            }
            if (widget.find('.timepicker').is(':visible')) {
                widget.find('.btn[data-action="togglePeriod"]').click();
            }
        },
        t: function () {
            this.date(this.getMoment());
        },
        'delete': function () {
            this.clear();
        },
        "shift tab": function(widget){
            if (!widget) {
                return;
            }
    
            if (widget.find('.timepicker').is(':visible')) {
            
                this.keyboardNav.TimePicker.index = ( (this.keyboardNav.TimePicker.index-1)%this.keyboardNav.TimePicker.nav.length);
                if( this.keyboardNav.TimePicker.index < 0 )
                    this.keyboardNav.TimePicker.index = this.keyboardNav.TimePicker.nav.length + this.keyboardNav.TimePicker.index;

                if( console ) console.log("[Datetimepicker ARIA Patch] SHIFT+TAB pressed  Going to "+this.keyboardNav.TimePicker.index+" / "+this.keyboardNav.TimePicker.nav[this.keyboardNav.TimePicker.index]);
                $(this.keyboardNav.TimePicker.nav[this.keyboardNav.TimePicker.index], widget).focus();    

                this.keyboardNav.DayPicker.index = 1; // keep the focus on the switch
            } else {

                this.keyboardNav.DayPicker.index = ( (this.keyboardNav.DayPicker.index-1)%this.keyboardNav.DayPicker.nav.length);
                if( this.keyboardNav.DayPicker.index < 0)
                    this.keyboardNav.DayPicker.index = this.keyboardNav.DayPicker.nav.length + this.keyboardNav.DayPicker.nav.index;
                
                if( console ) console.log("[Datetimepicker ARIA Patch] SHIFT+TAB pressed  Going to "+this.keyboardNav.DayPicker.index+" / "+this.keyboardNav.DayPicker.nav[this.keyboardNav.DayPicker.index]);
                $(this.keyboardNav.DayPicker.nav[this.keyboardNav.DayPicker.index], widget).focus();        

                this.keyboardNav.TimePicker.index = 0; // keep the focus on the switch
            }         

        },
        "tab": function(widget){
            if (!widget) {
                if( $('.datetimepicker-input').is(':focus') ){
                    $('.datetimepicker-input').siblings('.datepickerbutton').focus();
                }
                return;
            }

            

            if (widget.find('.timepicker').is(':visible')) {
                
                this.keyboardNav.TimePicker.index = ( (this.keyboardNav.TimePicker.index+1)%this.keyboardNav.TimePicker.nav.length);
                if( console ) console.log("[Datetimepicker ARIA Patch] TAB pressed  Going to "+this.keyboardNav.TimePicker.index+" / "+this.keyboardNav.TimePicker.nav[this.keyboardNav.TimePicker.index]);
                $(this.keyboardNav.TimePicker.nav[this.keyboardNav.TimePicker.index], widget).focus();    

                this.keyboardNav.DayPicker.index = 1; // keep the focus on the switch
            } else {
                
                this.keyboardNav.DayPicker.index = ( (this.keyboardNav.DayPicker.index+1)%this.keyboardNav.DayPicker.nav.length);
                if( console ) console.log("[Datetimepicker ARIA Patch] TAB pressed  Going to "+this.keyboardNav.DayPicker.index+" / "+this.keyboardNav.DayPicker.nav[this.keyboardNav.DayPicker.index]);
                $(this.keyboardNav.DayPicker.nav[this.keyboardNav.DayPicker.index], widget).focus();


                this.keyboardNav.TimePicker.index = 0; // keep the focus on the switch
            }             

    
        }

    };

    var datetimepickerAriaPatch = function(element, options){
            

        var picker = $(element).data('DateTimePicker');
        // fix some stuff
        picker.getToolbar = function () { // Fixed: we needed to add tabindex=-1 for ARIA keyboard navigation
            var row = [];
            if (options.showTodayButton) {
                row.push($('<td>').append($('<a>').attr({ 'data-action': 'today', 'title': options.tooltips.today , "tabindex": "-1"}).append($('<i>').addClass(options.icons.today))));
            }
            if (!options.sideBySide && hasDate() && hasTime()) {
                row.push($('<td>').append($('<a>').attr({ 'data-action': 'togglePicker', 'title': options.tooltips.selectTime, "tabindex": "-1" }).append($('<i>').addClass(options.icons.time))));
            }
            if (options.showClear) {
                row.push($('<td>').append($('<a>').attr({ 'data-action': 'clear', 'title': options.tooltips.clear, "tabindex": "-1" }).append($('<i>').addClass(options.icons.clear))));
            }
            if (options.showClose) {
                row.push($('<td>').append($('<a>').attr({ 'data-action': 'close', 'title': options.tooltips.close, "tabindex": "-1" }).append($('<i>').addClass(options.icons.close))));
            }
            return $('<table>').addClass('table-condensed').append($('<tbody>').append($('<tr>').append(row)));
        };


        // Create picker keyboard nav (will be fixed on load depending on what is disabled)
        picker.keyboardNav = {
            DayPicker: {
                nav: [
                    '.day.active',
                    '[data-action=togglePicker]',
                    '[data-action=previous]',
                    '[data-action=next]'
                ],
                index: 0
            },
            TimePicker: {
                nav: [
                    '[data-action=togglePicker]',
                    '[data-action=incrementHours]',
                    '[data-action=decrementHours]',
                    '[data-action=incrementMinutes]',
                    '[data-action=decrementMinutes]'
                    ],
                index: 0
            }
        };
        
        
        // overlod keyboard navigation
        var widget = $(element),
            keyMap = {
                'up': 38,
                38: 'up',
                'down': 40,
                40: 'down',
                'left': 37,
                37: 'left',
                'right': 39,
                39: 'right',
                'tab': 9,
                9: 'tab',
                'escape': 27,
                27: 'escape',
                'enter': 13,
                13: 'enter',
                'pageUp': 33,
                33: 'pageUp',
                'pageDown': 34,
                34: 'pageDown',
                'shift': 16,
                16: 'shift',
                'control': 17,
                17: 'control',
                'space': 32,
                32: 'space',
                't': 84,
                84: 't',
                'delete': 46,
                46: 'delete'
            },
            keyState = {},

            onkeydown = function(e){
            
                var handler = null,
                        index,
                        index2,
                        pressedKeys = [],
                        pressedModifiers = {},
                        keyboardNavDatePicker_currentKey = e.which,
                        keyBindKeys,
                        allModifiersPressed,
                        pressed = 'p';
    
                    keyState[keyboardNavDatePicker_currentKey] = pressed;
    
                    for (index in keyState) {
                        if (keyState.hasOwnProperty(index) && keyState[index] === pressed) {
                            pressedKeys.push(index);
                            if (parseInt(index, 10) !== keyboardNavDatePicker_currentKey) {
                                pressedModifiers[index] = true;
                            }
                        }
                    }
    
                    for (index in options.keyBinds) {
                        if (options.keyBinds.hasOwnProperty(index) && typeof (options.keyBinds[index]) === 'function') {
                            keyBindKeys = index.split(' ');
                            if (keyBindKeys.length === pressedKeys.length && keyMap[keyboardNavDatePicker_currentKey] === keyBindKeys[keyBindKeys.length - 1]) {
                                allModifiersPressed = true;
                                for (index2 = keyBindKeys.length - 2; index2 >= 0; index2--) {
                                    if (!(keyMap[keyBindKeys[index2]] in pressedModifiers)) {
                                        allModifiersPressed = false;
                                        break;
                                    }
                                }
                                if (allModifiersPressed) {
                                    handler = options.keyBinds[index];
                                    break;
                                }
                            }
                        }
                    }
    
                    if (handler) {
                        handler.call(picker, widget);
                        e.stopPropagation();
                        e.preventDefault();
                    }
                    
    
            },
            onkeyup = function (e) {
                if( e.which == 27 ){ // esc key not firing on keydown (https://stackoverflow.com/questions/19421047/why-the-keycode-event-for-escape-alone-not-working)
                    picker.hide();
                    element.find(".datetimepicker-input").focus()
                    keyState = [];
                }
                keyState[e.which] = 'r';
                e.stopPropagation();
                e.preventDefault();
                
            },
            toggleme = function(e){
                if( $(e.target).closest('[data-toggle=datetimepicker]').length < 1){
                    picker.hide();
                }
            };


        // Detach focus/blur handlers from the input box
        $(element).find('.datetimepicker-input').off("focus");
        $(element).find('.datetimepicker-input').off("blur");


        // Attach handlers
        $(element).find(".datepickerbutton").on("click", function(e){
            e.preventDefault();
            e.stopPropagation();
        });
        $(element).on("dp.show", function(){

            // reset tabindex on non focusable elements
            $('td:not(.disabled), th[data-action=previous]:not(.disabled), th[data-action=next]:not(.disabled)', element).each(function(){
                $(this).prop("tabIndex", "-1");
            })
            // keep in the nav only those elm not disabled
            var i=0, I= picker.keyboardNav.DayPicker.nav.length, newDayNav = [];
            for(;i<I;++i){
                if( !$(picker.keyboardNav.DayPicker.nav[i], $(this)).hasClass("disabled") ){
                    newDayNav.push(picker.keyboardNav.DayPicker.nav[i]);
                }
            }
            picker.keyboardNav.DayPicker.nav = newDayNav;
                
            // focus on the current day
            setTimeout((function(){
                element.find(picker.keyboardNav.DayPicker.nav[0]).focus();
                picker.keyboardNav.DayPicker.nav.index = 0;
                picker.keyboardNav.TimePicker.nav.index = 0;
            }).bind(this), 100);

            // attach handlers
            $(window).on("keydown", onkeydown);
            $(window).on("keyup", onkeyup);
            $(document).on("mouseup", toggleme);
        });
        $(element).on("dp.hide", function(){

            // detach handlers
            $(window).off("keydown", onkeydown);
            $(window).off("keyup", onkeyup);
            $(document).off("mouseup", toggleme);
            picker.keyboardNav.DayPicker.nav.index = 0;
            picker.keyboardNav.TimePicker.nav.index = 0;
        });

        $(element).on("dp.change", function(){
            element.find(picker.keyboardNav.DayPicker.nav[0]).focus();
        });
    }

        
    
    $.fn.datetimepickerAriaPatch = function(){
        datetimepickerAriaPatch($(this), $(this).data('DateTimePicker').options() );
    }
    
    return $.fn.datetimepickerAriaPatch;
}));

