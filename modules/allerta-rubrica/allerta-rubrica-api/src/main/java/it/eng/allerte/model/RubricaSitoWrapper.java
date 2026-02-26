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
 * This class is a wrapper for {@link RubricaSito}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaSito
 * @generated
 */
public class RubricaSitoWrapper
	extends BaseModelWrapper<RubricaSito>
	implements ModelWrapper<RubricaSito>, RubricaSito {

	public RubricaSitoWrapper(RubricaSito rubricaSito) {
		super(rubricaSito);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_SITO", getID_SITO());
		attributes.put("NOME", getNOME());
		attributes.put("FK_LIFERAY_SITE", getFK_LIFERAY_SITE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_SITO = (Long)attributes.get("ID_SITO");

		if (ID_SITO != null) {
			setID_SITO(ID_SITO);
		}

		String NOME = (String)attributes.get("NOME");

		if (NOME != null) {
			setNOME(NOME);
		}

		Long FK_LIFERAY_SITE = (Long)attributes.get("FK_LIFERAY_SITE");

		if (FK_LIFERAY_SITE != null) {
			setFK_LIFERAY_SITE(FK_LIFERAY_SITE);
		}
	}

	@Override
	public RubricaSito cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the fk_liferay_site of this rubrica sito.
	 *
	 * @return the fk_liferay_site of this rubrica sito
	 */
	@Override
	public long getFK_LIFERAY_SITE() {
		return model.getFK_LIFERAY_SITE();
	}

	/**
	 * Returns the id_sito of this rubrica sito.
	 *
	 * @return the id_sito of this rubrica sito
	 */
	@Override
	public long getID_SITO() {
		return model.getID_SITO();
	}

	/**
	 * Returns the nome of this rubrica sito.
	 *
	 * @return the nome of this rubrica sito
	 */
	@Override
	public String getNOME() {
		return model.getNOME();
	}

	/**
	 * Returns the primary key of this rubrica sito.
	 *
	 * @return the primary key of this rubrica sito
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the fk_liferay_site of this rubrica sito.
	 *
	 * @param FK_LIFERAY_SITE the fk_liferay_site of this rubrica sito
	 */
	@Override
	public void setFK_LIFERAY_SITE(long FK_LIFERAY_SITE) {
		model.setFK_LIFERAY_SITE(FK_LIFERAY_SITE);
	}

	/**
	 * Sets the id_sito of this rubrica sito.
	 *
	 * @param ID_SITO the id_sito of this rubrica sito
	 */
	@Override
	public void setID_SITO(long ID_SITO) {
		model.setID_SITO(ID_SITO);
	}

	/**
	 * Sets the nome of this rubrica sito.
	 *
	 * @param NOME the nome of this rubrica sito
	 */
	@Override
	public void setNOME(String NOME) {
		model.setNOME(NOME);
	}

	/**
	 * Sets the primary key of this rubrica sito.
	 *
	 * @param primaryKey the primary key of this rubrica sito
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected RubricaSitoWrapper wrap(RubricaSito rubricaSito) {
		return new RubricaSitoWrapper(rubricaSito);
	}

}