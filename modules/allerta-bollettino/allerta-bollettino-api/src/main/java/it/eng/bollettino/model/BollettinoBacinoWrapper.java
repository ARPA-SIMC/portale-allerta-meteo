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
 * This class is a wrapper for {@link BollettinoBacino}.
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoBacino
 * @generated
 */
public class BollettinoBacinoWrapper
	extends BaseModelWrapper<BollettinoBacino>
	implements BollettinoBacino, ModelWrapper<BollettinoBacino> {

	public BollettinoBacinoWrapper(BollettinoBacino bollettinoBacino) {
		super(bollettinoBacino);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("idBollettino", getIdBollettino());
		attributes.put("progressivo", getProgressivo());
		attributes.put("idBacino", getIdBacino());
		attributes.put("nomeBacino", getNomeBacino());
		attributes.put("oreOsservazione", getOreOsservazione());
		attributes.put("note", getNote());

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

		Long idBollettino = (Long)attributes.get("idBollettino");

		if (idBollettino != null) {
			setIdBollettino(idBollettino);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}

		String idBacino = (String)attributes.get("idBacino");

		if (idBacino != null) {
			setIdBacino(idBacino);
		}

		String nomeBacino = (String)attributes.get("nomeBacino");

		if (nomeBacino != null) {
			setNomeBacino(nomeBacino);
		}

		String oreOsservazione = (String)attributes.get("oreOsservazione");

		if (oreOsservazione != null) {
			setOreOsservazione(oreOsservazione);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@Override
	public BollettinoBacino cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this bollettino bacino.
	 *
	 * @return the ID of this bollettino bacino
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id bacino of this bollettino bacino.
	 *
	 * @return the id bacino of this bollettino bacino
	 */
	@Override
	public String getIdBacino() {
		return model.getIdBacino();
	}

	/**
	 * Returns the id bollettino of this bollettino bacino.
	 *
	 * @return the id bollettino of this bollettino bacino
	 */
	@Override
	public long getIdBollettino() {
		return model.getIdBollettino();
	}

	/**
	 * Returns the nome bacino of this bollettino bacino.
	 *
	 * @return the nome bacino of this bollettino bacino
	 */
	@Override
	public String getNomeBacino() {
		return model.getNomeBacino();
	}

	/**
	 * Returns the note of this bollettino bacino.
	 *
	 * @return the note of this bollettino bacino
	 */
	@Override
	public String getNote() {
		return model.getNote();
	}

	/**
	 * Returns the ore osservazione of this bollettino bacino.
	 *
	 * @return the ore osservazione of this bollettino bacino
	 */
	@Override
	public String getOreOsservazione() {
		return model.getOreOsservazione();
	}

	/**
	 * Returns the primary key of this bollettino bacino.
	 *
	 * @return the primary key of this bollettino bacino
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the progressivo of this bollettino bacino.
	 *
	 * @return the progressivo of this bollettino bacino
	 */
	@Override
	public int getProgressivo() {
		return model.getProgressivo();
	}

	/**
	 * Returns the uuid of this bollettino bacino.
	 *
	 * @return the uuid of this bollettino bacino
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
	 * Sets the ID of this bollettino bacino.
	 *
	 * @param id the ID of this bollettino bacino
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id bacino of this bollettino bacino.
	 *
	 * @param idBacino the id bacino of this bollettino bacino
	 */
	@Override
	public void setIdBacino(String idBacino) {
		model.setIdBacino(idBacino);
	}

	/**
	 * Sets the id bollettino of this bollettino bacino.
	 *
	 * @param idBollettino the id bollettino of this bollettino bacino
	 */
	@Override
	public void setIdBollettino(long idBollettino) {
		model.setIdBollettino(idBollettino);
	}

	/**
	 * Sets the nome bacino of this bollettino bacino.
	 *
	 * @param nomeBacino the nome bacino of this bollettino bacino
	 */
	@Override
	public void setNomeBacino(String nomeBacino) {
		model.setNomeBacino(nomeBacino);
	}

	/**
	 * Sets the note of this bollettino bacino.
	 *
	 * @param note the note of this bollettino bacino
	 */
	@Override
	public void setNote(String note) {
		model.setNote(note);
	}

	/**
	 * Sets the ore osservazione of this bollettino bacino.
	 *
	 * @param oreOsservazione the ore osservazione of this bollettino bacino
	 */
	@Override
	public void setOreOsservazione(String oreOsservazione) {
		model.setOreOsservazione(oreOsservazione);
	}

	/**
	 * Sets the primary key of this bollettino bacino.
	 *
	 * @param primaryKey the primary key of this bollettino bacino
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the progressivo of this bollettino bacino.
	 *
	 * @param progressivo the progressivo of this bollettino bacino
	 */
	@Override
	public void setProgressivo(int progressivo) {
		model.setProgressivo(progressivo);
	}

	/**
	 * Sets the uuid of this bollettino bacino.
	 *
	 * @param uuid the uuid of this bollettino bacino
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
	protected BollettinoBacinoWrapper wrap(BollettinoBacino bollettinoBacino) {
		return new BollettinoBacinoWrapper(bollettinoBacino);
	}

}