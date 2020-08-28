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

package it.eng.animazione.image.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class ParametroSoap implements Serializable {

	public static ParametroSoap toSoapModel(Parametro model) {
		ParametroSoap soapModel = new ParametroSoap();

		soapModel.setKey(model.getKey());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static ParametroSoap[] toSoapModels(Parametro[] models) {
		ParametroSoap[] soapModels = new ParametroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ParametroSoap[][] toSoapModels(Parametro[][] models) {
		ParametroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ParametroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ParametroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ParametroSoap[] toSoapModels(List<Parametro> models) {
		List<ParametroSoap> soapModels = new ArrayList<ParametroSoap>(
			models.size());

		for (Parametro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ParametroSoap[soapModels.size()]);
	}

	public ParametroSoap() {
	}

	public String getPrimaryKey() {
		return _key;
	}

	public void setPrimaryKey(String pk) {
		setKey(pk);
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private String _key;
	private String _value;

}