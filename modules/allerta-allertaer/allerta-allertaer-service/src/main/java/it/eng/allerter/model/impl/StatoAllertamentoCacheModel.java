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

import it.eng.allerter.model.StatoAllertamento;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StatoAllertamento in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class StatoAllertamentoCacheModel
	implements CacheModel<StatoAllertamento>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoAllertamentoCacheModel)) {
			return false;
		}

		StatoAllertamentoCacheModel statoAllertamentoCacheModel =
			(StatoAllertamentoCacheModel)obj;

		if (statoId == statoAllertamentoCacheModel.statoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, statoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", statoId=");
		sb.append(statoId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatoAllertamento toEntityModel() {
		StatoAllertamentoImpl statoAllertamentoImpl =
			new StatoAllertamentoImpl();

		if (uuid == null) {
			statoAllertamentoImpl.setUuid("");
		}
		else {
			statoAllertamentoImpl.setUuid(uuid);
		}

		statoAllertamentoImpl.setStatoId(statoId);
		statoAllertamentoImpl.setGroupId(groupId);
		statoAllertamentoImpl.setCompanyId(companyId);
		statoAllertamentoImpl.setUserId(userId);

		if (userName == null) {
			statoAllertamentoImpl.setUserName("");
		}
		else {
			statoAllertamentoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			statoAllertamentoImpl.setCreateDate(null);
		}
		else {
			statoAllertamentoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			statoAllertamentoImpl.setModifiedDate(null);
		}
		else {
			statoAllertamentoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			statoAllertamentoImpl.setNome("");
		}
		else {
			statoAllertamentoImpl.setNome(nome);
		}

		if (dataInizio == Long.MIN_VALUE) {
			statoAllertamentoImpl.setDataInizio(null);
		}
		else {
			statoAllertamentoImpl.setDataInizio(new Date(dataInizio));
		}

		if (dataFine == Long.MIN_VALUE) {
			statoAllertamentoImpl.setDataFine(null);
		}
		else {
			statoAllertamentoImpl.setDataFine(new Date(dataFine));
		}

		statoAllertamentoImpl.setParentId(parentId);

		statoAllertamentoImpl.resetOriginalValues();

		return statoAllertamentoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		statoId = objectInput.readLong();

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
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(statoId);

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
	}

	public String uuid;
	public long statoId;
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

}