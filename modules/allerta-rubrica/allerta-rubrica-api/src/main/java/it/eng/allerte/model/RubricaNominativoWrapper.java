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
 * This class is a wrapper for {@link RubricaNominativo}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaNominativo
 * @generated
 */
@ProviderType
public class RubricaNominativoWrapper
	implements RubricaNominativo, ModelWrapper<RubricaNominativo> {

	public RubricaNominativoWrapper(RubricaNominativo rubricaNominativo) {
		_rubricaNominativo = rubricaNominativo;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaNominativo.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaNominativo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_NOMINATIVO", getID_NOMINATIVO());
		attributes.put("COGNOME", getCOGNOME());
		attributes.put("NOME", getNOME());
		attributes.put("INDIRIZZO", getINDIRIZZO());
		attributes.put("FK_SITO_PROPRIETARIO", getFK_SITO_PROPRIETARIO());
		attributes.put("FK_UTENTE_PORTALE", getFK_UTENTE_PORTALE());
		attributes.put("FK_UTENTE_CREAZIONE", getFK_UTENTE_CREAZIONE());
		attributes.put("DATA_CREAZIONE", getDATA_CREAZIONE());
		attributes.put("FK_UTENTE_MODIFICA", getFK_UTENTE_MODIFICA());
		attributes.put("DATA_MODIFICA", getDATA_MODIFICA());
		attributes.put("DISABLED", isDISABLED());
		attributes.put("MODIFICA_MINORE", isMODIFICA_MINORE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_NOMINATIVO = (Long)attributes.get("ID_NOMINATIVO");

		if (ID_NOMINATIVO != null) {
			setID_NOMINATIVO(ID_NOMINATIVO);
		}

		String COGNOME = (String)attributes.get("COGNOME");

		if (COGNOME != null) {
			setCOGNOME(COGNOME);
		}

		String NOME = (String)attributes.get("NOME");

		if (NOME != null) {
			setNOME(NOME);
		}

		String INDIRIZZO = (String)attributes.get("INDIRIZZO");

		if (INDIRIZZO != null) {
			setINDIRIZZO(INDIRIZZO);
		}

		Long FK_SITO_PROPRIETARIO = (Long)attributes.get(
			"FK_SITO_PROPRIETARIO");

		if (FK_SITO_PROPRIETARIO != null) {
			setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);
		}

		Long FK_UTENTE_PORTALE = (Long)attributes.get("FK_UTENTE_PORTALE");

		if (FK_UTENTE_PORTALE != null) {
			setFK_UTENTE_PORTALE(FK_UTENTE_PORTALE);
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

		Boolean MODIFICA_MINORE = (Boolean)attributes.get("MODIFICA_MINORE");

		if (MODIFICA_MINORE != null) {
			setMODIFICA_MINORE(MODIFICA_MINORE);
		}
	}

	@Override
	public Object clone() {
		return new RubricaNominativoWrapper(
			(RubricaNominativo)_rubricaNominativo.clone());
	}

	@Override
	public int compareTo(
		it.eng.allerte.model.RubricaNominativo rubricaNominativo) {

		return _rubricaNominativo.compareTo(rubricaNominativo);
	}

	/**
	 * Returns the cognome of this rubrica nominativo.
	 *
	 * @return the cognome of this rubrica nominativo
	 */
	@Override
	public String getCOGNOME() {
		return _rubricaNominativo.getCOGNOME();
	}

	/**
	 * Returns the data_creazione of this rubrica nominativo.
	 *
	 * @return the data_creazione of this rubrica nominativo
	 */
	@Override
	public Date getDATA_CREAZIONE() {
		return _rubricaNominativo.getDATA_CREAZIONE();
	}

	/**
	 * Returns the data_modifica of this rubrica nominativo.
	 *
	 * @return the data_modifica of this rubrica nominativo
	 */
	@Override
	public Date getDATA_MODIFICA() {
		return _rubricaNominativo.getDATA_MODIFICA();
	}

	/**
	 * Returns the disabled of this rubrica nominativo.
	 *
	 * @return the disabled of this rubrica nominativo
	 */
	@Override
	public boolean getDISABLED() {
		return _rubricaNominativo.getDISABLED();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaNominativo.getExpandoBridge();
	}

	/**
	 * Returns the fk_sito_proprietario of this rubrica nominativo.
	 *
	 * @return the fk_sito_proprietario of this rubrica nominativo
	 */
	@Override
	public long getFK_SITO_PROPRIETARIO() {
		return _rubricaNominativo.getFK_SITO_PROPRIETARIO();
	}

	/**
	 * Returns the fk_utente_creazione of this rubrica nominativo.
	 *
	 * @return the fk_utente_creazione of this rubrica nominativo
	 */
	@Override
	public long getFK_UTENTE_CREAZIONE() {
		return _rubricaNominativo.getFK_UTENTE_CREAZIONE();
	}

	/**
	 * Returns the fk_utente_modifica of this rubrica nominativo.
	 *
	 * @return the fk_utente_modifica of this rubrica nominativo
	 */
	@Override
	public long getFK_UTENTE_MODIFICA() {
		return _rubricaNominativo.getFK_UTENTE_MODIFICA();
	}

	/**
	 * Returns the fk_utente_portale of this rubrica nominativo.
	 *
	 * @return the fk_utente_portale of this rubrica nominativo
	 */
	@Override
	public long getFK_UTENTE_PORTALE() {
		return _rubricaNominativo.getFK_UTENTE_PORTALE();
	}

	/**
	 * Returns the id_nominativo of this rubrica nominativo.
	 *
	 * @return the id_nominativo of this rubrica nominativo
	 */
	@Override
	public long getID_NOMINATIVO() {
		return _rubricaNominativo.getID_NOMINATIVO();
	}

	/**
	 * Returns the indirizzo of this rubrica nominativo.
	 *
	 * @return the indirizzo of this rubrica nominativo
	 */
	@Override
	public String getINDIRIZZO() {
		return _rubricaNominativo.getINDIRIZZO();
	}

	/**
	 * Returns the modifica_minore of this rubrica nominativo.
	 *
	 * @return the modifica_minore of this rubrica nominativo
	 */
	@Override
	public boolean getMODIFICA_MINORE() {
		return _rubricaNominativo.getMODIFICA_MINORE();
	}

	/**
	 * Returns the nome of this rubrica nominativo.
	 *
	 * @return the nome of this rubrica nominativo
	 */
	@Override
	public String getNOME() {
		return _rubricaNominativo.getNOME();
	}

	/**
	 * Returns the primary key of this rubrica nominativo.
	 *
	 * @return the primary key of this rubrica nominativo
	 */
	@Override
	public long getPrimaryKey() {
		return _rubricaNominativo.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaNominativo.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _rubricaNominativo.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaNominativo.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this rubrica nominativo is disabled.
	 *
	 * @return <code>true</code> if this rubrica nominativo is disabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isDISABLED() {
		return _rubricaNominativo.isDISABLED();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaNominativo.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this rubrica nominativo is modifica_minore.
	 *
	 * @return <code>true</code> if this rubrica nominativo is modifica_minore; <code>false</code> otherwise
	 */
	@Override
	public boolean isMODIFICA_MINORE() {
		return _rubricaNominativo.isMODIFICA_MINORE();
	}

	@Override
	public boolean isNew() {
		return _rubricaNominativo.isNew();
	}

	@Override
	public void persist() {
		_rubricaNominativo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaNominativo.setCachedModel(cachedModel);
	}

	/**
	 * Sets the cognome of this rubrica nominativo.
	 *
	 * @param COGNOME the cognome of this rubrica nominativo
	 */
	@Override
	public void setCOGNOME(String COGNOME) {
		_rubricaNominativo.setCOGNOME(COGNOME);
	}

	/**
	 * Sets the data_creazione of this rubrica nominativo.
	 *
	 * @param DATA_CREAZIONE the data_creazione of this rubrica nominativo
	 */
	@Override
	public void setDATA_CREAZIONE(Date DATA_CREAZIONE) {
		_rubricaNominativo.setDATA_CREAZIONE(DATA_CREAZIONE);
	}

	/**
	 * Sets the data_modifica of this rubrica nominativo.
	 *
	 * @param DATA_MODIFICA the data_modifica of this rubrica nominativo
	 */
	@Override
	public void setDATA_MODIFICA(Date DATA_MODIFICA) {
		_rubricaNominativo.setDATA_MODIFICA(DATA_MODIFICA);
	}

	/**
	 * Sets whether this rubrica nominativo is disabled.
	 *
	 * @param DISABLED the disabled of this rubrica nominativo
	 */
	@Override
	public void setDISABLED(boolean DISABLED) {
		_rubricaNominativo.setDISABLED(DISABLED);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaNominativo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaNominativo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaNominativo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fk_sito_proprietario of this rubrica nominativo.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario of this rubrica nominativo
	 */
	@Override
	public void setFK_SITO_PROPRIETARIO(long FK_SITO_PROPRIETARIO) {
		_rubricaNominativo.setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);
	}

	/**
	 * Sets the fk_utente_creazione of this rubrica nominativo.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione of this rubrica nominativo
	 */
	@Override
	public void setFK_UTENTE_CREAZIONE(long FK_UTENTE_CREAZIONE) {
		_rubricaNominativo.setFK_UTENTE_CREAZIONE(FK_UTENTE_CREAZIONE);
	}

	/**
	 * Sets the fk_utente_modifica of this rubrica nominativo.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica of this rubrica nominativo
	 */
	@Override
	public void setFK_UTENTE_MODIFICA(long FK_UTENTE_MODIFICA) {
		_rubricaNominativo.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);
	}

	/**
	 * Sets the fk_utente_portale of this rubrica nominativo.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale of this rubrica nominativo
	 */
	@Override
	public void setFK_UTENTE_PORTALE(long FK_UTENTE_PORTALE) {
		_rubricaNominativo.setFK_UTENTE_PORTALE(FK_UTENTE_PORTALE);
	}

	/**
	 * Sets the id_nominativo of this rubrica nominativo.
	 *
	 * @param ID_NOMINATIVO the id_nominativo of this rubrica nominativo
	 */
	@Override
	public void setID_NOMINATIVO(long ID_NOMINATIVO) {
		_rubricaNominativo.setID_NOMINATIVO(ID_NOMINATIVO);
	}

	/**
	 * Sets the indirizzo of this rubrica nominativo.
	 *
	 * @param INDIRIZZO the indirizzo of this rubrica nominativo
	 */
	@Override
	public void setINDIRIZZO(String INDIRIZZO) {
		_rubricaNominativo.setINDIRIZZO(INDIRIZZO);
	}

	/**
	 * Sets whether this rubrica nominativo is modifica_minore.
	 *
	 * @param MODIFICA_MINORE the modifica_minore of this rubrica nominativo
	 */
	@Override
	public void setMODIFICA_MINORE(boolean MODIFICA_MINORE) {
		_rubricaNominativo.setMODIFICA_MINORE(MODIFICA_MINORE);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaNominativo.setNew(n);
	}

	/**
	 * Sets the nome of this rubrica nominativo.
	 *
	 * @param NOME the nome of this rubrica nominativo
	 */
	@Override
	public void setNOME(String NOME) {
		_rubricaNominativo.setNOME(NOME);
	}

	/**
	 * Sets the primary key of this rubrica nominativo.
	 *
	 * @param primaryKey the primary key of this rubrica nominativo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rubricaNominativo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaNominativo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaNominativo> toCacheModel() {

		return _rubricaNominativo.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaNominativo toEscapedModel() {
		return new RubricaNominativoWrapper(
			_rubricaNominativo.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaNominativo.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaNominativo toUnescapedModel() {
		return new RubricaNominativoWrapper(
			_rubricaNominativo.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaNominativo.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaNominativoWrapper)) {
			return false;
		}

		RubricaNominativoWrapper rubricaNominativoWrapper =
			(RubricaNominativoWrapper)obj;

		if (Objects.equals(
				_rubricaNominativo,
				rubricaNominativoWrapper._rubricaNominativo)) {

			return true;
		}

		return false;
	}

	@Override
	public RubricaNominativo getWrappedModel() {
		return _rubricaNominativo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaNominativo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaNominativo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaNominativo.resetOriginalValues();
	}

	private final RubricaNominativo _rubricaNominativo;

}