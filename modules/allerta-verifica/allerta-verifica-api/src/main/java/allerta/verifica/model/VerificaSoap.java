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
 * This class is used by SOAP remote services, specifically {@link allerta.verifica.service.http.VerificaServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class VerificaSoap implements Serializable {

	public static VerificaSoap toSoapModel(Verifica model) {
		VerificaSoap soapModel = new VerificaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDocumento(model.getDocumento());
		soapModel.setStato(model.getStato());
		soapModel.setTitolo(model.getTitolo());
		soapModel.setFenomeni(model.getFenomeni());
		soapModel.setFenomeniDescritti(model.getFenomeniDescritti());
		soapModel.setNote(model.getNote());
		soapModel.setDataInizio(model.getDataInizio());
		soapModel.setDataFine(model.getDataFine());
		soapModel.setLink(model.getLink());
		soapModel.setHash(model.getHash());

		return soapModel;
	}

	public static VerificaSoap[] toSoapModels(Verifica[] models) {
		VerificaSoap[] soapModels = new VerificaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VerificaSoap[][] toSoapModels(Verifica[][] models) {
		VerificaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VerificaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VerificaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VerificaSoap[] toSoapModels(List<Verifica> models) {
		List<VerificaSoap> soapModels = new ArrayList<VerificaSoap>(
			models.size());

		for (Verifica model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VerificaSoap[soapModels.size()]);
	}

	public VerificaSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	public long getDocumento() {
		return _documento;
	}

	public void setDocumento(long documento) {
		_documento = documento;
	}

	public int getStato() {
		return _stato;
	}

	public void setStato(int stato) {
		_stato = stato;
	}

	public String getTitolo() {
		return _titolo;
	}

	public void setTitolo(String titolo) {
		_titolo = titolo;
	}

	public String getFenomeni() {
		return _fenomeni;
	}

	public void setFenomeni(String fenomeni) {
		_fenomeni = fenomeni;
	}

	public String getFenomeniDescritti() {
		return _fenomeniDescritti;
	}

	public void setFenomeniDescritti(String fenomeniDescritti) {
		_fenomeniDescritti = fenomeniDescritti;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
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

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public String getHash() {
		return _hash;
	}

	public void setHash(String hash) {
		_hash = hash;
	}

	private String _uuid;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _documento;
	private int _stato;
	private String _titolo;
	private String _fenomeni;
	private String _fenomeniDescritti;
	private String _note;
	private Date _dataInizio;
	private Date _dataFine;
	private String _link;
	private String _hash;

}