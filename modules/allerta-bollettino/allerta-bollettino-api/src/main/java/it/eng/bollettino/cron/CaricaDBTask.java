package it.eng.bollettino.cron;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.util.ExpandoBridgeUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONDeserializer;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.WorkflowDefinitionLink;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelperUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.scheduler.TriggerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalService;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import it.eng.allerta.configuration.AllertaBaseConfiguration;
import it.eng.allerta.configuration.schedulers.AllertaBaseSchedulersConfiguration;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerta.utils.BlogsRenderFilter;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.service.AllertaLocalService;
import it.eng.allerter.service.AllertaValangheLocalService;
import it.eng.allerter.service.LogInternoLocalService;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.allerter.service.SMSLocalService;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.bollettino.model.Allarme;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.model.RegolaAllarme;
import it.eng.bollettino.model.RegolaAllarmeComune;
import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.model.ValoreSensore;
import it.eng.bollettino.model.Variabile;
import it.eng.bollettino.service.AllarmeLocalService;
import it.eng.bollettino.service.AllarmeLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;
import it.eng.radarMeteo.service.ImgLocalService;
import it.eng.radarMeteo.service.ImgLocalServiceUtil;
import it.eng.radarMeteo.service.ImgService;
import it.eng.bollettino.service.RegolaAllarmeComuneLocalService;
import it.eng.bollettino.service.RegolaAllarmeComuneLocalServiceUtil;
import it.eng.bollettino.service.RegolaAllarmeCondizioneLocalService;
import it.eng.bollettino.service.RegolaAllarmeCondizioneLocalServiceUtil;
import it.eng.bollettino.service.RegolaAllarmeLocalServiceUtil;
import it.eng.bollettino.service.StazioneLocalService;
import it.eng.bollettino.service.StazioneLocalServiceUtil;
import it.eng.bollettino.service.StazioneVariabileLocalService;
import it.eng.bollettino.service.StazioneVariabileLocalServiceUtil;
import it.eng.bollettino.service.ValoreSensoreLocalService;
import it.eng.bollettino.service.ValoreSensoreLocalServiceUtil;
import it.eng.bollettino.service.VariabileLocalService;
import it.eng.bollettino.service.VariabileLocalServiceUtil;
import it.eng.cache.service.DatiLocalServiceUtil;

@Component(
		  immediate = true, 			  
		  service = MessageListener.class
		)
public class CaricaDBTask extends BaseMessageListener {

	public static Object o = new Object();
	public static boolean busy = false;
	private Log logger = LogFactoryUtil.getLog(CaricaDBTask.class);
	static CaricaDBTask lastInstance = null;
	
	static int executions = 0;
	static Date lastInvioAccensione = null;
	
	private List stazioniConBuchi(String variabile, String intervallo, String lookback) {
		String query = "select distinct idstazione from bollettino_valoresensore vs where not exists("+
	"select * from bollettino_valoresensore vs2 where vs2.idstazione=vs.idstazione and vs2.idvariabile=vs.idvariabile and vs2.datetime=vs.datetime - cast('"+intervallo+"' as interval))"+
	"and idvariabile = '"+variabile+"' and datetime > cast(now() as timestamp) - cast('"+lookback+"' as interval)";
		
		List l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(query);
		return l;
	}
	
	private void deleteOldValues() {
		String query = "delete from bollettino_valoresensore where datetime < cast(now() as timestamp) - cast('7 days' as interval)";
		BollettinoLocalServiceUtil.eseguiQueryGenericaLista(query);
	}
	
	private boolean haBuchi(String idStazione, List listaBuchi) {
		if (listaBuchi==null) return false;
		for (Object o : listaBuchi) {
			if (o instanceof Object[]) {
				Object[] o2 = (Object[])o;
				if (o2.length>0 && o2[0]!=null && o2[0].toString().equals(idStazione)) return true; 
			} else {
				if (o!=null && o.toString().equals(idStazione)) return true;
			}
		}
		return false;
	}
	
	public static void forzaEsecuzione(String richiedente) {
		LogInternoLocalServiceUtil.log("rt_data","Scaricamento forzato","Inizio scaricamento",richiedente);
		lastInstance.deactivate();
		lastInstance.activate(null);
	}
	
	public void forza(String richiedente) {
		try {
			logInternoLocalService.log("rt_data","Scaricamento forzato","Inizio scaricamento",richiedente);
			
			String className = this.getClass().getName();
			
			Trigger trigger = 
					_triggerFactory.createTrigger(className, className, new Date(), new Date(), 1, TimeUnit.MINUTE);

			SchedulerEntry schedulerEntry = new SchedulerEntryImpl(
				className, trigger);
					
			baseScheduler.register(
				this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
			
		} catch (Exception e) {
			logger.error(e);
		}
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		
		//aggiornaValori("254,0,0/1,-,-,-/B10004", "-/1213623,4369223/simnbo");
		//return;
		
		// synchronized(this) {

		BollettinoParametro bp = null;

		try {

			// if (busy) return;
			// busy = true;
			//monitoraggioPermGen();
			
			

			// logger.info(downloadUrl("https://www.arpae.it/smr/datiiningresso/bollettino/tendenza3g.txt"));
			

			logger.info("rt_data Scheduler START");
			
			boolean prosegui = true;

			bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("REFRESH_IN_PROGRESS");
			if (bp != null) {
				try {
					long l = Long.parseLong(bp.getValore());
					prosegui = (new Date().getTime() - l) > 10*60*1000; //dopo 10 minuti prosegui, probabile crash
				} catch (Exception e) {
				}
				
			}
			
			if (!prosegui) {
				logger.info("Scheduler già in esecuzione, esco");
				logger.info("rt_data Scheduler END");
				return;
			}
			

			if (bp==null) bp = BollettinoParametroLocalServiceUtil.createBollettinoParametro("REFRESH_IN_PROGRESS");
			bp.setValore(""+new Date().getTime());
			BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);

			try {
				togliDocScadutiDaHomepage();
			} catch (Exception e) {
				logger.error(e);
			}
			
			try {
				controlloPioggiaMonitoraggio();
			} catch (Exception e) {
				logger.error(e);
			}

			try {
				caricaTrascinataPioggia();
			} catch (Exception e) {
				logger.error(e);
			}

			int k = 0;
			
			boolean disable_rtdata = true;
			
			try {
				disable_rtdata = AllertaTracker.getAllertaBaseConfiguration().disableRtData();
			} catch (Exception e) {
				logger.error(e);
			}
			
			boolean aggiornaStazioni = executions % 100 == 0;
			String risultati = "";

			try {
				if (!disable_rtdata) aggiornaStazioni();
				else if (aggiornaStazioni) {
					RisultatiAggiornamento ra = stazioneLocalService.aggiornaStazioni();
					if (ra.aggiunti>0 || ra.modificati>0 || ra.rimossi>0 || ra.errore!=null) {
						if (ra.errore!=null) logInternoLocalService.log("dati osservati", "Aggiornamento stazioni", "Errore: "+ra.errore, "");
						else {
							risultati += "MODIFICHE ALLE STAZIONI - "+ra.toString()+" ";
							String ris = "Aggiunti "+ra.aggiunti+", modificati "+ra.modificati+", rimossi "+ra.rimossi;
							logInternoLocalService.log("dati osservati", "Aggiornamento stazioni", ris, "");
						}
					}
				}
				
			} catch (Exception e) {
				logger.error(e);
			}

			try {
				if (!disable_rtdata) aggiornaVariabili();
				else if (aggiornaStazioni) {
					RisultatiAggiornamento ra = variabileLocalService.aggiornaVariabili();
					if (ra.aggiunti>0 || ra.modificati>0 || ra.rimossi>0 || ra.errore!=null) {
						if (ra.errore!=null) logInternoLocalService.log("dati osservati", "Aggiornamento variabili", "Errore: "+ra.errore, "");
						else {
							String ris = "Aggiunti "+ra.aggiunti+", modificati "+ra.modificati+", rimossi "+ra.rimossi;
							logInternoLocalService.log("dati osservati", "Aggiornamento variabili", ris, "");
						}
					}
				}
			} catch (Exception e) {
				logger.error(e);
			}
			
			try {
				if (!disable_rtdata) aggiornaSensori();
				else if (aggiornaStazioni) {
					RisultatiAggiornamento ra = stazioneVariabileLocalService.aggiornaSensori();
					if (ra.aggiunti>0 || ra.modificati>0 || ra.rimossi>0 || ra.errore!=null) {
						if (ra.errore!=null) logInternoLocalService.log("dati osservati", "Aggiornamento sensori", "Errore: "+ra.errore, "");
						else {
							risultati += "MODIFICHE A SOGLIE O VARIABILI DEI SENSORI - "+ra.toString()+" ";
							String ris = "Aggiunti "+ra.aggiunti+", modificati "+ra.modificati+", rimossi "+ra.rimossi;
							logInternoLocalService.log("dati osservati", "Aggiornamento sensori", ris, "");
						}
					}
				}
			} catch (Exception e) {
				logger.error(e);
			}		
			
			try {
				aggiornaTuttoMare();
			} catch (Exception e) {
				logger.error(e);
			}	
			
			try {
				if (risultati!=null && !risultati.equals("")) {
					BollettinoParametro gruppo = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GRUPPO_ACCENSIONE_MAPPA");
					if (gruppo!=null) {
						try {
							
							
							
							long ts = new Date().getTime();
							long canaleMail[] = new long[1];
							canaleMail[0] = 1;
							smsLocalService.creaNotificaGruppoRubrica(canaleMail, "AllerteER", "Notifica variazioni stazioni Portale Allerte", "automatismo", "aggStazioni", ts, 20181, gruppo.getValore(), true, null);
							smsLocalService.eliminaDuplicatiEmail("automatismo", "aggStazioni", ts);
							smsLocalService.inviaEmail("automatismo", "aggStazioni", ts,
									"Notifica variazioni stazioni Portale Allerte", "Si comunicano le seguenti variazioni alle stazioni sul Portale Allerte Emilia-Romagna. "+risultati, "no-reply@regione.emilia-romagna.it");
										} catch (Exception e) {
							logger.error(e);
						}
					}
				}

			} catch (Exception e) {
				logger.error(e);
			}	
			
			try {
				if (!disable_rtdata) aggiornaTuttiValori();
			} catch (Exception e) {
				logger.error(e);
			}

			try {
				regoleAllarme();
			} catch (Exception e) {
				logger.error(e);
			}
			
			try {
				aggiornaLogSoglie();
			} catch (Exception e) {
				logger.error(e);
			}

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask", "receive", e, "");
		} finally {
			// busy = false;
			if (bp != null) {
				try {
					BollettinoParametroLocalServiceUtil.deleteBollettinoParametro(bp);
				} catch (Exception e2) {
					logger.error(e2);
					//logInternoLocalService.log("caricaDbTask", "receive", e2, "");
				}
			}
			// busy = false;
		}
		// }
		executions++;
		logger.info("rt_data Scheduler END");
		//lastInstance = this;
		
	}
	
