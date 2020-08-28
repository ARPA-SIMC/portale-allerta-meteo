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
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.BollettinoParametroServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoParametroSoap implements Serializable {

	public static BollettinoParametroSoap toSoapModel(
		BollettinoParametro model) {

		BollettinoParametroSoap soapModel = new BollettinoParametroSoap();

		soapModel.setParametroId(model.getParametroId());
		soapModel.setValore(model.getValore());

		return soapModel;
	}

	public static BollettinoParametroSoap[] toSoapModels(
		BollettinoParametro[] models) {

		BollettinoParametroSoap[] soapModels =
			new BollettinoParametroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BollettinoParametroSoap[][] toSoapModels(
		BollettinoParametro[][] models) {

		BollettinoParametroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new BollettinoParametroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BollettinoParametroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BollettinoParametroSoap[] toSoapModels(
		List<BollettinoParametro> models) {

		List<BollettinoParametroSoap> soapModels =
			new ArrayList<BollettinoParametroSoap>(models.size());

		for (BollettinoParametro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new BollettinoParametroSoap[soapModels.size()]);
	}

	public BollettinoParametroSoap() {
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