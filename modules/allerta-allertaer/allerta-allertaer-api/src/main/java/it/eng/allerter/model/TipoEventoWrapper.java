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
 * This class is a wrapper for {@link TipoEvento}.
 * </p>
 *
 * @author GFAVINI
 * @see TipoEvento
 * @generated
 */
@ProviderType
public class TipoEventoWrapper implements TipoEvento, ModelWrapper<TipoEvento> {

	public TipoEventoWrapper(TipoEvento tipoEvento) {
		_tipoEvento = tipoEvento;
	}

	@Override
	public Class<?> getModelClass() {
		return TipoEvento.class;
	}

	@Override
	public String getModelClassName() {
		return TipoEvento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventoId", getEventoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nome", getNome());
		attributes.put("indice", getIndice());
		attributes.put("tabella", getTabella());
		attributes.put("split", isSplit());
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

		Long eventoId = (Long)attributes.get("eventoId");

		if (eventoId != null) {
			setEventoId(eventoId);
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

		Integer indice = (Integer)attributes.get("indice");

		if (indice != null) {
			setIndice(indice);
		}

		Integer tabella = (Integer)attributes.get("tabella");

		if (tabella != null) {
			setTabella(tabella);
		}

		Boolean split = (Boolean)attributes.get("split");

		if (split != null) {
			setSplit(split);
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
		return new TipoEventoWrapper((TipoEvento)_tipoEvento.clone());
	}

	@Override
	public int compareTo(it.eng.allerter.model.TipoEvento tipoEvento) {
		return _tipoEvento.compareTo(tipoEvento);
	}

	/**
	 * Returns the company ID of this tipo evento.
	 *
	 * @return the company ID of this tipo evento
	 */
	@Override
	public long getCompanyId() {
		return _tipoEvento.getCompanyId();
	}

	/**
	 * Returns the costiero of this tipo evento.
	 *
	 * @return the costiero of this tipo evento
	 */
	@Override
	public boolean getCostiero() {
		return _tipoEvento.getCostiero();
	}

	/**
	 * Returns the create date of this tipo evento.
	 *
	 * @return the create date of this tipo evento
	 */
	@Override
	public Date getCreateDate() {
		return _tipoEvento.getCreateDate();
	}

	/**
	 * Returns the data fine of this tipo evento.
	 *
	 * @return the data fine of this tipo evento
	 */
	@Override
	public Date getDataFine() {
		return _tipoEvento.getDataFine();
	}

	/**
	 * Returns the data inizio of this tipo evento.
	 *
	 * @return the data inizio of this tipo evento
	 */
	@Override
	public Date getDataInizio() {
		return _tipoEvento.getDataInizio();
	}

	/**
	 * Returns the evento ID of this tipo evento.
	 *
	 * @return the evento ID of this tipo evento
	 */
	@Override
	public long getEventoId() {
		return _tipoEvento.getEventoId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _tipoEvento.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this tipo evento.
	 *
	 * @return the group ID of this tipo evento
	 */
	@Override
	public long getGroupId() {
		return _tipoEvento.getGroupId();
	}

	/**
	 * Returns the indice of this tipo evento.
	 *
	 * @return the indice of this tipo evento
	 */
	@Override
	public int getIndice() {
		return _tipoEvento.getIndice();
	}

	/**
	 * Returns the modified date of this tipo evento.
	 *
	 * @return the modified date of this tipo evento
	 */
	@Override
	public Date getModifiedDate() {
		return _tipoEvento.getModifiedDate();
	}

	/**
	 * Returns the nome of this tipo evento.
	 *
	 * @return the nome of this tipo evento
	 */
	@Override
	public String getNome() {
		return _tipoEvento.getNome();
	}

	/**
	 * Returns the parent ID of this tipo evento.
	 *
	 * @return the parent ID of this tipo evento
	 */
	@Override
	public long getParentId() {
		return _tipoEvento.getParentId();
	}

	/**
	 * Returns the primary key of this tipo evento.
	 *
	 * @return the primary key of this tipo evento
	 */
	@Override
	public long getPrimaryKey() {
		return _tipoEvento.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tipoEvento.getPrimaryKeyObj();
	}

	/**
	 * Returns the split of this tipo evento.
	 *
	 * @return the split of this tipo evento
	 */
	@Override
	public boolean getSplit() {
		return _tipoEvento.getSplit();
	}

	/**
	 * Returns the tabella of this tipo evento.
	 *
	 * @return the tabella of this tipo evento
	 */
	@Override
	public int getTabella() {
		return _tipoEvento.getTabella();
	}

	/**
	 * Returns the user ID of this tipo evento.
	 *
	 * @return the user ID of this tipo evento
	 */
	@Override
	public long getUserId() {
		return _tipoEvento.getUserId();
	}

	/**
	 * Returns the user name of this tipo evento.
	 *
	 * @return the user name of this tipo evento
	 */
	@Override
	public String getUserName() {
		return _tipoEvento.getUserName();
	}

	/**
	 * Returns the user uuid of this tipo evento.
	 *
	 * @return the user uuid of this tipo evento
	 */
	@Override
	public String getUserUuid() {
		return _tipoEvento.getUserUuid();
	}

	/**
	 * Returns the uuid of this tipo evento.
	 *
	 * @return the uuid of this tipo evento
	 */
	@Override
	public String getUuid() {
		return _tipoEvento.getUuid();
	}

	@Override
	public int hashCode() {
		return _tipoEvento.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _tipoEvento.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this tipo evento is costiero.
	 *
	 * @return <code>true</code> if this tipo evento is costiero; <code>false</code> otherwise
	 */
	@Override
	public boolean isCostiero() {
		return _tipoEvento.isCostiero();
	}

	@Override
	public boolean isEscapedModel() {
		return _tipoEvento.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _tipoEvento.isNew();
	}

	/**
	 * Returns <code>true</code> if this tipo evento is split.
	 *
	 * @return <code>true</code> if this tipo evento is split; <code>false</code> otherwise
	 */
	@Override
	public boolean isSplit() {
		return _tipoEvento.isSplit();
	}

	@Override
	public void persist() {
		_tipoEvento.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tipoEvento.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this tipo evento.
	 *
	 * @param companyId the company ID of this tipo evento
	 */
	@Override
	public void setCompanyId(long companyId) {
		_tipoEvento.setCompanyId(companyId);
	}

	/**
	 * Sets whether this tipo evento is costiero.
	 *
	 * @param costiero the costiero of this tipo evento
	 */
	@Override
	public void setCostiero(boolean costiero) {
		_tipoEvento.setCostiero(costiero);
	}

	/**
	 * Sets the create date of this tipo evento.
	 *
	 * @param createDate the create date of this tipo evento
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_tipoEvento.setCreateDate(createDate);
	}

	/**
	 * Sets the data fine of this tipo evento.
	 *
	 * @param dataFine the data fine of this tipo evento
	 */
	@Override
	public void setDataFine(Date dataFine) {
		_tipoEvento.setDataFine(dataFine);
	}

	/**
	 * Sets the data inizio of this tipo evento.
	 *
	 * @param dataInizio the data inizio of this tipo evento
	 */
	@Override
	public void setDataInizio(Date dataInizio) {
		_tipoEvento.setDataInizio(dataInizio);
	}

	/**
	 * Sets the evento ID of this tipo evento.
	 *
	 * @param eventoId the evento ID of this tipo evento
	 */
	@Override
	public void setEventoId(long eventoId) {
		_tipoEvento.setEventoId(eventoId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_tipoEvento.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_tipoEvento.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_tipoEvento.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this tipo evento.
	 *
	 * @param groupId the group ID of this tipo evento
	 */
	@Override
	public void setGroupId(long groupId) {
		_tipoEvento.setGroupId(groupId);
	}

	/**
	 * Sets the indice of this tipo evento.
	 *
	 * @param indice the indice of this tipo evento
	 */
	@Override
	public void setIndice(int indice) {
		_tipoEvento.setIndice(indice);
	}

	/**
	 * Sets the modified date of this tipo evento.
	 *
	 * @param modifiedDate the modified date of this tipo evento
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_tipoEvento.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_tipoEvento.setNew(n);
	}

	/**
	 * Sets the nome of this tipo evento.
	 *
	 * @param nome the nome of this tipo evento
	 */
	@Override
	public void setNome(String nome) {
		_tipoEvento.setNome(nome);
	}

	/**
	 * Sets the parent ID of this tipo evento.
	 *
	 * @param parentId the parent ID of this tipo evento
	 */
	@Override
	public void setParentId(long parentId) {
		_tipoEvento.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this tipo evento.
	 *
	 * @param primaryKey the primary key of this tipo evento
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tipoEvento.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_tipoEvento.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets whether this tipo evento is split.
	 *
	 * @param split the split of this tipo evento
	 */
	@Override
	public void setSplit(boolean split) {
		_tipoEvento.setSplit(split);
	}

	/**
	 * Sets the tabella of this tipo evento.
	 *
	 * @param tabella the tabella of this tipo evento
	 */
	@Override
	public void setTabella(int tabella) {
		_tipoEvento.setTabella(tabella);
	}

	/**
	 * Sets the user ID of this tipo evento.
	 *
	 * @param userId the user ID of this tipo evento
	 */
	@Override
	public void setUserId(long userId) {
		_tipoEvento.setUserId(userId);
	}

	/**
	 * Sets the user name of this tipo evento.
	 *
	 * @param userName the user name of this tipo evento
	 */
	@Override
	public void setUserName(String userName) {
		_tipoEvento.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this tipo evento.
	 *
	 * @param userUuid the user uuid of this tipo evento
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_tipoEvento.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this tipo evento.
	 *
	 * @param uuid the uuid of this tipo evento
	 */
	@Override
	public void setUuid(String uuid) {
		_tipoEvento.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.TipoEvento> toCacheModel() {

		return _tipoEvento.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.TipoEvento toEscapedModel() {
		return new TipoEventoWrapper(_tipoEvento.toEscapedModel());
	}

	@Override
	public String toString() {
		return _tipoEvento.toString();
	}

	@Override
	public it.eng.allerter.model.TipoEvento toUnescapedModel() {
		return new TipoEventoWrapper(_tipoEvento.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _tipoEvento.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoEventoWrapper)) {
			return false;
		}

		TipoEventoWrapper tipoEventoWrapper = (TipoEventoWrapper)obj;

		if (Objects.equals(_tipoEvento, tipoEventoWrapper._tipoEvento)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _tipoEvento.getStagedModelType();
	}

	@Override
	public TipoEvento getWrappedModel() {
		return _tipoEvento;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _tipoEvento.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _tipoEvento.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_tipoEvento.resetOriginalValues();
	}

	private final TipoEvento _tipoEvento;

}