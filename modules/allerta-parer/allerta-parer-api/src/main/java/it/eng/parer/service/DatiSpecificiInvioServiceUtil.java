/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import it.eng.parer.model.DatiSpecificiInvio;

import java.util.List;

/**
 * Provides the remote service utility for DatiSpecificiInvio. This utility wraps
 * <code>it.eng.parer.service.impl.DatiSpecificiInvioServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see DatiSpecificiInvioService
 * @generated
 */
public class DatiSpecificiInvioServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.parer.service.impl.DatiSpecificiInvioServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static List<DatiSpecificiInvio> listaDatiSpecificiByEsitoInvio(
		String esitoInvio) {

		return getService().listaDatiSpecificiByEsitoInvio(esitoInvio);
	}

	public static DatiSpecificiInvioService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<DatiSpecificiInvioService> _serviceSnapshot =
		new Snapshot<>(
			DatiSpecificiInvioServiceUtil.class,
			DatiSpecificiInvioService.class);

}