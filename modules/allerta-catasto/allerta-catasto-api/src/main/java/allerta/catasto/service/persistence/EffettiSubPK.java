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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EffettiSubPK)) {
			return false;
		}

		EffettiSubPK pk = (EffettiSubPK)obj;

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