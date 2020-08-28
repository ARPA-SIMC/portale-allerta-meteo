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

package it.eng.animaeteo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

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
@ProviderType
public class AnimeteoSmallImgCacheModel
	implements CacheModel<AnimeteoSmallImg>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnimeteoSmallImgCacheModel)) {
			return false;
		}

		AnimeteoSmallImgCacheModel animeteoSmallImgCacheModel =
			(AnimeteoSmallImgCacheModel)obj;

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