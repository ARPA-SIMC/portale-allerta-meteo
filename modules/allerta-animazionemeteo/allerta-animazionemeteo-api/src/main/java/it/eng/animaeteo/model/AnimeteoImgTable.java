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
 * The table class for the &quot;animeteo_AnimeteoImg&quot; database table.
 *
 * @author UTENTE
 * @see AnimeteoImg
 * @generated
 */
public class AnimeteoImgTable extends BaseTable<AnimeteoImgTable> {

	public static final AnimeteoImgTable INSTANCE = new AnimeteoImgTable();

	public final Column<AnimeteoImgTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AnimeteoImgTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AnimeteoImgTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AnimeteoImgTable, Date> inserted = createColumn(
		"inserted", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AnimeteoImgTable, String> data = createColumn(
		"data_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AnimeteoImgTable() {
		super("animeteo_AnimeteoImg", AnimeteoImgTable::new);
	}

}