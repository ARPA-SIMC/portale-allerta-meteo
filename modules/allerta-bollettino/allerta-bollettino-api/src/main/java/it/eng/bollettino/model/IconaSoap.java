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
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.IconaServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class IconaSoap implements Serializable {

	public static IconaSoap toSoapModel(Icona model) {
		IconaSoap soapModel = new IconaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setPath(model.getPath());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static IconaSoap[] toSoapModels(Icona[] models) {
		IconaSoap[] soapModels = new IconaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IconaSoap[][] toSoapModels(Icona[][] models) {
		IconaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IconaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IconaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IconaSoap[] toSoapModels(List<Icona> models) {
		List<IconaSoap> soapModels = new ArrayList<IconaSoap>(models.size());

		for (Icona model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IconaSoap[soapModels.size()]);
	}

	public IconaSoap() {
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

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private String _uuid;
	private long _id;
	private String _path;
	private String _descrizione;

}