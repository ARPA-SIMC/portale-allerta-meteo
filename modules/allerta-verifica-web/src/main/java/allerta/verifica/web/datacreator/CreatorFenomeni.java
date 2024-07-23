package allerta.verifica.web.datacreator;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import allerta.verifica.model.VerificaDato;
import allerta.verifica.service.VerificaLocalServiceUtil;
import allerta.verifica.web.bean.VerificaAllertaBean;
import allerta.verifica.web.constants.CostantiVerificaAllerte;
import allerta.verifica.web.datacreator.filler.DewetraHRWFiller;
import allerta.verifica.web.datacreator.filler.SuperamentiIdroFiller;
import allerta.verifica.web.datacreator.filler.SuperamentiPluvioFiller;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaStato;

public class CreatorFenomeni implements VerificaDatoCreator {
	
	static Map<String,ColumnFiller> columnFiller;
	static {
		columnFiller = new HashMap<String, ColumnFiller>();
		
		columnFiller.put("soglie_pluvio", new SuperamentiPluvioFiller());
		columnFiller.put("soglie_idro", new SuperamentiIdroFiller());
		columnFiller.put("dewetra", new DewetraHRWFiller());
	}
	
	@Override
	public boolean shouldExecute(Allerta a, List<VerificaDato> datiCorrenti) {
		List<Date> giorni = VerificaAllertaBean.getGiorniAncheParziali(a.getDataInizio(),a.getDataFine());
		if (giorni==null || giorni.size()==0) return false;
		
		return VerificaAllertaBean.filtraDatiUnico(datiCorrenti, giorni.get(0), "A1", 1L, "colore_pre", null)==null;
	}

	@Override
	public List<VerificaDato> execute(Allerta a, List<VerificaDato> datiCorrenti) {
		
		List<Date> giorni = VerificaAllertaBean.getGiorniAncheParziali(a.getDataInizio(),a.getDataFine());
		if (giorni==null || giorni.size()==0) return datiCorrenti;
		
		List<AllertaStato> as = a.getAllertaStato();
		
		for (Date d : giorni) {
			for (long evento=1; evento<=9; evento++) {
				
				datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, "", evento, "correttezza", 1, ""));
				datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, "", evento, "magnitudo", 1, ""));
				datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, "", evento, "localizzazione", 1, ""));
				datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, "", evento, "cause", 1, ""));
				datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, "", evento, "valutazione_descrittiva", 1, ""));
				datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, "", evento, "note_valutazione", 1, ""));
				String[] custom = CostantiVerificaAllerte.EVENTI_COLONNE.get(""+evento);
				
				String zone[] = (evento>=8?CostantiVerificaAllerte.SOTTOZONE_COSTA:CostantiVerificaAllerte.SOTTOZONE);
				for (String z : zone) {
				
					long areaDaCercare = (z.charAt(0)-'A'+1)*10+(z.charAt(1)-'0');
					//allerta a due griglie, l'inizio è con le aree negative
					if (a.getParentId()>0 && d.equals(a.getDataInizio())) areaDaCercare*=-1; //stesso giorno
					
					
					String pre = "";
					for (AllertaStato ass : as) {
						if (ass.getEventoId()==evento && ass.getAreaId()==areaDaCercare)
						{
							if (ass.getStatoId()==0) pre = "VERDE";
							if (ass.getStatoId()==1) pre = "GIALLO";
							if (ass.getStatoId()==2) pre = "ARANCIONE";
							if (ass.getStatoId()==3) pre = "ROSSO";
						}
					}
					
					datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, z, evento, "colore_pre", 1, pre));
					datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, z, evento, "colore_post", 1, " "));
					datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, z, evento, "note", 1, ""));
					
					for (String c : custom) {
						String def = getDefaultValue(a,d,z,evento,c);
						datiCorrenti.add(VerificaLocalServiceUtil.insertVerificaDato(a.getAllertaId(), d, z, evento, c, 1, def));
					}
				}
			}
		}
		
		return datiCorrenti;
	}
	
	public String getDefaultValue(Allerta a, Date g, String z, Long e, String n) {
		if (columnFiller.containsKey(n)) {
			return columnFiller.get(n).getColumnValue(a, g, z, e, n);
		}
		return "";
	}

}
