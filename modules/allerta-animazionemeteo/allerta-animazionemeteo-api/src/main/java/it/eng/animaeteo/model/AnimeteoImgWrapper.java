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

package it.eng.animaeteo.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link AnimeteoImg}.
 * </p>
 *
 * @author UTENTE
 * @see AnimeteoImg
 * @generated
 */
@ProviderType
public class AnimeteoImgWrapper
	implements AnimeteoImg, ModelWrapper<AnimeteoImg> {

	public AnimeteoImgWrapper(AnimeteoImg animeteoImg) {
		_animeteoImg = animeteoImg;
	}

	@Override
	public Class<?> getModelClass() {
		return AnimeteoImg.class;
	}

	@Override
	public String getModelClassName() {
		return AnimeteoImg.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Date inserted = (Date)attributes.get("inserted");

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
		return new AnimeteoImgWrapper((AnimeteoImg)_animeteoImg.clone());
	}

	@Override
	public int compareTo(it.eng.animaeteo.model.AnimeteoImg animeteoImg) {
		return _animeteoImg.compareTo(animeteoImg);
	}

	/**
	 * Returns the data of this animeteo img.
	 *
	 * @return the data of this animeteo img
	 */
	@Override
	public String getData() {
		return _animeteoImg.getData();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _animeteoImg.getExpandoBridge();
	}

	/**
	 * Returns the ID of this animeteo img.
	 *
	 * @return the ID of this animeteo img
	 */
	@Override
	public long getId() {
		return _animeteoImg.getId();
	}

	/**
	 * Returns the inserted of this animeteo img.
	 *
	 * @return the inserted of this animeteo img
	 */
	@Override
	public Date getInserted() {
		return _animeteoImg.getInserted();
	}

	/**
	 * Returns the name of this animeteo img.
	 *
	 * @return the name of this animeteo img
	 */
	@Override
	public String getName() {
		return _animeteoImg.getName();
	}

	/**
	 * Returns the primary key of this animeteo img.
	 *
	 * @return the primary key of this animeteo img
	 */
	@Override
	public long getPrimaryKey() {
		return _animeteoImg.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _animeteoImg.getPrimaryKeyObj();
	}

	/**
	 * Returns the type of this animeteo img.
	 *
	 * @return the type of this animeteo img
	 */
	@Override
	public String getType() {
		return _animeteoImg.getType();
	}

	@Override
	public int hashCode() {
		return _animeteoImg.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _animeteoImg.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _animeteoImg.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _animeteoImg.isNew();
	}

	@Override
	public void persist() {
		_animeteoImg.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_animeteoImg.setCachedModel(cachedModel);
	}

	/**
	 * Sets the data of this animeteo img.
	 *
	 * @param data the data of this animeteo img
	 */
	@Override
	public void setData(String data) {
		_animeteoImg.setData(data);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_animeteoImg.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_animeteoImg.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_animeteoImg.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this animeteo img.
	 *
	 * @param id the ID of this animeteo img
	 */
	@Override
	public void setId(long id) {
		_animeteoImg.setId(id);
	}

	/**
	 * Sets the inserted of this animeteo img.
	 *
	 * @param inserted the inserted of this animeteo img
	 */
	@Override
	public void setInserted(Date inserted) {
		_animeteoImg.setInserted(inserted);
	}

	/**
	 * Sets the name of this animeteo img.
	 *
	 * @param name the name of this animeteo img
	 */
	@Override
	public void setName(String name) {
		_animeteoImg.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_animeteoImg.setNew(n);
	}

	/**
	 * Sets the primary key of this animeteo img.
	 *
	 * @param primaryKey the primary key of this animeteo img
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_animeteoImg.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_animeteoImg.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the type of this animeteo img.
	 *
	 * @param type the type of this animeteo img
	 */
	@Override
	public void setType(String type) {
		_animeteoImg.setType(type);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.animaeteo.model.AnimeteoImg> toCacheModel() {

		return _animeteoImg.toCacheModel();
	}

	@Override
	public it.eng.animaeteo.model.AnimeteoImg toEscapedModel() {
		return new AnimeteoImgWrapper(_animeteoImg.toEscapedModel());
	}

	@Override
	public String toString() {
		return _animeteoImg.toString();
	}

	@Override
	public it.eng.animaeteo.model.AnimeteoImg toUnescapedModel() {
		return new AnimeteoImgWrapper(_animeteoImg.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _animeteoImg.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnimeteoImgWrapper)) {
			return false;
		}

		AnimeteoImgWrapper animeteoImgWrapper = (AnimeteoImgWrapper)obj;

		if (Objects.equals(_animeteoImg, animeteoImgWrapper._animeteoImg)) {
			return true;
		}

		return false;
	}

	@Override
	public AnimeteoImg getWrappedModel() {
		return _animeteoImg;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _animeteoImg.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _animeteoImg.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_animeteoImg.resetOriginalValues();
	}

	private final AnimeteoImg _animeteoImg;

}