/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.impl;

import com.liferay.portal.aop.AopService;

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

import org.osgi.service.component.annotations.Component;

/**
 * @author Francesco
 */
@Component(
	property = {
		"json.web.service.context.name=rt_portlet",
		"json.web.service.context.path=Comuni_bacini_ws"
	},
	service = AopService.class
)
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
			Object double1 = value[6]!=null?value[6]:"";
			sottoBacinoMonitoraggioBean.setOsservazione(new InfoValoreBean(double1.toString(),(String)value[7]));
			sottoBacinoMonitoraggioBean.setColmo_previsto(new InfoValoreBean((String)value[9],(String)value[10]));
			bacinoMonitoraggioBean.getSottobacino().add(sottoBacinoMonitoraggioBean);
		}

		return result;
	}
}