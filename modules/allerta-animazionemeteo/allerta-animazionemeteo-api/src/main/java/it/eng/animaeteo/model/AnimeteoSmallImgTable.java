/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animaeteo.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;animeteo_AnimeteoSmallImg&quot; database table.
 *
 * @author UTENTE
 * @see AnimeteoSmallImg
 * @generated
 */
public class AnimeteoSmallImgTable extends BaseTable<AnimeteoSmallImgTable> {

	public static final AnimeteoSmallImgTable INSTANCE =
		new AnimeteoSmallImgTable();

	public final Column<AnimeteoSmallImgTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AnimeteoSmallImgTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AnimeteoSmallImgTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AnimeteoSmallImgTable, Date> inserted = createColumn(
		"inserted", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AnimeteoSmallImgTable, String> data = createColumn(
		"data_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AnimeteoSmallImgTable() {
		super("animeteo_AnimeteoSmallImg", AnimeteoSmallImgTable::new);
	}

}