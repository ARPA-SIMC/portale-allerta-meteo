/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import it.eng.allerte.service.RubricaRuoloPermessiServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>RubricaRuoloPermessiServiceUtil</code> service
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
 * @author Pratola_L
 * @generated
 */
public class RubricaRuoloPermessiServiceHttp {

	public static java.util.Map<String, Object> getRolePermission(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaRuoloPermessiServiceUtil.class, "getRolePermission",
				_getRolePermissionParameterTypes0);

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

	public static java.util.Map<String, Object> insertRolePermission(
		HttpPrincipal httpPrincipal, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaRuoloPermessiServiceUtil.class, "insertRolePermission",
				_insertRolePermissionParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, data);

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

	public static java.util.Map<String, Object> updateRolePermission(
		HttpPrincipal httpPrincipal, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaRuoloPermessiServiceUtil.class, "updateRolePermission",
				_updateRolePermissionParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, data);

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

	public static java.util.Map<String, Object> getUserInfo(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaRuoloPermessiServiceUtil.class, "getUserInfo",
				_getUserInfoParameterTypes3);
			
			System.out.println("prova: "+httpPrincipal.getLogin());

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

	private static Log _log = LogFactoryUtil.getLog(
		RubricaRuoloPermessiServiceHttp.class);

	private static final Class<?>[] _getRolePermissionParameterTypes0 =
		new Class[] {};
	private static final Class<?>[] _insertRolePermissionParameterTypes1 =
		new Class[] {String.class};
	private static final Class<?>[] _updateRolePermissionParameterTypes2 =
		new Class[] {String.class};
	private static final Class<?>[] _getUserInfoParameterTypes3 =
		new Class[] {};

}