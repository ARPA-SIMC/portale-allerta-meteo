package it.eng.allerta.controlpanel.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import it.eng.allerter.model.AllertaParametro;

public class AllertaParametroSearchContainer extends SearchContainer<AllertaParametro> {

	public static final String	EMPTY_RESULTS_MESSAGE	= "Nessun parametro trovato";
	public static final int DEFAULT_DELTA = 200;
	
	static List<String>	headerNames	= new ArrayList<String>();
	
	static {
		headerNames.add("Nome");
		headerNames.add("Valore");
		headerNames.add("Azioni");
	}
	
	@SuppressWarnings("deprecation")
	public AllertaParametroSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(  portletRequest, 
				new AllertaParametroDisplayTerms(portletRequest), 
				new AllertaParametroDisplayTerms(portletRequest), 
				DEFAULT_CUR_PARAM, 
				DEFAULT_DELTA, 
				iteratorURL,
				headerNames, 
				EMPTY_RESULTS_MESSAGE);
		
		
	}
}
