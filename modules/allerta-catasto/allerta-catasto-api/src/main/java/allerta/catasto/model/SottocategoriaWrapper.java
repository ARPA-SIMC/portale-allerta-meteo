/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Sottocategoria}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Sottocategoria
 * @generated
 */
public class SottocategoriaWrapper
	extends BaseModelWrapper<Sottocategoria>
	implements ModelWrapper<Sottocategoria>, Sottocategoria {

	public SottocategoriaWrapper(Sottocategoria sottocategoria) {
		super(sottocategoria);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("idCategoria", getIdCategoria());
		attributes.put("descrizione", getDescrizione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long idCategoria = (Long)attributes.get("idCategoria");

		if (idCategoria != null) {
			setIdCategoria(idCategoria);
		}

		String descrizione = (String)attributes.get("descrizione");

		if (descrizione != null) {
			setDescrizione(descrizione);
		}
	}

	@Override
	public Sottocategoria cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the descrizione of this sottocategoria.
	 *
	 * @return the descrizione of this sottocategoria
	 */
	@Override
	public String getDescrizione() {
		return model.getDescrizione();
	}

	/**
	 * Returns the ID of this sottocategoria.
	 *
	 * @return the ID of this sottocategoria
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id categoria of this sottocategoria.
	 *
	 * @return the id categoria of this sottocategoria
	 */
	@Override
	public long getIdCategoria() {
		return model.getIdCategoria();
	}

	/**
	 * Returns the primary key of this sottocategoria.
	 *
	 * @return the primary key of this sottocategoria
	 */
	@Override
	public allerta.catasto.service.persistence.SottocategoriaPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the descrizione of this sottocategoria.
	 *
	 * @param descrizione the descrizione of this sottocategoria
	 */
	@Override
	public void setDescrizione(String descrizione) {
		model.setDescrizione(descrizione);
	}

	/**
	 * Sets the ID of this sottocategoria.
	 *
	 * @param id the ID of this sottocategoria
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id categoria of this sottocategoria.
	 *
	 * @param idCategoria the id categoria of this sottocategoria
	 */
	@Override
	public void setIdCategoria(long idCategoria) {
		model.setIdCategoria(idCategoria);
	}

	/**
	 * Sets the primary key of this sottocategoria.
	 *
	 * @param primaryKey the primary key of this sottocategoria
	 */
	@Override
	public void setPrimaryKey(
		allerta.catasto.service.persistence.SottocategoriaPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SottocategoriaWrapper wrap(Sottocategoria sottocategoria) {
		return new SottocategoriaWrapper(sottocategoria);
	}

}