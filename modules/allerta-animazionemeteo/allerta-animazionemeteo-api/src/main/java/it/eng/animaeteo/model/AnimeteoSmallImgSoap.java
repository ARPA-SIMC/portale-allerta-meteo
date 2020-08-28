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

package it.eng.animaeteo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.animaeteo.service.http.AnimeteoSmallImgServiceSoap}.
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class AnimeteoSmallImgSoap implements Serializable {

	public static AnimeteoSmallImgSoap toSoapModel(AnimeteoSmallImg model) {
		AnimeteoSmallImgSoap soapModel = new AnimeteoSmallImgSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());
		soapModel.setInserted(model.getInserted());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static AnimeteoSmallImgSoap[] toSoapModels(
		AnimeteoSmallImg[] models) {

		AnimeteoSmallImgSoap[] soapModels =
			new AnimeteoSmallImgSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnimeteoSmallImgSoap[][] toSoapModels(
		AnimeteoSmallImg[][] models) {

		AnimeteoSmallImgSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AnimeteoSmallImgSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnimeteoSmallImgSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnimeteoSmallImgSoap[] toSoapModels(
		List<AnimeteoSmallImg> models) {

		List<AnimeteoSmallImgSoap> soapModels =
			new ArrayList<AnimeteoSmallImgSoap>(models.size());

		for (AnimeteoSmallImg model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnimeteoSmallImgSoap[soapModels.size()]);
	}

	public AnimeteoSmallImgSoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public Date getInserted() {
		return _inserted;
	}

	public void setInserted(Date inserted) {
		_inserted = inserted;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	private long _id;
	private String _name;
	private String _type;
	private Date _inserted;
	private String _data;

}