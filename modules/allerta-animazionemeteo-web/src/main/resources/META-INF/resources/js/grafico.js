//http://maurizzzio.github.io/function-plot/
$( document ).ready(function() {
	

moment.locale('it');
var request=getParameterByName('r'),
req={},
theRequestArray=request.split('/');
req['ident']=theRequestArray[0]; //identificativo reti mobili
req['lonlat']=theRequestArray[1].split(","); //0 è lon, 1 è lat
req['net']=theRequestArray[2];
req['time']=theRequestArray[3];
req['level']=theRequestArray[4];
req['var']=theRequestArray[5];
req['data1']=theRequestArray[6];//begin
req['data2']=theRequestArray[7];//end
var domainLowDeflusso, domainHighDeflusso,
quantGiorni = moment(req['data2']).diff(moment(req['data1']), 'days'); //compreso il giorno 0
/*@ma	
var myRequest=theRequestArray[0]+'/'+
		req['lonlat'][0]+','+req['lonlat'][1]+'/'+
		req['net']+'/'+
		req['time']+'/'+
		req['level']+'/'+
		req['var']+'/'+
		moment(req['data1']).subtract(1,'day').format('YYYY-MM-DD')+'/'+
		req['data2'];
 */
//@ma
var myRequest = "stazione=" + theRequestArray[0] + "/" + theRequestArray[1] + "/" + theRequestArray[2] + "&variabile=" + 
theRequestArray[3] + "/" + theRequestArray[4] + "/" + theRequestArray[5] 
var variabile='/'+req['time']+'/'+req['level']+'/'+req['var'],
hash=req['ident']+'/'+req['lonlat'][0]+','+req['lonlat'][1]+'/'+req['net'],
vediSoglie,
oggi24h,
valoriAssi,
timeType,
ultimo,
laStazione,
mySummary=[];
//@ma
leStazioni = {}
leStazioni[hash] = { name: data.name, network :"network", height:data.height,
		municipality: {name:"municipality"},
		provincie: {name:"provincie"},
		region: {name:"region"},
		country: {name:"country"},
		basin: {name:data.namebasin},
		macroarea : {code:"code", name:data.name},
		geometry: { coordinates: [0,0] } , subbasin:{name:data.namesubbasin}  }
infoSensori = {}
infoSensori[hash] = { height: data.height, 
		sensor:{hydroinfo:{thresholds:[data.soglia1,data.soglia2,data.soglia3], equations:[2]}}
}
leVariabili = {}
leVariabili[variabile] = { description_it: data.description, unit: data.unit }
//@ma
//console.log(variabile, hash);
function deltaTime (tipo) {
	switch (tipo) { 
	case 'UTC':
		return 2;
		//return 0;
		break;
	case 'SOL':
		return 3;
		//return 1;
		break;
	case 'LOC':
		//return (moment(req['data2']).isDST())?4:3;
		return (moment(req['data2']).isDST())?2:1;
		break;
	}
}
function tipotempo (tipo) {
	switch (tipo) {
	case 'UTC':
		return 'UTC';
		break;
	case 'SOL':
		return 'solare';
		break;
	case 'LOC':
		return 'locale';
		break;
	}
}
function identificaStaz() {
	if (leStazioni[hash]==undefined) {
		$("#anag").before('<p>Autenticarsi dalla pagina pricipale</p>')
	}
	if ( leVariabili[variabile]!== undefined) {
		$('h1').html( ((leStazioni[hash].name!=null)?leStazioni[hash].name:'NOME NON DISPONIBILE') + (' - '+leVariabili[variabile].description_it) );
	} else {
		$('h1').html( ((leStazioni[hash].name!=null)?leStazioni[hash].name:'NOME NON DISPONIBILE') + ' - *ricaricare la finestra*');
		console.log('forgot');
	}
	//$('h2').html( moment(req['data1']).format("DD.MM.YYYY")+" - "+moment(req['data2']).format("DD.MM.YYYY")+ ' <span class="timeType"></span>');
	$('.anagrafica').click( function() {
		$('#anag').toggle();
		$('#anag').animate({'height':$(window).height()-40+'px','width':$(window).width()-40+'px'},
				300);
	});
	$('.anagrafica').toggle();
	$('.dwnlData').toggle();
	$('.attendere').toggle();
	$('#infoMinime').toggle();
	$('#anag').append('<a class="close"><span>close</span></a>');
	$('#anag a.close').click( function() {
		$('#anag').animate({
			height: '100%'
		}, 300, function() {
			$('#anag').toggle();
		});
	});
	//la nostra amata anagrafica
	$('#anag').append('<h2>'+leStazioni[hash].name+'</h2>');
	$('#anag').append('<ul class="list1"><li class="titolo">Posizione</li></ul>');
	$('.list1').append('<li><span>lat:</span> '+leStazioni[hash].geometry.coordinates[1]+', <span>lon:</span> '+leStazioni[hash].geometry.coordinates[0]+'</li>');
	if ( infoSensori[hash].height) {
		$('.list1').append('<li><span>altitudine:</span> '+infoSensori[hash].height+' m</li>');
	}
	$('.list1').append('<li><span>rete:</span> '+leStazioni[hash].network+'</li>');
	/*$('.list1').append('<li><div id="miniMap"></map></li>');
			var map = L.map('miniMap', {
				center: new L.LatLng(leStazioni[hash].properties.geometry.coordinates[1], leStazioni[hash].properties.geometry.coordinates[0]),
				zoom: 7,
				dragging: false,
				scrollWheelZoom: false,
				doubleClickZoom: false,
				zoomControl: false,
				attributionControl: false,
			});
			L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
			}).addTo(map);
			L.marker([leStazioni[hash].properties.geometry.coordinates[1], leStazioni[hash].properties.geometry.coordinates[0]]).addTo(map);*/
	//sta cosa che non riesco a mettere una f077u7a mappetta nell'anagrafica mi fa andare in be.
	if (leStazioni[hash]) {
		$('#anag').append('<ul class="list2"><li class="titolo">Info amministrative</li></ul>')
		if ( leStazioni[hash].municipality && leStazioni[hash].municipality.name ) {
			$('.list2').append('<li><span>comune:</span> '+leStazioni[hash].municipality.name+'</li>');
		}
		if ( leStazioni[hash].province && leStazioni[hash].province.name ) {
			$('.list2').append('<li><span>provincia:</span> '+leStazioni[hash].province.name+'</li>');
		}
		if ( leStazioni[hash].region && leStazioni[hash].region.name &&  leStazioni[hash].country && leStazioni[hash].country.name) {
			$('.list2').append('<li><span>regione:</span> '+leStazioni[hash].region.name+', '+leStazioni[hash].country.name+'</li>');
		}
		$('#anag').append('<ul class="list3"><li class="titolo">Bacino e macroarea</li></ul>');
		if ( leStazioni[hash].basin && leStazioni[hash].basin.name ) {
			$('.list3').append('<li><span>bacino:</span> '+leStazioni[hash].basin.name+'</li>');
		}
		if ((req['var']=='B13215') || (req['var']=='B13226')) {
			if ( leStazioni[hash].subbasin && leStazioni[hash].subbasin.name ) {
				$('.list3').append('<li><span>corso d\'acqua:</span> '+leStazioni[hash].subbasin.name+'</li>');
			}
		} else  {
			if ( leStazioni[hash].subbasin && leStazioni[hash].subbasin.name ) {
				$('.list3').append('<li><span>sottobacino:</span> '+leStazioni[hash].subbasin.name+'</li>');
			}
		}
		if ( leStazioni[hash].macroarea && leStazioni[hash].macroarea.name ) {
			$('.list3').append('<li><span>macroarea:</span> '+leStazioni[hash].macroarea.code+' - '+leStazioni[hash].macroarea.name+'</li>');
		}
	}
	if (((req['var']=='B13215') || (req['var']=='B13226')) && infoSensori[hash].sensor && infoSensori[hash].sensor.hydroinfo) {
		$('#anag').append('<ul class="list5"><li class="titolo">Soglie e info idrologiche</li></ul>')
		if ( infoSensori[hash].sensor.hydroinfo.hydro_zero) {
			$('.list5').append('<li><span>zero idrometrico:</span> '+infoSensori[hash].sensor.hydroinfo.hydro_zero+' m <small><span>valido dal:</span> '+moment(infoSensori[hash].sensor.hydroinfo.hydro_zero_validity_date).format('YYYY')+'</small></li>');
		}
		if ( infoSensori[hash].sensor.hydroinfo.thresholds[0]) {
			$('.list5').append('<li><span style="color: #FFFF00">soglia 1:</span> '+infoSensori[hash].sensor.hydroinfo.thresholds[0]+' m</li>');
		}
		if ( infoSensori[hash].sensor.hydroinfo.thresholds[1]) {
			$('.list5').append('<li><span style="color: #FF6600">soglia 2:</span> '+infoSensori[hash].sensor.hydroinfo.thresholds[1]+' m</li>');
		}
		if ( infoSensori[hash].sensor.hydroinfo.thresholds[2]) {
			$('.list5').append('<li><span style="color: #FF0000">soglia 3:</span> '+infoSensori[hash].sensor.hydroinfo.thresholds[2]+' m</li>');
		}
		if ( (infoSensori[hash].sensor.hydroinfo.thresholds[0]==null) && (infoSensori[hash].sensor.hydroinfo.thresholds[1]==null) && (infoSensori[hash].sensor.hydroinfo.thresholds[2]==null) ) {
			$('.list5').append('<li>SOGLIE NON DISPONIBILI</li>');
		}
	}
	if (((req['var']=='B13215') || (req['var']=='B13226')) && infoSensori[hash].sensor && infoSensori[hash].sensor.hydroinfo && (infoSensori[hash].sensor.hydroinfo.equations.length>0)) {
		$('#anag').append('<ul class="list7"><li class="titolo">Scala di deflusso</li></ul>');
		if (infoSensori[hash].sensor.hydroinfo.outflow_scale_validity_date) {
			$('.list7').append('<li><span>valida da :</span> '+moment(infoSensori[hash].sensor.hydroinfo.outflow_scale_validity_date).format('MMM YYYY')+'</li>');
		}
		$.each( infoSensori[hash].sensor.hydroinfo.equations, function(i,v) {
			$('.list7').append('<li><span> Q ['+v.lower_level +' &lt; liv. &lt; '+v.upper_level+']:</span><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+v.formula+'</li>');
		});
	}
	if (infoSensori[hash].sensor) {
		if ( infoSensori[hash].sensor.heated ) {
			$('#anag').append('<ul class="list4"><li class="titolo">Info extra</li></ul>');
			$('.list4').append('<li><span>riscaldato:</span> '+((infoSensori[hash].sensor.heated)?'si':'no')+((infoSensori[hash].sensor.heated_from)?' <span>dal:</span> '+infoSensori[hash].sensor.heated_from:'')+'</li>');
		}
	}
	setTimeout(function(){
		if (laStazione) {
			$('#anag').append('<ul class="list8"><li class="titolo">Dati in archivio</li></ul>');
			$('.list8').append('<li><span>sensore attivo da:</span> '+moment(laStazione[variabile.substring(1).replace('B13226','B13215')].begin).format("DD MMM YYYY")+'</li>');
			$('.list8').append('<li><span>fino a <em>indicativamente</em></span> '+moment(laStazione[variabile.substring(1).replace('B13226','B13215')].end).format("DD MMM YYYY")+'</li>');
			$('#anag').append('<ul class="list9"><li class="titolo">Variabili misurate</li></ul>');
			for (var vm in laStazione) {
				var richiesta=hash+'/'+vm+'/'+req['data1']+'/'+req['data2'];
				$('.list9').append('<li><a onclick="fAprigrafico(\''+richiesta+'\')">'+leVariabili['/'+vm].description_it+'</a></li>');
			}
		}
	}, 10000);
	$(document).attr("title", ((leStazioni[hash].name!=null)?leStazioni[hash].name:'NOME NON DISPONIBILE')+' > '+leVariabili[variabile].description_it+" > "+req['data1']+"-"+req['data2']);
	$('h1').html($('h1').html().replace(' *ricaricare la finestra* ', leVariabili[variabile].description_it));
	getDataAndPlot(plotSezione);
}
d3.selection.prototype.moveToFront = function() {
	return this.each(function(){
		this.parentNode.appendChild(this);
	});
};
var it_IT = {
		"decimal": ".",
		"thousands": ",",
		"grouping": [3],
		"currency": ["$", ""],
		"dateTime": "%a %b %e %X %Y",
		"date": "%m/%d/%Y",
		"time": "%H:%M:%S",
		"periods": ["AM", "PM"],
		"days": ["Domenica", "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato"],
		"shortDays": ["Dom", "Lun", "Mar", "Mer", "Gio", "Ven", "Sab"],
		"months": ["Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"],
		"shortMonths": ["Gen", "Feb", "Mar", "Apr", "Mag", "Giu", "Lug", "Ago", "Set", "Ott", "Nov", "Dic"]
};
var IT=d3.locale(it_IT);
function make_x_axis_hours() {
	return d3.svg.axis()
	.scale(x)
	.orient("bottom")
	.ticks(d3.time.hour.utc, 1)
}
function make_x_axis() {
	return d3.svg.axis()
	.scale(x)
	.orient("bottom")
	.ticks(d3.time.hour.utc, 6)
}
function make_x_axis_days() {
	return d3.svg.axis()
	.scale(x)
	.orient("bottom")
	.ticks(d3.time.day.utc, 1)
}
function make_y_axis() {
	return d3.svg.axis()
	.scale(y)
	.orient("left")
	.ticks(5);
}
//var formattaData = d3.time.format("%H:%M %a %d.%b.%y"); //col locale in inglese
//var formattaData = IT.timeFormat.utc("%H:%M %a %d.%b.%y"); ////col locale in ita
var formattaData = IT.timeFormat.utc("%H:%M"); ////col locale in ita
var formattaData2 = IT.timeFormat.utc("%d %B"); ////col locale in ita
var margin = {top: 20, right: 50, bottom: 30, left: 50},
width = 960 - margin.left - margin.right,
height = 500 - margin.top - margin.bottom;
var parseDate = d3.time.format.utc("%Y-%m-%dT%H:%M:%SZ").parse,
bisectDate = d3.bisector(function(d) { return d.t; }).right,
bisectDateDef = d3.bisector(function(d) { return d.defX; }).right,
formatValue = ((req['var']=='B13215')||(req['var']=='B13013'))?d3.format(",.2f"):d3.format(",.1f"),
		formatVal= function(d) { return (d!=null)?formatValue(d):'nd'; };
		var x = d3.time.scale.utc().range([0, width]);
		var y = d3.scale.linear().range([height, 0]);
		var cum = d3.scale.linear().range([height, 0]);
		var raffiche = d3.scale.linear().range([height, 0]);
		var xAxis = d3.svg.axis()
		.scale(x)
		.orient("bottom")
		.ticks(d3.time.hour.locale, 6)
		//.tickFormat( function(d) { return (moment(d).utc().format('HH')=='00')?formattaData2(d): moment(d).utc().format('HH:mm') } );
		.tickFormat( function(d) { return moment(d).utc().format('H') } );
		var yAxis = d3.svg.axis()
		.scale(y)
		.orient("left").ticks(5);
		if (req['var']=='B13011') { //precipitazione
			var yCumAxis = d3.svg.axis().scale(cum).orient("right").ticks(6);
			var lineP = d3.svg.line()
			.defined(function(d) {  return d.v != null; })
			.x(function(d) { return x(d.t); })
			.y(function(d) { return cum(d.c); });
		}
		if (req['var']=='B11002') { //ilvento
			var yRafficheAxis = d3.svg.axis().scale(raffiche).orient("right").ticks(6);
			var lineRaffiche = d3.svg.line()
			.defined(function(d) {  return d.v != null; })
			.x(function(d) { return x(d.t); })
			.y(function(d) { return raffiche(d.v); });
		}
		var line = d3.svg.line()
		.defined(function(d) {  return d.v != null; })
		.x(function(d) { return x(d.t); })
		.y(function(d) { return y(d.v); });
		function getDataAndPlot(callback) {
			var dataRaffiche=[], arrayLabelRaffiche={};
			if (typeof(Storage) !== "undefined") {
				vediSoglie = jAllertaStorage.get("rt_data_vediSoglie");
				oggi24h= jAllertaStorage.get("rt_data_oggi24h");
				valoriAssi= jAllertaStorage.get("rt_data_valoriAssi");
				timeType = jAllertaStorage.get("rt_data_timeType");
				vediSoglie = 1
				oggi24h = true
				valoriAssi= true
				//@ma
				$.each(jAllertaStorage.get("rt_data_summary") || [], function(i,k){
					if (mySummary[k.station]===undefined) {
						mySummary[k.station]=[];
					}
					mySummary[k.station][k.variable]=k;
				});
				laStazione=mySummary[hash];
			}
			if (!vediSoglie) {vediSoglie=false;}
			if (!oggi24h) {oggi24h=false;}
			if (!valoriAssi) {valoriAssi=false;}
			if (!timeType) {timeType='LOC';}
			$('.timeType').removeClass('timeLOC timeSOL timeUTC').text(timeType).addClass('time'+timeType);
			var svg = d3.select("body").append("svg").attr("class", "theGrafico")
			.attr("width", width + margin.left + margin.right)
			.attr("height", height + margin.top + margin.bottom)
			.append("g")
			.attr("transform", "translate(" + margin.left + "," + margin.top + ")");
			$.ajax({
				//@ma
				url: theService+"get-time-series/?"+myRequest,
				type: "GET",
				dataType: 'json',
				beforeSend: function(xhr) {
					if (inputUser!='') {
						xhr.setRequestHeader("Authorization", "Basic " + btoa(inputUser+":"+passWord))
					}
				},
				success: function (myTS) {
					var myEndDate=moment(req['data2']+'T00:00:00Z').add(1,'days');
					var myStartDate=moment(req['data1']+'T00:00:00Z');
					var data=[];
					$.each(myTS, function(i,v) { //elimino dati troppo vecchi
						if ( moment(v.t).isBetween( moment(myStartDate).utc().subtract(deltaTime(timeType),'hours').subtract(1, 'seconds') , moment(myEndDate).utc().subtract(deltaTime(timeType),'hours').add(1,'seconds') ) ){
							data.push(v);
						}
					});
					myTS= null;
					var cont=0;
					//console.log(data[0], data[data.length-1]);
					//moment(req['data2']).diff(moment(req['data1']), 'days');
					if (data.length!=0) {
						var myDataNullFinale=moment(data[data.length-1].t);
						while ( (data[data.length-1].v == null) && ( moment(data[data.length-1].t) > myDataNullFinale.subtract(2, 'hours')) ) {
							//console.log(data[data.length-1]);
							data.pop();
						}
						quantGiorni= moment(data[data.length-1].t).diff(moment(data[0].t),'days');
						ultimo=data[data.length-1];
						$(".ultDato").text(normalizzaValore(ultimo.v, req['var']).toFixed(1)+' ' +normalizzaUnita(leVariabili[variabile].unit)+ (location.search.match(/variabile=1,0,(3600|1800)\/1,-,-,-\/B13011/i) ? (leVariabili["/1,0,3600/1,-,-,-/B13011"] ? "/1h" : "/30'") : ""));
						$(".ultOre").html( moment(ultimo.t).utc().add(deltaTime(timeType),'hours').format("HH:mm") +' <span class="timeType time'+timeType+'">'+tipotempo(timeType)+'</span>'  );
						$(".ultGiorno").text( moment(ultimo.t).utc().add(deltaTime(timeType),'hours').format("ddd DD MMM YYYY")  );
						$('.basin').text( ( leStazioni[hash].basin && leStazioni[hash].basin.name )?leStazioni[hash].basin.name:'non disponibile' );
						$('.subbasin').text( ( leStazioni[hash].subbasin && leStazioni[hash].subbasin.name )?leStazioni[hash].subbasin.name:'non disponibile' );
						if ((req['var']=='B13215') || (req['var']=='B13226')) {
							$('.subba').html( $('.subba').html().replace('sottobacino','corso d\'acqua') );
						}
						$('.quota').text( ( leStazioni[hash] && leStazioni[hash].height )?leStazioni[hash].height: 'ND' );
					}
					if (data.length==0) {
						data=[{t:moment(myStartDate).utc().subtract(deltaTime(timeType),'hours').format('YYYY-MM-DDTHH:mm:ssZ'), v:null},{t:moment(myEndDate).utc().subtract(deltaTime(timeType),'hours').format('YYYY-MM-DDTHH:mm:ssZ'), v:null}];
						$('h1').html($('h1').text()+ " DATI NON DISPONIBILI!!");
					}
					if (req['var']=='B13011') {var cont=0;}//precipitazione
					data.forEach(function(d) {
						d.t = parseDate(moment(d.t).utc().add(deltaTime(timeType),'hours').format("YYYY-MM-DDTHH:mm:ss[Z]"));
						d.v = normalizzaValore(d.v, req['var']);
						if (req['var']=='B13011') { //se è preci mi calcolo la cumulata
							cont=cont+d.v
							d.c=cont;
						}
					});
					$('.dwnlData').click( function() {
						$('#frm_dexter').empty();
						$('#frm_dexter').show();
						$('#frm_dexter').animate({
							height: '100%'
						});
						$('#frm_dexter').append('<a class="close"><span>close</span></a>');
						$('#frm_dexter a.close').click( function() { //la chiusura
							$('#frm_dexter').animate({
								height: '0'
							}, 300, function() {
								$('#frm_dexter').hide();
							});
						});
						//il form
						$('#frm_dexter').append('<p><input type="email" name="email" placeholder="*indirizzo e-mail valido" required /></p>');
						$('#frm_dexter').append('<p><input type="date" name="data1" placeholder="data inizio YYYY-MM-DD" value="'+moment().subtract(7,'days').format('YYYY-MM-DD')+'" /></p>');
						$('#frm_dexter').append('<p><input type="date" name="data2" placeholder="data fine YYYY-MM-DD" value="'+moment().format('YYYY-MM-DD')+'" /></p>');
						$('#frm_dexter').append('<p>formato<br />csv <input type="radio" name="fmt" value="csv" /> xls<input type="radio" name="fmt" value="xls" /></p>');
						//$('#frm_dexter').append('<div class="g-recaptcha" data-sitekey="6Ld6bw8TAAAAACTo5CEA-m7GpBVSzZXtt8R0Z2lL"></div>');
						$('#frm_dexter').append('<p><button>GO</button></p>');
						$('#frm_dexter button').click( function() {
							$.ajax({
								url: theService.replace('rt_data/','debra/api/data?station=')+hash+'&variable='+variabile.substring(1)+'&email='+$('input[name="email"]').val()+'&begin_datetime='+$('input[name="data1"]').val()+'T00:00:00Z&end_datetime='+$('input[name="data2"]').val()+'T23:59:59Z'+'&fmt='+$('input[name="fmt"]:checked').val(),
								type: "GET",
								dataType: 'json',
								beforeSend: function(xhr) {
									if (inputUser!='') {
										xhr.setRequestHeader("Authorization", "Basic " + btoa(inputUser+":"+passWord))
									}
								},
								success: function (data) {
									alert ("richiesta inviata, verificare la presa in carico in email. successivamente saranno recapitati i dati al medesimo indirizzo\n alla richiesta è assegnato l'id: "+data.task);
								},
								complete: function () {
									$('#frm_dexter a.close').click(); //chiudo la finestra dexteriana
								},
								error: function(data) {
									//console.log(data);
									alert('errore '+data.status+"\n il servizio ha ripsposto: "+data.responseText)
								}
							});
						});
					});
					var min=d3.min(data, function(d) { return d.v; });
					var max=d3.max(data, function(d) { return d.v; });
					if (max==undefined) {max=9};
					if (min==undefined) {min=1};
					x.domain([data[0].t, data[data.length - 1].t]);
					if ( oggi24h && (req['data2']==moment().format("YYYY-MM-DD")) ) {x.domain([data[0].t, moment(myEndDate).utc()]);}
					//arrotondo max e min
					switch (req['var']) {
					case 'B12101': //temperatura
						if (min<0) {min=Math.floor(min/5)*5} else {min=0}
						if (max>10) {max=Math.ceil((max+.1)/10)*10} else {max=10}
						//x.domain([data[0].t, data[data.length - 1].t]);
						y.domain([min,max]);
						break;
					case 'B13011': //precipitazione
						min=0
						max=Math.ceil((max+.1)/5)*5
						//x.domain([data[0].t, data[data.length - 1].t]);
						y.domain([min,max]);
						cum.domain([min, Math.ceil( d3.max(data, function(d) { return d.c; })/10)*10])
						break;
					case 'B14198': //radiazione
						min=0
						if (max>1000) {max=Math.ceil((max+.1)/100)*100} else {max=1000}
						//x.domain([data[0].t, data[data.length - 1].t]);
						y.domain([min,max]);
						break;
					case 'B10004': //pressione
						min=Math.floor(min/100)*100
						if (max>1000) {max=Math.ceil((max+.1)/100)*100} else {max=1000}
						//x.domain([data[0].t, data[data.length - 1].t]);
						y.domain([min,max]);
						break;
					case 'B11002': //vento
						min=0;
						max=Math.ceil((max+.1)/5)*5;
						//x.domain([data[0].t, data[data.length - 1].t]);
						y.domain([min,max]);
						//disegnamo le raffiche, se esistono
						var theReqRaffiche=req['ident']+'/'+req['lonlat'][0]+','+req['lonlat'][1]+'/'+req['net']+'/205,0,600/'+req['level']+'/B11041/'+moment(req['data1']).subtract(1,'day').format('YYYY-MM-DD')+'/'+req['data2']
						//console.log(theReqRaffiche);
						$.ajax({
							url: theService+"get-time-series/"+theReqRaffiche,
							type: "GET",
							async: false,
							dataType: 'json',
							beforeSend: function(xhr) {
								if (inputUser!='') {
									xhr.setRequestHeader("Authorization", "Basic " + btoa(inputUser+":"+passWord))
								}
							},
							success: function (myRaffiche) {
								if ((myRaffiche).length>0) {
									//var myEndDate=moment(req['data2']+'T00:00:00Z').add(1,'days');
									//var myStartDate=moment(req['data1']+'T00:00:00Z');
									$.each(myRaffiche, function(i,v) { //elimino dati troppo vecchi
										if ( moment(v.t).isBetween( moment(myStartDate).utc().subtract(deltaTime(timeType),'hours').subtract(1, 'seconds') , moment(myEndDate).utc().subtract(deltaTime(timeType),'hours').add(1,'seconds') ) ){
											dataRaffiche.push(v);
										}
									});
									myRaffiche= null;
									var cont=0;
									var myDataNullFinale=moment(data[data.length-1].t);
									while ( (dataRaffiche[dataRaffiche.length-1].v == null) && ( moment(dataRaffiche[dataRaffiche.length-1].t) > myDataNullFinale.subtract(2, 'hours')) ) {
										dataRaffiche.pop();
									}
									dataRaffiche.forEach(function(d) {
										d.t = parseDate(moment(d.t).utc().add(deltaTime(timeType),'hours').format("YYYY-MM-DDTHH:mm:ss[Z]"));
										d.v = normalizzaValore(d.v, req['var']);
									});
									var maxRaffiche=d3.max(dataRaffiche, function(d) { return d.v; });
									maxRaffiche=Math.ceil((maxRaffiche+.1)/5)*5;
									if (maxRaffiche > max) {
										max=maxRaffiche;
									}
									//xRaffi.domain([data[0].t, data[data.length - 1].t]);
									raffiche.domain([0,maxRaffiche]);
									//var svg = d3.select(".theGrafico");
									y.domain([min,max]);
									//if ( oggi24h && (req['data2']==moment().format("YYYY-MM-DD")) ) {x.domain([data[0].t, moment(myEndDate).utc()]);}
									svg.append("g")
									.attr("class", "y axis")
									.attr("transform", "translate("+ (width)+ ",0 )")
									//.call(yRafficheAxis)
									.append("text")
									.attr("transform", "rotate(-90)")
									.attr("y", 6)
									.attr("dy", "-1em")
									.style({"text-anchor": "end", 'fill': 'red'})
									.text("raffiche ("+normalizzaUnita(leVariabili[variabile].unit)+')');
									/*svg.append("path")
										.datum(dataRaffiche)
										.attr("class", "lineP")
										.attr("d", lineRaffiche);*/
									var svgRaffiche=svg.append("g").attr("class", "leRaffiche")
									$.each(dataRaffiche, function(i,v) {
										svgRaffiche.append("circle")
										.attr('cx', x(v.t))
										.attr('cy', y(v.v))
										.attr('r', '2')
										.style({'fill':'red'});
										arrayLabelRaffiche[v.t]=v.v;
									});
									/*$.each(dataRaffiche, function(i,v) {
										console.log (i, v.t, x(v.t), v.v, y(v.v));
									});*/
								} else {
									//noraffiche, provo l'altra
									var theReqRaffiche=req['ident']+'/'+req['lonlat'][0]+','+req['lonlat'][1]+'/'+req['net']+'/2,0,3600/103,10000,-,-/B11002/'+moment(req['data1']).subtract(1,'day').format('YYYY-MM-DD')+'/'+req['data2']
									$.ajax({
										//http://www.smr.arpa.emr.it/meteozen/rt_data/spatialseries/2,0,3600/103,10000,-,-/B11002/2016-04-07T11:00:00
										url: theService+"get-time-series/"+theReqRaffiche,
										type: "GET",
										async: false,
										dataType: 'json',
										beforeSend: function(xhr) {
											if (inputUser!='') {
												xhr.setRequestHeader("Authorization", "Basic " + btoa(inputUser+":"+passWord))
											}
										},success: function (myRaffiche) {
											if ((myRaffiche).length>0) {
												//var myEndDate=moment(req['data2']+'T00:00:00Z').add(1,'days');
												//var myStartDate=moment(req['data1']+'T00:00:00Z');
												$.each(myRaffiche, function(i,v) { //elimino dati troppo vecchi
													if ( moment(v.t).isBetween( moment(myStartDate).utc().subtract(deltaTime(timeType),'hours').subtract(1, 'seconds') , moment(myEndDate).utc().subtract(deltaTime(timeType),'hours').add(1,'seconds') ) ){
														dataRaffiche.push(v);
													}
												});
												myRaffiche= null;
												var cont=0;
												var myDataNullFinale=moment(data[data.length-1].t);
												while ( (dataRaffiche[dataRaffiche.length-1].v == null) && ( moment(dataRaffiche[dataRaffiche.length-1].t) > myDataNullFinale.subtract(2, 'hours')) ) {
													dataRaffiche.pop();
												}
												dataRaffiche.forEach(function(d) {
													d.t = parseDate(moment(d.t).utc().add(deltaTime(timeType),'hours').format("YYYY-MM-DDTHH:mm:ss[Z]"));
													d.v = normalizzaValore(d.v, req['var']);
												});
												var maxRaffiche=d3.max(dataRaffiche, function(d) { return d.v; });
												maxRaffiche=Math.ceil((maxRaffiche+.1)/5)*5;
												if (maxRaffiche > max) {
													max=maxRaffiche;
												}
												//xRaffi.domain([data[0].t, data[data.length - 1].t]);
												raffiche.domain([0,maxRaffiche]);
												//var svg = d3.select(".theGrafico");
												y.domain([min,max]);
												//if ( oggi24h && (req['data2']==moment().format("YYYY-MM-DD")) ) {x.domain([data[0].t, moment(myEndDate).utc()]);}
												svg.append("g")
												.attr("class", "y axis")
												.attr("transform", "translate("+ (width)+ ",0 )")
												//.call(yRafficheAxis)
												.append("text")
												.attr("transform", "rotate(-90)")
												.attr("y", 6)
												.attr("dy", "-1em")
												.style({"text-anchor": "end", 'fill': 'red'})
												.text("velocità massima oraria scalare ("+normalizzaUnita(leVariabili[variabile].unit)+')');
												/*svg.append("path")
													.datum(dataRaffiche)
													.attr("class", "lineP")
													.attr("d", lineRaffiche);*/
												var svgRaffiche=svg.append("g").attr("class", "leRaffiche")
												$.each(dataRaffiche, function(i,v) {
													svgRaffiche.append("circle")
													.attr('cx', x(v.t))
													.attr('cy', y(v.v))
													.attr('r', '2')
													.style({'fill':'red'});
													arrayLabelRaffiche[v.t]=v.v;
												});
												/*$.each(dataRaffiche, function(i,v) {
													console.log (i, v.t, x(v.t), v.v, y(v.v));
												});*/
											}
										}
									});
								}
							}
						});
						break;
					case 'B13003': //umidita
						min=0
						max=100;
						//x.domain([data[0].t, data[data.length - 1].t]);
						y.domain([min,max]);
						break;
					case 'B13226':
						min=Math.floor((min-.1)/5)*5;
						if (min<0) {min=0}
						max=Math.ceil((max+.1)/5)*5;
						//x.domain([data[0].t, data[data.length - 1].t]);
						y.domain([min,max]);
						break;
					case 'B13215': //livello idro
						//var soglie= new Array(); //da cancellare
						var mieSoglie=infoSensori[hash];
						//console.log(mieSoglie);
						if (mieSoglie) {
							var soglie=new Array( (mieSoglie.sensor && mieSoglie.sensor.hydroinfo && mieSoglie.sensor.hydroinfo.thresholds[0])?mieSoglie.sensor.hydroinfo.thresholds[0]:null  , (mieSoglie.sensor && mieSoglie.sensor.hydroinfo && mieSoglie.sensor.hydroinfo.thresholds[1])?mieSoglie.sensor.hydroinfo.thresholds[1]:null, (mieSoglie.sensor && mieSoglie.sensor.hydroinfo &&  mieSoglie.sensor.hydroinfo.thresholds[2])?mieSoglie.sensor.hydroinfo.thresholds[2]:null);
							if (vediSoglie==1) {//aggiungiamo l'opzione per mostrare o meno le soglie sempre;
								$.each(soglie, function(key, value) { //aggiungo le eventuali soglie nei massimi e nei minimi in modo che siano sempre visibili
									if (value!=null) {
										if (value > max) {max=value;}
										if (value < min) {min=value;}
									}
								});
							}
						}
						min=Math.floor(min-.1);
						max=Math.ceil(max+.1);
						//x.domain([data[0].t, data[data.length - 1].t]);
						y.domain([min,max]);
						break;
					case 'B13013': //neve
						min= 0;
						max=Math.ceil((max+.1)/3)*3;
						break;
					default:
						if (min<0) {min=Math.floor(min/5)*5} else {min=0}
					max=Math.ceil((max+.1)/5)*5;
					//x.domain([data[0].t, data[data.length - 1].t]);
					y.domain([min,max]);
					break;
					}
					if ( oggi24h && (req['data2']==moment().format("YYYY-MM-DD")) ) {x.domain([data[0].t, moment(myEndDate).utc()]);}
					svg.append("g")
					.attr("class", "x axis")
					.attr("transform", "translate(0," + height + ")")
					.call(xAxis);
					svg.append("g")
					.attr("class", "y axis")
					.call(yAxis)
					.append("text")
					.attr("transform", "rotate(-90)")
					.attr("y", 6)
					.attr("dy", ".71em")
					.style({"text-anchor": "end", 'fill': 'steelblue'})
					.text(leVariabili[variabile].description_it+" ("+normalizzaUnita(leVariabili[variabile].unit)+')');
					//aggiungiamo i nomi dei giorni in basso
					for (i=0; i<=quantGiorni; i++) {
						///var lungGiorno=x( moment(req['data1']).add(i+1, 'days') )-x( moment(req['data1']).add(i, 'days') );
						var lungGiorno=x( moment(data[0].t).add(i+1, 'days') )-x( moment(data[0].t).add(i, 'days'));
						var fontsize = '14px';
						if (quantGiorni>=5) {
							fontsize='10px';
						}
						if (quantGiorni>=8) {
							fontsize='8px';
						}
						if (quantGiorni>=10) {
							fontsize='6px';
						}
						svg.append('rect')
						.attr('class', 'ilGiorno')
						.attr('x', x(moment(data[0].t).add(i,'days') )+lungGiorno/4+lungGiorno/8 )
						.attr('y', height+8 )
						.attr('width', lungGiorno/4 )
						.attr('height',30 )
						.attr('style', 'fill: #FFF; opacity: .7');
						d3.select(".theGrafico").append('text')
						.attr('x',  x( moment(data[0].t).add(i, 'days') )+margin.left  +lungGiorno/2)
						.attr('y', height+46 )
						.style({"text-anchor": "middle", 'fill':'#35B53A', 'font-weight': 'bold', 'font-size': fontsize})
						.text(moment(data[0].t).add(i, 'days').format("ddd DD MMM YYYY") );
					}
					if (req['var']=='B13011') {//se è preci
						svg.append("g")
						.attr("class", "y axis")
						.attr("transform", "translate("+ (width)+ ",0 )")
						.call(yCumAxis)
						.append("text")
						.attr("transform", "rotate(-90)")
						.attr("y", 6)
						.attr("dy", "-1em")
						.style({"text-anchor": "end", 'fill': 'red'})
						.text("cumulata ("+normalizzaUnita(leVariabili[variabile].unit)+')');
						/*var barWidth=(x(data[1].t)-x(data[0].t)); //mi calcolo la frequenza
					svg.selectAll(".bar")
						.data(data)
						.enter().append("rect")
						.attr("class", "bar")
						.attr("x", function(d) { return x(d.t)- barWidth; })
						.attr("width", barWidth)
						.attr("y", function(d) { return y(d.v); })
						.attr("height", function(d) {return height - y(d.v); });*/
					}
					svg.append("g")
					.attr("class", "grid")
					.call(make_y_axis()
							.tickSize(-width, 0, 0)
							.tickFormat("")
					);
					svg.append("g") //ore
					.attr("class", "grid2")
					.attr("transform", "translate(0," + height + ")")
					.call(make_x_axis_hours()
							.tickSize(-height, 0, 0)
							.tickFormat("")
							//.style({'color': 'red'})
					);
					svg.append("g")  //6ore
					.attr("class", "grid4")
					.attr("transform", "translate(0," + height + ")")
					.call(make_x_axis()
							.tickSize(-height, 0, 0)
							.tickFormat("")
							//.style({'color': 'red'})
					);
					svg.append("g")
					.attr("class", "grid3")
					.attr("transform", "translate(0," + height + ")")
					.call(make_x_axis_days()
							.tickSize(-height, 0, 0)
							.tickFormat("")
					);
					if (req['var']=='B13215') {//mettiamo le soglie � un livello idro
						$.each(soglie, function(key, value) {
							if (value!=null) {
								svg.append("line")
								.attr('class', 'threshold_'+key)
								.attr('x1',0)
								.attr('y1', y(value))
								.attr('x2', width)
								.attr('y2', y(value));
								svg.append("text").attr("x", 15+30*key)
								.attr("y", y(value))
								.attr("dy", '-.3em')
								.text(value+' m');
							}
						});
					}
					if (req['var']=='B11002') { //se è il vento
						svg.select('.leRaffiche').moveToFront();
						svgWindCont=svg.append('g')
						$.ajax({
							url:theService+"get-time-series?"+myRequest.replace('B11002','B11001'),
							type: "GET",
							dataType: 'json',
							async: false,
							beforeSend: function(xhr) {
								if (inputUser!='') {
									xhr.setRequestHeader("Authorization", "Basic " + btoa(inputUser+":"+passWord))
								}
							},
							success: function(dataDir) {
								var leDirezioni={};
								$.each(dataDir, function(key, value) {
									leDirezioni[parseDate(moment(value.t).utc().add(deltaTime(timeType),'hours').format("YYYY-MM-DDTHH:mm:ss[Z]"))]=value.v
								});
								$.each ( data, function (key, value) {//bisogna fare le barbe del vento
									var cx=x(value.t);
									var cy=y(value.v);
									if (value.v!=null) {
										if (value.v<.3) {
											svgWindCont.append('circle')
											.attr('cx', cx)
											.attr('cy', cy)
											.attr('r', 5)
											.style({'fill': '#FFF', 'stroke':'#CCC', 'stroke-width':'2'});
											svgWindCont.append('circle')
											.attr('cx', cx)
											.attr('cy', cy)
											.attr('r', 2)
											.style({'fill': '#CCC', 'stroke':'#CCC', 'stroke-width':'2'});
										} else {
											var thisWind=svgWindCont.append('g').attr('height','64').attr('width','64')
											.attr('transform','translate(' + (cx-32) + ',' + (cy-32) + ')')
											.append("g")
											.attr('transform','rotate('+(leDirezioni[value.t] || 0)+' 32 32)');
											thisWind.append('line')
											.attr('x1','32')
											.attr('y1','7')
											.attr('x2','32')
											.attr('y2','32')
											.attr('class','lineaGrigia');
											thisWind.append('circle')
											.attr('cx', 32)
											.attr('cy', 32)
											.attr('r', 5)
											.style({'fill': beccaVentoColore(value.v), 'stroke':'#AAA', 'stroke-width':'2'})
											var nodi=Math.round(value.v*1.94254),
											lAltezza=7,
											triangoli=0,
											lineaCorta=0,
											lineeLunghe=Math.floor(nodi/10),
											resto=nodi-(lineeLunghe*10);
											if ((resto >= 3) && (resto<=7)) {lineaCorta=1;}
											if (resto >= 8)  {lineeLunghe++;}
											var triangoli=Math.floor(lineeLunghe/5),
											lineeLunghe=lineeLunghe-(triangoli*5);
											//disegnamo i triangoli
											for (i=0; i<triangoli; i++) {
												thisWind.append('polygon')
												.attr('fill','#000')
												.attr('points','32, '+(lAltezza+(i*7))+" 42,"+(lAltezza+(i*7)+3)+" 32,"+(lAltezza+(i*7)+6) );
											}
											lAltezza=lAltezza+(8*(triangoli))
											//disegnamo le linee lunghe
											for (i=0; i<lineeLunghe; i++) {
												thisWind.append('g')
												.attr('transform','rotate(-17 32 '+(lAltezza+(i*2.5))+')')
												.append('line')
												.attr('x1', 32 )
												.attr('y1', lAltezza+(i*2.5) )
												.attr('x2', 42 )
												.attr('y2', lAltezza+(i*2.5) )
												.attr('class','lineaGrigia');
											}
											lAltezza=lAltezza+(2.5*(lineeLunghe-1))
											var offset=(lineeLunghe==0)?3:0
													//disegnamo le linee corte
													lAltezza=lAltezza+3+offset;
											for (i=0; i<lineaCorta; i++) {
												thisWind.append('g')
												.attr('transform','rotate(-17 32 '+(lAltezza+(i*2.5))+')')
												.append('line')
												.attr('x1', 32 )
												.attr('y1', lAltezza+(i*2.5) )
												.attr('x2', 39 )
												.attr('y2', lAltezza+(i*2.5) )
												.attr('class','lineaGrigia');
											}
										}
									}
								});
							}
						});
					} else { // se NON è il vento
						//vediamo se è una cumulata
						var arrayTempo = req['time'].split(",");
						p2=arrayTempo[2];
						if (p2 > 0) { //è una cumulata, grafico a barre
							var barWidth=(x(moment(data[0].t).add(p2, 'seconds'))-x(data[0].t)); //mi calcolo la larghezza dalla barra
							svg.selectAll(".bar")
							.data(data)
							.enter().append("rect")
							.attr("class", "bar")
							.attr("x", function(d) { return x(d.t)- barWidth; })
							.attr("width", barWidth)
							.attr("y", function(d) { return y(d.v); })
							.attr("height", function(d) {return height - y(d.v); });
						} else { //non è una cumulata, metto un path
							svg.append("path")
							.datum(data)
							.attr("class", "line")
							.attr("d", line);
							
							//@ma
							for(var a = 0; a < data.length; a++) 
								svg.append("circle")
								.attr("cx", x(data[a].t))
								.attr("cy", y(data[a].v)).style("fill", "#4682B4")
								.attr("r", 1);
							//@ma
						}
						if (req['var']=='B13011') { //precipitazione
							svg.append("path")
							.datum(data)
							.attr("class", "lineP")
							.attr("d", lineP);
						}
					}
					//aggiungiamo il grigiume per il resto di oggi24
					svg.append('rect')
					.attr("height", height)
					.attr("width", width-x(ultimo.t))
					.attr("x", x(ultimo.t))
					.attr("y", 0)
					.style({"fill":"#000", 'opacity': '.2'});
					//gestiamo il mouseover a modo nostro
					/////////////////////////////////////
					var visDato= svg.append("g")
					.attr("class", "focus")
					.style("display", "none");
					visDato.append("rect")
					.attr("class", "focusRectVal")
					.attr("height", '20px')
					.attr("x", 0)
					.attr("y", -10)
					.attr('opacity', .7);
					visDato.append("text")
					.attr("x", 0)
					.attr("dx", 2)
					.attr("dy", ".36em")
					.style("fill","#FFF");
					var visData= svg.append("g")
					.attr("class", "focus")
					.style("display", "none");
					visData.append("rect")
					.attr("class", "focusRectData")
					.attr("height", '20px')
					.attr("x", 0)
					.attr("dy", -10)
					.attr('opacity', .7);
					visData.append("text")
					.attr("x", 0)
					.attr("dx", 2)
					//.attr("dy", "1.38em")
					.attr("dy", "1.25em")
					.style("fill","#FFF");
					var lineVal= svg.append("line")
					.attr("class", "focusLineVal");
					var lineData= svg.append("line")
					.attr("class", "focusDataVal");
					////////////////////////////////////
					var focus = svg.append("g")
					.attr("class", "focus")
					.style("display", "none");
					focus.append("circle")
					.attr("class", "standard")
					.attr("r", 4.5);
					focus.append("circle")
					.attr("class", "standardGreen")
					.attr("r", 1);
					if ((req['var']=='B13011') || (req['var']=='B11002')) { //precipitazione o rafica di vento
						var focusCum = svg.append("g")
						.attr("class", "focusCum")
						.style("display", "none");
						focusCum.append("circle")
						.attr("class", "cumulata")
						.attr("r", 4.5);
						focusCum.append("circle")
						.attr("class", "cumulata")
						.attr("r", 1);
						focusCum.append("rect")
						.attr("class", "focusRectCum")
						.attr("height", '20px')
						.attr("x", 6)
						.attr("y", -10);
						focusCum.append("text")
						.attr("x", 9)
						.attr("dy", ".35em");
						focusCum.select("text").append("tspan").attr("class", "theVal")
					}
					/*if (req['var']=='B13011') { //precipitazione
				var focusCum = svg.append("g")
					.attr("class", "focusCum")
					.style("display", "none");
				focusCum.append("circle")
					.attr("class", "cumulata")
					.attr("r", 4.5);
				focusCum.append("circle")
					.attr("class", "cumulata")
					.attr("r", 1);
				focusCum.append("rect")
					.attr("class", "focusRectCum")
					.attr("height", '20px')
					.attr("x", 6)
					.attr("y", -10);
				focusCum.append("text")
					.attr("x", 9)
					.attr("dy", ".35em");
				focusCum.select("text").append("tspan").attr("class", "theVal")
			}*/
					svg.append("rect")
					.attr("class", "overlay")
					.attr("width", width)
					.attr("height", height)
					.on("mouseover", function() {
						focus.style("display", null);
						if ((req['var']=='B13011') || (req['var']=='B11002')) {  //precipitazione o raffiche
							focusCum.style("display", null);
						}
						visDato.style("display", null);
						visData.style("display", null);
						lineVal.style("display", null);
						lineData.style("display", null);
						if ((req['var']=='B13011') || (req['var']=='B11002')) {  //precipitazione o raffiche
							focusCum.style("display", null);
						}
					})
					.on("mouseout", function() {
						focus.style("display", "none");
						if ((req['var']=='B13011') || (req['var']=='B11002')) {  //precipitazione o raffiche
							focusCum.style("display", 'none');
						}
						visDato.style("display", "none");
						visData.style("display", "none");
						lineVal.style("display", "none");
						lineVal.style("display", "none");
						lineData.style("display", "none");
						if ((req['var']=='B13011') || (req['var']=='B11002')) {  //precipitazione o raffiche
							focusCum.style("display", 'none');
						}
					})
					.on("mousemove", mousemove);
					var thatWind=null;
					function mousemove() {
						var x0 = x.invert(d3.mouse(this)[0]),
						i = bisectDate(data, x0, 1),
						d0 = data[i - 1],
						//d1 = (x0> moment(data[data.length-1].t).subtract(deltaTime(timeType),'hours').utc().add(deltaTime(timeType),'hours') )? data[data.length-1] : data[i],
						d1 = (x0> moment(data[data.length-1].t).subtract(deltaTime(timeType),'hours').utc().add(deltaTime(timeType),'hours') )? data[data.length-1] : data[i],
								d1 =  (data[i])?data[i]:d0,
										d = x0 - d0.t > d1.t - x0 ? d1 : d0;
										//console.log(d);
										visDato.select("text").text(formatVal(d.v)+' '+normalizzaUnita(leVariabili[variabile].unit));
										visData.select("text").text('['+formattaData(d.t)+']');
										var theX=x(d.t);
										var theY=y(d.v);
										var visDatoWidth=visDato.select("text").node().getComputedTextLength();
										var visDataWidth=visData.select("text").node().getComputedTextLength();
										if (d.v!=null) {
											focus.style('display', null);
											focus.attr("transform", "translate(" + theX + "," + theY + ")");
											if (valoriAssi) {
												visDato.attr("transform", "translate("+ (-visDatoWidth-4) +"," + theY + ")");
												if ( theX > width-200) {
													visData.attr("transform", "translate(" + (theX-visDataWidth-4) + ","+ height + ")");
												} else {
													visData.attr("transform", "translate(" + theX + ","+ height + ")");
												}
											} else {
												if ( theX > width-200) {
													visDato.attr("transform", "translate("+ (theX-visDatoWidth-8) +"," + (theY-10) + ")");
													visData.attr("transform", "translate(" + (theX-visDataWidth-8) + ","+ (theY) + ")");
												} else {
													visDato.attr("transform", "translate("+ (theX+4) +"," + (theY-9) + ")");
													visData.attr("transform", "translate(" + (theX+4) + ","+ (theY) + ")");
												}
											}
											if (valoriAssi) {
												lineVal
												.attr('x1', 0)
												.attr('y1', theY)
												.attr('x2', theX)
												.attr('y2', theY);
											}
											if (valoriAssi) {
												lineData
												.attr('x1', theX)
												.attr('y1', height)
												.attr('x2', theX)
												.attr('y2', theY);
											} else {
												lineData
												.attr('x1', theX)
												.attr('y1', height)
												.attr('x2', theX)
												.attr('y2', 0);
											}
											lineVal.style('display', null);
											lineData.style('display', null);
										} else {
											focus.style('display', "none");
											visDato.attr("transform", "translate(0," + height + ")");
											if ( theX > width-200) {
												visData.attr("transform", "translate(" + (theX-visDataWidth-4) + ","+ height + ")");
											} else {
												visData.attr("transform", "translate(" + theX + ","+ height + ")");
											}
											lineVal.style('display', "none");
											lineData.style('display', "none");
										}
										visDato.select("rect").attr('width',visDatoWidth+4);
										visData.select("rect").attr('width',visDataWidth+4);
										if (req['var']=='B13011') {// se pioggia
											focusCum.select(".theVal").text(formatVal(d.c));
											focusCum.attr("transform", "translate(" +theX + "," + cum(d.c) + ")");
											var cumWidth=focusCum.select(".theVal").node().getComputedTextLength();
											focusCum.select(".focusRectCum").attr('width',cumWidth+4);
										}
										if (req['var']=='B11002') {// se vento vediamo le etichette per le eventuali raffiche
											//console.log(arrayLabelRaffiche[d.t]);
											if (dataRaffiche.length>0) {
												focusCum.style("display", null);
												if ( arrayLabelRaffiche[d.t] != undefined ) {
													focusCum.select(".theVal").text( formatVal(arrayLabelRaffiche[d.t])+' m/s' );
													focusCum.attr("transform", "translate(" +theX + "," + y(arrayLabelRaffiche[d.t]) + ")");
													var cumWidth=focusCum.select(".theVal").node().getComputedTextLength();
													focusCum.select(".focusRectCum").attr('width',cumWidth+4);
												} else {
													focusCum.style("display", 'none');
												}
											} else {
												focusCum.style("display", 'none');
											}
											// se vento voglio portare in primo piano la mia barba
											if (thatWind != null) {
												thatWind.select('circle').style('stroke','#AAA');
												thatWind.selectAll('line').attr('class','lineaGrigia');
											}
											var thisWind=d3.select("g[transform^='translate("+(theX-32)+"']");
											thisWind.selectAll('circle').style('stroke','#000');
											thisWind.moveToFront().selectAll('line').attr('class','lineaNera');
											thatWind=thisWind;
										}
										/*if (req['var']=='B11002') {// se vento voglio portare in primo piano la mia barba
					if (thatWind != null) {
						thatWind.select('circle').style('stroke','#AAA');
						thatWind.selectAll('line').attr('class','lineaGrigia');
					}
					var thisWind=d3.select("g[transform^='translate("+(theX-32)+"']");
					thisWind.selectAll('circle').style('stroke','#000');
					thisWind.moveToFront().selectAll('line').attr('class','lineaNera');
					thatWind=thisWind;
				}*/
					}
				},
				complete: function () {
					if (callback && typeof(callback) === "function") {
						callback();
					}
				}
			});
		} //getDataAndPlot
		function plotDeflusso() {
			if ( ( (req['var']=='B13215') || (req['var']=='B13226') ) && (infoSensori[hash]) && (infoSensori[hash].sensor) && ( (infoSensori[hash].sensor.hydroinfo.equations).length > 0)  ) {
				var isDeflussed=false;
				$.ajax({
					url: contextPath+"/js/math.min.js",
					dataType: "script",
					cache: true
				});
				//console.log (domainLowDeflusso, domainHighDeflusso);
				var theTheFlusso = d3.select("#container").append("svg").attr("class", "theTheFlusso")
				.attr("width", width + margin.left + margin.right)
				.attr("height", height + margin.top + margin.bottom)
				.append("g")
				.attr("transform", "translate(" + margin.left + "," + margin.top + ")");
				$('.theTheFlusso').hide();
				theTheFlusso.append('rect')
				.attr("width", width)
				.attr("height", height)
				.attr("fill", '#FFF')
				.attr('opacity','.5');
				$('<li><a href="javascript:;" class="deflusso">Scala di deflusso</a></li>').appendTo( $('#opt') ).click(function() {
					//$(".theTheFlusso").hide();
					$('.theGrafico').hide();
					$('.theTheFlusso').show();
					if (!isDeflussed) {
						deflusData=[];
						$.each(infoSensori[hash].sensor.hydroinfo.equations, function(i,v) {
							//console.log(v.formula);
							for (j=v.lower_level; j<v.upper_level; j=j+0.01) {
								var thisDeflus=math.eval(v.formula, {"X": j});
								if (thisDeflus.re) {thisDeflus = thisDeflus.re} //se ho un numero immaginario prendo solo la parte reale
								deflusData.push({'defX': thisDeflus.toFixed(2), 'defY': parseFloat(j).toFixed(2)  });
							}
							if ( i == (infoSensori[hash].sensor.hydroinfo.equations).length -1 ) {
								var thisDeflus=math.eval(v.formula, {"X": v.upper_level});
								if (thisDeflus.re) {thisDeflus = thisDeflus.re}
								deflusData.push({'defX': thisDeflus.toFixed(2),'defY': parseFloat(v.upper_level).toFixed(2)  });
							}
						});
						theTheFlusso.append("rect")
						.attr('width',width)
						.attr('height',margin.bottom)
						.attr('x',0)
						.attr('y',height)
						.attr('fill',"#FFF")
						// Set the ranges
						var xTheFlusso = d3.scale.linear().range([0, width]);
						var yTheFlusso = d3.scale.linear().range([height, 0]);
						// Define the axes
						var xAxisTheFlusso = d3.svg.axis().scale(xTheFlusso).orient("bottom").ticks(5);
						var yAxisTheFlusso = d3.svg.axis().scale(yTheFlusso).orient("left").ticks(5);
						// Define the line
						var valueline = d3.svg.line()
						.x(function(d) { return xTheFlusso(d.defX); })
						.y(function(d) { return yTheFlusso(d.defY); });
						(domainLowDeflusso, domainHighDeflusso);
						if ( domainLowDeflusso == undefined ) {
							domainLowDeflusso = deflusData[0].defY;
						}
						if ( domainHighDeflusso == undefined ) {
							domainHighDeflusso = deflusData[deflusData.length-1];
						}
						xTheFlusso.domain([deflusData[0].defX, deflusData[deflusData.length-1].defX]);
						//yTheFlusso.domain([deflusData[0].defY, deflusData[deflusData.length-1].defY]);
						yTheFlusso.domain([domainLowDeflusso, domainHighDeflusso]);
						theTheFlusso.append("path")
						.attr("class", "lineDeflusso")
						.attr("d", valueline(deflusData));
						// Add the X Axis
						theTheFlusso.append("g")
						.attr("class", "x axis")
						.attr("transform", "translate(0," + height + ")")
						.call(xAxisTheFlusso)
						.append("text")
						.attr("x", width)
						.attr("dy", "-.51em")
						.style({"text-anchor": "end", 'fill': '#35B53A'})
						.text('portata (m^3/s)');
						// Add the Y Axis
						theTheFlusso.append("g")
						.attr("class", "y axis")
						.call(yAxisTheFlusso)
						.append("text")
						.attr("transform", "rotate(-90)")
						.attr("y", 6)
						.attr("dy", ".71em")
						.style({"text-anchor": "end", 'fill': 'steelblue'})
						.text('livello idrometrico (m)');
						var shift1=500;
						var ultimaEq=(infoSensori[hash].sensor.hydroinfo.equations).length-1;
						if (ultimaEq==0) {ultimaEq=999} //se abbiamo solo un equazione...
						/*$.each(infoSensori[hash].sensor.hydroinfo.equations, function(i,v) {
					theTheFlusso.append("line") //la linea del deflusso
						.attr('class','lineP')
						.attr('x1', 0)
						.attr('x2', width)
						.attr('y1', yTheFlusso(v.upper_level))
						.attr('y2', yTheFlusso(v.upper_level))
						.attr('stroke-dasharray', '1 2 3');
					////////////////////////////////
					theTheFlusso.append("text")
						.attr('class','t1'+i)
						.attr('x',(i!=0)?((i!=ultimaEq)?width-10:i*40+20):shift1)
						.attr('y',yTheFlusso(v.upper_level) +13)
						.attr('fill','red')
						.attr('font-size','14')
						.attr('font-weight','bold')
						.text(v.formula.replace('X','liv.'))
						.style("text-anchor", (i!=ultimaEq)?"end":'begin');
					var len=theTheFlusso.select('.t1'+i).node().getComputedTextLength();
					theTheFlusso.append("rect")
						.attr('width',len)
						.attr('height',14)
						.attr('x',(i!=0)?((i!=ultimaEq)?width-10-len:i*40+20):shift1-len )
						.attr('y',yTheFlusso(v.upper_level) +1)
						.attr('fill',"#FF5")
						.attr('fill-opacity',".3")
					theTheFlusso.select('.t1'+i).moveToFront();
					///////////////////////////////////
					theTheFlusso.append("text")
						.attr('class','t2'+i)
						.attr('x', (i!=0)?((i!=ultimaEq)?width-20:i*40+35):shift1-20 )
						.attr('y',yTheFlusso(v.upper_level) + 28)
						.attr('fill','#4682B4')
						.attr('font-size','12')
						.attr('font-weight','bold')
						.text('['+ v.lower_level+' < liv. < '+v.upper_level+']')
						.style("text-anchor", (i!=ultimaEq)?"end":'begin');
					len=theTheFlusso.select('.t2'+i).node().getComputedTextLength()
					theTheFlusso.append("rect")
						.attr('width',len)
						.attr('height',14)
						.attr('x', (i!=0)?((i!=ultimaEq)?width-20-len:i*40+35):shift1-20-len )
						.attr('y',yTheFlusso(v.upper_level) +18)
						.attr('fill',"#FFF")
						.attr('fill-opacity',".6")
					theTheFlusso.select('.t2'+i).moveToFront();
				});*/
						//gestiamo il mouseover a modo nostro per il deflusso
						/////////////////////////////////////
						var visDatoDef= theTheFlusso.append("g")
						.attr("class", "focus")
						.style("display", "none");
						visDatoDef.append("rect")
						.attr("class", "focusRectVal")
						.attr("height", '20px')
						.attr("x", 0)
						.attr("y", -10);
						visDatoDef.append("text")
						.attr("x", 0)
						.attr("dx", 2)
						.attr("dy", ".36em")
						.style("fill","#FFF");
						var visDataDef= theTheFlusso.append("g")
						.attr("class", "focus")
						.style("display", "none");
						visDataDef.append("rect")
						.attr("class", "focusRectData")
						.attr("height", '20px')
						.attr("x", 0)
						.attr("dy", -10);
						visDataDef.append("text")
						.attr("x", 0)
						.attr("dx", 2)
						.attr("dy", "1.38em")
						.style("fill","#FFF");
						var lineValDef= theTheFlusso.append("line")
						.attr("class", "focusLineVal");
						var lineDataDef= theTheFlusso.append("line")
						.attr("class", "focusDataVal");
						////////////////////////////////////
						var focusDef = theTheFlusso.append("g")
						.attr("class", "focus")
						.style("display", "none");
						focusDef.append("circle")
						.attr("class", "standard")
						.attr("r", 4.5);
						focusDef.append("circle")
						.attr("class", "standardGreen")
						.attr("r", 1);
						theTheFlusso.append("rect")
						.attr("class", "overlay")
						.attr("width", width)
						.attr("height", height)
						.on("mouseover", function() {
							focusDef.style("display", null);
							visDatoDef.style("display", null);
							visDataDef.style("display", null);
							lineValDef.style("display", null);
							lineDataDef.style("display", null);
						})
						.on("mouseout", function() {
							focusDef.style("display", "none");
							visDatoDef.style("display", "none");
							visDataDef.style("display", "none");
							lineValDef.style("display", "none");
							lineDataDef.style("display", "none");
						})
						.on("mousemove", mousemoveDef);
						isDeflussed=!isDeflussed;
					}//deflusso
					theTheFlusso.append('rect').attr('width',50).attr('height',14).attr('x',405).attr('y',-11).attr('fill',"#F00").attr('stroke','#C6CED5').attr('stroke-width','1')
					theTheFlusso.append("text").text('chiudi').style('cursor','pointer').attr('x',414).attr('y',0).attr('fill',"#FFF").on('click', function() {$('svg').hide(); $('.theGrafico').show()})
					function mousemoveDef() {
						var x0 = xTheFlusso.invert(d3.mouse(this)[0]),
						i = bisectDateDef(deflusData, x0, 1),
						d0 = deflusData[i - 1],
						d1 = (deflusData[i]!=undefined)?deflusData[i]:deflusData[i-1],
								d = x0 - d0.defX > d1.defX - x0 ? d1 : d0;
								visDatoDef.select("text").text(d.defY);
								visDataDef.select("text").text(d.defX);
								var theX=xTheFlusso(d.defX),
								theY=yTheFlusso(d.defY);
								////////////////////////////////////////////////////////////
								var visDatoWidthDef=visDatoDef.select("text").node().getComputedTextLength(),
								visDataWidthDef=visDataDef.select("text").node().getComputedTextLength();
								focusDef.style('display', null);
								focusDef.attr("transform", "translate(" + theX + "," + theY + ")");
								visDatoDef.attr("transform", "translate("+ (- visDatoWidthDef -4) +"," + theY + ")");
								if ( theX > width-200) {
									visDataDef.attr("transform", "translate(" + (theX-visDataWidthDef-4) + ","+ height + ")");
								} else {
									visDataDef.attr("transform", "translate(" + theX + ","+ height + ")");
								}
								lineValDef
								.attr('x1', 0)
								.attr('y1', theY)
								.attr('x2', theX)
								.attr('y2', theY);
								lineDataDef
								.attr('x1', theX)
								.attr('y1', height)
								.attr('x2', theX)
								.attr('y2', theY);
								lineValDef.style('display', null);
								lineDataDef.style('display', null);
								visDatoDef.select("rect").attr('width',visDatoWidthDef+4);
								visDataDef.select("rect").attr('width',visDataWidthDef+4)
								/////////////////////////////////////////////////////////////////
					}
				});
			}
		}
		function plotSezione() {
			if ( ( (req['var']=='B13215') || (req['var']=='B13226') ) && (infoSensori[hash]) && (infoSensori[hash].sensor) && (infoSensori[hash].sensor.hydroinfo.section) && ( (infoSensori[hash].sensor.hydroinfo.section.coordinates).length > 0)  ) {
				var isSezioned=false;
				var theSeZione = d3.select("#container").append("svg").attr("class", "theSeZione")
				.attr("width", width + margin.left + margin.right)
				.attr("height", height + margin.top + margin.bottom)
				.append("g")
				.attr("transform", "translate(" + margin.left + "," + margin.top + ")");
				$('.theSeZione').hide();
				if (!isSezioned) {
					sezionData=infoSensori[hash].sensor.hydroinfo.section.coordinates;
					var loZero=infoSensori[hash].sensor.hydroinfo.hydro_zero;
					$.each(infoSensori[hash].sensor.hydroinfo.section.coordinates, function(i,v) {
						sezionData[i][2]=v[1]-loZero;
					});
					// Set the ranges
					var xTheSezione = d3.scale.linear().range([0, width]),
					yTheSezione = d3.scale.linear().range([height, 0]),
					yTheSezioneSLM = d3.scale.linear().range([height, 0]);
					// Define the axes
					var xAxisTheSezione = d3.svg.axis().scale(xTheSezione).orient("bottom").ticks(5),
					yAxisTheSezione = d3.svg.axis().scale(yTheSezione).orient("right").ticks(5),
					yAxisTheSezioneSLM = d3.svg.axis().scale(yTheSezioneSLM).orient("left").ticks(5);
					// Define the line
					var valueline = d3.svg.area()
					.x(function(d) { return xTheSezione(d[0]); })
					.y0(height)
					.y1(function(d) { return yTheSezione(d[1]); });
					domainLowDeflusso=Math.floor(d3.min(sezionData, function(d) { return d[2]; }))
					domainHighDeflusso= Math.ceil(d3.max(sezionData, function(d) { return d[2]; }))+1
					xTheSezione.domain([sezionData[0][0],sezionData[sezionData.length-1][0]]);
					yTheSezione.domain([domainLowDeflusso+loZero, domainHighDeflusso+loZero]);
					yTheSezioneSLM.domain([domainLowDeflusso, domainHighDeflusso]);
					//console.log(ultimo);
					if (req['var']=='B13215') {
						theSeZione.append('rect')
						.attr('width',width)
						//.attr('height',height-margin.bottom-yTheSezioneSLM(ultimo.v))
						.attr('height',height)
						.attr('x', 0 )
						//.attr('y', height-(height-yTheSezioneSLM(ultimo.v)))
						.attr('y', yTheSezioneSLM(ultimo.v))
						.attr('fill',"aqua")
						theSeZione.append("rect")
						.attr('width',width)
						.attr('height',margin.bottom)
						.attr('x',0)
						.attr('y',height)
						.attr('fill',"#FFF")
						.attr('fill-opacity',".99");
					}
					//yTheSezione.domain([Math.floor(d3.min(sezionData, function(d) { return d[1]; })), d3.max(sezionData, function(d) { return d[1]; })]);
					//yTheSezioneSLM.domain([Math.floor(d3.min(sezionData, function(d) { return d[2]; })) , d3.max(sezionData, function(d) { return d[2]; })]);
					theSeZione.append('linearGradient') //il gradiente
					.attr('id','grad-sezione')
					.attr('gradientTransform','rotate(90)')
					.selectAll('stop').data([
					                         {offset:'5%', color:"#C93"},
					                         {offset:'95%', color:""}
					                         ]).enter().append("stop")
					                         .attr("offset", function(d) { return d.offset; })
					                         .attr("stop-color", function(d) { return d.color; });
					theSeZione.append("path")
					.datum(sezionData)
					.attr("class", "area")
					.attr("d", valueline);
					theSeZione.append("g")
					.attr("class", "x axis")
					.attr("transform", "translate(0," + height + ")")
					.call(xAxisTheSezione);
					theSeZione.append("g")
					.attr("class", "y axis")
					.call(yAxisTheSezioneSLM)
					.append("text")
					.attr("transform", "rotate(-90)")
					.attr("y", 6)
					.attr("dy", ".71em")
					.style("text-anchor", "end")
					.text('livello idrometrico (m)');
					theSeZione.append("g")
					.attr("class", "y axis")
					.attr("transform", "translate("+ (width)+ ",0 )")
					.call(yAxisTheSezione)
					.append("text")
					.attr("transform", "rotate(-90)")
					.attr("y", 6)
					.attr("dy", "-1em")
					.attr("dx", "-1em")
					.style("text-anchor", "end")
					.text("quota slm");
					var mieSoglie=infoSensori[hash];
					//console.log(mieSoglie);
					if (mieSoglie) {
						var soglie=new Array( (mieSoglie.sensor && mieSoglie.sensor.hydroinfo && mieSoglie.sensor.hydroinfo.thresholds[0])?mieSoglie.sensor.hydroinfo.thresholds[0]:null  , (mieSoglie.sensor && mieSoglie.sensor.hydroinfo && mieSoglie.sensor.hydroinfo.thresholds[1])?mieSoglie.sensor.hydroinfo.thresholds[1]:null, (mieSoglie.sensor && mieSoglie.sensor.hydroinfo &&  mieSoglie.sensor.hydroinfo.thresholds[2])?mieSoglie.sensor.hydroinfo.thresholds[2]:null);
						$.each(soglie, function(key, value) {
							if (value!=null) {
								theSeZione.append("line")
								.attr('class', 'threshold_'+key)
								.attr('x1',0)
								.attr('y1', yTheSezioneSLM(value))
								.attr('x2', width)
								.attr('y2', yTheSezioneSLM(value));
								theSeZione.append("text").attr("x", 15+30*key)
								.attr("y", yTheSezioneSLM(value))
								.attr("dy", '-.3em')
								.text(value+' m');
							}
						});
					}
					isSezioned=!isSezioned;
					theSeZione.append('rect').attr('width',50).attr('height',14).attr('x',405).attr('y',-11).attr('fill',"#F00").attr('stroke','#C6CED5').attr('stroke-width','1')
					theSeZione.append("text").text('chiudi').style('cursor','pointer').attr('x',414).attr('y',0).attr('fill',"#FFF").on('click', function() {$('svg').hide(); $('.theGrafico').show()})
				} //isSezioned
				$('<li><a href="javascript:;" class="sezione">Sezione</a></li>').appendTo( $('#opt') ).click(function() {
					$('.theSeZione').show();
					$('.theGrafico').hide();
				});//fine gestione sezione
			}
			plotDeflusso();
		}
		function progressBar() {
			$('.progressBar').animate({
				width: '100%'
			}, 60000, function() {
				///rt_data/lastdata/STATION/VARIABLE
				$.ajax({ //vedo se ci sono dati + nuovi
					url: theService+"lastdata/"+leStazioni[hash].id+"/"+leVariabili[variabile].id,
					type: "GET",
					dataType: 'json',
					
					success: function (lastDataCheck) {
						//console.log(lastDataCheck, ultimo);
						//console.log(lastDataCheck.datetime, ultimo.t);
						//console.log( moment(lastDataCheck.datetime).add(deltaTime(timeType),'hour').Date )
						if (moment(lastDataCheck.datetime).add(deltaTime(timeType),'hour').isAfter(moment(ultimo.t))) {
							$('.progressBar').css('width',0);
							$("svg").hide();
							d3.selectAll("svg.theGrafico").remove();
							getDataAndPlot();
							if (req['data2']==moment().format("YYYY-MM-DD")) {
								progressBar();
							}
						} else {
							$('.progressBar').css('width',0);
							progressBar();
						}
					}
				});
			});
		}
		
		//$(document).ready( function() { //devo catturare le info della stazione
			
			//beccaVariabili();
			//@ma	beccaInfoSensori();
			beccaAnagrafica(identificaStaz);
			$( window ).resize(function() {
				$('#anag').css({'height':$(window).height()-40+'px','width':$(window).width()-40+'px'});
			});
			if (req['data2']==moment().format("YYYY-MM-DD")) {
				$('.progressBarCont').append('<div class="progressBar"></div>');
				progressBar();
				$('.progressBarCont, .progressBar').click( function() {
					$('.progressBar').stop();
					$('.progressBar').css('width',0);
					$("svg").hide();
					d3.selectAll("svg.theGrafico").remove();
					getDataAndPlot();
					progressBar();
				});
			} else {
				$('.progressBarCont').css('cursor', 'default');
			}
		//});
});