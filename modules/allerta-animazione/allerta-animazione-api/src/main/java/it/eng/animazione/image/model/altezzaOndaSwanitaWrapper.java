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
 * This class is a wrapper for {@link altezzaOndaSwanita}.
 * </p>
 *
 * @author UTENTE
 * @see altezzaOndaSwanita
 * @generated
 */
@ProviderType
public class altezzaOndaSwanitaWrapper
	implements altezzaOndaSwanita, ModelWrapper<altezzaOndaSwanita> {

	public altezzaOndaSwanitaWrapper(altezzaOndaSwanita altezzaOndaSwanita) {
		_altezzaOndaSwanita = altezzaOndaSwanita;
	}

	@Override
	public Class<?> getModelClass() {
		return altezzaOndaSwanita.class;
	}

	@Override
	public String getModelClassName() {
		return altezzaOndaSwanita.class.getName();
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
		return new altezzaOndaSwanitaWrapper(
			(altezzaOndaSwanita)_altezzaOndaSwanita.clone());
	}

	@Override
	public int compareTo(
		it.eng.animazione.image.model.altezzaOndaSwanita altezzaOndaSwanita) {

		return _altezzaOndaSwanita.compareTo(altezzaOndaSwanita);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _altezzaOndaSwanita.getExpandoBridge();
	}

	/**
	 * Returns the ID of this altezza onda swanita.
	 *
	 * @return the ID of this altezza onda swanita
	 */
	@Override
	public long getId() {
		return _altezzaOndaSwanita.getId();
	}

	/**
	 * Returns the im of this altezza onda swanita.
	 *
	 * @return the im of this altezza onda swanita
	 */
	@Override
	public String getIm() {
		return _altezzaOndaSwanita.getIm();
	}

	/**
	 * Returns the img data of this altezza onda swanita.
	 *
	 * @return the img data of this altezza onda swanita
	 */
	@Override
	public String getImgData() {
		return _altezzaOndaSwanita.getImgData();
	}

	/**
	 * Returns the primary key of this altezza onda swanita.
	 *
	 * @return the primary key of this altezza onda swanita
	 */
	@Override
	public long getPrimaryKey() {
		return _altezzaOndaSwanita.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _altezzaOndaSwanita.getPrimaryKeyObj();
	}

	/**
	 * Returns the text_loc of this altezza onda swanita.
	 *
	 * @return the text_loc of this altezza onda swanita
	 */
	@Override
	public String getText_LOC() {
		return _altezzaOndaSwanita.getText_LOC();
	}

	/**
	 * Returns the ts_utc of this altezza onda swanita.
	 *
	 * @return the ts_utc of this altezza onda swanita
	 */
	@Override
	public long getTs_UTC() {
		return _altezzaOndaSwanita.getTs_UTC();
	}

	@Override
	public int hashCode() {
		return _altezzaOndaSwanita.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _altezzaOndaSwanita.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _altezzaOndaSwanita.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _altezzaOndaSwanita.isNew();
	}

	@Override
	public void persist() {
		_altezzaOndaSwanita.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_altezzaOndaSwanita.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_altezzaOndaSwanita.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_altezzaOndaSwanita.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_altezzaOndaSwanita.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this altezza onda swanita.
	 *
	 * @param id the ID of this altezza onda swanita
	 */
	@Override
	public void setId(long id) {
		_altezzaOndaSwanita.setId(id);
	}

	/**
	 * Sets the im of this altezza onda swanita.
	 *
	 * @param im the im of this altezza onda swanita
	 */
	@Override
	public void setIm(String im) {
		_altezzaOndaSwanita.setIm(im);
	}

	/**
	 * Sets the img data of this altezza onda swanita.
	 *
	 * @param imgData the img data of this altezza onda swanita
	 */
	@Override
	public void setImgData(String imgData) {
		_altezzaOndaSwanita.setImgData(imgData);
	}

	@Override
	public void setNew(boolean n) {
		_altezzaOndaSwanita.setNew(n);
	}

	/**
	 * Sets the primary key of this altezza onda swanita.
	 *
	 * @param primaryKey the primary key of this altezza onda swanita
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_altezzaOndaSwanita.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_altezzaOndaSwanita.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the text_loc of this altezza onda swanita.
	 *
	 * @param text_LOC the text_loc of this altezza onda swanita
	 */
	@Override
	public void setText_LOC(String text_LOC) {
		_altezzaOndaSwanita.setText_LOC(text_LOC);
	}

	/**
	 * Sets the ts_utc of this altezza onda swanita.
	 *
	 * @param ts_UTC the ts_utc of this altezza onda swanita
	 */
	@Override
	public void setTs_UTC(long ts_UTC) {
		_altezzaOndaSwanita.setTs_UTC(ts_UTC);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.animazione.image.model.altezzaOndaSwanita> toCacheModel() {

		return _altezzaOndaSwanita.toCacheModel();
	}

	@Override
	public it.eng.animazione.image.model.altezzaOndaSwanita toEscapedModel() {
		return new altezzaOndaSwanitaWrapper(
			_altezzaOndaSwanita.toEscapedModel());
	}

	@Override
	public String toString() {
		return _altezzaOndaSwanita.toString();
	}

	@Override
	public it.eng.animazione.image.model.altezzaOndaSwanita toUnescapedModel() {
		return new altezzaOndaSwanitaWrapper(
			_altezzaOndaSwanita.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _altezzaOndaSwanita.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof altezzaOndaSwanitaWrapper)) {
			return false;
		}

		altezzaOndaSwanitaWrapper altezzaOndaSwanitaWrapper =
			(altezzaOndaSwanitaWrapper)obj;

		if (Objects.equals(
				_altezzaOndaSwanita,
				altezzaOndaSwanitaWrapper._altezzaOndaSwanita)) {

			return true;
		}

		return false;
	}

	@Override
	public altezzaOndaSwanita getWrappedModel() {
		return _altezzaOndaSwanita;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _altezzaOndaSwanita.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _altezzaOndaSwanita.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_altezzaOndaSwanita.resetOriginalValues();
	}

	private final altezzaOndaSwanita _altezzaOndaSwanita;

}