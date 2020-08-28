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

package it.eng.parer.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.parer.model.DatiSpecificiInvio;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DatiSpecificiInvio in entity cache.
 *
 * @author Pratola_L
 * @generated
 */
@ProviderType
public class DatiSpecificiInvioCacheModel
	implements CacheModel<DatiSpecificiInvio>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DatiSpecificiInvioCacheModel)) {
			return false;
		}

		DatiSpecificiInvioCacheModel datiSpecificiInvioCacheModel =
			(DatiSpecificiInvioCacheModel)obj;

		if (ID_INVIO == datiSpecificiInvioCacheModel.ID_INVIO) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ID_INVIO);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(103);

		sb.append("{ID_INVIO=");
		sb.append(ID_INVIO);
		sb.append(", AMBIENTE=");
		sb.append(AMBIENTE);
		sb.append(", VERSIONE=");
		sb.append(VERSIONE);
		sb.append(", VERSATORE_ENTE=");
		sb.append(VERSATORE_ENTE);
		sb.append(", VERSATORE_USER_ID=");
		sb.append(VERSATORE_USER_ID);
		sb.append(", VERSATORE_STRUTTURA=");
		sb.append(VERSATORE_STRUTTURA);
		sb.append(", CHIAVE_NUMERO=");
		sb.append(CHIAVE_NUMERO);
		sb.append(", CHIAVE_ANNO=");
		sb.append(CHIAVE_ANNO);
		sb.append(", CHIAVE_TIPO_REGISTRO=");
		sb.append(CHIAVE_TIPO_REGISTRO);
		sb.append(", TIPOLOGIA_UNITA_DOCUMENTARIA=");
		sb.append(TIPOLOGIA_UNITA_DOCUMENTARIA);
		sb.append(", TIPO_CONSERVAZIONE=");
		sb.append(TIPO_CONSERVAZIONE);
		sb.append(", FORZA_ACCETTAZIONE=");
		sb.append(FORZA_ACCETTAZIONE);
		sb.append(", FORZA_CONSERVAZIONE=");
		sb.append(FORZA_CONSERVAZIONE);
		sb.append(", FORZA_COLLEGAMENTO=");
		sb.append(FORZA_COLLEGAMENTO);
		sb.append(", OGGETTO_UNITA_DOCUMENTARIA=");
		sb.append(OGGETTO_UNITA_DOCUMENTARIA);
		sb.append(", DATA_UNITA_DOCUMENTARIA=");
		sb.append(DATA_UNITA_DOCUMENTARIA);
		sb.append(", VERSIONE_DATI_SPECIFICI=");
		sb.append(VERSIONE_DATI_SPECIFICI);
		sb.append(", IDENTIFICATIVO_DATO_SPECIFICO=");
		sb.append(IDENTIFICATIVO_DATO_SPECIFICO);
		sb.append(", DATA_GENERAZIONE=");
		sb.append(DATA_GENERAZIONE);
		sb.append(", NUM_SMS_GENERATI=");
		sb.append(NUM_SMS_GENERATI);
		sb.append(", NUM_SMS_INVIATI=");
		sb.append(NUM_SMS_INVIATI);
		sb.append(", NUM_NOTIFICHE_RICEZIONE=");
		sb.append(NUM_NOTIFICHE_RICEZIONE);
		sb.append(", DENOMINAZIONE_APPLICATIVO=");
		sb.append(DENOMINAZIONE_APPLICATIVO);
		sb.append(", OGGETTO_MAIL=");
		sb.append(OGGETTO_MAIL);
		sb.append(", TESTO_MAIL=");
		sb.append(TESTO_MAIL);
		sb.append(", COMPILATORE_ARPAE=");
		sb.append(COMPILATORE_ARPAE);
		sb.append(", COMPILATORE_PROTEZIONE_CIVILE=");
		sb.append(COMPILATORE_PROTEZIONE_CIVILE);
		sb.append(", DATA_INIZIO_VALIDITA=");
		sb.append(DATA_INIZIO_VALIDITA);
		sb.append(", DATA_FINE_VALIDITA=");
		sb.append(DATA_FINE_VALIDITA);
		sb.append(", APPROVATORE_ARPAE=");
		sb.append(APPROVATORE_ARPAE);
		sb.append(", DATA_FIRMA_ARPAE=");
		sb.append(DATA_FIRMA_ARPAE);
		sb.append(", APPROVATORE_PROTEZIONE_CIVILE=");
		sb.append(APPROVATORE_PROTEZIONE_CIVILE);
		sb.append(", DATA_FIRMA_PROTEZIONE_CIVILE=");
		sb.append(DATA_FIRMA_PROTEZIONE_CIVILE);
		sb.append(", INVIO_RESPONSABILE_TERRITORIO=");
		sb.append(INVIO_RESPONSABILE_TERRITORIO);
		sb.append(", ID_DOCUMENTO_PRINCIPALE=");
		sb.append(ID_DOCUMENTO_PRINCIPALE);
		sb.append(", TIPO_DOCUMENTO=");
		sb.append(TIPO_DOCUMENTO);
		sb.append(", TIPO_STRUTTURA=");
		sb.append(TIPO_STRUTTURA);
		sb.append(", DENOMINAZIONE_SENSORE_RILEVAMENTO=");
		sb.append(DENOMINAZIONE_SENSORE_RILEVAMENTO);
		sb.append(", REGOLA_ALLARME_ID=");
		sb.append(REGOLA_ALLARME_ID);
		sb.append(", REGOLA_ALLARME_NOME=");
		sb.append(REGOLA_ALLARME_NOME);
		sb.append(", REGOLA_ALLARME_DESCRIZIONE=");
		sb.append(REGOLA_ALLARME_DESCRIZIONE);
		sb.append(", ESITO_INVIO=");
		sb.append(ESITO_INVIO);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", data_invio=");
		sb.append(data_invio);
		sb.append(", data_risposta=");
		sb.append(data_risposta);
		sb.append(", CODICE_ESITO=");
		sb.append(CODICE_ESITO);
		sb.append(", CODICE_ERRORE=");
		sb.append(CODICE_ERRORE);
		sb.append(", MESG_ERRORE=");
		sb.append(MESG_ERRORE);
		sb.append(", CODICE_TIPO_INVIO=");
		sb.append(CODICE_TIPO_INVIO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DatiSpecificiInvio toEntityModel() {
		DatiSpecificiInvioImpl datiSpecificiInvioImpl =
			new DatiSpecificiInvioImpl();

		datiSpecificiInvioImpl.setID_INVIO(ID_INVIO);

		if (AMBIENTE == null) {
			datiSpecificiInvioImpl.setAMBIENTE("");
		}
		else {
			datiSpecificiInvioImpl.setAMBIENTE(AMBIENTE);
		}

		datiSpecificiInvioImpl.setVERSIONE(VERSIONE);

		if (VERSATORE_ENTE == null) {
			datiSpecificiInvioImpl.setVERSATORE_ENTE("");
		}
		else {
			datiSpecificiInvioImpl.setVERSATORE_ENTE(VERSATORE_ENTE);
		}

		if (VERSATORE_USER_ID == null) {
			datiSpecificiInvioImpl.setVERSATORE_USER_ID("");
		}
		else {
			datiSpecificiInvioImpl.setVERSATORE_USER_ID(VERSATORE_USER_ID);
		}

		if (VERSATORE_STRUTTURA == null) {
			datiSpecificiInvioImpl.setVERSATORE_STRUTTURA("");
		}
		else {
			datiSpecificiInvioImpl.setVERSATORE_STRUTTURA(VERSATORE_STRUTTURA);
		}

		if (CHIAVE_NUMERO == null) {
			datiSpecificiInvioImpl.setCHIAVE_NUMERO("");
		}
		else {
			datiSpecificiInvioImpl.setCHIAVE_NUMERO(CHIAVE_NUMERO);
		}

		datiSpecificiInvioImpl.setCHIAVE_ANNO(CHIAVE_ANNO);

		if (CHIAVE_TIPO_REGISTRO == null) {
			datiSpecificiInvioImpl.setCHIAVE_TIPO_REGISTRO("");
		}
		else {
			datiSpecificiInvioImpl.setCHIAVE_TIPO_REGISTRO(
				CHIAVE_TIPO_REGISTRO);
		}

		if (TIPOLOGIA_UNITA_DOCUMENTARIA == null) {
			datiSpecificiInvioImpl.setTIPOLOGIA_UNITA_DOCUMENTARIA("");
		}
		else {
			datiSpecificiInvioImpl.setTIPOLOGIA_UNITA_DOCUMENTARIA(
				TIPOLOGIA_UNITA_DOCUMENTARIA);
		}

		if (TIPO_CONSERVAZIONE == null) {
			datiSpecificiInvioImpl.setTIPO_CONSERVAZIONE("");
		}
		else {
			datiSpecificiInvioImpl.setTIPO_CONSERVAZIONE(TIPO_CONSERVAZIONE);
		}

		if (FORZA_ACCETTAZIONE == null) {
			datiSpecificiInvioImpl.setFORZA_ACCETTAZIONE("");
		}
		else {
			datiSpecificiInvioImpl.setFORZA_ACCETTAZIONE(FORZA_ACCETTAZIONE);
		}

		if (FORZA_CONSERVAZIONE == null) {
			datiSpecificiInvioImpl.setFORZA_CONSERVAZIONE("");
		}
		else {
			datiSpecificiInvioImpl.setFORZA_CONSERVAZIONE(FORZA_CONSERVAZIONE);
		}

		if (FORZA_COLLEGAMENTO == null) {
			datiSpecificiInvioImpl.setFORZA_COLLEGAMENTO("");
		}
		else {
			datiSpecificiInvioImpl.setFORZA_COLLEGAMENTO(FORZA_COLLEGAMENTO);
		}

		if (OGGETTO_UNITA_DOCUMENTARIA == null) {
			datiSpecificiInvioImpl.setOGGETTO_UNITA_DOCUMENTARIA("");
		}
		else {
			datiSpecificiInvioImpl.setOGGETTO_UNITA_DOCUMENTARIA(
				OGGETTO_UNITA_DOCUMENTARIA);
		}

		if (DATA_UNITA_DOCUMENTARIA == Long.MIN_VALUE) {
			datiSpecificiInvioImpl.setDATA_UNITA_DOCUMENTARIA(null);
		}
		else {
			datiSpecificiInvioImpl.setDATA_UNITA_DOCUMENTARIA(
				new Date(DATA_UNITA_DOCUMENTARIA));
		}

		datiSpecificiInvioImpl.setVERSIONE_DATI_SPECIFICI(
			VERSIONE_DATI_SPECIFICI);

		if (IDENTIFICATIVO_DATO_SPECIFICO == null) {
			datiSpecificiInvioImpl.setIDENTIFICATIVO_DATO_SPECIFICO("");
		}
		else {
			datiSpecificiInvioImpl.setIDENTIFICATIVO_DATO_SPECIFICO(
				IDENTIFICATIVO_DATO_SPECIFICO);
		}

		if (DATA_GENERAZIONE == Long.MIN_VALUE) {
			datiSpecificiInvioImpl.setDATA_GENERAZIONE(null);
		}
		else {
			datiSpecificiInvioImpl.setDATA_GENERAZIONE(
				new Date(DATA_GENERAZIONE));
		}

		datiSpecificiInvioImpl.setNUM_SMS_GENERATI(NUM_SMS_GENERATI);
		datiSpecificiInvioImpl.setNUM_SMS_INVIATI(NUM_SMS_INVIATI);
		datiSpecificiInvioImpl.setNUM_NOTIFICHE_RICEZIONE(
			NUM_NOTIFICHE_RICEZIONE);

		if (DENOMINAZIONE_APPLICATIVO == null) {
			datiSpecificiInvioImpl.setDENOMINAZIONE_APPLICATIVO("");
		}
		else {
			datiSpecificiInvioImpl.setDENOMINAZIONE_APPLICATIVO(
				DENOMINAZIONE_APPLICATIVO);
		}

		if (OGGETTO_MAIL == null) {
			datiSpecificiInvioImpl.setOGGETTO_MAIL("");
		}
		else {
			datiSpecificiInvioImpl.setOGGETTO_MAIL(OGGETTO_MAIL);
		}

		if (TESTO_MAIL == null) {
			datiSpecificiInvioImpl.setTESTO_MAIL("");
		}
		else {
			datiSpecificiInvioImpl.setTESTO_MAIL(TESTO_MAIL);
		}

		if (COMPILATORE_ARPAE == null) {
			datiSpecificiInvioImpl.setCOMPILATORE_ARPAE("");
		}
		else {
			datiSpecificiInvioImpl.setCOMPILATORE_ARPAE(COMPILATORE_ARPAE);
		}

		if (COMPILATORE_PROTEZIONE_CIVILE == null) {
			datiSpecificiInvioImpl.setCOMPILATORE_PROTEZIONE_CIVILE("");
		}
		else {
			datiSpecificiInvioImpl.setCOMPILATORE_PROTEZIONE_CIVILE(
				COMPILATORE_PROTEZIONE_CIVILE);
		}

		if (DATA_INIZIO_VALIDITA == Long.MIN_VALUE) {
			datiSpecificiInvioImpl.setDATA_INIZIO_VALIDITA(null);
		}
		else {
			datiSpecificiInvioImpl.setDATA_INIZIO_VALIDITA(
				new Date(DATA_INIZIO_VALIDITA));
		}

		if (DATA_FINE_VALIDITA == Long.MIN_VALUE) {
			datiSpecificiInvioImpl.setDATA_FINE_VALIDITA(null);
		}
		else {
			datiSpecificiInvioImpl.setDATA_FINE_VALIDITA(
				new Date(DATA_FINE_VALIDITA));
		}

		if (APPROVATORE_ARPAE == null) {
			datiSpecificiInvioImpl.setAPPROVATORE_ARPAE("");
		}
		else {
			datiSpecificiInvioImpl.setAPPROVATORE_ARPAE(APPROVATORE_ARPAE);
		}

		if (DATA_FIRMA_ARPAE == Long.MIN_VALUE) {
			datiSpecificiInvioImpl.setDATA_FIRMA_ARPAE(null);
		}
		else {
			datiSpecificiInvioImpl.setDATA_FIRMA_ARPAE(
				new Date(DATA_FIRMA_ARPAE));
		}

		if (APPROVATORE_PROTEZIONE_CIVILE == null) {
			datiSpecificiInvioImpl.setAPPROVATORE_PROTEZIONE_CIVILE("");
		}
		else {
			datiSpecificiInvioImpl.setAPPROVATORE_PROTEZIONE_CIVILE(
				APPROVATORE_PROTEZIONE_CIVILE);
		}

		if (DATA_FIRMA_PROTEZIONE_CIVILE == Long.MIN_VALUE) {
			datiSpecificiInvioImpl.setDATA_FIRMA_PROTEZIONE_CIVILE(null);
		}
		else {
			datiSpecificiInvioImpl.setDATA_FIRMA_PROTEZIONE_CIVILE(
				new Date(DATA_FIRMA_PROTEZIONE_CIVILE));
		}

		if (INVIO_RESPONSABILE_TERRITORIO == null) {
			datiSpecificiInvioImpl.setINVIO_RESPONSABILE_TERRITORIO("");
		}
		else {
			datiSpecificiInvioImpl.setINVIO_RESPONSABILE_TERRITORIO(
				INVIO_RESPONSABILE_TERRITORIO);
		}

		datiSpecificiInvioImpl.setID_DOCUMENTO_PRINCIPALE(
			ID_DOCUMENTO_PRINCIPALE);

		if (TIPO_DOCUMENTO == null) {
			datiSpecificiInvioImpl.setTIPO_DOCUMENTO("");
		}
		else {
			datiSpecificiInvioImpl.setTIPO_DOCUMENTO(TIPO_DOCUMENTO);
		}

		if (TIPO_STRUTTURA == null) {
			datiSpecificiInvioImpl.setTIPO_STRUTTURA("");
		}
		else {
			datiSpecificiInvioImpl.setTIPO_STRUTTURA(TIPO_STRUTTURA);
		}

		if (DENOMINAZIONE_SENSORE_RILEVAMENTO == null) {
			datiSpecificiInvioImpl.setDENOMINAZIONE_SENSORE_RILEVAMENTO("");
		}
		else {
			datiSpecificiInvioImpl.setDENOMINAZIONE_SENSORE_RILEVAMENTO(
				DENOMINAZIONE_SENSORE_RILEVAMENTO);
		}

		if (REGOLA_ALLARME_ID == null) {
			datiSpecificiInvioImpl.setREGOLA_ALLARME_ID("");
		}
		else {
			datiSpecificiInvioImpl.setREGOLA_ALLARME_ID(REGOLA_ALLARME_ID);
		}

		if (REGOLA_ALLARME_NOME == null) {
			datiSpecificiInvioImpl.setREGOLA_ALLARME_NOME("");
		}
		else {
			datiSpecificiInvioImpl.setREGOLA_ALLARME_NOME(REGOLA_ALLARME_NOME);
		}

		if (REGOLA_ALLARME_DESCRIZIONE == null) {
			datiSpecificiInvioImpl.setREGOLA_ALLARME_DESCRIZIONE("");
		}
		else {
			datiSpecificiInvioImpl.setREGOLA_ALLARME_DESCRIZIONE(
				REGOLA_ALLARME_DESCRIZIONE);
		}

		if (ESITO_INVIO == null) {
			datiSpecificiInvioImpl.setESITO_INVIO("");
		}
		else {
			datiSpecificiInvioImpl.setESITO_INVIO(ESITO_INVIO);
		}

		datiSpecificiInvioImpl.setUserId(userId);
		datiSpecificiInvioImpl.setCompanyId(companyId);
		datiSpecificiInvioImpl.setGroupId(groupId);

		if (data_invio == Long.MIN_VALUE) {
			datiSpecificiInvioImpl.setData_invio(null);
		}
		else {
			datiSpecificiInvioImpl.setData_invio(new Date(data_invio));
		}

		if (data_risposta == Long.MIN_VALUE) {
			datiSpecificiInvioImpl.setData_risposta(null);
		}
		else {
			datiSpecificiInvioImpl.setData_risposta(new Date(data_risposta));
		}

		if (CODICE_ESITO == null) {
			datiSpecificiInvioImpl.setCODICE_ESITO("");
		}
		else {
			datiSpecificiInvioImpl.setCODICE_ESITO(CODICE_ESITO);
		}

		if (CODICE_ERRORE == null) {
			datiSpecificiInvioImpl.setCODICE_ERRORE("");
		}
		else {
			datiSpecificiInvioImpl.setCODICE_ERRORE(CODICE_ERRORE);
		}

		if (MESG_ERRORE == null) {
			datiSpecificiInvioImpl.setMESG_ERRORE("");
		}
		else {
			datiSpecificiInvioImpl.setMESG_ERRORE(MESG_ERRORE);
		}

		if (CODICE_TIPO_INVIO == null) {
			datiSpecificiInvioImpl.setCODICE_TIPO_INVIO("");
		}
		else {
			datiSpecificiInvioImpl.setCODICE_TIPO_INVIO(CODICE_TIPO_INVIO);
		}

		datiSpecificiInvioImpl.resetOriginalValues();

		return datiSpecificiInvioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID_INVIO = objectInput.readLong();
		AMBIENTE = objectInput.readUTF();

		VERSIONE = objectInput.readDouble();
		VERSATORE_ENTE = objectInput.readUTF();
		VERSATORE_USER_ID = objectInput.readUTF();
		VERSATORE_STRUTTURA = objectInput.readUTF();
		CHIAVE_NUMERO = objectInput.readUTF();

		CHIAVE_ANNO = objectInput.readLong();
		CHIAVE_TIPO_REGISTRO = objectInput.readUTF();
		TIPOLOGIA_UNITA_DOCUMENTARIA = objectInput.readUTF();
		TIPO_CONSERVAZIONE = objectInput.readUTF();
		FORZA_ACCETTAZIONE = objectInput.readUTF();
		FORZA_CONSERVAZIONE = objectInput.readUTF();
		FORZA_COLLEGAMENTO = objectInput.readUTF();
		OGGETTO_UNITA_DOCUMENTARIA = objectInput.readUTF();
		DATA_UNITA_DOCUMENTARIA = objectInput.readLong();

		VERSIONE_DATI_SPECIFICI = objectInput.readDouble();
		IDENTIFICATIVO_DATO_SPECIFICO = objectInput.readUTF();
		DATA_GENERAZIONE = objectInput.readLong();

		NUM_SMS_GENERATI = objectInput.readInt();

		NUM_SMS_INVIATI = objectInput.readInt();

		NUM_NOTIFICHE_RICEZIONE = objectInput.readInt();
		DENOMINAZIONE_APPLICATIVO = objectInput.readUTF();
		OGGETTO_MAIL = objectInput.readUTF();
		TESTO_MAIL = objectInput.readUTF();
		COMPILATORE_ARPAE = objectInput.readUTF();
		COMPILATORE_PROTEZIONE_CIVILE = objectInput.readUTF();
		DATA_INIZIO_VALIDITA = objectInput.readLong();
		DATA_FINE_VALIDITA = objectInput.readLong();
		APPROVATORE_ARPAE = objectInput.readUTF();
		DATA_FIRMA_ARPAE = objectInput.readLong();
		APPROVATORE_PROTEZIONE_CIVILE = objectInput.readUTF();
		DATA_FIRMA_PROTEZIONE_CIVILE = objectInput.readLong();
		INVIO_RESPONSABILE_TERRITORIO = objectInput.readUTF();

		ID_DOCUMENTO_PRINCIPALE = objectInput.readLong();
		TIPO_DOCUMENTO = objectInput.readUTF();
		TIPO_STRUTTURA = objectInput.readUTF();
		DENOMINAZIONE_SENSORE_RILEVAMENTO = objectInput.readUTF();
		REGOLA_ALLARME_ID = objectInput.readUTF();
		REGOLA_ALLARME_NOME = objectInput.readUTF();
		REGOLA_ALLARME_DESCRIZIONE = objectInput.readUTF();
		ESITO_INVIO = objectInput.readUTF();

		userId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		data_invio = objectInput.readLong();
		data_risposta = objectInput.readLong();
		CODICE_ESITO = objectInput.readUTF();
		CODICE_ERRORE = objectInput.readUTF();
		MESG_ERRORE = objectInput.readUTF();
		CODICE_TIPO_INVIO = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ID_INVIO);

		if (AMBIENTE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(AMBIENTE);
		}

		objectOutput.writeDouble(VERSIONE);

		if (VERSATORE_ENTE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(VERSATORE_ENTE);
		}

		if (VERSATORE_USER_ID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(VERSATORE_USER_ID);
		}

		if (VERSATORE_STRUTTURA == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(VERSATORE_STRUTTURA);
		}

		if (CHIAVE_NUMERO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CHIAVE_NUMERO);
		}

		objectOutput.writeLong(CHIAVE_ANNO);

		if (CHIAVE_TIPO_REGISTRO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CHIAVE_TIPO_REGISTRO);
		}

		if (TIPOLOGIA_UNITA_DOCUMENTARIA == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TIPOLOGIA_UNITA_DOCUMENTARIA);
		}

		if (TIPO_CONSERVAZIONE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TIPO_CONSERVAZIONE);
		}

		if (FORZA_ACCETTAZIONE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FORZA_ACCETTAZIONE);
		}

		if (FORZA_CONSERVAZIONE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FORZA_CONSERVAZIONE);
		}

		if (FORZA_COLLEGAMENTO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(FORZA_COLLEGAMENTO);
		}

		if (OGGETTO_UNITA_DOCUMENTARIA == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(OGGETTO_UNITA_DOCUMENTARIA);
		}

		objectOutput.writeLong(DATA_UNITA_DOCUMENTARIA);

		objectOutput.writeDouble(VERSIONE_DATI_SPECIFICI);

		if (IDENTIFICATIVO_DATO_SPECIFICO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(IDENTIFICATIVO_DATO_SPECIFICO);
		}

		objectOutput.writeLong(DATA_GENERAZIONE);

		objectOutput.writeInt(NUM_SMS_GENERATI);

		objectOutput.writeInt(NUM_SMS_INVIATI);

		objectOutput.writeInt(NUM_NOTIFICHE_RICEZIONE);

		if (DENOMINAZIONE_APPLICATIVO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DENOMINAZIONE_APPLICATIVO);
		}

		if (OGGETTO_MAIL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(OGGETTO_MAIL);
		}

		if (TESTO_MAIL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TESTO_MAIL);
		}

		if (COMPILATORE_ARPAE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(COMPILATORE_ARPAE);
		}

		if (COMPILATORE_PROTEZIONE_CIVILE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(COMPILATORE_PROTEZIONE_CIVILE);
		}

		objectOutput.writeLong(DATA_INIZIO_VALIDITA);
		objectOutput.writeLong(DATA_FINE_VALIDITA);

		if (APPROVATORE_ARPAE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(APPROVATORE_ARPAE);
		}

		objectOutput.writeLong(DATA_FIRMA_ARPAE);

		if (APPROVATORE_PROTEZIONE_CIVILE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(APPROVATORE_PROTEZIONE_CIVILE);
		}

		objectOutput.writeLong(DATA_FIRMA_PROTEZIONE_CIVILE);

		if (INVIO_RESPONSABILE_TERRITORIO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(INVIO_RESPONSABILE_TERRITORIO);
		}

		objectOutput.writeLong(ID_DOCUMENTO_PRINCIPALE);

		if (TIPO_DOCUMENTO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TIPO_DOCUMENTO);
		}

		if (TIPO_STRUTTURA == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(TIPO_STRUTTURA);
		}

		if (DENOMINAZIONE_SENSORE_RILEVAMENTO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(DENOMINAZIONE_SENSORE_RILEVAMENTO);
		}

		if (REGOLA_ALLARME_ID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REGOLA_ALLARME_ID);
		}

		if (REGOLA_ALLARME_NOME == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REGOLA_ALLARME_NOME);
		}

		if (REGOLA_ALLARME_DESCRIZIONE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(REGOLA_ALLARME_DESCRIZIONE);
		}

		if (ESITO_INVIO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ESITO_INVIO);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(data_invio);
		objectOutput.writeLong(data_risposta);

		if (CODICE_ESITO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CODICE_ESITO);
		}

		if (CODICE_ERRORE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CODICE_ERRORE);
		}

		if (MESG_ERRORE == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(MESG_ERRORE);
		}

		if (CODICE_TIPO_INVIO == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(CODICE_TIPO_INVIO);
		}
	}

	public long ID_INVIO;

	public String AMBIENTE;

	public double VERSIONE;

	public String VERSATORE_ENTE;

	public String VERSATORE_USER_ID;

	public String VERSATORE_STRUTTURA;

	public String CHIAVE_NUMERO;

	public long CHIAVE_ANNO;

	public String CHIAVE_TIPO_REGISTRO;

	public String TIPOLOGIA_UNITA_DOCUMENTARIA;

	public String TIPO_CONSERVAZIONE;

	public String FORZA_ACCETTAZIONE;

	public String FORZA_CONSERVAZIONE;

	public String FORZA_COLLEGAMENTO;

	public String OGGETTO_UNITA_DOCUMENTARIA;

	public long DATA_UNITA_DOCUMENTARIA;

	public double VERSIONE_DATI_SPECIFICI;

	public String IDENTIFICATIVO_DATO_SPECIFICO;

	public long DATA_GENERAZIONE;

	public int NUM_SMS_GENERATI;

	public int NUM_SMS_INVIATI;

	public int NUM_NOTIFICHE_RICEZIONE;

	public String DENOMINAZIONE_APPLICATIVO;

	public String OGGETTO_MAIL;

	public String TESTO_MAIL;

	public String COMPILATORE_ARPAE;

	public String COMPILATORE_PROTEZIONE_CIVILE;

	public long DATA_INIZIO_VALIDITA;

	public long DATA_FINE_VALIDITA;

	public String APPROVATORE_ARPAE;

	public long DATA_FIRMA_ARPAE;

	public String APPROVATORE_PROTEZIONE_CIVILE;

	public long DATA_FIRMA_PROTEZIONE_CIVILE;

	public String INVIO_RESPONSABILE_TERRITORIO;

	public long ID_DOCUMENTO_PRINCIPALE;

	public String TIPO_DOCUMENTO;

	public String TIPO_STRUTTURA;

	public String DENOMINAZIONE_SENSORE_RILEVAMENTO;

	public String REGOLA_ALLARME_ID;

	public String REGOLA_ALLARME_NOME;

	public String REGOLA_ALLARME_DESCRIZIONE;

	public String ESITO_INVIO;

	public long userId;
	public long companyId;
	public long groupId;
	public long data_invio;
	public long data_risposta;

	public String CODICE_ESITO;

	public String CODICE_ERRORE;

	public String MESG_ERRORE;

	public String CODICE_TIPO_INVIO;

}