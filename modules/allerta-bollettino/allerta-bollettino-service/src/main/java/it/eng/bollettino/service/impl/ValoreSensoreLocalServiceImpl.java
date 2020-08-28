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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONDeserializer;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import allerta.bollettino.service.util.DownloaderDati;
import it.eng.bollettino.cron.CaricaDBTask;
import it.eng.bollettino.cron.RisultatiAggiornamento;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.model.Stazione;
import it.eng.bollettino.model.StazioneVariabile;
import it.eng.bollettino.model.ValoreSensore;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;
import it.eng.bollettino.service.StazioneVariabileLocalService;
import it.eng.bollettino.service.StazioneVariabileLocalServiceUtil;
import it.eng.bollettino.service.ValoreSensoreLocalServiceUtil;
import it.eng.bollettino.service.base.ValoreSensoreLocalServiceBaseImpl;

/**
 * The implementation of the valore sensore local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.bollettino.service.ValoreSensoreLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author GFAVINI
 * @see ValoreSensoreLocalServiceBaseImpl
 */
public class ValoreSensoreLocalServiceImpl
	extends ValoreSensoreLocalServiceBaseImpl {
	
	private Log logger = LogFactoryUtil.getLog(ValoreSensoreLocalServiceBaseImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.bollettino.service.ValoreSensoreLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.bollettino.service.ValoreSensoreLocalServiceUtil</code>.
	 */
	
	public Map<String,Object> aggiornaDatiOsservati(String dati) {
		
		HashMap<String,Object> m = new HashMap<String, Object>();
		
		JSONDeserializer<ArrayList> deserializer = 
				JSONFactoryUtil.createJSONDeserializer();
		
		boolean idro = false;
		boolean pluvio = false;
		
		 ArrayList al = deserializer.deserialize(dati);
		 if (al==null || al.size()==0) {
			 m.put("valori", 0);
			 m.put("idro", false);
			 m.put("pluvio", false);
			 return m;
		 }
		 
		 SimpleDateFormat atom = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		 
		 for (int k=0; k<al.size(); k++) {
			 
			 try {
				 Map<String, Object> o = (Map<String, Object>) al.get(k);
				 if (o==null) continue;
				 
				 String dt = (String) o.get("t");
				 if (dt.endsWith("Z")) dt = dt.substring(0, dt.length()-1);
				 String stazione = (String) o.get("sta");
				 String variabile = (String) o.get("var");
				 Double v = (o.get("v")!=null?Double.parseDouble(o.get("v").toString()):null);
				 Date dat = atom.parse(dt);
				 
				 DynamicQuery dq = DynamicQueryFactoryUtil
							.forClass(ValoreSensore.class, getClassLoader())
					.add(PropertyFactoryUtil.forName("idStazione").eq(stazione))
					.add(PropertyFactoryUtil.forName("idVariabile").eq(variabile))
					.add(PropertyFactoryUtil.forName("datetime").eq(dat));
				 
				 List<ValoreSensore> valori = dynamicQuery(dq);
				 
				 if (v==null) {
					 //annullamento valore
					 for (ValoreSensore vs : valori) deleteValoreSensore(vs);
					 continue;
				 }
				 
				 if (variabile.contains("B13215")) idro = true;
				 if (variabile.contains("B13011")) pluvio = true;
				 
				 
				 if (valori.size()==0) {
					 //inserimento
					 ValoreSensore vs = ValoreSensoreLocalServiceUtil.createValoreSensore(0);
					 vs.setIdStazione(stazione);
					 vs.setIdVariabile(variabile);
					 vs.setDatetime(dat);
					 vs.setValue(v);
					 ValoreSensoreLocalServiceUtil.updateValoreSensore(vs);
				 } else {
					 //se ce n'è più di uno cancellali
					 for (int i=0; i<valori.size()-1; i++) deleteValoreSensore(valori.get(i));
					 ValoreSensore vs = valori.get(valori.size()-1);
					 vs.setValue(v);
					 ValoreSensoreLocalServiceUtil.updateValoreSensore(vs);
				 }
				 
				 //aggiorna ultima data sensore
				 DynamicQuery dq2 = DynamicQueryFactoryUtil.forClass(StazioneVariabile.class,getClassLoader())
				 .add(PropertyFactoryUtil.forName("idStazione").eq(stazione))
					.add(PropertyFactoryUtil.forName("idVariabile").eq(variabile));
				 List<StazioneVariabile> stv = dynamicQuery(dq2);
				 if (stv!=null && stv.size()>0) {
					 StazioneVariabile ssvv = stv.get(0);
					 if (ssvv.getDataUltimoValore()==null || dat.after(ssvv.getDataUltimoValore())) {
						 ssvv.setDataUltimoValore(dat);
						 StazioneVariabileLocalServiceUtil.updateStazioneVariabile(ssvv);
					 }
				 }
				 
			 } catch (Exception e) {
				 logger.error(e);
			 }
			 
			 
		 }
		 
		 String query = "delete from bollettino_valoresensore where datetime < cast(now() as timestamp) - cast('7 days' as interval)";
		 BollettinoLocalServiceUtil.eseguiQueryGenericaLista(query);
			
		 
		 m.put("valori", al.size());
		 m.put("idro", idro);
		 m.put("pluvio", pluvio);
		 
		 return m;
	}
	
	
	public boolean controlloPioggiaMonitoraggio() {
		
		
		String query1 = "select count(*) from allerter_allerta a where a.datafine > current_timestamp and a.stato = 0 and exists (select * from allerter_allertastato s where "+
				" s.allertaid = a.allertaid and s.eventoid<4 and s.statoid in (1,2,3))";
		String query2 = "select max(value) from bollettino_valoresensore v join bollettino_stazionevariabile sv on v.idstazione = sv.idstazione and v.idvariabile = sv.idvariabile  where v.datetime=sv.dataultimovalore and v.idvariabile in ('1,0,3600/1,-,-,-/B13011','1,0,1800/1,-,-,-/B13011','1,0,900/1,-,-,-/B13011')";
		
		try {
			
			BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("CONTROLLO_MONITORAGGIO");
			//logInternoLocalService.log("caricaDbTask", "controlloPioggiaMonitoraggio", "bp "+bp.getValore(), "");
			if (bp==null || bp.getValore()==null || !bp.getValore().equals("true")) return false;
			
			Object o = BollettinoLocalServiceUtil.eseguiQueryGenerica(query1);
			if (o==null) return false;
			Integer i =Integer.parseInt(o.toString());
			//logInternoLocalService.log("caricaDbTask", "controlloPioggiaMonitoraggio", "i "+i, "");
			if (i.intValue()<1) return false;
			
			o = BollettinoLocalServiceUtil.eseguiQueryGenerica(query2);
			if (o==null) return false;
			
			double d = Double.parseDouble(o.toString());
			//logInternoLocalService.log("caricaDbTask", "controlloPioggiaMonitoraggio", "d "+d, "");
			
			BollettinoParametro bp2 = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("SOGLIA_PIOGGIA_MONITORAGGIO");
			double d2 = (bp2!=null? Double.parseDouble(bp2.getValore()) : 5.0);
			//logInternoLocalService.log("caricaDbTask", "controlloPioggiaMonitoraggio", "d2 "+d2, "");
			if (d<d2) return false;
			
			//scatenate l'inferno
			bp.setValore("false");
			BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);
			
			bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GESTIONE_MONITORAGGIO");
			//logInternoLocalService.log("caricaDbTask", "controlloPioggiaMonitoraggio", "bp2 "+bp.getValore(), "");
			if (bp==null) return false;
			bp.setValore("true");
			BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);
			
			logger.warn("Monitoraggio attivato automaticamente");
			return true;
			
		} catch (Exception e) {
			logger.error(e);
			return false;
			//logInternoLocalService.log("caricaDbTask","controlloPioggiaMonitoraggio", e, null);
		}
		
		
	}
	
	public Date getDataAggiornamentoStazioneVariabile(String stazione, String variabile) {

		try {
			DynamicQuery varStaz = dynamicQuery()
					.add(PropertyFactoryUtil.forName("idStazione").eq(stazione))
					.add(PropertyFactoryUtil.forName("idVariabile").eq(variabile))
					.addOrder(OrderFactoryUtil.desc("datetime"));
			List<ValoreSensore> vs = dynamicQuery(varStaz,0,1);

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
	
	public RisultatiAggiornamento aggiornaTuttiDatiOsservati() {
		
		RisultatiAggiornamento out = new RisultatiAggiornamento();

		String dati = DownloaderDati.downloadDatiOsservati();
		if (dati==null) {
			out.errore = "Impossibile scaricare web service dati osservati";
			return out;
		}
		
		Map<String,Object> map = aggiornaDatiOsservati(dati);
		
		out.aggiunti = (Integer)map.get("valori");
		
		return out;
	}
}