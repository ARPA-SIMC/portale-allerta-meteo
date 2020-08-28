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

import it.eng.bollettino.model.ValoreSensore;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ValoreSensore in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class ValoreSensoreCacheModel
	implements CacheModel<ValoreSensore>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ValoreSensoreCacheModel)) {
			return false;
		}

		ValoreSensoreCacheModel valoreSensoreCacheModel =
			(ValoreSensoreCacheModel)obj;

		if (id == valoreSensoreCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", value=");
		sb.append(value);
		sb.append(", datetime=");
		sb.append(datetime);
		sb.append(", idVariabile=");
		sb.append(idVariabile);
		sb.append(", idStazione=");
		sb.append(idStazione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ValoreSensore toEntityModel() {
		ValoreSensoreImpl valoreSensoreImpl = new ValoreSensoreImpl();

		if (uuid == null) {
			valoreSensoreImpl.setUuid("");
		}
		else {
			valoreSensoreImpl.setUuid(uuid);
		}

		valoreSensoreImpl.setId(id);
		valoreSensoreImpl.setValue(value);

		if (datetime == Long.MIN_VALUE) {
			valoreSensoreImpl.setDatetime(null);
		}
		else {
			valoreSensoreImpl.setDatetime(new Date(datetime));
		}

		if (idVariabile == null) {
			valoreSensoreImpl.setIdVariabile("");
		}
		else {
			valoreSensoreImpl.setIdVariabile(idVariabile);
		}

		if (idStazione == null) {
			valoreSensoreImpl.setIdStazione("");
		}
		else {
			valoreSensoreImpl.setIdStazione(idStazione);
		}

		valoreSensoreImpl.resetOriginalValues();

		return valoreSensoreImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		value = objectInput.readDouble();
		datetime = objectInput.readLong();
		idVariabile = objectInput.readUTF();
		idStazione = objectInput.readUTF();
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

		objectOutput.writeDouble(value);
		objectOutput.writeLong(datetime);

		if (idVariabile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idVariabile);
		}

		if (idStazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idStazione);
		}
	}

	public String uuid;
	public long id;
	public double value;
	public long datetime;
	public String idVariabile;
	public String idStazione;

}