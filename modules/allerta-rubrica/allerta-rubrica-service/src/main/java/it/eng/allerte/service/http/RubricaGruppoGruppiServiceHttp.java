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

package it.eng.allerte.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import it.eng.allerte.service.RubricaGruppoGruppiServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>RubricaGruppoGruppiServiceUtil</code> service
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
 * @see RubricaGruppoGruppiServiceSoap
 * @generated
 */
@ProviderType
public class RubricaGruppoGruppiServiceHttp {

	public static java.util.Map<String, Object> updateGroupSubgroups(
		HttpPrincipal httpPrincipal, int id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoGruppiServiceUtil.class, "updateGroupSubgroups",
				_updateGroupSubgroupsParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, data);

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

	public static java.util.Map<String, Object> deleteGroupSubgroups(
		HttpPrincipal httpPrincipal, int id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoGruppiServiceUtil.class, "deleteGroupSubgroups",
				_deleteGroupSubgroupsParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, data);

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

	public static java.util.Map<String, Object> addGroupSubgroups(
		HttpPrincipal httpPrincipal, int id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoGruppiServiceUtil.class, "addGroupSubgroups",
				_addGroupSubgroupsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, data);

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

	public static java.util.Map<String, Object> deleteGroupMultiSubgroups(
		HttpPrincipal httpPrincipal, int id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoGruppiServiceUtil.class,
				"deleteGroupMultiSubgroups",
				_deleteGroupMultiSubgroupsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, data);

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

	public static java.util.Map<String, Object> addGroupMultiSubgroups(
		HttpPrincipal httpPrincipal, int id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoGruppiServiceUtil.class, "addGroupMultiSubgroups",
				_addGroupMultiSubgroupsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, data);

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

	public static java.util.Map<String, Object> deleteGroupMultiSupergroups(
		HttpPrincipal httpPrincipal, int id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoGruppiServiceUtil.class,
				"deleteGroupMultiSupergroups",
				_deleteGroupMultiSupergroupsParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, data);

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

	public static java.util.Map<String, Object> addGroupMultiSupergroups(
		HttpPrincipal httpPrincipal, int id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoGruppiServiceUtil.class,
				"addGroupMultiSupergroups",
				_addGroupMultiSupergroupsParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, data);

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

	public static java.util.List<it.eng.allerte.model.RubricaGruppo>
		getSubGroups(HttpPrincipal httpPrincipal, long idGroup) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoGruppiServiceUtil.class, "getSubGroups",
				_getSubGroupsParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey, idGroup);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<it.eng.allerte.model.RubricaGruppo>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		RubricaGruppoGruppiServiceHttp.class);

	private static final Class<?>[] _updateGroupSubgroupsParameterTypes0 =
		new Class[] {int.class, String.class};
	private static final Class<?>[] _deleteGroupSubgroupsParameterTypes1 =
		new Class[] {int.class, String.class};
	private static final Class<?>[] _addGroupSubgroupsParameterTypes2 =
		new Class[] {int.class, String.class};
	private static final Class<?>[] _deleteGroupMultiSubgroupsParameterTypes3 =
		new Class[] {int.class, String.class};
	private static final Class<?>[] _addGroupMultiSubgroupsParameterTypes4 =
		new Class[] {int.class, String.class};
	private static final Class<?>[]
		_deleteGroupMultiSupergroupsParameterTypes5 = new Class[] {
			int.class, String.class
		};
	private static final Class<?>[] _addGroupMultiSupergroupsParameterTypes6 =
		new Class[] {int.class, String.class};
	private static final Class<?>[] _getSubGroupsParameterTypes14 =
		new Class[] {long.class};

}