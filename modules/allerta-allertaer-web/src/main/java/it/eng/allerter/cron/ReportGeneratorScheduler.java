package it.eng.allerter.cron;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;

import it.eng.allerta.configuration.AllertaBaseConfiguration;
import it.eng.allerta.configuration.schedulers.AllertaBaseSchedulersConfiguration;
import it.eng.allerta.utils.AllertaTracker;
import it.eng.allerter.allerta.JasperUtils;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.service.AllertaLocalService;
import it.eng.allerter.service.AllertaParametroLocalService;
import it.eng.allerter.service.AllertaValangheLocalService;
import it.eng.bollettino.model.Allarme;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.model.RegolaAllarme;
import it.eng.bollettino.service.AllarmeLocalService;
import it.eng.bollettino.service.BollettinoLocalService;
import it.eng.bollettino.service.BollettinoParametroLocalService;
import it.eng.bollettino.service.RegolaAllarmeLocalService;
import it.eng.parer.model.ComponentiInvio;
import it.eng.parer.model.DatiSpecificiInvio;
import it.eng.parer.model.DocumentiCollegati;
import it.eng.parer.service.ComponentiInvioLocalService;
import it.eng.parer.service.DatiSpecificiInvioLocalService;
import it.eng.parer.service.DocumentiCollegatiLocalService;

@Component(
  immediate = true, 			  
  service = MessageListener.class
)
public class ReportGeneratorScheduler extends BaseMessageListener  {
	
	public static String QUERY_INVII = "select identificativo_dato_specifico from parer_datispecificiinvio i where tipo_documento='__TIPODOC__' and data_generazione > current_timestamp - cast('3 days' as interval) and data_generazione < current_timestamp - cast('__ORE__ hours' as interval) "+
			"and esito_invio ='OK' and not exists(select * from parer_datispecificiinvio i2 where i2.chiave_tipo_registro='__TIPOREGISTRO__' and i2.chiave_anno=i.chiave_anno "+
			"and i2.chiave_numero=i.chiave_numero||'__PROGRESSIVO__')";
	
	public static String QUERY_SUPERAMENTI = "select allarmeid from bollettino_allarme i where createdate > current_timestamp - cast('3 days' as interval) and createdate < current_timestamp - cast('__ORE__ hours' as interval) "+
			"and not exists(select * from parer_datispecificiinvio i2 where i2.chiave_tipo_registro='__TIPOREGISTRO__' "+
			"and i2.chiave_numero=i.allarmeid||'__PROGRESSIVO__')";
	
	public static int LIMITE_ARRETRATI = 3;
	

