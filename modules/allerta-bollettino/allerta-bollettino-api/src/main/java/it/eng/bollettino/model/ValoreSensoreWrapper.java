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

package it.eng.bollettino.model;

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
 * This class is a wrapper for {@link ValoreSensore}.
 * </p>
 *
 * @author GFAVINI
 * @see ValoreSensore
 * @generated
 */
@ProviderType
public class ValoreSensoreWrapper
	implements ValoreSensore, ModelWrapper<ValoreSensore> {

	public ValoreSensoreWrapper(ValoreSensore valoreSensore) {
		_valoreSensore = valoreSensore;
	}

	@Override
	public Class<?> getModelClass() {
		return ValoreSensore.class;
	}

	@Override
	public String getModelClassName() {
		return ValoreSensore.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("value", getValue());
		attributes.put("datetime", getDatetime());
		attributes.put("idVariabile", getIdVariabile());
		attributes.put("idStazione", getIdStazione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Double value = (Double)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Date datetime = (Date)attributes.get("datetime");

		if (datetime != null) {
			setDatetime(datetime);
		}

		String idVariabile = (String)attributes.get("idVariabile");

		if (idVariabile != null) {
			setIdVariabile(idVariabile);
		}

		String idStazione = (String)attributes.get("idStazione");

		if (idStazione != null) {
			setIdStazione(idStazione);
		}
	}

	@Override
	public Object clone() {
		return new ValoreSensoreWrapper((ValoreSensore)_valoreSensore.clone());
	}

	@Override
	public int compareTo(it.eng.bollettino.model.ValoreSensore valoreSensore) {
		return _valoreSensore.compareTo(valoreSensore);
	}

	/**
	 * Returns the datetime of this valore sensore.
	 *
	 * @return the datetime of this valore sensore
	 */
	@Override
	public Date getDatetime() {
		return _valoreSensore.getDatetime();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _valoreSensore.getExpandoBridge();
	}

	/**
	 * Returns the ID of this valore sensore.
	 *
	 * @return the ID of this valore sensore
	 */
	@Override
	public long getId() {
		return _valoreSensore.getId();
	}

	/**
	 * Returns the id stazione of this valore sensore.
	 *
	 * @return the id stazione of this valore sensore
	 */
	@Override
	public String getIdStazione() {
		return _valoreSensore.getIdStazione();
	}

	/**
	 * Returns the id variabile of this valore sensore.
	 *
	 * @return the id variabile of this valore sensore
	 */
	@Override
	public String getIdVariabile() {
		return _valoreSensore.getIdVariabile();
	}

	/**
	 * Returns the primary key of this valore sensore.
	 *
	 * @return the primary key of this valore sensore
	 */
	@Override
	public long getPrimaryKey() {
		return _valoreSensore.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _valoreSensore.getPrimaryKeyObj();
	}

	/**
	 * Returns the uuid of this valore sensore.
	 *
	 * @return the uuid of this valore sensore
	 */
	@Override
	public String getUuid() {
		return _valoreSensore.getUuid();
	}

	/**
	 * Returns the value of this valore sensore.
	 *
	 * @return the value of this valore sensore
	 */
	@Override
	public double getValue() {
		return _valoreSensore.getValue();
	}

	@Override
	public int hashCode() {
		return _valoreSensore.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _valoreSensore.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _valoreSensore.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _valoreSensore.isNew();
	}

	@Override
	public void persist() {
		_valoreSensore.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_valoreSensore.setCachedModel(cachedModel);
	}

	/**
	 * Sets the datetime of this valore sensore.
	 *
	 * @param datetime the datetime of this valore sensore
	 */
	@Override
	public void setDatetime(Date datetime) {
		_valoreSensore.setDatetime(datetime);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_valoreSensore.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_valoreSensore.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_valoreSensore.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this valore sensore.
	 *
	 * @param id the ID of this valore sensore
	 */
	@Override
	public void setId(long id) {
		_valoreSensore.setId(id);
	}

	/**
	 * Sets the id stazione of this valore sensore.
	 *
	 * @param idStazione the id stazione of this valore sensore
	 */
	@Override
	public void setIdStazione(String idStazione) {
		_valoreSensore.setIdStazione(idStazione);
	}

	/**
	 * Sets the id variabile of this valore sensore.
	 *
	 * @param idVariabile the id variabile of this valore sensore
	 */
	@Override
	public void setIdVariabile(String idVariabile) {
		_valoreSensore.setIdVariabile(idVariabile);
	}

	@Override
	public void setNew(boolean n) {
		_valoreSensore.setNew(n);
	}

	/**
	 * Sets the primary key of this valore sensore.
	 *
	 * @param primaryKey the primary key of this valore sensore
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_valoreSensore.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_valoreSensore.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the uuid of this valore sensore.
	 *
	 * @param uuid the uuid of this valore sensore
	 */
	@Override
	public void setUuid(String uuid) {
		_valoreSensore.setUuid(uuid);
	}

	/**
	 * Sets the value of this valore sensore.
	 *
	 * @param value the value of this valore sensore
	 */
	@Override
	public void setValue(double value) {
		_valoreSensore.setValue(value);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.ValoreSensore> toCacheModel() {

		return _valoreSensore.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.ValoreSensore toEscapedModel() {
		return new ValoreSensoreWrapper(_valoreSensore.toEscapedModel());
	}

	@Override
	public String toString() {
		return _valoreSensore.toString();
	}

	@Override
	public it.eng.bollettino.model.ValoreSensore toUnescapedModel() {
		return new ValoreSensoreWrapper(_valoreSensore.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _valoreSensore.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ValoreSensoreWrapper)) {
			return false;
		}

		ValoreSensoreWrapper valoreSensoreWrapper = (ValoreSensoreWrapper)obj;

		if (Objects.equals(
				_valoreSensore, valoreSensoreWrapper._valoreSensore)) {

			return true;
		}

		return false;
	}

	@Override
	public ValoreSensore getWrappedModel() {
		return _valoreSensore;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _valoreSensore.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _valoreSensore.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_valoreSensore.resetOriginalValues();
	}

	private final ValoreSensore _valoreSensore;

}