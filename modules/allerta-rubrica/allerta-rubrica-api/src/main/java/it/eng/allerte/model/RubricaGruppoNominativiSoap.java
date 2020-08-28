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

import it.eng.allerte.service.persistence.RubricaGruppoNominativiPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaGruppoNominativiServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaGruppoNominativiSoap implements Serializable {

	public static RubricaGruppoNominativiSoap toSoapModel(
		RubricaGruppoNominativi model) {

		RubricaGruppoNominativiSoap soapModel =
			new RubricaGruppoNominativiSoap();

		soapModel.setFK_GRUPPO(model.getFK_GRUPPO());
		soapModel.setFK_NOMINATIVO(model.getFK_NOMINATIVO());
		soapModel.setFK_RUOLO(model.getFK_RUOLO());
		soapModel.setSPECIFICA_RUOLO(model.getSPECIFICA_RUOLO());

		return soapModel;
	}

	public static RubricaGruppoNominativiSoap[] toSoapModels(
		RubricaGruppoNominativi[] models) {

		RubricaGruppoNominativiSoap[] soapModels =
			new RubricaGruppoNominativiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaGruppoNominativiSoap[][] toSoapModels(
		RubricaGruppoNominativi[][] models) {

		RubricaGruppoNominativiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RubricaGruppoNominativiSoap
					[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaGruppoNominativiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaGruppoNominativiSoap[] toSoapModels(
		List<RubricaGruppoNominativi> models) {

		List<RubricaGruppoNominativiSoap> soapModels =
			new ArrayList<RubricaGruppoNominativiSoap>(models.size());

		for (RubricaGruppoNominativi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new RubricaGruppoNominativiSoap[soapModels.size()]);
	}

	public RubricaGruppoNominativiSoap() {
	}

	public RubricaGruppoNominativiPK getPrimaryKey() {
		return new RubricaGruppoNominativiPK(_FK_GRUPPO, _FK_NOMINATIVO);
	}

	public void setPrimaryKey(RubricaGruppoNominativiPK pk) {
		setFK_GRUPPO(pk.FK_GRUPPO);
		setFK_NOMINATIVO(pk.FK_NOMINATIVO);
	}

	public long getFK_GRUPPO() {
		return _FK_GRUPPO;
	}

	public void setFK_GRUPPO(long FK_GRUPPO) {
		_FK_GRUPPO = FK_GRUPPO;
	}

	public long getFK_NOMINATIVO() {
		return _FK_NOMINATIVO;
	}

	public void setFK_NOMINATIVO(long FK_NOMINATIVO) {
		_FK_NOMINATIVO = FK_NOMINATIVO;
	}

	public long getFK_RUOLO() {
		return _FK_RUOLO;
	}

	public void setFK_RUOLO(long FK_RUOLO) {
		_FK_RUOLO = FK_RUOLO;
	}

	public String getSPECIFICA_RUOLO() {
		return _SPECIFICA_RUOLO;
	}

	public void setSPECIFICA_RUOLO(String SPECIFICA_RUOLO) {
		_SPECIFICA_RUOLO = SPECIFICA_RUOLO;
	}

	private long _FK_GRUPPO;

	private long _FK_NOMINATIVO;

	private long _FK_RUOLO;

	private String _SPECIFICA_RUOLO;

}