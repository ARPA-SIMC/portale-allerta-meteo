/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;smsService_SmsSchedulerContext&quot; database table.
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContext
 * @generated
 */
public class SmsSchedulerContextTable
	extends BaseTable<SmsSchedulerContextTable> {

	public static final SmsSchedulerContextTable INSTANCE =
		new SmsSchedulerContextTable();

	public final Column<SmsSchedulerContextTable, String> varId = createColumn(
		"varId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<SmsSchedulerContextTable, String> value = createColumn(
		"value", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private SmsSchedulerContextTable() {
		super("smsService_SmsSchedulerContext", SmsSchedulerContextTable::new);
	}

}