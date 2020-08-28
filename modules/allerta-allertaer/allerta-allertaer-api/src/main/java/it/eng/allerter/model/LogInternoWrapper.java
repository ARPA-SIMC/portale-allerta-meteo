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

package it.eng.allerter.model;

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
 * This class is a wrapper for {@link LogInterno}.
 * </p>
 *
 * @author GFAVINI
 * @see LogInterno
 * @generated
 */
@ProviderType
public class LogInternoWrapper implements LogInterno, ModelWrapper<LogInterno> {

	public LogInternoWrapper(LogInterno logInterno) {
		_logInterno = logInterno;
	}

	@Override
	public Class<?> getModelClass() {
		return LogInterno.class;
	}

	@Override
	public String getModelClassName() {
		return LogInterno.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("logId", getLogId());
		attributes.put("timestamp", getTimestamp());
		attributes.put("thread", getThread());
		attributes.put("cosa", getCosa());
		attributes.put("dettaglio", getDettaglio());
		attributes.put("utente", getUtente());
		attributes.put("risultato", getRisultato());
		attributes.put("eccezione", getEccezione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long logId = (Long)attributes.get("logId");

		if (logId != null) {
			setLogId(logId);
		}

		Date timestamp = (Date)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		String thread = (String)attributes.get("thread");

		if (thread != null) {
			setThread(thread);
		}

		String cosa = (String)attributes.get("cosa");

		if (cosa != null) {
			setCosa(cosa);
		}

		String dettaglio = (String)attributes.get("dettaglio");

		if (dettaglio != null) {
			setDettaglio(dettaglio);
		}

		String utente = (String)attributes.get("utente");

		if (utente != null) {
			setUtente(utente);
		}

		String risultato = (String)attributes.get("risultato");

		if (risultato != null) {
			setRisultato(risultato);
		}

		String eccezione = (String)attributes.get("eccezione");

		if (eccezione != null) {
			setEccezione(eccezione);
		}
	}

	@Override
	public Object clone() {
		return new LogInternoWrapper((LogInterno)_logInterno.clone());
	}

	@Override
	public int compareTo(it.eng.allerter.model.LogInterno logInterno) {
		return _logInterno.compareTo(logInterno);
	}

	/**
	 * Returns the cosa of this log interno.
	 *
	 * @return the cosa of this log interno
	 */
	@Override
	public String getCosa() {
		return _logInterno.getCosa();
	}

	/**
	 * Returns the dettaglio of this log interno.
	 *
	 * @return the dettaglio of this log interno
	 */
	@Override
	public String getDettaglio() {
		return _logInterno.getDettaglio();
	}

	/**
	 * Returns the eccezione of this log interno.
	 *
	 * @return the eccezione of this log interno
	 */
	@Override
	public String getEccezione() {
		return _logInterno.getEccezione();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _logInterno.getExpandoBridge();
	}

	/**
	 * Returns the log ID of this log interno.
	 *
	 * @return the log ID of this log interno
	 */
	@Override
	public long getLogId() {
		return _logInterno.getLogId();
	}

	/**
	 * Returns the primary key of this log interno.
	 *
	 * @return the primary key of this log interno
	 */
	@Override
	public long getPrimaryKey() {
		return _logInterno.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _logInterno.getPrimaryKeyObj();
	}

	/**
	 * Returns the risultato of this log interno.
	 *
	 * @return the risultato of this log interno
	 */
	@Override
	public String getRisultato() {
		return _logInterno.getRisultato();
	}

	/**
	 * Returns the thread of this log interno.
	 *
	 * @return the thread of this log interno
	 */
	@Override
	public String getThread() {
		return _logInterno.getThread();
	}

	/**
	 * Returns the timestamp of this log interno.
	 *
	 * @return the timestamp of this log interno
	 */
	@Override
	public Date getTimestamp() {
		return _logInterno.getTimestamp();
	}

	/**
	 * Returns the utente of this log interno.
	 *
	 * @return the utente of this log interno
	 */
	@Override
	public String getUtente() {
		return _logInterno.getUtente();
	}

	@Override
	public int hashCode() {
		return _logInterno.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _logInterno.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _logInterno.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _logInterno.isNew();
	}

	@Override
	public void persist() {
		_logInterno.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_logInterno.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cosa of this log interno.
	 *
	 * @param cosa the cosa of this log interno
	 */
	@Override
	public void setCosa(String cosa) {
		_logInterno.setCosa(cosa);
	}

	/**
	 * Sets the dettaglio of this log interno.
	 *
	 * @param dettaglio the dettaglio of this log interno
	 */
	@Override
	public void setDettaglio(String dettaglio) {
		_logInterno.setDettaglio(dettaglio);
	}

	/**
	 * Sets the eccezione of this log interno.
	 *
	 * @param eccezione the eccezione of this log interno
	 */
	@Override
	public void setEccezione(String eccezione) {
		_logInterno.setEccezione(eccezione);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_logInterno.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_logInterno.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_logInterno.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the log ID of this log interno.
	 *
	 * @param logId the log ID of this log interno
	 */
	@Override
	public void setLogId(long logId) {
		_logInterno.setLogId(logId);
	}

	@Override
	public void setNew(boolean n) {
		_logInterno.setNew(n);
	}

	/**
	 * Sets the primary key of this log interno.
	 *
	 * @param primaryKey the primary key of this log interno
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_logInterno.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_logInterno.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the risultato of this log interno.
	 *
	 * @param risultato the risultato of this log interno
	 */
	@Override
	public void setRisultato(String risultato) {
		_logInterno.setRisultato(risultato);
	}

	/**
	 * Sets the thread of this log interno.
	 *
	 * @param thread the thread of this log interno
	 */
	@Override
	public void setThread(String thread) {
		_logInterno.setThread(thread);
	}

	/**
	 * Sets the timestamp of this log interno.
	 *
	 * @param timestamp the timestamp of this log interno
	 */
	@Override
	public void setTimestamp(Date timestamp) {
		_logInterno.setTimestamp(timestamp);
	}

	/**
	 * Sets the utente of this log interno.
	 *
	 * @param utente the utente of this log interno
	 */
	@Override
	public void setUtente(String utente) {
		_logInterno.setUtente(utente);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.LogInterno> toCacheModel() {

		return _logInterno.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.LogInterno toEscapedModel() {
		return new LogInternoWrapper(_logInterno.toEscapedModel());
	}

	@Override
	public String toString() {
		return _logInterno.toString();
	}

	@Override
	public it.eng.allerter.model.LogInterno toUnescapedModel() {
		return new LogInternoWrapper(_logInterno.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _logInterno.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogInternoWrapper)) {
			return false;
		}

		LogInternoWrapper logInternoWrapper = (LogInternoWrapper)obj;

		if (Objects.equals(_logInterno, logInternoWrapper._logInterno)) {
			return true;
		}

		return false;
	}

	@Override
	public LogInterno getWrappedModel() {
		return _logInterno;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _logInterno.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _logInterno.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_logInterno.resetOriginalValues();
	}

	private final LogInterno _logInterno;

}