/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ComponentiInvio}.
 * </p>
 *
 * @author Pratola_L
 * @see ComponentiInvio
 * @generated
 */
public class ComponentiInvioWrapper
	extends BaseModelWrapper<ComponentiInvio>
	implements ComponentiInvio, ModelWrapper<ComponentiInvio> {

	public ComponentiInvioWrapper(ComponentiInvio componentiInvio) {
		super(componentiInvio);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_INVIO", getID_INVIO());
		attributes.put("ID_COMPONENTE", getID_COMPONENTE());
		attributes.put("ORDINE_PRESENTAZIONE", getORDINE_PRESENTAZIONE());
		attributes.put("TIPO_COMPONENTE", getTIPO_COMPONENTE());
		attributes.put(
			"TIPO_SUPPORTO_COMPONENTE", getTIPO_SUPPORTO_COMPONENTE());
		attributes.put("NOME_COMPONENTE", getNOME_COMPONENTE());
		attributes.put("FORMATO_FILE_VERSATO", getFORMATO_FILE_VERSATO());
		attributes.put("HASH_VERSATO", getHASH_VERSATO());
		attributes.put("URN_VERSATO", getURN_VERSATO());
		attributes.put("ID_COMPONENTE_VERSATO", getID_COMPONENTE_VERSATO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_INVIO = (Long)attributes.get("ID_INVIO");

		if (ID_INVIO != null) {
			setID_INVIO(ID_INVIO);
		}

		Long ID_COMPONENTE = (Long)attributes.get("ID_COMPONENTE");

		if (ID_COMPONENTE != null) {
			setID_COMPONENTE(ID_COMPONENTE);
		}

		Long ORDINE_PRESENTAZIONE = (Long)attributes.get(
			"ORDINE_PRESENTAZIONE");

		if (ORDINE_PRESENTAZIONE != null) {
			setORDINE_PRESENTAZIONE(ORDINE_PRESENTAZIONE);
		}

		String TIPO_COMPONENTE = (String)attributes.get("TIPO_COMPONENTE");

		if (TIPO_COMPONENTE != null) {
			setTIPO_COMPONENTE(TIPO_COMPONENTE);
		}

		String TIPO_SUPPORTO_COMPONENTE = (String)attributes.get(
			"TIPO_SUPPORTO_COMPONENTE");

		if (TIPO_SUPPORTO_COMPONENTE != null) {
			setTIPO_SUPPORTO_COMPONENTE(TIPO_SUPPORTO_COMPONENTE);
		}

		String NOME_COMPONENTE = (String)attributes.get("NOME_COMPONENTE");

		if (NOME_COMPONENTE != null) {
			setNOME_COMPONENTE(NOME_COMPONENTE);
		}

		String FORMATO_FILE_VERSATO = (String)attributes.get(
			"FORMATO_FILE_VERSATO");

		if (FORMATO_FILE_VERSATO != null) {
			setFORMATO_FILE_VERSATO(FORMATO_FILE_VERSATO);
		}

		String HASH_VERSATO = (String)attributes.get("HASH_VERSATO");

		if (HASH_VERSATO != null) {
			setHASH_VERSATO(HASH_VERSATO);
		}

		String URN_VERSATO = (String)attributes.get("URN_VERSATO");

		if (URN_VERSATO != null) {
			setURN_VERSATO(URN_VERSATO);
		}

		Long ID_COMPONENTE_VERSATO = (Long)attributes.get(
			"ID_COMPONENTE_VERSATO");

		if (ID_COMPONENTE_VERSATO != null) {
			setID_COMPONENTE_VERSATO(ID_COMPONENTE_VERSATO);
		}
	}

	@Override
	public ComponentiInvio cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the formato_file_versato of this componenti invio.
	 *
	 * @return the formato_file_versato of this componenti invio
	 */
	@Override
	public String getFORMATO_FILE_VERSATO() {
		return model.getFORMATO_FILE_VERSATO();
	}

	/**
	 * Returns the hash_versato of this componenti invio.
	 *
	 * @return the hash_versato of this componenti invio
	 */
	@Override
	public String getHASH_VERSATO() {
		return model.getHASH_VERSATO();
	}

	/**
	 * Returns the id_componente of this componenti invio.
	 *
	 * @return the id_componente of this componenti invio
	 */
	@Override
	public long getID_COMPONENTE() {
		return model.getID_COMPONENTE();
	}

	/**
	 * Returns the id_componente_versato of this componenti invio.
	 *
	 * @return the id_componente_versato of this componenti invio
	 */
	@Override
	public long getID_COMPONENTE_VERSATO() {
		return model.getID_COMPONENTE_VERSATO();
	}

	/**
	 * Returns the id_invio of this componenti invio.
	 *
	 * @return the id_invio of this componenti invio
	 */
	@Override
	public long getID_INVIO() {
		return model.getID_INVIO();
	}

	/**
	 * Returns the nome_componente of this componenti invio.
	 *
	 * @return the nome_componente of this componenti invio
	 */
	@Override
	public String getNOME_COMPONENTE() {
		return model.getNOME_COMPONENTE();
	}

	/**
	 * Returns the ordine_presentazione of this componenti invio.
	 *
	 * @return the ordine_presentazione of this componenti invio
	 */
	@Override
	public long getORDINE_PRESENTAZIONE() {
		return model.getORDINE_PRESENTAZIONE();
	}

	/**
	 * Returns the primary key of this componenti invio.
	 *
	 * @return the primary key of this componenti invio
	 */
	@Override
	public it.eng.parer.service.persistence.ComponentiInvioPK getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tipo_componente of this componenti invio.
	 *
	 * @return the tipo_componente of this componenti invio
	 */
	@Override
	public String getTIPO_COMPONENTE() {
		return model.getTIPO_COMPONENTE();
	}

	/**
	 * Returns the tipo_supporto_componente of this componenti invio.
	 *
	 * @return the tipo_supporto_componente of this componenti invio
	 */
	@Override
	public String getTIPO_SUPPORTO_COMPONENTE() {
		return model.getTIPO_SUPPORTO_COMPONENTE();
	}

	/**
	 * Returns the urn_versato of this componenti invio.
	 *
	 * @return the urn_versato of this componenti invio
	 */
	@Override
	public String getURN_VERSATO() {
		return model.getURN_VERSATO();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the formato_file_versato of this componenti invio.
	 *
	 * @param FORMATO_FILE_VERSATO the formato_file_versato of this componenti invio
	 */
	@Override
	public void setFORMATO_FILE_VERSATO(String FORMATO_FILE_VERSATO) {
		model.setFORMATO_FILE_VERSATO(FORMATO_FILE_VERSATO);
	}

	/**
	 * Sets the hash_versato of this componenti invio.
	 *
	 * @param HASH_VERSATO the hash_versato of this componenti invio
	 */
	@Override
	public void setHASH_VERSATO(String HASH_VERSATO) {
		model.setHASH_VERSATO(HASH_VERSATO);
	}

	/**
	 * Sets the id_componente of this componenti invio.
	 *
	 * @param ID_COMPONENTE the id_componente of this componenti invio
	 */
	@Override
	public void setID_COMPONENTE(long ID_COMPONENTE) {
		model.setID_COMPONENTE(ID_COMPONENTE);
	}

	/**
	 * Sets the id_componente_versato of this componenti invio.
	 *
	 * @param ID_COMPONENTE_VERSATO the id_componente_versato of this componenti invio
	 */
	@Override
	public void setID_COMPONENTE_VERSATO(long ID_COMPONENTE_VERSATO) {
		model.setID_COMPONENTE_VERSATO(ID_COMPONENTE_VERSATO);
	}

	/**
	 * Sets the id_invio of this componenti invio.
	 *
	 * @param ID_INVIO the id_invio of this componenti invio
	 */
	@Override
	public void setID_INVIO(long ID_INVIO) {
		model.setID_INVIO(ID_INVIO);
	}

	/**
	 * Sets the nome_componente of this componenti invio.
	 *
	 * @param NOME_COMPONENTE the nome_componente of this componenti invio
	 */
	@Override
	public void setNOME_COMPONENTE(String NOME_COMPONENTE) {
		model.setNOME_COMPONENTE(NOME_COMPONENTE);
	}

	/**
	 * Sets the ordine_presentazione of this componenti invio.
	 *
	 * @param ORDINE_PRESENTAZIONE the ordine_presentazione of this componenti invio
	 */
	@Override
	public void setORDINE_PRESENTAZIONE(long ORDINE_PRESENTAZIONE) {
		model.setORDINE_PRESENTAZIONE(ORDINE_PRESENTAZIONE);
	}

	/**
	 * Sets the primary key of this componenti invio.
	 *
	 * @param primaryKey the primary key of this componenti invio
	 */
	@Override
	public void setPrimaryKey(
		it.eng.parer.service.persistence.ComponentiInvioPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tipo_componente of this componenti invio.
	 *
	 * @param TIPO_COMPONENTE the tipo_componente of this componenti invio
	 */
	@Override
	public void setTIPO_COMPONENTE(String TIPO_COMPONENTE) {
		model.setTIPO_COMPONENTE(TIPO_COMPONENTE);
	}

	/**
	 * Sets the tipo_supporto_componente of this componenti invio.
	 *
	 * @param TIPO_SUPPORTO_COMPONENTE the tipo_supporto_componente of this componenti invio
	 */
	@Override
	public void setTIPO_SUPPORTO_COMPONENTE(String TIPO_SUPPORTO_COMPONENTE) {
		model.setTIPO_SUPPORTO_COMPONENTE(TIPO_SUPPORTO_COMPONENTE);
	}

	/**
	 * Sets the urn_versato of this componenti invio.
	 *
	 * @param URN_VERSATO the urn_versato of this componenti invio
	 */
	@Override
	public void setURN_VERSATO(String URN_VERSATO) {
		model.setURN_VERSATO(URN_VERSATO);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ComponentiInvioWrapper wrap(ComponentiInvio componentiInvio) {
		return new ComponentiInvioWrapper(componentiInvio);
	}

}