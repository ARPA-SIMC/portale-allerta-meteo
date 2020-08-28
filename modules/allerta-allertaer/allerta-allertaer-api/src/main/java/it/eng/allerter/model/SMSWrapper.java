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
 * This class is a wrapper for {@link SMS}.
 * </p>
 *
 * @author GFAVINI
 * @see SMS
 * @generated
 */
@ProviderType
public class SMSWrapper implements SMS, ModelWrapper<SMS> {

	public SMSWrapper(SMS sms) {
		_sms = sms;
	}

	@Override
	public Class<?> getModelClass() {
		return SMS.class;
	}

	@Override
	public String getModelClassName() {
		return SMS.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tipo", getTipo());
		attributes.put("sottotipo", getSottotipo());
		attributes.put("param", getParam());
		attributes.put("testo", getTesto());
		attributes.put("destinatario", getDestinatario());
		attributes.put("numeroDa", getNumeroDa());
		attributes.put("numero", getNumero());
		attributes.put("nomeDestinatario", getNomeDestinatario());
		attributes.put("stato", getStato());
		attributes.put("dataInvio", getDataInvio());
		attributes.put("dataAck", getDataAck());
		attributes.put("dataRicevuta", getDataRicevuta());
		attributes.put("tentativi", getTentativi());
		attributes.put("prossimoInvio", getProssimoInvio());
		attributes.put("codiceErrore", getCodiceErrore());
		attributes.put("descrizioneErrore", getDescrizioneErrore());
		attributes.put("timestamp", getTimestamp());

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

		String testo = (String)attributes.get("testo");

		if (testo != null) {
			setTesto(testo);
		}

		Long destinatario = (Long)attributes.get("destinatario");

		if (destinatario != null) {
			setDestinatario(destinatario);
		}

		String numeroDa = (String)attributes.get("numeroDa");

		if (numeroDa != null) {
			setNumeroDa(numeroDa);
		}

		String numero = (String)attributes.get("numero");

		if (numero != null) {
			setNumero(numero);
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

		Date dataAck = (Date)attributes.get("dataAck");

		if (dataAck != null) {
			setDataAck(dataAck);
		}

		Date dataRicevuta = (Date)attributes.get("dataRicevuta");

		if (dataRicevuta != null) {
			setDataRicevuta(dataRicevuta);
		}

		Long tentativi = (Long)attributes.get("tentativi");

		if (tentativi != null) {
			setTentativi(tentativi);
		}

		Date prossimoInvio = (Date)attributes.get("prossimoInvio");

		if (prossimoInvio != null) {
			setProssimoInvio(prossimoInvio);
		}

		String codiceErrore = (String)attributes.get("codiceErrore");

		if (codiceErrore != null) {
			setCodiceErrore(codiceErrore);
		}

		String descrizioneErrore = (String)attributes.get("descrizioneErrore");

		if (descrizioneErrore != null) {
			setDescrizioneErrore(descrizioneErrore);
		}

		String timestamp = (String)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}
	}

	@Override
	public Object clone() {
		return new SMSWrapper((SMS)_sms.clone());
	}

	@Override
	public int compareTo(it.eng.allerter.model.SMS sms) {
		return _sms.compareTo(sms);
	}

	/**
	 * Returns the codice errore of this sms.
	 *
	 * @return the codice errore of this sms
	 */
	@Override
	public String getCodiceErrore() {
		return _sms.getCodiceErrore();
	}

	/**
	 * Returns the data ack of this sms.
	 *
	 * @return the data ack of this sms
	 */
	@Override
	public Date getDataAck() {
		return _sms.getDataAck();
	}

	/**
	 * Returns the data invio of this sms.
	 *
	 * @return the data invio of this sms
	 */
	@Override
	public Date getDataInvio() {
		return _sms.getDataInvio();
	}

	/**
	 * Returns the data ricevuta of this sms.
	 *
	 * @return the data ricevuta of this sms
	 */
	@Override
	public Date getDataRicevuta() {
		return _sms.getDataRicevuta();
	}

