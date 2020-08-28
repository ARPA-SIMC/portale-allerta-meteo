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

package it.eng.radarMeteo.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Transactional;

import it.eng.radarMeteo.bean.BacinoMonitoraggioBean;
import it.eng.radarMeteo.bean.BollettinoMonitoraggioBean;
import it.eng.radarMeteo.bean.InfoValoreBean;
import it.eng.radarMeteo.bean.SottoBacinoMonitoraggioBean;
import it.eng.radarMeteo.model.Comuni_bacini_ws;
import it.eng.radarMeteo.service.base.Comuni_bacini_wsServiceBaseImpl;

/**
 * The implementation of the comuni_bacini_ws remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.radarMeteo.service.Comuni_bacini_wsService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Francesco
 * @see Comuni_bacini_wsServiceBaseImpl
 */
public class Comuni_bacini_wsServiceImpl
	extends Comuni_bacini_wsServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>it.eng.radarMeteo.service.Comuni_bacini_wsServiceUtil</code> to access the comuni_bacini_ws remote service.
	 */
	
	private final Log _log = LogFactoryUtil.getLog(Comuni_bacini_wsServiceImpl.class);
	
	@Transactional
	public Map<String,Object> getBollettinoMonitoraggio(){
		Map<String,Object> result = new HashMap<String, Object>();
		List<Object[]> getBollettinoMonitoraggio = comuni_wsFinder.getBollettinoMonitoraggio();
		for(Object[] value:getBollettinoMonitoraggio){
			if(!result.containsKey(value[0])){
				result.put((String)value[0], new BollettinoMonitoraggioBean());
				((BollettinoMonitoraggioBean)result.get(value[0])).setInizioMonitoraggio((Timestamp)value[1]);
				((BollettinoMonitoraggioBean)result.get(value[0])).setFineMonitoraggio((Timestamp)value[2]);
				if(value[3]==null)
					value[3] = "";
				((BollettinoMonitoraggioBean)result.get(value[0])).setNote((String)value[3]);
				((BollettinoMonitoraggioBean)result.get(value[0])).setLink((String)value[8]);
			}
			BollettinoMonitoraggioBean object = (BollettinoMonitoraggioBean)result.get(value[0]);

			//questa parte deve essere un arrayList da inserire nel bacino
			BacinoMonitoraggioBean bacinoMonitoraggioBean = null;
			for(BacinoMonitoraggioBean bm : object.getBacino()){
//				_log.info("result confronto bacini "+bm.getNome_bacino().equalsIgnoreCase((String)value[4]));
				if(bm.getNome_bacino().equalsIgnoreCase((String)value[4])){
					bacinoMonitoraggioBean = bm;
				}
			}
			if(bacinoMonitoraggioBean ==null){
				bacinoMonitoraggioBean = new BacinoMonitoraggioBean();
				bacinoMonitoraggioBean.setNome_bacino((String)value[4]);

				if(bacinoMonitoraggioBean.getProvince().size()==0){
					List<Comuni_bacini_ws> findByBacino = null;
					findByBacino = comuni_bacini_wsLocalService.findByBacino("BACINO "+(String)value[4]);
					for(Comuni_bacini_ws bacs:findByBacino ){
						bacinoMonitoraggioBean.getComuni().add(bacs.getComune());
						if(!bacinoMonitoraggioBean.getProvince().contains(bacs.getProvincia()))
							bacinoMonitoraggioBean.getProvince().add(bacs.getProvincia());
					}
				}
				object.getBacino().add(bacinoMonitoraggioBean);
			}

			SottoBacinoMonitoraggioBean sottoBacinoMonitoraggioBean =  new SottoBacinoMonitoraggioBean();
			sottoBacinoMonitoraggioBean.setNomeSottobacino((String)value[5]);
			Double double1 = (double) value[6];
			sottoBacinoMonitoraggioBean.setOsservazione(new InfoValoreBean(double1.toString(),(String)value[7]));
			sottoBacinoMonitoraggioBean.setColmo_previsto(new InfoValoreBean((String)value[9],(String)value[10]));
			bacinoMonitoraggioBean.getSottobacino().add(sottoBacinoMonitoraggioBean);
		}

		return result;
	}
}