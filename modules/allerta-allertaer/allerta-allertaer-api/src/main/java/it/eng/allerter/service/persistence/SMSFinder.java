/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

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