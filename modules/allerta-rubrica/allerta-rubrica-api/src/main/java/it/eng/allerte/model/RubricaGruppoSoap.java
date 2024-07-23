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

package it.eng.allerte.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaGruppoServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaGruppoSoap implements Serializable {

	public static RubricaGruppoSoap toSoapModel(RubricaGruppo model) {
		RubricaGruppoSoap soapModel = new RubricaGruppoSoap();

		soapModel.setID_GRUPPO(model.getID_GRUPPO());
		soapModel.setNOME(model.getNOME());
		soapModel.setFK_SITO_PROPRIETARIO(model.getFK_SITO_PROPRIETARIO());
		soapModel.setNOTE(model.getNOTE());
		soapModel.setFK_UTENTE_CREAZIONE(model.getFK_UTENTE_CREAZIONE());
		soapModel.setDATA_CREAZIONE(model.getDATA_CREAZIONE());
		soapModel.setFK_UTENTE_MODIFICA(model.getFK_UTENTE_MODIFICA());
		soapModel.setDATA_MODIFICA(model.getDATA_MODIFICA());
		soapModel.setDISABLED(model.isDISABLED());
		soapModel.setFK_CATEGORIA(model.getFK_CATEGORIA());

		return soapModel;
	}

	public static RubricaGruppoSoap[] toSoapModels(RubricaGruppo[] models) {
		RubricaGruppoSoap[] soapModels = new RubricaGruppoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaGruppoSoap[][] toSoapModels(RubricaGruppo[][] models) {
		RubricaGruppoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RubricaGruppoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaGruppoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaGruppoSoap[] toSoapModels(List<RubricaGruppo> models) {
		List<RubricaGruppoSoap> soapModels = new ArrayList<RubricaGruppoSoap>(
			models.size());

		for (RubricaGruppo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RubricaGruppoSoap[soapModels.size()]);
	}

	public RubricaGruppoSoap() {
	}

	public long getPrimaryKey() {
		return _ID_GRUPPO;
	}

	public void setPrimaryKey(long pk) {
		setID_GRUPPO(pk);
	}

	public long getID_GRUPPO() {
		return _ID_GRUPPO;
	}

	public void setID_GRUPPO(long ID_GRUPPO) {
		_ID_GRUPPO = ID_GRUPPO;
	}

	public String getNOME() {
		return _NOME;
	}

	public void setNOME(String NOME) {
		_NOME = NOME;
	}

	public long getFK_SITO_PROPRIETARIO() {
		return _FK_SITO_PROPRIETARIO;
	}

	public void setFK_SITO_PROPRIETARIO(long FK_SITO_PROPRIETARIO) {
		_FK_SITO_PROPRIETARIO = FK_SITO_PROPRIETARIO;
	}

	public String getNOTE() {
		return _NOTE;
	}

	public void setNOTE(String NOTE) {
		_NOTE = NOTE;
	}

	public long getFK_UTENTE_CREAZIONE() {
		return _FK_UTENTE_CREAZIONE;
	}

	public void setFK_UTENTE_CREAZIONE(long FK_UTENTE_CREAZIONE) {
		_FK_UTENTE_CREAZIONE = FK_UTENTE_CREAZIONE;
	}

	public Date getDATA_CREAZIONE() {
		return _DATA_CREAZIONE;
	}

	public void setDATA_CREAZIONE(Date DATA_CREAZIONE) {
		_DATA_CREAZIONE = DATA_CREAZIONE;
	}

	public long getFK_UTENTE_MODIFICA() {
		return _FK_UTENTE_MODIFICA;
	}

	public void setFK_UTENTE_MODIFICA(long FK_UTENTE_MODIFICA) {
		_FK_UTENTE_MODIFICA = FK_UTENTE_MODIFICA;
	}

	public Date getDATA_MODIFICA() {
		return _DATA_MODIFICA;
	}

	public void setDATA_MODIFICA(Date DATA_MODIFICA) {
		_DATA_MODIFICA = DATA_MODIFICA;
	}

	public boolean getDISABLED() {
		return _DISABLED;
	}

	public boolean isDISABLED() {
		return _DISABLED;
	}

	public void setDISABLED(boolean DISABLED) {
		_DISABLED = DISABLED;
	}

	public long getFK_CATEGORIA() {
		return _FK_CATEGORIA;
	}

	public void setFK_CATEGORIA(long FK_CATEGORIA) {
		_FK_CATEGORIA = FK_CATEGORIA;
	}

	private long _ID_GRUPPO;

	private String _NOME;

	private long _FK_SITO_PROPRIETARIO;

	private String _NOTE;

	private long _FK_UTENTE_CREAZIONE;

	private Date _DATA_CREAZIONE;

	private long _FK_UTENTE_MODIFICA;

	private Date _DATA_MODIFICA;

	private boolean _DISABLED;

	private long _FK_CATEGORIA;

}