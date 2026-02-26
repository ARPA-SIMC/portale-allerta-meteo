/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Nodo}.
 * </p>
 *
 * @author Giorgianni_F
 * @see Nodo
 * @generated
 */
public class NodoWrapper
	extends BaseModelWrapper<Nodo> implements ModelWrapper<Nodo>, Nodo {

	public NodoWrapper(Nodo nodo) {
		super(nodo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("ip", getIp());
		attributes.put("porta", getPorta());
		attributes.put("nodoConnesso", getNodoConnesso());
		attributes.put("dataConnessione", getDataConnessione());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long Id = (Long)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		String ip = (String)attributes.get("ip");

		if (ip != null) {
			setIp(ip);
		}

		Integer porta = (Integer)attributes.get("porta");

		if (porta != null) {
			setPorta(porta);
		}

		String nodoConnesso = (String)attributes.get("nodoConnesso");

		if (nodoConnesso != null) {
			setNodoConnesso(nodoConnesso);
		}

		Date dataConnessione = (Date)attributes.get("dataConnessione");

		if (dataConnessione != null) {
			setDataConnessione(dataConnessione);
		}
	}

	@Override
	public Nodo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the data connessione of this nodo.
	 *
	 * @return the data connessione of this nodo
	 */
	@Override
	public Date getDataConnessione() {
		return model.getDataConnessione();
	}

	/**
	 * Returns the ID of this nodo.
	 *
	 * @return the ID of this nodo
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the ip of this nodo.
	 *
	 * @return the ip of this nodo
	 */
	@Override
	public String getIp() {
		return model.getIp();
	}

	/**
	 * Returns the nodo connesso of this nodo.
	 *
	 * @return the nodo connesso of this nodo
	 */
	@Override
	public String getNodoConnesso() {
		return model.getNodoConnesso();
	}

	/**
	 * Returns the porta of this nodo.
	 *
	 * @return the porta of this nodo
	 */
	@Override
	public int getPorta() {
		return model.getPorta();
	}

	/**
	 * Returns the primary key of this nodo.
	 *
	 * @return the primary key of this nodo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data connessione of this nodo.
	 *
	 * @param dataConnessione the data connessione of this nodo
	 */
	@Override
	public void setDataConnessione(Date dataConnessione) {
		model.setDataConnessione(dataConnessione);
	}

	/**
	 * Sets the ID of this nodo.
	 *
	 * @param Id the ID of this nodo
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the ip of this nodo.
	 *
	 * @param ip the ip of this nodo
	 */
	@Override
	public void setIp(String ip) {
		model.setIp(ip);
	}

	/**
	 * Sets the nodo connesso of this nodo.
	 *
	 * @param nodoConnesso the nodo connesso of this nodo
	 */
	@Override
	public void setNodoConnesso(String nodoConnesso) {
		model.setNodoConnesso(nodoConnesso);
	}

	/**
	 * Sets the porta of this nodo.
	 *
	 * @param porta the porta of this nodo
	 */
	@Override
	public void setPorta(int porta) {
		model.setPorta(porta);
	}

	/**
	 * Sets the primary key of this nodo.
	 *
	 * @param primaryKey the primary key of this nodo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected NodoWrapper wrap(Nodo nodo) {
		return new NodoWrapper(nodo);
	}

}