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

package it.eng.allerte.model;

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
 * This class is a wrapper for {@link RubricaLog}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaLog
 * @generated
 */
@ProviderType
public class RubricaLogWrapper implements RubricaLog, ModelWrapper<RubricaLog> {

	public RubricaLogWrapper(RubricaLog rubricaLog) {
		_rubricaLog = rubricaLog;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaLog.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_LOG", getID_LOG());
		attributes.put("FK_SITO_PROPRIETARIO", getFK_SITO_PROPRIETARIO());
		attributes.put("TABELLA", getTABELLA());
		attributes.put("TIPO_OPERAZIONE", getTIPO_OPERAZIONE());
		attributes.put("ID_OGGETTO", getID_OGGETTO());
		attributes.put("NUOVA_DESCRIZIONE", getNUOVA_DESCRIZIONE());
		attributes.put("FK_UTENTE_MODIFICA", getFK_UTENTE_MODIFICA());
		attributes.put("DATA_MODIFICA", getDATA_MODIFICA());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_LOG = (Long)attributes.get("ID_LOG");

		if (ID_LOG != null) {
			setID_LOG(ID_LOG);
		}

		Long FK_SITO_PROPRIETARIO = (Long)attributes.get(
			"FK_SITO_PROPRIETARIO");

		if (FK_SITO_PROPRIETARIO != null) {
			setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);
		}

		String TABELLA = (String)attributes.get("TABELLA");

		if (TABELLA != null) {
			setTABELLA(TABELLA);
		}

		String TIPO_OPERAZIONE = (String)attributes.get("TIPO_OPERAZIONE");

		if (TIPO_OPERAZIONE != null) {
			setTIPO_OPERAZIONE(TIPO_OPERAZIONE);
		}

		String ID_OGGETTO = (String)attributes.get("ID_OGGETTO");

		if (ID_OGGETTO != null) {
			setID_OGGETTO(ID_OGGETTO);
		}

		String NUOVA_DESCRIZIONE = (String)attributes.get("NUOVA_DESCRIZIONE");

		if (NUOVA_DESCRIZIONE != null) {
			setNUOVA_DESCRIZIONE(NUOVA_DESCRIZIONE);
		}

		Long FK_UTENTE_MODIFICA = (Long)attributes.get("FK_UTENTE_MODIFICA");

