/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_Bacino&quot; database table.
 *
 * @author GFAVINI
 * @see Bacino
 * @generated
 */
public class BacinoTable extends BaseTable<BacinoTable> {

	public static final BacinoTable INSTANCE = new BacinoTable();

	public final Column<BacinoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BacinoTable, String> id = createColumn(
		"id_", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<BacinoTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BacinoTable, Integer> progressivo = createColumn(
		"progressivo", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private BacinoTable() {
		super("BOLLETTINO_Bacino", BacinoTable::new);
	}

}