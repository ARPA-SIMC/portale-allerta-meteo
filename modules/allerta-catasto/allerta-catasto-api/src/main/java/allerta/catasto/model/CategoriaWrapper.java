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

package allerta.catasto.model;

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
 * This class is a wrapper for {@link Categoria}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Categoria
 * @generated
 */
@ProviderType
public class CategoriaWrapper implements Categoria, ModelWrapper<Categoria> {

	public CategoriaWrapper(Categoria categoria) {
		_categoria = categoria;
	}

	@Override
	public Class<?> getModelClass() {
		return Categoria.class;
	}

	@Override
	public String getModelClassName() {
		return Categoria.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public Object clone() {
		return new CategoriaWrapper((Categoria)_categoria.clone());
	}

	@Override
	public int compareTo(allerta.catasto.model.Categoria categoria) {
		return _categoria.compareTo(categoria);
	}

	/**
	 * Returns the descrizione of this categoria.
	 *
	 * @return the descrizione of this categoria
	 */
	@Override
	public String getDescrizione() {
		return _categoria.getDescrizione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _categoria.getExpandoBridge();
	}

	/**
	 * Returns the ID of this categoria.
	 *
	 * @return the ID of this categoria
	 */
	@Override
	public long getId() {
		return _categoria.getId();
	}

	/**
	 * Returns the primary key of this categoria.
	 *
	 * @return the primary key of this categoria
	 */
	@Override
	public long getPrimaryKey() {
		return _categoria.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _categoria.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _categoria.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _categoria.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _categoria.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _categoria.isNew();
	}

	@Override
	public void persist() {
		_categoria.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_categoria.setCachedModel(cachedModel);
	}

	/**
	 * Sets the descrizione of this categoria.
	 *
	 * @param descrizione the descrizione of this categoria
	 */
	@Override
	public void setDescrizione(String descrizione) {
		_categoria.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_categoria.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_categoria.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_categoria.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this categoria.
	 *
	 * @param id the ID of this categoria
	 */
	@Override
	public void setId(long id) {
		_categoria.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_categoria.setNew(n);
	}

	/**
	 * Sets the primary key of this categoria.
	 *
	 * @param primaryKey the primary key of this categoria
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_categoria.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_categoria.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<allerta.catasto.model.Categoria> toCacheModel() {

		return _categoria.toCacheModel();
	}

	@Override
	public allerta.catasto.model.Categoria toEscapedModel() {
		return new CategoriaWrapper(_categoria.toEscapedModel());
	}

	@Override
	public String toString() {
		return _categoria.toString();
	}

	@Override
	public allerta.catasto.model.Categoria toUnescapedModel() {
		return new CategoriaWrapper(_categoria.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _categoria.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CategoriaWrapper)) {
			return false;
		}

		CategoriaWrapper categoriaWrapper = (CategoriaWrapper)obj;

		if (Objects.equals(_categoria, categoriaWrapper._categoria)) {
			return true;
		}

		return false;
	}

	@Override
	public Categoria getWrappedModel() {
		return _categoria;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _categoria.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _categoria.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_categoria.resetOriginalValues();
	}

	private final Categoria _categoria;

}