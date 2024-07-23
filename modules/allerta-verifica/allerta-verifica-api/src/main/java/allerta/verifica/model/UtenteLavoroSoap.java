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

package allerta.verifica.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link allerta.verifica.service.http.UtenteLavoroServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class UtenteLavoroSoap implements Serializable {

	public static UtenteLavoroSoap toSoapModel(UtenteLavoro model) {
		UtenteLavoroSoap soapModel = new UtenteLavoroSoap();

		soapModel.setId(model.getId());
		soapModel.setDocumento(model.getDocumento());
		soapModel.setUtente(model.getUtente());
		soapModel.setTs(model.getTs());
		soapModel.setAttivita(model.getAttivita());

		return soapModel;
	}

	public static UtenteLavoroSoap[] toSoapModels(UtenteLavoro[] models) {
		UtenteLavoroSoap[] soapModels = new UtenteLavoroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UtenteLavoroSoap[][] toSoapModels(UtenteLavoro[][] models) {
		UtenteLavoroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UtenteLavoroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UtenteLavoroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UtenteLavoroSoap[] toSoapModels(List<UtenteLavoro> models) {
		List<UtenteLavoroSoap> soapModels = new ArrayList<UtenteLavoroSoap>(
			models.size());

		for (UtenteLavoro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UtenteLavoroSoap[soapModels.size()]);
	}

	public UtenteLavoroSoap() {
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

	public long getDocumento() {
		return _documento;
	}

	public void setDocumento(long documento) {
		_documento = documento;
	}

	public String getUtente() {
		return _utente;
	}

	public void setUtente(String utente) {
		_utente = utente;
	}

	public Date getTs() {
		return _ts;
	}

	public void setTs(Date ts) {
		_ts = ts;
	}

	public String getAttivita() {
		return _attivita;
	}

	public void setAttivita(String attivita) {
		_attivita = attivita;
	}

	private long _id;
	private long _documento;
	private String _utente;
	private Date _ts;
	private String _attivita;

}