/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.animazione.image.model.altezzaOnda;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing altezzaOnda in entity cache.
 *
 * @author UTENTE
 * @generated
 */
public class altezzaOndaCacheModel
	implements CacheModel<altezzaOnda>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof altezzaOndaCacheModel)) {
			return false;
		}

		altezzaOndaCacheModel altezzaOndaCacheModel =
			(altezzaOndaCacheModel)object;

		if (id == altezzaOndaCacheModel.id) {
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
		sb.append(", im=");
		sb.append(im);
		sb.append(", text_LOC=");
		sb.append(text_LOC);
		sb.append(", ts_UTC=");
		sb.append(ts_UTC);
		sb.append(", imgData=");
		sb.append(imgData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public altezzaOnda toEntityModel() {
		altezzaOndaImpl altezzaOndaImpl = new altezzaOndaImpl();

		altezzaOndaImpl.setId(id);

		if (im == null) {
			altezzaOndaImpl.setIm("");
		}
		else {
			altezzaOndaImpl.setIm(im);
		}

		if (text_LOC == null) {
			altezzaOndaImpl.setText_LOC("");
		}
		else {
			altezzaOndaImpl.setText_LOC(text_LOC);
		}

		altezzaOndaImpl.setTs_UTC(ts_UTC);

		if (imgData == null) {
			altezzaOndaImpl.setImgData("");
		}
		else {
			altezzaOndaImpl.setImgData(imgData);
		}

		altezzaOndaImpl.resetOriginalValues();

		return altezzaOndaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		im = objectInput.readUTF();
		text_LOC = objectInput.readUTF();

		ts_UTC = objectInput.readLong();
		imgData = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (im == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(im);
		}

		if (text_LOC == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(text_LOC);
		}

		objectOutput.writeLong(ts_UTC);

		if (imgData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imgData);
		}
	}

	public long id;
	public String im;
	public String text_LOC;
	public long ts_UTC;
	public String imgData;

}