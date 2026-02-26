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
public class RubricaGruppoGruppiPK
	implements Comparable<RubricaGruppoGruppiPK>, Serializable {

	public long FK_GRUPPO_PADRE;

	public long FK_GRUPPO_FIGLIO;

	public RubricaGruppoGruppiPK() {
	}

	public RubricaGruppoGruppiPK(long FK_GRUPPO_PADRE, long FK_GRUPPO_FIGLIO) {
		this.FK_GRUPPO_PADRE = FK_GRUPPO_PADRE;
		this.FK_GRUPPO_FIGLIO = FK_GRUPPO_FIGLIO;
	}

	public long getFK_GRUPPO_PADRE() {
		return FK_GRUPPO_PADRE;
	}

	public void setFK_GRUPPO_PADRE(long FK_GRUPPO_PADRE) {
		this.FK_GRUPPO_PADRE = FK_GRUPPO_PADRE;
	}

	public long getFK_GRUPPO_FIGLIO() {
		return FK_GRUPPO_FIGLIO;
	}

	public void setFK_GRUPPO_FIGLIO(long FK_GRUPPO_FIGLIO) {
		this.FK_GRUPPO_FIGLIO = FK_GRUPPO_FIGLIO;
	}

	@Override
	public int compareTo(RubricaGruppoGruppiPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (FK_GRUPPO_PADRE < pk.FK_GRUPPO_PADRE) {
			value = -1;
		}
		else if (FK_GRUPPO_PADRE > pk.FK_GRUPPO_PADRE) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (FK_GRUPPO_FIGLIO < pk.FK_GRUPPO_FIGLIO) {
			value = -1;
		}
		else if (FK_GRUPPO_FIGLIO > pk.FK_GRUPPO_FIGLIO) {
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

		if (!(object instanceof RubricaGruppoGruppiPK)) {
			return false;
		}

		RubricaGruppoGruppiPK pk = (RubricaGruppoGruppiPK)object;

		if ((FK_GRUPPO_PADRE == pk.FK_GRUPPO_PADRE) &&
			(FK_GRUPPO_FIGLIO == pk.FK_GRUPPO_FIGLIO)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, FK_GRUPPO_PADRE);
		hashCode = HashUtil.hash(hashCode, FK_GRUPPO_FIGLIO);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("FK_GRUPPO_PADRE=");

		sb.append(FK_GRUPPO_PADRE);
		sb.append(", FK_GRUPPO_FIGLIO=");

		sb.append(FK_GRUPPO_FIGLIO);

		sb.append("}");

		return sb.toString();
	}

}