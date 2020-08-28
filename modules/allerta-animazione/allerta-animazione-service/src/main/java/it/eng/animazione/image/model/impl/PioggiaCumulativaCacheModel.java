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

package it.eng.animazione.image.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.animazione.image.model.PioggiaCumulativa;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PioggiaCumulativa in entity cache.
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class PioggiaCumulativaCacheModel
	implements CacheModel<PioggiaCumulativa>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PioggiaCumulativaCacheModel)) {
			return false;
		}

		PioggiaCumulativaCacheModel pioggiaCumulativaCacheModel =
			(PioggiaCumulativaCacheModel)obj;

		if (id == pioggiaCumulativaCacheModel.id) {
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
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", cumulazione=");
		sb.append(cumulazione);
		sb.append(", inzioCumulazione=");
		sb.append(inzioCumulazione);
		sb.append(", fineCumulazione=");
		sb.append(fineCumulazione);
		sb.append(", imgData=");
		sb.append(imgData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PioggiaCumulativa toEntityModel() {
		PioggiaCumulativaImpl pioggiaCumulativaImpl =
			new PioggiaCumulativaImpl();

		pioggiaCumulativaImpl.setId(id);

		if (nome == null) {
			pioggiaCumulativaImpl.setNome("");
		}
		else {
			pioggiaCumulativaImpl.setNome(nome);
		}

		if (cumulazione == null) {
			pioggiaCumulativaImpl.setCumulazione("");
		}
		else {
			pioggiaCumulativaImpl.setCumulazione(cumulazione);
		}

		if (inzioCumulazione == Long.MIN_VALUE) {
			pioggiaCumulativaImpl.setInzioCumulazione(null);
		}
		else {
			pioggiaCumulativaImpl.setInzioCumulazione(
				new Date(inzioCumulazione));
		}

		if (fineCumulazione == Long.MIN_VALUE) {
			pioggiaCumulativaImpl.setFineCumulazione(null);
		}
		else {
			pioggiaCumulativaImpl.setFineCumulazione(new Date(fineCumulazione));
		}

		if (imgData == null) {
			pioggiaCumulativaImpl.setImgData("");
		}
		else {
			pioggiaCumulativaImpl.setImgData(imgData);
		}

		pioggiaCumulativaImpl.resetOriginalValues();

		return pioggiaCumulativaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		nome = objectInput.readUTF();
		cumulazione = objectInput.readUTF();
		inzioCumulazione = objectInput.readLong();
		fineCumulazione = objectInput.readLong();
		imgData = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (cumulazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cumulazione);
		}

		objectOutput.writeLong(inzioCumulazione);
		objectOutput.writeLong(fineCumulazione);

		if (imgData == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imgData);
		}
	}

	public long id;
	public String nome;
	public String cumulazione;
	public long inzioCumulazione;
	public long fineCumulazione;
	public String imgData;

}