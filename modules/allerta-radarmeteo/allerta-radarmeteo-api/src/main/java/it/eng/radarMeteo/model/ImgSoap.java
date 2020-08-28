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

package it.eng.radarMeteo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.radarMeteo.service.http.ImgServiceSoap}.
 *
 * @author Francesco
 * @generated
 */
@ProviderType
public class ImgSoap implements Serializable {

	public static ImgSoap toSoapModel(Img model) {
		ImgSoap soapModel = new ImgSoap();

		soapModel.setId(model.getId());
		soapModel.setCoord(model.getCoord());
		soapModel.setPalette(model.getPalette());
		soapModel.setTimestamp(model.getTimestamp());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static ImgSoap[] toSoapModels(Img[] models) {
		ImgSoap[] soapModels = new ImgSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImgSoap[][] toSoapModels(Img[][] models) {
		ImgSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImgSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImgSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImgSoap[] toSoapModels(List<Img> models) {
		List<ImgSoap> soapModels = new ArrayList<ImgSoap>(models.size());

		for (Img model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImgSoap[soapModels.size()]);
	}

	public ImgSoap() {
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

	public String getCoord() {
		return _coord;
	}

	public void setCoord(String coord) {
		_coord = coord;
	}

	public String getPalette() {
		return _palette;
	}

	public void setPalette(String palette) {
		_palette = palette;
	}

	public long getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(long timestamp) {
		_timestamp = timestamp;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	private long _id;
	private String _coord;
	private String _palette;
	private long _timestamp;
	private String _data;

}