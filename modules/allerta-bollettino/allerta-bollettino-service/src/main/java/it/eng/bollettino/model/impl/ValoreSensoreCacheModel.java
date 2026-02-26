/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

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
public class ValoreSensoreCacheModel
	implements CacheModel<ValoreSensore>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ValoreSensoreCacheModel)) {
			return false;
		}

		ValoreSensoreCacheModel valoreSensoreCacheModel =
			(ValoreSensoreCacheModel)object;

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