/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DatiSpecificiInvio}.
 * </p>
 *
 * @author Pratola_L
 * @see DatiSpecificiInvio
 * @generated
 */
public class DatiSpecificiInvioWrapper
	extends BaseModelWrapper<DatiSpecificiInvio>
	implements DatiSpecificiInvio, ModelWrapper<DatiSpecificiInvio> {

	public DatiSpecificiInvioWrapper(DatiSpecificiInvio datiSpecificiInvio) {
		super(datiSpecificiInvio);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID_INVIO", getID_INVIO());
		attributes.put("AMBIENTE", getAMBIENTE());
		attributes.put("VERSIONE", getVERSIONE());
		attributes.put("VERSATORE_ENTE", getVERSATORE_ENTE());
		attributes.put("VERSATORE_USER_ID", getVERSATORE_USER_ID());
		attributes.put("VERSATORE_STRUTTURA", getVERSATORE_STRUTTURA());
		attributes.put("CHIAVE_NUMERO", getCHIAVE_NUMERO());
		attributes.put("CHIAVE_ANNO", getCHIAVE_ANNO());
		attributes.put("CHIAVE_TIPO_REGISTRO", getCHIAVE_TIPO_REGISTRO());
		attributes.put(
			"TIPOLOGIA_UNITA_DOCUMENTARIA", getTIPOLOGIA_UNITA_DOCUMENTARIA());
		attributes.put("TIPO_CONSERVAZIONE", getTIPO_CONSERVAZIONE());
		attributes.put("FORZA_ACCETTAZIONE", getFORZA_ACCETTAZIONE());
		attributes.put("FORZA_CONSERVAZIONE", getFORZA_CONSERVAZIONE());
		attributes.put("FORZA_COLLEGAMENTO", getFORZA_COLLEGAMENTO());
		attributes.put(
			"OGGETTO_UNITA_DOCUMENTARIA", getOGGETTO_UNITA_DOCUMENTARIA());
		attributes.put("DATA_UNITA_DOCUMENTARIA", getDATA_UNITA_DOCUMENTARIA());
		attributes.put("VERSIONE_DATI_SPECIFICI", getVERSIONE_DATI_SPECIFICI());
		attributes.put(
			"IDENTIFICATIVO_DATO_SPECIFICO",
			getIDENTIFICATIVO_DATO_SPECIFICO());
		attributes.put("DATA_GENERAZIONE", getDATA_GENERAZIONE());
		attributes.put("NUM_SMS_GENERATI", getNUM_SMS_GENERATI());
		attributes.put("NUM_SMS_INVIATI", getNUM_SMS_INVIATI());
		attributes.put("NUM_NOTIFICHE_RICEZIONE", getNUM_NOTIFICHE_RICEZIONE());
		attributes.put(
			"DENOMINAZIONE_APPLICATIVO", getDENOMINAZIONE_APPLICATIVO());
		attributes.put("OGGETTO_MAIL", getOGGETTO_MAIL());
		attributes.put("TESTO_MAIL", getTESTO_MAIL());
		attributes.put("COMPILATORE_ARPAE", getCOMPILATORE_ARPAE());
		attributes.put(
			"COMPILATORE_PROTEZIONE_CIVILE",
			getCOMPILATORE_PROTEZIONE_CIVILE());
		attributes.put("DATA_INIZIO_VALIDITA", getDATA_INIZIO_VALIDITA());
		attributes.put("DATA_FINE_VALIDITA", getDATA_FINE_VALIDITA());
		attributes.put("APPROVATORE_ARPAE", getAPPROVATORE_ARPAE());
		attributes.put("DATA_FIRMA_ARPAE", getDATA_FIRMA_ARPAE());
		attributes.put(
			"APPROVATORE_PROTEZIONE_CIVILE",
			getAPPROVATORE_PROTEZIONE_CIVILE());
		attributes.put(
			"DATA_FIRMA_PROTEZIONE_CIVILE", getDATA_FIRMA_PROTEZIONE_CIVILE());
		attributes.put(
			"INVIO_RESPONSABILE_TERRITORIO",
			getINVIO_RESPONSABILE_TERRITORIO());
		attributes.put("ID_DOCUMENTO_PRINCIPALE", getID_DOCUMENTO_PRINCIPALE());
		attributes.put("TIPO_DOCUMENTO", getTIPO_DOCUMENTO());
		attributes.put("TIPO_STRUTTURA", getTIPO_STRUTTURA());
		attributes.put(
			"DENOMINAZIONE_SENSORE_RILEVAMENTO",
			getDENOMINAZIONE_SENSORE_RILEVAMENTO());
		attributes.put("REGOLA_ALLARME_ID", getREGOLA_ALLARME_ID());
		attributes.put("REGOLA_ALLARME_NOME", getREGOLA_ALLARME_NOME());
		attributes.put(
			"REGOLA_ALLARME_DESCRIZIONE", getREGOLA_ALLARME_DESCRIZIONE());
		attributes.put("ESITO_INVIO", getESITO_INVIO());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("data_invio", getData_invio());
		attributes.put("data_risposta", getData_risposta());
		attributes.put("CODICE_ESITO", getCODICE_ESITO());
		attributes.put("CODICE_ERRORE", getCODICE_ERRORE());
		attributes.put("MESG_ERRORE", getMESG_ERRORE());
		attributes.put("CODICE_TIPO_INVIO", getCODICE_TIPO_INVIO());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID_INVIO = (Long)attributes.get("ID_INVIO");

		if (ID_INVIO != null) {
			setID_INVIO(ID_INVIO);
		}

		String AMBIENTE = (String)attributes.get("AMBIENTE");

		if (AMBIENTE != null) {
			setAMBIENTE(AMBIENTE);
		}

		Double VERSIONE = (Double)attributes.get("VERSIONE");

		if (VERSIONE != null) {
			setVERSIONE(VERSIONE);
		}

		String VERSATORE_ENTE = (String)attributes.get("VERSATORE_ENTE");

		if (VERSATORE_ENTE != null) {
			setVERSATORE_ENTE(VERSATORE_ENTE);
		}

		String VERSATORE_USER_ID = (String)attributes.get("VERSATORE_USER_ID");

		if (VERSATORE_USER_ID != null) {
			setVERSATORE_USER_ID(VERSATORE_USER_ID);
		}

		String VERSATORE_STRUTTURA = (String)attributes.get(
			"VERSATORE_STRUTTURA");

		if (VERSATORE_STRUTTURA != null) {
			setVERSATORE_STRUTTURA(VERSATORE_STRUTTURA);
		}

		String CHIAVE_NUMERO = (String)attributes.get("CHIAVE_NUMERO");

		if (CHIAVE_NUMERO != null) {
			setCHIAVE_NUMERO(CHIAVE_NUMERO);
		}

		Long CHIAVE_ANNO = (Long)attributes.get("CHIAVE_ANNO");

		if (CHIAVE_ANNO != null) {
			setCHIAVE_ANNO(CHIAVE_ANNO);
		}

		String CHIAVE_TIPO_REGISTRO = (String)attributes.get(
			"CHIAVE_TIPO_REGISTRO");

		if (CHIAVE_TIPO_REGISTRO != null) {
			setCHIAVE_TIPO_REGISTRO(CHIAVE_TIPO_REGISTRO);
		}

		String TIPOLOGIA_UNITA_DOCUMENTARIA = (String)attributes.get(
			"TIPOLOGIA_UNITA_DOCUMENTARIA");

		if (TIPOLOGIA_UNITA_DOCUMENTARIA != null) {
			setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA);
		}

		String TIPO_CONSERVAZIONE = (String)attributes.get(
			"TIPO_CONSERVAZIONE");

		if (TIPO_CONSERVAZIONE != null) {
			setTIPO_CONSERVAZIONE(TIPO_CONSERVAZIONE);
		}

		String FORZA_ACCETTAZIONE = (String)attributes.get(
			"FORZA_ACCETTAZIONE");

		if (FORZA_ACCETTAZIONE != null) {
			setFORZA_ACCETTAZIONE(FORZA_ACCETTAZIONE);
		}

		String FORZA_CONSERVAZIONE = (String)attributes.get(
			"FORZA_CONSERVAZIONE");

		if (FORZA_CONSERVAZIONE != null) {
			setFORZA_CONSERVAZIONE(FORZA_CONSERVAZIONE);
		}

		String FORZA_COLLEGAMENTO = (String)attributes.get(
			"FORZA_COLLEGAMENTO");

		if (FORZA_COLLEGAMENTO != null) {
			setFORZA_COLLEGAMENTO(FORZA_COLLEGAMENTO);
		}

		String OGGETTO_UNITA_DOCUMENTARIA = (String)attributes.get(
			"OGGETTO_UNITA_DOCUMENTARIA");

		if (OGGETTO_UNITA_DOCUMENTARIA != null) {
			setOGGETTO_UNITA_DOCUMENTARIA(OGGETTO_UNITA_DOCUMENTARIA);
		}

		Date DATA_UNITA_DOCUMENTARIA = (Date)attributes.get(
			"DATA_UNITA_DOCUMENTARIA");

		if (DATA_UNITA_DOCUMENTARIA != null) {
			setDATA_UNITA_DOCUMENTARIA(DATA_UNITA_DOCUMENTARIA);
		}

		Double VERSIONE_DATI_SPECIFICI = (Double)attributes.get(
			"VERSIONE_DATI_SPECIFICI");

		if (VERSIONE_DATI_SPECIFICI != null) {
			setVERSIONE_DATI_SPECIFICI(VERSIONE_DATI_SPECIFICI);
		}

		String IDENTIFICATIVO_DATO_SPECIFICO = (String)attributes.get(
			"IDENTIFICATIVO_DATO_SPECIFICO");

		if (IDENTIFICATIVO_DATO_SPECIFICO != null) {
			setIDENTIFICATIVO_DATO_SPECIFICO(IDENTIFICATIVO_DATO_SPECIFICO);
		}

		Date DATA_GENERAZIONE = (Date)attributes.get("DATA_GENERAZIONE");

		if (DATA_GENERAZIONE != null) {
			setDATA_GENERAZIONE(DATA_GENERAZIONE);
		}

		Integer NUM_SMS_GENERATI = (Integer)attributes.get("NUM_SMS_GENERATI");

		if (NUM_SMS_GENERATI != null) {
			setNUM_SMS_GENERATI(NUM_SMS_GENERATI);
		}

		Integer NUM_SMS_INVIATI = (Integer)attributes.get("NUM_SMS_INVIATI");

		if (NUM_SMS_INVIATI != null) {
			setNUM_SMS_INVIATI(NUM_SMS_INVIATI);
		}

		Integer NUM_NOTIFICHE_RICEZIONE = (Integer)attributes.get(
			"NUM_NOTIFICHE_RICEZIONE");

		if (NUM_NOTIFICHE_RICEZIONE != null) {
			setNUM_NOTIFICHE_RICEZIONE(NUM_NOTIFICHE_RICEZIONE);
		}

		String DENOMINAZIONE_APPLICATIVO = (String)attributes.get(
			"DENOMINAZIONE_APPLICATIVO");

		if (DENOMINAZIONE_APPLICATIVO != null) {
			setDENOMINAZIONE_APPLICATIVO(DENOMINAZIONE_APPLICATIVO);
		}

		String OGGETTO_MAIL = (String)attributes.get("OGGETTO_MAIL");

		if (OGGETTO_MAIL != null) {
			setOGGETTO_MAIL(OGGETTO_MAIL);
		}

		String TESTO_MAIL = (String)attributes.get("TESTO_MAIL");

		if (TESTO_MAIL != null) {
			setTESTO_MAIL(TESTO_MAIL);
		}

		String COMPILATORE_ARPAE = (String)attributes.get("COMPILATORE_ARPAE");

		if (COMPILATORE_ARPAE != null) {
			setCOMPILATORE_ARPAE(COMPILATORE_ARPAE);
		}

		String COMPILATORE_PROTEZIONE_CIVILE = (String)attributes.get(
			"COMPILATORE_PROTEZIONE_CIVILE");

		if (COMPILATORE_PROTEZIONE_CIVILE != null) {
			setCOMPILATORE_PROTEZIONE_CIVILE(COMPILATORE_PROTEZIONE_CIVILE);
		}

		Date DATA_INIZIO_VALIDITA = (Date)attributes.get(
			"DATA_INIZIO_VALIDITA");

		if (DATA_INIZIO_VALIDITA != null) {
			setDATA_INIZIO_VALIDITA(DATA_INIZIO_VALIDITA);
		}

		Date DATA_FINE_VALIDITA = (Date)attributes.get("DATA_FINE_VALIDITA");

		if (DATA_FINE_VALIDITA != null) {
			setDATA_FINE_VALIDITA(DATA_FINE_VALIDITA);
		}

		String APPROVATORE_ARPAE = (String)attributes.get("APPROVATORE_ARPAE");

		if (APPROVATORE_ARPAE != null) {
			setAPPROVATORE_ARPAE(APPROVATORE_ARPAE);
		}

		Date DATA_FIRMA_ARPAE = (Date)attributes.get("DATA_FIRMA_ARPAE");

		if (DATA_FIRMA_ARPAE != null) {
			setDATA_FIRMA_ARPAE(DATA_FIRMA_ARPAE);
		}

		String APPROVATORE_PROTEZIONE_CIVILE = (String)attributes.get(
			"APPROVATORE_PROTEZIONE_CIVILE");

		if (APPROVATORE_PROTEZIONE_CIVILE != null) {
			setAPPROVATORE_PROTEZIONE_CIVILE(APPROVATORE_PROTEZIONE_CIVILE);
		}

		Date DATA_FIRMA_PROTEZIONE_CIVILE = (Date)attributes.get(
			"DATA_FIRMA_PROTEZIONE_CIVILE");

		if (DATA_FIRMA_PROTEZIONE_CIVILE != null) {
			setDATA_FIRMA_PROTEZIONE_CIVILE(DATA_FIRMA_PROTEZIONE_CIVILE);
		}

		String INVIO_RESPONSABILE_TERRITORIO = (String)attributes.get(
			"INVIO_RESPONSABILE_TERRITORIO");

		if (INVIO_RESPONSABILE_TERRITORIO != null) {
			setINVIO_RESPONSABILE_TERRITORIO(INVIO_RESPONSABILE_TERRITORIO);
		}

		Long ID_DOCUMENTO_PRINCIPALE = (Long)attributes.get(
			"ID_DOCUMENTO_PRINCIPALE");

		if (ID_DOCUMENTO_PRINCIPALE != null) {
			setID_DOCUMENTO_PRINCIPALE(ID_DOCUMENTO_PRINCIPALE);
		}

		String TIPO_DOCUMENTO = (String)attributes.get("TIPO_DOCUMENTO");

		if (TIPO_DOCUMENTO != null) {
			setTIPO_DOCUMENTO(TIPO_DOCUMENTO);
		}

		String TIPO_STRUTTURA = (String)attributes.get("TIPO_STRUTTURA");

		if (TIPO_STRUTTURA != null) {
			setTIPO_STRUTTURA(TIPO_STRUTTURA);
		}

		String DENOMINAZIONE_SENSORE_RILEVAMENTO = (String)attributes.get(
			"DENOMINAZIONE_SENSORE_RILEVAMENTO");

		if (DENOMINAZIONE_SENSORE_RILEVAMENTO != null) {
			setDENOMINAZIONE_SENSORE_RILEVAMENTO(
				DENOMINAZIONE_SENSORE_RILEVAMENTO);
		}

		String REGOLA_ALLARME_ID = (String)attributes.get("REGOLA_ALLARME_ID");

		if (REGOLA_ALLARME_ID != null) {
			setREGOLA_ALLARME_ID(REGOLA_ALLARME_ID);
		}

		String REGOLA_ALLARME_NOME = (String)attributes.get(
			"REGOLA_ALLARME_NOME");

		if (REGOLA_ALLARME_NOME != null) {
			setREGOLA_ALLARME_NOME(REGOLA_ALLARME_NOME);
		}

		String REGOLA_ALLARME_DESCRIZIONE = (String)attributes.get(
			"REGOLA_ALLARME_DESCRIZIONE");

		if (REGOLA_ALLARME_DESCRIZIONE != null) {
			setREGOLA_ALLARME_DESCRIZIONE(REGOLA_ALLARME_DESCRIZIONE);
		}

		String ESITO_INVIO = (String)attributes.get("ESITO_INVIO");

		if (ESITO_INVIO != null) {
			setESITO_INVIO(ESITO_INVIO);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date data_invio = (Date)attributes.get("data_invio");

		if (data_invio != null) {
			setData_invio(data_invio);
		}

		Date data_risposta = (Date)attributes.get("data_risposta");

		if (data_risposta != null) {
			setData_risposta(data_risposta);
		}

		String CODICE_ESITO = (String)attributes.get("CODICE_ESITO");

		if (CODICE_ESITO != null) {
			setCODICE_ESITO(CODICE_ESITO);
		}

		String CODICE_ERRORE = (String)attributes.get("CODICE_ERRORE");

		if (CODICE_ERRORE != null) {
			setCODICE_ERRORE(CODICE_ERRORE);
		}

		String MESG_ERRORE = (String)attributes.get("MESG_ERRORE");

		if (MESG_ERRORE != null) {
			setMESG_ERRORE(MESG_ERRORE);
		}

		String CODICE_TIPO_INVIO = (String)attributes.get("CODICE_TIPO_INVIO");

		if (CODICE_TIPO_INVIO != null) {
			setCODICE_TIPO_INVIO(CODICE_TIPO_INVIO);
		}
	}

	@Override
	public DatiSpecificiInvio cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ambiente of this dati specifici invio.
	 *
	 * @return the ambiente of this dati specifici invio
	 */
	@Override
	public String getAMBIENTE() {
		return model.getAMBIENTE();
	}

	/**
	 * Returns the approvatore_arpae of this dati specifici invio.
	 *
	 * @return the approvatore_arpae of this dati specifici invio
	 */
	@Override
	public String getAPPROVATORE_ARPAE() {
		return model.getAPPROVATORE_ARPAE();
	}

	/**
	 * Returns the approvatore_protezione_civile of this dati specifici invio.
	 *
	 * @return the approvatore_protezione_civile of this dati specifici invio
	 */
	@Override
	public String getAPPROVATORE_PROTEZIONE_CIVILE() {
		return model.getAPPROVATORE_PROTEZIONE_CIVILE();
	}

	/**
	 * Returns the chiave_anno of this dati specifici invio.
	 *
	 * @return the chiave_anno of this dati specifici invio
	 */
	@Override
	public long getCHIAVE_ANNO() {
		return model.getCHIAVE_ANNO();
	}

	/**
	 * Returns the chiave_numero of this dati specifici invio.
	 *
	 * @return the chiave_numero of this dati specifici invio
	 */
	@Override
	public String getCHIAVE_NUMERO() {
		return model.getCHIAVE_NUMERO();
	}

	/**
	 * Returns the chiave_tipo_registro of this dati specifici invio.
	 *
	 * @return the chiave_tipo_registro of this dati specifici invio
	 */
	@Override
	public String getCHIAVE_TIPO_REGISTRO() {
		return model.getCHIAVE_TIPO_REGISTRO();
	}

	/**
	 * Returns the codice_errore of this dati specifici invio.
	 *
	 * @return the codice_errore of this dati specifici invio
	 */
	@Override
	public String getCODICE_ERRORE() {
		return model.getCODICE_ERRORE();
	}

	/**
	 * Returns the codice_esito of this dati specifici invio.
	 *
	 * @return the codice_esito of this dati specifici invio
	 */
	@Override
	public String getCODICE_ESITO() {
		return model.getCODICE_ESITO();
	}

	/**
	 * Returns the codice_tipo_invio of this dati specifici invio.
	 *
	 * @return the codice_tipo_invio of this dati specifici invio
	 */
	@Override
	public String getCODICE_TIPO_INVIO() {
		return model.getCODICE_TIPO_INVIO();
	}

	/**
	 * Returns the company ID of this dati specifici invio.
	 *
	 * @return the company ID of this dati specifici invio
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the compilatore_arpae of this dati specifici invio.
	 *
	 * @return the compilatore_arpae of this dati specifici invio
	 */
	@Override
	public String getCOMPILATORE_ARPAE() {
		return model.getCOMPILATORE_ARPAE();
	}

	/**
	 * Returns the compilatore_protezione_civile of this dati specifici invio.
	 *
	 * @return the compilatore_protezione_civile of this dati specifici invio
	 */
	@Override
	public String getCOMPILATORE_PROTEZIONE_CIVILE() {
		return model.getCOMPILATORE_PROTEZIONE_CIVILE();
	}

	/**
	 * Returns the data_fine_validita of this dati specifici invio.
	 *
	 * @return the data_fine_validita of this dati specifici invio
	 */
	@Override
	public Date getDATA_FINE_VALIDITA() {
		return model.getDATA_FINE_VALIDITA();
	}

	/**
	 * Returns the data_firma_arpae of this dati specifici invio.
	 *
	 * @return the data_firma_arpae of this dati specifici invio
	 */
	@Override
	public Date getDATA_FIRMA_ARPAE() {
		return model.getDATA_FIRMA_ARPAE();
	}

	/**
	 * Returns the data_firma_protezione_civile of this dati specifici invio.
	 *
	 * @return the data_firma_protezione_civile of this dati specifici invio
	 */
	@Override
	public Date getDATA_FIRMA_PROTEZIONE_CIVILE() {
		return model.getDATA_FIRMA_PROTEZIONE_CIVILE();
	}

	/**
	 * Returns the data_generazione of this dati specifici invio.
	 *
	 * @return the data_generazione of this dati specifici invio
	 */
	@Override
	public Date getDATA_GENERAZIONE() {
		return model.getDATA_GENERAZIONE();
	}

	/**
	 * Returns the data_inizio_validita of this dati specifici invio.
	 *
	 * @return the data_inizio_validita of this dati specifici invio
	 */
	@Override
	public Date getDATA_INIZIO_VALIDITA() {
		return model.getDATA_INIZIO_VALIDITA();
	}

	/**
	 * Returns the data_invio of this dati specifici invio.
	 *
	 * @return the data_invio of this dati specifici invio
	 */
	@Override
	public Date getData_invio() {
		return model.getData_invio();
	}

	/**
	 * Returns the data_risposta of this dati specifici invio.
	 *
	 * @return the data_risposta of this dati specifici invio
	 */
	@Override
	public Date getData_risposta() {
		return model.getData_risposta();
	}

	/**
	 * Returns the data_unita_documentaria of this dati specifici invio.
	 *
	 * @return the data_unita_documentaria of this dati specifici invio
	 */
	@Override
	public Date getDATA_UNITA_DOCUMENTARIA() {
		return model.getDATA_UNITA_DOCUMENTARIA();
	}

	/**
	 * Returns the denominazione_applicativo of this dati specifici invio.
	 *
	 * @return the denominazione_applicativo of this dati specifici invio
	 */
	@Override
	public String getDENOMINAZIONE_APPLICATIVO() {
		return model.getDENOMINAZIONE_APPLICATIVO();
	}

	/**
	 * Returns the denominazione_sensore_rilevamento of this dati specifici invio.
	 *
	 * @return the denominazione_sensore_rilevamento of this dati specifici invio
	 */
	@Override
	public String getDENOMINAZIONE_SENSORE_RILEVAMENTO() {
		return model.getDENOMINAZIONE_SENSORE_RILEVAMENTO();
	}

	/**
	 * Returns the esito_invio of this dati specifici invio.
	 *
	 * @return the esito_invio of this dati specifici invio
	 */
	@Override
	public String getESITO_INVIO() {
		return model.getESITO_INVIO();
	}

	/**
	 * Returns the forza_accettazione of this dati specifici invio.
	 *
	 * @return the forza_accettazione of this dati specifici invio
	 */
	@Override
	public String getFORZA_ACCETTAZIONE() {
		return model.getFORZA_ACCETTAZIONE();
	}

	/**
	 * Returns the forza_collegamento of this dati specifici invio.
	 *
	 * @return the forza_collegamento of this dati specifici invio
	 */
	@Override
	public String getFORZA_COLLEGAMENTO() {
		return model.getFORZA_COLLEGAMENTO();
	}

	/**
	 * Returns the forza_conservazione of this dati specifici invio.
	 *
	 * @return the forza_conservazione of this dati specifici invio
	 */
	@Override
	public String getFORZA_CONSERVAZIONE() {
		return model.getFORZA_CONSERVAZIONE();
	}

	/**
	 * Returns the group ID of this dati specifici invio.
	 *
	 * @return the group ID of this dati specifici invio
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id_documento_principale of this dati specifici invio.
	 *
	 * @return the id_documento_principale of this dati specifici invio
	 */
	@Override
	public long getID_DOCUMENTO_PRINCIPALE() {
		return model.getID_DOCUMENTO_PRINCIPALE();
	}

	/**
	 * Returns the id_invio of this dati specifici invio.
	 *
	 * @return the id_invio of this dati specifici invio
	 */
	@Override
	public long getID_INVIO() {
		return model.getID_INVIO();
	}

	/**
	 * Returns the identificativo_dato_specifico of this dati specifici invio.
	 *
	 * @return the identificativo_dato_specifico of this dati specifici invio
	 */
	@Override
	public String getIDENTIFICATIVO_DATO_SPECIFICO() {
		return model.getIDENTIFICATIVO_DATO_SPECIFICO();
	}

	/**
	 * Returns the invio_responsabile_territorio of this dati specifici invio.
	 *
	 * @return the invio_responsabile_territorio of this dati specifici invio
	 */
	@Override
	public String getINVIO_RESPONSABILE_TERRITORIO() {
		return model.getINVIO_RESPONSABILE_TERRITORIO();
	}

	/**
	 * Returns the mesg_errore of this dati specifici invio.
	 *
	 * @return the mesg_errore of this dati specifici invio
	 */
	@Override
	public String getMESG_ERRORE() {
		return model.getMESG_ERRORE();
	}

	/**
	 * Returns the num_notifiche_ricezione of this dati specifici invio.
	 *
	 * @return the num_notifiche_ricezione of this dati specifici invio
	 */
	@Override
	public int getNUM_NOTIFICHE_RICEZIONE() {
		return model.getNUM_NOTIFICHE_RICEZIONE();
	}

	/**
	 * Returns the num_sms_generati of this dati specifici invio.
	 *
	 * @return the num_sms_generati of this dati specifici invio
	 */
	@Override
	public int getNUM_SMS_GENERATI() {
		return model.getNUM_SMS_GENERATI();
	}

	/**
	 * Returns the num_sms_inviati of this dati specifici invio.
	 *
	 * @return the num_sms_inviati of this dati specifici invio
	 */
	@Override
	public int getNUM_SMS_INVIATI() {
		return model.getNUM_SMS_INVIATI();
	}

	/**
	 * Returns the oggetto_mail of this dati specifici invio.
	 *
	 * @return the oggetto_mail of this dati specifici invio
	 */
	@Override
	public String getOGGETTO_MAIL() {
		return model.getOGGETTO_MAIL();
	}

	/**
	 * Returns the oggetto_unita_documentaria of this dati specifici invio.
	 *
	 * @return the oggetto_unita_documentaria of this dati specifici invio
	 */
	@Override
	public String getOGGETTO_UNITA_DOCUMENTARIA() {
		return model.getOGGETTO_UNITA_DOCUMENTARIA();
	}

	/**
	 * Returns the primary key of this dati specifici invio.
	 *
	 * @return the primary key of this dati specifici invio
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the regola_allarme_descrizione of this dati specifici invio.
	 *
	 * @return the regola_allarme_descrizione of this dati specifici invio
	 */
	@Override
	public String getREGOLA_ALLARME_DESCRIZIONE() {
		return model.getREGOLA_ALLARME_DESCRIZIONE();
	}

	/**
	 * Returns the regola_allarme_id of this dati specifici invio.
	 *
	 * @return the regola_allarme_id of this dati specifici invio
	 */
	@Override
	public String getREGOLA_ALLARME_ID() {
		return model.getREGOLA_ALLARME_ID();
	}

	/**
	 * Returns the regola_allarme_nome of this dati specifici invio.
	 *
	 * @return the regola_allarme_nome of this dati specifici invio
	 */
	@Override
	public String getREGOLA_ALLARME_NOME() {
		return model.getREGOLA_ALLARME_NOME();
	}

	/**
	 * Returns the testo_mail of this dati specifici invio.
	 *
	 * @return the testo_mail of this dati specifici invio
	 */
	@Override
	public String getTESTO_MAIL() {
		return model.getTESTO_MAIL();
	}

	/**
	 * Returns the tipo_conservazione of this dati specifici invio.
	 *
	 * @return the tipo_conservazione of this dati specifici invio
	 */
	@Override
	public String getTIPO_CONSERVAZIONE() {
		return model.getTIPO_CONSERVAZIONE();
	}

	/**
	 * Returns the tipo_documento of this dati specifici invio.
	 *
	 * @return the tipo_documento of this dati specifici invio
	 */
	@Override
	public String getTIPO_DOCUMENTO() {
		return model.getTIPO_DOCUMENTO();
	}

	/**
	 * Returns the tipo_struttura of this dati specifici invio.
	 *
	 * @return the tipo_struttura of this dati specifici invio
	 */
	@Override
	public String getTIPO_STRUTTURA() {
		return model.getTIPO_STRUTTURA();
	}

	/**
	 * Returns the tipologia_unita_documentaria of this dati specifici invio.
	 *
	 * @return the tipologia_unita_documentaria of this dati specifici invio
	 */
	@Override
	public String getTIPOLOGIA_UNITA_DOCUMENTARIA() {
		return model.getTIPOLOGIA_UNITA_DOCUMENTARIA();
	}

	/**
	 * Returns the user ID of this dati specifici invio.
	 *
	 * @return the user ID of this dati specifici invio
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this dati specifici invio.
	 *
	 * @return the user uuid of this dati specifici invio
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the versatore_ente of this dati specifici invio.
	 *
	 * @return the versatore_ente of this dati specifici invio
	 */
	@Override
	public String getVERSATORE_ENTE() {
		return model.getVERSATORE_ENTE();
	}

	/**
	 * Returns the versatore_struttura of this dati specifici invio.
	 *
	 * @return the versatore_struttura of this dati specifici invio
	 */
	@Override
	public String getVERSATORE_STRUTTURA() {
		return model.getVERSATORE_STRUTTURA();
	}

	/**
	 * Returns the versatore_user_id of this dati specifici invio.
	 *
	 * @return the versatore_user_id of this dati specifici invio
	 */
	@Override
	public String getVERSATORE_USER_ID() {
		return model.getVERSATORE_USER_ID();
	}

	/**
	 * Returns the versione of this dati specifici invio.
	 *
	 * @return the versione of this dati specifici invio
	 */
	@Override
	public double getVERSIONE() {
		return model.getVERSIONE();
	}

	/**
	 * Returns the versione_dati_specifici of this dati specifici invio.
	 *
	 * @return the versione_dati_specifici of this dati specifici invio
	 */
	@Override
	public double getVERSIONE_DATI_SPECIFICI() {
		return model.getVERSIONE_DATI_SPECIFICI();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ambiente of this dati specifici invio.
	 *
	 * @param AMBIENTE the ambiente of this dati specifici invio
	 */
	@Override
	public void setAMBIENTE(String AMBIENTE) {
		model.setAMBIENTE(AMBIENTE);
	}

	/**
	 * Sets the approvatore_arpae of this dati specifici invio.
	 *
	 * @param APPROVATORE_ARPAE the approvatore_arpae of this dati specifici invio
	 */
	@Override
	public void setAPPROVATORE_ARPAE(String APPROVATORE_ARPAE) {
		model.setAPPROVATORE_ARPAE(APPROVATORE_ARPAE);
	}

	/**
	 * Sets the approvatore_protezione_civile of this dati specifici invio.
	 *
	 * @param APPROVATORE_PROTEZIONE_CIVILE the approvatore_protezione_civile of this dati specifici invio
	 */
	@Override
	public void setAPPROVATORE_PROTEZIONE_CIVILE(
		String APPROVATORE_PROTEZIONE_CIVILE) {

		model.setAPPROVATORE_PROTEZIONE_CIVILE(APPROVATORE_PROTEZIONE_CIVILE);
	}

	/**
	 * Sets the chiave_anno of this dati specifici invio.
	 *
	 * @param CHIAVE_ANNO the chiave_anno of this dati specifici invio
	 */
	@Override
	public void setCHIAVE_ANNO(long CHIAVE_ANNO) {
		model.setCHIAVE_ANNO(CHIAVE_ANNO);
	}

	/**
	 * Sets the chiave_numero of this dati specifici invio.
	 *
	 * @param CHIAVE_NUMERO the chiave_numero of this dati specifici invio
	 */
	@Override
	public void setCHIAVE_NUMERO(String CHIAVE_NUMERO) {
		model.setCHIAVE_NUMERO(CHIAVE_NUMERO);
	}

	/**
	 * Sets the chiave_tipo_registro of this dati specifici invio.
	 *
	 * @param CHIAVE_TIPO_REGISTRO the chiave_tipo_registro of this dati specifici invio
	 */
	@Override
	public void setCHIAVE_TIPO_REGISTRO(String CHIAVE_TIPO_REGISTRO) {
		model.setCHIAVE_TIPO_REGISTRO(CHIAVE_TIPO_REGISTRO);
	}

	/**
	 * Sets the codice_errore of this dati specifici invio.
	 *
	 * @param CODICE_ERRORE the codice_errore of this dati specifici invio
	 */
	@Override
	public void setCODICE_ERRORE(String CODICE_ERRORE) {
		model.setCODICE_ERRORE(CODICE_ERRORE);
	}

	/**
	 * Sets the codice_esito of this dati specifici invio.
	 *
	 * @param CODICE_ESITO the codice_esito of this dati specifici invio
	 */
	@Override
	public void setCODICE_ESITO(String CODICE_ESITO) {
		model.setCODICE_ESITO(CODICE_ESITO);
	}

	/**
	 * Sets the codice_tipo_invio of this dati specifici invio.
	 *
	 * @param CODICE_TIPO_INVIO the codice_tipo_invio of this dati specifici invio
	 */
	@Override
	public void setCODICE_TIPO_INVIO(String CODICE_TIPO_INVIO) {
		model.setCODICE_TIPO_INVIO(CODICE_TIPO_INVIO);
	}

	/**
	 * Sets the company ID of this dati specifici invio.
	 *
	 * @param companyId the company ID of this dati specifici invio
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the compilatore_arpae of this dati specifici invio.
	 *
	 * @param COMPILATORE_ARPAE the compilatore_arpae of this dati specifici invio
	 */
	@Override
	public void setCOMPILATORE_ARPAE(String COMPILATORE_ARPAE) {
		model.setCOMPILATORE_ARPAE(COMPILATORE_ARPAE);
	}

	/**
	 * Sets the compilatore_protezione_civile of this dati specifici invio.
	 *
	 * @param COMPILATORE_PROTEZIONE_CIVILE the compilatore_protezione_civile of this dati specifici invio
	 */
	@Override
	public void setCOMPILATORE_PROTEZIONE_CIVILE(
		String COMPILATORE_PROTEZIONE_CIVILE) {

		model.setCOMPILATORE_PROTEZIONE_CIVILE(COMPILATORE_PROTEZIONE_CIVILE);
	}

	/**
	 * Sets the data_fine_validita of this dati specifici invio.
	 *
	 * @param DATA_FINE_VALIDITA the data_fine_validita of this dati specifici invio
	 */
	@Override
	public void setDATA_FINE_VALIDITA(Date DATA_FINE_VALIDITA) {
		model.setDATA_FINE_VALIDITA(DATA_FINE_VALIDITA);
	}

	/**
	 * Sets the data_firma_arpae of this dati specifici invio.
	 *
	 * @param DATA_FIRMA_ARPAE the data_firma_arpae of this dati specifici invio
	 */
	@Override
	public void setDATA_FIRMA_ARPAE(Date DATA_FIRMA_ARPAE) {
		model.setDATA_FIRMA_ARPAE(DATA_FIRMA_ARPAE);
	}

	/**
	 * Sets the data_firma_protezione_civile of this dati specifici invio.
	 *
	 * @param DATA_FIRMA_PROTEZIONE_CIVILE the data_firma_protezione_civile of this dati specifici invio
	 */
	@Override
	public void setDATA_FIRMA_PROTEZIONE_CIVILE(
		Date DATA_FIRMA_PROTEZIONE_CIVILE) {

		model.setDATA_FIRMA_PROTEZIONE_CIVILE(DATA_FIRMA_PROTEZIONE_CIVILE);
	}

	/**
	 * Sets the data_generazione of this dati specifici invio.
	 *
	 * @param DATA_GENERAZIONE the data_generazione of this dati specifici invio
	 */
	@Override
	public void setDATA_GENERAZIONE(Date DATA_GENERAZIONE) {
		model.setDATA_GENERAZIONE(DATA_GENERAZIONE);
	}

	/**
	 * Sets the data_inizio_validita of this dati specifici invio.
	 *
	 * @param DATA_INIZIO_VALIDITA the data_inizio_validita of this dati specifici invio
	 */
	@Override
	public void setDATA_INIZIO_VALIDITA(Date DATA_INIZIO_VALIDITA) {
		model.setDATA_INIZIO_VALIDITA(DATA_INIZIO_VALIDITA);
	}

	/**
	 * Sets the data_invio of this dati specifici invio.
	 *
	 * @param data_invio the data_invio of this dati specifici invio
	 */
	@Override
	public void setData_invio(Date data_invio) {
		model.setData_invio(data_invio);
	}

	/**
	 * Sets the data_risposta of this dati specifici invio.
	 *
	 * @param data_risposta the data_risposta of this dati specifici invio
	 */
	@Override
	public void setData_risposta(Date data_risposta) {
		model.setData_risposta(data_risposta);
	}

	/**
	 * Sets the data_unita_documentaria of this dati specifici invio.
	 *
	 * @param DATA_UNITA_DOCUMENTARIA the data_unita_documentaria of this dati specifici invio
	 */
	@Override
	public void setDATA_UNITA_DOCUMENTARIA(Date DATA_UNITA_DOCUMENTARIA) {
		model.setDATA_UNITA_DOCUMENTARIA(DATA_UNITA_DOCUMENTARIA);
	}

	/**
	 * Sets the denominazione_applicativo of this dati specifici invio.
	 *
	 * @param DENOMINAZIONE_APPLICATIVO the denominazione_applicativo of this dati specifici invio
	 */
	@Override
	public void setDENOMINAZIONE_APPLICATIVO(String DENOMINAZIONE_APPLICATIVO) {
		model.setDENOMINAZIONE_APPLICATIVO(DENOMINAZIONE_APPLICATIVO);
	}

	/**
	 * Sets the denominazione_sensore_rilevamento of this dati specifici invio.
	 *
	 * @param DENOMINAZIONE_SENSORE_RILEVAMENTO the denominazione_sensore_rilevamento of this dati specifici invio
	 */
	@Override
	public void setDENOMINAZIONE_SENSORE_RILEVAMENTO(
		String DENOMINAZIONE_SENSORE_RILEVAMENTO) {

		model.setDENOMINAZIONE_SENSORE_RILEVAMENTO(
			DENOMINAZIONE_SENSORE_RILEVAMENTO);
	}

	/**
	 * Sets the esito_invio of this dati specifici invio.
	 *
	 * @param ESITO_INVIO the esito_invio of this dati specifici invio
	 */
	@Override
	public void setESITO_INVIO(String ESITO_INVIO) {
		model.setESITO_INVIO(ESITO_INVIO);
	}

	/**
	 * Sets the forza_accettazione of this dati specifici invio.
	 *
	 * @param FORZA_ACCETTAZIONE the forza_accettazione of this dati specifici invio
	 */
	@Override
	public void setFORZA_ACCETTAZIONE(String FORZA_ACCETTAZIONE) {
		model.setFORZA_ACCETTAZIONE(FORZA_ACCETTAZIONE);
	}

	/**
	 * Sets the forza_collegamento of this dati specifici invio.
	 *
	 * @param FORZA_COLLEGAMENTO the forza_collegamento of this dati specifici invio
	 */
	@Override
	public void setFORZA_COLLEGAMENTO(String FORZA_COLLEGAMENTO) {
		model.setFORZA_COLLEGAMENTO(FORZA_COLLEGAMENTO);
	}

	/**
	 * Sets the forza_conservazione of this dati specifici invio.
	 *
	 * @param FORZA_CONSERVAZIONE the forza_conservazione of this dati specifici invio
	 */
	@Override
	public void setFORZA_CONSERVAZIONE(String FORZA_CONSERVAZIONE) {
		model.setFORZA_CONSERVAZIONE(FORZA_CONSERVAZIONE);
	}

	/**
	 * Sets the group ID of this dati specifici invio.
	 *
	 * @param groupId the group ID of this dati specifici invio
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id_documento_principale of this dati specifici invio.
	 *
	 * @param ID_DOCUMENTO_PRINCIPALE the id_documento_principale of this dati specifici invio
	 */
	@Override
	public void setID_DOCUMENTO_PRINCIPALE(long ID_DOCUMENTO_PRINCIPALE) {
		model.setID_DOCUMENTO_PRINCIPALE(ID_DOCUMENTO_PRINCIPALE);
	}

	/**
	 * Sets the id_invio of this dati specifici invio.
	 *
	 * @param ID_INVIO the id_invio of this dati specifici invio
	 */
	@Override
	public void setID_INVIO(long ID_INVIO) {
		model.setID_INVIO(ID_INVIO);
	}

	/**
	 * Sets the identificativo_dato_specifico of this dati specifici invio.
	 *
	 * @param IDENTIFICATIVO_DATO_SPECIFICO the identificativo_dato_specifico of this dati specifici invio
	 */
	@Override
	public void setIDENTIFICATIVO_DATO_SPECIFICO(
		String IDENTIFICATIVO_DATO_SPECIFICO) {

		model.setIDENTIFICATIVO_DATO_SPECIFICO(IDENTIFICATIVO_DATO_SPECIFICO);
	}

	/**
	 * Sets the invio_responsabile_territorio of this dati specifici invio.
	 *
	 * @param INVIO_RESPONSABILE_TERRITORIO the invio_responsabile_territorio of this dati specifici invio
	 */
	@Override
	public void setINVIO_RESPONSABILE_TERRITORIO(
		String INVIO_RESPONSABILE_TERRITORIO) {

		model.setINVIO_RESPONSABILE_TERRITORIO(INVIO_RESPONSABILE_TERRITORIO);
	}

	/**
	 * Sets the mesg_errore of this dati specifici invio.
	 *
	 * @param MESG_ERRORE the mesg_errore of this dati specifici invio
	 */
	@Override
	public void setMESG_ERRORE(String MESG_ERRORE) {
		model.setMESG_ERRORE(MESG_ERRORE);
	}

	/**
	 * Sets the num_notifiche_ricezione of this dati specifici invio.
	 *
	 * @param NUM_NOTIFICHE_RICEZIONE the num_notifiche_ricezione of this dati specifici invio
	 */
	@Override
	public void setNUM_NOTIFICHE_RICEZIONE(int NUM_NOTIFICHE_RICEZIONE) {
		model.setNUM_NOTIFICHE_RICEZIONE(NUM_NOTIFICHE_RICEZIONE);
	}

	/**
	 * Sets the num_sms_generati of this dati specifici invio.
	 *
	 * @param NUM_SMS_GENERATI the num_sms_generati of this dati specifici invio
	 */
	@Override
	public void setNUM_SMS_GENERATI(int NUM_SMS_GENERATI) {
		model.setNUM_SMS_GENERATI(NUM_SMS_GENERATI);
	}

	/**
	 * Sets the num_sms_inviati of this dati specifici invio.
	 *
	 * @param NUM_SMS_INVIATI the num_sms_inviati of this dati specifici invio
	 */
	@Override
	public void setNUM_SMS_INVIATI(int NUM_SMS_INVIATI) {
		model.setNUM_SMS_INVIATI(NUM_SMS_INVIATI);
	}

	/**
	 * Sets the oggetto_mail of this dati specifici invio.
	 *
	 * @param OGGETTO_MAIL the oggetto_mail of this dati specifici invio
	 */
	@Override
	public void setOGGETTO_MAIL(String OGGETTO_MAIL) {
		model.setOGGETTO_MAIL(OGGETTO_MAIL);
	}

	/**
	 * Sets the oggetto_unita_documentaria of this dati specifici invio.
	 *
	 * @param OGGETTO_UNITA_DOCUMENTARIA the oggetto_unita_documentaria of this dati specifici invio
	 */
	@Override
	public void setOGGETTO_UNITA_DOCUMENTARIA(
		String OGGETTO_UNITA_DOCUMENTARIA) {

		model.setOGGETTO_UNITA_DOCUMENTARIA(OGGETTO_UNITA_DOCUMENTARIA);
	}

	/**
	 * Sets the primary key of this dati specifici invio.
	 *
	 * @param primaryKey the primary key of this dati specifici invio
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the regola_allarme_descrizione of this dati specifici invio.
	 *
	 * @param REGOLA_ALLARME_DESCRIZIONE the regola_allarme_descrizione of this dati specifici invio
	 */
	@Override
	public void setREGOLA_ALLARME_DESCRIZIONE(
		String REGOLA_ALLARME_DESCRIZIONE) {

		model.setREGOLA_ALLARME_DESCRIZIONE(REGOLA_ALLARME_DESCRIZIONE);
	}

	/**
	 * Sets the regola_allarme_id of this dati specifici invio.
	 *
	 * @param REGOLA_ALLARME_ID the regola_allarme_id of this dati specifici invio
	 */
	@Override
	public void setREGOLA_ALLARME_ID(String REGOLA_ALLARME_ID) {
		model.setREGOLA_ALLARME_ID(REGOLA_ALLARME_ID);
	}

	/**
	 * Sets the regola_allarme_nome of this dati specifici invio.
	 *
	 * @param REGOLA_ALLARME_NOME the regola_allarme_nome of this dati specifici invio
	 */
	@Override
	public void setREGOLA_ALLARME_NOME(String REGOLA_ALLARME_NOME) {
		model.setREGOLA_ALLARME_NOME(REGOLA_ALLARME_NOME);
	}

	/**
	 * Sets the testo_mail of this dati specifici invio.
	 *
	 * @param TESTO_MAIL the testo_mail of this dati specifici invio
	 */
	@Override
	public void setTESTO_MAIL(String TESTO_MAIL) {
		model.setTESTO_MAIL(TESTO_MAIL);
	}

	/**
	 * Sets the tipo_conservazione of this dati specifici invio.
	 *
	 * @param TIPO_CONSERVAZIONE the tipo_conservazione of this dati specifici invio
	 */
	@Override
	public void setTIPO_CONSERVAZIONE(String TIPO_CONSERVAZIONE) {
		model.setTIPO_CONSERVAZIONE(TIPO_CONSERVAZIONE);
	}

	/**
	 * Sets the tipo_documento of this dati specifici invio.
	 *
	 * @param TIPO_DOCUMENTO the tipo_documento of this dati specifici invio
	 */
	@Override
	public void setTIPO_DOCUMENTO(String TIPO_DOCUMENTO) {
		model.setTIPO_DOCUMENTO(TIPO_DOCUMENTO);
	}

	/**
	 * Sets the tipo_struttura of this dati specifici invio.
	 *
	 * @param TIPO_STRUTTURA the tipo_struttura of this dati specifici invio
	 */
	@Override
	public void setTIPO_STRUTTURA(String TIPO_STRUTTURA) {
		model.setTIPO_STRUTTURA(TIPO_STRUTTURA);
	}

	/**
	 * Sets the tipologia_unita_documentaria of this dati specifici invio.
	 *
	 * @param TIPOLOGIA_UNITA_DOCUMENTARIA the tipologia_unita_documentaria of this dati specifici invio
	 */
	@Override
	public void setTIPOLOGIA_UNITA_DOCUMENTARIA(
		String TIPOLOGIA_UNITA_DOCUMENTARIA) {

		model.setTIPOLOGIA_UNITA_DOCUMENTARIA(TIPOLOGIA_UNITA_DOCUMENTARIA);
	}

	/**
	 * Sets the user ID of this dati specifici invio.
	 *
	 * @param userId the user ID of this dati specifici invio
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this dati specifici invio.
	 *
	 * @param userUuid the user uuid of this dati specifici invio
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the versatore_ente of this dati specifici invio.
	 *
	 * @param VERSATORE_ENTE the versatore_ente of this dati specifici invio
	 */
	@Override
	public void setVERSATORE_ENTE(String VERSATORE_ENTE) {
		model.setVERSATORE_ENTE(VERSATORE_ENTE);
	}

	/**
	 * Sets the versatore_struttura of this dati specifici invio.
	 *
	 * @param VERSATORE_STRUTTURA the versatore_struttura of this dati specifici invio
	 */
	@Override
	public void setVERSATORE_STRUTTURA(String VERSATORE_STRUTTURA) {
		model.setVERSATORE_STRUTTURA(VERSATORE_STRUTTURA);
	}

	/**
	 * Sets the versatore_user_id of this dati specifici invio.
	 *
	 * @param VERSATORE_USER_ID the versatore_user_id of this dati specifici invio
	 */
	@Override
	public void setVERSATORE_USER_ID(String VERSATORE_USER_ID) {
		model.setVERSATORE_USER_ID(VERSATORE_USER_ID);
	}

	/**
	 * Sets the versione of this dati specifici invio.
	 *
	 * @param VERSIONE the versione of this dati specifici invio
	 */
	@Override
	public void setVERSIONE(double VERSIONE) {
		model.setVERSIONE(VERSIONE);
	}

	/**
	 * Sets the versione_dati_specifici of this dati specifici invio.
	 *
	 * @param VERSIONE_DATI_SPECIFICI the versione_dati_specifici of this dati specifici invio
	 */
	@Override
	public void setVERSIONE_DATI_SPECIFICI(double VERSIONE_DATI_SPECIFICI) {
		model.setVERSIONE_DATI_SPECIFICI(VERSIONE_DATI_SPECIFICI);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DatiSpecificiInvioWrapper wrap(
		DatiSpecificiInvio datiSpecificiInvio) {

		return new DatiSpecificiInvioWrapper(datiSpecificiInvio);
	}

}