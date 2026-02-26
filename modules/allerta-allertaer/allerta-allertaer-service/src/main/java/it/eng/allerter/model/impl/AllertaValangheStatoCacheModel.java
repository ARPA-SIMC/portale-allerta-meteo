/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerter.model.AllertaValangheStato;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AllertaValangheStato in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class AllertaValangheStatoCacheModel
	implements CacheModel<AllertaValangheStato>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AllertaValangheStatoCacheModel)) {
			return false;
		}

		AllertaValangheStatoCacheModel allertaValangheStatoCacheModel =
			(AllertaValangheStatoCacheModel)object;

		if (allertaValangheStatoId ==
				allertaValangheStatoCacheModel.allertaValangheStatoId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, allertaValangheStatoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", allertaValangheStatoId=");
		sb.append(allertaValangheStatoId);
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
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", dataInizio=");
		sb.append(dataInizio);
		sb.append(", dataFine=");
		sb.append(dataFine);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", allertaValangheId=");
		sb.append(allertaValangheId);
		sb.append(", statoId=");
		sb.append(statoId);
		sb.append(", eventoId=");
		sb.append(eventoId);
		sb.append(", areaId=");
		sb.append(areaId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AllertaValangheStato toEntityModel() {
		AllertaValangheStatoImpl allertaValangheStatoImpl =
			new AllertaValangheStatoImpl();

		if (uuid == null) {
			allertaValangheStatoImpl.setUuid("");
		}
		else {
			allertaValangheStatoImpl.setUuid(uuid);
		}

		allertaValangheStatoImpl.setAllertaValangheStatoId(
			allertaValangheStatoId);
		allertaValangheStatoImpl.setGroupId(groupId);
		allertaValangheStatoImpl.setCompanyId(companyId);
		allertaValangheStatoImpl.setUserId(userId);

		if (userName == null) {
			allertaValangheStatoImpl.setUserName("");
		}
		else {
			allertaValangheStatoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			allertaValangheStatoImpl.setCreateDate(null);
		}
		else {
			allertaValangheStatoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			allertaValangheStatoImpl.setModifiedDate(null);
		}
		else {
			allertaValangheStatoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			allertaValangheStatoImpl.setNome("");
		}
		else {
			allertaValangheStatoImpl.setNome(nome);
		}

		if (dataInizio == Long.MIN_VALUE) {
			allertaValangheStatoImpl.setDataInizio(null);
		}
		else {
			allertaValangheStatoImpl.setDataInizio(new Date(dataInizio));
		}

		if (dataFine == Long.MIN_VALUE) {
			allertaValangheStatoImpl.setDataFine(null);
		}
		else {
			allertaValangheStatoImpl.setDataFine(new Date(dataFine));
		}

		allertaValangheStatoImpl.setParentId(parentId);
		allertaValangheStatoImpl.setAllertaValangheId(allertaValangheId);
		allertaValangheStatoImpl.setStatoId(statoId);
		allertaValangheStatoImpl.setEventoId(eventoId);
		allertaValangheStatoImpl.setAreaId(areaId);

		allertaValangheStatoImpl.resetOriginalValues();

		return allertaValangheStatoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		allertaValangheStatoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		dataInizio = objectInput.readLong();
		dataFine = objectInput.readLong();

		parentId = objectInput.readLong();

		allertaValangheId = objectInput.readLong();

		statoId = objectInput.readLong();

		eventoId = objectInput.readLong();

		areaId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(allertaValangheStatoId);

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

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		objectOutput.writeLong(dataInizio);
		objectOutput.writeLong(dataFine);

		objectOutput.writeLong(parentId);

		objectOutput.writeLong(allertaValangheId);

		objectOutput.writeLong(statoId);

		objectOutput.writeLong(eventoId);

		objectOutput.writeLong(areaId);
	}

	public String uuid;
	public long allertaValangheStatoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public long dataInizio;
	public long dataFine;
	public long parentId;
	public long allertaValangheId;
	public long statoId;
	public long eventoId;
	public long areaId;

}