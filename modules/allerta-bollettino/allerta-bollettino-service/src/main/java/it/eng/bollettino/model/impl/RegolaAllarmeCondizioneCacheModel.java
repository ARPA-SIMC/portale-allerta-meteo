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

import it.eng.bollettino.model.RegolaAllarmeCondizione;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RegolaAllarmeCondizione in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class RegolaAllarmeCondizioneCacheModel
	implements CacheModel<RegolaAllarmeCondizione>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegolaAllarmeCondizioneCacheModel)) {
			return false;
		}

		RegolaAllarmeCondizioneCacheModel regolaAllarmeCondizioneCacheModel =
			(RegolaAllarmeCondizioneCacheModel)obj;

		if (id == regolaAllarmeCondizioneCacheModel.id) {
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
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", idRegola=");
		sb.append(idRegola);
		sb.append(", lettera=");
		sb.append(lettera);
		sb.append(", idVariabile=");
		sb.append(idVariabile);
		sb.append(", idStazione=");
		sb.append(idStazione);
		sb.append(", idStazioneVariabile=");
		sb.append(idStazioneVariabile);
		sb.append(", soglia=");
		sb.append(soglia);
		sb.append(", valoreSoglia=");
		sb.append(valoreSoglia);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RegolaAllarmeCondizione toEntityModel() {
		RegolaAllarmeCondizioneImpl regolaAllarmeCondizioneImpl =
			new RegolaAllarmeCondizioneImpl();

		if (uuid == null) {
			regolaAllarmeCondizioneImpl.setUuid("");
		}
		else {
			regolaAllarmeCondizioneImpl.setUuid(uuid);
		}

		regolaAllarmeCondizioneImpl.setId(id);
		regolaAllarmeCondizioneImpl.setIdRegola(idRegola);

		if (lettera == null) {
			regolaAllarmeCondizioneImpl.setLettera("");
		}
		else {
			regolaAllarmeCondizioneImpl.setLettera(lettera);
		}

		if (idVariabile == null) {
			regolaAllarmeCondizioneImpl.setIdVariabile("");
		}
		else {
			regolaAllarmeCondizioneImpl.setIdVariabile(idVariabile);
		}

		if (idStazione == null) {
			regolaAllarmeCondizioneImpl.setIdStazione("");
		}
		else {
			regolaAllarmeCondizioneImpl.setIdStazione(idStazione);
		}

		regolaAllarmeCondizioneImpl.setIdStazioneVariabile(idStazioneVariabile);
		regolaAllarmeCondizioneImpl.setSoglia(soglia);
		regolaAllarmeCondizioneImpl.setValoreSoglia(valoreSoglia);

		regolaAllarmeCondizioneImpl.resetOriginalValues();

		return regolaAllarmeCondizioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		idRegola = objectInput.readLong();
		lettera = objectInput.readUTF();
		idVariabile = objectInput.readUTF();
		idStazione = objectInput.readUTF();

		idStazioneVariabile = objectInput.readLong();

		soglia = objectInput.readInt();

		valoreSoglia = objectInput.readDouble();
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

		objectOutput.writeLong(idRegola);

		if (lettera == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lettera);
		}

		if (idVariabile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idVariabile);
		}

		if (idStazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idStazione);
		}

		objectOutput.writeLong(idStazioneVariabile);

		objectOutput.writeInt(soglia);

		objectOutput.writeDouble(valoreSoglia);
	}

	public String uuid;
	public long id;
	public long idRegola;
	public String lettera;
	public String idVariabile;
	public String idStazione;
	public long idStazioneVariabile;
	public int soglia;
	public double valoreSoglia;

}