package allerta.search.objects.searchables;

import java.util.List;
import java.util.Map;

import allerta.search.filter.AutocompletionTextFilter;
import allerta.search.filter.MenuFilter;
import allerta.search.filter.TextFilter;
import allerta.search.objects.CountResult;
import allerta.search.objects.SearchResult;
import allerta.search.objects.Searchable;

public class AllertaSearchable extends Searchable {
	
	public static final String QUERY_COUNT_BY_YEAR =
			"select date_part('year',datainizio) as anno ,count(*) as cnt from allerter_allerta x where stato=0 _CRITERIA_ " + 
			"group by date_part('year',datainizio) order by date_part('year',datainizio) desc";

	public static final String QUERY_COUNT_BY_MONTH =
			"select date_part('month',datainizio) as mese ,count(*) as cnt from allerter_allerta x where stato=0 _CRITERIA_ " + 
			"group by date_part('month',datainizio) order by date_part('month',datainizio) desc";

	public static final String QUERY_SEARCH =
			"select titolo,numero as subtitle, " + 
			"'/web/guest/singola-allerta/-/asset_publisher/FZPQSb6AzKtJ/Allerta-Bollettino/id/' || " + 
			"(select entryid from assetentry where classnameid=92243 and classpk=x.allertaid limit 1) as link, " + 
			"to_char(dataemissione,'DD/MM/YYYY HH24:MI') as dataemissione,to_char(datainizio,'DD/MM/YYYY HH24:MI') as datainizio,case when tipoallerta then 'icon i-warning-o' else 'icon i-bullhorn-o' end as cls, link as pdf from allerter_allerta x " + 
			"where stato=0 _CRITERIA_ order by x.dataemissione desc";
	
	public static final String QUERY_FEED =
			"select titolo,'https://allertameteo.regione.emilia-romagna.it' || link as link,"
			+ "'https://allertameteo.regione.emilia-romagna.it' || link as uuid,dataemissione,case when (sintesi is null or sintesi='') then  descrizionemeteo ELSE sintesi END as sint "
			+ "from allerter_allerta x where stato = 0 _CRITERIA_ order by x.dataemissione desc";
	
	public AllertaSearchable() {
		super();
		
		filters.add(new TextFilter("numero", "Numero", 1, "", "", null));
		
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
		
		mf = new MenuFilter("evento", "Evento", 2, "soloAllerte", "", null);
		mf.addOption("", "");
		mf.addOption("1", "Piene dei fiumi");
		mf.addOption("2", "Frane e piene dei fiumi minori");
		mf.addOption("3", "Temporali");
		mf.addOption("4", "Vento");
		mf.addOption("5", "Temperature estreme");
		mf.addOption("6", "Neve");
		mf.addOption("7", "Pioggia che gela");
		mf.addOption("8", "Stato del mare");
		mf.addOption("9", "Criticità costiera");
		
		filters.add(mf);
		
		filters.add(new TextFilter("zone", "Zone (separate da spazi)", 2, "soloAllerte", "", null));

		filters.add(new AutocompletionTextFilter("comune", "Comune", 3,"select distinct nome from storico_aree where tipo='M' order by nome", "soloAllerte", "", null));
	}
	
	@Override
	public String getName() {
		return "allerte e bollettini meteo";
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
		
		
		//queste condizioni, se presenti insieme, devono puntare allo stesso oggetto AllertaStato
		boolean tupleQuery = criteria.containsKey("colore") || criteria.containsKey("zone") || criteria.containsKey("evento") || criteria.containsKey("comune");
		if (criteria.containsKey("tipo") && "B".equals(criteria.get("tipo")))
			tupleQuery = false; //se vuole solo i bollettini ignora le restrizioni su zona ed evento
		
		
			
		String tuple = "and (select max(statoid) from allerter_allertastato y where y.allertaid=x.allertaid and y.statoid in (1,2,3) %ZONE% %EVENTO% %COMUNE%)%COLORE%";
		if (tupleQuery) {
			if (criteria.containsKey("colore")) tuple = tuple.replace("%COLORE%", "="+criteria.get("colore"));
			else tuple = tuple.replace("%COLORE%", ">0"); //qualunque
			
			if (criteria.containsKey("zone")) {
				String zoneSub = "";
				try {
					String[] s = criteria.get("zone").toUpperCase().split(" ");
					String v2 = "(-100";
					for (String sx :s) {
						sx = sx.trim();
						if (sx.length()<1 || sx.length()>2) continue;
						int code = (sx.charAt(0)-'A'+1)*10;
						if (code<10 || code>=90) continue;
						if (sx.length()==2) {
							int increment = sx.charAt(1)-'0';
							if (increment<1 || increment>3) continue;
							code+=(sx.charAt(1)-'0');
						}
						v2+=","+code;
					}
					v2+=")";
					zoneSub += " and y.areaid in "+v2+" ";
				} catch (Exception e) {}
				tuple = tuple.replace("%ZONE%", zoneSub);
			}
			else tuple = tuple.replace("%ZONE%", ""); //qualunque
			
			if (criteria.containsKey("comune")) {
				String com = criteria.get("comune");
				com = com.replaceAll("'", "''");
				String subs = " and exists(select * from storico_aree a where a.tipo='M' and upper(a.nome)=upper('"+com+"') and y.areaid=a.areaid and x.datainizio>=a.data_inizio and x.datainizio<=a.data_fine)";
				tuple = tuple.replace("%COMUNE%", subs);
			} else tuple = tuple.replace("%COMUNE%", ""); //qualunque
			
			if (criteria.containsKey("evento")) tuple = tuple.replace("%EVENTO%", " and y.eventoid="+criteria.get("evento"));
			else tuple = tuple.replace("%EVENTO%", ""); //qualunque
			
			
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


	public String getFeedId() { return "allerte-bollettini"; }
	public String getFeedTitle() { return "Allerte e bollettini di vigilanza"; }
	public String getFeedLink() { return "allerte-e-bollettini"; }

}
