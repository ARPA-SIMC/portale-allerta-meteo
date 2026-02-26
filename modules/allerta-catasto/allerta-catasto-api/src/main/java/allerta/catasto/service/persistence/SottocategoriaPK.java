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
public class SottocategoriaPK
	implements Comparable<SottocategoriaPK>, Serializable {

	public long id;
	public long idCategoria;

	public SottocategoriaPK() {
	}

	public SottocategoriaPK(long id, long idCategoria) {
		this.id = id;
		this.idCategoria = idCategoria;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public int compareTo(SottocategoriaPK pk) {
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

		if (idCategoria < pk.idCategoria) {
			value = -1;
		}
		else if (idCategoria > pk.idCategoria) {
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

		if (!(object instanceof SottocategoriaPK)) {
			return false;
		}

		SottocategoriaPK pk = (SottocategoriaPK)object;

		if ((id == pk.id) && (idCategoria == pk.idCategoria)) {
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
		hashCode = HashUtil.hash(hashCode, idCategoria);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("id=");

		sb.append(id);
		sb.append(", idCategoria=");

		sb.append(idCategoria);

		sb.append("}");

		return sb.toString();
	}

}