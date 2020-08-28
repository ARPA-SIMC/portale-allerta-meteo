package it.eng.allertaer.cruscotto.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import it.eng.allerter.model.LogInterno;

public class CruscottoSearchContainer extends SearchContainer<LogInterno>{
	
	public static final String	EMPTY_RESULTS_MESSAGE	= "Nessun messaggio trovato";
	static List<String>	headerNames	= new ArrayList<String>();
	
	static {
		headerNames.add("Timestamp");
		headerNames.add("Tipologia");
		headerNames.add("Risultato");
		headerNames.add("Errore");
		headerNames.add("Utente");
	}
	
	@SuppressWarnings("deprecation")
	public CruscottoSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(  portletRequest, 
				new CruscottoDisplayTerms(portletRequest), 
				new CruscottoDisplayTerms(portletRequest), 
				DEFAULT_CUR_PARAM, 
				DEFAULT_DELTA, 
				iteratorURL,
				headerNames, 
				EMPTY_RESULTS_MESSAGE);
		
		CruscottoDisplayTerms displayTerms = (CruscottoDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter("da", ""+displayTerms.getDa());
		iteratorURL.setParameter("a", ""+displayTerms.getA());

	}

}
