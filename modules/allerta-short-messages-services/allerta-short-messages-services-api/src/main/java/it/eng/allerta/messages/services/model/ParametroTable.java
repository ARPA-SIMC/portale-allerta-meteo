/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;smsService_Parametro&quot; database table.
 *
 * @author Giorgianni_F
 * @see Parametro
 * @generated
 */
public class ParametroTable extends BaseTable<ParametroTable> {

	public static final ParametroTable INSTANCE = new ParametroTable();

	public final Column<ParametroTable, Long> Id = createColumn(
		"Id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ParametroTable, String> ip = createColumn(
		"ip", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParametroTable, Integer> porta = createColumn(
		"porta", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ParametroTable, String> username = createColumn(
		"username", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParametroTable, String> password = createColumn(
		"password_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParametroTable, String> mittente = createColumn(
		"mittente", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParametroTable, String> nodo = createColumn(
		"nodo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParametroTable, Date> dataConnessione = createColumn(
		"dataConnessione", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ParametroTable() {
		super("smsService_Parametro", ParametroTable::new);
	}

}