package allerta.catasto.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import allerta.catasto.model.Segnalazione;


public class CatastoSearchContainer extends SearchContainer<Segnalazione> {
	
	public static final String	EMPTY_RESULTS_MESSAGE	= "Nessuna segnalazione trovata";
	public static final int DEFAULT_DELTA = 10;
	static List<String>	headerNames	= new ArrayList<String>();
	
	static {
		headerNames.add("ID");
		headerNames.add("Data evento");
		headerNames.add("Comune");
		headerNames.add("Area");
		headerNames.add("Descrizione");
		headerNames.add("Ultima modifica");
		headerNames.add("Azioni");
	}
	
	@SuppressWarnings("deprecation")
	public CatastoSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		
		super(  portletRequest, 
				new CatastoDisplayTerms(portletRequest), 
				new CatastoDisplayTerms(portletRequest), 
				DEFAULT_CUR_PARAM, 
				DEFAULT_DELTA, 
				iteratorURL,
				headerNames, 
				EMPTY_RESULTS_MESSAGE);
		
		CatastoDisplayTerms displayTerms = (CatastoDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter("dataInvioDa", displayTerms.getDataDa());
		iteratorURL.setParameter("dataInvioA", displayTerms.getDataA());

	}

}