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

import it.eng.bollettino.model.Variabile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Variabile in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class VariabileCacheModel
	implements CacheModel<Variabile>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VariabileCacheModel)) {
			return false;
		}

		VariabileCacheModel variabileCacheModel = (VariabileCacheModel)obj;

		if (id.equals(variabileCacheModel.id)) {
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
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", description_it=");
		sb.append(description_it);
		sb.append(", level_t1=");
		sb.append(level_t1);
		sb.append(", level_t2=");
		sb.append(level_t2);
		sb.append(", level_v1=");
		sb.append(level_v1);
		sb.append(", level_v2=");
		sb.append(level_v2);
		sb.append(", trange_p1=");
		sb.append(trange_p1);
		sb.append(", trange_p2=");
		sb.append(trange_p2);
		sb.append(", trange_pind=");
		sb.append(trange_pind);
		sb.append(", unit=");
		sb.append(unit);
		sb.append(", bcode=");
		sb.append(bcode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Variabile toEntityModel() {
		VariabileImpl variabileImpl = new VariabileImpl();

		if (uuid == null) {
			variabileImpl.setUuid("");
		}
		else {
			variabileImpl.setUuid(uuid);
		}

		if (id == null) {
			variabileImpl.setId("");
		}
		else {
			variabileImpl.setId(id);
		}

		if (description_it == null) {
			variabileImpl.setDescription_it("");
		}
		else {
			variabileImpl.setDescription_it(description_it);
		}

		variabileImpl.setLevel_t1(level_t1);
		variabileImpl.setLevel_t2(level_t2);
		variabileImpl.setLevel_v1(level_v1);
		variabileImpl.setLevel_v2(level_v2);
		variabileImpl.setTrange_p1(trange_p1);
		variabileImpl.setTrange_p2(trange_p2);
		variabileImpl.setTrange_pind(trange_pind);

		if (unit == null) {
			variabileImpl.setUnit("");
		}
		else {
			variabileImpl.setUnit(unit);
		}

		if (bcode == null) {
			variabileImpl.setBcode("");
		}
		else {
			variabileImpl.setBcode(bcode);
		}

		variabileImpl.resetOriginalValues();

		return variabileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		id = objectInput.readUTF();
		description_it = objectInput.readUTF();

		level_t1 = objectInput.readInt();

		level_t2 = objectInput.readInt();

		level_v1 = objectInput.readInt();

		level_v2 = objectInput.readInt();

		trange_p1 = objectInput.readInt();

		trange_p2 = objectInput.readInt();

		trange_pind = objectInput.readInt();
		unit = objectInput.readUTF();
		bcode = objectInput.readUTF();
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

		if (description_it == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description_it);
		}

		objectOutput.writeInt(level_t1);

		objectOutput.writeInt(level_t2);

		objectOutput.writeInt(level_v1);

		objectOutput.writeInt(level_v2);

		objectOutput.writeInt(trange_p1);

		objectOutput.writeInt(trange_p2);

		objectOutput.writeInt(trange_pind);

		if (unit == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(unit);
		}

		if (bcode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bcode);
		}
	}

	public String uuid;
	public String id;
	public String description_it;
	public int level_t1;
	public int level_t2;
	public int level_v1;
	public int level_v2;
	public int trange_p1;
	public int trange_p2;
	public int trange_pind;
	public String unit;
	public String bcode;

}