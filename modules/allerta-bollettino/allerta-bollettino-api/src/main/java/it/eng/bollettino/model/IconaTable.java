/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_Icona&quot; database table.
 *
 * @author GFAVINI
 * @see Icona
 * @generated
 */
public class IconaTable extends BaseTable<IconaTable> {

	public static final IconaTable INSTANCE = new IconaTable();

	public final Column<IconaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IconaTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<IconaTable, String> path = createColumn(
		"path_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IconaTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private IconaTable() {
		super("BOLLETTINO_Icona", IconaTable::new);
	}

}