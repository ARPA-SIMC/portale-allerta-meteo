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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link RegolaAllarmeComune}.
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmeComune
 * @generated
 */
@ProviderType
public class RegolaAllarmeComuneWrapper
	implements RegolaAllarmeComune, ModelWrapper<RegolaAllarmeComune> {

	public RegolaAllarmeComuneWrapper(RegolaAllarmeComune regolaAllarmeComune) {
		_regolaAllarmeComune = regolaAllarmeComune;
	}

	@Override
	public Class<?> getModelClass() {
		return RegolaAllarmeComune.class;
	}

	@Override
	public String getModelClassName() {
		return RegolaAllarmeComune.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("idRegola", getIdRegola());
		attributes.put("idComune", getIdComune());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long idRegola = (Long)attributes.get("idRegola");

		if (idRegola != null) {
			setIdRegola(idRegola);
		}

		Long idComune = (Long)attributes.get("idComune");

		if (idComune != null) {
			setIdComune(idComune);
		}
	}

	@Override
	public Object clone() {
		return new RegolaAllarmeComuneWrapper(
			(RegolaAllarmeComune)_regolaAllarmeComune.clone());
	}

	@Override
	public int compareTo(
		it.eng.bollettino.model.RegolaAllarmeComune regolaAllarmeComune) {

		return _regolaAllarmeComune.compareTo(regolaAllarmeComune);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _regolaAllarmeComune.getExpandoBridge();
	}

	/**
	 * Returns the ID of this regola allarme comune.
	 *
	 * @return the ID of this regola allarme comune
	 */
	@Override
	public long getId() {
		return _regolaAllarmeComune.getId();
	}

	/**
	 * Returns the id comune of this regola allarme comune.
	 *
	 * @return the id comune of this regola allarme comune
	 */
	@Override
	public long getIdComune() {
		return _regolaAllarmeComune.getIdComune();
	}

	/**
	 * Returns the id regola of this regola allarme comune.
	 *
	 * @return the id regola of this regola allarme comune
	 */
	@Override
	public long getIdRegola() {
		return _regolaAllarmeComune.getIdRegola();
	}

	/**
	 * Returns the primary key of this regola allarme comune.
	 *
	 * @return the primary key of this regola allarme comune
	 */
	@Override
	public long getPrimaryKey() {
		return _regolaAllarmeComune.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _regolaAllarmeComune.getPrimaryKeyObj();
	}

	/**
	 * Returns the uuid of this regola allarme comune.
	 *
	 * @return the uuid of this regola allarme comune
	 */
	@Override
	public String getUuid() {
		return _regolaAllarmeComune.getUuid();
	}

	@Override
	public int hashCode() {
		return _regolaAllarmeComune.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _regolaAllarmeComune.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _regolaAllarmeComune.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _regolaAllarmeComune.isNew();
	}

	@Override
	public void persist() {
		_regolaAllarmeComune.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_regolaAllarmeComune.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_regolaAllarmeComune.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_regolaAllarmeComune.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_regolaAllarmeComune.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this regola allarme comune.
	 *
	 * @param id the ID of this regola allarme comune
	 */
	@Override
	public void setId(long id) {
		_regolaAllarmeComune.setId(id);
	}

	/**
	 * Sets the id comune of this regola allarme comune.
	 *
	 * @param idComune the id comune of this regola allarme comune
	 */
	@Override
	public void setIdComune(long idComune) {
		_regolaAllarmeComune.setIdComune(idComune);
	}

	/**
	 * Sets the id regola of this regola allarme comune.
	 *
	 * @param idRegola the id regola of this regola allarme comune
	 */
	@Override
	public void setIdRegola(long idRegola) {
		_regolaAllarmeComune.setIdRegola(idRegola);
	}

	@Override
	public void setNew(boolean n) {
		_regolaAllarmeComune.setNew(n);
	}

	/**
	 * Sets the primary key of this regola allarme comune.
	 *
	 * @param primaryKey the primary key of this regola allarme comune
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_regolaAllarmeComune.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_regolaAllarmeComune.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the uuid of this regola allarme comune.
	 *
	 * @param uuid the uuid of this regola allarme comune
	 */
	@Override
	public void setUuid(String uuid) {
		_regolaAllarmeComune.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.RegolaAllarmeComune> toCacheModel() {

		return _regolaAllarmeComune.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.RegolaAllarmeComune toEscapedModel() {
		return new RegolaAllarmeComuneWrapper(
			_regolaAllarmeComune.toEscapedModel());
	}

	@Override
	public String toString() {
		return _regolaAllarmeComune.toString();
	}

	@Override
	public it.eng.bollettino.model.RegolaAllarmeComune toUnescapedModel() {
		return new RegolaAllarmeComuneWrapper(
			_regolaAllarmeComune.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _regolaAllarmeComune.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegolaAllarmeComuneWrapper)) {
			return false;
		}

		RegolaAllarmeComuneWrapper regolaAllarmeComuneWrapper =
			(RegolaAllarmeComuneWrapper)obj;

		if (Objects.equals(
				_regolaAllarmeComune,
				regolaAllarmeComuneWrapper._regolaAllarmeComune)) {

			return true;
		}

		return false;
	}

	@Override
	public RegolaAllarmeComune getWrappedModel() {
		return _regolaAllarmeComune;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _regolaAllarmeComune.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _regolaAllarmeComune.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_regolaAllarmeComune.resetOriginalValues();
	}

	private final RegolaAllarmeComune _regolaAllarmeComune;

}