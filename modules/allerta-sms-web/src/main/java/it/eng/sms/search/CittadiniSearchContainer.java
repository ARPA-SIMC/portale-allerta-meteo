package it.eng.sms.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import it.eng.sms.bean.Cittadini;

public class CittadiniSearchContainer extends SearchContainer<Cittadini> {
	
	public static final String	EMPTY_RESULTS_MESSAGE	= "Nessun cittadino trovato";
	public static final int DEFAULT_DELTA = 15;
	static List<String>	headerNames	= new ArrayList<String>();
	
	static {
		headerNames.add("Comune");
		headerNames.add("Cognome");
		headerNames.add("Nome");
		headerNames.add("Email");
		headerNames.add("Telefoni");
	}
	
	@SuppressWarnings("deprecation")
	public CittadiniSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		
		super(  portletRequest, 
				new CittadiniDisplayTerms(portletRequest), 
				new CittadiniDisplayTerms(portletRequest), 
				DEFAULT_CUR_PARAM, 
				DEFAULT_DELTA, 
				iteratorURL,
				headerNames, 
				EMPTY_RESULTS_MESSAGE);
		
		CittadiniDisplayTerms terms = (CittadiniDisplayTerms)getDisplayTerms();
		iteratorURL.setParameter("comune", terms.getComune());
		iteratorURL.setParameter("cognome", terms.getCognome());
		iteratorURL.setParameter("nome", terms.getNome());
		iteratorURL.setParameter("email", terms.getEmail());
		iteratorURL.setParameter("tel", terms.getTel());
	}

}
