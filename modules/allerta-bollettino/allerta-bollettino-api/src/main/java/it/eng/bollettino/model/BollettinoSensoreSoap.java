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
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.BollettinoSensoreServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoSensoreSoap implements Serializable {

	public static BollettinoSensoreSoap toSoapModel(BollettinoSensore model) {
		BollettinoSensoreSoap soapModel = new BollettinoSensoreSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setIdBollettino(model.getIdBollettino());
		soapModel.setIdStazione(model.getIdStazione());
		soapModel.setIdBollettinoBacino(model.getIdBollettinoBacino());
		soapModel.setProgressivo(model.getProgressivo());
		soapModel.setNomeStazione(model.getNomeStazione());
		soapModel.setOreOsservazione(model.getOreOsservazione());
		soapModel.setOsservazione(model.getOsservazione());
		soapModel.setTendenza(model.getTendenza());
		soapModel.setColmoPrevisto(model.getColmoPrevisto());
		soapModel.setOraPrevista(model.getOraPrevista());
		soapModel.setSoglia1(model.getSoglia1());
		soapModel.setSoglia2(model.getSoglia2());
		soapModel.setSoglia3(model.getSoglia3());
		soapModel.setGiornoPrevisto(model.getGiornoPrevisto());
		soapModel.setOsservato(model.isOsservato());

		return soapModel;
	}

	public static BollettinoSensoreSoap[] toSoapModels(
		BollettinoSensore[] models) {

		BollettinoSensoreSoap[] soapModels =
			new BollettinoSensoreSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BollettinoSensoreSoap[][] toSoapModels(
		BollettinoSensore[][] models) {

		BollettinoSensoreSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new BollettinoSensoreSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BollettinoSensoreSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BollettinoSensoreSoap[] toSoapModels(
		List<BollettinoSensore> models) {

		List<BollettinoSensoreSoap> soapModels =
			new ArrayList<BollettinoSensoreSoap>(models.size());

		for (BollettinoSensore model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BollettinoSensoreSoap[soapModels.size()]);
	}

	public BollettinoSensoreSoap() {
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

	public long getIdStazione() {
		return _idStazione;
	}

	public void setIdStazione(long idStazione) {
		_idStazione = idStazione;
	}

	public long getIdBollettinoBacino() {
		return _idBollettinoBacino;
	}

	public void setIdBollettinoBacino(long idBollettinoBacino) {
		_idBollettinoBacino = idBollettinoBacino;
	}

	public int getProgressivo() {
		return _progressivo;
	}

	public void setProgressivo(int progressivo) {
		_progressivo = progressivo;
	}

	public String getNomeStazione() {
		return _nomeStazione;
	}

	public void setNomeStazione(String nomeStazione) {
		_nomeStazione = nomeStazione;
	}

	public String getOreOsservazione() {
		return _oreOsservazione;
	}

	public void setOreOsservazione(String oreOsservazione) {
		_oreOsservazione = oreOsservazione;
	}

	public double getOsservazione() {
		return _osservazione;
	}

	public void setOsservazione(double osservazione) {
		_osservazione = osservazione;
	}

	public int getTendenza() {
		return _tendenza;
	}

	public void setTendenza(int tendenza) {
		_tendenza = tendenza;
	}

	public String getColmoPrevisto() {
		return _colmoPrevisto;
	}

	public void setColmoPrevisto(String colmoPrevisto) {
		_colmoPrevisto = colmoPrevisto;
	}

	public String getOraPrevista() {
		return _oraPrevista;
	}

	public void setOraPrevista(String oraPrevista) {
		_oraPrevista = oraPrevista;
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

	public String getGiornoPrevisto() {
		return _giornoPrevisto;
	}

	public void setGiornoPrevisto(String giornoPrevisto) {
		_giornoPrevisto = giornoPrevisto;
	}

	public boolean getOsservato() {
		return _osservato;
	}

	public boolean isOsservato() {
		return _osservato;
	}

	public void setOsservato(boolean osservato) {
		_osservato = osservato;
	}

	private String _uuid;
	private long _id;
	private long _idBollettino;
	private long _idStazione;
	private long _idBollettinoBacino;
	private int _progressivo;
	private String _nomeStazione;
	private String _oreOsservazione;
	private double _osservazione;
	private int _tendenza;
	private String _colmoPrevisto;
	private String _oraPrevista;
	private double _soglia1;
	private double _soglia2;
	private double _soglia3;
	private String _giornoPrevisto;
	private boolean _osservato;

}