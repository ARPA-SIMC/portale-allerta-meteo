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
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class StoricoSoap implements Serializable {

	public static StoricoSoap toSoapModel(Storico model) {
		StoricoSoap soapModel = new StoricoSoap();

		soapModel.setId(model.getId());
		soapModel.setIdZona(model.getIdZona());
		soapModel.setNome(model.getNome());
		soapModel.setSigla(model.getSigla());
		soapModel.setTipo(model.getTipo());
		soapModel.setXml(model.getXml());

		return soapModel;
	}

	public static StoricoSoap[] toSoapModels(Storico[] models) {
		StoricoSoap[] soapModels = new StoricoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StoricoSoap[][] toSoapModels(Storico[][] models) {
		StoricoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StoricoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StoricoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StoricoSoap[] toSoapModels(List<Storico> models) {
		List<StoricoSoap> soapModels = new ArrayList<StoricoSoap>(
			models.size());

		for (Storico model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StoricoSoap[soapModels.size()]);
	}

	public StoricoSoap() {
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

	public int getIdZona() {
		return _idZona;
	}

	public void setIdZona(int idZona) {
		_idZona = idZona;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getSigla() {
		return _sigla;
	}

	public void setSigla(String sigla) {
		_sigla = sigla;
	}

	public String getTipo() {
		return _tipo;
	}

	public void setTipo(String tipo) {
		_tipo = tipo;
	}

	public String getXml() {
		return _xml;
	}

	public void setXml(String xml) {
		_xml = xml;
	}

	private long _id;
	private int _idZona;
	private String _nome;
	private String _sigla;
	private String _tipo;
	private String _xml;

}