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

package it.eng.radarMeteo.model;

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
 * This class is a wrapper for {@link Json}.
 * </p>
 *
 * @author Francesco
 * @see Json
 * @generated
 */
@ProviderType
public class JsonWrapper implements Json, ModelWrapper<Json> {

	public JsonWrapper(Json json) {
		_json = json;
	}

	@Override
	public Class<?> getModelClass() {
		return Json.class;
	}

	@Override
	public String getModelClassName() {
		return Json.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("type", getType());
		attributes.put("inserted", getInserted());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long inserted = (Long)attributes.get("inserted");

		if (inserted != null) {
			setInserted(inserted);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	@Override
	public Object clone() {
		return new JsonWrapper((Json)_json.clone());
	}

	@Override
	public int compareTo(it.eng.radarMeteo.model.Json json) {
		return _json.compareTo(json);
	}

	/**
	 * Returns the data of this json.
	 *
	 * @return the data of this json
	 */
	@Override
	public String getData() {
		return _json.getData();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _json.getExpandoBridge();
	}

	/**
	 * Returns the ID of this json.
	 *
	 * @return the ID of this json
	 */
	@Override
	public long getId() {
		return _json.getId();
	}

	/**
	 * Returns the inserted of this json.
	 *
	 * @return the inserted of this json
	 */
	@Override
	public long getInserted() {
		return _json.getInserted();
	}

	/**
	 * Returns the primary key of this json.
	 *
	 * @return the primary key of this json
	 */
	@Override
	public long getPrimaryKey() {
		return _json.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _json.getPrimaryKeyObj();
	}

	/**
	 * Returns the type of this json.
	 *
	 * @return the type of this json
	 */
	@Override
	public String getType() {
		return _json.getType();
	}

	@Override
	public int hashCode() {
		return _json.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _json.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _json.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _json.isNew();
	}

	@Override
	public void persist() {
		_json.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_json.setCachedModel(cachedModel);
	}

	/**
	 * Sets the data of this json.
	 *
	 * @param data the data of this json
	 */
	@Override
	public void setData(String data) {
		_json.setData(data);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_json.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_json.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_json.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this json.
	 *
	 * @param id the ID of this json
	 */
	@Override
	public void setId(long id) {
		_json.setId(id);
	}

	/**
	 * Sets the inserted of this json.
	 *
	 * @param inserted the inserted of this json
	 */
	@Override
	public void setInserted(long inserted) {
		_json.setInserted(inserted);
	}

	@Override
	public void setNew(boolean n) {
		_json.setNew(n);
	}

	/**
	 * Sets the primary key of this json.
	 *
	 * @param primaryKey the primary key of this json
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_json.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_json.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the type of this json.
	 *
	 * @param type the type of this json
	 */
	@Override
	public void setType(String type) {
		_json.setType(type);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.radarMeteo.model.Json> toCacheModel() {

		return _json.toCacheModel();
	}

	@Override
	public it.eng.radarMeteo.model.Json toEscapedModel() {
		return new JsonWrapper(_json.toEscapedModel());
	}

	@Override
	public String toString() {
		return _json.toString();
	}

	@Override
	public it.eng.radarMeteo.model.Json toUnescapedModel() {
		return new JsonWrapper(_json.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _json.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JsonWrapper)) {
			return false;
		}

		JsonWrapper jsonWrapper = (JsonWrapper)obj;

		if (Objects.equals(_json, jsonWrapper._json)) {
			return true;
		}

		return false;
	}

	@Override
	public Json getWrappedModel() {
		return _json;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _json.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _json.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_json.resetOriginalValues();
	}

	private final Json _json;

}