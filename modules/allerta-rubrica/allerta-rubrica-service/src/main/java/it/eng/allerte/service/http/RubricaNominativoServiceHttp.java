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

import it.eng.allerte.service.RubricaNominativoServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>RubricaNominativoServiceUtil</code> service
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
 * @see RubricaNominativoServiceSoap
 * @generated
 */
@ProviderType
public class RubricaNominativoServiceHttp {

	public static java.util.Map<String, Object> getNominatives(
		HttpPrincipal httpPrincipal, Long id) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaNominativoServiceUtil.class, "getNominatives",
				_getNominativesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

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

	public static java.util.Map<String, Object> getNominatives(
		HttpPrincipal httpPrincipal, String name, int limit, int offset) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaNominativoServiceUtil.class, "getNominatives",
				_getNominativesParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, name, limit, offset);

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

	public static java.util.Map<String, Object> deleteNominatives(
		HttpPrincipal httpPrincipal, Long id) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaNominativoServiceUtil.class, "deleteNominatives",
				_deleteNominativesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

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

	public static java.util.Map<String, Object> updateNominatives(
		HttpPrincipal httpPrincipal, Long id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaNominativoServiceUtil.class, "updateNominatives",
				_updateNominativesParameterTypes4);

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

	public static java.util.Map<String, Object> insertNominatives(
		HttpPrincipal httpPrincipal, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaNominativoServiceUtil.class, "insertNominatives",
				_insertNominativesParameterTypes6);

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

	public static java.util.Map<String, Object> importNominatives(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaNominativoServiceUtil.class, "importNominatives",
				_importNominativesParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey);

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

	public static java.util.Map<String, Object> nominativesMulti(
		HttpPrincipal httpPrincipal, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaNominativoServiceUtil.class, "nominativesMulti",
				_nominativesMultiParameterTypes8);

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

	public static java.util.Map<String, Object> addNominativesGroupsMulti(
		HttpPrincipal httpPrincipal, Long id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaNominativoServiceUtil.class, "addNominativesGroupsMulti",
				_addNominativesGroupsMultiParameterTypes9);

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

	public static java.util.Map<String, Object> deleteNominativesGroupsMulti(
		HttpPrincipal httpPrincipal, Long id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaNominativoServiceUtil.class,
				"deleteNominativesGroupsMulti",
				_deleteNominativesGroupsMultiParameterTypes10);

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

	public static java.util.Map<String, Object> nominativesMulti(
		HttpPrincipal httpPrincipal, Long id) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaNominativoServiceUtil.class, "nominativesMulti",
				_nominativesMultiParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

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

	private static Log _log = LogFactoryUtil.getLog(
		RubricaNominativoServiceHttp.class);

	private static final Class<?>[] _getNominativesParameterTypes0 =
		new Class[] {Long.class};
	private static final Class<?>[] _getNominativesParameterTypes1 =
		new Class[] {String.class, int.class, int.class};
	private static final Class<?>[] _deleteNominativesParameterTypes2 =
		new Class[] {Long.class};
	private static final Class<?>[] _updateNominativesParameterTypes4 =
		new Class[] {Long.class, String.class};
	private static final Class<?>[] _insertNominativesParameterTypes6 =
		new Class[] {String.class};
	private static final Class<?>[] _importNominativesParameterTypes7 =
		new Class[] {};
	private static final Class<?>[] _nominativesMultiParameterTypes8 =
		new Class[] {String.class};
	private static final Class<?>[] _addNominativesGroupsMultiParameterTypes9 =
		new Class[] {Long.class, String.class};
	private static final Class<?>[]
		_deleteNominativesGroupsMultiParameterTypes10 = new Class[] {
			Long.class, String.class
		};
	private static final Class<?>[] _nominativesMultiParameterTypes14 =
		new Class[] {Long.class};

}