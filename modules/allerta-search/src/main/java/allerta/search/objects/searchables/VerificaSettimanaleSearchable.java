package allerta.search.objects.searchables;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import allerta.search.filter.DateFilter;
import allerta.search.objects.Searchable;

public class VerificaSettimanaleSearchable extends Searchable {
	
	public static final String QUERY_COUNT_BY_YEAR =
			"select date_part('year',datainiziovera), count(*) as cnt from verifica_settimanale_vw where 1=1 _CRITERIA_ " + 
			"group by date_part('year',datainiziovera) order by date_part('year',datainiziovera) desc ";

	public static final String QUERY_COUNT_BY_MONTH =
			"select date_part('month',datainiziovera), count(*) as cnt from verifica_settimanale_vw where 1=1 _CRITERIA_ " + 
			"group by date_part('month',datainiziovera) order by date_part('month',datainiziovera)";


	public static final String QUERY_SEARCH =
			"select * from verifica_settimanale_vw where 1=1 _CRITERIA_";
	
	public static final String QUERY_FEED =
			"select titolo,'https://allertameteo.regione.emilia-romagna.it' || pdf as link,"
			+ "dataemissione as uuid, dataemissione as data_pubblicazione, titolo as sint "
			+ "from verifica_settimanale_vw x where 1=1 _CRITERIA_";
	
	
	public VerificaSettimanaleSearchable() {
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "verifiche settimanali allerte";
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

		if (criteria.containsKey("anno")) {
			String s = criteria.get("anno");
			out+=" and date_part('year',datainiziovera)="+s;
		}
		
		if (criteria.containsKey("mese")) {
			String s = criteria.get("mese");
			out += " and date_part('month',datainiziovera)="+s;
		}

		
		} catch (Exception e) {
			return "";
		}
		return out;
	}

	
	public String getFeedId() { return "verifica-settimanale"; }
	public String getFeedTitle() { return "Report settimanale verifiche allerte"; }
	public String getFeedLink() { return "verifica-settimanale"; }

}

