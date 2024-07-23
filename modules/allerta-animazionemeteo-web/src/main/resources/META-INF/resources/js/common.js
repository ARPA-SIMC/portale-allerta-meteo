//var theService="http://localhost:8081/api/jsonws/RT_json-portlet.testjsonrt/",
	//theService2="http://www.smr.arpa.emr.it/meteozen/rt_data/"
//var theService="http://meteozen.metarpa/rt_data/",
var
    infoSensori={},
    leVariabili={},
    iGiorni={0:'Domenica', 1:'Luned�', 2:'Marted�',3:'Mercoled�',4:'Gioved�',5:'Venerd�',6:'Sabato'},
    leStazioni={},
    theMainVars= [
    "/0,0,1800/1,-,-,-/B22001",//onda, direzione
    "/2,0,1800/1,-,-,-/B22021",//onda, altezz
    '/254,0,0/1,-,-,-/B13226', //portata?
    '/254,0,0/1,-,-,-/B10004', //pressione
    '/0,0,3600/1,-,-,-/B14198', //radiazione
    '/254,0,0/103,2000,-,-/B13003', //umidit�
    '/254,0,0/103,10000,-,-/B11002', //vento
    "/254,0,0/1,-,-,-/B13013",//neve
    '/254,0,0/1,-,-,-/B13215', // livello idrometrico
    '/1,0,3600/1,-,-,-/B13011', //precipitazione oraria
    '/254,0,0/103,2000,-,-/B12101' //temperatura
    ],
    theMainProvince= [
    'Rimini',
    'Bologna'
    ],

    //colori= ["#507c26", "#333696", "#e7c6ea", "#28f6cb", "#c1e740", "#9ff314", "#d79a47", "#2dffb2", "#12a771", "#fd0be5", "#bf3f7f", "#62556f", "#90930a", "#9b325b", "#471db0", "#02dfc1", "#036f0f", "#8a8a5c", "#5d0b2d", "#a0b018", "#768ffc", "#454801", "#86e60a", "#a71036", "#f71e9c", "#1a37bc", "#1601b9", "#6b9462", "#1172eb", "#d3f30f", "#fafbb5", "#0f1325", "#f4370a", "#2fc3d7", "#99c940", "#b0a49c", "#844448", "#557822", "#66102f", "#b60b5b", "#586c2f", "#a7a89b", "#401cc7", "#3728d9", "#889fb0", "#f2337f", "#8306a8", "#ec5f72", "#782654", "#32ee27", "#74d6cb", "#5a03fa", "#46d77e"],

    colori= ["#e7c6ea", "#0000FF", "#FF8000", "#d79a47", "#804000", "#FF8000", "#fd0be5", "#768ffc", "#454801", "#0099ff", "#a71036", "#f71e9c", "#1a37bc", "#1601b9", "#6b9462", "#1172eb", "#E71DB9", "#fafbb5", "#0f1325", "#f4370a", "#2fc3d7", "#99c940", "#b0a49c", "#844448", "#557822", "#66102f", "#b60b5b", "#586c2f", "#a7a89b" ],
    inputUser='', passWord='';

    //colore pianura: #46d77e

function fAprigrafico(theRich){
    window.open('grafico.html?r='+theRich,'_'+theRich,"width=976, height=700").focus();
    return false;
}

function isEmail(email) {
  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  return regex.test(email);
}

function isData(data) {
    //TODO
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function cercaVar(string) {
    var theVar=[];
    $.each(theVariables, function (key, value){
        if (value['req'].indexOf(string) > 0) {
            theVar['v']= value;
            theVar['k']= key;
        }
    });
    return theVar;
}

function normalizzaUnita(unitaIn) {
    var unitaOut
    switch (unitaIn) {
        case 'K' : unitaOut='°C'; break;
        case 'KG/M**2': unitaOut='mm'; break;
        case 'M': unitaOut='m'; break;
        case 'PA': unitaOut='hPA'; break;
        case 'M/S': unitaOut='m/s'; break;
        case 'W/M**2': unitaOut='W/m^2'; break;
        case 'M**3/S': unitaOut='m^3/s'; break;
        default: unitaOut=unitaIn; break;
    }
    return unitaOut;
}


function beccaInfoSensori(callback) {
    //console.log('beccaInfoSensori');
    //var start = new Date().getTime();
    $.ajax({
        url: theUrl=theService+"get-sensors/"+variabile,
        type: "GET",
        dataType: 'json',
        async: false,
        beforeSend: function (xhr) {
            if (inputUser!='') {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(inputUser+":"+passWord));
            }
             if(typeof(Storage) !== "undefined") {
                var value = jAllertaStorage.get("rt_data_"+variabile);
                if(!value){
                    return true;
                } else {
                    infoSensori = {};
                    $.each(value, function(index, value2) {
                        //var hash="_"+value2.lat+value2.network+value2.lon;
                        infoSensori[value2.station]=value2;
                    });
                    if (callback && typeof(callback) === "function") {
                        callback();
                    }
                    return false;
                }
            } else {
                return true;
            }
        },

        success: function (data2) {
            infoSensori = {};
            $.each(data2, function(index, value2){
                //var hash="_"+value.lat+value.network+value.lon;
                infoSensori[value2.station]=value2;
            });
            jAllertaStorage.set('rt_data_'+variabile, data2, {TTL: 86400000});
        },

        complete: function() {
            //console.log('always beccaInfoSensori');
            if (callback && typeof(callback) === "function") {
                callback();
            }
        }
    });
}


