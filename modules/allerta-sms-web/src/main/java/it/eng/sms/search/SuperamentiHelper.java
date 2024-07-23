package it.eng.sms.search;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.eng.allerter.model.SMS;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.sms.bean.Superamenti;

public class SuperamentiHelper {
	
public static boolean isFilterEmpty( SuperamentiDisplayTerms displayTerms) {
		
		if( 
			Validator.isNull( displayTerms.getTipo()) && 
			Validator.isNull( displayTerms.getDataDa()) &&
			Validator.isNull( displayTerms.getDataA()) &&
			Validator.isNull( displayTerms.getComune()) &&
			Validator.isNull( displayTerms.getProvincia()) &&
			Validator.isNull( displayTerms.getBacino()) &&
			Validator.isNull( displayTerms.getZona()) &&
			Validator.isNull( displayTerms.getSoglia())
			
				) {
			
			
			return true;
		}
		
		return false;
		
	}
	
	public static List<Superamenti> getSuperamenti(SuperamentiDisplayTerms displayTerms,int start,int end) 
				throws SystemException {
		
		//if( isFilterEmpty(displayTerms))
		//	return Collections.EMPTY_LIST;
		
		return  getSuperamentiData( displayTerms.getTipo(),  
							displayTerms.getDataDa(), 
							displayTerms.getDataA(),
							displayTerms.getComune(),
							displayTerms.getProvincia(),
							displayTerms.getBacino(),
							displayTerms.getStazione(),
							displayTerms.getZona(),
							displayTerms.getSoglia(),
							start, end);
	}
	
