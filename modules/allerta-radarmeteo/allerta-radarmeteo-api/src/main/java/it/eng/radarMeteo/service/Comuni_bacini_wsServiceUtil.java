/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import java.util.Map;

/**
 * Provides the remote service utility for Comuni_bacini_ws. This utility wraps
 * <code>it.eng.radarMeteo.service.impl.Comuni_bacini_wsServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Francesco
 * @see Comuni_bacini_wsService
 * @generated
 */
public class Comuni_bacini_wsServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.radarMeteo.service.impl.Comuni_bacini_wsServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Map<String, Object> getBollettinoMonitoraggio() {
		return getService().getBollettinoMonitoraggio();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Comuni_bacini_wsService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<Comuni_bacini_wsService> _serviceSnapshot =
		new Snapshot<>(
			Comuni_bacini_wsServiceUtil.class, Comuni_bacini_wsService.class);

}