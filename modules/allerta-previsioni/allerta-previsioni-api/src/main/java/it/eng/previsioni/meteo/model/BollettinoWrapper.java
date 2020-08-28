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

package it.eng.previsioni.meteo.model;

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
 * This class is a wrapper for {@link Bollettino}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Bollettino
 * @generated
 */
@ProviderType
public class BollettinoWrapper implements Bollettino, ModelWrapper<Bollettino> {

	public BollettinoWrapper(Bollettino bollettino) {
		_bollettino = bollettino;
	}

	@Override
	public Class<?> getModelClass() {
		return Bollettino.class;
	}

	@Override
	public String getModelClassName() {
		return Bollettino.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tipo", getTipo());
		attributes.put("timestamp", getTimestamp());
		attributes.put("emissione", getEmissione());
		attributes.put("validita", getValidita());
		attributes.put("xml_content", getXml_content());
		attributes.put("json", getJson());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String tipo = (String)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		Long timestamp = (Long)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		String emissione = (String)attributes.get("emissione");

		if (emissione != null) {
			setEmissione(emissione);
		}

		String validita = (String)attributes.get("validita");

		if (validita != null) {
			setValidita(validita);
		}

		String xml_content = (String)attributes.get("xml_content");

		if (xml_content != null) {
			setXml_content(xml_content);
		}

		String json = (String)attributes.get("json");

		if (json != null) {
			setJson(json);
		}
	}

	@Override
	public Object clone() {
		return new BollettinoWrapper((Bollettino)_bollettino.clone());
	}

	@Override
	public int compareTo(it.eng.previsioni.meteo.model.Bollettino bollettino) {
		return _bollettino.compareTo(bollettino);
	}

	/**
	 * Returns the emissione of this bollettino.
	 *
	 * @return the emissione of this bollettino
	 */
	@Override
	public String getEmissione() {
		return _bollettino.getEmissione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bollettino.getExpandoBridge();
	}

	/**
	 * Returns the ID of this bollettino.
	 *
	 * @return the ID of this bollettino
	 */
	@Override
	public long getId() {
		return _bollettino.getId();
	}

	/**
	 * Returns the json of this bollettino.
	 *
	 * @return the json of this bollettino
	 */
	@Override
	public String getJson() {
		return _bollettino.getJson();
	}

	/**
	 * Returns the primary key of this bollettino.
	 *
	 * @return the primary key of this bollettino
	 */
	@Override
	public long getPrimaryKey() {
		return _bollettino.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bollettino.getPrimaryKeyObj();
	}

	/**
	 * Returns the timestamp of this bollettino.
	 *
	 * @return the timestamp of this bollettino
	 */
	@Override
	public long getTimestamp() {
		return _bollettino.getTimestamp();
	}

	/**
	 * Returns the tipo of this bollettino.
	 *
	 * @return the tipo of this bollettino
	 */
	@Override
	public String getTipo() {
		return _bollettino.getTipo();
	}

	/**
	 * Returns the validita of this bollettino.
	 *
	 * @return the validita of this bollettino
	 */
	@Override
	public String getValidita() {
		return _bollettino.getValidita();
	}

	/**
	 * Returns the xml_content of this bollettino.
	 *
	 * @return the xml_content of this bollettino
	 */
	@Override
	public String getXml_content() {
		return _bollettino.getXml_content();
	}

	@Override
	public int hashCode() {
		return _bollettino.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _bollettino.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bollettino.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bollettino.isNew();
	}

	@Override
	public void persist() {
		_bollettino.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bollettino.setCachedModel(cachedModel);
	}

	/**
	 * Sets the emissione of this bollettino.
	 *
	 * @param emissione the emissione of this bollettino
	 */
	@Override
	public void setEmissione(String emissione) {
		_bollettino.setEmissione(emissione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_bollettino.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bollettino.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bollettino.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this bollettino.
	 *
	 * @param id the ID of this bollettino
	 */
	@Override
	public void setId(long id) {
		_bollettino.setId(id);
	}

	/**
	 * Sets the json of this bollettino.
	 *
	 * @param json the json of this bollettino
	 */
	@Override
	public void setJson(String json) {
		_bollettino.setJson(json);
	}

	@Override
	public void setNew(boolean n) {
		_bollettino.setNew(n);
	}

	/**
	 * Sets the primary key of this bollettino.
	 *
	 * @param primaryKey the primary key of this bollettino
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bollettino.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bollettino.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the timestamp of this bollettino.
	 *
	 * @param timestamp the timestamp of this bollettino
	 */
	@Override
	public void setTimestamp(long timestamp) {
		_bollettino.setTimestamp(timestamp);
	}

	/**
	 * Sets the tipo of this bollettino.
	 *
	 * @param tipo the tipo of this bollettino
	 */
	@Override
	public void setTipo(String tipo) {
		_bollettino.setTipo(tipo);
	}

	/**
	 * Sets the validita of this bollettino.
	 *
	 * @param validita the validita of this bollettino
	 */
	@Override
	public void setValidita(String validita) {
		_bollettino.setValidita(validita);
	}

	/**
	 * Sets the xml_content of this bollettino.
	 *
	 * @param xml_content the xml_content of this bollettino
	 */
	@Override
	public void setXml_content(String xml_content) {
		_bollettino.setXml_content(xml_content);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.previsioni.meteo.model.Bollettino> toCacheModel() {

		return _bollettino.toCacheModel();
	}

	@Override
	public it.eng.previsioni.meteo.model.Bollettino toEscapedModel() {
		return new BollettinoWrapper(_bollettino.toEscapedModel());
	}

	@Override
	public String toString() {
		return _bollettino.toString();
	}

	@Override
	public it.eng.previsioni.meteo.model.Bollettino toUnescapedModel() {
		return new BollettinoWrapper(_bollettino.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _bollettino.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BollettinoWrapper)) {
			return false;
		}

		BollettinoWrapper bollettinoWrapper = (BollettinoWrapper)obj;

		if (Objects.equals(_bollettino, bollettinoWrapper._bollettino)) {
			return true;
		}

		return false;
	}

	@Override
	public Bollettino getWrappedModel() {
		return _bollettino;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bollettino.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bollettino.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bollettino.resetOriginalValues();
	}

	private final Bollettino _bollettino;

}