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
 * This class is a wrapper for {@link AllertaStato}.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaStato
 * @generated
 */
@ProviderType
public class AllertaStatoWrapper
	implements AllertaStato, ModelWrapper<AllertaStato> {

	public AllertaStatoWrapper(AllertaStato allertaStato) {
		_allertaStato = allertaStato;
	}

	@Override
	public Class<?> getModelClass() {
		return AllertaStato.class;
	}

	@Override
	public String getModelClassName() {
		return AllertaStato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("allertaStatoId", getAllertaStatoId());
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
		attributes.put("allertaId", getAllertaId());
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

		Long allertaStatoId = (Long)attributes.get("allertaStatoId");

		if (allertaStatoId != null) {
			setAllertaStatoId(allertaStatoId);
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

		Long allertaId = (Long)attributes.get("allertaId");

		if (allertaId != null) {
			setAllertaId(allertaId);
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
		return new AllertaStatoWrapper((AllertaStato)_allertaStato.clone());
	}

	@Override
	public int compareTo(it.eng.allerter.model.AllertaStato allertaStato) {
		return _allertaStato.compareTo(allertaStato);
	}

	/**
	 * Returns the allerta ID of this allerta stato.
	 *
	 * @return the allerta ID of this allerta stato
	 */
	@Override
	public long getAllertaId() {
		return _allertaStato.getAllertaId();
	}

	/**
	 * Returns the allerta stato ID of this allerta stato.
	 *
	 * @return the allerta stato ID of this allerta stato
	 */
	@Override
	public long getAllertaStatoId() {
		return _allertaStato.getAllertaStatoId();
	}

	/**
	 * Returns the area ID of this allerta stato.
	 *
	 * @return the area ID of this allerta stato
	 */
	@Override
	public long getAreaId() {
		return _allertaStato.getAreaId();
	}

	/**
	 * Returns the company ID of this allerta stato.
	 *
	 * @return the company ID of this allerta stato
	 */
	@Override
	public long getCompanyId() {
		return _allertaStato.getCompanyId();
	}

	/**
	 * Returns the create date of this allerta stato.
	 *
	 * @return the create date of this allerta stato
	 */
	@Override
	public Date getCreateDate() {
		return _allertaStato.getCreateDate();
	}

	/**
	 * Returns the data fine of this allerta stato.
	 *
	 * @return the data fine of this allerta stato
	 */
	@Override
	public Date getDataFine() {
		return _allertaStato.getDataFine();
	}

	/**
	 * Returns the data inizio of this allerta stato.
	 *
	 * @return the data inizio of this allerta stato
	 */
	@Override
	public Date getDataInizio() {
		return _allertaStato.getDataInizio();
	}

	/**
	 * Returns the evento ID of this allerta stato.
	 *
	 * @return the evento ID of this allerta stato
	 */
	@Override
	public long getEventoId() {
		return _allertaStato.getEventoId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _allertaStato.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this allerta stato.
	 *
	 * @return the group ID of this allerta stato
	 */
	@Override
	public long getGroupId() {
		return _allertaStato.getGroupId();
	}

	/**
	 * Returns the modified date of this allerta stato.
	 *
	 * @return the modified date of this allerta stato
	 */
	@Override
	public Date getModifiedDate() {
		return _allertaStato.getModifiedDate();
	}

	/**
	 * Returns the nome of this allerta stato.
	 *
	 * @return the nome of this allerta stato
	 */
	@Override
	public String getNome() {
		return _allertaStato.getNome();
	}

	/**
	 * Returns the parent ID of this allerta stato.
	 *
	 * @return the parent ID of this allerta stato
	 */
	@Override
	public long getParentId() {
		return _allertaStato.getParentId();
	}

	/**
	 * Returns the primary key of this allerta stato.
	 *
	 * @return the primary key of this allerta stato
	 */
	@Override
	public long getPrimaryKey() {
		return _allertaStato.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _allertaStato.getPrimaryKeyObj();
	}

	/**
	 * Returns the stato ID of this allerta stato.
	 *
	 * @return the stato ID of this allerta stato
	 */
	@Override
	public long getStatoId() {
		return _allertaStato.getStatoId();
	}

	/**
	 * Returns the user ID of this allerta stato.
	 *
	 * @return the user ID of this allerta stato
	 */
	@Override
	public long getUserId() {
		return _allertaStato.getUserId();
	}

	/**
	 * Returns the user name of this allerta stato.
	 *
	 * @return the user name of this allerta stato
	 */
	@Override
	public String getUserName() {
		return _allertaStato.getUserName();
	}

	/**
	 * Returns the user uuid of this allerta stato.
	 *
	 * @return the user uuid of this allerta stato
	 */
	@Override
	public String getUserUuid() {
		return _allertaStato.getUserUuid();
	}

	/**
	 * Returns the uuid of this allerta stato.
	 *
	 * @return the uuid of this allerta stato
	 */
	@Override
	public String getUuid() {
		return _allertaStato.getUuid();
	}

	@Override
	public int hashCode() {
		return _allertaStato.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _allertaStato.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _allertaStato.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _allertaStato.isNew();
	}

	@Override
	public void persist() {
		_allertaStato.persist();
	}

	/**
	 * Sets the allerta ID of this allerta stato.
	 *
	 * @param allertaId the allerta ID of this allerta stato
	 */
	@Override
	public void setAllertaId(long allertaId) {
		_allertaStato.setAllertaId(allertaId);
	}

	/**
	 * Sets the allerta stato ID of this allerta stato.
	 *
	 * @param allertaStatoId the allerta stato ID of this allerta stato
	 */
	@Override
	public void setAllertaStatoId(long allertaStatoId) {
		_allertaStato.setAllertaStatoId(allertaStatoId);
	}

	/**
	 * Sets the area ID of this allerta stato.
	 *
	 * @param areaId the area ID of this allerta stato
	 */
	@Override
	public void setAreaId(long areaId) {
		_allertaStato.setAreaId(areaId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_allertaStato.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this allerta stato.
	 *
	 * @param companyId the company ID of this allerta stato
	 */
	@Override
	public void setCompanyId(long companyId) {
		_allertaStato.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this allerta stato.
	 *
	 * @param createDate the create date of this allerta stato
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_allertaStato.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this allerta stato.
	 *
	 * @param dataFine the data fine of this allerta stato
	 */
	@Override
	public void setDataFine(Date dataFine) {
		_allertaStato.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this allerta stato.
	 *
	 * @param dataInizio the data inizio of this allerta stato
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		_allertaStato.setDataInizio(dataInizio);
	}

	/**
	 * Sets the evento ID of this allerta stato.
	 *
	 * @param eventoId the evento ID of this allerta stato
	 */
	@Override
	public void setEventoId(long eventoId) {
		_allertaStato.setEventoId(eventoId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_allertaStato.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_allertaStato.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_allertaStato.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this allerta stato.
	 *
	 * @param groupId the group ID of this allerta stato
	 */
	@Override
	public void setGroupId(long groupId) {
		_allertaStato.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this allerta stato.
	 *
	 * @param modifiedDate the modified date of this allerta stato
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_allertaStato.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_allertaStato.setNew(n);
	}

	/**
	 * Sets the nome of this allerta stato.
	 *
	 * @param nome the nome of this allerta stato
	 */
	@Override
	public void setNome(String nome) {
		_allertaStato.setNome(nome);
	}

	/**
	 * Sets the parent ID of this allerta stato.
	 *
	 * @param parentId the parent ID of this allerta stato
	 */
	@Override
	public void setParentId(long parentId) {
		_allertaStato.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this allerta stato.
	 *
	 * @param primaryKey the primary key of this allerta stato
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_allertaStato.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_allertaStato.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the stato ID of this allerta stato.
	 *
	 * @param statoId the stato ID of this allerta stato
	 */
	@Override
	public void setStatoId(long statoId) {
		_allertaStato.setStatoId(statoId);
	}

	/**
	 * Sets the user ID of this allerta stato.
	 *
	 * @param userId the user ID of this allerta stato
	 */
	@Override
	public void setUserId(long userId) {
		_allertaStato.setUserId(userId);
	}

	/**
	 * Sets the user name of this allerta stato.
	 *
	 * @param userName the user name of this allerta stato
	 */
	@Override
	public void setUserName(String userName) {
		_allertaStato.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this allerta stato.
	 *
	 * @param userUuid the user uuid of this allerta stato
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_allertaStato.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this allerta stato.
	 *
	 * @param uuid the uuid of this allerta stato
	 */
	@Override
	public void setUuid(String uuid) {
		_allertaStato.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.AllertaStato> toCacheModel() {

		return _allertaStato.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.AllertaStato toEscapedModel() {
		return new AllertaStatoWrapper(_allertaStato.toEscapedModel());
	}

	@Override
	public String toString() {
		return _allertaStato.toString();
	}

	@Override
	public it.eng.allerter.model.AllertaStato toUnescapedModel() {
		return new AllertaStatoWrapper(_allertaStato.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _allertaStato.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AllertaStatoWrapper)) {
			return false;
		}

		AllertaStatoWrapper allertaStatoWrapper = (AllertaStatoWrapper)obj;

		if (Objects.equals(_allertaStato, allertaStatoWrapper._allertaStato)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _allertaStato.getStagedModelType();
	}

	@Override
	public AllertaStato getWrappedModel() {
		return _allertaStato;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _allertaStato.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _allertaStato.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_allertaStato.resetOriginalValues();
	}

	private final AllertaStato _allertaStato;

}