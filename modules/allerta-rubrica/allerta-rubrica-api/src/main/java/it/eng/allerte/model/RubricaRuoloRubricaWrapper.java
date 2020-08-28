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
 * This class is a wrapper for {@link RubricaRuoloRubrica}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuoloRubrica
 * @generated
 */
@ProviderType
public class RubricaRuoloRubricaWrapper
	implements RubricaRuoloRubrica, ModelWrapper<RubricaRuoloRubrica> {

	public RubricaRuoloRubricaWrapper(RubricaRuoloRubrica rubricaRuoloRubrica) {
		_rubricaRuoloRubrica = rubricaRuoloRubrica;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaRuoloRubrica.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaRuoloRubrica.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_RUOLO", getID_RUOLO());
		attributes.put("DESCRIZIONE", getDESCRIZIONE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_RUOLO = (Long)attributes.get("ID_RUOLO");

		if (ID_RUOLO != null) {
			setID_RUOLO(ID_RUOLO);
		}

		String DESCRIZIONE = (String)attributes.get("DESCRIZIONE");

		if (DESCRIZIONE != null) {
			setDESCRIZIONE(DESCRIZIONE);
		}
	}

	@Override
	public Object clone() {
		return new RubricaRuoloRubricaWrapper(
			(RubricaRuoloRubrica)_rubricaRuoloRubrica.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerte.model.RubricaRuoloRubrica rubricaRuoloRubrica) {

		return _rubricaRuoloRubrica.compareTo(rubricaRuoloRubrica);
	}

	/**
	 * Returns the descrizione of this rubrica ruolo rubrica.
	 *
	 * @return the descrizione of this rubrica ruolo rubrica
	 */
	@Override
	public String getDESCRIZIONE() {
		return _rubricaRuoloRubrica.getDESCRIZIONE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaRuoloRubrica.getExpandoBridge();
	}

	/**
	 * Returns the id_ruolo of this rubrica ruolo rubrica.
	 *
	 * @return the id_ruolo of this rubrica ruolo rubrica
	 */
	@Override
	public long getID_RUOLO() {
		return _rubricaRuoloRubrica.getID_RUOLO();
	}

	/**
	 * Returns the primary key of this rubrica ruolo rubrica.
	 *
	 * @return the primary key of this rubrica ruolo rubrica
	 */
	@Override
	public long getPrimaryKey() {
		return _rubricaRuoloRubrica.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaRuoloRubrica.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _rubricaRuoloRubrica.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaRuoloRubrica.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaRuoloRubrica.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaRuoloRubrica.isNew();
	}

	@Override
	public void persist() {
		_rubricaRuoloRubrica.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaRuoloRubrica.setCachedModel(cachedModel);
	}

	/**
	 * Sets the descrizione of this rubrica ruolo rubrica.
	 *
	 * @param DESCRIZIONE the descrizione of this rubrica ruolo rubrica
	 */
	@Override
	public void setDESCRIZIONE(String DESCRIZIONE) {
		_rubricaRuoloRubrica.setDESCRIZIONE(DESCRIZIONE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaRuoloRubrica.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaRuoloRubrica.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaRuoloRubrica.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id_ruolo of this rubrica ruolo rubrica.
	 *
	 * @param ID_RUOLO the id_ruolo of this rubrica ruolo rubrica
	 */
	@Override
	public void setID_RUOLO(long ID_RUOLO) {
		_rubricaRuoloRubrica.setID_RUOLO(ID_RUOLO);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaRuoloRubrica.setNew(n);
	}

	/**
	 * Sets the primary key of this rubrica ruolo rubrica.
	 *
	 * @param primaryKey the primary key of this rubrica ruolo rubrica
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rubricaRuoloRubrica.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaRuoloRubrica.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaRuoloRubrica> toCacheModel() {

		return _rubricaRuoloRubrica.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaRuoloRubrica toEscapedModel() {
		return new RubricaRuoloRubricaWrapper(
			_rubricaRuoloRubrica.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaRuoloRubrica.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaRuoloRubrica toUnescapedModel() {
		return new RubricaRuoloRubricaWrapper(
			_rubricaRuoloRubrica.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaRuoloRubrica.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaRuoloRubricaWrapper)) {
			return false;
		}

		RubricaRuoloRubricaWrapper rubricaRuoloRubricaWrapper =
			(RubricaRuoloRubricaWrapper)obj;

		if (Objects.equals(
				_rubricaRuoloRubrica,
				rubricaRuoloRubricaWrapper._rubricaRuoloRubrica)) {

			return true;
		}

		return false;
	}

	@Override
	public RubricaRuoloRubrica getWrappedModel() {
		return _rubricaRuoloRubrica;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaRuoloRubrica.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaRuoloRubrica.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaRuoloRubrica.resetOriginalValues();
	}

	private final RubricaRuoloRubrica _rubricaRuoloRubrica;

}