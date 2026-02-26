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
 * This class is a wrapper for {@link RubricaRuolo}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuolo
 * @generated
 */
public class RubricaRuoloWrapper
	extends BaseModelWrapper<RubricaRuolo>
	implements ModelWrapper<RubricaRuolo>, RubricaRuolo {

	public RubricaRuoloWrapper(RubricaRuolo rubricaRuolo) {
		super(rubricaRuolo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_RUOLO", getID_RUOLO());
		attributes.put("DESCRIZIONE", getDESCRIZIONE());
		attributes.put("FK_RUOLO_LIFERAY", getFK_RUOLO_LIFERAY());

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

		Long FK_RUOLO_LIFERAY = (Long)attributes.get("FK_RUOLO_LIFERAY");

		if (FK_RUOLO_LIFERAY != null) {
			setFK_RUOLO_LIFERAY(FK_RUOLO_LIFERAY);
		}
	}

	@Override
	public RubricaRuolo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the descrizione of this rubrica ruolo.
	 *
	 * @return the descrizione of this rubrica ruolo
	 */
	@Override
	public String getDESCRIZIONE() {
		return model.getDESCRIZIONE();
	}

	/**
	 * Returns the fk_ruolo_liferay of this rubrica ruolo.
	 *
	 * @return the fk_ruolo_liferay of this rubrica ruolo
	 */
	@Override
	public long getFK_RUOLO_LIFERAY() {
		return model.getFK_RUOLO_LIFERAY();
	}

	/**
	 * Returns the id_ruolo of this rubrica ruolo.
	 *
	 * @return the id_ruolo of this rubrica ruolo
	 */
	@Override
	public long getID_RUOLO() {
		return model.getID_RUOLO();
	}

	/**
	 * Returns the primary key of this rubrica ruolo.
	 *
	 * @return the primary key of this rubrica ruolo
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
	 * Sets the descrizione of this rubrica ruolo.
	 *
	 * @param DESCRIZIONE the descrizione of this rubrica ruolo
	 */
	@Override
	public void setDESCRIZIONE(String DESCRIZIONE) {
		model.setDESCRIZIONE(DESCRIZIONE);
	}

	/**
	 * Sets the fk_ruolo_liferay of this rubrica ruolo.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay of this rubrica ruolo
	 */
	@Override
	public void setFK_RUOLO_LIFERAY(long FK_RUOLO_LIFERAY) {
		model.setFK_RUOLO_LIFERAY(FK_RUOLO_LIFERAY);
	}

	/**
	 * Sets the id_ruolo of this rubrica ruolo.
	 *
	 * @param ID_RUOLO the id_ruolo of this rubrica ruolo
	 */
	@Override
	public void setID_RUOLO(long ID_RUOLO) {
		model.setID_RUOLO(ID_RUOLO);
	}

	/**
	 * Sets the primary key of this rubrica ruolo.
	 *
	 * @param primaryKey the primary key of this rubrica ruolo
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
	protected RubricaRuoloWrapper wrap(RubricaRuolo rubricaRuolo) {
		return new RubricaRuoloWrapper(rubricaRuolo);
	}

}