package allerta.search.objects.searchables;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import allerta.search.filter.DateFilter;
import allerta.search.filter.MenuFilter;
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
		
		super();
		
		MenuFilter mf = new MenuFilter("evento", "Evento", 4, "", "", null);
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
		
		 mf = new MenuFilter("zona", "Zona", 2, "", "", null);
		String zn[] = {"A1","A2","B1","B2","C1","C2","D1","D2","E1","E2","F1","F2","F3","G1","G2","H1","H2"};
		mf.addOption("", "");
		for (String z : zn)
			mf.addOption(z, z);
		filters.add(mf);
		
		mf = new MenuFilter("colorePre", "Colore previsto", 3, "", "", null);
		mf.addOption("", "");
		mf.addOption("VERDE", "VERDE");
		mf.addOption("GIALLO", "GIALLO");
		mf.addOption("ARANCIONE", "ARANCIONE");
		mf.addOption("ROSSO", "ROSSO");
		filters.add(mf);
		
		mf = new MenuFilter("colorePost", "Colore osservato", 3, "", "", null);
		mf.addOption("", "");
		mf.addOption("VERDE", "VERDE");
		mf.addOption("GIALLO", "GIALLO");
		mf.addOption("ARANCIONE", "ARANCIONE");
		mf.addOption("ROSSO", "ROSSO");
		filters.add(mf);
		
		mf = new MenuFilter("correttezza", "Correttezza", 2, "", "", null);
		mf.addOption("", "");
		mf.addOption("C", "C");
		mf.addOption("PC", "PC");
		mf.addOption("FA", "FA");
		mf.addOption("MA", "MA");
		filters.add(mf);
		
		mf = new MenuFilter("magnitudo", "Magnitudo", 2, "", "", null);
		mf.addOption("", "");
		mf.addOption("+", "+");
		mf.addOption("++", "++");
		mf.addOption("-", "-");
		mf.addOption("--", "--");
		filters.add(mf);
		
		mf = new MenuFilter("localizzazione", "Localizzazione", 2, "", "", null);
		mf.addOption("", "");
		mf.addOption("+", "+");
		mf.addOption("++", "++");
		mf.addOption("-", "-");
		mf.addOption("--", "--");
		filters.add(mf);
	
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
		
		String subq = "";
		if (criteria.containsKey("zona") && !"".equals(criteria.get("zona"))) {
			subq+=" and v.zona='"+criteria.get("zona")+"' ";
		}
		if (criteria.containsKey("evento") && !"".equals(criteria.get("evento"))) {
			subq+=" and v.evento="+criteria.get("evento")+" ";
		}
		if (criteria.containsKey("correttezza") && !"".equals(criteria.get("correttezza"))) {
			subq+=" and v.correttezza='"+criteria.get("correttezza")+"' ";
		}
		if (criteria.containsKey("magnitudo") && !"".equals(criteria.get("magnitudo"))) {
			subq+=" and v.magnitudo='"+criteria.get("magnitudo")+"' ";
		}
		if (criteria.containsKey("localizzazione") && !"".equals(criteria.get("localizzazione"))) {
			subq+=" and v.localizzazione='"+criteria.get("localizzazione")+"' ";
		}
		if (criteria.containsKey("colorePre") && !"".equals(criteria.get("colorePre"))) {
			subq+=" and v.pre='"+criteria.get("colorePre")+"' ";
		}
		if (criteria.containsKey("colorePost") && !"".equals(criteria.get("colorePost"))) {
			subq+=" and v.post='"+criteria.get("colorePost")+"' ";
		}
		
		if (!"".equals(subq)) {
			out += "and exists (select * from verifica_filtri_vw v where v.giorno>=verifica_settimanale_vw.datainiziovera " + 
					"			and v.giorno<verifica_settimanale_vw.datainiziovera+cast('7 day' as interval) "+subq+" )";
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

