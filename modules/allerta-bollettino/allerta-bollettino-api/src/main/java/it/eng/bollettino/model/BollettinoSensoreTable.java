/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_BollettinoSensore&quot; database table.
 *
 * @author GFAVINI
 * @see BollettinoSensore
 * @generated
 */
public class BollettinoSensoreTable extends BaseTable<BollettinoSensoreTable> {

	public static final BollettinoSensoreTable INSTANCE =
		new BollettinoSensoreTable();

	public final Column<BollettinoSensoreTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BollettinoSensoreTable, Long> idBollettino =
		createColumn(
			"idBollettino", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, Long> idStazione = createColumn(
		"idStazione", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, Long> idBollettinoBacino =
		createColumn(
			"idBollettinoBacino", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, Integer> progressivo =
		createColumn(
			"progressivo", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, String> nomeStazione =
		createColumn(
			"nomeStazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, String> oreOsservazione =
		createColumn(
			"oreOsservazione", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, Double> osservazione =
		createColumn(
			"osservazione", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, Integer> tendenza =
		createColumn(
			"tendenza", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, String> colmoPrevisto =
		createColumn(
			"colmoPrevisto", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, String> oraPrevista =
		createColumn(
			"oraPrevista", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, Double> soglia1 = createColumn(
		"soglia1", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, Double> soglia2 = createColumn(
		"soglia2", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, Double> soglia3 = createColumn(
		"soglia3", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, String> giornoPrevisto =
		createColumn(
			"giornoPrevisto", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoSensoreTable, Boolean> osservato =
		createColumn(
			"osservato", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private BollettinoSensoreTable() {
		super("BOLLETTINO_BollettinoSensore", BollettinoSensoreTable::new);
	}

}