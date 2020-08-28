package it.eng.sms.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;

public class DettaglioSearchContainer extends SearchContainer<Object> {
	
	public static final String	EMPTY_RESULTS_MESSAGE	= "Nessun SMS trovato";
	public static final int DEFAULT_DELTA = 5000;
	static List<String>	headerNames	= new ArrayList<String>();
	
	static {
		headerNames.add("ID Destinatario");
		headerNames.add("Destinatario");
		headerNames.add("Numero");
		headerNames.add("Stato");
		headerNames.add("Testo");
		headerNames.add("Data/ora generazione");
		headerNames.add("Data/ora spedito al gestore");
		headerNames.add("Data/ora arrivo ricevuta");
		headerNames.add("Successo per singolo contatto");
		headerNames.add("Successo per destinatario");
	}
	
	public DettaglioSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		
		super(  portletRequest, 
				new DettaglioDisplayTerm(portletRequest), 
				new DettaglioDisplayTerm(portletRequest), 
				DEFAULT_CUR_PARAM, 
				DEFAULT_DELTA, 
				iteratorURL,
				headerNames, 
				EMPTY_RESULTS_MESSAGE);
		
		DettaglioDisplayTerm displayTerms = (DettaglioDisplayTerm) getDisplayTerms();
		iteratorURL.setParameter("id", displayTerms.getId());
		iteratorURL.setParameter("filtro", displayTerms.getFiltro());
		iteratorURL.setParameter("failed", displayTerms.getFailed());
	}
	

}