	/**
	 * Returns the descrizione errore of this sms.
	 *
	 * @return the descrizione errore of this sms
	 */
	@Override
	public String getDescrizioneErrore() {
		return _sms.getDescrizioneErrore();
	}

	/**
	 * Returns the destinatario of this sms.
	 *
	 * @return the destinatario of this sms
	 */
	@Override
	public long getDestinatario() {
		return _sms.getDestinatario();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _sms.getExpandoBridge();
	}

	/**
	 * Returns the ID of this sms.
	 *
	 * @return the ID of this sms
	 */
	@Override
	public long getId() {
		return _sms.getId();
	}

	/**
	 * Returns the nome destinatario of this sms.
	 *
	 * @return the nome destinatario of this sms
	 */
	@Override
	public String getNomeDestinatario() {
		return _sms.getNomeDestinatario();
	}

	/**
	 * Returns the numero of this sms.
	 *
	 * @return the numero of this sms
	 */
	@Override
	public String getNumero() {
		return _sms.getNumero();
	}

	/**
	 * Returns the numero da of this sms.
	 *
	 * @return the numero da of this sms
	 */
	@Override
	public String getNumeroDa() {
		return _sms.getNumeroDa();
	}

	/**
	 * Returns the param of this sms.
	 *
	 * @return the param of this sms
	 */
	@Override
	public long getParam() {
		return _sms.getParam();
	}

	/**
	 * Returns the primary key of this sms.
	 *
	 * @return the primary key of this sms
	 */
	@Override
	public long getPrimaryKey() {
		return _sms.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sms.getPrimaryKeyObj();
	}

	/**
	 * Returns the prossimo invio of this sms.
	 *
	 * @return the prossimo invio of this sms
	 */
	@Override
	public Date getProssimoInvio() {
		return _sms.getProssimoInvio();
	}

	/**
	 * Returns the sottotipo of this sms.
	 *
	 * @return the sottotipo of this sms
	 */
	@Override
	public String getSottotipo() {
		return _sms.getSottotipo();
	}

	/**
	 * Returns the stato of this sms.
	 *
	 * @return the stato of this sms
	 */
	@Override
	public long getStato() {
		return _sms.getStato();
	}

	/**
	 * Returns the tentativi of this sms.
	 *
	 * @return the tentativi of this sms
	 */
	@Override
	public long getTentativi() {
		return _sms.getTentativi();
	}

	/**
	 * Returns the testo of this sms.
	 *
	 * @return the testo of this sms
	 */
	@Override
	public String getTesto() {
		return _sms.getTesto();
	}

	/**
	 * Returns the timestamp of this sms.
	 *
	 * @return the timestamp of this sms
	 */
	@Override
	public String getTimestamp() {
		return _sms.getTimestamp();
	}

	/**
	 * Returns the tipo of this sms.
	 *
	 * @return the tipo of this sms
	 */
	@Override
	public String getTipo() {
		return _sms.getTipo();
	}

	@Override
	public int hashCode() {
		return _sms.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _sms.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _sms.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _sms.isNew();
	}

	@Override
	public void persist() {
		_sms.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sms.setCachedModel(cachedModel);
	}

	/**
	 * Sets the codice errore of this sms.
	 *
	 * @param codiceErrore the codice errore of this sms
	 */
	@Override
	public void setCodiceErrore(String codiceErrore) {
		_sms.setCodiceErrore(codiceErrore);
	}

	/**
	 * Sets the data ack of this sms.
	 *
	 * @param dataAck the data ack of this sms
	 */
	@Override
	public void setDataAck(Date dataAck) {
		_sms.setDataAck(dataAck);
	}

	/**
	 * Sets the data invio of this sms.
	 *
	 * @param dataInvio the data invio of this sms
	 */
	@Override
	public void setDataInvio(Date dataInvio) {
		_sms.setDataInvio(dataInvio);
	}

	/**
	 * Sets the data ricevuta of this sms.
	 *
	 * @param dataRicevuta the data ricevuta of this sms
	 */
	@Override
	public void setDataRicevuta(Date dataRicevuta) {
		_sms.setDataRicevuta(dataRicevuta);
	}

