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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link allerta.catasto.service.http.EffettiServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EffettiSoap implements Serializable {

	public static EffettiSoap toSoapModel(Effetti model) {
		EffettiSoap soapModel = new EffettiSoap();

		soapModel.setId(model.getId());
		soapModel.setDescrizione(model.getDescrizione());

		return soapModel;
	}

	public static EffettiSoap[] toSoapModels(Effetti[] models) {
		EffettiSoap[] soapModels = new EffettiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EffettiSoap[][] toSoapModels(Effetti[][] models) {
		EffettiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EffettiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EffettiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EffettiSoap[] toSoapModels(List<Effetti> models) {
		List<EffettiSoap> soapModels = new ArrayList<EffettiSoap>(
			models.size());

		for (Effetti model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EffettiSoap[soapModels.size()]);
	}

	public EffettiSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	private long _id;
	private String _descrizione;

}