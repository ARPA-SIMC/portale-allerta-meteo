/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.impl;

import com.liferay.portal.aop.AopService;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import it.eng.allerter.model.LogInterno;
import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.allerter.service.base.LogInternoLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.allerter.model.LogInterno",
	service = AopService.class
)
public class LogInternoLocalServiceImpl extends LogInternoLocalServiceBaseImpl {


	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerter.service.LogInternoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerter.service.LogInternoLocalServiceUtil</code>.
	 */
	private DynamicQuery searchQuery(Date da, Date a) {
		
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LogInterno.class, getClassLoader());
		
		if (da!=null) {
			dynamicQuery.add(PropertyFactoryUtil.forName("timestamp").ge(da));
		}
		
		if (a!=null) {
			dynamicQuery.add(PropertyFactoryUtil.forName("timestamp").le(a));
		}
		
		
		return dynamicQuery;
	}
	
	public List<LogInterno> searchLog(Date da, Date a, int start, int end) {
		DynamicQuery q = searchQuery(da,a);
		q.addOrder(OrderFactoryUtil.desc("timestamp"));
		return LogInternoLocalServiceUtil.dynamicQuery(q, start, end);
	}
	
	public long logCount(Date da, Date a) {
		return LogInternoLocalServiceUtil.dynamicQueryCount(searchQuery(da,a));
	}
	

	public void log(String cosa, String dettaglio, String risultato, String utente) {
		
		try {
			if (Validator.isNull(utente))
				utente = "";
			
			long logId = counterLocalService.increment(LogInterno.class.getName()); 
			
			LogInterno li = logInternoPersistence.create(logId);
//			LogInterno li = logInternoPersistence.createLogInterno(new LogInternoPK(new Date(),
//					Thread.currentThread().toString()));
			li.setTimestamp(new Date());
			li.setThread(Thread.currentThread().toString());
			li.setCosa(cosa);
			li.setDettaglio(dettaglio);
			li.setRisultato(risultato);
			li.setUtente(utente);
			logInternoPersistence.update(li); //addLogInterno(li);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void log(String cosa, String dettaglio, Exception eccezione, String utente) {
		
		try {
			
			if (Validator.isNull(utente))
				utente = "";
		
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			eccezione.printStackTrace(pw);
						
			long logId = counterLocalService.increment(LogInterno.class.getName()); 
			
			LogInterno li = logInternoPersistence.create(logId);
			
			//LogInterno li = logInternoPersistence.createLogInterno(new LogInternoPK(new Date(),Thread.currentThread().toString()));
			li.setTimestamp(new Date());
			li.setThread(Thread.currentThread().toString());
			li.setCosa(cosa);
			li.setDettaglio(dettaglio);
			li.setRisultato("error");
			li.setEccezione(sw.toString());
			li.setUtente(utente);
			logInternoPersistence.update(li);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}