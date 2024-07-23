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

package allerta.verifica.model.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.verifica.model.Verifica;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Verifica in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class VerificaCacheModel
	implements CacheModel<Verifica>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VerificaCacheModel)) {
			return false;
		}

		VerificaCacheModel verificaCacheModel = (VerificaCacheModel)obj;

		if (id == verificaCacheModel.id) {
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
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
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
		sb.append(", documento=");
		sb.append(documento);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", titolo=");
		sb.append(titolo);
		sb.append(", fenomeni=");
		sb.append(fenomeni);
		sb.append(", fenomeniDescritti=");
		sb.append(fenomeniDescritti);
		sb.append(", note=");
		sb.append(note);
		sb.append(", dataInizio=");
		sb.append(dataInizio);
		sb.append(", dataFine=");
		sb.append(dataFine);
		sb.append(", link=");
		sb.append(link);
		sb.append(", hash=");
		sb.append(hash);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Verifica toEntityModel() {
		VerificaImpl verificaImpl = new VerificaImpl();

		if (uuid == null) {
			verificaImpl.setUuid("");
		}
		else {
			verificaImpl.setUuid(uuid);
		}

		verificaImpl.setId(id);
		verificaImpl.setGroupId(groupId);
		verificaImpl.setCompanyId(companyId);
		verificaImpl.setUserId(userId);

		if (userName == null) {
			verificaImpl.setUserName("");
		}
		else {
			verificaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			verificaImpl.setCreateDate(null);
		}
		else {
			verificaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			verificaImpl.setModifiedDate(null);
		}
		else {
			verificaImpl.setModifiedDate(new Date(modifiedDate));
		}

		verificaImpl.setDocumento(documento);
		verificaImpl.setStato(stato);

		if (titolo == null) {
			verificaImpl.setTitolo("");
		}
		else {
			verificaImpl.setTitolo(titolo);
		}

		if (fenomeni == null) {
			verificaImpl.setFenomeni("");
		}
		else {
			verificaImpl.setFenomeni(fenomeni);
		}

		if (fenomeniDescritti == null) {
			verificaImpl.setFenomeniDescritti("");
		}
		else {
			verificaImpl.setFenomeniDescritti(fenomeniDescritti);
		}

		if (note == null) {
			verificaImpl.setNote("");
		}
		else {
			verificaImpl.setNote(note);
		}

		if (dataInizio == Long.MIN_VALUE) {
			verificaImpl.setDataInizio(null);
		}
		else {
			verificaImpl.setDataInizio(new Date(dataInizio));
		}

		if (dataFine == Long.MIN_VALUE) {
			verificaImpl.setDataFine(null);
		}
		else {
			verificaImpl.setDataFine(new Date(dataFine));
		}

		if (link == null) {
			verificaImpl.setLink("");
		}
		else {
			verificaImpl.setLink(link);
		}

		if (hash == null) {
			verificaImpl.setHash("");
		}
		else {
			verificaImpl.setHash(hash);
		}

		verificaImpl.resetOriginalValues();

		return verificaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		documento = objectInput.readLong();

		stato = objectInput.readInt();
		titolo = objectInput.readUTF();
		fenomeni = objectInput.readUTF();
		fenomeniDescritti = objectInput.readUTF();
		note = objectInput.readUTF();
		dataInizio = objectInput.readLong();
		dataFine = objectInput.readLong();
		link = objectInput.readUTF();
		hash = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

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

		objectOutput.writeLong(documento);

		objectOutput.writeInt(stato);

		if (titolo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(titolo);
		}

		if (fenomeni == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fenomeni);
		}

		if (fenomeniDescritti == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fenomeniDescritti);
		}

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(dataInizio);
		objectOutput.writeLong(dataFine);

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		if (hash == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hash);
		}
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long documento;
	public int stato;
	public String titolo;
	public String fenomeni;
	public String fenomeniDescritti;
	public String note;
	public long dataInizio;
	public long dataFine;
	public String link;
	public String hash;

}