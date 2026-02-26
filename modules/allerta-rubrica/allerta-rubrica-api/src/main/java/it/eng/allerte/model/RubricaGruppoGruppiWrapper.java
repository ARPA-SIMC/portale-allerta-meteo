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
 * This class is a wrapper for {@link RubricaGruppoGruppi}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppi
 * @generated
 */
public class RubricaGruppoGruppiWrapper
	extends BaseModelWrapper<RubricaGruppoGruppi>
	implements ModelWrapper<RubricaGruppoGruppi>, RubricaGruppoGruppi {

	public RubricaGruppoGruppiWrapper(RubricaGruppoGruppi rubricaGruppoGruppi) {
		super(rubricaGruppoGruppi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("FK_GRUPPO_PADRE", getFK_GRUPPO_PADRE());
		attributes.put("FK_GRUPPO_FIGLIO", getFK_GRUPPO_FIGLIO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long FK_GRUPPO_PADRE = (Long)attributes.get("FK_GRUPPO_PADRE");

		if (FK_GRUPPO_PADRE != null) {
			setFK_GRUPPO_PADRE(FK_GRUPPO_PADRE);
		}

		Long FK_GRUPPO_FIGLIO = (Long)attributes.get("FK_GRUPPO_FIGLIO");

		if (FK_GRUPPO_FIGLIO != null) {
			setFK_GRUPPO_FIGLIO(FK_GRUPPO_FIGLIO);
		}
	}

	@Override
	public RubricaGruppoGruppi cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the fk_gruppo_figlio of this rubrica gruppo gruppi.
	 *
	 * @return the fk_gruppo_figlio of this rubrica gruppo gruppi
	 */
	@Override
	public long getFK_GRUPPO_FIGLIO() {
		return model.getFK_GRUPPO_FIGLIO();
	}

	/**
	 * Returns the fk_gruppo_padre of this rubrica gruppo gruppi.
	 *
	 * @return the fk_gruppo_padre of this rubrica gruppo gruppi
	 */
	@Override
	public long getFK_GRUPPO_PADRE() {
		return model.getFK_GRUPPO_PADRE();
	}

	/**
	 * Returns the primary key of this rubrica gruppo gruppi.
	 *
	 * @return the primary key of this rubrica gruppo gruppi
	 */
	@Override
	public it.eng.allerte.service.persistence.RubricaGruppoGruppiPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the fk_gruppo_figlio of this rubrica gruppo gruppi.
	 *
	 * @param FK_GRUPPO_FIGLIO the fk_gruppo_figlio of this rubrica gruppo gruppi
	 */
	@Override
	public void setFK_GRUPPO_FIGLIO(long FK_GRUPPO_FIGLIO) {
		model.setFK_GRUPPO_FIGLIO(FK_GRUPPO_FIGLIO);
	}

	/**
	 * Sets the fk_gruppo_padre of this rubrica gruppo gruppi.
	 *
	 * @param FK_GRUPPO_PADRE the fk_gruppo_padre of this rubrica gruppo gruppi
	 */
	@Override
	public void setFK_GRUPPO_PADRE(long FK_GRUPPO_PADRE) {
		model.setFK_GRUPPO_PADRE(FK_GRUPPO_PADRE);
	}

	/**
	 * Sets the primary key of this rubrica gruppo gruppi.
	 *
	 * @param primaryKey the primary key of this rubrica gruppo gruppi
	 */
	@Override
	public void setPrimaryKey(
		it.eng.allerte.service.persistence.RubricaGruppoGruppiPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RubricaGruppoGruppiWrapper wrap(
		RubricaGruppoGruppi rubricaGruppoGruppi) {

		return new RubricaGruppoGruppiWrapper(rubricaGruppoGruppi);
	}

}