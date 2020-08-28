package it.eng.Allarme.workflow;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.bollettino.model.Allarme;
import it.eng.bollettino.model.AttivazioneFiume;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.model.Idrometro;
import it.eng.bollettino.model.Pluviometro;
import it.eng.bollettino.model.RegolaAllarme;
import it.eng.bollettino.model.RegolaAllarmeComune;
import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.service.AllarmeLocalServiceUtil;
import it.eng.bollettino.service.AttivazioneFiumeLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;
import it.eng.bollettino.service.IdrometroLocalServiceUtil;
import it.eng.bollettino.service.PluviometroLocalServiceUtil;
import it.eng.bollettino.service.RegolaAllarmeComuneLocalServiceUtil;
import it.eng.bollettino.service.RegolaAllarmeCondizioneLocalServiceUtil;
import it.eng.bollettino.service.RegolaAllarmeLocalServiceUtil;
import it.eng.bollettino.service.StazioneLocalServiceUtil;
import it.eng.bollettino.service.StazioneVariabileLocalServiceUtil;

@Component(
		immediate = true, 
		service = WorkflowHandler.class
		)
public class AllarmeWorkflowHandler extends BaseWorkflowHandler<Allarme>  {
	
	public static final String CLASS_NAME = Allarme.class.getName();
	
	public static AssetCategory pubblicato;
	public static AssetCategory lavorazione;
	public static AssetCategory presentato;
	
	public static long CANALE_EMAIL = 1;
	public static long CANALE_SMS = 3;
	
	public static long SINDACO_ROLE = 29574; 

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType(Locale locale) {
		return "Allarme";
	}

	@Override
	public Allarme updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
		
		System.out.println("Allarme WORKFLOW "+status);
    	
        long userId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
        Allarme feedback = AllarmeLocalServiceUtil.getAllarme(resourcePrimKey);
        
        if (status == WorkflowConstants.STATUS_APPROVED && feedback.getStato()== WorkflowConstants.STATUS_APPROVED && feedback.getDataApprovazione()!=null) {
        	//LogInternoLocalServiceUtil.log("allarmeWorkflowHandler", "updateStatus", "Gia' approvato",null);
        	return feedback;
        }
        
    	RegolaAllarme ra = RegolaAllarmeLocalServiceUtil.fetchRegolaAllarme(feedback.getIdRegola());
        
        
        if (status == WorkflowConstants.STATUS_DRAFT) {
        	//if (lavorazione==null) caricaPubblicatoTag();
        	//if (lavorazione!=null) AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(AssetEntryLocalServiceUtil.getEntry(Allarme.class.getName(), feedback.getAllarmeId()).getEntryId(), lavorazione);
            AssetEntryLocalServiceUtil.updateVisible(Allarme.class.getName(), resourcePrimKey, true);
            IndexerRegistryUtil.nullSafeGetIndexer(Allarme.class).reindex(feedback);
        } 
        
        //if (feedback.getStato()==status) return feedback;
        	
        //feedback.setStato(status);
        //feedback=AllarmeLocalServiceUtil.updateAllarme(feedback);
        if (status == WorkflowConstants.STATUS_APPROVED || status == WorkflowConstants.STATUS_DENIED) {
        	feedback.setStato(status);
        	feedback.setDataApprovazione(new Date());
        	feedback.setIdApprovatore(userId);
        	feedback=AllarmeLocalServiceUtil.updateAllarme(feedback);
        	//if (pubblicato==null) caricaPubblicatoTag();
        	//if (pubblicato!=null) {
        		//AssetCategoryLocalServiceUtil.clearAssetEntryAssetCategories(AssetEntryLocalServiceUtil.getEntry(Allarme.class.getName(), feedback.getAllarmeId()).getEntryId());
        		//AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(AssetEntryLocalServiceUtil.getEntry(Allarme.class.getName(), feedback.getAllarmeId()).getEntryId(), pubblicato);
        	//}
            AssetEntryLocalServiceUtil.updateVisible(Allarme.class.getName(),
                    resourcePrimKey, true);
            IndexerRegistryUtil.nullSafeGetIndexer(Allarme.class).reindex(feedback);
        } 
        
