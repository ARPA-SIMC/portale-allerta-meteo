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
 * This class is a wrapper for {@link RegolaAllarmeCondizione}.
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmeCondizione
 * @generated
 */
public class RegolaAllarmeCondizioneWrapper
	extends BaseModelWrapper<RegolaAllarmeCondizione>
	implements ModelWrapper<RegolaAllarmeCondizione>, RegolaAllarmeCondizione {

	public RegolaAllarmeCondizioneWrapper(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		super(regolaAllarmeCondizione);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("idRegola", getIdRegola());
		attributes.put("lettera", getLettera());
		attributes.put("idVariabile", getIdVariabile());
		attributes.put("idStazione", getIdStazione());
		attributes.put("idStazioneVariabile", getIdStazioneVariabile());
		attributes.put("soglia", getSoglia());
		attributes.put("valoreSoglia", getValoreSoglia());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long idRegola = (Long)attributes.get("idRegola");

		if (idRegola != null) {
			setIdRegola(idRegola);
		}

		String lettera = (String)attributes.get("lettera");

		if (lettera != null) {
			setLettera(lettera);
		}

		String idVariabile = (String)attributes.get("idVariabile");

		if (idVariabile != null) {
			setIdVariabile(idVariabile);
		}

		String idStazione = (String)attributes.get("idStazione");

		if (idStazione != null) {
			setIdStazione(idStazione);
		}

		Long idStazioneVariabile = (Long)attributes.get("idStazioneVariabile");

		if (idStazioneVariabile != null) {
			setIdStazioneVariabile(idStazioneVariabile);
		}

		Integer soglia = (Integer)attributes.get("soglia");

		if (soglia != null) {
			setSoglia(soglia);
		}

		Double valoreSoglia = (Double)attributes.get("valoreSoglia");

		if (valoreSoglia != null) {
			setValoreSoglia(valoreSoglia);
		}
	}

	@Override
	public RegolaAllarmeCondizione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this regola allarme condizione.
	 *
	 * @return the ID of this regola allarme condizione
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id regola of this regola allarme condizione.
	 *
	 * @return the id regola of this regola allarme condizione
	 */
	@Override
	public long getIdRegola() {
		return model.getIdRegola();
	}

	/**
	 * Returns the id stazione of this regola allarme condizione.
	 *
	 * @return the id stazione of this regola allarme condizione
	 */
	@Override
	public String getIdStazione() {
		return model.getIdStazione();
	}

	/**
	 * Returns the id stazione variabile of this regola allarme condizione.
	 *
	 * @return the id stazione variabile of this regola allarme condizione
	 */
	@Override
	public long getIdStazioneVariabile() {
		return model.getIdStazioneVariabile();
	}

	/**
	 * Returns the id variabile of this regola allarme condizione.
	 *
	 * @return the id variabile of this regola allarme condizione
	 */
	@Override
	public String getIdVariabile() {
		return model.getIdVariabile();
	}

	/**
	 * Returns the lettera of this regola allarme condizione.
	 *
	 * @return the lettera of this regola allarme condizione
	 */
	@Override
	public String getLettera() {
		return model.getLettera();
	}

	/**
	 * Returns the primary key of this regola allarme condizione.
	 *
	 * @return the primary key of this regola allarme condizione
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the soglia of this regola allarme condizione.
	 *
	 * @return the soglia of this regola allarme condizione
	 */
	@Override
	public int getSoglia() {
		return model.getSoglia();
	}

	/**
	 * Returns the uuid of this regola allarme condizione.
	 *
	 * @return the uuid of this regola allarme condizione
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the valore soglia of this regola allarme condizione.
	 *
	 * @return the valore soglia of this regola allarme condizione
	 */
	@Override
	public double getValoreSoglia() {
		return model.getValoreSoglia();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this regola allarme condizione.
	 *
	 * @param id the ID of this regola allarme condizione
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id regola of this regola allarme condizione.
	 *
	 * @param idRegola the id regola of this regola allarme condizione
	 */
	@Override
	public void setIdRegola(long idRegola) {
		model.setIdRegola(idRegola);
	}

	/**
	 * Sets the id stazione of this regola allarme condizione.
	 *
	 * @param idStazione the id stazione of this regola allarme condizione
	 */
	@Override
	public void setIdStazione(String idStazione) {
		model.setIdStazione(idStazione);
	}

	/**
	 * Sets the id stazione variabile of this regola allarme condizione.
	 *
	 * @param idStazioneVariabile the id stazione variabile of this regola allarme condizione
	 */
	@Override
	public void setIdStazioneVariabile(long idStazioneVariabile) {
		model.setIdStazioneVariabile(idStazioneVariabile);
	}

	/**
	 * Sets the id variabile of this regola allarme condizione.
	 *
	 * @param idVariabile the id variabile of this regola allarme condizione
	 */
	@Override
	public void setIdVariabile(String idVariabile) {
		model.setIdVariabile(idVariabile);
	}

	/**
	 * Sets the lettera of this regola allarme condizione.
	 *
	 * @param lettera the lettera of this regola allarme condizione
	 */
	@Override
	public void setLettera(String lettera) {
		model.setLettera(lettera);
	}

	/**
	 * Sets the primary key of this regola allarme condizione.
	 *
	 * @param primaryKey the primary key of this regola allarme condizione
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the soglia of this regola allarme condizione.
	 *
	 * @param soglia the soglia of this regola allarme condizione
	 */
	@Override
	public void setSoglia(int soglia) {
		model.setSoglia(soglia);
	}

	/**
	 * Sets the uuid of this regola allarme condizione.
	 *
	 * @param uuid the uuid of this regola allarme condizione
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the valore soglia of this regola allarme condizione.
	 *
	 * @param valoreSoglia the valore soglia of this regola allarme condizione
	 */
	@Override
	public void setValoreSoglia(double valoreSoglia) {
		model.setValoreSoglia(valoreSoglia);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RegolaAllarmeCondizioneWrapper wrap(
		RegolaAllarmeCondizione regolaAllarmeCondizione) {

		return new RegolaAllarmeCondizioneWrapper(regolaAllarmeCondizione);
	}

}