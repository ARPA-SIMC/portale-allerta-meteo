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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerter.service.http.TipoEventoServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class TipoEventoSoap implements Serializable {

	public static TipoEventoSoap toSoapModel(TipoEvento model) {
		TipoEventoSoap soapModel = new TipoEventoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEventoId(model.getEventoId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNome(model.getNome());
		soapModel.setIndice(model.getIndice());
		soapModel.setTabella(model.getTabella());
		soapModel.setSplit(model.isSplit());
		soapModel.setCostiero(model.isCostiero());
		soapModel.setDataInizio(model.getDataInizio());
		soapModel.setDataFine(model.getDataFine());
		soapModel.setParentId(model.getParentId());

		return soapModel;
	}

	public static TipoEventoSoap[] toSoapModels(TipoEvento[] models) {
		TipoEventoSoap[] soapModels = new TipoEventoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TipoEventoSoap[][] toSoapModels(TipoEvento[][] models) {
		TipoEventoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TipoEventoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TipoEventoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TipoEventoSoap[] toSoapModels(List<TipoEvento> models) {
		List<TipoEventoSoap> soapModels = new ArrayList<TipoEventoSoap>(
			models.size());

		for (TipoEvento model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TipoEventoSoap[soapModels.size()]);
	}

	public TipoEventoSoap() {
	}

	public long getPrimaryKey() {
		return _eventoId;
	}

	public void setPrimaryKey(long pk) {
		setEventoId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEventoId() {
		return _eventoId;
	}

	public void setEventoId(long eventoId) {
		_eventoId = eventoId;
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

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public int getIndice() {
		return _indice;
	}

	public void setIndice(int indice) {
		_indice = indice;
	}

	public int getTabella() {
		return _tabella;
	}

	public void setTabella(int tabella) {
		_tabella = tabella;
	}

	public boolean getSplit() {
		return _split;
	}

	public boolean isSplit() {
		return _split;
	}

	public void setSplit(boolean split) {
		_split = split;
	}

	public boolean getCostiero() {
		return _costiero;
	}

	public boolean isCostiero() {
		return _costiero;
	}

	public void setCostiero(boolean costiero) {
		_costiero = costiero;
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

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	private String _uuid;
	private long _eventoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private int _indice;
	private int _tabella;
	private boolean _split;
	private boolean _costiero;
	private Date _dataInizio;
	private Date _dataFine;
	private long _parentId;

}