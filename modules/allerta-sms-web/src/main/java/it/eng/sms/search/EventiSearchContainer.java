package it.eng.sms.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;

public class EventiSearchContainer extends SearchContainer<Object> {
	
	public static final String	EMPTY_RESULTS_MESSAGE	= "No Record Found";
	public static final int DEFAULT_DELTA = 15;
	static List<String>	headerNames	= new ArrayList<String>();
	
	static {
		headerNames.add("Evento");
		headerNames.add("Tipo Evento");
		headerNames.add("Data/ora generazione");
		headerNames.add("SMS Generati");
		headerNames.add("SMS Spediti");
		headerNames.add("SMS consegnati");
		headerNames.add("% successo");
		headerNames.add("Ultimo aggiornamento");
		headerNames.add("Vai al dettaglio");
	}
	
	@SuppressWarnings("deprecation")
	public EventiSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		
		super(  portletRequest, 
				new EventiDisplayTerms(portletRequest), 
				new EventiDisplayTerms(portletRequest), 
				DEFAULT_CUR_PARAM, 
				DEFAULT_DELTA, 
				iteratorURL,
				headerNames, 
				EMPTY_RESULTS_MESSAGE);
		
		EventiDisplayTerms displayTerms = (EventiDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter("filtro", displayTerms.getFiltro());
		iteratorURL.setParameter("dataInvioDa", displayTerms.getDataInvioDa());
		iteratorURL.setParameter("dataInvioA", displayTerms.getDataInvioA());
	}
}
