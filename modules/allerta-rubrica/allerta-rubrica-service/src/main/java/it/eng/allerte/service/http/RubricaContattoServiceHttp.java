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

import it.eng.allerte.service.RubricaContattoServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>RubricaContattoServiceUtil</code> service
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
 * @see RubricaContattoServiceSoap
 * @generated
 */
@ProviderType
public class RubricaContattoServiceHttp {

	public static java.util.Map<String, Object> addContacts(
		HttpPrincipal httpPrincipal, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaContattoServiceUtil.class, "addContacts",
				_addContactsParameterTypes0);

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

	public static java.util.Map<String, Object> updateContacts(
		HttpPrincipal httpPrincipal, Long id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaContattoServiceUtil.class, "updateContacts",
				_updateContactsParameterTypes1);

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

	public static java.util.Map<String, Object> deleteContacts(
		HttpPrincipal httpPrincipal, Long id, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaContattoServiceUtil.class, "deleteContacts",
				_deleteContactsParameterTypes2);

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

	public static java.util.Map<String, Object> deleteContactsMulti(
		HttpPrincipal httpPrincipal, String data) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaContattoServiceUtil.class, "deleteContactsMulti",
				_deleteContactsMultiParameterTypes3);

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

	public static java.util.List<it.eng.allerte.model.RubricaContatto>
		getContactByNominative(HttpPrincipal httpPrincipal, long idNominative) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaContattoServiceUtil.class, "getContactByNominative",
				_getContactByNominativeParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, idNominative);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<it.eng.allerte.model.RubricaContatto>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.eng.allerte.model.RubricaContatto>
		getContactByNominativePortal(
			HttpPrincipal httpPrincipal, long idUserPortal) {

		try {
			MethodKey methodKey = new MethodKey(
				RubricaContattoServiceUtil.class,
				"getContactByNominativePortal",
				_getContactByNominativePortalParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, idUserPortal);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List<it.eng.allerte.model.RubricaContatto>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		RubricaContattoServiceHttp.class);

	private static final Class<?>[] _addContactsParameterTypes0 = new Class[] {
		String.class
	};
	private static final Class<?>[] _updateContactsParameterTypes1 =
		new Class[] {Long.class, String.class};
	private static final Class<?>[] _deleteContactsParameterTypes2 =
		new Class[] {Long.class, String.class};
	private static final Class<?>[] _deleteContactsMultiParameterTypes3 =
		new Class[] {String.class};
	private static final Class<?>[] _getContactByNominativeParameterTypes8 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getContactByNominativePortalParameterTypes9 = new Class[] {long.class};

}