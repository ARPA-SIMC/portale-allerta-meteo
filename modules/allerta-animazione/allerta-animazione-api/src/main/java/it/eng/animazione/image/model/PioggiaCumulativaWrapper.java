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

package it.eng.animazione.image.model;

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
 * This class is a wrapper for {@link PioggiaCumulativa}.
 * </p>
 *
 * @author UTENTE
 * @see PioggiaCumulativa
 * @generated
 */
@ProviderType
public class PioggiaCumulativaWrapper
	implements PioggiaCumulativa, ModelWrapper<PioggiaCumulativa> {

	public PioggiaCumulativaWrapper(PioggiaCumulativa pioggiaCumulativa) {
		_pioggiaCumulativa = pioggiaCumulativa;
	}

	@Override
	public Class<?> getModelClass() {
		return PioggiaCumulativa.class;
	}

	@Override
	public String getModelClassName() {
		return PioggiaCumulativa.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("cumulazione", getCumulazione());
		attributes.put("inzioCumulazione", getInzioCumulazione());
		attributes.put("fineCumulazione", getFineCumulazione());
		attributes.put("imgData", getImgData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String cumulazione = (String)attributes.get("cumulazione");

		if (cumulazione != null) {
			setCumulazione(cumulazione);
		}

		Date inzioCumulazione = (Date)attributes.get("inzioCumulazione");

		if (inzioCumulazione != null) {
			setInzioCumulazione(inzioCumulazione);
		}

		Date fineCumulazione = (Date)attributes.get("fineCumulazione");

		if (fineCumulazione != null) {
			setFineCumulazione(fineCumulazione);
		}

		String imgData = (String)attributes.get("imgData");

		if (imgData != null) {
			setImgData(imgData);
		}
	}

	@Override
	public Object clone() {
		return new PioggiaCumulativaWrapper(
			(PioggiaCumulativa)_pioggiaCumulativa.clone());
	}

	@Override
	public int compareTo(
		it.eng.animazione.image.model.PioggiaCumulativa pioggiaCumulativa) {

		return _pioggiaCumulativa.compareTo(pioggiaCumulativa);
	}

	/**
	 * Returns the cumulazione of this pioggia cumulativa.
	 *
	 * @return the cumulazione of this pioggia cumulativa
	 */
	@Override
	public String getCumulazione() {
		return _pioggiaCumulativa.getCumulazione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _pioggiaCumulativa.getExpandoBridge();
	}

	/**
	 * Returns the fine cumulazione of this pioggia cumulativa.
	 *
	 * @return the fine cumulazione of this pioggia cumulativa
	 */
	@Override
	public Date getFineCumulazione() {
		return _pioggiaCumulativa.getFineCumulazione();
	}

	/**
	 * Returns the ID of this pioggia cumulativa.
	 *
	 * @return the ID of this pioggia cumulativa
	 */
	@Override
	public long getId() {
		return _pioggiaCumulativa.getId();
	}

	/**
	 * Returns the img data of this pioggia cumulativa.
	 *
	 * @return the img data of this pioggia cumulativa
	 */
	@Override
	public String getImgData() {
		return _pioggiaCumulativa.getImgData();
	}

	/**
	 * Returns the inzio cumulazione of this pioggia cumulativa.
	 *
	 * @return the inzio cumulazione of this pioggia cumulativa
	 */
	@Override
	public Date getInzioCumulazione() {
		return _pioggiaCumulativa.getInzioCumulazione();
	}

	/**
	 * Returns the nome of this pioggia cumulativa.
	 *
	 * @return the nome of this pioggia cumulativa
	 */
	@Override
	public String getNome() {
		return _pioggiaCumulativa.getNome();
	}

	/**
	 * Returns the primary key of this pioggia cumulativa.
	 *
	 * @return the primary key of this pioggia cumulativa
	 */
	@Override
	public long getPrimaryKey() {
		return _pioggiaCumulativa.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pioggiaCumulativa.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _pioggiaCumulativa.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _pioggiaCumulativa.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _pioggiaCumulativa.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _pioggiaCumulativa.isNew();
	}

	@Override
	public void persist() {
		_pioggiaCumulativa.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_pioggiaCumulativa.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cumulazione of this pioggia cumulativa.
	 *
	 * @param cumulazione the cumulazione of this pioggia cumulativa
	 */
	@Override
	public void setCumulazione(String cumulazione) {
		_pioggiaCumulativa.setCumulazione(cumulazione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_pioggiaCumulativa.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_pioggiaCumulativa.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_pioggiaCumulativa.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fine cumulazione of this pioggia cumulativa.
	 *
	 * @param fineCumulazione the fine cumulazione of this pioggia cumulativa
	 */
	@Override
	public void setFineCumulazione(Date fineCumulazione) {
		_pioggiaCumulativa.setFineCumulazione(fineCumulazione);
	}

	/**
	 * Sets the ID of this pioggia cumulativa.
	 *
	 * @param id the ID of this pioggia cumulativa
	 */
	@Override
	public void setId(long id) {
		_pioggiaCumulativa.setId(id);
	}

	/**
	 * Sets the img data of this pioggia cumulativa.
	 *
	 * @param imgData the img data of this pioggia cumulativa
	 */
	@Override
	public void setImgData(String imgData) {
		_pioggiaCumulativa.setImgData(imgData);
	}

	/**
	 * Sets the inzio cumulazione of this pioggia cumulativa.
	 *
	 * @param inzioCumulazione the inzio cumulazione of this pioggia cumulativa
	 */
	@Override
	public void setInzioCumulazione(Date inzioCumulazione) {
		_pioggiaCumulativa.setInzioCumulazione(inzioCumulazione);
	}

	@Override
	public void setNew(boolean n) {
		_pioggiaCumulativa.setNew(n);
	}

	/**
	 * Sets the nome of this pioggia cumulativa.
	 *
	 * @param nome the nome of this pioggia cumulativa
	 */
	@Override
	public void setNome(String nome) {
		_pioggiaCumulativa.setNome(nome);
	}

	/**
	 * Sets the primary key of this pioggia cumulativa.
	 *
	 * @param primaryKey the primary key of this pioggia cumulativa
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_pioggiaCumulativa.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_pioggiaCumulativa.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.animazione.image.model.PioggiaCumulativa> toCacheModel() {

		return _pioggiaCumulativa.toCacheModel();
	}

	@Override
	public it.eng.animazione.image.model.PioggiaCumulativa toEscapedModel() {
		return new PioggiaCumulativaWrapper(
			_pioggiaCumulativa.toEscapedModel());
	}

	@Override
	public String toString() {
		return _pioggiaCumulativa.toString();
	}

	@Override
	public it.eng.animazione.image.model.PioggiaCumulativa toUnescapedModel() {
		return new PioggiaCumulativaWrapper(
			_pioggiaCumulativa.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _pioggiaCumulativa.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PioggiaCumulativaWrapper)) {
			return false;
		}

		PioggiaCumulativaWrapper pioggiaCumulativaWrapper =
			(PioggiaCumulativaWrapper)obj;

		if (Objects.equals(
				_pioggiaCumulativa,
				pioggiaCumulativaWrapper._pioggiaCumulativa)) {

			return true;
		}

		return false;
	}

	@Override
	public PioggiaCumulativa getWrappedModel() {
		return _pioggiaCumulativa;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _pioggiaCumulativa.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _pioggiaCumulativa.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_pioggiaCumulativa.resetOriginalValues();
	}

	private final PioggiaCumulativa _pioggiaCumulativa;

}