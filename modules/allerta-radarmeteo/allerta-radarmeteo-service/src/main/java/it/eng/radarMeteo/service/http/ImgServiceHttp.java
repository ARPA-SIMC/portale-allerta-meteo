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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import it.eng.radarMeteo.service.ImgServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ImgServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Francesco
 * @see ImgServiceSoap
 * @generated
 */
@ProviderType
public class ImgServiceHttp {

	public static java.util.ArrayList<java.util.Map<String, Object>>
		getsensorvaluesnotime(
			HttpPrincipal httpPrincipal, String variabile, long time) {

		try {
			MethodKey methodKey = new MethodKey(
				ImgServiceUtil.class, "getsensorvaluesnotime",
				_getsensorvaluesnotimeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, variabile, time);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.ArrayList<java.util.Map<String, Object>>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.ArrayList<java.util.Map<String, Object>>
		getSensorValues(
			HttpPrincipal httpPrincipal, String variabile, Long time) {

		try {
			MethodKey methodKey = new MethodKey(
				ImgServiceUtil.class, "getSensorValues",
				_getSensorValuesParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, variabile, time);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.ArrayList<java.util.Map<String, Object>>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.ArrayList<java.util.Map<String, Object>>
		getTimeSeries(
			HttpPrincipal httpPrincipal, String stazione, String variabile) {

		try {
			MethodKey methodKey = new MethodKey(
				ImgServiceUtil.class, "getTimeSeries",
				_getTimeSeriesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, stazione, variabile);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.ArrayList<java.util.Map<String, Object>>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.ArrayList<java.util.Map<String, Object>> lastdata(
		HttpPrincipal httpPrincipal, String stazione, String variabile) {

		try {
			MethodKey methodKey = new MethodKey(
				ImgServiceUtil.class, "lastdata", _lastdataParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, stazione, variabile);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.ArrayList<java.util.Map<String, Object>>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.Map<String, Object> getInfoSensore(
		HttpPrincipal httpPrincipal, String stazione, String variabile) {

		try {
			MethodKey methodKey = new MethodKey(
				ImgServiceUtil.class, "getInfoSensore",
				_getInfoSensoreParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, stazione, variabile);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.Map<String, Object>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.ArrayList<java.util.Map<String, Object>>
		getStations(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				ImgServiceUtil.class, "getStations",
				_getStationsParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.ArrayList<java.util.Map<String, Object>>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static it.eng.radarMeteo.model.Img getlastimages(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				ImgServiceUtil.class, "getlastimages",
				_getlastimagesParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (it.eng.radarMeteo.model.Img)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ImgServiceHttp.class);

	private static final Class<?>[] _getsensorvaluesnotimeParameterTypes0 =
		new Class[] {String.class, long.class};
	private static final Class<?>[] _getSensorValuesParameterTypes1 =
		new Class[] {String.class, Long.class};
	private static final Class<?>[] _getTimeSeriesParameterTypes2 =
		new Class[] {String.class, String.class};
	private static final Class<?>[] _lastdataParameterTypes3 = new Class[] {
		String.class, String.class
	};
	private static final Class<?>[] _getInfoSensoreParameterTypes4 =
		new Class[] {String.class, String.class};
	private static final Class<?>[] _getStationsParameterTypes5 = new Class[] {
		
	};
	private static final Class<?>[] _getlastimagesParameterTypes6 =
		new Class[] {};

}