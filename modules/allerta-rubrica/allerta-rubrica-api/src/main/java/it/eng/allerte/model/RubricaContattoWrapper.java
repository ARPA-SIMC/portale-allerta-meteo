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
 * This class is a wrapper for {@link RubricaContatto}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaContatto
 * @generated
 */
public class RubricaContattoWrapper
	extends BaseModelWrapper<RubricaContatto>
	implements ModelWrapper<RubricaContatto>, RubricaContatto {

	public RubricaContattoWrapper(RubricaContatto rubricaContatto) {
		super(rubricaContatto);
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
	public RubricaContatto cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the allertamento of this rubrica contatto.
	 *
	 * @return the allertamento of this rubrica contatto
	 */
	@Override
	public boolean getALLERTAMENTO() {
		return model.getALLERTAMENTO();
	}

	/**
	 * Returns the contatto of this rubrica contatto.
	 *
	 * @return the contatto of this rubrica contatto
	 */
	@Override
	public String getCONTATTO() {
		return model.getCONTATTO();
	}

	/**
	 * Returns the data_creazione of this rubrica contatto.
	 *
	 * @return the data_creazione of this rubrica contatto
	 */
	@Override
	public Date getDATA_CREAZIONE() {
		return model.getDATA_CREAZIONE();
	}

	/**
	 * Returns the data_fine_validita of this rubrica contatto.
	 *
	 * @return the data_fine_validita of this rubrica contatto
	 */
	@Override
	public Date getDATA_FINE_VALIDITA() {
		return model.getDATA_FINE_VALIDITA();
	}

	/**
	 * Returns the data_modifica of this rubrica contatto.
	 *
	 * @return the data_modifica of this rubrica contatto
	 */
	@Override
	public Date getDATA_MODIFICA() {
		return model.getDATA_MODIFICA();
	}

	/**
	 * Returns the fk_canale of this rubrica contatto.
	 *
	 * @return the fk_canale of this rubrica contatto
	 */
	@Override
	public long getFK_CANALE() {
		return model.getFK_CANALE();
	}

	/**
	 * Returns the fk_nominativo of this rubrica contatto.
	 *
	 * @return the fk_nominativo of this rubrica contatto
	 */
	@Override
	public long getFK_NOMINATIVO() {
		return model.getFK_NOMINATIVO();
	}

	/**
	 * Returns the fk_utente_creazione of this rubrica contatto.
	 *
	 * @return the fk_utente_creazione of this rubrica contatto
	 */
	@Override
	public long getFK_UTENTE_CREAZIONE() {
		return model.getFK_UTENTE_CREAZIONE();
	}

	/**
	 * Returns the fk_utente_modifica of this rubrica contatto.
	 *
	 * @return the fk_utente_modifica of this rubrica contatto
	 */
	@Override
	public long getFK_UTENTE_MODIFICA() {
		return model.getFK_UTENTE_MODIFICA();
	}

	/**
	 * Returns the id_contatto of this rubrica contatto.
	 *
	 * @return the id_contatto of this rubrica contatto
	 */
	@Override
	public long getID_CONTATTO() {
		return model.getID_CONTATTO();
	}

	/**
	 * Returns the modifica_minore of this rubrica contatto.
	 *
	 * @return the modifica_minore of this rubrica contatto
	 */
	@Override
	public boolean getMODIFICA_MINORE() {
		return model.getMODIFICA_MINORE();
	}

	/**
	 * Returns the primary key of this rubrica contatto.
	 *
	 * @return the primary key of this rubrica contatto
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this rubrica contatto is allertamento.
	 *
	 * @return <code>true</code> if this rubrica contatto is allertamento; <code>false</code> otherwise
	 */
	@Override
	public boolean isALLERTAMENTO() {
		return model.isALLERTAMENTO();
	}

	/**
	 * Returns <code>true</code> if this rubrica contatto is modifica_minore.
	 *
	 * @return <code>true</code> if this rubrica contatto is modifica_minore; <code>false</code> otherwise
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
	 * Sets whether this rubrica contatto is allertamento.
	 *
	 * @param ALLERTAMENTO the allertamento of this rubrica contatto
	 */
	@Override
	public void setALLERTAMENTO(boolean ALLERTAMENTO) {
		model.setALLERTAMENTO(ALLERTAMENTO);
	}

	/**
	 * Sets the contatto of this rubrica contatto.
	 *
	 * @param CONTATTO the contatto of this rubrica contatto
	 */
	@Override
	public void setCONTATTO(String CONTATTO) {
		model.setCONTATTO(CONTATTO);
	}

	/**
	 * Sets the data_creazione of this rubrica contatto.
	 *
	 * @param DATA_CREAZIONE the data_creazione of this rubrica contatto
	 */
	@Override
	public void setDATA_CREAZIONE(Date DATA_CREAZIONE) {
		model.setDATA_CREAZIONE(DATA_CREAZIONE);
	}

	/**
	 * Sets the data_fine_validita of this rubrica contatto.
	 *
	 * @param DATA_FINE_VALIDITA the data_fine_validita of this rubrica contatto
	 */
	@Override
	public void setDATA_FINE_VALIDITA(Date DATA_FINE_VALIDITA) {
		model.setDATA_FINE_VALIDITA(DATA_FINE_VALIDITA);
	}

	/**
	 * Sets the data_modifica of this rubrica contatto.
	 *
	 * @param DATA_MODIFICA the data_modifica of this rubrica contatto
	 */
	@Override
	public void setDATA_MODIFICA(Date DATA_MODIFICA) {
		model.setDATA_MODIFICA(DATA_MODIFICA);
	}

	/**
	 * Sets the fk_canale of this rubrica contatto.
	 *
	 * @param FK_CANALE the fk_canale of this rubrica contatto
	 */
	@Override
	public void setFK_CANALE(long FK_CANALE) {
		model.setFK_CANALE(FK_CANALE);
	}

	/**
	 * Sets the fk_nominativo of this rubrica contatto.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo of this rubrica contatto
	 */
	@Override
	public void setFK_NOMINATIVO(long FK_NOMINATIVO) {
		model.setFK_NOMINATIVO(FK_NOMINATIVO);
	}

	/**
	 * Sets the fk_utente_creazione of this rubrica contatto.
	 *
	 * @param FK_UTENTE_CREAZIONE the fk_utente_creazione of this rubrica contatto
	 */
	@Override
	public void setFK_UTENTE_CREAZIONE(long FK_UTENTE_CREAZIONE) {
		model.setFK_UTENTE_CREAZIONE(FK_UTENTE_CREAZIONE);
	}

	/**
	 * Sets the fk_utente_modifica of this rubrica contatto.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica of this rubrica contatto
	 */
	@Override
	public void setFK_UTENTE_MODIFICA(long FK_UTENTE_MODIFICA) {
		model.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);
	}

	/**
	 * Sets the id_contatto of this rubrica contatto.
	 *
	 * @param ID_CONTATTO the id_contatto of this rubrica contatto
	 */
	@Override
	public void setID_CONTATTO(long ID_CONTATTO) {
		model.setID_CONTATTO(ID_CONTATTO);
	}

	/**
	 * Sets whether this rubrica contatto is modifica_minore.
	 *
	 * @param MODIFICA_MINORE the modifica_minore of this rubrica contatto
	 */
	@Override
	public void setMODIFICA_MINORE(boolean MODIFICA_MINORE) {
		model.setMODIFICA_MINORE(MODIFICA_MINORE);
	}

	/**
	 * Sets the primary key of this rubrica contatto.
	 *
	 * @param primaryKey the primary key of this rubrica contatto
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
	protected RubricaContattoWrapper wrap(RubricaContatto rubricaContatto) {
		return new RubricaContattoWrapper(rubricaContatto);
	}

}