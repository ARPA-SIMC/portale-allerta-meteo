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

import it.eng.allerter.model.Area;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Area in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AreaCacheModel implements CacheModel<Area>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AreaCacheModel)) {
			return false;
		}

		AreaCacheModel areaCacheModel = (AreaCacheModel)obj;

		if (areaId == areaCacheModel.areaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, areaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", areaId=");
		sb.append(areaId);
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
		sb.append(", tipoArea=");
		sb.append(tipoArea);
		sb.append(", costiero=");
		sb.append(costiero);
		sb.append(", dataInizio=");
		sb.append(dataInizio);
		sb.append(", dataFine=");
		sb.append(dataFine);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Area toEntityModel() {
		AreaImpl areaImpl = new AreaImpl();

		if (uuid == null) {
			areaImpl.setUuid("");
		}
		else {
			areaImpl.setUuid(uuid);
		}

		areaImpl.setAreaId(areaId);
		areaImpl.setGroupId(groupId);
		areaImpl.setCompanyId(companyId);
		areaImpl.setUserId(userId);

		if (userName == null) {
			areaImpl.setUserName("");
		}
		else {
			areaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			areaImpl.setCreateDate(null);
		}
		else {
			areaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			areaImpl.setModifiedDate(null);
		}
		else {
			areaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			areaImpl.setNome("");
		}
		else {
			areaImpl.setNome(nome);
		}

		if (tipoArea == null) {
			areaImpl.setTipoArea("");
		}
		else {
			areaImpl.setTipoArea(tipoArea);
		}

		areaImpl.setCostiero(costiero);

		if (dataInizio == Long.MIN_VALUE) {
			areaImpl.setDataInizio(null);
		}
		else {
			areaImpl.setDataInizio(new Date(dataInizio));
		}

		if (dataFine == Long.MIN_VALUE) {
			areaImpl.setDataFine(null);
		}
		else {
			areaImpl.setDataFine(new Date(dataFine));
		}

		areaImpl.setParentId(parentId);

		areaImpl.resetOriginalValues();

		return areaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		areaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();
		tipoArea = objectInput.readUTF();

		costiero = objectInput.readBoolean();
		dataInizio = objectInput.readLong();
		dataFine = objectInput.readLong();

		parentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(areaId);

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

		if (tipoArea == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tipoArea);
		}

		objectOutput.writeBoolean(costiero);
		objectOutput.writeLong(dataInizio);
		objectOutput.writeLong(dataFine);

		objectOutput.writeLong(parentId);
	}

	public String uuid;
	public long areaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public String tipoArea;
	public boolean costiero;
	public long dataInizio;
	public long dataFine;
	public long parentId;

}