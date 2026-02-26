/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ImgService}.
 *
 * @author Francesco
 * @see ImgService
 * @generated
 */
public class ImgServiceWrapper
	implements ImgService, ServiceWrapper<ImgService> {

	public ImgServiceWrapper() {
		this(null);
	}

	public ImgServiceWrapper(ImgService imgService) {
		_imgService = imgService;
	}

	@Override
	public java.util.Map<String, Object> getInfoSensore(
		String stazione, String variabile) {

		return _imgService.getInfoSensore(stazione, variabile);
	}

	@Override
	public it.eng.radarMeteo.model.Img getlastimages() {
		return _imgService.getlastimages();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _imgService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.ArrayList<java.util.Map<String, Object>> getSensorValues(
		String variabile, Long time) {

		return _imgService.getSensorValues(variabile, time);
	}

	@Override
	public java.util.ArrayList<java.util.Map<String, Object>>
		getsensorvaluesnotime(String variabile, long time) {

		return _imgService.getsensorvaluesnotime(variabile, time);
	}

	@Override
	public java.util.ArrayList<java.util.Map<String, Object>> getStations() {
		return _imgService.getStations();
	}

	@Override
	public java.util.ArrayList<java.util.Map<String, Object>> getTimeSeries(
		String stazione, String variabile) {

		return _imgService.getTimeSeries(stazione, variabile);
	}

	@Override
	public java.util.ArrayList<java.util.Map<String, Object>> lastdata(
		String stazione, String variabile) {

		return _imgService.lastdata(stazione, variabile);
	}

	@Override
	public ImgService getWrappedService() {
		return _imgService;
	}

	@Override
	public void setWrappedService(ImgService imgService) {
		_imgService = imgService;
	}

	private ImgService _imgService;

}