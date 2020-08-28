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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaSitoServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaSitoSoap implements Serializable {

	public static RubricaSitoSoap toSoapModel(RubricaSito model) {
		RubricaSitoSoap soapModel = new RubricaSitoSoap();

		soapModel.setID_SITO(model.getID_SITO());
		soapModel.setNOME(model.getNOME());
		soapModel.setFK_LIFERAY_SITE(model.getFK_LIFERAY_SITE());

		return soapModel;
	}

	public static RubricaSitoSoap[] toSoapModels(RubricaSito[] models) {
		RubricaSitoSoap[] soapModels = new RubricaSitoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaSitoSoap[][] toSoapModels(RubricaSito[][] models) {
		RubricaSitoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RubricaSitoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaSitoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaSitoSoap[] toSoapModels(List<RubricaSito> models) {
		List<RubricaSitoSoap> soapModels = new ArrayList<RubricaSitoSoap>(
			models.size());

		for (RubricaSito model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RubricaSitoSoap[soapModels.size()]);
	}

	public RubricaSitoSoap() {
	}

	public long getPrimaryKey() {
		return _ID_SITO;
	}

	public void setPrimaryKey(long pk) {
		setID_SITO(pk);
	}

	public long getID_SITO() {
		return _ID_SITO;
	}

	public void setID_SITO(long ID_SITO) {
		_ID_SITO = ID_SITO;
	}

	public String getNOME() {
		return _NOME;
	}

	public void setNOME(String NOME) {
		_NOME = NOME;
	}

	public long getFK_LIFERAY_SITE() {
		return _FK_LIFERAY_SITE;
	}

	public void setFK_LIFERAY_SITE(long FK_LIFERAY_SITE) {
		_FK_LIFERAY_SITE = FK_LIFERAY_SITE;
	}

	private long _ID_SITO;

	private String _NOME;

	private long _FK_LIFERAY_SITE;

}