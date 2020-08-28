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

package it.eng.previsioni.meteo.model;

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
 * This class is a wrapper for {@link Img}.
 * </p>
 *
 * @author Brian Wing Shun Chan
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
		attributes.put("daypart", getDaypart());
		attributes.put("day", getDay());
		attributes.put("provincia", getProvincia());
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

		String daypart = (String)attributes.get("daypart");

		if (daypart != null) {
			setDaypart(daypart);
		}

		String day = (String)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
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
		return new ImgWrapper((Img)_img.clone());
	}

	@Override
	public int compareTo(it.eng.previsioni.meteo.model.Img img) {
		return _img.compareTo(img);
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

	/**
	 * Returns the day of this img.
	 *
	 * @return the day of this img
	 */
	@Override
	public String getDay() {
		return _img.getDay();
	}

	/**
	 * Returns the daypart of this img.
	 *
	 * @return the daypart of this img
	 */
	@Override
	public String getDaypart() {
		return _img.getDaypart();
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
	 * Returns the inserted of this img.
	 *
	 * @return the inserted of this img
	 */
	@Override
	public Date getInserted() {
		return _img.getInserted();
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
	 * Returns the provincia of this img.
	 *
	 * @return the provincia of this img
	 */
	@Override
	public String getProvincia() {
		return _img.getProvincia();
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
	 * Sets the data of this img.
	 *
	 * @param data the data of this img
	 */
	@Override
	public void setData(String data) {
		_img.setData(data);
	}

	/**
	 * Sets the day of this img.
	 *
	 * @param day the day of this img
	 */
	@Override
	public void setDay(String day) {
		_img.setDay(day);
	}

	/**
	 * Sets the daypart of this img.
	 *
	 * @param daypart the daypart of this img
	 */
	@Override
	public void setDaypart(String daypart) {
		_img.setDaypart(daypart);
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

	/**
	 * Sets the inserted of this img.
	 *
	 * @param inserted the inserted of this img
	 */
	@Override
	public void setInserted(Date inserted) {
		_img.setInserted(inserted);
	}

	@Override
	public void setNew(boolean n) {
		_img.setNew(n);
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
	 * Sets the provincia of this img.
	 *
	 * @param provincia the provincia of this img
	 */
	@Override
	public void setProvincia(String provincia) {
		_img.setProvincia(provincia);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.previsioni.meteo.model.Img> toCacheModel() {

		return _img.toCacheModel();
	}

	@Override
	public it.eng.previsioni.meteo.model.Img toEscapedModel() {
		return new ImgWrapper(_img.toEscapedModel());
	}

	@Override
	public String toString() {
		return _img.toString();
	}

	@Override
	public it.eng.previsioni.meteo.model.Img toUnescapedModel() {
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