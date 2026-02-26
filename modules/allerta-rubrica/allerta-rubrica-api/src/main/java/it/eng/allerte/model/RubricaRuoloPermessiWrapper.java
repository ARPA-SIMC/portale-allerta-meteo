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
 * This class is a wrapper for {@link RubricaRuoloPermessi}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessi
 * @generated
 */
public class RubricaRuoloPermessiWrapper
	extends BaseModelWrapper<RubricaRuoloPermessi>
	implements ModelWrapper<RubricaRuoloPermessi>, RubricaRuoloPermessi {

	public RubricaRuoloPermessiWrapper(
		RubricaRuoloPermessi rubricaRuoloPermessi) {

		super(rubricaRuoloPermessi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("FK_ID_RUOLO", getFK_ID_RUOLO());
		attributes.put("FK_ID_PERMESSO", getFK_ID_PERMESSO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long FK_ID_RUOLO = (Long)attributes.get("FK_ID_RUOLO");

		if (FK_ID_RUOLO != null) {
			setFK_ID_RUOLO(FK_ID_RUOLO);
		}

		String FK_ID_PERMESSO = (String)attributes.get("FK_ID_PERMESSO");

		if (FK_ID_PERMESSO != null) {
			setFK_ID_PERMESSO(FK_ID_PERMESSO);
		}
	}

	@Override
	public RubricaRuoloPermessi cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the fk_id_permesso of this rubrica ruolo permessi.
	 *
	 * @return the fk_id_permesso of this rubrica ruolo permessi
	 */
	@Override
	public String getFK_ID_PERMESSO() {
		return model.getFK_ID_PERMESSO();
	}

	/**
	 * Returns the fk_id_ruolo of this rubrica ruolo permessi.
	 *
	 * @return the fk_id_ruolo of this rubrica ruolo permessi
	 */
	@Override
	public long getFK_ID_RUOLO() {
		return model.getFK_ID_RUOLO();
	}

	/**
	 * Returns the primary key of this rubrica ruolo permessi.
	 *
	 * @return the primary key of this rubrica ruolo permessi
	 */
	@Override
	public it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the fk_id_permesso of this rubrica ruolo permessi.
	 *
	 * @param FK_ID_PERMESSO the fk_id_permesso of this rubrica ruolo permessi
	 */
	@Override
	public void setFK_ID_PERMESSO(String FK_ID_PERMESSO) {
		model.setFK_ID_PERMESSO(FK_ID_PERMESSO);
	}

	/**
	 * Sets the fk_id_ruolo of this rubrica ruolo permessi.
	 *
	 * @param FK_ID_RUOLO the fk_id_ruolo of this rubrica ruolo permessi
	 */
	@Override
	public void setFK_ID_RUOLO(long FK_ID_RUOLO) {
		model.setFK_ID_RUOLO(FK_ID_RUOLO);
	}

	/**
	 * Sets the primary key of this rubrica ruolo permessi.
	 *
	 * @param primaryKey the primary key of this rubrica ruolo permessi
	 */
	@Override
	public void setPrimaryKey(
		it.eng.allerte.service.persistence.RubricaRuoloPermessiPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RubricaRuoloPermessiWrapper wrap(
		RubricaRuoloPermessi rubricaRuoloPermessi) {

		return new RubricaRuoloPermessiWrapper(rubricaRuoloPermessi);
	}

}