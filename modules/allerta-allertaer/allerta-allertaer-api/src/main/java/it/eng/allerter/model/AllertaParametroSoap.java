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

package it.eng.allerter.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerter.service.http.AllertaParametroServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AllertaParametroSoap implements Serializable {

	public static AllertaParametroSoap toSoapModel(AllertaParametro model) {
		AllertaParametroSoap soapModel = new AllertaParametroSoap();

		soapModel.setParametroId(model.getParametroId());
		soapModel.setValore(model.getValore());

		return soapModel;
	}

	public static AllertaParametroSoap[] toSoapModels(
		AllertaParametro[] models) {

		AllertaParametroSoap[] soapModels =
			new AllertaParametroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AllertaParametroSoap[][] toSoapModels(
		AllertaParametro[][] models) {

		AllertaParametroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AllertaParametroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AllertaParametroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AllertaParametroSoap[] toSoapModels(
		List<AllertaParametro> models) {

		List<AllertaParametroSoap> soapModels =
			new ArrayList<AllertaParametroSoap>(models.size());

		for (AllertaParametro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AllertaParametroSoap[soapModels.size()]);
	}

	public AllertaParametroSoap() {
	}

	public String getPrimaryKey() {
		return _parametroId;
	}

	public void setPrimaryKey(String pk) {
		setParametroId(pk);
	}

	public String getParametroId() {
		return _parametroId;
	}

	public void setParametroId(String parametroId) {
		_parametroId = parametroId;
	}

	public String getValore() {
		return _valore;
	}

	public void setValore(String valore) {
		_valore = valore;
	}

	private String _parametroId;
	private String _valore;

}