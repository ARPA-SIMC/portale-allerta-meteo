/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Pluviometro}.
 * </p>
 *
 * @author GFAVINI
 * @see Pluviometro
 * @generated
 */
public class PluviometroWrapper
	extends BaseModelWrapper<Pluviometro>
	implements ModelWrapper<Pluviometro>, Pluviometro {

	public PluviometroWrapper(Pluviometro pluviometro) {
		super(pluviometro);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stazioneId", getStazioneId());
		attributes.put("nomeGruppo", getNomeGruppo());
		attributes.put("nomeRubrica", getNomeRubrica());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String stazioneId = (String)attributes.get("stazioneId");

		if (stazioneId != null) {
			setStazioneId(stazioneId);
		}

		String nomeGruppo = (String)attributes.get("nomeGruppo");

		if (nomeGruppo != null) {
			setNomeGruppo(nomeGruppo);
		}

		String nomeRubrica = (String)attributes.get("nomeRubrica");

		if (nomeRubrica != null) {
			setNomeRubrica(nomeRubrica);
		}
	}

	@Override
	public Pluviometro cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the nome gruppo of this pluviometro.
	 *
	 * @return the nome gruppo of this pluviometro
	 */
	@Override
	public String getNomeGruppo() {
		return model.getNomeGruppo();
	}

	/**
	 * Returns the nome rubrica of this pluviometro.
	 *
	 * @return the nome rubrica of this pluviometro
	 */
	@Override
	public String getNomeRubrica() {
		return model.getNomeRubrica();
	}

	/**
	 * Returns the primary key of this pluviometro.
	 *
	 * @return the primary key of this pluviometro
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stazione ID of this pluviometro.
	 *
	 * @return the stazione ID of this pluviometro
	 */
	@Override
	public String getStazioneId() {
		return model.getStazioneId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the nome gruppo of this pluviometro.
	 *
	 * @param nomeGruppo the nome gruppo of this pluviometro
	 */
	@Override
	public void setNomeGruppo(String nomeGruppo) {
		model.setNomeGruppo(nomeGruppo);
	}

	/**
	 * Sets the nome rubrica of this pluviometro.
	 *
	 * @param nomeRubrica the nome rubrica of this pluviometro
	 */
	@Override
	public void setNomeRubrica(String nomeRubrica) {
		model.setNomeRubrica(nomeRubrica);
	}

	/**
	 * Sets the primary key of this pluviometro.
	 *
	 * @param primaryKey the primary key of this pluviometro
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stazione ID of this pluviometro.
	 *
	 * @param stazioneId the stazione ID of this pluviometro
	 */
	@Override
	public void setStazioneId(String stazioneId) {
		model.setStazioneId(stazioneId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PluviometroWrapper wrap(Pluviometro pluviometro) {
		return new PluviometroWrapper(pluviometro);
	}

}