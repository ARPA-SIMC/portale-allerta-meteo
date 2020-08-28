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

package it.eng.radarMeteo.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.radarMeteo.service.http.Comuni_wsServiceSoap}.
 *
 * @author Francesco
 * @generated
 */
@ProviderType
public class Comuni_wsSoap implements Serializable {

	public static Comuni_wsSoap toSoapModel(Comuni_ws model) {
		Comuni_wsSoap soapModel = new Comuni_wsSoap();

		soapModel.setIdIstat(model.getIdIstat());
		soapModel.setComune(model.getComune());
		soapModel.setProvincia(model.getProvincia());
		soapModel.setSottozona(model.getSottozona());
		soapModel.setZonaallerta(model.getZonaallerta());

		return soapModel;
	}

	public static Comuni_wsSoap[] toSoapModels(Comuni_ws[] models) {
		Comuni_wsSoap[] soapModels = new Comuni_wsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Comuni_wsSoap[][] toSoapModels(Comuni_ws[][] models) {
		Comuni_wsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Comuni_wsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Comuni_wsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Comuni_wsSoap[] toSoapModels(List<Comuni_ws> models) {
		List<Comuni_wsSoap> soapModels = new ArrayList<Comuni_wsSoap>(
			models.size());

		for (Comuni_ws model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Comuni_wsSoap[soapModels.size()]);
	}

	public Comuni_wsSoap() {
	}

	public String getPrimaryKey() {
		return _idIstat;
	}

	public void setPrimaryKey(String pk) {
		setIdIstat(pk);
	}

	public String getIdIstat() {
		return _idIstat;
	}

	public void setIdIstat(String idIstat) {
		_idIstat = idIstat;
	}

	public String getComune() {
		return _comune;
	}

	public void setComune(String comune) {
		_comune = comune;
	}

	public String getProvincia() {
		return _provincia;
	}

	public void setProvincia(String provincia) {
		_provincia = provincia;
	}

	public String getSottozona() {
		return _sottozona;
	}

	public void setSottozona(String sottozona) {
		_sottozona = sottozona;
	}

	public String getZonaallerta() {
		return _zonaallerta;
	}

	public void setZonaallerta(String zonaallerta) {
		_zonaallerta = zonaallerta;
	}

	private String _idIstat;
	private String _comune;
	private String _provincia;
	private String _sottozona;
	private String _zonaallerta;

}