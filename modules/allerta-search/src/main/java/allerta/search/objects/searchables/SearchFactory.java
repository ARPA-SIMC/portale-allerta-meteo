package allerta.search.objects.searchables;

import java.util.HashMap;
import java.util.Map;

import allerta.search.objects.Searchable;

public class SearchFactory {
	
	static final Map<String, Searchable> searchables = new HashMap<String, Searchable>();

	static {
		searchables.put("allerta", new AllertaSearchable());
		searchables.put("valanghe", new ValangheSearchable());
		searchables.put("monitoraggio", new MonitoraggioSearchable());
		searchables.put("report-post-evento", new ReportPostEventoSearchable());
		searchables.put("allerta-briefing", new AllertaBriefingSearchable());
		searchables.put("verifica-settimanale", new VerificaSettimanaleSearchable());
	}
	
	public static Searchable getSearchable(String name) {
		return searchables.get(name);
	}
}