	@Override
	protected void doReceive(Message message) throws Exception {

		_log.info("ReportGenerator Scheduler - START");	
		
		AllertaBaseConfiguration configuration = AllertaTracker.getAllertaBaseConfiguration();
		if (configuration==null || configuration.disableParer()) {
			_log.info("Invii Parer disabilitati");
			return;
		}
			
		String quandosms = "0,1,48";
		String quandomail = "0";
		try {
			
			//Thread.sleep(new Random().nextInt(60000));
			
    		AllertaParametro ap = allertaParametroLocalService.getAllertaParametro("PARER_ORE_GENERAZIONE_REPORT_SMS");
    		
    		if (ap!=null) quandosms = ap.getValore();
    		
    	} catch (Exception e) {}
		
		try {
			
    		AllertaParametro ap = allertaParametroLocalService.getAllertaParametro("PARER_ORE_GENERAZIONE_REPORT_EMAIL");
    		if (ap!=null) quandomail = ap.getValore();
    	} catch (Exception e) {}
		
		int versione = 1;
		
		for (String s : quandosms.split(",")) {
			
			try {
				
				String vv = (versione>=10?""+versione:"0"+versione);
				String query = QUERY_INVII.replace("__TIPODOC__","ALLERTA").replace("__PROGRESSIVO__", vv).replace("__TIPOREGISTRO__", "ALLERTA SMS").replace("__ORE__", s);
				List<String> l = bollettinoLocalService.eseguiQueryGenericaLista(query);
				
				for (String n : l) {
					
					try {
						
						Allerta a = allertaLocalService.getAllerta(Long.parseLong(n));
						
						String querysms1 = "select count(*) as x from allerter_sms where tipo='allerta' and sottotipo='"+a.getNumero()+"' and stato>=0";
						String querysms2 = "select count(*) as x from allerter_sms where tipo='allerta' and sottotipo='"+a.getNumero()+"' and stato>=0 and dataack is not null";
						String querysms3 = "select count(*) as x from allerter_sms where tipo='allerta' and sottotipo='"+a.getNumero()+"' and stato=4";
						
						int smsgenerati = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms1)).intValue();
						int smsinviati = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms2)).intValue();
						int smsricevuti = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms3)).intValue();
						
						String num = a.getNumero().split("/")[0];
						String anno = a.getNumero().split("/")[1];
						
						PrincipalThreadLocal.setName(a.getUserId());
						
						PermissionChecker pc = PermissionCheckerFactoryUtil.create(userLocalService.fetchUser(a.getUserId()));
						PermissionThreadLocal.setPermissionChecker(pc);
						
						creaOggettiParer(a, Integer.parseInt(s), num, anno, smsgenerati, smsinviati, smsricevuti, versione);
						
					} catch (Exception e) {
						_log.error(e);
						//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
					}
				}
				
			} catch (Exception e) {
				_log.error(e);
				//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
			}
			
			versione++;
		}
		
		versione = 1;
		
		for (String s : quandomail.split(",")) {
			
			try {
				
				String vv = (versione>=10?""+versione:"0"+versione);
				String query = QUERY_INVII.replace("__TIPODOC__","ALLERTA").replace("__PROGRESSIVO__", vv).replace("__TIPOREGISTRO__", "ALLERTA MAIL").replace("__ORE__", s);
				
				List<String> l = bollettinoLocalService.eseguiQueryGenericaLista(query);
				
				for (String n : l) {
				
					try {
					
						Allerta a = allertaLocalService.getAllerta(Long.parseLong(n));
						
						String queryemail1 = "select oggetto from allerter_email where tipo='allerta' and sottotipo='"+a.getNumero()+"' limit 1";
						String queryemail2 = "select testo from allerter_email where tipo='allerta' and sottotipo='"+a.getNumero()+"' limit 1";
						String oggettoemail = (String)bollettinoLocalService.eseguiQueryGenerica(queryemail1);
						String testoemail = (String)bollettinoLocalService.eseguiQueryGenerica(queryemail2);

						String num = a.getNumero().split("/")[0];
						String anno = a.getNumero().split("/")[1];
						
						PrincipalThreadLocal.setName(a.getUserId());
						PermissionChecker pc = PermissionCheckerFactoryUtil.create(userLocalService.fetchUser(a.getUserId()));
						PermissionThreadLocal.setPermissionChecker(pc);
						
						creaOggettiParerEmail(a, Integer.parseInt(s), num, anno, oggettoemail, testoemail, versione);
						
					} catch (Exception e) {
						_log.error(e);
						//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
					}
				}
				
			} catch (Exception e) {
				_log.error(e);
				//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
			}
			
			versione++;
		}

		
		versione = 1;
		
		for (String s : quandosms.split(",")) {
			
			try {
				
				String vv = (versione>=10?""+versione:"0"+versione);
				String query = QUERY_INVII.replace("__TIPODOC__","MONITORAGGIO").replace("__PROGRESSIVO__", vv).replace("__TIPOREGISTRO__", "MONITORAGGIO SMS").replace("__ORE__", s);
				
				List<String> l = bollettinoLocalService.eseguiQueryGenericaLista(query);
				
				for (String n : l) {
				
					try {
					
						Bollettino a = bollettinoLocalService.getBollettino(Long.parseLong(n));
						
						String querysms1 = "select count(*) as x from allerter_sms where tipo='monitoraggio' and sottotipo='"+a.getNumero()+"' and stato>=0";
						String querysms2 = "select count(*) as x from allerter_sms where tipo='monitoraggio' and sottotipo='"+a.getNumero()+"' and stato>=0 and dataack is not null";
						String querysms3 = "select count(*) as x from allerter_sms where tipo='monitoraggio' and sottotipo='"+a.getNumero()+"' and stato=4";
						
						int smsgenerati = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms1)).intValue();
						int smsinviati = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms2)).intValue();
						int smsricevuti = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms3)).intValue();
						
						String revisione = a.getNumero().split("/")[2];
						
						if (revisione.length()>2) revisione = revisione.substring(0, 2);
						
						String num = a.getNumero().split("/")[0] + revisione;
						String anno = a.getNumero().split("/")[1];
						
						PrincipalThreadLocal.setName(a.getUserId());
						PermissionChecker pc = PermissionCheckerFactoryUtil.create(userLocalService.fetchUser(a.getUserId()));
						PermissionThreadLocal.setPermissionChecker(pc);
						
						creaOggettiParerBollettino(a, Integer.parseInt(s), num, anno, smsgenerati, smsinviati, smsricevuti, versione);
						
					} catch (Exception e) {
						_log.error(e);
						//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
					}
				}
			} catch (Exception e) {
				_log.error(e);
				//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
			}
			
			versione++;
		}
		
		versione = 1;
		
		for (String s : quandomail.split(",")) {
			
			try {
				
				String vv = (versione>=10?""+versione:"0"+versione);
				String query = QUERY_INVII.replace("__TIPODOC__","MONITORAGGIO").replace("__PROGRESSIVO__", vv).replace("__TIPOREGISTRO__", "MONITORAGGIO MAIL").replace("__ORE__", s);
				
				List<String> l = bollettinoLocalService.eseguiQueryGenericaLista(query);
				
				for (String n : l) {
				
					try {
					
						Bollettino a = bollettinoLocalService.getBollettino(Long.parseLong(n));
						
						String queryemail1 = "select oggetto from allerter_email where tipo='monitoraggio' and sottotipo='"+a.getNumero()+"' limit 1";
						String queryemail2 = "select testo from allerter_email where tipo='monitoraggio' and sottotipo='"+a.getNumero()+"' limit 1";
						String oggettoemail = (String)bollettinoLocalService.eseguiQueryGenerica(queryemail1);
						String testoemail = (String)bollettinoLocalService.eseguiQueryGenerica(queryemail2);

						String revisione = a.getNumero().split("/")[2];
						
						if (revisione.length()>2) revisione = revisione.substring(0, 2);
						
						String num = a.getNumero().split("/")[0] + revisione;
						String anno = a.getNumero().split("/")[1];
						
						PrincipalThreadLocal.setName(a.getUserId());
						PermissionChecker pc = PermissionCheckerFactoryUtil.create(userLocalService.fetchUser(a.getUserId()));
						PermissionThreadLocal.setPermissionChecker(pc);
						
						creaOggettiParerEmailBollettino(a, Integer.parseInt(s), num, anno, oggettoemail, testoemail, versione);
						
					} catch (Exception e) {
						_log.error(e);
						//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
					}
				}
			} catch (Exception e) {
				_log.error(e);
				//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
			}
			versione++;
		}
		
		
		versione = 1;
		
		for (String s : quandosms.split(",")) {
			
			try {
				
				String vv = (versione>=10?""+versione:"0"+versione);
				
				String query = QUERY_SUPERAMENTI.replace("__PROGRESSIVO__", vv).replace("__TIPOREGISTRO__", "SUPERAMENTI SMS").replace("__ORE__", s);
				
				List<BigInteger> l = bollettinoLocalService.eseguiQueryGenericaLista(query);
				
				for (BigInteger n : l) {
				
					try {
					
						Allarme a = allarmeLocalService.getAllarme(n.longValue());
						
						String querysms1 = "select count(*) as x from allerter_sms where tipo='superamento' and sottotipo='"+a.getAllarmeId()+"' and stato>=0";
						String querysms2 = "select count(*) as x from allerter_sms where tipo='superamento' and sottotipo='"+a.getAllarmeId()+"' and stato>=0 and dataack is not null";
						String querysms3 = "select count(*) as x from allerter_sms where tipo='superamento' and sottotipo='"+a.getAllarmeId()+"' and stato=4";
						
						int smsgenerati = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms1)).intValue();
						int smsinviati = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms2)).intValue();
						int smsricevuti = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms3)).intValue();
						
						String num = ""+a.getAllarmeId();
						String anno = new SimpleDateFormat("yyyy").format(a.getCreateDate());
						
						PrincipalThreadLocal.setName(20198);
						PermissionChecker pc = PermissionCheckerFactoryUtil.create(userLocalService.fetchUser(20198));
						PermissionThreadLocal.setPermissionChecker(pc);
						
						creaOggettiParerAllarme(a, Integer.parseInt(s), num, anno, smsgenerati, smsinviati, smsricevuti, versione);
						
					} catch (Exception e) {
						_log.error(e);
						//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
					}
				}
			} catch (Exception e) {
				_log.error(e);
				//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
			}
			
			versione++;
		}
		
		versione = 1;
		
		for (String s : quandomail.split(",")) {
			
			try {
			
				String vv = (versione>=10?""+versione:"0"+versione);
				
				String query = QUERY_SUPERAMENTI.replace("__PROGRESSIVO__", vv).replace("__TIPOREGISTRO__", "SUPERAMENTI MAIL").replace("__ORE__", s);
				
				List<BigInteger> l = bollettinoLocalService.eseguiQueryGenericaLista(query);
				
				for (BigInteger n : l) {
				
					try {
					
						Allarme a = allarmeLocalService.getAllarme(n.longValue());
						
						String queryemail1 = "select oggetto from allerter_email where tipo='superamento' and sottotipo='"+a.getAllarmeId()+"' limit 1";
						String queryemail2 = "select testo from allerter_email where tipo='superamento' and sottotipo='"+a.getAllarmeId()+"' limit 1";
						String oggettoemail = (String)bollettinoLocalService.eseguiQueryGenerica(queryemail1);
						String testoemail = (String)bollettinoLocalService.eseguiQueryGenerica(queryemail2);

						String num = ""+a.getAllarmeId();
						String anno = new SimpleDateFormat("yyyy").format(a.getCreateDate());
						
						PrincipalThreadLocal.setName(20198);
						PermissionChecker pc = PermissionCheckerFactoryUtil.create(userLocalService.fetchUser(20198));
						PermissionThreadLocal.setPermissionChecker(pc);
						
						creaOggettiParerEmailAllarme(a, Integer.parseInt(s), num, anno, oggettoemail, testoemail, versione);
						
					} catch (Exception e) {
						_log.error(e);
						//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
					}
				}
			} catch (Exception e) {
				_log.error(e);
				//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
			}
			
			versione++;
		}
		
		versione = 1;
		
		for (String s : quandosms.split(",")) {
			
			try {
				
				String vv = (versione>=10?""+versione:"0"+versione);
				String query = QUERY_INVII.replace("__TIPODOC__","BOLLETTINO VALANGHE").replace("__PROGRESSIVO__", vv).replace("__TIPOREGISTRO__", "METEOMONT SMS").replace("__ORE__", s);
				List<String> l = bollettinoLocalService.eseguiQueryGenericaLista(query);
				
				for (String n : l) {
					
					try {
						
						AllertaValanghe a = allertaValangheLocalService.getAllertaValanghe(Long.parseLong(n));
						
						String querysms1 = "select count(*) as x from allerter_sms where tipo='valanghe' and sottotipo='"+a.getNumero()+"' and stato>=0";
						String querysms2 = "select count(*) as x from allerter_sms where tipo='valanghe' and sottotipo='"+a.getNumero()+"' and stato>=0 and dataack is not null";
						String querysms3 = "select count(*) as x from allerter_sms where tipo='valanghe' and sottotipo='"+a.getNumero()+"' and stato=4";
						
						int smsgenerati = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms1)).intValue();
						int smsinviati = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms2)).intValue();
						int smsricevuti = ((Number)bollettinoLocalService.eseguiQueryGenerica(querysms3)).intValue();
						
						String num = a.getNumero().split("/")[0];
						String anno = a.getNumero().split("/")[1];
						
						PrincipalThreadLocal.setName(a.getUserId());
						
						PermissionChecker pc = PermissionCheckerFactoryUtil.create(userLocalService.fetchUser(a.getUserId()));
						PermissionThreadLocal.setPermissionChecker(pc);
						
						creaOggettiParerValangheSms(a, Integer.parseInt(s), num, anno, smsgenerati, smsinviati, smsricevuti, versione);
						
					} catch (Exception e) {
						_log.error(e);
						//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
					}
				}
				
			} catch (Exception e) {
				_log.error(e);
				//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
			}
			
			versione++;
		}
		
		versione = 1;
		
		for (String s : quandomail.split(",")) {
			
			try {
				
				String vv = (versione>=10?""+versione:"0"+versione);
				String query = QUERY_INVII.replace("__TIPODOC__","BOLLETTINO VALANGHE").replace("__PROGRESSIVO__", vv).replace("__TIPOREGISTRO__", "METEOMONT MAIL").replace("__ORE__", s);
				
				List<String> l = bollettinoLocalService.eseguiQueryGenericaLista(query);
				
				for (String n : l) {
				
					try {
					
						AllertaValanghe a = allertaValangheLocalService.getAllertaValanghe(Long.parseLong(n));
						
						String queryemail1 = "select oggetto from allerter_email where tipo='valanghe' and sottotipo='"+a.getNumero()+"' limit 1";
						String queryemail2 = "select testo from allerter_email where tipo='valanghe' and sottotipo='"+a.getNumero()+"' limit 1";
						String oggettoemail = (String)bollettinoLocalService.eseguiQueryGenerica(queryemail1);
						String testoemail = (String)bollettinoLocalService.eseguiQueryGenerica(queryemail2);

						String num = a.getNumero().split("/")[0];
						String anno = a.getNumero().split("/")[1];
						
						PrincipalThreadLocal.setName(a.getUserId());
						PermissionChecker pc = PermissionCheckerFactoryUtil.create(userLocalService.fetchUser(a.getUserId()));
						PermissionThreadLocal.setPermissionChecker(pc);
						
						creaOggettiParerValangheEmail(a, Integer.parseInt(s), num, anno, oggettoemail, testoemail, versione);
						
					} catch (Exception e) {
						_log.error(e);
						//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
					}
				}
				
			} catch (Exception e) {
				_log.error(e);
				//logInternoLocalService.log("ReportGeneratorTimer", "receive", e, "");
			}
			
			versione++;
		}
		
		arretratiAllerte(true);
		arretratiAllerte(false);
		arretratiMonitoraggi();
		arretratiValanghe(true);
		arretratiValanghe(false);
		
		_log.info("ReportGenerator Scheduler - END");
	}
	
	Map<String,Object> creaReportSms(Allerta a, int ore, int versione) {
		
		try {
		String cpu = PortalUtil.getComputerName();
		String host = cpu.contains("667") || cpu.contains("668")? "https://allertameteo.regione.emilia-romagna.it" : "http://localhost:8080";
		String u2 =  host+"/o/report/sms";
		
		String urlpdf = u2 + ("?tipo=allerta&sottotipo="+a.getNumero());
		System.out.println(urlpdf);
		File sms = FileUtil.createTempFile(new URL(urlpdf).openConnection().getInputStream());

		long user = a.getUserId();
	
		//trova i dati del creatore
		User us = userLocalService.fetchUser(user);
		
		 ServiceContext sc = new ServiceContext();
		 
		 sc.setUserId(user);
		 sc.setScopeGroupId(a.getGroupId());
		 sc.setCompanyId(a.getCompanyId());
		 
		 long l = fileUploadByApp(sc, sms, "allerta-"+a.getAllertaId(), "rep_invio_sms_"+ore+"_ore.pdf", "Report invio", "application/pdf");
		 
		 Map<String,Object> m = new HashMap<String, Object>();
		 m.put("entry", l);
		 m.put("hash", getHash(sms));
		 try { sms.delete(); } catch (Exception e) {}
		 return m;
		}
		
		catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("ReportGeneratorTimer", "creaReportSms", e, "");
			return null;
		}
	}
	
	Map<String,Object> creaReportSmsValanghe(AllertaValanghe a, int ore, int versione) {
		
		try {
		String cpu = PortalUtil.getComputerName();
		String host = cpu.contains("667") || cpu.contains("668")? "https://allertameteo.regione.emilia-romagna.it" : "http://localhost:8080";
		String u2 =  host+"/o/report/sms";
		
		String urlpdf = u2 + ("?tipo=valanghe&sottotipo="+a.getNumero());
		System.out.println(urlpdf);
		File sms = FileUtil.createTempFile(new URL(urlpdf).openConnection().getInputStream());

		long user = a.getUserId();
	
		//trova i dati del creatore
		User us = userLocalService.fetchUser(user);
		
		 ServiceContext sc = new ServiceContext();
		 
		 sc.setUserId(user);
		 sc.setScopeGroupId(a.getGroupId());
		 sc.setCompanyId(a.getCompanyId());
		 
		 long l = fileUploadByApp(sc, sms, "allerta-valanghe-"+a.getAllertaValangheId(), "rep_invio_sms_"+ore+"_ore.pdf", "Report invio", "application/pdf");
		 
		 Map<String,Object> m = new HashMap<String, Object>();
		 m.put("entry", l);
		 m.put("hash", getHash(sms));
		 try { sms.delete(); } catch (Exception e) {}
		 return m;
		}
		
		catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("ReportGeneratorTimer", "creaReportSms", e, "");
			return null;
		}
	}
	
	Map<String,Object> creaReportSmsBollettino(Bollettino a, int ore, int versione) {
		
		try {
		String cpu = PortalUtil.getComputerName();
		String host = cpu.contains("667") || cpu.contains("668")? "https://allertameteo.regione.emilia-romagna.it" : "http://localhost:8080";
		String u2 =  host+"/o/report/sms";
		
		String urlpdf = u2 + ("?tipo=monitoraggio&sottotipo="+a.getNumero());
		System.out.println(urlpdf);
		File sms = FileUtil.createTempFile(new URL(urlpdf).openConnection().getInputStream());

		long user = a.getUserId();
	
		//trova i dati del creatore
		User us = userLocalService.fetchUser(user);
		
		 ServiceContext sc = new ServiceContext();
		 
		 sc.setUserId(user);
		 sc.setScopeGroupId(a.getGroupId());
		 sc.setCompanyId(a.getCompanyId());
		 
		 long l = fileUploadByApp(sc, sms, "bollettino-"+a.getBollettinoId(), "rep_invio_sms_"+ore+"_ore.pdf", "Report invio", "application/pdf");
		 
		 Map<String,Object> m = new HashMap<String, Object>();
		 m.put("entry", l);
		 m.put("hash", getHash(sms));
		 try { sms.delete(); } catch (Exception e) {}
		 return m;
		}
		
		catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("ReportGeneratorTimer", "creaReportSmsBollettino", e, "");
			return null;
		}
	}
	
	Map<String,Object> creaReportSmsAllarme(Allarme a, int ore, int versione) {
		
		try {
		String cpu = PortalUtil.getComputerName();
			
		String host = cpu.contains("667") || cpu.contains("668")? "https://allertameteo.regione.emilia-romagna.it" : "http://localhost:8080";
		String u2 =  host+"/o/report/sms";
				
		String urlpdf = u2 + ("?tipo=superamento&param="+a.getAllarmeId());
		System.out.println(urlpdf);
		URLConnection uc = new URL(urlpdf).openConnection();
		InputStream is = uc.getInputStream();
		File sms = FileUtil.createTempFile(is);

		try {
			is.close();
		} catch (Exception e) { e.printStackTrace(); }
	
		//trova i dati del creatore
		
		 ServiceContext sc = new ServiceContext();
		 
		 sc.setUserId(20198);
		 sc.setScopeGroupId(20181);
		 sc.setCompanyId(20154);
		 
		 long l = fileUploadByApp(sc, sms, "report-superamenti", ""+a.getAllarmeId()+"_rep_invio_sms_"+ore+"_ore.pdf", "Report invio", "application/pdf");
		 
		 Map<String,Object> m = new HashMap<String, Object>();
		 m.put("entry", l);
		 m.put("hash", getHash(sms));
		 try { sms.delete(); } catch (Exception e) {}
		 return m;
		}
		
		catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("ReportGeneratorTimer", "creaReportSmsAllarme", e, "");
			return null;
		}
	}
	
	Map<String,Object> creaReportEmail(Allerta a, int ore, int versione) {
		
		try {
			String cpu = PortalUtil.getComputerName();
			
			String host = cpu.contains("667") || cpu.contains("668")? "https://allertameteo.regione.emilia-romagna.it" : "http://localhost:8080";
		String u2 =  host+"/o/report/email";
		
		String urlpdf = u2 + ("?tipo=allerta&sottotipo="+a.getNumero());
		System.out.println(urlpdf);
		URLConnection uc = new URL(urlpdf).openConnection();
		InputStream is = uc.getInputStream();
		File sms = FileUtil.createTempFile(is);

		try {
			is.close();
		} catch (Exception e) { e.printStackTrace(); }
		
		
		long user = a.getUserId();
	
		//trova i dati del creatore
		User us = userLocalService.fetchUser(user);
		
		 ServiceContext sc = new ServiceContext();
		 
		 sc.setUserId(user);
		 sc.setScopeGroupId(a.getGroupId());
		 sc.setCompanyId(a.getCompanyId());
		 
		 long l = fileUploadByApp(sc, sms, "allerta-"+a.getAllertaId(), "rep_invio_email_"+ore+"_ore.pdf", "Report invio", "application/pdf");
		 
		 Map<String,Object> m = new HashMap<String, Object>();
		 m.put("entry", l);
		 m.put("hash", getHash(sms));
		 try { sms.delete(); } catch (Exception e) {}
		 return m;
		} catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("ReportGeneratorTimer", "creaReportEmail", e, "");
			return null;
		}
	}
	
	Map<String,Object> creaReportEmailValanghe(AllertaValanghe a, int ore, int versione) {
		
		try {
			String cpu = PortalUtil.getComputerName();
			
			String host = cpu.contains("667") || cpu.contains("668")? "https://allertameteo.regione.emilia-romagna.it" : "http://localhost:8080";
		String u2 =  host+"/o/report/email";
		
		String urlpdf = u2 + ("?tipo=valanghe&sottotipo="+a.getNumero());
		System.out.println(urlpdf);
		URLConnection uc = new URL(urlpdf).openConnection();
		InputStream is = uc.getInputStream();
		File sms = FileUtil.createTempFile(is);

		try {
			is.close();
		} catch (Exception e) { e.printStackTrace(); }
		
		
		long user = a.getUserId();
	
		//trova i dati del creatore
		User us = userLocalService.fetchUser(user);
		
		 ServiceContext sc = new ServiceContext();
		 
		 sc.setUserId(user);
		 sc.setScopeGroupId(a.getGroupId());
		 sc.setCompanyId(a.getCompanyId());
		 
		 long l = fileUploadByApp(sc, sms, "allerta-valanghe-"+a.getAllertaValangheId(), "rep_invio_email_"+ore+"_ore.pdf", "Report invio", "application/pdf");
		 
		 Map<String,Object> m = new HashMap<String, Object>();
		 m.put("entry", l);
		 m.put("hash", getHash(sms));
		 try { sms.delete(); } catch (Exception e) {}
		 return m;
		} catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("ReportGeneratorTimer", "creaReportEmail", e, "");
			return null;
		}
	}
	
	Map<String,Object> creaReportEmailBollettino(Bollettino a, int ore, int versione) {
		
		try {
		String cpu = PortalUtil.getComputerName();
		String host = cpu.contains("667") || cpu.contains("668")? "https://allertameteo.regione.emilia-romagna.it" : "http://localhost:8080";
		String u2 =  host+"/o/report/email";
		
		String urlpdf = u2 + ("?tipo=monitoraggio&sottotipo="+a.getNumero());
		System.out.println(urlpdf);
		File sms = FileUtil.createTempFile(new URL(urlpdf).openConnection().getInputStream());

		long user = a.getUserId();
	
		//trova i dati del creatore
		User us = userLocalService.fetchUser(user);
		
		 ServiceContext sc = new ServiceContext();
		 
		 sc.setUserId(user);
		 sc.setScopeGroupId(a.getGroupId());
		 sc.setCompanyId(a.getCompanyId());
		 
		 long l = fileUploadByApp(sc, sms, "bollettino-"+a.getBollettinoId(), "rep_invio_email_"+ore+"_ore.pdf", "Report invio", "application/pdf");
		 
		 Map<String,Object> m = new HashMap<String, Object>();
		 m.put("entry", l);
		 m.put("hash", getHash(sms));
		 try { sms.delete(); } catch (Exception e) {}
		 return m;
		} catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("ReportGeneratorTimer", "creaReportEmailBollettino", e, "");
			return null;
		}
	}
	
	Map<String,Object> creaReportEmailAllarme(Allarme a, int ore, int versione) {
		
		try {
		String cpu = PortalUtil.getComputerName();
		String host = cpu.contains("667") || cpu.contains("668")? "https://allertameteo.regione.emilia-romagna.it" : "http://localhost:8080";
		String u2 =  host+"/o/report/email";
		
		String urlpdf = u2 + ("?tipo=superamento&param="+a.getAllarmeId());
		System.out.println(urlpdf);
		File sms = FileUtil.createTempFile(new URL(urlpdf).openConnection().getInputStream());


		
		 ServiceContext sc = new ServiceContext();
		 
		 sc.setUserId(20198);
		 sc.setScopeGroupId(20181);
		 sc.setCompanyId(20154);
		 
		 long l = fileUploadByApp(sc, sms, "report-superamenti", ""+a.getAllarmeId()+"_rep_invio_email_"+ore+"_ore.pdf", "Report invio", "application/pdf");
		 
		 Map<String,Object> m = new HashMap<String, Object>();
		 m.put("entry", l);
		 m.put("hash", getHash(sms));
		 try { sms.delete(); } catch (Exception e) {}
		 return m;
		} catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("ReportGeneratorTimer", "creaReportEmailAllarme", e, "");
			return null;
		}
	}
	
	public void creaOggettiParer(Allerta feedback, int ore, String num, String anno, int sms1, int sms2, int sms3, int versione) {
		try {
    		String vv = (versione>=10?""+versione:"0"+versione);
    		Map<String,Object> m = creaReportSms(feedback,ore,versione);
    		
    		DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
    		dsi.setCHIAVE_NUMERO(num+vv);
    		dsi.setCHIAVE_ANNO(Long.parseLong(feedback.getNumero().split("/")[1]));
    		dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
    		dsi.setIDENTIFICATIVO_DATO_SPECIFICO(feedback.getNumero());
    		dsi.setDATA_GENERAZIONE(new Date());
    		dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");

    		dsi.setNUM_SMS_GENERATI(sms1);
    		dsi.setNUM_SMS_INVIATI(sms2);
    		dsi.setNUM_NOTIFICHE_RICEZIONE(sms3);
    		
    		ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
    		ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
    		
    		//DocumentiCollegatiPK pk = new DocumentiCollegatiPK(num, Integer.parseInt(anno), "ALLERTE", 0);
    		DocumentiCollegati dc = documentiCollegatiLocalService.getNuovoDocumentoCollegato();
    		dc.setDOC_COLLEGATO_NUMERO(num);
    		dc.setDOC_COLLEGATO_ANNO(Integer.parseInt(anno));
    		dc.setDOC_COLLEGATO_TIPO_REGISTRO("ALLERTE");
    		documentiCollegati.add(dc);
    		
    		ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
    		c.setHASH_VERSATO((String)m.get("hash"));
    		c.setID_COMPONENTE_VERSATO((Long)m.get("entry"));
    		c.setNOME_COMPONENTE("rep_invio_sms_"+ore+"_ore.pdf");
    		c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it"+feedback.getLink());
    		c.setFORMATO_FILE_VERSATO("PDF"); componentiInvio.add(c);
    		
    		if (feedback.getTipoAllerta())
    			datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioAllertaSms(dsi, documentiCollegati, componentiInvio);
    		
    	} catch (Exception e) {
    		_log.error(e);
    		//logInternoLocalService.log("ReportGeneratorTimer", "creaOggettiParer", e, "");
    	}
	}
	
	
	public void creaOggettiParerValangheSms(AllertaValanghe feedback, int ore, String num, String anno, int sms1, int sms2, int sms3, int versione) {
		try {
			
			if (!feedback.getTipoAllerta()) return;
			
    		String vv = (versione>=10?""+versione:"0"+versione);
    		Map<String,Object> m = creaReportSmsValanghe(feedback,ore,versione);
    		
    		DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
    		dsi.setCHIAVE_NUMERO("0"+num+vv);
    		dsi.setCHIAVE_ANNO(Long.parseLong(feedback.getNumero().split("/")[1]));
    		dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
    		dsi.setIDENTIFICATIVO_DATO_SPECIFICO(feedback.getNumero());
    		dsi.setDATA_GENERAZIONE(new Date());
    		dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");

    		dsi.setNUM_SMS_GENERATI(sms1);
    		dsi.setNUM_SMS_INVIATI(sms2);
    		dsi.setNUM_NOTIFICHE_RICEZIONE(sms3);
    		
    		ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
    		ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
    		
    		//DocumentiCollegatiPK pk = new DocumentiCollegatiPK(num, Integer.parseInt(anno), "ALLERTE", 0);
    		DocumentiCollegati dc = documentiCollegatiLocalService.getNuovoDocumentoCollegato();
    		dc.setDOC_COLLEGATO_NUMERO("0"+num);
    		dc.setDOC_COLLEGATO_ANNO(Integer.parseInt(anno));
    		dc.setDOC_COLLEGATO_TIPO_REGISTRO("METEOMONT");
    		documentiCollegati.add(dc);
    		
    		ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
    		c.setHASH_VERSATO((String)m.get("hash"));
    		c.setID_COMPONENTE_VERSATO((Long)m.get("entry"));
    		c.setNOME_COMPONENTE("rep_invio_sms_"+ore+"_ore.pdf");
    		c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it"+feedback.getLink());
    		c.setFORMATO_FILE_VERSATO("PDF"); componentiInvio.add(c);
    		
    		if (feedback.getTipoAllerta())
    			datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioValangheSms(dsi, documentiCollegati, componentiInvio);
    		
    	} catch (Exception e) {
    		_log.error(e);
    		//logInternoLocalService.log("ReportGeneratorTimer", "creaOggettiParer", e, "");
    	}
	}
	
	public void creaOggettiParerBollettino(Bollettino feedback, int ore, String num, String anno, int sms1, int sms2, int sms3, int versione) {
		try {
    		String vv = (versione>=10?""+versione:"0"+versione);
    		Map<String,Object> m = creaReportSmsBollettino(feedback,ore,versione);
    		
    		DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
    		dsi.setCHIAVE_NUMERO(num+vv);
    		dsi.setCHIAVE_ANNO(Long.parseLong(anno));
    		dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
    		dsi.setIDENTIFICATIVO_DATO_SPECIFICO(feedback.getNumero());
    		dsi.setDATA_GENERAZIONE(new Date());
    		dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");

    		dsi.setNUM_SMS_GENERATI(sms1);
    		dsi.setNUM_SMS_INVIATI(sms2);
    		dsi.setNUM_NOTIFICHE_RICEZIONE(sms3);
    		
    		ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
    		ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
    		
    		//DocumentiCollegatiPK pk = new DocumentiCollegatiPK(num, Integer.parseInt(anno), "ALLERTE", 0);
    		DocumentiCollegati dc = documentiCollegatiLocalService.getNuovoDocumentoCollegato();
    		dc.setDOC_COLLEGATO_NUMERO(num);
    		dc.setDOC_COLLEGATO_ANNO(Integer.parseInt(anno));
    		dc.setDOC_COLLEGATO_TIPO_REGISTRO("MONITORAGGI");
    		documentiCollegati.add(dc);
    		
    		ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
    		c.setHASH_VERSATO((String)m.get("hash"));
    		c.setID_COMPONENTE_VERSATO((Long)m.get("entry"));
    		c.setNOME_COMPONENTE("rep_invio_sms_"+ore+"_ore.pdf");
    		c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it"+feedback.getLink());
    		c.setFORMATO_FILE_VERSATO("PDF"); componentiInvio.add(c);
    		
    		
    		datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioMonitoraggioSms(dsi, documentiCollegati, componentiInvio);
    		
    	} catch (Exception e) {
    		_log.error(e);
    		//logInternoLocalService.log("ReportGeneratorTimer", "creaOggettiParerBollettino", e, "");
    		//System.out.println("PARER EXCEPTION: "+e.getMessage());
    	}
	}
	
	public void creaOggettiParerAllarme(Allarme feedback, int ore, String num, String anno, int sms1, int sms2, int sms3, int versione) {
		try {
    		String vv = (versione>=10?""+versione:"0"+versione);
    		Map<String,Object> m = creaReportSmsAllarme(feedback,ore,versione);
    		
    		DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
    		dsi.setCHIAVE_NUMERO(num+vv);
    		dsi.setCHIAVE_ANNO(Long.parseLong(anno));
    		dsi.setDATA_UNITA_DOCUMENTARIA(new Date());
    		dsi.setIDENTIFICATIVO_DATO_SPECIFICO(""+feedback.getAllarmeId());
    		dsi.setDATA_GENERAZIONE(new Date());
    		dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");

    		dsi.setNUM_SMS_GENERATI(sms1);
    		dsi.setNUM_SMS_INVIATI(sms2);
    		dsi.setNUM_NOTIFICHE_RICEZIONE(sms3);
    		
    		dsi.setREGOLA_ALLARME_ID(""+feedback.getIdRegola());
    		
    		try {
	    		RegolaAllarme ra = regolaAllarmeLocalService.getRegolaAllarme(feedback.getIdRegola());
	    		
	    		dsi.setREGOLA_ALLARME_DESCRIZIONE(ra.getDescrizione());
	    		dsi.setREGOLA_ALLARME_NOME(ra.getNome());
	    		
	    		String qq = "select principale from regole_allarme_vw where id_ = "+feedback.getIdRegola();
				String desc = (String)bollettinoLocalService.eseguiQueryGenerica(qq);
				
	    		dsi.setDENOMINAZIONE_SENSORE_RILEVAMENTO(desc);
    		} catch (Exception e) {}
    		
    		ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
    		ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();

    		DocumentiCollegati dc = documentiCollegatiLocalService.getNuovoDocumentoCollegato();
    		dc.setDOC_COLLEGATO_NUMERO(num+"01");
    		dc.setDOC_COLLEGATO_ANNO(Integer.parseInt(anno));
    		dc.setDOC_COLLEGATO_TIPO_REGISTRO("SUPERAMENTI MAIL");
    		documentiCollegati.add(dc);
    		
    		ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
    		c.setHASH_VERSATO((String)m.get("hash"));
    		c.setID_COMPONENTE_VERSATO((Long)m.get("entry"));
    		c.setNOME_COMPONENTE("rep_invio_sms_"+ore+"_ore.pdf");
    		c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it");
    		c.setFORMATO_FILE_VERSATO("PDF"); componentiInvio.add(c);
    		
    		
    		datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioSuperamentoSms(dsi, documentiCollegati, componentiInvio);
    		
    	} catch (Exception e) {
    		_log.error(e);
    		//logInternoLocalService.log("ReportGeneratorTimer", "creaOggettiParerAllarme", e, "");
    		System.out.println("PARER EXCEPTION: "+e.getMessage());
    	}
	}
	
	public void creaOggettiParerEmail(Allerta feedback, int ore, String num, String anno, String oggetto, String testo, int versione) {
		try {
			String vv = (versione>=10?""+versione:"0"+versione);
    		Map<String,Object> m = creaReportEmail(feedback,ore,versione);
    		
    		DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
    		dsi.setCHIAVE_NUMERO(num+vv);
    		dsi.setCHIAVE_ANNO(Long.parseLong(feedback.getNumero().split("/")[1]));
    		dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
    		dsi.setIDENTIFICATIVO_DATO_SPECIFICO(feedback.getNumero());
    		dsi.setDATA_GENERAZIONE(new Date());
    		dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");

    		dsi.setOGGETTO_MAIL(oggetto);
    		dsi.setTESTO_MAIL(testo);
    		
    		ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
    		ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
    		
    		DocumentiCollegati dc = documentiCollegatiLocalService.getNuovoDocumentoCollegato();
    		dc.setDOC_COLLEGATO_NUMERO(num);
    		dc.setDOC_COLLEGATO_ANNO(Integer.parseInt(anno));
    		dc.setDOC_COLLEGATO_TIPO_REGISTRO("ALLERTE");
    		documentiCollegati.add(dc);
    		
    		ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
    		c.setHASH_VERSATO((String)m.get("hash"));
    		c.setID_COMPONENTE_VERSATO((Long)m.get("entry"));
    		c.setNOME_COMPONENTE("rep_invio_email_"+ore+"_ore.pdf");
    		c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it"+feedback.getLink());
    		c.setFORMATO_FILE_VERSATO("PDF"); componentiInvio.add(c);
    		
    		if (feedback.getTipoAllerta())
    			datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioAllertaMail(dsi, documentiCollegati, componentiInvio);
    		
    	} catch (Exception e) {
    		_log.error(e);
    		//logInternoLocalService.log("ReportGeneratorTimer", "creaOggettiParerEmail", e, "");
    		System.out.println("PARER EXCEPTION: "+e.getMessage());
    	}
		
		
	}
	
	public void creaOggettiParerValangheEmail(AllertaValanghe feedback, int ore, String num, String anno, String oggetto, String testo, int versione) {
		try {
			
			if (!feedback.getTipoAllerta()) return;
			
			String vv = (versione>=10?""+versione:"0"+versione);
    		Map<String,Object> m = creaReportEmailValanghe(feedback,ore,versione);
    		
    		DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
    		dsi.setCHIAVE_NUMERO("0"+num+vv);
    		dsi.setCHIAVE_ANNO(Long.parseLong(feedback.getNumero().split("/")[1]));
    		dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
    		dsi.setIDENTIFICATIVO_DATO_SPECIFICO(feedback.getNumero());
    		dsi.setDATA_GENERAZIONE(new Date());
    		dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");

    		dsi.setOGGETTO_MAIL(oggetto);
    		dsi.setTESTO_MAIL(testo);
    		
    		ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
    		ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
    		
    		DocumentiCollegati dc = documentiCollegatiLocalService.getNuovoDocumentoCollegato();
    		dc.setDOC_COLLEGATO_NUMERO("0"+num);
    		dc.setDOC_COLLEGATO_ANNO(Integer.parseInt(anno));
    		dc.setDOC_COLLEGATO_TIPO_REGISTRO("METEOMONT");
    		documentiCollegati.add(dc);
    		
    		ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
    		c.setHASH_VERSATO((String)m.get("hash"));
    		c.setID_COMPONENTE_VERSATO((Long)m.get("entry"));
    		c.setNOME_COMPONENTE("rep_invio_email_"+ore+"_ore.pdf");
    		c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it"+feedback.getLink());
    		c.setFORMATO_FILE_VERSATO("PDF"); componentiInvio.add(c);
    		
    		if (feedback.getTipoAllerta())
    			datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioValangheMail(dsi, documentiCollegati, componentiInvio);
    		
    	} catch (Exception e) {
    		_log.error(e);
    		//logInternoLocalService.log("ReportGeneratorTimer", "creaOggettiParerEmail", e, "");
    		System.out.println("PARER EXCEPTION: "+e.getMessage());
    	}
		
		
	}
	
	public void creaOggettiParerEmailBollettino(Bollettino feedback, int ore, String num, String anno, String oggetto, String testo, int versione) {
		try {
			String vv = (versione>=10?""+versione:"0"+versione);
    		Map<String,Object> m = creaReportEmailBollettino(feedback,ore,versione);
    		
    		DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
    		dsi.setCHIAVE_NUMERO(num+vv);
    		dsi.setCHIAVE_ANNO(Long.parseLong(anno));
    		dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
    		dsi.setIDENTIFICATIVO_DATO_SPECIFICO(feedback.getNumero());
    		dsi.setDATA_GENERAZIONE(new Date());
    		dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");

    		dsi.setOGGETTO_MAIL(oggetto);
    		dsi.setTESTO_MAIL(testo);
    		
    		ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
    		ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
    		
    		DocumentiCollegati dc = documentiCollegatiLocalService.getNuovoDocumentoCollegato();
    		dc.setDOC_COLLEGATO_NUMERO(num);
    		dc.setDOC_COLLEGATO_ANNO(Integer.parseInt(anno));
    		dc.setDOC_COLLEGATO_TIPO_REGISTRO("MONITORAGGI");
    		documentiCollegati.add(dc);
    		
    		ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
    		c.setHASH_VERSATO((String)m.get("hash"));
    		c.setID_COMPONENTE_VERSATO((Long)m.get("entry"));
    		c.setNOME_COMPONENTE("rep_invio_email_"+ore+"_ore.pdf");
    		c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it"+feedback.getLink());
    		
    		c.setFORMATO_FILE_VERSATO("PDF"); componentiInvio.add(c);
    		datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioMonitoraggioMail(dsi, documentiCollegati, componentiInvio);
    		
    	} catch (Exception e) {
    		_log.error(e);
    		//logInternoLocalService.log("ReportGeneratorTimer", "creaOggettiParerEmailBollettino", e, "");
    		System.out.println("PARER EXCEPTION: "+e.getMessage());
    	}
	}
	
	public void creaOggettiParerEmailAllarme(Allarme feedback, int ore, String num, String anno, String oggetto, String testo, int versione) {
		try {
			String vv = (versione>=10?""+versione:"0"+versione);
    		Map<String,Object> m = creaReportEmailAllarme(feedback,ore,versione);
    		
    		DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
    		dsi.setCHIAVE_NUMERO(num+vv);
    		dsi.setCHIAVE_ANNO(Long.parseLong(anno));
    		dsi.setDATA_UNITA_DOCUMENTARIA(new Date());
    		dsi.setIDENTIFICATIVO_DATO_SPECIFICO(""+feedback.getAllarmeId());
    		dsi.setDATA_GENERAZIONE(new Date());
    		dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");

    		dsi.setOGGETTO_MAIL(oggetto);
    		dsi.setTESTO_MAIL(testo);
    		
    		dsi.setREGOLA_ALLARME_ID(""+feedback.getIdRegola());
    		
    		try {
	    		RegolaAllarme ra = regolaAllarmeLocalService.getRegolaAllarme(feedback.getIdRegola());
	    		
	    		dsi.setREGOLA_ALLARME_DESCRIZIONE(ra.getDescrizione());
	    		dsi.setREGOLA_ALLARME_NOME(ra.getNome());
	    		
	    		String qq = "select principale from regole_allarme_vw where id_ = "+feedback.getIdRegola();
				String desc = (String)bollettinoLocalService.eseguiQueryGenerica(qq);
				
	    		dsi.setDENOMINAZIONE_SENSORE_RILEVAMENTO(desc);
    		} catch (Exception e) {}
    		
    		ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
    		ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
    		
    		DocumentiCollegati dc = documentiCollegatiLocalService.getNuovoDocumentoCollegato();
    		/*dc.setDOC_COLLEGATO_NUMERO(num+vv);
    		dc.setDOC_COLLEGATO_ANNO(Integer.parseInt(anno));
    		dc.setDOC_COLLEGATO_TIPO_REGISTRO("SUPERAMENTI SMS");
    		documentiCollegati.add(dc);*/
    		
    		ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
    		c.setHASH_VERSATO((String)m.get("hash"));
    		c.setID_COMPONENTE_VERSATO((Long)m.get("entry"));
    		c.setNOME_COMPONENTE("rep_invio_email_"+ore+"_ore.pdf");
    		c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it");
    		c.setFORMATO_FILE_VERSATO("PDF"); componentiInvio.add(c);
    		datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioSuperamentoMail(dsi, documentiCollegati, componentiInvio);
    		
    	} catch (Exception e) {
    		_log.error(e);
    		//logInternoLocalService.log("ReportGeneratorTimer", "creaOggettiParerEmailAllarme", e, "");
    		System.out.println("PARER EXCEPTION: "+e.getMessage());
    	}
	}
	
	public String getHash(File file) {
		try {
		RandomAccessFile f = new RandomAccessFile(file, "r");
		byte[] b = new byte[(int)f.length()];
		f.readFully(b);
		f.close();
		return getHash(b);
		} catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("ReportGeneratorTimer", "getHash", e, "");
			return null;
		}
	}
	
	public String getHash(byte[] b) {
		if (b==null || b.length==0) return "";
		StringBuffer hexString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(b, 0, b.length);

			byte[] mdbytes = md.digest();

			//convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < mdbytes.length; i++) {
				sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			System.out.println("Hex format : " + sb.toString());

		//convert the byte to hex format method 2
			hexString = new StringBuffer();
			for (int i=0;i<mdbytes.length;i++) {
				hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
		}

		System.out.println("Hex format : " + hexString.toString());
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "";
		}
		return hexString.toString();
		
	}
	
	
	public long fileUploadByApp(ServiceContext serviceContext, File file, String folderName, String title, String description, String mimeType)	{
		
	    System.out.println("Exist=>"+file.exists());
		long repositoryId = serviceContext.getScopeGroupId();
	 	//String mimeType = MimeTypesUtil.getContentType(file);
		//String title = file.getName();
		//String description = "This file is added via programatically";
		String changeLog = "hi";
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		if (folderName.startsWith("bollettino")) {
			try {
				BollettinoParametro ap = bollettinoParametroLocalService.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
				if (ap!=null) parentFolderId = Long.parseLong(ap.getValore());
			} catch (Exception e) {}
		} else if (folderName.startsWith("allerta-valanghe")) {
			try {
				AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro("VALANGHE_PARENT_FOLDER_ID");
				if (ap!=null) parentFolderId = Long.parseLong(ap.getValore());
			} catch (Exception e) {}
		} else {
		try {
			AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
			if (ap!=null) parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {}
		}
		
	    try
	    {  
	    	Folder folder =DLAppServiceUtil.getFolder(serviceContext.getScopeGroupId(), parentFolderId, folderName);
	    	List<FileEntry> ll = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
	    	for (FileEntry fe : ll) {
	    		if (fe.getTitle().equals(title))
	    	    	DLAppServiceUtil.deleteFileEntryByTitle(repositoryId, folder.getFolderId(), fe.getTitle());
	    	}
	    	
	    	
	    	InputStream is = new FileInputStream( file );
	    	FileEntry f = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), file.getName(), mimeType, 
	    			title, description, changeLog, is, file.length(), serviceContext);
	    	
	    	Role guestRole = roleLocalService.getRole(serviceContext.getCompanyId(),RoleConstants.GUEST);
	    	resourcePermissionLocalService.setResourcePermissions(serviceContext.getCompanyId(), 
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, 
					String.valueOf(f.getFileEntryId()), guestRole.getRoleId(), new String[]{"VIEW"});
			
			AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro("ALLERTA_RUOLI_MODIFICA_LINK");
			if (ap!=null && ap.getValore()!=null && !ap.getValore().equals("")) {
				String[] ruoli = ap.getValore().split(",");
				for (String s : ruoli) {
					long l = Long.parseLong(s);
					resourcePermissionLocalService.setResourcePermissions(serviceContext.getCompanyId(), DLFileEntry.class.getName(), 
							ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(f.getFileEntryId()), l, new String[]{"VIEW","UPDATE","DELETE"});			
				}
			}
			
			if (is!=null) {
				try {
					is.close();
				} catch (Exception e) {}
			}
			
			return f.getFileEntryId();
	    	
	     }
	    catch (Exception e)
	    {
	    	_log.error(e);
	    	 //logInternoLocalService.log("allertaBean", "fileUpload", e, "");
	    	 return -1;
	    }
	}
	
	
	public void arretratiValanghe(boolean allerte) {
		
		String query= "select allertavalangheid from allerter_allertavalanghe a where tipoallerta and stato=0 and dataemissione<current_timestamp - cast('2 hours' as interval) and not exists "+
				"(select * from parer_datispecificiinvio i where chiave_tipo_registro='METEOMONT' and ('0' || a.numero)=i.chiave_numero || '/' || i.chiave_anno) limit "+LIMITE_ARRETRATI;
		
		String queryB= "select allertavalangheid from allerter_allertavalanghe a where not tipoallerta and stato=0 and dataemissione<current_timestamp - cast('2 hours' as interval) and not exists "+
				"(select * from parer_datispecificiinvio i where chiave_tipo_registro='METEOMONT' and a.numero=i.chiave_numero || '/' || i.chiave_anno) limit "+LIMITE_ARRETRATI;
		
		try {
			List<Object> l = bollettinoLocalService.eseguiQueryGenericaLista(allerte?query:queryB);
			
			for (Object o : l) {
				AllertaValanghe feedback = allertaValangheLocalService.getAllertaValanghe(Long.parseLong(o.toString()));
				PermissionChecker perm = PermissionCheckerFactoryUtil.create(userLocalService.fetchUser(feedback.getUserId()));
				PermissionThreadLocal.setPermissionChecker(perm);
				
				_log.info("Arretrati valanghe: "+feedback.getAllertaValangheId());
				//logInternoLocalService.log("arretratiAllerte", ""+feedback.getAllertaId(), "","");
				
				User arpa = userLocalService.getUser(feedback.getUtenteFirmaArpaId());
        		User pc = userLocalService.getUser(feedback.getUtenteFirmaProtId());
        		
        		DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
				dsi.setCHIAVE_NUMERO((feedback.getTipoAllerta()?"0":"")
						+feedback.getNumero().split("/")[0]);
				dsi.setCHIAVE_ANNO(Long.parseLong(feedback.getNumero().split("/")[1]));
				dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
				dsi.setIDENTIFICATIVO_DATO_SPECIFICO("" + feedback.getAllertaValangheId());
				dsi.setDATA_GENERAZIONE(feedback.getCreateDate());
				dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");
				dsi.setCOMPILATORE_ARPAE(feedback.getCreatorName());
				dsi.setCOMPILATORE_PROTEZIONE_CIVILE(feedback.getUserName());
				dsi.setAPPROVATORE_ARPAE(arpa.getFullName());
				dsi.setAPPROVATORE_PROTEZIONE_CIVILE(pc.getFullName());
				dsi.setDATA_INIZIO_VALIDITA(feedback.getDataInizio());
				dsi.setDATA_FINE_VALIDITA(feedback.getDataFine());
				dsi.setDATA_FIRMA_ARPAE(feedback.getDataFirmaArpa());
				dsi.setDATA_FIRMA_PROTEZIONE_CIVILE(feedback.getDataFirmaProt());
        		
        		ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
        		ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
        		
        		ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
        		c.setHASH_VERSATO(feedback.getHash());
        		
        		FileEntry f = getValangheReportId(feedback);
        		c.setID_COMPONENTE_VERSATO(f.getFileEntryId());
        		c.setNOME_COMPONENTE(f.getTitle());
        		c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it"+feedback.getLink());
        		c.setFORMATO_FILE_VERSATO("PDF");
        		componentiInvio.add(c);
        		datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioValanghe
        			(dsi, documentiCollegati, componentiInvio);
        		
			}
		}
	    catch (Exception e)
	    {
	    	_log.error(e);
	    	 //logInternoLocalService.log("arretratiAllerte", "fileUpload", e, "");
	    	 return;
	    }	
		
	}
	
	public void arretratiAllerte(boolean allerte) {
		
		String query= "select allertaid from allerter_allerta a where tipoallerta and stato=0 and dataemissione<current_timestamp - cast('2 hours' as interval) and not exists "+
				"(select * from parer_datispecificiinvio i where chiave_tipo_registro='ALLERTE' and a.numero=i.chiave_numero || '/' || i.chiave_anno) limit "+LIMITE_ARRETRATI;
		
		String queryB= "select allertaid from allerter_allerta a where not tipoallerta and stato=0 and dataemissione<current_timestamp - cast('2 hours' as interval) and not exists "+
				"(select * from parer_datispecificiinvio i where chiave_tipo_registro='BOLLETTINI' and a.numero=i.chiave_numero || '/' || i.chiave_anno) limit "+LIMITE_ARRETRATI;
		
		try {
			List<Object> l = bollettinoLocalService.eseguiQueryGenericaLista(allerte?query:queryB);
			
			for (Object o : l) {
				Allerta feedback = allertaLocalService.getAllerta(Long.parseLong(o.toString()));
				PermissionChecker perm = PermissionCheckerFactoryUtil.create(userLocalService.fetchUser(feedback.getUserId()));
				PermissionThreadLocal.setPermissionChecker(perm);
				
				_log.info("Arretrati allerte: "+feedback.getAllertaId());
				//logInternoLocalService.log("arretratiAllerte", ""+feedback.getAllertaId(), "","");
				
				User arpa = userLocalService.getUser(feedback.getUtenteFirmaArpaId());
        		User pc = userLocalService.getUser(feedback.getUtenteFirmaProtId());
        		
        		DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
        		dsi.setCHIAVE_NUMERO(feedback.getNumero().split("/")[0]);
        		dsi.setCHIAVE_ANNO(Long.parseLong(feedback.getNumero().split("/")[1]));
        		dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
        		dsi.setIDENTIFICATIVO_DATO_SPECIFICO(""+feedback.getAllertaId());
        		dsi.setDATA_GENERAZIONE(feedback.getCreateDate());
        		dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");
        		dsi.setCOMPILATORE_ARPAE(feedback.getCreatorName());
        		dsi.setCOMPILATORE_PROTEZIONE_CIVILE(feedback.getUserName());
        		dsi.setAPPROVATORE_ARPAE(arpa.getFullName());
        		dsi.setAPPROVATORE_PROTEZIONE_CIVILE(pc.getFullName());
        		dsi.setDATA_INIZIO_VALIDITA(feedback.getDataInizio());
        		dsi.setDATA_FINE_VALIDITA(feedback.getDataFine());
        		dsi.setDATA_FIRMA_ARPAE(feedback.getDataFirmaArpa());
        		dsi.setDATA_FIRMA_PROTEZIONE_CIVILE(feedback.getDataFirmaProt());
        		
        		ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
        		ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
        		
        		ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
        		c.setHASH_VERSATO(feedback.getHash());
        		
        		FileEntry f = getReportId(feedback);
        		c.setID_COMPONENTE_VERSATO(f.getFileEntryId());
        		c.setNOME_COMPONENTE(f.getTitle());
        		c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it"+feedback.getLink());
        		c.setFORMATO_FILE_VERSATO("PDF");
        		componentiInvio.add(c);
        		if (feedback.getTipoAllerta())
        			datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioAllerta
        			(dsi, documentiCollegati, componentiInvio);
        		else 
        			datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioAllertaBollettino
        			(dsi, documentiCollegati, componentiInvio);
			}
		}
	    catch (Exception e)
	    {
	    	_log.error(e);
	    	 //logInternoLocalService.log("arretratiAllerte", "fileUpload", e, "");
	    	 return;
	    }	
		
	}
	
	
    private FileEntry getReportId(Allerta a) {
    	
    	try {
    	
	    	Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	    	
	    	try {
	    		AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
	    		if (ap!=null) parentFolderId = Long.parseLong(ap.getValore());
	    	} catch (Exception e) {}
	    	
	    	Folder folder =DLAppServiceUtil.getFolder(20181, parentFolderId, "allerta-"+a.getAllertaId());
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(20181, folder.getFolderId());
			
			for (FileEntry f : fileEntries) {
				if (f.getTitle().startsWith("allerta") || f.getTitle().startsWith("bollettino")) {
					return f;
				}
			}
			
			return null;
			
    	} catch (Exception e) {
    		_log.error(e);
    		//logInternoLocalService.log("AllertaWorkflow", "getReportId", e, "");
    		return null;
    	}
    	
    }
    
    private FileEntry getValangheReportId(AllertaValanghe a) {
    	
    	try {
    	
	    	Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	    	
	    	try {
	    		AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro("VALANGHE_PARENT_FOLDER_ID");
	    		if (ap!=null) parentFolderId = Long.parseLong(ap.getValore());
	    	} catch (Exception e) {}
	    	
	    	Folder folder =DLAppServiceUtil.getFolder(20181, parentFolderId, "allerta-valanghe-"+a.getAllertaValangheId());
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(20181, folder.getFolderId());
			
			for (FileEntry f : fileEntries) {
				if (f.getTitle().startsWith("allerta") || f.getTitle().startsWith("bollettino")) {
					return f;
				}
			}
			
			return null;
			
    	} catch (Exception e) {
    		_log.error(e);
    		//logInternoLocalService.log("AllertaWorkflow", "getReportId", e, "");
    		return null;
    	}
    	
    }
    
    public void arretratiMonitoraggi() {
    	String query= "select bollettinoid from bollettino_bollettino a where stato=0 and dataemissione<current_timestamp - cast('2 hours' as interval) and not exists "+
    "(select * from parer_datispecificiinvio i where chiave_tipo_registro='MONITORAGGI' and a.bollettinoid || '' = i.identificativo_dato_specifico) limit "+LIMITE_ARRETRATI;

		try {
			List<Object> l = bollettinoLocalService.eseguiQueryGenericaLista(query);
			
			for (Object o : l) {
				Bollettino feedback = bollettinoLocalService.getBollettino(Long.parseLong(o.toString()));
				PermissionChecker perm = PermissionCheckerFactoryUtil.create(userLocalService.fetchUser(feedback.getUserId()));
				PermissionThreadLocal.setPermissionChecker(perm);
				
				User arpa = userLocalService.fetchUser(feedback.getIdApprovatore());
        		String[] num = feedback.getNumero().split("/");
        		DatiSpecificiInvio dsi = datiSpecificiInvioLocalService.createDatiSpecificiInvio(0);
        		dsi.setCHIAVE_NUMERO(num[0]+num[2].substring(0, 2));
        		dsi.setCHIAVE_ANNO(Long.parseLong(num[1]));
        		dsi.setDATA_UNITA_DOCUMENTARIA(feedback.getDataEmissione());
        		dsi.setIDENTIFICATIVO_DATO_SPECIFICO(""+feedback.getBollettinoId());
        		dsi.setDATA_GENERAZIONE(feedback.getCreateDate());
        		dsi.setDENOMINAZIONE_APPLICATIVO("AllertaMeteoER");
        		dsi.setCOMPILATORE_ARPAE(feedback.getUserName());
        		dsi.setAPPROVATORE_ARPAE(arpa!=null?arpa.getFullName():"");
        		dsi.setDATA_INIZIO_VALIDITA(feedback.getDataInizio());
        		dsi.setDATA_FINE_VALIDITA(feedback.getDataFine());
        		dsi.setDATA_FIRMA_ARPAE(feedback.getDataApprovazione());

        		ArrayList<DocumentiCollegati> documentiCollegati = new ArrayList<DocumentiCollegati>();
        		ArrayList<ComponentiInvio> componentiInvio = new ArrayList<ComponentiInvio>();
        		
        		ComponentiInvio c = componentiInvioLocalService.getNuovoComponenteInvio();
        		c.setHASH_VERSATO(feedback.getHash());
        		FileEntry f = getReportId(feedback);
        		if (f==null) continue;
        		c.setID_COMPONENTE_VERSATO(f.getFileEntryId());
        		c.setNOME_COMPONENTE(f.getTitle());
        		c.setURN_VERSATO("https://allertameteo.regione.emilia-romagna.it"+feedback.getLink());
        		c.setFORMATO_FILE_VERSATO("PDF");
        		componentiInvio.add(c);
        			datiSpecificiInvioLocalService.comunicaDatiSpecificiInvioMonitoraggio
        			(dsi, documentiCollegati, componentiInvio);
			}
		}
	    catch (Exception e)
	    {
	    	_log.error(e);
	    	 //logInternoLocalService.log("arretratiMonitoraggi", "fileUpload", e, "");
	    	 return;
	    }	
    }
    
    private FileEntry getReportId(Bollettino a) {
    	
    	try {
    	
        	Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
        	
        	try {
        		BollettinoParametro ap = bollettinoParametroLocalService.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
        		if (ap!=null) parentFolderId = Long.parseLong(ap.getValore());
        	} catch (Exception e) {}
        	
        	Folder folder =DLAppServiceUtil.getFolder(20181, parentFolderId, "bollettino-"+a.getBollettinoId());
    		List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(20181, folder.getFolderId());
    		
    		for (FileEntry f : fileEntries) {
    			if (f.getTitle().startsWith("monitoraggio")) {
    				return f;
    			}
    		}
    		
    		return null;
    		
    	} catch (Exception e) {
    		_log.error(e);
    		//logInternoLocalService.log("BollettinoWorkflow", "getReportAsFile", e, "");
    		return null;
    	}
    	
    }
    

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		
		Class<?> clazz = getClass();

		String className = clazz.getName();
		
		AllertaBaseSchedulersConfiguration configuration = AllertaTracker.getAllertaSchedulersConfiguration();
		
		_log.info("ReportoGeneratori scheduling at " + configuration.schedulerReportGeneratorMinutes());
		
		if (configuration.schedulerReportGeneratorMinutes()<1) return;

		Trigger trigger = _triggerFactory.createTrigger(className, className, null, null, configuration.schedulerReportGeneratorMinutes(), TimeUnit.MINUTE);

		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(className, trigger);

		baseScheduler.register(this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
		
	}

	@Deactivate
	protected void deactivate() {
		baseScheduler.unregister(this);
	}
	
	private Log _log = LogFactoryUtil.getLog(ReportGeneratorScheduler.class);
	
	@Reference
	private SchedulerEngineHelper baseScheduler;
	
	@Reference
	private TriggerFactory _triggerFactory;
	
    @Reference
    private BollettinoLocalService bollettinoLocalService;

    @Reference
    private UserLocalService userLocalService;

    @Reference
    private AllarmeLocalService allarmeLocalService;
    
    @Reference
    private Portal portal;

    @Reference
    private DatiSpecificiInvioLocalService datiSpecificiInvioLocalService;
    
    @Reference
    private ComponentiInvioLocalService componentiInvioLocalService;
    
    @Reference
    private DocumentiCollegatiLocalService documentiCollegatiLocalService;
    
    @Reference
    private RegolaAllarmeLocalService regolaAllarmeLocalService;
    
    @Reference
    private BollettinoParametroLocalService bollettinoParametroLocalService;

    @Reference
    private RoleLocalService roleLocalService;
    
    @Reference
    private ResourcePermissionLocalService resourcePermissionLocalService;
    
    @Reference
    private AllertaParametroLocalService allertaParametroLocalService;
    
    @Reference
    private AllertaLocalService allertaLocalService;
    
    @Reference
    private AllertaValangheLocalService allertaValangheLocalService;
    
    @Reference
    private JasperUtils jasperUtils;
    
    //@Reference
    //private LogInternoLocalService logInternoLocalService;
}
