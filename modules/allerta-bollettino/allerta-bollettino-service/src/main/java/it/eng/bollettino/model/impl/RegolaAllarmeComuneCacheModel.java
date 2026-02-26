/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

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
public class RegolaAllarmeComuneCacheModel
	implements CacheModel<RegolaAllarmeComune>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RegolaAllarmeComuneCacheModel)) {
			return false;
		}

		RegolaAllarmeComuneCacheModel regolaAllarmeComuneCacheModel =
			(RegolaAllarmeComuneCacheModel)object;

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