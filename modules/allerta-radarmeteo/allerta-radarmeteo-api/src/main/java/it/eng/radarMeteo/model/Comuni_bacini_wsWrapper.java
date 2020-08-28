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
 * This class is a wrapper for {@link Comuni_bacini_ws}.
 * </p>
 *
 * @author Francesco
 * @see Comuni_bacini_ws
 * @generated
 */
@ProviderType
public class Comuni_bacini_wsWrapper
	implements Comuni_bacini_ws, ModelWrapper<Comuni_bacini_ws> {

	public Comuni_bacini_wsWrapper(Comuni_bacini_ws comuni_bacini_ws) {
		_comuni_bacini_ws = comuni_bacini_ws;
	}

	@Override
	public Class<?> getModelClass() {
		return Comuni_bacini_ws.class;
	}

	@Override
	public String getModelClassName() {
		return Comuni_bacini_ws.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idBacini", getIdBacini());
		attributes.put("comune", getComune());
		attributes.put("provincia", getProvincia());
		attributes.put("bacino", getBacino());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer idBacini = (Integer)attributes.get("idBacini");

		if (idBacini != null) {
			setIdBacini(idBacini);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String bacino = (String)attributes.get("bacino");

		if (bacino != null) {
			setBacino(bacino);
		}
	}

	@Override
	public Object clone() {
		return new Comuni_bacini_wsWrapper(
			(Comuni_bacini_ws)_comuni_bacini_ws.clone());
	}

	@Override
	public int compareTo(
		it.eng.radarMeteo.model.Comuni_bacini_ws comuni_bacini_ws) {

		return _comuni_bacini_ws.compareTo(comuni_bacini_ws);
	}

	/**
	 * Returns the bacino of this comuni_bacini_ws.
	 *
	 * @return the bacino of this comuni_bacini_ws
	 */
	@Override
	public String getBacino() {
		return _comuni_bacini_ws.getBacino();
	}

	/**
	 * Returns the comune of this comuni_bacini_ws.
	 *
	 * @return the comune of this comuni_bacini_ws
	 */
	@Override
	public String getComune() {
		return _comuni_bacini_ws.getComune();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _comuni_bacini_ws.getExpandoBridge();
	}

	/**
	 * Returns the id bacini of this comuni_bacini_ws.
	 *
	 * @return the id bacini of this comuni_bacini_ws
	 */
	@Override
	public int getIdBacini() {
		return _comuni_bacini_ws.getIdBacini();
	}

	/**
	 * Returns the primary key of this comuni_bacini_ws.
	 *
	 * @return the primary key of this comuni_bacini_ws
	 */
	@Override
	public int getPrimaryKey() {
		return _comuni_bacini_ws.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _comuni_bacini_ws.getPrimaryKeyObj();
	}

	/**
	 * Returns the provincia of this comuni_bacini_ws.
	 *
	 * @return the provincia of this comuni_bacini_ws
	 */
	@Override
	public String getProvincia() {
		return _comuni_bacini_ws.getProvincia();
	}

	@Override
	public int hashCode() {
		return _comuni_bacini_ws.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _comuni_bacini_ws.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _comuni_bacini_ws.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _comuni_bacini_ws.isNew();
	}

	@Override
	public void persist() {
		_comuni_bacini_ws.persist();
	}

	/**
	 * Sets the bacino of this comuni_bacini_ws.
	 *
	 * @param bacino the bacino of this comuni_bacini_ws
	 */
	@Override
	public void setBacino(String bacino) {
		_comuni_bacini_ws.setBacino(bacino);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_comuni_bacini_ws.setCachedModel(cachedModel);
	}

	/**
	 * Sets the comune of this comuni_bacini_ws.
	 *
	 * @param comune the comune of this comuni_bacini_ws
	 */
	@Override
	public void setComune(String comune) {
		_comuni_bacini_ws.setComune(comune);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_comuni_bacini_ws.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_comuni_bacini_ws.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_comuni_bacini_ws.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id bacini of this comuni_bacini_ws.
	 *
	 * @param idBacini the id bacini of this comuni_bacini_ws
	 */
	@Override
	public void setIdBacini(int idBacini) {
		_comuni_bacini_ws.setIdBacini(idBacini);
	}

	@Override
	public void setNew(boolean n) {
		_comuni_bacini_ws.setNew(n);
	}

	/**
	 * Sets the primary key of this comuni_bacini_ws.
	 *
	 * @param primaryKey the primary key of this comuni_bacini_ws
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		_comuni_bacini_ws.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_comuni_bacini_ws.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the provincia of this comuni_bacini_ws.
	 *
	 * @param provincia the provincia of this comuni_bacini_ws
	 */
	@Override
	public void setProvincia(String provincia) {
		_comuni_bacini_ws.setProvincia(provincia);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.radarMeteo.model.Comuni_bacini_ws> toCacheModel() {

		return _comuni_bacini_ws.toCacheModel();
	}

	@Override
	public it.eng.radarMeteo.model.Comuni_bacini_ws toEscapedModel() {
		return new Comuni_bacini_wsWrapper(_comuni_bacini_ws.toEscapedModel());
	}

	@Override
	public String toString() {
		return _comuni_bacini_ws.toString();
	}

	@Override
	public it.eng.radarMeteo.model.Comuni_bacini_ws toUnescapedModel() {
		return new Comuni_bacini_wsWrapper(
			_comuni_bacini_ws.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _comuni_bacini_ws.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Comuni_bacini_wsWrapper)) {
			return false;
		}

		Comuni_bacini_wsWrapper comuni_bacini_wsWrapper =
			(Comuni_bacini_wsWrapper)obj;

		if (Objects.equals(
				_comuni_bacini_ws, comuni_bacini_wsWrapper._comuni_bacini_ws)) {

			return true;
		}

		return false;
	}

	@Override
	public Comuni_bacini_ws getWrappedModel() {
		return _comuni_bacini_ws;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _comuni_bacini_ws.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _comuni_bacini_ws.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_comuni_bacini_ws.resetOriginalValues();
	}

	private final Comuni_bacini_ws _comuni_bacini_ws;

}