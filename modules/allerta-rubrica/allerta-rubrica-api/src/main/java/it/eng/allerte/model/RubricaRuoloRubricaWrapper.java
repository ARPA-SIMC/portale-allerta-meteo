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
 * This class is a wrapper for {@link RubricaRuoloRubrica}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuoloRubrica
 * @generated
 */
public class RubricaRuoloRubricaWrapper
	extends BaseModelWrapper<RubricaRuoloRubrica>
	implements ModelWrapper<RubricaRuoloRubrica>, RubricaRuoloRubrica {

	public RubricaRuoloRubricaWrapper(RubricaRuoloRubrica rubricaRuoloRubrica) {
		super(rubricaRuoloRubrica);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_RUOLO", getID_RUOLO());
		attributes.put("DESCRIZIONE", getDESCRIZIONE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_RUOLO = (Long)attributes.get("ID_RUOLO");

		if (ID_RUOLO != null) {
			setID_RUOLO(ID_RUOLO);
		}

		String DESCRIZIONE = (String)attributes.get("DESCRIZIONE");

		if (DESCRIZIONE != null) {
			setDESCRIZIONE(DESCRIZIONE);
		}
	}

	@Override
	public RubricaRuoloRubrica cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the descrizione of this rubrica ruolo rubrica.
	 *
	 * @return the descrizione of this rubrica ruolo rubrica
	 */
	@Override
	public String getDESCRIZIONE() {
		return model.getDESCRIZIONE();
	}

	/**
	 * Returns the id_ruolo of this rubrica ruolo rubrica.
	 *
	 * @return the id_ruolo of this rubrica ruolo rubrica
	 */
	@Override
	public long getID_RUOLO() {
		return model.getID_RUOLO();
	}

	/**
	 * Returns the primary key of this rubrica ruolo rubrica.
	 *
	 * @return the primary key of this rubrica ruolo rubrica
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
	 * Sets the descrizione of this rubrica ruolo rubrica.
	 *
	 * @param DESCRIZIONE the descrizione of this rubrica ruolo rubrica
	 */
	@Override
	public void setDESCRIZIONE(String DESCRIZIONE) {
		model.setDESCRIZIONE(DESCRIZIONE);
	}

	/**
	 * Sets the id_ruolo of this rubrica ruolo rubrica.
	 *
	 * @param ID_RUOLO the id_ruolo of this rubrica ruolo rubrica
	 */
	@Override
	public void setID_RUOLO(long ID_RUOLO) {
		model.setID_RUOLO(ID_RUOLO);
	}

	/**
	 * Sets the primary key of this rubrica ruolo rubrica.
	 *
	 * @param primaryKey the primary key of this rubrica ruolo rubrica
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
	protected RubricaRuoloRubricaWrapper wrap(
		RubricaRuoloRubrica rubricaRuoloRubrica) {

		return new RubricaRuoloRubricaWrapper(rubricaRuoloRubrica);
	}

}