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

package it.eng.previsioni.meteo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.previsioni.meteo.model.Img;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Img in entity cache.
 *
 * @author Brian Wing Shun Chan
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", daypart=");
		sb.append(daypart);
		sb.append(", day=");
		sb.append(day);
		sb.append(", provincia=");
		sb.append(provincia);
		sb.append(", inserted=");
		sb.append(inserted);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Img toEntityModel() {
		ImgImpl imgImpl = new ImgImpl();

		imgImpl.setId(id);

		if (daypart == null) {
			imgImpl.setDaypart("");
		}
		else {
			imgImpl.setDaypart(daypart);
		}

		if (day == null) {
			imgImpl.setDay("");
		}
		else {
			imgImpl.setDay(day);
		}

		if (provincia == null) {
			imgImpl.setProvincia("");
		}
		else {
			imgImpl.setProvincia(provincia);
		}

		if (inserted == Long.MIN_VALUE) {
			imgImpl.setInserted(null);
		}
		else {
			imgImpl.setInserted(new Date(inserted));
		}

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
		daypart = objectInput.readUTF();
		day = objectInput.readUTF();
		provincia = objectInput.readUTF();
		inserted = objectInput.readLong();
		data = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (daypart == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(daypart);
		}

		if (day == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(day);
		}

		if (provincia == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(provincia);
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
	public String daypart;
	public String day;
	public String provincia;
	public long inserted;
	public String data;

}