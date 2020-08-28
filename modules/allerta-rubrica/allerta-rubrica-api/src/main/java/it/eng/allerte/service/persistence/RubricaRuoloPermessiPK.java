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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaRuoloPermessiPK)) {
			return false;
		}

		RubricaRuoloPermessiPK pk = (RubricaRuoloPermessiPK)obj;

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