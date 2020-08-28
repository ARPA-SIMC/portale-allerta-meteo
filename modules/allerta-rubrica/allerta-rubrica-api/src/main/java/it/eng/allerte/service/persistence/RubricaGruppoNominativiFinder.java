/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.allerte.service.persistence;

import aQute.bnd.annotation.ProviderType;

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