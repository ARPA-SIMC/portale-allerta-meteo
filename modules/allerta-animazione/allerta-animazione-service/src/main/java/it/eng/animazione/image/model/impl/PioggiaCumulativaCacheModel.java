/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

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
public class PioggiaCumulativaCacheModel
	implements CacheModel<PioggiaCumulativa>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PioggiaCumulativaCacheModel)) {
			return false;
		}

		PioggiaCumulativaCacheModel pioggiaCumulativaCacheModel =
			(PioggiaCumulativaCacheModel)object;

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