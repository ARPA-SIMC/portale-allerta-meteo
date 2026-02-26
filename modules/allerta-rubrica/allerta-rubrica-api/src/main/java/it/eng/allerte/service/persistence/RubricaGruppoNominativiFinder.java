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
public interface RubricaGruppoNominativiFinder {

	public void deleteByNominativo(Long fkNominativo);

	public void deleteByGruppo(Long fkGruppo);

	public void deleteNominativoDaGruppo(Long fkGruppo, Long fkNominativo);

	public java.util.List<Object[]> loadByidRuolo(Long idRuolo);

	public java.util.List<Object[]> loadNominativiGruppo(
		Long idGruppo, Long idSite);

	public java.util.List<Object[]> loadRuoloByNominativo(Long idNominativo);

}