function beccaAnagrafica(callback) {
    //console.log("beccaAnagrafica");
    $.ajax({
        url: theUrl=theService+"get-stations",
        type: "GET",
        dataType: 'json',
        async: false,
        beforeSend: function(xhr) {
            if (inputUser!='') {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(inputUser+":"+passWord));
                return true;
            }
            if(typeof(Storage) !== "undefined") {
                var value = jAllertaStorage.get("rt_data_leStazioni");
                if(!value){
                    return true;
                } else {
                    $.each(value, function(index, value2){
                        //var hash="_"+value2.properties.lat+value2.properties.network+value2.properties.lon;
                        leStazioni[value2.id]=value2;
                    });

                    if (callback && typeof(callback) === "function") {
                        callback();
                    }
                return false;
                }
            } else {
                return true;
            }
        },
        success: function(data2) {
            //console.log("ok");
            $.each(data2, function(index, value2){
                //var hash="_"+value.properties.lat+value.properties.network+value.properties.lon;
                leStazioni[value2.id]=value2;
            });
            jAllertaStorage.set('rt_data_leStazioni', data2, {TTL: 86400000});
            /*if (callback && typeof(callback) === "function") {
                callback();
            }*/
        },

        complete: function() {
            //console.log('always beccaAnagrafica')
            if (callback && typeof(callback) === "function") {
                callback();
            }
        }
    });
    //var end = new Date().getTime();
    //console.log('beccaAnagrafica '+ (end - start));
}


/*function beccaVariabili(callback) {
//console.log('beccavariabili');
    //var start = new Date().getTime();

    $.ajax({
        url: theUrl=theService+"get-variables",
        type: "GET",
        dataType: 'json',
        async: false,
        beforeSend: function(xhr) {
            if (inputUser!='') {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(inputUser+":"+passWord))
                return true;
            }
            if(typeof(Storage) !== "undefined") {
                var value = $.jStorage.get("rt_data_leVariabili");
                if(!value){
                    return true;
                } else {
                    $.each(value, function(index, value2){
                        leVariabili['/'+value2.id]=value2;
                    });
                    if (callback && typeof(callback) === "function") {
                        callback();
                    }
                return false;
                }
            } else {
                return true;
            }
        },
        success: function(data2) {
            //console.log ("variabili", data2);
            $.each(data2, function(index, value2){
                //console.log (index, value2);
                leVariabili['/'+value2.id]=value2;
            });
            if(typeof(Storage) !== "undefined") {
                $.jStorage.set('rt_data_leVariabili', data2, {TTL: 86400000});
            }
        },
        complete: function() {
            //console.log('always beccaVariabili')
            if (callback && typeof(callback) === "function") {
                callback();
            }
        }
    });
    //var end = new Date().getTime();
    //console.log('beccaVariabili '+ (end - start));
}*/

function normalizzaValore(theValue, theVar) {
    //console.log (theValue, theVar)
    if (theValue== null) return null;
    switch (theVar) {
        case 'B14198': //radiazione
            if (theValue<0) {theValue=0;}
        break;
        case 'B12101': //temperatura
            theValue=theValue-273.15;
        break;
        case 'B10004': //pressione
            theValue=theValue/100;
        break;
        case 'B13003': //umidit�
            if (theValue>100) {theValue=100;}
            theValue=Math.round(theValue);
        break;
        case 'B13013': //neve
            if (theValue<0) {theValue=0;}
            //theValue=Math.round(theValue);
        break;

    }
    //console.log (theValue, theVar)
    return theValue;
}

