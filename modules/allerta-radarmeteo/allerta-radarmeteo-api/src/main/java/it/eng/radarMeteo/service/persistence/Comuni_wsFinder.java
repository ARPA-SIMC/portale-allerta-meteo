/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Francesco
 * @generated
 */
@ProviderType
public interface Comuni_wsFinder {

	public java.util.List<Object[]> getMeteomont();

	public java.util.List<Object[]> getStatoAllerta(java.sql.Timestamp data);

	public java.util.List<Object[]> getStatoAllertaForCap(
		java.sql.Timestamp data);

	public java.util.List<Object[]> getBollettinoMonitoraggio();

}