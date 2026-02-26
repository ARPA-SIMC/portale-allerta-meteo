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
 * This class is a wrapper for {@link BollettinoIcona}.
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoIcona
 * @generated
 */
public class BollettinoIconaWrapper
	extends BaseModelWrapper<BollettinoIcona>
	implements BollettinoIcona, ModelWrapper<BollettinoIcona> {

	public BollettinoIconaWrapper(BollettinoIcona bollettinoIcona) {
		super(bollettinoIcona);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("idBollettino", getIdBollettino());
		attributes.put("idIcona", getIdIcona());
		attributes.put("x", getX());
		attributes.put("y", getY());

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

		Long idIcona = (Long)attributes.get("idIcona");

		if (idIcona != null) {
			setIdIcona(idIcona);
		}

		Double x = (Double)attributes.get("x");

		if (x != null) {
			setX(x);
		}

		Double y = (Double)attributes.get("y");

		if (y != null) {
			setY(y);
		}
	}

	@Override
	public BollettinoIcona cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this bollettino icona.
	 *
	 * @return the ID of this bollettino icona
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id bollettino of this bollettino icona.
	 *
	 * @return the id bollettino of this bollettino icona
	 */
	@Override
	public long getIdBollettino() {
		return model.getIdBollettino();
	}

	/**
	 * Returns the id icona of this bollettino icona.
	 *
	 * @return the id icona of this bollettino icona
	 */
	@Override
	public long getIdIcona() {
		return model.getIdIcona();
	}

	/**
	 * Returns the primary key of this bollettino icona.
	 *
	 * @return the primary key of this bollettino icona
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this bollettino icona.
	 *
	 * @return the uuid of this bollettino icona
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the x of this bollettino icona.
	 *
	 * @return the x of this bollettino icona
	 */
	@Override
	public double getX() {
		return model.getX();
	}

	/**
	 * Returns the y of this bollettino icona.
	 *
	 * @return the y of this bollettino icona
	 */
	@Override
	public double getY() {
		return model.getY();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this bollettino icona.
	 *
	 * @param id the ID of this bollettino icona
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id bollettino of this bollettino icona.
	 *
	 * @param idBollettino the id bollettino of this bollettino icona
	 */
	@Override
	public void setIdBollettino(long idBollettino) {
		model.setIdBollettino(idBollettino);
	}

	/**
	 * Sets the id icona of this bollettino icona.
	 *
	 * @param idIcona the id icona of this bollettino icona
	 */
	@Override
	public void setIdIcona(long idIcona) {
		model.setIdIcona(idIcona);
	}

	/**
	 * Sets the primary key of this bollettino icona.
	 *
	 * @param primaryKey the primary key of this bollettino icona
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this bollettino icona.
	 *
	 * @param uuid the uuid of this bollettino icona
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the x of this bollettino icona.
	 *
	 * @param x the x of this bollettino icona
	 */
	@Override
	public void setX(double x) {
		model.setX(x);
	}

	/**
	 * Sets the y of this bollettino icona.
	 *
	 * @param y the y of this bollettino icona
	 */
	@Override
	public void setY(double y) {
		model.setY(y);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BollettinoIconaWrapper wrap(BollettinoIcona bollettinoIcona) {
		return new BollettinoIconaWrapper(bollettinoIcona);
	}

}