		if (FK_UTENTE_MODIFICA != null) {
			setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);
		}

		Date DATA_MODIFICA = (Date)attributes.get("DATA_MODIFICA");

		if (DATA_MODIFICA != null) {
			setDATA_MODIFICA(DATA_MODIFICA);
		}
	}

	@Override
	public Object clone() {
		return new RubricaLogWrapper((RubricaLog)_rubricaLog.clone());
	}

	@Override
	public int compareTo(it.eng.allerte.model.RubricaLog rubricaLog) {
		return _rubricaLog.compareTo(rubricaLog);
	}

	/**
	 * Returns the data_modifica of this rubrica log.
	 *
	 * @return the data_modifica of this rubrica log
	 */
	@Override
	public Date getDATA_MODIFICA() {
		return _rubricaLog.getDATA_MODIFICA();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaLog.getExpandoBridge();
	}

	/**
	 * Returns the fk_sito_proprietario of this rubrica log.
	 *
	 * @return the fk_sito_proprietario of this rubrica log
	 */
	@Override
	public long getFK_SITO_PROPRIETARIO() {
		return _rubricaLog.getFK_SITO_PROPRIETARIO();
	}

	/**
	 * Returns the fk_utente_modifica of this rubrica log.
	 *
	 * @return the fk_utente_modifica of this rubrica log
	 */
	@Override
	public long getFK_UTENTE_MODIFICA() {
		return _rubricaLog.getFK_UTENTE_MODIFICA();
	}

	/**
	 * Returns the id_log of this rubrica log.
	 *
	 * @return the id_log of this rubrica log
	 */
	@Override
	public long getID_LOG() {
		return _rubricaLog.getID_LOG();
	}

	/**
	 * Returns the id_oggetto of this rubrica log.
	 *
	 * @return the id_oggetto of this rubrica log
	 */
	@Override
	public String getID_OGGETTO() {
		return _rubricaLog.getID_OGGETTO();
	}

	/**
	 * Returns the nuova_descrizione of this rubrica log.
	 *
	 * @return the nuova_descrizione of this rubrica log
	 */
	@Override
	public String getNUOVA_DESCRIZIONE() {
		return _rubricaLog.getNUOVA_DESCRIZIONE();
	}

	/**
	 * Returns the primary key of this rubrica log.
	 *
	 * @return the primary key of this rubrica log
	 */
	@Override
	public long getPrimaryKey() {
		return _rubricaLog.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaLog.getPrimaryKeyObj();
	}

	/**
	 * Returns the tabella of this rubrica log.
	 *
	 * @return the tabella of this rubrica log
	 */
	@Override
	public String getTABELLA() {
		return _rubricaLog.getTABELLA();
	}

	/**
	 * Returns the tipo_operazione of this rubrica log.
	 *
	 * @return the tipo_operazione of this rubrica log
	 */
	@Override
	public String getTIPO_OPERAZIONE() {
		return _rubricaLog.getTIPO_OPERAZIONE();
	}

	@Override
	public int hashCode() {
		return _rubricaLog.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaLog.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaLog.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaLog.isNew();
	}

	@Override
	public void persist() {
		_rubricaLog.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaLog.setCachedModel(cachedModel);
	}

	/**
	 * Sets the data_modifica of this rubrica log.
	 *
	 * @param DATA_MODIFICA the data_modifica of this rubrica log
	 */
	@Override
	public void setDATA_MODIFICA(Date DATA_MODIFICA) {
		_rubricaLog.setDATA_MODIFICA(DATA_MODIFICA);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaLog.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fk_sito_proprietario of this rubrica log.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario of this rubrica log
	 */
	@Override
	public void setFK_SITO_PROPRIETARIO(long FK_SITO_PROPRIETARIO) {
		_rubricaLog.setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);
	}

	/**
	 * Sets the fk_utente_modifica of this rubrica log.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica of this rubrica log
	 */
	@Override
	public void setFK_UTENTE_MODIFICA(long FK_UTENTE_MODIFICA) {
		_rubricaLog.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);
	}

	/**
	 * Sets the id_log of this rubrica log.
	 *
	 * @param ID_LOG the id_log of this rubrica log
	 */
	@Override
	public void setID_LOG(long ID_LOG) {
		_rubricaLog.setID_LOG(ID_LOG);
	}

	/**
	 * Sets the id_oggetto of this rubrica log.
	 *
	 * @param ID_OGGETTO the id_oggetto of this rubrica log
	 */
	@Override
	public void setID_OGGETTO(String ID_OGGETTO) {
		_rubricaLog.setID_OGGETTO(ID_OGGETTO);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaLog.setNew(n);
	}

	/**
	 * Sets the nuova_descrizione of this rubrica log.
	 *
	 * @param NUOVA_DESCRIZIONE the nuova_descrizione of this rubrica log
	 */
	@Override
	public void setNUOVA_DESCRIZIONE(String NUOVA_DESCRIZIONE) {
		_rubricaLog.setNUOVA_DESCRIZIONE(NUOVA_DESCRIZIONE);
	}

	/**
	 * Sets the primary key of this rubrica log.
	 *
	 * @param primaryKey the primary key of this rubrica log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rubricaLog.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaLog.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the tabella of this rubrica log.
	 *
	 * @param TABELLA the tabella of this rubrica log
	 */
	@Override
	public void setTABELLA(String TABELLA) {
		_rubricaLog.setTABELLA(TABELLA);
	}

	/**
	 * Sets the tipo_operazione of this rubrica log.
	 *
	 * @param TIPO_OPERAZIONE the tipo_operazione of this rubrica log
	 */
	@Override
	public void setTIPO_OPERAZIONE(String TIPO_OPERAZIONE) {
		_rubricaLog.setTIPO_OPERAZIONE(TIPO_OPERAZIONE);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaLog> toCacheModel() {

		return _rubricaLog.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaLog toEscapedModel() {
		return new RubricaLogWrapper(_rubricaLog.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaLog.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaLog toUnescapedModel() {
		return new RubricaLogWrapper(_rubricaLog.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaLog.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaLogWrapper)) {
			return false;
		}

		RubricaLogWrapper rubricaLogWrapper = (RubricaLogWrapper)obj;

		if (Objects.equals(_rubricaLog, rubricaLogWrapper._rubricaLog)) {
			return true;
		}

		return false;
	}

	@Override
	public RubricaLog getWrappedModel() {
		return _rubricaLog;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaLog.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaLog.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaLog.resetOriginalValues();
	}

	private final RubricaLog _rubricaLog;

}