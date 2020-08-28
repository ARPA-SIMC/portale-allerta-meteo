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
 * This class is a wrapper for {@link AnimeteoSmallImg}.
 * </p>
 *
 * @author UTENTE
 * @see AnimeteoSmallImg
 * @generated
 */
@ProviderType
public class AnimeteoSmallImgWrapper
	implements AnimeteoSmallImg, ModelWrapper<AnimeteoSmallImg> {

	public AnimeteoSmallImgWrapper(AnimeteoSmallImg animeteoSmallImg) {
		_animeteoSmallImg = animeteoSmallImg;
	}

	@Override
	public Class<?> getModelClass() {
		return AnimeteoSmallImg.class;
	}

	@Override
	public String getModelClassName() {
		return AnimeteoSmallImg.class.getName();
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
		return new AnimeteoSmallImgWrapper(
			(AnimeteoSmallImg)_animeteoSmallImg.clone());
	}

	@Override
	public int compareTo(
		it.eng.animaeteo.model.AnimeteoSmallImg animeteoSmallImg) {

		return _animeteoSmallImg.compareTo(animeteoSmallImg);
	}

	/**
	 * Returns the data of this animeteo small img.
	 *
	 * @return the data of this animeteo small img
	 */
	@Override
	public String getData() {
		return _animeteoSmallImg.getData();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _animeteoSmallImg.getExpandoBridge();
	}

	/**
	 * Returns the ID of this animeteo small img.
	 *
	 * @return the ID of this animeteo small img
	 */
	@Override
	public long getId() {
		return _animeteoSmallImg.getId();
	}

	/**
	 * Returns the inserted of this animeteo small img.
	 *
	 * @return the inserted of this animeteo small img
	 */
	@Override
	public Date getInserted() {
		return _animeteoSmallImg.getInserted();
	}

	/**
	 * Returns the name of this animeteo small img.
	 *
	 * @return the name of this animeteo small img
	 */
	@Override
	public String getName() {
		return _animeteoSmallImg.getName();
	}

	/**
	 * Returns the primary key of this animeteo small img.
	 *
	 * @return the primary key of this animeteo small img
	 */
	@Override
	public long getPrimaryKey() {
		return _animeteoSmallImg.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _animeteoSmallImg.getPrimaryKeyObj();
	}

	/**
	 * Returns the type of this animeteo small img.
	 *
	 * @return the type of this animeteo small img
	 */
	@Override
	public String getType() {
		return _animeteoSmallImg.getType();
	}

	@Override
	public int hashCode() {
		return _animeteoSmallImg.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _animeteoSmallImg.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _animeteoSmallImg.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _animeteoSmallImg.isNew();
	}

	@Override
	public void persist() {
		_animeteoSmallImg.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_animeteoSmallImg.setCachedModel(cachedModel);
	}

	/**
	 * Sets the data of this animeteo small img.
	 *
	 * @param data the data of this animeteo small img
	 */
	@Override
	public void setData(String data) {
		_animeteoSmallImg.setData(data);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_animeteoSmallImg.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_animeteoSmallImg.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_animeteoSmallImg.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this animeteo small img.
	 *
	 * @param id the ID of this animeteo small img
	 */
	@Override
	public void setId(long id) {
		_animeteoSmallImg.setId(id);
	}

	/**
	 * Sets the inserted of this animeteo small img.
	 *
	 * @param inserted the inserted of this animeteo small img
	 */
	@Override
	public void setInserted(Date inserted) {
		_animeteoSmallImg.setInserted(inserted);
	}

	/**
	 * Sets the name of this animeteo small img.
	 *
	 * @param name the name of this animeteo small img
	 */
	@Override
	public void setName(String name) {
		_animeteoSmallImg.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_animeteoSmallImg.setNew(n);
	}

	/**
	 * Sets the primary key of this animeteo small img.
	 *
	 * @param primaryKey the primary key of this animeteo small img
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_animeteoSmallImg.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_animeteoSmallImg.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the type of this animeteo small img.
	 *
	 * @param type the type of this animeteo small img
	 */
	@Override
	public void setType(String type) {
		_animeteoSmallImg.setType(type);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.animaeteo.model.AnimeteoSmallImg> toCacheModel() {

		return _animeteoSmallImg.toCacheModel();
	}

	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg toEscapedModel() {
		return new AnimeteoSmallImgWrapper(_animeteoSmallImg.toEscapedModel());
	}

	@Override
	public String toString() {
		return _animeteoSmallImg.toString();
	}

	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg toUnescapedModel() {
		return new AnimeteoSmallImgWrapper(
			_animeteoSmallImg.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _animeteoSmallImg.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnimeteoSmallImgWrapper)) {
			return false;
		}

		AnimeteoSmallImgWrapper animeteoSmallImgWrapper =
			(AnimeteoSmallImgWrapper)obj;

		if (Objects.equals(
				_animeteoSmallImg, animeteoSmallImgWrapper._animeteoSmallImg)) {

			return true;
		}

		return false;
	}

	@Override
	public AnimeteoSmallImg getWrappedModel() {
		return _animeteoSmallImg;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _animeteoSmallImg.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _animeteoSmallImg.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_animeteoSmallImg.resetOriginalValues();
	}

	private final AnimeteoSmallImg _animeteoSmallImg;

}