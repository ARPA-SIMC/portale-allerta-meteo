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
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SMS service. Represents a row in the &quot;ALLERTER_SMS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.allerter.model.impl.SMSModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.allerter.model.impl.SMSImpl</code>.
 * </p>
 *
 * @author GFAVINI
 * @see SMS
 * @generated
 */
@ProviderType
public interface SMSModel extends BaseModel<SMS> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a sms model instance should use the {@link SMS} interface instead.
	 */

	/**
	 * Returns the primary key of this sms.
	 *
	 * @return the primary key of this sms
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this sms.
	 *
	 * @param primaryKey the primary key of this sms
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this sms.
	 *
	 * @return the ID of this sms
	 */
	public long getId();

	/**
	 * Sets the ID of this sms.
	 *
	 * @param id the ID of this sms
	 */
	public void setId(long id);

	/**
	 * Returns the tipo of this sms.
	 *
	 * @return the tipo of this sms
	 */
	@AutoEscape
	public String getTipo();

	/**
	 * Sets the tipo of this sms.
	 *
	 * @param tipo the tipo of this sms
	 */
	public void setTipo(String tipo);

	/**
	 * Returns the sottotipo of this sms.
	 *
	 * @return the sottotipo of this sms
	 */
	@AutoEscape
	public String getSottotipo();

	/**
	 * Sets the sottotipo of this sms.
	 *
	 * @param sottotipo the sottotipo of this sms
	 */
	public void setSottotipo(String sottotipo);

	/**
	 * Returns the param of this sms.
	 *
	 * @return the param of this sms
	 */
	public long getParam();

	/**
	 * Sets the param of this sms.
	 *
	 * @param param the param of this sms
	 */
	public void setParam(long param);

	/**
	 * Returns the testo of this sms.
	 *
	 * @return the testo of this sms
	 */
	@AutoEscape
	public String getTesto();

	/**
	 * Sets the testo of this sms.
	 *
	 * @param testo the testo of this sms
	 */
	public void setTesto(String testo);

	/**
	 * Returns the destinatario of this sms.
	 *
	 * @return the destinatario of this sms
	 */
	public long getDestinatario();

	/**
	 * Sets the destinatario of this sms.
	 *
	 * @param destinatario the destinatario of this sms
	 */
	public void setDestinatario(long destinatario);

	/**
	 * Returns the numero da of this sms.
	 *
	 * @return the numero da of this sms
	 */
	@AutoEscape
	public String getNumeroDa();

	/**
	 * Sets the numero da of this sms.
	 *
	 * @param numeroDa the numero da of this sms
	 */
	public void setNumeroDa(String numeroDa);

	/**
	 * Returns the numero of this sms.
	 *
	 * @return the numero of this sms
	 */
	@AutoEscape
	public String getNumero();

	/**
	 * Sets the numero of this sms.
	 *
	 * @param numero the numero of this sms
	 */
	public void setNumero(String numero);

	/**
	 * Returns the nome destinatario of this sms.
	 *
	 * @return the nome destinatario of this sms
	 */
	@AutoEscape
	public String getNomeDestinatario();

	/**
	 * Sets the nome destinatario of this sms.
	 *
	 * @param nomeDestinatario the nome destinatario of this sms
	 */
	public void setNomeDestinatario(String nomeDestinatario);

	/**
	 * Returns the stato of this sms.
	 *
	 * @return the stato of this sms
	 */
	public long getStato();

	/**
	 * Sets the stato of this sms.
	 *
	 * @param stato the stato of this sms
	 */
	public void setStato(long stato);

	/**
	 * Returns the data invio of this sms.
	 *
	 * @return the data invio of this sms
	 */
	public Date getDataInvio();

	/**
	 * Sets the data invio of this sms.
	 *
	 * @param dataInvio the data invio of this sms
	 */
	public void setDataInvio(Date dataInvio);

	/**
	 * Returns the data ack of this sms.
	 *
	 * @return the data ack of this sms
	 */
	public Date getDataAck();

	/**
	 * Sets the data ack of this sms.
	 *
	 * @param dataAck the data ack of this sms
	 */
	public void setDataAck(Date dataAck);

	/**
	 * Returns the data ricevuta of this sms.
	 *
	 * @return the data ricevuta of this sms
	 */
	public Date getDataRicevuta();

	/**
	 * Sets the data ricevuta of this sms.
	 *
	 * @param dataRicevuta the data ricevuta of this sms
	 */
	public void setDataRicevuta(Date dataRicevuta);

	/**
	 * Returns the tentativi of this sms.
	 *
	 * @return the tentativi of this sms
	 */
	public long getTentativi();

	/**
	 * Sets the tentativi of this sms.
	 *
	 * @param tentativi the tentativi of this sms
	 */
	public void setTentativi(long tentativi);

	/**
	 * Returns the prossimo invio of this sms.
	 *
	 * @return the prossimo invio of this sms
	 */
	public Date getProssimoInvio();

	/**
	 * Sets the prossimo invio of this sms.
	 *
	 * @param prossimoInvio the prossimo invio of this sms
	 */
	public void setProssimoInvio(Date prossimoInvio);

	/**
	 * Returns the codice errore of this sms.
	 *
	 * @return the codice errore of this sms
	 */
	@AutoEscape
	public String getCodiceErrore();

	/**
	 * Sets the codice errore of this sms.
	 *
	 * @param codiceErrore the codice errore of this sms
	 */
	public void setCodiceErrore(String codiceErrore);

	/**
	 * Returns the descrizione errore of this sms.
	 *
	 * @return the descrizione errore of this sms
	 */
	@AutoEscape
	public String getDescrizioneErrore();

	/**
	 * Sets the descrizione errore of this sms.
	 *
	 * @param descrizioneErrore the descrizione errore of this sms
	 */
	public void setDescrizioneErrore(String descrizioneErrore);

	/**
	 * Returns the timestamp of this sms.
	 *
	 * @return the timestamp of this sms
	 */
	@AutoEscape
	public String getTimestamp();

	/**
	 * Sets the timestamp of this sms.
	 *
	 * @param timestamp the timestamp of this sms
	 */
	public void setTimestamp(String timestamp);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(it.eng.allerter.model.SMS sms);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.eng.allerter.model.SMS> toCacheModel();

	@Override
	public it.eng.allerter.model.SMS toEscapedModel();

	@Override
	public it.eng.allerter.model.SMS toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}