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
public interface JsonFinder {

	public java.util.List<Object[]> findRecentValuesByVar(String variabile);

	public java.util.List<Object[]> findValuesByVarDate(
		String variabile, Long date);

	public java.util.List<Object[]> findValuesByElenco(
		String variabile, Long date);

	public java.util.List<Object[]> findLastTheeDays(
		String stazione, String variabile);

	public java.util.List<Object[]> getInfoSensore(
		String idstazione, String variabile);

	public java.util.ArrayList<Object[]> getAllStations();

}