	public static int getTotalSuperamentiCount(SuperamentiDisplayTerms displayTerms) 
				throws SystemException{
		
		//if( isFilterEmpty(displayTerms))
		//	return 0;
		
		try {
			//String x = "select count(*) from elenco_superamenti_vw where 1=1 ";
			String x =  "select count(*) from (select *, to_char(sogliaregola,'FM9999990.09') as sr2 from elenco_superamenti_vw " + 
					"union " + 
					"select null as allarmeid, dataorainizio at time zone 'utc' at time zone 'europe/rome' as createdate, dataorainizio at time zone 'utc' at time zone 'europe/rome' as datafine, null as idregola, " + 
					"0 as colore, idvariabile, soglia, idstazione, nomestazione, 0 as soglia1, " + 
					"null as soglia2, null as soglia3, null as txt, to_char(dataorainizio at time zone 'utc' at time zone 'europe/rome','HH24:MI') as oralocale, 'idro' as tipo, " + 
					"replace(to_char(valore,'FM9999990.09'),'.',',') || ' m' as livello, " + 
					"0 as sogliaregola, to_char(valoresoglia,'FM9999990.09') as sr2 from allerter_logsoglia) " + 
					"v join bollettino_stazione st on st.id_ = v.idstazione  left join comune_translate c on c.nome_db=st.namemunicipality ";
			String where = "where 1=1 ";
			if (displayTerms.getTipo()!=null && !"".equals(displayTerms.getTipo())) where +=" and tipo='"+displayTerms.getTipo()+"'";
			if (displayTerms.getDataDa()!=null && !"".equals(displayTerms.getDataDa())) {
				Date d = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(displayTerms.getDataDa());
				where+=" and createdate>='"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:00").format(d)+"'";
			}
			if (displayTerms.getDataA()!=null && !"".equals(displayTerms.getDataA())) {
				Date d = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(displayTerms.getDataA());
				where+=" and createdate<='"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:00").format(d)+"'";
			}
			if (displayTerms.getComune()!=null && !"".equals(displayTerms.getComune())) {
				where+=" and upper(st.namemunicipality) like '%"+displayTerms.getComune().toUpperCase()+"%' ";
			}
			if (displayTerms.getProvincia()!=null && !"".equals(displayTerms.getProvincia())) {
				where+=" and upper(st.nameprovince) like '%"+displayTerms.getProvincia().toUpperCase()+"%' ";
			}
			if (displayTerms.getBacino()!=null && !"".equals(displayTerms.getBacino())) {
				where+=" and upper(st.namebasin) like '%"+displayTerms.getBacino().toUpperCase()+"%' ";
			}
			if (displayTerms.getStazione()!=null && !"".equals(displayTerms.getStazione())) {
				where+=" and upper(st.name) like '%"+displayTerms.getStazione().toUpperCase()+"%' ";
			}
			if (displayTerms.getZona()!=null && !"".equals(displayTerms.getZona())) {
				where+=" and upper(c.zona) = '"+displayTerms.getZona().toUpperCase()+"' ";
			}
			if (displayTerms.getSoglia()!=null && !"".equals(displayTerms.getSoglia())) {
				where+=" and soglia = "+displayTerms.getSoglia()+" ";
			}
			x+= where;
			
			Object l = BollettinoLocalServiceUtil.eseguiQueryGenerica(x);
		
			return Integer.parseInt(l.toString());
		} catch (Exception e ) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static List<Superamenti> getSuperamentiData(
									String tipo, 
									String dataDa, 
									String dataA,
									String comune,
									String provincia,
									String bacino,
									String stazione,
									String zona,
									String soglia,
									int start, int end) throws SystemException {
		try {
			//String x = "select v.tipo,v.createdate,v.name,v.soglia,v.livello,v.sogliaregola,st.namebasin,st.nameprovince,st.namemunicipality from elenco_superamenti_vw v join bollettino_stazione st on st.id_ = v.idstazione  where 1=1 ";
			
			String x = "select v.tipo,v.createdate,v.name,v.soglia,v.livello,v.sogliaregola,st.namebasin,st.nameprovince,st.namemunicipality,c.zona from (select *, to_char(sogliaregola,'FM9999990.09') as sr2 from elenco_superamenti_vw " + 
					"union " + 
					"select null as allarmeid, dataorainizio at time zone 'utc' at time zone 'europe/rome' as createdate, dataorainizio at time zone 'utc' at time zone 'europe/rome' as datafine, null as idregola, " + 
					"0 as colore, idvariabile, soglia, idstazione, nomestazione, 0 as soglia1, " + 
					"null as soglia2, null as soglia3, null as txt, to_char(dataorainizio at time zone 'utc' at time zone 'europe/rome','HH24:MI') as oralocale, 'idro' as tipo, " + 
					"replace(to_char(valore,'FM9999990.09'),'.',',') || ' m' as livello, " + 
					"valoresoglia as sogliaregola, to_char(valoresoglia,'FM9999990.09') as sr2 from allerter_logsoglia) " + 
					"v join bollettino_stazione st on st.id_ = v.idstazione left join comune_translate c on c.nome_db=st.namemunicipality ";
			String where = "where 1=1 ";
			if (tipo!=null && !"".equals(tipo)) where +=" and tipo='"+tipo+"'";
			if (dataDa!=null && !"".equals(dataDa)) {
				Date d = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataDa);
				where+=" and createdate>='"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:00").format(d)+"'";
			}
			if (dataA!=null && !"".equals(dataA)) {
				Date d = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataA);
				where+=" and createdate<='"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:00").format(d)+"'";
			}
			if (comune!=null && !"".equals(comune)) {
				where+=" and upper(st.namemunicipality) like '%"+comune.toUpperCase()+"%' ";
			}
			if (provincia!=null && !"".equals(provincia)) {
				where+=" and upper(st.nameprovince) like '%"+provincia.toUpperCase()+"%' ";
			}
			if (bacino!=null && !"".equals(bacino)) {
				where+=" and upper(st.namebasin) like '%"+bacino.toUpperCase()+"%' ";
			}
			if (stazione!=null && !"".equals(stazione)) {
				where+=" and upper(st.name) like '%"+stazione.toUpperCase()+"%' ";
			}
			if (zona!=null && !"".equals(zona)) {
				where+=" and upper(c.zona) = '"+zona.toUpperCase()+"' ";
			}
			if (soglia!=null && !"".equals(soglia)) {
				where+=" and soglia = "+soglia+" ";
			}
			x+= where;
			x+= " order by v.createdate desc";
			
			if (start!=-1) x+=" offset "+start;
			if (end!=-1) x+=" limit "+(end-start);
			
			List<Object[]> l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(x);
			
			List<Superamenti> out = new ArrayList<Superamenti>();
			
			for (Object[] o : l) {
				Superamenti ss = new Superamenti();
				out.add(ss);
				ss.setTipo((String)o[0]);
				ss.setCreatedate((Date)o[1]);
				ss.setName((String)o[2]);
				ss.setSoglia((Integer)o[3]);
				ss.setLivello((String)o[4]);
				Double d = (Double)o[5];
				d = Math.round(d*10.0)/10.0;
				ss.setSogliaregola(d);
				ss.setBacino((String)o[6]);
				ss.setProvincia((String)o[7]);
				ss.setComune((String)o[8]);
				ss.setZona((String)o[9]);
			}
			
			return out;
		} catch (Exception e ) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
