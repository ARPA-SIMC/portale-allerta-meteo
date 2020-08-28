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
 * This class is a wrapper for {@link RubricaUtenteSito}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaUtenteSito
 * @generated
 */
@ProviderType
public class RubricaUtenteSitoWrapper
	implements RubricaUtenteSito, ModelWrapper<RubricaUtenteSito> {

	public RubricaUtenteSitoWrapper(RubricaUtenteSito rubricaUtenteSito) {
		_rubricaUtenteSito = rubricaUtenteSito;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaUtenteSito.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaUtenteSito.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_UTENTE", getID_UTENTE());
		attributes.put("ID_SITO", getID_SITO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_UTENTE = (Long)attributes.get("ID_UTENTE");

		if (ID_UTENTE != null) {
			setID_UTENTE(ID_UTENTE);
		}

		Long ID_SITO = (Long)attributes.get("ID_SITO");

		if (ID_SITO != null) {
			setID_SITO(ID_SITO);
		}
	}

	@Override
	public Object clone() {
		return new RubricaUtenteSitoWrapper(
			(RubricaUtenteSito)_rubricaUtenteSito.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerte.model.RubricaUtenteSito rubricaUtenteSito) {

		return _rubricaUtenteSito.compareTo(rubricaUtenteSito);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaUtenteSito.getExpandoBridge();
	}

	/**
	 * Returns the id_sito of this rubrica utente sito.
	 *
	 * @return the id_sito of this rubrica utente sito
	 */
	@Override
	public long getID_SITO() {
		return _rubricaUtenteSito.getID_SITO();
	}

	/**
	 * Returns the id_utente of this rubrica utente sito.
	 *
	 * @return the id_utente of this rubrica utente sito
	 */
	@Override
	public long getID_UTENTE() {
		return _rubricaUtenteSito.getID_UTENTE();
	}

	/**
	 * Returns the primary key of this rubrica utente sito.
	 *
	 * @return the primary key of this rubrica utente sito
	 */
	@Override
	public long getPrimaryKey() {
		return _rubricaUtenteSito.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaUtenteSito.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _rubricaUtenteSito.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaUtenteSito.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaUtenteSito.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaUtenteSito.isNew();
	}

	@Override
	public void persist() {
		_rubricaUtenteSito.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaUtenteSito.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaUtenteSito.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaUtenteSito.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaUtenteSito.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id_sito of this rubrica utente sito.
	 *
	 * @param ID_SITO the id_sito of this rubrica utente sito
	 */
	@Override
	public void setID_SITO(long ID_SITO) {
		_rubricaUtenteSito.setID_SITO(ID_SITO);
	}

	/**
	 * Sets the id_utente of this rubrica utente sito.
	 *
	 * @param ID_UTENTE the id_utente of this rubrica utente sito
	 */
	@Override
	public void setID_UTENTE(long ID_UTENTE) {
		_rubricaUtenteSito.setID_UTENTE(ID_UTENTE);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaUtenteSito.setNew(n);
	}

	/**
	 * Sets the primary key of this rubrica utente sito.
	 *
	 * @param primaryKey the primary key of this rubrica utente sito
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rubricaUtenteSito.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaUtenteSito.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaUtenteSito> toCacheModel() {

		return _rubricaUtenteSito.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaUtenteSito toEscapedModel() {
		return new RubricaUtenteSitoWrapper(
			_rubricaUtenteSito.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaUtenteSito.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaUtenteSito toUnescapedModel() {
		return new RubricaUtenteSitoWrapper(
			_rubricaUtenteSito.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaUtenteSito.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaUtenteSitoWrapper)) {
			return false;
		}

		RubricaUtenteSitoWrapper rubricaUtenteSitoWrapper =
			(RubricaUtenteSitoWrapper)obj;

		if (Objects.equals(
				_rubricaUtenteSito,
				rubricaUtenteSitoWrapper._rubricaUtenteSito)) {

			return true;
		}

		return false;
	}

	@Override
	public RubricaUtenteSito getWrappedModel() {
		return _rubricaUtenteSito;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaUtenteSito.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaUtenteSito.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaUtenteSito.resetOriginalValues();
	}

	private final RubricaUtenteSito _rubricaUtenteSito;

}