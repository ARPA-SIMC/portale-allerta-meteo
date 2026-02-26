/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;img_animazioni_altezzaOndaAdriac&quot; database table.
 *
 * @author UTENTE
 * @see altezzaOndaAdriac
 * @generated
 */
public class altezzaOndaAdriacTable extends BaseTable<altezzaOndaAdriacTable> {

	public static final altezzaOndaAdriacTable INSTANCE =
		new altezzaOndaAdriacTable();

	public final Column<altezzaOndaAdriacTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<altezzaOndaAdriacTable, String> im = createColumn(
		"im", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<altezzaOndaAdriacTable, String> text_LOC = createColumn(
		"text_LOC", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<altezzaOndaAdriacTable, Long> ts_UTC = createColumn(
		"timestamp", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<altezzaOndaAdriacTable, String> imgData = createColumn(
		"imgData", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private altezzaOndaAdriacTable() {
		super("img_animazioni_altezzaOndaAdriac", altezzaOndaAdriacTable::new);
	}

}