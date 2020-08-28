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
 * This class is a wrapper for {@link Storico}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Storico
 * @generated
 */
@ProviderType
public class StoricoWrapper implements Storico, ModelWrapper<Storico> {

	public StoricoWrapper(Storico storico) {
		_storico = storico;
	}

	@Override
	public Class<?> getModelClass() {
		return Storico.class;
	}

	@Override
	public String getModelClassName() {
		return Storico.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("idZona", getIdZona());
		attributes.put("nome", getNome());
		attributes.put("sigla", getSigla());
		attributes.put("tipo", getTipo());
		attributes.put("xml", getXml());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer idZona = (Integer)attributes.get("idZona");

		if (idZona != null) {
			setIdZona(idZona);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String sigla = (String)attributes.get("sigla");

		if (sigla != null) {
			setSigla(sigla);
		}

		String tipo = (String)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		String xml = (String)attributes.get("xml");

		if (xml != null) {
			setXml(xml);
		}
	}

	@Override
	public Object clone() {
		return new StoricoWrapper((Storico)_storico.clone());
	}

	@Override
	public int compareTo(it.eng.previsioni.meteo.model.Storico storico) {
		return _storico.compareTo(storico);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _storico.getExpandoBridge();
	}

	/**
	 * Returns the ID of this storico.
	 *
	 * @return the ID of this storico
	 */
	@Override
	public long getId() {
		return _storico.getId();
	}

	/**
	 * Returns the id zona of this storico.
	 *
	 * @return the id zona of this storico
	 */
	@Override
	public int getIdZona() {
		return _storico.getIdZona();
	}

	/**
	 * Returns the nome of this storico.
	 *
	 * @return the nome of this storico
	 */
	@Override
	public String getNome() {
		return _storico.getNome();
	}

	/**
	 * Returns the primary key of this storico.
	 *
	 * @return the primary key of this storico
	 */
	@Override
	public long getPrimaryKey() {
		return _storico.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _storico.getPrimaryKeyObj();
	}

	/**
	 * Returns the sigla of this storico.
	 *
	 * @return the sigla of this storico
	 */
	@Override
	public String getSigla() {
		return _storico.getSigla();
	}

	/**
	 * Returns the tipo of this storico.
	 *
	 * @return the tipo of this storico
	 */
	@Override
	public String getTipo() {
		return _storico.getTipo();
	}

	/**
	 * Returns the xml of this storico.
	 *
	 * @return the xml of this storico
	 */
	@Override
	public String getXml() {
		return _storico.getXml();
	}

	@Override
	public int hashCode() {
		return _storico.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _storico.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _storico.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _storico.isNew();
	}

	@Override
	public void persist() {
		_storico.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_storico.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_storico.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_storico.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_storico.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this storico.
	 *
	 * @param id the ID of this storico
	 */
	@Override
	public void setId(long id) {
		_storico.setId(id);
	}

	/**
	 * Sets the id zona of this storico.
	 *
	 * @param idZona the id zona of this storico
	 */
	@Override
	public void setIdZona(int idZona) {
		_storico.setIdZona(idZona);
	}

	@Override
	public void setNew(boolean n) {
		_storico.setNew(n);
	}

	/**
	 * Sets the nome of this storico.
	 *
	 * @param nome the nome of this storico
	 */
	@Override
	public void setNome(String nome) {
		_storico.setNome(nome);
	}

	/**
	 * Sets the primary key of this storico.
	 *
	 * @param primaryKey the primary key of this storico
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_storico.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_storico.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the sigla of this storico.
	 *
	 * @param sigla the sigla of this storico
	 */
	@Override
	public void setSigla(String sigla) {
		_storico.setSigla(sigla);
	}

	/**
	 * Sets the tipo of this storico.
	 *
	 * @param tipo the tipo of this storico
	 */
	@Override
	public void setTipo(String tipo) {
		_storico.setTipo(tipo);
	}

	/**
	 * Sets the xml of this storico.
	 *
	 * @param xml the xml of this storico
	 */
	@Override
	public void setXml(String xml) {
		_storico.setXml(xml);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.previsioni.meteo.model.Storico> toCacheModel() {

		return _storico.toCacheModel();
	}

	@Override
	public it.eng.previsioni.meteo.model.Storico toEscapedModel() {
		return new StoricoWrapper(_storico.toEscapedModel());
	}

	@Override
	public String toString() {
		return _storico.toString();
	}

	@Override
	public it.eng.previsioni.meteo.model.Storico toUnescapedModel() {
		return new StoricoWrapper(_storico.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _storico.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StoricoWrapper)) {
			return false;
		}

		StoricoWrapper storicoWrapper = (StoricoWrapper)obj;

		if (Objects.equals(_storico, storicoWrapper._storico)) {
			return true;
		}

		return false;
	}

	@Override
	public Storico getWrappedModel() {
		return _storico;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _storico.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _storico.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_storico.resetOriginalValues();
	}

	private final Storico _storico;

}