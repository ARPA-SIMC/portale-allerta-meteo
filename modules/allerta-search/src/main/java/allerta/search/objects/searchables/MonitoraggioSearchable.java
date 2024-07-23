package allerta.search.objects.searchables;

import java.util.List;
import java.util.Map;

import allerta.search.filter.MenuFilter;
import allerta.search.filter.TextFilter;
import allerta.search.objects.CountResult;
import allerta.search.objects.SearchResult;
import allerta.search.objects.Searchable;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

public class MonitoraggioSearchable extends Searchable {
	
	public static final String QUERY_COUNT_BY_YEAR =
			"select substring(numero from 5 for 4) as anno ,count(*) as cnt from bollettino_bollettino x where stato=0 _CRITERIA_ " + 
			"group by substring(numero from 5 for 4) order by substring(numero from 5 for 4) desc";

	public static final String QUERY_COUNT_BY_MONTH =
			"select substring(numero from 1 for 8) as evento ,count(*) as cnt from bollettino_bollettino x where stato=0 _CRITERIA_ " + 
			"group by substring(numero from 1 for 8) order by substring(numero from 1 for 8) desc";

	public static final String QUERY_SEARCH =
			"select cast(('Monitoraggio n. ' || numero) as character varying) as title,numero as subtitle, " + 
			"'/web/guest/monitoraggio-dettaglio/-/asset_publisher/16LwXJHZXwfc/Bollettino/id/' || " + 
			"(select entryid from assetentry where classnameid=92303 and classpk=x.bollettinoid limit 1) as link, " + 
			"to_char(dataemissione,'DD/MM/YYYY HH24:MI') as dataemissione,to_char(datainizio,'DD/MM/YYYY HH24:MI') as datainizio,cast('icon i-file-text-o' as character varying) as cls, link as pdf from bollettino_bollettino x " + 
			"where stato=0 _CRITERIA_ order by x.dataemissione desc";
	
	public static final String QUERY_FEED =
			"select 'Monitoraggio n. ' || numero  as titolo,'https://allertameteo.regione.emilia-romagna.it' || link as link,"
			+ "'https://allertameteo.regione.emilia-romagna.it' || link as uuid,dataemissione,notemeteo as sint from bollettino_bollettino x where stato = 0 _CRITERIA_ order by x.dataemissione desc";
	
	public MonitoraggioSearchable() {
		super();
		
		filters.add(new TextFilter("numero", "Numero", 2, "", "", null));
		
		MenuFilter mf;
		
		
		String query = "select id_, nome from bollettino_bacino order by progressivo asc";
		try {
			
			List<Object[]> l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(query);
			mf = new MenuFilter("bacino", "Bacino", 3, "", "", null);
			mf.addOption("", "");
			for (Object[] o : l) {
				mf.addOption(o[0].toString(), o[1].toString());
			}
			filters.add(mf);
		} catch (Exception e) {}
		

		filters.add(new TextFilter("stazione", "Stazione", 2, "", "", null));

	}
	
	@Override
	public String getName() {
		return "documenti di monitoraggio";
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
	public String getMonthEquivalent() {
		return "evento";
	}
	
	@Override
	public String translateMonth(String evento) {
		return evento;
	}

	@Override
	public String getCriteriaQuery(Map<String, String> criteria) {
		String query = "";
		
		for (String key : criteria.keySet()) {
			
			String value = criteria.get(key);
			value = value.replaceAll("'", "");
			value = value.replaceAll("\"", "");
			value = value.replaceAll("\\(", "");
			value = value.replaceAll("\\)", "");
			value = value.replaceAll("&", "");
			value = value.replaceAll("\\\\", "");
			value = value.replaceAll(",", " ");
			value = value.replaceAll(";", " ");
			value = value.trim();
			if ("".equals(value)) continue;
			
			if ("anno".equals(key)) query += " and numero like '%/"+value+"/%'";
			
			if ("evento".equals(key)) query += " and numero like '"+value+"/%'";
			
			if ("numero".equals(key)) query += " and numero like '%"+value+"%' ";
			
		
			
			if ("bacino".equals(key)) {
				query += " and exists (select * from bollettino_bollettinosensore y join bollettino_bollettinobacino b on y.idbollettinobacino=b.id_ where y.idbollettino=x.bollettinoid and b.idbacino='"+value+"' and y.tendenza<>-100) ";
			}
			
			if ("stazione".equals(key)) {
				query += " and exists (select * from bollettino_bollettinosensore y where y.idbollettino=x.bollettinoid and upper(y.nomestazione) like '%"+value.toUpperCase()+"%' and y.tendenza<>-100) ";
			}

		}
		
		return query;
	}


	public String getFeedId() { return "monitoraggi"; }
	public String getFeedTitle() { return "Monitoraggi eventi"; }
	public String getFeedLink() { return "monitoraggio-eventi"; }

}
