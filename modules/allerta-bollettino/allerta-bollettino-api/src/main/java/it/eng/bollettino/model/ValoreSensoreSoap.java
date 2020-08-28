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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.ValoreSensoreServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class ValoreSensoreSoap implements Serializable {

	public static ValoreSensoreSoap toSoapModel(ValoreSensore model) {
		ValoreSensoreSoap soapModel = new ValoreSensoreSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setValue(model.getValue());
		soapModel.setDatetime(model.getDatetime());
		soapModel.setIdVariabile(model.getIdVariabile());
		soapModel.setIdStazione(model.getIdStazione());

		return soapModel;
	}

	public static ValoreSensoreSoap[] toSoapModels(ValoreSensore[] models) {
		ValoreSensoreSoap[] soapModels = new ValoreSensoreSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ValoreSensoreSoap[][] toSoapModels(ValoreSensore[][] models) {
		ValoreSensoreSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ValoreSensoreSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ValoreSensoreSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ValoreSensoreSoap[] toSoapModels(List<ValoreSensore> models) {
		List<ValoreSensoreSoap> soapModels = new ArrayList<ValoreSensoreSoap>(
			models.size());

		for (ValoreSensore model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ValoreSensoreSoap[soapModels.size()]);
	}

	public ValoreSensoreSoap() {
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

	public double getValue() {
		return _value;
	}

	public void setValue(double value) {
		_value = value;
	}

	public Date getDatetime() {
		return _datetime;
	}

	public void setDatetime(Date datetime) {
		_datetime = datetime;
	}

	public String getIdVariabile() {
		return _idVariabile;
	}

	public void setIdVariabile(String idVariabile) {
		_idVariabile = idVariabile;
	}

	public String getIdStazione() {
		return _idStazione;
	}

	public void setIdStazione(String idStazione) {
		_idStazione = idStazione;
	}

	private String _uuid;
	private long _id;
	private double _value;
	private Date _datetime;
	private String _idVariabile;
	private String _idStazione;

}