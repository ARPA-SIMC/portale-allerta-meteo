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

package it.eng.bollettino.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.bollettino.model.Bacino;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Bacino in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BacinoCacheModel implements CacheModel<Bacino>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BacinoCacheModel)) {
			return false;
		}

		BacinoCacheModel bacinoCacheModel = (BacinoCacheModel)obj;

		if (id.equals(bacinoCacheModel.id)) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", progressivo=");
		sb.append(progressivo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Bacino toEntityModel() {
		BacinoImpl bacinoImpl = new BacinoImpl();

		if (uuid == null) {
			bacinoImpl.setUuid("");
		}
		else {
			bacinoImpl.setUuid(uuid);
		}

		if (id == null) {
			bacinoImpl.setId("");
		}
		else {
			bacinoImpl.setId(id);
		}

		if (nome == null) {
			bacinoImpl.setNome("");
		}
		else {
			bacinoImpl.setNome(nome);
		}

		bacinoImpl.setProgressivo(progressivo);

		bacinoImpl.resetOriginalValues();

		return bacinoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		id = objectInput.readUTF();
		nome = objectInput.readUTF();

		progressivo = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(id);
		}

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		objectOutput.writeInt(progressivo);
	}

	public String uuid;
	public String id;
	public String nome;
	public int progressivo;

}