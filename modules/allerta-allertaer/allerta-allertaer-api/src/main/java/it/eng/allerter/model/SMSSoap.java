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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerter.service.http.SMSServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class SMSSoap implements Serializable {

	public static SMSSoap toSoapModel(SMS model) {
		SMSSoap soapModel = new SMSSoap();

		soapModel.setId(model.getId());
		soapModel.setTipo(model.getTipo());
		soapModel.setSottotipo(model.getSottotipo());
		soapModel.setParam(model.getParam());
		soapModel.setTesto(model.getTesto());
		soapModel.setDestinatario(model.getDestinatario());
		soapModel.setNumeroDa(model.getNumeroDa());
		soapModel.setNumero(model.getNumero());
		soapModel.setNomeDestinatario(model.getNomeDestinatario());
		soapModel.setStato(model.getStato());
		soapModel.setDataInvio(model.getDataInvio());
		soapModel.setDataAck(model.getDataAck());
		soapModel.setDataRicevuta(model.getDataRicevuta());
		soapModel.setTentativi(model.getTentativi());
		soapModel.setProssimoInvio(model.getProssimoInvio());
		soapModel.setCodiceErrore(model.getCodiceErrore());
		soapModel.setDescrizioneErrore(model.getDescrizioneErrore());
		soapModel.setTimestamp(model.getTimestamp());

		return soapModel;
	}

	public static SMSSoap[] toSoapModels(SMS[] models) {
		SMSSoap[] soapModels = new SMSSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SMSSoap[][] toSoapModels(SMS[][] models) {
		SMSSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SMSSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SMSSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SMSSoap[] toSoapModels(List<SMS> models) {
		List<SMSSoap> soapModels = new ArrayList<SMSSoap>(models.size());

		for (SMS model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SMSSoap[soapModels.size()]);
	}

	public SMSSoap() {
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

	public String getTesto() {
		return _testo;
	}

	public void setTesto(String testo) {
		_testo = testo;
	}

	public long getDestinatario() {
		return _destinatario;
	}

	public void setDestinatario(long destinatario) {
		_destinatario = destinatario;
	}

	public String getNumeroDa() {
		return _numeroDa;
	}

	public void setNumeroDa(String numeroDa) {
		_numeroDa = numeroDa;
	}

	public String getNumero() {
		return _numero;
	}

	public void setNumero(String numero) {
		_numero = numero;
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

	public Date getDataAck() {
		return _dataAck;
	}

	public void setDataAck(Date dataAck) {
		_dataAck = dataAck;
	}

	public Date getDataRicevuta() {
		return _dataRicevuta;
	}

	public void setDataRicevuta(Date dataRicevuta) {
		_dataRicevuta = dataRicevuta;
	}

	public long getTentativi() {
		return _tentativi;
	}

	public void setTentativi(long tentativi) {
		_tentativi = tentativi;
	}

	public Date getProssimoInvio() {
		return _prossimoInvio;
	}

	public void setProssimoInvio(Date prossimoInvio) {
		_prossimoInvio = prossimoInvio;
	}

	public String getCodiceErrore() {
		return _codiceErrore;
	}

	public void setCodiceErrore(String codiceErrore) {
		_codiceErrore = codiceErrore;
	}

	public String getDescrizioneErrore() {
		return _descrizioneErrore;
	}

	public void setDescrizioneErrore(String descrizioneErrore) {
		_descrizioneErrore = descrizioneErrore;
	}

	public String getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(String timestamp) {
		_timestamp = timestamp;
	}

	private long _id;
	private String _tipo;
	private String _sottotipo;
	private long _param;
	private String _testo;
	private long _destinatario;
	private String _numeroDa;
	private String _numero;
	private String _nomeDestinatario;
	private long _stato;
	private Date _dataInvio;
	private Date _dataAck;
	private Date _dataRicevuta;
	private long _tentativi;
	private Date _prossimoInvio;
	private String _codiceErrore;
	private String _descrizioneErrore;
	private String _timestamp;

}