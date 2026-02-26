package it.eng.allerta.controlpanel.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import it.eng.bollettino.model.BollettinoParametro;


public class BollettinoParametroSearchContainer extends SearchContainer<BollettinoParametro> {

	public static final String	EMPTY_RESULTS_MESSAGE	= "Nessun parametro trovato";
	public static final int DEFAULT_DELTA = 200;
	
	static List<String>	headerNames	= new ArrayList<String>();
	
	static {
		headerNames.add("Nome");
		headerNames.add("Valore");
		headerNames.add("Azioni");
	}
	
	@SuppressWarnings("deprecation")
	public BollettinoParametroSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(  portletRequest, 
				new BollettinoParametroDisplayTerms(portletRequest), 
				new BollettinoParametroDisplayTerms(portletRequest), 
				DEFAULT_CUR_PARAM, 
				DEFAULT_DELTA, 
				iteratorURL,
				headerNames, 
				EMPTY_RESULTS_MESSAGE);
		
		
	}
}
