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

import it.eng.allerte.service.persistence.RubricaRuoloPermessiPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaRuoloPermessiServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaRuoloPermessiSoap implements Serializable {

	public static RubricaRuoloPermessiSoap toSoapModel(
		RubricaRuoloPermessi model) {

		RubricaRuoloPermessiSoap soapModel = new RubricaRuoloPermessiSoap();

		soapModel.setFK_ID_RUOLO(model.getFK_ID_RUOLO());
		soapModel.setFK_ID_PERMESSO(model.getFK_ID_PERMESSO());

		return soapModel;
	}

	public static RubricaRuoloPermessiSoap[] toSoapModels(
		RubricaRuoloPermessi[] models) {

		RubricaRuoloPermessiSoap[] soapModels =
			new RubricaRuoloPermessiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaRuoloPermessiSoap[][] toSoapModels(
		RubricaRuoloPermessi[][] models) {

		RubricaRuoloPermessiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RubricaRuoloPermessiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaRuoloPermessiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaRuoloPermessiSoap[] toSoapModels(
		List<RubricaRuoloPermessi> models) {

		List<RubricaRuoloPermessiSoap> soapModels =
			new ArrayList<RubricaRuoloPermessiSoap>(models.size());

		for (RubricaRuoloPermessi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new RubricaRuoloPermessiSoap[soapModels.size()]);
	}

	public RubricaRuoloPermessiSoap() {
	}

	public RubricaRuoloPermessiPK getPrimaryKey() {
		return new RubricaRuoloPermessiPK(_FK_ID_RUOLO, _FK_ID_PERMESSO);
	}

	public void setPrimaryKey(RubricaRuoloPermessiPK pk) {
		setFK_ID_RUOLO(pk.FK_ID_RUOLO);
		setFK_ID_PERMESSO(pk.FK_ID_PERMESSO);
	}

	public long getFK_ID_RUOLO() {
		return _FK_ID_RUOLO;
	}

	public void setFK_ID_RUOLO(long FK_ID_RUOLO) {
		_FK_ID_RUOLO = FK_ID_RUOLO;
	}

	public String getFK_ID_PERMESSO() {
		return _FK_ID_PERMESSO;
	}

	public void setFK_ID_PERMESSO(String FK_ID_PERMESSO) {
		_FK_ID_PERMESSO = FK_ID_PERMESSO;
	}

	private long _FK_ID_RUOLO;

	private String _FK_ID_PERMESSO;

}