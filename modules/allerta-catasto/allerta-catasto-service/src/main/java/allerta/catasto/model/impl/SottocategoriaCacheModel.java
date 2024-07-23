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

package allerta.catasto.model.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.model.Sottocategoria;
import allerta.catasto.service.persistence.SottocategoriaPK;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

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
@ProviderType
public class SottocategoriaCacheModel
	implements CacheModel<Sottocategoria>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SottocategoriaCacheModel)) {
			return false;
		}

		SottocategoriaCacheModel sottocategoriaCacheModel =
			(SottocategoriaCacheModel)obj;

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