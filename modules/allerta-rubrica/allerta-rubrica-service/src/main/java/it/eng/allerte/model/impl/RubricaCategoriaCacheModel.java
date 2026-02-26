/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerte.model.RubricaCategoria;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RubricaCategoria in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
public class RubricaCategoriaCacheModel
	implements CacheModel<RubricaCategoria>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RubricaCategoriaCacheModel)) {
			return false;
		}

		RubricaCategoriaCacheModel rubricaCategoriaCacheModel =
			(RubricaCategoriaCacheModel)object;

		if (ID_CATEGORIA == rubricaCategoriaCacheModel.ID_CATEGORIA) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_CATEGORIA);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{ID_CATEGORIA=");
		sb.append(ID_CATEGORIA);
		sb.append(", DESCRIZIONE=");
		sb.append(DESCRIZIONE);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RubricaCategoria toEntityModel() {
		RubricaCategoriaImpl rubricaCategoriaImpl = new RubricaCategoriaImpl();

		rubricaCategoriaImpl.setID_CATEGORIA(ID_CATEGORIA);

		if (DESCRIZIONE == null) {
			rubricaCategoriaImpl.setDESCRIZIONE("");
		}
		else {
			rubricaCategoriaImpl.setDESCRIZIONE(DESCRIZIONE);
		}

		rubricaCategoriaImpl.resetOriginalValues();

		return rubricaCategoriaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_CATEGORIA = objectInput.readLong();
		DESCRIZIONE = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_CATEGORIA);

		if (DESCRIZIONE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DESCRIZIONE);
		}
	}

	public long ID_CATEGORIA;

	public String DESCRIZIONE;

}