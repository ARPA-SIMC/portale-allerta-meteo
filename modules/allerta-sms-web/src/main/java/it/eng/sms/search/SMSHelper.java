package it.eng.sms.search;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import it.eng.allerter.model.SMS;
import it.eng.allerter.service.SMSLocalServiceUtil;

public class SMSHelper {
	
	public static boolean isFilterEmpty( SMSDisplayTerms displayTerms) {
		
		if( 
			Validator.isNull( displayTerms.getTipo()) && 
			Validator.isNull( displayTerms.getSottoTipo()) &&
			Validator.isNull( displayTerms.getNumero()) &&
			Validator.isNull( displayTerms.getDestinatario()) &&
			Validator.isNull( displayTerms.getDataInvioDa()) &&
			Validator.isNull( displayTerms.getDataInvioA()) &&
			(Validator.isNull( displayTerms.getStato()) || displayTerms.getStato() == -1) 
			
				) {
			
			
			return true;
		}
		
		return false;
		
	}
	
	public static List<SMS> getSMS(SMSDisplayTerms displayTerms,int start,int end) 
				throws SystemException {
		
		//if( isFilterEmpty(displayTerms))
		//	return Collections.EMPTY_LIST;
		
		return  getSMSData( displayTerms.getTipo(), 
							displayTerms.getSottoTipo(), 
							displayTerms.getStato(), 
							displayTerms.getNumero(), 
							displayTerms.getDestinatario(), 
							displayTerms.getDataInvioDa(), 
							displayTerms.getDataInvioA(),
							start, end);
	}
	
	public static int getTotalSMSCount(SMSDisplayTerms displayTerms) 
				throws SystemException{
		
		//if( isFilterEmpty(displayTerms))
		//	return 0;
		
		return (int) SMSLocalServiceUtil.searchSMSCount(displayTerms.getTipo(), 
														displayTerms.getSottoTipo(), 
														displayTerms.getStato(), 
														displayTerms.getNumero(), 
														displayTerms.getDestinatario(), 
														displayTerms.getDataInvioDa(), 
														displayTerms.getDataInvioA());
	}
	
	public static List<SMS> getSMSData(
									String tipo, 
									String sottoTipo, 
									long stato, 
									String numero, 
									String destinatario, 
									String dataInvioDa, 
									String dataInvioA,
									int start, int end) throws SystemException {
		
		return SMSLocalServiceUtil.searchSMS(tipo, 
											 sottoTipo, 
											 stato, 
											 numero, 
											 destinatario, 
											 dataInvioDa, 
											 dataInvioA,
											 start,
											 end);
	}

}
