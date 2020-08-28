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
public interface RubricaGruppoGruppiFinder {

	public java.util.ArrayList<Object[]> getAntenati(Long fkGruppoFiglio);

	public java.util.ArrayList<Object[]> getGruppiFigli(Long fkGruppoPadre);

	public java.util.ArrayList<Object[]> getGruppiPadriPerFiglio(
		Long fkGruppoPadre);

	public void deleteGruppoPadreFiglio(Long fkGruppo);

	public void deleteGruppoSottoGruppo(Long fkGruppo, Long fkSottoGruppo);

}