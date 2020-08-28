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

package it.eng.radarMeteo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.radarMeteo.service.http.JsonServiceSoap}.
 *
 * @author Francesco
 * @generated
 */
@ProviderType
public class JsonSoap implements Serializable {

	public static JsonSoap toSoapModel(Json model) {
		JsonSoap soapModel = new JsonSoap();

		soapModel.setId(model.getId());
		soapModel.setType(model.getType());
		soapModel.setInserted(model.getInserted());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static JsonSoap[] toSoapModels(Json[] models) {
		JsonSoap[] soapModels = new JsonSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JsonSoap[][] toSoapModels(Json[][] models) {
		JsonSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JsonSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JsonSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JsonSoap[] toSoapModels(List<Json> models) {
		List<JsonSoap> soapModels = new ArrayList<JsonSoap>(models.size());

		for (Json model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JsonSoap[soapModels.size()]);
	}

	public JsonSoap() {
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

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getInserted() {
		return _inserted;
	}

	public void setInserted(long inserted) {
		_inserted = inserted;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	private long _id;
	private String _type;
	private long _inserted;
	private String _data;

}