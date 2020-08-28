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
 * This class is a wrapper for {@link AllertaParametro}.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaParametro
 * @generated
 */
@ProviderType
public class AllertaParametroWrapper
	implements AllertaParametro, ModelWrapper<AllertaParametro> {

	public AllertaParametroWrapper(AllertaParametro allertaParametro) {
		_allertaParametro = allertaParametro;
	}

	@Override
	public Class<?> getModelClass() {
		return AllertaParametro.class;
	}

	@Override
	public String getModelClassName() {
		return AllertaParametro.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parametroId", getParametroId());
		attributes.put("valore", getValore());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String parametroId = (String)attributes.get("parametroId");

		if (parametroId != null) {
			setParametroId(parametroId);
		}

		String valore = (String)attributes.get("valore");

		if (valore != null) {
			setValore(valore);
		}
	}

	@Override
	public Object clone() {
		return new AllertaParametroWrapper(
			(AllertaParametro)_allertaParametro.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerter.model.AllertaParametro allertaParametro) {

		return _allertaParametro.compareTo(allertaParametro);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _allertaParametro.getExpandoBridge();
	}

	/**
	 * Returns the parametro ID of this allerta parametro.
	 *
	 * @return the parametro ID of this allerta parametro
	 */
	@Override
	public String getParametroId() {
		return _allertaParametro.getParametroId();
	}

	/**
	 * Returns the primary key of this allerta parametro.
	 *
	 * @return the primary key of this allerta parametro
	 */
	@Override
	public String getPrimaryKey() {
		return _allertaParametro.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _allertaParametro.getPrimaryKeyObj();
	}

	/**
	 * Returns the valore of this allerta parametro.
	 *
	 * @return the valore of this allerta parametro
	 */
	@Override
	public String getValore() {
		return _allertaParametro.getValore();
	}

	@Override
	public int hashCode() {
		return _allertaParametro.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _allertaParametro.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _allertaParametro.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _allertaParametro.isNew();
	}

	@Override
	public void persist() {
		_allertaParametro.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_allertaParametro.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_allertaParametro.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_allertaParametro.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_allertaParametro.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_allertaParametro.setNew(n);
	}

	/**
	 * Sets the parametro ID of this allerta parametro.
	 *
	 * @param parametroId the parametro ID of this allerta parametro
	 */
	@Override
	public void setParametroId(String parametroId) {
		_allertaParametro.setParametroId(parametroId);
	}

	/**
	 * Sets the primary key of this allerta parametro.
	 *
	 * @param primaryKey the primary key of this allerta parametro
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_allertaParametro.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_allertaParametro.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the valore of this allerta parametro.
	 *
	 * @param valore the valore of this allerta parametro
	 */
	@Override
	public void setValore(String valore) {
		_allertaParametro.setValore(valore);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.AllertaParametro> toCacheModel() {

		return _allertaParametro.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.AllertaParametro toEscapedModel() {
		return new AllertaParametroWrapper(_allertaParametro.toEscapedModel());
	}

	@Override
	public String toString() {
		return _allertaParametro.toString();
	}

	@Override
	public it.eng.allerter.model.AllertaParametro toUnescapedModel() {
		return new AllertaParametroWrapper(
			_allertaParametro.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _allertaParametro.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AllertaParametroWrapper)) {
			return false;
		}

		AllertaParametroWrapper allertaParametroWrapper =
			(AllertaParametroWrapper)obj;

		if (Objects.equals(
				_allertaParametro, allertaParametroWrapper._allertaParametro)) {

			return true;
		}

		return false;
	}

	@Override
	public AllertaParametro getWrappedModel() {
		return _allertaParametro;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _allertaParametro.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _allertaParametro.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_allertaParametro.resetOriginalValues();
	}

	private final AllertaParametro _allertaParametro;

}