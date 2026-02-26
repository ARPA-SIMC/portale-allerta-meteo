/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import java.util.Map;

/**
 * Provides the remote service utility for Bollettino. This utility wraps
 * <code>it.eng.bollettino.service.impl.BollettinoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author GFAVINI
 * @see BollettinoService
 * @generated
 */
public class BollettinoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.bollettino.service.impl.BollettinoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.ArrayList<Map<String, String>> getAllarmi() {
		return getService().getAllarmi();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static BollettinoService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<BollettinoService> _serviceSnapshot =
		new Snapshot<>(BollettinoServiceUtil.class, BollettinoService.class);

}