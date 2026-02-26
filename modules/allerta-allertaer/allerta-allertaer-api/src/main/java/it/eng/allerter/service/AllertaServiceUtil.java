/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import java.util.Map;

/**
 * Provides the remote service utility for Allerta. This utility wraps
 * <code>it.eng.allerter.service.impl.AllertaServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author GFAVINI
 * @see AllertaService
 * @generated
 */
public class AllertaServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerter.service.impl.AllertaServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static long getIdApprovatore(long id) {
		return getService().getIdApprovatore(id);
	}

	public static Map<String, Object> getInfoAllerta() {
		return getService().getInfoAllerta();
	}

	public static Map<String, Object> getInfoAllertaDomani() {
		return getService().getInfoAllertaDomani();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.ArrayList<Map<String, String>> getStatoAllerta() {
		return getService().getStatoAllerta();
	}

	public static java.util.ArrayList<Map<String, String>> getStatoAllertaDays(
		int giorni) {

		return getService().getStatoAllertaDays(giorni);
	}

	public static java.util.ArrayList<Map<String, String>>
		getStatoAllertaDomani() {

		return getService().getStatoAllertaDomani();
	}

	public static Map<String, Object> getStatoAllertaPrimes() {
		return getService().getStatoAllertaPrimes();
	}

	public static Map<String, Object> getStatoAllertaPrimesDomani() {
		return getService().getStatoAllertaPrimesDomani();
	}

	public static AllertaService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AllertaService> _serviceSnapshot =
		new Snapshot<>(AllertaServiceUtil.class, AllertaService.class);

}