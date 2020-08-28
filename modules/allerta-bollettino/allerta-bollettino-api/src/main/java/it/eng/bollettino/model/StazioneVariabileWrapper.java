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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link StazioneVariabile}.
 * </p>
 *
 * @author GFAVINI
 * @see StazioneVariabile
 * @generated
 */
@ProviderType
public class StazioneVariabileWrapper
	implements StazioneVariabile, ModelWrapper<StazioneVariabile> {

	public StazioneVariabileWrapper(StazioneVariabile stazioneVariabile) {
		_stazioneVariabile = stazioneVariabile;
	}

	@Override
	public Class<?> getModelClass() {
		return StazioneVariabile.class;
	}

	@Override
	public String getModelClassName() {
		return StazioneVariabile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("idStazione", getIdStazione());
		attributes.put("idVariabile", getIdVariabile());
		attributes.put("dataUltimoValore", getDataUltimoValore());
		attributes.put("soglia1", getSoglia1());
		attributes.put("soglia2", getSoglia2());
		attributes.put("soglia3", getSoglia3());

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

		String idStazione = (String)attributes.get("idStazione");

		if (idStazione != null) {
			setIdStazione(idStazione);
		}

		String idVariabile = (String)attributes.get("idVariabile");

		if (idVariabile != null) {
			setIdVariabile(idVariabile);
		}

		Date dataUltimoValore = (Date)attributes.get("dataUltimoValore");

		if (dataUltimoValore != null) {
			setDataUltimoValore(dataUltimoValore);
		}

		Double soglia1 = (Double)attributes.get("soglia1");

		if (soglia1 != null) {
			setSoglia1(soglia1);
		}

		Double soglia2 = (Double)attributes.get("soglia2");

		if (soglia2 != null) {
			setSoglia2(soglia2);
		}

		Double soglia3 = (Double)attributes.get("soglia3");

		if (soglia3 != null) {
			setSoglia3(soglia3);
		}
	}

	@Override
	public Object clone() {
		return new StazioneVariabileWrapper(
			(StazioneVariabile)_stazioneVariabile.clone());
	}

	@Override
	public int compareTo(
		it.eng.bollettino.model.StazioneVariabile stazioneVariabile) {

		return _stazioneVariabile.compareTo(stazioneVariabile);
	}

	/**
	 * Returns the data ultimo valore of this stazione variabile.
	 *
	 * @return the data ultimo valore of this stazione variabile
	 */
	@Override
	public Date getDataUltimoValore() {
		return _stazioneVariabile.getDataUltimoValore();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _stazioneVariabile.getExpandoBridge();
	}

	/**
	 * Returns the ID of this stazione variabile.
	 *
	 * @return the ID of this stazione variabile
	 */
	@Override
	public long getId() {
		return _stazioneVariabile.getId();
	}

	/**
	 * Returns the id stazione of this stazione variabile.
	 *
	 * @return the id stazione of this stazione variabile
	 */
	@Override
	public String getIdStazione() {
		return _stazioneVariabile.getIdStazione();
	}

	/**
	 * Returns the id variabile of this stazione variabile.
	 *
	 * @return the id variabile of this stazione variabile
	 */
	@Override
	public String getIdVariabile() {
		return _stazioneVariabile.getIdVariabile();
	}

	/**
	 * Returns the primary key of this stazione variabile.
	 *
	 * @return the primary key of this stazione variabile
	 */
	@Override
	public long getPrimaryKey() {
		return _stazioneVariabile.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stazioneVariabile.getPrimaryKeyObj();
	}

	/**
	 * Returns the soglia1 of this stazione variabile.
	 *
	 * @return the soglia1 of this stazione variabile
	 */
	@Override
	public double getSoglia1() {
		return _stazioneVariabile.getSoglia1();
	}

	/**
	 * Returns the soglia2 of this stazione variabile.
	 *
	 * @return the soglia2 of this stazione variabile
	 */
	@Override
	public double getSoglia2() {
		return _stazioneVariabile.getSoglia2();
	}

	/**
	 * Returns the soglia3 of this stazione variabile.
	 *
	 * @return the soglia3 of this stazione variabile
	 */
	@Override
	public double getSoglia3() {
		return _stazioneVariabile.getSoglia3();
	}

	/**
	 * Returns the uuid of this stazione variabile.
	 *
	 * @return the uuid of this stazione variabile
	 */
	@Override
	public String getUuid() {
		return _stazioneVariabile.getUuid();
	}

	@Override
	public int hashCode() {
		return _stazioneVariabile.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _stazioneVariabile.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _stazioneVariabile.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _stazioneVariabile.isNew();
	}

	@Override
	public void persist() {
		_stazioneVariabile.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_stazioneVariabile.setCachedModel(cachedModel);
	}

	/**
	 * Sets the data ultimo valore of this stazione variabile.
	 *
	 * @param dataUltimoValore the data ultimo valore of this stazione variabile
	 */
	@Override
	public void setDataUltimoValore(Date dataUltimoValore) {
		_stazioneVariabile.setDataUltimoValore(dataUltimoValore);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_stazioneVariabile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_stazioneVariabile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_stazioneVariabile.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this stazione variabile.
	 *
	 * @param id the ID of this stazione variabile
	 */
	@Override
	public void setId(long id) {
		_stazioneVariabile.setId(id);
	}

	/**
	 * Sets the id stazione of this stazione variabile.
	 *
	 * @param idStazione the id stazione of this stazione variabile
	 */
	@Override
	public void setIdStazione(String idStazione) {
		_stazioneVariabile.setIdStazione(idStazione);
	}

	/**
	 * Sets the id variabile of this stazione variabile.
	 *
	 * @param idVariabile the id variabile of this stazione variabile
	 */
	@Override
	public void setIdVariabile(String idVariabile) {
		_stazioneVariabile.setIdVariabile(idVariabile);
	}

	@Override
	public void setNew(boolean n) {
		_stazioneVariabile.setNew(n);
	}

	/**
	 * Sets the primary key of this stazione variabile.
	 *
	 * @param primaryKey the primary key of this stazione variabile
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_stazioneVariabile.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_stazioneVariabile.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the soglia1 of this stazione variabile.
	 *
	 * @param soglia1 the soglia1 of this stazione variabile
	 */
	@Override
	public void setSoglia1(double soglia1) {
		_stazioneVariabile.setSoglia1(soglia1);
	}

	/**
	 * Sets the soglia2 of this stazione variabile.
	 *
	 * @param soglia2 the soglia2 of this stazione variabile
	 */
	@Override
	public void setSoglia2(double soglia2) {
		_stazioneVariabile.setSoglia2(soglia2);
	}

	/**
	 * Sets the soglia3 of this stazione variabile.
	 *
	 * @param soglia3 the soglia3 of this stazione variabile
	 */
	@Override
	public void setSoglia3(double soglia3) {
		_stazioneVariabile.setSoglia3(soglia3);
	}

	/**
	 * Sets the uuid of this stazione variabile.
	 *
	 * @param uuid the uuid of this stazione variabile
	 */
	@Override
	public void setUuid(String uuid) {
		_stazioneVariabile.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.StazioneVariabile> toCacheModel() {

		return _stazioneVariabile.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.StazioneVariabile toEscapedModel() {
		return new StazioneVariabileWrapper(
			_stazioneVariabile.toEscapedModel());
	}

	@Override
	public String toString() {
		return _stazioneVariabile.toString();
	}

	@Override
	public it.eng.bollettino.model.StazioneVariabile toUnescapedModel() {
		return new StazioneVariabileWrapper(
			_stazioneVariabile.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _stazioneVariabile.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StazioneVariabileWrapper)) {
			return false;
		}

		StazioneVariabileWrapper stazioneVariabileWrapper =
			(StazioneVariabileWrapper)obj;

		if (Objects.equals(
				_stazioneVariabile,
				stazioneVariabileWrapper._stazioneVariabile)) {

			return true;
		}

		return false;
	}

	@Override
	public StazioneVariabile getWrappedModel() {
		return _stazioneVariabile;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _stazioneVariabile.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _stazioneVariabile.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_stazioneVariabile.resetOriginalValues();
	}

	private final StazioneVariabile _stazioneVariabile;

}