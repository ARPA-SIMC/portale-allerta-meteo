/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Auth}.
 * </p>
 *
 * @author Giorgianni_F
 * @see Auth
 * @generated
 */
public class AuthWrapper
	extends BaseModelWrapper<Auth> implements Auth, ModelWrapper<Auth> {

	public AuthWrapper(Auth auth) {
		super(auth);
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
	public Auth cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the key of this auth.
	 *
	 * @return the key of this auth
	 */
	@Override
	public String getKey() {
		return model.getKey();
	}

	/**
	 * Returns the primary key of this auth.
	 *
	 * @return the primary key of this auth
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the value of this auth.
	 *
	 * @return the value of this auth
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
	 * Sets the key of this auth.
	 *
	 * @param key the key of this auth
	 */
	@Override
	public void setKey(String key) {
		model.setKey(key);
	}

	/**
	 * Sets the primary key of this auth.
	 *
	 * @param primaryKey the primary key of this auth
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the value of this auth.
	 *
	 * @param value the value of this auth
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
	protected AuthWrapper wrap(Auth auth) {
		return new AuthWrapper(auth);
	}

}