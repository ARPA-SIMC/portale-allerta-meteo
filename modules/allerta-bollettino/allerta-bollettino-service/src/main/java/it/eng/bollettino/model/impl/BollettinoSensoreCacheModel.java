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

import it.eng.bollettino.model.BollettinoSensore;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BollettinoSensore in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoSensoreCacheModel
	implements CacheModel<BollettinoSensore>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BollettinoSensoreCacheModel)) {
			return false;
		}

		BollettinoSensoreCacheModel bollettinoSensoreCacheModel =
			(BollettinoSensoreCacheModel)obj;

		if (id == bollettinoSensoreCacheModel.id) {
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
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", idBollettino=");
		sb.append(idBollettino);
		sb.append(", idStazione=");
		sb.append(idStazione);
		sb.append(", idBollettinoBacino=");
		sb.append(idBollettinoBacino);
		sb.append(", progressivo=");
		sb.append(progressivo);
		sb.append(", nomeStazione=");
		sb.append(nomeStazione);
		sb.append(", oreOsservazione=");
		sb.append(oreOsservazione);
		sb.append(", osservazione=");
		sb.append(osservazione);
		sb.append(", tendenza=");
		sb.append(tendenza);
		sb.append(", colmoPrevisto=");
		sb.append(colmoPrevisto);
		sb.append(", oraPrevista=");
		sb.append(oraPrevista);
		sb.append(", soglia1=");
		sb.append(soglia1);
		sb.append(", soglia2=");
		sb.append(soglia2);
		sb.append(", soglia3=");
		sb.append(soglia3);
		sb.append(", giornoPrevisto=");
		sb.append(giornoPrevisto);
		sb.append(", osservato=");
		sb.append(osservato);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BollettinoSensore toEntityModel() {
		BollettinoSensoreImpl bollettinoSensoreImpl =
			new BollettinoSensoreImpl();

		if (uuid == null) {
			bollettinoSensoreImpl.setUuid("");
		}
		else {
			bollettinoSensoreImpl.setUuid(uuid);
		}

		bollettinoSensoreImpl.setId(id);
		bollettinoSensoreImpl.setIdBollettino(idBollettino);
		bollettinoSensoreImpl.setIdStazione(idStazione);
		bollettinoSensoreImpl.setIdBollettinoBacino(idBollettinoBacino);
		bollettinoSensoreImpl.setProgressivo(progressivo);

		if (nomeStazione == null) {
			bollettinoSensoreImpl.setNomeStazione("");
		}
		else {
			bollettinoSensoreImpl.setNomeStazione(nomeStazione);
		}

		if (oreOsservazione == null) {
			bollettinoSensoreImpl.setOreOsservazione("");
		}
		else {
			bollettinoSensoreImpl.setOreOsservazione(oreOsservazione);
		}

		bollettinoSensoreImpl.setOsservazione(osservazione);
		bollettinoSensoreImpl.setTendenza(tendenza);

		if (colmoPrevisto == null) {
			bollettinoSensoreImpl.setColmoPrevisto("");
		}
		else {
			bollettinoSensoreImpl.setColmoPrevisto(colmoPrevisto);
		}

		if (oraPrevista == null) {
			bollettinoSensoreImpl.setOraPrevista("");
		}
		else {
			bollettinoSensoreImpl.setOraPrevista(oraPrevista);
		}

		bollettinoSensoreImpl.setSoglia1(soglia1);
		bollettinoSensoreImpl.setSoglia2(soglia2);
		bollettinoSensoreImpl.setSoglia3(soglia3);

		if (giornoPrevisto == null) {
			bollettinoSensoreImpl.setGiornoPrevisto("");
		}
		else {
			bollettinoSensoreImpl.setGiornoPrevisto(giornoPrevisto);
		}

		bollettinoSensoreImpl.setOsservato(osservato);

		bollettinoSensoreImpl.resetOriginalValues();

		return bollettinoSensoreImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		idBollettino = objectInput.readLong();

		idStazione = objectInput.readLong();

		idBollettinoBacino = objectInput.readLong();

		progressivo = objectInput.readInt();
		nomeStazione = objectInput.readUTF();
		oreOsservazione = objectInput.readUTF();

		osservazione = objectInput.readDouble();

		tendenza = objectInput.readInt();
		colmoPrevisto = objectInput.readUTF();
		oraPrevista = objectInput.readUTF();

		soglia1 = objectInput.readDouble();

		soglia2 = objectInput.readDouble();

		soglia3 = objectInput.readDouble();
		giornoPrevisto = objectInput.readUTF();

		osservato = objectInput.readBoolean();
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

		objectOutput.writeLong(idBollettino);

		objectOutput.writeLong(idStazione);

		objectOutput.writeLong(idBollettinoBacino);

		objectOutput.writeInt(progressivo);

		if (nomeStazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nomeStazione);
		}

		if (oreOsservazione == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(oreOsservazione);
		}

		objectOutput.writeDouble(osservazione);

		objectOutput.writeInt(tendenza);

		if (colmoPrevisto == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(colmoPrevisto);
		}

		if (oraPrevista == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(oraPrevista);
		}

		objectOutput.writeDouble(soglia1);

		objectOutput.writeDouble(soglia2);

		objectOutput.writeDouble(soglia3);

		if (giornoPrevisto == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(giornoPrevisto);
		}

		objectOutput.writeBoolean(osservato);
	}

	public String uuid;
	public long id;
	public long idBollettino;
	public long idStazione;
	public long idBollettinoBacino;
	public int progressivo;
	public String nomeStazione;
	public String oreOsservazione;
	public double osservazione;
	public int tendenza;
	public String colmoPrevisto;
	public String oraPrevista;
	public double soglia1;
	public double soglia2;
	public double soglia3;
	public String giornoPrevisto;
	public boolean osservato;

}