/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LogInterno}.
 * </p>
 *
 * @author GFAVINI
 * @see LogInterno
 * @generated
 */
public class LogInternoWrapper
	extends BaseModelWrapper<LogInterno>
	implements LogInterno, ModelWrapper<LogInterno> {

	public LogInternoWrapper(LogInterno logInterno) {
		super(logInterno);
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
	public LogInterno cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the cosa of this log interno.
	 *
	 * @return the cosa of this log interno
	 */
	@Override
	public String getCosa() {
		return model.getCosa();
	}

	/**
	 * Returns the dettaglio of this log interno.
	 *
	 * @return the dettaglio of this log interno
	 */
	@Override
	public String getDettaglio() {
		return model.getDettaglio();
	}

	/**
	 * Returns the eccezione of this log interno.
	 *
	 * @return the eccezione of this log interno
	 */
	@Override
	public String getEccezione() {
		return model.getEccezione();
	}

	/**
	 * Returns the log ID of this log interno.
	 *
	 * @return the log ID of this log interno
	 */
	@Override
	public long getLogId() {
		return model.getLogId();
	}

	/**
	 * Returns the primary key of this log interno.
	 *
	 * @return the primary key of this log interno
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the risultato of this log interno.
	 *
	 * @return the risultato of this log interno
	 */
	@Override
	public String getRisultato() {
		return model.getRisultato();
	}

	/**
	 * Returns the thread of this log interno.
	 *
	 * @return the thread of this log interno
	 */
	@Override
	public String getThread() {
		return model.getThread();
	}

	/**
	 * Returns the timestamp of this log interno.
	 *
	 * @return the timestamp of this log interno
	 */
	@Override
	public Date getTimestamp() {
		return model.getTimestamp();
	}

	/**
	 * Returns the utente of this log interno.
	 *
	 * @return the utente of this log interno
	 */
	@Override
	public String getUtente() {
		return model.getUtente();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cosa of this log interno.
	 *
	 * @param cosa the cosa of this log interno
	 */
	@Override
	public void setCosa(String cosa) {
		model.setCosa(cosa);
	}

	/**
	 * Sets the dettaglio of this log interno.
	 *
	 * @param dettaglio the dettaglio of this log interno
	 */
	@Override
	public void setDettaglio(String dettaglio) {
		model.setDettaglio(dettaglio);
	}

	/**
	 * Sets the eccezione of this log interno.
	 *
	 * @param eccezione the eccezione of this log interno
	 */
	@Override
	public void setEccezione(String eccezione) {
		model.setEccezione(eccezione);
	}

	/**
	 * Sets the log ID of this log interno.
	 *
	 * @param logId the log ID of this log interno
	 */
	@Override
	public void setLogId(long logId) {
		model.setLogId(logId);
	}

	/**
	 * Sets the primary key of this log interno.
	 *
	 * @param primaryKey the primary key of this log interno
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the risultato of this log interno.
	 *
	 * @param risultato the risultato of this log interno
	 */
	@Override
	public void setRisultato(String risultato) {
		model.setRisultato(risultato);
	}

	/**
	 * Sets the thread of this log interno.
	 *
	 * @param thread the thread of this log interno
	 */
	@Override
	public void setThread(String thread) {
		model.setThread(thread);
	}

	/**
	 * Sets the timestamp of this log interno.
	 *
	 * @param timestamp the timestamp of this log interno
	 */
	@Override
	public void setTimestamp(Date timestamp) {
		model.setTimestamp(timestamp);
	}

	/**
	 * Sets the utente of this log interno.
	 *
	 * @param utente the utente of this log interno
	 */
	@Override
	public void setUtente(String utente) {
		model.setUtente(utente);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected LogInternoWrapper wrap(LogInterno logInterno) {
		return new LogInternoWrapper(logInterno);
	}

}