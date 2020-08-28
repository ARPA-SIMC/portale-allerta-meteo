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

import it.eng.allerte.service.RubricaGruppoNominativiServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>RubricaGruppoNominativiServiceUtil</code> service
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
 * @see RubricaGruppoNominativiServiceSoap
 * @generated
 */
@ProviderType
public class RubricaGruppoNominativiServiceHttp {

	public static java.util.Map<String, Object> addGroupNominatives(
		HttpPrincipal httpPrincipal, int id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoNominativiServiceUtil.class, "addGroupNominatives",
				_addGroupNominativesParameterTypes0);

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

	public static java.util.Map<String, Object> deleteGroupNominatives(
		HttpPrincipal httpPrincipal, int id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoNominativiServiceUtil.class,
				"deleteGroupNominatives",
				_deleteGroupNominativesParameterTypes1);

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

	public static java.util.Map<String, Object> addGroupNominativesMulti(
		HttpPrincipal httpPrincipal, int id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoNominativiServiceUtil.class,
				"addGroupNominativesMulti",
				_addGroupNominativesMultiParameterTypes2);

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

	public static java.util.Map<String, Object> deleteGroupNominativesMulti(
		HttpPrincipal httpPrincipal, int id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoNominativiServiceUtil.class,
				"deleteGroupNominativesMulti",
				_deleteGroupNominativesMultiParameterTypes3);

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

	public static java.util.Map<String, Object> nominativeGroupRole(
		HttpPrincipal httpPrincipal, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoNominativiServiceUtil.class, "nominativeGroupRole",
				_nominativeGroupRoleParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, data);

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

	public static java.util.Set<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroup(
			HttpPrincipal httpPrincipal, Long ownerId, Long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoNominativiServiceUtil.class,
				"getNominativeForGroup",
				_getNominativeForGroupParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, ownerId, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.Set<it.eng.allerte.model.RubricaNominativo>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroupPortal(HttpPrincipal httpPrincipal, Long ownerId) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaGruppoNominativiServiceUtil.class,
				"getNominativeForGroupPortal",
				_getNominativeForGroupPortalParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(methodKey, ownerId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<it.eng.allerte.model.RubricaNominativo>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		RubricaGruppoNominativiServiceHttp.class);

	private static final Class<?>[] _addGroupNominativesParameterTypes0 =
		new Class[] {int.class, String.class};
	private static final Class<?>[] _deleteGroupNominativesParameterTypes1 =
		new Class[] {int.class, String.class};
	private static final Class<?>[] _addGroupNominativesMultiParameterTypes2 =
		new Class[] {int.class, String.class};
	private static final Class<?>[]
		_deleteGroupNominativesMultiParameterTypes3 = new Class[] {
			int.class, String.class
		};
	private static final Class<?>[] _nominativeGroupRoleParameterTypes6 =
		new Class[] {String.class};
	private static final Class<?>[] _getNominativeForGroupParameterTypes10 =
		new Class[] {Long.class, Long.class};
	private static final Class<?>[]
		_getNominativeForGroupPortalParameterTypes11 = new Class[] {Long.class};

}