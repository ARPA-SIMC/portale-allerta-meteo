package allerta.search.filter;

import java.util.Map;

public class TextFilter extends SearchFilter {
	
	public TextFilter(String name, String label, int width, String classes, String styles, Map<String,String> params) {
		setName(name);
		setClasses(classes);
		setStyles(styles);
		setLabel(label);
		setParams(params);
		setWidth(width);
	}

	@Override
	public String render() {
		return "<label class=\"control-label\" for=\""+name+"\">"+label+"</label>"+
				"<input type=\"text\" class=\"form-control "+classes+"\" "+this.renderEvents()+" "+
				(styles!=null?"style=\""+styles+"\"":"")+" name=\""+name+"\" />";
	}

	@Override
	public Object parseValue(String input) {
		return input;
	}

	@Override
	public String formatValue(Object input) {
		return input.toString();
	}
	
	

}
