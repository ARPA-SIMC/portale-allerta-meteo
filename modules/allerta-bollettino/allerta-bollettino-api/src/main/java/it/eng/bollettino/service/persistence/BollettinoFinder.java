/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

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