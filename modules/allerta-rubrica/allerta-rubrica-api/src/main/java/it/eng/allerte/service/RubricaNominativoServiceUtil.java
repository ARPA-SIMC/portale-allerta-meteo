/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.module.service.Snapshot;

import java.util.Map;

/**
 * Provides the remote service utility for RubricaNominativo. This utility wraps
 * <code>it.eng.allerte.service.impl.RubricaNominativoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Pratola_L
 * @see RubricaNominativoService
 * @generated
 */
public class RubricaNominativoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaNominativoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Map<String, Object> addNominativesGroupsMulti(
		Long id, String data) {

		return getService().addNominativesGroupsMulti(id, data);
	}

	public static Map<String, Object> deleteNominatives(Long id) {
		return getService().deleteNominatives(id);
	}

	public static Map<String, Object> deleteNominativesGroupsMulti(
		Long id, String data) {

		return getService().deleteNominativesGroupsMulti(id, data);
	}

	public static Map<String, Object> getNominatives(Long id) {
		return getService().getNominatives(id);
	}

	public static Map<String, Object> getNominatives(
		String name, int limit, int offset) {

		return getService().getNominatives(name, limit, offset);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Map<String, Object> importNominatives() {
		return getService().importNominatives();
	}

	public static Map<String, Object> insertNominatives(String data) {
		return getService().insertNominatives(data);
	}

	public static Map<String, Object> nominativesMulti(Long id) {
		return getService().nominativesMulti(id);
	}

	public static Map<String, Object> nominativesMulti(String data) {
		return getService().nominativesMulti(data);
	}

	public static Map<String, Object> updateNominatives(Long id, String data) {
		return getService().updateNominatives(id, data);
	}

	public static RubricaNominativoService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<RubricaNominativoService> _serviceSnapshot =
		new Snapshot<>(
			RubricaNominativoServiceUtil.class, RubricaNominativoService.class);

}