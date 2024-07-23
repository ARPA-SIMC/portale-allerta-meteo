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
 * This class is used by SOAP remote services, specifically {@link allerta.verifica.service.http.VerificaDatoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class VerificaDatoSoap implements Serializable {

	public static VerificaDatoSoap toSoapModel(VerificaDato model) {
		VerificaDatoSoap soapModel = new VerificaDatoSoap();

		soapModel.setId(model.getId());
		soapModel.setDocumento(model.getDocumento());
		soapModel.setGiorno(model.getGiorno());
		soapModel.setZona(model.getZona());
		soapModel.setEvento(model.getEvento());
		soapModel.setNomeDato(model.getNomeDato());
		soapModel.setProgressivo(model.getProgressivo());
		soapModel.setDatoInserito(model.getDatoInserito());
		soapModel.setDatoCalcolato(model.getDatoCalcolato());

		return soapModel;
	}

	public static VerificaDatoSoap[] toSoapModels(VerificaDato[] models) {
		VerificaDatoSoap[] soapModels = new VerificaDatoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VerificaDatoSoap[][] toSoapModels(VerificaDato[][] models) {
		VerificaDatoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VerificaDatoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VerificaDatoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VerificaDatoSoap[] toSoapModels(List<VerificaDato> models) {
		List<VerificaDatoSoap> soapModels = new ArrayList<VerificaDatoSoap>(
			models.size());

		for (VerificaDato model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VerificaDatoSoap[soapModels.size()]);
	}

	public VerificaDatoSoap() {
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

	public Date getGiorno() {
		return _giorno;
	}

	public void setGiorno(Date giorno) {
		_giorno = giorno;
	}

	public String getZona() {
		return _zona;
	}

	public void setZona(String zona) {
		_zona = zona;
	}

	public long getEvento() {
		return _evento;
	}

	public void setEvento(long evento) {
		_evento = evento;
	}

	public String getNomeDato() {
		return _nomeDato;
	}

	public void setNomeDato(String nomeDato) {
		_nomeDato = nomeDato;
	}

	public int getProgressivo() {
		return _progressivo;
	}

	public void setProgressivo(int progressivo) {
		_progressivo = progressivo;
	}

	public String getDatoInserito() {
		return _datoInserito;
	}

	public void setDatoInserito(String datoInserito) {
		_datoInserito = datoInserito;
	}

	public String getDatoCalcolato() {
		return _datoCalcolato;
	}

	public void setDatoCalcolato(String datoCalcolato) {
		_datoCalcolato = datoCalcolato;
	}

	private long _id;
	private long _documento;
	private Date _giorno;
	private String _zona;
	private long _evento;
	private String _nomeDato;
	private int _progressivo;
	private String _datoInserito;
	private String _datoCalcolato;

}