/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerta.messages.services.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;smsService_Auth&quot; database table.
 *
 * @author Giorgianni_F
 * @see Auth
 * @generated
 */
public class AuthTable extends BaseTable<AuthTable> {

	public static final AuthTable INSTANCE = new AuthTable();

	public final Column<AuthTable, String> key = createColumn(
		"key_", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<AuthTable, String> value = createColumn(
		"value", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AuthTable() {
		super("smsService_Auth", AuthTable::new);
	}

}