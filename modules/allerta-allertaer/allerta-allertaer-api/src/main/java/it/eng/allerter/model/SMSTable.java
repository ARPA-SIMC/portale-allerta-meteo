/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;ALLERTER_SMS&quot; database table.
 *
 * @author GFAVINI
 * @see SMS
 * @generated
 */
public class SMSTable extends BaseTable<SMSTable> {

	public static final SMSTable INSTANCE = new SMSTable();

	public final Column<SMSTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SMSTable, String> tipo = createColumn(
		"tipo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SMSTable, String> sottotipo = createColumn(
		"sottotipo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SMSTable, Long> param = createColumn(
		"param", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SMSTable, String> testo = createColumn(
		"testo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SMSTable, Long> destinatario = createColumn(
		"destinatario", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SMSTable, String> numeroDa = createColumn(
		"numeroDa", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SMSTable, String> numero = createColumn(
		"numero", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SMSTable, String> nomeDestinatario = createColumn(
		"nomeDestinatario", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SMSTable, Long> stato = createColumn(
		"stato", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SMSTable, Date> dataInvio = createColumn(
		"dataInvio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SMSTable, Date> dataAck = createColumn(
		"dataAck", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SMSTable, Date> dataRicevuta = createColumn(
		"dataRicevuta", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SMSTable, Long> tentativi = createColumn(
		"tentativi", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SMSTable, Date> prossimoInvio = createColumn(
		"prossimoInvio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SMSTable, String> codiceErrore = createColumn(
		"codiceErrore", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SMSTable, String> descrizioneErrore = createColumn(
		"descrizioneErrore", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SMSTable, String> timestamp = createColumn(
		"timestamp", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private SMSTable() {
		super("ALLERTER_SMS", SMSTable::new);
	}

}