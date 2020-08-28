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
 * This class is a wrapper for {@link RubricaCanale}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaCanale
 * @generated
 */
@ProviderType
public class RubricaCanaleWrapper
	implements RubricaCanale, ModelWrapper<RubricaCanale> {

	public RubricaCanaleWrapper(RubricaCanale rubricaCanale) {
		_rubricaCanale = rubricaCanale;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaCanale.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaCanale.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_CANALE", getID_CANALE());
		attributes.put("NOME", getNOME());
		attributes.put("ICONA", getICONA());
		attributes.put("REGEX", getREGEX());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_CANALE = (Long)attributes.get("ID_CANALE");

		if (ID_CANALE != null) {
			setID_CANALE(ID_CANALE);
		}

		String NOME = (String)attributes.get("NOME");

		if (NOME != null) {
			setNOME(NOME);
		}

		String ICONA = (String)attributes.get("ICONA");

		if (ICONA != null) {
			setICONA(ICONA);
		}

		String REGEX = (String)attributes.get("REGEX");

		if (REGEX != null) {
			setREGEX(REGEX);
		}
	}

	@Override
	public Object clone() {
		return new RubricaCanaleWrapper((RubricaCanale)_rubricaCanale.clone());
	}

	@Override
	public int compareTo(it.eng.allerte.model.RubricaCanale rubricaCanale) {
		return _rubricaCanale.compareTo(rubricaCanale);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaCanale.getExpandoBridge();
	}

	/**
	 * Returns the icona of this rubrica canale.
	 *
	 * @return the icona of this rubrica canale
	 */
	@Override
	public String getICONA() {
		return _rubricaCanale.getICONA();
	}

	/**
	 * Returns the id_canale of this rubrica canale.
	 *
	 * @return the id_canale of this rubrica canale
	 */
	@Override
	public long getID_CANALE() {
		return _rubricaCanale.getID_CANALE();
	}

	/**
	 * Returns the nome of this rubrica canale.
	 *
	 * @return the nome of this rubrica canale
	 */
	@Override
	public String getNOME() {
		return _rubricaCanale.getNOME();
	}

	/**
	 * Returns the primary key of this rubrica canale.
	 *
	 * @return the primary key of this rubrica canale
	 */
	@Override
	public long getPrimaryKey() {
		return _rubricaCanale.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaCanale.getPrimaryKeyObj();
	}

	/**
	 * Returns the regex of this rubrica canale.
	 *
	 * @return the regex of this rubrica canale
	 */
	@Override
	public String getREGEX() {
		return _rubricaCanale.getREGEX();
	}

	@Override
	public int hashCode() {
		return _rubricaCanale.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaCanale.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaCanale.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaCanale.isNew();
	}

	@Override
	public void persist() {
		_rubricaCanale.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaCanale.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaCanale.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaCanale.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaCanale.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the icona of this rubrica canale.
	 *
	 * @param ICONA the icona of this rubrica canale
	 */
	@Override
	public void setICONA(String ICONA) {
		_rubricaCanale.setICONA(ICONA);
	}

	/**
	 * Sets the id_canale of this rubrica canale.
	 *
	 * @param ID_CANALE the id_canale of this rubrica canale
	 */
	@Override
	public void setID_CANALE(long ID_CANALE) {
		_rubricaCanale.setID_CANALE(ID_CANALE);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaCanale.setNew(n);
	}

	/**
	 * Sets the nome of this rubrica canale.
	 *
	 * @param NOME the nome of this rubrica canale
	 */
	@Override
	public void setNOME(String NOME) {
		_rubricaCanale.setNOME(NOME);
	}

	/**
	 * Sets the primary key of this rubrica canale.
	 *
	 * @param primaryKey the primary key of this rubrica canale
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rubricaCanale.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaCanale.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the regex of this rubrica canale.
	 *
	 * @param REGEX the regex of this rubrica canale
	 */
	@Override
	public void setREGEX(String REGEX) {
		_rubricaCanale.setREGEX(REGEX);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaCanale> toCacheModel() {

		return _rubricaCanale.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaCanale toEscapedModel() {
		return new RubricaCanaleWrapper(_rubricaCanale.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaCanale.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaCanale toUnescapedModel() {
		return new RubricaCanaleWrapper(_rubricaCanale.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaCanale.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaCanaleWrapper)) {
			return false;
		}

		RubricaCanaleWrapper rubricaCanaleWrapper = (RubricaCanaleWrapper)obj;

		if (Objects.equals(
				_rubricaCanale, rubricaCanaleWrapper._rubricaCanale)) {

			return true;
		}

		return false;
	}

	@Override
	public RubricaCanale getWrappedModel() {
		return _rubricaCanale;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaCanale.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaCanale.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaCanale.resetOriginalValues();
	}

	private final RubricaCanale _rubricaCanale;

}