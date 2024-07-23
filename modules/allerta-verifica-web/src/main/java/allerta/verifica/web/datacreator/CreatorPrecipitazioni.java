package allerta.verifica.web.datacreator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import allerta.verifica.model.VerificaDato;
import allerta.verifica.service.VerificaLocalServiceUtil;
import allerta.verifica.web.bean.VerificaAllertaBean;
import allerta.verifica.web.constants.CostantiVerificaAllerte;
import it.eng.allerter.model.Allerta;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

public class CreatorPrecipitazioni implements VerificaDatoCreator {

	@Override
	public boolean shouldExecute(Allerta a, List<VerificaDato> datiCorrenti) {
		List<Date> giorni = VerificaAllertaBean.getGiorni(a.getDataInizio(),a.getDataFine());
		if (giorni==null || giorni.size()==0) return false;
		
		for (Date d : giorni) {
			if (VerificaAllertaBean.filtraDatiUnico(datiCorrenti, d, "A", null, "precipitazioni_osservate", null)==null) return true;
		}
		
		return false;
	}

	@Override
	public List<VerificaDato> execute(Allerta a, List<VerificaDato> datiCorrenti) {
		
		List<Date> giorni = VerificaAllertaBean.getGiorni(a.getDataInizio(),a.getDataFine());
		if (giorni==null || giorni.size()==0) return datiCorrenti;
		
		

		
		for (Date d : giorni) {
			
			if (VerificaAllertaBean.filtraDatiUnico(datiCorrenti, d, "A", null, "precipitazioni_osservate", null)!=null)
				continue;
			
			String dat = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(d);
			
			List<Object[]> preci = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(/*"select idmacroarea, "
					+ "max(maxpioggia) as maxpioggia from (select s.idmacroarea,vs.idstazione,sum(value) as maxpioggia "
					+ "from bollettino_valoresensore vs join bollettino_stazione s "
					+ "on s.id_=vs.idstazione where vs.idvariabile = '1,0,3600/1,-,-,-/B13011' " + 
					"and idmacroarea in ('A','B','C','D','E','F','G','H') " + 
					"and cast(vs.datetime as date) = cast('"+dat+"' as date) " + 
					"group by vs.idstazione,s.idmacroarea) x group by idmacroarea"*/
					
					"select idmacroarea, "+
					"coalesce(avg(maxpioggia),0.0) as maxpioggia from (select s.idmacroarea,vs.idstazione,sum(value) as maxpioggia "+
					"from bollettino_valoresensore vs join bollettino_stazione s "+
					"on s.id_=vs.idstazione where vs.idvariabile = '1,0,3600/1,-,-,-/B13011' and vs.value>0.0 "+
					"and idmacroarea in ('A','B','C','D','E','F','G','H') "+
					"and cast(vs.datetime as date) = cast('"+dat+"' as date) "+
					"group by vs.idstazione,s.idmacroarea) x group by idmacroarea "
					
					);
			
			for (String z : CostantiVerificaAllerte.ZONE) {
				String val = CostantiVerificaAllerte.PRECIPITAZIONI[0];
				try {
					if (preci!=null && preci.size()>0) {
						double pioggia = -1;
						for (Object[] o : preci) {
							if (o!=null && o.length>1 && z.equals(o[0].toString()) && o[1]!=null)
								pioggia = Double.parseDouble(o[1].toString());
						}
						if (pioggia>=45.0) val = CostantiVerificaAllerte.PRECIPITAZIONI[5];
						else if (pioggia>=20.0) val = CostantiVerificaAllerte.PRECIPITAZIONI[4];
						else if (pioggia>=5.0) val = CostantiVerificaAllerte.PRECIPITAZIONI[3];
						else if (pioggia>0.2) val = CostantiVerificaAllerte.PRECIPITAZIONI[2];
						else val = CostantiVerificaAllerte.PRECIPITAZIONI[1];
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, z, null, "precipitazioni_osservate", 1, val));
				datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, z, null, "precipitazioni_previste", 1, " "));
				datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, z, null, "precipitazioni_note", 1, ""));
			

			}
			
			
			//calcola fenomeni del giorno
			boolean dueGiorni = a.getParentId()>0;
			boolean negativo = dueGiorni && d.equals(giorni.get(0));
			String query = "select distinct eventoid from (select * from allerter_allertastato a \r\n" + 
					"where allertaid="+a.getAllertaId()+" and areaid"+(negativo?"<":">")+"0 and statoid>0 and statoid<>1000 order by statoid desc) x";
		
			List<Object> ll = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(query);
			String eventi = "";
			String eventiInformali[] = { "piene dei fiumi", "frane e piene dei corsi minori", "temporali", "vento",
					"temperature estreme", "neve", "pioggia che gela", "stato del mare", "mareggiate" };
			if (ll!=null) {
				for (Object o : ll) {
					int e = (o!=null?Integer.parseInt(o.toString()):-1);
					if (e>0) {
						if (!"".equals(eventi)) eventi+=", ";
						eventi+=eventiInformali[e-1].toUpperCase();
					}
				}
			}
			
			datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, null, null, "precipitazioni_fenom", 1, eventi));
		
		}
		
		return datiCorrenti;
	}

}
