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

package it.eng.allerte.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

/**
 * @author Pratola_L
 * @generated
 */
@ProviderType
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaGruppoGruppiPK)) {
			return false;
		}

		RubricaGruppoGruppiPK pk = (RubricaGruppoGruppiPK)obj;

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