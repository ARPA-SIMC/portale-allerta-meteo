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

package it.eng.allerter.model;

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
 * This class is a wrapper for {@link Email}.
 * </p>
 *
 * @author GFAVINI
 * @see Email
 * @generated
 */
@ProviderType
public class EmailWrapper implements Email, ModelWrapper<Email> {

	public EmailWrapper(Email email) {
		_email = email;
	}

	@Override
	public Class<?> getModelClass() {
		return Email.class;
	}

	@Override
	public String getModelClassName() {
		return Email.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tipo", getTipo());
		attributes.put("sottotipo", getSottotipo());
		attributes.put("param", getParam());
		attributes.put("destinatario", getDestinatario());
		attributes.put("indirizzo", getIndirizzo());
		attributes.put("nomeDestinatario", getNomeDestinatario());
		attributes.put("stato", getStato());
		attributes.put("dataInvio", getDataInvio());
		attributes.put("testo", getTesto());
		attributes.put("oggetto", getOggetto());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String tipo = (String)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		String sottotipo = (String)attributes.get("sottotipo");

		if (sottotipo != null) {
			setSottotipo(sottotipo);
		}

		Long param = (Long)attributes.get("param");

		if (param != null) {
			setParam(param);
		}

		Long destinatario = (Long)attributes.get("destinatario");

		if (destinatario != null) {
			setDestinatario(destinatario);
		}

		String indirizzo = (String)attributes.get("indirizzo");

		if (indirizzo != null) {
			setIndirizzo(indirizzo);
		}

		String nomeDestinatario = (String)attributes.get("nomeDestinatario");

		if (nomeDestinatario != null) {
			setNomeDestinatario(nomeDestinatario);
		}

		Long stato = (Long)attributes.get("stato");

		if (stato != null) {
			setStato(stato);
		}

		Date dataInvio = (Date)attributes.get("dataInvio");

		if (dataInvio != null) {
			setDataInvio(dataInvio);
		}

		String testo = (String)attributes.get("testo");

		if (testo != null) {
			setTesto(testo);
		}

		String oggetto = (String)attributes.get("oggetto");

		if (oggetto != null) {
			setOggetto(oggetto);
		}
	}

	@Override
	public Object clone() {
		return new EmailWrapper((Email)_email.clone());
	}

	@Override
	public int compareTo(it.eng.allerter.model.Email email) {
		return _email.compareTo(email);
	}

	/**
	 * Returns the data invio of this email.
	 *
	 * @return the data invio of this email
	 */
	@Override
	public Date getDataInvio() {
		return _email.getDataInvio();
	}

	/**
	 * Returns the destinatario of this email.
	 *
	 * @return the destinatario of this email
	 */
	@Override
	public long getDestinatario() {
		return _email.getDestinatario();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _email.getExpandoBridge();
	}

	/**
	 * Returns the ID of this email.
	 *
	 * @return the ID of this email
	 */
	@Override
	public long getId() {
		return _email.getId();
	}

	/**
	 * Returns the indirizzo of this email.
	 *
	 * @return the indirizzo of this email
	 */
	@Override
	public String getIndirizzo() {
		return _email.getIndirizzo();
	}

	/**
	 * Returns the nome destinatario of this email.
	 *
	 * @return the nome destinatario of this email
	 */
	@Override
	public String getNomeDestinatario() {
		return _email.getNomeDestinatario();
	}

	/**
	 * Returns the oggetto of this email.
	 *
	 * @return the oggetto of this email
	 */
	@Override
	public String getOggetto() {
		return _email.getOggetto();
	}

	/**
	 * Returns the param of this email.
	 *
	 * @return the param of this email
	 */
	@Override
	public long getParam() {
		return _email.getParam();
	}

	/**
	 * Returns the primary key of this email.
	 *
	 * @return the primary key of this email
	 */
	@Override
	public long getPrimaryKey() {
		return _email.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _email.getPrimaryKeyObj();
	}

	/**
	 * Returns the sottotipo of this email.
	 *
	 * @return the sottotipo of this email
	 */
	@Override
	public String getSottotipo() {
		return _email.getSottotipo();
	}

