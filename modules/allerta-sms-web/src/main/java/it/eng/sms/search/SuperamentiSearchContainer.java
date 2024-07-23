package it.eng.sms.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import it.eng.sms.bean.Superamenti;

import com.liferay.portal.kernel.dao.search.SearchContainer;


public class SuperamentiSearchContainer extends SearchContainer<Superamenti> {
	
	public static final String	EMPTY_RESULTS_MESSAGE	= "Nessun risultato trovato";
	public static final int DEFAULT_DELTA = 15;
	static List<String>	headerNames	= new ArrayList<String>();
	
	static {
		headerNames.add("Tipo");
		headerNames.add("Data da");
		headerNames.add("Data a");
	}
	
	@SuppressWarnings("deprecation")
	public SuperamentiSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		
		super(  portletRequest, 
				new SuperamentiDisplayTerms(portletRequest), 
				new SuperamentiDisplayTerms(portletRequest), 
				DEFAULT_CUR_PARAM, 
				DEFAULT_DELTA, 
				iteratorURL,
				headerNames, 
				EMPTY_RESULTS_MESSAGE);
		
		SuperamentiDisplayTerms displayTerms = (SuperamentiDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter("tipo", ""+displayTerms.getTipo());
		iteratorURL.setParameter("dataDa", displayTerms.getDataDa());
		iteratorURL.setParameter("dataA", displayTerms.getDataA());
		iteratorURL.setParameter("comune", displayTerms.getComune());
		iteratorURL.setParameter("provincia", displayTerms.getProvincia());
		iteratorURL.setParameter("bacino", displayTerms.getBacino());
		iteratorURL.setParameter("zona", displayTerms.getZona());
		iteratorURL.setParameter("stazione", displayTerms.getStazione());
		iteratorURL.setParameter("soglia", displayTerms.getSoglia());
	}
	
	

}
