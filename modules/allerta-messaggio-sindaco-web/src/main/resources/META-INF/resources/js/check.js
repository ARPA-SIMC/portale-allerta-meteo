// F1 reset deu dati nascosti 

$( document ).ready(function() {

	$(" :button").addClass( "pupped" );
	$(".modal-header :button").addClass( "marked" );
	
	$(".inputSubject").keyup(function(e) {
		$("#inputSubject").html(160 - $(this).val().length);
	});
	

	$(".selectBooleanInfoCheck").change(function(e) {
		
		performSelectBooleanInfoCheck();
	});
	
});

function performSelectBooleanInfoCheck() {
	var values = '';
	
	$(".selectBooleanInfoCheck").each(function(i, item) {
		var value = $(this).val();
		
		if ($(this).is(":checked")) {
			$(".list-info-"+value).show();
			values += value + ',';
		} else {
			$(".list-info-"+value).hide();
		}
	});
	
	$(".selectBooleanInfo").val(values);
	
}

function removeBooleanInfo(info) {
	$(".selectBooleanInfoCheck[value="+info+"]").prop("checked", false);
	performSelectBooleanInfoCheck();
}

$(document).on("click", ".modal-close-from-inside", function(){
	$(window.parent.document).find(".yui3-widget-mask").next().find(".close").trigger("click").trigger("click"); 
});

 // F2  Funzione selettore css per check
 $(document).on("click", ".selectable-ul li", function(){
	 if( $(this).hasClass("selected") ){
			$(this).removeClass("selected");
	 }
	 else{
		 $(this).addClass("selected");
	 }
	});
 
//Per gestire correttamente le sub-modali
 $(document).on("click", ".addinfo", function(){
 	$(window.parent.document).find(".yui3-widget-mask").next().addClass("with-sub-modal");
 });
 $(document).on("click", ".modal-popup .modal-footer .btn, .modal-popup .btn.close", function(){
 	$(window.parent.document).find(".yui3-widget-mask").next().removeClass("with-sub-modal");
 });
 $(document).on("mousedown", ".modal-popup .btn.close", function(){
 	$(window.parent.document).find(".yui3-widget-mask").next().removeClass("with-sub-modal");
 });

 
 
 // Gestione della select della seconda pagina 
 
 $(document).on("click", ".update-data li", function(){	 
	 var id = $(this).attr('id');
	 var idCheck = "#div_".concat(id).concat(" input");
	 if($(idCheck).val().trim()=='no' || $(idCheck).val().trim()=='' ){	 $(idCheck).val('si');	 }
	 else if($(idCheck).val().trim()=='si' ){ $(idCheck).val('no');	 }
	});
 
 // F3 La funzione viene utlizzata per settare il valore booleano e serve 
 // a rispecchiare il prototipo costruito come interfaccia
 $(document).on("click", ".insert-selectable-docs", function(){
		var t = $(this).attr("data-target");
		
		$( $(this).attr("data-source") ).find("li.selected").each(function(){
			var id = $(this).attr('id');
		    var idCheck = "#div_".concat(id).concat(" input");
		    $(idCheck).val('si');
			$(t).append( $(this) );
			$(this).addClass("removable");
			$(this).prepend('<a href="#" class="trash-handler"><span class="sr-only">Rimuovi</span></a>');
		});
	});
 
	$(document).on("click",'.trash-handler', function(){
	 var id = $(this).closest("li").attr('id');
	 var idCheck = "#div_".concat(id).concat(" input");
	 $(idCheck).val('no');
	 $(this).closest("li").remove();
	});
	
	 
	
/*
 *  F4 CONTROLLO CHE ALMENO UN CANALE SIA SETTATO
 * 
 */
function controllaCanale(){
	var booleanValue = false;
	$("#hyddenDataChannel").find('input').each(function() {
	    if($(this).val()=='si'){
	    	  booleanValue = true;
	    }
	});
	if(booleanValue === false){
		alert('ATTENZIONE, NON HAI SELEZIONATO NESSUN CANALE DI INVIO.');
		return false;
	}else {
    	return true;
    }
	
}