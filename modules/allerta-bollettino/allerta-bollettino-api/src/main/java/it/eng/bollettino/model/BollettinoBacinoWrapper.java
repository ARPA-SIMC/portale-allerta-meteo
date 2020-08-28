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
 * This class is a wrapper for {@link BollettinoBacino}.
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoBacino
 * @generated
 */
@ProviderType
public class BollettinoBacinoWrapper
	implements BollettinoBacino, ModelWrapper<BollettinoBacino> {

	public BollettinoBacinoWrapper(BollettinoBacino bollettinoBacino) {
		_bollettinoBacino = bollettinoBacino;
	}

	@Override
	public Class<?> getModelClass() {
		return BollettinoBacino.class;
	}

	@Override
	public String getModelClassName() {
		return BollettinoBacino.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("idBollettino", getIdBollettino());
		attributes.put("progressivo", getProgressivo());
		attributes.put("idBacino", getIdBacino());
		attributes.put("nomeBacino", getNomeBacino());
		attributes.put("oreOsservazione", getOreOsservazione());
		attributes.put("note", getNote());

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

		Long idBollettino = (Long)attributes.get("idBollettino");

		if (idBollettino != null) {
			setIdBollettino(idBollettino);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}

		String idBacino = (String)attributes.get("idBacino");

		if (idBacino != null) {
			setIdBacino(idBacino);
		}

		String nomeBacino = (String)attributes.get("nomeBacino");

		if (nomeBacino != null) {
			setNomeBacino(nomeBacino);
		}

		String oreOsservazione = (String)attributes.get("oreOsservazione");

		if (oreOsservazione != null) {
			setOreOsservazione(oreOsservazione);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@Override
	public Object clone() {
		return new BollettinoBacinoWrapper(
			(BollettinoBacino)_bollettinoBacino.clone());
	}

	@Override
	public int compareTo(
		it.eng.bollettino.model.BollettinoBacino bollettinoBacino) {

		return _bollettinoBacino.compareTo(bollettinoBacino);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bollettinoBacino.getExpandoBridge();
	}

	/**
	 * Returns the ID of this bollettino bacino.
	 *
	 * @return the ID of this bollettino bacino
	 */
	@Override
	public long getId() {
		return _bollettinoBacino.getId();
	}

	/**
	 * Returns the id bacino of this bollettino bacino.
	 *
	 * @return the id bacino of this bollettino bacino
	 */
	@Override
	public String getIdBacino() {
		return _bollettinoBacino.getIdBacino();
	}

	/**
	 * Returns the id bollettino of this bollettino bacino.
	 *
	 * @return the id bollettino of this bollettino bacino
	 */
	@Override
	public long getIdBollettino() {
		return _bollettinoBacino.getIdBollettino();
	}

	/**
	 * Returns the nome bacino of this bollettino bacino.
	 *
	 * @return the nome bacino of this bollettino bacino
	 */
	@Override
	public String getNomeBacino() {
		return _bollettinoBacino.getNomeBacino();
	}

	/**
	 * Returns the note of this bollettino bacino.
	 *
	 * @return the note of this bollettino bacino
	 */
	@Override
	public String getNote() {
		return _bollettinoBacino.getNote();
	}

	/**
	 * Returns the ore osservazione of this bollettino bacino.
	 *
	 * @return the ore osservazione of this bollettino bacino
	 */
	@Override
	public String getOreOsservazione() {
		return _bollettinoBacino.getOreOsservazione();
	}

	/**
	 * Returns the primary key of this bollettino bacino.
	 *
	 * @return the primary key of this bollettino bacino
	 */
	@Override
	public long getPrimaryKey() {
		return _bollettinoBacino.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bollettinoBacino.getPrimaryKeyObj();
	}

	/**
	 * Returns the progressivo of this bollettino bacino.
	 *
	 * @return the progressivo of this bollettino bacino
	 */
	@Override
	public int getProgressivo() {
		return _bollettinoBacino.getProgressivo();
	}

	/**
	 * Returns the uuid of this bollettino bacino.
	 *
	 * @return the uuid of this bollettino bacino
	 */
	@Override
	public String getUuid() {
		return _bollettinoBacino.getUuid();
	}

	@Override
	public int hashCode() {
		return _bollettinoBacino.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _bollettinoBacino.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bollettinoBacino.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bollettinoBacino.isNew();
	}

	@Override
	public void persist() {
		_bollettinoBacino.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bollettinoBacino.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_bollettinoBacino.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bollettinoBacino.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bollettinoBacino.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this bollettino bacino.
	 *
	 * @param id the ID of this bollettino bacino
	 */
	@Override
	public void setId(long id) {
		_bollettinoBacino.setId(id);
	}

	/**
	 * Sets the id bacino of this bollettino bacino.
	 *
	 * @param idBacino the id bacino of this bollettino bacino
	 */
	@Override
	public void setIdBacino(String idBacino) {
		_bollettinoBacino.setIdBacino(idBacino);
	}

	/**
	 * Sets the id bollettino of this bollettino bacino.
	 *
	 * @param idBollettino the id bollettino of this bollettino bacino
	 */
	@Override
	public void setIdBollettino(long idBollettino) {
		_bollettinoBacino.setIdBollettino(idBollettino);
	}

	@Override
	public void setNew(boolean n) {
		_bollettinoBacino.setNew(n);
	}

	/**
	 * Sets the nome bacino of this bollettino bacino.
	 *
	 * @param nomeBacino the nome bacino of this bollettino bacino
	 */
	@Override
	public void setNomeBacino(String nomeBacino) {
		_bollettinoBacino.setNomeBacino(nomeBacino);
	}

	/**
	 * Sets the note of this bollettino bacino.
	 *
	 * @param note the note of this bollettino bacino
	 */
	@Override
	public void setNote(String note) {
		_bollettinoBacino.setNote(note);
	}

	/**
	 * Sets the ore osservazione of this bollettino bacino.
	 *
	 * @param oreOsservazione the ore osservazione of this bollettino bacino
	 */
	@Override
	public void setOreOsservazione(String oreOsservazione) {
		_bollettinoBacino.setOreOsservazione(oreOsservazione);
	}

	/**
	 * Sets the primary key of this bollettino bacino.
	 *
	 * @param primaryKey the primary key of this bollettino bacino
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bollettinoBacino.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bollettinoBacino.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the progressivo of this bollettino bacino.
	 *
	 * @param progressivo the progressivo of this bollettino bacino
	 */
	@Override
	public void setProgressivo(int progressivo) {
		_bollettinoBacino.setProgressivo(progressivo);
	}

	/**
	 * Sets the uuid of this bollettino bacino.
	 *
	 * @param uuid the uuid of this bollettino bacino
	 */
	@Override
	public void setUuid(String uuid) {
		_bollettinoBacino.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.BollettinoBacino> toCacheModel() {

		return _bollettinoBacino.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.BollettinoBacino toEscapedModel() {
		return new BollettinoBacinoWrapper(_bollettinoBacino.toEscapedModel());
	}

	@Override
	public String toString() {
		return _bollettinoBacino.toString();
	}

	@Override
	public it.eng.bollettino.model.BollettinoBacino toUnescapedModel() {
		return new BollettinoBacinoWrapper(
			_bollettinoBacino.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _bollettinoBacino.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BollettinoBacinoWrapper)) {
			return false;
		}

		BollettinoBacinoWrapper bollettinoBacinoWrapper =
			(BollettinoBacinoWrapper)obj;

		if (Objects.equals(
				_bollettinoBacino, bollettinoBacinoWrapper._bollettinoBacino)) {

			return true;
		}

		return false;
	}

	@Override
	public BollettinoBacino getWrappedModel() {
		return _bollettinoBacino;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bollettinoBacino.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bollettinoBacino.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bollettinoBacino.resetOriginalValues();
	}

	private final BollettinoBacino _bollettinoBacino;

}