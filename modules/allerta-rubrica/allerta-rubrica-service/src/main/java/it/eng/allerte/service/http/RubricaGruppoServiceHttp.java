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

import it.eng.allerte.service.RubricaGruppoServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>RubricaGruppoServiceUtil</code> service
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
public class RubricaGruppoServiceHttp {

	public static java.util.Map<String, Object> getGroups(
		HttpPrincipal httpPrincipal, Long id) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoServiceUtil.class, "getGroups",
				_getGroupsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

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

	public static java.util.Map<String, Object> updateGroups(
		HttpPrincipal httpPrincipal, Long id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoServiceUtil.class, "updateGroups",
				_updateGroupsParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, data);

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

	public static java.util.Map<String, Object> deleteGroups(
		HttpPrincipal httpPrincipal, Long id) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoServiceUtil.class, "deleteGroups",
				_deleteGroupsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

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

	public static java.util.Map<String, Object> getGroups(
		HttpPrincipal httpPrincipal, String name, Long categoria, int limit,
		int offset) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoServiceUtil.class, "getGroups",
				_getGroupsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, name, categoria, limit, offset);

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

	public static java.util.Map<String, Object> getGroups(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoServiceUtil.class, "getGroups",
				_getGroupsParameterTypes4);

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

	public static java.util.Map<String, Object> addGroup(
		HttpPrincipal httpPrincipal, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoServiceUtil.class, "addGroup",
				_addGroupParameterTypes5);

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

	public static java.util.Map<String, Object> deleteGroupsMulti(
		HttpPrincipal httpPrincipal, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoServiceUtil.class, "deleteGroupsMulti",
				_deleteGroupsMultiParameterTypes6);

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

	public static it.eng.allerte.model.RubricaGruppo getGroupForOwnerByName(
		HttpPrincipal httpPrincipal, Long ownerId, String groupName) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoServiceUtil.class, "getGroupForOwnerByName",
				_getGroupForOwnerByNameParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, ownerId, groupName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (it.eng.allerte.model.RubricaGruppo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		RubricaGruppoServiceHttp.class);

	private static final Class<?>[] _getGroupsParameterTypes0 = new Class[] {
		Long.class
	};
	private static final Class<?>[] _updateGroupsParameterTypes1 = new Class[] {
		Long.class, String.class
	};
	private static final Class<?>[] _deleteGroupsParameterTypes2 = new Class[] {
		Long.class
	};
	private static final Class<?>[] _getGroupsParameterTypes3 = new Class[] {
		String.class, Long.class, int.class, int.class
	};
	private static final Class<?>[] _getGroupsParameterTypes4 = new Class[] {};
	private static final Class<?>[] _addGroupParameterTypes5 = new Class[] {
		String.class
	};
	private static final Class<?>[] _deleteGroupsMultiParameterTypes6 =
		new Class[] {String.class};
	private static final Class<?>[] _getGroupForOwnerByNameParameterTypes15 =
		new Class[] {Long.class, String.class};

}