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

package it.eng.bollettino.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.bollettino.model.Bollettino;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Bollettino in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoCacheModel
	implements CacheModel<Bollettino>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BollettinoCacheModel)) {
			return false;
		}

		BollettinoCacheModel bollettinoCacheModel = (BollettinoCacheModel)obj;

		if (bollettinoId == bollettinoCacheModel.bollettinoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bollettinoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bollettinoId=");
		sb.append(bollettinoId);
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
		sb.append(", noteMeteo=");
		sb.append(noteMeteo);
		sb.append(", stringaMeteo=");
		sb.append(stringaMeteo);
		sb.append(", link=");
		sb.append(link);
		sb.append(", ultimo=");
		sb.append(ultimo);
		sb.append(", hash=");
		sb.append(hash);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Bollettino toEntityModel() {
		BollettinoImpl bollettinoImpl = new BollettinoImpl();

		if (uuid == null) {
			bollettinoImpl.setUuid("");
		}
		else {
			bollettinoImpl.setUuid(uuid);
		}

		bollettinoImpl.setBollettinoId(bollettinoId);
		bollettinoImpl.setGroupId(groupId);
		bollettinoImpl.setCompanyId(companyId);
		bollettinoImpl.setUserId(userId);

		if (userName == null) {
			bollettinoImpl.setUserName("");
		}
		else {
			bollettinoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bollettinoImpl.setCreateDate(null);
		}
		else {
			bollettinoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bollettinoImpl.setModifiedDate(null);
		}
		else {
			bollettinoImpl.setModifiedDate(new Date(modifiedDate));
		}

		bollettinoImpl.setStato(stato);
		bollettinoImpl.setIdApprovatore(idApprovatore);

		if (dataApprovazione == Long.MIN_VALUE) {
			bollettinoImpl.setDataApprovazione(null);
		}
		else {
			bollettinoImpl.setDataApprovazione(new Date(dataApprovazione));
		}

		if (numero == null) {
			bollettinoImpl.setNumero("");
		}
		else {
			bollettinoImpl.setNumero(numero);
		}

		bollettinoImpl.setProgressivo(progressivo);
		bollettinoImpl.setAnno(anno);

		if (dataEmissione == Long.MIN_VALUE) {
			bollettinoImpl.setDataEmissione(null);
		}
		else {
			bollettinoImpl.setDataEmissione(new Date(dataEmissione));
		}

		if (dataInizio == Long.MIN_VALUE) {
			bollettinoImpl.setDataInizio(null);
		}
		else {
			bollettinoImpl.setDataInizio(new Date(dataInizio));
		}

		if (dataFine == Long.MIN_VALUE) {
			bollettinoImpl.setDataFine(null);
		}
		else {
			bollettinoImpl.setDataFine(new Date(dataFine));
		}

		if (noteMeteo == null) {
			bollettinoImpl.setNoteMeteo("");
		}
		else {
			bollettinoImpl.setNoteMeteo(noteMeteo);
		}

		if (stringaMeteo == null) {
			bollettinoImpl.setStringaMeteo("");
		}
		else {
			bollettinoImpl.setStringaMeteo(stringaMeteo);
		}

		if (link == null) {
			bollettinoImpl.setLink("");
		}
		else {
			bollettinoImpl.setLink(link);
		}

		bollettinoImpl.setUltimo(ultimo);

		if (hash == null) {
			bollettinoImpl.setHash("");
		}
		else {
			bollettinoImpl.setHash(hash);
		}

		bollettinoImpl.resetOriginalValues();

		return bollettinoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bollettinoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		stato = objectInput.readInt();

		idApprovatore = objectInput.readLong();
		dataApprovazione = objectInput.readLong();
		numero = objectInput.readUTF();

		progressivo = objectInput.readInt();

		anno = objectInput.readInt();
		dataEmissione = objectInput.readLong();
		dataInizio = objectInput.readLong();
		dataFine = objectInput.readLong();
		noteMeteo = objectInput.readUTF();
		stringaMeteo = objectInput.readUTF();
		link = objectInput.readUTF();

		ultimo = objectInput.readBoolean();
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

		objectOutput.writeLong(bollettinoId);

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

		if (noteMeteo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noteMeteo);
		}

		if (stringaMeteo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stringaMeteo);
		}

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		objectOutput.writeBoolean(ultimo);

		if (hash == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hash);
		}
	}

	public String uuid;
	public long bollettinoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int stato;
	public long idApprovatore;
	public long dataApprovazione;
	public String numero;
	public int progressivo;
	public int anno;
	public long dataEmissione;
	public long dataInizio;
	public long dataFine;
	public String noteMeteo;
	public String stringaMeteo;
	public String link;
	public boolean ultimo;
	public String hash;

}