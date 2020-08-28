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

package it.eng.radarMeteo.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import it.eng.radarMeteo.service.ImgServiceUtil;

import java.rmi.RemoteException;

import java.util.Map;

/**
 * Provides the SOAP utility for the
 * <code>ImgServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>it.eng.radarMeteo.model.ImgSoap</code>. If the method in the
 * service utility returns a
 * <code>it.eng.radarMeteo.model.Img</code>, that is translated to a
 * <code>it.eng.radarMeteo.model.ImgSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Francesco
 * @see ImgServiceHttp
 * @generated
 */
@ProviderType
public class ImgServiceSoap {

	public static java.util.ArrayList<Map<String, Object>>
			getsensorvaluesnotime(String variabile, long time)
		throws RemoteException {

		try {
			java.util.ArrayList<Map<String, Object>> returnValue =
				ImgServiceUtil.getsensorvaluesnotime(variabile, time);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.util.ArrayList<Map<String, Object>> getSensorValues(
			String variabile, Long time)
		throws RemoteException {

		try {
			java.util.ArrayList<Map<String, Object>> returnValue =
				ImgServiceUtil.getSensorValues(variabile, time);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.util.ArrayList<Map<String, Object>> getTimeSeries(
			String stazione, String variabile)
		throws RemoteException {

		try {
			java.util.ArrayList<Map<String, Object>> returnValue =
				ImgServiceUtil.getTimeSeries(stazione, variabile);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.util.ArrayList<Map<String, Object>> lastdata(
			String stazione, String variabile)
		throws RemoteException {

		try {
			java.util.ArrayList<Map<String, Object>> returnValue =
				ImgServiceUtil.lastdata(stazione, variabile);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.util.ArrayList<Map<String, Object>> getStations()
		throws RemoteException {

		try {
			java.util.ArrayList<Map<String, Object>> returnValue =
				ImgServiceUtil.getStations();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static it.eng.radarMeteo.model.ImgSoap getlastimages()
		throws RemoteException {

		try {
			it.eng.radarMeteo.model.Img returnValue =
				ImgServiceUtil.getlastimages();

			return it.eng.radarMeteo.model.ImgSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ImgServiceSoap.class);

}