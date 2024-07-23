package allerta.search.filter;

import java.util.HashMap;
import java.util.Map;

public abstract class SearchFilter {
	
	String name;
	String label;
	String classes;
	String styles;
	Map<String, String> params;
	Map<String,String> events;
	int width = 0;
	
	public abstract String render();
	public abstract Object parseValue(String input);
	public abstract String formatValue(Object input);
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getStyles() {
		return styles;
	}

	public void setStyles(String styles) {
		this.styles = styles;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Map<String, String> getParams() {
		return params;
	}
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	
	public Map<String, String> getEvents() {
		if (events==null) events = new HashMap<String, String>();
		return events;
	}
	public void setEvents(Map<String, String> events) {
		this.events = events;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	protected String renderEvents() {
		String out = "";
		if (events==null) return out;
		for (String ev: events.keySet()) {
			out+="on"+ev+"=\""+events.get(ev)+"\" ";
		}
		return out;
	}

}
