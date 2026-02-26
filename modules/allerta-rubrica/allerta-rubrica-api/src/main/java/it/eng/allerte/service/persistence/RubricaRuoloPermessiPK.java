/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Pratola_L
 * @generated
 */
public class RubricaRuoloPermessiPK
	implements Comparable<RubricaRuoloPermessiPK>, Serializable {

	public long FK_ID_RUOLO;

	public String FK_ID_PERMESSO;

	public RubricaRuoloPermessiPK() {
	}

	public RubricaRuoloPermessiPK(long FK_ID_RUOLO, String FK_ID_PERMESSO) {
		this.FK_ID_RUOLO = FK_ID_RUOLO;
		this.FK_ID_PERMESSO = FK_ID_PERMESSO;
	}

	public long getFK_ID_RUOLO() {
		return FK_ID_RUOLO;
	}

	public void setFK_ID_RUOLO(long FK_ID_RUOLO) {
		this.FK_ID_RUOLO = FK_ID_RUOLO;
	}

	public String getFK_ID_PERMESSO() {
		return FK_ID_PERMESSO;
	}

	public void setFK_ID_PERMESSO(String FK_ID_PERMESSO) {
		this.FK_ID_PERMESSO = FK_ID_PERMESSO;
	}

	@Override
	public int compareTo(RubricaRuoloPermessiPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (FK_ID_RUOLO < pk.FK_ID_RUOLO) {
			value = -1;
		}
		else if (FK_ID_RUOLO > pk.FK_ID_RUOLO) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = FK_ID_PERMESSO.compareTo(pk.FK_ID_PERMESSO);

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

		if (!(object instanceof RubricaRuoloPermessiPK)) {
			return false;
		}

		RubricaRuoloPermessiPK pk = (RubricaRuoloPermessiPK)object;

		if ((FK_ID_RUOLO == pk.FK_ID_RUOLO) &&
			FK_ID_PERMESSO.equals(pk.FK_ID_PERMESSO)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, FK_ID_RUOLO);
		hashCode = HashUtil.hash(hashCode, FK_ID_PERMESSO);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("FK_ID_RUOLO=");

		sb.append(FK_ID_RUOLO);
		sb.append(", FK_ID_PERMESSO=");

		sb.append(FK_ID_PERMESSO);

		sb.append("}");

		return sb.toString();
	}

}