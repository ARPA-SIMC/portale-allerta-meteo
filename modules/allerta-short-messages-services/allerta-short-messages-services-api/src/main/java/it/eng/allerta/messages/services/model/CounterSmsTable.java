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
 * The table class for the &quot;smsService_CounterSms&quot; database table.
 *
 * @author Giorgianni_F
 * @see CounterSms
 * @generated
 */
public class CounterSmsTable extends BaseTable<CounterSmsTable> {

	public static final CounterSmsTable INSTANCE = new CounterSmsTable();

	public final Column<CounterSmsTable, Long> counterId = createColumn(
		"counterId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CounterSmsTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CounterSmsTable, Integer> numerosms = createColumn(
		"numerosms", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CounterSmsTable, String> nodo = createColumn(
		"nodo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CounterSmsTable() {
		super("smsService_CounterSms", CounterSmsTable::new);
	}

}