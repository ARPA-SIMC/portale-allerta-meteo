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

package it.eng.allerta.messages.services.model;

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
 * This class is a wrapper for {@link Auth}.
 * </p>
 *
 * @author Giorgianni_F
 * @see Auth
 * @generated
 */
@ProviderType
public class AuthWrapper implements Auth, ModelWrapper<Auth> {

	public AuthWrapper(Auth auth) {
		_auth = auth;
	}

	@Override
	public Class<?> getModelClass() {
		return Auth.class;
	}

	@Override
	public String getModelClassName() {
		return Auth.class.getName();
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
		return new AuthWrapper((Auth)_auth.clone());
	}

	@Override
	public int compareTo(it.eng.allerta.messages.services.model.Auth auth) {
		return _auth.compareTo(auth);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _auth.getExpandoBridge();
	}

	/**
	 * Returns the key of this auth.
	 *
	 * @return the key of this auth
	 */
	@Override
	public String getKey() {
		return _auth.getKey();
	}

	/**
	 * Returns the primary key of this auth.
	 *
	 * @return the primary key of this auth
	 */
	@Override
	public String getPrimaryKey() {
		return _auth.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _auth.getPrimaryKeyObj();
	}

	/**
	 * Returns the value of this auth.
	 *
	 * @return the value of this auth
	 */
	@Override
	public String getValue() {
		return _auth.getValue();
	}

	@Override
	public int hashCode() {
		return _auth.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _auth.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _auth.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _auth.isNew();
	}

	@Override
	public void persist() {
		_auth.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_auth.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_auth.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_auth.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_auth.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the key of this auth.
	 *
	 * @param key the key of this auth
	 */
	@Override
	public void setKey(String key) {
		_auth.setKey(key);
	}

	@Override
	public void setNew(boolean n) {
		_auth.setNew(n);
	}

	/**
	 * Sets the primary key of this auth.
	 *
	 * @param primaryKey the primary key of this auth
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_auth.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_auth.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the value of this auth.
	 *
	 * @param value the value of this auth
	 */
	@Override
	public void setValue(String value) {
		_auth.setValue(value);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerta.messages.services.model.Auth> toCacheModel() {

		return _auth.toCacheModel();
	}

	@Override
	public it.eng.allerta.messages.services.model.Auth toEscapedModel() {
		return new AuthWrapper(_auth.toEscapedModel());
	}

	@Override
	public String toString() {
		return _auth.toString();
	}

	@Override
	public it.eng.allerta.messages.services.model.Auth toUnescapedModel() {
		return new AuthWrapper(_auth.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _auth.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthWrapper)) {
			return false;
		}

		AuthWrapper authWrapper = (AuthWrapper)obj;

		if (Objects.equals(_auth, authWrapper._auth)) {
			return true;
		}

		return false;
	}

	@Override
	public Auth getWrappedModel() {
		return _auth;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _auth.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _auth.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_auth.resetOriginalValues();
	}

	private final Auth _auth;

}