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

package it.eng.allerter.model;

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
 * This class is a wrapper for {@link Geografia}.
 * </p>
 *
 * @author GFAVINI
 * @see Geografia
 * @generated
 */
@ProviderType
public class GeografiaWrapper implements Geografia, ModelWrapper<Geografia> {

	public GeografiaWrapper(Geografia geografia) {
		_geografia = geografia;
	}

	@Override
	public Class<?> getModelClass() {
		return Geografia.class;
	}

	@Override
	public String getModelClassName() {
		return Geografia.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("geografiaId", getGeografiaId());
		attributes.put("tipo", getTipo());
		attributes.put("area", getArea());
		attributes.put("complessita", getComplessita());
		attributes.put("geometria", getGeometria());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String geografiaId = (String)attributes.get("geografiaId");

		if (geografiaId != null) {
			setGeografiaId(geografiaId);
		}

		String tipo = (String)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}

		String complessita = (String)attributes.get("complessita");

		if (complessita != null) {
			setComplessita(complessita);
		}

		String geometria = (String)attributes.get("geometria");

		if (geometria != null) {
			setGeometria(geometria);
		}
	}

	@Override
	public Object clone() {
		return new GeografiaWrapper((Geografia)_geografia.clone());
	}

	@Override
	public int compareTo(it.eng.allerter.model.Geografia geografia) {
		return _geografia.compareTo(geografia);
	}

	/**
	 * Returns the area of this geografia.
	 *
	 * @return the area of this geografia
	 */
	@Override
	public String getArea() {
		return _geografia.getArea();
	}

	/**
	 * Returns the complessita of this geografia.
	 *
	 * @return the complessita of this geografia
	 */
	@Override
	public String getComplessita() {
		return _geografia.getComplessita();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _geografia.getExpandoBridge();
	}

	/**
	 * Returns the geografia ID of this geografia.
	 *
	 * @return the geografia ID of this geografia
	 */
	@Override
	public String getGeografiaId() {
		return _geografia.getGeografiaId();
	}

	/**
	 * Returns the geometria of this geografia.
	 *
	 * @return the geometria of this geografia
	 */
	@Override
	public String getGeometria() {
		return _geografia.getGeometria();
	}

	/**
	 * Returns the primary key of this geografia.
	 *
	 * @return the primary key of this geografia
	 */
	@Override
	public it.eng.allerter.service.persistence.GeografiaPK getPrimaryKey() {
		return _geografia.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _geografia.getPrimaryKeyObj();
	}

	/**
	 * Returns the tipo of this geografia.
	 *
	 * @return the tipo of this geografia
	 */
	@Override
	public String getTipo() {
		return _geografia.getTipo();
	}

	@Override
	public int hashCode() {
		return _geografia.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _geografia.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _geografia.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _geografia.isNew();
	}

	@Override
	public void persist() {
		_geografia.persist();
	}

	/**
	 * Sets the area of this geografia.
	 *
	 * @param area the area of this geografia
	 */
	@Override
	public void setArea(String area) {
		_geografia.setArea(area);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_geografia.setCachedModel(cachedModel);
	}

	/**
	 * Sets the complessita of this geografia.
	 *
	 * @param complessita the complessita of this geografia
	 */
	@Override
	public void setComplessita(String complessita) {
		_geografia.setComplessita(complessita);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_geografia.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_geografia.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_geografia.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the geografia ID of this geografia.
	 *
	 * @param geografiaId the geografia ID of this geografia
	 */
	@Override
	public void setGeografiaId(String geografiaId) {
		_geografia.setGeografiaId(geografiaId);
	}

	/**
	 * Sets the geometria of this geografia.
	 *
	 * @param geometria the geometria of this geografia
	 */
	@Override
	public void setGeometria(String geometria) {
		_geografia.setGeometria(geometria);
	}

	@Override
	public void setNew(boolean n) {
		_geografia.setNew(n);
	}

	/**
	 * Sets the primary key of this geografia.
	 *
	 * @param primaryKey the primary key of this geografia
	 */
	@Override
	public void setPrimaryKey(
		it.eng.allerter.service.persistence.GeografiaPK primaryKey) {

		_geografia.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_geografia.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the tipo of this geografia.
	 *
	 * @param tipo the tipo of this geografia
	 */
	@Override
	public void setTipo(String tipo) {
		_geografia.setTipo(tipo);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.Geografia> toCacheModel() {

		return _geografia.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.Geografia toEscapedModel() {
		return new GeografiaWrapper(_geografia.toEscapedModel());
	}

	@Override
	public String toString() {
		return _geografia.toString();
	}

	@Override
	public it.eng.allerter.model.Geografia toUnescapedModel() {
		return new GeografiaWrapper(_geografia.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _geografia.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeografiaWrapper)) {
			return false;
		}

		GeografiaWrapper geografiaWrapper = (GeografiaWrapper)obj;

		if (Objects.equals(_geografia, geografiaWrapper._geografia)) {
			return true;
		}

		return false;
	}

	@Override
	public Geografia getWrappedModel() {
		return _geografia;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _geografia.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _geografia.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_geografia.resetOriginalValues();
	}

	private final Geografia _geografia;

}