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

import it.eng.bollettino.model.RegolaAllarmeComune;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RegolaAllarmeComune in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class RegolaAllarmeComuneCacheModel
	implements CacheModel<RegolaAllarmeComune>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegolaAllarmeComuneCacheModel)) {
			return false;
		}

		RegolaAllarmeComuneCacheModel regolaAllarmeComuneCacheModel =
			(RegolaAllarmeComuneCacheModel)obj;

		if (id == regolaAllarmeComuneCacheModel.id) {
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
		sb.append(", idRegola=");
		sb.append(idRegola);
		sb.append(", idComune=");
		sb.append(idComune);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RegolaAllarmeComune toEntityModel() {
		RegolaAllarmeComuneImpl regolaAllarmeComuneImpl =
			new RegolaAllarmeComuneImpl();

		if (uuid == null) {
			regolaAllarmeComuneImpl.setUuid("");
		}
		else {
			regolaAllarmeComuneImpl.setUuid(uuid);
		}

		regolaAllarmeComuneImpl.setId(id);
		regolaAllarmeComuneImpl.setIdRegola(idRegola);
		regolaAllarmeComuneImpl.setIdComune(idComune);

		regolaAllarmeComuneImpl.resetOriginalValues();

		return regolaAllarmeComuneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		idRegola = objectInput.readLong();

		idComune = objectInput.readLong();
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

		objectOutput.writeLong(idRegola);

		objectOutput.writeLong(idComune);
	}

	public String uuid;
	public long id;
	public long idRegola;
	public long idComune;

}