        //mandiamo mail/sms solo per allarmi arancioni o rossi
        if (status == WorkflowConstants.STATUS_APPROVED) {
        	
        	
        	String fromSMS = "33312345678";
            try {
				BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("SMS_FROM_ALLARME");
				if (bp!=null) fromSMS = bp.getValore();
				
			} catch (Exception e) {}
        	
        	sendSMS(feedback,ra,fromSMS);
        	
        	//sendMail(feedback);
        }
        
        if (status == WorkflowConstants.STATUS_PENDING) {

        	//if (presentato==null) caricaPubblicatoTag();
        	//if (presentato!=null) {
        		//AssetCategoryLocalServiceUtil.clearAssetEntryAssetCategories(AssetEntryLocalServiceUtil.getEntry(Allarme.class.getName(), feedback.getAllarmeId()).getEntryId());
        		//AssetCategoryLocalServiceUtil.addAssetEntryAssetCategory(AssetEntryLocalServiceUtil.getEntry(Allarme.class.getName(), feedback.getAllarmeId()).getEntryId(), presentato);
        	//}
            AssetEntryLocalServiceUtil.updateVisible(Allarme.class.getName(), resourcePrimKey, true);
            IndexerRegistryUtil.nullSafeGetIndexer(Allarme.class).reindex(feedback);
        } 
        return feedback;
	}
	
	 public void sendSMS(Allarme a, RegolaAllarme ra, String from) {
	    	
    	try {
    		
    		String ff = "superamenti@allertameteoer.it";
			
			try {
				BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("EMAIL_FROM_ALLARME");
				if (bp!=null) ff = bp.getValore();
				
			} catch (Exception e) {}
			
			boolean nuovaRubrica = SMSLocalServiceUtil.isNuovaRubricaAttiva();
    		
    		/*trova sindaci
    		 *Spostato nella local
    		DynamicQuery dyn = DynamicQueryFactoryUtil.forClass(RegolaAllarmeComune.class).add(PropertyFactoryUtil.forName("idRegola").eq(ra.getId()));
			List<RegolaAllarmeComune> comuni = RegolaAllarmeComuneLocalServiceUtil.dynamicQuery(dyn);
			*/
			List<RegolaAllarmeComune> comuni = RegolaAllarmeComuneLocalServiceUtil.getAllarmeCondizione(ra.getId());
    		
    		String descNormale = "";
    		String descNonTecnica = "";
    		String emailNormale = "";
    		String emailNonTecnica = "";
    		//if (ra!=null) desc = ra.getDescrizione();
    		//if (desc!=null && desc.length()>160) desc = desc.substring(0, 160);
    	
    		/*for (RegolaAllarmeComune rr : comuni) {
    			int sent = SMSLocalServiceUtil.creaSMSGroupRole(from, desc, "allarme", ""+rr.getIdComune(), a.getAllarmeId(), rr.getIdComune(), SINDACO_ROLE);
    			System.out.println("Creati "+sent+" SMS sindaco "+rr.getIdComune());
    		}*/
    		
    		/*i destinatari di fiume/bacino li creiamo qui
    		 * Spostato nella local
    		dyn = DynamicQueryFactoryUtil.forClass(RegolaAllarmeCondizione.class).add(PropertyFactoryUtil.forName("idRegola").eq(ra.getId()));
			List<RegolaAllarmeCondizione> rac = RegolaAllarmeCondizioneLocalServiceUtil.dynamicQuery(dyn);
			*/
			List<RegolaAllarmeCondizione> rac = RegolaAllarmeCondizioneLocalServiceUtil.getAllarmeCondizione(ra.getId());
			
			int soglia = a.getColore();
				
				
			if (rac!=null && rac.size()>0) {
				
				//RegolaAllarmeCondizione r = rac.get(0);
				RegolaAllarmeCondizione r = rac.get(0);
				for (RegolaAllarmeCondizione r2 : rac)
					if (r2.getId()<r.getId()) r = r2;
				
				String var = r.getIdVariabile();
				boolean pioggia = var.contains("B13011");
				String staz = r.getIdStazione();
				
				Stazione s = StazioneLocalServiceUtil.fetchStazione(staz);
				String id = s.getId();
				
				double valSoglia = 0.0;
				
				//troviamo il valore
				try {
					
					/*Spostato in Local
					dyn = DynamicQueryFactoryUtil.forClass(StazioneVariabile.class).add(PropertyFactoryUtil.forName("idStazione").eq(staz)).add(PropertyFactoryUtil.forName("idVariabile").eq(var));
					List<StazioneVariabile> lsv = StazioneVariabileLocalServiceUtil.dynamicQuery(dyn);
					*/
					List<StazioneVariabile> lsv = StazioneVariabileLocalServiceUtil.getStazioneVariabile(staz, var);
					
					StazioneVariabile sv = (lsv!=null && lsv.size()>0? lsv.get(0):null);
					
					if (sv!=null) {
						if (soglia==1) valSoglia = sv.getSoglia1();
						if (soglia==2) valSoglia = sv.getSoglia2();
						if (soglia==3) valSoglia = sv.getSoglia3();
					}
				} catch (Exception e) {
					
				}
					
				//Organization o = OrganizationLocalServiceUtil.fetchOrganization(20154, "Rubrica Sensori"); 
				
				if (s != null && pioggia) {
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
					sdf.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
					sdf2.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
					
					double valor = 0.0;
					if (soglia == 1) {
						double mezzora = BollettinoLocalServiceUtil.getSommaValori(s.getId(), "1,0,1800/1,-,-,-/B13011", 2);
						double ora = BollettinoLocalServiceUtil.getSommaValori(s.getId(), "1,0,3600/1,-,-,-/B13011", 1);
						if (mezzora > ora)
							valor = mezzora;
						else
							valor = ora;
					} else if (soglia == 2) {
						double mezzora = BollettinoLocalServiceUtil.getSommaValori(s.getId(), "1,0,1800/1,-,-,-/B13011", 6);
						double ora = BollettinoLocalServiceUtil.getSommaValori(s.getId(), "1,0,3600/1,-,-,-/B13011", 3);
						if (mezzora > ora)
							valor = mezzora;
						else
							valor = ora;
					} else {
						double mezzora = BollettinoLocalServiceUtil.getSommaValori(s.getId(), "1,0,1800/1,-,-,-/B13011", 24);
						double ora = BollettinoLocalServiceUtil.getSommaValori(s.getId(), "1,0,3600/1,-,-,-/B13011", 12);
						if (mezzora > ora)
							valor = mezzora;
						else
							valor = ora;
					} 
					String cumulata = "";
					
					try {
						cumulata = String.format("%.1f", valor);
						cumulata = cumulata.replace(".", ",");
					} catch (Exception e) {}
					
					descNormale = "Pluviometro %NOME%: superamento soglia %SOGLIA% in data %DATA%";
					
					try {
						BollettinoParametro bb = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("SMS_TESTO_ALLARME_PLUVIOMETRO");
						if (bb!=null && bb.getValore()!=null) descNormale = bb.getValore();
					} catch (Exception e) {}
					
					try {
						BollettinoParametro bb = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("EMAIL_TESTO_ALLARME_PLUVIOMETRO");
						if (bb!=null && bb.getValore()!=null) emailNormale = bb.getValore();
					} catch (Exception e) {}
					
					String sog = "";
					int vsg = (int)valSoglia;
					if (soglia==1) sog = "30mm/ora";
					if (soglia==2) sog = "70mm/3ore";
					if (soglia==3) sog = vsg+"mm/12ore";
					
					descNormale = descNormale.replace("%NOME%", s.getName());
					descNormale = descNormale.replace("%SOGLIA%", sog);
					descNormale = descNormale.replace("%DATA%", sdf.format(a.getCreateDate()));
					descNormale = descNormale.replace("%ORA%", sdf2.format(a.getCreateDate()));
					descNormale = descNormale.replace("%PROVINCIA%", getProvincia(s));
					descNormale = descNormale.replace("%CUMULATA%", cumulata);
					
					emailNormale = emailNormale.replace("%NOME%", s.getName());
					emailNormale = emailNormale.replace("%SOGLIA%", sog);
					emailNormale = emailNormale.replace("%DATA%", sdf.format(a.getCreateDate()));
					emailNormale = emailNormale.replace("%ORA%", sdf2.format(a.getCreateDate()));
					emailNormale = emailNormale.replace("%PROVINCIA%", getProvincia(s));
					emailNormale = emailNormale.replace("%CUMULATA%", cumulata);
					//descNormale = "Pluviometro " + s.getName() +": superamento soglia " + soglia +" in data "+sdf.format(a.getCreateDate());
					
						
					Pluviometro p = PluviometroLocalServiceUtil.fetchPluviometro(id);
					if (p!=null) {
						if (nuovaRubrica) {
							SMSLocalServiceUtil.creaNotificaGruppoRubrica(null, from, descNormale, "superamento", p.getNomeRubrica(), a.getAllarmeId(), 20181, p.getNomeRubrica(), true, null);

						} else {
							Organization o = OrganizationLocalServiceUtil.fetchOrganization(20154, p.getNomeRubrica());
							if (o!=null) {
								SMSLocalServiceUtil.creaSMSOrganization(from, descNormale, "superamento", p.getNomeRubrica(), a.getAllarmeId(), o.getOrganizationId());
							}
						}
					}
						
					//pluviometri sempre
					if (nuovaRubrica) {
						List<String> regole = new ArrayList<String>();
						regole.add("@PLUVIOMETRI.*@->false"); 
						SMSLocalServiceUtil.creaNotificaGruppoRubrica(null, from, descNormale, "superamento", p.getNomeRubrica(), a.getAllarmeId(), 20181, "Pluviometri", true, regole);

					} else {
						Organization o = OrganizationLocalServiceUtil.fetchOrganization(20154, "Pluviometri");
						if (o!=null) {
							List<String> ls = new ArrayList<String>();
							ls.add("§§§§xxx"); 
							SMSLocalServiceUtil.creaSMSOrganization(from, descNormale, "superamento", p.getNomeRubrica(), a.getAllarmeId(), o.getOrganizationId(),0,ls);
						}
					}
					
		    		SMSLocalServiceUtil.inviaSMS("superamento", null, a.getAllarmeId());
	    			SMSLocalServiceUtil.inviaEmail("superamento", null, a.getAllarmeId(), "ALLERTAER - Superata soglia "+sog+" nel pluviometro "+s.getName()+" ("+getProvincia(s)+")", emailNormale, ff);    		

					
					//gerarchia.add("Pluviometri");
					//gerarchia.add("PLUVIOMETRI "+s.getNameProvince());
					//gerarchia.add("PLUVIOMETRO "+s.getName().toUpperCase());
				}
					
				if (s != null && !pioggia) {
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
					sdf.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
					sdf2.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
					
					Object liv = BollettinoLocalServiceUtil.eseguiQueryGenerica("select value from bollettino_valoresensore where idstazione='"+
					s.getId()+"' and idvariabile='254,0,0/1,-,-,-/B13215' order by datetime desc limit 1");
					String livell = "";
					if (liv!=null) {
						livell = liv.toString();
						livell = livell.replace(".", ",");
					}
					
					descNormale = "Idrometro %NOME% sul bacino %BACINO%: superamento soglia %SOGLIA% in data %DATA%";
					descNonTecnica = "Verificato un superamento di soglia idrometrica sul bacino %BACINO% in data %DATA%";
					emailNormale = "Idrometro %NOME% sul bacino %BACINO%: superamento soglia %SOGLIA% in data %DATA%";
					emailNonTecnica = "Verificato un superamento di soglia idrometrica sul bacino %BACINO% in data %DATA%";
					
					try {
						BollettinoParametro bb = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("SMS_TESTO_ALLARME_IDROMETRO");
						if (bb!=null && bb.getValore()!=null) descNormale = bb.getValore();
						bb = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("SMS_TESTO_ALLARME_IDROMETRO_NT");
						if (bb!=null && bb.getValore()!=null) descNonTecnica = bb.getValore();
						if (soglia==3) {
							bb = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("SMS_TESTO_ALLARME_IDROMETRO_NT_3");
							if (bb!=null && bb.getValore()!=null) descNonTecnica = bb.getValore();
						}
					} catch (Exception e) {}
					
					try {
						BollettinoParametro bb = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("EMAIL_TESTO_ALLARME_IDROMETRO");
						if (bb!=null && bb.getValore()!=null) emailNormale = bb.getValore();
						bb = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("EMAIL_TESTO_ALLARME_IDROMETRO_NT");
						if (bb!=null && bb.getValore()!=null) emailNonTecnica = bb.getValore();
						if (soglia==3) {
							bb = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("EMAIL_TESTO_ALLARME_IDROMETRO_NT_3");
							if (bb!=null && bb.getValore()!=null) emailNonTecnica = bb.getValore();
						}
					} catch (Exception e) {}
					
					Idrometro idro = IdrometroLocalServiceUtil.fetchIdrometro(id);
					String bac = (idro!=null?idro.getNomeBacino():s.getNameBasin());
					
					descNormale = descNormale.replace("%NOME%", s.getName());
					descNormale = descNormale.replace("%BACINO%", bac);
					descNormale = descNormale.replace("%SOGLIA%", ""+soglia);
					descNormale = descNormale.replace("%DATA%", sdf.format(a.getCreateDate()));
					descNormale = descNormale.replace("%ORA%", sdf2.format(a.getCreateDate()));
					descNormale = descNormale.replace("%PROVINCIA%", getProvincia(s));
					descNormale = descNormale.replace("%LIVELLO%", livell);
				
					descNonTecnica = descNonTecnica.replace("%NOME%", s.getName());
					descNonTecnica = descNonTecnica.replace("%BACINO%", bac);
					descNonTecnica = descNonTecnica.replace("%SOGLIA%", ""+soglia);
					descNonTecnica = descNonTecnica.replace("%DATA%", sdf.format(a.getCreateDate()));
					descNonTecnica = descNonTecnica.replace("%ORA%", sdf2.format(a.getCreateDate()));
					descNonTecnica = descNonTecnica.replace("%PROVINCIA%", getProvincia(s));
					descNonTecnica = descNonTecnica.replace("%LIVELLO%", livell);
					
					emailNormale = emailNormale.replace("%NOME%", s.getName());
					emailNormale = emailNormale.replace("%BACINO%", bac);
					emailNormale = emailNormale.replace("%SOGLIA%", ""+soglia);
					emailNormale = emailNormale.replace("%DATA%", sdf.format(a.getCreateDate()));
					emailNormale = emailNormale.replace("%ORA%", sdf2.format(a.getCreateDate()));
					emailNormale = emailNormale.replace("%PROVINCIA%", getProvincia(s));
					emailNormale = emailNormale.replace("%LIVELLO%", livell);
				
					emailNonTecnica = emailNonTecnica.replace("%NOME%", s.getName());
					emailNonTecnica = emailNonTecnica.replace("%BACINO%", bac);
					emailNonTecnica = emailNonTecnica.replace("%SOGLIA%", ""+soglia);
					emailNonTecnica = emailNonTecnica.replace("%DATA%", sdf.format(a.getCreateDate()));
					emailNonTecnica = emailNonTecnica.replace("%ORA%", sdf2.format(a.getCreateDate()));
					emailNonTecnica = emailNonTecnica.replace("%PROVINCIA%", getProvincia(s));
					emailNonTecnica = emailNonTecnica.replace("%LIVELLO%", livell);
					
					//descNormale = "Idrometro " + s.getName() +" sul bacino "+s.getNameBasin()+": superamento soglia " + soglia +" in data "+sdf.format(a.getCreateDate());
					//descNonTecnica = "Si e' verificato un superamento di soglia idrometrica sul bacino "+s.getNameBasin()+" in data "+sdf.format(a.getCreateDate());
					
					if (idro!=null) {
						
						String bacino = idro.getNomeBacino();
						String sottobacino = idro.getNomeSottobacino();
						String rubrica = idro.getNomeRubrica();
						String bacinoTutti = bacino+"-TT";
						String bacinoPrimo = bacino+"-NT";
						//String sottobacinoTutti = sottobacino+"-TT";
						//String sottobacinoPrimo = sottobacino+"-NT";
						String sempreTutti = "SEMPRE-TT";
						String semprePrimo = "SEMPRE-NT";
						
						boolean doppioLivello = (sottobacino!=null && !sottobacino.equals("") && !sottobacino.equals(bacino));
						boolean bacinoAttivo = false;
						boolean sottobacinoAttivo = false;
						
						String sottobacini[] = null;
						String sottobaciniTutti[] = null;
						String sottobaciniPrimo[] = null;
						AttivazioneFiume sottobaciniAttivi[] = null;
						if (doppioLivello) {
							sottobacini = sottobacino.split(",");
							sottobaciniTutti = new String[sottobacini.length];
							sottobaciniPrimo = new String[sottobacini.length];
							sottobaciniAttivi = new AttivazioneFiume[sottobacini.length];
							
							for (int k=0; k<sottobacini.length; k++) {
								sottobaciniTutti[k] = sottobacini[k]+"-TT";
								sottobaciniPrimo[k] = sottobacini[k]+"-NT";
								sottobaciniAttivi[k] = AttivazioneFiumeLocalServiceUtil.fetchAttivazioneFiume(sottobacini[k]+"_"+soglia);
								if (sottobaciniAttivi[k]==null) {
									sottobaciniAttivi[k] = AttivazioneFiumeLocalServiceUtil.createAttivazioneFiume(sottobacini[k]+"_"+soglia);
									sottobaciniAttivi[k].setAttivo(false);
								}
							}
						}
						
						AttivazioneFiume af = AttivazioneFiumeLocalServiceUtil.fetchAttivazioneFiume(bacino+"_"+soglia);
						if (af==null) {
							af = AttivazioneFiumeLocalServiceUtil.createAttivazioneFiume(bacino+"_"+soglia);
							af.setAttivo(false);
						}
						bacinoAttivo = af.getAttivo();
						/*AttivazioneFiume af2 = null;
						if (doppioLivello) {
							af2 = AttivazioneFiumeLocalServiceUtil.fetchAttivazioneFiume(sottobacino);
							if (af2==null) {
								af2 = AttivazioneFiumeLocalServiceUtil.createAttivazioneFiume(sottobacino);
								af2.setAttivo(false);
							}
							sottobacinoAttivo = af2.getAttivo();
						}*/
						
						
						//DESTINATARI SEMPRE - TUTTI
						Organization o = null;
						
						if (nuovaRubrica) {
							SMSLocalServiceUtil.creaNotificaGruppoRubrica(null, from, descNormale, "superamento", sempreTutti, a.getAllarmeId(), 20181, sempreTutti, true, null);

						} else {
							o = getOrganization(sempreTutti);
							if (o!=null) {
								SMSLocalServiceUtil.creaSMSOrganization(from, descNormale, "superamento", o.getName(), a.getAllarmeId(), o.getOrganizationId());
							}
						}
						
						//DESTINATARI SEMPRE - PRIMO
						if (!bacinoAttivo) {
							if (nuovaRubrica) {
								SMSLocalServiceUtil.creaNotificaGruppoRubrica(null, from, descNonTecnica, "superamento", semprePrimo, a.getAllarmeId(), 20181, semprePrimo, true, null);

							} else {
								o = getOrganization(semprePrimo);
								if (o!=null) {
									SMSLocalServiceUtil.creaSMSOrganization(from, descNonTecnica, "superamento", o.getName(), a.getAllarmeId(), o.getOrganizationId());
								}
							}
						}
						//DESTINATARI BACINO - TUTTI
						if (nuovaRubrica) {
							SMSLocalServiceUtil.creaNotificaGruppoRubrica(null, from, descNormale, "superamento", bacinoTutti, a.getAllarmeId(), 20181, bacinoTutti, true, null);

						} else {
							o = getOrganization(bacinoTutti);
							if (o!=null) {
								SMSLocalServiceUtil.creaSMSOrganization(from, descNormale, "superamento", o.getName(), a.getAllarmeId(), o.getOrganizationId());
							}
						}
						//DESTINATARI BACINO - PRIMO
						if (!bacinoAttivo) {
							if (nuovaRubrica) {
								SMSLocalServiceUtil.creaNotificaGruppoRubrica(null, from, descNonTecnica, "superamento", bacinoPrimo, a.getAllarmeId(), 20181, bacinoPrimo, true, null);

							} else {
								o = getOrganization(bacinoPrimo);
								if (o!=null) {
									SMSLocalServiceUtil.creaSMSOrganization(from, descNonTecnica, "superamento", o.getName(), a.getAllarmeId(), o.getOrganizationId());
								}
							}
						}
						//DESTINATARI SOTTOBACINI
						if (doppioLivello) {
							for (int k=0; k<sottobacini.length; k++) {
								//SOTTOBACINO - TUTTI
								if (nuovaRubrica) {
									SMSLocalServiceUtil.creaNotificaGruppoRubrica(null, from, descNormale, "superamento", sottobaciniTutti[k], a.getAllarmeId(), 20181, sottobaciniTutti[k], true, null);

								} else {
									o = getOrganization(sottobaciniTutti[k]);
									if (o!=null) {
										SMSLocalServiceUtil.creaSMSOrganization(from, descNormale, "superamento", o.getName(), a.getAllarmeId(), o.getOrganizationId());
									}
								}
								//SOTTOBACINO - PRIMO
								if (!sottobaciniAttivi[k].getAttivo()) {
									if (nuovaRubrica) {
										SMSLocalServiceUtil.creaNotificaGruppoRubrica(null, from, descNonTecnica, "superamento", sottobaciniPrimo[k], a.getAllarmeId(), 20181, sottobaciniPrimo[k], true, null);

									} else {
										o = getOrganization(sottobaciniPrimo[k]);
										if (o!=null) {
											SMSLocalServiceUtil.creaSMSOrganization(from, descNonTecnica, "superamento", o.getName(), a.getAllarmeId(), o.getOrganizationId());
										}
									}
								}
							}
						}
						
						//DESTINATARI SPECIFICO IDROMETRO
						if (nuovaRubrica) {
							SMSLocalServiceUtil.creaNotificaGruppoRubrica(null, from, descNormale, "superamento", rubrica, a.getAllarmeId(), 20181, rubrica, true, null);

						} else {
							o = getOrganization(rubrica);
							if (o!=null) {
								SMSLocalServiceUtil.creaSMSOrganization(from, descNormale, "superamento", o.getName(), a.getAllarmeId(), o.getOrganizationId());
							}
						}
						
						//aggiorna le attivazioni
						if (af!=null) {
							af.setAttivo(true);
							AttivazioneFiumeLocalServiceUtil.updateAttivazioneFiume(af);
						}
						if (doppioLivello) {
							for (int k=0; k<sottobacini.length; k++) {
								if (sottobaciniAttivi[k]!=null) {
									sottobaciniAttivi[k].setAttivo(true);
									AttivazioneFiumeLocalServiceUtil.updateAttivazioneFiume(sottobaciniAttivi[k]);
								}
							}
						}
						
						//INVIO SMS
						SMSLocalServiceUtil.inviaSMS("superamento", null, a.getAllarmeId());
						
						//INVIO MAIL NON TECNICHE
		    			SMSLocalServiceUtil.inviaEmail("superamento", semprePrimo, a.getAllarmeId(), (soglia==2?"ALLERTAER - Innalzamento del livello idrometrico al di sopra della soglia 2 sul fiume "+bac:
    						"ALLERTAER - Evento di piena in corso sul fiume "+bac), emailNonTecnica, ff);    		
		    			SMSLocalServiceUtil.inviaEmail("superamento", bacinoPrimo, a.getAllarmeId(), (soglia==2?"ALLERTAER - Innalzamento del livello idrometrico al di sopra della soglia 2 sul fiume "+bac:
    						"ALLERTAER - Evento di piena in corso sul fiume "+bac), emailNonTecnica, ff);    		
		    			if (doppioLivello) {
		    				for (int k=0; k<sottobacini.length; k++) {
				    			SMSLocalServiceUtil.inviaEmail("superamento", sottobaciniPrimo[k], a.getAllarmeId(),
				    					(soglia==2?"ALLERTAER - Innalzamento del livello idrometrico al di sopra della soglia 2 sul fiume "+bac:
				    						"ALLERTAER - Evento di piena in corso sul fiume "+bac), emailNonTecnica, ff);    						
		    				}
		    			}
		    			
		    			//INVIO TUTTE LE ALTRE MAIL
		    			SMSLocalServiceUtil.inviaEmail("superamento", null, a.getAllarmeId(), "ALLERTAER - Superata soglia "+soglia+" nell'idrometro di "+s.getName()+" sul fiume "+bac, emailNormale, ff);    		
						
					}
				}				
			}
	    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		//LogInternoLocalServiceUtil.log("AllarmeWorkflow", "sendSMS", e, "");
    	}
    }
	 
	 public Organization getOrganization(String nome) {
    	try {
    		return OrganizationLocalServiceUtil.fetchOrganization(20154, nome);
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
	 }
	    
    private String getProvincia(Stazione s) {
    	
    	String p = s.getNameProvince();
    	return (p!=null?p:"");
    	/*if (p==null) return "";
    	
    	if ("BOLOGNA".equals(p)) return "BO";
    	if ("FERRARA".equals(p)) return "FE";
    	if ("MODENA".equals(p)) return "MO";
    	if ("PIACENZA".equals(p)) return "PC";
    	if ("RIMINI".equals(p)) return "RN";
    	if ("RAVENNA".equals(p)) return "RA";
    	if (p.startsWith("REGGIO")) return "RE";
    	if (p.startsWith("FORL")) return "FC";*/
    	
    }

}
