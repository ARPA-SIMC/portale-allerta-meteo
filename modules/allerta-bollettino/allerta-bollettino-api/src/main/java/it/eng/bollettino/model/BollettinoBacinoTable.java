/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_BollettinoBacino&quot; database table.
 *
 * @author GFAVINI
 * @see BollettinoBacino
 * @generated
 */
public class BollettinoBacinoTable extends BaseTable<BollettinoBacinoTable> {

	public static final BollettinoBacinoTable INSTANCE =
		new BollettinoBacinoTable();

	public final Column<BollettinoBacinoTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoBacinoTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BollettinoBacinoTable, Long> idBollettino =
		createColumn(
			"idBollettino", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BollettinoBacinoTable, Integer> progressivo =
		createColumn(
			"progressivo", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BollettinoBacinoTable, String> idBacino = createColumn(
		"idBacino", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoBacinoTable, String> nomeBacino =
		createColumn(
			"nomeBacino", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoBacinoTable, String> oreOsservazione =
		createColumn(
			"oreOsservazione", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BollettinoBacinoTable, String> note = createColumn(
		"note", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private BollettinoBacinoTable() {
		super("BOLLETTINO_BollettinoBacino", BollettinoBacinoTable::new);
	}

}