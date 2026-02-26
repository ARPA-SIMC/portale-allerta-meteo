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
 * This class is a wrapper for {@link RubricaCanale}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaCanale
 * @generated
 */
public class RubricaCanaleWrapper
	extends BaseModelWrapper<RubricaCanale>
	implements ModelWrapper<RubricaCanale>, RubricaCanale {

	public RubricaCanaleWrapper(RubricaCanale rubricaCanale) {
		super(rubricaCanale);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_CANALE", getID_CANALE());
		attributes.put("NOME", getNOME());
		attributes.put("ICONA", getICONA());
		attributes.put("REGEX", getREGEX());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_CANALE = (Long)attributes.get("ID_CANALE");

		if (ID_CANALE != null) {
			setID_CANALE(ID_CANALE);
		}

		String NOME = (String)attributes.get("NOME");

		if (NOME != null) {
			setNOME(NOME);
		}

		String ICONA = (String)attributes.get("ICONA");

		if (ICONA != null) {
			setICONA(ICONA);
		}

		String REGEX = (String)attributes.get("REGEX");

		if (REGEX != null) {
			setREGEX(REGEX);
		}
	}

	@Override
	public RubricaCanale cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the icona of this rubrica canale.
	 *
	 * @return the icona of this rubrica canale
	 */
	@Override
	public String getICONA() {
		return model.getICONA();
	}

	/**
	 * Returns the id_canale of this rubrica canale.
	 *
	 * @return the id_canale of this rubrica canale
	 */
	@Override
	public long getID_CANALE() {
		return model.getID_CANALE();
	}

	/**
	 * Returns the nome of this rubrica canale.
	 *
	 * @return the nome of this rubrica canale
	 */
	@Override
	public String getNOME() {
		return model.getNOME();
	}

	/**
	 * Returns the primary key of this rubrica canale.
	 *
	 * @return the primary key of this rubrica canale
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the regex of this rubrica canale.
	 *
	 * @return the regex of this rubrica canale
	 */
	@Override
	public String getREGEX() {
		return model.getREGEX();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the icona of this rubrica canale.
	 *
	 * @param ICONA the icona of this rubrica canale
	 */
	@Override
	public void setICONA(String ICONA) {
		model.setICONA(ICONA);
	}

	/**
	 * Sets the id_canale of this rubrica canale.
	 *
	 * @param ID_CANALE the id_canale of this rubrica canale
	 */
	@Override
	public void setID_CANALE(long ID_CANALE) {
		model.setID_CANALE(ID_CANALE);
	}

	/**
	 * Sets the nome of this rubrica canale.
	 *
	 * @param NOME the nome of this rubrica canale
	 */
	@Override
	public void setNOME(String NOME) {
		model.setNOME(NOME);
	}

	/**
	 * Sets the primary key of this rubrica canale.
	 *
	 * @param primaryKey the primary key of this rubrica canale
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the regex of this rubrica canale.
	 *
	 * @param REGEX the regex of this rubrica canale
	 */
	@Override
	public void setREGEX(String REGEX) {
		model.setREGEX(REGEX);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RubricaCanaleWrapper wrap(RubricaCanale rubricaCanale) {
		return new RubricaCanaleWrapper(rubricaCanale);
	}

}