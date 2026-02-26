/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_RegolaAllarmeCondizione&quot; database table.
 *
 * @author GFAVINI
 * @see RegolaAllarmeCondizione
 * @generated
 */
public class RegolaAllarmeCondizioneTable
	extends BaseTable<RegolaAllarmeCondizioneTable> {

	public static final RegolaAllarmeCondizioneTable INSTANCE =
		new RegolaAllarmeCondizioneTable();

	public final Column<RegolaAllarmeCondizioneTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeCondizioneTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RegolaAllarmeCondizioneTable, Long> idRegola =
		createColumn("idRegola", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeCondizioneTable, String> lettera =
		createColumn(
			"lettera", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeCondizioneTable, String> idVariabile =
		createColumn(
			"idVariabile", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeCondizioneTable, String> idStazione =
		createColumn(
			"idStazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeCondizioneTable, Long>
		idStazioneVariabile = createColumn(
			"idStazioneVariabile", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeCondizioneTable, Integer> soglia =
		createColumn(
			"soglia", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<RegolaAllarmeCondizioneTable, Double> valoreSoglia =
		createColumn(
			"valoreSoglia", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private RegolaAllarmeCondizioneTable() {
		super(
			"BOLLETTINO_RegolaAllarmeCondizione",
			RegolaAllarmeCondizioneTable::new);
	}

}