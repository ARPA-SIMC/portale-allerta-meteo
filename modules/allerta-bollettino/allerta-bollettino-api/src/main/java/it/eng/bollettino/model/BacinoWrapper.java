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

package it.eng.bollettino.model;

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
 * This class is a wrapper for {@link Bacino}.
 * </p>
 *
 * @author GFAVINI
 * @see Bacino
 * @generated
 */
@ProviderType
public class BacinoWrapper implements Bacino, ModelWrapper<Bacino> {

	public BacinoWrapper(Bacino bacino) {
		_bacino = bacino;
	}

	@Override
	public Class<?> getModelClass() {
		return Bacino.class;
	}

	@Override
	public String getModelClassName() {
		return Bacino.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("progressivo", getProgressivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}
	}

	@Override
	public Object clone() {
		return new BacinoWrapper((Bacino)_bacino.clone());
	}

	@Override
	public int compareTo(it.eng.bollettino.model.Bacino bacino) {
		return _bacino.compareTo(bacino);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bacino.getExpandoBridge();
	}

	/**
	 * Returns the ID of this bacino.
	 *
	 * @return the ID of this bacino
	 */
	@Override
	public String getId() {
		return _bacino.getId();
	}

	/**
	 * Returns the nome of this bacino.
	 *
	 * @return the nome of this bacino
	 */
	@Override
	public String getNome() {
		return _bacino.getNome();
	}

	/**
	 * Returns the primary key of this bacino.
	 *
	 * @return the primary key of this bacino
	 */
	@Override
	public String getPrimaryKey() {
		return _bacino.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bacino.getPrimaryKeyObj();
	}

	/**
	 * Returns the progressivo of this bacino.
	 *
	 * @return the progressivo of this bacino
	 */
	@Override
	public int getProgressivo() {
		return _bacino.getProgressivo();
	}

	/**
	 * Returns the uuid of this bacino.
	 *
	 * @return the uuid of this bacino
	 */
	@Override
	public String getUuid() {
		return _bacino.getUuid();
	}

	@Override
	public int hashCode() {
		return _bacino.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _bacino.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bacino.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bacino.isNew();
	}

	@Override
	public void persist() {
		_bacino.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bacino.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_bacino.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bacino.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bacino.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this bacino.
	 *
	 * @param id the ID of this bacino
	 */
	@Override
	public void setId(String id) {
		_bacino.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_bacino.setNew(n);
	}

	/**
	 * Sets the nome of this bacino.
	 *
	 * @param nome the nome of this bacino
	 */
	@Override
	public void setNome(String nome) {
		_bacino.setNome(nome);
	}

	/**
	 * Sets the primary key of this bacino.
	 *
	 * @param primaryKey the primary key of this bacino
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_bacino.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bacino.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the progressivo of this bacino.
	 *
	 * @param progressivo the progressivo of this bacino
	 */
	@Override
	public void setProgressivo(int progressivo) {
		_bacino.setProgressivo(progressivo);
	}

	/**
	 * Sets the uuid of this bacino.
	 *
	 * @param uuid the uuid of this bacino
	 */
	@Override
	public void setUuid(String uuid) {
		_bacino.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.Bacino> toCacheModel() {

		return _bacino.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.Bacino toEscapedModel() {
		return new BacinoWrapper(_bacino.toEscapedModel());
	}

	@Override
	public String toString() {
		return _bacino.toString();
	}

	@Override
	public it.eng.bollettino.model.Bacino toUnescapedModel() {
		return new BacinoWrapper(_bacino.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _bacino.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BacinoWrapper)) {
			return false;
		}

		BacinoWrapper bacinoWrapper = (BacinoWrapper)obj;

		if (Objects.equals(_bacino, bacinoWrapper._bacino)) {
			return true;
		}

		return false;
	}

	@Override
	public Bacino getWrappedModel() {
		return _bacino;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bacino.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bacino.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bacino.resetOriginalValues();
	}

	private final Bacino _bacino;

}