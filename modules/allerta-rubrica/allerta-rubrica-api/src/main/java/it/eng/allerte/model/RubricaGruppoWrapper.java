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
 * This class is a wrapper for {@link RubricaGruppo}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppo
 * @generated
 */
@ProviderType
public class RubricaGruppoWrapper
	implements RubricaGruppo, ModelWrapper<RubricaGruppo> {

	public RubricaGruppoWrapper(RubricaGruppo rubricaGruppo) {
		_rubricaGruppo = rubricaGruppo;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaGruppo.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaGruppo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_GRUPPO", getID_GRUPPO());
		attributes.put("NOME", getNOME());
		attributes.put("FK_SITO_PROPRIETARIO", getFK_SITO_PROPRIETARIO());
		attributes.put("NOTE", getNOTE());
		attributes.put("FK_UTENTE_CREAZIONE", getFK_UTENTE_CREAZIONE());
		attributes.put("DATA_CREAZIONE", getDATA_CREAZIONE());
		attributes.put("FK_UTENTE_MODIFICA", getFK_UTENTE_MODIFICA());
		attributes.put("DATA_MODIFICA", getDATA_MODIFICA());
		attributes.put("DISABLED", isDISABLED());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_GRUPPO = (Long)attributes.get("ID_GRUPPO");

		if (ID_GRUPPO != null) {
			setID_GRUPPO(ID_GRUPPO);
		}

		String NOME = (String)attributes.get("NOME");

		if (NOME != null) {
			setNOME(NOME);
		}

		Long FK_SITO_PROPRIETARIO = (Long)attributes.get(
			"FK_SITO_PROPRIETARIO");

		if (FK_SITO_PROPRIETARIO != null) {
			setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);
		}

		String NOTE = (String)attributes.get("NOTE");

		if (NOTE != null) {
			setNOTE(NOTE);
		}

		Long FK_UTENTE_CREAZIONE = (Long)attributes.get("FK_UTENTE_CREAZIONE");

		if (FK_UTENTE_CREAZIONE != null) {
			setFK_UTENTE_CREAZIONE(FK_UTENTE_CREAZIONE);
		}

		Date DATA_CREAZIONE = (Date)attributes.get("DATA_CREAZIONE");

		if (DATA_CREAZIONE != null) {
			setDATA_CREAZIONE(DATA_CREAZIONE);
		}

		Long FK_UTENTE_MODIFICA = (Long)attributes.get("FK_UTENTE_MODIFICA");

		if (FK_UTENTE_MODIFICA != null) {
			setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);
		}

		Date DATA_MODIFICA = (Date)attributes.get("DATA_MODIFICA");

		if (DATA_MODIFICA != null) {
			setDATA_MODIFICA(DATA_MODIFICA);
		}

		Boolean DISABLED = (Boolean)attributes.get("DISABLED");

		if (DISABLED != null) {
			setDISABLED(DISABLED);
		}
	}

	@Override
	public Object clone() {
		return new RubricaGruppoWrapper((RubricaGruppo)_rubricaGruppo.clone());
	}

	@Override
	public int compareTo(it.eng.allerte.model.RubricaGruppo rubricaGruppo) {
		return _rubricaGruppo.compareTo(rubricaGruppo);
	}

	/**
	 * Returns the data_creazione of this rubrica gruppo.
	 *
	 * @return the data_creazione of this rubrica gruppo
	 */
	@Override
	public Date getDATA_CREAZIONE() {
		return _rubricaGruppo.getDATA_CREAZIONE();
	}

	/**
	 * Returns the data_modifica of this rubrica gruppo.
	 *
	 * @return the data_modifica of this rubrica gruppo
	 */
	@Override
	public Date getDATA_MODIFICA() {
		return _rubricaGruppo.getDATA_MODIFICA();
	}

	/**
	 * Returns the disabled of this rubrica gruppo.
	 *
	 * @return the disabled of this rubrica gruppo
	 */
	@Override
	public boolean getDISABLED() {
		return _rubricaGruppo.getDISABLED();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaGruppo.getExpandoBridge();
	}

	/**
	 * Returns the fk_sito_proprietario of this rubrica gruppo.
	 *
	 * @return the fk_sito_proprietario of this rubrica gruppo
	 */
	@Override
	public long getFK_SITO_PROPRIETARIO() {
		return _rubricaGruppo.getFK_SITO_PROPRIETARIO();
	}

	/**
	 * Returns the fk_utente_creazione of this rubrica gruppo.
	 *
	 * @return the fk_utente_creazione of this rubrica gruppo
	 */
	@Override
	public long getFK_UTENTE_CREAZIONE() {
		return _rubricaGruppo.getFK_UTENTE_CREAZIONE();
	}

	/**
	 * Returns the fk_utente_modifica of this rubrica gruppo.
	 *
	 * @return the fk_utente_modifica of this rubrica gruppo
	 */
	@Override
	public long getFK_UTENTE_MODIFICA() {
		return _rubricaGruppo.getFK_UTENTE_MODIFICA();
	}

	/**
	 * Returns the id_gruppo of this rubrica gruppo.
	 *
	 * @return the id_gruppo of this rubrica gruppo
	 */
	@Override
	public long getID_GRUPPO() {
		return _rubricaGruppo.getID_GRUPPO();
	}

	/**
	 * Returns the nome of this rubrica gruppo.
	 *
	 * @return the nome of this rubrica gruppo
	 */
	@Override
	public String getNOME() {
		return _rubricaGruppo.getNOME();
	}

	/**
	 * Returns the note of this rubrica gruppo.
	 *
	 * @return the note of this rubrica gruppo
	 */
	@Override
	public String getNOTE() {
		return _rubricaGruppo.getNOTE();
	}

	/**
	 * Returns the primary key of this rubrica gruppo.
	 *
	 * @return the primary key of this rubrica gruppo
	 */
	@Override
	public long getPrimaryKey() {
		return _rubricaGruppo.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaGruppo.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _rubricaGruppo.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaGruppo.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this rubrica gruppo is disabled.
	 *
	 * @return <code>true</code> if this rubrica gruppo is disabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isDISABLED() {
		return _rubricaGruppo.isDISABLED();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaGruppo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _rubricaGruppo.isNew();
	}

	@Override
	public void persist() {
		_rubricaGruppo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaGruppo.setCachedModel(cachedModel);
	}

	/**
	 * Sets the data_creazione of this rubrica gruppo.
	 *
	 * @param DATA_CREAZIONE the data_creazione of this rubrica gruppo
	 */
	@Override
	public void setDATA_CREAZIONE(Date DATA_CREAZIONE) {
		_rubricaGruppo.setDATA_CREAZIONE(DATA_CREAZIONE);
	}

	/**
	 * Sets the data_modifica of this rubrica gruppo.
	 *
	 * @param DATA_MODIFICA the data_modifica of this rubrica gruppo
	 */
	@Override
	public void setDATA_MODIFICA(Date DATA_MODIFICA) {
		_rubricaGruppo.setDATA_MODIFICA(DATA_MODIFICA);
	}

	/**
	 * Sets whether this rubrica gruppo is disabled.
	 *
	 * @param DISABLED the disabled of this rubrica gruppo
	 */
	@Override
	public void setDISABLED(boolean DISABLED) {
		_rubricaGruppo.setDISABLED(DISABLED);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaGruppo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaGruppo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaGruppo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fk_sito_proprietario of this rubrica gruppo.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario of this rubrica gruppo
	 */
	@Override
	public void setFK_SITO_PROPRIETARIO(long FK_SITO_PROPRIETARIO) {
		_rubricaGruppo.setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);
	}

	/**
	 * Sets the fk_utente_creazione of this rubrica gruppo.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione of this rubrica gruppo
	 */
	@Override
	public void setFK_UTENTE_CREAZIONE(long FK_UTENTE_CREAZIONE) {
		_rubricaGruppo.setFK_UTENTE_CREAZIONE(FK_UTENTE_CREAZIONE);
	}

	/**
	 * Sets the fk_utente_modifica of this rubrica gruppo.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica of this rubrica gruppo
	 */
	@Override
	public void setFK_UTENTE_MODIFICA(long FK_UTENTE_MODIFICA) {
		_rubricaGruppo.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);
	}

	/**
	 * Sets the id_gruppo of this rubrica gruppo.
	 *
	 * @param ID_GRUPPO the id_gruppo of this rubrica gruppo
	 */
	@Override
	public void setID_GRUPPO(long ID_GRUPPO) {
		_rubricaGruppo.setID_GRUPPO(ID_GRUPPO);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaGruppo.setNew(n);
	}

	/**
	 * Sets the nome of this rubrica gruppo.
	 *
	 * @param NOME the nome of this rubrica gruppo
	 */
	@Override
	public void setNOME(String NOME) {
		_rubricaGruppo.setNOME(NOME);
	}

	/**
	 * Sets the note of this rubrica gruppo.
	 *
	 * @param NOTE the note of this rubrica gruppo
	 */
	@Override
	public void setNOTE(String NOTE) {
		_rubricaGruppo.setNOTE(NOTE);
	}

	/**
	 * Sets the primary key of this rubrica gruppo.
	 *
	 * @param primaryKey the primary key of this rubrica gruppo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rubricaGruppo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaGruppo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaGruppo> toCacheModel() {

		return _rubricaGruppo.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaGruppo toEscapedModel() {
		return new RubricaGruppoWrapper(_rubricaGruppo.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaGruppo.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaGruppo toUnescapedModel() {
		return new RubricaGruppoWrapper(_rubricaGruppo.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaGruppo.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaGruppoWrapper)) {
			return false;
		}

		RubricaGruppoWrapper rubricaGruppoWrapper = (RubricaGruppoWrapper)obj;

		if (Objects.equals(
				_rubricaGruppo, rubricaGruppoWrapper._rubricaGruppo)) {

			return true;
		}

		return false;
	}

	@Override
	public RubricaGruppo getWrappedModel() {
		return _rubricaGruppo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaGruppo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaGruppo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaGruppo.resetOriginalValues();
	}

	private final RubricaGruppo _rubricaGruppo;

}