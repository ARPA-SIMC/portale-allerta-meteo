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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaCategoriaServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaCategoriaSoap implements Serializable {

	public static RubricaCategoriaSoap toSoapModel(RubricaCategoria model) {
		RubricaCategoriaSoap soapModel = new RubricaCategoriaSoap();

		soapModel.setID_CATEGORIA(model.getID_CATEGORIA());
		soapModel.setDESCRIZIONE(model.getDESCRIZIONE());

		return soapModel;
	}

	public static RubricaCategoriaSoap[] toSoapModels(
		RubricaCategoria[] models) {

		RubricaCategoriaSoap[] soapModels =
			new RubricaCategoriaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaCategoriaSoap[][] toSoapModels(
		RubricaCategoria[][] models) {

		RubricaCategoriaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RubricaCategoriaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaCategoriaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaCategoriaSoap[] toSoapModels(
		List<RubricaCategoria> models) {

		List<RubricaCategoriaSoap> soapModels =
			new ArrayList<RubricaCategoriaSoap>(models.size());

		for (RubricaCategoria model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RubricaCategoriaSoap[soapModels.size()]);
	}

	public RubricaCategoriaSoap() {
	}

	public long getPrimaryKey() {
		return _ID_CATEGORIA;
	}

	public void setPrimaryKey(long pk) {
		setID_CATEGORIA(pk);
	}

	public long getID_CATEGORIA() {
		return _ID_CATEGORIA;
	}

	public void setID_CATEGORIA(long ID_CATEGORIA) {
		_ID_CATEGORIA = ID_CATEGORIA;
	}

	public String getDESCRIZIONE() {
		return _DESCRIZIONE;
	}

	public void setDESCRIZIONE(String DESCRIZIONE) {
		_DESCRIZIONE = DESCRIZIONE;
	}

	private long _ID_CATEGORIA;

	private String _DESCRIZIONE;

}