/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import java.util.List;
import java.util.Map;

/**
 * Provides the remote service utility for RubricaGruppoGruppi. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaGruppoGruppiServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppiService
 * @generated
 */
public class RubricaGruppoGruppiServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoGruppiServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Map<String, Object> addGroupMultiSubgroups(
		int id, String data) {

		return getService().addGroupMultiSubgroups(id, data);
	}

	public static Map<String, Object> addGroupMultiSupergroups(
		int id, String data) {

		return getService().addGroupMultiSupergroups(id, data);
	}

	public static Map<String, Object> addGroupSubgroups(int id, String data) {
		return getService().addGroupSubgroups(id, data);
	}

	public static Map<String, Object> deleteGroupMultiSubgroups(
		int id, String data) {

		return getService().deleteGroupMultiSubgroups(id, data);
	}

	public static Map<String, Object> deleteGroupMultiSupergroups(
		int id, String data) {

		return getService().deleteGroupMultiSupergroups(id, data);
	}

	public static Map<String, Object> deleteGroupSubgroups(
		int id, String data) {

		return getService().deleteGroupSubgroups(id, data);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Il metodo restituisce la lista dei sottogruppi per l'id gruppo passato come parametro
	 *
	 * @param idGroup
	 * @return
	 */
	public static List<it.eng.allerte.model.RubricaGruppo> getSubGroups(
		long idGroup) {

		return getService().getSubGroups(idGroup);
	}

	public static Map<String, Object> updateGroupSubgroups(
		int id, String data) {

		return getService().updateGroupSubgroups(id, data);
	}

	public static RubricaGruppoGruppiService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RubricaGruppoGruppiService> _serviceSnapshot =
		new Snapshot<>(
			RubricaGruppoGruppiServiceUtil.class,
			RubricaGruppoGruppiService.class);

}