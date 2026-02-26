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
public interface AllertaFinder {

	public java.util.List<it.eng.allerter.model.Allerta> getAllertasOrdered(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<it.eng.allerter.model.Allerta> comparator);

	public long getUtenteApprovatore(long idAllerta);

	public java.util.List<Object> getMacroareeAllerta(int giorni);

	public java.util.List<Object> getMacroareeAllertaPrimes(int giorni);

	public java.util.Map<String, Object> getInfoAllerta(int giorni);

	public java.util.List<Object> getEventi(long allertaId);

	public String nextIdAllerta(boolean allerta, int anno);

}