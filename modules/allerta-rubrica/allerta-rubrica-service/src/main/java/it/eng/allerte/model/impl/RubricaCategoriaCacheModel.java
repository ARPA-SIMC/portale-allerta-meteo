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

package it.eng.allerte.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

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
@ProviderType
public class RubricaCategoriaCacheModel
	implements CacheModel<RubricaCategoria>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaCategoriaCacheModel)) {
			return false;
		}

		RubricaCategoriaCacheModel rubricaCategoriaCacheModel =
			(RubricaCategoriaCacheModel)obj;

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