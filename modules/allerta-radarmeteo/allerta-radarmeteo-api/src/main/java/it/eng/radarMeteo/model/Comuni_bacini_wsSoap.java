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
 * This class is used by SOAP remote services, specifically {@link it.eng.radarMeteo.service.http.Comuni_bacini_wsServiceSoap}.
 *
 * @author Francesco
 * @generated
 */
@ProviderType
public class Comuni_bacini_wsSoap implements Serializable {

	public static Comuni_bacini_wsSoap toSoapModel(Comuni_bacini_ws model) {
		Comuni_bacini_wsSoap soapModel = new Comuni_bacini_wsSoap();

		soapModel.setIdBacini(model.getIdBacini());
		soapModel.setComune(model.getComune());
		soapModel.setProvincia(model.getProvincia());
		soapModel.setBacino(model.getBacino());

		return soapModel;
	}

	public static Comuni_bacini_wsSoap[] toSoapModels(
		Comuni_bacini_ws[] models) {

		Comuni_bacini_wsSoap[] soapModels =
			new Comuni_bacini_wsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Comuni_bacini_wsSoap[][] toSoapModels(
		Comuni_bacini_ws[][] models) {

		Comuni_bacini_wsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new Comuni_bacini_wsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Comuni_bacini_wsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Comuni_bacini_wsSoap[] toSoapModels(
		List<Comuni_bacini_ws> models) {

		List<Comuni_bacini_wsSoap> soapModels =
			new ArrayList<Comuni_bacini_wsSoap>(models.size());

		for (Comuni_bacini_ws model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Comuni_bacini_wsSoap[soapModels.size()]);
	}

	public Comuni_bacini_wsSoap() {
	}

	public int getPrimaryKey() {
		return _idBacini;
	}

	public void setPrimaryKey(int pk) {
		setIdBacini(pk);
	}

	public int getIdBacini() {
		return _idBacini;
	}

	public void setIdBacini(int idBacini) {
		_idBacini = idBacini;
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

	public String getBacino() {
		return _bacino;
	}

	public void setBacino(String bacino) {
		_bacino = bacino;
	}

	private int _idBacini;
	private String _comune;
	private String _provincia;
	private String _bacino;

}