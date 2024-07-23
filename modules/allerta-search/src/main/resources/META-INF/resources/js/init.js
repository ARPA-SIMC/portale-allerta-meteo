
function callSearch(obj,cmd,params,callb) {
	
	var serviceUrl = "/o/object-search"
		
	serviceUrl+="?object="+obj+"&command="+cmd+(params?"&"+params:"")
	
	console.log(serviceUrl)
	
	$.ajax({
			      url: serviceUrl,
			      method: 'GET',
	}).then(callb).fail(function (resp) {
      	console.log('search fail');
      	console.log(resp)
	});
	
}

function countByYear() {
	callSearch(getObjectType(),"countYears",getParams(),countByYearCallback)
}

function countByMonth(anno,callb) {
	callSearch(getObjectType(),"countMonths","anno="+anno+"&"+getParams(),callb)
}

function search(anno,mese,callb) {
	callSearch(getObjectType(),"search","anno="+anno+"&"+getVarMese()+"="+mese+"&"+getParams(),callb)
}

function createYearNode(year,count) {
	
	var html = '<div id="year_'+year+'" year="'+year+'" class="search-year search-collapsed"><h3>'+year+' <span class="search-count">('+count+')</span></h3><div class="collapsed"></div><div class="expanded"></div></div>'
	var n = $(html)
	n.prepend(createCollapse(yearExpandCallback))
	return n
}

function createMonthNode(year,month,displayMonth,count) {
	
	var html = '<div id="month_'+year+month+'" year="'+year+'" month="'+month+'" class="search-month search-collapsed"><h6>'+displayMonth+' <span class="search-count">('+count+')</span></h6><div class="collapsed"></div><div class="expanded"></div></div>'
	var n = $(html)
	n.prepend(createCollapse(monthExpandCallback))
	return n
}

function createItemNode(item) {
	var pdf = (item.pdf?'<a class="pdf icon i-file-pdf-o" target="_blank" href="'+item.pdf+'"><span class="pdf2">PDF</span></a>':'')
	var html = '<div class="'+item.classes+'"><a target="_blank" href="'+item.link+'">'+item.title+'</a>'+pdf+'</div>'
	var n = $(html)
	return n
}

function createCollapse(callb) {
	var html = '<div class="search-collapser closed icon i-plus-square-o" ></div>'
	var n = $(html)
	n.click(function(e){
		 if ($( this ).hasClass('closed')) {
			 //open
			 $( this ).removeClass('closed')
			 $( this ).removeClass('i-plus-square-o')
			 $( this ).addClass('open')
			 $( this ).addClass('i-minus-square-o')
			 $( this ).parent().removeClass('search-collapsed')
			 $( this ).parent().addClass('search-expanded')
			 if (!$( this ).parent().hasClass('complete')) {
				 callb($( this ).parent())
			 }
			 
		 } else {
			 //close
			 $( this ).removeClass('open')
			 $( this ).addClass('closed')
			 $( this ).removeClass('i-minus-square-o')
			 $( this ).addClass('i-plus-square-o')
			 $( this ).parent().removeClass('search-expanded')
			 $( this ).parent().addClass('search-collapsed')
			 
		 }
	})
	return n;
}

function yearExpandCallback(node) {
 if (dueLivelli()) {
	countByMonth(node.attr("year"),function(data) {
		var container = node.find(".expanded")
		for (let mese of data) {
			container.append(createMonthNode(node.attr("year"),mese.periodo,mese.periodoVisualizzato,mese.count))
		}
		node.addClass("complete")
	})
 } else {
	 //un solo livello
	 monthExpandCallback(node)
 }
}

function monthExpandCallback(node) {
	search(node.attr("year"),node.attr("month"),function(data) {
		var container = node.find(".expanded")
		for (let item of data) {
			container.append(createItemNode(item))
		}
		node.addClass("complete")
		
	})
}

function countByYearCallback(data) {
	var container = $("#search-container")
	if (!container) return
	container.empty()
	for (let anno of data) {
		container.append(createYearNode(anno.periodo,anno.count))
	}
	updateFeed()
}

function autocompletion(e) {
	var testo = (e.target.value||"").toUpperCase()
	var nome = (e.target.name)
	$('.autocomp-'+nome).empty()
	$('.autocomp-'+nome).css('display','none')
	if (testo.length<3) return false
	var l = $('.autocomp-options-'+nome).children()
	
	for (var x=0; x<l.length; x++) {
		if (l[x].textContent.includes(testo)) {
			$(l[x]).clone(true).appendTo('.autocomp-'+nome)
			$('.autocomp-'+nome).css('display','')
		}
	}
}


function chooseAutocompletion(e) {
	var testo = e.target.textContent
	console.log(e)
	console.log(testo)
	$(e.target).parent().parent().find('.autocomp-input').val(testo)
	$(e.target).parent().parent().find('.autocomp-search-results').css("display","none")
}

function chooseAutocompletion2(e) {
	if (e.which==13) {
		chooseAutocompletion(e)
		return false;
	}
}

jQuery( document ).ready(function() {
	countByYear()
	$('.autocomp-input').on('paste input',autocompletion)
	$('.autocomp-opt').on('click mousedown',chooseAutocompletion)
	$('.autocomp-opt').on('keypress keydown input',chooseAutocompletion2)
	$('.autocomp-search-results').css("display","none")
	$('.input-group--date-picker').datetimepicker({
		 useCurrent: false,
    	 icons: {
             time: "far fa-clock",
             date: "far fa-calendar-minus",
             up: "fa fa-arrow-up",
             down: "fa fa-arrow-down"
         }
    });
})

