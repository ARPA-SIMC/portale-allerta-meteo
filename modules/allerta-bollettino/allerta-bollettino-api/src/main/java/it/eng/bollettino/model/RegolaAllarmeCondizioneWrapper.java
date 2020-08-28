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
 * This class is a wrapper for {@link RegolaAllarmeCondizione}.
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmeCondizione
 * @generated
 */
@ProviderType
public class RegolaAllarmeCondizioneWrapper
	implements RegolaAllarmeCondizione, ModelWrapper<RegolaAllarmeCondizione> {

	public RegolaAllarmeCondizioneWrapper(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		_regolaAllarmeCondizione = regolaAllarmeCondizione;
	}

	@Override
	public Class<?> getModelClass() {
		return RegolaAllarmeCondizione.class;
	}

	@Override
	public String getModelClassName() {
		return RegolaAllarmeCondizione.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("idRegola", getIdRegola());
		attributes.put("lettera", getLettera());
		attributes.put("idVariabile", getIdVariabile());
		attributes.put("idStazione", getIdStazione());
		attributes.put("idStazioneVariabile", getIdStazioneVariabile());
		attributes.put("soglia", getSoglia());
		attributes.put("valoreSoglia", getValoreSoglia());

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

		Long idRegola = (Long)attributes.get("idRegola");

		if (idRegola != null) {
			setIdRegola(idRegola);
		}

		String lettera = (String)attributes.get("lettera");

		if (lettera != null) {
			setLettera(lettera);
		}

		String idVariabile = (String)attributes.get("idVariabile");

		if (idVariabile != null) {
			setIdVariabile(idVariabile);
		}

		String idStazione = (String)attributes.get("idStazione");

		if (idStazione != null) {
			setIdStazione(idStazione);
		}

		Long idStazioneVariabile = (Long)attributes.get("idStazioneVariabile");

		if (idStazioneVariabile != null) {
			setIdStazioneVariabile(idStazioneVariabile);
		}

		Integer soglia = (Integer)attributes.get("soglia");

		if (soglia != null) {
			setSoglia(soglia);
		}

		Double valoreSoglia = (Double)attributes.get("valoreSoglia");

		if (valoreSoglia != null) {
			setValoreSoglia(valoreSoglia);
		}
	}

	@Override
	public Object clone() {
		return new RegolaAllarmeCondizioneWrapper(
			(RegolaAllarmeCondizione)_regolaAllarmeCondizione.clone());
	}

	@Override
	public int compareTo(
		it.eng.bollettino.model.RegolaAllarmeCondizione
			regolaAllarmeCondizione) {

		return _regolaAllarmeCondizione.compareTo(regolaAllarmeCondizione);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _regolaAllarmeCondizione.getExpandoBridge();
	}

	/**
	 * Returns the ID of this regola allarme condizione.
	 *
	 * @return the ID of this regola allarme condizione
	 */
	@Override
	public long getId() {
		return _regolaAllarmeCondizione.getId();
	}

	/**
	 * Returns the id regola of this regola allarme condizione.
	 *
	 * @return the id regola of this regola allarme condizione
	 */
	@Override
	public long getIdRegola() {
		return _regolaAllarmeCondizione.getIdRegola();
	}

	/**
	 * Returns the id stazione of this regola allarme condizione.
	 *
	 * @return the id stazione of this regola allarme condizione
	 */
	@Override
	public String getIdStazione() {
		return _regolaAllarmeCondizione.getIdStazione();
	}

	/**
	 * Returns the id stazione variabile of this regola allarme condizione.
	 *
	 * @return the id stazione variabile of this regola allarme condizione
	 */
	@Override
	public long getIdStazioneVariabile() {
		return _regolaAllarmeCondizione.getIdStazioneVariabile();
	}

	/**
	 * Returns the id variabile of this regola allarme condizione.
	 *
	 * @return the id variabile of this regola allarme condizione
	 */
	@Override
	public String getIdVariabile() {
		return _regolaAllarmeCondizione.getIdVariabile();
	}

	/**
	 * Returns the lettera of this regola allarme condizione.
	 *
	 * @return the lettera of this regola allarme condizione
	 */
	@Override
	public String getLettera() {
		return _regolaAllarmeCondizione.getLettera();
	}

	/**
	 * Returns the primary key of this regola allarme condizione.
	 *
	 * @return the primary key of this regola allarme condizione
	 */
	@Override
	public long getPrimaryKey() {
		return _regolaAllarmeCondizione.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _regolaAllarmeCondizione.getPrimaryKeyObj();
	}

	/**
	 * Returns the soglia of this regola allarme condizione.
	 *
	 * @return the soglia of this regola allarme condizione
	 */
	@Override
	public int getSoglia() {
		return _regolaAllarmeCondizione.getSoglia();
	}

	/**
	 * Returns the uuid of this regola allarme condizione.
	 *
	 * @return the uuid of this regola allarme condizione
	 */
	@Override
	public String getUuid() {
		return _regolaAllarmeCondizione.getUuid();
	}

	/**
	 * Returns the valore soglia of this regola allarme condizione.
	 *
	 * @return the valore soglia of this regola allarme condizione
	 */
	@Override
	public double getValoreSoglia() {
		return _regolaAllarmeCondizione.getValoreSoglia();
	}

	@Override
	public int hashCode() {
		return _regolaAllarmeCondizione.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _regolaAllarmeCondizione.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _regolaAllarmeCondizione.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _regolaAllarmeCondizione.isNew();
	}

	@Override
	public void persist() {
		_regolaAllarmeCondizione.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_regolaAllarmeCondizione.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_regolaAllarmeCondizione.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_regolaAllarmeCondizione.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_regolaAllarmeCondizione.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this regola allarme condizione.
	 *
	 * @param id the ID of this regola allarme condizione
	 */
	@Override
	public void setId(long id) {
		_regolaAllarmeCondizione.setId(id);
	}

	/**
	 * Sets the id regola of this regola allarme condizione.
	 *
	 * @param idRegola the id regola of this regola allarme condizione
	 */
	@Override
	public void setIdRegola(long idRegola) {
		_regolaAllarmeCondizione.setIdRegola(idRegola);
	}

	/**
	 * Sets the id stazione of this regola allarme condizione.
	 *
	 * @param idStazione the id stazione of this regola allarme condizione
	 */
	@Override
	public void setIdStazione(String idStazione) {
		_regolaAllarmeCondizione.setIdStazione(idStazione);
	}

	/**
	 * Sets the id stazione variabile of this regola allarme condizione.
	 *
	 * @param idStazioneVariabile the id stazione variabile of this regola allarme condizione
	 */
	@Override
	public void setIdStazioneVariabile(long idStazioneVariabile) {
		_regolaAllarmeCondizione.setIdStazioneVariabile(idStazioneVariabile);
	}

	/**
	 * Sets the id variabile of this regola allarme condizione.
	 *
	 * @param idVariabile the id variabile of this regola allarme condizione
	 */
	@Override
	public void setIdVariabile(String idVariabile) {
		_regolaAllarmeCondizione.setIdVariabile(idVariabile);
	}

	/**
	 * Sets the lettera of this regola allarme condizione.
	 *
	 * @param lettera the lettera of this regola allarme condizione
	 */
	@Override
	public void setLettera(String lettera) {
		_regolaAllarmeCondizione.setLettera(lettera);
	}

	@Override
	public void setNew(boolean n) {
		_regolaAllarmeCondizione.setNew(n);
	}

	/**
	 * Sets the primary key of this regola allarme condizione.
	 *
	 * @param primaryKey the primary key of this regola allarme condizione
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_regolaAllarmeCondizione.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_regolaAllarmeCondizione.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the soglia of this regola allarme condizione.
	 *
	 * @param soglia the soglia of this regola allarme condizione
	 */
	@Override
	public void setSoglia(int soglia) {
		_regolaAllarmeCondizione.setSoglia(soglia);
	}

	/**
	 * Sets the uuid of this regola allarme condizione.
	 *
	 * @param uuid the uuid of this regola allarme condizione
	 */
	@Override
	public void setUuid(String uuid) {
		_regolaAllarmeCondizione.setUuid(uuid);
	}

	/**
	 * Sets the valore soglia of this regola allarme condizione.
	 *
	 * @param valoreSoglia the valore soglia of this regola allarme condizione
	 */
	@Override
	public void setValoreSoglia(double valoreSoglia) {
		_regolaAllarmeCondizione.setValoreSoglia(valoreSoglia);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.RegolaAllarmeCondizione> toCacheModel() {

		return _regolaAllarmeCondizione.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.RegolaAllarmeCondizione toEscapedModel() {
		return new RegolaAllarmeCondizioneWrapper(
			_regolaAllarmeCondizione.toEscapedModel());
	}

	@Override
	public String toString() {
		return _regolaAllarmeCondizione.toString();
	}

	@Override
	public it.eng.bollettino.model.RegolaAllarmeCondizione toUnescapedModel() {
		return new RegolaAllarmeCondizioneWrapper(
			_regolaAllarmeCondizione.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _regolaAllarmeCondizione.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RegolaAllarmeCondizioneWrapper)) {
			return false;
		}

		RegolaAllarmeCondizioneWrapper regolaAllarmeCondizioneWrapper =
			(RegolaAllarmeCondizioneWrapper)obj;

		if (Objects.equals(
				_regolaAllarmeCondizione,
				regolaAllarmeCondizioneWrapper._regolaAllarmeCondizione)) {

			return true;
		}

		return false;
	}

	@Override
	public RegolaAllarmeCondizione getWrappedModel() {
		return _regolaAllarmeCondizione;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _regolaAllarmeCondizione.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _regolaAllarmeCondizione.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_regolaAllarmeCondizione.resetOriginalValues();
	}

	private final RegolaAllarmeCondizione _regolaAllarmeCondizione;

}