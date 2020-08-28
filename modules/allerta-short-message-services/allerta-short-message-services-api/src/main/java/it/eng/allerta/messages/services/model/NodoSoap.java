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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerta.messages.services.service.http.NodoServiceSoap}.
 *
 * @author Giorgianni_F
 * @generated
 */
@ProviderType
public class NodoSoap implements Serializable {

	public static NodoSoap toSoapModel(Nodo model) {
		NodoSoap soapModel = new NodoSoap();

		soapModel.setId(model.getId());
		soapModel.setIp(model.getIp());
		soapModel.setPorta(model.getPorta());
		soapModel.setNodoConnesso(model.getNodoConnesso());
		soapModel.setDataConnessione(model.getDataConnessione());

		return soapModel;
	}

	public static NodoSoap[] toSoapModels(Nodo[] models) {
		NodoSoap[] soapModels = new NodoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NodoSoap[][] toSoapModels(Nodo[][] models) {
		NodoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NodoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NodoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NodoSoap[] toSoapModels(List<Nodo> models) {
		List<NodoSoap> soapModels = new ArrayList<NodoSoap>(models.size());

		for (Nodo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NodoSoap[soapModels.size()]);
	}

	public NodoSoap() {
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

	public String getNodoConnesso() {
		return _nodoConnesso;
	}

	public void setNodoConnesso(String nodoConnesso) {
		_nodoConnesso = nodoConnesso;
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
	private String _nodoConnesso;
	private Date _dataConnessione;

}