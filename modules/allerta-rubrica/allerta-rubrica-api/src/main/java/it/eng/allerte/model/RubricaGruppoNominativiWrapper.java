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
 * This class is a wrapper for {@link RubricaGruppoNominativi}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativi
 * @generated
 */
@ProviderType
public class RubricaGruppoNominativiWrapper
	implements RubricaGruppoNominativi, ModelWrapper<RubricaGruppoNominativi> {

	public RubricaGruppoNominativiWrapper(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		_rubricaGruppoNominativi = rubricaGruppoNominativi;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaGruppoNominativi.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaGruppoNominativi.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("FK_GRUPPO", getFK_GRUPPO());
		attributes.put("FK_NOMINATIVO", getFK_NOMINATIVO());
		attributes.put("FK_RUOLO", getFK_RUOLO());
		attributes.put("SPECIFICA_RUOLO", getSPECIFICA_RUOLO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long FK_GRUPPO = (Long)attributes.get("FK_GRUPPO");

		if (FK_GRUPPO != null) {
			setFK_GRUPPO(FK_GRUPPO);
		}

		Long FK_NOMINATIVO = (Long)attributes.get("FK_NOMINATIVO");

		if (FK_NOMINATIVO != null) {
			setFK_NOMINATIVO(FK_NOMINATIVO);
		}

		Long FK_RUOLO = (Long)attributes.get("FK_RUOLO");

		if (FK_RUOLO != null) {
			setFK_RUOLO(FK_RUOLO);
		}

		String SPECIFICA_RUOLO = (String)attributes.get("SPECIFICA_RUOLO");

		if (SPECIFICA_RUOLO != null) {
			setSPECIFICA_RUOLO(SPECIFICA_RUOLO);
		}
	}

	@Override
	public Object clone() {
		return new RubricaGruppoNominativiWrapper(
			(RubricaGruppoNominativi)_rubricaGruppoNominativi.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerte.model.RubricaGruppoNominativi rubricaGruppoNominativi) {

		return _rubricaGruppoNominativi.compareTo(rubricaGruppoNominativi);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaGruppoNominativi.getExpandoBridge();
	}

	/**
	 * Returns the fk_gruppo of this rubrica gruppo nominativi.
	 *
	 * @return the fk_gruppo of this rubrica gruppo nominativi
	 */
	@Override
	public long getFK_GRUPPO() {
		return _rubricaGruppoNominativi.getFK_GRUPPO();
	}

	/**
	 * Returns the fk_nominativo of this rubrica gruppo nominativi.
	 *
	 * @return the fk_nominativo of this rubrica gruppo nominativi
	 */
	@Override
	public long getFK_NOMINATIVO() {
		return _rubricaGruppoNominativi.getFK_NOMINATIVO();
	}

	/**
	 * Returns the fk_ruolo of this rubrica gruppo nominativi.
	 *
	 * @return the fk_ruolo of this rubrica gruppo nominativi
	 */
	@Override
	public long getFK_RUOLO() {
		return _rubricaGruppoNominativi.getFK_RUOLO();
	}

	/**
	 * Returns the primary key of this rubrica gruppo nominativi.
	 *
	 * @return the primary key of this rubrica gruppo nominativi
	 */
	@Override
	public it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
		getPrimaryKey() {

		return _rubricaGruppoNominativi.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaGruppoNominativi.getPrimaryKeyObj();
	}

	/**
	 * Returns the specifica_ruolo of this rubrica gruppo nominativi.
	 *
	 * @return the specifica_ruolo of this rubrica gruppo nominativi
	 */
	@Override
	public String getSPECIFICA_RUOLO() {
		return _rubricaGruppoNominativi.getSPECIFICA_RUOLO();
	}

	@Override
	public int hashCode() {
		return _rubricaGruppoNominativi.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaGruppoNominativi.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaGruppoNominativi.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaGruppoNominativi.isNew();
	}

	@Override
	public void persist() {
		_rubricaGruppoNominativi.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaGruppoNominativi.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaGruppoNominativi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaGruppoNominativi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaGruppoNominativi.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fk_gruppo of this rubrica gruppo nominativi.
	 *
	 * @param FK_GRUPPO the fk_gruppo of this rubrica gruppo nominativi
	 */
	@Override
	public void setFK_GRUPPO(long FK_GRUPPO) {
		_rubricaGruppoNominativi.setFK_GRUPPO(FK_GRUPPO);
	}

	/**
	 * Sets the fk_nominativo of this rubrica gruppo nominativi.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo of this rubrica gruppo nominativi
	 */
	@Override
	public void setFK_NOMINATIVO(long FK_NOMINATIVO) {
		_rubricaGruppoNominativi.setFK_NOMINATIVO(FK_NOMINATIVO);
	}

	/**
	 * Sets the fk_ruolo of this rubrica gruppo nominativi.
	 *
	 * @param FK_RUOLO the fk_ruolo of this rubrica gruppo nominativi
	 */
	@Override
	public void setFK_RUOLO(long FK_RUOLO) {
		_rubricaGruppoNominativi.setFK_RUOLO(FK_RUOLO);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaGruppoNominativi.setNew(n);
	}

	/**
	 * Sets the primary key of this rubrica gruppo nominativi.
	 *
	 * @param primaryKey the primary key of this rubrica gruppo nominativi
	 */
	@Override
	public void setPrimaryKey(
		it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
			primaryKey) {

		_rubricaGruppoNominativi.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaGruppoNominativi.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the specifica_ruolo of this rubrica gruppo nominativi.
	 *
	 * @param SPECIFICA_RUOLO the specifica_ruolo of this rubrica gruppo nominativi
	 */
	@Override
	public void setSPECIFICA_RUOLO(String SPECIFICA_RUOLO) {
		_rubricaGruppoNominativi.setSPECIFICA_RUOLO(SPECIFICA_RUOLO);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaGruppoNominativi> toCacheModel() {

		return _rubricaGruppoNominativi.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaGruppoNominativi toEscapedModel() {
		return new RubricaGruppoNominativiWrapper(
			_rubricaGruppoNominativi.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaGruppoNominativi.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaGruppoNominativi toUnescapedModel() {
		return new RubricaGruppoNominativiWrapper(
			_rubricaGruppoNominativi.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaGruppoNominativi.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaGruppoNominativiWrapper)) {
			return false;
		}

		RubricaGruppoNominativiWrapper rubricaGruppoNominativiWrapper =
			(RubricaGruppoNominativiWrapper)obj;

		if (Objects.equals(
				_rubricaGruppoNominativi,
				rubricaGruppoNominativiWrapper._rubricaGruppoNominativi)) {

			return true;
		}

		return false;
	}

	@Override
	public RubricaGruppoNominativi getWrappedModel() {
		return _rubricaGruppoNominativi;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaGruppoNominativi.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaGruppoNominativi.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaGruppoNominativi.resetOriginalValues();
	}

	private final RubricaGruppoNominativi _rubricaGruppoNominativi;

}