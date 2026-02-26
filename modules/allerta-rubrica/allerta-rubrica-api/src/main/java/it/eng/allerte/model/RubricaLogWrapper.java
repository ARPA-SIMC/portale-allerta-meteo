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
 * This class is a wrapper for {@link RubricaLog}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaLog
 * @generated
 */
public class RubricaLogWrapper
	extends BaseModelWrapper<RubricaLog>
	implements ModelWrapper<RubricaLog>, RubricaLog {

	public RubricaLogWrapper(RubricaLog rubricaLog) {
		super(rubricaLog);
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
	public RubricaLog cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the data_modifica of this rubrica log.
	 *
	 * @return the data_modifica of this rubrica log
	 */
	@Override
	public Date getDATA_MODIFICA() {
		return model.getDATA_MODIFICA();
	}

	/**
	 * Returns the fk_sito_proprietario of this rubrica log.
	 *
	 * @return the fk_sito_proprietario of this rubrica log
	 */
	@Override
	public long getFK_SITO_PROPRIETARIO() {
		return model.getFK_SITO_PROPRIETARIO();
	}

	/**
	 * Returns the fk_utente_modifica of this rubrica log.
	 *
	 * @return the fk_utente_modifica of this rubrica log
	 */
	@Override
	public long getFK_UTENTE_MODIFICA() {
		return model.getFK_UTENTE_MODIFICA();
	}

	/**
	 * Returns the id_log of this rubrica log.
	 *
	 * @return the id_log of this rubrica log
	 */
	@Override
	public long getID_LOG() {
		return model.getID_LOG();
	}

	/**
	 * Returns the id_oggetto of this rubrica log.
	 *
	 * @return the id_oggetto of this rubrica log
	 */
	@Override
	public String getID_OGGETTO() {
		return model.getID_OGGETTO();
	}

	/**
	 * Returns the nuova_descrizione of this rubrica log.
	 *
	 * @return the nuova_descrizione of this rubrica log
	 */
	@Override
	public String getNUOVA_DESCRIZIONE() {
		return model.getNUOVA_DESCRIZIONE();
	}

	/**
	 * Returns the primary key of this rubrica log.
	 *
	 * @return the primary key of this rubrica log
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tabella of this rubrica log.
	 *
	 * @return the tabella of this rubrica log
	 */
	@Override
	public String getTABELLA() {
		return model.getTABELLA();
	}

	/**
	 * Returns the tipo_operazione of this rubrica log.
	 *
	 * @return the tipo_operazione of this rubrica log
	 */
	@Override
	public String getTIPO_OPERAZIONE() {
		return model.getTIPO_OPERAZIONE();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data_modifica of this rubrica log.
	 *
	 * @param DATA_MODIFICA the data_modifica of this rubrica log
	 */
	@Override
	public void setDATA_MODIFICA(Date DATA_MODIFICA) {
		model.setDATA_MODIFICA(DATA_MODIFICA);
	}

	/**
	 * Sets the fk_sito_proprietario of this rubrica log.
	 *
	 * @param FK_SITO_PROPRIETARIO the fk_sito_proprietario of this rubrica log
	 */
	@Override
	public void setFK_SITO_PROPRIETARIO(long FK_SITO_PROPRIETARIO) {
		model.setFK_SITO_PROPRIETARIO(FK_SITO_PROPRIETARIO);
	}

	/**
	 * Sets the fk_utente_modifica of this rubrica log.
	 *
	 * @param FK_UTENTE_MODIFICA the fk_utente_modifica of this rubrica log
	 */
	@Override
	public void setFK_UTENTE_MODIFICA(long FK_UTENTE_MODIFICA) {
		model.setFK_UTENTE_MODIFICA(FK_UTENTE_MODIFICA);
	}

	/**
	 * Sets the id_log of this rubrica log.
	 *
	 * @param ID_LOG the id_log of this rubrica log
	 */
	@Override
	public void setID_LOG(long ID_LOG) {
		model.setID_LOG(ID_LOG);
	}

	/**
	 * Sets the id_oggetto of this rubrica log.
	 *
	 * @param ID_OGGETTO the id_oggetto of this rubrica log
	 */
	@Override
	public void setID_OGGETTO(String ID_OGGETTO) {
		model.setID_OGGETTO(ID_OGGETTO);
	}

	/**
	 * Sets the nuova_descrizione of this rubrica log.
	 *
	 * @param NUOVA_DESCRIZIONE the nuova_descrizione of this rubrica log
	 */
	@Override
	public void setNUOVA_DESCRIZIONE(String NUOVA_DESCRIZIONE) {
		model.setNUOVA_DESCRIZIONE(NUOVA_DESCRIZIONE);
	}

	/**
	 * Sets the primary key of this rubrica log.
	 *
	 * @param primaryKey the primary key of this rubrica log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tabella of this rubrica log.
	 *
	 * @param TABELLA the tabella of this rubrica log
	 */
	@Override
	public void setTABELLA(String TABELLA) {
		model.setTABELLA(TABELLA);
	}

	/**
	 * Sets the tipo_operazione of this rubrica log.
	 *
	 * @param TIPO_OPERAZIONE the tipo_operazione of this rubrica log
	 */
	@Override
	public void setTIPO_OPERAZIONE(String TIPO_OPERAZIONE) {
		model.setTIPO_OPERAZIONE(TIPO_OPERAZIONE);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RubricaLogWrapper wrap(RubricaLog rubricaLog) {
		return new RubricaLogWrapper(rubricaLog);
	}

}