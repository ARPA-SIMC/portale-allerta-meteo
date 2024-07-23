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

package it.eng.animazione.image.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class altezzaOndaAdriacSoap implements Serializable {

	public static altezzaOndaAdriacSoap toSoapModel(altezzaOndaAdriac model) {
		altezzaOndaAdriacSoap soapModel = new altezzaOndaAdriacSoap();

		soapModel.setId(model.getId());
		soapModel.setIm(model.getIm());
		soapModel.setText_LOC(model.getText_LOC());
		soapModel.setTs_UTC(model.getTs_UTC());
		soapModel.setImgData(model.getImgData());

		return soapModel;
	}

	public static altezzaOndaAdriacSoap[] toSoapModels(
		altezzaOndaAdriac[] models) {

		altezzaOndaAdriacSoap[] soapModels =
			new altezzaOndaAdriacSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static altezzaOndaAdriacSoap[][] toSoapModels(
		altezzaOndaAdriac[][] models) {

		altezzaOndaAdriacSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new altezzaOndaAdriacSoap[models.length][models[0].length];
		}
		else {
			soapModels = new altezzaOndaAdriacSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static altezzaOndaAdriacSoap[] toSoapModels(
		List<altezzaOndaAdriac> models) {

		List<altezzaOndaAdriacSoap> soapModels =
			new ArrayList<altezzaOndaAdriacSoap>(models.size());

		for (altezzaOndaAdriac model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new altezzaOndaAdriacSoap[soapModels.size()]);
	}

	public altezzaOndaAdriacSoap() {
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

	public String getIm() {
		return _im;
	}

	public void setIm(String im) {
		_im = im;
	}

	public String getText_LOC() {
		return _text_LOC;
	}

	public void setText_LOC(String text_LOC) {
		_text_LOC = text_LOC;
	}

	public long getTs_UTC() {
		return _ts_UTC;
	}

	public void setTs_UTC(long ts_UTC) {
		_ts_UTC = ts_UTC;
	}

	public String getImgData() {
		return _imgData;
	}

	public void setImgData(String imgData) {
		_imgData = imgData;
	}

	private long _id;
	private String _im;
	private String _text_LOC;
	private long _ts_UTC;
	private String _imgData;

}