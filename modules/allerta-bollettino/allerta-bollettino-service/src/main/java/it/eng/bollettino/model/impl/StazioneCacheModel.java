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

import it.eng.bollettino.model.Stazione;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Stazione in entity cache.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class StazioneCacheModel
	implements CacheModel<Stazione>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StazioneCacheModel)) {
			return false;
		}

		StazioneCacheModel stazioneCacheModel = (StazioneCacheModel)obj;

		if (id.equals(stazioneCacheModel.id)) {
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
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", ident=");
		sb.append(ident);
		sb.append(", name=");
		sb.append(name);
		sb.append(", lon=");
		sb.append(lon);
		sb.append(", lat=");
		sb.append(lat);
		sb.append(", height=");
		sb.append(height);
		sb.append(", idBasin=");
		sb.append(idBasin);
		sb.append(", idSubbasin=");
		sb.append(idSubbasin);
		sb.append(", idCountry=");
		sb.append(idCountry);
		sb.append(", idProvince=");
		sb.append(idProvince);
		sb.append(", idRegion=");
		sb.append(idRegion);
		sb.append(", idMunicipality=");
		sb.append(idMunicipality);
		sb.append(", idMacroarea=");
		sb.append(idMacroarea);
		sb.append(", nameBasin=");
		sb.append(nameBasin);
		sb.append(", nameSubbasin=");
		sb.append(nameSubbasin);
		sb.append(", nameCountry=");
		sb.append(nameCountry);
		sb.append(", nameProvince=");
		sb.append(nameProvince);
		sb.append(", nameRegion=");
		sb.append(nameRegion);
		sb.append(", nameMunicipality=");
		sb.append(nameMunicipality);
		sb.append(", nameMacroarea=");
		sb.append(nameMacroarea);
		sb.append(", network=");
		sb.append(network);
		sb.append(", attivo=");
		sb.append(attivo);
		sb.append(", incluso=");
		sb.append(incluso);
		sb.append(", progressivo=");
		sb.append(progressivo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Stazione toEntityModel() {
		StazioneImpl stazioneImpl = new StazioneImpl();

		if (uuid == null) {
			stazioneImpl.setUuid("");
		}
		else {
			stazioneImpl.setUuid(uuid);
		}

		if (id == null) {
			stazioneImpl.setId("");
		}
		else {
			stazioneImpl.setId(id);
		}

		if (ident == null) {
			stazioneImpl.setIdent("");
		}
		else {
			stazioneImpl.setIdent(ident);
		}

		if (name == null) {
			stazioneImpl.setName("");
		}
		else {
			stazioneImpl.setName(name);
		}

		stazioneImpl.setLon(lon);
		stazioneImpl.setLat(lat);
		stazioneImpl.setHeight(height);

		if (idBasin == null) {
			stazioneImpl.setIdBasin("");
		}
		else {
			stazioneImpl.setIdBasin(idBasin);
		}

		if (idSubbasin == null) {
			stazioneImpl.setIdSubbasin("");
		}
		else {
			stazioneImpl.setIdSubbasin(idSubbasin);
		}

		if (idCountry == null) {
			stazioneImpl.setIdCountry("");
		}
		else {
			stazioneImpl.setIdCountry(idCountry);
		}

		if (idProvince == null) {
			stazioneImpl.setIdProvince("");
		}
		else {
			stazioneImpl.setIdProvince(idProvince);
		}

		if (idRegion == null) {
			stazioneImpl.setIdRegion("");
		}
		else {
			stazioneImpl.setIdRegion(idRegion);
		}

		if (idMunicipality == null) {
			stazioneImpl.setIdMunicipality("");
		}
		else {
			stazioneImpl.setIdMunicipality(idMunicipality);
		}

		if (idMacroarea == null) {
			stazioneImpl.setIdMacroarea("");
		}
		else {
			stazioneImpl.setIdMacroarea(idMacroarea);
		}

		if (nameBasin == null) {
			stazioneImpl.setNameBasin("");
		}
		else {
			stazioneImpl.setNameBasin(nameBasin);
		}

		if (nameSubbasin == null) {
			stazioneImpl.setNameSubbasin("");
		}
		else {
			stazioneImpl.setNameSubbasin(nameSubbasin);
		}

		if (nameCountry == null) {
			stazioneImpl.setNameCountry("");
		}
		else {
			stazioneImpl.setNameCountry(nameCountry);
		}

		if (nameProvince == null) {
			stazioneImpl.setNameProvince("");
		}
		else {
			stazioneImpl.setNameProvince(nameProvince);
		}

		if (nameRegion == null) {
			stazioneImpl.setNameRegion("");
		}
		else {
			stazioneImpl.setNameRegion(nameRegion);
		}

		if (nameMunicipality == null) {
			stazioneImpl.setNameMunicipality("");
		}
		else {
			stazioneImpl.setNameMunicipality(nameMunicipality);
		}

		if (nameMacroarea == null) {
			stazioneImpl.setNameMacroarea("");
		}
		else {
			stazioneImpl.setNameMacroarea(nameMacroarea);
		}

		if (network == null) {
			stazioneImpl.setNetwork("");
		}
		else {
			stazioneImpl.setNetwork(network);
		}

		stazioneImpl.setAttivo(attivo);
		stazioneImpl.setIncluso(incluso);
		stazioneImpl.setProgressivo(progressivo);

		stazioneImpl.resetOriginalValues();

		return stazioneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		id = objectInput.readUTF();
		ident = objectInput.readUTF();
		name = objectInput.readUTF();

		lon = objectInput.readLong();

		lat = objectInput.readLong();

		height = objectInput.readDouble();
		idBasin = objectInput.readUTF();
		idSubbasin = objectInput.readUTF();
		idCountry = objectInput.readUTF();
		idProvince = objectInput.readUTF();
		idRegion = objectInput.readUTF();
		idMunicipality = objectInput.readUTF();
		idMacroarea = objectInput.readUTF();
		nameBasin = objectInput.readUTF();
		nameSubbasin = objectInput.readUTF();
		nameCountry = objectInput.readUTF();
		nameProvince = objectInput.readUTF();
		nameRegion = objectInput.readUTF();
		nameMunicipality = objectInput.readUTF();
		nameMacroarea = objectInput.readUTF();
		network = objectInput.readUTF();

		attivo = objectInput.readBoolean();

		incluso = objectInput.readBoolean();

		progressivo = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(id);
		}

		if (ident == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ident);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(lon);

		objectOutput.writeLong(lat);

		objectOutput.writeDouble(height);

		if (idBasin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idBasin);
		}

		if (idSubbasin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idSubbasin);
		}

		if (idCountry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idCountry);
		}

		if (idProvince == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idProvince);
		}

		if (idRegion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idRegion);
		}

		if (idMunicipality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idMunicipality);
		}

		if (idMacroarea == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idMacroarea);
		}

		if (nameBasin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameBasin);
		}

		if (nameSubbasin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameSubbasin);
		}

		if (nameCountry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameCountry);
		}

		if (nameProvince == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameProvince);
		}

		if (nameRegion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameRegion);
		}

		if (nameMunicipality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameMunicipality);
		}

		if (nameMacroarea == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nameMacroarea);
		}

		if (network == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(network);
		}

		objectOutput.writeBoolean(attivo);

		objectOutput.writeBoolean(incluso);

		objectOutput.writeInt(progressivo);
	}

	public String uuid;
	public String id;
	public String ident;
	public String name;
	public long lon;
	public long lat;
	public double height;
	public String idBasin;
	public String idSubbasin;
	public String idCountry;
	public String idProvince;
	public String idRegion;
	public String idMunicipality;
	public String idMacroarea;
	public String nameBasin;
	public String nameSubbasin;
	public String nameCountry;
	public String nameProvince;
	public String nameRegion;
	public String nameMunicipality;
	public String nameMacroarea;
	public String network;
	public boolean attivo;
	public boolean incluso;
	public int progressivo;

}