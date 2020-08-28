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
 * This class is a wrapper for {@link Idrometro}.
 * </p>
 *
 * @author GFAVINI
 * @see Idrometro
 * @generated
 */
@ProviderType
public class IdrometroWrapper implements Idrometro, ModelWrapper<Idrometro> {

	public IdrometroWrapper(Idrometro idrometro) {
		_idrometro = idrometro;
	}

	@Override
	public Class<?> getModelClass() {
		return Idrometro.class;
	}

	@Override
	public String getModelClassName() {
		return Idrometro.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stazioneId", getStazioneId());
		attributes.put("nomeBacino", getNomeBacino());
		attributes.put("nomeSottobacino", getNomeSottobacino());
		attributes.put("nomeRubrica", getNomeRubrica());
		attributes.put("sogliaSpike", getSogliaSpike());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String stazioneId = (String)attributes.get("stazioneId");

		if (stazioneId != null) {
			setStazioneId(stazioneId);
		}

		String nomeBacino = (String)attributes.get("nomeBacino");

		if (nomeBacino != null) {
			setNomeBacino(nomeBacino);
		}

		String nomeSottobacino = (String)attributes.get("nomeSottobacino");

		if (nomeSottobacino != null) {
			setNomeSottobacino(nomeSottobacino);
		}

		String nomeRubrica = (String)attributes.get("nomeRubrica");

		if (nomeRubrica != null) {
			setNomeRubrica(nomeRubrica);
		}

		Double sogliaSpike = (Double)attributes.get("sogliaSpike");

		if (sogliaSpike != null) {
			setSogliaSpike(sogliaSpike);
		}
	}

	@Override
	public Object clone() {
		return new IdrometroWrapper((Idrometro)_idrometro.clone());
	}

	@Override
	public int compareTo(it.eng.bollettino.model.Idrometro idrometro) {
		return _idrometro.compareTo(idrometro);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _idrometro.getExpandoBridge();
	}

	/**
	 * Returns the nome bacino of this idrometro.
	 *
	 * @return the nome bacino of this idrometro
	 */
	@Override
	public String getNomeBacino() {
		return _idrometro.getNomeBacino();
	}

	/**
	 * Returns the nome rubrica of this idrometro.
	 *
	 * @return the nome rubrica of this idrometro
	 */
	@Override
	public String getNomeRubrica() {
		return _idrometro.getNomeRubrica();
	}

	/**
	 * Returns the nome sottobacino of this idrometro.
	 *
	 * @return the nome sottobacino of this idrometro
	 */
	@Override
	public String getNomeSottobacino() {
		return _idrometro.getNomeSottobacino();
	}

	/**
	 * Returns the primary key of this idrometro.
	 *
	 * @return the primary key of this idrometro
	 */
	@Override
	public String getPrimaryKey() {
		return _idrometro.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idrometro.getPrimaryKeyObj();
	}

	/**
	 * Returns the soglia spike of this idrometro.
	 *
	 * @return the soglia spike of this idrometro
	 */
	@Override
	public double getSogliaSpike() {
		return _idrometro.getSogliaSpike();
	}

	/**
	 * Returns the stazione ID of this idrometro.
	 *
	 * @return the stazione ID of this idrometro
	 */
	@Override
	public String getStazioneId() {
		return _idrometro.getStazioneId();
	}

	@Override
	public int hashCode() {
		return _idrometro.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _idrometro.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _idrometro.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _idrometro.isNew();
	}

	@Override
	public void persist() {
		_idrometro.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_idrometro.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_idrometro.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_idrometro.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_idrometro.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_idrometro.setNew(n);
	}

	/**
	 * Sets the nome bacino of this idrometro.
	 *
	 * @param nomeBacino the nome bacino of this idrometro
	 */
	@Override
	public void setNomeBacino(String nomeBacino) {
		_idrometro.setNomeBacino(nomeBacino);
	}

	/**
	 * Sets the nome rubrica of this idrometro.
	 *
	 * @param nomeRubrica the nome rubrica of this idrometro
	 */
	@Override
	public void setNomeRubrica(String nomeRubrica) {
		_idrometro.setNomeRubrica(nomeRubrica);
	}

	/**
	 * Sets the nome sottobacino of this idrometro.
	 *
	 * @param nomeSottobacino the nome sottobacino of this idrometro
	 */
	@Override
	public void setNomeSottobacino(String nomeSottobacino) {
		_idrometro.setNomeSottobacino(nomeSottobacino);
	}

	/**
	 * Sets the primary key of this idrometro.
	 *
	 * @param primaryKey the primary key of this idrometro
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_idrometro.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_idrometro.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the soglia spike of this idrometro.
	 *
	 * @param sogliaSpike the soglia spike of this idrometro
	 */
	@Override
	public void setSogliaSpike(double sogliaSpike) {
		_idrometro.setSogliaSpike(sogliaSpike);
	}

	/**
	 * Sets the stazione ID of this idrometro.
	 *
	 * @param stazioneId the stazione ID of this idrometro
	 */
	@Override
	public void setStazioneId(String stazioneId) {
		_idrometro.setStazioneId(stazioneId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.Idrometro> toCacheModel() {

		return _idrometro.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.Idrometro toEscapedModel() {
		return new IdrometroWrapper(_idrometro.toEscapedModel());
	}

	@Override
	public String toString() {
		return _idrometro.toString();
	}

	@Override
	public it.eng.bollettino.model.Idrometro toUnescapedModel() {
		return new IdrometroWrapper(_idrometro.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _idrometro.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IdrometroWrapper)) {
			return false;
		}

		IdrometroWrapper idrometroWrapper = (IdrometroWrapper)obj;

		if (Objects.equals(_idrometro, idrometroWrapper._idrometro)) {
			return true;
		}

		return false;
	}

	@Override
	public Idrometro getWrappedModel() {
		return _idrometro;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _idrometro.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _idrometro.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_idrometro.resetOriginalValues();
	}

	private final Idrometro _idrometro;

}