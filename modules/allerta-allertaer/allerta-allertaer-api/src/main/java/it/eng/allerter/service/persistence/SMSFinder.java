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

package it.eng.allerter.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author GFAVINI
 * @generated
 */
@ProviderType
public interface SMSFinder {

	public int eliminaDuplicati(String tipo, String sottotipo, long param);

	public int eliminaDuplicatiEmail(String tipo, String sottotipo, long param);

	public java.util.List<Object[]> ottieniPerSpedizione(
		String tipo, String sottotipo, long param);

	public java.util.List<Object[]> ottieniPerSpedizione(
		String tipo, String sottotipo, long param, int currentStatus,
		int newStatus, int limit);

	public java.util.List<String> ottieniEmailPerSpedizione(
		String tipo, String sottotipo, long param);

	public java.util.List<String> ottieniEmailPerSpedizione(
		String tipo, String sottotipo, long param, String text, String subject);

	public int marcaMessaggiInTimeout();

}