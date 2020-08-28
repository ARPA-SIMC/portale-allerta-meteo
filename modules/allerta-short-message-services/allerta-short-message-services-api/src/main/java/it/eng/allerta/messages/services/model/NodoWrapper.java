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

package it.eng.allerta.messages.services.model;

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
 * This class is a wrapper for {@link Nodo}.
 * </p>
 *
 * @author Giorgianni_F
 * @see Nodo
 * @generated
 */
@ProviderType
public class NodoWrapper implements Nodo, ModelWrapper<Nodo> {

	public NodoWrapper(Nodo nodo) {
		_nodo = nodo;
	}

	@Override
	public Class<?> getModelClass() {
		return Nodo.class;
	}

	@Override
	public String getModelClassName() {
		return Nodo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("ip", getIp());
		attributes.put("porta", getPorta());
		attributes.put("nodoConnesso", getNodoConnesso());
		attributes.put("dataConnessione", getDataConnessione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		String ip = (String)attributes.get("ip");

		if (ip != null) {
			setIp(ip);
		}

		Integer porta = (Integer)attributes.get("porta");

		if (porta != null) {
			setPorta(porta);
		}

		String nodoConnesso = (String)attributes.get("nodoConnesso");

		if (nodoConnesso != null) {
			setNodoConnesso(nodoConnesso);
		}

		Date dataConnessione = (Date)attributes.get("dataConnessione");

		if (dataConnessione != null) {
			setDataConnessione(dataConnessione);
		}
	}

	@Override
	public Object clone() {
		return new NodoWrapper((Nodo)_nodo.clone());
	}

	@Override
	public int compareTo(it.eng.allerta.messages.services.model.Nodo nodo) {
		return _nodo.compareTo(nodo);
	}

	/**
	 * Returns the data connessione of this nodo.
	 *
	 * @return the data connessione of this nodo
	 */
	@Override
	public Date getDataConnessione() {
		return _nodo.getDataConnessione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _nodo.getExpandoBridge();
	}

	/**
	 * Returns the ID of this nodo.
	 *
	 * @return the ID of this nodo
	 */
	@Override
	public long getId() {
		return _nodo.getId();
	}

	/**
	 * Returns the ip of this nodo.
	 *
	 * @return the ip of this nodo
	 */
	@Override
	public String getIp() {
		return _nodo.getIp();
	}

	/**
	 * Returns the nodo connesso of this nodo.
	 *
	 * @return the nodo connesso of this nodo
	 */
	@Override
	public String getNodoConnesso() {
		return _nodo.getNodoConnesso();
	}

	/**
	 * Returns the porta of this nodo.
	 *
	 * @return the porta of this nodo
	 */
	@Override
	public int getPorta() {
		return _nodo.getPorta();
	}

	/**
	 * Returns the primary key of this nodo.
	 *
	 * @return the primary key of this nodo
	 */
	@Override
	public long getPrimaryKey() {
		return _nodo.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _nodo.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _nodo.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _nodo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _nodo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _nodo.isNew();
	}

	@Override
	public void persist() {
		_nodo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_nodo.setCachedModel(cachedModel);
	}

	/**
	 * Sets the data connessione of this nodo.
	 *
	 * @param dataConnessione the data connessione of this nodo
	 */
	@Override
	public void setDataConnessione(Date dataConnessione) {
		_nodo.setDataConnessione(dataConnessione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_nodo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_nodo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_nodo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this nodo.
	 *
	 * @param Id the ID of this nodo
	 */
	@Override
	public void setId(long Id) {
		_nodo.setId(Id);
	}

	/**
	 * Sets the ip of this nodo.
	 *
	 * @param ip the ip of this nodo
	 */
	@Override
	public void setIp(String ip) {
		_nodo.setIp(ip);
	}

	@Override
	public void setNew(boolean n) {
		_nodo.setNew(n);
	}

	/**
	 * Sets the nodo connesso of this nodo.
	 *
	 * @param nodoConnesso the nodo connesso of this nodo
	 */
	@Override
	public void setNodoConnesso(String nodoConnesso) {
		_nodo.setNodoConnesso(nodoConnesso);
	}

	/**
	 * Sets the porta of this nodo.
	 *
	 * @param porta the porta of this nodo
	 */
	@Override
	public void setPorta(int porta) {
		_nodo.setPorta(porta);
	}

	/**
	 * Sets the primary key of this nodo.
	 *
	 * @param primaryKey the primary key of this nodo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_nodo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_nodo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerta.messages.services.model.Nodo> toCacheModel() {

		return _nodo.toCacheModel();
	}

	@Override
	public it.eng.allerta.messages.services.model.Nodo toEscapedModel() {
		return new NodoWrapper(_nodo.toEscapedModel());
	}

	@Override
	public String toString() {
		return _nodo.toString();
	}

	@Override
	public it.eng.allerta.messages.services.model.Nodo toUnescapedModel() {
		return new NodoWrapper(_nodo.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _nodo.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NodoWrapper)) {
			return false;
		}

		NodoWrapper nodoWrapper = (NodoWrapper)obj;

		if (Objects.equals(_nodo, nodoWrapper._nodo)) {
			return true;
		}

		return false;
	}

	@Override
	public Nodo getWrappedModel() {
		return _nodo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _nodo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _nodo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_nodo.resetOriginalValues();
	}

	private final Nodo _nodo;

}