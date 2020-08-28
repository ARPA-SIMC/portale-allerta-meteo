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
 * This class is a wrapper for {@link RegolaAllarme}.
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarme
 * @generated
 */
@ProviderType
public class RegolaAllarmeWrapper
	implements RegolaAllarme, ModelWrapper<RegolaAllarme> {

	public RegolaAllarmeWrapper(RegolaAllarme regolaAllarme) {
		_regolaAllarme = regolaAllarme;
	}

	@Override
	public Class<?> getModelClass() {
		return RegolaAllarme.class;
	}

	@Override
	public String getModelClassName() {
		return RegolaAllarme.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("espressione", getEspressione());
		attributes.put("descrizione", getDescrizione());
		attributes.put("colore", getColore());
		attributes.put("attivo", isAttivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String espressione = (String)attributes.get("espressione");

		if (espressione != null) {
			setEspressione(espressione);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		Integer colore = (Integer)attributes.get("colore");

		if (colore != null) {
			setColore(colore);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
		}
	}

	@Override
	public Object clone() {
		return new RegolaAllarmeWrapper((RegolaAllarme)_regolaAllarme.clone());
	}

	@Override
	public int compareTo(it.eng.bollettino.model.RegolaAllarme regolaAllarme) {
		return _regolaAllarme.compareTo(regolaAllarme);
	}

	/**
	 * Returns the attivo of this regola allarme.
	 *
	 * @return the attivo of this regola allarme
	 */
	@Override
	public boolean getAttivo() {
		return _regolaAllarme.getAttivo();
	}

	/**
	 * Returns the colore of this regola allarme.
	 *
	 * @return the colore of this regola allarme
	 */
	@Override
	public int getColore() {
		return _regolaAllarme.getColore();
	}

	/**
	 * Returns the descrizione of this regola allarme.
	 *
	 * @return the descrizione of this regola allarme
	 */
	@Override
	public String getDescrizione() {
		return _regolaAllarme.getDescrizione();
	}

	/**
	 * Returns the espressione of this regola allarme.
	 *
	 * @return the espressione of this regola allarme
	 */
	@Override
	public String getEspressione() {
		return _regolaAllarme.getEspressione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _regolaAllarme.getExpandoBridge();
	}

	/**
	 * Returns the ID of this regola allarme.
	 *
	 * @return the ID of this regola allarme
	 */
	@Override
	public long getId() {
		return _regolaAllarme.getId();
	}

	/**
	 * Returns the nome of this regola allarme.
	 *
	 * @return the nome of this regola allarme
	 */
	@Override
	public String getNome() {
		return _regolaAllarme.getNome();
	}

	/**
	 * Returns the primary key of this regola allarme.
	 *
	 * @return the primary key of this regola allarme
	 */
	@Override
	public long getPrimaryKey() {
		return _regolaAllarme.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _regolaAllarme.getPrimaryKeyObj();
	}

	/**
	 * Returns the uuid of this regola allarme.
	 *
	 * @return the uuid of this regola allarme
	 */
	@Override
	public String getUuid() {
		return _regolaAllarme.getUuid();
	}

	@Override
	public int hashCode() {
		return _regolaAllarme.hashCode();
	}

	/**
	 * Returns <code>true</code> if this regola allarme is attivo.
	 *
	 * @return <code>true</code> if this regola allarme is attivo; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttivo() {
		return _regolaAllarme.isAttivo();
	}

	@Override
	public boolean isCachedModel() {
		return _regolaAllarme.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _regolaAllarme.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _regolaAllarme.isNew();
	}

	@Override
	public void persist() {
		_regolaAllarme.persist();
	}

	/**
	 * Sets whether this regola allarme is attivo.
	 *
	 * @param attivo the attivo of this regola allarme
	 */
	@Override
	public void setAttivo(boolean attivo) {
		_regolaAllarme.setAttivo(attivo);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_regolaAllarme.setCachedModel(cachedModel);
	}

	/**
	 * Sets the colore of this regola allarme.
	 *
	 * @param colore the colore of this regola allarme
	 */
	@Override
	public void setColore(int colore) {
		_regolaAllarme.setColore(colore);
	}

	/**
	 * Sets the descrizione of this regola allarme.
	 *
	 * @param descrizione the descrizione of this regola allarme
	 */
	@Override
	public void setDescrizione(String descrizione) {
		_regolaAllarme.setDescrizione(descrizione);
	}

	/**
	 * Sets the espressione of this regola allarme.
	 *
	 * @param espressione the espressione of this regola allarme
	 */
	@Override
	public void setEspressione(String espressione) {
		_regolaAllarme.setEspressione(espressione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_regolaAllarme.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_regolaAllarme.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_regolaAllarme.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this regola allarme.
	 *
	 * @param id the ID of this regola allarme
	 */
	@Override
	public void setId(long id) {
		_regolaAllarme.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_regolaAllarme.setNew(n);
	}

	/**
	 * Sets the nome of this regola allarme.
	 *
	 * @param nome the nome of this regola allarme
	 */
	@Override
	public void setNome(String nome) {
		_regolaAllarme.setNome(nome);
	}

	/**
	 * Sets the primary key of this regola allarme.
	 *
	 * @param primaryKey the primary key of this regola allarme
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_regolaAllarme.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_regolaAllarme.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the uuid of this regola allarme.
	 *
	 * @param uuid the uuid of this regola allarme
	 */
	@Override
	public void setUuid(String uuid) {
		_regolaAllarme.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.RegolaAllarme> toCacheModel() {

		return _regolaAllarme.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.RegolaAllarme toEscapedModel() {
		return new RegolaAllarmeWrapper(_regolaAllarme.toEscapedModel());
	}

	@Override
	public String toString() {
		return _regolaAllarme.toString();
	}

	@Override
	public it.eng.bollettino.model.RegolaAllarme toUnescapedModel() {
		return new RegolaAllarmeWrapper(_regolaAllarme.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _regolaAllarme.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegolaAllarmeWrapper)) {
			return false;
		}

		RegolaAllarmeWrapper regolaAllarmeWrapper = (RegolaAllarmeWrapper)obj;

		if (Objects.equals(
				_regolaAllarme, regolaAllarmeWrapper._regolaAllarme)) {

			return true;
		}

		return false;
	}

	@Override
	public RegolaAllarme getWrappedModel() {
		return _regolaAllarme;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _regolaAllarme.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _regolaAllarme.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_regolaAllarme.resetOriginalValues();
	}

	private final RegolaAllarme _regolaAllarme;

}