	/**
	 * Sets the descrizione errore of this sms.
	 *
	 * @param descrizioneErrore the descrizione errore of this sms
	 */
	@Override
	public void setDescrizioneErrore(String descrizioneErrore) {
		_sms.setDescrizioneErrore(descrizioneErrore);
	}

	/**
	 * Sets the destinatario of this sms.
	 *
	 * @param destinatario the destinatario of this sms
	 */
	@Override
	public void setDestinatario(long destinatario) {
		_sms.setDestinatario(destinatario);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_sms.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_sms.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_sms.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the ID of this sms.
	 *
	 * @param id the ID of this sms
	 */
	@Override
	public void setId(long id) {
		_sms.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_sms.setNew(n);
	}

	/**
	 * Sets the nome destinatario of this sms.
	 *
	 * @param nomeDestinatario the nome destinatario of this sms
	 */
	@Override
	public void setNomeDestinatario(String nomeDestinatario) {
		_sms.setNomeDestinatario(nomeDestinatario);
	}

	/**
	 * Sets the numero of this sms.
	 *
	 * @param numero the numero of this sms
	 */
	@Override
	public void setNumero(String numero) {
		_sms.setNumero(numero);
	}

	/**
	 * Sets the numero da of this sms.
	 *
	 * @param numeroDa the numero da of this sms
	 */
	@Override
	public void setNumeroDa(String numeroDa) {
		_sms.setNumeroDa(numeroDa);
	}

	/**
	 * Sets the param of this sms.
	 *
	 * @param param the param of this sms
	 */
	@Override
	public void setParam(long param) {
		_sms.setParam(param);
	}

	/**
	 * Sets the primary key of this sms.
	 *
	 * @param primaryKey the primary key of this sms
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sms.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_sms.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the prossimo invio of this sms.
	 *
	 * @param prossimoInvio the prossimo invio of this sms
	 */
	@Override
	public void setProssimoInvio(Date prossimoInvio) {
		_sms.setProssimoInvio(prossimoInvio);
	}

	/**
	 * Sets the sottotipo of this sms.
	 *
	 * @param sottotipo the sottotipo of this sms
	 */
	@Override
	public void setSottotipo(String sottotipo) {
		_sms.setSottotipo(sottotipo);
	}

	/**
	 * Sets the stato of this sms.
	 *
	 * @param stato the stato of this sms
	 */
	@Override
	public void setStato(long stato) {
		_sms.setStato(stato);
	}

	/**
	 * Sets the tentativi of this sms.
	 *
	 * @param tentativi the tentativi of this sms
	 */
	@Override
	public void setTentativi(long tentativi) {
		_sms.setTentativi(tentativi);
	}

	/**
	 * Sets the testo of this sms.
	 *
	 * @param testo the testo of this sms
	 */
	@Override
	public void setTesto(String testo) {
		_sms.setTesto(testo);
	}

	/**
	 * Sets the timestamp of this sms.
	 *
	 * @param timestamp the timestamp of this sms
	 */
	@Override
	public void setTimestamp(String timestamp) {
		_sms.setTimestamp(timestamp);
	}

	/**
	 * Sets the tipo of this sms.
	 *
	 * @param tipo the tipo of this sms
	 */
	@Override
	public void setTipo(String tipo) {
		_sms.setTipo(tipo);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<it.eng.allerter.model.SMS>
		toCacheModel() {

		return _sms.toCacheModel();
	}

	@Override
	public it.eng.allerter.model.SMS toEscapedModel() {
		return new SMSWrapper(_sms.toEscapedModel());
	}

	@Override
	public String toString() {
		return _sms.toString();
	}

	@Override
	public it.eng.allerter.model.SMS toUnescapedModel() {
		return new SMSWrapper(_sms.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _sms.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SMSWrapper)) {
			return false;
		}

		SMSWrapper smsWrapper = (SMSWrapper)obj;

		if (Objects.equals(_sms, smsWrapper._sms)) {
			return true;
		}

		return false;
	}

	@Override
	public SMS getWrappedModel() {
		return _sms;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _sms.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _sms.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_sms.resetOriginalValues();
	}

	private final SMS _sms;

}