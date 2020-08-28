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

package it.eng.previsioni.meteo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.previsioni.meteo.model.Bollettino;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Bollettino in entity cache.
 *
 * @author Brian Wing Shun Chan
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

		if (id == bollettinoCacheModel.id) {
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

		sb.append("{id=");
		sb.append(id);
		sb.append(", tipo=");
		sb.append(tipo);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append(", emissione=");
		sb.append(emissione);
		sb.append(", validita=");
		sb.append(validita);
		sb.append(", xml_content=");
		sb.append(xml_content);
		sb.append(", json=");
		sb.append(json);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Bollettino toEntityModel() {
		BollettinoImpl bollettinoImpl = new BollettinoImpl();

		bollettinoImpl.setId(id);

		if (tipo == null) {
			bollettinoImpl.setTipo("");
		}
		else {
			bollettinoImpl.setTipo(tipo);
		}

		bollettinoImpl.setTimestamp(timestamp);

		if (emissione == null) {
			bollettinoImpl.setEmissione("");
		}
		else {
			bollettinoImpl.setEmissione(emissione);
		}

		if (validita == null) {
			bollettinoImpl.setValidita("");
		}
		else {
			bollettinoImpl.setValidita(validita);
		}

		if (xml_content == null) {
			bollettinoImpl.setXml_content("");
		}
		else {
			bollettinoImpl.setXml_content(xml_content);
		}

		if (json == null) {
			bollettinoImpl.setJson("");
		}
		else {
			bollettinoImpl.setJson(json);
		}

		bollettinoImpl.resetOriginalValues();

		return bollettinoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		tipo = objectInput.readUTF();

		timestamp = objectInput.readLong();
		emissione = objectInput.readUTF();
		validita = objectInput.readUTF();
		xml_content = objectInput.readUTF();
		json = objectInput.readUTF();
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

		objectOutput.writeLong(timestamp);

		if (emissione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emissione);
		}

		if (validita == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(validita);
		}

		if (xml_content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(xml_content);
		}

		if (json == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(json);
		}
	}

	public long id;
	public String tipo;
	public long timestamp;
	public String emissione;
	public String validita;
	public String xml_content;
	public String json;

}