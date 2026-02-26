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
public interface RubricaNominativoFinder {

	public java.util.ArrayList<Object[]> getNominativiByName(
		String name, Long limit, Long offset);

}