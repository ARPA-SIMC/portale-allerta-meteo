/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.radarMeteo.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rt_portlet_img&quot; database table.
 *
 * @author Francesco
 * @see Img
 * @generated
 */
public class ImgTable extends BaseTable<ImgTable> {

	public static final ImgTable INSTANCE = new ImgTable();

	public final Column<ImgTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ImgTable, String> coord = createColumn(
		"coord", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImgTable, String> palette = createColumn(
		"palette", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImgTable, Long> timestamp = createColumn(
		"timestamp", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ImgTable, String> data = createColumn(
		"data_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ImgTable() {
		super("rt_portlet_img", ImgTable::new);
	}

}