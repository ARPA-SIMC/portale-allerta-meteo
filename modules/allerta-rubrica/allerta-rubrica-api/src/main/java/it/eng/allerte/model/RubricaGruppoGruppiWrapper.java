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
 * This class is a wrapper for {@link RubricaGruppoGruppi}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppi
 * @generated
 */
@ProviderType
public class RubricaGruppoGruppiWrapper
	implements RubricaGruppoGruppi, ModelWrapper<RubricaGruppoGruppi> {

	public RubricaGruppoGruppiWrapper(RubricaGruppoGruppi rubricaGruppoGruppi) {
		_rubricaGruppoGruppi = rubricaGruppoGruppi;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaGruppoGruppi.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaGruppoGruppi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("FK_GRUPPO_PADRE", getFK_GRUPPO_PADRE());
		attributes.put("FK_GRUPPO_FIGLIO", getFK_GRUPPO_FIGLIO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long FK_GRUPPO_PADRE = (Long)attributes.get("FK_GRUPPO_PADRE");

		if (FK_GRUPPO_PADRE != null) {
			setFK_GRUPPO_PADRE(FK_GRUPPO_PADRE);
		}

		Long FK_GRUPPO_FIGLIO = (Long)attributes.get("FK_GRUPPO_FIGLIO");

		if (FK_GRUPPO_FIGLIO != null) {
			setFK_GRUPPO_FIGLIO(FK_GRUPPO_FIGLIO);
		}
	}

	@Override
	public Object clone() {
		return new RubricaGruppoGruppiWrapper(
			(RubricaGruppoGruppi)_rubricaGruppoGruppi.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerte.model.RubricaGruppoGruppi rubricaGruppoGruppi) {

		return _rubricaGruppoGruppi.compareTo(rubricaGruppoGruppi);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaGruppoGruppi.getExpandoBridge();
	}

	/**
	 * Returns the fk_gruppo_figlio of this rubrica gruppo gruppi.
	 *
	 * @return the fk_gruppo_figlio of this rubrica gruppo gruppi
	 */
	@Override
	public long getFK_GRUPPO_FIGLIO() {
		return _rubricaGruppoGruppi.getFK_GRUPPO_FIGLIO();
	}

	/**
	 * Returns the fk_gruppo_padre of this rubrica gruppo gruppi.
	 *
	 * @return the fk_gruppo_padre of this rubrica gruppo gruppi
	 */
	@Override
	public long getFK_GRUPPO_PADRE() {
		return _rubricaGruppoGruppi.getFK_GRUPPO_PADRE();
	}

	/**
	 * Returns the primary key of this rubrica gruppo gruppi.
	 *
	 * @return the primary key of this rubrica gruppo gruppi
	 */
	@Override
	public it.eng.allerte.service.persistence.RubricaGruppoGruppiPK
		getPrimaryKey() {

		return _rubricaGruppoGruppi.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaGruppoGruppi.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _rubricaGruppoGruppi.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaGruppoGruppi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaGruppoGruppi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaGruppoGruppi.isNew();
	}

	@Override
	public void persist() {
		_rubricaGruppoGruppi.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaGruppoGruppi.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaGruppoGruppi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaGruppoGruppi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaGruppoGruppi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fk_gruppo_figlio of this rubrica gruppo gruppi.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio of this rubrica gruppo gruppi
	 */
	@Override
	public void setFK_GRUPPO_FIGLIO(long FK_GRUPPO_FIGLIO) {
		_rubricaGruppoGruppi.setFK_GRUPPO_FIGLIO(FK_GRUPPO_FIGLIO);
	}

	/**
	 * Sets the fk_gruppo_padre of this rubrica gruppo gruppi.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre of this rubrica gruppo gruppi
	 */
	@Override
	public void setFK_GRUPPO_PADRE(long FK_GRUPPO_PADRE) {
		_rubricaGruppoGruppi.setFK_GRUPPO_PADRE(FK_GRUPPO_PADRE);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaGruppoGruppi.setNew(n);
	}

	/**
	 * Sets the primary key of this rubrica gruppo gruppi.
	 *
	 * @param primaryKey the primary key of this rubrica gruppo gruppi
	 */
	@Override
	public void setPrimaryKey(
		it.eng.allerte.service.persistence.RubricaGruppoGruppiPK primaryKey) {

		_rubricaGruppoGruppi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaGruppoGruppi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaGruppoGruppi> toCacheModel() {

		return _rubricaGruppoGruppi.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaGruppoGruppi toEscapedModel() {
		return new RubricaGruppoGruppiWrapper(
			_rubricaGruppoGruppi.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaGruppoGruppi.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaGruppoGruppi toUnescapedModel() {
		return new RubricaGruppoGruppiWrapper(
			_rubricaGruppoGruppi.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaGruppoGruppi.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaGruppoGruppiWrapper)) {
			return false;
		}

		RubricaGruppoGruppiWrapper rubricaGruppoGruppiWrapper =
			(RubricaGruppoGruppiWrapper)obj;

		if (Objects.equals(
				_rubricaGruppoGruppi,
				rubricaGruppoGruppiWrapper._rubricaGruppoGruppi)) {

			return true;
		}

		return false;
	}

	@Override
	public RubricaGruppoGruppi getWrappedModel() {
		return _rubricaGruppoGruppi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaGruppoGruppi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaGruppoGruppi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaGruppoGruppi.resetOriginalValues();
	}

	private final RubricaGruppoGruppi _rubricaGruppoGruppi;

}