package allerta.search.objects.searchables;

import java.util.List;
import java.util.Map;

import allerta.search.filter.AutocompletionTextFilter;
import allerta.search.filter.MenuFilter;
import allerta.search.filter.TextFilter;
import allerta.search.objects.CountResult;
import allerta.search.objects.SearchResult;
import allerta.search.objects.Searchable;

public class ValangheSearchable extends Searchable {
	
	public static final String QUERY_COUNT_BY_YEAR =
			"select date_part('year',datainizio) as anno ,count(*) as cnt from allerter_allertavalanghe x where stato=0 _CRITERIA_ " + 
			"group by date_part('year',datainizio) order by date_part('year',datainizio) desc";

	public static final String QUERY_COUNT_BY_MONTH =
			"select date_part('month',datainizio) as mese ,count(*) as cnt from allerter_allertavalanghe x where stato=0 _CRITERIA_ " + 
			"group by date_part('month',datainizio) order by date_part('month',datainizio) desc";

	public static final String QUERY_SEARCH =
			"select titolo,numero as subtitle, " + 
			"'/web/guest/singola-allerta-valanghe/-/asset_publisher/3KQ7Ixh8YDd7/AllertaValanghe-Bollettino/id/' || " + 
			"(select entryid from assetentry where classnameid=(select classnameid from classname_ where value='it.eng.allerter.model.AllertaValanghe') and classpk=x.allertavalangheid limit 1) as link, " + 
			"to_char(dataemissione,'DD/MM/YYYY HH24:MI') as dataemissione,to_char(datainizio,'DD/MM/YYYY HH24:MI') as datainizio,case when tipoallerta then 'icon i-warning-o' else 'icon i-bullhorn-o' end as cls, link as pdf from allerter_allertavalanghe x " + 
			"where stato=0 _CRITERIA_ order by x.dataemissione desc";
	
	public static final String QUERY_FEED =
			"select titolo,'https://allertameteo.regione.emilia-romagna.it' || link as link,"
			+ "'https://allertameteo.regione.emilia-romagna.it' || link as uuid,dataemissione,case when (sintesi is null or sintesi='') then  descrizionefenomeni ELSE sintesi END as sint "
			+ "from allerter_allertavalanghe x where stato = 0 _CRITERIA_ order by x.dataemissione desc";
	
	public ValangheSearchable() {
		super();
		
		filters.add(new TextFilter("numero", "Numero", 2, "", "", null));
		
		MenuFilter mf = new MenuFilter("tipo", "Tipo", 2, "", "", null);
		mf.addOption("X", "Tutte");
		mf.addOption("A", "Solo allerte");
		mf.addOption("B", "Solo bollettini");
		mf.getEvents().put("change", "var dis=(this.value=='B'?'disabled':null); $('.soloAllerte').attr('disabled',dis); ");

		
		filters.add(mf);
		
		mf = new MenuFilter("colore", "Colore allerta", 2, "soloAllerte", "", null);
		mf.addOption("", "");
		mf.addOption("1", "Gialla");
		mf.addOption("2", "Arancione");
		mf.addOption("3", "Rossa");
		
		filters.add(mf);
		
		mf = new MenuFilter("zona", "Zona", 2, "soloAllerte", "", null);
		mf.addOption("", "");
		mf.addOption("10", "Appennino Emiliano Occidentale");
		mf.addOption("20", "Appennino Emiliano Centrale");
		mf.addOption("30", "Appennino Romagnolo");
		
		filters.add(mf);
		
		filters.add(new AutocompletionTextFilter("comune", "Comune", 3,"select distinct nome from storico_aree where tipo='V' order by nome", "soloAllerte", "", null));

	}
	
	@Override
	public String getName() {
		return "allerte e bollettini valanghe";
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
		String query = "";
		

		boolean tupleQuery = criteria.containsKey("colore") || criteria.containsKey("zona") || criteria.containsKey("comune");
		if (criteria.containsKey("tipo") && "B".equals(criteria.get("tipo")))
			tupleQuery = false; //se vuole solo i bollettini ignora le restrizioni su zona ed evento
		
		
		
		String tuple = "and (select max(statoid) from allerter_allertavalanghestato y where y.allertavalangheid=x.allertavalangheid and y.statoid in (1,2,3) %ZONA% %COMUNE%)%COLORE%";
		if (tupleQuery) {
			if (criteria.containsKey("colore")) tuple = tuple.replace("%COLORE%", "="+criteria.get("colore"));
			else tuple = tuple.replace("%COLORE%", ">0"); //qualunque
			
			if (criteria.containsKey("zona")) {
				String zoneSub = "";
				try {
					
					zoneSub += " and y.areaid = "+criteria.get("zona")+" ";
				} catch (Exception e) {}
				tuple = tuple.replace("%ZONA%", zoneSub);
			}
			else tuple = tuple.replace("%ZONA%", ""); //qualunque
			
			if (criteria.containsKey("comune")) {
				String subs = " and exists(select * from storico_aree a where a.tipo='V' and upper(a.nome)=upper('"+criteria.get("comune")+"') and y.areaid=a.areaid and x.datainizio>=a.data_inizio and x.datainizio<=a.data_fine)";
				tuple = tuple.replace("%COMUNE%", subs);
			} else tuple = tuple.replace("%COMUNE%", ""); //qualunque

			
			
		}
		
		for (String key : criteria.keySet()) {
			
			String value = criteria.get(key);
			if ("".equals(value)) continue;
			
			if ("anno".equals(key)) query += " and numero like '%/"+value+"'";
			
			if ("mese".equals(key)) query += " and date_part('month',datainizio)="+value;
			
			if ("numero".equals(key)) query += " and numero like '%"+value+"%' ";
			
			if ("tipo".equals(key)) {
				if ("A".equals(value)) query += " and tipoallerta ";
				else if ("B".equals(value)) query += " and not tipoallerta ";
			}

		}
		
		if (tupleQuery) query += tuple;
		
		return query;
	}


	public String getFeedId() { return "valanghe"; }
	public String getFeedTitle() { return "Allerte e bollettini valanghe"; }
	public String getFeedLink() { return "allerte-e-bollettini-valanghe"; }

}
