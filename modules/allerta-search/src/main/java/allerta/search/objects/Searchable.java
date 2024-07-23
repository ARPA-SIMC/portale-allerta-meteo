package allerta.search.objects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import allerta.search.filter.SearchFilter;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

public abstract class Searchable {
	
	protected List<SearchFilter> filters = new ArrayList<SearchFilter>();
	
	public abstract String getName();
	
	public List<SearchResult> search(Map<String, String> criteria) {
		String q = getQuerySearch();
		
		q = q.replaceAll("_CRITERIA_", getCriteriaQuery(criteria));
		
		if (criteria.containsKey("limit")) {
			q = q+" limit "+criteria.get("limit");
		}
		
		List l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(q);
		
		if (l==null) return new ArrayList<SearchResult>();
		
		ArrayList<SearchResult> cr = new ArrayList<SearchResult>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		for (Object o : l) {
			Object[] o2 = (Object[]) o;
			SearchResult res = new SearchResult();
			if (o2[0]!=null) res.title = o2[0].toString();
			if (o2[1]!=null) res.subtitle = o2[1].toString();
			if (o2[2]!=null) res.link = o2[2].toString();
			if (o2[3]!=null) res.date = o2[3].toString();
			if (o2[4]!=null) res.dateForArchival = o2[4].toString();
			if (o2[5]!=null) res.classes = o2[5].toString();
			if (o2[6]!=null) res.pdf = o2[6].toString();
			cr.add(res);
		}
		
		return cr;
	}
	
	public List<FeedResult> feed(Map<String, String> criteria) {
		String q = getQueryFeed();
		
		q = q.replaceAll("_CRITERIA_", getCriteriaQuery(criteria));
		
		if (criteria.containsKey("limit")) {
			q = q+" limit "+criteria.get("limit");
		}
		
		List l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(q);
		
		if (l==null) return new ArrayList<FeedResult>();
		
		ArrayList<FeedResult> cr = new ArrayList<FeedResult>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		
		for (Object o : l) {
			Object[] o2 = (Object[]) o;
			FeedResult res = new FeedResult();
			if (o2[0]!=null) res.title = o2[0].toString();
			if (o2[1]!=null) res.link = o2[1].toString();
			if (o2[2]!=null) res.id = o2[2].toString();
			if (o2[3]!=null) {
				Date upd = (Date)o2[3];
				String dat = sdf.format(upd)+"T"+sdf2.format(upd)+"Z";
				res.updated = dat;
			}
			
			
			if (o2[4]!=null) res.summary = o2[4].toString();

			cr.add(res);
		}
		
		return cr;
	}
	
	//public abstract int count(Integer year, Integer month, Map<String, Object> criteria);
	
	public List<CountResult> countByYear(Map<String, String> criteria) {
		String q = getQueryCountByYear();
		
		q = q.replaceAll("_CRITERIA_", getCriteriaQuery(criteria));
		
		List l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(q);
		
		if (l==null) return new ArrayList<CountResult>();
		
		ArrayList<CountResult> cr = new ArrayList<CountResult>();
		
		for (Object o : l) {
			Object[] o2 = (Object[]) o;
			CountResult res = new CountResult();
			
			res.periodo = o2[0].toString();
			if (res.periodo.endsWith(".0")) res.periodo = res.periodo.substring(0, res.periodo.length()-2);
			
			res.count = (int)Double.parseDouble(o2[1].toString());
			cr.add(res);
		}
		
		return cr;
	}
	
	
	public List<CountResult> countByMonth(Map<String, String> criteria) {
		String q = getQueryCountByMonth();
		
		q = q.replaceAll("_CRITERIA_", getCriteriaQuery(criteria));
		
		List l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(q);
		
		if (l==null) return new ArrayList<CountResult>();
		
		ArrayList<CountResult> cr = new ArrayList<CountResult>();
		
		for (Object o : l) {
			Object[] o2 = (Object[]) o;
			CountResult res = new CountResult();
			res.periodo = o2[0].toString();
			if (res.periodo.endsWith(".0")) res.periodo = res.periodo.substring(0, res.periodo.length()-2);
			res.periodoVisualizzato = translateMonth(res.periodo);
			res.count = (int)Double.parseDouble(o2[1].toString());
			cr.add(res);
		}
		
		return cr;
	}
	
