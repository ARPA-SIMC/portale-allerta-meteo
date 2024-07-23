package allerta.search.filter;

import java.util.List;
import java.util.Map;

import it.eng.bollettino.service.BollettinoLocalServiceUtil;

public class AutocompletionTextFilter extends TextFilter {
	
	List<String> autocompletion;

	public AutocompletionTextFilter(String name, String label, int width, List<String> autoOptions, String classes, String styles,
			Map<String, String> params) {
		super(name, label, width, classes, styles, params);
		autocompletion = autoOptions;
	}
	
	public AutocompletionTextFilter(String name, String label, int width, String query, String classes, String styles,
			Map<String, String> params) {
		super(name, label, width, classes, styles, params);
		autocompletion = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(query);
	}
	
	@Override
	public String render() {
		
		String text = "";
		for (String s : autocompletion)
			text+="<a href=\"#\" class=\"autocomp-opt\">"+s+"</a>";
		
		return "<DIV><label class=\"control-label\" for=\""+name+"\">"+label+"</label>"+
				"<input type=\"text\" class=\"form-control autocomp-input "+classes+"\" "+
				(styles!=null?"style=\""+styles+"\"":"")+" name=\""+name+"\" /> <div><ul class=\"autocomp-options autocomp-options-"+name+"\" style=\"display:none\">"+text+
				"</ul></div> <div class=\"autocomp-search-results autocomp-"+name+"\" ></div></DIV>";
	}

}