function beccaVentoColore(velocita) {
    if (velocita<0.3) {colore="#CCCCCC"; scale='.3'}
    else if (velocita<1.6) {colore="#00FFFF"; scale='.4'}
    else if (velocita<3.4) {colore="#1CB8A5"; scale='.5'}
    else if (velocita<5.5) {colore="#00FF00"; scale='.6'}
    else if (velocita<8) {colore="#6BA531"; scale='.65'}
    else if (velocita<10.8) {colore="#008C30"; scale='.7'}
    else if (velocita<13.9) {colore="#FFFF00"; scale='.75'}
    else if (velocita<17.2) {colore="#FF7F00"; scale='.8'}
    else if (velocita<20.8) {colore="#FF0000"; scale='.85'}
    else if (velocita<24.5) {colore="#BF9213"; scale='.9'}
    else if (velocita<28.5) {colore="#FF00FF"; scale='.95'}
    else if (velocita<32.7) {colore="#7A11B2"; scale='1'}
    else  {colore="#0000FF"; scale='1'}
    return colore;
}


function sventolaBarba(velocita, direzione/*, Rvelocita, Rdirezione*/) {

    if (velocita<0.3) {colore="#CCCCCC"; scale='.3'}
    else if (velocita<1.6) {colore="#00FFFF"; scale='.4'}
    else if (velocita<3.4) {colore="#1CB8A5"; scale='.5'}
    else if (velocita<5.5) {colore="#00FF00"; scale='.6'}
    else if (velocita<8) {colore="#6BA531"; scale='.65'}
    else if (velocita<10.8) {colore="#008C30"; scale='.7'}
    else if (velocita<13.9) {colore="#FFFF00"; scale='.75'}
    else if (velocita<17.2) {colore="#FF7F00"; scale='.8'}
    else if (velocita<20.8) {colore="#FF0000"; scale='.85'}
    else if (velocita<24.5) {colore="#BF9213"; scale='.9'}
    else if (velocita<28.5) {colore="#FF00FF"; scale='.95'}
    else if (velocita<32.7) {colore="#7A11B2"; scale='1'}
    else  {colore="#0000FF"; scale='1'}

    nodi=Math.round(velocita*1.94254);

    if (nodi < 1) {
        return "<circle cx='32' cy='32' r='3' stroke='#CCCCCC' /><circle cx='32' cy='32' r='5' fill='none' stroke='black' stroke-width='1' />";
    } else {
        var theSVG="<g transform='rotate("+direzione+ " 32 32)'><line x1='32' y1='7' x2='32' y2='32' style='stroke: black; stroke-width:2' /><circle cx='32' cy='32' r='5' fill='"+colore+"' fill-opacity='.5' stroke='black' stroke-width='2' />"

        lAltezza=7;

        triangoli=0;
        lineaCorta=0;

        lineeLunghe=Math.floor(nodi/10);
        resto=nodi-(lineeLunghe*10);

        if ((resto >= 3) && (resto<=7)) {
            lineaCorta=1;
        }

        if (resto >= 8)  {
            lineeLunghe++
        }

        triangoli=Math.floor(lineeLunghe/5);
        lineeLunghe=lineeLunghe-(triangoli*5);

        //disegnamo i triangoli
        for (i=0; i<triangoli; i++) {
            theSVG=theSVG+"<polygon fill='black'  points='32,"+(lAltezza+(i*7))+" 42,"+(lAltezza+(i*7)+3)+" 32,"+(lAltezza+(i*7)+6)+"' />"
        }
        lAltezza=lAltezza+(8*(triangoli))

        //disegnamo le linee lunghe
        for (i=0; i<lineeLunghe; i++) {
                theSVG=theSVG+ "<g transform='rotate(-17 32 "+(lAltezza+(i*2.5))+")'><line x1='32' y1='"+(lAltezza+(i*2.5))+"' x2='26' y2='"+(lAltezza+(i*2.5))+"' style='stroke:black;stroke-width:2;' /></g>";

        }
        lAltezza=lAltezza+(2.5*(lineeLunghe-1));
        //

        offset=(lineeLunghe==0)?3:0;

        //disegnamo le linee corte
        lAltezza=lAltezza+3+offset;
        for (i=0; i<lineaCorta; i++) {
            theSVG=theSVG+ "<g transform='rotate(-17 32 "+(lAltezza+(i*2.5))+")'><line x1='32' y1='"+(lAltezza+(i*2.5))+"' x2='23' y2='"+(lAltezza+(i*2.5))+"' style='stroke:black;stroke-width:1.5;' /></g>";
        }



        /*if (Rvelocita>0) {
            return theSVG+"</g><g transform='translate(32,48)'><ellipse cx='0' cy='-4' ry='7' rx='16' style='fill:#666; opacity: .5' /><text class='laRaff' font-weight='bold' fill='#FFF' text-anchor='middle'>"+Rvelocita+"</text></g></svg></div>"
        } else {*/
            return theSVG+"</g>";
        //}
    }
}
