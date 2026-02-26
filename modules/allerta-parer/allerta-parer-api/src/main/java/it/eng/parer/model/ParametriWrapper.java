/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Parametri}.
 * </p>
 *
 * @author Pratola_L
 * @see Parametri
 * @generated
 */
public class ParametriWrapper
	extends BaseModelWrapper<Parametri>
	implements ModelWrapper<Parametri>, Parametri {

	public ParametriWrapper(Parametri parametri) {
		super(parametri);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("chiave", getChiave());
		attributes.put("valore", getValore());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String chiave = (String)attributes.get("chiave");

		if (chiave != null) {
			setChiave(chiave);
		}

		String valore = (String)attributes.get("valore");

		if (valore != null) {
			setValore(valore);
		}
	}

	@Override
	public Parametri cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the chiave of this parametri.
	 *
	 * @return the chiave of this parametri
	 */
	@Override
	public String getChiave() {
		return model.getChiave();
	}

	/**
	 * Returns the primary key of this parametri.
	 *
	 * @return the primary key of this parametri
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the valore of this parametri.
	 *
	 * @return the valore of this parametri
	 */
	@Override
	public String getValore() {
		return model.getValore();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the chiave of this parametri.
	 *
	 * @param chiave the chiave of this parametri
	 */
	@Override
	public void setChiave(String chiave) {
		model.setChiave(chiave);
	}

	/**
	 * Sets the primary key of this parametri.
	 *
	 * @param primaryKey the primary key of this parametri
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the valore of this parametri.
	 *
	 * @param valore the valore of this parametri
	 */
	@Override
	public void setValore(String valore) {
		model.setValore(valore);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ParametriWrapper wrap(Parametri parametri) {
		return new ParametriWrapper(parametri);
	}

}