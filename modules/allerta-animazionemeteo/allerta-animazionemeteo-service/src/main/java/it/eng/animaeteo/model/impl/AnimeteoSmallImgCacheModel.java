/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.animaeteo.model.AnimeteoSmallImg;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AnimeteoSmallImg in entity cache.
 *
 * @author UTENTE
 * @generated
 */
public class AnimeteoSmallImgCacheModel
	implements CacheModel<AnimeteoSmallImg>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnimeteoSmallImgCacheModel)) {
			return false;
		}

		AnimeteoSmallImgCacheModel animeteoSmallImgCacheModel =
			(AnimeteoSmallImgCacheModel)object;

		if (id == animeteoSmallImgCacheModel.id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", inserted=");
		sb.append(inserted);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnimeteoSmallImg toEntityModel() {
		AnimeteoSmallImgImpl animeteoSmallImgImpl = new AnimeteoSmallImgImpl();

		animeteoSmallImgImpl.setId(id);

		if (name == null) {
			animeteoSmallImgImpl.setName("");
		}
		else {
			animeteoSmallImgImpl.setName(name);
		}

		if (type == null) {
			animeteoSmallImgImpl.setType("");
		}
		else {
			animeteoSmallImgImpl.setType(type);
		}

		if (inserted == Long.MIN_VALUE) {
			animeteoSmallImgImpl.setInserted(null);
		}
		else {
			animeteoSmallImgImpl.setInserted(new Date(inserted));
		}

		if (data == null) {
			animeteoSmallImgImpl.setData("");
		}
		else {
			animeteoSmallImgImpl.setData(data);
		}

		animeteoSmallImgImpl.resetOriginalValues();

		return animeteoSmallImgImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		name = objectInput.readUTF();
		type = objectInput.readUTF();
		inserted = objectInput.readLong();
		data = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(inserted);

		if (data == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(data);
		}
	}

	public long id;
	public String name;
	public String type;
	public long inserted;
	public String data;

}