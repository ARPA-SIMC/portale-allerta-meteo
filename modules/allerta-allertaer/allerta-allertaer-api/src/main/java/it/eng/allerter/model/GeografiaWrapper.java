/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Geografia}.
 * </p>
 *
 * @author GFAVINI
 * @see Geografia
 * @generated
 */
public class GeografiaWrapper
	extends BaseModelWrapper<Geografia>
	implements Geografia, ModelWrapper<Geografia> {

	public GeografiaWrapper(Geografia geografia) {
		super(geografia);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("geografiaId", getGeografiaId());
		attributes.put("tipo", getTipo());
		attributes.put("area", getArea());
		attributes.put("complessita", getComplessita());
		attributes.put("geometria", getGeometria());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String geografiaId = (String)attributes.get("geografiaId");

		if (geografiaId != null) {
			setGeografiaId(geografiaId);
		}

		String tipo = (String)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}

		String complessita = (String)attributes.get("complessita");

		if (complessita != null) {
			setComplessita(complessita);
		}

		String geometria = (String)attributes.get("geometria");

		if (geometria != null) {
			setGeometria(geometria);
		}
	}

	@Override
	public Geografia cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the area of this geografia.
	 *
	 * @return the area of this geografia
	 */
	@Override
	public String getArea() {
		return model.getArea();
	}

	/**
	 * Returns the complessita of this geografia.
	 *
	 * @return the complessita of this geografia
	 */
	@Override
	public String getComplessita() {
		return model.getComplessita();
	}

	/**
	 * Returns the geografia ID of this geografia.
	 *
	 * @return the geografia ID of this geografia
	 */
	@Override
	public String getGeografiaId() {
		return model.getGeografiaId();
	}

	/**
	 * Returns the geometria of this geografia.
	 *
	 * @return the geometria of this geografia
	 */
	@Override
	public String getGeometria() {
		return model.getGeometria();
	}

	/**
	 * Returns the primary key of this geografia.
	 *
	 * @return the primary key of this geografia
	 */
	@Override
	public it.eng.allerter.service.persistence.GeografiaPK getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tipo of this geografia.
	 *
	 * @return the tipo of this geografia
	 */
	@Override
	public String getTipo() {
		return model.getTipo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the area of this geografia.
	 *
	 * @param area the area of this geografia
	 */
	@Override
	public void setArea(String area) {
		model.setArea(area);
	}

	/**
	 * Sets the complessita of this geografia.
	 *
	 * @param complessita the complessita of this geografia
	 */
	@Override
	public void setComplessita(String complessita) {
		model.setComplessita(complessita);
	}

	/**
	 * Sets the geografia ID of this geografia.
	 *
	 * @param geografiaId the geografia ID of this geografia
	 */
	@Override
	public void setGeografiaId(String geografiaId) {
		model.setGeografiaId(geografiaId);
	}

	/**
	 * Sets the geometria of this geografia.
	 *
	 * @param geometria the geometria of this geografia
	 */
	@Override
	public void setGeometria(String geometria) {
		model.setGeometria(geometria);
	}

	/**
	 * Sets the primary key of this geografia.
	 *
	 * @param primaryKey the primary key of this geografia
	 */
	@Override
	public void setPrimaryKey(
		it.eng.allerter.service.persistence.GeografiaPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tipo of this geografia.
	 *
	 * @param tipo the tipo of this geografia
	 */
	@Override
	public void setTipo(String tipo) {
		model.setTipo(tipo);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected GeografiaWrapper wrap(Geografia geografia) {
		return new GeografiaWrapper(geografia);
	}

}