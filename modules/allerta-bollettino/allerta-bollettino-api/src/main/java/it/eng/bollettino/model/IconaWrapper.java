/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Icona}.
 * </p>
 *
 * @author GFAVINI
 * @see Icona
 * @generated
 */
public class IconaWrapper
	extends BaseModelWrapper<Icona> implements Icona, ModelWrapper<Icona> {

	public IconaWrapper(Icona icona) {
		super(icona);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("path", getPath());
		attributes.put("descrizione", getDescrizione());

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

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public Icona cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the descrizione of this icona.
	 *
	 * @return the descrizione of this icona
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the ID of this icona.
	 *
	 * @return the ID of this icona
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the path of this icona.
	 *
	 * @return the path of this icona
	 */
	@Override
	public String getPath() {
		return model.getPath();
	}

	/**
	 * Returns the primary key of this icona.
	 *
	 * @return the primary key of this icona
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this icona.
	 *
	 * @return the uuid of this icona
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the descrizione of this icona.
	 *
	 * @param descrizione the descrizione of this icona
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the ID of this icona.
	 *
	 * @param id the ID of this icona
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the path of this icona.
	 *
	 * @param path the path of this icona
	 */
	@Override
	public void setPath(String path) {
		model.setPath(path);
	}

	/**
	 * Sets the primary key of this icona.
	 *
	 * @param primaryKey the primary key of this icona
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this icona.
	 *
	 * @param uuid the uuid of this icona
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected IconaWrapper wrap(Icona icona) {
		return new IconaWrapper(icona);
	}

}