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

package it.eng.allerte.model;

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
 * This class is a wrapper for {@link RubricaSito}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaSito
 * @generated
 */
@ProviderType
public class RubricaSitoWrapper
	implements RubricaSito, ModelWrapper<RubricaSito> {

	public RubricaSitoWrapper(RubricaSito rubricaSito) {
		_rubricaSito = rubricaSito;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaSito.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaSito.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_SITO", getID_SITO());
		attributes.put("NOME", getNOME());
		attributes.put("FK_LIFERAY_SITE", getFK_LIFERAY_SITE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_SITO = (Long)attributes.get("ID_SITO");

		if (ID_SITO != null) {
			setID_SITO(ID_SITO);
		}

		String NOME = (String)attributes.get("NOME");

		if (NOME != null) {
			setNOME(NOME);
		}

		Long FK_LIFERAY_SITE = (Long)attributes.get("FK_LIFERAY_SITE");

		if (FK_LIFERAY_SITE != null) {
			setFK_LIFERAY_SITE(FK_LIFERAY_SITE);
		}
	}

	@Override
	public Object clone() {
		return new RubricaSitoWrapper((RubricaSito)_rubricaSito.clone());
	}

	@Override
	public int compareTo(it.eng.allerte.model.RubricaSito rubricaSito) {
		return _rubricaSito.compareTo(rubricaSito);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaSito.getExpandoBridge();
	}

	/**
	 * Returns the fk_liferay_site of this rubrica sito.
	 *
	 * @return the fk_liferay_site of this rubrica sito
	 */
	@Override
	public long getFK_LIFERAY_SITE() {
		return _rubricaSito.getFK_LIFERAY_SITE();
	}

	/**
	 * Returns the id_sito of this rubrica sito.
	 *
	 * @return the id_sito of this rubrica sito
	 */
	@Override
	public long getID_SITO() {
		return _rubricaSito.getID_SITO();
	}

	/**
	 * Returns the nome of this rubrica sito.
	 *
	 * @return the nome of this rubrica sito
	 */
	@Override
	public String getNOME() {
		return _rubricaSito.getNOME();
	}

	/**
	 * Returns the primary key of this rubrica sito.
	 *
	 * @return the primary key of this rubrica sito
	 */
	@Override
	public long getPrimaryKey() {
		return _rubricaSito.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaSito.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _rubricaSito.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaSito.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaSito.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaSito.isNew();
	}

	@Override
	public void persist() {
		_rubricaSito.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaSito.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaSito.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaSito.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaSito.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fk_liferay_site of this rubrica sito.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site of this rubrica sito
	 */
	@Override
	public void setFK_LIFERAY_SITE(long FK_LIFERAY_SITE) {
		_rubricaSito.setFK_LIFERAY_SITE(FK_LIFERAY_SITE);
	}

	/**
	 * Sets the id_sito of this rubrica sito.
	 *
	 * @param ID_SITO the id_sito of this rubrica sito
	 */
	@Override
	public void setID_SITO(long ID_SITO) {
		_rubricaSito.setID_SITO(ID_SITO);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaSito.setNew(n);
	}

	/**
	 * Sets the nome of this rubrica sito.
	 *
	 * @param NOME the nome of this rubrica sito
	 */
	@Override
	public void setNOME(String NOME) {
		_rubricaSito.setNOME(NOME);
	}

	/**
	 * Sets the primary key of this rubrica sito.
	 *
	 * @param primaryKey the primary key of this rubrica sito
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rubricaSito.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaSito.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaSito> toCacheModel() {

		return _rubricaSito.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaSito toEscapedModel() {
		return new RubricaSitoWrapper(_rubricaSito.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaSito.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaSito toUnescapedModel() {
		return new RubricaSitoWrapper(_rubricaSito.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaSito.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaSitoWrapper)) {
			return false;
		}

		RubricaSitoWrapper rubricaSitoWrapper = (RubricaSitoWrapper)obj;

		if (Objects.equals(_rubricaSito, rubricaSitoWrapper._rubricaSito)) {
			return true;
		}

		return false;
	}

	@Override
	public RubricaSito getWrappedModel() {
		return _rubricaSito;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaSito.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaSito.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaSito.resetOriginalValues();
	}

	private final RubricaSito _rubricaSito;

}