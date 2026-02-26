/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import it.eng.radarMeteo.service.Comuni_wsServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>Comuni_wsServiceUtil</code> service
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
 * @generated
 */
public class Comuni_wsServiceHttp {

	public static java.util.ArrayList<java.util.HashMap<String, String>>
		getMeteomont(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				Comuni_wsServiceUtil.class, "getMeteomont",
				_getMeteomontParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.ArrayList<java.util.HashMap<String, String>>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.Map<String, Object> getStatoAllerta(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				Comuni_wsServiceUtil.class, "getStatoAllerta",
				_getStatoAllertaParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.Map<String, Object>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.Map<String, Object> getStatoAllerta(
		HttpPrincipal httpPrincipal, java.sql.Timestamp timestamp) {

		try {
			MethodKey methodKey = new MethodKey(
				Comuni_wsServiceUtil.class, "getStatoAllerta",
				_getStatoAllertaParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, timestamp);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.Map<String, Object>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<Object[]> getStatoAllertaCap(
		HttpPrincipal httpPrincipal, java.sql.Timestamp timestamp) {

		try {
			MethodKey methodKey = new MethodKey(
				Comuni_wsServiceUtil.class, "getStatoAllertaCap",
				_getStatoAllertaCapParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, timestamp);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<Object[]>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(Comuni_wsServiceHttp.class);

	private static final Class<?>[] _getMeteomontParameterTypes0 =
		new Class[] {};
	private static final Class<?>[] _getStatoAllertaParameterTypes1 =
		new Class[] {};
	private static final Class<?>[] _getStatoAllertaParameterTypes2 =
		new Class[] {java.sql.Timestamp.class};
	private static final Class<?>[] _getStatoAllertaCapParameterTypes3 =
		new Class[] {java.sql.Timestamp.class};

}