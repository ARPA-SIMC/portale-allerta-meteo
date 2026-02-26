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
 * This class is a wrapper for {@link RubricaGruppo}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppo
 * @generated
 */
public class RubricaGruppoWrapper
	extends BaseModelWrapper<RubricaGruppo>
	implements ModelWrapper<RubricaGruppo>, RubricaGruppo {

	public RubricaGruppoWrapper(RubricaGruppo rubricaGruppo) {
		super(rubricaGruppo);
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
		attributes.put("FK_CATEGORIA", getFK_CATEGORIA());

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

		Long FK_CATEGORIA = (Long)attributes.get("FK_CATEGORIA");

		if (FK_CATEGORIA != null) {
			setFK_CATEGORIA(FK_CATEGORIA);
		}
	}

	@Override
	public RubricaGruppo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the data_creazione of this rubrica gruppo.
	 *
	 * @return the data_creazione of this rubrica gruppo
	 */
	@Override
	public Date getDATA_CREAZIONE() {
		return model.getDATA_CREAZIONE();
	}

	/**
	 * Returns the data_modifica of this rubrica gruppo.
	 *
	 * @return the data_modifica of this rubrica gruppo
	 */
	@Override
	public Date getDATA_MODIFICA() {
		return model.getDATA_MODIFICA();
	}

	/**
	 * Returns the disabled of this rubrica gruppo.
	 *
	 * @return the disabled of this rubrica gruppo
	 */
	@Override
	public boolean getDISABLED() {
		return model.getDISABLED();
	}

	/**
	 * Returns the fk_categoria of this rubrica gruppo.
	 *
	 * @return the fk_categoria of this rubrica gruppo
	 */
	@Override
	public long getFK_CATEGORIA() {
		return model.getFK_CATEGORIA();
	}

	/**
	 * Returns the fk_sito_proprietario of this rubrica gruppo.
	 *
	 * @return the fk_sito_proprietario of this rubrica gruppo
	 */
	@Override
	public long getFK_SITO_PROPRIETARIO() {
		return model.getFK_SITO_PROPRIETARIO();
	}

	/**
	 * Returns the fk_utente_creazione of this rubrica gruppo.
	 *
	 * @return the fk_utente_creazione of this rubrica gruppo
	 */
	@Override
	public long getFK_UTENTE_CREAZIONE() {
		return model.getFK_UTENTE_CREAZIONE();
	}

	/**
	 * Returns the fk_utente_modifica of this rubrica gruppo.
	 *
	 * @return the fk_utente_modifica of this rubrica gruppo
	 */
	@Override
	public long getFK_UTENTE_MODIFICA() {
		return model.getFK_UTENTE_MODIFICA();
	}

	/**
	 * Returns the id_gruppo of this rubrica gruppo.
	 *
	 * @return the id_gruppo of this rubrica gruppo
	 */
	@Override
	public long getID_GRUPPO() {
		return model.getID_GRUPPO();
	}

	/**
	 * Returns the nome of this rubrica gruppo.
	 *
	 * @return the nome of this rubrica gruppo
	 */
	@Override
	public String getNOME() {
		return model.getNOME();
	}

	/**
	 * Returns the note of this rubrica gruppo.
	 *
	 * @return the note of this rubrica gruppo
	 */
	@Override
	public String getNOTE() {
		return model.getNOTE();
	}

	/**
	 * Returns the primary key of this rubrica gruppo.
	 *
	 * @return the primary key of this rubrica gruppo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this rubrica gruppo is disabled.
	 *
	 * @return <code>true</code> if this rubrica gruppo is disabled; <code>false</code> otherwise
	 */
	@Override
	public boolean isDISABLED() {
		return model.isDISABLED();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data_creazione of this rubrica gruppo.
	 *
	 * @param DATA_CREAZIONE the data_creazione of this rubrica gruppo
	 */
	@Override
	public void setDATA_CREAZIONE(Date DATA_CREAZIONE) {
		model.setDATA_CREAZIONE(DATA_CREAZIONE);
	}

	/**
	 * Sets the data_modifica of this rubrica gruppo.
	 *
	 * @param DATA_MODIFICA the data_modifica of this rubrica gruppo
	 */
	@Override
	public void setDATA_MODIFICA(Date DATA_MODIFICA) {
		model.setDATA_MODIFICA(DATA_MODIFICA);
	}

	/**
	 * Sets whether this rubrica gruppo is disabled.
	 *
	 * @param DISABLED the disabled of this rubrica gruppo
	 */
	@Override
	public void setDISABLED(boolean DISABLED) {
		model.setDISABLED(DISABLED);
	}

	/**
	 * Sets the fk_categoria of this rubrica gruppo.
	 *
	 * @param FK_CATEGORIA the fk_categoria of this rubrica gruppo
	 */
	@Override
	public void setFK_CATEGORIA(long FK_CATEGORIA) {
		model.setFK_CATEGORIA(FK_CATEGORIA);
	}

	/**
	 * Sets the fk_sito_proprietario of this rubrica gruppo.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario of this rubrica gruppo
	 */
	@Override
	public void setFK_SITO_PROPRIETARIO(long FK_SITO_PROPRIETARIO) {
		model.setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);
	}

	/**
	 * Sets the fk_utente_creazione of this rubrica gruppo.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione of this rubrica gruppo
	 */
	@Override
	public void setFK_UTENTE_CREAZIONE(long FK_UTENTE_CREAZIONE) {
		model.setFK_UTENTE_CREAZIONE(FK_UTENTE_CREAZIONE);
	}

	/**
	 * Sets the fk_utente_modifica of this rubrica gruppo.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica of this rubrica gruppo
	 */
	@Override
	public void setFK_UTENTE_MODIFICA(long FK_UTENTE_MODIFICA) {
		model.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);
	}

	/**
	 * Sets the id_gruppo of this rubrica gruppo.
	 *
	 * @param ID_GRUPPO the id_gruppo of this rubrica gruppo
	 */
	@Override
	public void setID_GRUPPO(long ID_GRUPPO) {
		model.setID_GRUPPO(ID_GRUPPO);
	}

	/**
	 * Sets the nome of this rubrica gruppo.
	 *
	 * @param NOME the nome of this rubrica gruppo
	 */
	@Override
	public void setNOME(String NOME) {
		model.setNOME(NOME);
	}

	/**
	 * Sets the note of this rubrica gruppo.
	 *
	 * @param NOTE the note of this rubrica gruppo
	 */
	@Override
	public void setNOTE(String NOTE) {
		model.setNOTE(NOTE);
	}

	/**
	 * Sets the primary key of this rubrica gruppo.
	 *
	 * @param primaryKey the primary key of this rubrica gruppo
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
	protected RubricaGruppoWrapper wrap(RubricaGruppo rubricaGruppo) {
		return new RubricaGruppoWrapper(rubricaGruppo);
	}

}