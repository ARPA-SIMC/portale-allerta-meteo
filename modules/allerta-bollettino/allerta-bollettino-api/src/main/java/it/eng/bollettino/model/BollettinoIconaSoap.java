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
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.BollettinoIconaServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoIconaSoap implements Serializable {

	public static BollettinoIconaSoap toSoapModel(BollettinoIcona model) {
		BollettinoIconaSoap soapModel = new BollettinoIconaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setIdBollettino(model.getIdBollettino());
		soapModel.setIdIcona(model.getIdIcona());
		soapModel.setX(model.getX());
		soapModel.setY(model.getY());

		return soapModel;
	}

	public static BollettinoIconaSoap[] toSoapModels(BollettinoIcona[] models) {
		BollettinoIconaSoap[] soapModels =
			new BollettinoIconaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BollettinoIconaSoap[][] toSoapModels(
		BollettinoIcona[][] models) {

		BollettinoIconaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new BollettinoIconaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BollettinoIconaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BollettinoIconaSoap[] toSoapModels(
		List<BollettinoIcona> models) {

		List<BollettinoIconaSoap> soapModels =
			new ArrayList<BollettinoIconaSoap>(models.size());

		for (BollettinoIcona model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BollettinoIconaSoap[soapModels.size()]);
	}

	public BollettinoIconaSoap() {
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

	public long getIdBollettino() {
		return _idBollettino;
	}

	public void setIdBollettino(long idBollettino) {
		_idBollettino = idBollettino;
	}

	public long getIdIcona() {
		return _idIcona;
	}

	public void setIdIcona(long idIcona) {
		_idIcona = idIcona;
	}

	public double getX() {
		return _x;
	}

	public void setX(double x) {
		_x = x;
	}

	public double getY() {
		return _y;
	}

	public void setY(double y) {
		_y = y;
	}

	private String _uuid;
	private long _id;
	private long _idBollettino;
	private long _idIcona;
	private double _x;
	private double _y;

}