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

package it.eng.cache.model;

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
 * This class is a wrapper for {@link Dati}.
 * </p>
 *
 * @author GFAVINI
 * @see Dati
 * @generated
 */
@ProviderType
public class DatiWrapper implements Dati, ModelWrapper<Dati> {

	public DatiWrapper(Dati dati) {
		_dati = dati;
	}

	@Override
	public Class<?> getModelClass() {
		return Dati.class;
	}

	@Override
	public String getModelClassName() {
		return Dati.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idDati", getIdDati());
		attributes.put("dato", getDato());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String idDati = (String)attributes.get("idDati");

		if (idDati != null) {
			setIdDati(idDati);
		}

		String dato = (String)attributes.get("dato");

		if (dato != null) {
			setDato(dato);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public Object clone() {
		return new DatiWrapper((Dati)_dati.clone());
	}

	@Override
	public int compareTo(it.eng.cache.model.Dati dati) {
		return _dati.compareTo(dati);
	}

	/**
	 * Returns the create date of this dati.
	 *
	 * @return the create date of this dati
	 */
	@Override
	public Date getCreateDate() {
		return _dati.getCreateDate();
	}

	/**
	 * Returns the dato of this dati.
	 *
	 * @return the dato of this dati
	 */
	@Override
	public String getDato() {
		return _dati.getDato();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dati.getExpandoBridge();
	}

	/**
	 * Returns the id dati of this dati.
	 *
	 * @return the id dati of this dati
	 */
	@Override
	public String getIdDati() {
		return _dati.getIdDati();
	}

	/**
	 * Returns the primary key of this dati.
	 *
	 * @return the primary key of this dati
	 */
	@Override
	public String getPrimaryKey() {
		return _dati.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dati.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _dati.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _dati.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dati.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dati.isNew();
	}

	@Override
	public void persist() {
		_dati.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dati.setCachedModel(cachedModel);
	}

	/**
	 * Sets the create date of this dati.
	 *
	 * @param createDate the create date of this dati
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_dati.setCreateDate(createDate);
	}

	/**
	 * Sets the dato of this dati.
	 *
	 * @param dato the dato of this dati
	 */
	@Override
	public void setDato(String dato) {
		_dati.setDato(dato);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_dati.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dati.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dati.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id dati of this dati.
	 *
	 * @param idDati the id dati of this dati
	 */
	@Override
	public void setIdDati(String idDati) {
		_dati.setIdDati(idDati);
	}

	@Override
	public void setNew(boolean n) {
		_dati.setNew(n);
	}

	/**
	 * Sets the primary key of this dati.
	 *
	 * @param primaryKey the primary key of this dati
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_dati.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dati.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<it.eng.cache.model.Dati>
		toCacheModel() {

		return _dati.toCacheModel();
	}

	@Override
	public it.eng.cache.model.Dati toEscapedModel() {
		return new DatiWrapper(_dati.toEscapedModel());
	}

	@Override
	public String toString() {
		return _dati.toString();
	}

	@Override
	public it.eng.cache.model.Dati toUnescapedModel() {
		return new DatiWrapper(_dati.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _dati.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DatiWrapper)) {
			return false;
		}

		DatiWrapper datiWrapper = (DatiWrapper)obj;

		if (Objects.equals(_dati, datiWrapper._dati)) {
			return true;
		}

		return false;
	}

	@Override
	public Dati getWrappedModel() {
		return _dati;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dati.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dati.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dati.resetOriginalValues();
	}

	private final Dati _dati;

}