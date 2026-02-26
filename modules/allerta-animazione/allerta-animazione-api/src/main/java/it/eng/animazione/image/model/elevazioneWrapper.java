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
 * This class is a wrapper for {@link elevazione}.
 * </p>
 *
 * @author UTENTE
 * @see elevazione
 * @generated
 */
public class elevazioneWrapper
	extends BaseModelWrapper<elevazione>
	implements elevazione, ModelWrapper<elevazione> {

	public elevazioneWrapper(elevazione elevazione) {
		super(elevazione);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("im", getIm());
		attributes.put("text_LOC", getText_LOC());
		attributes.put("ts_UTC", getTs_UTC());
		attributes.put("imgData", getImgData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String im = (String)attributes.get("im");

		if (im != null) {
			setIm(im);
		}

		String text_LOC = (String)attributes.get("text_LOC");

		if (text_LOC != null) {
			setText_LOC(text_LOC);
		}

		Long ts_UTC = (Long)attributes.get("ts_UTC");

		if (ts_UTC != null) {
			setTs_UTC(ts_UTC);
		}

		String imgData = (String)attributes.get("imgData");

		if (imgData != null) {
			setImgData(imgData);
		}
	}

	@Override
	public elevazione cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this elevazione.
	 *
	 * @return the ID of this elevazione
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the im of this elevazione.
	 *
	 * @return the im of this elevazione
	 */
	@Override
	public String getIm() {
		return model.getIm();
	}

	/**
	 * Returns the img data of this elevazione.
	 *
	 * @return the img data of this elevazione
	 */
	@Override
	public String getImgData() {
		return model.getImgData();
	}

	/**
	 * Returns the primary key of this elevazione.
	 *
	 * @return the primary key of this elevazione
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the text_loc of this elevazione.
	 *
	 * @return the text_loc of this elevazione
	 */
	@Override
	public String getText_LOC() {
		return model.getText_LOC();
	}

	/**
	 * Returns the ts_utc of this elevazione.
	 *
	 * @return the ts_utc of this elevazione
	 */
	@Override
	public long getTs_UTC() {
		return model.getTs_UTC();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this elevazione.
	 *
	 * @param id the ID of this elevazione
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the im of this elevazione.
	 *
	 * @param im the im of this elevazione
	 */
	@Override
	public void setIm(String im) {
		model.setIm(im);
	}

	/**
	 * Sets the img data of this elevazione.
	 *
	 * @param imgData the img data of this elevazione
	 */
	@Override
	public void setImgData(String imgData) {
		model.setImgData(imgData);
	}

	/**
	 * Sets the primary key of this elevazione.
	 *
	 * @param primaryKey the primary key of this elevazione
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the text_loc of this elevazione.
	 *
	 * @param text_LOC the text_loc of this elevazione
	 */
	@Override
	public void setText_LOC(String text_LOC) {
		model.setText_LOC(text_LOC);
	}

	/**
	 * Sets the ts_utc of this elevazione.
	 *
	 * @param ts_UTC the ts_utc of this elevazione
	 */
	@Override
	public void setTs_UTC(long ts_UTC) {
		model.setTs_UTC(ts_UTC);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected elevazioneWrapper wrap(elevazione elevazione) {
		return new elevazioneWrapper(elevazione);
	}

}