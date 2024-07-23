

function isAllerta() {
	
	var k = 0;
	var j = 0;
	var val = -1;
	var cel = null;
	var inp = null;
	
	var allerta = [];
	for (k=0; k<9; k++) allerta.push(0);
	
	for (k=1; k<=8; k++) {
		for (j=1; j<=9; j++) {
			cel = document.getElementById("cella"+k+"-"+j+"-1");
			if (cel) {
				inp = cel.firstElementChild;
				if (inp) {
					val = inp.value;
					if (val==1 || val==2 || val==3) 
						allerta[j-1]=Math.max(val,allerta[j-1]);
				}
			}
			if (j>3) {
				cel = document.getElementById("cella"+k+"-"+j+"-2");
				if (cel) {
					inp = cel.firstElementChild;
					if (inp) {
						val = inp.value;
						if (val==1 || val==2 || val==3)
							allerta[j-1]=Math.max(val,allerta[j-1]);
					}
				}
			}
		}
	}
	
	var out=allerta[0];
	for (k=1; k<9; k++) out+=","+allerta[k]
	
	return out;
	
}

function isAllertaNuovo() {
	
	var decodifica = [11,12,21,22,31,32,41,42,43,51,52,61,62,63,71,72,81,82];

	
	var k = 0;
	var j = 0;
	var val = -1;
	var cel = null;
	var inp = null;
	
	var allerta = [];
	for (k=0; k<9; k++) allerta.push(0);
	
	for (k=1; k<=18; k++) {
		for (j=1; j<=9; j++) {
			cel = document.getElementById("cella"+decodifica[k-1]+"-"+j);
			if (cel) {
				inp = cel.firstElementChild;
				if (inp) {
					val = inp.value;
					if (val==1 || val==2 || val==3) 
						allerta[j-1]=Math.max(val,allerta[j-1]);
				}
			}
			if ($('#duegriglie')[0].checked) {
				cel = document.getElementById("cellaX"+decodifica[k-1]+"-"+j);
				if (cel) {
					inp = cel.firstElementChild;
					if (inp) {
						val = inp.value;
						if (val==1 || val==2 || val==3)
							allerta[j-1]=Math.max(val,allerta[j-1]);
					}
				}
			}
		}
	}
	
	var out=allerta[0];
	for (k=1; k<9; k++) out+=","+allerta[k]
	
	return out;
	
}

function isAllertaValanghe() {
	
	var k = 0;
	var j = 0;
	var val = -1;
	var cel = null;
	var inp = null;
	
	var dueg = $('#duegriglie')[0].checked
	
	var allerta = [];
	for (k=0; k<1; k++) allerta.push(0);
	
	for (k=1; k<=3; k++) {
		for (j=1; j<=1; j++) {
			cel = document.getElementById("cella"+k+"-"+j+"-1");
			if (cel) {
				inp = cel.firstElementChild;
				if (inp) {
					val = inp.value;
					if (val==1 || val==2 || val==3)
						allerta[j-1]=Math.max(val,allerta[j-1]);
				}
			}
			if (dueg) {
				cel = document.getElementById("cellaOggi"+k+"-"+j+"-1");
				if (cel) {
					inp = cel.firstElementChild;
					if (inp) {
						val = inp.value;
						if (val==1 || val==2 || val==3)
							allerta[j-1]=Math.max(val,allerta[j-1]);
					}
				}
			}
			
		}
	}
	
	var out=allerta[0];
	
	return out;
	
}



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

function toggleAllertaNuovo(riga,colonna,sottoriga) {
	
	if (colonna==8 || colonna==9) {
		//stato del mare, crit costiera -> solo B2 e D2
		if (riga!=22 && riga!=42) return;
	}
	if (colonna==6 || colonna==7) {
		//neve, ghiaccio -> no in mesi estivi
		var dateObj = new Date();
		var month = dateObj.getUTCMonth() + 1; //months from 1-12
		if (month>=5 && month<=9) return;
	}
			
			var cel = document.getElementById("cella"+riga+"-"+colonna);
			var inp = cel.firstElementChild;
			var txt = document.getElementById("testo"+riga+"-"+colonna);
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
			
			setColoriMappaOggi(riga);
			
		}

