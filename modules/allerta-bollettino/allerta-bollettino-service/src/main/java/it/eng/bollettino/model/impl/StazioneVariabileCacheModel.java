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

import it.eng.bollettino.model.StazioneVariabile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StazioneVariabile in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class StazioneVariabileCacheModel
	implements CacheModel<StazioneVariabile>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StazioneVariabileCacheModel)) {
			return false;
		}

		StazioneVariabileCacheModel stazioneVariabileCacheModel =
			(StazioneVariabileCacheModel)obj;

		if (id == stazioneVariabileCacheModel.id) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", idStazione=");
		sb.append(idStazione);
		sb.append(", idVariabile=");
		sb.append(idVariabile);
		sb.append(", dataUltimoValore=");
		sb.append(dataUltimoValore);
		sb.append(", soglia1=");
		sb.append(soglia1);
		sb.append(", soglia2=");
		sb.append(soglia2);
		sb.append(", soglia3=");
		sb.append(soglia3);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StazioneVariabile toEntityModel() {
		StazioneVariabileImpl stazioneVariabileImpl =
			new StazioneVariabileImpl();

		if (uuid == null) {
			stazioneVariabileImpl.setUuid("");
		}
		else {
			stazioneVariabileImpl.setUuid(uuid);
		}

		stazioneVariabileImpl.setId(id);

		if (idStazione == null) {
			stazioneVariabileImpl.setIdStazione("");
		}
		else {
			stazioneVariabileImpl.setIdStazione(idStazione);
		}

		if (idVariabile == null) {
			stazioneVariabileImpl.setIdVariabile("");
		}
		else {
			stazioneVariabileImpl.setIdVariabile(idVariabile);
		}

		if (dataUltimoValore == Long.MIN_VALUE) {
			stazioneVariabileImpl.setDataUltimoValore(null);
		}
		else {
			stazioneVariabileImpl.setDataUltimoValore(
				new Date(dataUltimoValore));
		}

		stazioneVariabileImpl.setSoglia1(soglia1);
		stazioneVariabileImpl.setSoglia2(soglia2);
		stazioneVariabileImpl.setSoglia3(soglia3);

		stazioneVariabileImpl.resetOriginalValues();

		return stazioneVariabileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		idStazione = objectInput.readUTF();
		idVariabile = objectInput.readUTF();
		dataUltimoValore = objectInput.readLong();

		soglia1 = objectInput.readDouble();

		soglia2 = objectInput.readDouble();

		soglia3 = objectInput.readDouble();
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

		if (idStazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idStazione);
		}

		if (idVariabile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idVariabile);
		}

		objectOutput.writeLong(dataUltimoValore);

		objectOutput.writeDouble(soglia1);

		objectOutput.writeDouble(soglia2);

		objectOutput.writeDouble(soglia3);
	}

	public String uuid;
	public long id;
	public String idStazione;
	public String idVariabile;
	public long dataUltimoValore;
	public double soglia1;
	public double soglia2;
	public double soglia3;

}