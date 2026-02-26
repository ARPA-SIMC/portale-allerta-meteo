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
 * This class is a wrapper for {@link Email}.
 * </p>
 *
 * @author GFAVINI
 * @see Email
 * @generated
 */
public class EmailWrapper
	extends BaseModelWrapper<Email> implements Email, ModelWrapper<Email> {

	public EmailWrapper(Email email) {
		super(email);
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
	public Email cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the data invio of this email.
	 *
	 * @return the data invio of this email
	 */
	@Override
	public Date getDataInvio() {
		return model.getDataInvio();
	}

	/**
	 * Returns the destinatario of this email.
	 *
	 * @return the destinatario of this email
	 */
	@Override
	public long getDestinatario() {
		return model.getDestinatario();
	}

	/**
	 * Returns the ID of this email.
	 *
	 * @return the ID of this email
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the indirizzo of this email.
	 *
	 * @return the indirizzo of this email
	 */
	@Override
	public String getIndirizzo() {
		return model.getIndirizzo();
	}

	/**
	 * Returns the nome destinatario of this email.
	 *
	 * @return the nome destinatario of this email
	 */
	@Override
	public String getNomeDestinatario() {
		return model.getNomeDestinatario();
	}

	/**
	 * Returns the oggetto of this email.
	 *
	 * @return the oggetto of this email
	 */
	@Override
	public String getOggetto() {
		return model.getOggetto();
	}

	/**
	 * Returns the param of this email.
	 *
	 * @return the param of this email
	 */
	@Override
	public long getParam() {
		return model.getParam();
	}

	/**
	 * Returns the primary key of this email.
	 *
	 * @return the primary key of this email
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sottotipo of this email.
	 *
	 * @return the sottotipo of this email
	 */
	@Override
	public String getSottotipo() {
		return model.getSottotipo();
	}

	/**
	 * Returns the stato of this email.
	 *
	 * @return the stato of this email
	 */
	@Override
	public long getStato() {
		return model.getStato();
	}

	/**
	 * Returns the testo of this email.
	 *
	 * @return the testo of this email
	 */
	@Override
	public String getTesto() {
		return model.getTesto();
	}

	/**
	 * Returns the tipo of this email.
	 *
	 * @return the tipo of this email
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
	 * Sets the data invio of this email.
	 *
	 * @param dataInvio the data invio of this email
	 */
	@Override
	public void setDataInvio(Date dataInvio) {
		model.setDataInvio(dataInvio);
	}

	/**
	 * Sets the destinatario of this email.
	 *
	 * @param destinatario the destinatario of this email
	 */
	@Override
	public void setDestinatario(long destinatario) {
		model.setDestinatario(destinatario);
	}

	/**
	 * Sets the ID of this email.
	 *
	 * @param id the ID of this email
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the indirizzo of this email.
	 *
	 * @param indirizzo the indirizzo of this email
	 */
	@Override
	public void setIndirizzo(String indirizzo) {
		model.setIndirizzo(indirizzo);
	}

	/**
	 * Sets the nome destinatario of this email.
	 *
	 * @param nomeDestinatario the nome destinatario of this email
	 */
	@Override
	public void setNomeDestinatario(String nomeDestinatario) {
		model.setNomeDestinatario(nomeDestinatario);
	}

	/**
	 * Sets the oggetto of this email.
	 *
	 * @param oggetto the oggetto of this email
	 */
	@Override
	public void setOggetto(String oggetto) {
		model.setOggetto(oggetto);
	}

	/**
	 * Sets the param of this email.
	 *
	 * @param param the param of this email
	 */
	@Override
	public void setParam(long param) {
		model.setParam(param);
	}

	/**
	 * Sets the primary key of this email.
	 *
	 * @param primaryKey the primary key of this email
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sottotipo of this email.
	 *
	 * @param sottotipo the sottotipo of this email
	 */
	@Override
	public void setSottotipo(String sottotipo) {
		model.setSottotipo(sottotipo);
	}

	/**
	 * Sets the stato of this email.
	 *
	 * @param stato the stato of this email
	 */
	@Override
	public void setStato(long stato) {
		model.setStato(stato);
	}

	/**
	 * Sets the testo of this email.
	 *
	 * @param testo the testo of this email
	 */
	@Override
	public void setTesto(String testo) {
		model.setTesto(testo);
	}

	/**
	 * Sets the tipo of this email.
	 *
	 * @param tipo the tipo of this email
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
	protected EmailWrapper wrap(Email email) {
		return new EmailWrapper(email);
	}

}