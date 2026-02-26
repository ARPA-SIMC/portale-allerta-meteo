/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_BollettinoIcona&quot; database table.
 *
 * @author GFAVINI
 * @see BollettinoIcona
 * @generated
 */
public class BollettinoIconaTable extends BaseTable<BollettinoIconaTable> {

	public static final BollettinoIconaTable INSTANCE =
		new BollettinoIconaTable();

	public final Column<BollettinoIconaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoIconaTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BollettinoIconaTable, Long> idBollettino = createColumn(
		"idBollettino", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BollettinoIconaTable, Long> idIcona = createColumn(
		"idIcona", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BollettinoIconaTable, Double> x = createColumn(
		"x", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<BollettinoIconaTable, Double> y = createColumn(
		"y", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private BollettinoIconaTable() {
		super("BOLLETTINO_BollettinoIcona", BollettinoIconaTable::new);
	}

}