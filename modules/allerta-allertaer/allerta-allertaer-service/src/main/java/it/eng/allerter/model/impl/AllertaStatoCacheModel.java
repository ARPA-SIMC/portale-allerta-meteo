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

package it.eng.allerter.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.allerter.model.AllertaStato;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AllertaStato in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AllertaStatoCacheModel
	implements CacheModel<AllertaStato>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AllertaStatoCacheModel)) {
			return false;
		}

		AllertaStatoCacheModel allertaStatoCacheModel =
			(AllertaStatoCacheModel)obj;

		if (allertaStatoId == allertaStatoCacheModel.allertaStatoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, allertaStatoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", allertaStatoId=");
		sb.append(allertaStatoId);
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
		sb.append(", allertaId=");
		sb.append(allertaId);
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
	public AllertaStato toEntityModel() {
		AllertaStatoImpl allertaStatoImpl = new AllertaStatoImpl();

		if (uuid == null) {
			allertaStatoImpl.setUuid("");
		}
		else {
			allertaStatoImpl.setUuid(uuid);
		}

		allertaStatoImpl.setAllertaStatoId(allertaStatoId);
		allertaStatoImpl.setGroupId(groupId);
		allertaStatoImpl.setCompanyId(companyId);
		allertaStatoImpl.setUserId(userId);

		if (userName == null) {
			allertaStatoImpl.setUserName("");
		}
		else {
			allertaStatoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			allertaStatoImpl.setCreateDate(null);
		}
		else {
			allertaStatoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			allertaStatoImpl.setModifiedDate(null);
		}
		else {
			allertaStatoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			allertaStatoImpl.setNome("");
		}
		else {
			allertaStatoImpl.setNome(nome);
		}

		if (dataInizio == Long.MIN_VALUE) {
			allertaStatoImpl.setDataInizio(null);
		}
		else {
			allertaStatoImpl.setDataInizio(new Date(dataInizio));
		}

		if (dataFine == Long.MIN_VALUE) {
			allertaStatoImpl.setDataFine(null);
		}
		else {
			allertaStatoImpl.setDataFine(new Date(dataFine));
		}

		allertaStatoImpl.setParentId(parentId);
		allertaStatoImpl.setAllertaId(allertaId);
		allertaStatoImpl.setStatoId(statoId);
		allertaStatoImpl.setEventoId(eventoId);
		allertaStatoImpl.setAreaId(areaId);

		allertaStatoImpl.resetOriginalValues();

		return allertaStatoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		allertaStatoId = objectInput.readLong();

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

		allertaId = objectInput.readLong();

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

		objectOutput.writeLong(allertaStatoId);

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

		objectOutput.writeLong(allertaId);

		objectOutput.writeLong(statoId);

		objectOutput.writeLong(eventoId);

		objectOutput.writeLong(areaId);
	}

	public String uuid;
	public long allertaStatoId;
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
	public long allertaId;
	public long statoId;
	public long eventoId;
	public long areaId;

}