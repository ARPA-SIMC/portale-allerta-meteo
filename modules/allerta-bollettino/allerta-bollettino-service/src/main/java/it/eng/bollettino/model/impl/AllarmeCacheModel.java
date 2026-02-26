/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.bollettino.model.Allarme;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Allarme in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class AllarmeCacheModel implements CacheModel<Allarme>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AllarmeCacheModel)) {
			return false;
		}

		AllarmeCacheModel allarmeCacheModel = (AllarmeCacheModel)object;

		if (allarmeId == allarmeCacheModel.allarmeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, allarmeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", allarmeId=");
		sb.append(allarmeId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", idApprovatore=");
		sb.append(idApprovatore);
		sb.append(", dataApprovazione=");
		sb.append(dataApprovazione);
		sb.append(", idRegola=");
		sb.append(idRegola);
		sb.append(", colore=");
		sb.append(colore);
		sb.append(", dataInizio=");
		sb.append(dataInizio);
		sb.append(", dataFine=");
		sb.append(dataFine);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Allarme toEntityModel() {
		AllarmeImpl allarmeImpl = new AllarmeImpl();

		if (uuid == null) {
			allarmeImpl.setUuid("");
		}
		else {
			allarmeImpl.setUuid(uuid);
		}

		allarmeImpl.setAllarmeId(allarmeId);
		allarmeImpl.setGroupId(groupId);
		allarmeImpl.setCompanyId(companyId);
		allarmeImpl.setUserId(userId);

		if (userName == null) {
			allarmeImpl.setUserName("");
		}
		else {
			allarmeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			allarmeImpl.setCreateDate(null);
		}
		else {
			allarmeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			allarmeImpl.setModifiedDate(null);
		}
		else {
			allarmeImpl.setModifiedDate(new Date(modifiedDate));
		}

		allarmeImpl.setStato(stato);
		allarmeImpl.setIdApprovatore(idApprovatore);

		if (dataApprovazione == Long.MIN_VALUE) {
			allarmeImpl.setDataApprovazione(null);
		}
		else {
			allarmeImpl.setDataApprovazione(new Date(dataApprovazione));
		}

		allarmeImpl.setIdRegola(idRegola);
		allarmeImpl.setColore(colore);

		if (dataInizio == Long.MIN_VALUE) {
			allarmeImpl.setDataInizio(null);
		}
		else {
			allarmeImpl.setDataInizio(new Date(dataInizio));
		}

		if (dataFine == Long.MIN_VALUE) {
			allarmeImpl.setDataFine(null);
		}
		else {
			allarmeImpl.setDataFine(new Date(dataFine));
		}

		allarmeImpl.resetOriginalValues();

		return allarmeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		allarmeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		stato = objectInput.readInt();

		idApprovatore = objectInput.readLong();
		dataApprovazione = objectInput.readLong();

		idRegola = objectInput.readLong();

		colore = objectInput.readInt();
		dataInizio = objectInput.readLong();
		dataFine = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(allarmeId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(stato);

		objectOutput.writeLong(idApprovatore);
		objectOutput.writeLong(dataApprovazione);

		objectOutput.writeLong(idRegola);

		objectOutput.writeInt(colore);
		objectOutput.writeLong(dataInizio);
		objectOutput.writeLong(dataFine);
	}

	public String uuid;
	public long allarmeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int stato;
	public long idApprovatore;
	public long dataApprovazione;
	public long idRegola;
	public int colore;
	public long dataInizio;
	public long dataFine;

}