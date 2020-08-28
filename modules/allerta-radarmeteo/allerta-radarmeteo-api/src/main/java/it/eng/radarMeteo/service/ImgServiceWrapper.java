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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ImgService}.
 *
 * @author Francesco
 * @see ImgService
 * @generated
 */
@ProviderType
public class ImgServiceWrapper
	implements ImgService, ServiceWrapper<ImgService> {

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