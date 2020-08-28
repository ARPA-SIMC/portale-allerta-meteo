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

package it.eng.radarMeteo.service.persistence;

import aQute.bnd.annotation.ProviderType;

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