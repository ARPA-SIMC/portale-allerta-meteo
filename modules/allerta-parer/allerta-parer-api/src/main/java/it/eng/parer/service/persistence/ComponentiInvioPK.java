/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Pratola_L
 * @generated
 */
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
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ComponentiInvioPK)) {
			return false;
		}

		ComponentiInvioPK pk = (ComponentiInvioPK)object;

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