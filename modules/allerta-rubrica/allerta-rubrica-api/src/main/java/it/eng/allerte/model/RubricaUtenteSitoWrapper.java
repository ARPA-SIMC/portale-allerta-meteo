/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RubricaUtenteSito}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaUtenteSito
 * @generated
 */
public class RubricaUtenteSitoWrapper
	extends BaseModelWrapper<RubricaUtenteSito>
	implements ModelWrapper<RubricaUtenteSito>, RubricaUtenteSito {

	public RubricaUtenteSitoWrapper(RubricaUtenteSito rubricaUtenteSito) {
		super(rubricaUtenteSito);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_UTENTE", getID_UTENTE());
		attributes.put("ID_SITO", getID_SITO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_UTENTE = (Long)attributes.get("ID_UTENTE");

		if (ID_UTENTE != null) {
			setID_UTENTE(ID_UTENTE);
		}

		Long ID_SITO = (Long)attributes.get("ID_SITO");

		if (ID_SITO != null) {
			setID_SITO(ID_SITO);
		}
	}

	@Override
	public RubricaUtenteSito cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the id_sito of this rubrica utente sito.
	 *
	 * @return the id_sito of this rubrica utente sito
	 */
	@Override
	public long getID_SITO() {
		return model.getID_SITO();
	}

	/**
	 * Returns the id_utente of this rubrica utente sito.
	 *
	 * @return the id_utente of this rubrica utente sito
	 */
	@Override
	public long getID_UTENTE() {
		return model.getID_UTENTE();
	}

	/**
	 * Returns the primary key of this rubrica utente sito.
	 *
	 * @return the primary key of this rubrica utente sito
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the id_sito of this rubrica utente sito.
	 *
	 * @param ID_SITO the id_sito of this rubrica utente sito
	 */
	@Override
	public void setID_SITO(long ID_SITO) {
		model.setID_SITO(ID_SITO);
	}

	/**
	 * Sets the id_utente of this rubrica utente sito.
	 *
	 * @param ID_UTENTE the id_utente of this rubrica utente sito
	 */
	@Override
	public void setID_UTENTE(long ID_UTENTE) {
		model.setID_UTENTE(ID_UTENTE);
	}

	/**
	 * Sets the primary key of this rubrica utente sito.
	 *
	 * @param primaryKey the primary key of this rubrica utente sito
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
	protected RubricaUtenteSitoWrapper wrap(
		RubricaUtenteSito rubricaUtenteSito) {

		return new RubricaUtenteSitoWrapper(rubricaUtenteSito);
	}

}