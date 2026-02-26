/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;BOLLETTINO_StazioneVariabile&quot; database table.
 *
 * @author GFAVINI
 * @see StazioneVariabile
 * @generated
 */
public class StazioneVariabileTable extends BaseTable<StazioneVariabileTable> {

	public static final StazioneVariabileTable INSTANCE =
		new StazioneVariabileTable();

	public final Column<StazioneVariabileTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneVariabileTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<StazioneVariabileTable, String> idStazione =
		createColumn(
			"idStazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneVariabileTable, String> idVariabile =
		createColumn(
			"idVariabile", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneVariabileTable, Date> dataUltimoValore =
		createColumn(
			"dataUltimoValore", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<StazioneVariabileTable, Double> soglia1 = createColumn(
		"soglia1", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<StazioneVariabileTable, Double> soglia2 = createColumn(
		"soglia2", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<StazioneVariabileTable, Double> soglia3 = createColumn(
		"soglia3", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private StazioneVariabileTable() {
		super("BOLLETTINO_StazioneVariabile", StazioneVariabileTable::new);
	}

}