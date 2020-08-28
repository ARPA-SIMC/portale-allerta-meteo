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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaUtenteSitoServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaUtenteSitoSoap implements Serializable {

	public static RubricaUtenteSitoSoap toSoapModel(RubricaUtenteSito model) {
		RubricaUtenteSitoSoap soapModel = new RubricaUtenteSitoSoap();

		soapModel.setID_UTENTE(model.getID_UTENTE());
		soapModel.setID_SITO(model.getID_SITO());

		return soapModel;
	}

	public static RubricaUtenteSitoSoap[] toSoapModels(
		RubricaUtenteSito[] models) {

		RubricaUtenteSitoSoap[] soapModels =
			new RubricaUtenteSitoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaUtenteSitoSoap[][] toSoapModels(
		RubricaUtenteSito[][] models) {

		RubricaUtenteSitoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RubricaUtenteSitoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaUtenteSitoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaUtenteSitoSoap[] toSoapModels(
		List<RubricaUtenteSito> models) {

		List<RubricaUtenteSitoSoap> soapModels =
			new ArrayList<RubricaUtenteSitoSoap>(models.size());

		for (RubricaUtenteSito model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RubricaUtenteSitoSoap[soapModels.size()]);
	}

	public RubricaUtenteSitoSoap() {
	}

	public long getPrimaryKey() {
		return _ID_UTENTE;
	}

	public void setPrimaryKey(long pk) {
		setID_UTENTE(pk);
	}

	public long getID_UTENTE() {
		return _ID_UTENTE;
	}

	public void setID_UTENTE(long ID_UTENTE) {
		_ID_UTENTE = ID_UTENTE;
	}

	public long getID_SITO() {
		return _ID_SITO;
	}

	public void setID_SITO(long ID_SITO) {
		_ID_SITO = ID_SITO;
	}

	private long _ID_UTENTE;

	private long _ID_SITO;

}