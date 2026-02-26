/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import it.eng.allerte.model.RubricaGruppo;

import java.util.Map;

/**
 * Provides the remote service utility for RubricaGruppo. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaGruppoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaGruppoService
 * @generated
 */
public class RubricaGruppoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Map<String, Object> addGroup(String data) {
		return getService().addGroup(data);
	}

	public static Map<String, Object> deleteGroups(Long id) {
		return getService().deleteGroups(id);
	}

	public static Map<String, Object> deleteGroupsMulti(String data) {
		return getService().deleteGroupsMulti(data);
	}

	/**
	 * Il metodo restituisce le info sul gruppo a partire dal nome e per il sito proprietario
	 */
	public static RubricaGruppo getGroupForOwnerByName(
		Long ownerId, String groupName) {

		return getService().getGroupForOwnerByName(ownerId, groupName);
	}

	public static Map<String, Object> getGroups() {
		return getService().getGroups();
	}

	public static Map<String, Object> getGroups(Long id) {
		return getService().getGroups(id);
	}

	public static Map<String, Object> getGroups(
		String name, Long categoria, int limit, int offset) {

		return getService().getGroups(name, categoria, limit, offset);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Map<String, Object> updateGroups(Long id, String data) {
		return getService().updateGroups(id, data);
	}

	public static RubricaGruppoService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RubricaGruppoService> _serviceSnapshot =
		new Snapshot<>(
			RubricaGruppoServiceUtil.class, RubricaGruppoService.class);

}