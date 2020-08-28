package it.eng.allertaer.cruscotto.search;

import java.util.Date;
import java.util.List;

import it.eng.allerter.model.LogInterno;
import it.eng.allerter.service.LogInternoLocalServiceUtil;

public class CruscottoHelper {
	
	
	public static List<LogInterno> getLogInterni(CruscottoDisplayTerms terms,int start, int end) {
		return LogInternoLocalServiceUtil.searchLog(terms.getDataDa(),terms.getDataA(),start,end);
	}
	
	public static long getCountLogInterni(CruscottoDisplayTerms terms) {
		return LogInternoLocalServiceUtil.logCount(terms.getDataDa(),terms.getDataA());
	}

}
