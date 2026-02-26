/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.cache.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.cache.model.Dati;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Dati in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class DatiCacheModel implements CacheModel<Dati>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DatiCacheModel)) {
			return false;
		}

		DatiCacheModel datiCacheModel = (DatiCacheModel)object;

		if (idDati.equals(datiCacheModel.idDati)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, idDati);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{idDati=");
		sb.append(idDati);
		sb.append(", dato=");
		sb.append(dato);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dati toEntityModel() {
		DatiImpl datiImpl = new DatiImpl();

		if (idDati == null) {
			datiImpl.setIdDati("");
		}
		else {
			datiImpl.setIdDati(idDati);
		}

		if (dato == null) {
			datiImpl.setDato("");
		}
		else {
			datiImpl.setDato(dato);
		}

		if (createDate == Long.MIN_VALUE) {
			datiImpl.setCreateDate(null);
		}
		else {
			datiImpl.setCreateDate(new Date(createDate));
		}

		datiImpl.resetOriginalValues();

		return datiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		idDati = objectInput.readUTF();
		dato = objectInput.readUTF();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (idDati == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idDati);
		}

		if (dato == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dato);
		}

		objectOutput.writeLong(createDate);
	}

	public String idDati;
	public String dato;
	public long createDate;

}