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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaContattoServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaContattoSoap implements Serializable {

	public static RubricaContattoSoap toSoapModel(RubricaContatto model) {
		RubricaContattoSoap soapModel = new RubricaContattoSoap();

		soapModel.setID_CONTATTO(model.getID_CONTATTO());
		soapModel.setFK_NOMINATIVO(model.getFK_NOMINATIVO());
		soapModel.setFK_CANALE(model.getFK_CANALE());
		soapModel.setCONTATTO(model.getCONTATTO());
		soapModel.setALLERTAMENTO(model.isALLERTAMENTO());
		soapModel.setFK_UTENTE_CREAZIONE(model.getFK_UTENTE_CREAZIONE());
		soapModel.setDATA_CREAZIONE(model.getDATA_CREAZIONE());
		soapModel.setFK_UTENTE_MODIFICA(model.getFK_UTENTE_MODIFICA());
		soapModel.setDATA_MODIFICA(model.getDATA_MODIFICA());
		soapModel.setDATA_FINE_VALIDITA(model.getDATA_FINE_VALIDITA());
		soapModel.setMODIFICA_MINORE(model.isMODIFICA_MINORE());

		return soapModel;
	}

	public static RubricaContattoSoap[] toSoapModels(RubricaContatto[] models) {
		RubricaContattoSoap[] soapModels =
			new RubricaContattoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaContattoSoap[][] toSoapModels(
		RubricaContatto[][] models) {

		RubricaContattoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RubricaContattoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaContattoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaContattoSoap[] toSoapModels(
		List<RubricaContatto> models) {

		List<RubricaContattoSoap> soapModels =
			new ArrayList<RubricaContattoSoap>(models.size());

		for (RubricaContatto model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RubricaContattoSoap[soapModels.size()]);
	}

	public RubricaContattoSoap() {
	}

	public long getPrimaryKey() {
		return _ID_CONTATTO;
	}

	public void setPrimaryKey(long pk) {
		setID_CONTATTO(pk);
	}

	public long getID_CONTATTO() {
		return _ID_CONTATTO;
	}

	public void setID_CONTATTO(long ID_CONTATTO) {
		_ID_CONTATTO = ID_CONTATTO;
	}

	public long getFK_NOMINATIVO() {
		return _FK_NOMINATIVO;
	}

	public void setFK_NOMINATIVO(long FK_NOMINATIVO) {
		_FK_NOMINATIVO = FK_NOMINATIVO;
	}

	public long getFK_CANALE() {
		return _FK_CANALE;
	}

	public void setFK_CANALE(long FK_CANALE) {
		_FK_CANALE = FK_CANALE;
	}

	public String getCONTATTO() {
		return _CONTATTO;
	}

	public void setCONTATTO(String CONTATTO) {
		_CONTATTO = CONTATTO;
	}

	public boolean getALLERTAMENTO() {
		return _ALLERTAMENTO;
	}

	public boolean isALLERTAMENTO() {
		return _ALLERTAMENTO;
	}

	public void setALLERTAMENTO(boolean ALLERTAMENTO) {
		_ALLERTAMENTO = ALLERTAMENTO;
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

	public Date getDATA_FINE_VALIDITA() {
		return _DATA_FINE_VALIDITA;
	}

	public void setDATA_FINE_VALIDITA(Date DATA_FINE_VALIDITA) {
		_DATA_FINE_VALIDITA = DATA_FINE_VALIDITA;
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

	private long _ID_CONTATTO;

	private long _FK_NOMINATIVO;

	private long _FK_CANALE;

	private String _CONTATTO;

	private boolean _ALLERTAMENTO;

	private long _FK_UTENTE_CREAZIONE;

	private Date _DATA_CREAZIONE;

	private long _FK_UTENTE_MODIFICA;

	private Date _DATA_MODIFICA;

	private Date _DATA_FINE_VALIDITA;

	private boolean _MODIFICA_MINORE;

}