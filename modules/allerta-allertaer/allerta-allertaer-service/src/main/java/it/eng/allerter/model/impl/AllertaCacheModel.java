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

import it.eng.allerter.model.Allerta;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Allerta in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AllertaCacheModel implements CacheModel<Allerta>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AllertaCacheModel)) {
			return false;
		}

		AllertaCacheModel allertaCacheModel = (AllertaCacheModel)obj;

		if (allertaId == allertaCacheModel.allertaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, allertaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", allertaId=");
		sb.append(allertaId);
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
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", numero=");
		sb.append(numero);
		sb.append(", progressivo=");
		sb.append(progressivo);
		sb.append(", anno=");
		sb.append(anno);
		sb.append(", dataEmissione=");
		sb.append(dataEmissione);
		sb.append(", dataInizio=");
		sb.append(dataInizio);
		sb.append(", dataFine=");
		sb.append(dataFine);
		sb.append(", descrizioneMeteo=");
		sb.append(descrizioneMeteo);
		sb.append(", tendenza=");
		sb.append(tendenza);
		sb.append(", note=");
		sb.append(note);
		sb.append(", riferimenti=");
		sb.append(riferimenti);
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
		sb.append(", sintesi=");
		sb.append(sintesi);
		sb.append(", link=");
		sb.append(link);
		sb.append(", titolo=");
		sb.append(titolo);
		sb.append(", tipoAllerta=");
		sb.append(tipoAllerta);
		sb.append(", hash=");
		sb.append(hash);
		sb.append(", sintesiBriefing=");
		sb.append(sintesiBriefing);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Allerta toEntityModel() {
		AllertaImpl allertaImpl = new AllertaImpl();

		if (uuid == null) {
			allertaImpl.setUuid("");
		}
		else {
			allertaImpl.setUuid(uuid);
		}

		allertaImpl.setAllertaId(allertaId);
		allertaImpl.setGroupId(groupId);
		allertaImpl.setCompanyId(companyId);
		allertaImpl.setUserId(userId);

		if (userName == null) {
			allertaImpl.setUserName("");
		}
		else {
			allertaImpl.setUserName(userName);
		}

		if (creatorName == null) {
			allertaImpl.setCreatorName("");
		}
		else {
			allertaImpl.setCreatorName(creatorName);
		}

		if (createDate == Long.MIN_VALUE) {
			allertaImpl.setCreateDate(null);
		}
		else {
			allertaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			allertaImpl.setModifiedDate(null);
		}
		else {
			allertaImpl.setModifiedDate(new Date(modifiedDate));
		}

		allertaImpl.setStato(stato);

		if (numero == null) {
			allertaImpl.setNumero("");
		}
		else {
			allertaImpl.setNumero(numero);
		}

		allertaImpl.setProgressivo(progressivo);
		allertaImpl.setAnno(anno);

		if (dataEmissione == Long.MIN_VALUE) {
			allertaImpl.setDataEmissione(null);
		}
		else {
			allertaImpl.setDataEmissione(new Date(dataEmissione));
		}

		if (dataInizio == Long.MIN_VALUE) {
			allertaImpl.setDataInizio(null);
		}
		else {
			allertaImpl.setDataInizio(new Date(dataInizio));
		}

		if (dataFine == Long.MIN_VALUE) {
			allertaImpl.setDataFine(null);
		}
		else {
			allertaImpl.setDataFine(new Date(dataFine));
		}

		if (descrizioneMeteo == null) {
			allertaImpl.setDescrizioneMeteo("");
		}
		else {
			allertaImpl.setDescrizioneMeteo(descrizioneMeteo);
		}

		allertaImpl.setTendenza(tendenza);

		if (note == null) {
			allertaImpl.setNote("");
		}
		else {
			allertaImpl.setNote(note);
		}

		if (riferimenti == null) {
			allertaImpl.setRiferimenti("");
		}
		else {
			allertaImpl.setRiferimenti(riferimenti);
		}

		allertaImpl.setUtenteFirmaArpaId(utenteFirmaArpaId);

		if (dataFirmaArpa == Long.MIN_VALUE) {
			allertaImpl.setDataFirmaArpa(null);
		}
		else {
			allertaImpl.setDataFirmaArpa(new Date(dataFirmaArpa));
		}

		allertaImpl.setUtenteFirmaProtId(utenteFirmaProtId);

		if (dataFirmaProt == Long.MIN_VALUE) {
			allertaImpl.setDataFirmaProt(null);
		}
		else {
			allertaImpl.setDataFirmaProt(new Date(dataFirmaProt));
		}

		allertaImpl.setParentId(parentId);

		if (sintesi == null) {
			allertaImpl.setSintesi("");
		}
		else {
			allertaImpl.setSintesi(sintesi);
		}

		if (link == null) {
			allertaImpl.setLink("");
		}
		else {
			allertaImpl.setLink(link);
		}

		if (titolo == null) {
			allertaImpl.setTitolo("");
		}
		else {
			allertaImpl.setTitolo(titolo);
		}

		allertaImpl.setTipoAllerta(tipoAllerta);

		if (hash == null) {
			allertaImpl.setHash("");
		}
		else {
			allertaImpl.setHash(hash);
		}

		if (sintesiBriefing == null) {
			allertaImpl.setSintesiBriefing("");
		}
		else {
			allertaImpl.setSintesiBriefing(sintesiBriefing);
		}

		allertaImpl.resetOriginalValues();

		return allertaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		allertaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		creatorName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		stato = objectInput.readInt();
		numero = objectInput.readUTF();

		progressivo = objectInput.readInt();

		anno = objectInput.readInt();
		dataEmissione = objectInput.readLong();
		dataInizio = objectInput.readLong();
		dataFine = objectInput.readLong();
		descrizioneMeteo = objectInput.readUTF();

		tendenza = objectInput.readInt();
		note = objectInput.readUTF();
		riferimenti = objectInput.readUTF();

		utenteFirmaArpaId = objectInput.readLong();
		dataFirmaArpa = objectInput.readLong();

		utenteFirmaProtId = objectInput.readLong();
		dataFirmaProt = objectInput.readLong();

		parentId = objectInput.readLong();
		sintesi = objectInput.readUTF();
		link = objectInput.readUTF();
		titolo = objectInput.readUTF();

		tipoAllerta = objectInput.readBoolean();
		hash = objectInput.readUTF();
		sintesiBriefing = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(allertaId);

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

		objectOutput.writeInt(stato);

		if (numero == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(numero);
		}

		objectOutput.writeInt(progressivo);

		objectOutput.writeInt(anno);
		objectOutput.writeLong(dataEmissione);
		objectOutput.writeLong(dataInizio);
		objectOutput.writeLong(dataFine);

		if (descrizioneMeteo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizioneMeteo);
		}

		objectOutput.writeInt(tendenza);

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

		objectOutput.writeLong(utenteFirmaArpaId);
		objectOutput.writeLong(dataFirmaArpa);

		objectOutput.writeLong(utenteFirmaProtId);
		objectOutput.writeLong(dataFirmaProt);

		objectOutput.writeLong(parentId);

		if (sintesi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sintesi);
		}

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		if (titolo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(titolo);
		}

		objectOutput.writeBoolean(tipoAllerta);

		if (hash == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hash);
		}

		if (sintesiBriefing == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sintesiBriefing);
		}
	}

	public String uuid;
	public long allertaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public String creatorName;
	public long createDate;
	public long modifiedDate;
	public int stato;
	public String numero;
	public int progressivo;
	public int anno;
	public long dataEmissione;
	public long dataInizio;
	public long dataFine;
	public String descrizioneMeteo;
	public int tendenza;
	public String note;
	public String riferimenti;
	public long utenteFirmaArpaId;
	public long dataFirmaArpa;
	public long utenteFirmaProtId;
	public long dataFirmaProt;
	public long parentId;
	public String sintesi;
	public String link;
	public String titolo;
	public boolean tipoAllerta;
	public String hash;
	public String sintesiBriefing;

}