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

package it.eng.allerta.messages.services.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerta.messages.services.service.http.ParametroServiceSoap}.
 *
 * @author Giorgianni_F
 * @generated
 */
@ProviderType
public class ParametroSoap implements Serializable {

	public static ParametroSoap toSoapModel(Parametro model) {
		ParametroSoap soapModel = new ParametroSoap();

		soapModel.setId(model.getId());
		soapModel.setIp(model.getIp());
		soapModel.setPorta(model.getPorta());
		soapModel.setUsername(model.getUsername());
		soapModel.setPassword(model.getPassword());
		soapModel.setMittente(model.getMittente());
		soapModel.setNodo(model.getNodo());
		soapModel.setDataConnessione(model.getDataConnessione());

		return soapModel;
	}

	public static ParametroSoap[] toSoapModels(Parametro[] models) {
		ParametroSoap[] soapModels = new ParametroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ParametroSoap[][] toSoapModels(Parametro[][] models) {
		ParametroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ParametroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ParametroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ParametroSoap[] toSoapModels(List<Parametro> models) {
		List<ParametroSoap> soapModels = new ArrayList<ParametroSoap>(
			models.size());

		for (Parametro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ParametroSoap[soapModels.size()]);
	}

	public ParametroSoap() {
	}

	public long getPrimaryKey() {
		return _Id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _Id;
	}

	public void setId(long Id) {
		_Id = Id;
	}

	public String getIp() {
		return _ip;
	}

	public void setIp(String ip) {
		_ip = ip;
	}

	public int getPorta() {
		return _porta;
	}

	public void setPorta(int porta) {
		_porta = porta;
	}

	public String getUsername() {
		return _username;
	}

	public void setUsername(String username) {
		_username = username;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getMittente() {
		return _mittente;
	}

	public void setMittente(String mittente) {
		_mittente = mittente;
	}

	public String getNodo() {
		return _nodo;
	}

	public void setNodo(String nodo) {
		_nodo = nodo;
	}

	public Date getDataConnessione() {
		return _dataConnessione;
	}

	public void setDataConnessione(Date dataConnessione) {
		_dataConnessione = dataConnessione;
	}

	private long _Id;
	private String _ip;
	private int _porta;
	private String _username;
	private String _password;
	private String _mittente;
	private String _nodo;
	private Date _dataConnessione;

}