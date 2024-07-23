package allerta.search.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class DateFilter extends SearchFilter {
	
	public static final SimpleDateFormat formatoSenzaOra = new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat formatoConOra = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public DateFilter(String name, String label, int width, String classes, String styles, Map<String,String> params) {
		setName(name);
		setClasses(classes);
		setStyles(styles);
		setLabel(label);
		setParams(params);
		setWidth(width);
	}
	
	@Override
	public String render() {
		return "<div class=\"col form-group\"><label class=\"control-label\" for=\"datetimepicker_"+name+"\">"+label+"</label>"+
				"<div class=\"input-group date input-group--date-picker\" id=\"datetimepicker_"+name+"\">\r\n" + 
				"		            <input type=\"text\" class=\"form-control "+classes+"\" name=\""+name+"\" value=\"\" placeholder=\"gg/mm/aaaa\">\r\n" + 
				"	                <span class=\"input-group-addon\">\r\n" + 
				"	                   <i class=\"far fa-calendar-minus\"></i>\r\n" + 
				"	                </span>\r\n" + 
				"	             </div></div>";
	}

	@Override
	public Object parseValue(String input) {
		if (input==null || "".equals(input)) return null;
		Date d = null;
		try {
			d = formatoConOra.parse(input);
		} catch (Exception pe) {
			try {
				d = formatoSenzaOra.parse(input); 
			} catch (Exception pe2) {}
		}
		return d;
	}

	@Override
	public String formatValue(Object input) {
		if (input==null || input.equals("")) return "";
		return formatoSenzaOra.format((Date)input);
	}

}
