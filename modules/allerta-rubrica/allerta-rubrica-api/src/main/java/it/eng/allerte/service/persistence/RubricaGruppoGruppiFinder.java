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
public interface RubricaGruppoGruppiFinder {

	public java.util.ArrayList<Object[]> getAntenati(Long fkGruppoFiglio);

	public java.util.ArrayList<Object[]> getGruppiFigli(Long fkGruppoPadre);

	public java.util.ArrayList<Object[]> getGruppiPadriPerFiglio(
		Long fkGruppoPadre);

	public void deleteGruppoPadreFiglio(Long fkGruppo);

	public void deleteGruppoSottoGruppo(Long fkGruppo, Long fkSottoGruppo);

}