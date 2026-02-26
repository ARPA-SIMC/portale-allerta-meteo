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
 * The table class for the &quot;ALLERTER_Email&quot; database table.
 *
 * @author GFAVINI
 * @see Email
 * @generated
 */
public class EmailTable extends BaseTable<EmailTable> {

	public static final EmailTable INSTANCE = new EmailTable();

	public final Column<EmailTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EmailTable, String> tipo = createColumn(
		"tipo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmailTable, String> sottotipo = createColumn(
		"sottotipo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmailTable, Long> param = createColumn(
		"param", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmailTable, Long> destinatario = createColumn(
		"destinatario", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmailTable, String> indirizzo = createColumn(
		"indirizzo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmailTable, String> nomeDestinatario = createColumn(
		"nomeDestinatario", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmailTable, Long> stato = createColumn(
		"stato", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EmailTable, Date> dataInvio = createColumn(
		"dataInvio", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EmailTable, String> testo = createColumn(
		"testo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EmailTable, String> oggetto = createColumn(
		"oggetto", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EmailTable() {
		super("ALLERTER_Email", EmailTable::new);
	}

}