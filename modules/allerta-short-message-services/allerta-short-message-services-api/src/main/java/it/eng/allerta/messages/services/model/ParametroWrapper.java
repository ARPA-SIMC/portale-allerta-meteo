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
 * This class is a wrapper for {@link Parametro}.
 * </p>
 *
 * @author Giorgianni_F
 * @see Parametro
 * @generated
 */
@ProviderType
public class ParametroWrapper implements Parametro, ModelWrapper<Parametro> {

	public ParametroWrapper(Parametro parametro) {
		_parametro = parametro;
	}

	@Override
	public Class<?> getModelClass() {
		return Parametro.class;
	}

	@Override
	public String getModelClassName() {
		return Parametro.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("ip", getIp());
		attributes.put("porta", getPorta());
		attributes.put("username", getUsername());
		attributes.put("password", getPassword());
		attributes.put("mittente", getMittente());
		attributes.put("nodo", getNodo());
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

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String mittente = (String)attributes.get("mittente");

		if (mittente != null) {
			setMittente(mittente);
		}

		String nodo = (String)attributes.get("nodo");

		if (nodo != null) {
			setNodo(nodo);
		}

		Date dataConnessione = (Date)attributes.get("dataConnessione");

		if (dataConnessione != null) {
			setDataConnessione(dataConnessione);
		}
	}

	@Override
	public Object clone() {
		return new ParametroWrapper((Parametro)_parametro.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerta.messages.services.model.Parametro parametro) {

		return _parametro.compareTo(parametro);
	}

	/**
	 * Returns the data connessione of this parametro.
	 *
	 * @return the data connessione of this parametro
	 */
	@Override
	public Date getDataConnessione() {
		return _parametro.getDataConnessione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _parametro.getExpandoBridge();
	}

	/**
	 * Returns the ID of this parametro.
	 *
	 * @return the ID of this parametro
	 */
	@Override
	public long getId() {
		return _parametro.getId();
	}

	/**
	 * Returns the ip of this parametro.
	 *
	 * @return the ip of this parametro
	 */
	@Override
	public String getIp() {
		return _parametro.getIp();
	}

	/**
	 * Returns the mittente of this parametro.
	 *
	 * @return the mittente of this parametro
	 */
	@Override
	public String getMittente() {
		return _parametro.getMittente();
	}

	/**
	 * Returns the nodo of this parametro.
	 *
	 * @return the nodo of this parametro
	 */
	@Override
	public String getNodo() {
		return _parametro.getNodo();
	}

	/**
	 * Returns the password of this parametro.
	 *
	 * @return the password of this parametro
	 */
	@Override
	public String getPassword() {
		return _parametro.getPassword();
	}

	/**
	 * Returns the porta of this parametro.
	 *
	 * @return the porta of this parametro
	 */
	@Override
	public int getPorta() {
		return _parametro.getPorta();
	}

	/**
	 * Returns the primary key of this parametro.
	 *
	 * @return the primary key of this parametro
	 */
	@Override
	public long getPrimaryKey() {
		return _parametro.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _parametro.getPrimaryKeyObj();
	}

	/**
	 * Returns the username of this parametro.
	 *
	 * @return the username of this parametro
	 */
	@Override
	public String getUsername() {
		return _parametro.getUsername();
	}

	@Override
	public int hashCode() {
		return _parametro.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _parametro.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _parametro.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _parametro.isNew();
	}

	@Override
	public void persist() {
		_parametro.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_parametro.setCachedModel(cachedModel);
	}

	/**
	 * Sets the data connessione of this parametro.
	 *
	 * @param dataConnessione the data connessione of this parametro
	 */
	@Override
	public void setDataConnessione(Date dataConnessione) {
		_parametro.setDataConnessione(dataConnessione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_parametro.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_parametro.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_parametro.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this parametro.
	 *
	 * @param Id the ID of this parametro
	 */
	@Override
	public void setId(long Id) {
		_parametro.setId(Id);
	}

	/**
	 * Sets the ip of this parametro.
	 *
	 * @param ip the ip of this parametro
	 */
	@Override
	public void setIp(String ip) {
		_parametro.setIp(ip);
	}

	/**
	 * Sets the mittente of this parametro.
	 *
	 * @param mittente the mittente of this parametro
	 */
	@Override
	public void setMittente(String mittente) {
		_parametro.setMittente(mittente);
	}

	@Override
	public void setNew(boolean n) {
		_parametro.setNew(n);
	}

	/**
	 * Sets the nodo of this parametro.
	 *
	 * @param nodo the nodo of this parametro
	 */
	@Override
	public void setNodo(String nodo) {
		_parametro.setNodo(nodo);
	}

	/**
	 * Sets the password of this parametro.
	 *
	 * @param password the password of this parametro
	 */
	@Override
	public void setPassword(String password) {
		_parametro.setPassword(password);
	}

	/**
	 * Sets the porta of this parametro.
	 *
	 * @param porta the porta of this parametro
	 */
	@Override
	public void setPorta(int porta) {
		_parametro.setPorta(porta);
	}

	/**
	 * Sets the primary key of this parametro.
	 *
	 * @param primaryKey the primary key of this parametro
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_parametro.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_parametro.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the username of this parametro.
	 *
	 * @param username the username of this parametro
	 */
	@Override
	public void setUsername(String username) {
		_parametro.setUsername(username);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerta.messages.services.model.Parametro> toCacheModel() {

		return _parametro.toCacheModel();
	}

	@Override
	public it.eng.allerta.messages.services.model.Parametro toEscapedModel() {
		return new ParametroWrapper(_parametro.toEscapedModel());
	}

	@Override
	public String toString() {
		return _parametro.toString();
	}

	@Override
	public it.eng.allerta.messages.services.model.Parametro toUnescapedModel() {
		return new ParametroWrapper(_parametro.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _parametro.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ParametroWrapper)) {
			return false;
		}

		ParametroWrapper parametroWrapper = (ParametroWrapper)obj;

		if (Objects.equals(_parametro, parametroWrapper._parametro)) {
			return true;
		}

		return false;
	}

	@Override
	public Parametro getWrappedModel() {
		return _parametro;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _parametro.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _parametro.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_parametro.resetOriginalValues();
	}

	private final Parametro _parametro;

}