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
 * This class is a wrapper for {@link Parametro}.
 * </p>
 *
 * @author Giorgianni_F
 * @see Parametro
 * @generated
 */
public class ParametroWrapper
	extends BaseModelWrapper<Parametro>
	implements ModelWrapper<Parametro>, Parametro {

	public ParametroWrapper(Parametro parametro) {
		super(parametro);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("ip", getIp());
		attributes.put("porta", getPorta());
		attributes.put("username", getUsername());
		attributes.put("password", getPassword());
		attributes.put("mittente", getMittente());
		attributes.put("nodo", getNodo());
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

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String mittente = (String)attributes.get("mittente");

		if (mittente != null) {
			setMittente(mittente);
		}

		String nodo = (String)attributes.get("nodo");

		if (nodo != null) {
			setNodo(nodo);
		}

		Date dataConnessione = (Date)attributes.get("dataConnessione");

		if (dataConnessione != null) {
			setDataConnessione(dataConnessione);
		}
	}

	@Override
	public Parametro cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the data connessione of this parametro.
	 *
	 * @return the data connessione of this parametro
	 */
	@Override
	public Date getDataConnessione() {
		return model.getDataConnessione();
	}

	/**
	 * Returns the ID of this parametro.
	 *
	 * @return the ID of this parametro
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the ip of this parametro.
	 *
	 * @return the ip of this parametro
	 */
	@Override
	public String getIp() {
		return model.getIp();
	}

	/**
	 * Returns the mittente of this parametro.
	 *
	 * @return the mittente of this parametro
	 */
	@Override
	public String getMittente() {
		return model.getMittente();
	}

	/**
	 * Returns the nodo of this parametro.
	 *
	 * @return the nodo of this parametro
	 */
	@Override
	public String getNodo() {
		return model.getNodo();
	}

	/**
	 * Returns the password of this parametro.
	 *
	 * @return the password of this parametro
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the porta of this parametro.
	 *
	 * @return the porta of this parametro
	 */
	@Override
	public int getPorta() {
		return model.getPorta();
	}

	/**
	 * Returns the primary key of this parametro.
	 *
	 * @return the primary key of this parametro
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the username of this parametro.
	 *
	 * @return the username of this parametro
	 */
	@Override
	public String getUsername() {
		return model.getUsername();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the data connessione of this parametro.
	 *
	 * @param dataConnessione the data connessione of this parametro
	 */
	@Override
	public void setDataConnessione(Date dataConnessione) {
		model.setDataConnessione(dataConnessione);
	}

	/**
	 * Sets the ID of this parametro.
	 *
	 * @param Id the ID of this parametro
	 */
	@Override
	public void setId(long Id) {
		model.setId(Id);
	}

	/**
	 * Sets the ip of this parametro.
	 *
	 * @param ip the ip of this parametro
	 */
	@Override
	public void setIp(String ip) {
		model.setIp(ip);
	}

	/**
	 * Sets the mittente of this parametro.
	 *
	 * @param mittente the mittente of this parametro
	 */
	@Override
	public void setMittente(String mittente) {
		model.setMittente(mittente);
	}

	/**
	 * Sets the nodo of this parametro.
	 *
	 * @param nodo the nodo of this parametro
	 */
	@Override
	public void setNodo(String nodo) {
		model.setNodo(nodo);
	}

	/**
	 * Sets the password of this parametro.
	 *
	 * @param password the password of this parametro
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the porta of this parametro.
	 *
	 * @param porta the porta of this parametro
	 */
	@Override
	public void setPorta(int porta) {
		model.setPorta(porta);
	}

	/**
	 * Sets the primary key of this parametro.
	 *
	 * @param primaryKey the primary key of this parametro
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the username of this parametro.
	 *
	 * @param username the username of this parametro
	 */
	@Override
	public void setUsername(String username) {
		model.setUsername(username);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ParametroWrapper wrap(Parametro parametro) {
		return new ParametroWrapper(parametro);
	}

}