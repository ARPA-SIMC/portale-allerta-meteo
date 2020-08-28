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

import it.eng.allerter.service.persistence.GeografiaPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerter.service.http.GeografiaServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class GeografiaSoap implements Serializable {

	public static GeografiaSoap toSoapModel(Geografia model) {
		GeografiaSoap soapModel = new GeografiaSoap();

		soapModel.setGeografiaId(model.getGeografiaId());
		soapModel.setTipo(model.getTipo());
		soapModel.setArea(model.getArea());
		soapModel.setComplessita(model.getComplessita());
		soapModel.setGeometria(model.getGeometria());

		return soapModel;
	}

	public static GeografiaSoap[] toSoapModels(Geografia[] models) {
		GeografiaSoap[] soapModels = new GeografiaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeografiaSoap[][] toSoapModels(Geografia[][] models) {
		GeografiaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeografiaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeografiaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeografiaSoap[] toSoapModels(List<Geografia> models) {
		List<GeografiaSoap> soapModels = new ArrayList<GeografiaSoap>(
			models.size());

		for (Geografia model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeografiaSoap[soapModels.size()]);
	}

	public GeografiaSoap() {
	}

	public GeografiaPK getPrimaryKey() {
		return new GeografiaPK(_geografiaId, _tipo, _area, _complessita);
	}

	public void setPrimaryKey(GeografiaPK pk) {
		setGeografiaId(pk.geografiaId);
		setTipo(pk.tipo);
		setArea(pk.area);
		setComplessita(pk.complessita);
	}

	public String getGeografiaId() {
		return _geografiaId;
	}

	public void setGeografiaId(String geografiaId) {
		_geografiaId = geografiaId;
	}

	public String getTipo() {
		return _tipo;
	}

	public void setTipo(String tipo) {
		_tipo = tipo;
	}

	public String getArea() {
		return _area;
	}

	public void setArea(String area) {
		_area = area;
	}

	public String getComplessita() {
		return _complessita;
	}

	public void setComplessita(String complessita) {
		_complessita = complessita;
	}

	public String getGeometria() {
		return _geometria;
	}

	public void setGeometria(String geometria) {
		_geometria = geometria;
	}

	private String _geografiaId;
	private String _tipo;
	private String _area;
	private String _complessita;
	private String _geometria;

}