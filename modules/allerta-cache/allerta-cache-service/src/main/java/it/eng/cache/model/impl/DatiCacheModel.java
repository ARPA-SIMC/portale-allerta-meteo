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

package it.eng.cache.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

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
@ProviderType
public class DatiCacheModel implements CacheModel<Dati>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DatiCacheModel)) {
			return false;
		}

		DatiCacheModel datiCacheModel = (DatiCacheModel)obj;

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