/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerter.model.Email;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Email in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class EmailCacheModel implements CacheModel<Email>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmailCacheModel)) {
			return false;
		}

		EmailCacheModel emailCacheModel = (EmailCacheModel)object;

		if (id == emailCacheModel.id) {
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
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tipo=");
		sb.append(tipo);
		sb.append(", sottotipo=");
		sb.append(sottotipo);
		sb.append(", param=");
		sb.append(param);
		sb.append(", destinatario=");
		sb.append(destinatario);
		sb.append(", indirizzo=");
		sb.append(indirizzo);
		sb.append(", nomeDestinatario=");
		sb.append(nomeDestinatario);
		sb.append(", stato=");
		sb.append(stato);
		sb.append(", dataInvio=");
		sb.append(dataInvio);
		sb.append(", testo=");
		sb.append(testo);
		sb.append(", oggetto=");
		sb.append(oggetto);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Email toEntityModel() {
		EmailImpl emailImpl = new EmailImpl();

		emailImpl.setId(id);

		if (tipo == null) {
			emailImpl.setTipo("");
		}
		else {
			emailImpl.setTipo(tipo);
		}

		if (sottotipo == null) {
			emailImpl.setSottotipo("");
		}
		else {
			emailImpl.setSottotipo(sottotipo);
		}

		emailImpl.setParam(param);
		emailImpl.setDestinatario(destinatario);

		if (indirizzo == null) {
			emailImpl.setIndirizzo("");
		}
		else {
			emailImpl.setIndirizzo(indirizzo);
		}

		if (nomeDestinatario == null) {
			emailImpl.setNomeDestinatario("");
		}
		else {
			emailImpl.setNomeDestinatario(nomeDestinatario);
		}

		emailImpl.setStato(stato);

		if (dataInvio == Long.MIN_VALUE) {
			emailImpl.setDataInvio(null);
		}
		else {
			emailImpl.setDataInvio(new Date(dataInvio));
		}

		if (testo == null) {
			emailImpl.setTesto("");
		}
		else {
			emailImpl.setTesto(testo);
		}

		if (oggetto == null) {
			emailImpl.setOggetto("");
		}
		else {
			emailImpl.setOggetto(oggetto);
		}

		emailImpl.resetOriginalValues();

		return emailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		tipo = objectInput.readUTF();
		sottotipo = objectInput.readUTF();

		param = objectInput.readLong();

		destinatario = objectInput.readLong();
		indirizzo = objectInput.readUTF();
		nomeDestinatario = objectInput.readUTF();

		stato = objectInput.readLong();
		dataInvio = objectInput.readLong();
		testo = objectInput.readUTF();
		oggetto = objectInput.readUTF();
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

		objectOutput.writeLong(destinatario);

		if (indirizzo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(indirizzo);
		}

		if (nomeDestinatario == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeDestinatario);
		}

		objectOutput.writeLong(stato);
		objectOutput.writeLong(dataInvio);

		if (testo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(testo);
		}

		if (oggetto == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(oggetto);
		}
	}

	public long id;
	public String tipo;
	public String sottotipo;
	public long param;
	public long destinatario;
	public String indirizzo;
	public String nomeDestinatario;
	public long stato;
	public long dataInvio;
	public String testo;
	public String oggetto;

}