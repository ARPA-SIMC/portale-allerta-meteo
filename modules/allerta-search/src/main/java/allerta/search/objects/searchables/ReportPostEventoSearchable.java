package allerta.search.objects.searchables;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import allerta.search.filter.DateFilter;
import allerta.search.objects.Searchable;

public class ReportPostEventoSearchable extends Searchable {
	
	public static final String QUERY_COUNT_BY_YEAR =
			"select date_part('year',data_sort) as anno ,count(*) as cnt from report_post_evento_vw x where 1=1 _CRITERIA_ " + 
			"group by date_part('year',data_sort) order by date_part('year',data_sort) desc";

	public static final String QUERY_COUNT_BY_MONTH = ""; //nessuna divisione per mese

	public static final String QUERY_SEARCH =
			"select cast(titolo as text) as titolo,cast(titolo as text) as subtitle, " + 
			"cast(link as text) as text, " + 
			"to_char(data_pubblicazione,'DD/MM/YYYY HH24:MI') as dataemissione,to_char(data_inizio,'DD/MM/YYYY') as datainizio,cast('icon i-bullhorn-o' as text) as cls, cast(pdf as text) from report_post_evento_vw x " + 
			"where 1=1 _CRITERIA_ order by x.data_sort desc";
	
	public static final String QUERY_FEED =
			"select titolo,'https://allertameteo.regione.emilia-romagna.it' || pdf as link,"
			+ "'https://allertameteo.regione.emilia-romagna.it' || link as uuid,data_pubblicazione,titolo as sint "
			+ "from report_post_evento_vw x where 1=1 _CRITERIA_ order by x.data_sort desc";
	
	
	public ReportPostEventoSearchable() {
		filters.add(new DateFilter("inizio-da","Data inizio evento da",3,"","",null));
		filters.add(new DateFilter("inizio-a","Data inizio evento a",3,"","",null));
		filters.add(new DateFilter("fine-da","Data fine evento da",3,"","",null));
		filters.add(new DateFilter("fine-a","Data fine evento a",3,"","",null));
		filters.add(new DateFilter("pub-da","Data pubblicazione da",3,"","",null));
		filters.add(new DateFilter("pub-a","Data pubblicazione a",3,"","",null));
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "report post evento";
	}

	@Override
	public String getQueryCountByYear() {
		return QUERY_COUNT_BY_YEAR;
	}

	@Override
	public String getQueryCountByMonth() {
		return QUERY_COUNT_BY_MONTH;
	}

	@Override
	public String getQuerySearch() {
		return QUERY_SEARCH;
	}
	
	@Override
	public String getQueryFeed() {
		return QUERY_FEED;
	}

	@Override
	public String getCriteriaQuery(Map<String, String> criteria) {
		// TODO Auto-generated method stub
		String out = "";
		
		try {
		
		SimpleDateFormat formatIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatOut = new SimpleDateFormat("yyyy-MM-dd");
		
		if (criteria.containsKey("inizio-da")) {
			String s = criteria.get("inizio-da");
			out+=" and x.data_inizio>='"+formatOut.format(formatIn.parse(s))+"'";
		}
		
		if (criteria.containsKey("inizio-a")) {
			String s = criteria.get("inizio-a");
			out+=" and x.data_inizio<='"+formatOut.format(formatIn.parse(s))+"'";
		}
		
		if (criteria.containsKey("fine-da")) {
			String s = criteria.get("fine-da");
			out+=" and x.data_fine>='"+formatOut.format(formatIn.parse(s))+"'";
		}
		
		if (criteria.containsKey("fine-a")) {
			String s = criteria.get("fine-a");
			out+=" and x.data_fine<='"+formatOut.format(formatIn.parse(s))+"'";
		}
		
		if (criteria.containsKey("pub-da")) {
			String s = criteria.get("pub-da");
			out+=" and x.data_pubblicazione>='"+formatOut.format(formatIn.parse(s))+"'";
		}
		
		if (criteria.containsKey("pub-a")) {
			String s = criteria.get("pub-a");
			out+=" and x.data_pubblicazione<='"+formatOut.format(formatIn.parse(s))+"'";
		}
		
		if (criteria.containsKey("anno")) {
			String s = criteria.get("anno");
			out+=" and date_part('year',data_sort)="+s;
		}
		
		} catch (Exception e) {
			return "";
		}
		return out;
	}
	
	@Override
	public String getMonthEquivalent() {
		return null; //i report post evento non hanno la suddivisione su due livelli
	}
	
	public String getFeedId() { return "report-post-evento"; }
	public String getFeedTitle() { return "Report post evento"; }
	public String getFeedLink() { return "archivio-report-post-evento"; }

}
