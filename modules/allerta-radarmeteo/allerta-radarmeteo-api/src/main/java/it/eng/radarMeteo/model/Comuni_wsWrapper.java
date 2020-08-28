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
 * This class is a wrapper for {@link Comuni_ws}.
 * </p>
 *
 * @author Francesco
 * @see Comuni_ws
 * @generated
 */
@ProviderType
public class Comuni_wsWrapper implements Comuni_ws, ModelWrapper<Comuni_ws> {

	public Comuni_wsWrapper(Comuni_ws comuni_ws) {
		_comuni_ws = comuni_ws;
	}

	@Override
	public Class<?> getModelClass() {
		return Comuni_ws.class;
	}

	@Override
	public String getModelClassName() {
		return Comuni_ws.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idIstat", getIdIstat());
		attributes.put("comune", getComune());
		attributes.put("provincia", getProvincia());
		attributes.put("sottozona", getSottozona());
		attributes.put("zonaallerta", getZonaallerta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String idIstat = (String)attributes.get("idIstat");

		if (idIstat != null) {
			setIdIstat(idIstat);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String sottozona = (String)attributes.get("sottozona");

		if (sottozona != null) {
			setSottozona(sottozona);
		}

		String zonaallerta = (String)attributes.get("zonaallerta");

		if (zonaallerta != null) {
			setZonaallerta(zonaallerta);
		}
	}

	@Override
	public Object clone() {
		return new Comuni_wsWrapper((Comuni_ws)_comuni_ws.clone());
	}

	@Override
	public int compareTo(it.eng.radarMeteo.model.Comuni_ws comuni_ws) {
		return _comuni_ws.compareTo(comuni_ws);
	}

	/**
	 * Returns the comune of this comuni_ws.
	 *
	 * @return the comune of this comuni_ws
	 */
	@Override
	public String getComune() {
		return _comuni_ws.getComune();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _comuni_ws.getExpandoBridge();
	}

	/**
	 * Returns the id istat of this comuni_ws.
	 *
	 * @return the id istat of this comuni_ws
	 */
	@Override
	public String getIdIstat() {
		return _comuni_ws.getIdIstat();
	}

	/**
	 * Returns the primary key of this comuni_ws.
	 *
	 * @return the primary key of this comuni_ws
	 */
	@Override
	public String getPrimaryKey() {
		return _comuni_ws.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _comuni_ws.getPrimaryKeyObj();
	}

	/**
	 * Returns the provincia of this comuni_ws.
	 *
	 * @return the provincia of this comuni_ws
	 */
	@Override
	public String getProvincia() {
		return _comuni_ws.getProvincia();
	}

	/**
	 * Returns the sottozona of this comuni_ws.
	 *
	 * @return the sottozona of this comuni_ws
	 */
	@Override
	public String getSottozona() {
		return _comuni_ws.getSottozona();
	}

	/**
	 * Returns the zonaallerta of this comuni_ws.
	 *
	 * @return the zonaallerta of this comuni_ws
	 */
	@Override
	public String getZonaallerta() {
		return _comuni_ws.getZonaallerta();
	}

	@Override
	public int hashCode() {
		return _comuni_ws.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _comuni_ws.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _comuni_ws.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _comuni_ws.isNew();
	}

	@Override
	public void persist() {
		_comuni_ws.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_comuni_ws.setCachedModel(cachedModel);
	}

	/**
	 * Sets the comune of this comuni_ws.
	 *
	 * @param comune the comune of this comuni_ws
	 */
	@Override
	public void setComune(String comune) {
		_comuni_ws.setComune(comune);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_comuni_ws.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_comuni_ws.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_comuni_ws.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id istat of this comuni_ws.
	 *
	 * @param idIstat the id istat of this comuni_ws
	 */
	@Override
	public void setIdIstat(String idIstat) {
		_comuni_ws.setIdIstat(idIstat);
	}

	@Override
	public void setNew(boolean n) {
		_comuni_ws.setNew(n);
	}

	/**
	 * Sets the primary key of this comuni_ws.
	 *
	 * @param primaryKey the primary key of this comuni_ws
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_comuni_ws.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_comuni_ws.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the provincia of this comuni_ws.
	 *
	 * @param provincia the provincia of this comuni_ws
	 */
	@Override
	public void setProvincia(String provincia) {
		_comuni_ws.setProvincia(provincia);
	}

	/**
	 * Sets the sottozona of this comuni_ws.
	 *
	 * @param sottozona the sottozona of this comuni_ws
	 */
	@Override
	public void setSottozona(String sottozona) {
		_comuni_ws.setSottozona(sottozona);
	}

	/**
	 * Sets the zonaallerta of this comuni_ws.
	 *
	 * @param zonaallerta the zonaallerta of this comuni_ws
	 */
	@Override
	public void setZonaallerta(String zonaallerta) {
		_comuni_ws.setZonaallerta(zonaallerta);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.radarMeteo.model.Comuni_ws> toCacheModel() {

		return _comuni_ws.toCacheModel();
	}

	@Override
	public it.eng.radarMeteo.model.Comuni_ws toEscapedModel() {
		return new Comuni_wsWrapper(_comuni_ws.toEscapedModel());
	}

	@Override
	public String toString() {
		return _comuni_ws.toString();
	}

	@Override
	public it.eng.radarMeteo.model.Comuni_ws toUnescapedModel() {
		return new Comuni_wsWrapper(_comuni_ws.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _comuni_ws.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Comuni_wsWrapper)) {
			return false;
		}

		Comuni_wsWrapper comuni_wsWrapper = (Comuni_wsWrapper)obj;

		if (Objects.equals(_comuni_ws, comuni_wsWrapper._comuni_ws)) {
			return true;
		}

		return false;
	}

	@Override
	public Comuni_ws getWrappedModel() {
		return _comuni_ws;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _comuni_ws.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _comuni_ws.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_comuni_ws.resetOriginalValues();
	}

	private final Comuni_ws _comuni_ws;

}