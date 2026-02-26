/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.dewetra.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;DEWETRA_HRW&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see HRW
 * @generated
 */
public class HRWTable extends BaseTable<HRWTable> {

	public static final HRWTable INSTANCE = new HRWTable();

	public final Column<HRWTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<HRWTable, String> comune = createColumn(
		"comune", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HRWTable, Date> timestamp = createColumn(
		"timestamp", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> HRI = createColumn(
		"HRI", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> SSI = createColumn(
		"SSI", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> SRI = createColumn(
		"SRI", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> VMI = createColumn(
		"VMI", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> VIL = createColumn(
		"VIL", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> POH = createColumn(
		"POH", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> ETM = createColumn(
		"ETM", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> TOP = createColumn(
		"TOP", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> LGT = createColumn(
		"LGT", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> Pers = createColumn(
		"Pers", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> SRT = createColumn(
		"SRT", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> SRT_3 = createColumn(
		"SRT_3", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> SRT_6 = createColumn(
		"SRT_6", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	public final Column<HRWTable, Double> Vel = createColumn(
		"Vel", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<HRWTable, Double> Dir = createColumn(
		"Dir", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private HRWTable() {
		super("DEWETRA_HRW", HRWTable::new);
	}

}