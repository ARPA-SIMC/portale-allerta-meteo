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

package it.eng.radarMeteo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

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
@ProviderType
public class ImgCacheModel implements CacheModel<Img>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImgCacheModel)) {
			return false;
		}

		ImgCacheModel imgCacheModel = (ImgCacheModel)obj;

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