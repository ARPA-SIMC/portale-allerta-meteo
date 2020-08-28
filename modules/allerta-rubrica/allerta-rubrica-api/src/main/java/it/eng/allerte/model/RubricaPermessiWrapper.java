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
 * This class is a wrapper for {@link RubricaPermessi}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaPermessi
 * @generated
 */
@ProviderType
public class RubricaPermessiWrapper
	implements RubricaPermessi, ModelWrapper<RubricaPermessi> {

	public RubricaPermessiWrapper(RubricaPermessi rubricaPermessi) {
		_rubricaPermessi = rubricaPermessi;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaPermessi.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaPermessi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_PERMESSO", getID_PERMESSO());
		attributes.put("NOME_PERMESSO", getNOME_PERMESSO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String ID_PERMESSO = (String)attributes.get("ID_PERMESSO");

		if (ID_PERMESSO != null) {
			setID_PERMESSO(ID_PERMESSO);
		}

		String NOME_PERMESSO = (String)attributes.get("NOME_PERMESSO");

		if (NOME_PERMESSO != null) {
			setNOME_PERMESSO(NOME_PERMESSO);
		}
	}

	@Override
	public Object clone() {
		return new RubricaPermessiWrapper(
			(RubricaPermessi)_rubricaPermessi.clone());
	}

	@Override
	public int compareTo(it.eng.allerte.model.RubricaPermessi rubricaPermessi) {
		return _rubricaPermessi.compareTo(rubricaPermessi);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaPermessi.getExpandoBridge();
	}

	/**
	 * Returns the id_permesso of this rubrica permessi.
	 *
	 * @return the id_permesso of this rubrica permessi
	 */
	@Override
	public String getID_PERMESSO() {
		return _rubricaPermessi.getID_PERMESSO();
	}

	/**
	 * Returns the nome_permesso of this rubrica permessi.
	 *
	 * @return the nome_permesso of this rubrica permessi
	 */
	@Override
	public String getNOME_PERMESSO() {
		return _rubricaPermessi.getNOME_PERMESSO();
	}

	/**
	 * Returns the primary key of this rubrica permessi.
	 *
	 * @return the primary key of this rubrica permessi
	 */
	@Override
	public String getPrimaryKey() {
		return _rubricaPermessi.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaPermessi.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _rubricaPermessi.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaPermessi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaPermessi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaPermessi.isNew();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaPermessi.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaPermessi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaPermessi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaPermessi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id_permesso of this rubrica permessi.
	 *
	 * @param ID_PERMESSO the id_permesso of this rubrica permessi
	 */
	@Override
	public void setID_PERMESSO(String ID_PERMESSO) {
		_rubricaPermessi.setID_PERMESSO(ID_PERMESSO);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaPermessi.setNew(n);
	}

	/**
	 * Sets the nome_permesso of this rubrica permessi.
	 *
	 * @param NOME_PERMESSO the nome_permesso of this rubrica permessi
	 */
	@Override
	public void setNOME_PERMESSO(String NOME_PERMESSO) {
		_rubricaPermessi.setNOME_PERMESSO(NOME_PERMESSO);
	}

	/**
	 * Sets the primary key of this rubrica permessi.
	 *
	 * @param primaryKey the primary key of this rubrica permessi
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_rubricaPermessi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaPermessi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaPermessi> toCacheModel() {

		return _rubricaPermessi.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaPermessi toEscapedModel() {
		return new RubricaPermessiWrapper(_rubricaPermessi.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaPermessi.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaPermessi toUnescapedModel() {
		return new RubricaPermessiWrapper(_rubricaPermessi.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaPermessi.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaPermessiWrapper)) {
			return false;
		}

		RubricaPermessiWrapper rubricaPermessiWrapper =
			(RubricaPermessiWrapper)obj;

		if (Objects.equals(
				_rubricaPermessi, rubricaPermessiWrapper._rubricaPermessi)) {

			return true;
		}

		return false;
	}

	@Override
	public RubricaPermessi getWrappedModel() {
		return _rubricaPermessi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaPermessi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaPermessi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaPermessi.resetOriginalValues();
	}

	private final RubricaPermessi _rubricaPermessi;

}