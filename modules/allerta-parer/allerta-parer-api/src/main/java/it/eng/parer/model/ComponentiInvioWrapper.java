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

package it.eng.parer.model;

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
 * This class is a wrapper for {@link ComponentiInvio}.
 * </p>
 *
 * @author Pratola_L
 * @see ComponentiInvio
 * @generated
 */
@ProviderType
public class ComponentiInvioWrapper
	implements ComponentiInvio, ModelWrapper<ComponentiInvio> {

	public ComponentiInvioWrapper(ComponentiInvio componentiInvio) {
		_componentiInvio = componentiInvio;
	}

	@Override
	public Class<?> getModelClass() {
		return ComponentiInvio.class;
	}

	@Override
	public String getModelClassName() {
		return ComponentiInvio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_INVIO", getID_INVIO());
		attributes.put("ID_COMPONENTE", getID_COMPONENTE());
		attributes.put("ORDINE_PRESENTAZIONE", getORDINE_PRESENTAZIONE());
		attributes.put("TIPO_COMPONENTE", getTIPO_COMPONENTE());
		attributes.put(
			"TIPO_SUPPORTO_COMPONENTE", getTIPO_SUPPORTO_COMPONENTE());
		attributes.put("NOME_COMPONENTE", getNOME_COMPONENTE());
		attributes.put("FORMATO_FILE_VERSATO", getFORMATO_FILE_VERSATO());
		attributes.put("HASH_VERSATO", getHASH_VERSATO());
		attributes.put("URN_VERSATO", getURN_VERSATO());
		attributes.put("ID_COMPONENTE_VERSATO", getID_COMPONENTE_VERSATO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_INVIO = (Long)attributes.get("ID_INVIO");

		if (ID_INVIO != null) {
			setID_INVIO(ID_INVIO);
		}

		Long ID_COMPONENTE = (Long)attributes.get("ID_COMPONENTE");

		if (ID_COMPONENTE != null) {
			setID_COMPONENTE(ID_COMPONENTE);
		}

		Long ORDINE_PRESENTAZIONE = (Long)attributes.get(
			"ORDINE_PRESENTAZIONE");

		if (ORDINE_PRESENTAZIONE != null) {
			setORDINE_PRESENTAZIONE(ORDINE_PRESENTAZIONE);
		}

		String TIPO_COMPONENTE = (String)attributes.get("TIPO_COMPONENTE");

		if (TIPO_COMPONENTE != null) {
			setTIPO_COMPONENTE(TIPO_COMPONENTE);
		}

		String TIPO_SUPPORTO_COMPONENTE = (String)attributes.get(
			"TIPO_SUPPORTO_COMPONENTE");

		if (TIPO_SUPPORTO_COMPONENTE != null) {
			setTIPO_SUPPORTO_COMPONENTE(TIPO_SUPPORTO_COMPONENTE);
		}

		String NOME_COMPONENTE = (String)attributes.get("NOME_COMPONENTE");

		if (NOME_COMPONENTE != null) {
			setNOME_COMPONENTE(NOME_COMPONENTE);
		}

		String FORMATO_FILE_VERSATO = (String)attributes.get(
			"FORMATO_FILE_VERSATO");

		if (FORMATO_FILE_VERSATO != null) {
			setFORMATO_FILE_VERSATO(FORMATO_FILE_VERSATO);
		}

		String HASH_VERSATO = (String)attributes.get("HASH_VERSATO");

		if (HASH_VERSATO != null) {
			setHASH_VERSATO(HASH_VERSATO);
		}

		String URN_VERSATO = (String)attributes.get("URN_VERSATO");

		if (URN_VERSATO != null) {
			setURN_VERSATO(URN_VERSATO);
		}

		Long ID_COMPONENTE_VERSATO = (Long)attributes.get(
			"ID_COMPONENTE_VERSATO");

		if (ID_COMPONENTE_VERSATO != null) {
			setID_COMPONENTE_VERSATO(ID_COMPONENTE_VERSATO);
		}
	}

	@Override
	public Object clone() {
		return new ComponentiInvioWrapper(
			(ComponentiInvio)_componentiInvio.clone());
	}

	@Override
	public int compareTo(it.eng.parer.model.ComponentiInvio componentiInvio) {
		return _componentiInvio.compareTo(componentiInvio);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _componentiInvio.getExpandoBridge();
	}

	/**
	 * Returns the formato_file_versato of this componenti invio.
	 *
	 * @return the formato_file_versato of this componenti invio
	 */
	@Override
	public String getFORMATO_FILE_VERSATO() {
		return _componentiInvio.getFORMATO_FILE_VERSATO();
	}

	/**
	 * Returns the hash_versato of this componenti invio.
	 *
	 * @return the hash_versato of this componenti invio
	 */
	@Override
	public String getHASH_VERSATO() {
		return _componentiInvio.getHASH_VERSATO();
	}

	/**
	 * Returns the id_componente of this componenti invio.
	 *
	 * @return the id_componente of this componenti invio
	 */
	@Override
	public long getID_COMPONENTE() {
		return _componentiInvio.getID_COMPONENTE();
	}

	/**
	 * Returns the id_componente_versato of this componenti invio.
	 *
	 * @return the id_componente_versato of this componenti invio
	 */
	@Override
	public long getID_COMPONENTE_VERSATO() {
		return _componentiInvio.getID_COMPONENTE_VERSATO();
	}

	/**
	 * Returns the id_invio of this componenti invio.
	 *
	 * @return the id_invio of this componenti invio
	 */
	@Override
	public long getID_INVIO() {
		return _componentiInvio.getID_INVIO();
	}

	/**
	 * Returns the nome_componente of this componenti invio.
	 *
	 * @return the nome_componente of this componenti invio
	 */
	@Override
	public String getNOME_COMPONENTE() {
		return _componentiInvio.getNOME_COMPONENTE();
	}

	/**
	 * Returns the ordine_presentazione of this componenti invio.
	 *
	 * @return the ordine_presentazione of this componenti invio
	 */
	@Override
	public long getORDINE_PRESENTAZIONE() {
		return _componentiInvio.getORDINE_PRESENTAZIONE();
	}

	/**
	 * Returns the primary key of this componenti invio.
	 *
	 * @return the primary key of this componenti invio
	 */
	@Override
	public it.eng.parer.service.persistence.ComponentiInvioPK getPrimaryKey() {
		return _componentiInvio.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _componentiInvio.getPrimaryKeyObj();
	}

	/**
	 * Returns the tipo_componente of this componenti invio.
	 *
	 * @return the tipo_componente of this componenti invio
	 */
	@Override
	public String getTIPO_COMPONENTE() {
		return _componentiInvio.getTIPO_COMPONENTE();
	}

	/**
	 * Returns the tipo_supporto_componente of this componenti invio.
	 *
	 * @return the tipo_supporto_componente of this componenti invio
	 */
	@Override
	public String getTIPO_SUPPORTO_COMPONENTE() {
		return _componentiInvio.getTIPO_SUPPORTO_COMPONENTE();
	}

	/**
	 * Returns the urn_versato of this componenti invio.
	 *
	 * @return the urn_versato of this componenti invio
	 */
	@Override
	public String getURN_VERSATO() {
		return _componentiInvio.getURN_VERSATO();
	}

	@Override
	public int hashCode() {
		return _componentiInvio.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _componentiInvio.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _componentiInvio.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _componentiInvio.isNew();
	}

	@Override
	public void persist() {
		_componentiInvio.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_componentiInvio.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_componentiInvio.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_componentiInvio.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_componentiInvio.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the formato_file_versato of this componenti invio.
	 *
	 * @param FORMATO_FILE_VERSATO the formato_file_versato of this componenti invio
	 */
	@Override
	public void setFORMATO_FILE_VERSATO(String FORMATO_FILE_VERSATO) {
		_componentiInvio.setFORMATO_FILE_VERSATO(FORMATO_FILE_VERSATO);
	}

	/**
	 * Sets the hash_versato of this componenti invio.
	 *
	 * @param HASH_VERSATO the hash_versato of this componenti invio
	 */
	@Override
	public void setHASH_VERSATO(String HASH_VERSATO) {
		_componentiInvio.setHASH_VERSATO(HASH_VERSATO);
	}

	/**
	 * Sets the id_componente of this componenti invio.
	 *
	 * @param ID_COMPONENTE the id_componente of this componenti invio
	 */
	@Override
	public void setID_COMPONENTE(long ID_COMPONENTE) {
		_componentiInvio.setID_COMPONENTE(ID_COMPONENTE);
	}

	/**
	 * Sets the id_componente_versato of this componenti invio.
	 *
	 * @param ID_COMPONENTE_VERSATO the id_componente_versato of this componenti invio
	 */
	@Override
	public void setID_COMPONENTE_VERSATO(long ID_COMPONENTE_VERSATO) {
		_componentiInvio.setID_COMPONENTE_VERSATO(ID_COMPONENTE_VERSATO);
	}

	/**
	 * Sets the id_invio of this componenti invio.
	 *
	 * @param ID_INVIO the id_invio of this componenti invio
	 */
	@Override
	public void setID_INVIO(long ID_INVIO) {
		_componentiInvio.setID_INVIO(ID_INVIO);
	}

	@Override
	public void setNew(boolean n) {
		_componentiInvio.setNew(n);
	}

	/**
	 * Sets the nome_componente of this componenti invio.
	 *
	 * @param NOME_COMPONENTE the nome_componente of this componenti invio
	 */
	@Override
	public void setNOME_COMPONENTE(String NOME_COMPONENTE) {
		_componentiInvio.setNOME_COMPONENTE(NOME_COMPONENTE);
	}

	/**
	 * Sets the ordine_presentazione of this componenti invio.
	 *
	 * @param ORDINE_PRESENTAZIONE the ordine_presentazione of this componenti invio
	 */
	@Override
	public void setORDINE_PRESENTAZIONE(long ORDINE_PRESENTAZIONE) {
		_componentiInvio.setORDINE_PRESENTAZIONE(ORDINE_PRESENTAZIONE);
	}

	/**
	 * Sets the primary key of this componenti invio.
	 *
	 * @param primaryKey the primary key of this componenti invio
	 */
	@Override
	public void setPrimaryKey(
		it.eng.parer.service.persistence.ComponentiInvioPK primaryKey) {

		_componentiInvio.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_componentiInvio.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the tipo_componente of this componenti invio.
	 *
	 * @param TIPO_COMPONENTE the tipo_componente of this componenti invio
	 */
	@Override
	public void setTIPO_COMPONENTE(String TIPO_COMPONENTE) {
		_componentiInvio.setTIPO_COMPONENTE(TIPO_COMPONENTE);
	}

	/**
	 * Sets the tipo_supporto_componente of this componenti invio.
	 *
	 * @param TIPO_SUPPORTO_COMPONENTE the tipo_supporto_componente of this componenti invio
	 */
	@Override
	public void setTIPO_SUPPORTO_COMPONENTE(String TIPO_SUPPORTO_COMPONENTE) {
		_componentiInvio.setTIPO_SUPPORTO_COMPONENTE(TIPO_SUPPORTO_COMPONENTE);
	}

	/**
	 * Sets the urn_versato of this componenti invio.
	 *
	 * @param URN_VERSATO the urn_versato of this componenti invio
	 */
	@Override
	public void setURN_VERSATO(String URN_VERSATO) {
		_componentiInvio.setURN_VERSATO(URN_VERSATO);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.parer.model.ComponentiInvio> toCacheModel() {

		return _componentiInvio.toCacheModel();
	}

	@Override
	public it.eng.parer.model.ComponentiInvio toEscapedModel() {
		return new ComponentiInvioWrapper(_componentiInvio.toEscapedModel());
	}

	@Override
	public String toString() {
		return _componentiInvio.toString();
	}

	@Override
	public it.eng.parer.model.ComponentiInvio toUnescapedModel() {
		return new ComponentiInvioWrapper(_componentiInvio.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _componentiInvio.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ComponentiInvioWrapper)) {
			return false;
		}

		ComponentiInvioWrapper componentiInvioWrapper =
			(ComponentiInvioWrapper)obj;

		if (Objects.equals(
				_componentiInvio, componentiInvioWrapper._componentiInvio)) {

			return true;
		}

		return false;
	}

	@Override
	public ComponentiInvio getWrappedModel() {
		return _componentiInvio;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _componentiInvio.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _componentiInvio.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_componentiInvio.resetOriginalValues();
	}

	private final ComponentiInvio _componentiInvio;

}