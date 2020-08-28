package it.eng.sms.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;

import it.eng.allerter.model.Email;

public class EmailSearchContainer extends SearchContainer<Email> {
	
	public static final String	EMPTY_RESULTS_MESSAGE	= "No Record Found";
	public static final int DEFAULT_DELTA = 15;
	static List<String>	headerNames	= new ArrayList<String>();
	
	static {
		headerNames.add("Tipo");
		headerNames.add("Sottotipo");
		headerNames.add("Destinatario");
		headerNames.add("Numero");
		headerNames.add("Testo");
	}
	
	@SuppressWarnings("deprecation")
	public EmailSearchContainer(PortletRequest portletRequest, PortletURL iteratorURL) {
		
		super(  portletRequest, 
				new SMSDisplayTerms(portletRequest), 
				new SMSDisplayTerms(portletRequest), 
				DEFAULT_CUR_PARAM, 
				DEFAULT_DELTA, 
				iteratorURL,
				headerNames, 
				EMPTY_RESULTS_MESSAGE);
		
		SMSDisplayTerms displayTerms = (SMSDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter("tipo", ""+displayTerms.getTipo());
		iteratorURL.setParameter("sottotipo", displayTerms.getSottoTipo());
		iteratorURL.setParameter("numero", displayTerms.getNumero());
		iteratorURL.setParameter("stato", String.valueOf(displayTerms.getStato()));
		iteratorURL.setParameter("dataInvioDa", displayTerms.getDataInvioDa());
		iteratorURL.setParameter("dataInvioA", displayTerms.getDataInvioA());
	}
	

}
