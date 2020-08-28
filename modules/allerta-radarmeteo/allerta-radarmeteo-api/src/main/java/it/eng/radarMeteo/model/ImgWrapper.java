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
 * This class is a wrapper for {@link Img}.
 * </p>
 *
 * @author Francesco
 * @see Img
 * @generated
 */
@ProviderType
public class ImgWrapper implements Img, ModelWrapper<Img> {

	public ImgWrapper(Img img) {
		_img = img;
	}

	@Override
	public Class<?> getModelClass() {
		return Img.class;
	}

	@Override
	public String getModelClassName() {
		return Img.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("coord", getCoord());
		attributes.put("palette", getPalette());
		attributes.put("timestamp", getTimestamp());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String coord = (String)attributes.get("coord");

		if (coord != null) {
			setCoord(coord);
		}

		String palette = (String)attributes.get("palette");

		if (palette != null) {
			setPalette(palette);
		}

		Long timestamp = (Long)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	@Override
	public Object clone() {
		return new ImgWrapper((Img)_img.clone());
	}

	@Override
	public int compareTo(it.eng.radarMeteo.model.Img img) {
		return _img.compareTo(img);
	}

	/**
	 * Returns the coord of this img.
	 *
	 * @return the coord of this img
	 */
	@Override
	public String getCoord() {
		return _img.getCoord();
	}

	/**
	 * Returns the data of this img.
	 *
	 * @return the data of this img
	 */
	@Override
	public String getData() {
		return _img.getData();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _img.getExpandoBridge();
	}

	/**
	 * Returns the ID of this img.
	 *
	 * @return the ID of this img
	 */
	@Override
	public long getId() {
		return _img.getId();
	}

	/**
	 * Returns the palette of this img.
	 *
	 * @return the palette of this img
	 */
	@Override
	public String getPalette() {
		return _img.getPalette();
	}

	/**
	 * Returns the primary key of this img.
	 *
	 * @return the primary key of this img
	 */
	@Override
	public long getPrimaryKey() {
		return _img.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _img.getPrimaryKeyObj();
	}

	/**
	 * Returns the timestamp of this img.
	 *
	 * @return the timestamp of this img
	 */
	@Override
	public long getTimestamp() {
		return _img.getTimestamp();
	}

	@Override
	public int hashCode() {
		return _img.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _img.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _img.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _img.isNew();
	}

	@Override
	public void persist() {
		_img.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_img.setCachedModel(cachedModel);
	}

	/**
	 * Sets the coord of this img.
	 *
	 * @param coord the coord of this img
	 */
	@Override
	public void setCoord(String coord) {
		_img.setCoord(coord);
	}

	/**
	 * Sets the data of this img.
	 *
	 * @param data the data of this img
	 */
	@Override
	public void setData(String data) {
		_img.setData(data);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_img.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_img.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_img.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this img.
	 *
	 * @param id the ID of this img
	 */
	@Override
	public void setId(long id) {
		_img.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_img.setNew(n);
	}

	/**
	 * Sets the palette of this img.
	 *
	 * @param palette the palette of this img
	 */
	@Override
	public void setPalette(String palette) {
		_img.setPalette(palette);
	}

	/**
	 * Sets the primary key of this img.
	 *
	 * @param primaryKey the primary key of this img
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_img.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_img.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the timestamp of this img.
	 *
	 * @param timestamp the timestamp of this img
	 */
	@Override
	public void setTimestamp(long timestamp) {
		_img.setTimestamp(timestamp);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.radarMeteo.model.Img> toCacheModel() {

		return _img.toCacheModel();
	}

	@Override
	public it.eng.radarMeteo.model.Img toEscapedModel() {
		return new ImgWrapper(_img.toEscapedModel());
	}

	@Override
	public String toString() {
		return _img.toString();
	}

	@Override
	public it.eng.radarMeteo.model.Img toUnescapedModel() {
		return new ImgWrapper(_img.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _img.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImgWrapper)) {
			return false;
		}

		ImgWrapper imgWrapper = (ImgWrapper)obj;

		if (Objects.equals(_img, imgWrapper._img)) {
			return true;
		}

		return false;
	}

	@Override
	public Img getWrappedModel() {
		return _img;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _img.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _img.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_img.resetOriginalValues();
	}

	private final Img _img;

}