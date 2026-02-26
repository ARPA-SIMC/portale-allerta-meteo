/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_RegolaAllarmeComune&quot; database table.
 *
 * @author GFAVINI
 * @see RegolaAllarmeComune
 * @generated
 */
public class RegolaAllarmeComuneTable
	extends BaseTable<RegolaAllarmeComuneTable> {

	public static final RegolaAllarmeComuneTable INSTANCE =
		new RegolaAllarmeComuneTable();

	public final Column<RegolaAllarmeComuneTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeComuneTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RegolaAllarmeComuneTable, Long> idRegola = createColumn(
		"idRegola", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeComuneTable, Long> idComune = createColumn(
		"idComune", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private RegolaAllarmeComuneTable() {
		super("BOLLETTINO_RegolaAllarmeComune", RegolaAllarmeComuneTable::new);
	}

}