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
 * This class is a wrapper for {@link ValoreSensore}.
 * </p>
 *
 * @author GFAVINI
 * @see ValoreSensore
 * @generated
 */
public class ValoreSensoreWrapper
	extends BaseModelWrapper<ValoreSensore>
	implements ModelWrapper<ValoreSensore>, ValoreSensore {

	public ValoreSensoreWrapper(ValoreSensore valoreSensore) {
		super(valoreSensore);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("value", getValue());
		attributes.put("datetime", getDatetime());
		attributes.put("idVariabile", getIdVariabile());
		attributes.put("idStazione", getIdStazione());

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

		Double value = (Double)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Date datetime = (Date)attributes.get("datetime");

		if (datetime != null) {
			setDatetime(datetime);
		}

		String idVariabile = (String)attributes.get("idVariabile");

		if (idVariabile != null) {
			setIdVariabile(idVariabile);
		}

		String idStazione = (String)attributes.get("idStazione");

		if (idStazione != null) {
			setIdStazione(idStazione);
		}
	}

	@Override
	public ValoreSensore cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the datetime of this valore sensore.
	 *
	 * @return the datetime of this valore sensore
	 */
	@Override
	public Date getDatetime() {
		return model.getDatetime();
	}

	/**
	 * Returns the ID of this valore sensore.
	 *
	 * @return the ID of this valore sensore
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id stazione of this valore sensore.
	 *
	 * @return the id stazione of this valore sensore
	 */
	@Override
	public String getIdStazione() {
		return model.getIdStazione();
	}

	/**
	 * Returns the id variabile of this valore sensore.
	 *
	 * @return the id variabile of this valore sensore
	 */
	@Override
	public String getIdVariabile() {
		return model.getIdVariabile();
	}

	/**
	 * Returns the primary key of this valore sensore.
	 *
	 * @return the primary key of this valore sensore
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this valore sensore.
	 *
	 * @return the uuid of this valore sensore
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the value of this valore sensore.
	 *
	 * @return the value of this valore sensore
	 */
	@Override
	public double getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the datetime of this valore sensore.
	 *
	 * @param datetime the datetime of this valore sensore
	 */
	@Override
	public void setDatetime(Date datetime) {
		model.setDatetime(datetime);
	}

	/**
	 * Sets the ID of this valore sensore.
	 *
	 * @param id the ID of this valore sensore
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id stazione of this valore sensore.
	 *
	 * @param idStazione the id stazione of this valore sensore
	 */
	@Override
	public void setIdStazione(String idStazione) {
		model.setIdStazione(idStazione);
	}

	/**
	 * Sets the id variabile of this valore sensore.
	 *
	 * @param idVariabile the id variabile of this valore sensore
	 */
	@Override
	public void setIdVariabile(String idVariabile) {
		model.setIdVariabile(idVariabile);
	}

	/**
	 * Sets the primary key of this valore sensore.
	 *
	 * @param primaryKey the primary key of this valore sensore
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this valore sensore.
	 *
	 * @param uuid the uuid of this valore sensore
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the value of this valore sensore.
	 *
	 * @param value the value of this valore sensore
	 */
	@Override
	public void setValue(double value) {
		model.setValue(value);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ValoreSensoreWrapper wrap(ValoreSensore valoreSensore) {
		return new ValoreSensoreWrapper(valoreSensore);
	}

}