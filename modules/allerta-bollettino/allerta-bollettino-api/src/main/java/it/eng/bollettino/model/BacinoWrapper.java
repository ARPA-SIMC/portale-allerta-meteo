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
 * This class is a wrapper for {@link Bacino}.
 * </p>
 *
 * @author GFAVINI
 * @see Bacino
 * @generated
 */
public class BacinoWrapper
	extends BaseModelWrapper<Bacino> implements Bacino, ModelWrapper<Bacino> {

	public BacinoWrapper(Bacino bacino) {
		super(bacino);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("progressivo", getProgressivo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}
	}

	@Override
	public Bacino cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this bacino.
	 *
	 * @return the ID of this bacino
	 */
	@Override
	public String getId() {
		return model.getId();
	}

	/**
	 * Returns the nome of this bacino.
	 *
	 * @return the nome of this bacino
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this bacino.
	 *
	 * @return the primary key of this bacino
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progressivo of this bacino.
	 *
	 * @return the progressivo of this bacino
	 */
	@Override
	public int getProgressivo() {
		return model.getProgressivo();
	}

	/**
	 * Returns the uuid of this bacino.
	 *
	 * @return the uuid of this bacino
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
	 * Sets the ID of this bacino.
	 *
	 * @param id the ID of this bacino
	 */
	@Override
	public void setId(String id) {
		model.setId(id);
	}

	/**
	 * Sets the nome of this bacino.
	 *
	 * @param nome the nome of this bacino
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this bacino.
	 *
	 * @param primaryKey the primary key of this bacino
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progressivo of this bacino.
	 *
	 * @param progressivo the progressivo of this bacino
	 */
	@Override
	public void setProgressivo(int progressivo) {
		model.setProgressivo(progressivo);
	}

	/**
	 * Sets the uuid of this bacino.
	 *
	 * @param uuid the uuid of this bacino
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
	protected BacinoWrapper wrap(Bacino bacino) {
		return new BacinoWrapper(bacino);
	}

}