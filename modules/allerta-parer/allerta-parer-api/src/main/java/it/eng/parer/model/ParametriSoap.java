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

package it.eng.parer.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class ParametriSoap implements Serializable {

	public static ParametriSoap toSoapModel(Parametri model) {
		ParametriSoap soapModel = new ParametriSoap();

		soapModel.setChiave(model.getChiave());
		soapModel.setValore(model.getValore());

		return soapModel;
	}

	public static ParametriSoap[] toSoapModels(Parametri[] models) {
		ParametriSoap[] soapModels = new ParametriSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ParametriSoap[][] toSoapModels(Parametri[][] models) {
		ParametriSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ParametriSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ParametriSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ParametriSoap[] toSoapModels(List<Parametri> models) {
		List<ParametriSoap> soapModels = new ArrayList<ParametriSoap>(
			models.size());

		for (Parametri model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ParametriSoap[soapModels.size()]);
	}

	public ParametriSoap() {
	}

	public String getPrimaryKey() {
		return _chiave;
	}

	public void setPrimaryKey(String pk) {
		setChiave(pk);
	}

	public String getChiave() {
		return _chiave;
	}

	public void setChiave(String chiave) {
		_chiave = chiave;
	}

	public String getValore() {
		return _valore;
	}

	public void setValore(String valore) {
		_valore = valore;
	}

	private String _chiave;
	private String _valore;

}