package it.eng.sms.search;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.util.Validator;

import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.sms.bean.EventiBean;

public class EventiHelper {
	
	public static List<EventiBean> getEventi(EventiDisplayTerms displayTerms,int start,int end) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		int num = end - start;
		String q = "select * from sms_invii_vw where 1=1 ";
		
		if ( Validator.isNotNull(displayTerms.getDataInvioDa())) {
			
			try {
				q += " and creazione>='" + sdf.parse(displayTerms.getDataInvioDa()) + "'";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if ( Validator.isNotNull(displayTerms.getDataInvioA())) {
			
			try {
				q += " and creazione<='" + sdf.parse(displayTerms.getDataInvioA()) + "'";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (Validator.isNotNull(displayTerms.getFiltro())) {
			
			String t = "'%" + displayTerms.getFiltro().toUpperCase() + "%'";
			q+=" and(upper(evento) like " + t + " or upper(tipo_evento) like " + t + ")";
		}
		
		q += " limit " + num;
		if (start > 0) q += " offset " + start;
		
		List evts = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(q);
		
		List<EventiBean> eventi = new ArrayList<EventiBean>();
		
		for(Object oo : evts) {
			
			Object[] o = (Object[])oo;
			
			EventiBean evento = new EventiBean();
			
			evento.setId( o[0].toString());
			evento.setEvento( o[1].toString());
			evento.setTipoEvento( o[2].toString());
			evento.setSmsGenerati( o[3].toString());
			evento.setSmsSpediti( o[4].toString());
			evento.setSmsConsegnati( o[5].toString());
			evento.setPercSuccesso(o[6].toString());
			evento.setUltimoAggiornamento( o[7].toString());
			evento.setDataGenerazione( o[8].toString());
			
			eventi.add(evento);
		}
		
		return eventi;
	}
	
	
	public static int getEventiCount(EventiDisplayTerms displayTerms) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		String q = "select count(*) from sms_invii_vw where 1=1 ";
		
		if ( Validator.isNotNull(displayTerms.getDataInvioDa())) {
			
			try {
				q += " and creazione>='" + sdf.parse(displayTerms.getDataInvioDa()) + "'";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if ( Validator.isNotNull(displayTerms.getDataInvioA())) {
			
			try {
				q += " and creazione<='" + sdf.parse(displayTerms.getDataInvioA()) + "'";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (Validator.isNotNull(displayTerms.getFiltro())) {
			
			String t = "'%" + displayTerms.getFiltro().toUpperCase() + "%'";
			q+=" and(upper(evento) like " + t + " or upper(tipo_evento) like " + t + ")";
		}
		
		Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
		
		if ( o== null) 
			return 0;
		
		return Integer.parseInt(o.toString());
	}

}
