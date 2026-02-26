/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

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
public class BacinoCacheModel implements CacheModel<Bacino>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BacinoCacheModel)) {
			return false;
		}

		BacinoCacheModel bacinoCacheModel = (BacinoCacheModel)object;

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