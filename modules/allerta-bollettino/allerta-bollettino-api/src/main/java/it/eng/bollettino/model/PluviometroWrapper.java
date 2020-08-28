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
 * This class is a wrapper for {@link Pluviometro}.
 * </p>
 *
 * @author GFAVINI
 * @see Pluviometro
 * @generated
 */
@ProviderType
public class PluviometroWrapper
	implements Pluviometro, ModelWrapper<Pluviometro> {

	public PluviometroWrapper(Pluviometro pluviometro) {
		_pluviometro = pluviometro;
	}

	@Override
	public Class<?> getModelClass() {
		return Pluviometro.class;
	}

	@Override
	public String getModelClassName() {
		return Pluviometro.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stazioneId", getStazioneId());
		attributes.put("nomeGruppo", getNomeGruppo());
		attributes.put("nomeRubrica", getNomeRubrica());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String stazioneId = (String)attributes.get("stazioneId");

		if (stazioneId != null) {
			setStazioneId(stazioneId);
		}

		String nomeGruppo = (String)attributes.get("nomeGruppo");

		if (nomeGruppo != null) {
			setNomeGruppo(nomeGruppo);
		}

		String nomeRubrica = (String)attributes.get("nomeRubrica");

		if (nomeRubrica != null) {
			setNomeRubrica(nomeRubrica);
		}
	}

	@Override
	public Object clone() {
		return new PluviometroWrapper((Pluviometro)_pluviometro.clone());
	}

	@Override
	public int compareTo(it.eng.bollettino.model.Pluviometro pluviometro) {
		return _pluviometro.compareTo(pluviometro);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _pluviometro.getExpandoBridge();
	}

	/**
	 * Returns the nome gruppo of this pluviometro.
	 *
	 * @return the nome gruppo of this pluviometro
	 */
	@Override
	public String getNomeGruppo() {
		return _pluviometro.getNomeGruppo();
	}

	/**
	 * Returns the nome rubrica of this pluviometro.
	 *
	 * @return the nome rubrica of this pluviometro
	 */
	@Override
	public String getNomeRubrica() {
		return _pluviometro.getNomeRubrica();
	}

	/**
	 * Returns the primary key of this pluviometro.
	 *
	 * @return the primary key of this pluviometro
	 */
	@Override
	public String getPrimaryKey() {
		return _pluviometro.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pluviometro.getPrimaryKeyObj();
	}

	/**
	 * Returns the stazione ID of this pluviometro.
	 *
	 * @return the stazione ID of this pluviometro
	 */
	@Override
	public String getStazioneId() {
		return _pluviometro.getStazioneId();
	}

	@Override
	public int hashCode() {
		return _pluviometro.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _pluviometro.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _pluviometro.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _pluviometro.isNew();
	}

	@Override
	public void persist() {
		_pluviometro.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pluviometro.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_pluviometro.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_pluviometro.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_pluviometro.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_pluviometro.setNew(n);
	}

	/**
	 * Sets the nome gruppo of this pluviometro.
	 *
	 * @param nomeGruppo the nome gruppo of this pluviometro
	 */
	@Override
	public void setNomeGruppo(String nomeGruppo) {
		_pluviometro.setNomeGruppo(nomeGruppo);
	}

	/**
	 * Sets the nome rubrica of this pluviometro.
	 *
	 * @param nomeRubrica the nome rubrica of this pluviometro
	 */
	@Override
	public void setNomeRubrica(String nomeRubrica) {
		_pluviometro.setNomeRubrica(nomeRubrica);
	}

	/**
	 * Sets the primary key of this pluviometro.
	 *
	 * @param primaryKey the primary key of this pluviometro
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		_pluviometro.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_pluviometro.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the stazione ID of this pluviometro.
	 *
	 * @param stazioneId the stazione ID of this pluviometro
	 */
	@Override
	public void setStazioneId(String stazioneId) {
		_pluviometro.setStazioneId(stazioneId);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.bollettino.model.Pluviometro> toCacheModel() {

		return _pluviometro.toCacheModel();
	}

	@Override
	public it.eng.bollettino.model.Pluviometro toEscapedModel() {
		return new PluviometroWrapper(_pluviometro.toEscapedModel());
	}

	@Override
	public String toString() {
		return _pluviometro.toString();
	}

	@Override
	public it.eng.bollettino.model.Pluviometro toUnescapedModel() {
		return new PluviometroWrapper(_pluviometro.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _pluviometro.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PluviometroWrapper)) {
			return false;
		}

		PluviometroWrapper pluviometroWrapper = (PluviometroWrapper)obj;

		if (Objects.equals(_pluviometro, pluviometroWrapper._pluviometro)) {
			return true;
		}

		return false;
	}

	@Override
	public Pluviometro getWrappedModel() {
		return _pluviometro;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _pluviometro.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _pluviometro.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_pluviometro.resetOriginalValues();
	}

	private final Pluviometro _pluviometro;

}