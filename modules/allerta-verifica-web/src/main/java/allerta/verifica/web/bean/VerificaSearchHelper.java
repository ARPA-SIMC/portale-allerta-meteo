package allerta.verifica.web.bean;

import com.liferay.portal.kernel.util.Validator;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import allerta.verifica.model.Verifica;
import allerta.verifica.service.VerificaLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

public class VerificaSearchHelper {
	
	public static List<Verifica> getVerifiche(VerificaDisplayTerms displayTerms,int start,int end) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		/*DynamicQuery dq = VerificaLocalServiceUtil.dynamicQuery();
		try {
			if (Validator.isNotNull(displayTerms.getDataDa()))
				dq = dq.add(PropertyFactoryUtil.forName("dataFine").gt(sdf.parse(displayTerms.getDataDa())));
			if (Validator.isNotNull(displayTerms.getDataA()))
				dq = dq.add(PropertyFactoryUtil.forName("dataInizio").le(sdf.parse(displayTerms.getDataA())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		dq = dq.addOrder(OrderFactoryUtil.desc("dataInizio"));
		//dq.setLimit(start, end);
		//List<Verifica> evts = VerificaLocalServiceUtil.getVerificas(start, end);
		List VerificaLocalServiceUtil.dynamicQuery(dq);*/
		
		List<Verifica> v = new ArrayList<Verifica>();
		
		String que = "select id_,stato from verifica_verifica where 1=1 " + getAdditionalWhereClause(displayTerms)
		+" order by createdate desc limit "+(end-start)+" offset "+start;
		List<Object[]> vers = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(que);
		if (vers!=null) for (Object[] ooo : vers) {
			v.add(VerificaLocalServiceUtil.fetchVerifica(((BigInteger)ooo[0]).longValue()));

		}
		
		return v;

	}
	
	public static String getAdditionalWhereClause(VerificaDisplayTerms displayTerms) {
		// TODO Auto-generated method stub

		String out = "";		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		if ( Validator.isNotNull(displayTerms.getDataDa())) {
			
			try {
				out += " and datafine>'" + sdf.parse(displayTerms.getDataDa()) + "'";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if ( Validator.isNotNull(displayTerms.getDataA())) {
			
			try {
				
				Date d2 = sdf.parse(displayTerms.getDataA());
				d2.setTime(d2.getTime()+23*60*60*1000);

				
				out += " and datainizio<='" + d2 + "'";
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
				String subq = "";
				boolean coloreSpecificato = false;
				
				if (displayTerms.getZona()!=null && !"".equals(displayTerms.getZona())) {
					subq+=" and v.zona='"+displayTerms.getZona()+"' ";
				}
				if (displayTerms.getEvento()!=null && !"".equals(displayTerms.getEvento())) {
					subq+=" and v.evento='"+displayTerms.getEvento()+"' ";
				}
				if (displayTerms.getCorrettezza()!=null && !"".equals(displayTerms.getCorrettezza())) {
					subq+=" and v.correttezza='"+displayTerms.getCorrettezza()+"' ";
				}
				if (displayTerms.getMagnitudo()!=null && !"".equals(displayTerms.getMagnitudo())) {
					subq+=" and v.magnitudo='"+displayTerms.getMagnitudo()+"' ";
				}
				if (displayTerms.getLocalizzazione()!=null && !"".equals(displayTerms.getLocalizzazione())) {
					subq+=" and v.localizzazione='"+displayTerms.getLocalizzazione()+"' ";
				}
				if (displayTerms.getColorePre()!=null && !"".equals(displayTerms.getColorePre())) {
					subq+=" and v.pre='"+displayTerms.getColorePre()+"' ";
					coloreSpecificato = true;
				}
				if (displayTerms.getColorePost()!=null && !"".equals(displayTerms.getColorePost())) {
					subq+=" and v.post='"+displayTerms.getColorePost()+"' ";
					coloreSpecificato = true;
				}
				if (displayTerms.getEvento()!=null && !"".equals(displayTerms.getEvento()) && !coloreSpecificato) {
					subq+=" and (v.pre in ('GIALLO','ARANCIONE','ROSSO') or v.post in ('GIALLO','ARANCIONE','ROSSO')) ";
				}
				
				if (!"".equals(subq)) {
					out += " and exists (select * from verifica_filtri2_vw v where v.documento=verifica_verifica.id_ " + 
							subq+" )";
				}

				return out;
	}
	
	
	public static int getVerificheCount(VerificaDisplayTerms displayTerms) {
		

		
		
		String q = "select count(*) from verifica_verifica where 1=1 ";
		
		
		q+=getAdditionalWhereClause(displayTerms);
		
		Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(q);
		
		if ( o== null) 
			return 0;
		
		return Integer.parseInt(o.toString());
	}

}
