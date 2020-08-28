function toggleAllerta(riga,colonna,sottoriga) {
	
	if (colonna==8 || colonna==9) {
		//stato del mare, crit costiera -> solo B2 e D2
		if (sottoriga==1) return;
		if (riga!=2 && riga!=4) return;
	}
	if (colonna==6 || colonna==7) {
		//neve, ghiaccio -> no in mesi estivi
		var dateObj = new Date();
		var month = dateObj.getUTCMonth() + 1; //months from 1-12
		if (month>=5 && month<=9) return;
	}
			
			var cel = document.getElementById("cella"+riga+"-"+colonna+"-"+sottoriga);
			var inp = cel.firstElementChild;
			var txt = document.getElementById("testo"+riga+"-"+colonna+"-"+sottoriga);
			var val = inp.value;
			var newval = parseInt(val)+1;
			if (newval==1001) newval = 0;
			else if (newval==4) newval = 1000;
			
			var newstring = " ";
			if (newval==0) newstring="VERDE";
			if (newval==1) newstring="GIALLO";
			if (newval==2) newstring="ARANCIONE";
			if (newval==3) newstring="ROSSO";
			
			inp.value = ""+newval;
			cel.className = cel.className.replace("cellaAllerta"+val,"cellaAllerta"+newval);
			txt.innerHTML = newstring;
			
			if (colonna<4) setColoriMappa1(riga);
			else setColoriMappa2(riga);
			
		}

function toggleAllertaValore(riga,colonna,sottoriga,newval) {
	
	if (colonna==8 || colonna==9) {
		//stato del mare, crit costiera -> solo B2 e D2
		if (sottoriga==1) return;
		if (riga!=2 && riga!=4) return;
	}
	if (colonna==6 || colonna==7) {
		//neve, ghiaccio -> no in mesi estivi
		var dateObj = new Date();
		var month = dateObj.getUTCMonth() + 1; //months from 1-12
		if (month>=5 && month<=9) return;
	}
	
	var cel = document.getElementById("cella"+riga+"-"+colonna+"-"+sottoriga);
	var inp = cel.firstElementChild;
	var txt = document.getElementById("testo"+riga+"-"+colonna+"-"+sottoriga);
	var val = inp.value;
	
	var newstring = " ";
	if (newval==0) newstring="VERDE";
	if (newval==1) newstring="GIALLO";
	if (newval==2) newstring="ARANCIONE";
	if (newval==3) newstring="ROSSO";
	
	inp.value = ""+newval;
	cel.className = cel.className.replace("cellaAllerta"+val,"cellaAllerta"+newval);
	txt.innerHTML = newstring;
	
	if (colonna<4) setColoriMappa1(riga);
	else setColoriMappa2(riga);
	
}

function toggleColonna(colonna) {
	
	var cel = document.getElementById("cella1-"+colonna+"-1");
	var inp = cel.firstElementChild;
	var val = parseInt(inp.value);
	var newval = 1000;
	if (val==1000) newval = 0;
	
	var k;
	
	if (colonna<4) {
		for (k=1; k<=8; k++) toggleAllertaValore(k,colonna,1,newval);
	} else {
		for (k=1; k<=8; k++) {
			toggleAllertaValore(k,colonna,1,newval);
			if (k!=6) toggleAllertaValore(k,colonna,2,newval);
		}
	}
	
}
		
function setColoriMappa1(riga) {
			var peggiore = -1;
			var colonna;
			
			for (colonna=1; colonna!=4; colonna++) {
				var cel = document.getElementById("cella"+riga+"-"+colonna+"-1");
				var inp = cel.firstElementChild;
				var val = parseInt(inp.value);
				if (val!=1000 && val>peggiore) peggiore = val;
			}
			
			var colore = "#ffffff";
			if (peggiore==0) colore = "#98ff5d";
			if (peggiore==1) colore = "#eff200";
			if (peggiore==2) colore = "#ffa500";
			if (peggiore==3) colore = "#ff3a21";
			
			document.getElementById("mappa1-area"+riga).style.fill = colore;
			
		}


