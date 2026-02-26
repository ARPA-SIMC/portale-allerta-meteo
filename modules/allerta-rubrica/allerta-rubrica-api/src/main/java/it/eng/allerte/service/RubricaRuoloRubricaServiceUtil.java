/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import java.util.Map;

/**
 * Provides the remote service utility for RubricaRuoloRubrica. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaRuoloRubricaServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaRuoloRubricaService
 * @generated
 */
public class RubricaRuoloRubricaServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaRuoloRubricaServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Map<String, Object> getAddressBookRoles() {
		return getService().getAddressBookRoles();
	}

	public static Long getCurrentSite() {
		return getService().getCurrentSite();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Map<Long, String> getSites() {
		return getService().getSites();
	}

	public static void updateSite(Long sito) {
		getService().updateSite(sito);
	}

	public static RubricaRuoloRubricaService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RubricaRuoloRubricaService> _serviceSnapshot =
		new Snapshot<>(
			RubricaRuoloRubricaServiceUtil.class,
			RubricaRuoloRubricaService.class);

}