/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;prev_meteo_Img&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Img
 * @generated
 */
public class ImgTable extends BaseTable<ImgTable> {

	public static final ImgTable INSTANCE = new ImgTable();

	public final Column<ImgTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ImgTable, String> daypart = createColumn(
		"daypart", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImgTable, String> day = createColumn(
		"day", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImgTable, String> provincia = createColumn(
		"provincia", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImgTable, Date> inserted = createColumn(
		"inserted", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ImgTable, String> data = createColumn(
		"data_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ImgTable() {
		super("prev_meteo_Img", ImgTable::new);
	}

}