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
public interface AllertaValangheFinder {

	public java.util.List<it.eng.allerter.model.AllertaValanghe>
		getAllertaValanghesOrdered(
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.eng.allerter.model.AllertaValanghe> comparator);

	public long getUtenteApprovatore(long idAllertaValanghe);

	public java.util.List<Object> getMacroareeAllertaValanghe(int giorni);

	public java.util.List<Object> getMacroareeAllertaValanghePrimes(int giorni);

	public java.util.Map<String, Object> getInfoAllertaValanghe(int giorni);

	public java.util.List<Object> getEventi(long allertaValangheId);

	public String nextIdAllertaValanghe(boolean allertaValanghe, int anno);

}