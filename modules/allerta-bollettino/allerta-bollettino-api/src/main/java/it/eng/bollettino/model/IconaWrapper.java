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
 * This class is a wrapper for {@link Icona}.
 * </p>
 *
 * @author GFAVINI
 * @see Icona
 * @generated
 */
@ProviderType
public class IconaWrapper implements Icona, ModelWrapper<Icona> {

	public IconaWrapper(Icona icona) {
		_icona = icona;
	}

	@Override
	public Class<?> getModelClass() {
		return Icona.class;
	}

	@Override
	public String getModelClassName() {
		return Icona.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("path", getPath());
		attributes.put("descrizione", getDescrizione());

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

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public Object clone() {
		return new IconaWrapper((Icona)_icona.clone());
	}

	@Override
	public int compareTo(it.eng.bollettino.model.Icona icona) {
		return _icona.compareTo(icona);
	}

	/**
	 * Returns the descrizione of this icona.
	 *
	 * @return the descrizione of this icona
	 */
	@Override
	public String getDescrizione() {
		return _icona.getDescrizione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _icona.getExpandoBridge();
	}

	/**
	 * Returns the ID of this icona.
	 *
	 * @return the ID of this icona
	 */
	@Override
	public long getId() {
		return _icona.getId();
	}

	/**
	 * Returns the path of this icona.
	 *
	 * @return the path of this icona
	 */
	@Override
	public String getPath() {
		return _icona.getPath();
	}

	/**
	 * Returns the primary key of this icona.
	 *
	 * @return the primary key of this icona
	 */
	@Override
	public long getPrimaryKey() {
		return _icona.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _icona.getPrimaryKeyObj();
	}

	/**
	 * Returns the uuid of this icona.
	 *
	 * @return the uuid of this icona
	 */
	@Override
	public String getUuid() {
		return _icona.getUuid();
	}

	@Override
	public int hashCode() {
		return _icona.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _icona.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _icona.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _icona.isNew();
	}

	@Override
	public void persist() {
		_icona.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_icona.setCachedModel(cachedModel);
	}

	/**
	 * Sets the descrizione of this icona.
	 *
	 * @param descrizione the descrizione of this icona
	 */
	@Override
	public void setDescrizione(String descrizione) {
		_icona.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_icona.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_icona.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_icona.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this icona.
	 *
	 * @param id the ID of this icona
	 */
	@Override
	public void setId(long id) {
		_icona.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_icona.setNew(n);
	}

	/**
	 * Sets the path of this icona.
	 *
	 * @param path the path of this icona
	 */
	@Override
	public void setPath(String path) {
		_icona.setPath(path);
	}

	/**
	 * Sets the primary key of this icona.
	 *
	 * @param primaryKey the primary key of this icona
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_icona.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_icona.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the uuid of this icona.
	 *
	 * @param uuid the uuid of this icona
	 */
	@Override
	public void setUuid(String uuid) {
		_icona.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.Icona> toCacheModel() {

		return _icona.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.Icona toEscapedModel() {
		return new IconaWrapper(_icona.toEscapedModel());
	}

	@Override
	public String toString() {
		return _icona.toString();
	}

	@Override
	public it.eng.bollettino.model.Icona toUnescapedModel() {
		return new IconaWrapper(_icona.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _icona.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IconaWrapper)) {
			return false;
		}

		IconaWrapper iconaWrapper = (IconaWrapper)obj;

		if (Objects.equals(_icona, iconaWrapper._icona)) {
			return true;
		}

		return false;
	}

	@Override
	public Icona getWrappedModel() {
		return _icona;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _icona.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _icona.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_icona.resetOriginalValues();
	}

	private final Icona _icona;

}