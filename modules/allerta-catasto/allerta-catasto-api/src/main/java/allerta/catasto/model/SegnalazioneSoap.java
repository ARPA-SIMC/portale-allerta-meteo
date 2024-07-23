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

package allerta.catasto.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link allerta.catasto.service.http.SegnalazioneServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SegnalazioneSoap implements Serializable {

	public static SegnalazioneSoap toSoapModel(Segnalazione model) {
		SegnalazioneSoap soapModel = new SegnalazioneSoap();

		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDocumentoAssociato(model.getDocumentoAssociato());
		soapModel.setDataEvento(model.getDataEvento());
		soapModel.setEnteSegnalante(model.getEnteSegnalante());
		soapModel.setFonte(model.getFonte());
		soapModel.setCategoria(model.getCategoria());
		soapModel.setSottocategoria(model.getSottocategoria());
		soapModel.setRiferimento(model.getRiferimento());
		soapModel.setDescrizione(model.getDescrizione());
		soapModel.setNote(model.getNote());
		soapModel.setArea(model.getArea());
		soapModel.setProvincia(model.getProvincia());
		soapModel.setComune(model.getComune());
		soapModel.setIndirizzo(model.getIndirizzo());
		soapModel.setCivico(model.getCivico());
		soapModel.setLat(model.getLat());
		soapModel.setLon(model.getLon());
		soapModel.setEffetti(model.getEffetti());
		soapModel.setEffettiSub(model.getEffettiSub());

		return soapModel;
	}

	public static SegnalazioneSoap[] toSoapModels(Segnalazione[] models) {
		SegnalazioneSoap[] soapModels = new SegnalazioneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SegnalazioneSoap[][] toSoapModels(Segnalazione[][] models) {
		SegnalazioneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SegnalazioneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SegnalazioneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SegnalazioneSoap[] toSoapModels(List<Segnalazione> models) {
		List<SegnalazioneSoap> soapModels = new ArrayList<SegnalazioneSoap>(
			models.size());

		for (Segnalazione model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SegnalazioneSoap[soapModels.size()]);
	}

	public SegnalazioneSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
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

	public long getDocumentoAssociato() {
		return _documentoAssociato;
	}

	public void setDocumentoAssociato(long documentoAssociato) {
		_documentoAssociato = documentoAssociato;
	}

	public Date getDataEvento() {
		return _dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		_dataEvento = dataEvento;
	}

	public String getEnteSegnalante() {
		return _enteSegnalante;
	}

	public void setEnteSegnalante(String enteSegnalante) {
		_enteSegnalante = enteSegnalante;
	}

	public long getFonte() {
		return _fonte;
	}

	public void setFonte(long fonte) {
		_fonte = fonte;
	}

	public long getCategoria() {
		return _categoria;
	}

	public void setCategoria(long categoria) {
		_categoria = categoria;
	}

	public long getSottocategoria() {
		return _sottocategoria;
	}

	public void setSottocategoria(long sottocategoria) {
		_sottocategoria = sottocategoria;
	}

	public String getRiferimento() {
		return _riferimento;
	}

	public void setRiferimento(String riferimento) {
		_riferimento = riferimento;
	}

	public String getDescrizione() {
		return _descrizione;
	}

	public void setDescrizione(String descrizione) {
		_descrizione = descrizione;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public String getArea() {
		return _area;
	}

	public void setArea(String area) {
		_area = area;
	}

	public String getProvincia() {
		return _provincia;
	}

	public void setProvincia(String provincia) {
		_provincia = provincia;
	}

	public String getComune() {
		return _comune;
	}

	public void setComune(String comune) {
		_comune = comune;
	}

	public String getIndirizzo() {
		return _indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		_indirizzo = indirizzo;
	}

	public String getCivico() {
		return _civico;
	}

	public void setCivico(String civico) {
		_civico = civico;
	}

	public double getLat() {
		return _lat;
	}

	public void setLat(double lat) {
		_lat = lat;
	}

	public double getLon() {
		return _lon;
	}

	public void setLon(double lon) {
		_lon = lon;
	}

	public long getEffetti() {
		return _effetti;
	}

	public void setEffetti(long effetti) {
		_effetti = effetti;
	}

	public long getEffettiSub() {
		return _effettiSub;
	}

	public void setEffettiSub(long effettiSub) {
		_effettiSub = effettiSub;
	}

	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _documentoAssociato;
	private Date _dataEvento;
	private String _enteSegnalante;
	private long _fonte;
	private long _categoria;
	private long _sottocategoria;
	private String _riferimento;
	private String _descrizione;
	private String _note;
	private String _area;
	private String _provincia;
	private String _comune;
	private String _indirizzo;
	private String _civico;
	private double _lat;
	private double _lon;
	private long _effetti;
	private long _effettiSub;

}