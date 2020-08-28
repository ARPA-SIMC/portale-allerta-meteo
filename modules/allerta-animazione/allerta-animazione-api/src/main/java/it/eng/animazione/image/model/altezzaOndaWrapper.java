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
 * This class is a wrapper for {@link altezzaOnda}.
 * </p>
 *
 * @author UTENTE
 * @see altezzaOnda
 * @generated
 */
@ProviderType
public class altezzaOndaWrapper
	implements altezzaOnda, ModelWrapper<altezzaOnda> {

	public altezzaOndaWrapper(altezzaOnda altezzaOnda) {
		_altezzaOnda = altezzaOnda;
	}

	@Override
	public Class<?> getModelClass() {
		return altezzaOnda.class;
	}

	@Override
	public String getModelClassName() {
		return altezzaOnda.class.getName();
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
		return new altezzaOndaWrapper((altezzaOnda)_altezzaOnda.clone());
	}

	@Override
	public int compareTo(
		it.eng.animazione.image.model.altezzaOnda altezzaOnda) {

		return _altezzaOnda.compareTo(altezzaOnda);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _altezzaOnda.getExpandoBridge();
	}

	/**
	 * Returns the ID of this altezza onda.
	 *
	 * @return the ID of this altezza onda
	 */
	@Override
	public long getId() {
		return _altezzaOnda.getId();
	}

	/**
	 * Returns the im of this altezza onda.
	 *
	 * @return the im of this altezza onda
	 */
	@Override
	public String getIm() {
		return _altezzaOnda.getIm();
	}

	/**
	 * Returns the img data of this altezza onda.
	 *
	 * @return the img data of this altezza onda
	 */
	@Override
	public String getImgData() {
		return _altezzaOnda.getImgData();
	}

	/**
	 * Returns the primary key of this altezza onda.
	 *
	 * @return the primary key of this altezza onda
	 */
	@Override
	public long getPrimaryKey() {
		return _altezzaOnda.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _altezzaOnda.getPrimaryKeyObj();
	}

	/**
	 * Returns the text_loc of this altezza onda.
	 *
	 * @return the text_loc of this altezza onda
	 */
	@Override
	public String getText_LOC() {
		return _altezzaOnda.getText_LOC();
	}

	/**
	 * Returns the ts_utc of this altezza onda.
	 *
	 * @return the ts_utc of this altezza onda
	 */
	@Override
	public long getTs_UTC() {
		return _altezzaOnda.getTs_UTC();
	}

	@Override
	public int hashCode() {
		return _altezzaOnda.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _altezzaOnda.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _altezzaOnda.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _altezzaOnda.isNew();
	}

	@Override
	public void persist() {
		_altezzaOnda.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_altezzaOnda.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_altezzaOnda.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_altezzaOnda.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_altezzaOnda.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this altezza onda.
	 *
	 * @param id the ID of this altezza onda
	 */
	@Override
	public void setId(long id) {
		_altezzaOnda.setId(id);
	}

	/**
	 * Sets the im of this altezza onda.
	 *
	 * @param im the im of this altezza onda
	 */
	@Override
	public void setIm(String im) {
		_altezzaOnda.setIm(im);
	}

	/**
	 * Sets the img data of this altezza onda.
	 *
	 * @param imgData the img data of this altezza onda
	 */
	@Override
	public void setImgData(String imgData) {
		_altezzaOnda.setImgData(imgData);
	}

	@Override
	public void setNew(boolean n) {
		_altezzaOnda.setNew(n);
	}

	/**
	 * Sets the primary key of this altezza onda.
	 *
	 * @param primaryKey the primary key of this altezza onda
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_altezzaOnda.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_altezzaOnda.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the text_loc of this altezza onda.
	 *
	 * @param text_LOC the text_loc of this altezza onda
	 */
	@Override
	public void setText_LOC(String text_LOC) {
		_altezzaOnda.setText_LOC(text_LOC);
	}

	/**
	 * Sets the ts_utc of this altezza onda.
	 *
	 * @param ts_UTC the ts_utc of this altezza onda
	 */
	@Override
	public void setTs_UTC(long ts_UTC) {
		_altezzaOnda.setTs_UTC(ts_UTC);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.animazione.image.model.altezzaOnda> toCacheModel() {

		return _altezzaOnda.toCacheModel();
	}

	@Override
	public it.eng.animazione.image.model.altezzaOnda toEscapedModel() {
		return new altezzaOndaWrapper(_altezzaOnda.toEscapedModel());
	}

	@Override
	public String toString() {
		return _altezzaOnda.toString();
	}

	@Override
	public it.eng.animazione.image.model.altezzaOnda toUnescapedModel() {
		return new altezzaOndaWrapper(_altezzaOnda.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _altezzaOnda.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof altezzaOndaWrapper)) {
			return false;
		}

		altezzaOndaWrapper altezzaOndaWrapper = (altezzaOndaWrapper)obj;

		if (Objects.equals(_altezzaOnda, altezzaOndaWrapper._altezzaOnda)) {
			return true;
		}

		return false;
	}

	@Override
	public altezzaOnda getWrappedModel() {
		return _altezzaOnda;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _altezzaOnda.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _altezzaOnda.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_altezzaOnda.resetOriginalValues();
	}

	private final altezzaOnda _altezzaOnda;

}