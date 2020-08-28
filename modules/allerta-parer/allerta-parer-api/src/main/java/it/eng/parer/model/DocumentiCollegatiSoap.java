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

import it.eng.parer.service.persistence.DocumentiCollegatiPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.parer.service.http.DocumentiCollegatiServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class DocumentiCollegatiSoap implements Serializable {

	public static DocumentiCollegatiSoap toSoapModel(DocumentiCollegati model) {
		DocumentiCollegatiSoap soapModel = new DocumentiCollegatiSoap();

		soapModel.setDOC_COLLEGATO_NUMERO(model.getDOC_COLLEGATO_NUMERO());
		soapModel.setDOC_COLLEGATO_ANNO(model.getDOC_COLLEGATO_ANNO());
		soapModel.setDOC_COLLEGATO_TIPO_REGISTRO(
			model.getDOC_COLLEGATO_TIPO_REGISTRO());
		soapModel.setDESCRIZIONE_COLLEGAMENTO(
			model.getDESCRIZIONE_COLLEGAMENTO());
		soapModel.setID_INVIO(model.getID_INVIO());

		return soapModel;
	}

	public static DocumentiCollegatiSoap[] toSoapModels(
		DocumentiCollegati[] models) {

		DocumentiCollegatiSoap[] soapModels =
			new DocumentiCollegatiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DocumentiCollegatiSoap[][] toSoapModels(
		DocumentiCollegati[][] models) {

		DocumentiCollegatiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DocumentiCollegatiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DocumentiCollegatiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DocumentiCollegatiSoap[] toSoapModels(
		List<DocumentiCollegati> models) {

		List<DocumentiCollegatiSoap> soapModels =
			new ArrayList<DocumentiCollegatiSoap>(models.size());

		for (DocumentiCollegati model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DocumentiCollegatiSoap[soapModels.size()]);
	}

	public DocumentiCollegatiSoap() {
	}

	public DocumentiCollegatiPK getPrimaryKey() {
		return new DocumentiCollegatiPK(
			_DOC_COLLEGATO_NUMERO, _DOC_COLLEGATO_ANNO,
			_DOC_COLLEGATO_TIPO_REGISTRO, _ID_INVIO);
	}

	public void setPrimaryKey(DocumentiCollegatiPK pk) {
		setDOC_COLLEGATO_NUMERO(pk.DOC_COLLEGATO_NUMERO);
		setDOC_COLLEGATO_ANNO(pk.DOC_COLLEGATO_ANNO);
		setDOC_COLLEGATO_TIPO_REGISTRO(pk.DOC_COLLEGATO_TIPO_REGISTRO);
		setID_INVIO(pk.ID_INVIO);
	}

	public String getDOC_COLLEGATO_NUMERO() {
		return _DOC_COLLEGATO_NUMERO;
	}

	public void setDOC_COLLEGATO_NUMERO(String DOC_COLLEGATO_NUMERO) {
		_DOC_COLLEGATO_NUMERO = DOC_COLLEGATO_NUMERO;
	}

	public int getDOC_COLLEGATO_ANNO() {
		return _DOC_COLLEGATO_ANNO;
	}

	public void setDOC_COLLEGATO_ANNO(int DOC_COLLEGATO_ANNO) {
		_DOC_COLLEGATO_ANNO = DOC_COLLEGATO_ANNO;
	}

	public String getDOC_COLLEGATO_TIPO_REGISTRO() {
		return _DOC_COLLEGATO_TIPO_REGISTRO;
	}

	public void setDOC_COLLEGATO_TIPO_REGISTRO(
		String DOC_COLLEGATO_TIPO_REGISTRO) {

		_DOC_COLLEGATO_TIPO_REGISTRO = DOC_COLLEGATO_TIPO_REGISTRO;
	}

	public String getDESCRIZIONE_COLLEGAMENTO() {
		return _DESCRIZIONE_COLLEGAMENTO;
	}

	public void setDESCRIZIONE_COLLEGAMENTO(String DESCRIZIONE_COLLEGAMENTO) {
		_DESCRIZIONE_COLLEGAMENTO = DESCRIZIONE_COLLEGAMENTO;
	}

	public long getID_INVIO() {
		return _ID_INVIO;
	}

	public void setID_INVIO(long ID_INVIO) {
		_ID_INVIO = ID_INVIO;
	}

	private String _DOC_COLLEGATO_NUMERO;

	private int _DOC_COLLEGATO_ANNO;

	private String _DOC_COLLEGATO_TIPO_REGISTRO;

	private String _DESCRIZIONE_COLLEGAMENTO;

	private long _ID_INVIO;

}