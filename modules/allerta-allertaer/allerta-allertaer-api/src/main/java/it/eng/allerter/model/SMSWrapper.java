/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SMS}.
 * </p>
 *
 * @author GFAVINI
 * @see SMS
 * @generated
 */
public class SMSWrapper
	extends BaseModelWrapper<SMS> implements ModelWrapper<SMS>, SMS {

	public SMSWrapper(SMS sms) {
		super(sms);
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
	public SMS cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the codice errore of this sms.
	 *
	 * @return the codice errore of this sms
	 */
	@Override
	public String getCodiceErrore() {
		return model.getCodiceErrore();
	}

	/**
	 * Returns the data ack of this sms.
	 *
	 * @return the data ack of this sms
	 */
	@Override
	public Date getDataAck() {
		return model.getDataAck();
	}

	/**
	 * Returns the data invio of this sms.
	 *
	 * @return the data invio of this sms
	 */
	@Override
	public Date getDataInvio() {
		return model.getDataInvio();
	}

	/**
	 * Returns the data ricevuta of this sms.
	 *
	 * @return the data ricevuta of this sms
	 */
	@Override
	public Date getDataRicevuta() {
		return model.getDataRicevuta();
	}

	/**
	 * Returns the descrizione errore of this sms.
	 *
	 * @return the descrizione errore of this sms
	 */
	@Override
	public String getDescrizioneErrore() {
		return model.getDescrizioneErrore();
	}

	/**
	 * Returns the destinatario of this sms.
	 *
	 * @return the destinatario of this sms
	 */
	@Override
	public long getDestinatario() {
		return model.getDestinatario();
	}

	/**
	 * Returns the ID of this sms.
	 *
	 * @return the ID of this sms
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the nome destinatario of this sms.
	 *
	 * @return the nome destinatario of this sms
	 */
	@Override
	public String getNomeDestinatario() {
		return model.getNomeDestinatario();
	}

	/**
	 * Returns the numero of this sms.
	 *
	 * @return the numero of this sms
	 */
	@Override
	public String getNumero() {
		return model.getNumero();
	}

	/**
	 * Returns the numero da of this sms.
	 *
	 * @return the numero da of this sms
	 */
	@Override
	public String getNumeroDa() {
		return model.getNumeroDa();
	}

	/**
	 * Returns the param of this sms.
	 *
	 * @return the param of this sms
	 */
	@Override
	public long getParam() {
		return model.getParam();
	}

	/**
	 * Returns the primary key of this sms.
	 *
	 * @return the primary key of this sms
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prossimo invio of this sms.
	 *
	 * @return the prossimo invio of this sms
	 */
	@Override
	public Date getProssimoInvio() {
		return model.getProssimoInvio();
	}

	/**
	 * Returns the sottotipo of this sms.
	 *
	 * @return the sottotipo of this sms
	 */
	@Override
	public String getSottotipo() {
		return model.getSottotipo();
	}

	/**
	 * Returns the stato of this sms.
	 *
	 * @return the stato of this sms
	 */
	@Override
	public long getStato() {
		return model.getStato();
	}

	/**
	 * Returns the tentativi of this sms.
	 *
	 * @return the tentativi of this sms
	 */
	@Override
	public long getTentativi() {
		return model.getTentativi();
	}

	/**
	 * Returns the testo of this sms.
	 *
	 * @return the testo of this sms
	 */
	@Override
	public String getTesto() {
		return model.getTesto();
	}

	/**
	 * Returns the timestamp of this sms.
	 *
	 * @return the timestamp of this sms
	 */
	@Override
	public String getTimestamp() {
		return model.getTimestamp();
	}

	/**
	 * Returns the tipo of this sms.
	 *
	 * @return the tipo of this sms
	 */
	@Override
	public String getTipo() {
		return model.getTipo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the codice errore of this sms.
	 *
	 * @param codiceErrore the codice errore of this sms
	 */
	@Override
	public void setCodiceErrore(String codiceErrore) {
		model.setCodiceErrore(codiceErrore);
	}

	/**
	 * Sets the data ack of this sms.
	 *
	 * @param dataAck the data ack of this sms
	 */
	@Override
	public void setDataAck(Date dataAck) {
		model.setDataAck(dataAck);
	}

	/**
	 * Sets the data invio of this sms.
	 *
	 * @param dataInvio the data invio of this sms
	 */
	@Override
	public void setDataInvio(Date dataInvio) {
		model.setDataInvio(dataInvio);
	}

	/**
	 * Sets the data ricevuta of this sms.
	 *
	 * @param dataRicevuta the data ricevuta of this sms
	 */
	@Override
	public void setDataRicevuta(Date dataRicevuta) {
		model.setDataRicevuta(dataRicevuta);
	}

	/**
	 * Sets the descrizione errore of this sms.
	 *
	 * @param descrizioneErrore the descrizione errore of this sms
	 */
	@Override
	public void setDescrizioneErrore(String descrizioneErrore) {
		model.setDescrizioneErrore(descrizioneErrore);
	}

	/**
	 * Sets the destinatario of this sms.
	 *
	 * @param destinatario the destinatario of this sms
	 */
	@Override
	public void setDestinatario(long destinatario) {
		model.setDestinatario(destinatario);
	}

	/**
	 * Sets the ID of this sms.
	 *
	 * @param id the ID of this sms
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the nome destinatario of this sms.
	 *
	 * @param nomeDestinatario the nome destinatario of this sms
	 */
	@Override
	public void setNomeDestinatario(String nomeDestinatario) {
		model.setNomeDestinatario(nomeDestinatario);
	}

	/**
	 * Sets the numero of this sms.
	 *
	 * @param numero the numero of this sms
	 */
	@Override
	public void setNumero(String numero) {
		model.setNumero(numero);
	}

	/**
	 * Sets the numero da of this sms.
	 *
	 * @param numeroDa the numero da of this sms
	 */
	@Override
	public void setNumeroDa(String numeroDa) {
		model.setNumeroDa(numeroDa);
	}

	/**
	 * Sets the param of this sms.
	 *
	 * @param param the param of this sms
	 */
	@Override
	public void setParam(long param) {
		model.setParam(param);
	}

	/**
	 * Sets the primary key of this sms.
	 *
	 * @param primaryKey the primary key of this sms
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prossimo invio of this sms.
	 *
	 * @param prossimoInvio the prossimo invio of this sms
	 */
	@Override
	public void setProssimoInvio(Date prossimoInvio) {
		model.setProssimoInvio(prossimoInvio);
	}

	/**
	 * Sets the sottotipo of this sms.
	 *
	 * @param sottotipo the sottotipo of this sms
	 */
	@Override
	public void setSottotipo(String sottotipo) {
		model.setSottotipo(sottotipo);
	}

	/**
	 * Sets the stato of this sms.
	 *
	 * @param stato the stato of this sms
	 */
	@Override
	public void setStato(long stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the tentativi of this sms.
	 *
	 * @param tentativi the tentativi of this sms
	 */
	@Override
	public void setTentativi(long tentativi) {
		model.setTentativi(tentativi);
	}

	/**
	 * Sets the testo of this sms.
	 *
	 * @param testo the testo of this sms
	 */
	@Override
	public void setTesto(String testo) {
		model.setTesto(testo);
	}

	/**
	 * Sets the timestamp of this sms.
	 *
	 * @param timestamp the timestamp of this sms
	 */
	@Override
	public void setTimestamp(String timestamp) {
		model.setTimestamp(timestamp);
	}

	/**
	 * Sets the tipo of this sms.
	 *
	 * @param tipo the tipo of this sms
	 */
	@Override
	public void setTipo(String tipo) {
		model.setTipo(tipo);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SMSWrapper wrap(SMS sms) {
		return new SMSWrapper(sms);
	}

}