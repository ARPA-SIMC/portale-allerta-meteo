/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import it.eng.radarMeteo.model.Img;

import java.util.Map;

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
public class ImgServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.radarMeteo.service.impl.ImgServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Map<String, Object> getInfoSensore(
		String stazione, String variabile) {

		return getService().getInfoSensore(stazione, variabile);
	}

	public static Img getlastimages() {
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

	public static java.util.ArrayList<Map<String, Object>> getSensorValues(
		String variabile, Long time) {

		return getService().getSensorValues(variabile, time);
	}

	public static java.util.ArrayList<Map<String, Object>>
		getsensorvaluesnotime(String variabile, long time) {

		return getService().getsensorvaluesnotime(variabile, time);
	}

	public static java.util.ArrayList<Map<String, Object>> getStations() {
		return getService().getStations();
	}

	public static java.util.ArrayList<Map<String, Object>> getTimeSeries(
		String stazione, String variabile) {

		return getService().getTimeSeries(stazione, variabile);
	}

	public static java.util.ArrayList<Map<String, Object>> lastdata(
		String stazione, String variabile) {

		return getService().lastdata(stazione, variabile);
	}

	public static ImgService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<ImgService> _serviceSnapshot = new Snapshot<>(
		ImgServiceUtil.class, ImgService.class);

}