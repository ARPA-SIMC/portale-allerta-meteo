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

package it.eng.previsioni.meteo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.previsioni.meteo.service.http.BollettinoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class BollettinoSoap implements Serializable {

	public static BollettinoSoap toSoapModel(Bollettino model) {
		BollettinoSoap soapModel = new BollettinoSoap();

		soapModel.setId(model.getId());
		soapModel.setTipo(model.getTipo());
		soapModel.setTimestamp(model.getTimestamp());
		soapModel.setEmissione(model.getEmissione());
		soapModel.setValidita(model.getValidita());
		soapModel.setXml_content(model.getXml_content());
		soapModel.setJson(model.getJson());

		return soapModel;
	}

	public static BollettinoSoap[] toSoapModels(Bollettino[] models) {
		BollettinoSoap[] soapModels = new BollettinoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BollettinoSoap[][] toSoapModels(Bollettino[][] models) {
		BollettinoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BollettinoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BollettinoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BollettinoSoap[] toSoapModels(List<Bollettino> models) {
		List<BollettinoSoap> soapModels = new ArrayList<BollettinoSoap>(
			models.size());

		for (Bollettino model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BollettinoSoap[soapModels.size()]);
	}

	public BollettinoSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getTipo() {
		return _tipo;
	}

	public void setTipo(String tipo) {
		_tipo = tipo;
	}

	public long getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(long timestamp) {
		_timestamp = timestamp;
	}

	public String getEmissione() {
		return _emissione;
	}

	public void setEmissione(String emissione) {
		_emissione = emissione;
	}

	public String getValidita() {
		return _validita;
	}

	public void setValidita(String validita) {
		_validita = validita;
	}

	public String getXml_content() {
		return _xml_content;
	}

	public void setXml_content(String xml_content) {
		_xml_content = xml_content;
	}

	public String getJson() {
		return _json;
	}

	public void setJson(String json) {
		_json = json;
	}

	private long _id;
	private String _tipo;
	private long _timestamp;
	private String _emissione;
	private String _validita;
	private String _xml_content;
	private String _json;

}