/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerta.messages.services.model.Nodo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Nodo in entity cache.
 *
 * @author Giorgianni_F
 * @generated
 */
public class NodoCacheModel implements CacheModel<Nodo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NodoCacheModel)) {
			return false;
		}

		NodoCacheModel nodoCacheModel = (NodoCacheModel)object;

		if (Id == nodoCacheModel.Id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, Id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{Id=");
		sb.append(Id);
		sb.append(", ip=");
		sb.append(ip);
		sb.append(", porta=");
		sb.append(porta);
		sb.append(", nodoConnesso=");
		sb.append(nodoConnesso);
		sb.append(", dataConnessione=");
		sb.append(dataConnessione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Nodo toEntityModel() {
		NodoImpl nodoImpl = new NodoImpl();

		nodoImpl.setId(Id);

		if (ip == null) {
			nodoImpl.setIp("");
		}
		else {
			nodoImpl.setIp(ip);
		}

		nodoImpl.setPorta(porta);

		if (nodoConnesso == null) {
			nodoImpl.setNodoConnesso("");
		}
		else {
			nodoImpl.setNodoConnesso(nodoConnesso);
		}

		if (dataConnessione == Long.MIN_VALUE) {
			nodoImpl.setDataConnessione(null);
		}
		else {
			nodoImpl.setDataConnessione(new Date(dataConnessione));
		}

		nodoImpl.resetOriginalValues();

		return nodoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Id = objectInput.readLong();
		ip = objectInput.readUTF();

		porta = objectInput.readInt();
		nodoConnesso = objectInput.readUTF();
		dataConnessione = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(Id);

		if (ip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ip);
		}

		objectOutput.writeInt(porta);

		if (nodoConnesso == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nodoConnesso);
		}

		objectOutput.writeLong(dataConnessione);
	}

	public long Id;
	public String ip;
	public int porta;
	public String nodoConnesso;
	public long dataConnessione;

}