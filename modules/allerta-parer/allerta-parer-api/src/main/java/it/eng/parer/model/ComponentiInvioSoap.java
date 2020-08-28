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

package it.eng.parer.model;

import aQute.bnd.annotation.ProviderType;

import it.eng.parer.service.persistence.ComponentiInvioPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.parer.service.http.ComponentiInvioServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class ComponentiInvioSoap implements Serializable {

	public static ComponentiInvioSoap toSoapModel(ComponentiInvio model) {
		ComponentiInvioSoap soapModel = new ComponentiInvioSoap();

		soapModel.setID_INVIO(model.getID_INVIO());
		soapModel.setID_COMPONENTE(model.getID_COMPONENTE());
		soapModel.setORDINE_PRESENTAZIONE(model.getORDINE_PRESENTAZIONE());
		soapModel.setTIPO_COMPONENTE(model.getTIPO_COMPONENTE());
		soapModel.setTIPO_SUPPORTO_COMPONENTE(
			model.getTIPO_SUPPORTO_COMPONENTE());
		soapModel.setNOME_COMPONENTE(model.getNOME_COMPONENTE());
		soapModel.setFORMATO_FILE_VERSATO(model.getFORMATO_FILE_VERSATO());
		soapModel.setHASH_VERSATO(model.getHASH_VERSATO());
		soapModel.setURN_VERSATO(model.getURN_VERSATO());
		soapModel.setID_COMPONENTE_VERSATO(model.getID_COMPONENTE_VERSATO());

		return soapModel;
	}

	public static ComponentiInvioSoap[] toSoapModels(ComponentiInvio[] models) {
		ComponentiInvioSoap[] soapModels =
			new ComponentiInvioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ComponentiInvioSoap[][] toSoapModels(
		ComponentiInvio[][] models) {

		ComponentiInvioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ComponentiInvioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ComponentiInvioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ComponentiInvioSoap[] toSoapModels(
		List<ComponentiInvio> models) {

		List<ComponentiInvioSoap> soapModels =
			new ArrayList<ComponentiInvioSoap>(models.size());

		for (ComponentiInvio model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ComponentiInvioSoap[soapModels.size()]);
	}

	public ComponentiInvioSoap() {
	}

	public ComponentiInvioPK getPrimaryKey() {
		return new ComponentiInvioPK(_ID_INVIO, _ID_COMPONENTE);
	}

	public void setPrimaryKey(ComponentiInvioPK pk) {
		setID_INVIO(pk.ID_INVIO);
		setID_COMPONENTE(pk.ID_COMPONENTE);
	}

	public long getID_INVIO() {
		return _ID_INVIO;
	}

	public void setID_INVIO(long ID_INVIO) {
		_ID_INVIO = ID_INVIO;
	}

	public long getID_COMPONENTE() {
		return _ID_COMPONENTE;
	}

	public void setID_COMPONENTE(long ID_COMPONENTE) {
		_ID_COMPONENTE = ID_COMPONENTE;
	}

	public long getORDINE_PRESENTAZIONE() {
		return _ORDINE_PRESENTAZIONE;
	}

	public void setORDINE_PRESENTAZIONE(long ORDINE_PRESENTAZIONE) {
		_ORDINE_PRESENTAZIONE = ORDINE_PRESENTAZIONE;
	}

	public String getTIPO_COMPONENTE() {
		return _TIPO_COMPONENTE;
	}

	public void setTIPO_COMPONENTE(String TIPO_COMPONENTE) {
		_TIPO_COMPONENTE = TIPO_COMPONENTE;
	}

	public String getTIPO_SUPPORTO_COMPONENTE() {
		return _TIPO_SUPPORTO_COMPONENTE;
	}

	public void setTIPO_SUPPORTO_COMPONENTE(String TIPO_SUPPORTO_COMPONENTE) {
		_TIPO_SUPPORTO_COMPONENTE = TIPO_SUPPORTO_COMPONENTE;
	}

	public String getNOME_COMPONENTE() {
		return _NOME_COMPONENTE;
	}

	public void setNOME_COMPONENTE(String NOME_COMPONENTE) {
		_NOME_COMPONENTE = NOME_COMPONENTE;
	}

	public String getFORMATO_FILE_VERSATO() {
		return _FORMATO_FILE_VERSATO;
	}

	public void setFORMATO_FILE_VERSATO(String FORMATO_FILE_VERSATO) {
		_FORMATO_FILE_VERSATO = FORMATO_FILE_VERSATO;
	}

	public String getHASH_VERSATO() {
		return _HASH_VERSATO;
	}

	public void setHASH_VERSATO(String HASH_VERSATO) {
		_HASH_VERSATO = HASH_VERSATO;
	}

	public String getURN_VERSATO() {
		return _URN_VERSATO;
	}

	public void setURN_VERSATO(String URN_VERSATO) {
		_URN_VERSATO = URN_VERSATO;
	}

	public long getID_COMPONENTE_VERSATO() {
		return _ID_COMPONENTE_VERSATO;
	}

	public void setID_COMPONENTE_VERSATO(long ID_COMPONENTE_VERSATO) {
		_ID_COMPONENTE_VERSATO = ID_COMPONENTE_VERSATO;
	}

	private long _ID_INVIO;

	private long _ID_COMPONENTE;

	private long _ORDINE_PRESENTAZIONE;

	private String _TIPO_COMPONENTE;

	private String _TIPO_SUPPORTO_COMPONENTE;

	private String _NOME_COMPONENTE;

	private String _FORMATO_FILE_VERSATO;

	private String _HASH_VERSATO;

	private String _URN_VERSATO;

	private long _ID_COMPONENTE_VERSATO;

}