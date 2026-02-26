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
 * This class is a wrapper for {@link RubricaCategoria}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaCategoria
 * @generated
 */
public class RubricaCategoriaWrapper
	extends BaseModelWrapper<RubricaCategoria>
	implements ModelWrapper<RubricaCategoria>, RubricaCategoria {

	public RubricaCategoriaWrapper(RubricaCategoria rubricaCategoria) {
		super(rubricaCategoria);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_CATEGORIA", getID_CATEGORIA());
		attributes.put("DESCRIZIONE", getDESCRIZIONE());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_CATEGORIA = (Long)attributes.get("ID_CATEGORIA");

		if (ID_CATEGORIA != null) {
			setID_CATEGORIA(ID_CATEGORIA);
		}

		String DESCRIZIONE = (String)attributes.get("DESCRIZIONE");

		if (DESCRIZIONE != null) {
			setDESCRIZIONE(DESCRIZIONE);
		}
	}

	@Override
	public RubricaCategoria cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the descrizione of this rubrica categoria.
	 *
	 * @return the descrizione of this rubrica categoria
	 */
	@Override
	public String getDESCRIZIONE() {
		return model.getDESCRIZIONE();
	}

	/**
	 * Returns the id_categoria of this rubrica categoria.
	 *
	 * @return the id_categoria of this rubrica categoria
	 */
	@Override
	public long getID_CATEGORIA() {
		return model.getID_CATEGORIA();
	}

	/**
	 * Returns the primary key of this rubrica categoria.
	 *
	 * @return the primary key of this rubrica categoria
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
	 * Sets the descrizione of this rubrica categoria.
	 *
	 * @param DESCRIZIONE the descrizione of this rubrica categoria
	 */
	@Override
	public void setDESCRIZIONE(String DESCRIZIONE) {
		model.setDESCRIZIONE(DESCRIZIONE);
	}

	/**
	 * Sets the id_categoria of this rubrica categoria.
	 *
	 * @param ID_CATEGORIA the id_categoria of this rubrica categoria
	 */
	@Override
	public void setID_CATEGORIA(long ID_CATEGORIA) {
		model.setID_CATEGORIA(ID_CATEGORIA);
	}

	/**
	 * Sets the primary key of this rubrica categoria.
	 *
	 * @param primaryKey the primary key of this rubrica categoria
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
	protected RubricaCategoriaWrapper wrap(RubricaCategoria rubricaCategoria) {
		return new RubricaCategoriaWrapper(rubricaCategoria);
	}

}