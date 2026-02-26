/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.impl;

import com.liferay.portal.aop.AopService;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import allerta.bollettino.service.util.DownloaderDati;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.bollettino.cron.RisultatiAggiornamento;
import it.eng.bollettino.model.RegolaAllarmeCondizione;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.model.Variabile;
import it.eng.bollettino.service.StazioneLocalServiceUtil;
import it.eng.bollettino.service.StazioneVariabileLocalServiceUtil;
import it.eng.bollettino.service.VariabileLocalServiceUtil;
import it.eng.bollettino.service.base.StazioneVariabileLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.bollettino.model.StazioneVariabile",
	service = AopService.class
)
public class StazioneVariabileLocalServiceImpl
	extends StazioneVariabileLocalServiceBaseImpl {
	

	private Log logger = LogFactoryUtil.getLog(StazioneVariabileLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.bollettino.service.StazioneVariabileLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.bollettino.service.StazioneVariabileLocalServiceUtil</code>.
	 */
	
	public List<StazioneVariabile> getStazioneVariabile( String idStazione, String idVariabile) {
		
		DynamicQuery dyn = 
				DynamicQueryFactoryUtil
					.forClass(StazioneVariabile.class, getClassLoader())
					.add(PropertyFactoryUtil.forName("idStazione").eq(idStazione))
					.add(PropertyFactoryUtil.forName("idVariabile").eq(idVariabile));
		
		return StazioneVariabileLocalServiceUtil.dynamicQuery(dyn);
	}
	
	public RisultatiAggiornamento aggiornaSensori() {
		
		RisultatiAggiornamento out = new RisultatiAggiornamento();
		
		String dati = DownloaderDati.downloadSensori();
		if (dati==null) {
			out.errore = "Impossibile scaricare web service sensori";
			return out;
		}
		
		Map<String,List<Object>> v = DownloaderDati.convertiJsonGenerico(dati);
		if (v==null) {
			out.errore = "Dati sensori in formato non comprensibile";
			return out;
		}
		
		List<StazioneVariabile> all = getStazioneVariabiles(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<StazioneVariabile> all2 = new ArrayList<StazioneVariabile>();
		all2.addAll(all);
		
		Map<String,StazioneVariabile> map = new HashMap<String, StazioneVariabile>();
		for (StazioneVariabile sv : all) {
			String key = sv.getIdStazione()+sv.getIdVariabile();
			map.put(key, sv);
		}
		
		for (String var : v.keySet()) {
			for (Object o : v.get(var)) {
				try {
					
					
					Map<String,Object> sensore = (Map)o;
					String stazione = (String)sensore.get("station");
					
					
					for (int k=0; k<all2.size(); k++) {
						StazioneVariabile ssvv = all2.get(k);
						if (ssvv.getIdStazione().equals(stazione) && ssvv.getIdVariabile().equals(var)) {
							all2.remove(k);
							break;
						}
					}
					
					Map<String,Object> datiSensore = (Map)sensore.get("sensor");
					double soglia1 = 0.0;
					double soglia2 = 0.0;
					double soglia3 = 0.0;
					
					Integer progressivo = null;
					
					if (datiSensore!=null) {
						Object hydroInfo = datiSensore.get("hydroinfo");
						if (hydroInfo!=null) {
							Object thresholds = ((Map<String,Object>)hydroInfo).get("thresholds");
							if (thresholds!=null) {
								List<Object> t = (List)thresholds;
								if (t!=null) {
									soglia1 = (t.get(0)!=null?Double.parseDouble(t.get(0).toString()):0.0);
									soglia2 = (t.get(1)!=null?Double.parseDouble(t.get(1).toString()):0.0);
									soglia3 = (t.get(2)!=null?Double.parseDouble(t.get(2).toString()):0.0);
								}
							}
							Object streamOrder = ((Map<String,Object>)hydroInfo).get("stream_order");
							
							if (streamOrder!=null && !streamOrder.toString().equals("P") && !streamOrder.toString().equals("T")) {
								try {
									progressivo = Integer.parseInt(streamOrder.toString());
								} catch (Exception e) {
									//logger.error(e);
								}
							}
							
						}
					}
					
					if (stazione==null) continue;
					
					boolean changed = false;
					
					if (progressivo!=null) {
						try {
							Stazione s = StazioneLocalServiceUtil.fetchStazione(stazione);
							if (s!=null) {
								int i = s.getProgressivo();
								if (i!=progressivo.intValue()) {
									s.setProgressivo(progressivo);
									StazioneLocalServiceUtil.updateStazione(s);
									changed=true;
								}
							}
						} catch (Exception e) {
							logger.error(e);
						}
					}
					
					StazioneVariabile l = map.get(stazione+var);
					
					if (l==null) {
						changed = true;
						out.aggiunti++;
						l = createStazioneVariabile(0);
						l.setIdStazione(stazione);
						l.setIdVariabile(var);
						Stazione s = StazioneLocalServiceUtil.fetchStazione(stazione);
						Variabile vb = VariabileLocalServiceUtil.fetchVariabile(var);
						out.aggiungi(l.getIdStazione()+" ("+(s!=null?s.getName():"")+") - variabile "+var+" ("+(vb!=null?vb.getDescription_it():"")+")");
					} else {
						
						if (l.getSoglia1()!=soglia1) changed = true;
						if (l.getSoglia2()!=soglia2) changed = true;
						if (l.getSoglia3()!=soglia3) changed = true;
						if (changed) {
							Stazione s = StazioneLocalServiceUtil.fetchStazione(stazione);
							Variabile vb = VariabileLocalServiceUtil.fetchVariabile(var);
							//Niente più avvisi per i cambiamenti alle soglie
							/*out.modificati++;
							if (s!=null)
								out.modifica(l.getIdStazione()+" ("+(s!=null?s.getName():"")+") - variabile "+var+" ("+(vb!=null?vb.getDescription_it():"")+")");
							*/
						}
					}
					l.setSoglia1(soglia1);
					l.setSoglia2(soglia2);
					l.setSoglia3(soglia3);
					if (changed) updateStazioneVariabile(l);
					
					
				} catch (Exception e) {
					logger.error(e);
				}
			}
			
		}
		
		try {
			for (StazioneVariabile ssvv : all2) {
				if (ssvv==null) continue;
				
				if ("254,0,0/101,-,-,-/B22037".equals(ssvv.getIdVariabile())) continue;
				if ("200,0,1800/1,-,-,-/M00001".equals(ssvv.getIdVariabile())) continue;
				if ("0,0,1800/1,-,-,-/M00002".equals(ssvv.getIdVariabile())) continue;
				
				Stazione st = StazioneLocalServiceUtil.fetchStazione(ssvv.getIdStazione());
				Variabile vb = VariabileLocalServiceUtil.fetchVariabile(ssvv.getIdVariabile());

				out.rimossi++;
				out.rimuovi(ssvv.getIdStazione()+" ("+st.getName()+") variabile "+ssvv.getIdVariabile()+" ("+(vb!=null?vb.getDescription_it():"")+")");
				StazioneVariabileLocalServiceUtil.deleteStazioneVariabile(ssvv);
				LogInternoLocalServiceUtil.log("rimuoviSV", "rimuoviSV", "Rimuovo "+ssvv.getIdStazione()+" ("+(st!=null?st.getName():"???")+") variabile "+ssvv.getIdVariabile(), "");
			}
		}
		catch (Exception e) {
			logger.error(e);
			LogInternoLocalServiceUtil.log("rimuoviSV", "rimuoviSV", e, "");
		}
		
		return out;
		
	}
}