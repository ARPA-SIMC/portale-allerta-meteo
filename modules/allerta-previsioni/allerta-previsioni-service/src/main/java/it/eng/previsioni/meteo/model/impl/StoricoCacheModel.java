/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import it.eng.previsioni.meteo.model.Storico;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Storico in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StoricoCacheModel implements CacheModel<Storico>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StoricoCacheModel)) {
			return false;
		}

		StoricoCacheModel storicoCacheModel = (StoricoCacheModel)object;

		if (id == storicoCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", idZona=");
		sb.append(idZona);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", sigla=");
		sb.append(sigla);
		sb.append(", tipo=");
		sb.append(tipo);
		sb.append(", xml=");
		sb.append(xml);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Storico toEntityModel() {
		StoricoImpl storicoImpl = new StoricoImpl();

		storicoImpl.setId(id);
		storicoImpl.setIdZona(idZona);

		if (nome == null) {
			storicoImpl.setNome("");
		}
		else {
			storicoImpl.setNome(nome);
		}

		if (sigla == null) {
			storicoImpl.setSigla("");
		}
		else {
			storicoImpl.setSigla(sigla);
		}

		if (tipo == null) {
			storicoImpl.setTipo("");
		}
		else {
			storicoImpl.setTipo(tipo);
		}

		if (xml == null) {
			storicoImpl.setXml("");
		}
		else {
			storicoImpl.setXml(xml);
		}

		storicoImpl.resetOriginalValues();

		return storicoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		idZona = objectInput.readInt();
		nome = objectInput.readUTF();
		sigla = objectInput.readUTF();
		tipo = objectInput.readUTF();
		xml = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeInt(idZona);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (sigla == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sigla);
		}

		if (tipo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tipo);
		}

		if (xml == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(xml);
		}
	}

	public long id;
	public int idZona;
	public String nome;
	public String sigla;
	public String tipo;
	public String xml;

}