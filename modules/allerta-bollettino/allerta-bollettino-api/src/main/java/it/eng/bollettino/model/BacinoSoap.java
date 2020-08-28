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
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.BacinoServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BacinoSoap implements Serializable {

	public static BacinoSoap toSoapModel(Bacino model) {
		BacinoSoap soapModel = new BacinoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setNome(model.getNome());
		soapModel.setProgressivo(model.getProgressivo());

		return soapModel;
	}

	public static BacinoSoap[] toSoapModels(Bacino[] models) {
		BacinoSoap[] soapModels = new BacinoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BacinoSoap[][] toSoapModels(Bacino[][] models) {
		BacinoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BacinoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BacinoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BacinoSoap[] toSoapModels(List<Bacino> models) {
		List<BacinoSoap> soapModels = new ArrayList<BacinoSoap>(models.size());

		for (Bacino model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BacinoSoap[soapModels.size()]);
	}

	public BacinoSoap() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public int getProgressivo() {
		return _progressivo;
	}

	public void setProgressivo(int progressivo) {
		_progressivo = progressivo;
	}

	private String _uuid;
	private String _id;
	private String _nome;
	private int _progressivo;

}