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
 * This class is a wrapper for {@link RubricaContatto}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaContatto
 * @generated
 */
@ProviderType
public class RubricaContattoWrapper
	implements RubricaContatto, ModelWrapper<RubricaContatto> {

	public RubricaContattoWrapper(RubricaContatto rubricaContatto) {
		_rubricaContatto = rubricaContatto;
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaContatto.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaContatto.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_CONTATTO", getID_CONTATTO());
		attributes.put("FK_NOMINATIVO", getFK_NOMINATIVO());
		attributes.put("FK_CANALE", getFK_CANALE());
		attributes.put("CONTATTO", getCONTATTO());
		attributes.put("ALLERTAMENTO", isALLERTAMENTO());
		attributes.put("FK_UTENTE_CREAZIONE", getFK_UTENTE_CREAZIONE());
		attributes.put("DATA_CREAZIONE", getDATA_CREAZIONE());
		attributes.put("FK_UTENTE_MODIFICA", getFK_UTENTE_MODIFICA());
		attributes.put("DATA_MODIFICA", getDATA_MODIFICA());
		attributes.put("DATA_FINE_VALIDITA", getDATA_FINE_VALIDITA());
		attributes.put("MODIFICA_MINORE", isMODIFICA_MINORE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_CONTATTO = (Long)attributes.get("ID_CONTATTO");

		if (ID_CONTATTO != null) {
			setID_CONTATTO(ID_CONTATTO);
		}

		Long FK_NOMINATIVO = (Long)attributes.get("FK_NOMINATIVO");

		if (FK_NOMINATIVO != null) {
			setFK_NOMINATIVO(FK_NOMINATIVO);
		}

		Long FK_CANALE = (Long)attributes.get("FK_CANALE");

		if (FK_CANALE != null) {
			setFK_CANALE(FK_CANALE);
		}

		String CONTATTO = (String)attributes.get("CONTATTO");

		if (CONTATTO != null) {
			setCONTATTO(CONTATTO);
		}

		Boolean ALLERTAMENTO = (Boolean)attributes.get("ALLERTAMENTO");

		if (ALLERTAMENTO != null) {
			setALLERTAMENTO(ALLERTAMENTO);
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

		Date DATA_FINE_VALIDITA = (Date)attributes.get("DATA_FINE_VALIDITA");

		if (DATA_FINE_VALIDITA != null) {
			setDATA_FINE_VALIDITA(DATA_FINE_VALIDITA);
		}

		Boolean MODIFICA_MINORE = (Boolean)attributes.get("MODIFICA_MINORE");

		if (MODIFICA_MINORE != null) {
			setMODIFICA_MINORE(MODIFICA_MINORE);
		}
	}

	@Override
	public Object clone() {
		return new RubricaContattoWrapper(
			(RubricaContatto)_rubricaContatto.clone());
	}

	@Override
	public int compareTo(it.eng.allerte.model.RubricaContatto rubricaContatto) {
		return _rubricaContatto.compareTo(rubricaContatto);
	}

	/**
	 * Returns the allertamento of this rubrica contatto.
	 *
	 * @return the allertamento of this rubrica contatto
	 */
	@Override
	public boolean getALLERTAMENTO() {
		return _rubricaContatto.getALLERTAMENTO();
	}

	/**
	 * Returns the contatto of this rubrica contatto.
	 *
	 * @return the contatto of this rubrica contatto
	 */
	@Override
	public String getCONTATTO() {
		return _rubricaContatto.getCONTATTO();
	}

	/**
	 * Returns the data_creazione of this rubrica contatto.
	 *
	 * @return the data_creazione of this rubrica contatto
	 */
	@Override
	public Date getDATA_CREAZIONE() {
		return _rubricaContatto.getDATA_CREAZIONE();
	}

	/**
	 * Returns the data_fine_validita of this rubrica contatto.
	 *
	 * @return the data_fine_validita of this rubrica contatto
	 */
	@Override
	public Date getDATA_FINE_VALIDITA() {
		return _rubricaContatto.getDATA_FINE_VALIDITA();
	}

	/**
	 * Returns the data_modifica of this rubrica contatto.
	 *
	 * @return the data_modifica of this rubrica contatto
	 */
	@Override
	public Date getDATA_MODIFICA() {
		return _rubricaContatto.getDATA_MODIFICA();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _rubricaContatto.getExpandoBridge();
	}

	/**
	 * Returns the fk_canale of this rubrica contatto.
	 *
	 * @return the fk_canale of this rubrica contatto
	 */
	@Override
	public long getFK_CANALE() {
		return _rubricaContatto.getFK_CANALE();
	}

	/**
	 * Returns the fk_nominativo of this rubrica contatto.
	 *
	 * @return the fk_nominativo of this rubrica contatto
	 */
	@Override
	public long getFK_NOMINATIVO() {
		return _rubricaContatto.getFK_NOMINATIVO();
	}

	/**
	 * Returns the fk_utente_creazione of this rubrica contatto.
	 *
	 * @return the fk_utente_creazione of this rubrica contatto
	 */
	@Override
	public long getFK_UTENTE_CREAZIONE() {
		return _rubricaContatto.getFK_UTENTE_CREAZIONE();
	}

	/**
	 * Returns the fk_utente_modifica of this rubrica contatto.
	 *
	 * @return the fk_utente_modifica of this rubrica contatto
	 */
	@Override
	public long getFK_UTENTE_MODIFICA() {
		return _rubricaContatto.getFK_UTENTE_MODIFICA();
	}

	/**
	 * Returns the id_contatto of this rubrica contatto.
	 *
	 * @return the id_contatto of this rubrica contatto
	 */
	@Override
	public long getID_CONTATTO() {
		return _rubricaContatto.getID_CONTATTO();
	}

	/**
	 * Returns the modifica_minore of this rubrica contatto.
	 *
	 * @return the modifica_minore of this rubrica contatto
	 */
	@Override
	public boolean getMODIFICA_MINORE() {
		return _rubricaContatto.getMODIFICA_MINORE();
	}

	/**
	 * Returns the primary key of this rubrica contatto.
	 *
	 * @return the primary key of this rubrica contatto
	 */
	@Override
	public long getPrimaryKey() {
		return _rubricaContatto.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rubricaContatto.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _rubricaContatto.hashCode();
	}

	/**
	 * Returns <code>true</code> if this rubrica contatto is allertamento.
	 *
	 * @return <code>true</code> if this rubrica contatto is allertamento; <code>false</code> otherwise
	 */
	@Override
	public boolean isALLERTAMENTO() {
		return _rubricaContatto.isALLERTAMENTO();
	}

	@Override
	public boolean isCachedModel() {
		return _rubricaContatto.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _rubricaContatto.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this rubrica contatto is modifica_minore.
	 *
	 * @return <code>true</code> if this rubrica contatto is modifica_minore; <code>false</code> otherwise
	 */
	@Override
	public boolean isMODIFICA_MINORE() {
		return _rubricaContatto.isMODIFICA_MINORE();
	}

	@Override
	public boolean isNew() {
		return _rubricaContatto.isNew();
	}

	@Override
	public void persist() {
		_rubricaContatto.persist();
	}

	/**
	 * Sets whether this rubrica contatto is allertamento.
	 *
	 * @param ALLERTAMENTO the allertamento of this rubrica contatto
	 */
	@Override
	public void setALLERTAMENTO(boolean ALLERTAMENTO) {
		_rubricaContatto.setALLERTAMENTO(ALLERTAMENTO);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rubricaContatto.setCachedModel(cachedModel);
	}

	/**
	 * Sets the contatto of this rubrica contatto.
	 *
	 * @param CONTATTO the contatto of this rubrica contatto
	 */
	@Override
	public void setCONTATTO(String CONTATTO) {
		_rubricaContatto.setCONTATTO(CONTATTO);
	}

	/**
	 * Sets the data_creazione of this rubrica contatto.
	 *
	 * @param DATA_CREAZIONE the data_creazione of this rubrica contatto
	 */
	@Override
	public void setDATA_CREAZIONE(Date DATA_CREAZIONE) {
		_rubricaContatto.setDATA_CREAZIONE(DATA_CREAZIONE);
	}

	/**
	 * Sets the data_fine_validita of this rubrica contatto.
	 *
	 * @param DATA_FINE_VALIDITA the data_fine_validita of this rubrica contatto
	 */
	@Override
	public void setDATA_FINE_VALIDITA(Date DATA_FINE_VALIDITA) {
		_rubricaContatto.setDATA_FINE_VALIDITA(DATA_FINE_VALIDITA);
	}

	/**
	 * Sets the data_modifica of this rubrica contatto.
	 *
	 * @param DATA_MODIFICA the data_modifica of this rubrica contatto
	 */
	@Override
	public void setDATA_MODIFICA(Date DATA_MODIFICA) {
		_rubricaContatto.setDATA_MODIFICA(DATA_MODIFICA);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_rubricaContatto.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_rubricaContatto.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_rubricaContatto.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the fk_canale of this rubrica contatto.
	 *
	 * @param FK_CANALE the fk_canale of this rubrica contatto
	 */
	@Override
	public void setFK_CANALE(long FK_CANALE) {
		_rubricaContatto.setFK_CANALE(FK_CANALE);
	}

	/**
	 * Sets the fk_nominativo of this rubrica contatto.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo of this rubrica contatto
	 */
	@Override
	public void setFK_NOMINATIVO(long FK_NOMINATIVO) {
		_rubricaContatto.setFK_NOMINATIVO(FK_NOMINATIVO);
	}

	/**
	 * Sets the fk_utente_creazione of this rubrica contatto.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione of this rubrica contatto
	 */
	@Override
	public void setFK_UTENTE_CREAZIONE(long FK_UTENTE_CREAZIONE) {
		_rubricaContatto.setFK_UTENTE_CREAZIONE(FK_UTENTE_CREAZIONE);
	}

	/**
	 * Sets the fk_utente_modifica of this rubrica contatto.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica of this rubrica contatto
	 */
	@Override
	public void setFK_UTENTE_MODIFICA(long FK_UTENTE_MODIFICA) {
		_rubricaContatto.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);
	}

	/**
	 * Sets the id_contatto of this rubrica contatto.
	 *
	 * @param ID_CONTATTO the id_contatto of this rubrica contatto
	 */
	@Override
	public void setID_CONTATTO(long ID_CONTATTO) {
		_rubricaContatto.setID_CONTATTO(ID_CONTATTO);
	}

	/**
	 * Sets whether this rubrica contatto is modifica_minore.
	 *
	 * @param MODIFICA_MINORE the modifica_minore of this rubrica contatto
	 */
	@Override
	public void setMODIFICA_MINORE(boolean MODIFICA_MINORE) {
		_rubricaContatto.setMODIFICA_MINORE(MODIFICA_MINORE);
	}

	@Override
	public void setNew(boolean n) {
		_rubricaContatto.setNew(n);
	}

	/**
	 * Sets the primary key of this rubrica contatto.
	 *
	 * @param primaryKey the primary key of this rubrica contatto
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rubricaContatto.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_rubricaContatto.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerte.model.RubricaContatto> toCacheModel() {

		return _rubricaContatto.toCacheModel();
	}

	@Override
	public it.eng.allerte.model.RubricaContatto toEscapedModel() {
		return new RubricaContattoWrapper(_rubricaContatto.toEscapedModel());
	}

	@Override
	public String toString() {
		return _rubricaContatto.toString();
	}

	@Override
	public it.eng.allerte.model.RubricaContatto toUnescapedModel() {
		return new RubricaContattoWrapper(_rubricaContatto.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _rubricaContatto.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RubricaContattoWrapper)) {
			return false;
		}

		RubricaContattoWrapper rubricaContattoWrapper =
			(RubricaContattoWrapper)obj;

		if (Objects.equals(
				_rubricaContatto, rubricaContattoWrapper._rubricaContatto)) {

			return true;
		}

		return false;
	}

	@Override
	public RubricaContatto getWrappedModel() {
		return _rubricaContatto;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _rubricaContatto.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _rubricaContatto.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_rubricaContatto.resetOriginalValues();
	}

	private final RubricaContatto _rubricaContatto;

}