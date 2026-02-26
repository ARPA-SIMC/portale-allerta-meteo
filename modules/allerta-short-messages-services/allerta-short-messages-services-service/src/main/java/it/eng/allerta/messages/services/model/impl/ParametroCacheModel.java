/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.allerta.messages.services.model.Parametro;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Parametro in entity cache.
 *
 * @author Giorgianni_F
 * @generated
 */
public class ParametroCacheModel
	implements CacheModel<Parametro>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ParametroCacheModel)) {
			return false;
		}

		ParametroCacheModel parametroCacheModel = (ParametroCacheModel)object;

		if (Id == parametroCacheModel.Id) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{Id=");
		sb.append(Id);
		sb.append(", ip=");
		sb.append(ip);
		sb.append(", porta=");
		sb.append(porta);
		sb.append(", username=");
		sb.append(username);
		sb.append(", password=");
		sb.append(password);
		sb.append(", mittente=");
		sb.append(mittente);
		sb.append(", nodo=");
		sb.append(nodo);
		sb.append(", dataConnessione=");
		sb.append(dataConnessione);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Parametro toEntityModel() {
		ParametroImpl parametroImpl = new ParametroImpl();

		parametroImpl.setId(Id);

		if (ip == null) {
			parametroImpl.setIp("");
		}
		else {
			parametroImpl.setIp(ip);
		}

		parametroImpl.setPorta(porta);

		if (username == null) {
			parametroImpl.setUsername("");
		}
		else {
			parametroImpl.setUsername(username);
		}

		if (password == null) {
			parametroImpl.setPassword("");
		}
		else {
			parametroImpl.setPassword(password);
		}

		if (mittente == null) {
			parametroImpl.setMittente("");
		}
		else {
			parametroImpl.setMittente(mittente);
		}

		if (nodo == null) {
			parametroImpl.setNodo("");
		}
		else {
			parametroImpl.setNodo(nodo);
		}

		if (dataConnessione == Long.MIN_VALUE) {
			parametroImpl.setDataConnessione(null);
		}
		else {
			parametroImpl.setDataConnessione(new Date(dataConnessione));
		}

		parametroImpl.resetOriginalValues();

		return parametroImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		Id = objectInput.readLong();
		ip = objectInput.readUTF();

		porta = objectInput.readInt();
		username = objectInput.readUTF();
		password = objectInput.readUTF();
		mittente = objectInput.readUTF();
		nodo = objectInput.readUTF();
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

		if (username == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(username);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (mittente == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mittente);
		}

		if (nodo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nodo);
		}

		objectOutput.writeLong(dataConnessione);
	}

	public long Id;
	public String ip;
	public int porta;
	public String username;
	public String password;
	public String mittente;
	public String nodo;
	public long dataConnessione;

}