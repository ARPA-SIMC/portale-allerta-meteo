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
 * This class is a wrapper for {@link StatoAllertamento}.
 * </p>
 *
 * @author GFAVINI
 * @see StatoAllertamento
 * @generated
 */
@ProviderType
public class StatoAllertamentoWrapper
	implements StatoAllertamento, ModelWrapper<StatoAllertamento> {

	public StatoAllertamentoWrapper(StatoAllertamento statoAllertamento) {
		_statoAllertamento = statoAllertamento;
	}

	@Override
	public Class<?> getModelClass() {
		return StatoAllertamento.class;
	}

	@Override
	public String getModelClassName() {
		return StatoAllertamento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("statoId", getStatoId());
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

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long statoId = (Long)attributes.get("statoId");

		if (statoId != null) {
			setStatoId(statoId);
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
	}

	@Override
	public Object clone() {
		return new StatoAllertamentoWrapper(
			(StatoAllertamento)_statoAllertamento.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerter.model.StatoAllertamento statoAllertamento) {

		return _statoAllertamento.compareTo(statoAllertamento);
	}

	/**
	 * Returns the company ID of this stato allertamento.
	 *
	 * @return the company ID of this stato allertamento
	 */
	@Override
	public long getCompanyId() {
		return _statoAllertamento.getCompanyId();
	}

	/**
	 * Returns the create date of this stato allertamento.
	 *
	 * @return the create date of this stato allertamento
	 */
	@Override
	public Date getCreateDate() {
		return _statoAllertamento.getCreateDate();
	}

	/**
	 * Returns the data fine of this stato allertamento.
	 *
	 * @return the data fine of this stato allertamento
	 */
	@Override
	public Date getDataFine() {
		return _statoAllertamento.getDataFine();
	}

	/**
	 * Returns the data inizio of this stato allertamento.
	 *
	 * @return the data inizio of this stato allertamento
	 */
	@Override
	public Date getDataInizio() {
		return _statoAllertamento.getDataInizio();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _statoAllertamento.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this stato allertamento.
	 *
	 * @return the group ID of this stato allertamento
	 */
	@Override
	public long getGroupId() {
		return _statoAllertamento.getGroupId();
	}

	/**
	 * Returns the modified date of this stato allertamento.
	 *
	 * @return the modified date of this stato allertamento
	 */
	@Override
	public Date getModifiedDate() {
		return _statoAllertamento.getModifiedDate();
	}

	/**
	 * Returns the nome of this stato allertamento.
	 *
	 * @return the nome of this stato allertamento
	 */
	@Override
	public String getNome() {
		return _statoAllertamento.getNome();
	}

	/**
	 * Returns the parent ID of this stato allertamento.
	 *
	 * @return the parent ID of this stato allertamento
	 */
	@Override
	public long getParentId() {
		return _statoAllertamento.getParentId();
	}

	/**
	 * Returns the primary key of this stato allertamento.
	 *
	 * @return the primary key of this stato allertamento
	 */
	@Override
	public long getPrimaryKey() {
		return _statoAllertamento.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statoAllertamento.getPrimaryKeyObj();
	}

	/**
	 * Returns the stato ID of this stato allertamento.
	 *
	 * @return the stato ID of this stato allertamento
	 */
	@Override
	public long getStatoId() {
		return _statoAllertamento.getStatoId();
	}

	/**
	 * Returns the user ID of this stato allertamento.
	 *
	 * @return the user ID of this stato allertamento
	 */
	@Override
	public long getUserId() {
		return _statoAllertamento.getUserId();
	}

	/**
	 * Returns the user name of this stato allertamento.
	 *
	 * @return the user name of this stato allertamento
	 */
	@Override
	public String getUserName() {
		return _statoAllertamento.getUserName();
	}

	/**
	 * Returns the user uuid of this stato allertamento.
	 *
	 * @return the user uuid of this stato allertamento
	 */
	@Override
	public String getUserUuid() {
		return _statoAllertamento.getUserUuid();
	}

	/**
	 * Returns the uuid of this stato allertamento.
	 *
	 * @return the uuid of this stato allertamento
	 */
	@Override
	public String getUuid() {
		return _statoAllertamento.getUuid();
	}

	@Override
	public int hashCode() {
		return _statoAllertamento.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _statoAllertamento.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _statoAllertamento.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _statoAllertamento.isNew();
	}

	@Override
	public void persist() {
		_statoAllertamento.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_statoAllertamento.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this stato allertamento.
	 *
	 * @param companyId the company ID of this stato allertamento
	 */
	@Override
	public void setCompanyId(long companyId) {
		_statoAllertamento.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this stato allertamento.
	 *
	 * @param createDate the create date of this stato allertamento
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_statoAllertamento.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this stato allertamento.
	 *
	 * @param dataFine the data fine of this stato allertamento
	 */
	@Override
	public void setDataFine(Date dataFine) {
		_statoAllertamento.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this stato allertamento.
	 *
	 * @param dataInizio the data inizio of this stato allertamento
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		_statoAllertamento.setDataInizio(dataInizio);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_statoAllertamento.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_statoAllertamento.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_statoAllertamento.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this stato allertamento.
	 *
	 * @param groupId the group ID of this stato allertamento
	 */
	@Override
	public void setGroupId(long groupId) {
		_statoAllertamento.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this stato allertamento.
	 *
	 * @param modifiedDate the modified date of this stato allertamento
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_statoAllertamento.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_statoAllertamento.setNew(n);
	}

	/**
	 * Sets the nome of this stato allertamento.
	 *
	 * @param nome the nome of this stato allertamento
	 */
	@Override
	public void setNome(String nome) {
		_statoAllertamento.setNome(nome);
	}

	/**
	 * Sets the parent ID of this stato allertamento.
	 *
	 * @param parentId the parent ID of this stato allertamento
	 */
	@Override
	public void setParentId(long parentId) {
		_statoAllertamento.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this stato allertamento.
	 *
	 * @param primaryKey the primary key of this stato allertamento
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_statoAllertamento.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_statoAllertamento.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the stato ID of this stato allertamento.
	 *
	 * @param statoId the stato ID of this stato allertamento
	 */
	@Override
	public void setStatoId(long statoId) {
		_statoAllertamento.setStatoId(statoId);
	}

	/**
	 * Sets the user ID of this stato allertamento.
	 *
	 * @param userId the user ID of this stato allertamento
	 */
	@Override
	public void setUserId(long userId) {
		_statoAllertamento.setUserId(userId);
	}

	/**
	 * Sets the user name of this stato allertamento.
	 *
	 * @param userName the user name of this stato allertamento
	 */
	@Override
	public void setUserName(String userName) {
		_statoAllertamento.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this stato allertamento.
	 *
	 * @param userUuid the user uuid of this stato allertamento
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_statoAllertamento.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this stato allertamento.
	 *
	 * @param uuid the uuid of this stato allertamento
	 */
	@Override
	public void setUuid(String uuid) {
		_statoAllertamento.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.StatoAllertamento> toCacheModel() {

		return _statoAllertamento.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.StatoAllertamento toEscapedModel() {
		return new StatoAllertamentoWrapper(
			_statoAllertamento.toEscapedModel());
	}

	@Override
	public String toString() {
		return _statoAllertamento.toString();
	}

	@Override
	public it.eng.allerter.model.StatoAllertamento toUnescapedModel() {
		return new StatoAllertamentoWrapper(
			_statoAllertamento.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _statoAllertamento.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StatoAllertamentoWrapper)) {
			return false;
		}

		StatoAllertamentoWrapper statoAllertamentoWrapper =
			(StatoAllertamentoWrapper)obj;

		if (Objects.equals(
				_statoAllertamento,
				statoAllertamentoWrapper._statoAllertamento)) {

			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _statoAllertamento.getStagedModelType();
	}

	@Override
	public StatoAllertamento getWrappedModel() {
		return _statoAllertamento;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _statoAllertamento.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _statoAllertamento.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_statoAllertamento.resetOriginalValues();
	}

	private final StatoAllertamento _statoAllertamento;

}