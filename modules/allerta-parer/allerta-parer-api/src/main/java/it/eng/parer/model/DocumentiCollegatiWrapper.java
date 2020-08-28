/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.parer.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link DocumentiCollegati}.
 * </p>
 *
 * @author Pratola_L
 * @see DocumentiCollegati
 * @generated
 */
@ProviderType
public class DocumentiCollegatiWrapper
	implements DocumentiCollegati, ModelWrapper<DocumentiCollegati> {

	public DocumentiCollegatiWrapper(DocumentiCollegati documentiCollegati) {
		_documentiCollegati = documentiCollegati;
	}

	@Override
	public Class<?> getModelClass() {
		return DocumentiCollegati.class;
	}

	@Override
	public String getModelClassName() {
		return DocumentiCollegati.class.getName();
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
	public Object clone() {
		return new DocumentiCollegatiWrapper(
			(DocumentiCollegati)_documentiCollegati.clone());
	}

	@Override
	public int compareTo(
		it.eng.parer.model.DocumentiCollegati documentiCollegati) {

		return _documentiCollegati.compareTo(documentiCollegati);
	}

	/**
	 * Returns the descrizione_collegamento of this documenti collegati.
	 *
	 * @return the descrizione_collegamento of this documenti collegati
	 */
	@Override
	public String getDESCRIZIONE_COLLEGAMENTO() {
		return _documentiCollegati.getDESCRIZIONE_COLLEGAMENTO();
	}

	/**
	 * Returns the doc_collegato_anno of this documenti collegati.
	 *
	 * @return the doc_collegato_anno of this documenti collegati
	 */
	@Override
	public int getDOC_COLLEGATO_ANNO() {
		return _documentiCollegati.getDOC_COLLEGATO_ANNO();
	}

	/**
	 * Returns the doc_collegato_numero of this documenti collegati.
	 *
	 * @return the doc_collegato_numero of this documenti collegati
	 */
	@Override
	public String getDOC_COLLEGATO_NUMERO() {
		return _documentiCollegati.getDOC_COLLEGATO_NUMERO();
	}

	/**
	 * Returns the doc_collegato_tipo_registro of this documenti collegati.
	 *
	 * @return the doc_collegato_tipo_registro of this documenti collegati
	 */
	@Override
	public String getDOC_COLLEGATO_TIPO_REGISTRO() {
		return _documentiCollegati.getDOC_COLLEGATO_TIPO_REGISTRO();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _documentiCollegati.getExpandoBridge();
	}

	/**
	 * Returns the id_invio of this documenti collegati.
	 *
	 * @return the id_invio of this documenti collegati
	 */
	@Override
	public long getID_INVIO() {
		return _documentiCollegati.getID_INVIO();
	}

	/**
	 * Returns the primary key of this documenti collegati.
	 *
	 * @return the primary key of this documenti collegati
	 */
	@Override
	public it.eng.parer.service.persistence.DocumentiCollegatiPK
		getPrimaryKey() {

		return _documentiCollegati.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _documentiCollegati.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _documentiCollegati.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _documentiCollegati.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _documentiCollegati.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _documentiCollegati.isNew();
	}

	@Override
	public void persist() {
		_documentiCollegati.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_documentiCollegati.setCachedModel(cachedModel);
	}

	/**
	 * Sets the descrizione_collegamento of this documenti collegati.
	 *
	 * @param DESCRIZIONE_COLLEGAMENTO the descrizione_collegamento of this documenti collegati
	 */
	@Override
	public void setDESCRIZIONE_COLLEGAMENTO(String DESCRIZIONE_COLLEGAMENTO) {
		_documentiCollegati.setDESCRIZIONE_COLLEGAMENTO(
			DESCRIZIONE_COLLEGAMENTO);
	}

	/**
	 * Sets the doc_collegato_anno of this documenti collegati.
	 *
	 * @param DOC_COLLEGATO_ANNO the doc_collegato_anno of this documenti collegati
	 */
	@Override
	public void setDOC_COLLEGATO_ANNO(int DOC_COLLEGATO_ANNO) {
		_documentiCollegati.setDOC_COLLEGATO_ANNO(DOC_COLLEGATO_ANNO);
	}

	/**
	 * Sets the doc_collegato_numero of this documenti collegati.
	 *
	 * @param DOC_COLLEGATO_NUMERO the doc_collegato_numero of this documenti collegati
	 */
	@Override
	public void setDOC_COLLEGATO_NUMERO(String DOC_COLLEGATO_NUMERO) {
		_documentiCollegati.setDOC_COLLEGATO_NUMERO(DOC_COLLEGATO_NUMERO);
	}

	/**
	 * Sets the doc_collegato_tipo_registro of this documenti collegati.
	 *
	 * @param DOC_COLLEGATO_TIPO_REGISTRO the doc_collegato_tipo_registro of this documenti collegati
	 */
	@Override
	public void setDOC_COLLEGATO_TIPO_REGISTRO(
		String DOC_COLLEGATO_TIPO_REGISTRO) {

		_documentiCollegati.setDOC_COLLEGATO_TIPO_REGISTRO(
			DOC_COLLEGATO_TIPO_REGISTRO);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_documentiCollegati.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_documentiCollegati.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_documentiCollegati.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the id_invio of this documenti collegati.
	 *
	 * @param ID_INVIO the id_invio of this documenti collegati
	 */
	@Override
	public void setID_INVIO(long ID_INVIO) {
		_documentiCollegati.setID_INVIO(ID_INVIO);
	}

	@Override
	public void setNew(boolean n) {
		_documentiCollegati.setNew(n);
	}

	/**
	 * Sets the primary key of this documenti collegati.
	 *
	 * @param primaryKey the primary key of this documenti collegati
	 */
	@Override
	public void setPrimaryKey(
		it.eng.parer.service.persistence.DocumentiCollegatiPK primaryKey) {

		_documentiCollegati.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_documentiCollegati.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.parer.model.DocumentiCollegati> toCacheModel() {

		return _documentiCollegati.toCacheModel();
	}

	@Override
	public it.eng.parer.model.DocumentiCollegati toEscapedModel() {
		return new DocumentiCollegatiWrapper(
			_documentiCollegati.toEscapedModel());
	}

	@Override
	public String toString() {
		return _documentiCollegati.toString();
	}

	@Override
	public it.eng.parer.model.DocumentiCollegati toUnescapedModel() {
		return new DocumentiCollegatiWrapper(
			_documentiCollegati.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _documentiCollegati.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentiCollegatiWrapper)) {
			return false;
		}

		DocumentiCollegatiWrapper documentiCollegatiWrapper =
			(DocumentiCollegatiWrapper)obj;

		if (Objects.equals(
				_documentiCollegati,
				documentiCollegatiWrapper._documentiCollegati)) {

			return true;
		}

		return false;
	}

	@Override
	public DocumentiCollegati getWrappedModel() {
		return _documentiCollegati;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _documentiCollegati.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _documentiCollegati.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_documentiCollegati.resetOriginalValues();
	}

	private final DocumentiCollegati _documentiCollegati;

}