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

import it.eng.allerte.service.persistence.RubricaGruppoGruppiPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaGruppoGruppiServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaGruppoGruppiSoap implements Serializable {

	public static RubricaGruppoGruppiSoap toSoapModel(
		RubricaGruppoGruppi model) {

		RubricaGruppoGruppiSoap soapModel = new RubricaGruppoGruppiSoap();

		soapModel.setFK_GRUPPO_PADRE(model.getFK_GRUPPO_PADRE());
		soapModel.setFK_GRUPPO_FIGLIO(model.getFK_GRUPPO_FIGLIO());

		return soapModel;
	}

	public static RubricaGruppoGruppiSoap[] toSoapModels(
		RubricaGruppoGruppi[] models) {

		RubricaGruppoGruppiSoap[] soapModels =
			new RubricaGruppoGruppiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaGruppoGruppiSoap[][] toSoapModels(
		RubricaGruppoGruppi[][] models) {

		RubricaGruppoGruppiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RubricaGruppoGruppiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaGruppoGruppiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaGruppoGruppiSoap[] toSoapModels(
		List<RubricaGruppoGruppi> models) {

		List<RubricaGruppoGruppiSoap> soapModels =
			new ArrayList<RubricaGruppoGruppiSoap>(models.size());

		for (RubricaGruppoGruppi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new RubricaGruppoGruppiSoap[soapModels.size()]);
	}

	public RubricaGruppoGruppiSoap() {
	}

	public RubricaGruppoGruppiPK getPrimaryKey() {
		return new RubricaGruppoGruppiPK(_FK_GRUPPO_PADRE, _FK_GRUPPO_FIGLIO);
	}

	public void setPrimaryKey(RubricaGruppoGruppiPK pk) {
		setFK_GRUPPO_PADRE(pk.FK_GRUPPO_PADRE);
		setFK_GRUPPO_FIGLIO(pk.FK_GRUPPO_FIGLIO);
	}

	public long getFK_GRUPPO_PADRE() {
		return _FK_GRUPPO_PADRE;
	}

	public void setFK_GRUPPO_PADRE(long FK_GRUPPO_PADRE) {
		_FK_GRUPPO_PADRE = FK_GRUPPO_PADRE;
	}

	public long getFK_GRUPPO_FIGLIO() {
		return _FK_GRUPPO_FIGLIO;
	}

	public void setFK_GRUPPO_FIGLIO(long FK_GRUPPO_FIGLIO) {
		_FK_GRUPPO_FIGLIO = FK_GRUPPO_FIGLIO;
	}

	private long _FK_GRUPPO_PADRE;

	private long _FK_GRUPPO_FIGLIO;

}