/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rubrica_RubricaSito&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaSito
 * @generated
 */
public class RubricaSitoTable extends BaseTable<RubricaSitoTable> {

	public static final RubricaSitoTable INSTANCE = new RubricaSitoTable();

	public final Column<RubricaSitoTable, Long> ID_SITO = createColumn(
		"ID_SITO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaSitoTable, String> NOME = createColumn(
		"NOME", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaSitoTable, Long> FK_LIFERAY_SITE = createColumn(
		"FK_LIFERAY_SITE", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private RubricaSitoTable() {
		super("rubrica_RubricaSito", RubricaSitoTable::new);
	}

}