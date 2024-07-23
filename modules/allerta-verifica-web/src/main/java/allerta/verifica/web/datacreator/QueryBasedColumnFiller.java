package allerta.verifica.web.datacreator;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.eng.allerter.model.Allerta;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

public class QueryBasedColumnFiller implements ColumnFiller{

	String query = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public QueryBasedColumnFiller(String q) {
		query = q;
	}
	
	@Override
	public String getColumnValue(Allerta a, Date d, String z, Long e, String c) {
		String s = query;
		if (s==null) return "";
		
		s = s.replaceAll("%ALLERTA%", ""+a.getAllertaId());
		s = s.replaceAll("%ZONA%", "'"+z+"'");
		s = s.replaceAll("%EVENTO%", ""+e);
		s = s.replaceAll("%COLONNA%", "'"+c+"'");
		s = s.replaceAll("%GIORNO%", "'"+sdf.format(d)+"'");
		Object out = BollettinoLocalServiceUtil.eseguiQueryGenerica(s);
		return out!=null?out.toString():"";
	}

}
