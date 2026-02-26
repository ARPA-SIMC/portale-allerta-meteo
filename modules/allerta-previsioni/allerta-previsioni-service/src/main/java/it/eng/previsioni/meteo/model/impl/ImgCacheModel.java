/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

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