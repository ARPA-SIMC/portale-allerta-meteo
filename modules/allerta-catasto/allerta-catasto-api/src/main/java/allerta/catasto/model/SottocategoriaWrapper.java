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
 * This class is a wrapper for {@link Sottocategoria}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Sottocategoria
 * @generated
 */
@ProviderType
public class SottocategoriaWrapper
	implements Sottocategoria, ModelWrapper<Sottocategoria> {

	public SottocategoriaWrapper(Sottocategoria sottocategoria) {
		_sottocategoria = sottocategoria;
	}

	@Override
	public Class<?> getModelClass() {
		return Sottocategoria.class;
	}

	@Override
	public String getModelClassName() {
		return Sottocategoria.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("idCategoria", getIdCategoria());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long idCategoria = (Long)attributes.get("idCategoria");

		if (idCategoria != null) {
			setIdCategoria(idCategoria);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public Object clone() {
		return new SottocategoriaWrapper(
			(Sottocategoria)_sottocategoria.clone());
	}

	@Override
	public int compareTo(allerta.catasto.model.Sottocategoria sottocategoria) {
		return _sottocategoria.compareTo(sottocategoria);
	}

	/**
	 * Returns the descrizione of this sottocategoria.
	 *
	 * @return the descrizione of this sottocategoria
	 */
	@Override
	public String getDescrizione() {
		return _sottocategoria.getDescrizione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _sottocategoria.getExpandoBridge();
	}

	/**
	 * Returns the ID of this sottocategoria.
	 *
	 * @return the ID of this sottocategoria
	 */
	@Override
	public long getId() {
		return _sottocategoria.getId();
	}

	/**
	 * Returns the id categoria of this sottocategoria.
	 *
	 * @return the id categoria of this sottocategoria
	 */
	@Override
	public long getIdCategoria() {
		return _sottocategoria.getIdCategoria();
	}

	/**
	 * Returns the primary key of this sottocategoria.
	 *
	 * @return the primary key of this sottocategoria
	 */
	@Override
	public allerta.catasto.service.persistence.SottocategoriaPK
		getPrimaryKey() {

		return _sottocategoria.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sottocategoria.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _sottocategoria.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _sottocategoria.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _sottocategoria.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _sottocategoria.isNew();
	}

	@Override
	public void persist() {
		_sottocategoria.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sottocategoria.setCachedModel(cachedModel);
	}

	/**
	 * Sets the descrizione of this sottocategoria.
	 *
	 * @param descrizione the descrizione of this sottocategoria
	 */
	@Override
	public void setDescrizione(String descrizione) {
		_sottocategoria.setDescrizione(descrizione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_sottocategoria.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_sottocategoria.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_sottocategoria.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this sottocategoria.
	 *
	 * @param id the ID of this sottocategoria
	 */
	@Override
	public void setId(long id) {
		_sottocategoria.setId(id);
	}

	/**
	 * Sets the id categoria of this sottocategoria.
	 *
	 * @param idCategoria the id categoria of this sottocategoria
	 */
	@Override
	public void setIdCategoria(long idCategoria) {
		_sottocategoria.setIdCategoria(idCategoria);
	}

	@Override
	public void setNew(boolean n) {
		_sottocategoria.setNew(n);
	}

	/**
	 * Sets the primary key of this sottocategoria.
	 *
	 * @param primaryKey the primary key of this sottocategoria
	 */
	@Override
	public void setPrimaryKey(
		allerta.catasto.service.persistence.SottocategoriaPK primaryKey) {

		_sottocategoria.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_sottocategoria.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<allerta.catasto.model.Sottocategoria> toCacheModel() {

		return _sottocategoria.toCacheModel();
	}

	@Override
	public allerta.catasto.model.Sottocategoria toEscapedModel() {
		return new SottocategoriaWrapper(_sottocategoria.toEscapedModel());
	}

	@Override
	public String toString() {
		return _sottocategoria.toString();
	}

	@Override
	public allerta.catasto.model.Sottocategoria toUnescapedModel() {
		return new SottocategoriaWrapper(_sottocategoria.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _sottocategoria.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SottocategoriaWrapper)) {
			return false;
		}

		SottocategoriaWrapper sottocategoriaWrapper =
			(SottocategoriaWrapper)obj;

		if (Objects.equals(
				_sottocategoria, sottocategoriaWrapper._sottocategoria)) {

			return true;
		}

		return false;
	}

	@Override
	public Sottocategoria getWrappedModel() {
		return _sottocategoria;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _sottocategoria.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _sottocategoria.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_sottocategoria.resetOriginalValues();
	}

	private final Sottocategoria _sottocategoria;

}