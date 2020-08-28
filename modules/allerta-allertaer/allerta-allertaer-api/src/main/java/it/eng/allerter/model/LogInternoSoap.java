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

package it.eng.allerter.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerter.service.http.LogInternoServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class LogInternoSoap implements Serializable {

	public static LogInternoSoap toSoapModel(LogInterno model) {
		LogInternoSoap soapModel = new LogInternoSoap();

		soapModel.setLogId(model.getLogId());
		soapModel.setTimestamp(model.getTimestamp());
		soapModel.setThread(model.getThread());
		soapModel.setCosa(model.getCosa());
		soapModel.setDettaglio(model.getDettaglio());
		soapModel.setUtente(model.getUtente());
		soapModel.setRisultato(model.getRisultato());
		soapModel.setEccezione(model.getEccezione());

		return soapModel;
	}

	public static LogInternoSoap[] toSoapModels(LogInterno[] models) {
		LogInternoSoap[] soapModels = new LogInternoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LogInternoSoap[][] toSoapModels(LogInterno[][] models) {
		LogInternoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LogInternoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LogInternoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LogInternoSoap[] toSoapModels(List<LogInterno> models) {
		List<LogInternoSoap> soapModels = new ArrayList<LogInternoSoap>(
			models.size());

		for (LogInterno model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LogInternoSoap[soapModels.size()]);
	}

	public LogInternoSoap() {
	}

	public long getPrimaryKey() {
		return _logId;
	}

	public void setPrimaryKey(long pk) {
		setLogId(pk);
	}

	public long getLogId() {
		return _logId;
	}

	public void setLogId(long logId) {
		_logId = logId;
	}

	public Date getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(Date timestamp) {
		_timestamp = timestamp;
	}

	public String getThread() {
		return _thread;
	}

	public void setThread(String thread) {
		_thread = thread;
	}

	public String getCosa() {
		return _cosa;
	}

	public void setCosa(String cosa) {
		_cosa = cosa;
	}

	public String getDettaglio() {
		return _dettaglio;
	}

	public void setDettaglio(String dettaglio) {
		_dettaglio = dettaglio;
	}

	public String getUtente() {
		return _utente;
	}

	public void setUtente(String utente) {
		_utente = utente;
	}

	public String getRisultato() {
		return _risultato;
	}

	public void setRisultato(String risultato) {
		_risultato = risultato;
	}

	public String getEccezione() {
		return _eccezione;
	}

	public void setEccezione(String eccezione) {
		_eccezione = eccezione;
	}

	private long _logId;
	private Date _timestamp;
	private String _thread;
	private String _cosa;
	private String _dettaglio;
	private String _utente;
	private String _risultato;
	private String _eccezione;

}