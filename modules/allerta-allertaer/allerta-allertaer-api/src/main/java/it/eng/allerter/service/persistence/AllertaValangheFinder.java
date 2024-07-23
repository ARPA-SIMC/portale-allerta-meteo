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