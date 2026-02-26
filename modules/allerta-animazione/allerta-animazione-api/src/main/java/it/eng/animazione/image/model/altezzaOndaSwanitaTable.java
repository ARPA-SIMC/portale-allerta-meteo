/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;img_animazioni_altezzaOndaSwanita&quot; database table.
 *
 * @author UTENTE
 * @see altezzaOndaSwanita
 * @generated
 */
public class altezzaOndaSwanitaTable
	extends BaseTable<altezzaOndaSwanitaTable> {

	public static final altezzaOndaSwanitaTable INSTANCE =
		new altezzaOndaSwanitaTable();

	public final Column<altezzaOndaSwanitaTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<altezzaOndaSwanitaTable, String> im = createColumn(
		"im", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<altezzaOndaSwanitaTable, String> text_LOC =
		createColumn(
			"text_LOC", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<altezzaOndaSwanitaTable, Long> ts_UTC = createColumn(
		"timestamp", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<altezzaOndaSwanitaTable, String> imgData = createColumn(
		"imgData", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private altezzaOndaSwanitaTable() {
		super(
			"img_animazioni_altezzaOndaSwanita", altezzaOndaSwanitaTable::new);
	}

}