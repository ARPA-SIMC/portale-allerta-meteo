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

import it.eng.bollettino.model.BollettinoIcona;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BollettinoIcona in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoIconaCacheModel
	implements CacheModel<BollettinoIcona>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BollettinoIconaCacheModel)) {
			return false;
		}

		BollettinoIconaCacheModel bollettinoIconaCacheModel =
			(BollettinoIconaCacheModel)obj;

		if (id == bollettinoIconaCacheModel.id) {
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
		sb.append(", idBollettino=");
		sb.append(idBollettino);
		sb.append(", idIcona=");
		sb.append(idIcona);
		sb.append(", x=");
		sb.append(x);
		sb.append(", y=");
		sb.append(y);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BollettinoIcona toEntityModel() {
		BollettinoIconaImpl bollettinoIconaImpl = new BollettinoIconaImpl();

		if (uuid == null) {
			bollettinoIconaImpl.setUuid("");
		}
		else {
			bollettinoIconaImpl.setUuid(uuid);
		}

		bollettinoIconaImpl.setId(id);
		bollettinoIconaImpl.setIdBollettino(idBollettino);
		bollettinoIconaImpl.setIdIcona(idIcona);
		bollettinoIconaImpl.setX(x);
		bollettinoIconaImpl.setY(y);

		bollettinoIconaImpl.resetOriginalValues();

		return bollettinoIconaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		idBollettino = objectInput.readLong();

		idIcona = objectInput.readLong();

		x = objectInput.readDouble();

		y = objectInput.readDouble();
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

		objectOutput.writeLong(idIcona);

		objectOutput.writeDouble(x);

		objectOutput.writeDouble(y);
	}

	public String uuid;
	public long id;
	public long idBollettino;
	public long idIcona;
	public double x;
	public double y;

}