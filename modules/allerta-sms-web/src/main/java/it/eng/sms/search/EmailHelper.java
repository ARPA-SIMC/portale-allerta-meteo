package it.eng.sms.search;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import it.eng.allerter.model.Email;
import it.eng.allerter.service.SMSLocalServiceUtil;

public class EmailHelper {
	
	public static List<Email> getEmail(SMSDisplayTerms displayTerms, int start, int end) 
			throws SystemException {
	
		return SMSLocalServiceUtil.searchEmail(
									displayTerms.getTipo(), 
									displayTerms.getSottoTipo(), 
									displayTerms.getDestinatario(), 
									displayTerms.getDataInvioDa(),
									displayTerms.getDataInvioA(),
									start, 
									end);
	}
	
	public static int getTotalEmailCount(SMSDisplayTerms displayTerms) 
			throws SystemException{
	
		return 
				(int) SMSLocalServiceUtil.searchEmailCount(displayTerms.getTipo(), 
														  displayTerms.getSottoTipo(), 
														  displayTerms.getDestinatario(), 
														  displayTerms.getDataInvioDa(),
														  displayTerms.getDataInvioA());
	}

}
