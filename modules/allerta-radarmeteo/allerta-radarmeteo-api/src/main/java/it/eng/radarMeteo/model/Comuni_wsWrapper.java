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
 * This class is a wrapper for {@link Comuni_ws}.
 * </p>
 *
 * @author Francesco
 * @see Comuni_ws
 * @generated
 */
public class Comuni_wsWrapper
	extends BaseModelWrapper<Comuni_ws>
	implements Comuni_ws, ModelWrapper<Comuni_ws> {

	public Comuni_wsWrapper(Comuni_ws comuni_ws) {
		super(comuni_ws);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idIstat", getIdIstat());
		attributes.put("comune", getComune());
		attributes.put("provincia", getProvincia());
		attributes.put("sottozona", getSottozona());
		attributes.put("zonaallerta", getZonaallerta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String idIstat = (String)attributes.get("idIstat");

		if (idIstat != null) {
			setIdIstat(idIstat);
		}

		String comune = (String)attributes.get("comune");

		if (comune != null) {
			setComune(comune);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String sottozona = (String)attributes.get("sottozona");

		if (sottozona != null) {
			setSottozona(sottozona);
		}

		String zonaallerta = (String)attributes.get("zonaallerta");

		if (zonaallerta != null) {
			setZonaallerta(zonaallerta);
		}
	}

	@Override
	public Comuni_ws cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the comune of this comuni_ws.
	 *
	 * @return the comune of this comuni_ws
	 */
	@Override
	public String getComune() {
		return model.getComune();
	}

	/**
	 * Returns the id istat of this comuni_ws.
	 *
	 * @return the id istat of this comuni_ws
	 */
	@Override
	public String getIdIstat() {
		return model.getIdIstat();
	}

	/**
	 * Returns the primary key of this comuni_ws.
	 *
	 * @return the primary key of this comuni_ws
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the provincia of this comuni_ws.
	 *
	 * @return the provincia of this comuni_ws
	 */
	@Override
	public String getProvincia() {
		return model.getProvincia();
	}

	/**
	 * Returns the sottozona of this comuni_ws.
	 *
	 * @return the sottozona of this comuni_ws
	 */
	@Override
	public String getSottozona() {
		return model.getSottozona();
	}

	/**
	 * Returns the zonaallerta of this comuni_ws.
	 *
	 * @return the zonaallerta of this comuni_ws
	 */
	@Override
	public String getZonaallerta() {
		return model.getZonaallerta();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the comune of this comuni_ws.
	 *
	 * @param comune the comune of this comuni_ws
	 */
	@Override
	public void setComune(String comune) {
		model.setComune(comune);
	}

	/**
	 * Sets the id istat of this comuni_ws.
	 *
	 * @param idIstat the id istat of this comuni_ws
	 */
	@Override
	public void setIdIstat(String idIstat) {
		model.setIdIstat(idIstat);
	}

	/**
	 * Sets the primary key of this comuni_ws.
	 *
	 * @param primaryKey the primary key of this comuni_ws
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the provincia of this comuni_ws.
	 *
	 * @param provincia the provincia of this comuni_ws
	 */
	@Override
	public void setProvincia(String provincia) {
		model.setProvincia(provincia);
	}

	/**
	 * Sets the sottozona of this comuni_ws.
	 *
	 * @param sottozona the sottozona of this comuni_ws
	 */
	@Override
	public void setSottozona(String sottozona) {
		model.setSottozona(sottozona);
	}

	/**
	 * Sets the zonaallerta of this comuni_ws.
	 *
	 * @param zonaallerta the zonaallerta of this comuni_ws
	 */
	@Override
	public void setZonaallerta(String zonaallerta) {
		model.setZonaallerta(zonaallerta);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected Comuni_wsWrapper wrap(Comuni_ws comuni_ws) {
		return new Comuni_wsWrapper(comuni_ws);
	}

}