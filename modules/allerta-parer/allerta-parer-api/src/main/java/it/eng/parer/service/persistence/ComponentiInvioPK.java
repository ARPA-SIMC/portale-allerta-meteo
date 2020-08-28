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

package it.eng.parer.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

/**
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class ComponentiInvioPK
	implements Comparable<ComponentiInvioPK>, Serializable {

	public long ID_INVIO;

	public long ID_COMPONENTE;

	public ComponentiInvioPK() {
	}

	public ComponentiInvioPK(long ID_INVIO, long ID_COMPONENTE) {
		this.ID_INVIO = ID_INVIO;
		this.ID_COMPONENTE = ID_COMPONENTE;
	}

	public long getID_INVIO() {
		return ID_INVIO;
	}

	public void setID_INVIO(long ID_INVIO) {
		this.ID_INVIO = ID_INVIO;
	}

	public long getID_COMPONENTE() {
		return ID_COMPONENTE;
	}

	public void setID_COMPONENTE(long ID_COMPONENTE) {
		this.ID_COMPONENTE = ID_COMPONENTE;
	}

	@Override
	public int compareTo(ComponentiInvioPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (ID_INVIO < pk.ID_INVIO) {
			value = -1;
		}
		else if (ID_INVIO > pk.ID_INVIO) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (ID_COMPONENTE < pk.ID_COMPONENTE) {
			value = -1;
		}
		else if (ID_COMPONENTE > pk.ID_COMPONENTE) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ComponentiInvioPK)) {
			return false;
		}

		ComponentiInvioPK pk = (ComponentiInvioPK)obj;

		if ((ID_INVIO == pk.ID_INVIO) && (ID_COMPONENTE == pk.ID_COMPONENTE)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, ID_INVIO);
		hashCode = HashUtil.hash(hashCode, ID_COMPONENTE);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("ID_INVIO=");

		sb.append(ID_INVIO);
		sb.append(", ID_COMPONENTE=");

		sb.append(ID_COMPONENTE);

		sb.append("}");

		return sb.toString();
	}

}