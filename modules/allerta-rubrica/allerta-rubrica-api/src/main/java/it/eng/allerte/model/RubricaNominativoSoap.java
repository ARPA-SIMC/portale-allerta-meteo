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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaNominativoServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaNominativoSoap implements Serializable {

	public static RubricaNominativoSoap toSoapModel(RubricaNominativo model) {
		RubricaNominativoSoap soapModel = new RubricaNominativoSoap();

		soapModel.setID_NOMINATIVO(model.getID_NOMINATIVO());
		soapModel.setCOGNOME(model.getCOGNOME());
		soapModel.setNOME(model.getNOME());
		soapModel.setINDIRIZZO(model.getINDIRIZZO());
		soapModel.setFK_SITO_PROPRIETARIO(model.getFK_SITO_PROPRIETARIO());
		soapModel.setFK_UTENTE_PORTALE(model.getFK_UTENTE_PORTALE());
		soapModel.setFK_UTENTE_CREAZIONE(model.getFK_UTENTE_CREAZIONE());
		soapModel.setDATA_CREAZIONE(model.getDATA_CREAZIONE());
		soapModel.setFK_UTENTE_MODIFICA(model.getFK_UTENTE_MODIFICA());
		soapModel.setDATA_MODIFICA(model.getDATA_MODIFICA());
		soapModel.setDISABLED(model.isDISABLED());
		soapModel.setMODIFICA_MINORE(model.isMODIFICA_MINORE());

		return soapModel;
	}

	public static RubricaNominativoSoap[] toSoapModels(
		RubricaNominativo[] models) {

		RubricaNominativoSoap[] soapModels =
			new RubricaNominativoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaNominativoSoap[][] toSoapModels(
		RubricaNominativo[][] models) {

		RubricaNominativoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RubricaNominativoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaNominativoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaNominativoSoap[] toSoapModels(
		List<RubricaNominativo> models) {

		List<RubricaNominativoSoap> soapModels =
			new ArrayList<RubricaNominativoSoap>(models.size());

		for (RubricaNominativo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RubricaNominativoSoap[soapModels.size()]);
	}

	public RubricaNominativoSoap() {
	}

	public long getPrimaryKey() {
		return _ID_NOMINATIVO;
	}

	public void setPrimaryKey(long pk) {
		setID_NOMINATIVO(pk);
	}

	public long getID_NOMINATIVO() {
		return _ID_NOMINATIVO;
	}

	public void setID_NOMINATIVO(long ID_NOMINATIVO) {
		_ID_NOMINATIVO = ID_NOMINATIVO;
	}

	public String getCOGNOME() {
		return _COGNOME;
	}

	public void setCOGNOME(String COGNOME) {
		_COGNOME = COGNOME;
	}

	public String getNOME() {
		return _NOME;
	}

	public void setNOME(String NOME) {
		_NOME = NOME;
	}

	public String getINDIRIZZO() {
		return _INDIRIZZO;
	}

	public void setINDIRIZZO(String INDIRIZZO) {
		_INDIRIZZO = INDIRIZZO;
	}

	public long getFK_SITO_PROPRIETARIO() {
		return _FK_SITO_PROPRIETARIO;
	}

	public void setFK_SITO_PROPRIETARIO(long FK_SITO_PROPRIETARIO) {
		_FK_SITO_PROPRIETARIO = FK_SITO_PROPRIETARIO;
	}

	public long getFK_UTENTE_PORTALE() {
		return _FK_UTENTE_PORTALE;
	}

	public void setFK_UTENTE_PORTALE(long FK_UTENTE_PORTALE) {
		_FK_UTENTE_PORTALE = FK_UTENTE_PORTALE;
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

	public boolean getMODIFICA_MINORE() {
		return _MODIFICA_MINORE;
	}

	public boolean isMODIFICA_MINORE() {
		return _MODIFICA_MINORE;
	}

	public void setMODIFICA_MINORE(boolean MODIFICA_MINORE) {
		_MODIFICA_MINORE = MODIFICA_MINORE;
	}

	private long _ID_NOMINATIVO;

	private String _COGNOME;

	private String _NOME;

	private String _INDIRIZZO;

	private long _FK_SITO_PROPRIETARIO;

	private long _FK_UTENTE_PORTALE;

	private long _FK_UTENTE_CREAZIONE;

	private Date _DATA_CREAZIONE;

	private long _FK_UTENTE_MODIFICA;

	private Date _DATA_MODIFICA;

	private boolean _DISABLED;

	private boolean _MODIFICA_MINORE;

}