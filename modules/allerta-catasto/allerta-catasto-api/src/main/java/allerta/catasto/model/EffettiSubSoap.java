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

import allerta.catasto.service.persistence.EffettiSubPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link allerta.catasto.service.http.EffettiSubServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EffettiSubSoap implements Serializable {

	public static EffettiSubSoap toSoapModel(EffettiSub model) {
		EffettiSubSoap soapModel = new EffettiSubSoap();

		soapModel.setId(model.getId());
		soapModel.setIdEffetti(model.getIdEffetti());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static EffettiSubSoap[] toSoapModels(EffettiSub[] models) {
		EffettiSubSoap[] soapModels = new EffettiSubSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EffettiSubSoap[][] toSoapModels(EffettiSub[][] models) {
		EffettiSubSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EffettiSubSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EffettiSubSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EffettiSubSoap[] toSoapModels(List<EffettiSub> models) {
		List<EffettiSubSoap> soapModels = new ArrayList<EffettiSubSoap>(
			models.size());

		for (EffettiSub model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EffettiSubSoap[soapModels.size()]);
	}

	public EffettiSubSoap() {
	}

	public EffettiSubPK getPrimaryKey() {
		return new EffettiSubPK(_id, _idEffetti);
	}

	public void setPrimaryKey(EffettiSubPK pk) {
		setId(pk.id);
		setIdEffetti(pk.idEffetti);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getIdEffetti() {
		return _idEffetti;
	}

	public void setIdEffetti(long idEffetti) {
		_idEffetti = idEffetti;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id;
	private long _idEffetti;
	private String _descrizione;

}