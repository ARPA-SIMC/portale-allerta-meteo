package allerta.verifica.web.datacreator;

import java.util.Date;

import it.eng.allerter.model.Allerta;

public interface ColumnFiller {

	public String getColumnValue(Allerta a, Date d, String z, Long e, String c);
}
