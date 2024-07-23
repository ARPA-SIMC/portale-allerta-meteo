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
 * This class is a wrapper for {@link AllertaValangheStato}.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaValangheStato
 * @generated
 */
@ProviderType
public class AllertaValangheStatoWrapper
	implements AllertaValangheStato, ModelWrapper<AllertaValangheStato> {

	public AllertaValangheStatoWrapper(
		AllertaValangheStato allertaValangheStato) {

		_allertaValangheStato = allertaValangheStato;
	}

	@Override
	public Class<?> getModelClass() {
		return AllertaValangheStato.class;
	}

	@Override
	public String getModelClassName() {
		return AllertaValangheStato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("allertaValangheStatoId", getAllertaValangheStatoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("dataInizio", getDataInizio());
		attributes.put("dataFine", getDataFine());
		attributes.put("parentId", getParentId());
		attributes.put("allertaValangheId", getAllertaValangheId());
		attributes.put("statoId", getStatoId());
		attributes.put("eventoId", getEventoId());
		attributes.put("areaId", getAreaId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long allertaValangheStatoId = (Long)attributes.get(
			"allertaValangheStatoId");

		if (allertaValangheStatoId != null) {
			setAllertaValangheStatoId(allertaValangheStatoId);
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

		Long allertaValangheId = (Long)attributes.get("allertaValangheId");

		if (allertaValangheId != null) {
			setAllertaValangheId(allertaValangheId);
		}

		Long statoId = (Long)attributes.get("statoId");

		if (statoId != null) {
			setStatoId(statoId);
		}

		Long eventoId = (Long)attributes.get("eventoId");

		if (eventoId != null) {
			setEventoId(eventoId);
		}

		Long areaId = (Long)attributes.get("areaId");

		if (areaId != null) {
			setAreaId(areaId);
		}
	}

	@Override
	public Object clone() {
		return new AllertaValangheStatoWrapper(
			(AllertaValangheStato)_allertaValangheStato.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerter.model.AllertaValangheStato allertaValangheStato) {

		return _allertaValangheStato.compareTo(allertaValangheStato);
	}

	/**
	 * Returns the allerta valanghe ID of this allerta valanghe stato.
	 *
	 * @return the allerta valanghe ID of this allerta valanghe stato
	 */
	@Override
	public long getAllertaValangheId() {
		return _allertaValangheStato.getAllertaValangheId();
	}

	/**
	 * Returns the allerta valanghe stato ID of this allerta valanghe stato.
	 *
	 * @return the allerta valanghe stato ID of this allerta valanghe stato
	 */
	@Override
	public long getAllertaValangheStatoId() {
		return _allertaValangheStato.getAllertaValangheStatoId();
	}

	/**
	 * Returns the area ID of this allerta valanghe stato.
	 *
	 * @return the area ID of this allerta valanghe stato
	 */
	@Override
	public long getAreaId() {
		return _allertaValangheStato.getAreaId();
	}

	/**
	 * Returns the company ID of this allerta valanghe stato.
	 *
	 * @return the company ID of this allerta valanghe stato
	 */
	@Override
	public long getCompanyId() {
		return _allertaValangheStato.getCompanyId();
	}

	/**
	 * Returns the create date of this allerta valanghe stato.
	 *
	 * @return the create date of this allerta valanghe stato
	 */
	@Override
	public Date getCreateDate() {
		return _allertaValangheStato.getCreateDate();
	}

	/**
	 * Returns the data fine of this allerta valanghe stato.
	 *
	 * @return the data fine of this allerta valanghe stato
	 */
	@Override
	public Date getDataFine() {
		return _allertaValangheStato.getDataFine();
	}

	/**
	 * Returns the data inizio of this allerta valanghe stato.
	 *
	 * @return the data inizio of this allerta valanghe stato
	 */
	@Override
	public Date getDataInizio() {
		return _allertaValangheStato.getDataInizio();
	}

	/**
	 * Returns the evento ID of this allerta valanghe stato.
	 *
	 * @return the evento ID of this allerta valanghe stato
	 */
	@Override
	public long getEventoId() {
		return _allertaValangheStato.getEventoId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _allertaValangheStato.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this allerta valanghe stato.
	 *
	 * @return the group ID of this allerta valanghe stato
	 */
	@Override
	public long getGroupId() {
		return _allertaValangheStato.getGroupId();
	}

	/**
	 * Returns the modified date of this allerta valanghe stato.
	 *
	 * @return the modified date of this allerta valanghe stato
	 */
	@Override
	public Date getModifiedDate() {
		return _allertaValangheStato.getModifiedDate();
	}

	/**
	 * Returns the nome of this allerta valanghe stato.
	 *
	 * @return the nome of this allerta valanghe stato
	 */
	@Override
	public String getNome() {
		return _allertaValangheStato.getNome();
	}

	/**
	 * Returns the parent ID of this allerta valanghe stato.
	 *
	 * @return the parent ID of this allerta valanghe stato
	 */
	@Override
	public long getParentId() {
		return _allertaValangheStato.getParentId();
	}

	/**
	 * Returns the primary key of this allerta valanghe stato.
	 *
	 * @return the primary key of this allerta valanghe stato
	 */
	@Override
	public long getPrimaryKey() {
		return _allertaValangheStato.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _allertaValangheStato.getPrimaryKeyObj();
	}

	/**
	 * Returns the stato ID of this allerta valanghe stato.
	 *
	 * @return the stato ID of this allerta valanghe stato
	 */
	@Override
	public long getStatoId() {
		return _allertaValangheStato.getStatoId();
	}

	/**
	 * Returns the user ID of this allerta valanghe stato.
	 *
	 * @return the user ID of this allerta valanghe stato
	 */
	@Override
	public long getUserId() {
		return _allertaValangheStato.getUserId();
	}

	/**
	 * Returns the user name of this allerta valanghe stato.
	 *
	 * @return the user name of this allerta valanghe stato
	 */
	@Override
	public String getUserName() {
		return _allertaValangheStato.getUserName();
	}

	/**
	 * Returns the user uuid of this allerta valanghe stato.
	 *
	 * @return the user uuid of this allerta valanghe stato
	 */
	@Override
	public String getUserUuid() {
		return _allertaValangheStato.getUserUuid();
	}

	/**
	 * Returns the uuid of this allerta valanghe stato.
	 *
	 * @return the uuid of this allerta valanghe stato
	 */
	@Override
	public String getUuid() {
		return _allertaValangheStato.getUuid();
	}

	@Override
	public int hashCode() {
		return _allertaValangheStato.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _allertaValangheStato.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _allertaValangheStato.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _allertaValangheStato.isNew();
	}

	@Override
	public void persist() {
		_allertaValangheStato.persist();
	}

	/**
	 * Sets the allerta valanghe ID of this allerta valanghe stato.
	 *
	 * @param allertaValangheId the allerta valanghe ID of this allerta valanghe stato
	 */
	@Override
	public void setAllertaValangheId(long allertaValangheId) {
		_allertaValangheStato.setAllertaValangheId(allertaValangheId);
	}

	/**
	 * Sets the allerta valanghe stato ID of this allerta valanghe stato.
	 *
	 * @param allertaValangheStatoId the allerta valanghe stato ID of this allerta valanghe stato
	 */
	@Override
	public void setAllertaValangheStatoId(long allertaValangheStatoId) {
		_allertaValangheStato.setAllertaValangheStatoId(allertaValangheStatoId);
	}

	/**
	 * Sets the area ID of this allerta valanghe stato.
	 *
	 * @param areaId the area ID of this allerta valanghe stato
	 */
	@Override
	public void setAreaId(long areaId) {
		_allertaValangheStato.setAreaId(areaId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_allertaValangheStato.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this allerta valanghe stato.
	 *
	 * @param companyId the company ID of this allerta valanghe stato
	 */
	@Override
	public void setCompanyId(long companyId) {
		_allertaValangheStato.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this allerta valanghe stato.
	 *
	 * @param createDate the create date of this allerta valanghe stato
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_allertaValangheStato.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this allerta valanghe stato.
	 *
	 * @param dataFine the data fine of this allerta valanghe stato
	 */
	@Override
	public void setDataFine(Date dataFine) {
		_allertaValangheStato.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this allerta valanghe stato.
	 *
	 * @param dataInizio the data inizio of this allerta valanghe stato
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		_allertaValangheStato.setDataInizio(dataInizio);
	}

	/**
	 * Sets the evento ID of this allerta valanghe stato.
	 *
	 * @param eventoId the evento ID of this allerta valanghe stato
	 */
	@Override
	public void setEventoId(long eventoId) {
		_allertaValangheStato.setEventoId(eventoId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_allertaValangheStato.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_allertaValangheStato.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_allertaValangheStato.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this allerta valanghe stato.
	 *
	 * @param groupId the group ID of this allerta valanghe stato
	 */
	@Override
	public void setGroupId(long groupId) {
		_allertaValangheStato.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this allerta valanghe stato.
	 *
	 * @param modifiedDate the modified date of this allerta valanghe stato
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_allertaValangheStato.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_allertaValangheStato.setNew(n);
	}

	/**
	 * Sets the nome of this allerta valanghe stato.
	 *
	 * @param nome the nome of this allerta valanghe stato
	 */
	@Override
	public void setNome(String nome) {
		_allertaValangheStato.setNome(nome);
	}

	/**
	 * Sets the parent ID of this allerta valanghe stato.
	 *
	 * @param parentId the parent ID of this allerta valanghe stato
	 */
	@Override
	public void setParentId(long parentId) {
		_allertaValangheStato.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this allerta valanghe stato.
	 *
	 * @param primaryKey the primary key of this allerta valanghe stato
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_allertaValangheStato.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_allertaValangheStato.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the stato ID of this allerta valanghe stato.
	 *
	 * @param statoId the stato ID of this allerta valanghe stato
	 */
	@Override
	public void setStatoId(long statoId) {
		_allertaValangheStato.setStatoId(statoId);
	}

	/**
	 * Sets the user ID of this allerta valanghe stato.
	 *
	 * @param userId the user ID of this allerta valanghe stato
	 */
	@Override
	public void setUserId(long userId) {
		_allertaValangheStato.setUserId(userId);
	}

	/**
	 * Sets the user name of this allerta valanghe stato.
	 *
	 * @param userName the user name of this allerta valanghe stato
	 */
	@Override
	public void setUserName(String userName) {
		_allertaValangheStato.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this allerta valanghe stato.
	 *
	 * @param userUuid the user uuid of this allerta valanghe stato
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_allertaValangheStato.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this allerta valanghe stato.
	 *
	 * @param uuid the uuid of this allerta valanghe stato
	 */
	@Override
	public void setUuid(String uuid) {
		_allertaValangheStato.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.AllertaValangheStato> toCacheModel() {

		return _allertaValangheStato.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.AllertaValangheStato toEscapedModel() {
		return new AllertaValangheStatoWrapper(
			_allertaValangheStato.toEscapedModel());
	}

	@Override
	public String toString() {
		return _allertaValangheStato.toString();
	}

	@Override
	public it.eng.allerter.model.AllertaValangheStato toUnescapedModel() {
		return new AllertaValangheStatoWrapper(
			_allertaValangheStato.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _allertaValangheStato.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AllertaValangheStatoWrapper)) {
			return false;
		}

		AllertaValangheStatoWrapper allertaValangheStatoWrapper =
			(AllertaValangheStatoWrapper)obj;

		if (Objects.equals(
				_allertaValangheStato,
				allertaValangheStatoWrapper._allertaValangheStato)) {

			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _allertaValangheStato.getStagedModelType();
	}

	@Override
	public AllertaValangheStato getWrappedModel() {
		return _allertaValangheStato;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _allertaValangheStato.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _allertaValangheStato.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_allertaValangheStato.resetOriginalValues();
	}

	private final AllertaValangheStato _allertaValangheStato;

}