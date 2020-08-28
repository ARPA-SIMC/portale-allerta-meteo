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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerta.messages.services.service.http.CounterSmsServiceSoap}.
 *
 * @author Giorgianni_F
 * @generated
 */
@ProviderType
public class CounterSmsSoap implements Serializable {

	public static CounterSmsSoap toSoapModel(CounterSms model) {
		CounterSmsSoap soapModel = new CounterSmsSoap();

		soapModel.setCounterId(model.getCounterId());
		soapModel.setDate(model.getDate());
		soapModel.setNumerosms(model.getNumerosms());
		soapModel.setNodo(model.getNodo());

		return soapModel;
	}

	public static CounterSmsSoap[] toSoapModels(CounterSms[] models) {
		CounterSmsSoap[] soapModels = new CounterSmsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CounterSmsSoap[][] toSoapModels(CounterSms[][] models) {
		CounterSmsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CounterSmsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CounterSmsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CounterSmsSoap[] toSoapModels(List<CounterSms> models) {
		List<CounterSmsSoap> soapModels = new ArrayList<CounterSmsSoap>(
			models.size());

		for (CounterSms model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CounterSmsSoap[soapModels.size()]);
	}

	public CounterSmsSoap() {
	}

	public long getPrimaryKey() {
		return _counterId;
	}

	public void setPrimaryKey(long pk) {
		setCounterId(pk);
	}

	public long getCounterId() {
		return _counterId;
	}

	public void setCounterId(long counterId) {
		_counterId = counterId;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public int getNumerosms() {
		return _numerosms;
	}

	public void setNumerosms(int numerosms) {
		_numerosms = numerosms;
	}

	public String getNodo() {
		return _nodo;
	}

	public void setNodo(String nodo) {
		_nodo = nodo;
	}

	private long _counterId;
	private Date _date;
	private int _numerosms;
	private String _nodo;

}