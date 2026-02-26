/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.animazione.image.model.altezzaOndaAdriac;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing altezzaOndaAdriac in entity cache.
 *
 * @author UTENTE
 * @generated
 */
public class altezzaOndaAdriacCacheModel
	implements CacheModel<altezzaOndaAdriac>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof altezzaOndaAdriacCacheModel)) {
			return false;
		}

		altezzaOndaAdriacCacheModel altezzaOndaAdriacCacheModel =
			(altezzaOndaAdriacCacheModel)object;

		if (id == altezzaOndaAdriacCacheModel.id) {
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
	public altezzaOndaAdriac toEntityModel() {
		altezzaOndaAdriacImpl altezzaOndaAdriacImpl =
			new altezzaOndaAdriacImpl();

		altezzaOndaAdriacImpl.setId(id);

		if (im == null) {
			altezzaOndaAdriacImpl.setIm("");
		}
		else {
			altezzaOndaAdriacImpl.setIm(im);
		}

		if (text_LOC == null) {
			altezzaOndaAdriacImpl.setText_LOC("");
		}
		else {
			altezzaOndaAdriacImpl.setText_LOC(text_LOC);
		}

		altezzaOndaAdriacImpl.setTs_UTC(ts_UTC);

		if (imgData == null) {
			altezzaOndaAdriacImpl.setImgData("");
		}
		else {
			altezzaOndaAdriacImpl.setImgData(imgData);
		}

		altezzaOndaAdriacImpl.resetOriginalValues();

		return altezzaOndaAdriacImpl;
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