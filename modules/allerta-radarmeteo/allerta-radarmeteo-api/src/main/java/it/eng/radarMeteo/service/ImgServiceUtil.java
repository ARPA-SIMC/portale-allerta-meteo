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

package it.eng.radarMeteo.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Img. This utility wraps
 * <code>it.eng.radarMeteo.service.impl.ImgServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Francesco
 * @see ImgService
 * @generated
 */
@ProviderType
public class ImgServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.radarMeteo.service.impl.ImgServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.Map<String, Object> getInfoSensore(
		String stazione, String variabile) {

		return getService().getInfoSensore(stazione, variabile);
	}

	public static it.eng.radarMeteo.model.Img getlastimages() {
		return getService().getlastimages();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.ArrayList<java.util.Map<String, Object>>
		getSensorValues(String variabile, Long time) {

		return getService().getSensorValues(variabile, time);
	}

	public static java.util.ArrayList<java.util.Map<String, Object>>
		getsensorvaluesnotime(String variabile, long time) {

		return getService().getsensorvaluesnotime(variabile, time);
	}

	public static java.util.ArrayList<java.util.Map<String, Object>>
		getStations() {

		return getService().getStations();
	}

	public static java.util.ArrayList<java.util.Map<String, Object>>
		getTimeSeries(String stazione, String variabile) {

		return getService().getTimeSeries(stazione, variabile);
	}

	public static java.util.ArrayList<java.util.Map<String, Object>> lastdata(
		String stazione, String variabile) {

		return getService().lastdata(stazione, variabile);
	}

	public static ImgService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ImgService, ImgService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ImgService.class);

		ServiceTracker<ImgService, ImgService> serviceTracker =
			new ServiceTracker<ImgService, ImgService>(
				bundle.getBundleContext(), ImgService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}