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

package allerta.catasto.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SottocategoriaPK)) {
			return false;
		}

		SottocategoriaPK pk = (SottocategoriaPK)obj;

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