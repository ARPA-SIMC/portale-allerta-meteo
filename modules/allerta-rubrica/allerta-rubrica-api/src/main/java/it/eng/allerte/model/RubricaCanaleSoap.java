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

package it.eng.allerte.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaCanaleServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaCanaleSoap implements Serializable {

	public static RubricaCanaleSoap toSoapModel(RubricaCanale model) {
		RubricaCanaleSoap soapModel = new RubricaCanaleSoap();

		soapModel.setID_CANALE(model.getID_CANALE());
		soapModel.setNOME(model.getNOME());
		soapModel.setICONA(model.getICONA());
		soapModel.setREGEX(model.getREGEX());

		return soapModel;
	}

	public static RubricaCanaleSoap[] toSoapModels(RubricaCanale[] models) {
		RubricaCanaleSoap[] soapModels = new RubricaCanaleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaCanaleSoap[][] toSoapModels(RubricaCanale[][] models) {
		RubricaCanaleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RubricaCanaleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaCanaleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaCanaleSoap[] toSoapModels(List<RubricaCanale> models) {
		List<RubricaCanaleSoap> soapModels = new ArrayList<RubricaCanaleSoap>(
			models.size());

		for (RubricaCanale model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RubricaCanaleSoap[soapModels.size()]);
	}

	public RubricaCanaleSoap() {
	}

	public long getPrimaryKey() {
		return _ID_CANALE;
	}

	public void setPrimaryKey(long pk) {
		setID_CANALE(pk);
	}

	public long getID_CANALE() {
		return _ID_CANALE;
	}

	public void setID_CANALE(long ID_CANALE) {
		_ID_CANALE = ID_CANALE;
	}

	public String getNOME() {
		return _NOME;
	}

	public void setNOME(String NOME) {
		_NOME = NOME;
	}

	public String getICONA() {
		return _ICONA;
	}

	public void setICONA(String ICONA) {
		_ICONA = ICONA;
	}

	public String getREGEX() {
		return _REGEX;
	}

	public void setREGEX(String REGEX) {
		_REGEX = REGEX;
	}

	private long _ID_CANALE;

	private String _NOME;

	private String _ICONA;

	private String _REGEX;

}