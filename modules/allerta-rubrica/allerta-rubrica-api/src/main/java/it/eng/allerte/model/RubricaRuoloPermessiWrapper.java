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
 * This class is a wrapper for {@link RubricaRuoloPermessi}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessi
 * @generated
 */
@ProviderType
public class RubricaRuoloPermessiWrapper
	implements RubricaRuoloPermessi, ModelWrapper<RubricaRuoloPermessi> {

	public RubricaRuoloPermessiWrapper(
		RubricaRuoloPermessi rubricaRuoloPermessi) {

		_rubricaRuoloPermessi = rubricaRuoloPermessi;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaRuoloPermessi.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaRuoloPermessi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("FK_ID_RUOLO", getFK_ID_RUOLO());
		attributes.put("FK_ID_PERMESSO", getFK_ID_PERMESSO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long FK_ID_RUOLO = (Long)attributes.get("FK_ID_RUOLO");

		if (FK_ID_RUOLO != null) {
			setFK_ID_RUOLO(FK_ID_RUOLO);
		}

		String FK_ID_PERMESSO = (String)attributes.get("FK_ID_PERMESSO");

		if (FK_ID_PERMESSO != null) {
			setFK_ID_PERMESSO(FK_ID_PERMESSO);
		}
	}

	@Override
	public Object clone() {
		return new RubricaRuoloPermessiWrapper(
			(RubricaRuoloPermessi)_rubricaRuoloPermessi.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerte.model.RubricaRuoloPermessi rubricaRuoloPermessi) {

		return _rubricaRuoloPermessi.compareTo(rubricaRuoloPermessi);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaRuoloPermessi.getExpandoBridge();
	}

	/**
	 * Returns the fk_id_permesso of this rubrica ruolo permessi.
	 *
	 * @return the fk_id_permesso of this rubrica ruolo permessi
	 */
	@Override
	public String getFK_ID_PERMESSO() {
		return _rubricaRuoloPermessi.getFK_ID_PERMESSO();
	}

	/**
	 * Returns the fk_id_ruolo of this rubrica ruolo permessi.
	 *
	 * @return the fk_id_ruolo of this rubrica ruolo permessi
	 */
	@Override
	public long getFK_ID_RUOLO() {
		return _rubricaRuoloPermessi.getFK_ID_RUOLO();
	}

	/**
	 * Returns the primary key of this rubrica ruolo permessi.
	 *
	 * @return the primary key of this rubrica ruolo permessi
	 */
	@Override
	public it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
		getPrimaryKey() {

		return _rubricaRuoloPermessi.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaRuoloPermessi.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _rubricaRuoloPermessi.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaRuoloPermessi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaRuoloPermessi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaRuoloPermessi.isNew();
	}

	@Override
	public void persist() {
		_rubricaRuoloPermessi.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaRuoloPermessi.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaRuoloPermessi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaRuoloPermessi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaRuoloPermessi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fk_id_permesso of this rubrica ruolo permessi.
	 *
	 * @param FK_ID_PERMESSO the fk_id_permesso of this rubrica ruolo permessi
	 */
	@Override
	public void setFK_ID_PERMESSO(String FK_ID_PERMESSO) {
		_rubricaRuoloPermessi.setFK_ID_PERMESSO(FK_ID_PERMESSO);
	}

	/**
	 * Sets the fk_id_ruolo of this rubrica ruolo permessi.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo of this rubrica ruolo permessi
	 */
	@Override
	public void setFK_ID_RUOLO(long FK_ID_RUOLO) {
		_rubricaRuoloPermessi.setFK_ID_RUOLO(FK_ID_RUOLO);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaRuoloPermessi.setNew(n);
	}

	/**
	 * Sets the primary key of this rubrica ruolo permessi.
	 *
	 * @param primaryKey the primary key of this rubrica ruolo permessi
	 */
	@Override
	public void setPrimaryKey(
		it.eng.allerte.service.persistence.RubricaRuoloPermessiPK primaryKey) {

		_rubricaRuoloPermessi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaRuoloPermessi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaRuoloPermessi> toCacheModel() {

		return _rubricaRuoloPermessi.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaRuoloPermessi toEscapedModel() {
		return new RubricaRuoloPermessiWrapper(
			_rubricaRuoloPermessi.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaRuoloPermessi.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaRuoloPermessi toUnescapedModel() {
		return new RubricaRuoloPermessiWrapper(
			_rubricaRuoloPermessi.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaRuoloPermessi.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaRuoloPermessiWrapper)) {
			return false;
		}

		RubricaRuoloPermessiWrapper rubricaRuoloPermessiWrapper =
			(RubricaRuoloPermessiWrapper)obj;

		if (Objects.equals(
				_rubricaRuoloPermessi,
				rubricaRuoloPermessiWrapper._rubricaRuoloPermessi)) {

			return true;
		}

		return false;
	}

	@Override
	public RubricaRuoloPermessi getWrappedModel() {
		return _rubricaRuoloPermessi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaRuoloPermessi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaRuoloPermessi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaRuoloPermessi.resetOriginalValues();
	}

	private final RubricaRuoloPermessi _rubricaRuoloPermessi;

}