/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Bollettino}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Bollettino
 * @generated
 */
public class BollettinoWrapper
	extends BaseModelWrapper<Bollettino>
	implements Bollettino, ModelWrapper<Bollettino> {

	public BollettinoWrapper(Bollettino bollettino) {
		super(bollettino);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tipo", getTipo());
		attributes.put("timestamp", getTimestamp());
		attributes.put("emissione", getEmissione());
		attributes.put("validita", getValidita());
		attributes.put("xml_content", getXml_content());
		attributes.put("json", getJson());

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

		Long timestamp = (Long)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		String emissione = (String)attributes.get("emissione");

		if (emissione != null) {
			setEmissione(emissione);
		}

		String validita = (String)attributes.get("validita");

		if (validita != null) {
			setValidita(validita);
		}

		String xml_content = (String)attributes.get("xml_content");

		if (xml_content != null) {
			setXml_content(xml_content);
		}

		String json = (String)attributes.get("json");

		if (json != null) {
			setJson(json);
		}
	}

	@Override
	public Bollettino cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the emissione of this bollettino.
	 *
	 * @return the emissione of this bollettino
	 */
	@Override
	public String getEmissione() {
		return model.getEmissione();
	}

	/**
	 * Returns the ID of this bollettino.
	 *
	 * @return the ID of this bollettino
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the json of this bollettino.
	 *
	 * @return the json of this bollettino
	 */
	@Override
	public String getJson() {
		return model.getJson();
	}

	/**
	 * Returns the primary key of this bollettino.
	 *
	 * @return the primary key of this bollettino
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the timestamp of this bollettino.
	 *
	 * @return the timestamp of this bollettino
	 */
	@Override
	public long getTimestamp() {
		return model.getTimestamp();
	}

	/**
	 * Returns the tipo of this bollettino.
	 *
	 * @return the tipo of this bollettino
	 */
	@Override
	public String getTipo() {
		return model.getTipo();
	}

	/**
	 * Returns the validita of this bollettino.
	 *
	 * @return the validita of this bollettino
	 */
	@Override
	public String getValidita() {
		return model.getValidita();
	}

	/**
	 * Returns the xml_content of this bollettino.
	 *
	 * @return the xml_content of this bollettino
	 */
	@Override
	public String getXml_content() {
		return model.getXml_content();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the emissione of this bollettino.
	 *
	 * @param emissione the emissione of this bollettino
	 */
	@Override
	public void setEmissione(String emissione) {
		model.setEmissione(emissione);
	}

	/**
	 * Sets the ID of this bollettino.
	 *
	 * @param id the ID of this bollettino
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the json of this bollettino.
	 *
	 * @param json the json of this bollettino
	 */
	@Override
	public void setJson(String json) {
		model.setJson(json);
	}

	/**
	 * Sets the primary key of this bollettino.
	 *
	 * @param primaryKey the primary key of this bollettino
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the timestamp of this bollettino.
	 *
	 * @param timestamp the timestamp of this bollettino
	 */
	@Override
	public void setTimestamp(long timestamp) {
		model.setTimestamp(timestamp);
	}

	/**
	 * Sets the tipo of this bollettino.
	 *
	 * @param tipo the tipo of this bollettino
	 */
	@Override
	public void setTipo(String tipo) {
		model.setTipo(tipo);
	}

	/**
	 * Sets the validita of this bollettino.
	 *
	 * @param validita the validita of this bollettino
	 */
	@Override
	public void setValidita(String validita) {
		model.setValidita(validita);
	}

	/**
	 * Sets the xml_content of this bollettino.
	 *
	 * @param xml_content the xml_content of this bollettino
	 */
	@Override
	public void setXml_content(String xml_content) {
		model.setXml_content(xml_content);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BollettinoWrapper wrap(Bollettino bollettino) {
		return new BollettinoWrapper(bollettino);
	}

}