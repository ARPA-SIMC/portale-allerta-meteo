/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;prev_meteo_Bollettino&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Bollettino
 * @generated
 */
public class BollettinoTable extends BaseTable<BollettinoTable> {

	public static final BollettinoTable INSTANCE = new BollettinoTable();

	public final Column<BollettinoTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BollettinoTable, String> tipo = createColumn(
		"tipo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, Long> timestamp = createColumn(
		"timestamp", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, String> emissione = createColumn(
		"emissione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, String> validita = createColumn(
		"validita", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, String> xml_content = createColumn(
		"xml_content", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BollettinoTable, String> json = createColumn(
		"json", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private BollettinoTable() {
		super("prev_meteo_Bollettino", BollettinoTable::new);
	}

}