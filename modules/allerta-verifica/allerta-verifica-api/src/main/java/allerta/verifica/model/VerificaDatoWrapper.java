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

package allerta.verifica.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link VerificaDato}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VerificaDato
 * @generated
 */
@ProviderType
public class VerificaDatoWrapper
	implements VerificaDato, ModelWrapper<VerificaDato> {

	public VerificaDatoWrapper(VerificaDato verificaDato) {
		_verificaDato = verificaDato;
	}

	@Override
	public Class<?> getModelClass() {
		return VerificaDato.class;
	}

	@Override
	public String getModelClassName() {
		return VerificaDato.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("documento", getDocumento());
		attributes.put("giorno", getGiorno());
		attributes.put("zona", getZona());
		attributes.put("evento", getEvento());
		attributes.put("nomeDato", getNomeDato());
		attributes.put("progressivo", getProgressivo());
		attributes.put("datoInserito", getDatoInserito());
		attributes.put("datoCalcolato", getDatoCalcolato());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long documento = (Long)attributes.get("documento");

		if (documento != null) {
			setDocumento(documento);
		}

		Date giorno = (Date)attributes.get("giorno");

		if (giorno != null) {
			setGiorno(giorno);
		}

		String zona = (String)attributes.get("zona");

		if (zona != null) {
			setZona(zona);
		}

		Long evento = (Long)attributes.get("evento");

		if (evento != null) {
			setEvento(evento);
		}

		String nomeDato = (String)attributes.get("nomeDato");

		if (nomeDato != null) {
			setNomeDato(nomeDato);
		}

		Integer progressivo = (Integer)attributes.get("progressivo");

		if (progressivo != null) {
			setProgressivo(progressivo);
		}

		String datoInserito = (String)attributes.get("datoInserito");

		if (datoInserito != null) {
			setDatoInserito(datoInserito);
		}

		String datoCalcolato = (String)attributes.get("datoCalcolato");

		if (datoCalcolato != null) {
			setDatoCalcolato(datoCalcolato);
		}
	}

	@Override
	public Object clone() {
		return new VerificaDatoWrapper((VerificaDato)_verificaDato.clone());
	}

	@Override
	public int compareTo(allerta.verifica.model.VerificaDato verificaDato) {
		return _verificaDato.compareTo(verificaDato);
	}

	/**
	 * Returns the dato calcolato of this verifica dato.
	 *
	 * @return the dato calcolato of this verifica dato
	 */
	@Override
	public String getDatoCalcolato() {
		return _verificaDato.getDatoCalcolato();
	}

	/**
	 * Returns the dato inserito of this verifica dato.
	 *
	 * @return the dato inserito of this verifica dato
	 */
	@Override
	public String getDatoInserito() {
		return _verificaDato.getDatoInserito();
	}

	/**
	 * Returns the documento of this verifica dato.
	 *
	 * @return the documento of this verifica dato
	 */
	@Override
	public long getDocumento() {
		return _verificaDato.getDocumento();
	}

	/**
	 * Returns the evento of this verifica dato.
	 *
	 * @return the evento of this verifica dato
	 */
	@Override
	public long getEvento() {
		return _verificaDato.getEvento();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _verificaDato.getExpandoBridge();
	}

	/**
	 * Returns the giorno of this verifica dato.
	 *
	 * @return the giorno of this verifica dato
	 */
	@Override
	public Date getGiorno() {
		return _verificaDato.getGiorno();
	}

	/**
	 * Returns the ID of this verifica dato.
	 *
	 * @return the ID of this verifica dato
	 */
	@Override
	public long getId() {
		return _verificaDato.getId();
	}

	/**
	 * Returns the nome dato of this verifica dato.
	 *
	 * @return the nome dato of this verifica dato
	 */
	@Override
	public String getNomeDato() {
		return _verificaDato.getNomeDato();
	}

	/**
	 * Returns the primary key of this verifica dato.
	 *
	 * @return the primary key of this verifica dato
	 */
	@Override
	public long getPrimaryKey() {
		return _verificaDato.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _verificaDato.getPrimaryKeyObj();
	}

	/**
	 * Returns the progressivo of this verifica dato.
	 *
	 * @return the progressivo of this verifica dato
	 */
	@Override
	public int getProgressivo() {
		return _verificaDato.getProgressivo();
	}

	/**
	 * Returns the zona of this verifica dato.
	 *
	 * @return the zona of this verifica dato
	 */
	@Override
	public String getZona() {
		return _verificaDato.getZona();
	}

	@Override
	public int hashCode() {
		return _verificaDato.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _verificaDato.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _verificaDato.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _verificaDato.isNew();
	}

	@Override
	public void persist() {
		_verificaDato.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_verificaDato.setCachedModel(cachedModel);
	}

	/**
	 * Sets the dato calcolato of this verifica dato.
	 *
	 * @param datoCalcolato the dato calcolato of this verifica dato
	 */
	@Override
	public void setDatoCalcolato(String datoCalcolato) {
		_verificaDato.setDatoCalcolato(datoCalcolato);
	}

	/**
	 * Sets the dato inserito of this verifica dato.
	 *
	 * @param datoInserito the dato inserito of this verifica dato
	 */
	@Override
	public void setDatoInserito(String datoInserito) {
		_verificaDato.setDatoInserito(datoInserito);
	}

	/**
	 * Sets the documento of this verifica dato.
	 *
	 * @param documento the documento of this verifica dato
	 */
	@Override
	public void setDocumento(long documento) {
		_verificaDato.setDocumento(documento);
	}

	/**
	 * Sets the evento of this verifica dato.
	 *
	 * @param evento the evento of this verifica dato
	 */
	@Override
	public void setEvento(long evento) {
		_verificaDato.setEvento(evento);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_verificaDato.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_verificaDato.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_verificaDato.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the giorno of this verifica dato.
	 *
	 * @param giorno the giorno of this verifica dato
	 */
	@Override
	public void setGiorno(Date giorno) {
		_verificaDato.setGiorno(giorno);
	}

	/**
	 * Sets the ID of this verifica dato.
	 *
	 * @param id the ID of this verifica dato
	 */
	@Override
	public void setId(long id) {
		_verificaDato.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_verificaDato.setNew(n);
	}

	/**
	 * Sets the nome dato of this verifica dato.
	 *
	 * @param nomeDato the nome dato of this verifica dato
	 */
	@Override
	public void setNomeDato(String nomeDato) {
		_verificaDato.setNomeDato(nomeDato);
	}

	/**
	 * Sets the primary key of this verifica dato.
	 *
	 * @param primaryKey the primary key of this verifica dato
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_verificaDato.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_verificaDato.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the progressivo of this verifica dato.
	 *
	 * @param progressivo the progressivo of this verifica dato
	 */
	@Override
	public void setProgressivo(int progressivo) {
		_verificaDato.setProgressivo(progressivo);
	}

	/**
	 * Sets the zona of this verifica dato.
	 *
	 * @param zona the zona of this verifica dato
	 */
	@Override
	public void setZona(String zona) {
		_verificaDato.setZona(zona);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<allerta.verifica.model.VerificaDato> toCacheModel() {

		return _verificaDato.toCacheModel();
	}

	@Override
	public allerta.verifica.model.VerificaDato toEscapedModel() {
		return new VerificaDatoWrapper(_verificaDato.toEscapedModel());
	}

	@Override
	public String toString() {
		return _verificaDato.toString();
	}

	@Override
	public allerta.verifica.model.VerificaDato toUnescapedModel() {
		return new VerificaDatoWrapper(_verificaDato.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _verificaDato.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VerificaDatoWrapper)) {
			return false;
		}

		VerificaDatoWrapper verificaDatoWrapper = (VerificaDatoWrapper)obj;

		if (Objects.equals(_verificaDato, verificaDatoWrapper._verificaDato)) {
			return true;
		}

		return false;
	}

	@Override
	public VerificaDato getWrappedModel() {
		return _verificaDato;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _verificaDato.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _verificaDato.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_verificaDato.resetOriginalValues();
	}

	private final VerificaDato _verificaDato;

}