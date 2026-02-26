/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import it.eng.allerte.model.RubricaContatto;

import java.util.List;
import java.util.Map;

/**
 * Provides the remote service utility for RubricaContatto. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaContattoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaContattoService
 * @generated
 */
public class RubricaContattoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaContattoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Map<String, Object> addContacts(String data) {
		return getService().addContacts(data);
	}

	public static Map<String, Object> deleteContacts(Long id, String data) {
		return getService().deleteContacts(id, data);
	}

	public static Map<String, Object> deleteContactsMulti(String data) {
		return getService().deleteContactsMulti(data);
	}

	/**
	 * ritorna una lista di contatti per l'id nominativo passato come parametro
	 *
	 * @param idNominative
	 * @return
	 */
	public static List<RubricaContatto> getContactByNominative(
		long idNominative) {

		return getService().getContactByNominative(idNominative);
	}

	/**
	 * Il metodo ritorna i conatti per un user iscritto al portale
	 *
	 * @param idUserPortal
	 * @return
	 */
	public static List<RubricaContatto> getContactByNominativePortal(
		long idUserPortal) {

		return getService().getContactByNominativePortal(idUserPortal);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Map<String, Object> updateContacts(Long id, String data) {
		return getService().updateContacts(id, data);
	}

	public static RubricaContattoService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RubricaContattoService> _serviceSnapshot =
		new Snapshot<>(
			RubricaContattoServiceUtil.class, RubricaContattoService.class);

}