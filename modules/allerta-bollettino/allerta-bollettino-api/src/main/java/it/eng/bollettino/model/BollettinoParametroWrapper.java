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
 * This class is a wrapper for {@link BollettinoParametro}.
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoParametro
 * @generated
 */
public class BollettinoParametroWrapper
	extends BaseModelWrapper<BollettinoParametro>
	implements BollettinoParametro, ModelWrapper<BollettinoParametro> {

	public BollettinoParametroWrapper(BollettinoParametro bollettinoParametro) {
		super(bollettinoParametro);
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
	public BollettinoParametro cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the parametro ID of this bollettino parametro.
	 *
	 * @return the parametro ID of this bollettino parametro
	 */
	@Override
	public String getParametroId() {
		return model.getParametroId();
	}

	/**
	 * Returns the primary key of this bollettino parametro.
	 *
	 * @return the primary key of this bollettino parametro
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the valore of this bollettino parametro.
	 *
	 * @return the valore of this bollettino parametro
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
	 * Sets the parametro ID of this bollettino parametro.
	 *
	 * @param parametroId the parametro ID of this bollettino parametro
	 */
	@Override
	public void setParametroId(String parametroId) {
		model.setParametroId(parametroId);
	}

	/**
	 * Sets the primary key of this bollettino parametro.
	 *
	 * @param primaryKey the primary key of this bollettino parametro
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the valore of this bollettino parametro.
	 *
	 * @param valore the valore of this bollettino parametro
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
	protected BollettinoParametroWrapper wrap(
		BollettinoParametro bollettinoParametro) {

		return new BollettinoParametroWrapper(bollettinoParametro);
	}

}