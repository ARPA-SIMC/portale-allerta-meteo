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
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.RegolaAllarmeComuneServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class RegolaAllarmeComuneSoap implements Serializable {

	public static RegolaAllarmeComuneSoap toSoapModel(
		RegolaAllarmeComune model) {

		RegolaAllarmeComuneSoap soapModel = new RegolaAllarmeComuneSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setIdRegola(model.getIdRegola());
		soapModel.setIdComune(model.getIdComune());

		return soapModel;
	}

	public static RegolaAllarmeComuneSoap[] toSoapModels(
		RegolaAllarmeComune[] models) {

		RegolaAllarmeComuneSoap[] soapModels =
			new RegolaAllarmeComuneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RegolaAllarmeComuneSoap[][] toSoapModels(
		RegolaAllarmeComune[][] models) {

		RegolaAllarmeComuneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RegolaAllarmeComuneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RegolaAllarmeComuneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RegolaAllarmeComuneSoap[] toSoapModels(
		List<RegolaAllarmeComune> models) {

		List<RegolaAllarmeComuneSoap> soapModels =
			new ArrayList<RegolaAllarmeComuneSoap>(models.size());

		for (RegolaAllarmeComune model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new RegolaAllarmeComuneSoap[soapModels.size()]);
	}

	public RegolaAllarmeComuneSoap() {
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

	public long getIdRegola() {
		return _idRegola;
	}

	public void setIdRegola(long idRegola) {
		_idRegola = idRegola;
	}

	public long getIdComune() {
		return _idComune;
	}

	public void setIdComune(long idComune) {
		_idComune = idComune;
	}

	private String _uuid;
	private long _id;
	private long _idRegola;
	private long _idComune;

}