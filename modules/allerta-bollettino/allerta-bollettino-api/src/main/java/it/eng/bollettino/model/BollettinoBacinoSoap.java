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
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.BollettinoBacinoServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoBacinoSoap implements Serializable {

	public static BollettinoBacinoSoap toSoapModel(BollettinoBacino model) {
		BollettinoBacinoSoap soapModel = new BollettinoBacinoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setIdBollettino(model.getIdBollettino());
		soapModel.setProgressivo(model.getProgressivo());
		soapModel.setIdBacino(model.getIdBacino());
		soapModel.setNomeBacino(model.getNomeBacino());
		soapModel.setOreOsservazione(model.getOreOsservazione());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static BollettinoBacinoSoap[] toSoapModels(
		BollettinoBacino[] models) {

		BollettinoBacinoSoap[] soapModels =
			new BollettinoBacinoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BollettinoBacinoSoap[][] toSoapModels(
		BollettinoBacino[][] models) {

		BollettinoBacinoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new BollettinoBacinoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BollettinoBacinoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BollettinoBacinoSoap[] toSoapModels(
		List<BollettinoBacino> models) {

		List<BollettinoBacinoSoap> soapModels =
			new ArrayList<BollettinoBacinoSoap>(models.size());

		for (BollettinoBacino model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BollettinoBacinoSoap[soapModels.size()]);
	}

	public BollettinoBacinoSoap() {
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

	public int getProgressivo() {
		return _progressivo;
	}

	public void setProgressivo(int progressivo) {
		_progressivo = progressivo;
	}

	public String getIdBacino() {
		return _idBacino;
	}

	public void setIdBacino(String idBacino) {
		_idBacino = idBacino;
	}

	public String getNomeBacino() {
		return _nomeBacino;
	}

	public void setNomeBacino(String nomeBacino) {
		_nomeBacino = nomeBacino;
	}

	public String getOreOsservazione() {
		return _oreOsservazione;
	}

	public void setOreOsservazione(String oreOsservazione) {
		_oreOsservazione = oreOsservazione;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private String _uuid;
	private long _id;
	private long _idBollettino;
	private int _progressivo;
	private String _idBacino;
	private String _nomeBacino;
	private String _oreOsservazione;
	private String _note;

}