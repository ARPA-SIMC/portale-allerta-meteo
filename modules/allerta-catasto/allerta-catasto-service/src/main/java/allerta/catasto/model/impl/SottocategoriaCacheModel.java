/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model.impl;

import allerta.catasto.model.Sottocategoria;
import allerta.catasto.service.persistence.SottocategoriaPK;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Sottocategoria in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SottocategoriaCacheModel
	implements CacheModel<Sottocategoria>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SottocategoriaCacheModel)) {
			return false;
		}

		SottocategoriaCacheModel sottocategoriaCacheModel =
			(SottocategoriaCacheModel)object;

		if (sottocategoriaPK.equals(
				sottocategoriaCacheModel.sottocategoriaPK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, sottocategoriaPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", idCategoria=");
		sb.append(idCategoria);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Sottocategoria toEntityModel() {
		SottocategoriaImpl sottocategoriaImpl = new SottocategoriaImpl();

		sottocategoriaImpl.setId(id);
		sottocategoriaImpl.setIdCategoria(idCategoria);

		if (descrizione == null) {
			sottocategoriaImpl.setDescrizione("");
		}
		else {
			sottocategoriaImpl.setDescrizione(descrizione);
		}

		sottocategoriaImpl.resetOriginalValues();

		return sottocategoriaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		idCategoria = objectInput.readLong();
		descrizione = objectInput.readUTF();

		sottocategoriaPK = new SottocategoriaPK(id, idCategoria);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(idCategoria);

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}
	}

	public long id;
	public long idCategoria;
	public String descrizione;
	public transient SottocategoriaPK sottocategoriaPK;

}