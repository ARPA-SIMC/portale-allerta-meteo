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

package allerta.catasto.model;

import aQute.bnd.annotation.ProviderType;

import allerta.catasto.service.persistence.SottocategoriaPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link allerta.catasto.service.http.SottocategoriaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SottocategoriaSoap implements Serializable {

	public static SottocategoriaSoap toSoapModel(Sottocategoria model) {
		SottocategoriaSoap soapModel = new SottocategoriaSoap();

		soapModel.setId(model.getId());
		soapModel.setIdCategoria(model.getIdCategoria());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static SottocategoriaSoap[] toSoapModels(Sottocategoria[] models) {
		SottocategoriaSoap[] soapModels = new SottocategoriaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SottocategoriaSoap[][] toSoapModels(
		Sottocategoria[][] models) {

		SottocategoriaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SottocategoriaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SottocategoriaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SottocategoriaSoap[] toSoapModels(
		List<Sottocategoria> models) {

		List<SottocategoriaSoap> soapModels = new ArrayList<SottocategoriaSoap>(
			models.size());

		for (Sottocategoria model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SottocategoriaSoap[soapModels.size()]);
	}

	public SottocategoriaSoap() {
	}

	public SottocategoriaPK getPrimaryKey() {
		return new SottocategoriaPK(_id, _idCategoria);
	}

	public void setPrimaryKey(SottocategoriaPK pk) {
		setId(pk.id);
		setIdCategoria(pk.idCategoria);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getIdCategoria() {
		return _idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		_idCategoria = idCategoria;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id;
	private long _idCategoria;
	private String _descrizione;

}