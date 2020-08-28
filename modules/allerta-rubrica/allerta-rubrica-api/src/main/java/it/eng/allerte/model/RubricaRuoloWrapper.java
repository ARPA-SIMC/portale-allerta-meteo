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
 * This class is a wrapper for {@link RubricaRuolo}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuolo
 * @generated
 */
@ProviderType
public class RubricaRuoloWrapper
	implements RubricaRuolo, ModelWrapper<RubricaRuolo> {

	public RubricaRuoloWrapper(RubricaRuolo rubricaRuolo) {
		_rubricaRuolo = rubricaRuolo;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaRuolo.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaRuolo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_RUOLO", getID_RUOLO());
		attributes.put("DESCRIZIONE", getDESCRIZIONE());
		attributes.put("FK_RUOLO_LIFERAY", getFK_RUOLO_LIFERAY());

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

		Long FK_RUOLO_LIFERAY = (Long)attributes.get("FK_RUOLO_LIFERAY");

		if (FK_RUOLO_LIFERAY != null) {
			setFK_RUOLO_LIFERAY(FK_RUOLO_LIFERAY);
		}
	}

	@Override
	public Object clone() {
		return new RubricaRuoloWrapper((RubricaRuolo)_rubricaRuolo.clone());
	}

	@Override
	public int compareTo(it.eng.allerte.model.RubricaRuolo rubricaRuolo) {
		return _rubricaRuolo.compareTo(rubricaRuolo);
	}

	/**
	 * Returns the descrizione of this rubrica ruolo.
	 *
	 * @return the descrizione of this rubrica ruolo
	 */
	@Override
	public String getDESCRIZIONE() {
		return _rubricaRuolo.getDESCRIZIONE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaRuolo.getExpandoBridge();
	}

	/**
	 * Returns the fk_ruolo_liferay of this rubrica ruolo.
	 *
	 * @return the fk_ruolo_liferay of this rubrica ruolo
	 */
	@Override
	public long getFK_RUOLO_LIFERAY() {
		return _rubricaRuolo.getFK_RUOLO_LIFERAY();
	}

	/**
	 * Returns the id_ruolo of this rubrica ruolo.
	 *
	 * @return the id_ruolo of this rubrica ruolo
	 */
	@Override
	public long getID_RUOLO() {
		return _rubricaRuolo.getID_RUOLO();
	}

	/**
	 * Returns the primary key of this rubrica ruolo.
	 *
	 * @return the primary key of this rubrica ruolo
	 */
	@Override
	public long getPrimaryKey() {
		return _rubricaRuolo.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaRuolo.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _rubricaRuolo.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaRuolo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaRuolo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaRuolo.isNew();
	}

	@Override
	public void persist() {
		_rubricaRuolo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaRuolo.setCachedModel(cachedModel);
	}

	/**
	 * Sets the descrizione of this rubrica ruolo.
	 *
	 * @param DESCRIZIONE the descrizione of this rubrica ruolo
	 */
	@Override
	public void setDESCRIZIONE(String DESCRIZIONE) {
		_rubricaRuolo.setDESCRIZIONE(DESCRIZIONE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaRuolo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaRuolo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaRuolo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fk_ruolo_liferay of this rubrica ruolo.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay of this rubrica ruolo
	 */
	@Override
	public void setFK_RUOLO_LIFERAY(long FK_RUOLO_LIFERAY) {
		_rubricaRuolo.setFK_RUOLO_LIFERAY(FK_RUOLO_LIFERAY);
	}

	/**
	 * Sets the id_ruolo of this rubrica ruolo.
	 *
	 * @param ID_RUOLO the id_ruolo of this rubrica ruolo
	 */
	@Override
	public void setID_RUOLO(long ID_RUOLO) {
		_rubricaRuolo.setID_RUOLO(ID_RUOLO);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaRuolo.setNew(n);
	}

	/**
	 * Sets the primary key of this rubrica ruolo.
	 *
	 * @param primaryKey the primary key of this rubrica ruolo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rubricaRuolo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaRuolo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaRuolo> toCacheModel() {

		return _rubricaRuolo.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaRuolo toEscapedModel() {
		return new RubricaRuoloWrapper(_rubricaRuolo.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaRuolo.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaRuolo toUnescapedModel() {
		return new RubricaRuoloWrapper(_rubricaRuolo.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaRuolo.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaRuoloWrapper)) {
			return false;
		}

		RubricaRuoloWrapper rubricaRuoloWrapper = (RubricaRuoloWrapper)obj;

		if (Objects.equals(_rubricaRuolo, rubricaRuoloWrapper._rubricaRuolo)) {
			return true;
		}

		return false;
	}

	@Override
	public RubricaRuolo getWrappedModel() {
		return _rubricaRuolo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaRuolo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaRuolo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaRuolo.resetOriginalValues();
	}

	private final RubricaRuolo _rubricaRuolo;

}