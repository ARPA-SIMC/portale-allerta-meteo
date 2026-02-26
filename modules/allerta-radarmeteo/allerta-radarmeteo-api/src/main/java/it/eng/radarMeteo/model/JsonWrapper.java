/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Json}.
 * </p>
 *
 * @author Francesco
 * @see Json
 * @generated
 */
public class JsonWrapper
	extends BaseModelWrapper<Json> implements Json, ModelWrapper<Json> {

	public JsonWrapper(Json json) {
		super(json);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("type", getType());
		attributes.put("inserted", getInserted());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long inserted = (Long)attributes.get("inserted");

		if (inserted != null) {
			setInserted(inserted);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	@Override
	public Json cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the data of this json.
	 *
	 * @return the data of this json
	 */
	@Override
	public String getData() {
		return model.getData();
	}

	/**
	 * Returns the ID of this json.
	 *
	 * @return the ID of this json
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the inserted of this json.
	 *
	 * @return the inserted of this json
	 */
	@Override
	public long getInserted() {
		return model.getInserted();
	}

	/**
	 * Returns the primary key of this json.
	 *
	 * @return the primary key of this json
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this json.
	 *
	 * @return the type of this json
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data of this json.
	 *
	 * @param data the data of this json
	 */
	@Override
	public void setData(String data) {
		model.setData(data);
	}

	/**
	 * Sets the ID of this json.
	 *
	 * @param id the ID of this json
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the inserted of this json.
	 *
	 * @param inserted the inserted of this json
	 */
	@Override
	public void setInserted(long inserted) {
		model.setInserted(inserted);
	}

	/**
	 * Sets the primary key of this json.
	 *
	 * @param primaryKey the primary key of this json
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this json.
	 *
	 * @param type the type of this json
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected JsonWrapper wrap(Json json) {
		return new JsonWrapper(json);
	}

}