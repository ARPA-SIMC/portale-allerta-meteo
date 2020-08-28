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
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.RegolaAllarmeCondizioneServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class RegolaAllarmeCondizioneSoap implements Serializable {

	public static RegolaAllarmeCondizioneSoap toSoapModel(
		RegolaAllarmeCondizione model) {

		RegolaAllarmeCondizioneSoap soapModel =
			new RegolaAllarmeCondizioneSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setIdRegola(model.getIdRegola());
		soapModel.setLettera(model.getLettera());
		soapModel.setIdVariabile(model.getIdVariabile());
		soapModel.setIdStazione(model.getIdStazione());
		soapModel.setIdStazioneVariabile(model.getIdStazioneVariabile());
		soapModel.setSoglia(model.getSoglia());
		soapModel.setValoreSoglia(model.getValoreSoglia());

		return soapModel;
	}

	public static RegolaAllarmeCondizioneSoap[] toSoapModels(
		RegolaAllarmeCondizione[] models) {

		RegolaAllarmeCondizioneSoap[] soapModels =
			new RegolaAllarmeCondizioneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RegolaAllarmeCondizioneSoap[][] toSoapModels(
		RegolaAllarmeCondizione[][] models) {

		RegolaAllarmeCondizioneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RegolaAllarmeCondizioneSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new RegolaAllarmeCondizioneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RegolaAllarmeCondizioneSoap[] toSoapModels(
		List<RegolaAllarmeCondizione> models) {

		List<RegolaAllarmeCondizioneSoap> soapModels =
			new ArrayList<RegolaAllarmeCondizioneSoap>(models.size());

		for (RegolaAllarmeCondizione model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new RegolaAllarmeCondizioneSoap[soapModels.size()]);
	}

	public RegolaAllarmeCondizioneSoap() {
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

	public long getIdRegola() {
		return _idRegola;
	}

	public void setIdRegola(long idRegola) {
		_idRegola = idRegola;
	}

	public String getLettera() {
		return _lettera;
	}

	public void setLettera(String lettera) {
		_lettera = lettera;
	}

	public String getIdVariabile() {
		return _idVariabile;
	}

	public void setIdVariabile(String idVariabile) {
		_idVariabile = idVariabile;
	}

	public String getIdStazione() {
		return _idStazione;
	}

	public void setIdStazione(String idStazione) {
		_idStazione = idStazione;
	}

	public long getIdStazioneVariabile() {
		return _idStazioneVariabile;
	}

	public void setIdStazioneVariabile(long idStazioneVariabile) {
		_idStazioneVariabile = idStazioneVariabile;
	}

	public int getSoglia() {
		return _soglia;
	}

	public void setSoglia(int soglia) {
		_soglia = soglia;
	}

	public double getValoreSoglia() {
		return _valoreSoglia;
	}

	public void setValoreSoglia(double valoreSoglia) {
		_valoreSoglia = valoreSoglia;
	}

	private String _uuid;
	private long _id;
	private long _idRegola;
	private String _lettera;
	private String _idVariabile;
	private String _idStazione;
	private long _idStazioneVariabile;
	private int _soglia;
	private double _valoreSoglia;

}