	public void aggiornaLogSoglie() {
		String comando1 = "update allerter_logsoglia x set dataorafine = " + 
				"(select datetime from bollettino_valoresensore vs where vs.idstazione=x.idstazione and " + 
				"vs.idvariabile=x.idvariabile order by vs.datetime desc limit 1) where x.dataorafine is null and not exists " + 
				"(select * from superamenti_soglia1_vw ss where ss.idstazione=x.idstazione and ss.idvariabile=x.idvariabile)";
		
		String sottoComando = "select idstazione, datetime as dataorainizio, " + 
				"idvariabile, (select name from bollettino_stazione where id_=vv.idstazione limit 1) as nomestazione, value as valore " + 
				"from superamenti_soglia1_vw vv where not exists (select * from allerter_logsoglia ls where " + 
				"ls.idstazione=vv.idstazione and ls.idvariabile=vv.idvariabile and ls.dataorafine is null) " + 
				"and not exists (select * from allerter_logspike spike where spike.idstazione=vv.idstazione " + 
				"and spike.idvariabile=vv.idvariabile and spike.dataora=vv.datetime)";
		String sottoComando2 = "select idstazione, datetime as dataorainizio, null as dataorafine, " + 
				"idvariabile, (select name from bollettino_stazione where id_=vv.idstazione limit 1) as nomestazione, value as valore, 1 as soglia, soglia1 as valoresoglia " + 
				"from superamenti_soglia1_vw vv where not exists (select * from allerter_logsoglia ls where " + 
				"ls.idstazione=vv.idstazione and ls.idvariabile=vv.idvariabile and ls.dataorafine is null) " + 
				"and not exists (select * from allerter_logspike spike where spike.idstazione=vv.idstazione " + 
				"and spike.idvariabile=vv.idvariabile and spike.dataora=vv.datetime)";
		String comando2 = "insert into allerter_logsoglia ("+sottoComando2+")";
	
		try {
			
			List<Object[]> l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(sottoComando);
			long ts = new Date().getTime();
			
			if (l!=null) {
				long[] canali = {1}; //solo mail
				for (Object[] o : l) {
					ts++;
					
					String gruppoRubrica = "Superamenti soglia 1";
					String testoMail = "Si comunica superamento soglia 1 idrometro %STAZIONE% alle %ORE% ora locale";
					
					Date d = (Date)o[1];
					boolean oraLegale = TimeZone.getDefault().inDaylightTime( d);
					d.setTime(d.getTime()+(oraLegale?7200000:3600000));
					String ora = new SimpleDateFormat("HH:mm").format(d);
					String stazione = (String)o[3];
					
					testoMail = testoMail.replaceAll("%ORE%", ora);
					testoMail = testoMail.replaceAll("%STAZIONE%", stazione);
					
					
					smsLocalService.creaNotificaGruppoRubrica(canali, "AllerteER", "", "soglia1", "soglia1", ts, 20181, gruppoRubrica, true, null);
					//smsLocalService.creaSMSOrganization("AllerteER", sms, "spike", s, ts, org);
					smsLocalService.eliminaDuplicatiEmail("soglia1", "soglia1", ts);
					smsLocalService.inviaEmail("soglia1", "soglia1", ts,
							"Portale Web allerte: superamento soglia 1 idrometro "+stazione, testoMail, "no-reply@regione.emilia-romagna.it");
					
				}
			}
			
			BollettinoLocalServiceUtil.eseguiQueryGenerica(comando1);
			BollettinoLocalServiceUtil.eseguiQueryGenerica(comando2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void aggiornaTuttiValori() {
		
		boolean aggiornato = false;
		StringBuilder stringa = new StringBuilder();
		
		try {	
			
			try {
			DatiLocalServiceUtil.removeDatiByPrefix("sensorvalues%");
			} catch (Exception ecc ) {}
			
			if (aggiornaValoriSuperficiale("254,0,0/1,-,-,-/B13215","idro",stringa))
				aggiornato = true;

			
			if (aggiornaValoriSuperficiale("1,0,900/1,-,-,-/B13011","pioggia 15min",stringa))
				aggiornato = true;
			if (aggiornaValoriSuperficiale("1,0,1800/1,-,-,-/B13011","pioggia 30min",stringa))
				aggiornato = true;
			if (aggiornaValoriSuperficiale("1,0,3600/1,-,-,-/B13011","pioggia 60min",stringa))
				aggiornato = true;
			//if (aggiornaValoriSuperficiale("1,0,86400/1,-,-,-/B13011"))
				//aggiornato = true;
			
			if (aggiornaValoriSuperficiale("254,0,0/103,2000,-,-/B13003","umidità",stringa))
				aggiornato = true;
			if (aggiornaValoriSuperficiale("254,0,0/103,10000,-,-/B11002","vel. vento",stringa))
				aggiornato = true;
			if (aggiornaValoriSuperficiale("254,0,0/103,10000,-,-/B11001","dir. vento",stringa))
				aggiornato = true;
			if (aggiornaValoriSuperficiale("254,0,0/1,-,-,-/B10004","pressione",stringa))
				aggiornato = true;
			if (aggiornaValoriSuperficiale("254,0,0/1,-,-,-/B13013","spessore neve",stringa))
				aggiornato = true;
			if (aggiornaValoriSuperficiale("254,0,0/103,2000,-,-/B12101","temperatura",stringa))
				aggiornato = true;
			
			try {
				deleteOldValues();
			} catch (Exception ex) {
				logger.error(ex);
			}
			
			//ricaricaCachePluvio();
		logInternoLocalService.log("rt_data", "Scaricamento dati sensori", stringa.toString(), "");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask", "receive", e, "");
		}

	}

	public void togliDocScadutiDaHomepage() {

		Calendar c = Calendar.getInstance();
		//c.add(Calendar.HOUR, 1); // per sicurezza
		Date d = c.getTime();

		// trova tutti gli oggetti con la categoria "mostra in home"
		logger.info("Tolgo doc scaduti");
		try {
/*
			long idCat = 0;
			BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("CATEGORIA_MOSTRA_IN_HOME");
			if (bp == null || bp.getValore() == null)
				return;
			idCat = Long.parseLong(bp.getValore());
*/			
			long idCat = 155477;
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			assetEntryQuery.setClassName(Allerta.class.getName());
			assetEntryQuery.setAllCategoryIds( new long[]{idCat});
			
			List<AssetEntry> allertaAssets = assetEntryLocalService.getEntries(assetEntryQuery);
			for (AssetEntry allertaAssetEntry : allertaAssets) {
					
				Allerta a = allertaLocalService.fetchAllerta(allertaAssetEntry.getClassPK());
				
				if (a != null && a.getDataFine() != null && a.getDataFine().before(d)) {
					
					long[] cats = allertaAssetEntry.getCategoryIds();
					
					long[] cc = new long[cats.length - 1];
					
					int i = 0;
					for( long l : cats) {
						
						if( l != idCat)
							cc[i++] = l;
					}
					
					assetEntryLocalService.deleteAssetCategoryAssetEntry(idCat, allertaAssetEntry);
					assetEntryLocalService.updateEntry(
							allertaAssetEntry.getUserId(), 
							allertaAssetEntry.getGroupId(), 
							allertaAssetEntry.getClassName(), 
							allertaAssetEntry.getClassPK(), 
							cc, 
							new String[]{});
					logger.info("Rimuovo da homepage Allerta " + a.getAllertaId());
				}
				
			}
			
			assetEntryLocalService.reindex(allertaAssets);
			
			assetEntryQuery = new AssetEntryQuery();
			assetEntryQuery.setClassName(Bollettino.class.getName());
			assetEntryQuery.setAllCategoryIds( new long[]{idCat});
			
			List<AssetEntry> bollettinoAssets = assetEntryLocalService.getEntries(assetEntryQuery);
			for (AssetEntry bollettinoAssetEntry : bollettinoAssets) {
					
				Bollettino b = BollettinoLocalServiceUtil.fetchBollettino(bollettinoAssetEntry.getClassPK());
				if (b != null && b.getDataFine() != null && b.getDataFine().before(d)) {
					
					long[] cats = bollettinoAssetEntry.getCategoryIds();
					
					long[] cc = new long[cats.length - 1];
					
					int i = 0;
					for( long l : cats) {
						
						if( l != idCat)
							cc[i++] = l;
					}
					
					assetEntryLocalService.deleteAssetCategoryAssetEntry(idCat, bollettinoAssetEntry);
					assetEntryLocalService.updateEntry(
							bollettinoAssetEntry.getUserId(), 
							bollettinoAssetEntry.getGroupId(), 
							bollettinoAssetEntry.getClassName(), 
							bollettinoAssetEntry.getClassPK(), 
							cc, 
							new String[]{});
					
					//assetEntryLocalService.updateAssetEntry(bollettinoAssetEntry);
					logger.info("Rimuovo da homepage Bollettino " + b.getBollettinoId());
				}
				
			}
			
			assetEntryLocalService.reindex(bollettinoAssets);
			
			
			assetEntryQuery = new AssetEntryQuery();
			assetEntryQuery.setClassName(AllertaValanghe.class.getName());
			assetEntryQuery.setAllCategoryIds( new long[]{idCat});
			
			allertaAssets = assetEntryLocalService.getEntries(assetEntryQuery);
			for (AssetEntry allertaAssetEntry : allertaAssets) {
					
				AllertaValanghe a = allertaValangheLocalService.fetchAllertaValanghe(allertaAssetEntry.getClassPK());
				
				if (a != null && a.getDataFine() != null && a.getDataFine().before(d)) {
					
					long[] cats = allertaAssetEntry.getCategoryIds();
					
					long[] cc = new long[cats.length - 1];
					
					int i = 0;
					for( long l : cats) {
						
						if( l != idCat)
							cc[i++] = l;
					}
					
					assetEntryLocalService.deleteAssetCategoryAssetEntry(idCat, allertaAssetEntry);
					assetEntryLocalService.updateEntry(
							allertaAssetEntry.getUserId(), 
							allertaAssetEntry.getGroupId(), 
							allertaAssetEntry.getClassName(), 
							allertaAssetEntry.getClassPK(), 
							cc, 
							new String[]{});
					logger.info("Rimuovo da homepage AllertaValanghe " + a.getAllertaValangheId());
				}
				
			}
			
			assetEntryLocalService.reindex(allertaAssets);
			
			//allerta-pubblicata 153999
			//monitoraggio-pubblicato 158459
			
			assetEntryQuery = new AssetEntryQuery();
			assetEntryQuery.setClassName("com.liferay.blogs.model.BlogsEntry");
			assetEntryQuery.setAllCategoryIds( new long[]{idCat});
			
			allertaAssets = assetEntryLocalService.getEntries(assetEntryQuery);
			
			if (allertaAssets.size()>0) {
	            PermissionChecker permissionChecker;
	            User u = UserLocalServiceUtil.fetchUser(20198);

	            permissionChecker = PermissionCheckerFactoryUtil.create(u);
	            PermissionThreadLocal.setPermissionChecker(permissionChecker);
			}
			
			for (AssetEntry allertaAssetEntry : allertaAssets) {
				BlogsEntry b = BlogsEntryLocalServiceUtil.fetchBlogsEntry(allertaAssetEntry.getClassPK());
				if (b!=null && b.getExpandoBridge()!=null) {
					if (b.getExpandoBridge().hasAttribute("Data uscita banner")) {
						Date dd = (Date) b.getExpandoBridge().getAttribute("Data uscita banner");
						if (dd!=null && new Date().after(dd)) {
							assetEntryLocalService.deleteAssetCategoryAssetEntry(idCat, allertaAssetEntry);
							assetEntryLocalService.updateEntry(
									allertaAssetEntry.getUserId(), 
									allertaAssetEntry.getGroupId(), 
									allertaAssetEntry.getClassName(), 
									allertaAssetEntry.getClassPK(), 
									new long[] {}, 
									new String[]{});
							logger.info("Rimuovo da homepage news " + b.getEntryId());
						}
					}
				}
			}
			
		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	private <T> T deserialize(String content, Class<T> clazz) {
		
		JSONDeserializer<T> deserializer = 
				JSONFactoryUtil.createJSONDeserializer();
		
		return deserializer.deserialize(content);
	}
	
	public void caricaTrascinataPioggia() throws Exception {

		BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("DBTASK_TRASCINATA_URL1");
		if (bp == null)
			return;
		String url = bp.getValore();
		String content = downloadUrl(url);
		if (content == null) {
			logger.error("Scaricamento elenco immagini trascinate FALLITO da "+url);
			return;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map = deserialize(content, map.getClass()); //, );

		Object o = map.get("6h");

		if (o == null) {
			return;
		}

		List o2 = (List) o;

		if (o2.size() == 0) {
			return;
		}

		String o3 = o2.get(0).toString();

		bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("DBTASK_TRASCINATA_URL2");
		if (bp == null)
			return;
		String url2 = bp.getValore() + o3;

		byte[] data = downloadUrlBinary(url2);

		if (data == null) {
			logger.error("Scaricamento immagine trascinata FALLITO da "+url);
			return;
		}

		// temp file
		try {


			try {
				bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("PATH_IMG_BOLLETTINO");
				if (bp == null)
					bp = BollettinoParametroLocalServiceUtil.createBollettinoParametro("PATH_IMG_BOLLETTINO");
				bp.setValore("xxx");
				BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);
				
				String hex = bytesToHex(data);
				bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("IMG_BOLLETTINO");
				if (bp == null)
					bp = BollettinoParametroLocalServiceUtil.createBollettinoParametro("IMG_BOLLETTINO");
				bp.setValore(hex);
				BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);
				
				logger.info("Trascinata scaricata con successo");
				
			} catch (Exception e) {

			}
		} catch (Exception e) {
			logger.error(e);
		}
		
		
		o = map.get("48h");

		if (o == null) {
			return;
		}

		o2 = (List) o;

		if (o2.size() == 0) {
			return;
		}

		o3 = o2.get(0).toString();

		bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("DBTASK_TRASCINATA_URL3");
		if (bp == null)
			return;
		url2 = bp.getValore() + o3;

		data = downloadUrlBinary(url2);

		if (data == null) {
			logger.error("Scaricamento immagine trascinata FALLITO da "+url);
			return;
		}

		// temp file
		try {


			try {
				bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("PATH_IMG_BOLLETTINO");
				if (bp == null)
					bp = BollettinoParametroLocalServiceUtil.createBollettinoParametro("PATH_IMG_BOLLETTINO");
				bp.setValore("xxx");
				BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);
				
				String hex = bytesToHex(data);
				bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("IMG_BOLLETTINO2");
				if (bp == null)
					bp = BollettinoParametroLocalServiceUtil.createBollettinoParametro("IMG_BOLLETTINO2");
				bp.setValore(hex);
				BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);
				
				logger.info("Trascinata 48h scaricata con successo");
				
			} catch (Exception e) {

			}
		} catch (Exception e) {
			logger.error(e);
		}

	}

	public void aggiornaStazioni() {

		String url = "https://simc.arpae.it/meteozen/rt_data/api/v2/stations";
		String content = downloadUrl(url);
		if (content == null) {
			logger.error("Aggiornamento stazioni FALLITO");
			logInternoLocalService.log("rt_data","Aggiornamento stazioni","Fallito, rt_data non raggiungibile","");
			return;
		}
		
		List<Stazione> staz = null;
		List<Stazione> staz2 = new ArrayList<Stazione>();
		try {
			staz = StazioneLocalServiceUtil.getStaziones(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			staz2.addAll(staz);
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask", "aggiornaStazioni", e, "");
		}


		//Map<String, Object> map[] = new Map[0];
		//andcop - errore di Cast Map to ArrayList
		ArrayList<Object> map = new ArrayList<Object>();
		map = deserialize(content, map.getClass()); //, map.getClass());

		for (int k = 0; k < map.size(); k++) {

			String id = null;
			
			try {
				Map<String, Object> o = (Map<String, Object>) map.get(k);
				Stazione s = null;

				id = (String) o.get("id");
				if (id == null || id.equals(""))
					continue;

				try {
					s = StazioneLocalServiceUtil.fetchStazione(id);
					if (s==null) {
						s = StazioneLocalServiceUtil.createStazione(id);
						s.setAttivo(true);
						logger.info("Creazione stazione "+id);
						logInternoLocalService.log("rt_data","Creazione stazione",id,"");
					}
					
					for (Stazione ss : staz2) {
						if (ss.getId().equals(s.getId())) {
							staz2.remove(ss);
							break;
						}
					}
					
				} catch (Exception e) {
					logger.error(e);
				}

				if (s == null) {
					s = StazioneLocalServiceUtil.createStazione(id);
					s.setAttivo(true);
				}

				if (!s.getAttivo()) {
					logger.info("Riattivazione stazione "+id);
					logInternoLocalService.log("rt_data","Riattivazione stazione",id+" ("+s.getName()+"","");
				}
				s.setAttivo(true);
				if (o.get("height") != null)
					s.setHeight(Float.parseFloat(o.get("height").toString()));
				if (o.get("lat") != null)
					s.setLat((long) Double.parseDouble(o.get("lat").toString()));
				if (o.get("lon") != null)
					s.setLon((long) Double.parseDouble(o.get("lon").toString()));
				if (o.get("ident") != null)
					s.setIdent(o.get("ident").toString());
				if (o.get("network") != null)
					s.setNetwork(o.get("network").toString());
				if (o.get("name") != null)
					s.setName(o.get("name").toString());

				if (o.get("country") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("country");
					if (m.get("name") != null)
						s.setNameCountry(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdCountry(m.get("code").toString());
				}

				if (o.get("province") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("province");
					if (m.get("name") != null)
						s.setNameProvince(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdProvince(m.get("code").toString());
				}

				if (o.get("basin") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("basin");
					if (m.get("name") != null)
						s.setNameBasin(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdBasin(m.get("code").toString());
				}

				if (o.get("region") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("region");
					if (m.get("name") != null)
						s.setNameRegion(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdRegion(m.get("code").toString());
				}

				if (o.get("subbasin") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("subbasin");
					if (m.get("name") != null)
						s.setNameSubbasin(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdSubbasin(m.get("code").toString());
				}

				if (o.get("municipality") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("municipality");
					if (m.get("name") != null)
						s.setNameMunicipality(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdMunicipality(m.get("code").toString());
				}

				if (o.get("macroarea") != null) {
					Map<String, Object> m = (Map<String, Object>) o.get("macroarea");
					if (m.get("name") != null)
						s.setNameMacroarea(m.get("name").toString());
					if (m.get("code") != null)
						s.setIdMacroarea(m.get("code").toString());
				}

				StazioneLocalServiceUtil.updateStazione(s);

			} catch (Exception e) {
				logger.error(e);
				//logInternoLocalService.log("caricaDbTask.aggiornaStazioni", id, e, null);

			}

		}
		
		//quelle non presenti nel web service vengono disattivate
		for (Stazione rimasto : staz2) {
			try {
				if (rimasto.getAttivo()) {
					logger.info("Disattivo stazione "+rimasto.getId());
					logInternoLocalService.log("rt_data", "Disattivazione stazione", rimasto.getId()+" ("+rimasto.getName()+")", "");
				}
				rimasto.setAttivo(false);
				StazioneLocalServiceUtil.updateStazione(rimasto);
			} catch (Exception e) {
				logger.error(e);
				//logInternoLocalService.log("caricaDbTask", "aggiornaStazioni", e, null);
			}
		}
		
		logger.info("Aggiornamento stazioni completato");
		logInternoLocalService.log("rt_data","Aggiornamento stazioni","Riuscito: "+map.size()+" scaricate","");

	}

	public void aggiornaVariabili() {

		String url = "https://simc.arpae.it/meteozen/rt_data/api/v2/variables";
		String content = downloadUrl(url);
		if (content == null) {
			logger.error("Aggiornamento variabili FALLITO");
			logInternoLocalService.log("rt_data","Aggiornamento variabili","FALLITO, rt_data non raggiungibile","");
			return;
		}

		//Map<String, Object> map[] = new Map[0];
		//andcop - errore di cast Map to ArrayList
		ArrayList<Object> map = new ArrayList<Object>();
		map = deserialize(content, map.getClass()); //, map.getClass());

		for (int k = 0; k < map.size(); k++) {
			
			String id = null;

			try {

				Map<String, Object> o = (Map<String, Object>) map.get(k);
				Variabile s = null;

				id = (String) o.get("id");
				if (id == null || id.equals(""))
					continue;

				try {
					s = VariabileLocalServiceUtil.getVariabile(id);
				} catch (SystemException e) {

				} catch (PortalException e2) {
					s = VariabileLocalServiceUtil.createVariabile(id);
					logger.info("Creata variabile "+id);
					logInternoLocalService.log("rt_data","Creazione nuova variabile",id,"");
				}

				if (s == null)
					continue;

				if (o.get("level_t1") != null)
					s.setLevel_t1((int) Double.parseDouble(o.get("level_t1").toString()));
				if (o.get("level_t2") != null)
					s.setLevel_t2((int) Double.parseDouble(o.get("level_t2").toString()));
				if (o.get("level_v1") != null)
					s.setLevel_v1((int) Double.parseDouble(o.get("level_v1").toString()));
				if (o.get("level_v2") != null)
					s.setLevel_v2((int) Double.parseDouble(o.get("level_v2").toString()));
				if (o.get("trange_p1") != null)
					s.setTrange_p1((int) Double.parseDouble(o.get("trange_p1").toString()));
				if (o.get("trange_p2") != null)
					s.setTrange_p2((int) Double.parseDouble(o.get("trange_p2").toString()));
				if (o.get("trange_pind") != null)
					s.setTrange_pind((int) Double.parseDouble(o.get("trange_pind").toString()));

				if (o.get("unit") != null)
					s.setUnit(o.get("unit").toString());
				if (o.get("bcode") != null)
					s.setBcode(o.get("bcode").toString());
				if (o.get("description_it") != null)
					s.setDescription_it(o.get("description_it").toString());

				VariabileLocalServiceUtil.updateVariabile(s);

			} catch (Exception e) {
				logger.error(e);
				//logInternoLocalService.log("caricaDbTask.aggiornaVariabili", id, e, null);

			}

		}

	}

	public void aggiornaSensori() {

		String url = "https://simc.arpae.it/meteozen/rt_data/api/v2/sensors/";
		//String report ="";

		try {

			List<Variabile> var = VariabileLocalServiceUtil.getVariabiles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (Variabile v : var) {
				
				String nomeVar=null;

				try {

					nomeVar = v.getId();
					String url2 = url + nomeVar;
					// logger.info(url2);

					String content = downloadUrl(url2);
					if (content == null) {
						logInternoLocalService.log("rt_data","Aggiornamento elenco sensori per variabile","Fallito per "+nomeVar+", rt_data non raggiungibile","");
						logger.info("Aggiornamento stazione_variabile fallito per "+nomeVar);
						// logger.info("URL NULL" );
						continue;
					}

					DynamicQuery dyn = stazioneVariabileLocalService.dynamicQuery()
							.add(PropertyFactoryUtil.forName("idVariabile").eq(nomeVar));
					List<StazioneVariabile> sv = StazioneVariabileLocalServiceUtil.dynamicQuery(dyn);
					// List<StazioneVariabile> sv =
					// StazioneVariabileUtil.findByVariabile(nomeVar);

					
					//Map<String, Object> map[] = new Map[0];
					//andcop - errore di cast Map to ArrayList
					ArrayList<Object> map = new ArrayList<Object>();
					map = deserialize(content, map.getClass()); //, map.getClass());

					for (int k = 0; k < map.size(); k++) {
						
						String station = null;

						try {

							Map<String, Object> o = (Map<String, Object>) map.get(k);
							StazioneVariabile s = null;
							station = (String) o.get("station");
							if (station == null || station.equals(""))
								continue;

							for (StazioneVariabile vv : sv) {
								if (vv.getIdStazione().equals(station)) {
									s = vv;
									break;
								}
							}

							if (s == null) {
								s = StazioneVariabileLocalServiceUtil.createStazioneVariabile(0);
								s.setIdVariabile(nomeVar);
								s.setIdStazione(station);
								logInternoLocalService.log("rt_data","Aggiunta sensore","Stazione "+station+", variabile "+nomeVar,"");
							}
							
							//report+=station+"_"+nomeVar;

							Map<String, Object> sensor = (Map<String, Object>) o.get("sensor");
							if (sensor != null) {
								//report+="_sensor";
								Map<String, Object> hydro = (Map<String, Object>) sensor.get("hydroinfo");
								if (hydro != null) {
									//report+="_hydro";
									Object order = hydro.get("stream_order");
									if (order != null) {
										//report+="_stream";
										String oo = order.toString();
										if (oo.length() == 1) {
											//report+="_length1_"+oo.toString();
											/*Stazione staz = StazioneLocalServiceUtil.fetchStazione(station);
											if (staz != null) {
												staz.setProgressivo(0);
												StazioneLocalServiceUtil.updateStazione(staz);
											}*/
										} else {
											//report+="_"+oo.toString();
											int l = Integer.parseInt(oo);
											Stazione staz = StazioneLocalServiceUtil.fetchStazione(station);
											if (staz != null) {
												staz.setProgressivo(l);
												StazioneLocalServiceUtil.updateStazione(staz);
											}
										}
									}
									List<Object> thresholds = (List<Object>) hydro.get("thresholds");
									if (thresholds != null) {
										boolean modificaSoglia = false;
										double soglia = 0.0;
										
										if (thresholds.size() > 0 && thresholds.get(0) != null) {
											soglia = Double.parseDouble(thresholds.get(0).toString());
											if (soglia!=s.getSoglia1()) modificaSoglia = true;
											s.setSoglia1(soglia);
										}
										if (thresholds.size() > 1 && thresholds.get(1) != null) {
											soglia = Double.parseDouble(thresholds.get(1).toString());
											if (soglia!=s.getSoglia2()) modificaSoglia = true;
											s.setSoglia2(soglia);
										}
										if (thresholds.size() > 2 && thresholds.get(2) != null) {
											soglia = Double.parseDouble(thresholds.get(2).toString());
											if (soglia!=s.getSoglia3()) modificaSoglia = true;
											s.setSoglia3(soglia);
										}
										if (modificaSoglia) {
											logInternoLocalService.log("rt_data","Modifica soglie sensore",
													s.getIdStazione()+" "+nomeVar+" -> "+s.getSoglia1()+","+s.getSoglia2()+","
															+s.getSoglia3(),"");
											logger.info("Modifica soglie sensore "+s.getIdStazione());
											
										}
									}
								}
							}

							StazioneVariabileLocalServiceUtil.updateStazioneVariabile(s);
							//report+="\n";

						} catch (Exception e) {
							logger.error(e);
							//logInternoLocalService.log("caricaDbTask.aggiornaSensori", station+","+nomeVar, e, null);

						}
					}
				} catch (Exception e) {
					logger.error(e);
					//logInternoLocalService.log("caricaDbTask.aggiornaSensori", nomeVar, e, null);
				}
			}
			
			//logInternoLocalService.log("caricaDbTask.aggiornaSensori", "finish", report, null);

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask.aggiornaSensori", null, e, null);

		}

	}

	public boolean aggiornaValoriSuperficiale(String var, String nomeVar, StringBuilder out) {

		boolean aggiornato = false;
		List listaBuchi = null;
		int creati = 0;
		//https://simc.arpae.it/meteozen/rt_data/api/v2/lastdatetime/ /www.smr.arpa.emr.it
		String url = "http://simc.arpae.it/meteozen/rt_data/api/v2/lastdatetime/" + var;
		String content = downloadUrl(url);
		if (content == null) {
			//logInternoLocalService.log("rt_data","Scaricamento valori sensori","Fallito per variabile "+var+", rt_data non raggiungibile","");
			logger.info("Aggiornamento valori sensori fallito per "+var);
			// logger.info("URL NULL" );
			return false;
		}

		// logger.info(content);

		SimpleDateFormat atom = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

		//Map<String, Object> map[] = new Map[0];
		//andcop - errore di cast Map to ArrayList
		ArrayList<Object> map = new ArrayList<Object>();
		map = deserialize(content, map.getClass()); //, map.getClass());
		
		for (int k = 0; k < map.size(); k++) {
			
			String stazione = null;

			try {

				Map<String, Object> o = (Map<String, Object>) map.get(k);
				ValoreSensore s = null;

				String data = (String) o.get("datetime");
				stazione = (String) o.get("station");
				if (data == null)
					continue;

				Date dt = atom.parse(data);

				Date dt2 = getDataAggiornamentoStazioneVariabile(stazione, var);

				if (dt2 == null || dt.after(dt2)) {
					creaUltimoValoreSensore(stazione, var);
					aggiornato = true;
					creati++;
				}

			} catch (Exception ex) {
				logger.error(ex);
				//logInternoLocalService.log("caricaDbTask.aggiornaValoriSuperficiale", stazione+","+var, ex, null);

			}

		}
		
		if (var.contains("900/") || var.contains("B13215")) listaBuchi = stazioniConBuchi(var,"15 minutes","12 hours");
		if (var.contains("1800/")) listaBuchi = stazioniConBuchi(var,"30 minutes","1 day");
		if (var.contains("3600/")) listaBuchi = stazioniConBuchi(var,"1 hour","1 day");
		
		int prima,dopo;
		int tappati = 0;
		prima = 0;
		dopo = 0;
		if (listaBuchi!=null) {
			prima = listaBuchi.size();
			for (Object o : listaBuchi) {
				String id = "";
				if (o instanceof Object[]) id = (String) ((Object[])o)[0];
				else id = (String)o;
				try {
					tappati += aggiornaValori(var, id);
				} catch (Exception e) {
					logger.error(e);
					//logInternoLocalService.log("caricaDbTask.aggiornaValoriSuperficiale",id+" prof "+var,e,null);
				}
			}
		}
		
		if (var.contains("900/") || var.contains("B13215")) listaBuchi = stazioniConBuchi(var,"15 minutes","12 hours");
		if (var.contains("1800/")) listaBuchi = stazioniConBuchi(var,"30 minutes","1 day");
		if (var.contains("3600/")) listaBuchi = stazioniConBuchi(var,"1 hour","1 day");
		
		if (listaBuchi!=null) dopo = listaBuchi.size();
		
		//if (prima!=0) logInternoLocalService.log("caricaDbTask.aggiornaValoriSup_profondo",var,""+prima+"/"+dopo,null);
		String s = "Var. "+nomeVar+": "+creati+
				" ultimi e "+tappati+" precedenti; ";
		out.append(s);
		//if (creati>0 || tappati>0) logInternoLocalService.log("rt_data","Scaricamento ultimi dati sensori",s,"");
		logger.info(s);
		return aggiornato;

	}

	public Date getDataAggiornamentoStazioneVariabile(String stazione, String variabile) {

		try {
			DynamicQuery varStaz = valoreSensoreLocalService.dynamicQuery()
					.add(PropertyFactoryUtil.forName("idStazione").eq(stazione))
					.add(PropertyFactoryUtil.forName("idVariabile").eq(variabile))
					.addOrder(OrderFactoryUtil.desc("datetime"));
			List<ValoreSensore> vs = ValoreSensoreLocalServiceUtil.dynamicQuery(varStaz,0,1);

			if (vs != null && vs.size() > 0)
				return vs.get(0).getDatetime();
			else
				return null;

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask.getDataAggiornamentoStazioneVariabile", stazione+","+variabile, e, null);
			return null;
		}
	}

	public void creaUltimoValoreSensore(String stazione, String variabile) {

		String datetime = "";
		String content = "";

		try {
			String url = "https://simc.arpae.it/meteozen/rt_data/api/v2/lastdata/" + stazione + "/" + variabile;

			content = downloadUrl(url);
			if (content == null) {
				logger.error("creaUltimoValoreSensore fallito: "+url);
				return;
			}

			SimpleDateFormat atom = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

			Map<String, Object> map = new HashMap<String, Object>();
			map = deserialize(content, map.getClass()); //, map.getClass());
			
			// for (int k=0; k<map.length; k++) {

			Map<String, Object> o = map;
			//ValoreSensore s = null;

			datetime = (String) o.get("datetime");
			Double value = 0.0;

			try {
				value = Double.parseDouble(o.get("value").toString());
			} catch (Exception e) {
				logger.error(e);
				//logInternoLocalService.log("caricaDbTask", "creaUltimoValoreSensore", e, "");			
			}

			if (atom.parse(datetime).after(new Date())) {
				logger.info("Sensore ha restituito data futura:" + content + " data: " + datetime);
				return; // dato nel futuro, sensore sballato...
			}

			ValoreSensore vs = ValoreSensoreLocalServiceUtil.createValoreSensore(0);

			try {
				vs.setDatetime(atom.parse(datetime));
			} catch (Exception e) {
				logger.error(e);
				return;
			}
			vs.setIdStazione(stazione);
			vs.setIdVariabile(variabile);
			vs.setValue(value);

			ValoreSensoreLocalServiceUtil.updateValoreSensore(vs);

			// aggiorno la data ultimo rilevamento di questa variabile
			DynamicQuery varStaz = stazioneVariabileLocalService.dynamicQuery()
					.add(PropertyFactoryUtil.forName("idStazione").eq(stazione))
					.add(PropertyFactoryUtil.forName("idVariabile").eq(variabile));
			
			List<StazioneVariabile> stazVar = StazioneVariabileLocalServiceUtil.dynamicQuery(varStaz);
			
			if (stazVar != null && stazVar.size() > 0) {
			
				stazVar.get(0).setDataUltimoValore(atom.parse(datetime));
				StazioneVariabileLocalServiceUtil.updateStazioneVariabile(stazVar.get(0));
			}

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask", "creaUltimoValoreSensore", e, "");			
		}

		// }

	}

	public int aggiornaValori(String var, String stazione) throws Exception {

		SimpleDateFormat atomShort = new SimpleDateFormat("yyyy-MM-dd");

		Calendar c = Calendar.getInstance(Locale.ITALY);
		SimpleDateFormat atom = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

		String oggi = atomShort.format(c.getTime());
		
		int creati = 0;

		c.add(Calendar.HOUR, -120);

		String prima = atomShort.format(c.getTime());

		String url = "https://simc.arpae.it/meteozen/rt_data/api/v2/timeseries/" + stazione + "/" + var + "/"
				+ prima + "/" + oggi;
		String content = downloadUrl(url);
		if (content == null) {
			// logger.info("URL NULL");
			logger.error("Fallito scaricamento valore sensore "+stazione);
			return 0;
		}

		DynamicQuery dyn = valoreSensoreLocalService.dynamicQuery()
													.add(PropertyFactoryUtil.forName("idVariabile").eq(var))
													.add(PropertyFactoryUtil.forName("idStazione").eq(stazione));
		
		List<ValoreSensore> sv = ValoreSensoreLocalServiceUtil.dynamicQuery(dyn);
		// List<StazioneVariabile> sv =
		// StazioneVariabileUtil.findByVariabile(nomeVar);
		List<ValoreSensore> sv2 = new ArrayList<ValoreSensore>();
		for (ValoreSensore vv : sv)
			sv2.add(vv);

		
		//Map<String, Object> map[] = new Map[0];
		//andcop - errore di Cast Map to ArrayList
		ArrayList<Object> map = new ArrayList<Object>();

		map = deserialize(content, map.getClass()); //, map.getClass());
		
		for (int k = 0; k < map.size(); k++) {

			Map<String, Object> o = (Map<String, Object>) map.get(k);
			ValoreSensore s = null;

			String data = (String) o.get("t");
			if (data == null)
				continue;

			if (o.get("v") == null)
				continue;

			Date dt = atom.parse(data);

			for (ValoreSensore vs : sv) {
				if (vs.getDatetime().getTime() == dt.getTime()) {
					s = vs;
					sv2.remove(vs);
					break;
				}
			}

			if (s == null) {
			
				s = ValoreSensoreLocalServiceUtil.createValoreSensore(0);
				s.setIdStazione(stazione);
				s.setIdVariabile(var);
				s.setDatetime(dt);
				s.setValue(Double.parseDouble(o.get("v").toString()));
				ValoreSensoreLocalServiceUtil.updateValoreSensore(s);
				creati++;
				
			} else {
				double dd = Double.parseDouble(o.get("v").toString());
				if (dd != s.getValue()) {
					s.setValue(dd);
					ValoreSensoreLocalServiceUtil.updateValoreSensore(s);
				}
			}

		}

		// cancella quelli che non compaiono
		for (ValoreSensore ss : sv2) {
			try {
				ValoreSensoreLocalServiceUtil.deleteValoreSensore(ss);
			} catch (Exception e) {
				logger.error(e);
			}
		}
		
		return creati;

	}

	public void aggiornaValori() {

		try {

			List<StazioneVariabile> sv = StazioneVariabileLocalServiceUtil.getStazioneVariabiles(QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
			
			List<Stazione> st = StazioneLocalServiceUtil.getStaziones(QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
			Map<String,Stazione> mappaStazioni = new HashMap<String, Stazione>();
			for (Stazione s : st) mappaStazioni.put(s.getId(), s);

			//Questi valori sono quelli definiti in am.map-data-server, senza gli OR non si vedono i dati...grazie per avermelo detto
			for (StazioneVariabile s : sv) {

				if (	s.getIdVariabile().contains("B13011") || //precipitazioni
						s.getIdVariabile().contains("B13215") || //idrometrico
						s.getIdVariabile().contains("B10004") || //pressione
						s.getIdVariabile().contains("B13003") || //umidita
						s.getIdVariabile().contains("B12101") || //temperature
						s.getIdVariabile().contains("B11002") || //vento
						s.getIdVariabile().contains("B11001") 	 //direzionevento
						
					) {
					
					Stazione datiStazione = mappaStazioni.get(s.getIdStazione());
					if (datiStazione!=null && datiStazione.getAttivo())
						aggiornaValori(s.getIdVariabile(), s.getIdStazione());
				}

			}

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask", "aggiornaValori", e, "");			

		}

	}

	public void regoleAllarme() {

		try {
			
			boolean oraLegale = TimeZone.getDefault().inDaylightTime( new Date() );

			List<Company> comp = companyLocalService.getCompanies();
			Company company = (comp != null && comp.size() > 0 ? comp.get(0) : null);

			boolean monitoraggioAttivo = false;
			//boolean debugMode = false;
			long cutoffTime = new Date().getTime() - 6*3600*1000; //ora attuale meno 6 ore

			BollettinoParametro bp = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("GESTIONE_MONITORAGGIO");
			monitoraggioAttivo = (bp != null && bp.getValore() != null && bp.getValore().toLowerCase().equals("true"));

			List<RegolaAllarme> regole = RegolaAllarmeLocalServiceUtil.getRegolaAllarmes(QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
			List<RegolaAllarme> regoleSoddisfatte = new ArrayList<RegolaAllarme>();
			List<RegolaAllarme> regoleSoddisfattePioggia = new ArrayList<RegolaAllarme>();
			
			List<String> spikeIdrometri = BollettinoLocalServiceUtil.eseguiQueryGenericaLista("select idstazione from spike_idrometri");
			List<Object[]> spikeIdrometriFull = BollettinoLocalServiceUtil.eseguiQueryGenericaLista("select * from spike_idrometri");
			
			for (Object[] sp : spikeIdrometriFull) {
				String s = (String)sp[1];
				String nom = (String)(sp[0]!=null?sp[0]:"");
				double soglia = Double.parseDouble(sp[6].toString());
				double delta = Double.parseDouble(sp[5].toString());
				//logInternoLocalService.log("caricaDbTask", "SPIKE", s, "");
				
				Date d = getDataAggiornamentoStazioneVariabile(s,"254,0,0/1,-,-,-/B13215");
				if (d==null) continue;
				String dd = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(d);
				String sescape = nom.replaceAll("'", "''");
				
				logger.info("Spike: "+s+" "+nom);

				String query = "select * from allerter_logspike where idstazione='" + s+"' and idvariabile='254,0,0/1,-,-,-/B13215' and dataora='"+dd+"'";
				List<Object[]> l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(query);
				if (l==null) continue;
				if (l.size()>0) continue;
				query = "insert into allerter_logspike (idstazione,dataora,idvariabile,nomestazione,valore) values ('"+
				s+"','"+dd+"','254,0,0/1,-,-,-/B13215','"+sescape+"',"+delta+")";
				
				BollettinoLocalServiceUtil.eseguiQueryGenericaLista(query);
				if (monitoraggioAttivo) {
					logInternoLocalService.log("rt_data","Spike rilevato",s+" ("+nom+") -> "+delta+"m","");
					notificaSpike(s,nom,d,delta,soglia);
				}
			}


			
			List<String> idroDisattivati = BollettinoLocalServiceUtil.eseguiQueryGenericaLista("select idstazione from bollettino_disattivazionesensore where idvariabile='254,0,0/1,-,-,-/B13215'");
			List<String> pluvioDisattivati = BollettinoLocalServiceUtil.eseguiQueryGenericaLista("select idstazione from bollettino_disattivazionesensore where idvariabile like '%B13011'");
			
			//elenco di tutte le condizioni superate; se una regola non compare qui, non può essere superata
			List<Object[]> condizioniSuperate = BollettinoLocalServiceUtil.eseguiQueryGenericaLista("select idregola, nome, idcondizione, lettera, soglia, idstazione, soglia1, soglia2, soglia3, v1, v2, v3 from vw_stato_regole where superata");
			HashMap<Long,Boolean> regoleDaControllare = new HashMap<Long, Boolean>();
			HashMap<Long,Object[]> mappaCondizioni = new HashMap<Long, Object[]>();
			for (Object[] ob : condizioniSuperate) {
				Long l = Long.parseLong(ob[0].toString());
				Long cond = Long.parseLong(ob[2].toString());
				regoleDaControllare.put(l, true);
				mappaCondizioni.put(cond, ob);
			}
			
			logger.info("controllo "+regoleDaControllare.size()+" regole su "+regole.size()+", disattivati "+idroDisattivati.size()+" idrometri e "+pluvioDisattivati.size()+" pluviometri.");
			
			for (RegolaAllarme r : regole) {
				
				try {
					
					if (!regoleDaControllare.containsKey(r.getId())) continue;
					
					//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Inizio regola "+r.getNome(), "");

					if (!r.getAttivo()) {
						//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Regola non attiva", "");
						continue;
					}

					String espressione = r.getEspressione();
					if (espressione == null || espressione.equals("")) {
						//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Espressione nulla", "");
						continue;
					}
					espressione = espressione.toLowerCase();
					// valuta l'espressione con i valori sostituiti
					espressione = espressione.replaceAll("and", "*");
					espressione = espressione.replaceAll("or", "#");
					espressione = espressione.replaceAll("not", "@");

					DynamicQuery dyn = regolaAllarmeCondizioneLocalService.dynamicQuery()
							.add(PropertyFactoryUtil.forName("idRegola").eq(r.getId()))
							.addOrder(OrderFactoryUtil.asc("id"));
					List<RegolaAllarmeCondizione> rac = RegolaAllarmeCondizioneLocalServiceUtil.dynamicQuery(dyn);

					boolean pioggia = false;
					boolean primaPioggia = false;
					if (rac!=null && rac.size()>0 && rac.get(0)!=null && rac.get(0).getIdVariabile()!=null && rac.get(0).getIdVariabile().contains("B13011"))
						primaPioggia = true;
				

					for (RegolaAllarmeCondizione c : rac) {
	
						String var = c.getIdVariabile();
						String st = c.getIdStazione();
						String id = c.getLettera();
						if (var == null || st == null || var.equals("") || st.equals("") || id == null || id.equals(""))
							continue;
						id = id.toLowerCase();
						
						Object[] datiSuperamento = mappaCondizioni.get(c.getId());
						if (datiSuperamento==null) {
							//non è stata superata
							espressione = espressione.replaceAll(id, "0");
						} else {
							espressione = espressione.replaceAll(id, "1");
						}
	
						/*Stazione t = StazioneLocalServiceUtil.getStazione(st);
					
					//disattivato lato RT_DATA?
					if (t == null || !t.getAttivo()) {
						espressione = espressione.replaceAll(id, "0");
						//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Condizione su sensore che non riceve", "");
						continue;
					}
					

					// pioggia? facciamo tutto diverso
					pioggia = false;
					if (var.contains("B13011")) {
						pioggia = true;
					}
					
					//disattivato lato portale Allerte?
					boolean disatt = false;
					List<String> disattivati = (pioggia?pluvioDisattivati:idroDisattivati);
					for (String dis : disattivati) {
						if (t.getId().equals(dis)) {
							
							disatt = true; 
						}
					}
					
					if (disatt) {
						espressione = espressione.replaceAll(id, "0");
						//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Condizione su sensore che non riceve", "");
						continue;
					}

					if (!pioggia && !monitoraggioAttivo) {
						// ignora il superamento idrometrico, dev'essere un
						// falso positivo
						espressione = espressione.replaceAll(id, "0");
						//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Condizione su idrometro ma non siamo in monitoraggio", "");
						continue;
					}
					
					if (!pioggia && spikeIdrometri.size()>0) {
						for (String s : spikeIdrometri) {
							if (s.equals(st)) {
								//SPIKE
								espressione = espressione.replaceAll(id, "0");
								//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Condizione ritenuta spike", "");
								continue;
							}
						}
					}

					DynamicQuery sens = valoreSensoreLocalService.dynamicQuery()
							.add(PropertyFactoryUtil.forName("idStazione").eq(st))
							.add(PropertyFactoryUtil.forName("idVariabile").eq(var))
							.addOrder(OrderFactoryUtil.desc("datetime"));
					List<ValoreSensore> vs = ValoreSensoreLocalServiceUtil.dynamicQuery(sens, 0, 1);
					if (vs == null || vs.size() == 0) {
						espressione = espressione.replaceAll(id, "0");
						//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Nessun valore sensore trovato", "");
						continue;
					}

					ValoreSensore val = vs.get(0);
					
					//GPF 2020-03-05 Se il valore del dato è vecchio rischiamo di
					// generare un allarme per un sensore inattivo il cui ultimo
					// valore era in superamento soglia. Limitiamo l'età del dato.
					//
					if (val.getDatetime().getTime()<cutoffTime) {
						espressione = espressione.replaceAll(id, "0");
						continue;
					}
					
					double valoreSoglia = 1000000.0;

					DynamicQuery varStaz = stazioneVariabileLocalService.dynamicQuery()
							.add(PropertyFactoryUtil.forName("idStazione").eq(st))
							.add(PropertyFactoryUtil.forName("idVariabile").eq(var));
					List<StazioneVariabile> stazVar = StazioneVariabileLocalServiceUtil.dynamicQuery(varStaz);
					if (stazVar == null || stazVar.size() == 0) {
						espressione = espressione.replace(id, "0");
						//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Nessuna stazione-variabile trovata", "");
						continue;
					}
					StazioneVariabile ssvv = stazVar.get(0);

					if (c.getSoglia() == 1)
						valoreSoglia = ssvv.getSoglia1();
					else if (c.getSoglia() == 2)
						valoreSoglia = ssvv.getSoglia2();
					else if (c.getSoglia() == 3)
						valoreSoglia = ssvv.getSoglia3();
					
					if (valoreSoglia==0.0) valoreSoglia = 1000000.0; //ignora le soglie a 0

					double valor = 0.0;

					if (pioggia && c.getSoglia() == 1) {
						double quarto = BollettinoLocalServiceUtil.getSommaValori(st, "1,0,900/1,-,-,-/B13011", 4);
						double mezzora = BollettinoLocalServiceUtil.getSommaValori(st, "1,0,1800/1,-,-,-/B13011", 2);
						double ora = BollettinoLocalServiceUtil.getSommaValori(st, "1,0,3600/1,-,-,-/B13011", 1);
						if (mezzora > ora)
							valor = mezzora;
						else
							valor = ora;
						if (quarto>valor) valor = quarto;
						
					} else if (pioggia && c.getSoglia() == 2) {
						double quarto = BollettinoLocalServiceUtil.getSommaValori(st, "1,0,900/1,-,-,-/B13011", 12);
						double mezzora = BollettinoLocalServiceUtil.getSommaValori(st, "1,0,1800/1,-,-,-/B13011", 6);
						double ora = BollettinoLocalServiceUtil.getSommaValori(st, "1,0,3600/1,-,-,-/B13011", 3);
						if (mezzora > ora)
							valor = mezzora;
						else
							valor = ora;
						
						if (quarto>valor) valor = quarto;
						
					} else if (pioggia && c.getSoglia() == 3) {
						double mezzora = BollettinoLocalServiceUtil.getSommaValori(st, "1,0,1800/1,-,-,-/B13011", 24);
						double ora = BollettinoLocalServiceUtil.getSommaValori(st, "1,0,3600/1,-,-,-/B13011", 12);
						if (mezzora > ora)
							valor = mezzora;
						else
							valor = ora;
					} else
						valor = val.getValue();
					
					//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Confronto "+valor+" con "+valoreSoglia, "");
					if (valor >= valoreSoglia) {
						// logger.info("CONFRONTO "+val.getValue()+" ->
						// "+valoreSoglia);
						espressione = espressione.replaceAll(id, "1");
					} else
						espressione = espressione.replaceAll(id, "0");
					*/
				}

				

				// logger.info("espressione "+espressione);

				//try {
					logger.info("valuto regola "+r.getId()+" ("+r.getNome()+"): "+r.getEspressione()+" -> "+espressione);
					double d = ValutatoreEspressioni.eval(espressione);
					if (d != 0.0) {
						if (primaPioggia) {
							logger.info("regola pluvio soddisfatta: "+r.getId());
							regoleSoddisfattePioggia.add(r);
							//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Regola soddisfatta pluvio: "+r.getNome(), "");
						}
						else {
							logger.info("regola idro soddisfatta: "+r.getId());
							regoleSoddisfatte.add(r);
							//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Regola soddisfatta idro: "+r.getNome(), "");
						}
					}
				} catch (Exception ex) {
					logger.error(ex);
					//logInternoLocalService.log("caricaDbTask.regoleAllarme", r.getNome(), ex, null);

					// logger.info("E432");
				}

			}

			// logger.info("Regole soddisfatte:
			// "+regoleSoddisfatte.size());
			try {
				
			// carica gli allarmi attivi per disattivarli se necessario
			DynamicQuery all = allarmeLocalService.dynamicQuery()
					.add(PropertyFactoryUtil.forName("dataFine").isNull());
			List<Allarme> allarmi = AllarmeLocalServiceUtil.dynamicQuery(all);

			Date d = new Date();
			
			for (Allarme a : allarmi) {
				boolean trovato = false;
				for (RegolaAllarme ra : regoleSoddisfatte) {
					if (ra.getId()==a.getIdRegola()) trovato = true;
				}
				for (RegolaAllarme ra : regoleSoddisfattePioggia) {
					if (ra.getId()==a.getIdRegola()) trovato = true;
				}
				if (!trovato) {
					logger.info("termino allarme "+a.getAllarmeId()+" legato a regola "+a.getIdRegola());
					//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Termina allarme "+a.getAllarmeId(), "");
					a.setDataFine(d);
					AllarmeLocalServiceUtil.updateAllarme(a);
				}
			}


			// cerca gli allarmi già collegati alle regole, per crearne di nuovi
			// dove non presenti
			for (RegolaAllarme ra : regoleSoddisfatte) {

				boolean trovato = false;

				for (Allarme a : allarmi) {
					if (ra.getId() == a.getIdRegola()) {
						trovato = true;
						break;
					}
				}

				if (!trovato) {
					
					//allarme attivo, ma la sua regola non è tra quelle soddisfatte,
					//quindi deve cessare.

					long inc = counterLocalService.increment(Allarme.class.getName());
					Allarme al = AllarmeLocalServiceUtil.createAllarme(inc);
					al.setColore(ra.getColore());
					al.setGroupId(0);
					// al.setGroupId(comune.getIdComune());
					al.setCompanyId(company.getCompanyId());
					Date o = (Date)BollettinoLocalServiceUtil.eseguiQueryGenerica("select max(dataultimovalore) from bollettino_stazionevariabile where idvariabile like '%B13215%' and idstazione = (select idstazione from bollettino_regolaallarmecondizione rac where idregola = "+
							ra.getId()+" and id_ = (select min(id_) from bollettino_regolaallarmecondizione rac2 where rac.idregola = rac2.idregola))");
					
					if (o!=null) al.setCreateDate(new Date(o.getTime()+(oraLegale?7200000:3600000)));
					al.setIdRegola(ra.getId());
					al.setStato(WorkflowConstants.STATUS_PENDING);

					AllarmeLocalServiceUtil.updateAllarme(al);
					
					logger.info("creo allarme idro "+al.getAllarmeId()+": regola "+ra.getId()+" - "+ra.getNome());
					logInternoLocalService.log("superamenti", "Nuovo superamento idrometrico", ra.getNome(), "");

					assetEntryLocalService.updateEntry(0, 20194, Allarme.class.getName(), al.getAllarmeId(),
							new long[] {}, new String[] {});
					
					try {
						AssetEntry ae = assetEntryLocalService.fetchEntry(Allarme.class.getName(), al.getAllarmeId());
						if (ae!=null) {
							String data = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()); 
							ae.setTitle("Superamento regola "+ra.getNome()+" del "+data);
							ae.setCreateDate(new Date());
							ae.setModifiedDate(new Date());
							ae.setDescription("Superamento regola "+ra.getNome()+" del "+data);
							ae.setSummary("Superamento regola "+ra.getNome()+" del "+data);
							assetEntryLocalService.updateAssetEntry(ae);
						}
					} catch (Exception exx) {
						logger.error(exx);
					}

					WorkflowDefinitionLink workflowDefinitionLink = null;
					try {
						workflowDefinitionLink = workflowDefinitionLinkLocalService
								.getDefaultWorkflowDefinitionLink(company.getCompanyId(), Allarme.class.getName(), 0,
										0);

						ServiceContext sc = new ServiceContext();
						sc.setScopeGroupId(al.getGroupId());
						// start workflow instance to feedback.
						if (workflowDefinitionLink != null)
							WorkflowHandlerRegistryUtil.startWorkflowInstance(company.getCompanyId(), al.getGroupId(),
									0, Allarme.class.getName(), al.getPrimaryKey(), al, sc);

					} catch (Exception ex) {
						logger.error(ex);

					}

				}
			}

			// le regole pluviometriche non seguono il workflow e vengono auto
			// approvate
			for (RegolaAllarme ra : regoleSoddisfattePioggia) {
				
				//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Esamino regola soddisfatta pluvio: "+ra.getNome(), "");

				boolean trovato = false;

				for (Allarme a : allarmi) {
					if (ra.getId() == a.getIdRegola()) {
						trovato = true;
						break;
					}
				}

				if (!trovato) {

					// crea un allarme per ogni comune/gruppo destinatario
					//DynamicQuery com = DynamicQueryFactoryUtil.forClass(RegolaAllarmeComune.class)
						//	.add(PropertyFactoryUtil.forName("idRegola").eq(ra.getId()));
					//List<RegolaAllarmeComune> comuni = RegolaAllarmeComuneLocalServiceUtil.dynamicQuery(com);

					//for (RegolaAllarmeComune comune : comuni) {

						long inc = counterLocalService.increment(Allarme.class.getName());
						Allarme al = AllarmeLocalServiceUtil.createAllarme(inc);
						al.setColore(ra.getColore());
						al.setGroupId(0);
						al.setCompanyId(company.getCompanyId());
						
						Date o = (Date)BollettinoLocalServiceUtil.eseguiQueryGenerica("select max(dataultimovalore) from bollettino_stazionevariabile where idvariabile like '%B13011%' and idstazione = (select idstazione from bollettino_regolaallarmecondizione rac where idregola = "+
								ra.getId()+" and id_ = (select min(id_) from bollettino_regolaallarmecondizione rac2 where rac.idregola = rac2.idregola))");
						
						if (o!=null) al.setCreateDate(new Date(o.getTime()+(oraLegale?7200000:3600000)));
						al.setIdRegola(ra.getId());
						al.setStato(WorkflowConstants.STATUS_PENDING);
						
						logger.info("creo allarme pluvio "+al.getAllarmeId()+": regola "+ra.getId()+" - "+ra.getNome());
						logInternoLocalService.log("superamenti", "Nuovo superamento pluviometrico", ra.getNome(), "");

						AllarmeLocalServiceUtil.updateAllarme(al);

						assetEntryLocalService.updateEntry(0, 20194, Allarme.class.getName(),
								al.getAllarmeId(), new long[] {}, new String[] {});


						
						try {
							WorkflowDefinitionLink workflowDefinitionLink = null;
							workflowDefinitionLink = workflowDefinitionLinkLocalService
									.getDefaultWorkflowDefinitionLink(company.getCompanyId(), Allarme.class.getName(), 0,
											0);

							ServiceContext sc = new ServiceContext();
							sc.setScopeGroupId(al.getGroupId());
							// start workflow instance to feedback.
							if (workflowDefinitionLink != null)
								WorkflowHandlerRegistryUtil.startWorkflowInstance(company.getCompanyId(), al.getGroupId(),
										0, Allarme.class.getName(), al.getPrimaryKey(), al, sc);

						} catch (Exception ex) {
							logger.error(ex);
							//logInternoLocalService.log("caricaDbTask.regoleAllarme", ""+al.getAllarmeId(), ex, "");

						}

					//}

				}
			}

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask.regoleAllarme", "", e, "");
			// logger.info("E1234");
		}
			
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask.regoleAllarme", "", e, "");

		}

	}

	private void notificaSpike(String s, String nom, Date d, double delta, double soglia) {
		// TODO Auto-generated method stub
		try {
			long ts = new Date().getTime();
			DecimalFormat df = new DecimalFormat("#.##");
		String ora = new SimpleDateFormat("HH:mm").format(d);
		String sms = "Attenzione: rilevato spike ("+df.format(delta )+" metri, soglia "+df.format(soglia )+" metri) su "+nom+" alle ore "+ora+". Non viene considerato superamento.";
		long org = 0;
		
			long canale[] = new long[1];
			//canale[0] = 1; //solo email
			smsLocalService.creaNotificaGruppoRubrica(null, "AllerteER", "", "spike", s, ts, 20181, "Rubrica spike", true, null);
			//smsLocalService.creaSMSOrganization("AllerteER", sms, "spike", s, ts, org);
			smsLocalService.eliminaDuplicati("spike", s, ts);
			smsLocalService.eliminaDuplicatiEmail("spike", s, ts);
			smsLocalService.inviaSMS("spike", s, ts);
			smsLocalService.inviaEmail("spike", s, ts,
					"Portale Web allerte: spike "+nom, sms, "no-reply@regione.emilia-romagna.it");
			
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask.notificaSpike", "", e, "");
			return;
		}
		
	}
	
	private String downloadUrl(String url) {
		
		try {

			URL u = new URL(url);

			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(60000);
			
			//logger.info("Request URL ... " + url);
			
			if (u.getUserInfo() != null) {
				String basicAuth = "Basic " + new String(new Base64().encode(u.getUserInfo().getBytes()));
				conn.setRequestProperty("Authorization", basicAuth);
			}
			
			boolean redirectRequest = false;

			int status = conn.getResponseCode();
			
			if (status != HttpURLConnection.HTTP_OK) {
				
				if (status == HttpURLConnection.HTTP_MOVED_TEMP
					|| status == HttpURLConnection.HTTP_MOVED_PERM
						|| status == HttpURLConnection.HTTP_SEE_OTHER)
					
					redirectRequest = true;
			}

			if (redirectRequest) {

				String newUrl = conn.getHeaderField("Location");
				conn.setConnectTimeout(30000);
				conn.setReadTimeout(60000);
				
				//logger.info("Redirect to URL : " + newUrl);
				conn = (HttpURLConnection) new URL(newUrl).openConnection();
			}

			BufferedReader in = new BufferedReader(
		                              new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			return content.toString();
						
		}
		catch (FileNotFoundException f) {
			logger.error("Error 404: "+url);
			return null;
		}
		catch (Exception e) {
			logger.error(e);
			logInternoLocalService.log("Scaricamento ultimi dati sensori","Impossibile scaricare "+url, e, null);
			return null;
		}
	}
	
	private String downloadUrlPublic(String url) {
		
		try {

			URL u = new URL(url);

			HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(60000);
			
			//logger.info("Request URL ... " + url);
			
			/*if (u.getUserInfo() != null) {
				String basicAuth = "Basic " + new String(new Base64().encode(u.getUserInfo().getBytes()));
				conn.setRequestProperty("Authorization", basicAuth);
			}*/
			
			boolean redirectRequest = false;

			int status = conn.getResponseCode();
			
			if (status != HttpURLConnection.HTTP_OK) {
				
				if (status == HttpURLConnection.HTTP_MOVED_TEMP
					|| status == HttpURLConnection.HTTP_MOVED_PERM
						|| status == HttpURLConnection.HTTP_SEE_OTHER)
					
					redirectRequest = true;
			}

			if (redirectRequest) {

				String newUrl = conn.getHeaderField("Location");
				conn.setConnectTimeout(30000);
				conn.setReadTimeout(60000);
				
				//logger.info("Redirect to URL : " + newUrl);
				conn = (HttpURLConnection) new URL(newUrl).openConnection();
			}

			BufferedReader in = new BufferedReader(
		                              new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

			return content.toString();
						
		}
		catch (FileNotFoundException f) {
			logger.error("Error 404: "+url);
			return null;
		}
		catch (Exception e) {
			logger.error(e);
			logInternoLocalService.log("Download URL","Impossibile scaricare "+url, e, null);
			return null;
		}
	}

	private String downloadUrl_old(String url) {

		try {

			URL u = new URL(url);

			URLConnection con = u.openConnection();

			if (u.getUserInfo() != null) {
				String basicAuth = "Basic " + new String(new Base64().encode(u.getUserInfo().getBytes()));
				con.setRequestProperty("Authorization", basicAuth);
			}
			
			con.setConnectTimeout(30000);
			con.setReadTimeout(60000);

			Scanner s = new Scanner(con.getInputStream(), "UTF-8");
			
			s.useDelimiter("\\A");
			String str = (s.hasNext() ? s.next() : null);
			s.close();
			return str;
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask.downloadUrl", url, e, null);
			return null;
		}
	}

	private byte[] downloadUrlBinary(String url) {

		try {

			URL u = new URL(url);

			URLConnection con = u.openConnection();

			if (u.getUserInfo() != null) {
				String basicAuth = "Basic " + new String(new Base64().encode(u.getUserInfo().getBytes()));
				con.setRequestProperty("Authorization", basicAuth);
			}
			
			con.setConnectTimeout(30000);
			con.setReadTimeout(60000);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			StreamUtil.transfer(con.getInputStream(), baos);
			
			return baos.toByteArray();
			

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask.downloadUrlBinary", url, e, null);
			return null;
		}
	}

	public static void main(String... strings) throws Exception {
		new CaricaDBTask().aggiornaSensori();
	}
	
	/**
	 * Controlla l'eventuale accensione della mappa di monitoraggio quando
	 * non si è in corso di allerta idrogeologica. In questo caso usa una
	 * vista che controlla il superamento di soglia 1 in un idrometro a cui
	 * si abbina un superamento soglia 3 di un pluviometro ad esso associato.
	 */
	public void controlloPioggiaMonitoraggioFuoriAllerta() {
		
		String idrometro = "";
		String pluviometro = "";
		
		BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GESTIONE_MONITORAGGIO");
		if (bp!=null && bp.getValore()!=null && bp.getValore().equals("true")) return;
		
				
		String query1 = "select * from vw_attivazione_monitoraggio";
		List<Object[]> l = BollettinoLocalServiceUtil.eseguiQueryGenericaLista(query1);
		
		logInternoLocalService.log("monitoraggio","controlloPioggiaMonitoraggioFuoriAllerta","Query monitoraggio risultati: "+(l!=null?l.size():0),"");

		
		if (l==null || l.size()==0) return;
		
		
		
		String testo = "Accensione mappa monitoraggio causata da idrometro %IDRO% e pluviometro %PLUVIO%";
		String testoMail = "Si comunica l'accensione automatica della mappa di monitoraggio causata dall'idrometro "+
		"%IDRO% sopra soglia 1 a %VALOREIDRO% m e dal pluviometro %PLUVIO% con cumulata a 12 ore pari a %VALOREPLUVIO% mm";
		
		Object[] o = l.get(0);
		if (o!=null) {
			idrometro = (o[1]!=null?o[1].toString():"");
			String sogliaIdro = (o[2]!=null?o[2].toString():"");
			String valoreIdro = (o[3]!=null?o[3].toString():"");
			pluviometro = (o[4]!=null?o[4].toString():"");
			String sogliaPluvio = (o[5]!=null?o[5].toString():"");
			String valorePluvio = (o[6]!=null?o[6].toString():"");
			
			testo = testo.replaceAll("%IDRO%", idrometro);
			testo = testo.replaceAll("%SOGLIAIDRO%", sogliaIdro);
			testo = testo.replaceAll("%VALOREIDRO%", valoreIdro);
			testo = testo.replaceAll("%PLUVIO%", pluviometro);
			testo = testo.replaceAll("%SOGLIAPLUVIO%", sogliaPluvio);
			testo = testo.replaceAll("%VALOREPLUVIO%", valorePluvio);
			
			testoMail = testoMail.replaceAll("%IDRO%", idrometro);
			testoMail = testoMail.replaceAll("%SOGLIAIDRO%", sogliaIdro);
			testoMail = testoMail.replaceAll("%VALOREIDRO%", valoreIdro);
			testoMail = testoMail.replaceAll("%PLUVIO%", pluviometro);
			testoMail = testoMail.replaceAll("%SOGLIAPLUVIO%", sogliaPluvio);
			testoMail = testoMail.replaceAll("%VALOREPLUVIO%", valorePluvio);
		}
		
		BollettinoParametro gruppo = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GRUPPO_ACCENSIONE_MAPPA");
		if (gruppo!=null) {
			try {
				
				
				
				long ts = new Date().getTime();
				long canaleMail[] = new long[1];
				canaleMail[0] = 1;
				smsLocalService.creaNotificaGruppoRubrica(canaleMail, "AllerteER", testo, "automatismo", "monitoraggio", ts, 20181, gruppo.getValore(), true, null);
				smsLocalService.eliminaDuplicatiEmail("automatismo", "monitoraggio", ts);
				smsLocalService.inviaEmail("automatismo", "monitoraggio", ts,
						testo, testoMail, "no-reply@regione.emilia-romagna.it");
							} catch (Exception e) {
				logger.error(e);
			}
		}

		//commentato, per ora notifichiamo ma non attiviamo
		
		bp.setValore("true");
		BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);
		logInternoLocalService.log("monitoraggio","Attivazione monitoraggio","Stato di monitoraggio fuori allerta attivato: "+idrometro+"+"+pluviometro,"");
		
	}
	
	public void controlloPioggiaMonitoraggio() {
		
		String query1 = "select count(*) from allerter_allerta a where a.datafine > current_timestamp and a.stato = 0 and exists (select * from allerter_allertastato s where "+
				" s.allertaid = a.allertaid and s.eventoid<4 and s.statoid in (1,2,3))";
		//String query2 = "select max(value) from bollettino_valoresensore v join bollettino_stazionevariabile sv on v.idstazione = sv.idstazione and v.idvariabile = sv.idvariabile  where v.datetime=sv.dataultimovalore and v.idvariabile in ('1,0,3600/1,-,-,-/B13011','1,0,1800/1,-,-,-/B13011','1,0,900/1,-,-,-/B13011')";
		String query2 = "select greatest((select max(value) from bollettino_valoresensore v  " + 
				"join bollettino_stazionevariabile sv on v.idstazione = sv.idstazione  " + 
				"and v.idvariabile = sv.idvariabile  where v.datetime=sv.dataultimovalore and v.idvariabile =  " + 
				"'1,0,3600/1,-,-,-/B13011' and now()-sv.dataultimovalore<cast('6 hours' as interval)), " + 
				"(select max(val) from ( " + 
				"select v.idstazione,sum(v.value) as val from bollettino_valoresensore v " + 
				"join bollettino_stazionevariabile sv on v.idstazione = sv.idstazione  " + 
				"and v.idvariabile = sv.idvariabile where v.datetime>=sv.dataultimovalore-cast ('30 minutes' as interval) " + 
				"and v.idvariabile =  " + 
				"'1,0,1800/1,-,-,-/B13011' and now()-sv.dataultimovalore<cast('6 hours' as interval) group by v.idstazione) x), " + 
				"(select max(val) from ( " + 
				"select v.idstazione,sum(v.value) as val from bollettino_valoresensore v " + 
				"join bollettino_stazionevariabile sv on v.idstazione = sv.idstazione  " + 
				"and v.idvariabile = sv.idvariabile where v.datetime>=sv.dataultimovalore-cast('45 minutes' as interval) " + 
				"and v.idvariabile =  " + 
				"'1,0,900/1,-,-,-/B13011' and now()-sv.dataultimovalore<cast('6 hours' as interval) group by v.idstazione) x)) as mm";
		
		try {
			
			//se la mappa è già accesa
			BollettinoParametro accesa = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GESTIONE_MONITORAGGIO");
			if (accesa!=null && accesa.getValore()!=null && accesa.getValore().equals("true")) {
				//20240513 se il monitoraggio è acceso E siamo in verde idro-geo-temporali E questo è il documento più recente,
				//ALLORA spegni il monitoraggio e notifica
				Calendar adesso = Calendar.getInstance(Locale.ITALY);
				int ora = adesso.get(Calendar.HOUR_OF_DAY);
				int minuto = adesso.get(Calendar.MINUTE);
				if (ora>0 || minuto>=10) {
					//esegui il controllo solo verso mezzanotte, così da non impedire
					//successive accensioni
					return;
				}
				LogInternoLocalServiceUtil.log("controlloMonitoraggio", "spegnimentoAutomatico", "Eseguo controllo spegnimento mezzanotte", "");

				
				Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(query1);
				if (o==null) return;
				Integer i =Integer.parseInt(o.toString());
				if (i.intValue()<1) {
					accesa.setValore("false");
					BollettinoParametroLocalServiceUtil.updateBollettinoParametro(accesa);
					LogInternoLocalServiceUtil.log("controlloMonitoraggio", "spegnimentoAutomatico", "Spegnimento automatico mappa monitoraggio", "");

					try {
						String testo = "Spegnimento automatico mappa monitoraggio";
						String testoMail = "Si comunica lo spegnimento automatico della mappa di monitoraggio in quanto non ci sono allerte idro-geo-temporali in corso di validità presente o futura.";
												
						BollettinoParametro gruppo = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GRUPPO_ACCENSIONE_MAPPA");
						if (gruppo!=null) {
							try {
								
								
								
								long ts = new Date().getTime();
								long canaleMail[] = new long[1];
								canaleMail[0] = 1;
								smsLocalService.creaNotificaGruppoRubrica(canaleMail, "AllerteER", testo, "automatismo", "monitoraggio", ts, 20181, gruppo.getValore(), true, null);
								smsLocalService.eliminaDuplicatiEmail("automatismo", "monitoraggio", ts);
								smsLocalService.inviaEmail("automatismo", "monitoraggio", ts,
										testo, testoMail, "no-reply@regione.emilia-romagna.it");
											} catch (Exception e) {
								logger.error(e);
							}
						}
					} catch (Exception e) {
						logger.error(e);
						//logInternoLocalService.log("caricaDbTask","controlloPioggiaMonitoraggio", e, null);
					}
				}
				return;
			}
			
			BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("CONTROLLO_MONITORAGGIO");
			//logInternoLocalService.log("caricaDbTask", "controlloPioggiaMonitoraggio", "bp "+bp.getValore(), "");
			if (bp==null || bp.getValore()==null || !bp.getValore().equals("true")) {
				//usa un criterio diverso se sei fuori allerta idro
				try {
					controlloPioggiaMonitoraggioFuoriAllerta();
				} catch (Exception e) {
					e.printStackTrace();
					LogInternoLocalServiceUtil.log("controlloPioggiaMonitoraggio", "fuoriAllerta", e, "");
				}
				return;
			}
			
			Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(query1);
			if (o==null) return;
			Integer i =Integer.parseInt(o.toString());
			//logInternoLocalService.log("caricaDbTask", "controlloPioggiaMonitoraggio", "i "+i, "");
			if (i.intValue()<1) return;
			
			o = BollettinoLocalServiceUtil.eseguiQueryGenerica(query2);
			if (o==null) return;
			
			double d = Double.parseDouble(o.toString());
			//logInternoLocalService.log("caricaDbTask", "controlloPioggiaMonitoraggio", "d "+d, "");
			
			BollettinoParametro bp2 = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("SOGLIA_PIOGGIA_MONITORAGGIO");
			double d2 = (bp2!=null? Double.parseDouble(bp2.getValore()) : 5.0);
			//logInternoLocalService.log("caricaDbTask", "controlloPioggiaMonitoraggio", "d2 "+d2, "");
			if (d<d2) return;
			
			//scatenate l'inferno
			bp.setValore("false");
			BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);
			
			bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GESTIONE_MONITORAGGIO");
			//logInternoLocalService.log("caricaDbTask", "controlloPioggiaMonitoraggio", "bp2 "+bp.getValore(), "");
			if (bp==null) return;
			bp.setValore("true");
			BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);
			
			logger.warn("Monitoraggio attivato automaticamente");
			logInternoLocalService.log("monitoraggio","Attivazione monitoraggio","Stato di monitoraggio attivato automaticamente: rilevati "+d+"mm di pioggia","");
			
			try {
				String testo = "Accensione mappa monitoraggio per pioggia associata ad allerta idro";
				String testoMail = "Si comunica l'accensione automatica della mappa di monitoraggio causata dalla caduta di %MM%mm di pioggia.";
				
				testoMail = testoMail.replaceAll("%MM%", new DecimalFormat("0.0").format(d));
				
				BollettinoParametro gruppo = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GRUPPO_ACCENSIONE_MAPPA");
				if (gruppo!=null) {
					try {
						
						
						
						long ts = new Date().getTime();
						long canaleMail[] = new long[1];
						canaleMail[0] = 1;
						smsLocalService.creaNotificaGruppoRubrica(canaleMail, "AllerteER", testo, "automatismo", "monitoraggio", ts, 20181, gruppo.getValore(), true, null);
						smsLocalService.eliminaDuplicatiEmail("automatismo", "monitoraggio", ts);
						smsLocalService.inviaEmail("automatismo", "monitoraggio", ts,
								testo, testoMail, "no-reply@regione.emilia-romagna.it");
									} catch (Exception e) {
						logger.error(e);
					}
				}
			} catch (Exception e) {
				logger.error(e);
				//logInternoLocalService.log("caricaDbTask","controlloPioggiaMonitoraggio", e, null);
			}
			
		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask","controlloPioggiaMonitoraggio", e, null);
		}
		
		
	}
	
	public void monitoraggioPermGen() {
		
		try {
			//logInternoLocalService.log("caricaDbTask", "monitoraggioPermGen", "inizio", "");
			Iterator<MemoryPoolMXBean> iter = ManagementFactory.getMemoryPoolMXBeans().iterator();
			String risultato = "";
			while (iter.hasNext())
			{
			    MemoryPoolMXBean item = iter.next();
			    String name = item.getName();
			    MemoryUsage usage = item.getUsage();
			   
			    	risultato += name + " " + usage.getUsed() + "/" + usage.getMax() + ", " ;
			    
			    
			}
	    	logger.info("monitoraggio memoria: "+risultato);

		} catch (Exception e) {
			logger.error(e);
			//logInternoLocalService.log("caricaDbTask", "monitoraggioMem", e, "");
		}
	}
	
	private void ricaricaCachePluvio() {
		long ts = new Date().getTime();
		ts = ts - (ts % 15*60*1000); //arrotonda ai 15 minuti precedenti
		JSONSerializer serializer = JSONFactoryUtil.createJSONSerializer();

		for (int k=0; k<12; k++) {
			String cacheName = "sensorvalues_"+ts+"_1,0,3600/1,-,-,-/B13011";
			String jsonData = serializer.serialize(imgLocalService.getSensorValues("1,0,3600/1,-,-,-/B13011", ts));
			DatiLocalServiceUtil.putDato(cacheName, jsonData);
			ts-=(ts % 15*60*1000);
		}
	}
	
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	

	
	
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		
		logger.info("ACTIVATE CaricaDBTask");
		lastInstance = this;
		
		Class<?> clazz = getClass();

		String className = clazz.getName();
		
		AllertaBaseSchedulersConfiguration configuration = AllertaTracker.getAllertaSchedulersConfiguration();
		
		int distance = configuration!=null && configuration.schedulerCaricaDBTaskMinutes()>0? configuration.schedulerCaricaDBTaskMinutes() : 5;
		
		logger.info("scheduling at " + distance);
		
		if (distance<1) return;
		
		Trigger trigger = 
				_triggerFactory.createTrigger(className, className, null, null, distance, TimeUnit.MINUTE);

		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(
			className, trigger);
				
		baseScheduler.register(
			this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
		
	}
	
	public int aggiornaTuttoMare() {
		int out = 0;
		out += aggiornaDatiMare(14387);
		out += aggiornaDatiMare(53146);
		out += aggiornaDatiMare(53155);
		out += aggiornaDatiMare(53156);
		
		DatiLocalServiceUtil.removeDatiByPrefix("sensorvalues%");
		LogInternoLocalServiceUtil.log("aggiornaMare", "completato", "scritti "+out+" record", "");
		return out;
	}
	
	public int aggiornaDatiMare(int id) {
		String query = "https://apps.arpae.it/REST/meteo_marefe/?where={\"_id\":\""+id+"\"}";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat atom = new SimpleDateFormat("yyyyMMdd'T'HHmm");
		
		int out = 0;
		
		HashMap<String, String> variabili = new HashMap<String, String>();
		HashMap<Integer, String> stazioni = new HashMap<Integer, String>();
		
		try {
			
			variabili.put("livello_mare_igm", "254,0,0/101,-,-,-/B22037");
			variabili.put("direzione_onde_30min", "200,0,1800/1,-,-,-/M00001");
			variabili.put("altezza_significativa_onde_30min", "0,0,1800/1,-,-,-/M00002");
			
			//stazioni.put(14387, "-/1224944,4467667/marefe");
			stazioni.put(53146, "-/1247587,4421458/boa");
			//stazioni.put(53155, "-/1235751,4426714/boa");
			//stazioni.put(53156, "-/1275067,4397027/boa");
			
			if (!stazioni.containsKey(id)) return 0;
			String idStazione = stazioni.get(id);
			
			String s = downloadUrlPublic(query);
		
			if (s==null) return 0;
			
			JSONObject root = JSONFactoryUtil.createJSONObject(s);
			JSONObject dati = root.getJSONArray("_items").getJSONObject(0).getJSONObject("dati");
			for (String giorno : dati.keySet()) {
				try {
					Date d = sdf.parse(giorno);
					if ((new Date().getTime()-d.getTime())>2*24*3600*1000) continue;
					
					JSONObject gg = dati.getJSONObject(giorno);
					
					for (String ore : gg.keySet()) {
						try {
							Date d2 = atom.parse(giorno+"T"+ore);
							
							JSONObject valori = gg.getJSONObject(ore);
							
							for (String vars : valori.keySet()) {
								if (!variabili.containsKey(vars)) continue;
								
								if (valori.isNull(vars)) {
									
								} else {
								
									String idVariabile = variabili.get(vars);
									ValoreSensore val = valoreSensoreLocalService.createValoreSensore(0);
									val.setIdStazione(idStazione);
									val.setIdVariabile(idVariabile);
									val.setDatetime(d2);
									val.setValue(valori.getDouble(vars));
									ValoreSensoreLocalServiceUtil.updateValoreSensore(val);
									out++;
								}
							}
							
							
							
							
							
						} catch (Exception e3) {
							
						}
					}
				} catch (Exception e2) {
					
				}
			}
			
			for (String v : variabili.keySet()) {
				BollettinoLocalServiceUtil.eseguiQueryGenerica("update bollettino_stazionevariabile x set dataultimovalore = (select max(datetime) from bollettino_valoresensore vs " + 
						"where vs.idstazione=x.idstazione and vs.idvariabile=x.idvariabile) where x.idstazione='"+idStazione+"' and x.idvariabile='"+variabili.get(v) +"'");
			}
			
			
		} catch (Exception e) {
			logInternoLocalService.log("aggiornaDatiMare", "aggiornaDatiMare", e, "");
		}
		
		return out;
		
	}
	

	@Deactivate
	protected void deactivate() {
		baseScheduler.unregister(this);
	}
	

	@Reference
	private AssetEntryLocalService assetEntryLocalService;
	
	@Reference
	private AssetCategoryLocalService assetCategoryLocalService;
	
	@Reference
	private WorkflowDefinitionLinkLocalService workflowDefinitionLinkLocalService;
	
	@Reference
	private CompanyLocalService companyLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private AllertaLocalService allertaLocalService; 
	
	@Reference
	private AllertaValangheLocalService allertaValangheLocalService; 
	
	@Reference
	private SchedulerEngineHelper baseScheduler;
	
	@Reference
	private TriggerFactory _triggerFactory;

	@Reference
	private SMSLocalService smsLocalService;
	
	@Reference
	private StazioneLocalService stazioneLocalService;
	
	@Reference
	private VariabileLocalService variabileLocalService;
	
	@Reference
	private StazioneVariabileLocalService stazioneVariabileLocalService;
	
	@Reference
	private ValoreSensoreLocalService valoreSensoreLocalService;
	
	@Reference
	private RegolaAllarmeCondizioneLocalService regolaAllarmeCondizioneLocalService;
	
	@Reference
	private AllarmeLocalService allarmeLocalService;
	
	@Reference
	private RegolaAllarmeComuneLocalService regolaAllarmeComuneLocalService;
	
	@Reference
	private LogInternoLocalService logInternoLocalService;
	
	@Reference
	ImgService imgLocalService;
	
}
