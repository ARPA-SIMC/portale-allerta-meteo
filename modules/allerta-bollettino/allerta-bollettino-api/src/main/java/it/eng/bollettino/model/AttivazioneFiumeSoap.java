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

package it.eng.bollettino.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.AttivazioneFiumeServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AttivazioneFiumeSoap implements Serializable {

	public static AttivazioneFiumeSoap toSoapModel(AttivazioneFiume model) {
		AttivazioneFiumeSoap soapModel = new AttivazioneFiumeSoap();

		soapModel.setFiumeId(model.getFiumeId());
		soapModel.setAttivo(model.isAttivo());

		return soapModel;
	}

	public static AttivazioneFiumeSoap[] toSoapModels(
		AttivazioneFiume[] models) {

		AttivazioneFiumeSoap[] soapModels =
			new AttivazioneFiumeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttivazioneFiumeSoap[][] toSoapModels(
		AttivazioneFiume[][] models) {

		AttivazioneFiumeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AttivazioneFiumeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttivazioneFiumeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttivazioneFiumeSoap[] toSoapModels(
		List<AttivazioneFiume> models) {

		List<AttivazioneFiumeSoap> soapModels =
			new ArrayList<AttivazioneFiumeSoap>(models.size());

		for (AttivazioneFiume model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AttivazioneFiumeSoap[soapModels.size()]);
	}

	public AttivazioneFiumeSoap() {
	}

	public String getPrimaryKey() {
		return _fiumeId;
	}

	public void setPrimaryKey(String pk) {
		setFiumeId(pk);
	}

	public String getFiumeId() {
		return _fiumeId;
	}

	public void setFiumeId(String fiumeId) {
		_fiumeId = fiumeId;
	}

	public boolean getAttivo() {
		return _attivo;
	}

	public boolean isAttivo() {
		return _attivo;
	}

	public void setAttivo(boolean attivo) {
		_attivo = attivo;
	}

	private String _fiumeId;
	private boolean _attivo;

}