package allerta.verifica.web.bean;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import allerta.verifica.model.Verifica;

public class VerificaSearchContainer extends SearchContainer<Verifica> {
	
	public static final String	EMPTY_RESULTS_MESSAGE	= "Nessuna verifica trovata";
	public static final int DEFAULT_DELTA = 10;
	static List<String>	headerNames	= new ArrayList<String>();
	
	static {
		headerNames.add("Documento");
		headerNames.add("Valido da");
		headerNames.add("Stato");
		headerNames.add("Ultima modifica");
		headerNames.add("Utente");
		headerNames.add("Azioni");
	}
	
	@SuppressWarnings("deprecation")
	public VerificaSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		
		super(  portletRequest, 
				new VerificaDisplayTerms(portletRequest), 
				new VerificaDisplayTerms(portletRequest), 
				DEFAULT_CUR_PARAM, 
				DEFAULT_DELTA, 
				iteratorURL,
				headerNames, 
				EMPTY_RESULTS_MESSAGE);
		
		VerificaDisplayTerms displayTerms = (VerificaDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter("dataInvioDa", displayTerms.getDataDa());
		iteratorURL.setParameter("dataInvioA", displayTerms.getDataA());

	}

}
