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

import it.eng.bollettino.model.BollettinoBacino;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BollettinoBacino in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoBacinoCacheModel
	implements CacheModel<BollettinoBacino>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BollettinoBacinoCacheModel)) {
			return false;
		}

		BollettinoBacinoCacheModel bollettinoBacinoCacheModel =
			(BollettinoBacinoCacheModel)obj;

		if (id == bollettinoBacinoCacheModel.id) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", idBollettino=");
		sb.append(idBollettino);
		sb.append(", progressivo=");
		sb.append(progressivo);
		sb.append(", idBacino=");
		sb.append(idBacino);
		sb.append(", nomeBacino=");
		sb.append(nomeBacino);
		sb.append(", oreOsservazione=");
		sb.append(oreOsservazione);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BollettinoBacino toEntityModel() {
		BollettinoBacinoImpl bollettinoBacinoImpl = new BollettinoBacinoImpl();

		if (uuid == null) {
			bollettinoBacinoImpl.setUuid("");
		}
		else {
			bollettinoBacinoImpl.setUuid(uuid);
		}

		bollettinoBacinoImpl.setId(id);
		bollettinoBacinoImpl.setIdBollettino(idBollettino);
		bollettinoBacinoImpl.setProgressivo(progressivo);

		if (idBacino == null) {
			bollettinoBacinoImpl.setIdBacino("");
		}
		else {
			bollettinoBacinoImpl.setIdBacino(idBacino);
		}

		if (nomeBacino == null) {
			bollettinoBacinoImpl.setNomeBacino("");
		}
		else {
			bollettinoBacinoImpl.setNomeBacino(nomeBacino);
		}

		if (oreOsservazione == null) {
			bollettinoBacinoImpl.setOreOsservazione("");
		}
		else {
			bollettinoBacinoImpl.setOreOsservazione(oreOsservazione);
		}

		if (note == null) {
			bollettinoBacinoImpl.setNote("");
		}
		else {
			bollettinoBacinoImpl.setNote(note);
		}

		bollettinoBacinoImpl.resetOriginalValues();

		return bollettinoBacinoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		idBollettino = objectInput.readLong();

		progressivo = objectInput.readInt();
		idBacino = objectInput.readUTF();
		nomeBacino = objectInput.readUTF();
		oreOsservazione = objectInput.readUTF();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		objectOutput.writeLong(idBollettino);

		objectOutput.writeInt(progressivo);

		if (idBacino == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idBacino);
		}

		if (nomeBacino == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeBacino);
		}

		if (oreOsservazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(oreOsservazione);
		}

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public String uuid;
	public long id;
	public long idBollettino;
	public int progressivo;
	public String idBacino;
	public String nomeBacino;
	public String oreOsservazione;
	public String note;

}