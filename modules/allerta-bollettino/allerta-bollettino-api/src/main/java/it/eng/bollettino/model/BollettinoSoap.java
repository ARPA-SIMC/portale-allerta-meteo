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

package it.eng.bollettino.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.bollettino.service.http.BollettinoServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class BollettinoSoap implements Serializable {

	public static BollettinoSoap toSoapModel(Bollettino model) {
		BollettinoSoap soapModel = new BollettinoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBollettinoId(model.getBollettinoId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStato(model.getStato());
		soapModel.setIdApprovatore(model.getIdApprovatore());
		soapModel.setDataApprovazione(model.getDataApprovazione());
		soapModel.setNumero(model.getNumero());
		soapModel.setProgressivo(model.getProgressivo());
		soapModel.setAnno(model.getAnno());
		soapModel.setDataEmissione(model.getDataEmissione());
		soapModel.setDataInizio(model.getDataInizio());
		soapModel.setDataFine(model.getDataFine());
		soapModel.setNoteMeteo(model.getNoteMeteo());
		soapModel.setStringaMeteo(model.getStringaMeteo());
		soapModel.setLink(model.getLink());
		soapModel.setUltimo(model.isUltimo());
		soapModel.setHash(model.getHash());

		return soapModel;
	}

	public static BollettinoSoap[] toSoapModels(Bollettino[] models) {
		BollettinoSoap[] soapModels = new BollettinoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BollettinoSoap[][] toSoapModels(Bollettino[][] models) {
		BollettinoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BollettinoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BollettinoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BollettinoSoap[] toSoapModels(List<Bollettino> models) {
		List<BollettinoSoap> soapModels = new ArrayList<BollettinoSoap>(
			models.size());

		for (Bollettino model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BollettinoSoap[soapModels.size()]);
	}

	public BollettinoSoap() {
	}

	public long getPrimaryKey() {
		return _bollettinoId;
	}

	public void setPrimaryKey(long pk) {
		setBollettinoId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBollettinoId() {
		return _bollettinoId;
	}

	public void setBollettinoId(long bollettinoId) {
		_bollettinoId = bollettinoId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStato() {
		return _stato;
	}

	public void setStato(int stato) {
		_stato = stato;
	}

	public long getIdApprovatore() {
		return _idApprovatore;
	}

	public void setIdApprovatore(long idApprovatore) {
		_idApprovatore = idApprovatore;
	}

	public Date getDataApprovazione() {
		return _dataApprovazione;
	}

	public void setDataApprovazione(Date dataApprovazione) {
		_dataApprovazione = dataApprovazione;
	}

	public String getNumero() {
		return _numero;
	}

	public void setNumero(String numero) {
		_numero = numero;
	}

	public int getProgressivo() {
		return _progressivo;
	}

	public void setProgressivo(int progressivo) {
		_progressivo = progressivo;
	}

	public int getAnno() {
		return _anno;
	}

	public void setAnno(int anno) {
		_anno = anno;
	}

	public Date getDataEmissione() {
		return _dataEmissione;
	}

	public void setDataEmissione(Date dataEmissione) {
		_dataEmissione = dataEmissione;
	}

	public Date getDataInizio() {
		return _dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		_dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return _dataFine;
	}

	public void setDataFine(Date dataFine) {
		_dataFine = dataFine;
	}

	public String getNoteMeteo() {
		return _noteMeteo;
	}

	public void setNoteMeteo(String noteMeteo) {
		_noteMeteo = noteMeteo;
	}

	public String getStringaMeteo() {
		return _stringaMeteo;
	}

	public void setStringaMeteo(String stringaMeteo) {
		_stringaMeteo = stringaMeteo;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public boolean getUltimo() {
		return _ultimo;
	}

	public boolean isUltimo() {
		return _ultimo;
	}

	public void setUltimo(boolean ultimo) {
		_ultimo = ultimo;
	}

	public String getHash() {
		return _hash;
	}

	public void setHash(String hash) {
		_hash = hash;
	}

	private String _uuid;
	private long _bollettinoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _stato;
	private long _idApprovatore;
	private Date _dataApprovazione;
	private String _numero;
	private int _progressivo;
	private int _anno;
	private Date _dataEmissione;
	private Date _dataInizio;
	private Date _dataFine;
	private String _noteMeteo;
	private String _stringaMeteo;
	private String _link;
	private boolean _ultimo;
	private String _hash;

}