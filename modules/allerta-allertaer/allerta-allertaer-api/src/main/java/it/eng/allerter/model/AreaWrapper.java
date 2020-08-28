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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Area}.
 * </p>
 *
 * @author GFAVINI
 * @see Area
 * @generated
 */
@ProviderType
public class AreaWrapper implements Area, ModelWrapper<Area> {

	public AreaWrapper(Area area) {
		_area = area;
	}

	@Override
	public Class<?> getModelClass() {
		return Area.class;
	}

	@Override
	public String getModelClassName() {
		return Area.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("areaId", getAreaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("tipoArea", getTipoArea());
		attributes.put("costiero", isCostiero());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("parentId", getParentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long areaId = (Long)attributes.get("areaId");

		if (areaId != null) {
			setAreaId(areaId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String tipoArea = (String)attributes.get("tipoArea");

		if (tipoArea != null) {
			setTipoArea(tipoArea);
		}

		Boolean costiero = (Boolean)attributes.get("costiero");

		if (costiero != null) {
			setCostiero(costiero);
		}

		Date dataInizio = (Date)attributes.get("dataInizio");

		if (dataInizio != null) {
			setDataInizio(dataInizio);
		}

		Date dataFine = (Date)attributes.get("dataFine");

		if (dataFine != null) {
			setDataFine(dataFine);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}
	}

	@Override
	public Object clone() {
		return new AreaWrapper((Area)_area.clone());
	}

	@Override
	public int compareTo(it.eng.allerter.model.Area area) {
		return _area.compareTo(area);
	}

	/**
	 * Returns the area ID of this area.
	 *
	 * @return the area ID of this area
	 */
	@Override
	public long getAreaId() {
		return _area.getAreaId();
	}

	/**
	 * Returns the company ID of this area.
	 *
	 * @return the company ID of this area
	 */
	@Override
	public long getCompanyId() {
		return _area.getCompanyId();
	}

	/**
	 * Returns the costiero of this area.
	 *
	 * @return the costiero of this area
	 */
	@Override
	public boolean getCostiero() {
		return _area.getCostiero();
	}

	/**
	 * Returns the create date of this area.
	 *
	 * @return the create date of this area
	 */
	@Override
	public Date getCreateDate() {
		return _area.getCreateDate();
	}

	/**
	 * Returns the data fine of this area.
	 *
	 * @return the data fine of this area
	 */
	@Override
	public Date getDataFine() {
		return _area.getDataFine();
	}

	/**
	 * Returns the data inizio of this area.
	 *
	 * @return the data inizio of this area
	 */
	@Override
	public Date getDataInizio() {
		return _area.getDataInizio();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _area.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this area.
	 *
	 * @return the group ID of this area
	 */
	@Override
	public long getGroupId() {
		return _area.getGroupId();
	}

	/**
	 * Returns the modified date of this area.
	 *
	 * @return the modified date of this area
	 */
	@Override
	public Date getModifiedDate() {
		return _area.getModifiedDate();
	}

	/**
	 * Returns the nome of this area.
	 *
	 * @return the nome of this area
	 */
	@Override
	public String getNome() {
		return _area.getNome();
	}

	/**
	 * Returns the parent ID of this area.
	 *
	 * @return the parent ID of this area
	 */
	@Override
	public long getParentId() {
		return _area.getParentId();
	}

	/**
	 * Returns the primary key of this area.
	 *
	 * @return the primary key of this area
	 */
	@Override
	public long getPrimaryKey() {
		return _area.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _area.getPrimaryKeyObj();
	}

	/**
	 * Returns the tipo area of this area.
	 *
	 * @return the tipo area of this area
	 */
	@Override
	public String getTipoArea() {
		return _area.getTipoArea();
	}

	/**
	 * Returns the user ID of this area.
	 *
	 * @return the user ID of this area
	 */
	@Override
	public long getUserId() {
		return _area.getUserId();
	}

	/**
	 * Returns the user name of this area.
	 *
	 * @return the user name of this area
	 */
	@Override
	public String getUserName() {
		return _area.getUserName();
	}

	/**
	 * Returns the user uuid of this area.
	 *
	 * @return the user uuid of this area
	 */
	@Override
	public String getUserUuid() {
		return _area.getUserUuid();
	}

	/**
	 * Returns the uuid of this area.
	 *
	 * @return the uuid of this area
	 */
	@Override
	public String getUuid() {
		return _area.getUuid();
	}

	@Override
	public int hashCode() {
		return _area.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _area.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this area is costiero.
	 *
	 * @return <code>true</code> if this area is costiero; <code>false</code> otherwise
	 */
	@Override
	public boolean isCostiero() {
		return _area.isCostiero();
	}

	@Override
	public boolean isEscapedModel() {
		return _area.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _area.isNew();
	}

	@Override
	public void persist() {
		_area.persist();
	}

	/**
	 * Sets the area ID of this area.
	 *
	 * @param areaId the area ID of this area
	 */
	@Override
	public void setAreaId(long areaId) {
		_area.setAreaId(areaId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_area.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this area.
	 *
	 * @param companyId the company ID of this area
	 */
	@Override
	public void setCompanyId(long companyId) {
		_area.setCompanyId(companyId);
	}

	/**
	 * Sets whether this area is costiero.
	 *
	 * @param costiero the costiero of this area
	 */
	@Override
	public void setCostiero(boolean costiero) {
		_area.setCostiero(costiero);
	}

	/**
	 * Sets the create date of this area.
	 *
	 * @param createDate the create date of this area
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_area.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this area.
	 *
	 * @param dataFine the data fine of this area
	 */
	@Override
	public void setDataFine(Date dataFine) {
		_area.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this area.
	 *
	 * @param dataInizio the data inizio of this area
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		_area.setDataInizio(dataInizio);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_area.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_area.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_area.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this area.
	 *
	 * @param groupId the group ID of this area
	 */
	@Override
	public void setGroupId(long groupId) {
		_area.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this area.
	 *
	 * @param modifiedDate the modified date of this area
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_area.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_area.setNew(n);
	}

	/**
	 * Sets the nome of this area.
	 *
	 * @param nome the nome of this area
	 */
	@Override
	public void setNome(String nome) {
		_area.setNome(nome);
	}

	/**
	 * Sets the parent ID of this area.
	 *
	 * @param parentId the parent ID of this area
	 */
	@Override
	public void setParentId(long parentId) {
		_area.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this area.
	 *
	 * @param primaryKey the primary key of this area
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_area.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_area.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the tipo area of this area.
	 *
	 * @param tipoArea the tipo area of this area
	 */
	@Override
	public void setTipoArea(String tipoArea) {
		_area.setTipoArea(tipoArea);
	}

	/**
	 * Sets the user ID of this area.
	 *
	 * @param userId the user ID of this area
	 */
	@Override
	public void setUserId(long userId) {
		_area.setUserId(userId);
	}

	/**
	 * Sets the user name of this area.
	 *
	 * @param userName the user name of this area
	 */
	@Override
	public void setUserName(String userName) {
		_area.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this area.
	 *
	 * @param userUuid the user uuid of this area
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_area.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this area.
	 *
	 * @param uuid the uuid of this area
	 */
	@Override
	public void setUuid(String uuid) {
		_area.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.Area> toCacheModel() {

		return _area.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.Area toEscapedModel() {
		return new AreaWrapper(_area.toEscapedModel());
	}

	@Override
	public String toString() {
		return _area.toString();
	}

	@Override
	public it.eng.allerter.model.Area toUnescapedModel() {
		return new AreaWrapper(_area.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _area.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AreaWrapper)) {
			return false;
		}

		AreaWrapper areaWrapper = (AreaWrapper)obj;

		if (Objects.equals(_area, areaWrapper._area)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _area.getStagedModelType();
	}

	@Override
	public Area getWrappedModel() {
		return _area;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _area.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _area.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_area.resetOriginalValues();
	}

	private final Area _area;

}