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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerte.service.http.RubricaPermessiServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class RubricaPermessiSoap implements Serializable {

	public static RubricaPermessiSoap toSoapModel(RubricaPermessi model) {
		RubricaPermessiSoap soapModel = new RubricaPermessiSoap();

		soapModel.setID_PERMESSO(model.getID_PERMESSO());
		soapModel.setNOME_PERMESSO(model.getNOME_PERMESSO());

		return soapModel;
	}

	public static RubricaPermessiSoap[] toSoapModels(RubricaPermessi[] models) {
		RubricaPermessiSoap[] soapModels =
			new RubricaPermessiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RubricaPermessiSoap[][] toSoapModels(
		RubricaPermessi[][] models) {

		RubricaPermessiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RubricaPermessiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RubricaPermessiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RubricaPermessiSoap[] toSoapModels(
		List<RubricaPermessi> models) {

		List<RubricaPermessiSoap> soapModels =
			new ArrayList<RubricaPermessiSoap>(models.size());

		for (RubricaPermessi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RubricaPermessiSoap[soapModels.size()]);
	}

	public RubricaPermessiSoap() {
	}

	public String getPrimaryKey() {
		return _ID_PERMESSO;
	}

	public void setPrimaryKey(String pk) {
		setID_PERMESSO(pk);
	}

	public String getID_PERMESSO() {
		return _ID_PERMESSO;
	}

	public void setID_PERMESSO(String ID_PERMESSO) {
		_ID_PERMESSO = ID_PERMESSO;
	}

	public String getNOME_PERMESSO() {
		return _NOME_PERMESSO;
	}

	public void setNOME_PERMESSO(String NOME_PERMESSO) {
		_NOME_PERMESSO = NOME_PERMESSO;
	}

	private String _ID_PERMESSO;

	private String _NOME_PERMESSO;

}