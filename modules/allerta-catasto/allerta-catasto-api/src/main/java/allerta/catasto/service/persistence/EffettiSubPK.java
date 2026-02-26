/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EffettiSubPK implements Comparable<EffettiSubPK>, Serializable {

	public long id;
	public long idEffetti;

	public EffettiSubPK() {
	}

	public EffettiSubPK(long id, long idEffetti) {
		this.id = id;
		this.idEffetti = idEffetti;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdEffetti() {
		return idEffetti;
	}

	public void setIdEffetti(long idEffetti) {
		this.idEffetti = idEffetti;
	}

	@Override
	public int compareTo(EffettiSubPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (id < pk.id) {
			value = -1;
		}
		else if (id > pk.id) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (idEffetti < pk.idEffetti) {
			value = -1;
		}
		else if (idEffetti > pk.idEffetti) {
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

		if (!(object instanceof EffettiSubPK)) {
			return false;
		}

		EffettiSubPK pk = (EffettiSubPK)object;

		if ((id == pk.id) && (idEffetti == pk.idEffetti)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, id);
		hashCode = HashUtil.hash(hashCode, idEffetti);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("id=");

		sb.append(id);
		sb.append(", idEffetti=");

		sb.append(idEffetti);

		sb.append("}");

		return sb.toString();
	}

}