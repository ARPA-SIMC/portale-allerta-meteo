/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import java.util.Map;

/**
 * Provides the remote service utility for RubricaRuoloPermessi. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaRuoloPermessiServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessiService
 * @generated
 */
public class RubricaRuoloPermessiServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaRuoloPermessiServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Map<String, Object> getRolePermission() {
		return getService().getRolePermission();
	}

	public static Map<String, Object> getUserInfo() {
		return getService().getUserInfo();
	}

	public static Map<String, Object> insertRolePermission(String data) {
		return getService().insertRolePermission(data);
	}

	public static Map<String, Object> updateRolePermission(String data) {
		return getService().updateRolePermission(data);
	}

	public static RubricaRuoloPermessiService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RubricaRuoloPermessiService>
		_serviceSnapshot = new Snapshot<>(
			RubricaRuoloPermessiServiceUtil.class,
			RubricaRuoloPermessiService.class);

}