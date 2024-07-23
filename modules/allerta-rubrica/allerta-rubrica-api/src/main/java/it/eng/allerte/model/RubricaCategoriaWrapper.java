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
 * This class is a wrapper for {@link RubricaCategoria}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaCategoria
 * @generated
 */
@ProviderType
public class RubricaCategoriaWrapper
	implements RubricaCategoria, ModelWrapper<RubricaCategoria> {

	public RubricaCategoriaWrapper(RubricaCategoria rubricaCategoria) {
		_rubricaCategoria = rubricaCategoria;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaCategoria.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaCategoria.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_CATEGORIA", getID_CATEGORIA());
		attributes.put("DESCRIZIONE", getDESCRIZIONE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_CATEGORIA = (Long)attributes.get("ID_CATEGORIA");

		if (ID_CATEGORIA != null) {
			setID_CATEGORIA(ID_CATEGORIA);
		}

		String DESCRIZIONE = (String)attributes.get("DESCRIZIONE");

		if (DESCRIZIONE != null) {
			setDESCRIZIONE(DESCRIZIONE);
		}
	}

	@Override
	public Object clone() {
		return new RubricaCategoriaWrapper(
			(RubricaCategoria)_rubricaCategoria.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerte.model.RubricaCategoria rubricaCategoria) {

		return _rubricaCategoria.compareTo(rubricaCategoria);
	}

	/**
	 * Returns the descrizione of this rubrica categoria.
	 *
	 * @return the descrizione of this rubrica categoria
	 */
	@Override
	public String getDESCRIZIONE() {
		return _rubricaCategoria.getDESCRIZIONE();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaCategoria.getExpandoBridge();
	}

	/**
	 * Returns the id_categoria of this rubrica categoria.
	 *
	 * @return the id_categoria of this rubrica categoria
	 */
	@Override
	public long getID_CATEGORIA() {
		return _rubricaCategoria.getID_CATEGORIA();
	}

	/**
	 * Returns the primary key of this rubrica categoria.
	 *
	 * @return the primary key of this rubrica categoria
	 */
	@Override
	public long getPrimaryKey() {
		return _rubricaCategoria.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaCategoria.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _rubricaCategoria.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaCategoria.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaCategoria.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaCategoria.isNew();
	}

	@Override
	public void persist() {
		_rubricaCategoria.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaCategoria.setCachedModel(cachedModel);
	}

	/**
	 * Sets the descrizione of this rubrica categoria.
	 *
	 * @param DESCRIZIONE the descrizione of this rubrica categoria
	 */
	@Override
	public void setDESCRIZIONE(String DESCRIZIONE) {
		_rubricaCategoria.setDESCRIZIONE(DESCRIZIONE);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaCategoria.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaCategoria.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaCategoria.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id_categoria of this rubrica categoria.
	 *
	 * @param ID_CATEGORIA the id_categoria of this rubrica categoria
	 */
	@Override
	public void setID_CATEGORIA(long ID_CATEGORIA) {
		_rubricaCategoria.setID_CATEGORIA(ID_CATEGORIA);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaCategoria.setNew(n);
	}

	/**
	 * Sets the primary key of this rubrica categoria.
	 *
	 * @param primaryKey the primary key of this rubrica categoria
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rubricaCategoria.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaCategoria.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaCategoria> toCacheModel() {

		return _rubricaCategoria.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaCategoria toEscapedModel() {
		return new RubricaCategoriaWrapper(_rubricaCategoria.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaCategoria.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaCategoria toUnescapedModel() {
		return new RubricaCategoriaWrapper(
			_rubricaCategoria.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaCategoria.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaCategoriaWrapper)) {
			return false;
		}

		RubricaCategoriaWrapper rubricaCategoriaWrapper =
			(RubricaCategoriaWrapper)obj;

		if (Objects.equals(
				_rubricaCategoria, rubricaCategoriaWrapper._rubricaCategoria)) {

			return true;
		}

		return false;
	}

	@Override
	public RubricaCategoria getWrappedModel() {
		return _rubricaCategoria;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaCategoria.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaCategoria.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaCategoria.resetOriginalValues();
	}

	private final RubricaCategoria _rubricaCategoria;

}