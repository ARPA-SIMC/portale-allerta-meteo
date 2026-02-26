/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;parer_DatiSpecificiInvio&quot; database table.
 *
 * @author Pratola_L
 * @see DatiSpecificiInvio
 * @generated
 */
public class DatiSpecificiInvioTable
	extends BaseTable<DatiSpecificiInvioTable> {

	public static final DatiSpecificiInvioTable INSTANCE =
		new DatiSpecificiInvioTable();

	public final Column<DatiSpecificiInvioTable, Long> ID_INVIO = createColumn(
		"ID_INVIO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<DatiSpecificiInvioTable, String> AMBIENTE =
		createColumn(
			"AMBIENTE", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Double> VERSIONE =
		createColumn(
			"VERSIONE", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> VERSATORE_ENTE =
		createColumn(
			"VERSATORE_ENTE", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> VERSATORE_USER_ID =
		createColumn(
			"VERSATORE_USER_ID", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> VERSATORE_STRUTTURA =
		createColumn(
			"VERSATORE_STRUTTURA", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> CHIAVE_NUMERO =
		createColumn(
			"CHIAVE_NUMERO", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Long> CHIAVE_ANNO =
		createColumn(
			"CHIAVE_ANNO", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> CHIAVE_TIPO_REGISTRO =
		createColumn(
			"CHIAVE_TIPO_REGISTRO", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String>
		TIPOLOGIA_UNITA_DOCUMENTARIA = createColumn(
			"TIPOLOGIA_UNITA_DOCUMENTARIA", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> TIPO_CONSERVAZIONE =
		createColumn(
			"TIPO_CONSERVAZIONE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> FORZA_ACCETTAZIONE =
		createColumn(
			"FORZA_ACCETTAZIONE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> FORZA_CONSERVAZIONE =
		createColumn(
			"FORZA_CONSERVAZIONE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> FORZA_COLLEGAMENTO =
		createColumn(
			"FORZA_COLLEGAMENTO", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String>
		OGGETTO_UNITA_DOCUMENTARIA = createColumn(
			"OGGETTO_UNITA_DOCUMENTARIA", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Date> DATA_UNITA_DOCUMENTARIA =
		createColumn(
			"DATA_UNITA_DOCUMENTARIA", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Double>
		VERSIONE_DATI_SPECIFICI = createColumn(
			"VERSIONE_DATI_SPECIFICI", Double.class, Types.DOUBLE,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String>
		IDENTIFICATIVO_DATO_SPECIFICO = createColumn(
			"IDENTIFICATIVO_DATO_SPECIFICO", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Date> DATA_GENERAZIONE =
		createColumn(
			"DATA_GENERAZIONE", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Integer> NUM_SMS_GENERATI =
		createColumn(
			"NUM_SMS_GENERATI", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Integer> NUM_SMS_INVIATI =
		createColumn(
			"NUM_SMS_INVIATI", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Integer>
		NUM_NOTIFICHE_RICEZIONE = createColumn(
			"NUM_NOTIFICHE_RICEZIONE", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String>
		DENOMINAZIONE_APPLICATIVO = createColumn(
			"DENOMINAZIONE_APPLICATIVO", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> OGGETTO_MAIL =
		createColumn(
			"OGGETTO_MAIL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> TESTO_MAIL =
		createColumn(
			"TESTO_MAIL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> COMPILATORE_ARPAE =
		createColumn(
			"COMPILATORE_ARPAE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String>
		COMPILATORE_PROTEZIONE_CIVILE = createColumn(
			"COMPILATORE_PROTEZIONE_CIVILE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Date> DATA_INIZIO_VALIDITA =
		createColumn(
			"DATA_INIZIO_VALIDITA", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Date> DATA_FINE_VALIDITA =
		createColumn(
			"DATA_FINE_VALIDITA", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> APPROVATORE_ARPAE =
		createColumn(
			"APPROVATORE_ARPAE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Date> DATA_FIRMA_ARPAE =
		createColumn(
			"DATA_FIRMA_ARPAE", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String>
		APPROVATORE_PROTEZIONE_CIVILE = createColumn(
			"APPROVATORE_PROTEZIONE_CIVILE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Date>
		DATA_FIRMA_PROTEZIONE_CIVILE = createColumn(
			"DATA_FIRMA_PROTEZIONE_CIVILE", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String>
		INVIO_RESPONSABILE_TERRITORIO = createColumn(
			"INVIO_RESPONSABILE_TERRITORIO", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Long> ID_DOCUMENTO_PRINCIPALE =
		createColumn(
			"ID_DOCUMENTO_PRINCIPALE", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> TIPO_DOCUMENTO =
		createColumn(
			"TIPO_DOCUMENTO", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> TIPO_STRUTTURA =
		createColumn(
			"TIPO_STRUTTURA", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String>
		DENOMINAZIONE_SENSORE_RILEVAMENTO = createColumn(
			"DENOMINAZIONE_SENSORE_RILEVAMENTO", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> REGOLA_ALLARME_ID =
		createColumn(
			"REGOLA_ALLARME_ID", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> REGOLA_ALLARME_NOME =
		createColumn(
			"REGOLA_ALLARME_NOME", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String>
		REGOLA_ALLARME_DESCRIZIONE = createColumn(
			"REGOLA_ALLARME_DESCRIZIONE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> ESITO_INVIO =
		createColumn(
			"ESITO_INVIO", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DatiSpecificiInvioTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DatiSpecificiInvioTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DatiSpecificiInvioTable, Date> data_invio =
		createColumn(
			"data_invio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DatiSpecificiInvioTable, Date> data_risposta =
		createColumn(
			"data_risposta", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> CODICE_ESITO =
		createColumn(
			"CODICE_ESITO", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> CODICE_ERRORE =
		createColumn(
			"CODICE_ERRORE", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> MESG_ERRORE =
		createColumn(
			"MESG_ERRORE", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<DatiSpecificiInvioTable, String> CODICE_TIPO_INVIO =
		createColumn(
			"CODICE_TIPO_INVIO", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private DatiSpecificiInvioTable() {
		super("parer_DatiSpecificiInvio", DatiSpecificiInvioTable::new);
	}

}