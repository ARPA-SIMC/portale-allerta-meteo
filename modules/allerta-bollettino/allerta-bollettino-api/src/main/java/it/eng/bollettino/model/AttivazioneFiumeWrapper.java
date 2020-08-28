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
 * This class is a wrapper for {@link AttivazioneFiume}.
 * </p>
 *
 * @author GFAVINI
 * @see AttivazioneFiume
 * @generated
 */
@ProviderType
public class AttivazioneFiumeWrapper
	implements AttivazioneFiume, ModelWrapper<AttivazioneFiume> {

	public AttivazioneFiumeWrapper(AttivazioneFiume attivazioneFiume) {
		_attivazioneFiume = attivazioneFiume;
	}

	@Override
	public Class<?> getModelClass() {
		return AttivazioneFiume.class;
	}

	@Override
	public String getModelClassName() {
		return AttivazioneFiume.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fiumeId", getFiumeId());
		attributes.put("attivo", isAttivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String fiumeId = (String)attributes.get("fiumeId");

		if (fiumeId != null) {
			setFiumeId(fiumeId);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
		}
	}

	@Override
	public Object clone() {
		return new AttivazioneFiumeWrapper(
			(AttivazioneFiume)_attivazioneFiume.clone());
	}

	@Override
	public int compareTo(
		it.eng.bollettino.model.AttivazioneFiume attivazioneFiume) {

		return _attivazioneFiume.compareTo(attivazioneFiume);
	}

	/**
	 * Returns the attivo of this attivazione fiume.
	 *
	 * @return the attivo of this attivazione fiume
	 */
	@Override
	public boolean getAttivo() {
		return _attivazioneFiume.getAttivo();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _attivazioneFiume.getExpandoBridge();
	}

	/**
	 * Returns the fiume ID of this attivazione fiume.
	 *
	 * @return the fiume ID of this attivazione fiume
	 */
	@Override
	public String getFiumeId() {
		return _attivazioneFiume.getFiumeId();
	}

	/**
	 * Returns the primary key of this attivazione fiume.
	 *
	 * @return the primary key of this attivazione fiume
	 */
	@Override
	public String getPrimaryKey() {
		return _attivazioneFiume.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _attivazioneFiume.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _attivazioneFiume.hashCode();
	}

	/**
	 * Returns <code>true</code> if this attivazione fiume is attivo.
	 *
	 * @return <code>true</code> if this attivazione fiume is attivo; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttivo() {
		return _attivazioneFiume.isAttivo();
	}

	@Override
	public boolean isCachedModel() {
		return _attivazioneFiume.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _attivazioneFiume.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _attivazioneFiume.isNew();
	}

	@Override
	public void persist() {
		_attivazioneFiume.persist();
	}

	/**
	 * Sets whether this attivazione fiume is attivo.
	 *
	 * @param attivo the attivo of this attivazione fiume
	 */
	@Override
	public void setAttivo(boolean attivo) {
		_attivazioneFiume.setAttivo(attivo);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_attivazioneFiume.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_attivazioneFiume.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_attivazioneFiume.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_attivazioneFiume.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fiume ID of this attivazione fiume.
	 *
	 * @param fiumeId the fiume ID of this attivazione fiume
	 */
	@Override
	public void setFiumeId(String fiumeId) {
		_attivazioneFiume.setFiumeId(fiumeId);
	}

	@Override
	public void setNew(boolean n) {
		_attivazioneFiume.setNew(n);
	}

	/**
	 * Sets the primary key of this attivazione fiume.
	 *
	 * @param primaryKey the primary key of this attivazione fiume
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_attivazioneFiume.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_attivazioneFiume.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.AttivazioneFiume> toCacheModel() {

		return _attivazioneFiume.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.AttivazioneFiume toEscapedModel() {
		return new AttivazioneFiumeWrapper(_attivazioneFiume.toEscapedModel());
	}

	@Override
	public String toString() {
		return _attivazioneFiume.toString();
	}

	@Override
	public it.eng.bollettino.model.AttivazioneFiume toUnescapedModel() {
		return new AttivazioneFiumeWrapper(
			_attivazioneFiume.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _attivazioneFiume.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttivazioneFiumeWrapper)) {
			return false;
		}

		AttivazioneFiumeWrapper attivazioneFiumeWrapper =
			(AttivazioneFiumeWrapper)obj;

		if (Objects.equals(
				_attivazioneFiume, attivazioneFiumeWrapper._attivazioneFiume)) {

			return true;
		}

		return false;
	}

	@Override
	public AttivazioneFiume getWrappedModel() {
		return _attivazioneFiume;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _attivazioneFiume.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _attivazioneFiume.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_attivazioneFiume.resetOriginalValues();
	}

	private final AttivazioneFiume _attivazioneFiume;

}