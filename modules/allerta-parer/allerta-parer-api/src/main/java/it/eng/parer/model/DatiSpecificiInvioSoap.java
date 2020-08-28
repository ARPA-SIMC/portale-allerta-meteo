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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.eng.parer.service.http.DatiSpecificiInvioServiceSoap}.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class DatiSpecificiInvioSoap implements Serializable {

	public static DatiSpecificiInvioSoap toSoapModel(DatiSpecificiInvio model) {
		DatiSpecificiInvioSoap soapModel = new DatiSpecificiInvioSoap();

		soapModel.setID_INVIO(model.getID_INVIO());
		soapModel.setAMBIENTE(model.getAMBIENTE());
		soapModel.setVERSIONE(model.getVERSIONE());
		soapModel.setVERSATORE_ENTE(model.getVERSATORE_ENTE());
		soapModel.setVERSATORE_USER_ID(model.getVERSATORE_USER_ID());
		soapModel.setVERSATORE_STRUTTURA(model.getVERSATORE_STRUTTURA());
		soapModel.setCHIAVE_NUMERO(model.getCHIAVE_NUMERO());
		soapModel.setCHIAVE_ANNO(model.getCHIAVE_ANNO());
		soapModel.setCHIAVE_TIPO_REGISTRO(model.getCHIAVE_TIPO_REGISTRO());
		soapModel.setTIPOLOGIA_UNITA_DOCUMENTARIA(
			model.getTIPOLOGIA_UNITA_DOCUMENTARIA());
		soapModel.setTIPO_CONSERVAZIONE(model.getTIPO_CONSERVAZIONE());
		soapModel.setFORZA_ACCETTAZIONE(model.getFORZA_ACCETTAZIONE());
		soapModel.setFORZA_CONSERVAZIONE(model.getFORZA_CONSERVAZIONE());
		soapModel.setFORZA_COLLEGAMENTO(model.getFORZA_COLLEGAMENTO());
		soapModel.setOGGETTO_UNITA_DOCUMENTARIA(
			model.getOGGETTO_UNITA_DOCUMENTARIA());
		soapModel.setDATA_UNITA_DOCUMENTARIA(
			model.getDATA_UNITA_DOCUMENTARIA());
		soapModel.setVERSIONE_DATI_SPECIFICI(
			model.getVERSIONE_DATI_SPECIFICI());
		soapModel.setIDENTIFICATIVO_DATO_SPECIFICO(
			model.getIDENTIFICATIVO_DATO_SPECIFICO());
		soapModel.setDATA_GENERAZIONE(model.getDATA_GENERAZIONE());
		soapModel.setNUM_SMS_GENERATI(model.getNUM_SMS_GENERATI());
		soapModel.setNUM_SMS_INVIATI(model.getNUM_SMS_INVIATI());
		soapModel.setNUM_NOTIFICHE_RICEZIONE(
			model.getNUM_NOTIFICHE_RICEZIONE());
		soapModel.setDENOMINAZIONE_APPLICATIVO(
			model.getDENOMINAZIONE_APPLICATIVO());
		soapModel.setOGGETTO_MAIL(model.getOGGETTO_MAIL());
		soapModel.setTESTO_MAIL(model.getTESTO_MAIL());
		soapModel.setCOMPILATORE_ARPAE(model.getCOMPILATORE_ARPAE());
		soapModel.setCOMPILATORE_PROTEZIONE_CIVILE(
			model.getCOMPILATORE_PROTEZIONE_CIVILE());
		soapModel.setDATA_INIZIO_VALIDITA(model.getDATA_INIZIO_VALIDITA());
		soapModel.setDATA_FINE_VALIDITA(model.getDATA_FINE_VALIDITA());
		soapModel.setAPPROVATORE_ARPAE(model.getAPPROVATORE_ARPAE());
		soapModel.setDATA_FIRMA_ARPAE(model.getDATA_FIRMA_ARPAE());
		soapModel.setAPPROVATORE_PROTEZIONE_CIVILE(
			model.getAPPROVATORE_PROTEZIONE_CIVILE());
		soapModel.setDATA_FIRMA_PROTEZIONE_CIVILE(
			model.getDATA_FIRMA_PROTEZIONE_CIVILE());
		soapModel.setINVIO_RESPONSABILE_TERRITORIO(
			model.getINVIO_RESPONSABILE_TERRITORIO());
		soapModel.setID_DOCUMENTO_PRINCIPALE(
			model.getID_DOCUMENTO_PRINCIPALE());
		soapModel.setTIPO_DOCUMENTO(model.getTIPO_DOCUMENTO());
		soapModel.setTIPO_STRUTTURA(model.getTIPO_STRUTTURA());
		soapModel.setDENOMINAZIONE_SENSORE_RILEVAMENTO(
			model.getDENOMINAZIONE_SENSORE_RILEVAMENTO());
		soapModel.setREGOLA_ALLARME_ID(model.getREGOLA_ALLARME_ID());
		soapModel.setREGOLA_ALLARME_NOME(model.getREGOLA_ALLARME_NOME());
		soapModel.setREGOLA_ALLARME_DESCRIZIONE(
			model.getREGOLA_ALLARME_DESCRIZIONE());
		soapModel.setESITO_INVIO(model.getESITO_INVIO());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setData_invio(model.getData_invio());
		soapModel.setData_risposta(model.getData_risposta());
		soapModel.setCODICE_ESITO(model.getCODICE_ESITO());
		soapModel.setCODICE_ERRORE(model.getCODICE_ERRORE());
		soapModel.setMESG_ERRORE(model.getMESG_ERRORE());
		soapModel.setCODICE_TIPO_INVIO(model.getCODICE_TIPO_INVIO());

		return soapModel;
	}

	public static DatiSpecificiInvioSoap[] toSoapModels(
		DatiSpecificiInvio[] models) {

		DatiSpecificiInvioSoap[] soapModels =
			new DatiSpecificiInvioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DatiSpecificiInvioSoap[][] toSoapModels(
		DatiSpecificiInvio[][] models) {

		DatiSpecificiInvioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new DatiSpecificiInvioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DatiSpecificiInvioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DatiSpecificiInvioSoap[] toSoapModels(
		List<DatiSpecificiInvio> models) {

		List<DatiSpecificiInvioSoap> soapModels =
			new ArrayList<DatiSpecificiInvioSoap>(models.size());

		for (DatiSpecificiInvio model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new DatiSpecificiInvioSoap[soapModels.size()]);
	}

	public DatiSpecificiInvioSoap() {
	}

	public long getPrimaryKey() {
		return _ID_INVIO;
	}

	public void setPrimaryKey(long pk) {
		setID_INVIO(pk);
	}

	public long getID_INVIO() {
		return _ID_INVIO;
	}

	public void setID_INVIO(long ID_INVIO) {
		_ID_INVIO = ID_INVIO;
	}

	public String getAMBIENTE() {
		return _AMBIENTE;
	}

	public void setAMBIENTE(String AMBIENTE) {
		_AMBIENTE = AMBIENTE;
	}

	public double getVERSIONE() {
		return _VERSIONE;
	}

	public void setVERSIONE(double VERSIONE) {
		_VERSIONE = VERSIONE;
	}

	public String getVERSATORE_ENTE() {
		return _VERSATORE_ENTE;
	}

	public void setVERSATORE_ENTE(String VERSATORE_ENTE) {
		_VERSATORE_ENTE = VERSATORE_ENTE;
	}

	public String getVERSATORE_USER_ID() {
		return _VERSATORE_USER_ID;
	}

	public void setVERSATORE_USER_ID(String VERSATORE_USER_ID) {
		_VERSATORE_USER_ID = VERSATORE_USER_ID;
	}

	public String getVERSATORE_STRUTTURA() {
		return _VERSATORE_STRUTTURA;
	}

	public void setVERSATORE_STRUTTURA(String VERSATORE_STRUTTURA) {
		_VERSATORE_STRUTTURA = VERSATORE_STRUTTURA;
	}

	public String getCHIAVE_NUMERO() {
		return _CHIAVE_NUMERO;
	}

	public void setCHIAVE_NUMERO(String CHIAVE_NUMERO) {
		_CHIAVE_NUMERO = CHIAVE_NUMERO;
	}

	public long getCHIAVE_ANNO() {
		return _CHIAVE_ANNO;
	}

	public void setCHIAVE_ANNO(long CHIAVE_ANNO) {
		_CHIAVE_ANNO = CHIAVE_ANNO;
	}

	public String getCHIAVE_TIPO_REGISTRO() {
		return _CHIAVE_TIPO_REGISTRO;
	}

	public void setCHIAVE_TIPO_REGISTRO(String CHIAVE_TIPO_REGISTRO) {
		_CHIAVE_TIPO_REGISTRO = CHIAVE_TIPO_REGISTRO;
	}

	public String getTIPOLOGIA_UNITA_DOCUMENTARIA() {
		return _TIPOLOGIA_UNITA_DOCUMENTARIA;
	}

	public void setTIPOLOGIA_UNITA_DOCUMENTARIA(
		String TIPOLOGIA_UNITA_DOCUMENTARIA) {

		_TIPOLOGIA_UNITA_DOCUMENTARIA = TIPOLOGIA_UNITA_DOCUMENTARIA;
	}

	public String getTIPO_CONSERVAZIONE() {
		return _TIPO_CONSERVAZIONE;
	}

	public void setTIPO_CONSERVAZIONE(String TIPO_CONSERVAZIONE) {
		_TIPO_CONSERVAZIONE = TIPO_CONSERVAZIONE;
	}

	public String getFORZA_ACCETTAZIONE() {
		return _FORZA_ACCETTAZIONE;
	}

	public void setFORZA_ACCETTAZIONE(String FORZA_ACCETTAZIONE) {
		_FORZA_ACCETTAZIONE = FORZA_ACCETTAZIONE;
	}

	public String getFORZA_CONSERVAZIONE() {
		return _FORZA_CONSERVAZIONE;
	}

	public void setFORZA_CONSERVAZIONE(String FORZA_CONSERVAZIONE) {
		_FORZA_CONSERVAZIONE = FORZA_CONSERVAZIONE;
	}

	public String getFORZA_COLLEGAMENTO() {
		return _FORZA_COLLEGAMENTO;
	}

	public void setFORZA_COLLEGAMENTO(String FORZA_COLLEGAMENTO) {
		_FORZA_COLLEGAMENTO = FORZA_COLLEGAMENTO;
	}

	public String getOGGETTO_UNITA_DOCUMENTARIA() {
		return _OGGETTO_UNITA_DOCUMENTARIA;
	}

	public void setOGGETTO_UNITA_DOCUMENTARIA(
		String OGGETTO_UNITA_DOCUMENTARIA) {

		_OGGETTO_UNITA_DOCUMENTARIA = OGGETTO_UNITA_DOCUMENTARIA;
	}

	public Date getDATA_UNITA_DOCUMENTARIA() {
		return _DATA_UNITA_DOCUMENTARIA;
	}

	public void setDATA_UNITA_DOCUMENTARIA(Date DATA_UNITA_DOCUMENTARIA) {
		_DATA_UNITA_DOCUMENTARIA = DATA_UNITA_DOCUMENTARIA;
	}

	public double getVERSIONE_DATI_SPECIFICI() {
		return _VERSIONE_DATI_SPECIFICI;
	}

	public void setVERSIONE_DATI_SPECIFICI(double VERSIONE_DATI_SPECIFICI) {
		_VERSIONE_DATI_SPECIFICI = VERSIONE_DATI_SPECIFICI;
	}

	public String getIDENTIFICATIVO_DATO_SPECIFICO() {
		return _IDENTIFICATIVO_DATO_SPECIFICO;
	}

	public void setIDENTIFICATIVO_DATO_SPECIFICO(
		String IDENTIFICATIVO_DATO_SPECIFICO) {

		_IDENTIFICATIVO_DATO_SPECIFICO = IDENTIFICATIVO_DATO_SPECIFICO;
	}

	public Date getDATA_GENERAZIONE() {
		return _DATA_GENERAZIONE;
	}

	public void setDATA_GENERAZIONE(Date DATA_GENERAZIONE) {
		_DATA_GENERAZIONE = DATA_GENERAZIONE;
	}

	public int getNUM_SMS_GENERATI() {
		return _NUM_SMS_GENERATI;
	}

	public void setNUM_SMS_GENERATI(int NUM_SMS_GENERATI) {
		_NUM_SMS_GENERATI = NUM_SMS_GENERATI;
	}

	public int getNUM_SMS_INVIATI() {
		return _NUM_SMS_INVIATI;
	}

	public void setNUM_SMS_INVIATI(int NUM_SMS_INVIATI) {
		_NUM_SMS_INVIATI = NUM_SMS_INVIATI;
	}

	public int getNUM_NOTIFICHE_RICEZIONE() {
		return _NUM_NOTIFICHE_RICEZIONE;
	}

	public void setNUM_NOTIFICHE_RICEZIONE(int NUM_NOTIFICHE_RICEZIONE) {
		_NUM_NOTIFICHE_RICEZIONE = NUM_NOTIFICHE_RICEZIONE;
	}

	public String getDENOMINAZIONE_APPLICATIVO() {
		return _DENOMINAZIONE_APPLICATIVO;
	}

	public void setDENOMINAZIONE_APPLICATIVO(String DENOMINAZIONE_APPLICATIVO) {
		_DENOMINAZIONE_APPLICATIVO = DENOMINAZIONE_APPLICATIVO;
	}

	public String getOGGETTO_MAIL() {
		return _OGGETTO_MAIL;
	}

	public void setOGGETTO_MAIL(String OGGETTO_MAIL) {
		_OGGETTO_MAIL = OGGETTO_MAIL;
	}

	public String getTESTO_MAIL() {
		return _TESTO_MAIL;
	}

	public void setTESTO_MAIL(String TESTO_MAIL) {
		_TESTO_MAIL = TESTO_MAIL;
	}

	public String getCOMPILATORE_ARPAE() {
		return _COMPILATORE_ARPAE;
	}

	public void setCOMPILATORE_ARPAE(String COMPILATORE_ARPAE) {
		_COMPILATORE_ARPAE = COMPILATORE_ARPAE;
	}

	public String getCOMPILATORE_PROTEZIONE_CIVILE() {
		return _COMPILATORE_PROTEZIONE_CIVILE;
	}

	public void setCOMPILATORE_PROTEZIONE_CIVILE(
		String COMPILATORE_PROTEZIONE_CIVILE) {

		_COMPILATORE_PROTEZIONE_CIVILE = COMPILATORE_PROTEZIONE_CIVILE;
	}

	public Date getDATA_INIZIO_VALIDITA() {
		return _DATA_INIZIO_VALIDITA;
	}

	public void setDATA_INIZIO_VALIDITA(Date DATA_INIZIO_VALIDITA) {
		_DATA_INIZIO_VALIDITA = DATA_INIZIO_VALIDITA;
	}

	public Date getDATA_FINE_VALIDITA() {
		return _DATA_FINE_VALIDITA;
	}

	public void setDATA_FINE_VALIDITA(Date DATA_FINE_VALIDITA) {
		_DATA_FINE_VALIDITA = DATA_FINE_VALIDITA;
	}

	public String getAPPROVATORE_ARPAE() {
		return _APPROVATORE_ARPAE;
	}

	public void setAPPROVATORE_ARPAE(String APPROVATORE_ARPAE) {
		_APPROVATORE_ARPAE = APPROVATORE_ARPAE;
	}

	public Date getDATA_FIRMA_ARPAE() {
		return _DATA_FIRMA_ARPAE;
	}

	public void setDATA_FIRMA_ARPAE(Date DATA_FIRMA_ARPAE) {
		_DATA_FIRMA_ARPAE = DATA_FIRMA_ARPAE;
	}

	public String getAPPROVATORE_PROTEZIONE_CIVILE() {
		return _APPROVATORE_PROTEZIONE_CIVILE;
	}

	public void setAPPROVATORE_PROTEZIONE_CIVILE(
		String APPROVATORE_PROTEZIONE_CIVILE) {

		_APPROVATORE_PROTEZIONE_CIVILE = APPROVATORE_PROTEZIONE_CIVILE;
	}

	public Date getDATA_FIRMA_PROTEZIONE_CIVILE() {
		return _DATA_FIRMA_PROTEZIONE_CIVILE;
	}

	public void setDATA_FIRMA_PROTEZIONE_CIVILE(
		Date DATA_FIRMA_PROTEZIONE_CIVILE) {

		_DATA_FIRMA_PROTEZIONE_CIVILE = DATA_FIRMA_PROTEZIONE_CIVILE;
	}

	public String getINVIO_RESPONSABILE_TERRITORIO() {
		return _INVIO_RESPONSABILE_TERRITORIO;
	}

	public void setINVIO_RESPONSABILE_TERRITORIO(
		String INVIO_RESPONSABILE_TERRITORIO) {

		_INVIO_RESPONSABILE_TERRITORIO = INVIO_RESPONSABILE_TERRITORIO;
	}

	public long getID_DOCUMENTO_PRINCIPALE() {
		return _ID_DOCUMENTO_PRINCIPALE;
	}

	public void setID_DOCUMENTO_PRINCIPALE(long ID_DOCUMENTO_PRINCIPALE) {
		_ID_DOCUMENTO_PRINCIPALE = ID_DOCUMENTO_PRINCIPALE;
	}

	public String getTIPO_DOCUMENTO() {
		return _TIPO_DOCUMENTO;
	}

	public void setTIPO_DOCUMENTO(String TIPO_DOCUMENTO) {
		_TIPO_DOCUMENTO = TIPO_DOCUMENTO;
	}

	public String getTIPO_STRUTTURA() {
		return _TIPO_STRUTTURA;
	}

	public void setTIPO_STRUTTURA(String TIPO_STRUTTURA) {
		_TIPO_STRUTTURA = TIPO_STRUTTURA;
	}

	public String getDENOMINAZIONE_SENSORE_RILEVAMENTO() {
		return _DENOMINAZIONE_SENSORE_RILEVAMENTO;
	}

	public void setDENOMINAZIONE_SENSORE_RILEVAMENTO(
		String DENOMINAZIONE_SENSORE_RILEVAMENTO) {

		_DENOMINAZIONE_SENSORE_RILEVAMENTO = DENOMINAZIONE_SENSORE_RILEVAMENTO;
	}

	public String getREGOLA_ALLARME_ID() {
		return _REGOLA_ALLARME_ID;
	}

	public void setREGOLA_ALLARME_ID(String REGOLA_ALLARME_ID) {
		_REGOLA_ALLARME_ID = REGOLA_ALLARME_ID;
	}

	public String getREGOLA_ALLARME_NOME() {
		return _REGOLA_ALLARME_NOME;
	}

	public void setREGOLA_ALLARME_NOME(String REGOLA_ALLARME_NOME) {
		_REGOLA_ALLARME_NOME = REGOLA_ALLARME_NOME;
	}

	public String getREGOLA_ALLARME_DESCRIZIONE() {
		return _REGOLA_ALLARME_DESCRIZIONE;
	}

	public void setREGOLA_ALLARME_DESCRIZIONE(
		String REGOLA_ALLARME_DESCRIZIONE) {

		_REGOLA_ALLARME_DESCRIZIONE = REGOLA_ALLARME_DESCRIZIONE;
	}

	public String getESITO_INVIO() {
		return _ESITO_INVIO;
	}

	public void setESITO_INVIO(String ESITO_INVIO) {
		_ESITO_INVIO = ESITO_INVIO;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public Date getData_invio() {
		return _data_invio;
	}

	public void setData_invio(Date data_invio) {
		_data_invio = data_invio;
	}

	public Date getData_risposta() {
		return _data_risposta;
	}

	public void setData_risposta(Date data_risposta) {
		_data_risposta = data_risposta;
	}

	public String getCODICE_ESITO() {
		return _CODICE_ESITO;
	}

	public void setCODICE_ESITO(String CODICE_ESITO) {
		_CODICE_ESITO = CODICE_ESITO;
	}

	public String getCODICE_ERRORE() {
		return _CODICE_ERRORE;
	}

	public void setCODICE_ERRORE(String CODICE_ERRORE) {
		_CODICE_ERRORE = CODICE_ERRORE;
	}

	public String getMESG_ERRORE() {
		return _MESG_ERRORE;
	}

	public void setMESG_ERRORE(String MESG_ERRORE) {
		_MESG_ERRORE = MESG_ERRORE;
	}

	public String getCODICE_TIPO_INVIO() {
		return _CODICE_TIPO_INVIO;
	}

	public void setCODICE_TIPO_INVIO(String CODICE_TIPO_INVIO) {
		_CODICE_TIPO_INVIO = CODICE_TIPO_INVIO;
	}

	private long _ID_INVIO;

	private String _AMBIENTE;

	private double _VERSIONE;

	private String _VERSATORE_ENTE;

	private String _VERSATORE_USER_ID;

	private String _VERSATORE_STRUTTURA;

	private String _CHIAVE_NUMERO;

	private long _CHIAVE_ANNO;

	private String _CHIAVE_TIPO_REGISTRO;

	private String _TIPOLOGIA_UNITA_DOCUMENTARIA;

	private String _TIPO_CONSERVAZIONE;

	private String _FORZA_ACCETTAZIONE;

	private String _FORZA_CONSERVAZIONE;

	private String _FORZA_COLLEGAMENTO;

	private String _OGGETTO_UNITA_DOCUMENTARIA;

	private Date _DATA_UNITA_DOCUMENTARIA;

	private double _VERSIONE_DATI_SPECIFICI;

	private String _IDENTIFICATIVO_DATO_SPECIFICO;

	private Date _DATA_GENERAZIONE;

	private int _NUM_SMS_GENERATI;

	private int _NUM_SMS_INVIATI;

	private int _NUM_NOTIFICHE_RICEZIONE;

	private String _DENOMINAZIONE_APPLICATIVO;

	private String _OGGETTO_MAIL;

	private String _TESTO_MAIL;

	private String _COMPILATORE_ARPAE;

	private String _COMPILATORE_PROTEZIONE_CIVILE;

	private Date _DATA_INIZIO_VALIDITA;

	private Date _DATA_FINE_VALIDITA;

	private String _APPROVATORE_ARPAE;

	private Date _DATA_FIRMA_ARPAE;

	private String _APPROVATORE_PROTEZIONE_CIVILE;

	private Date _DATA_FIRMA_PROTEZIONE_CIVILE;

	private String _INVIO_RESPONSABILE_TERRITORIO;

	private long _ID_DOCUMENTO_PRINCIPALE;

	private String _TIPO_DOCUMENTO;

	private String _TIPO_STRUTTURA;

	private String _DENOMINAZIONE_SENSORE_RILEVAMENTO;

	private String _REGOLA_ALLARME_ID;

	private String _REGOLA_ALLARME_NOME;

	private String _REGOLA_ALLARME_DESCRIZIONE;

	private String _ESITO_INVIO;

	private long _userId;
	private long _companyId;
	private long _groupId;
	private Date _data_invio;
	private Date _data_risposta;

	private String _CODICE_ESITO;

	private String _CODICE_ERRORE;

	private String _MESG_ERRORE;

	private String _CODICE_TIPO_INVIO;

}