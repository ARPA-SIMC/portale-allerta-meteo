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
 * This class is used by SOAP remote services, specifically {@link it.eng.allerter.service.http.AreaServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AreaSoap implements Serializable {

	public static AreaSoap toSoapModel(Area model) {
		AreaSoap soapModel = new AreaSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAreaId(model.getAreaId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNome(model.getNome());
		soapModel.setTipoArea(model.getTipoArea());
		soapModel.setCostiero(model.isCostiero());
		soapModel.setDataInizio(model.getDataInizio());
		soapModel.setDataFine(model.getDataFine());
		soapModel.setParentId(model.getParentId());

		return soapModel;
	}

	public static AreaSoap[] toSoapModels(Area[] models) {
		AreaSoap[] soapModels = new AreaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AreaSoap[][] toSoapModels(Area[][] models) {
		AreaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AreaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AreaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AreaSoap[] toSoapModels(List<Area> models) {
		List<AreaSoap> soapModels = new ArrayList<AreaSoap>(models.size());

		for (Area model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AreaSoap[soapModels.size()]);
	}

	public AreaSoap() {
	}

	public long getPrimaryKey() {
		return _areaId;
	}

	public void setPrimaryKey(long pk) {
		setAreaId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAreaId() {
		return _areaId;
	}

	public void setAreaId(long areaId) {
		_areaId = areaId;
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

	public String getTipoArea() {
		return _tipoArea;
	}

	public void setTipoArea(String tipoArea) {
		_tipoArea = tipoArea;
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
	private long _areaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nome;
	private String _tipoArea;
	private boolean _costiero;
	private Date _dataInizio;
	private Date _dataFine;
	private long _parentId;

}