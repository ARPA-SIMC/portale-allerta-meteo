/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.bollettino.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.WorkflowDefinitionLink;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import it.eng.bollettino.cron.ValutatoreEspressioni;
import it.eng.bollettino.model.Allarme;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.model.RegolaAllarme;
import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.model.ValoreSensore;
import it.eng.bollettino.service.AllarmeLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;
import it.eng.bollettino.service.RegolaAllarmeCondizioneLocalServiceUtil;
import it.eng.bollettino.service.RegolaAllarmeLocalServiceUtil;
import it.eng.bollettino.service.StazioneLocalServiceUtil;
import it.eng.bollettino.service.StazioneVariabileLocalServiceUtil;
import it.eng.bollettino.service.ValoreSensoreLocalServiceUtil;
import it.eng.bollettino.service.base.RegolaAllarmeLocalServiceBaseImpl;

/**
 * The implementation of the regola allarme local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.bollettino.service.RegolaAllarmeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmeLocalServiceBaseImpl
 */
public class RegolaAllarmeLocalServiceImpl
	extends RegolaAllarmeLocalServiceBaseImpl {
	
	private Log logger = LogFactoryUtil.getLog(RegolaAllarmeLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.bollettino.service.RegolaAllarmeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.bollettino.service.RegolaAllarmeLocalServiceUtil</code>.
	 */
	
	public Map<String,Object> regoleAllarme() {
		
		HashMap<String,Object> out = new HashMap<String, Object>();
		List<String> superamentiIdro = new ArrayList<String>();
		List<String> superamentiPluvio = new ArrayList<String>();
		List<String> superamentiCessati = new ArrayList<String>();
		List<Object[]> spike = new ArrayList<Object[]>();
		out.put("superamentiIdro", superamentiIdro);
		out.put("superamentiPluvio", superamentiPluvio);
		out.put("superamentiCessati", superamentiCessati);
		out.put("spike", spike);

		try {
			
			boolean oraLegale = TimeZone.getDefault().inDaylightTime( new Date() );

			List<Company> comp = CompanyLocalServiceUtil.getCompanies();
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
				
				Date d = ValoreSensoreLocalServiceUtil.getDataAggiornamentoStazioneVariabile(s,"254,0,0/1,-,-,-/B13215");
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
					Object[] o = new Object[5];
					o[0] = s;
					o[1] = nom;
					o[2] = d;
					o[3] = delta;
					o[4] = soglia;
					//logInternoLocalService.log("rt_data","Spike rilevato",s+" ("+nom+") -> "+delta+"m","");
					spike.add(o);
					//notificaSpike(s,nom,d,delta,soglia);
				}
			}


			
			List<String> idroDisattivati = BollettinoLocalServiceUtil.eseguiQueryGenericaLista("select idstazione from bollettino_disattivazionesensore where idvariabile='254,0,0/1,-,-,-/B13215'");
			List<String> pluvioDisattivati = BollettinoLocalServiceUtil.eseguiQueryGenericaLista("select idstazione from bollettino_disattivazionesensore where idvariabile like '%B13011'");
			logger.info("controllo "+regole.size()+" regole, disattivati "+idroDisattivati.size()+" idrometri e "+pluvioDisattivati.size()+" pluviometri.");
			
			for (RegolaAllarme r : regole) {
				
				try {
					
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

					Stazione t = StazioneLocalServiceUtil.getStazione(st);
					
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
					
					/*GPF 2020-03-05 Se il valore del dato è vecchio rischiamo di
					 * generare un allarme per un sensore inattivo il cui ultimo
					 * valore era in superamento soglia. Limitiamo l'età del dato.
					 */
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

					/*if (pioggia && r.getColore() == 1)
						valoreSoglia = 30;
					else if (pioggia && r.getColore() == 2)
						valoreSoglia = 75;
					else*/ if (c.getSoglia() == 1)
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
					RegolaAllarme regCessata = fetchRegolaAllarme(a.getIdRegola());
					if (regCessata!=null) superamentiCessati.add(regCessata.getNome());
				}
			}

			/*
			 * for (Allarme a : allarmi) {
			 * 
			 * long regola = a.getIdRegola();
			 * 
			 * boolean trovato = false;
			 * 
			 * for (RegolaAllarme ra : regoleSoddisfatte) { if
			 * (ra.getId()==regola) { trovato = true; break; } }
			 * 
			 * if (!trovato) { //a.setDataFine(d);
			 * //AllarmeLocalServiceUtil.updateAllarme(a); }
			 * 
			 * 
			 * }
			 */

			// cerca gli allarmi già collegati alle regole, per crearne di nuovi
			// dove non presenti
			for (RegolaAllarme ra : regoleSoddisfatte) {

				boolean trovato = false;
				//if (debugMode) logInternoLocalService.log("CaricaDBTask.regoleAllarme", "debug", "Esamino regola soddisfatta: "+ra.getNome(), "");

				for (Allarme a : allarmi) {
					if (ra.getId() == a.getIdRegola()) {
						trovato = true;
						break;
					}
				}

				if (!trovato) {
					
					

					// crea un allarme per ogni comune/gruppo destinatario
					// INVECE NO - ORA CREIAMO UN SOLO ALLARME CHE VALE PER
					// TUTTI I COMUNI
					//DynamicQuery com = regolaAllarmeComuneLocalService.dynamicQuery()
					//		.add(PropertyFactoryUtil.forName("idRegola").eq(ra.getId()));
					//List<RegolaAllarmeComune> comuni = RegolaAllarmeComuneLocalServiceUtil.dynamicQuery(com);

					// for (RegolaAllarmeComune comune : comuni) {

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
					//logInternoLocalService.log("superamenti", "Nuovo superamento idrometrico", ra.getNome(), "");
					superamentiIdro.add(ra.getNome());
					
					AssetEntryLocalServiceUtil.updateEntry(0, 20194, Allarme.class.getName(), al.getAllarmeId(),
							new long[] {}, new String[] {});
					
					try {
						AssetEntry ae = AssetEntryLocalServiceUtil.fetchEntry(Allarme.class.getName(), al.getAllarmeId());
						if (ae!=null) {
							String data = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()); 
							ae.setTitle("Superamento regola "+ra.getNome()+" del "+data);
							ae.setCreateDate(new Date());
							ae.setModifiedDate(new Date());
							ae.setDescription("Superamento regola "+ra.getNome()+" del "+data);
							ae.setSummary("Superamento regola "+ra.getNome()+" del "+data);
							AssetEntryLocalServiceUtil.updateAssetEntry(ae);
						}
					} catch (Exception exx) {
						logger.error(exx);
					}

					WorkflowDefinitionLink workflowDefinitionLink = null;
					try {
						workflowDefinitionLink = WorkflowDefinitionLinkLocalServiceUtil
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
						//logInternoLocalService.log("caricaDbTask.regoleAllarme", ""+al.getAllarmeId(), ex, null);

					}

					// }

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
						//logInternoLocalService.log("superamenti", "Nuovo superamento pluviometrico", ra.getNome(), "");
						superamentiPluvio.add(ra.getNome());
						
						AllarmeLocalServiceUtil.updateAllarme(al);

						AssetEntryLocalServiceUtil.updateEntry(0, 20194, Allarme.class.getName(),
								al.getAllarmeId(), new long[] {}, new String[] {});


						
						try {
							WorkflowDefinitionLink workflowDefinitionLink = null;
							workflowDefinitionLink = WorkflowDefinitionLinkLocalServiceUtil
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
		
		return out;

	}
}