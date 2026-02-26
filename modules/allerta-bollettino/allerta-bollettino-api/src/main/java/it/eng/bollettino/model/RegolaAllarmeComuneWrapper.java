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
 * This class is a wrapper for {@link RegolaAllarmeComune}.
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarmeComune
 * @generated
 */
public class RegolaAllarmeComuneWrapper
	extends BaseModelWrapper<RegolaAllarmeComune>
	implements ModelWrapper<RegolaAllarmeComune>, RegolaAllarmeComune {

	public RegolaAllarmeComuneWrapper(RegolaAllarmeComune regolaAllarmeComune) {
		super(regolaAllarmeComune);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("idRegola", getIdRegola());
		attributes.put("idComune", getIdComune());

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

		Long idRegola = (Long)attributes.get("idRegola");

		if (idRegola != null) {
			setIdRegola(idRegola);
		}

		Long idComune = (Long)attributes.get("idComune");

		if (idComune != null) {
			setIdComune(idComune);
		}
	}

	@Override
	public RegolaAllarmeComune cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this regola allarme comune.
	 *
	 * @return the ID of this regola allarme comune
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id comune of this regola allarme comune.
	 *
	 * @return the id comune of this regola allarme comune
	 */
	@Override
	public long getIdComune() {
		return model.getIdComune();
	}

	/**
	 * Returns the id regola of this regola allarme comune.
	 *
	 * @return the id regola of this regola allarme comune
	 */
	@Override
	public long getIdRegola() {
		return model.getIdRegola();
	}

	/**
	 * Returns the primary key of this regola allarme comune.
	 *
	 * @return the primary key of this regola allarme comune
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this regola allarme comune.
	 *
	 * @return the uuid of this regola allarme comune
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
	 * Sets the ID of this regola allarme comune.
	 *
	 * @param id the ID of this regola allarme comune
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id comune of this regola allarme comune.
	 *
	 * @param idComune the id comune of this regola allarme comune
	 */
	@Override
	public void setIdComune(long idComune) {
		model.setIdComune(idComune);
	}

	/**
	 * Sets the id regola of this regola allarme comune.
	 *
	 * @param idRegola the id regola of this regola allarme comune
	 */
	@Override
	public void setIdRegola(long idRegola) {
		model.setIdRegola(idRegola);
	}

	/**
	 * Sets the primary key of this regola allarme comune.
	 *
	 * @param primaryKey the primary key of this regola allarme comune
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this regola allarme comune.
	 *
	 * @param uuid the uuid of this regola allarme comune
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
	protected RegolaAllarmeComuneWrapper wrap(
		RegolaAllarmeComune regolaAllarmeComune) {

		return new RegolaAllarmeComuneWrapper(regolaAllarmeComune);
	}

}