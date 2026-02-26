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
 * The table class for the &quot;smsService_Nodo&quot; database table.
 *
 * @author Giorgianni_F
 * @see Nodo
 * @generated
 */
public class NodoTable extends BaseTable<NodoTable> {

	public static final NodoTable INSTANCE = new NodoTable();

	public final Column<NodoTable, Long> Id = createColumn(
		"Id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<NodoTable, String> ip = createColumn(
		"ip", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NodoTable, Integer> porta = createColumn(
		"porta", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<NodoTable, String> nodoConnesso = createColumn(
		"nodoConnesso", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NodoTable, Date> dataConnessione = createColumn(
		"dataConnessione", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private NodoTable() {
		super("smsService_Nodo", NodoTable::new);
	}

}