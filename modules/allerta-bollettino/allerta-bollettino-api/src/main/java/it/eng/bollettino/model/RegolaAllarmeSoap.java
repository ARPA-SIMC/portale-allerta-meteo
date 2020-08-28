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
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.RegolaAllarmeServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class RegolaAllarmeSoap implements Serializable {

	public static RegolaAllarmeSoap toSoapModel(RegolaAllarme model) {
		RegolaAllarmeSoap soapModel = new RegolaAllarmeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setNome(model.getNome());
		soapModel.setEspressione(model.getEspressione());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setColore(model.getColore());
		soapModel.setAttivo(model.isAttivo());

		return soapModel;
	}

	public static RegolaAllarmeSoap[] toSoapModels(RegolaAllarme[] models) {
		RegolaAllarmeSoap[] soapModels = new RegolaAllarmeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RegolaAllarmeSoap[][] toSoapModels(RegolaAllarme[][] models) {
		RegolaAllarmeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RegolaAllarmeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RegolaAllarmeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RegolaAllarmeSoap[] toSoapModels(List<RegolaAllarme> models) {
		List<RegolaAllarmeSoap> soapModels = new ArrayList<RegolaAllarmeSoap>(
			models.size());

		for (RegolaAllarme model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RegolaAllarmeSoap[soapModels.size()]);
	}

	public RegolaAllarmeSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getEspressione() {
		return _espressione;
	}

	public void setEspressione(String espressione) {
		_espressione = espressione;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public int getColore() {
		return _colore;
	}

	public void setColore(int colore) {
		_colore = colore;
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

	private String _uuid;
	private long _id;
	private String _nome;
	private String _espressione;
	private String _descrizione;
	private int _colore;
	private boolean _attivo;

}