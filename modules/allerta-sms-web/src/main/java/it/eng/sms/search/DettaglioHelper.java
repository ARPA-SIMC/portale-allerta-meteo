package it.eng.sms.search;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.util.Validator;

import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.sms.bean.DettaglioBean;

public class DettaglioHelper {
	
	public static List<DettaglioBean> getDettagli( DettaglioDisplayTerm displayTerms, int start,int end) {
		
		end = 10000;
		int num = end - start;
		String q = "select * from (select * from sms_dettaglio_vw where id='" + displayTerms.getId() + "' offset 0) x where 1=1 ";
		
		if( Validator.isNotNull( displayTerms.getFiltro())) {
			
			String f = "'%" + displayTerms.getFiltro().toUpperCase() + "%'";
			
			q += " and(upper(nomedestinatario) like " +
					f +
				 " or upper(numero) like " + 
				 	f +
				 " or upper(nomestato) like "+
				 	f + 
				 ")";
		}
		
		if ( Validator.isNotNull( displayTerms.getFailed()) && displayTerms.getFailed().equals("true")) {
			q += " and not destinatario_ricevuto ";
		}
		
		q += " limit " + num;
		if (start > 0) q += " offset " + start;
		
		List evts = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(q);
		
		List<DettaglioBean> dettagli = new ArrayList<DettaglioBean>();
		
		for(Object oo : evts) {
			
			Object[] o = (Object[])oo;
			
			DettaglioBean dettaglio = new DettaglioBean();
			
			dettaglio.setId( o[0].toString());
			dettaglio.setDestinatario(o[1] != null ? o[1].toString() : "");
			dettaglio.setNumero( o[2] != null ? o[2].toString() : "");
			dettaglio.setStato( o[4].toString());
			dettaglio.setTesto( o[5].toString());
			dettaglio.setDataGenerazione( o[6] != null ? o[6].toString() : "");
			dettaglio.setDataSpedizione( o[7] != null ? o[7].toString() : "");
			dettaglio.setDataRicevuta( o[8] != null ? o[8].toString() : "");
			dettaglio.setSuccessoContatto( o[10].toString());
			dettaglio.setSuccessoDestinatario( o[11].toString());
			dettaglio.setIdDestinatario(Long.parseLong(o[12].toString()));
			
			dettagli.add(dettaglio);
		}
		
		return dettagli;
	}
	
	public static int getDettagliCount(DettaglioDisplayTerm displayTerms) {
		
		String q = "select count(*) from (select * from sms_dettaglio_vw where id='" + displayTerms.getId() + "' offset 0) x where 1=1 ";
		
		if( Validator.isNotNull( displayTerms.getFiltro())) {
			
			String f = "'%" + displayTerms.getFiltro().toUpperCase() + "%'";
			
			q += " and(upper(nomedestinatario) like " +
					f +
				 " or upper(numero) like " + 
				 	f +
				 " or upper(nomestato) like "+
				 	f + 
				 ")";
		}
		
		if ( Validator.isNotNull( displayTerms.getFailed()) && displayTerms.getFailed().equals("true")) {
			q += " and not destinatario_ricevuto ";
		}
		
		Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
		
		if ( o== null) 
			return 0;
		
		return Integer.parseInt(o.toString());
	}

}