	public String getMonthEquivalent() {
		return "mese";
	}
	
	public String translateMonth(String month) {
		if ("1".equals(month)) return "Gennaio";
		if ("2".equals(month)) return "Febbraio";
		if ("3".equals(month)) return "Marzo";
		if ("4".equals(month)) return "Aprile";
		if ("5".equals(month)) return "Maggio";
		if ("6".equals(month)) return "Giugno";
		if ("7".equals(month)) return "Luglio";
		if ("8".equals(month)) return "Agosto";
		if ("9".equals(month)) return "Settembre";
		if ("10".equals(month)) return "Ottobre";
		if ("11".equals(month)) return "Novembre";
		if ("12".equals(month)) return "Dicembre";
		return month;
	}
	
	public String render(SearchResult sr) {
		
		String dateString = (sr.date!=null?new SimpleDateFormat("dd MMM yyyy", Locale.ITALIAN).format(sr.date):"");
		
		return "<div class=\"card card--item  \" style=\"margin-bottom:-2.5rem\">"+
				"<a data-senna-off=\"true\" href=\""+sr.link+"\" title=\"Vai alla pagina identificata da questo elemento\">"+
				"<div class=\"card-header\">" + 
				"<div class=\"card__thumbnail\">"+
				"<span class=\""+sr.classes+"\"></span>"+
				"</div></div></a><div class=\"card-body\">"+
				"<div class=\"card__heading\">" + 
				"<h3 class=\"card__title\">" + 
				"<a data-senna-off=\"true\" href=\""+sr.link+"\" title=\"Vai alla pagina identificata da questo elemento\">"+sr.title + 
				"</a>" + 
				"<div class=\"row card__data\">" + 
				"<div class=\"col-12 col-xl-12 card__data__item\">" + 
				"<span class=\"icon i-clock-o card__data__icon\" title=\"Emanato il\"></span>" + 
				"<span class=\"card__data__value\"> "+dateString+
				"</span></div></div></h3></div></div></a></div>";
	}
	
	public abstract String getQueryCountByYear();
	public abstract String getQueryCountByMonth();
	public abstract String getQuerySearch();
	public abstract String getQueryFeed();
	public abstract String getCriteriaQuery(Map<String, String> criteria);
	
	public String getFeedId() { return ""; }
	public String getFeedTitle() { return ""; }
	public String getFeedAuthor() { return "Regione Emilia-Romagna"; }
	public String getFeedLink() { return ""; }
	
	public boolean shouldRenderFilters() {
		return filters!=null && filters.size()>0;
	}
	
	public String renderFilters() {
		StringBuilder sb = new StringBuilder();
		int colonne = 0;
		boolean aperto = false;
		//boolean prima = true;
		
		for (SearchFilter sf : filters) {
			int nextColonne = sf.getWidth();

			if (!aperto) {
				//if (!prima) sb.append("</div>"); else prima=false;
				sb.append("<div class=\"row\">");
				aperto=true;
			}
			sb.append("<div class=\"form-group col-"+nextColonne+"\">");
			sb.append(sf.render());
			sb.append("</div>");
			colonne+=nextColonne;
			if (colonne>=12) {
				sb.append("</div>");
				colonne=0;
				aperto=false;
			}
		}
		
		if (aperto) sb.append("</div>");
		//sb.append("</div>");
		
		return sb.toString();
	}
	
	public String getFilterIds() {
		String out = null;
		for (SearchFilter sf : filters) {
			if (out!=null) out += ","; else out = "";
			out += "\""+sf.getName()+"\"";
		}
		return (out!=null?out:"");
		
	}

}
