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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaLogServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaLogSoap implements Serializable {

	public static RubricaLogSoap toSoapModel(RubricaLog model) {
		RubricaLogSoap soapModel = new RubricaLogSoap();

		soapModel.setID_LOG(model.getID_LOG());
		soapModel.setFK_SITO_PROPRIETARIO(model.getFK_SITO_PROPRIETARIO());
		soapModel.setTABELLA(model.getTABELLA());
		soapModel.setTIPO_OPERAZIONE(model.getTIPO_OPERAZIONE());
		soapModel.setID_OGGETTO(model.getID_OGGETTO());
		soapModel.setNUOVA_DESCRIZIONE(model.getNUOVA_DESCRIZIONE());
		soapModel.setFK_UTENTE_MODIFICA(model.getFK_UTENTE_MODIFICA());
		soapModel.setDATA_MODIFICA(model.getDATA_MODIFICA());

		return soapModel;
	}

	public static RubricaLogSoap[] toSoapModels(RubricaLog[] models) {
		RubricaLogSoap[] soapModels = new RubricaLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaLogSoap[][] toSoapModels(RubricaLog[][] models) {
		RubricaLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RubricaLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaLogSoap[] toSoapModels(List<RubricaLog> models) {
		List<RubricaLogSoap> soapModels = new ArrayList<RubricaLogSoap>(
			models.size());

		for (RubricaLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RubricaLogSoap[soapModels.size()]);
	}

	public RubricaLogSoap() {
	}

	public long getPrimaryKey() {
		return _ID_LOG;
	}

	public void setPrimaryKey(long pk) {
		setID_LOG(pk);
	}

	public long getID_LOG() {
		return _ID_LOG;
	}

	public void setID_LOG(long ID_LOG) {
		_ID_LOG = ID_LOG;
	}

	public long getFK_SITO_PROPRIETARIO() {
		return _FK_SITO_PROPRIETARIO;
	}

	public void setFK_SITO_PROPRIETARIO(long FK_SITO_PROPRIETARIO) {
		_FK_SITO_PROPRIETARIO = FK_SITO_PROPRIETARIO;
	}

	public String getTABELLA() {
		return _TABELLA;
	}

	public void setTABELLA(String TABELLA) {
		_TABELLA = TABELLA;
	}

	public String getTIPO_OPERAZIONE() {
		return _TIPO_OPERAZIONE;
	}

	public void setTIPO_OPERAZIONE(String TIPO_OPERAZIONE) {
		_TIPO_OPERAZIONE = TIPO_OPERAZIONE;
	}

	public String getID_OGGETTO() {
		return _ID_OGGETTO;
	}

	public void setID_OGGETTO(String ID_OGGETTO) {
		_ID_OGGETTO = ID_OGGETTO;
	}

	public String getNUOVA_DESCRIZIONE() {
		return _NUOVA_DESCRIZIONE;
	}

	public void setNUOVA_DESCRIZIONE(String NUOVA_DESCRIZIONE) {
		_NUOVA_DESCRIZIONE = NUOVA_DESCRIZIONE;
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

	private long _ID_LOG;

	private long _FK_SITO_PROPRIETARIO;

	private String _TABELLA;

	private String _TIPO_OPERAZIONE;

	private String _ID_OGGETTO;

	private String _NUOVA_DESCRIZIONE;

	private long _FK_UTENTE_MODIFICA;

	private Date _DATA_MODIFICA;

}