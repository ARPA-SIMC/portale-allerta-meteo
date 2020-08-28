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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.AllarmeServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AllarmeSoap implements Serializable {

	public static AllarmeSoap toSoapModel(Allarme model) {
		AllarmeSoap soapModel = new AllarmeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAllarmeId(model.getAllarmeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStato(model.getStato());
		soapModel.setIdApprovatore(model.getIdApprovatore());
		soapModel.setDataApprovazione(model.getDataApprovazione());
		soapModel.setIdRegola(model.getIdRegola());
		soapModel.setColore(model.getColore());
		soapModel.setDataInizio(model.getDataInizio());
		soapModel.setDataFine(model.getDataFine());

		return soapModel;
	}

	public static AllarmeSoap[] toSoapModels(Allarme[] models) {
		AllarmeSoap[] soapModels = new AllarmeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AllarmeSoap[][] toSoapModels(Allarme[][] models) {
		AllarmeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AllarmeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AllarmeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AllarmeSoap[] toSoapModels(List<Allarme> models) {
		List<AllarmeSoap> soapModels = new ArrayList<AllarmeSoap>(
			models.size());

		for (Allarme model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AllarmeSoap[soapModels.size()]);
	}

	public AllarmeSoap() {
	}

	public long getPrimaryKey() {
		return _allarmeId;
	}

	public void setPrimaryKey(long pk) {
		setAllarmeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAllarmeId() {
		return _allarmeId;
	}

	public void setAllarmeId(long allarmeId) {
		_allarmeId = allarmeId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStato() {
		return _stato;
	}

	public void setStato(int stato) {
		_stato = stato;
	}

	public long getIdApprovatore() {
		return _idApprovatore;
	}

	public void setIdApprovatore(long idApprovatore) {
		_idApprovatore = idApprovatore;
	}

	public Date getDataApprovazione() {
		return _dataApprovazione;
	}

	public void setDataApprovazione(Date dataApprovazione) {
		_dataApprovazione = dataApprovazione;
	}

	public long getIdRegola() {
		return _idRegola;
	}

	public void setIdRegola(long idRegola) {
		_idRegola = idRegola;
	}

	public int getColore() {
		return _colore;
	}

	public void setColore(int colore) {
		_colore = colore;
	}

	public Date getDataInizio() {
		return _dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		_dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return _dataFine;
	}

	public void setDataFine(Date dataFine) {
		_dataFine = dataFine;
	}

	private String _uuid;
	private long _allarmeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _stato;
	private long _idApprovatore;
	private Date _dataApprovazione;
	private long _idRegola;
	private int _colore;
	private Date _dataInizio;
	private Date _dataFine;

}