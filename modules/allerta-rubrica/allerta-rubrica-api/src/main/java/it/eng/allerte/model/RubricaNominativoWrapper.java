/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RubricaNominativo}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaNominativo
 * @generated
 */
public class RubricaNominativoWrapper
	extends BaseModelWrapper<RubricaNominativo>
	implements ModelWrapper<RubricaNominativo>, RubricaNominativo {

	public RubricaNominativoWrapper(RubricaNominativo rubricaNominativo) {
		super(rubricaNominativo);
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
	public RubricaNominativo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the cognome of this rubrica nominativo.
	 *
	 * @return the cognome of this rubrica nominativo
	 */
	@Override
	public String getCOGNOME() {
		return model.getCOGNOME();
	}

	/**
	 * Returns the data_creazione of this rubrica nominativo.
	 *
	 * @return the data_creazione of this rubrica nominativo
	 */
	@Override
	public Date getDATA_CREAZIONE() {
		return model.getDATA_CREAZIONE();
	}

	/**
	 * Returns the data_modifica of this rubrica nominativo.
	 *
	 * @return the data_modifica of this rubrica nominativo
	 */
	@Override
	public Date getDATA_MODIFICA() {
		return model.getDATA_MODIFICA();
	}

	/**
	 * Returns the disabled of this rubrica nominativo.
	 *
	 * @return the disabled of this rubrica nominativo
	 */
	@Override
	public boolean getDISABLED() {
		return model.getDISABLED();
	}

	/**
	 * Returns the fk_sito_proprietario of this rubrica nominativo.
	 *
	 * @return the fk_sito_proprietario of this rubrica nominativo
	 */
	@Override
	public long getFK_SITO_PROPRIETARIO() {
		return model.getFK_SITO_PROPRIETARIO();
	}

	/**
	 * Returns the fk_utente_creazione of this rubrica nominativo.
	 *
	 * @return the fk_utente_creazione of this rubrica nominativo
	 */
	@Override
	public long getFK_UTENTE_CREAZIONE() {
		return model.getFK_UTENTE_CREAZIONE();
	}

	/**
	 * Returns the fk_utente_modifica of this rubrica nominativo.
	 *
	 * @return the fk_utente_modifica of this rubrica nominativo
	 */
	@Override
	public long getFK_UTENTE_MODIFICA() {
		return model.getFK_UTENTE_MODIFICA();
	}

	/**
	 * Returns the fk_utente_portale of this rubrica nominativo.
	 *
	 * @return the fk_utente_portale of this rubrica nominativo
	 */
	@Override
	public long getFK_UTENTE_PORTALE() {
		return model.getFK_UTENTE_PORTALE();
	}

	/**
	 * Returns the id_nominativo of this rubrica nominativo.
	 *
	 * @return the id_nominativo of this rubrica nominativo
	 */
	@Override
	public long getID_NOMINATIVO() {
		return model.getID_NOMINATIVO();
	}

	/**
	 * Returns the indirizzo of this rubrica nominativo.
	 *
	 * @return the indirizzo of this rubrica nominativo
	 */
	@Override
	public String getINDIRIZZO() {
		return model.getINDIRIZZO();
	}

	/**
	 * Returns the modifica_minore of this rubrica nominativo.
	 *
	 * @return the modifica_minore of this rubrica nominativo
	 */
	@Override
	public boolean getMODIFICA_MINORE() {
		return model.getMODIFICA_MINORE();
	}

	/**
	 * Returns the nome of this rubrica nominativo.
	 *
	 * @return the nome of this rubrica nominativo
	 */
	@Override
	public String getNOME() {
		return model.getNOME();
	}

	/**
	 * Returns the primary key of this rubrica nominativo.
	 *
	 * @return the primary key of this rubrica nominativo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this rubrica nominativo is disabled.
	 *
	 * @return <code>true</code> if this rubrica nominativo is disabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isDISABLED() {
		return model.isDISABLED();
	}

	/**
	 * Returns <code>true</code> if this rubrica nominativo is modifica_minore.
	 *
	 * @return <code>true</code> if this rubrica nominativo is modifica_minore; <code>false</code> otherwise
	 */
	@Override
	public boolean isMODIFICA_MINORE() {
		return model.isMODIFICA_MINORE();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cognome of this rubrica nominativo.
	 *
	 * @param COGNOME the cognome of this rubrica nominativo
	 */
	@Override
	public void setCOGNOME(String COGNOME) {
		model.setCOGNOME(COGNOME);
	}

	/**
	 * Sets the data_creazione of this rubrica nominativo.
	 *
	 * @param DATA_CREAZIONE the data_creazione of this rubrica nominativo
	 */
	@Override
	public void setDATA_CREAZIONE(Date DATA_CREAZIONE) {
		model.setDATA_CREAZIONE(DATA_CREAZIONE);
	}

	/**
	 * Sets the data_modifica of this rubrica nominativo.
	 *
	 * @param DATA_MODIFICA the data_modifica of this rubrica nominativo
	 */
	@Override
	public void setDATA_MODIFICA(Date DATA_MODIFICA) {
		model.setDATA_MODIFICA(DATA_MODIFICA);
	}

	/**
	 * Sets whether this rubrica nominativo is disabled.
	 *
	 * @param DISABLED the disabled of this rubrica nominativo
	 */
	@Override
	public void setDISABLED(boolean DISABLED) {
		model.setDISABLED(DISABLED);
	}

	/**
	 * Sets the fk_sito_proprietario of this rubrica nominativo.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario of this rubrica nominativo
	 */
	@Override
	public void setFK_SITO_PROPRIETARIO(long FK_SITO_PROPRIETARIO) {
		model.setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);
	}

	/**
	 * Sets the fk_utente_creazione of this rubrica nominativo.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione of this rubrica nominativo
	 */
	@Override
	public void setFK_UTENTE_CREAZIONE(long FK_UTENTE_CREAZIONE) {
		model.setFK_UTENTE_CREAZIONE(FK_UTENTE_CREAZIONE);
	}

	/**
	 * Sets the fk_utente_modifica of this rubrica nominativo.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica of this rubrica nominativo
	 */
	@Override
	public void setFK_UTENTE_MODIFICA(long FK_UTENTE_MODIFICA) {
		model.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);
	}

	/**
	 * Sets the fk_utente_portale of this rubrica nominativo.
	 *
	 * @param FK_UTENTE_PORTALE the fk_utente_portale of this rubrica nominativo
	 */
	@Override
	public void setFK_UTENTE_PORTALE(long FK_UTENTE_PORTALE) {
		model.setFK_UTENTE_PORTALE(FK_UTENTE_PORTALE);
	}

	/**
	 * Sets the id_nominativo of this rubrica nominativo.
	 *
	 * @param ID_NOMINATIVO the id_nominativo of this rubrica nominativo
	 */
	@Override
	public void setID_NOMINATIVO(long ID_NOMINATIVO) {
		model.setID_NOMINATIVO(ID_NOMINATIVO);
	}

	/**
	 * Sets the indirizzo of this rubrica nominativo.
	 *
	 * @param INDIRIZZO the indirizzo of this rubrica nominativo
	 */
	@Override
	public void setINDIRIZZO(String INDIRIZZO) {
		model.setINDIRIZZO(INDIRIZZO);
	}

	/**
	 * Sets whether this rubrica nominativo is modifica_minore.
	 *
	 * @param MODIFICA_MINORE the modifica_minore of this rubrica nominativo
	 */
	@Override
	public void setMODIFICA_MINORE(boolean MODIFICA_MINORE) {
		model.setMODIFICA_MINORE(MODIFICA_MINORE);
	}

	/**
	 * Sets the nome of this rubrica nominativo.
	 *
	 * @param NOME the nome of this rubrica nominativo
	 */
	@Override
	public void setNOME(String NOME) {
		model.setNOME(NOME);
	}

	/**
	 * Sets the primary key of this rubrica nominativo.
	 *
	 * @param primaryKey the primary key of this rubrica nominativo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RubricaNominativoWrapper wrap(
		RubricaNominativo rubricaNominativo) {

		return new RubricaNominativoWrapper(rubricaNominativo);
	}

}