package allerta.verifica.web.bean;

import java.text.SimpleDateFormat;
import java.util.List;

import allerta.verifica.model.VerificaDato;
import allerta.verifica.web.constants.CostantiVerificaAllerte;

public class CostruttoreVerificaDato {
	
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	public static String getDataRepresentation(VerificaDato v, boolean disabled, boolean addWidget) {
		if (v==null) return "";
		
		String tipoDato = CostantiVerificaAllerte.TIPI_COLONNE.get(v.getNomeDato());
		
		if (tipoDato==null || "INPUT".equals(tipoDato))
			return getInputTextArea(v,disabled,addWidget);
		
		return "";
	}
	
	public static String getInputText(VerificaDato v, boolean disabled, boolean addWidget) {
		if (v==null) return "";
		
		String out;
		String field = getFieldName(v);
		boolean diff = isDifferent(v);
		out = "<div class=\"datocontainer\"><input "+(disabled?" disabled ":"")+" id=\""+field
				+"\" type=\"text\" name=\""+field+"\" class=\"form-control "+
				(diff?" datoDifferente ":"")+"\" value=\""+getDato(v)+"\" />" ;
		
		if (addWidget && v.getDatoCalcolato()!=null && !"".equals(v.getDatoCalcolato())) {
			out+=getWidget(field,v.getDatoCalcolato());
		}
		out+="</div>";
		return out;
	}
	
	public static String getInputTextArea(VerificaDato v, boolean disabled, boolean addWidget) {
		if (v==null) return "";
		
		String out;
		String field = getFieldName(v);
		boolean diff = isDifferent(v);
		out = "<div class=\"datocontainer\"><textarea style=\"height: 100px\" "+(disabled?" disabled ":"")+" id=\""+field
				+"\" type=\"text\" name=\""+field+"\" class=\"form-control "+
				(diff?" datoDifferente ":"")+"\">" + getDato(v)+ "</textarea>";
		
		if (addWidget && v.getDatoCalcolato()!=null && !"".equals(v.getDatoCalcolato())) {
			out+=getWidget(field,v.getDatoCalcolato());
		}
		out+="</div>";
		return out;
	}
	
	public static String getSelect(VerificaDato v, String[] keys, String[] labels, boolean disabled, boolean addWidget) {
		
		return getSelect(v, keys, labels, null, disabled, addWidget);
	}
	
	public static String getSelect(VerificaDato v, String[] keys, String[] labels, String js, boolean disabled, boolean addWidget) {
		if (v==null) return "";
		
		String out;
		String field = getFieldName(v);
		boolean diff = isDifferent(v);
		out = "<div class=\"datocontainer\"><select "+(disabled?" disabled ":"")+" id=\""+field
				+"\" name=\""+field+"\""+(js!=null?" onchange=\""+js+"\"":"")+" class=\"form-control "+
				(diff?" datoDifferente ":"")+"\">";
		
		for (int k=0; k<keys.length; k++) {
			out+="<option"+(keys[k].equals(getDato(v))?" selected ":"")+" value=\""+keys[k]+"\">"+labels[k]+"</option>";
		}
		
		out+="</select>";
		
		if (addWidget && v.getDatoCalcolato()!=null && !"".equals(v.getDatoCalcolato())) {
			out+=getWidget(field,v.getDatoCalcolato());
		}
		
		out+="</div>";
		
		return out;
	}
	
	public static String getWidget(String campo, String valore) {
		String widget = "<span onclick=\"ripristina('"+campo+"','"+valore+"')\" class=\"icon icon i-star-o tooltip2 \" aria-hidden=\"true\"><span class='tooltiptext'>Valore calcolato: "
				+valore+"</span></span>";
		return widget;
	}
	
	
	public static String getFieldName(VerificaDato v) {
		String out = "verificadato_"+(v.getGiorno()!=null?sdf.format(v.getGiorno())+"_":"")+
				(v.getEvento()>=0?v.getEvento()+"_":"")+
				(v.getZona()!=null?v.getZona()+"_":"")+
				(v.getNomeDato()!=null?v.getNomeDato():"")+
				(v.getProgressivo()>0?"_"+v.getProgressivo():"");
		
		return out;
	}
	
	public static boolean isDifferent(VerificaDato v) {
		return (v.getDatoCalcolato()!=null && v.getDatoInserito()!=null && !v.getDatoCalcolato().equals(v.getDatoInserito()));
	}
	
	public static String getDato(VerificaDato v) {
		if (v==null) return null;
		if (v.getDatoInserito()!=null /*&& (!v.getDatoInserito().equals(""))*/) return v.getDatoInserito();
		if (v.getDatoCalcolato()!=null) return v.getDatoCalcolato();
		return "";
	}
	
	
	public static String getEventoMenu(List<VerificaDato> dati,String id,long sel,String js) {
		String eventi[] = {"Crit. idraulica","Crit. idrogeologica","Crit. temporali","Vento",
				"Temp. estreme", "Neve", "Pioggia che gela", "Stato del mare", "Crit. costiera"};
		String out = "<select class=\"form-control\" id=\""+id+"\" name=\"" + id+"\" onchange=\""+js+"\" >";
		
		for (int k=1; k<=9; k++) {
			boolean giallo = false;
			boolean arancione = false;
			boolean rosso = false;
			String even = eventi[k-1];
			out+="<option "+(sel==k?"selected":"")+" value=\""+(k)+"\" >";
			List<VerificaDato> lv = VerificaAllertaBean.filtraDati(dati, null, null, (long)k, "colore_pre", null);
			for (VerificaDato vv : lv) {
				String ddd = vv.getDatoCalcolato();
				if ("GIALLO".equals(ddd)) giallo = true;
				if ("ARANCIONE".equals(ddd)) arancione = true;
				if ("ROSSO".equals(ddd)) rosso = true;
			}
			if (rosso) even +=" [ROSSO]";
			else if (arancione) even += " [ARANCIONE]";
			else if (giallo) even += " [GIALLO]";
			out+=even+"</option>";
			
		}
		out+="</select>";
		
		return out;
	}

}
