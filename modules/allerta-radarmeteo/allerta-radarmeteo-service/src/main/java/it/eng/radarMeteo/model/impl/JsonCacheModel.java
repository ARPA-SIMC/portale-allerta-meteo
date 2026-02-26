/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.radarMeteo.model.Json;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Json in entity cache.
 *
 * @author Francesco
 * @generated
 */
public class JsonCacheModel implements CacheModel<Json>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JsonCacheModel)) {
			return false;
		}

		JsonCacheModel jsonCacheModel = (JsonCacheModel)object;

		if (id == jsonCacheModel.id) {
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

		sb.append("{id=");
		sb.append(id);
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
	public Json toEntityModel() {
		JsonImpl jsonImpl = new JsonImpl();

		jsonImpl.setId(id);

		if (type == null) {
			jsonImpl.setType("");
		}
		else {
			jsonImpl.setType(type);
		}

		jsonImpl.setInserted(inserted);

		if (data == null) {
			jsonImpl.setData("");
		}
		else {
			jsonImpl.setData(data);
		}

		jsonImpl.resetOriginalValues();

		return jsonImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		type = objectInput.readUTF();

		inserted = objectInput.readLong();
		data = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

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
	public String type;
	public long inserted;
	public String data;

}