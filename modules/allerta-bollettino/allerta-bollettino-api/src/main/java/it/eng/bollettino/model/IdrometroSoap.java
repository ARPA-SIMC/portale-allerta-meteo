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
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.IdrometroServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class IdrometroSoap implements Serializable {

	public static IdrometroSoap toSoapModel(Idrometro model) {
		IdrometroSoap soapModel = new IdrometroSoap();

		soapModel.setStazioneId(model.getStazioneId());
		soapModel.setNomeBacino(model.getNomeBacino());
		soapModel.setNomeSottobacino(model.getNomeSottobacino());
		soapModel.setNomeRubrica(model.getNomeRubrica());
		soapModel.setSogliaSpike(model.getSogliaSpike());

		return soapModel;
	}

	public static IdrometroSoap[] toSoapModels(Idrometro[] models) {
		IdrometroSoap[] soapModels = new IdrometroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IdrometroSoap[][] toSoapModels(Idrometro[][] models) {
		IdrometroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IdrometroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IdrometroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IdrometroSoap[] toSoapModels(List<Idrometro> models) {
		List<IdrometroSoap> soapModels = new ArrayList<IdrometroSoap>(
			models.size());

		for (Idrometro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IdrometroSoap[soapModels.size()]);
	}

	public IdrometroSoap() {
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

	public String getNomeBacino() {
		return _nomeBacino;
	}

	public void setNomeBacino(String nomeBacino) {
		_nomeBacino = nomeBacino;
	}

	public String getNomeSottobacino() {
		return _nomeSottobacino;
	}

	public void setNomeSottobacino(String nomeSottobacino) {
		_nomeSottobacino = nomeSottobacino;
	}

	public String getNomeRubrica() {
		return _nomeRubrica;
	}

	public void setNomeRubrica(String nomeRubrica) {
		_nomeRubrica = nomeRubrica;
	}

	public double getSogliaSpike() {
		return _sogliaSpike;
	}

	public void setSogliaSpike(double sogliaSpike) {
		_sogliaSpike = sogliaSpike;
	}

	private String _stazioneId;
	private String _nomeBacino;
	private String _nomeSottobacino;
	private String _nomeRubrica;
	private double _sogliaSpike;

}