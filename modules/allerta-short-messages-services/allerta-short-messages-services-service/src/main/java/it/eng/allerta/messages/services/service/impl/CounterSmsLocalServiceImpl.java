/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.impl;

import com.liferay.portal.aop.AopService;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.allerta.messages.services.exception.NoSuchCounterSmsException;
import it.eng.allerta.messages.services.model.CounterSms;
import it.eng.allerta.messages.services.service.CounterSmsLocalServiceUtil;
import it.eng.allerta.messages.services.service.base.CounterSmsLocalServiceBaseImpl;
import it.eng.allerta.messages.services.service.persistence.CounterSmsUtil;
import org.osgi.service.component.annotations.Component;

/**
 * @author Giorgianni_F
 */
@Component(
	property = "model.class.name=it.eng.allerta.messages.services.model.CounterSms",
	service = AopService.class
)
public class CounterSmsLocalServiceImpl extends CounterSmsLocalServiceBaseImpl {


	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerta.messages.services.service.CounterSmsLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerta.messages.services.service.CounterSmsLocalServiceUtil</code>.
	 */
	
	public Long getTotalSMS() {
		
		DynamicQuery userQuery = 
					DynamicQueryFactoryUtil
						.forClass(CounterSms.class, getClassLoader())
						.setProjection(ProjectionFactoryUtil.sum("numerosms"));

		List<Object> dynamicQuery = null;
		
		try {
		
			dynamicQuery = CounterSmsLocalServiceUtil.dynamicQuery(userQuery);
		
		} catch (SystemException e) {
		
			e.printStackTrace();
		}
		
		return (long) dynamicQuery.get(0);
	}

	
	public List<CounterSms> findBydataGreather(Date date){
		try {
			return CounterSmsUtil.findBydataGreather(date);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return null;
	}
	
	public CounterSms findBydata(Date date){
		CounterSms findBydata = null;
		try {
			findBydata = CounterSmsUtil.findBydata(date);
		} catch (NoSuchCounterSmsException e) {
			// TODO Auto-generated catch block
			logger.info("NoSuchCounterSmsException... è un nuovo giorno");
			try {
				long counterId = CounterLocalServiceUtil.increment(CounterSms.class.getName());
				findBydata = counterSmsLocalService.createCounterSms(counterId);
				findBydata.setCounterId(counterId);
				findBydata.setDate(date);
				findBydata.setNumerosms(0);
				try {
					findBydata.setNodo(InetAddress.getLocalHost().getHostAddress());
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					logger.error(e1);
				}
				findBydata = CounterSmsLocalServiceUtil.addCounterSms(findBydata);
			} catch (SystemException e1) {
				// TODO Auto-generated catch block
				logger.error(e1);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
		return findBydata;
	}
	
	private Log logger = LogFactoryUtil.getLog(CounterSmsLocalServiceImpl.class);

}