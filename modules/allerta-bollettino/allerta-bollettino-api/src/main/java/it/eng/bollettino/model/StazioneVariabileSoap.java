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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.StazioneVariabileServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class StazioneVariabileSoap implements Serializable {

	public static StazioneVariabileSoap toSoapModel(StazioneVariabile model) {
		StazioneVariabileSoap soapModel = new StazioneVariabileSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setIdStazione(model.getIdStazione());
		soapModel.setIdVariabile(model.getIdVariabile());
		soapModel.setDataUltimoValore(model.getDataUltimoValore());
		soapModel.setSoglia1(model.getSoglia1());
		soapModel.setSoglia2(model.getSoglia2());
		soapModel.setSoglia3(model.getSoglia3());

		return soapModel;
	}

	public static StazioneVariabileSoap[] toSoapModels(
		StazioneVariabile[] models) {

		StazioneVariabileSoap[] soapModels =
			new StazioneVariabileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StazioneVariabileSoap[][] toSoapModels(
		StazioneVariabile[][] models) {

		StazioneVariabileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StazioneVariabileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StazioneVariabileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StazioneVariabileSoap[] toSoapModels(
		List<StazioneVariabile> models) {

		List<StazioneVariabileSoap> soapModels =
			new ArrayList<StazioneVariabileSoap>(models.size());

		for (StazioneVariabile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StazioneVariabileSoap[soapModels.size()]);
	}

	public StazioneVariabileSoap() {
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

	public String getIdStazione() {
		return _idStazione;
	}

	public void setIdStazione(String idStazione) {
		_idStazione = idStazione;
	}

	public String getIdVariabile() {
		return _idVariabile;
	}

	public void setIdVariabile(String idVariabile) {
		_idVariabile = idVariabile;
	}

	public Date getDataUltimoValore() {
		return _dataUltimoValore;
	}

	public void setDataUltimoValore(Date dataUltimoValore) {
		_dataUltimoValore = dataUltimoValore;
	}

	public double getSoglia1() {
		return _soglia1;
	}

	public void setSoglia1(double soglia1) {
		_soglia1 = soglia1;
	}

	public double getSoglia2() {
		return _soglia2;
	}

	public void setSoglia2(double soglia2) {
		_soglia2 = soglia2;
	}

	public double getSoglia3() {
		return _soglia3;
	}

	public void setSoglia3(double soglia3) {
		_soglia3 = soglia3;
	}

	private String _uuid;
	private long _id;
	private String _idStazione;
	private String _idVariabile;
	private Date _dataUltimoValore;
	private double _soglia1;
	private double _soglia2;
	private double _soglia3;

}