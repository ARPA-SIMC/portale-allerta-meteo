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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link BollettinoParametro}.
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoParametro
 * @generated
 */
@ProviderType
public class BollettinoParametroWrapper
	implements BollettinoParametro, ModelWrapper<BollettinoParametro> {

	public BollettinoParametroWrapper(BollettinoParametro bollettinoParametro) {
		_bollettinoParametro = bollettinoParametro;
	}

	@Override
	public Class<?> getModelClass() {
		return BollettinoParametro.class;
	}

	@Override
	public String getModelClassName() {
		return BollettinoParametro.class.getName();
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
		return new BollettinoParametroWrapper(
			(BollettinoParametro)_bollettinoParametro.clone());
	}

	@Override
	public int compareTo(
		it.eng.bollettino.model.BollettinoParametro bollettinoParametro) {

		return _bollettinoParametro.compareTo(bollettinoParametro);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bollettinoParametro.getExpandoBridge();
	}

	/**
	 * Returns the parametro ID of this bollettino parametro.
	 *
	 * @return the parametro ID of this bollettino parametro
	 */
	@Override
	public String getParametroId() {
		return _bollettinoParametro.getParametroId();
	}

	/**
	 * Returns the primary key of this bollettino parametro.
	 *
	 * @return the primary key of this bollettino parametro
	 */
	@Override
	public String getPrimaryKey() {
		return _bollettinoParametro.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bollettinoParametro.getPrimaryKeyObj();
	}

	/**
	 * Returns the valore of this bollettino parametro.
	 *
	 * @return the valore of this bollettino parametro
	 */
	@Override
	public String getValore() {
		return _bollettinoParametro.getValore();
	}

	@Override
	public int hashCode() {
		return _bollettinoParametro.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _bollettinoParametro.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bollettinoParametro.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bollettinoParametro.isNew();
	}

	@Override
	public void persist() {
		_bollettinoParametro.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bollettinoParametro.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_bollettinoParametro.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bollettinoParametro.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bollettinoParametro.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_bollettinoParametro.setNew(n);
	}

	/**
	 * Sets the parametro ID of this bollettino parametro.
	 *
	 * @param parametroId the parametro ID of this bollettino parametro
	 */
	@Override
	public void setParametroId(String parametroId) {
		_bollettinoParametro.setParametroId(parametroId);
	}

	/**
	 * Sets the primary key of this bollettino parametro.
	 *
	 * @param primaryKey the primary key of this bollettino parametro
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_bollettinoParametro.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bollettinoParametro.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the valore of this bollettino parametro.
	 *
	 * @param valore the valore of this bollettino parametro
	 */
	@Override
	public void setValore(String valore) {
		_bollettinoParametro.setValore(valore);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.BollettinoParametro> toCacheModel() {

		return _bollettinoParametro.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.BollettinoParametro toEscapedModel() {
		return new BollettinoParametroWrapper(
			_bollettinoParametro.toEscapedModel());
	}

	@Override
	public String toString() {
		return _bollettinoParametro.toString();
	}

	@Override
	public it.eng.bollettino.model.BollettinoParametro toUnescapedModel() {
		return new BollettinoParametroWrapper(
			_bollettinoParametro.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _bollettinoParametro.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BollettinoParametroWrapper)) {
			return false;
		}

		BollettinoParametroWrapper bollettinoParametroWrapper =
			(BollettinoParametroWrapper)obj;

		if (Objects.equals(
				_bollettinoParametro,
				bollettinoParametroWrapper._bollettinoParametro)) {

			return true;
		}

		return false;
	}

	@Override
	public BollettinoParametro getWrappedModel() {
		return _bollettinoParametro;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bollettinoParametro.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bollettinoParametro.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bollettinoParametro.resetOriginalValues();
	}

	private final BollettinoParametro _bollettinoParametro;

}