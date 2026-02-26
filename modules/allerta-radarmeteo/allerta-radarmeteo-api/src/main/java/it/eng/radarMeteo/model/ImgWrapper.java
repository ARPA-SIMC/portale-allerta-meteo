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
 * This class is a wrapper for {@link Img}.
 * </p>
 *
 * @author Francesco
 * @see Img
 * @generated
 */
public class ImgWrapper
	extends BaseModelWrapper<Img> implements Img, ModelWrapper<Img> {

	public ImgWrapper(Img img) {
		super(img);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("coord", getCoord());
		attributes.put("palette", getPalette());
		attributes.put("timestamp", getTimestamp());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String coord = (String)attributes.get("coord");

		if (coord != null) {
			setCoord(coord);
		}

		String palette = (String)attributes.get("palette");

		if (palette != null) {
			setPalette(palette);
		}

		Long timestamp = (Long)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	@Override
	public Img cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the coord of this img.
	 *
	 * @return the coord of this img
	 */
	@Override
	public String getCoord() {
		return model.getCoord();
	}

	/**
	 * Returns the data of this img.
	 *
	 * @return the data of this img
	 */
	@Override
	public String getData() {
		return model.getData();
	}

	/**
	 * Returns the ID of this img.
	 *
	 * @return the ID of this img
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the palette of this img.
	 *
	 * @return the palette of this img
	 */
	@Override
	public String getPalette() {
		return model.getPalette();
	}

	/**
	 * Returns the primary key of this img.
	 *
	 * @return the primary key of this img
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the timestamp of this img.
	 *
	 * @return the timestamp of this img
	 */
	@Override
	public long getTimestamp() {
		return model.getTimestamp();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the coord of this img.
	 *
	 * @param coord the coord of this img
	 */
	@Override
	public void setCoord(String coord) {
		model.setCoord(coord);
	}

	/**
	 * Sets the data of this img.
	 *
	 * @param data the data of this img
	 */
	@Override
	public void setData(String data) {
		model.setData(data);
	}

	/**
	 * Sets the ID of this img.
	 *
	 * @param id the ID of this img
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the palette of this img.
	 *
	 * @param palette the palette of this img
	 */
	@Override
	public void setPalette(String palette) {
		model.setPalette(palette);
	}

	/**
	 * Sets the primary key of this img.
	 *
	 * @param primaryKey the primary key of this img
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the timestamp of this img.
	 *
	 * @param timestamp the timestamp of this img
	 */
	@Override
	public void setTimestamp(long timestamp) {
		model.setTimestamp(timestamp);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ImgWrapper wrap(Img img) {
		return new ImgWrapper(img);
	}

}