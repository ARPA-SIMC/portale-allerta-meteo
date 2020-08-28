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

package it.eng.allerta.messages.services.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Giorgianni_F
 * @generated
 */
@ProviderType
public class AuthSoap implements Serializable {

	public static AuthSoap toSoapModel(Auth model) {
		AuthSoap soapModel = new AuthSoap();

		soapModel.setKey(model.getKey());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static AuthSoap[] toSoapModels(Auth[] models) {
		AuthSoap[] soapModels = new AuthSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuthSoap[][] toSoapModels(Auth[][] models) {
		AuthSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuthSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuthSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuthSoap[] toSoapModels(List<Auth> models) {
		List<AuthSoap> soapModels = new ArrayList<AuthSoap>(models.size());

		for (Auth model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuthSoap[soapModels.size()]);
	}

	public AuthSoap() {
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