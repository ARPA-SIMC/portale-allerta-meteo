/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RubricaPermessi}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaPermessi
 * @generated
 */
public class RubricaPermessiWrapper
	extends BaseModelWrapper<RubricaPermessi>
	implements ModelWrapper<RubricaPermessi>, RubricaPermessi {

	public RubricaPermessiWrapper(RubricaPermessi rubricaPermessi) {
		super(rubricaPermessi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_PERMESSO", getID_PERMESSO());
		attributes.put("NOME_PERMESSO", getNOME_PERMESSO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String ID_PERMESSO = (String)attributes.get("ID_PERMESSO");

		if (ID_PERMESSO != null) {
			setID_PERMESSO(ID_PERMESSO);
		}

		String NOME_PERMESSO = (String)attributes.get("NOME_PERMESSO");

		if (NOME_PERMESSO != null) {
			setNOME_PERMESSO(NOME_PERMESSO);
		}
	}

	@Override
	public RubricaPermessi cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the id_permesso of this rubrica permessi.
	 *
	 * @return the id_permesso of this rubrica permessi
	 */
	@Override
	public String getID_PERMESSO() {
		return model.getID_PERMESSO();
	}

	/**
	 * Returns the nome_permesso of this rubrica permessi.
	 *
	 * @return the nome_permesso of this rubrica permessi
	 */
	@Override
	public String getNOME_PERMESSO() {
		return model.getNOME_PERMESSO();
	}

	/**
	 * Returns the primary key of this rubrica permessi.
	 *
	 * @return the primary key of this rubrica permessi
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Sets the id_permesso of this rubrica permessi.
	 *
	 * @param ID_PERMESSO the id_permesso of this rubrica permessi
	 */
	@Override
	public void setID_PERMESSO(String ID_PERMESSO) {
		model.setID_PERMESSO(ID_PERMESSO);
	}

	/**
	 * Sets the nome_permesso of this rubrica permessi.
	 *
	 * @param NOME_PERMESSO the nome_permesso of this rubrica permessi
	 */
	@Override
	public void setNOME_PERMESSO(String NOME_PERMESSO) {
		model.setNOME_PERMESSO(NOME_PERMESSO);
	}

	/**
	 * Sets the primary key of this rubrica permessi.
	 *
	 * @param primaryKey the primary key of this rubrica permessi
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RubricaPermessiWrapper wrap(RubricaPermessi rubricaPermessi) {
		return new RubricaPermessiWrapper(rubricaPermessi);
	}

}