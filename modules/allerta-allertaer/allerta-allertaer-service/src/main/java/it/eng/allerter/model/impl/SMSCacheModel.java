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

import it.eng.allerter.model.SMS;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SMS in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class SMSCacheModel implements CacheModel<SMS>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SMSCacheModel)) {
			return false;
		}

		SMSCacheModel smsCacheModel = (SMSCacheModel)obj;

		if (id == smsCacheModel.id) {
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

		sb.append("{id=");
		sb.append(id);
		sb.append(", tipo=");
		sb.append(tipo);
		sb.append(", sottotipo=");
		sb.append(sottotipo);
		sb.append(", param=");
		sb.append(param);
		sb.append(", testo=");
		sb.append(testo);
		sb.append(", destinatario=");
		sb.append(destinatario);
		sb.append(", numeroDa=");
		sb.append(numeroDa);
		sb.append(", numero=");
		sb.append(numero);
		sb.append(", nomeDestinatario=");
		sb.append(nomeDestinatario);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", dataInvio=");
		sb.append(dataInvio);
		sb.append(", dataAck=");
		sb.append(dataAck);
		sb.append(", dataRicevuta=");
		sb.append(dataRicevuta);
		sb.append(", tentativi=");
		sb.append(tentativi);
		sb.append(", prossimoInvio=");
		sb.append(prossimoInvio);
		sb.append(", codiceErrore=");
		sb.append(codiceErrore);
		sb.append(", descrizioneErrore=");
		sb.append(descrizioneErrore);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SMS toEntityModel() {
		SMSImpl smsImpl = new SMSImpl();

		smsImpl.setId(id);

		if (tipo == null) {
			smsImpl.setTipo("");
		}
		else {
			smsImpl.setTipo(tipo);
		}

		if (sottotipo == null) {
			smsImpl.setSottotipo("");
		}
		else {
			smsImpl.setSottotipo(sottotipo);
		}

		smsImpl.setParam(param);

		if (testo == null) {
			smsImpl.setTesto("");
		}
		else {
			smsImpl.setTesto(testo);
		}

		smsImpl.setDestinatario(destinatario);

		if (numeroDa == null) {
			smsImpl.setNumeroDa("");
		}
		else {
			smsImpl.setNumeroDa(numeroDa);
		}

		if (numero == null) {
			smsImpl.setNumero("");
		}
		else {
			smsImpl.setNumero(numero);
		}

		if (nomeDestinatario == null) {
			smsImpl.setNomeDestinatario("");
		}
		else {
			smsImpl.setNomeDestinatario(nomeDestinatario);
		}

		smsImpl.setStato(stato);

		if (dataInvio == Long.MIN_VALUE) {
			smsImpl.setDataInvio(null);
		}
		else {
			smsImpl.setDataInvio(new Date(dataInvio));
		}

		if (dataAck == Long.MIN_VALUE) {
			smsImpl.setDataAck(null);
		}
		else {
			smsImpl.setDataAck(new Date(dataAck));
		}

		if (dataRicevuta == Long.MIN_VALUE) {
			smsImpl.setDataRicevuta(null);
		}
		else {
			smsImpl.setDataRicevuta(new Date(dataRicevuta));
		}

		smsImpl.setTentativi(tentativi);

		if (prossimoInvio == Long.MIN_VALUE) {
			smsImpl.setProssimoInvio(null);
		}
		else {
			smsImpl.setProssimoInvio(new Date(prossimoInvio));
		}

		if (codiceErrore == null) {
			smsImpl.setCodiceErrore("");
		}
		else {
			smsImpl.setCodiceErrore(codiceErrore);
		}

		if (descrizioneErrore == null) {
			smsImpl.setDescrizioneErrore("");
		}
		else {
			smsImpl.setDescrizioneErrore(descrizioneErrore);
		}

		if (timestamp == null) {
			smsImpl.setTimestamp("");
		}
		else {
			smsImpl.setTimestamp(timestamp);
		}

		smsImpl.resetOriginalValues();

		return smsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		tipo = objectInput.readUTF();
		sottotipo = objectInput.readUTF();

		param = objectInput.readLong();
		testo = objectInput.readUTF();

		destinatario = objectInput.readLong();
		numeroDa = objectInput.readUTF();
		numero = objectInput.readUTF();
		nomeDestinatario = objectInput.readUTF();

		stato = objectInput.readLong();
		dataInvio = objectInput.readLong();
		dataAck = objectInput.readLong();
		dataRicevuta = objectInput.readLong();

		tentativi = objectInput.readLong();
		prossimoInvio = objectInput.readLong();
		codiceErrore = objectInput.readUTF();
		descrizioneErrore = objectInput.readUTF();
		timestamp = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (tipo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tipo);
		}

		if (sottotipo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sottotipo);
		}

		objectOutput.writeLong(param);

		if (testo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(testo);
		}

		objectOutput.writeLong(destinatario);

		if (numeroDa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(numeroDa);
		}

		if (numero == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(numero);
		}

		if (nomeDestinatario == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeDestinatario);
		}

		objectOutput.writeLong(stato);
		objectOutput.writeLong(dataInvio);
		objectOutput.writeLong(dataAck);
		objectOutput.writeLong(dataRicevuta);

		objectOutput.writeLong(tentativi);
		objectOutput.writeLong(prossimoInvio);

		if (codiceErrore == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codiceErrore);
		}

		if (descrizioneErrore == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizioneErrore);
		}

		if (timestamp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(timestamp);
		}
	}

	public long id;
	public String tipo;
	public String sottotipo;
	public long param;
	public String testo;
	public long destinatario;
	public String numeroDa;
	public String numero;
	public String nomeDestinatario;
	public long stato;
	public long dataInvio;
	public long dataAck;
	public long dataRicevuta;
	public long tentativi;
	public long prossimoInvio;
	public String codiceErrore;
	public String descrizioneErrore;
	public String timestamp;

}