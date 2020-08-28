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

import it.eng.allerter.model.TipoEvento;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TipoEvento in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class TipoEventoCacheModel
	implements CacheModel<TipoEvento>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoEventoCacheModel)) {
			return false;
		}

		TipoEventoCacheModel tipoEventoCacheModel = (TipoEventoCacheModel)obj;

		if (eventoId == tipoEventoCacheModel.eventoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventoId=");
		sb.append(eventoId);
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
		sb.append(", indice=");
		sb.append(indice);
		sb.append(", tabella=");
		sb.append(tabella);
		sb.append(", split=");
		sb.append(split);
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
	public TipoEvento toEntityModel() {
		TipoEventoImpl tipoEventoImpl = new TipoEventoImpl();

		if (uuid == null) {
			tipoEventoImpl.setUuid("");
		}
		else {
			tipoEventoImpl.setUuid(uuid);
		}

		tipoEventoImpl.setEventoId(eventoId);
		tipoEventoImpl.setGroupId(groupId);
		tipoEventoImpl.setCompanyId(companyId);
		tipoEventoImpl.setUserId(userId);

		if (userName == null) {
			tipoEventoImpl.setUserName("");
		}
		else {
			tipoEventoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			tipoEventoImpl.setCreateDate(null);
		}
		else {
			tipoEventoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tipoEventoImpl.setModifiedDate(null);
		}
		else {
			tipoEventoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nome == null) {
			tipoEventoImpl.setNome("");
		}
		else {
			tipoEventoImpl.setNome(nome);
		}

		tipoEventoImpl.setIndice(indice);
		tipoEventoImpl.setTabella(tabella);
		tipoEventoImpl.setSplit(split);
		tipoEventoImpl.setCostiero(costiero);

		if (dataInizio == Long.MIN_VALUE) {
			tipoEventoImpl.setDataInizio(null);
		}
		else {
			tipoEventoImpl.setDataInizio(new Date(dataInizio));
		}

		if (dataFine == Long.MIN_VALUE) {
			tipoEventoImpl.setDataFine(null);
		}
		else {
			tipoEventoImpl.setDataFine(new Date(dataFine));
		}

		tipoEventoImpl.setParentId(parentId);

		tipoEventoImpl.resetOriginalValues();

		return tipoEventoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eventoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nome = objectInput.readUTF();

		indice = objectInput.readInt();

		tabella = objectInput.readInt();

		split = objectInput.readBoolean();

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

		objectOutput.writeLong(eventoId);

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

		objectOutput.writeInt(indice);

		objectOutput.writeInt(tabella);

		objectOutput.writeBoolean(split);

		objectOutput.writeBoolean(costiero);
		objectOutput.writeLong(dataInizio);
		objectOutput.writeLong(dataFine);

		objectOutput.writeLong(parentId);
	}

	public String uuid;
	public long eventoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nome;
	public int indice;
	public int tabella;
	public boolean split;
	public boolean costiero;
	public long dataInizio;
	public long dataFine;
	public long parentId;

}