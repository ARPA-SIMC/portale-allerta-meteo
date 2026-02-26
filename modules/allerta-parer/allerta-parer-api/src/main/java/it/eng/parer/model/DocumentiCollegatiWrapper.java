/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DocumentiCollegati}.
 * </p>
 *
 * @author Pratola_L
 * @see DocumentiCollegati
 * @generated
 */
public class DocumentiCollegatiWrapper
	extends BaseModelWrapper<DocumentiCollegati>
	implements DocumentiCollegati, ModelWrapper<DocumentiCollegati> {

	public DocumentiCollegatiWrapper(DocumentiCollegati documentiCollegati) {
		super(documentiCollegati);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("DOC_COLLEGATO_NUMERO", getDOC_COLLEGATO_NUMERO());
		attributes.put("DOC_COLLEGATO_ANNO", getDOC_COLLEGATO_ANNO());
		attributes.put(
			"DOC_COLLEGATO_TIPO_REGISTRO", getDOC_COLLEGATO_TIPO_REGISTRO());
		attributes.put(
			"DESCRIZIONE_COLLEGAMENTO", getDESCRIZIONE_COLLEGAMENTO());
		attributes.put("ID_INVIO", getID_INVIO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String DOC_COLLEGATO_NUMERO = (String)attributes.get(
			"DOC_COLLEGATO_NUMERO");

		if (DOC_COLLEGATO_NUMERO != null) {
			setDOC_COLLEGATO_NUMERO(DOC_COLLEGATO_NUMERO);
		}

		Integer DOC_COLLEGATO_ANNO = (Integer)attributes.get(
			"DOC_COLLEGATO_ANNO");

		if (DOC_COLLEGATO_ANNO != null) {
			setDOC_COLLEGATO_ANNO(DOC_COLLEGATO_ANNO);
		}

		String DOC_COLLEGATO_TIPO_REGISTRO = (String)attributes.get(
			"DOC_COLLEGATO_TIPO_REGISTRO");

		if (DOC_COLLEGATO_TIPO_REGISTRO != null) {
			setDOC_COLLEGATO_TIPO_REGISTRO(DOC_COLLEGATO_TIPO_REGISTRO);
		}

		String DESCRIZIONE_COLLEGAMENTO = (String)attributes.get(
			"DESCRIZIONE_COLLEGAMENTO");

		if (DESCRIZIONE_COLLEGAMENTO != null) {
			setDESCRIZIONE_COLLEGAMENTO(DESCRIZIONE_COLLEGAMENTO);
		}

		Long ID_INVIO = (Long)attributes.get("ID_INVIO");

		if (ID_INVIO != null) {
			setID_INVIO(ID_INVIO);
		}
	}

	@Override
	public DocumentiCollegati cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the descrizione_collegamento of this documenti collegati.
	 *
	 * @return the descrizione_collegamento of this documenti collegati
	 */
	@Override
	public String getDESCRIZIONE_COLLEGAMENTO() {
		return model.getDESCRIZIONE_COLLEGAMENTO();
	}

	/**
	 * Returns the doc_collegato_anno of this documenti collegati.
	 *
	 * @return the doc_collegato_anno of this documenti collegati
	 */
	@Override
	public int getDOC_COLLEGATO_ANNO() {
		return model.getDOC_COLLEGATO_ANNO();
	}

	/**
	 * Returns the doc_collegato_numero of this documenti collegati.
	 *
	 * @return the doc_collegato_numero of this documenti collegati
	 */
	@Override
	public String getDOC_COLLEGATO_NUMERO() {
		return model.getDOC_COLLEGATO_NUMERO();
	}

	/**
	 * Returns the doc_collegato_tipo_registro of this documenti collegati.
	 *
	 * @return the doc_collegato_tipo_registro of this documenti collegati
	 */
	@Override
	public String getDOC_COLLEGATO_TIPO_REGISTRO() {
		return model.getDOC_COLLEGATO_TIPO_REGISTRO();
	}

	/**
	 * Returns the id_invio of this documenti collegati.
	 *
	 * @return the id_invio of this documenti collegati
	 */
	@Override
	public long getID_INVIO() {
		return model.getID_INVIO();
	}

	/**
	 * Returns the primary key of this documenti collegati.
	 *
	 * @return the primary key of this documenti collegati
	 */
	@Override
	public it.eng.parer.service.persistence.DocumentiCollegatiPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the descrizione_collegamento of this documenti collegati.
	 *
	 * @param DESCRIZIONE_COLLEGAMENTO the descrizione_collegamento of this documenti collegati
	 */
	@Override
	public void setDESCRIZIONE_COLLEGAMENTO(String DESCRIZIONE_COLLEGAMENTO) {
		model.setDESCRIZIONE_COLLEGAMENTO(DESCRIZIONE_COLLEGAMENTO);
	}

	/**
	 * Sets the doc_collegato_anno of this documenti collegati.
	 *
	 * @param DOC_COLLEGATO_ANNO the doc_collegato_anno of this documenti collegati
	 */
	@Override
	public void setDOC_COLLEGATO_ANNO(int DOC_COLLEGATO_ANNO) {
		model.setDOC_COLLEGATO_ANNO(DOC_COLLEGATO_ANNO);
	}

	/**
	 * Sets the doc_collegato_numero of this documenti collegati.
	 *
	 * @param DOC_COLLEGATO_NUMERO the doc_collegato_numero of this documenti collegati
	 */
	@Override
	public void setDOC_COLLEGATO_NUMERO(String DOC_COLLEGATO_NUMERO) {
		model.setDOC_COLLEGATO_NUMERO(DOC_COLLEGATO_NUMERO);
	}

	/**
	 * Sets the doc_collegato_tipo_registro of this documenti collegati.
	 *
	 * @param DOC_COLLEGATO_TIPO_REGISTRO the doc_collegato_tipo_registro of this documenti collegati
	 */
	@Override
	public void setDOC_COLLEGATO_TIPO_REGISTRO(
		String DOC_COLLEGATO_TIPO_REGISTRO) {

		model.setDOC_COLLEGATO_TIPO_REGISTRO(DOC_COLLEGATO_TIPO_REGISTRO);
	}

	/**
	 * Sets the id_invio of this documenti collegati.
	 *
	 * @param ID_INVIO the id_invio of this documenti collegati
	 */
	@Override
	public void setID_INVIO(long ID_INVIO) {
		model.setID_INVIO(ID_INVIO);
	}

	/**
	 * Sets the primary key of this documenti collegati.
	 *
	 * @param primaryKey the primary key of this documenti collegati
	 */
	@Override
	public void setPrimaryKey(
		it.eng.parer.service.persistence.DocumentiCollegatiPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DocumentiCollegatiWrapper wrap(
		DocumentiCollegati documentiCollegati) {

		return new DocumentiCollegatiWrapper(documentiCollegati);
	}

}