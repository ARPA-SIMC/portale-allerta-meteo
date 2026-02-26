/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AnimeteoSmallImg}.
 * </p>
 *
 * @author UTENTE
 * @see AnimeteoSmallImg
 * @generated
 */
public class AnimeteoSmallImgWrapper
	extends BaseModelWrapper<AnimeteoSmallImg>
	implements AnimeteoSmallImg, ModelWrapper<AnimeteoSmallImg> {

	public AnimeteoSmallImgWrapper(AnimeteoSmallImg animeteoSmallImg) {
		super(animeteoSmallImg);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Date inserted = (Date)attributes.get("inserted");

		if (inserted != null) {
			setInserted(inserted);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	@Override
	public AnimeteoSmallImg cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the data of this animeteo small img.
	 *
	 * @return the data of this animeteo small img
	 */
	@Override
	public String getData() {
		return model.getData();
	}

	/**
	 * Returns the ID of this animeteo small img.
	 *
	 * @return the ID of this animeteo small img
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the inserted of this animeteo small img.
	 *
	 * @return the inserted of this animeteo small img
	 */
	@Override
	public Date getInserted() {
		return model.getInserted();
	}

	/**
	 * Returns the name of this animeteo small img.
	 *
	 * @return the name of this animeteo small img
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this animeteo small img.
	 *
	 * @return the primary key of this animeteo small img
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type of this animeteo small img.
	 *
	 * @return the type of this animeteo small img
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
	 * Sets the data of this animeteo small img.
	 *
	 * @param data the data of this animeteo small img
	 */
	@Override
	public void setData(String data) {
		model.setData(data);
	}

	/**
	 * Sets the ID of this animeteo small img.
	 *
	 * @param id the ID of this animeteo small img
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the inserted of this animeteo small img.
	 *
	 * @param inserted the inserted of this animeteo small img
	 */
	@Override
	public void setInserted(Date inserted) {
		model.setInserted(inserted);
	}

	/**
	 * Sets the name of this animeteo small img.
	 *
	 * @param name the name of this animeteo small img
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this animeteo small img.
	 *
	 * @param primaryKey the primary key of this animeteo small img
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type of this animeteo small img.
	 *
	 * @param type the type of this animeteo small img
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
	protected AnimeteoSmallImgWrapper wrap(AnimeteoSmallImg animeteoSmallImg) {
		return new AnimeteoSmallImgWrapper(animeteoSmallImg);
	}

}