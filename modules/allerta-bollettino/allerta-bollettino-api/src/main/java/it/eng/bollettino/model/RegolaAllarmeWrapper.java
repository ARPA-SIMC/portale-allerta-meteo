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
 * This class is a wrapper for {@link RegolaAllarme}.
 * </p>
 *
 * @author GFAVINI
 * @see RegolaAllarme
 * @generated
 */
public class RegolaAllarmeWrapper
	extends BaseModelWrapper<RegolaAllarme>
	implements ModelWrapper<RegolaAllarme>, RegolaAllarme {

	public RegolaAllarmeWrapper(RegolaAllarme regolaAllarme) {
		super(regolaAllarme);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("nome", getNome());
		attributes.put("espressione", getEspressione());
		attributes.put("descrizione", getDescrizione());
		attributes.put("colore", getColore());
		attributes.put("attivo", isAttivo());

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

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String espressione = (String)attributes.get("espressione");

		if (espressione != null) {
			setEspressione(espressione);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}

		Integer colore = (Integer)attributes.get("colore");

		if (colore != null) {
			setColore(colore);
		}

		Boolean attivo = (Boolean)attributes.get("attivo");

		if (attivo != null) {
			setAttivo(attivo);
		}
	}

	@Override
	public RegolaAllarme cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the attivo of this regola allarme.
	 *
	 * @return the attivo of this regola allarme
	 */
	@Override
	public boolean getAttivo() {
		return model.getAttivo();
	}

	/**
	 * Returns the colore of this regola allarme.
	 *
	 * @return the colore of this regola allarme
	 */
	@Override
	public int getColore() {
		return model.getColore();
	}

	/**
	 * Returns the descrizione of this regola allarme.
	 *
	 * @return the descrizione of this regola allarme
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the espressione of this regola allarme.
	 *
	 * @return the espressione of this regola allarme
	 */
	@Override
	public String getEspressione() {
		return model.getEspressione();
	}

	/**
	 * Returns the ID of this regola allarme.
	 *
	 * @return the ID of this regola allarme
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the nome of this regola allarme.
	 *
	 * @return the nome of this regola allarme
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this regola allarme.
	 *
	 * @return the primary key of this regola allarme
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this regola allarme.
	 *
	 * @return the uuid of this regola allarme
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this regola allarme is attivo.
	 *
	 * @return <code>true</code> if this regola allarme is attivo; <code>false</code> otherwise
	 */
	@Override
	public boolean isAttivo() {
		return model.isAttivo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this regola allarme is attivo.
	 *
	 * @param attivo the attivo of this regola allarme
	 */
	@Override
	public void setAttivo(boolean attivo) {
		model.setAttivo(attivo);
	}

	/**
	 * Sets the colore of this regola allarme.
	 *
	 * @param colore the colore of this regola allarme
	 */
	@Override
	public void setColore(int colore) {
		model.setColore(colore);
	}

	/**
	 * Sets the descrizione of this regola allarme.
	 *
	 * @param descrizione the descrizione of this regola allarme
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the espressione of this regola allarme.
	 *
	 * @param espressione the espressione of this regola allarme
	 */
	@Override
	public void setEspressione(String espressione) {
		model.setEspressione(espressione);
	}

	/**
	 * Sets the ID of this regola allarme.
	 *
	 * @param id the ID of this regola allarme
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the nome of this regola allarme.
	 *
	 * @param nome the nome of this regola allarme
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this regola allarme.
	 *
	 * @param primaryKey the primary key of this regola allarme
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this regola allarme.
	 *
	 * @param uuid the uuid of this regola allarme
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
	protected RegolaAllarmeWrapper wrap(RegolaAllarme regolaAllarme) {
		return new RegolaAllarmeWrapper(regolaAllarme);
	}

}