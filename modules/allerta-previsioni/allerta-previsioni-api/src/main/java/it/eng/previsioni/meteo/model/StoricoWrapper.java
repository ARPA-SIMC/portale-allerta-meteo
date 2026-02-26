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
 * This class is a wrapper for {@link Storico}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Storico
 * @generated
 */
public class StoricoWrapper
	extends BaseModelWrapper<Storico>
	implements ModelWrapper<Storico>, Storico {

	public StoricoWrapper(Storico storico) {
		super(storico);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("idZona", getIdZona());
		attributes.put("nome", getNome());
		attributes.put("sigla", getSigla());
		attributes.put("tipo", getTipo());
		attributes.put("xml", getXml());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer idZona = (Integer)attributes.get("idZona");

		if (idZona != null) {
			setIdZona(idZona);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String sigla = (String)attributes.get("sigla");

		if (sigla != null) {
			setSigla(sigla);
		}

		String tipo = (String)attributes.get("tipo");

		if (tipo != null) {
			setTipo(tipo);
		}

		String xml = (String)attributes.get("xml");

		if (xml != null) {
			setXml(xml);
		}
	}

	@Override
	public Storico cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this storico.
	 *
	 * @return the ID of this storico
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id zona of this storico.
	 *
	 * @return the id zona of this storico
	 */
	@Override
	public int getIdZona() {
		return model.getIdZona();
	}

	/**
	 * Returns the nome of this storico.
	 *
	 * @return the nome of this storico
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this storico.
	 *
	 * @return the primary key of this storico
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sigla of this storico.
	 *
	 * @return the sigla of this storico
	 */
	@Override
	public String getSigla() {
		return model.getSigla();
	}

	/**
	 * Returns the tipo of this storico.
	 *
	 * @return the tipo of this storico
	 */
	@Override
	public String getTipo() {
		return model.getTipo();
	}

	/**
	 * Returns the xml of this storico.
	 *
	 * @return the xml of this storico
	 */
	@Override
	public String getXml() {
		return model.getXml();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this storico.
	 *
	 * @param id the ID of this storico
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id zona of this storico.
	 *
	 * @param idZona the id zona of this storico
	 */
	@Override
	public void setIdZona(int idZona) {
		model.setIdZona(idZona);
	}

	/**
	 * Sets the nome of this storico.
	 *
	 * @param nome the nome of this storico
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this storico.
	 *
	 * @param primaryKey the primary key of this storico
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sigla of this storico.
	 *
	 * @param sigla the sigla of this storico
	 */
	@Override
	public void setSigla(String sigla) {
		model.setSigla(sigla);
	}

	/**
	 * Sets the tipo of this storico.
	 *
	 * @param tipo the tipo of this storico
	 */
	@Override
	public void setTipo(String tipo) {
		model.setTipo(tipo);
	}

	/**
	 * Sets the xml of this storico.
	 *
	 * @param xml the xml of this storico
	 */
	@Override
	public void setXml(String xml) {
		model.setXml(xml);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected StoricoWrapper wrap(Storico storico) {
		return new StoricoWrapper(storico);
	}

}