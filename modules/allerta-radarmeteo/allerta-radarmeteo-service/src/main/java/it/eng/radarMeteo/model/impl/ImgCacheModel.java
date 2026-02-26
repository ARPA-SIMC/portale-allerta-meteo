/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.radarMeteo.model.Img;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Img in entity cache.
 *
 * @author Francesco
 * @generated
 */
public class ImgCacheModel implements CacheModel<Img>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ImgCacheModel)) {
			return false;
		}

		ImgCacheModel imgCacheModel = (ImgCacheModel)object;

		if (id == imgCacheModel.id) {
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
		sb.append(", coord=");
		sb.append(coord);
		sb.append(", palette=");
		sb.append(palette);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Img toEntityModel() {
		ImgImpl imgImpl = new ImgImpl();

		imgImpl.setId(id);

		if (coord == null) {
			imgImpl.setCoord("");
		}
		else {
			imgImpl.setCoord(coord);
		}

		if (palette == null) {
			imgImpl.setPalette("");
		}
		else {
			imgImpl.setPalette(palette);
		}

		imgImpl.setTimestamp(timestamp);

		if (data == null) {
			imgImpl.setData("");
		}
		else {
			imgImpl.setData(data);
		}

		imgImpl.resetOriginalValues();

		return imgImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		coord = objectInput.readUTF();
		palette = objectInput.readUTF();

		timestamp = objectInput.readLong();
		data = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (coord == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(coord);
		}

		if (palette == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(palette);
		}

		objectOutput.writeLong(timestamp);

		if (data == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(data);
		}
	}

	public long id;
	public String coord;
	public String palette;
	public long timestamp;
	public String data;

}