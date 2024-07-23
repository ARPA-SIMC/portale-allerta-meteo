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

package allerta.verifica.model;

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
 * This class is a wrapper for {@link UtenteLavoro}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UtenteLavoro
 * @generated
 */
@ProviderType
public class UtenteLavoroWrapper
	implements UtenteLavoro, ModelWrapper<UtenteLavoro> {

	public UtenteLavoroWrapper(UtenteLavoro utenteLavoro) {
		_utenteLavoro = utenteLavoro;
	}

	@Override
	public Class<?> getModelClass() {
		return UtenteLavoro.class;
	}

	@Override
	public String getModelClassName() {
		return UtenteLavoro.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("documento", getDocumento());
		attributes.put("utente", getUtente());
		attributes.put("ts", getTs());
		attributes.put("attivita", getAttivita());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long documento = (Long)attributes.get("documento");

		if (documento != null) {
			setDocumento(documento);
		}

		String utente = (String)attributes.get("utente");

		if (utente != null) {
			setUtente(utente);
		}

		Date ts = (Date)attributes.get("ts");

		if (ts != null) {
			setTs(ts);
		}

		String attivita = (String)attributes.get("attivita");

		if (attivita != null) {
			setAttivita(attivita);
		}
	}

	@Override
	public Object clone() {
		return new UtenteLavoroWrapper((UtenteLavoro)_utenteLavoro.clone());
	}

	@Override
	public int compareTo(allerta.verifica.model.UtenteLavoro utenteLavoro) {
		return _utenteLavoro.compareTo(utenteLavoro);
	}

	/**
	 * Returns the attivita of this utente lavoro.
	 *
	 * @return the attivita of this utente lavoro
	 */
	@Override
	public String getAttivita() {
		return _utenteLavoro.getAttivita();
	}

	/**
	 * Returns the documento of this utente lavoro.
	 *
	 * @return the documento of this utente lavoro
	 */
	@Override
	public long getDocumento() {
		return _utenteLavoro.getDocumento();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _utenteLavoro.getExpandoBridge();
	}

	/**
	 * Returns the ID of this utente lavoro.
	 *
	 * @return the ID of this utente lavoro
	 */
	@Override
	public long getId() {
		return _utenteLavoro.getId();
	}

	/**
	 * Returns the primary key of this utente lavoro.
	 *
	 * @return the primary key of this utente lavoro
	 */
	@Override
	public long getPrimaryKey() {
		return _utenteLavoro.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _utenteLavoro.getPrimaryKeyObj();
	}

	/**
	 * Returns the ts of this utente lavoro.
	 *
	 * @return the ts of this utente lavoro
	 */
	@Override
	public Date getTs() {
		return _utenteLavoro.getTs();
	}

	/**
	 * Returns the utente of this utente lavoro.
	 *
	 * @return the utente of this utente lavoro
	 */
	@Override
	public String getUtente() {
		return _utenteLavoro.getUtente();
	}

	@Override
	public int hashCode() {
		return _utenteLavoro.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _utenteLavoro.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _utenteLavoro.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _utenteLavoro.isNew();
	}

	@Override
	public void persist() {
		_utenteLavoro.persist();
	}

	/**
	 * Sets the attivita of this utente lavoro.
	 *
	 * @param attivita the attivita of this utente lavoro
	 */
	@Override
	public void setAttivita(String attivita) {
		_utenteLavoro.setAttivita(attivita);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_utenteLavoro.setCachedModel(cachedModel);
	}

	/**
	 * Sets the documento of this utente lavoro.
	 *
	 * @param documento the documento of this utente lavoro
	 */
	@Override
	public void setDocumento(long documento) {
		_utenteLavoro.setDocumento(documento);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_utenteLavoro.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_utenteLavoro.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_utenteLavoro.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this utente lavoro.
	 *
	 * @param id the ID of this utente lavoro
	 */
	@Override
	public void setId(long id) {
		_utenteLavoro.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_utenteLavoro.setNew(n);
	}

	/**
	 * Sets the primary key of this utente lavoro.
	 *
	 * @param primaryKey the primary key of this utente lavoro
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_utenteLavoro.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_utenteLavoro.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the ts of this utente lavoro.
	 *
	 * @param ts the ts of this utente lavoro
	 */
	@Override
	public void setTs(Date ts) {
		_utenteLavoro.setTs(ts);
	}

	/**
	 * Sets the utente of this utente lavoro.
	 *
	 * @param utente the utente of this utente lavoro
	 */
	@Override
	public void setUtente(String utente) {
		_utenteLavoro.setUtente(utente);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<allerta.verifica.model.UtenteLavoro> toCacheModel() {

		return _utenteLavoro.toCacheModel();
	}

	@Override
	public allerta.verifica.model.UtenteLavoro toEscapedModel() {
		return new UtenteLavoroWrapper(_utenteLavoro.toEscapedModel());
	}

	@Override
	public String toString() {
		return _utenteLavoro.toString();
	}

	@Override
	public allerta.verifica.model.UtenteLavoro toUnescapedModel() {
		return new UtenteLavoroWrapper(_utenteLavoro.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _utenteLavoro.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UtenteLavoroWrapper)) {
			return false;
		}

		UtenteLavoroWrapper utenteLavoroWrapper = (UtenteLavoroWrapper)obj;

		if (Objects.equals(_utenteLavoro, utenteLavoroWrapper._utenteLavoro)) {
			return true;
		}

		return false;
	}

	@Override
	public UtenteLavoro getWrappedModel() {
		return _utenteLavoro;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _utenteLavoro.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _utenteLavoro.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_utenteLavoro.resetOriginalValues();
	}

	private final UtenteLavoro _utenteLavoro;

}