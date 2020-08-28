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

package it.eng.animazione.image.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author UTENTE
 * @generated
 */
@ProviderType
public class PioggiaCumulativaSoap implements Serializable {

	public static PioggiaCumulativaSoap toSoapModel(PioggiaCumulativa model) {
		PioggiaCumulativaSoap soapModel = new PioggiaCumulativaSoap();

		soapModel.setId(model.getId());
		soapModel.setNome(model.getNome());
		soapModel.setCumulazione(model.getCumulazione());
		soapModel.setInzioCumulazione(model.getInzioCumulazione());
		soapModel.setFineCumulazione(model.getFineCumulazione());
		soapModel.setImgData(model.getImgData());

		return soapModel;
	}

	public static PioggiaCumulativaSoap[] toSoapModels(
		PioggiaCumulativa[] models) {

		PioggiaCumulativaSoap[] soapModels =
			new PioggiaCumulativaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PioggiaCumulativaSoap[][] toSoapModels(
		PioggiaCumulativa[][] models) {

		PioggiaCumulativaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PioggiaCumulativaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PioggiaCumulativaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PioggiaCumulativaSoap[] toSoapModels(
		List<PioggiaCumulativa> models) {

		List<PioggiaCumulativaSoap> soapModels =
			new ArrayList<PioggiaCumulativaSoap>(models.size());

		for (PioggiaCumulativa model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PioggiaCumulativaSoap[soapModels.size()]);
	}

	public PioggiaCumulativaSoap() {
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

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getCumulazione() {
		return _cumulazione;
	}

	public void setCumulazione(String cumulazione) {
		_cumulazione = cumulazione;
	}

	public Date getInzioCumulazione() {
		return _inzioCumulazione;
	}

	public void setInzioCumulazione(Date inzioCumulazione) {
		_inzioCumulazione = inzioCumulazione;
	}

	public Date getFineCumulazione() {
		return _fineCumulazione;
	}

	public void setFineCumulazione(Date fineCumulazione) {
		_fineCumulazione = fineCumulazione;
	}

	public String getImgData() {
		return _imgData;
	}

	public void setImgData(String imgData) {
		_imgData = imgData;
	}

	private long _id;
	private String _nome;
	private String _cumulazione;
	private Date _inzioCumulazione;
	private Date _fineCumulazione;
	private String _imgData;

}