	/**
	 * Returns the stato of this email.
	 *
	 * @return the stato of this email
	 */
	@Override
	public long getStato() {
		return _email.getStato();
	}

	/**
	 * Returns the testo of this email.
	 *
	 * @return the testo of this email
	 */
	@Override
	public String getTesto() {
		return _email.getTesto();
	}

	/**
	 * Returns the tipo of this email.
	 *
	 * @return the tipo of this email
	 */
	@Override
	public String getTipo() {
		return _email.getTipo();
	}

	@Override
	public int hashCode() {
		return _email.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _email.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _email.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _email.isNew();
	}

	@Override
	public void persist() {
		_email.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_email.setCachedModel(cachedModel);
	}

	/**
	 * Sets the data invio of this email.
	 *
	 * @param dataInvio the data invio of this email
	 */
	@Override
	public void setDataInvio(Date dataInvio) {
		_email.setDataInvio(dataInvio);
	}

	/**
	 * Sets the destinatario of this email.
	 *
	 * @param destinatario the destinatario of this email
	 */
	@Override
	public void setDestinatario(long destinatario) {
		_email.setDestinatario(destinatario);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_email.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_email.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_email.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this email.
	 *
	 * @param id the ID of this email
	 */
	@Override
	public void setId(long id) {
		_email.setId(id);
	}

	/**
	 * Sets the indirizzo of this email.
	 *
	 * @param indirizzo the indirizzo of this email
	 */
	@Override
	public void setIndirizzo(String indirizzo) {
		_email.setIndirizzo(indirizzo);
	}

	@Override
	public void setNew(boolean n) {
		_email.setNew(n);
	}

	/**
	 * Sets the nome destinatario of this email.
	 *
	 * @param nomeDestinatario the nome destinatario of this email
	 */
	@Override
	public void setNomeDestinatario(String nomeDestinatario) {
		_email.setNomeDestinatario(nomeDestinatario);
	}

	/**
	 * Sets the oggetto of this email.
	 *
	 * @param oggetto the oggetto of this email
	 */
	@Override
	public void setOggetto(String oggetto) {
		_email.setOggetto(oggetto);
	}

	/**
	 * Sets the param of this email.
	 *
	 * @param param the param of this email
	 */
	@Override
	public void setParam(long param) {
		_email.setParam(param);
	}

	/**
	 * Sets the primary key of this email.
	 *
	 * @param primaryKey the primary key of this email
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_email.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_email.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the sottotipo of this email.
	 *
	 * @param sottotipo the sottotipo of this email
	 */
	@Override
	public void setSottotipo(String sottotipo) {
		_email.setSottotipo(sottotipo);
	}

	/**
	 * Sets the stato of this email.
	 *
	 * @param stato the stato of this email
	 */
	@Override
	public void setStato(long stato) {
		_email.setStato(stato);
	}

	/**
	 * Sets the testo of this email.
	 *
	 * @param testo the testo of this email
	 */
	@Override
	public void setTesto(String testo) {
		_email.setTesto(testo);
	}

	/**
	 * Sets the tipo of this email.
	 *
	 * @param tipo the tipo of this email
	 */
	@Override
	public void setTipo(String tipo) {
		_email.setTipo(tipo);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.eng.allerter.model.Email> toCacheModel() {

		return _email.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.Email toEscapedModel() {
		return new EmailWrapper(_email.toEscapedModel());
	}

	@Override
	public String toString() {
		return _email.toString();
	}

	@Override
	public it.eng.allerter.model.Email toUnescapedModel() {
		return new EmailWrapper(_email.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _email.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailWrapper)) {
			return false;
		}

		EmailWrapper emailWrapper = (EmailWrapper)obj;

		if (Objects.equals(_email, emailWrapper._email)) {
			return true;
		}

		return false;
	}

	@Override
	public Email getWrappedModel() {
		return _email;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _email.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _email.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_email.resetOriginalValues();
	}

	private final Email _email;

}