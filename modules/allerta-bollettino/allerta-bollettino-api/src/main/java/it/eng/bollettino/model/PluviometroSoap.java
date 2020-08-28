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
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.PluviometroServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class PluviometroSoap implements Serializable {

	public static PluviometroSoap toSoapModel(Pluviometro model) {
		PluviometroSoap soapModel = new PluviometroSoap();

		soapModel.setStazioneId(model.getStazioneId());
		soapModel.setNomeGruppo(model.getNomeGruppo());
		soapModel.setNomeRubrica(model.getNomeRubrica());

		return soapModel;
	}

	public static PluviometroSoap[] toSoapModels(Pluviometro[] models) {
		PluviometroSoap[] soapModels = new PluviometroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PluviometroSoap[][] toSoapModels(Pluviometro[][] models) {
		PluviometroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PluviometroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PluviometroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PluviometroSoap[] toSoapModels(List<Pluviometro> models) {
		List<PluviometroSoap> soapModels = new ArrayList<PluviometroSoap>(
			models.size());

		for (Pluviometro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PluviometroSoap[soapModels.size()]);
	}

	public PluviometroSoap() {
	}

	public String getPrimaryKey() {
		return _stazioneId;
	}

	public void setPrimaryKey(String pk) {
		setStazioneId(pk);
	}

	public String getStazioneId() {
		return _stazioneId;
	}

	public void setStazioneId(String stazioneId) {
		_stazioneId = stazioneId;
	}

	public String getNomeGruppo() {
		return _nomeGruppo;
	}

	public void setNomeGruppo(String nomeGruppo) {
		_nomeGruppo = nomeGruppo;
	}

	public String getNomeRubrica() {
		return _nomeRubrica;
	}

	public void setNomeRubrica(String nomeRubrica) {
		_nomeRubrica = nomeRubrica;
	}

	private String _stazioneId;
	private String _nomeGruppo;
	private String _nomeRubrica;

}