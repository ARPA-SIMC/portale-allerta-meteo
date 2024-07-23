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

package it.eng.allerter.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.allerter.service.http.AllertaValangheServiceSoap}.
 *
 * @author GFAVINI
 * @generated
 */
@ProviderType
public class AllertaValangheSoap implements Serializable {

	public static AllertaValangheSoap toSoapModel(AllertaValanghe model) {
		AllertaValangheSoap soapModel = new AllertaValangheSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAllertaValangheId(model.getAllertaValangheId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreatorName(model.getCreatorName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDataEmissione(model.getDataEmissione());
		soapModel.setDataInizio(model.getDataInizio());
		soapModel.setDataFine(model.getDataFine());
		soapModel.setNumero(model.getNumero());
		soapModel.setProgressivo(model.getProgressivo());
		soapModel.setAnno(model.getAnno());
		soapModel.setTitolo(model.getTitolo());
		soapModel.setDescrizioneFenomeni(model.getDescrizioneFenomeni());
		soapModel.setNote(model.getNote());
		soapModel.setRiferimenti(model.getRiferimenti());
		soapModel.setSintesi(model.getSintesi());
		soapModel.setUtenteFirmaArpaId(model.getUtenteFirmaArpaId());
		soapModel.setDataFirmaArpa(model.getDataFirmaArpa());
		soapModel.setUtenteFirmaProtId(model.getUtenteFirmaProtId());
		soapModel.setDataFirmaProt(model.getDataFirmaProt());
		soapModel.setParentId(model.getParentId());
		soapModel.setLink(model.getLink());
		soapModel.setStato(model.getStato());
		soapModel.setTipoAllerta(model.isTipoAllerta());
		soapModel.setHash(model.getHash());

		return soapModel;
	}

	public static AllertaValangheSoap[] toSoapModels(AllertaValanghe[] models) {
		AllertaValangheSoap[] soapModels =
			new AllertaValangheSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AllertaValangheSoap[][] toSoapModels(
		AllertaValanghe[][] models) {

		AllertaValangheSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AllertaValangheSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AllertaValangheSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AllertaValangheSoap[] toSoapModels(
		List<AllertaValanghe> models) {

		List<AllertaValangheSoap> soapModels =
			new ArrayList<AllertaValangheSoap>(models.size());

		for (AllertaValanghe model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AllertaValangheSoap[soapModels.size()]);
	}

	public AllertaValangheSoap() {
	}

	public long getPrimaryKey() {
		return _allertaValangheId;
	}

	public void setPrimaryKey(long pk) {
		setAllertaValangheId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAllertaValangheId() {
		return _allertaValangheId;
	}

	public void setAllertaValangheId(long allertaValangheId) {
		_allertaValangheId = allertaValangheId;
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

	public String getCreatorName() {
		return _creatorName;
	}

	public void setCreatorName(String creatorName) {
		_creatorName = creatorName;
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

	public String getTitolo() {
		return _titolo;
	}

	public void setTitolo(String titolo) {
		_titolo = titolo;
	}

	public String getDescrizioneFenomeni() {
		return _descrizioneFenomeni;
	}

	public void setDescrizioneFenomeni(String descrizioneFenomeni) {
		_descrizioneFenomeni = descrizioneFenomeni;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public String getRiferimenti() {
		return _riferimenti;
	}

	public void setRiferimenti(String riferimenti) {
		_riferimenti = riferimenti;
	}

	public String getSintesi() {
		return _sintesi;
	}

	public void setSintesi(String sintesi) {
		_sintesi = sintesi;
	}

	public long getUtenteFirmaArpaId() {
		return _utenteFirmaArpaId;
	}

	public void setUtenteFirmaArpaId(long utenteFirmaArpaId) {
		_utenteFirmaArpaId = utenteFirmaArpaId;
	}

	public Date getDataFirmaArpa() {
		return _dataFirmaArpa;
	}

	public void setDataFirmaArpa(Date dataFirmaArpa) {
		_dataFirmaArpa = dataFirmaArpa;
	}

	public long getUtenteFirmaProtId() {
		return _utenteFirmaProtId;
	}

	public void setUtenteFirmaProtId(long utenteFirmaProtId) {
		_utenteFirmaProtId = utenteFirmaProtId;
	}

	public Date getDataFirmaProt() {
		return _dataFirmaProt;
	}

	public void setDataFirmaProt(Date dataFirmaProt) {
		_dataFirmaProt = dataFirmaProt;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public int getStato() {
		return _stato;
	}

	public void setStato(int stato) {
		_stato = stato;
	}

	public boolean getTipoAllerta() {
		return _tipoAllerta;
	}

	public boolean isTipoAllerta() {
		return _tipoAllerta;
	}

	public void setTipoAllerta(boolean tipoAllerta) {
		_tipoAllerta = tipoAllerta;
	}

	public String getHash() {
		return _hash;
	}

	public void setHash(String hash) {
		_hash = hash;
	}

	private String _uuid;
	private long _allertaValangheId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private String _creatorName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _dataEmissione;
	private Date _dataInizio;
	private Date _dataFine;
	private String _numero;
	private int _progressivo;
	private int _anno;
	private String _titolo;
	private String _descrizioneFenomeni;
	private String _note;
	private String _riferimenti;
	private String _sintesi;
	private long _utenteFirmaArpaId;
	private Date _dataFirmaArpa;
	private long _utenteFirmaProtId;
	private Date _dataFirmaProt;
	private long _parentId;
	private String _link;
	private int _stato;
	private boolean _tipoAllerta;
	private String _hash;

}