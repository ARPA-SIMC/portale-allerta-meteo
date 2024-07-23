package allerta.search.objects.searchables;

import java.util.Map;

import allerta.search.filter.MenuFilter;

public class AllertaBriefingSearchable extends AllertaSearchable {
	
	@Override
	public String getName() {
		return "briefing allerte";
	}
	
	@Override
	public String getFeedId() { return "allerte-briefing"; }
	
	@Override
	public String getFeedTitle() { return "Briefing allerte"; }
	
	@Override
	public String getFeedLink() { return "allerte-briefing"; }
	
	public AllertaBriefingSearchable() {
		super();
		
		MenuFilter mf = new MenuFilter("modifica", "Tipologia modifica", 2, "soloAllerte", "", null);
		mf.addOption("", "");
		mf.addOption("DM", "Descrizione meteo");
		mf.addOption("TT", "Titolo");
		mf.addOption("CC", "Codici colore");
		mf.addOption("DT", "Data inizio/fine");
		
		filters.add(mf);
	}

	@Override
	public String getCriteriaQuery(Map<String, String> criteria) {
		String sup = super.getCriteriaQuery(criteria);
		
		String out = " and x.sintesibriefing is not null and exists(select allertaid from allerter_allertaversione z where z.allertaid=x.allertaid and z.fase=1) ";
		
		if (criteria.get("modifica")!=null) {
			String crit = criteria.get("modifica");
			if ("DM".equals(crit)) {
				String addition = " and x.descrizionemeteo<>(select descrizionemeteo from allerter_allertaversione z where z.allertaid=x.allertaid and z.fase=1) ";
				out = out+addition;
			}
			if ("TT".equals(crit)) {
				String addition = " and x.titolo<>(select titolo from allerter_allertaversione z where z.allertaid=x.allertaid and z.fase=1) ";
				out = out+addition;
			}
			if ("CC".equals(crit)) {
				String addition = " and exists(select a1.allertastatoid from allerter_allertastato a1 left join allerter_allertastatoversione a2 on a1.allertaid=x.allertaid and a2.allertaid=x.allertaid and a2.fase=1 and a1.areaid=a2.areaid and a1.eventoid=a2.eventoid where a1.statoid<>a2.statoid ) ";
				out = out+addition;
			}
			if ("DT".equals(crit)) {
				String addition = " and (x.datainizio<>(select datainizio from allerter_allertaversione z where z.allertaid=x.allertaid and z.fase=1) or x.datafine<>(select datafine from allerter_allertaversione z where z.allertaid=x.allertaid and z.fase=1)) ";
				out = out+addition;
			}
		}
		
		return out+sup;
	}
	
	@Override
	public String getQuerySearch() {
		String sup = super.getQuerySearch();
		sup = sup.replace("link as pdf", "'/o/report/briefing?id=' || x.allertaid as pdf");
		
		
		
		return sup;
	}
}