function toggleAllertaNuovoX(riga,colonna,sottoriga) {
	
	if (colonna==8 || colonna==9) {
		//stato del mare, crit costiera -> solo B2 e D2
		if (riga!=22 && riga!=42) return;
	}
	if (colonna==6 || colonna==7) {
		//neve, ghiaccio -> no in mesi estivi
		var dateObj = new Date();
		var month = dateObj.getUTCMonth() + 1; //months from 1-12
		if (month>=5 && month<=9) return;
	}
			
			var cel = document.getElementById("cellaX"+riga+"-"+colonna);
			var inp = cel.firstElementChild;
			var txt = document.getElementById("testoX"+riga+"-"+colonna);
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
			
			setColoriMappaDomani(riga);
			
		}

function toggleAllertaX(riga,colonna,sottoriga) {
	
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
			
			var cel = document.getElementById("cellaX"+riga+"-"+colonna+"-"+sottoriga);
			var inp = cel.firstElementChild;
			var txt = document.getElementById("testoX"+riga+"-"+colonna+"-"+sottoriga);
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
			
			if (colonna<4) setColoriMappa1X(riga);
			else setColoriMappa2X(riga);
			
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

function toggleAllertaValoreNuovo(riga,colonna,sottoriga,newval) {
	
	if (colonna==8 || colonna==9) {
		//stato del mare, crit costiera -> solo B2 e D2
		if (riga!=22 && riga!=42) return;
	}
	if (colonna==6 || colonna==7) {
		//neve, ghiaccio -> no in mesi estivi
		var dateObj = new Date();
		var month = dateObj.getUTCMonth() + 1; //months from 1-12
		if (month>=5 && month<=9) return;
	}
	
	var cel = document.getElementById("cella"+riga+"-"+colonna);
	var inp = cel.firstElementChild;
	var txt = document.getElementById("testo"+riga+"-"+colonna);
	var val = inp.value;
	
	var newstring = " ";
	if (newval==0) newstring="VERDE";
	if (newval==1) newstring="GIALLO";
	if (newval==2) newstring="ARANCIONE";
	if (newval==3) newstring="ROSSO";
	
	inp.value = ""+newval;
	cel.className = cel.className.replace("cellaAllerta"+val,"cellaAllerta"+newval);
	txt.innerHTML = newstring;
	
	setColoriMappaOggi(riga);
	
}

function toggleAllertaValoreNuovoX(riga,colonna,sottoriga,newval) {
	
	if (colonna==8 || colonna==9) {
		//stato del mare, crit costiera -> solo B2 e D2
		if (riga!=22 && riga!=42) return;
	}
	if (colonna==6 || colonna==7) {
		//neve, ghiaccio -> no in mesi estivi
		var dateObj = new Date();
		var month = dateObj.getUTCMonth() + 1; //months from 1-12
		if (month>=5 && month<=9) return;
	}
	
	var cel = document.getElementById("cellaX"+riga+"-"+colonna);
	var inp = cel.firstElementChild;
	var txt = document.getElementById("testoX"+riga+"-"+colonna);
	var val = inp.value;
	
	var newstring = " ";
	if (newval==0) newstring="VERDE";
	if (newval==1) newstring="GIALLO";
	if (newval==2) newstring="ARANCIONE";
	if (newval==3) newstring="ROSSO";
	
	inp.value = ""+newval;
	cel.className = cel.className.replace("cellaAllerta"+val,"cellaAllerta"+newval);
	txt.innerHTML = newstring;
	
	setColoriMappaDomani(riga);
	
}

function toggleAllertaValoreX(riga,colonna,sottoriga,newval) {
	
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
	
	var cel = document.getElementById("cellaX"+riga+"-"+colonna+"-"+sottoriga);
	var inp = cel.firstElementChild;
	var txt = document.getElementById("testoX"+riga+"-"+colonna+"-"+sottoriga);
	var val = inp.value;
	
	var newstring = " ";
	if (newval==0) newstring="VERDE";
	if (newval==1) newstring="GIALLO";
	if (newval==2) newstring="ARANCIONE";
	if (newval==3) newstring="ROSSO";
	
	inp.value = ""+newval;
	cel.className = cel.className.replace("cellaAllerta"+val,"cellaAllerta"+newval);
	txt.innerHTML = newstring;
	
	if (colonna<4) setColoriMappa1X(riga);
	else setColoriMappa2X(riga);
	
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

function toggleColonnaX(colonna) {
	
	var cel = document.getElementById("cellaX1-"+colonna+"-1");
	var inp = cel.firstElementChild;
	var val = parseInt(inp.value);
	var newval = 1000;
	if (val==1000) newval = 0;
	
	var k;
	
	if (colonna<4) {
		for (k=1; k<=8; k++) toggleAllertaValoreX(k,colonna,1,newval);
	} else {
		for (k=1; k<=8; k++) {
			toggleAllertaValoreX(k,colonna,1,newval);
			if (k!=6) toggleAllertaValoreX(k,colonna,2,newval);
		}
	}
	
}

function toggleColonnaNuovo(colonna) {
	
	var decodifica = [11,12,21,22,31,32,41,42,43,51,52,61,62,63,71,72,81,82];
	
	var cel = document.getElementById("cella11-"+colonna);
	var inp = cel.firstElementChild;
	var val = parseInt(inp.value);
	var newval = 1000;
	if (val==1000) newval = 0;
	
	var k;
	
	for (k=1; k<=decodifica.length; k++) toggleAllertaValoreNuovo(decodifica[k-1],colonna,1,newval);
	
	
}

function toggleColonnaNuovoX(colonna) {
	
	var decodifica = [11,12,21,22,31,32,41,42,43,51,52,61,62,63,71,72,81,82];
	
	var cel = document.getElementById("cellaX11-"+colonna);
	var inp = cel.firstElementChild;
	var val = parseInt(inp.value);
	var newval = 1000;
	if (val==1000) newval = 0;
	
	var k;
	
	for (k=1; k<=decodifica.length; k++) toggleAllertaValoreNuovoX(decodifica[k-1],colonna,1,newval);
	
	
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
			
			if (document.getElementById("mappa1-area"+riga))
				document.getElementById("mappa1-area"+riga).style.fill = colore;
			
		}

function setColoriMappaOggi(riga) {
	var peggiore = -1;
	var colonna;
	
	
	for (colonna=1; colonna<=9; colonna++) {
		var cel = document.getElementById("cella"+riga+"-"+colonna);
		var inp = cel.firstElementChild;
		var val = parseInt(inp.value);
		if (val!=1000 && val>peggiore) peggiore = val;
	}
	
	var colore = "#ffffff";
	if (peggiore==0) colore = "#98ff5d";
	if (peggiore==1) colore = "#eff200";
	if (peggiore==2) colore = "#ffa500";
	if (peggiore==3) colore = "#ff3a21";
	if (peggiore==-1 || peggiore==1000) colore="#ffffff";
	
	$('.mappa1-area'+ riga).each(function(i, obj) {
		obj.style.fill = colore;
	});
	
}

function setColoriMappaDomani(riga) {
	var peggiore = -1;
	var colonna;
	
	for (colonna=1; colonna<=9; colonna++) {
		var cel = document.getElementById("cellaX"+riga+"-"+colonna);
		var inp = cel.firstElementChild;
		var val = parseInt(inp.value);
		if (val!=1000 && val>peggiore) peggiore = val;
	}
	
	var colore = "#ffffff";
	if (peggiore==0) colore = "#98ff5d";
	if (peggiore==1) colore = "#eff200";
	if (peggiore==2) colore = "#ffa500";
	if (peggiore==3) colore = "#ff3a21";
	if (peggiore==-1 || peggiore==1000) colore="#ffffff";
	
	$('.mappa2-area'+ riga).each(function(i, obj) {
		obj.style.fill = colore;
	});
	
}

function setColoriMappa1X(riga) {
	var peggiore = -1;
	var colonna;
	
	for (colonna=1; colonna!=4; colonna++) {
		var cel = document.getElementById("cellaX"+riga+"-"+colonna+"-1");
		var inp = cel.firstElementChild;
		var val = parseInt(inp.value);
		if (val!=1000 && val>peggiore) peggiore = val;
	}
	
	var colore = "#ffffff";
	if (peggiore==0) colore = "#98ff5d";
	if (peggiore==1) colore = "#eff200";
	if (peggiore==2) colore = "#ffa500";
	if (peggiore==3) colore = "#ff3a21";
	
	if (document.getElementById("Xmappa1-area"+riga))
		document.getElementById("Xmappa1-area"+riga).style.fill = colore;
	
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
	
	if (document.getElementById("mappa2-area"+riga+"2"))
		document.getElementById("mappa2-area"+riga+"2").style.fill = colore;
		
	
}

function setColoriMappa2X(riga) {
	var peggiore = -1;
	var colonna;
	
	for (colonna=4; colonna!=10; colonna++) {
		var cel = document.getElementById("cellaX"+riga+"-"+colonna+"-1");
		var inp = cel.firstElementChild;
		var val = parseInt(inp.value);
		if (val!=1000 && val>peggiore) peggiore = val;
	}
	
	var colore = "#ffffff";
	if (peggiore==0) colore = "#98ff5d";
	if (peggiore==1) colore = "#eff200";
	if (peggiore==2) colore = "#ffa500";
	if (peggiore==3) colore = "#ff3a21";
	
	document.getElementById("Xmappa2-area"+riga+"1").style.fill = colore;
	
	if (riga==2)
		document.getElementById("Xmappa2-area"+riga+"1part2").style.fill = colore;
	
	if (riga==6) return;
	
	peggiore = -1;
	
	for (colonna=4; colonna!=10; colonna++) {
		var cel = document.getElementById("cellaX"+riga+"-"+colonna+"-2");
		var inp = cel.firstElementChild;
		var val = parseInt(inp.value);
		if (val!=1000 && val>peggiore) peggiore = val;
	}
	
	var colore = "#ffffff";
	if (peggiore==0) colore = "#98ff5d";
	if (peggiore==1) colore = "#eff200";
	if (peggiore==2) colore = "#ffa500";
	if (peggiore==3) colore = "#ff3a21";
	
	if (document.getElementById("Xmappa2-area"+riga+"2"))
		document.getElementById("Xmappa2-area"+riga+"2").style.fill = colore;
		
	
}

function toggleAllertaValanghe(riga,colonna,sottoriga) {			
	var cel = document.getElementById("cella"+riga+"-"+colonna+"-"+sottoriga);
	var inp = cel.firstElementChild;
	var txt = document.getElementById("testo"+riga+"-"+colonna+"-"+sottoriga);
	var val = inp.value;
	var newval = parseInt(val)+1;
	var newstring = " ";
	
	if (newval==1001) newval = 0;
	else if (newval==4)	newval = 1000;
	
	if (newval==0) newstring="VERDE";
	if (newval==1) newstring="GIALLO";
	if (newval==2) newstring="ARANCIONE";
	if (newval==3) newstring="ROSSO";
	
	inp.value = ""+newval;
	cel.className = cel.className.replace("cellaAllerta"+val,"cellaAllerta"+newval);
	txt.innerHTML = newstring;	
	
	setColoriMappaValanghe(riga);			
}

function toggleAllertaValangheOggi(riga,colonna,sottoriga) {			
	var cel = document.getElementById("cellaOggi"+riga+"-"+colonna+"-"+sottoriga);
	var inp = cel.firstElementChild;
	var txt = document.getElementById("testoOggi"+riga+"-"+colonna+"-"+sottoriga);
	var val = inp.value;
	var newval = parseInt(val)+1;
	var newstring = " ";
	
	if (newval==1001) newval = 0;
	else if (newval==4)	newval = 1000;
	
	if (newval==0) newstring="VERDE";
	if (newval==1) newstring="GIALLO";
	if (newval==2) newstring="ARANCIONE";
	if (newval==3) newstring="ROSSO";
	
	inp.value = ""+newval;
	cel.className = cel.className.replace("cellaAllerta"+val,"cellaAllerta"+newval);
	txt.innerHTML = newstring;	
	
	setColoriMappaValangheOggi(riga);			
}

function toggleAllertaValangheValore(riga,colonna,sottoriga,newval) {	
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
	
	setColoriMappaValanghe(riga);	
}

function toggleAllertaValangheValoreOggi(riga,colonna,sottoriga,newval) {	
	var cel = document.getElementById("cellaOggi"+riga+"-"+colonna+"-"+sottoriga);
	var inp = cel.firstElementChild;
	var txt = document.getElementById("testoOggi"+riga+"-"+colonna+"-"+sottoriga);
	var val = inp.value;	
	var newstring = " ";
	
	if (newval==0) newstring="VERDE";
	if (newval==1) newstring="GIALLO";
	if (newval==2) newstring="ARANCIONE";
	if (newval==3) newstring="ROSSO";
	
	inp.value = ""+newval;
	cel.className = cel.className.replace("cellaAllerta"+val,"cellaAllerta"+newval);
	txt.innerHTML = newstring;
	
	setColoriMappaValangheOggi(riga);	
}

function toggleValangheColonna(colonna) {	
	var cel = document.getElementById("cella1-"+colonna+"-1");
	var inp = cel.firstElementChild;
	var val = parseInt(inp.value);
	var newval = 1000;
	if (val==1000) newval = 0;
	
	var k;
	for (k=1; k<=3; k++) toggleAllertaValangheValore(k,colonna,1,newval);	
}

function toggleValangheColonnaOggi(colonna) {	
	var cel = document.getElementById("cellaOggi1-"+colonna+"-1");
	var inp = cel.firstElementChild;
	var val = parseInt(inp.value);
	var newval = 1000;
	if (val==1000) newval = 0;
	
	var k;
	for (k=1; k<=3; k++) toggleAllertaValangheValoreOggi(k,colonna,1,newval);	
}

function setColoriMappaValanghe(riga) {
	var peggiore = -1;
	var colonna;
	var numMaxCol = 2;
	
	if (riga==0) {
		var c = "#ffffff";
		$('.mappaValanghe-area'+ riga).each(function(i, obj) {
			obj.style.fill = c;
		});
		return;
	}
	
	for (colonna=1; colonna!=numMaxCol; colonna++) {
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
	
	//document.getElementById("mappaValanghe-area"+riga).style.fill = colore;
	
	$('.mappaValanghe-area'+ riga).each(function(i, obj) {
		obj.style.fill = colore;
	});
}

function setColoriMappaValangheOggi(riga) {
	var peggiore = -1;
	var colonna;
	var numMaxCol = 2;
	
	if (riga==0) {
		var c = "#ffffff";
		$('.mappaValangheOggi-area'+ riga).each(function(i, obj) {
			obj.style.fill = c;
		});
		return;
	}
	
	for (colonna=1; colonna!=numMaxCol; colonna++) {
		var cel = document.getElementById("cellaOggi"+riga+"-"+colonna+"-1");
		var inp = cel.firstElementChild;
		var val = parseInt(inp.value);
		
		if (val!=1000 && val>peggiore) peggiore = val;
	}
	
	var colore = "#ffffff";
	if (peggiore==0) colore = "#98ff5d";
	if (peggiore==1) colore = "#eff200";
	if (peggiore==2) colore = "#ffa500";
	if (peggiore==3) colore = "#ff3a21";
	
	//document.getElementById("mappaValanghe-area"+riga).style.fill = colore;
	
	$('.mappaValangheOggi-area'+ riga).each(function(i, obj) {
		obj.style.fill = colore;
	});
}
	
function setTuttiColoriValanghe() {	
	var k;
	
	for (k=0; k<=3; k++) {
		setColoriMappaValanghe(k);
		setColoriMappaValangheOggi(k);
	}			
}

function setTuttiColoriNuovo() {
	var decodifica = [11,12,21,22,31,32,41,42,43,51,52,61,62,63,71,72,81,82];
	for (k=0; k<18; k++) {
		setColoriMappaOggi(decodifica[k]);
		setColoriMappaDomani(decodifica[k]);
	}
	
}
		
function setTuttiColori() {

			var k;
			for (k=1; k<=8; k++) {
				setColoriMappa1(k);
				setColoriMappa2(k);
				setColoriMappa1X(k);
				setColoriMappa2X(k);
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

function aggiornaDataInizioOggi() {
	var d = moment().add('d', 1).startOf('day').add('h',-12).toDate()

   $('#datetimepicker1 .form-control')[0].value=
     ''+d.getDate()+'/'+(d.getMonth()+1)+'/'+d.getFullYear()+' 12:00';
}

function aggiornaDataInizioDomani() {
	
	var d = moment().add('d', 1).startOf('day').toDate()
	$('#datetimepicker1 .form-control')[0].value=
		''+d.getDate()+'/'+(d.getMonth()+1)+'/'+d.getFullYear()+' 00:00';
	
}

function aggiornaIntestazioni(duegiorni) {
	$('#intestazione').text(duegiorni?"Situazione dalle 00:00 di domani":"")
	$('#intestazioneX').text(duegiorni?"Situazione dalle 12:00 di oggi":"")
	if (duegiorni) {
		aggiornaDataInizioOggi()
	} else {
		aggiornaDataInizioDomani()
	}
}

function aggiornaIntestazioniValanghe(duegiorni) {
	if (duegiorni) {
		aggiornaDataInizioOggi()
	} else {
		aggiornaDataInizioDomani()
	}
}

	function mergeTabellaDettaglio() {
		autoMergeByRow("_inviisms_WAR_compilaallertaportlet_\\:fo\\:sms2",0,0,0,8);
	}
	
	(function($){
		if ($("#mappa").length > 0) {
			setTuttiColoriNuovo();	
		}
		if ($("#mappa1").length > 0) {
			setTuttiColori();	
		}
		if ($("#mappaValanghe").length > 0) {
			setTuttiColoriValanghe();	
		}
		
	})(jQuery);
	
	
	
	