function setColoriMappa2(riga) {
	var peggiore = -1;
	var colonna;
	
	for (colonna=4; colonna!=10; colonna++) {
		var cel = document.getElementById("cella"+riga+"-"+colonna+"-1");
		var inp = cel.firstElementChild;
		var val = parseInt(inp.value);
		if (val!=1000 && val>peggiore) peggiore = val;
	}
	
	var colore = "#ffffff";
	if (peggiore==0) colore = "#98ff5d";
	if (peggiore==1) colore = "#eff200";
	if (peggiore==2) colore = "#ffa500";
	if (peggiore==3) colore = "#ff3a21";
	
	document.getElementById("mappa2-area"+riga+"1").style.fill = colore;
	
	if (riga==2)
		document.getElementById("mappa2-area"+riga+"1part2").style.fill = colore;
	
	if (riga==6) return;
	
	peggiore = -1;
	
	for (colonna=4; colonna!=10; colonna++) {
		var cel = document.getElementById("cella"+riga+"-"+colonna+"-2");
		var inp = cel.firstElementChild;
		var val = parseInt(inp.value);
		if (val!=1000 && val>peggiore) peggiore = val;
	}
	
	var colore = "#ffffff";
	if (peggiore==0) colore = "#98ff5d";
	if (peggiore==1) colore = "#eff200";
	if (peggiore==2) colore = "#ffa500";
	if (peggiore==3) colore = "#ff3a21";
	
	document.getElementById("mappa2-area"+riga+"2").style.fill = colore;
		
	
}
		
function setTuttiColori() {
			
			var k;
			for (k=1; k<=8; k++) {
				setColoriMappa1(k);
				setColoriMappa2(k);
			}
			
			
		}



function autoMergeByRow(tableId
        , rowStartIndex // zero or positive
        , colStart      // zero or positive
        , colEnd        // equals to colStart or greater than colStart or negative
        , linkedCol
        ) {

    var trArr = $('#' + tableId).find('tr');            // rows array
    for(var rowIndex = rowStartIndex ; rowIndex < trArr.length-1 ; rowIndex++) {
        var tdArr = $(trArr[rowIndex]).find('td');  // cols array of the row
        if(colEnd < 0) colEnd = tdArr.length - 1;       // if colEnd is negative, process at the end of the cols;
        for(var colIndex = colStart ; colIndex < tdArr.length && colIndex <= colEnd ; colIndex++) {
            var span = 1;
            var theCell = $(tdArr)[colIndex];
            if($(theCell).attr('colspan')) {continue;}
            var cellBelow = $($(theCell).parent().next().children()[colIndex]); 
            var linkedCell
            var linkedCellBelow
            if (linkedCol>=0) {
            	linkedCell = $(tdArr)[linkedCol]
            	linkedCellBelow = $($(theCell).parent().next().children()[linkedCol]);  
            }
            while(cellBelow != undefined && rowIndex+span<trArr.length
                    && $(theCell).text() == $(cellBelow).text()) {
                span++;
                cellBelow.hide();
                cellBelow = $($(cellBelow).parent().next().children()[colIndex]);    
                if (linkedCell) {
                	linkedCellBelow.hide()
                	linkedCellBelow = $($(linkedCellBelow).parent().next().children()[linkedCol]);
                }
            }
            if(span > 1) {
            	$(theCell).attr('rowspan', span);   
            	if (linkedCell) {
            		$(linkedCell).attr('rowspan', span); 
            	}
            }
        }
    }
}
	function mergeTabellaDettaglio() {
		autoMergeByRow("_inviisms_WAR_compilaallertaportlet_\\:fo\\:sms2",0,0,0,8);
	}
	
	(function($){
		if ($("#mappa1").length > 0) {
			setTuttiColori();	
		}
		
	})(jQuery);
	