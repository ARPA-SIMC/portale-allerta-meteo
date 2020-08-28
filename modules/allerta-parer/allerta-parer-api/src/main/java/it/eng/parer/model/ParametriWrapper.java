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

package it.eng.parer.model;

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
 * This class is a wrapper for {@link Parametri}.
 * </p>
 *
 * @author Pratola_L
 * @see Parametri
 * @generated
 */
@ProviderType
public class ParametriWrapper implements Parametri, ModelWrapper<Parametri> {

	public ParametriWrapper(Parametri parametri) {
		_parametri = parametri;
	}

	@Override
	public Class<?> getModelClass() {
		return Parametri.class;
	}

	@Override
	public String getModelClassName() {
		return Parametri.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("chiave", getChiave());
		attributes.put("valore", getValore());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String chiave = (String)attributes.get("chiave");

		if (chiave != null) {
			setChiave(chiave);
		}

		String valore = (String)attributes.get("valore");

		if (valore != null) {
			setValore(valore);
		}
	}

	@Override
	public Object clone() {
		return new ParametriWrapper((Parametri)_parametri.clone());
	}

	@Override
	public int compareTo(it.eng.parer.model.Parametri parametri) {
		return _parametri.compareTo(parametri);
	}

	/**
	 * Returns the chiave of this parametri.
	 *
	 * @return the chiave of this parametri
	 */
	@Override
	public String getChiave() {
		return _parametri.getChiave();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _parametri.getExpandoBridge();
	}

	/**
	 * Returns the primary key of this parametri.
	 *
	 * @return the primary key of this parametri
	 */
	@Override
	public String getPrimaryKey() {
		return _parametri.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _parametri.getPrimaryKeyObj();
	}

	/**
	 * Returns the valore of this parametri.
	 *
	 * @return the valore of this parametri
	 */
	@Override
	public String getValore() {
		return _parametri.getValore();
	}

	@Override
	public int hashCode() {
		return _parametri.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _parametri.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _parametri.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _parametri.isNew();
	}

	@Override
	public void persist() {
		_parametri.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_parametri.setCachedModel(cachedModel);
	}

	/**
	 * Sets the chiave of this parametri.
	 *
	 * @param chiave the chiave of this parametri
	 */
	@Override
	public void setChiave(String chiave) {
		_parametri.setChiave(chiave);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_parametri.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_parametri.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_parametri.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_parametri.setNew(n);
	}

	/**
	 * Sets the primary key of this parametri.
	 *
	 * @param primaryKey the primary key of this parametri
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_parametri.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_parametri.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the valore of this parametri.
	 *
	 * @param valore the valore of this parametri
	 */
	@Override
	public void setValore(String valore) {
		_parametri.setValore(valore);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.parer.model.Parametri> toCacheModel() {

		return _parametri.toCacheModel();
	}

	@Override
	public it.eng.parer.model.Parametri toEscapedModel() {
		return new ParametriWrapper(_parametri.toEscapedModel());
	}

	@Override
	public String toString() {
		return _parametri.toString();
	}

	@Override
	public it.eng.parer.model.Parametri toUnescapedModel() {
		return new ParametriWrapper(_parametri.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _parametri.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ParametriWrapper)) {
			return false;
		}

		ParametriWrapper parametriWrapper = (ParametriWrapper)obj;

		if (Objects.equals(_parametri, parametriWrapper._parametri)) {
			return true;
		}

		return false;
	}

	@Override
	public Parametri getWrappedModel() {
		return _parametri;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _parametri.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _parametri.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_parametri.resetOriginalValues();
	}

	private final Parametri _parametri;

}