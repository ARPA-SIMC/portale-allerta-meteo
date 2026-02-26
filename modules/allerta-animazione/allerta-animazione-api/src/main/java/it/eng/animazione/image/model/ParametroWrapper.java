/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Parametro}.
 * </p>
 *
 * @author UTENTE
 * @see Parametro
 * @generated
 */
public class ParametroWrapper
	extends BaseModelWrapper<Parametro>
	implements ModelWrapper<Parametro>, Parametro {

	public ParametroWrapper(Parametro parametro) {
		super(parametro);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("key", getKey());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public Parametro cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the key of this parametro.
	 *
	 * @return the key of this parametro
	 */
	@Override
	public String getKey() {
		return model.getKey();
	}

	/**
	 * Returns the primary key of this parametro.
	 *
	 * @return the primary key of this parametro
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the value of this parametro.
	 *
	 * @return the value of this parametro
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the key of this parametro.
	 *
	 * @param key the key of this parametro
	 */
	@Override
	public void setKey(String key) {
		model.setKey(key);
	}

	/**
	 * Sets the primary key of this parametro.
	 *
	 * @param primaryKey the primary key of this parametro
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the value of this parametro.
	 *
	 * @param value the value of this parametro
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ParametroWrapper wrap(Parametro parametro) {
		return new ParametroWrapper(parametro);
	}

}