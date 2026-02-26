/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import it.eng.parer.service.DocumentiCollegatiServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>DocumentiCollegatiServiceUtil</code> service
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
public class DocumentiCollegatiServiceHttp {

	public static java.util.List<it.eng.parer.model.DocumentiCollegati>
		listaDocumentiCollegatiByEsitoInvio(
			HttpPrincipal httpPrincipal, Long idInvio) {

		try {
			MethodKey methodKey = new MethodKey(
				DocumentiCollegatiServiceUtil.class,
				"listaDocumentiCollegatiByEsitoInvio",
				_listaDocumentiCollegatiByEsitoInvioParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, idInvio);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<it.eng.parer.model.DocumentiCollegati>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		DocumentiCollegatiServiceHttp.class);

	private static final Class<?>[]
		_listaDocumentiCollegatiByEsitoInvioParameterTypes0 = new Class[] {
			Long.class
		};

}