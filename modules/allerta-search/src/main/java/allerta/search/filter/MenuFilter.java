package allerta.search.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuFilter extends SearchFilter {
	
	private class Option {
		String value;
		String label;
		
		public Option(String v, String l) {
			value = v;
			label = l;
		}
	}
	
	List<Option> options = new ArrayList<MenuFilter.Option>();

	public MenuFilter(String name, String label, int width, String classes, String styles, Map<String,String> params) {
		setName(name);
		setClasses(classes);
		setStyles(styles);
		setLabel(label);
		setParams(params);
		setWidth(width);
	}
	
	@Override
	public String render() {
		String o2 = "";
		for (Option o : options) {
			o2+="<option value=\""+o.value+"\">"+o.label+"</option>";
		}
		return "<label class=\"control-label\" for=\""+name+"\">"+label+"</label>"+
		"<select class=\"form-control "+classes+"\" "+this.renderEvents()+" "+
		(styles!=null?"style=\""+styles+"\"":"")+" name=\""+name+"\" >"+o2+"</select>";
	}

	@Override
	public Object parseValue(String input) {
		return input;
	}

	@Override
	public String formatValue(Object input) {
		return input.toString();
	}
	
	public void addOption(String value, String label) {
		options.add(new Option(value,label));
	}

}
