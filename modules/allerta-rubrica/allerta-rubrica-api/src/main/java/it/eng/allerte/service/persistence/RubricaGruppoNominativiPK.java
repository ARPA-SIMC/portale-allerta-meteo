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
public class RubricaGruppoNominativiPK
	implements Comparable<RubricaGruppoNominativiPK>, Serializable {

	public long FK_GRUPPO;

	public long FK_NOMINATIVO;

	public RubricaGruppoNominativiPK() {
	}

	public RubricaGruppoNominativiPK(long FK_GRUPPO, long FK_NOMINATIVO) {
		this.FK_GRUPPO = FK_GRUPPO;
		this.FK_NOMINATIVO = FK_NOMINATIVO;
	}

	public long getFK_GRUPPO() {
		return FK_GRUPPO;
	}

	public void setFK_GRUPPO(long FK_GRUPPO) {
		this.FK_GRUPPO = FK_GRUPPO;
	}

	public long getFK_NOMINATIVO() {
		return FK_NOMINATIVO;
	}

	public void setFK_NOMINATIVO(long FK_NOMINATIVO) {
		this.FK_NOMINATIVO = FK_NOMINATIVO;
	}

	@Override
	public int compareTo(RubricaGruppoNominativiPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (FK_GRUPPO < pk.FK_GRUPPO) {
			value = -1;
		}
		else if (FK_GRUPPO > pk.FK_GRUPPO) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (FK_NOMINATIVO < pk.FK_NOMINATIVO) {
			value = -1;
		}
		else if (FK_NOMINATIVO > pk.FK_NOMINATIVO) {
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

		if (!(object instanceof RubricaGruppoNominativiPK)) {
			return false;
		}

		RubricaGruppoNominativiPK pk = (RubricaGruppoNominativiPK)object;

		if ((FK_GRUPPO == pk.FK_GRUPPO) &&
			(FK_NOMINATIVO == pk.FK_NOMINATIVO)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, FK_GRUPPO);
		hashCode = HashUtil.hash(hashCode, FK_NOMINATIVO);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("FK_GRUPPO=");

		sb.append(FK_GRUPPO);
		sb.append(", FK_NOMINATIVO=");

		sb.append(FK_NOMINATIVO);

		sb.append("}");

		return sb.toString();
	}

}