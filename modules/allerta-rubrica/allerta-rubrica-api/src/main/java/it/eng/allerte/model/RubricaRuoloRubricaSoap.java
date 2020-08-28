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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaRuoloRubricaServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaRuoloRubricaSoap implements Serializable {

	public static RubricaRuoloRubricaSoap toSoapModel(
		RubricaRuoloRubrica model) {

		RubricaRuoloRubricaSoap soapModel = new RubricaRuoloRubricaSoap();

		soapModel.setID_RUOLO(model.getID_RUOLO());
		soapModel.setDESCRIZIONE(model.getDESCRIZIONE());

		return soapModel;
	}

	public static RubricaRuoloRubricaSoap[] toSoapModels(
		RubricaRuoloRubrica[] models) {

		RubricaRuoloRubricaSoap[] soapModels =
			new RubricaRuoloRubricaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaRuoloRubricaSoap[][] toSoapModels(
		RubricaRuoloRubrica[][] models) {

		RubricaRuoloRubricaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RubricaRuoloRubricaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaRuoloRubricaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaRuoloRubricaSoap[] toSoapModels(
		List<RubricaRuoloRubrica> models) {

		List<RubricaRuoloRubricaSoap> soapModels =
			new ArrayList<RubricaRuoloRubricaSoap>(models.size());

		for (RubricaRuoloRubrica model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new RubricaRuoloRubricaSoap[soapModels.size()]);
	}

	public RubricaRuoloRubricaSoap() {
	}

	public long getPrimaryKey() {
		return _ID_RUOLO;
	}

	public void setPrimaryKey(long pk) {
		setID_RUOLO(pk);
	}

	public long getID_RUOLO() {
		return _ID_RUOLO;
	}

	public void setID_RUOLO(long ID_RUOLO) {
		_ID_RUOLO = ID_RUOLO;
	}

	public String getDESCRIZIONE() {
		return _DESCRIZIONE;
	}

	public void setDESCRIZIONE(String DESCRIZIONE) {
		_DESCRIZIONE = DESCRIZIONE;
	}

	private long _ID_RUOLO;

	private String _DESCRIZIONE;

}