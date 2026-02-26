/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link StazioneVariabile}.
 * </p>
 *
 * @author GFAVINI
 * @see StazioneVariabile
 * @generated
 */
public class StazioneVariabileWrapper
	extends BaseModelWrapper<StazioneVariabile>
	implements ModelWrapper<StazioneVariabile>, StazioneVariabile {

	public StazioneVariabileWrapper(StazioneVariabile stazioneVariabile) {
		super(stazioneVariabile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("idStazione", getIdStazione());
		attributes.put("idVariabile", getIdVariabile());
		attributes.put("dataUltimoValore", getDataUltimoValore());
		attributes.put("soglia1", getSoglia1());
		attributes.put("soglia2", getSoglia2());
		attributes.put("soglia3", getSoglia3());

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

		String idStazione = (String)attributes.get("idStazione");

		if (idStazione != null) {
			setIdStazione(idStazione);
		}

		String idVariabile = (String)attributes.get("idVariabile");

		if (idVariabile != null) {
			setIdVariabile(idVariabile);
		}

		Date dataUltimoValore = (Date)attributes.get("dataUltimoValore");

		if (dataUltimoValore != null) {
			setDataUltimoValore(dataUltimoValore);
		}

		Double soglia1 = (Double)attributes.get("soglia1");

		if (soglia1 != null) {
			setSoglia1(soglia1);
		}

		Double soglia2 = (Double)attributes.get("soglia2");

		if (soglia2 != null) {
			setSoglia2(soglia2);
		}

		Double soglia3 = (Double)attributes.get("soglia3");

		if (soglia3 != null) {
			setSoglia3(soglia3);
		}
	}

	@Override
	public StazioneVariabile cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the data ultimo valore of this stazione variabile.
	 *
	 * @return the data ultimo valore of this stazione variabile
	 */
	@Override
	public Date getDataUltimoValore() {
		return model.getDataUltimoValore();
	}

	/**
	 * Returns the ID of this stazione variabile.
	 *
	 * @return the ID of this stazione variabile
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id stazione of this stazione variabile.
	 *
	 * @return the id stazione of this stazione variabile
	 */
	@Override
	public String getIdStazione() {
		return model.getIdStazione();
	}

	/**
	 * Returns the id variabile of this stazione variabile.
	 *
	 * @return the id variabile of this stazione variabile
	 */
	@Override
	public String getIdVariabile() {
		return model.getIdVariabile();
	}

	/**
	 * Returns the primary key of this stazione variabile.
	 *
	 * @return the primary key of this stazione variabile
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the soglia1 of this stazione variabile.
	 *
	 * @return the soglia1 of this stazione variabile
	 */
	@Override
	public double getSoglia1() {
		return model.getSoglia1();
	}

	/**
	 * Returns the soglia2 of this stazione variabile.
	 *
	 * @return the soglia2 of this stazione variabile
	 */
	@Override
	public double getSoglia2() {
		return model.getSoglia2();
	}

	/**
	 * Returns the soglia3 of this stazione variabile.
	 *
	 * @return the soglia3 of this stazione variabile
	 */
	@Override
	public double getSoglia3() {
		return model.getSoglia3();
	}

	/**
	 * Returns the uuid of this stazione variabile.
	 *
	 * @return the uuid of this stazione variabile
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data ultimo valore of this stazione variabile.
	 *
	 * @param dataUltimoValore the data ultimo valore of this stazione variabile
	 */
	@Override
	public void setDataUltimoValore(Date dataUltimoValore) {
		model.setDataUltimoValore(dataUltimoValore);
	}

	/**
	 * Sets the ID of this stazione variabile.
	 *
	 * @param id the ID of this stazione variabile
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id stazione of this stazione variabile.
	 *
	 * @param idStazione the id stazione of this stazione variabile
	 */
	@Override
	public void setIdStazione(String idStazione) {
		model.setIdStazione(idStazione);
	}

	/**
	 * Sets the id variabile of this stazione variabile.
	 *
	 * @param idVariabile the id variabile of this stazione variabile
	 */
	@Override
	public void setIdVariabile(String idVariabile) {
		model.setIdVariabile(idVariabile);
	}

	/**
	 * Sets the primary key of this stazione variabile.
	 *
	 * @param primaryKey the primary key of this stazione variabile
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the soglia1 of this stazione variabile.
	 *
	 * @param soglia1 the soglia1 of this stazione variabile
	 */
	@Override
	public void setSoglia1(double soglia1) {
		model.setSoglia1(soglia1);
	}

	/**
	 * Sets the soglia2 of this stazione variabile.
	 *
	 * @param soglia2 the soglia2 of this stazione variabile
	 */
	@Override
	public void setSoglia2(double soglia2) {
		model.setSoglia2(soglia2);
	}

	/**
	 * Sets the soglia3 of this stazione variabile.
	 *
	 * @param soglia3 the soglia3 of this stazione variabile
	 */
	@Override
	public void setSoglia3(double soglia3) {
		model.setSoglia3(soglia3);
	}

	/**
	 * Sets the uuid of this stazione variabile.
	 *
	 * @param uuid the uuid of this stazione variabile
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected StazioneVariabileWrapper wrap(
		StazioneVariabile stazioneVariabile) {

		return new StazioneVariabileWrapper(stazioneVariabile);
	}

}