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

package it.eng.allerta.messages.services.service.impl;

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

/**
 * The implementation of the counter sms local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerta.messages.services.service.CounterSmsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Giorgianni_F
 * @see CounterSmsLocalServiceBaseImpl
 */
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