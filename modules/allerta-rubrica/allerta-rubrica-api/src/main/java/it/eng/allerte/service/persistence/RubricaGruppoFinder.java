/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Pratola_L
 * @generated
 */
@ProviderType
public interface RubricaGruppoFinder {

	public void aggiornaTuttoGruppo(Long gruppo);

	public java.util.ArrayList<Object[]> getGruppiByName(
		Long site, String groupName, Long limit, Long offset);

	public java.util.ArrayList<Object[]> getGruppiByNameCategory(
		Long site, String groupName, Long category, Long limit, Long offset);

	public java.util.ArrayList<Object[]> getGerarchia(Long site);

	public Object[] getGruppiByOwnerAndName(Long idOwner, String groupName);

	public java.util.ArrayList<Object[]> getAllGruppi(Long limit, Long offset);

	public java.util.ArrayList<Object[]> getGroup(Long id);

}