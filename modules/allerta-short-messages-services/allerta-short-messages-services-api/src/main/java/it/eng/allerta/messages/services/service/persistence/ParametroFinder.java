/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Giorgianni_F
 * @generated
 */
@ProviderType
public interface ParametroFinder {

	public int resetSMSFaseTwo();

	public int resetSMSFaseThree();

	public java.util.List<Long> fetchSmsStatoTre();

}