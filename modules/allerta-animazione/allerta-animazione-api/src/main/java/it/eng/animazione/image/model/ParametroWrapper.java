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

package it.eng.animazione.image.model;

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
 * This class is a wrapper for {@link Parametro}.
 * </p>
 *
 * @author UTENTE
 * @see Parametro
 * @generated
 */
@ProviderType
public class ParametroWrapper implements Parametro, ModelWrapper<Parametro> {

	public ParametroWrapper(Parametro parametro) {
		_parametro = parametro;
	}

	@Override
	public Class<?> getModelClass() {
		return Parametro.class;
	}

	@Override
	public String getModelClassName() {
		return Parametro.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("key", getKey());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public Object clone() {
		return new ParametroWrapper((Parametro)_parametro.clone());
	}

	@Override
	public int compareTo(it.eng.animazione.image.model.Parametro parametro) {
		return _parametro.compareTo(parametro);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _parametro.getExpandoBridge();
	}

	/**
	 * Returns the key of this parametro.
	 *
	 * @return the key of this parametro
	 */
	@Override
	public String getKey() {
		return _parametro.getKey();
	}

	/**
	 * Returns the primary key of this parametro.
	 *
	 * @return the primary key of this parametro
	 */
	@Override
	public String getPrimaryKey() {
		return _parametro.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _parametro.getPrimaryKeyObj();
	}

	/**
	 * Returns the value of this parametro.
	 *
	 * @return the value of this parametro
	 */
	@Override
	public String getValue() {
		return _parametro.getValue();
	}

	@Override
	public int hashCode() {
		return _parametro.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _parametro.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _parametro.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _parametro.isNew();
	}

	@Override
	public void persist() {
		_parametro.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_parametro.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_parametro.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_parametro.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_parametro.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the key of this parametro.
	 *
	 * @param key the key of this parametro
	 */
	@Override
	public void setKey(String key) {
		_parametro.setKey(key);
	}

	@Override
	public void setNew(boolean n) {
		_parametro.setNew(n);
	}

	/**
	 * Sets the primary key of this parametro.
	 *
	 * @param primaryKey the primary key of this parametro
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_parametro.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_parametro.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the value of this parametro.
	 *
	 * @param value the value of this parametro
	 */
	@Override
	public void setValue(String value) {
		_parametro.setValue(value);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.animazione.image.model.Parametro> toCacheModel() {

		return _parametro.toCacheModel();
	}

	@Override
	public it.eng.animazione.image.model.Parametro toEscapedModel() {
		return new ParametroWrapper(_parametro.toEscapedModel());
	}

	@Override
	public String toString() {
		return _parametro.toString();
	}

	@Override
	public it.eng.animazione.image.model.Parametro toUnescapedModel() {
		return new ParametroWrapper(_parametro.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _parametro.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ParametroWrapper)) {
			return false;
		}

		ParametroWrapper parametroWrapper = (ParametroWrapper)obj;

		if (Objects.equals(_parametro, parametroWrapper._parametro)) {
			return true;
		}

		return false;
	}

	@Override
	public Parametro getWrappedModel() {
		return _parametro;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _parametro.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _parametro.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_parametro.resetOriginalValues();
	}

	private final Parametro _parametro;

}