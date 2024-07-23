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

package it.eng.cache.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.cache.service.http.DatiServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class DatiSoap implements Serializable {

	public static DatiSoap toSoapModel(Dati model) {
		DatiSoap soapModel = new DatiSoap();

		soapModel.setIdDati(model.getIdDati());
		soapModel.setDato(model.getDato());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static DatiSoap[] toSoapModels(Dati[] models) {
		DatiSoap[] soapModels = new DatiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DatiSoap[][] toSoapModels(Dati[][] models) {
		DatiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DatiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DatiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DatiSoap[] toSoapModels(List<Dati> models) {
		List<DatiSoap> soapModels = new ArrayList<DatiSoap>(models.size());

		for (Dati model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DatiSoap[soapModels.size()]);
	}

	public DatiSoap() {
	}

	public String getPrimaryKey() {
		return _idDati;
	}

	public void setPrimaryKey(String pk) {
		setIdDati(pk);
	}

	public String getIdDati() {
		return _idDati;
	}

	public void setIdDati(String idDati) {
		_idDati = idDati;
	}

	public String getDato() {
		return _dato;
	}

	public void setDato(String dato) {
		_dato = dato;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private String _idDati;
	private String _dato;
	private Date _createDate;

}