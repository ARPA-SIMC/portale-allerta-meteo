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
 * This class is a wrapper for {@link Comuni_bacini_ws}.
 * </p>
 *
 * @author Francesco
 * @see Comuni_bacini_ws
 * @generated
 */
public class Comuni_bacini_wsWrapper
	extends BaseModelWrapper<Comuni_bacini_ws>
	implements Comuni_bacini_ws, ModelWrapper<Comuni_bacini_ws> {

	public Comuni_bacini_wsWrapper(Comuni_bacini_ws comuni_bacini_ws) {
		super(comuni_bacini_ws);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idBacini", getIdBacini());
		attributes.put("comune", getComune());
		attributes.put("provincia", getProvincia());
		attributes.put("bacino", getBacino());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer idBacini = (Integer)attributes.get("idBacini");

		if (idBacini != null) {
			setIdBacini(idBacini);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String bacino = (String)attributes.get("bacino");

		if (bacino != null) {
			setBacino(bacino);
		}
	}

	@Override
	public Comuni_bacini_ws cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the bacino of this comuni_bacini_ws.
	 *
	 * @return the bacino of this comuni_bacini_ws
	 */
	@Override
	public String getBacino() {
		return model.getBacino();
	}

	/**
	 * Returns the comune of this comuni_bacini_ws.
	 *
	 * @return the comune of this comuni_bacini_ws
	 */
	@Override
	public String getComune() {
		return model.getComune();
	}

	/**
	 * Returns the id bacini of this comuni_bacini_ws.
	 *
	 * @return the id bacini of this comuni_bacini_ws
	 */
	@Override
	public int getIdBacini() {
		return model.getIdBacini();
	}

	/**
	 * Returns the primary key of this comuni_bacini_ws.
	 *
	 * @return the primary key of this comuni_bacini_ws
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the provincia of this comuni_bacini_ws.
	 *
	 * @return the provincia of this comuni_bacini_ws
	 */
	@Override
	public String getProvincia() {
		return model.getProvincia();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bacino of this comuni_bacini_ws.
	 *
	 * @param bacino the bacino of this comuni_bacini_ws
	 */
	@Override
	public void setBacino(String bacino) {
		model.setBacino(bacino);
	}

	/**
	 * Sets the comune of this comuni_bacini_ws.
	 *
	 * @param comune the comune of this comuni_bacini_ws
	 */
	@Override
	public void setComune(String comune) {
		model.setComune(comune);
	}

	/**
	 * Sets the id bacini of this comuni_bacini_ws.
	 *
	 * @param idBacini the id bacini of this comuni_bacini_ws
	 */
	@Override
	public void setIdBacini(int idBacini) {
		model.setIdBacini(idBacini);
	}

	/**
	 * Sets the primary key of this comuni_bacini_ws.
	 *
	 * @param primaryKey the primary key of this comuni_bacini_ws
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the provincia of this comuni_bacini_ws.
	 *
	 * @param provincia the provincia of this comuni_bacini_ws
	 */
	@Override
	public void setProvincia(String provincia) {
		model.setProvincia(provincia);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected Comuni_bacini_wsWrapper wrap(Comuni_bacini_ws comuni_bacini_ws) {
		return new Comuni_bacini_wsWrapper(comuni_bacini_ws);
	}

}