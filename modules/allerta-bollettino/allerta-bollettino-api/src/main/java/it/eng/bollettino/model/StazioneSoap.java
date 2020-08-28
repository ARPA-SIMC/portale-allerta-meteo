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

package it.eng.bollettino.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.StazioneServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class StazioneSoap implements Serializable {

	public static StazioneSoap toSoapModel(Stazione model) {
		StazioneSoap soapModel = new StazioneSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setIdent(model.getIdent());
		soapModel.setName(model.getName());
		soapModel.setLon(model.getLon());
		soapModel.setLat(model.getLat());
		soapModel.setHeight(model.getHeight());
		soapModel.setIdBasin(model.getIdBasin());
		soapModel.setIdSubbasin(model.getIdSubbasin());
		soapModel.setIdCountry(model.getIdCountry());
		soapModel.setIdProvince(model.getIdProvince());
		soapModel.setIdRegion(model.getIdRegion());
		soapModel.setIdMunicipality(model.getIdMunicipality());
		soapModel.setIdMacroarea(model.getIdMacroarea());
		soapModel.setNameBasin(model.getNameBasin());
		soapModel.setNameSubbasin(model.getNameSubbasin());
		soapModel.setNameCountry(model.getNameCountry());
		soapModel.setNameProvince(model.getNameProvince());
		soapModel.setNameRegion(model.getNameRegion());
		soapModel.setNameMunicipality(model.getNameMunicipality());
		soapModel.setNameMacroarea(model.getNameMacroarea());
		soapModel.setNetwork(model.getNetwork());
		soapModel.setAttivo(model.isAttivo());
		soapModel.setIncluso(model.isIncluso());
		soapModel.setProgressivo(model.getProgressivo());

		return soapModel;
	}

	public static StazioneSoap[] toSoapModels(Stazione[] models) {
		StazioneSoap[] soapModels = new StazioneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StazioneSoap[][] toSoapModels(Stazione[][] models) {
		StazioneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StazioneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StazioneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StazioneSoap[] toSoapModels(List<Stazione> models) {
		List<StazioneSoap> soapModels = new ArrayList<StazioneSoap>(
			models.size());

		for (Stazione model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StazioneSoap[soapModels.size()]);
	}

	public StazioneSoap() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getIdent() {
		return _ident;
	}

	public void setIdent(String ident) {
		_ident = ident;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getLon() {
		return _lon;
	}

	public void setLon(long lon) {
		_lon = lon;
	}

	public long getLat() {
		return _lat;
	}

	public void setLat(long lat) {
		_lat = lat;
	}

	public double getHeight() {
		return _height;
	}

	public void setHeight(double height) {
		_height = height;
	}

	public String getIdBasin() {
		return _idBasin;
	}

	public void setIdBasin(String idBasin) {
		_idBasin = idBasin;
	}

	public String getIdSubbasin() {
		return _idSubbasin;
	}

	public void setIdSubbasin(String idSubbasin) {
		_idSubbasin = idSubbasin;
	}

	public String getIdCountry() {
		return _idCountry;
	}

	public void setIdCountry(String idCountry) {
		_idCountry = idCountry;
	}

	public String getIdProvince() {
		return _idProvince;
	}

	public void setIdProvince(String idProvince) {
		_idProvince = idProvince;
	}

	public String getIdRegion() {
		return _idRegion;
	}

	public void setIdRegion(String idRegion) {
		_idRegion = idRegion;
	}

	public String getIdMunicipality() {
		return _idMunicipality;
	}

	public void setIdMunicipality(String idMunicipality) {
		_idMunicipality = idMunicipality;
	}

	public String getIdMacroarea() {
		return _idMacroarea;
	}

	public void setIdMacroarea(String idMacroarea) {
		_idMacroarea = idMacroarea;
	}

	public String getNameBasin() {
		return _nameBasin;
	}

	public void setNameBasin(String nameBasin) {
		_nameBasin = nameBasin;
	}

	public String getNameSubbasin() {
		return _nameSubbasin;
	}

	public void setNameSubbasin(String nameSubbasin) {
		_nameSubbasin = nameSubbasin;
	}

	public String getNameCountry() {
		return _nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		_nameCountry = nameCountry;
	}

	public String getNameProvince() {
		return _nameProvince;
	}

	public void setNameProvince(String nameProvince) {
		_nameProvince = nameProvince;
	}

	public String getNameRegion() {
		return _nameRegion;
	}

	public void setNameRegion(String nameRegion) {
		_nameRegion = nameRegion;
	}

	public String getNameMunicipality() {
		return _nameMunicipality;
	}

	public void setNameMunicipality(String nameMunicipality) {
		_nameMunicipality = nameMunicipality;
	}

	public String getNameMacroarea() {
		return _nameMacroarea;
	}

	public void setNameMacroarea(String nameMacroarea) {
		_nameMacroarea = nameMacroarea;
	}

	public String getNetwork() {
		return _network;
	}

	public void setNetwork(String network) {
		_network = network;
	}

	public boolean getAttivo() {
		return _attivo;
	}

	public boolean isAttivo() {
		return _attivo;
	}

	public void setAttivo(boolean attivo) {
		_attivo = attivo;
	}

	public boolean getIncluso() {
		return _incluso;
	}

	public boolean isIncluso() {
		return _incluso;
	}

	public void setIncluso(boolean incluso) {
		_incluso = incluso;
	}

	public int getProgressivo() {
		return _progressivo;
	}

	public void setProgressivo(int progressivo) {
		_progressivo = progressivo;
	}

	private String _uuid;
	private String _id;
	private String _ident;
	private String _name;
	private long _lon;
	private long _lat;
	private double _height;
	private String _idBasin;
	private String _idSubbasin;
	private String _idCountry;
	private String _idProvince;
	private String _idRegion;
	private String _idMunicipality;
	private String _idMacroarea;
	private String _nameBasin;
	private String _nameSubbasin;
	private String _nameCountry;
	private String _nameProvince;
	private String _nameRegion;
	private String _nameMunicipality;
	private String _nameMacroarea;
	private String _network;
	private boolean _attivo;
	private boolean _incluso;
	private int _progressivo;

}