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
 * This class is a wrapper for {@link Idrometro}.
 * </p>
 *
 * @author GFAVINI
 * @see Idrometro
 * @generated
 */
public class IdrometroWrapper
	extends BaseModelWrapper<Idrometro>
	implements Idrometro, ModelWrapper<Idrometro> {

	public IdrometroWrapper(Idrometro idrometro) {
		super(idrometro);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stazioneId", getStazioneId());
		attributes.put("nomeBacino", getNomeBacino());
		attributes.put("nomeSottobacino", getNomeSottobacino());
		attributes.put("nomeRubrica", getNomeRubrica());
		attributes.put("sogliaSpike", getSogliaSpike());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String stazioneId = (String)attributes.get("stazioneId");

		if (stazioneId != null) {
			setStazioneId(stazioneId);
		}

		String nomeBacino = (String)attributes.get("nomeBacino");

		if (nomeBacino != null) {
			setNomeBacino(nomeBacino);
		}

		String nomeSottobacino = (String)attributes.get("nomeSottobacino");

		if (nomeSottobacino != null) {
			setNomeSottobacino(nomeSottobacino);
		}

		String nomeRubrica = (String)attributes.get("nomeRubrica");

		if (nomeRubrica != null) {
			setNomeRubrica(nomeRubrica);
		}

		Double sogliaSpike = (Double)attributes.get("sogliaSpike");

		if (sogliaSpike != null) {
			setSogliaSpike(sogliaSpike);
		}
	}

	@Override
	public Idrometro cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the nome bacino of this idrometro.
	 *
	 * @return the nome bacino of this idrometro
	 */
	@Override
	public String getNomeBacino() {
		return model.getNomeBacino();
	}

	/**
	 * Returns the nome rubrica of this idrometro.
	 *
	 * @return the nome rubrica of this idrometro
	 */
	@Override
	public String getNomeRubrica() {
		return model.getNomeRubrica();
	}

	/**
	 * Returns the nome sottobacino of this idrometro.
	 *
	 * @return the nome sottobacino of this idrometro
	 */
	@Override
	public String getNomeSottobacino() {
		return model.getNomeSottobacino();
	}

	/**
	 * Returns the primary key of this idrometro.
	 *
	 * @return the primary key of this idrometro
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the soglia spike of this idrometro.
	 *
	 * @return the soglia spike of this idrometro
	 */
	@Override
	public double getSogliaSpike() {
		return model.getSogliaSpike();
	}

	/**
	 * Returns the stazione ID of this idrometro.
	 *
	 * @return the stazione ID of this idrometro
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
	 * Sets the nome bacino of this idrometro.
	 *
	 * @param nomeBacino the nome bacino of this idrometro
	 */
	@Override
	public void setNomeBacino(String nomeBacino) {
		model.setNomeBacino(nomeBacino);
	}

	/**
	 * Sets the nome rubrica of this idrometro.
	 *
	 * @param nomeRubrica the nome rubrica of this idrometro
	 */
	@Override
	public void setNomeRubrica(String nomeRubrica) {
		model.setNomeRubrica(nomeRubrica);
	}

	/**
	 * Sets the nome sottobacino of this idrometro.
	 *
	 * @param nomeSottobacino the nome sottobacino of this idrometro
	 */
	@Override
	public void setNomeSottobacino(String nomeSottobacino) {
		model.setNomeSottobacino(nomeSottobacino);
	}

	/**
	 * Sets the primary key of this idrometro.
	 *
	 * @param primaryKey the primary key of this idrometro
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the soglia spike of this idrometro.
	 *
	 * @param sogliaSpike the soglia spike of this idrometro
	 */
	@Override
	public void setSogliaSpike(double sogliaSpike) {
		model.setSogliaSpike(sogliaSpike);
	}

	/**
	 * Sets the stazione ID of this idrometro.
	 *
	 * @param stazioneId the stazione ID of this idrometro
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
	protected IdrometroWrapper wrap(Idrometro idrometro) {
		return new IdrometroWrapper(idrometro);
	}

}