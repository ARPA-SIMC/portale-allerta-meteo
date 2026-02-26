/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.bollettino.model.RegolaAllarme;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RegolaAllarme in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
public class RegolaAllarmeCacheModel
	implements CacheModel<RegolaAllarme>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RegolaAllarmeCacheModel)) {
			return false;
		}

		RegolaAllarmeCacheModel regolaAllarmeCacheModel =
			(RegolaAllarmeCacheModel)object;

		if (id == regolaAllarmeCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", espressione=");
		sb.append(espressione);
		sb.append(", descrizione=");
		sb.append(descrizione);
		sb.append(", colore=");
		sb.append(colore);
		sb.append(", attivo=");
		sb.append(attivo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RegolaAllarme toEntityModel() {
		RegolaAllarmeImpl regolaAllarmeImpl = new RegolaAllarmeImpl();

		if (uuid == null) {
			regolaAllarmeImpl.setUuid("");
		}
		else {
			regolaAllarmeImpl.setUuid(uuid);
		}

		regolaAllarmeImpl.setId(id);

		if (nome == null) {
			regolaAllarmeImpl.setNome("");
		}
		else {
			regolaAllarmeImpl.setNome(nome);
		}

		if (espressione == null) {
			regolaAllarmeImpl.setEspressione("");
		}
		else {
			regolaAllarmeImpl.setEspressione(espressione);
		}

		if (descrizione == null) {
			regolaAllarmeImpl.setDescrizione("");
		}
		else {
			regolaAllarmeImpl.setDescrizione(descrizione);
		}

		regolaAllarmeImpl.setColore(colore);
		regolaAllarmeImpl.setAttivo(attivo);

		regolaAllarmeImpl.resetOriginalValues();

		return regolaAllarmeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		nome = objectInput.readUTF();
		espressione = objectInput.readUTF();
		descrizione = objectInput.readUTF();

		colore = objectInput.readInt();

		attivo = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (espressione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(espressione);
		}

		if (descrizione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(descrizione);
		}

		objectOutput.writeInt(colore);

		objectOutput.writeBoolean(attivo);
	}

	public String uuid;
	public long id;
	public String nome;
	public String espressione;
	public String descrizione;
	public int colore;
	public boolean attivo;

}