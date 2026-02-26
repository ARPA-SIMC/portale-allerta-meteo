/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.bollettino.model.Icona;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Icona in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class IconaCacheModel implements CacheModel<Icona>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IconaCacheModel)) {
			return false;
		}

		IconaCacheModel iconaCacheModel = (IconaCacheModel)object;

		if (id == iconaCacheModel.id) {
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
		sb.append(", path=");
		sb.append(path);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Icona toEntityModel() {
		IconaImpl iconaImpl = new IconaImpl();

		if (uuid == null) {
			iconaImpl.setUuid("");
		}
		else {
			iconaImpl.setUuid(uuid);
		}

		iconaImpl.setId(id);

		if (path == null) {
			iconaImpl.setPath("");
		}
		else {
			iconaImpl.setPath(path);
		}

		if (descrizione == null) {
			iconaImpl.setDescrizione("");
		}
		else {
			iconaImpl.setDescrizione(descrizione);
		}

		iconaImpl.resetOriginalValues();

		return iconaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		path = objectInput.readUTF();
		descrizione = objectInput.readUTF();
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

		if (path == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(path);
		}

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}
	}

	public String uuid;
	public long id;
	public String path;
	public String descrizione;

}