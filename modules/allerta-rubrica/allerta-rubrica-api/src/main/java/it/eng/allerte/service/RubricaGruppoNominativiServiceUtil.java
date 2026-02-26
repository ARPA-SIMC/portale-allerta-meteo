/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Provides the remote service utility for RubricaGruppoNominativi. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaGruppoNominativiServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativiService
 * @generated
 */
public class RubricaGruppoNominativiServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoNominativiServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Map<String, Object> addGroupNominatives(int id, String data) {
		return getService().addGroupNominatives(id, data);
	}

	public static Map<String, Object> addGroupNominativesMulti(
		int id, String data) {

		return getService().addGroupNominativesMulti(id, data);
	}

	public static Map<String, Object> deleteGroupNominatives(
		int id, String data) {

		return getService().deleteGroupNominatives(id, data);
	}

	public static Map<String, Object> deleteGroupNominativesMulti(
		int id, String data) {

		return getService().deleteGroupNominativesMulti(id, data);
	}

	/**
	 * restituisci i nominvativi associati a un gruppo
	 *
	 * @param ownerId
	 * @param groupId
	 * @return
	 */
	public static Set<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroup(Long ownerId, Long groupId) {

		return getService().getNominativeForGroup(ownerId, groupId);
	}

	/**
	 * Il metodo ritorna le info di un nominativo iscrittto al portale per il sito proprietario
	 *
	 * @param ownerId
	 * @return
	 */
	public static List<it.eng.allerte.model.RubricaNominativo>
		getNominativeForGroupPortal(Long ownerId) {

		return getService().getNominativeForGroupPortal(ownerId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Map<String, Object> nominativeGroupRole(String data) {
		return getService().nominativeGroupRole(data);
	}

	public static RubricaGruppoNominativiService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RubricaGruppoNominativiService>
		_serviceSnapshot = new Snapshot<>(
			RubricaGruppoNominativiServiceUtil.class,
			RubricaGruppoNominativiService.class);

}