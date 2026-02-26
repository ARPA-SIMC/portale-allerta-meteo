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
 * This class is a wrapper for {@link AllertaParametro}.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaParametro
 * @generated
 */
public class AllertaParametroWrapper
	extends BaseModelWrapper<AllertaParametro>
	implements AllertaParametro, ModelWrapper<AllertaParametro> {

	public AllertaParametroWrapper(AllertaParametro allertaParametro) {
		super(allertaParametro);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parametroId", getParametroId());
		attributes.put("valore", getValore());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String parametroId = (String)attributes.get("parametroId");

		if (parametroId != null) {
			setParametroId(parametroId);
		}

		String valore = (String)attributes.get("valore");

		if (valore != null) {
			setValore(valore);
		}
	}

	@Override
	public AllertaParametro cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the parametro ID of this allerta parametro.
	 *
	 * @return the parametro ID of this allerta parametro
	 */
	@Override
	public String getParametroId() {
		return model.getParametroId();
	}

	/**
	 * Returns the primary key of this allerta parametro.
	 *
	 * @return the primary key of this allerta parametro
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the valore of this allerta parametro.
	 *
	 * @return the valore of this allerta parametro
	 */
	@Override
	public String getValore() {
		return model.getValore();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the parametro ID of this allerta parametro.
	 *
	 * @param parametroId the parametro ID of this allerta parametro
	 */
	@Override
	public void setParametroId(String parametroId) {
		model.setParametroId(parametroId);
	}

	/**
	 * Sets the primary key of this allerta parametro.
	 *
	 * @param primaryKey the primary key of this allerta parametro
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the valore of this allerta parametro.
	 *
	 * @param valore the valore of this allerta parametro
	 */
	@Override
	public void setValore(String valore) {
		model.setValore(valore);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected AllertaParametroWrapper wrap(AllertaParametro allertaParametro) {
		return new AllertaParametroWrapper(allertaParametro);
	}

}