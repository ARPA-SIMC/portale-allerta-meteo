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
 * This class is a wrapper for {@link elevazione}.
 * </p>
 *
 * @author UTENTE
 * @see elevazione
 * @generated
 */
@ProviderType
public class elevazioneWrapper implements elevazione, ModelWrapper<elevazione> {

	public elevazioneWrapper(elevazione elevazione) {
		_elevazione = elevazione;
	}

	@Override
	public Class<?> getModelClass() {
		return elevazione.class;
	}

	@Override
	public String getModelClassName() {
		return elevazione.class.getName();
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
		return new elevazioneWrapper((elevazione)_elevazione.clone());
	}

	@Override
	public int compareTo(it.eng.animazione.image.model.elevazione elevazione) {
		return _elevazione.compareTo(elevazione);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _elevazione.getExpandoBridge();
	}

	/**
	 * Returns the ID of this elevazione.
	 *
	 * @return the ID of this elevazione
	 */
	@Override
	public long getId() {
		return _elevazione.getId();
	}

	/**
	 * Returns the im of this elevazione.
	 *
	 * @return the im of this elevazione
	 */
	@Override
	public String getIm() {
		return _elevazione.getIm();
	}

	/**
	 * Returns the img data of this elevazione.
	 *
	 * @return the img data of this elevazione
	 */
	@Override
	public String getImgData() {
		return _elevazione.getImgData();
	}

	/**
	 * Returns the primary key of this elevazione.
	 *
	 * @return the primary key of this elevazione
	 */
	@Override
	public long getPrimaryKey() {
		return _elevazione.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _elevazione.getPrimaryKeyObj();
	}

	/**
	 * Returns the text_loc of this elevazione.
	 *
	 * @return the text_loc of this elevazione
	 */
	@Override
	public String getText_LOC() {
		return _elevazione.getText_LOC();
	}

	/**
	 * Returns the ts_utc of this elevazione.
	 *
	 * @return the ts_utc of this elevazione
	 */
	@Override
	public long getTs_UTC() {
		return _elevazione.getTs_UTC();
	}

	@Override
	public int hashCode() {
		return _elevazione.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _elevazione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _elevazione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _elevazione.isNew();
	}

	@Override
	public void persist() {
		_elevazione.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_elevazione.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_elevazione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_elevazione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_elevazione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this elevazione.
	 *
	 * @param id the ID of this elevazione
	 */
	@Override
	public void setId(long id) {
		_elevazione.setId(id);
	}

	/**
	 * Sets the im of this elevazione.
	 *
	 * @param im the im of this elevazione
	 */
	@Override
	public void setIm(String im) {
		_elevazione.setIm(im);
	}

	/**
	 * Sets the img data of this elevazione.
	 *
	 * @param imgData the img data of this elevazione
	 */
	@Override
	public void setImgData(String imgData) {
		_elevazione.setImgData(imgData);
	}

	@Override
	public void setNew(boolean n) {
		_elevazione.setNew(n);
	}

	/**
	 * Sets the primary key of this elevazione.
	 *
	 * @param primaryKey the primary key of this elevazione
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_elevazione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_elevazione.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the text_loc of this elevazione.
	 *
	 * @param text_LOC the text_loc of this elevazione
	 */
	@Override
	public void setText_LOC(String text_LOC) {
		_elevazione.setText_LOC(text_LOC);
	}

	/**
	 * Sets the ts_utc of this elevazione.
	 *
	 * @param ts_UTC the ts_utc of this elevazione
	 */
	@Override
	public void setTs_UTC(long ts_UTC) {
		_elevazione.setTs_UTC(ts_UTC);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.animazione.image.model.elevazione> toCacheModel() {

		return _elevazione.toCacheModel();
	}

	@Override
	public it.eng.animazione.image.model.elevazione toEscapedModel() {
		return new elevazioneWrapper(_elevazione.toEscapedModel());
	}

	@Override
	public String toString() {
		return _elevazione.toString();
	}

	@Override
	public it.eng.animazione.image.model.elevazione toUnescapedModel() {
		return new elevazioneWrapper(_elevazione.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _elevazione.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof elevazioneWrapper)) {
			return false;
		}

		elevazioneWrapper elevazioneWrapper = (elevazioneWrapper)obj;

		if (Objects.equals(_elevazione, elevazioneWrapper._elevazione)) {
			return true;
		}

		return false;
	}

	@Override
	public elevazione getWrappedModel() {
		return _elevazione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _elevazione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _elevazione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_elevazione.resetOriginalValues();
	}

	private final elevazione _elevazione;

}