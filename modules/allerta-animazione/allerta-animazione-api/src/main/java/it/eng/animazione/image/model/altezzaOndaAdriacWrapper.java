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
 * This class is a wrapper for {@link altezzaOndaAdriac}.
 * </p>
 *
 * @author UTENTE
 * @see altezzaOndaAdriac
 * @generated
 */
@ProviderType
public class altezzaOndaAdriacWrapper
	implements altezzaOndaAdriac, ModelWrapper<altezzaOndaAdriac> {

	public altezzaOndaAdriacWrapper(altezzaOndaAdriac altezzaOndaAdriac) {
		_altezzaOndaAdriac = altezzaOndaAdriac;
	}

	@Override
	public Class<?> getModelClass() {
		return altezzaOndaAdriac.class;
	}

	@Override
	public String getModelClassName() {
		return altezzaOndaAdriac.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("im", getIm());
		attributes.put("text_LOC", getText_LOC());
		attributes.put("ts_UTC", getTs_UTC());
		attributes.put("imgData", getImgData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String im = (String)attributes.get("im");

		if (im != null) {
			setIm(im);
		}

		String text_LOC = (String)attributes.get("text_LOC");

		if (text_LOC != null) {
			setText_LOC(text_LOC);
		}

		Long ts_UTC = (Long)attributes.get("ts_UTC");

		if (ts_UTC != null) {
			setTs_UTC(ts_UTC);
		}

		String imgData = (String)attributes.get("imgData");

		if (imgData != null) {
			setImgData(imgData);
		}
	}

	@Override
	public Object clone() {
		return new altezzaOndaAdriacWrapper(
			(altezzaOndaAdriac)_altezzaOndaAdriac.clone());
	}

	@Override
	public int compareTo(
		it.eng.animazione.image.model.altezzaOndaAdriac altezzaOndaAdriac) {

		return _altezzaOndaAdriac.compareTo(altezzaOndaAdriac);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _altezzaOndaAdriac.getExpandoBridge();
	}

	/**
	 * Returns the ID of this altezza onda adriac.
	 *
	 * @return the ID of this altezza onda adriac
	 */
	@Override
	public long getId() {
		return _altezzaOndaAdriac.getId();
	}

	/**
	 * Returns the im of this altezza onda adriac.
	 *
	 * @return the im of this altezza onda adriac
	 */
	@Override
	public String getIm() {
		return _altezzaOndaAdriac.getIm();
	}

	/**
	 * Returns the img data of this altezza onda adriac.
	 *
	 * @return the img data of this altezza onda adriac
	 */
	@Override
	public String getImgData() {
		return _altezzaOndaAdriac.getImgData();
	}

	/**
	 * Returns the primary key of this altezza onda adriac.
	 *
	 * @return the primary key of this altezza onda adriac
	 */
	@Override
	public long getPrimaryKey() {
		return _altezzaOndaAdriac.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _altezzaOndaAdriac.getPrimaryKeyObj();
	}

	/**
	 * Returns the text_loc of this altezza onda adriac.
	 *
	 * @return the text_loc of this altezza onda adriac
	 */
	@Override
	public String getText_LOC() {
		return _altezzaOndaAdriac.getText_LOC();
	}

	/**
	 * Returns the ts_utc of this altezza onda adriac.
	 *
	 * @return the ts_utc of this altezza onda adriac
	 */
	@Override
	public long getTs_UTC() {
		return _altezzaOndaAdriac.getTs_UTC();
	}

	@Override
	public int hashCode() {
		return _altezzaOndaAdriac.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _altezzaOndaAdriac.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _altezzaOndaAdriac.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _altezzaOndaAdriac.isNew();
	}

	@Override
	public void persist() {
		_altezzaOndaAdriac.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_altezzaOndaAdriac.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_altezzaOndaAdriac.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_altezzaOndaAdriac.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_altezzaOndaAdriac.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this altezza onda adriac.
	 *
	 * @param id the ID of this altezza onda adriac
	 */
	@Override
	public void setId(long id) {
		_altezzaOndaAdriac.setId(id);
	}

	/**
	 * Sets the im of this altezza onda adriac.
	 *
	 * @param im the im of this altezza onda adriac
	 */
	@Override
	public void setIm(String im) {
		_altezzaOndaAdriac.setIm(im);
	}

	/**
	 * Sets the img data of this altezza onda adriac.
	 *
	 * @param imgData the img data of this altezza onda adriac
	 */
	@Override
	public void setImgData(String imgData) {
		_altezzaOndaAdriac.setImgData(imgData);
	}

	@Override
	public void setNew(boolean n) {
		_altezzaOndaAdriac.setNew(n);
	}

	/**
	 * Sets the primary key of this altezza onda adriac.
	 *
	 * @param primaryKey the primary key of this altezza onda adriac
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_altezzaOndaAdriac.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_altezzaOndaAdriac.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the text_loc of this altezza onda adriac.
	 *
	 * @param text_LOC the text_loc of this altezza onda adriac
	 */
	@Override
	public void setText_LOC(String text_LOC) {
		_altezzaOndaAdriac.setText_LOC(text_LOC);
	}

	/**
	 * Sets the ts_utc of this altezza onda adriac.
	 *
	 * @param ts_UTC the ts_utc of this altezza onda adriac
	 */
	@Override
	public void setTs_UTC(long ts_UTC) {
		_altezzaOndaAdriac.setTs_UTC(ts_UTC);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.animazione.image.model.altezzaOndaAdriac> toCacheModel() {

		return _altezzaOndaAdriac.toCacheModel();
	}

	@Override
	public it.eng.animazione.image.model.altezzaOndaAdriac toEscapedModel() {
		return new altezzaOndaAdriacWrapper(
			_altezzaOndaAdriac.toEscapedModel());
	}

	@Override
	public String toString() {
		return _altezzaOndaAdriac.toString();
	}

	@Override
	public it.eng.animazione.image.model.altezzaOndaAdriac toUnescapedModel() {
		return new altezzaOndaAdriacWrapper(
			_altezzaOndaAdriac.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _altezzaOndaAdriac.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof altezzaOndaAdriacWrapper)) {
			return false;
		}

		altezzaOndaAdriacWrapper altezzaOndaAdriacWrapper =
			(altezzaOndaAdriacWrapper)obj;

		if (Objects.equals(
				_altezzaOndaAdriac,
				altezzaOndaAdriacWrapper._altezzaOndaAdriac)) {

			return true;
		}

		return false;
	}

	@Override
	public altezzaOndaAdriac getWrappedModel() {
		return _altezzaOndaAdriac;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _altezzaOndaAdriac.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _altezzaOndaAdriac.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_altezzaOndaAdriac.resetOriginalValues();
	}

	private final altezzaOndaAdriac _altezzaOndaAdriac;

}