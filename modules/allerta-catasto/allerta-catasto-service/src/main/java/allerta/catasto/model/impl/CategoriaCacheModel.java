/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model.impl;

import allerta.catasto.model.Categoria;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Categoria in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CategoriaCacheModel
	implements CacheModel<Categoria>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CategoriaCacheModel)) {
			return false;
		}

		CategoriaCacheModel categoriaCacheModel = (CategoriaCacheModel)object;

		if (id == categoriaCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(id);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Categoria toEntityModel() {
		CategoriaImpl categoriaImpl = new CategoriaImpl();

		categoriaImpl.setId(id);

		if (descrizione == null) {
			categoriaImpl.setDescrizione("");
		}
		else {
			categoriaImpl.setDescrizione(descrizione);
		}

		categoriaImpl.resetOriginalValues();

		return categoriaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		descrizione = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}
	}

	public long id;
	public String descrizione;

}