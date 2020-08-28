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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerter.service.http.EmailServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class EmailSoap implements Serializable {

	public static EmailSoap toSoapModel(Email model) {
		EmailSoap soapModel = new EmailSoap();

		soapModel.setId(model.getId());
		soapModel.setTipo(model.getTipo());
		soapModel.setSottotipo(model.getSottotipo());
		soapModel.setParam(model.getParam());
		soapModel.setDestinatario(model.getDestinatario());
		soapModel.setIndirizzo(model.getIndirizzo());
		soapModel.setNomeDestinatario(model.getNomeDestinatario());
		soapModel.setStato(model.getStato());
		soapModel.setDataInvio(model.getDataInvio());
		soapModel.setTesto(model.getTesto());
		soapModel.setOggetto(model.getOggetto());

		return soapModel;
	}

	public static EmailSoap[] toSoapModels(Email[] models) {
		EmailSoap[] soapModels = new EmailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmailSoap[][] toSoapModels(Email[][] models) {
		EmailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmailSoap[] toSoapModels(List<Email> models) {
		List<EmailSoap> soapModels = new ArrayList<EmailSoap>(models.size());

		for (Email model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmailSoap[soapModels.size()]);
	}

	public EmailSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getTipo() {
		return _tipo;
	}

	public void setTipo(String tipo) {
		_tipo = tipo;
	}

	public String getSottotipo() {
		return _sottotipo;
	}

	public void setSottotipo(String sottotipo) {
		_sottotipo = sottotipo;
	}

	public long getParam() {
		return _param;
	}

	public void setParam(long param) {
		_param = param;
	}

	public long getDestinatario() {
		return _destinatario;
	}

	public void setDestinatario(long destinatario) {
		_destinatario = destinatario;
	}

	public String getIndirizzo() {
		return _indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		_indirizzo = indirizzo;
	}

	public String getNomeDestinatario() {
		return _nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		_nomeDestinatario = nomeDestinatario;
	}

	public long getStato() {
		return _stato;
	}

	public void setStato(long stato) {
		_stato = stato;
	}

	public Date getDataInvio() {
		return _dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		_dataInvio = dataInvio;
	}

	public String getTesto() {
		return _testo;
	}

	public void setTesto(String testo) {
		_testo = testo;
	}

	public String getOggetto() {
		return _oggetto;
	}

	public void setOggetto(String oggetto) {
		_oggetto = oggetto;
	}

	private long _id;
	private String _tipo;
	private String _sottotipo;
	private long _param;
	private long _destinatario;
	private String _indirizzo;
	private String _nomeDestinatario;
	private long _stato;
	private Date _dataInvio;
	private String _testo;
	private String _oggetto;

}