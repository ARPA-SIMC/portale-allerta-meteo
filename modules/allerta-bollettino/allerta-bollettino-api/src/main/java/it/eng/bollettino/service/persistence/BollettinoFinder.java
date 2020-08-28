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

package it.eng.bollettino.service.persistence;

import aQute.bnd.annotation.ProviderType;

/**
 * @author GFAVINI
 * @generated
 */
@ProviderType
public interface BollettinoFinder {

	public java.util.List<Object> getFiumiBollettino(long id);

	public java.util.List<Object> getComuniAllarme();

	public long getUtenteApprovatore(long idBollettino);

	public double getSommaValori(
		String idStazione, String idVariabile, int quanti);

	public String nextIdMonitoraggio(int anno);

	public Object eseguiQueryGenerica(String s);

	public java.util.List<Object> eseguiQueryGenericaLista(String s);

}