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