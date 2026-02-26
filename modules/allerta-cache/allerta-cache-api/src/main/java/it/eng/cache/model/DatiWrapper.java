/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.cache.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Dati}.
 * </p>
 *
 * @author GFAVINI
 * @see Dati
 * @generated
 */
public class DatiWrapper
	extends BaseModelWrapper<Dati> implements Dati, ModelWrapper<Dati> {

	public DatiWrapper(Dati dati) {
		super(dati);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idDati", getIdDati());
		attributes.put("dato", getDato());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String idDati = (String)attributes.get("idDati");

		if (idDati != null) {
			setIdDati(idDati);
		}

		String dato = (String)attributes.get("dato");

		if (dato != null) {
			setDato(dato);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public Dati cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this dati.
	 *
	 * @return the create date of this dati
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the dato of this dati.
	 *
	 * @return the dato of this dati
	 */
	@Override
	public String getDato() {
		return model.getDato();
	}

	/**
	 * Returns the id dati of this dati.
	 *
	 * @return the id dati of this dati
	 */
	@Override
	public String getIdDati() {
		return model.getIdDati();
	}

	/**
	 * Returns the primary key of this dati.
	 *
	 * @return the primary key of this dati
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this dati.
	 *
	 * @param createDate the create date of this dati
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the dato of this dati.
	 *
	 * @param dato the dato of this dati
	 */
	@Override
	public void setDato(String dato) {
		model.setDato(dato);
	}

	/**
	 * Sets the id dati of this dati.
	 *
	 * @param idDati the id dati of this dati
	 */
	@Override
	public void setIdDati(String idDati) {
		model.setIdDati(idDati);
	}

	/**
	 * Sets the primary key of this dati.
	 *
	 * @param primaryKey the primary key of this dati
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DatiWrapper wrap(Dati dati) {
		return new DatiWrapper(dati);
	}

}