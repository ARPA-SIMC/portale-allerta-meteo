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
 * This class is a wrapper for {@link RubricaGruppoNominativi}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativi
 * @generated
 */
public class RubricaGruppoNominativiWrapper
	extends BaseModelWrapper<RubricaGruppoNominativi>
	implements ModelWrapper<RubricaGruppoNominativi>, RubricaGruppoNominativi {

	public RubricaGruppoNominativiWrapper(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		super(rubricaGruppoNominativi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("FK_GRUPPO", getFK_GRUPPO());
		attributes.put("FK_NOMINATIVO", getFK_NOMINATIVO());
		attributes.put("FK_RUOLO", getFK_RUOLO());
		attributes.put("SPECIFICA_RUOLO", getSPECIFICA_RUOLO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long FK_GRUPPO = (Long)attributes.get("FK_GRUPPO");

		if (FK_GRUPPO != null) {
			setFK_GRUPPO(FK_GRUPPO);
		}

		Long FK_NOMINATIVO = (Long)attributes.get("FK_NOMINATIVO");

		if (FK_NOMINATIVO != null) {
			setFK_NOMINATIVO(FK_NOMINATIVO);
		}

		Long FK_RUOLO = (Long)attributes.get("FK_RUOLO");

		if (FK_RUOLO != null) {
			setFK_RUOLO(FK_RUOLO);
		}

		String SPECIFICA_RUOLO = (String)attributes.get("SPECIFICA_RUOLO");

		if (SPECIFICA_RUOLO != null) {
			setSPECIFICA_RUOLO(SPECIFICA_RUOLO);
		}
	}

	@Override
	public RubricaGruppoNominativi cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the fk_gruppo of this rubrica gruppo nominativi.
	 *
	 * @return the fk_gruppo of this rubrica gruppo nominativi
	 */
	@Override
	public long getFK_GRUPPO() {
		return model.getFK_GRUPPO();
	}

	/**
	 * Returns the fk_nominativo of this rubrica gruppo nominativi.
	 *
	 * @return the fk_nominativo of this rubrica gruppo nominativi
	 */
	@Override
	public long getFK_NOMINATIVO() {
		return model.getFK_NOMINATIVO();
	}

	/**
	 * Returns the fk_ruolo of this rubrica gruppo nominativi.
	 *
	 * @return the fk_ruolo of this rubrica gruppo nominativi
	 */
	@Override
	public long getFK_RUOLO() {
		return model.getFK_RUOLO();
	}

	/**
	 * Returns the primary key of this rubrica gruppo nominativi.
	 *
	 * @return the primary key of this rubrica gruppo nominativi
	 */
	@Override
	public it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the specifica_ruolo of this rubrica gruppo nominativi.
	 *
	 * @return the specifica_ruolo of this rubrica gruppo nominativi
	 */
	@Override
	public String getSPECIFICA_RUOLO() {
		return model.getSPECIFICA_RUOLO();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the fk_gruppo of this rubrica gruppo nominativi.
	 *
	 * @param FK_GRUPPO the fk_gruppo of this rubrica gruppo nominativi
	 */
	@Override
	public void setFK_GRUPPO(long FK_GRUPPO) {
		model.setFK_GRUPPO(FK_GRUPPO);
	}

	/**
	 * Sets the fk_nominativo of this rubrica gruppo nominativi.
	 *
	 * @param FK_NOMINATIVO the fk_nominativo of this rubrica gruppo nominativi
	 */
	@Override
	public void setFK_NOMINATIVO(long FK_NOMINATIVO) {
		model.setFK_NOMINATIVO(FK_NOMINATIVO);
	}

	/**
	 * Sets the fk_ruolo of this rubrica gruppo nominativi.
	 *
	 * @param FK_RUOLO the fk_ruolo of this rubrica gruppo nominativi
	 */
	@Override
	public void setFK_RUOLO(long FK_RUOLO) {
		model.setFK_RUOLO(FK_RUOLO);
	}

	/**
	 * Sets the primary key of this rubrica gruppo nominativi.
	 *
	 * @param primaryKey the primary key of this rubrica gruppo nominativi
	 */
	@Override
	public void setPrimaryKey(
		it.eng.allerte.service.persistence.RubricaGruppoNominativiPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the specifica_ruolo of this rubrica gruppo nominativi.
	 *
	 * @param SPECIFICA_RUOLO the specifica_ruolo of this rubrica gruppo nominativi
	 */
	@Override
	public void setSPECIFICA_RUOLO(String SPECIFICA_RUOLO) {
		model.setSPECIFICA_RUOLO(SPECIFICA_RUOLO);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RubricaGruppoNominativiWrapper wrap(
		RubricaGruppoNominativi rubricaGruppoNominativi) {

		return new RubricaGruppoNominativiWrapper(rubricaGruppoNominativi);
	}

}