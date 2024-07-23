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

import it.eng.allerter.model.AllertaValanghe;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AllertaValanghe in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AllertaValangheCacheModel
	implements CacheModel<AllertaValanghe>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AllertaValangheCacheModel)) {
			return false;
		}

		AllertaValangheCacheModel allertaValangheCacheModel =
			(AllertaValangheCacheModel)obj;

		if (allertaValangheId == allertaValangheCacheModel.allertaValangheId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, allertaValangheId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(59);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", allertaValangheId=");
		sb.append(allertaValangheId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", creatorName=");
		sb.append(creatorName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", dataEmissione=");
		sb.append(dataEmissione);
		sb.append(", dataInizio=");
		sb.append(dataInizio);
		sb.append(", dataFine=");
		sb.append(dataFine);
		sb.append(", numero=");
		sb.append(numero);
		sb.append(", progressivo=");
		sb.append(progressivo);
		sb.append(", anno=");
		sb.append(anno);
		sb.append(", titolo=");
		sb.append(titolo);
		sb.append(", descrizioneFenomeni=");
		sb.append(descrizioneFenomeni);
		sb.append(", note=");
		sb.append(note);
		sb.append(", riferimenti=");
		sb.append(riferimenti);
		sb.append(", sintesi=");
		sb.append(sintesi);
		sb.append(", utenteFirmaArpaId=");
		sb.append(utenteFirmaArpaId);
		sb.append(", dataFirmaArpa=");
		sb.append(dataFirmaArpa);
		sb.append(", utenteFirmaProtId=");
		sb.append(utenteFirmaProtId);
		sb.append(", dataFirmaProt=");
		sb.append(dataFirmaProt);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", link=");
		sb.append(link);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", tipoAllerta=");
		sb.append(tipoAllerta);
		sb.append(", hash=");
		sb.append(hash);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AllertaValanghe toEntityModel() {
		AllertaValangheImpl allertaValangheImpl = new AllertaValangheImpl();

		if (uuid == null) {
			allertaValangheImpl.setUuid("");
		}
		else {
			allertaValangheImpl.setUuid(uuid);
		}

		allertaValangheImpl.setAllertaValangheId(allertaValangheId);
		allertaValangheImpl.setGroupId(groupId);
		allertaValangheImpl.setCompanyId(companyId);
		allertaValangheImpl.setUserId(userId);

		if (userName == null) {
			allertaValangheImpl.setUserName("");
		}
		else {
			allertaValangheImpl.setUserName(userName);
		}

		if (creatorName == null) {
			allertaValangheImpl.setCreatorName("");
		}
		else {
			allertaValangheImpl.setCreatorName(creatorName);
		}

		if (createDate == Long.MIN_VALUE) {
			allertaValangheImpl.setCreateDate(null);
		}
		else {
			allertaValangheImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			allertaValangheImpl.setModifiedDate(null);
		}
		else {
			allertaValangheImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (dataEmissione == Long.MIN_VALUE) {
			allertaValangheImpl.setDataEmissione(null);
		}
		else {
			allertaValangheImpl.setDataEmissione(new Date(dataEmissione));
		}

		if (dataInizio == Long.MIN_VALUE) {
			allertaValangheImpl.setDataInizio(null);
		}
		else {
			allertaValangheImpl.setDataInizio(new Date(dataInizio));
		}

		if (dataFine == Long.MIN_VALUE) {
			allertaValangheImpl.setDataFine(null);
		}
		else {
			allertaValangheImpl.setDataFine(new Date(dataFine));
		}

		if (numero == null) {
			allertaValangheImpl.setNumero("");
		}
		else {
			allertaValangheImpl.setNumero(numero);
		}

		allertaValangheImpl.setProgressivo(progressivo);
		allertaValangheImpl.setAnno(anno);

		if (titolo == null) {
			allertaValangheImpl.setTitolo("");
		}
		else {
			allertaValangheImpl.setTitolo(titolo);
		}

		if (descrizioneFenomeni == null) {
			allertaValangheImpl.setDescrizioneFenomeni("");
		}
		else {
			allertaValangheImpl.setDescrizioneFenomeni(descrizioneFenomeni);
		}

		if (note == null) {
			allertaValangheImpl.setNote("");
		}
		else {
			allertaValangheImpl.setNote(note);
		}

		if (riferimenti == null) {
			allertaValangheImpl.setRiferimenti("");
		}
		else {
			allertaValangheImpl.setRiferimenti(riferimenti);
		}

		if (sintesi == null) {
			allertaValangheImpl.setSintesi("");
		}
		else {
			allertaValangheImpl.setSintesi(sintesi);
		}

		allertaValangheImpl.setUtenteFirmaArpaId(utenteFirmaArpaId);

		if (dataFirmaArpa == Long.MIN_VALUE) {
			allertaValangheImpl.setDataFirmaArpa(null);
		}
		else {
			allertaValangheImpl.setDataFirmaArpa(new Date(dataFirmaArpa));
		}

		allertaValangheImpl.setUtenteFirmaProtId(utenteFirmaProtId);

		if (dataFirmaProt == Long.MIN_VALUE) {
			allertaValangheImpl.setDataFirmaProt(null);
		}
		else {
			allertaValangheImpl.setDataFirmaProt(new Date(dataFirmaProt));
		}

		allertaValangheImpl.setParentId(parentId);

		if (link == null) {
			allertaValangheImpl.setLink("");
		}
		else {
			allertaValangheImpl.setLink(link);
		}

		allertaValangheImpl.setStato(stato);
		allertaValangheImpl.setTipoAllerta(tipoAllerta);

		if (hash == null) {
			allertaValangheImpl.setHash("");
		}
		else {
			allertaValangheImpl.setHash(hash);
		}

		allertaValangheImpl.resetOriginalValues();

		return allertaValangheImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		allertaValangheId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		creatorName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dataEmissione = objectInput.readLong();
		dataInizio = objectInput.readLong();
		dataFine = objectInput.readLong();
		numero = objectInput.readUTF();

		progressivo = objectInput.readInt();

		anno = objectInput.readInt();
		titolo = objectInput.readUTF();
		descrizioneFenomeni = objectInput.readUTF();
		note = objectInput.readUTF();
		riferimenti = objectInput.readUTF();
		sintesi = objectInput.readUTF();

		utenteFirmaArpaId = objectInput.readLong();
		dataFirmaArpa = objectInput.readLong();

		utenteFirmaProtId = objectInput.readLong();
		dataFirmaProt = objectInput.readLong();

		parentId = objectInput.readLong();
		link = objectInput.readUTF();

		stato = objectInput.readInt();

		tipoAllerta = objectInput.readBoolean();
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

		objectOutput.writeLong(allertaValangheId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (creatorName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(creatorName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(dataEmissione);
		objectOutput.writeLong(dataInizio);
		objectOutput.writeLong(dataFine);

		if (numero == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(numero);
		}

		objectOutput.writeInt(progressivo);

		objectOutput.writeInt(anno);

		if (titolo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(titolo);
		}

		if (descrizioneFenomeni == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizioneFenomeni);
		}

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}

		if (riferimenti == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(riferimenti);
		}

		if (sintesi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sintesi);
		}

		objectOutput.writeLong(utenteFirmaArpaId);
		objectOutput.writeLong(dataFirmaArpa);

		objectOutput.writeLong(utenteFirmaProtId);
		objectOutput.writeLong(dataFirmaProt);

		objectOutput.writeLong(parentId);

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		objectOutput.writeInt(stato);

		objectOutput.writeBoolean(tipoAllerta);

		if (hash == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hash);
		}
	}

	public String uuid;
	public long allertaValangheId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public String creatorName;
	public long createDate;
	public long modifiedDate;
	public long dataEmissione;
	public long dataInizio;
	public long dataFine;
	public String numero;
	public int progressivo;
	public int anno;
	public String titolo;
	public String descrizioneFenomeni;
	public String note;
	public String riferimenti;
	public String sintesi;
	public long utenteFirmaArpaId;
	public long dataFirmaArpa;
	public long utenteFirmaProtId;
	public long dataFirmaProt;
	public long parentId;
	public String link;
	public int stato;
	public boolean tipoAllerta;
	public String hash;

}