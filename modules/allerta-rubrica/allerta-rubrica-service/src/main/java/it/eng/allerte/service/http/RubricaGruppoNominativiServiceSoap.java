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

import it.eng.allerte.service.RubricaGruppoNominativiServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>RubricaGruppoNominativiServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>it.eng.allerte.model.RubricaGruppoNominativiSoap</code>. If the method in the
 * service utility returns a
 * <code>it.eng.allerte.model.RubricaGruppoNominativi</code>, that is translated to a
 * <code>it.eng.allerte.model.RubricaGruppoNominativiSoap</code>. Methods that SOAP
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
 * @author Pratola_L
 * @see RubricaGruppoNominativiServiceHttp
 * @generated
 */
@ProviderType
public class RubricaGruppoNominativiServiceSoap {

	/**
	 * restituisci i nominvativi associati a un gruppo
	 *
	 * @param ownerId
	 * @param groupId
	 * @return
	 */
	public static java.util.Set<it.eng.allerte.model.RubricaNominativo>
			getNominativeForGroup(Long ownerId, Long groupId)
		throws RemoteException {

		try {
			java.util.Set<it.eng.allerte.model.RubricaNominativo> returnValue =
				RubricaGruppoNominativiServiceUtil.getNominativeForGroup(
					ownerId, groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Il metodo ritorna le info di un nominativo iscrittto al portale per il sito proprietario
	 *
	 * @param ownerId
	 * @return
	 */
	public static it.eng.allerte.model.RubricaNominativoSoap[]
			getNominativeForGroupPortal(Long ownerId)
		throws RemoteException {

		try {
			java.util.List<it.eng.allerte.model.RubricaNominativo> returnValue =
				RubricaGruppoNominativiServiceUtil.getNominativeForGroupPortal(
					ownerId);

			return it.eng.allerte.model.RubricaNominativoSoap.toSoapModels(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		RubricaGruppoNominativiServiceSoap.class);

}