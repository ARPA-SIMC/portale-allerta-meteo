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

package allerta.catasto.model.impl;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.model.Segnalazione;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Segnalazione in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SegnalazioneCacheModel
	implements CacheModel<Segnalazione>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SegnalazioneCacheModel)) {
			return false;
		}

		SegnalazioneCacheModel segnalazioneCacheModel =
			(SegnalazioneCacheModel)obj;

		if (id == segnalazioneCacheModel.id) {
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
		StringBundler sb = new StringBundler(51);

		sb.append("{id=");
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
		sb.append(", documentoAssociato=");
		sb.append(documentoAssociato);
		sb.append(", dataEvento=");
		sb.append(dataEvento);
		sb.append(", enteSegnalante=");
		sb.append(enteSegnalante);
		sb.append(", fonte=");
		sb.append(fonte);
		sb.append(", categoria=");
		sb.append(categoria);
		sb.append(", sottocategoria=");
		sb.append(sottocategoria);
		sb.append(", riferimento=");
		sb.append(riferimento);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", note=");
		sb.append(note);
		sb.append(", area=");
		sb.append(area);
		sb.append(", provincia=");
		sb.append(provincia);
		sb.append(", comune=");
		sb.append(comune);
		sb.append(", indirizzo=");
		sb.append(indirizzo);
		sb.append(", civico=");
		sb.append(civico);
		sb.append(", lat=");
		sb.append(lat);
		sb.append(", lon=");
		sb.append(lon);
		sb.append(", effetti=");
		sb.append(effetti);
		sb.append(", effettiSub=");
		sb.append(effettiSub);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Segnalazione toEntityModel() {
		SegnalazioneImpl segnalazioneImpl = new SegnalazioneImpl();

		segnalazioneImpl.setId(id);
		segnalazioneImpl.setGroupId(groupId);
		segnalazioneImpl.setCompanyId(companyId);
		segnalazioneImpl.setUserId(userId);

		if (userName == null) {
			segnalazioneImpl.setUserName("");
		}
		else {
			segnalazioneImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			segnalazioneImpl.setCreateDate(null);
		}
		else {
			segnalazioneImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			segnalazioneImpl.setModifiedDate(null);
		}
		else {
			segnalazioneImpl.setModifiedDate(new Date(modifiedDate));
		}

		segnalazioneImpl.setDocumentoAssociato(documentoAssociato);

		if (dataEvento == Long.MIN_VALUE) {
			segnalazioneImpl.setDataEvento(null);
		}
		else {
			segnalazioneImpl.setDataEvento(new Date(dataEvento));
		}

		if (enteSegnalante == null) {
			segnalazioneImpl.setEnteSegnalante("");
		}
		else {
			segnalazioneImpl.setEnteSegnalante(enteSegnalante);
		}

		segnalazioneImpl.setFonte(fonte);
		segnalazioneImpl.setCategoria(categoria);
		segnalazioneImpl.setSottocategoria(sottocategoria);

		if (riferimento == null) {
			segnalazioneImpl.setRiferimento("");
		}
		else {
			segnalazioneImpl.setRiferimento(riferimento);
		}

		if (descrizione == null) {
			segnalazioneImpl.setDescrizione("");
		}
		else {
			segnalazioneImpl.setDescrizione(descrizione);
		}

		if (note == null) {
			segnalazioneImpl.setNote("");
		}
		else {
			segnalazioneImpl.setNote(note);
		}

		if (area == null) {
			segnalazioneImpl.setArea("");
		}
		else {
			segnalazioneImpl.setArea(area);
		}

		if (provincia == null) {
			segnalazioneImpl.setProvincia("");
		}
		else {
			segnalazioneImpl.setProvincia(provincia);
		}

		if (comune == null) {
			segnalazioneImpl.setComune("");
		}
		else {
			segnalazioneImpl.setComune(comune);
		}

		if (indirizzo == null) {
			segnalazioneImpl.setIndirizzo("");
		}
		else {
			segnalazioneImpl.setIndirizzo(indirizzo);
		}

		if (civico == null) {
			segnalazioneImpl.setCivico("");
		}
		else {
			segnalazioneImpl.setCivico(civico);
		}

		segnalazioneImpl.setLat(lat);
		segnalazioneImpl.setLon(lon);
		segnalazioneImpl.setEffetti(effetti);
		segnalazioneImpl.setEffettiSub(effettiSub);

		segnalazioneImpl.resetOriginalValues();

		return segnalazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		documentoAssociato = objectInput.readLong();
		dataEvento = objectInput.readLong();
		enteSegnalante = objectInput.readUTF();

		fonte = objectInput.readLong();

		categoria = objectInput.readLong();

		sottocategoria = objectInput.readLong();
		riferimento = objectInput.readUTF();
		descrizione = objectInput.readUTF();
		note = objectInput.readUTF();
		area = objectInput.readUTF();
		provincia = objectInput.readUTF();
		comune = objectInput.readUTF();
		indirizzo = objectInput.readUTF();
		civico = objectInput.readUTF();

		lat = objectInput.readDouble();

		lon = objectInput.readDouble();

		effetti = objectInput.readLong();

		effettiSub = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
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

		objectOutput.writeLong(documentoAssociato);
		objectOutput.writeLong(dataEvento);

		if (enteSegnalante == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(enteSegnalante);
		}

		objectOutput.writeLong(fonte);

		objectOutput.writeLong(categoria);

		objectOutput.writeLong(sottocategoria);

		if (riferimento == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(riferimento);
		}

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		if (note == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(note);
		}

		if (area == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(area);
		}

		if (provincia == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(provincia);
		}

		if (comune == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comune);
		}

		if (indirizzo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(indirizzo);
		}

		if (civico == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(civico);
		}

		objectOutput.writeDouble(lat);

		objectOutput.writeDouble(lon);

		objectOutput.writeLong(effetti);

		objectOutput.writeLong(effettiSub);
	}

	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long documentoAssociato;
	public long dataEvento;
	public String enteSegnalante;
	public long fonte;
	public long categoria;
	public long sottocategoria;
	public String riferimento;
	public String descrizione;
	public String note;
	public String area;
	public String provincia;
	public String comune;
	public String indirizzo;
	public String civico;
	public double lat;
	public double lon;
	public long effetti;
	public long effettiSub;

}