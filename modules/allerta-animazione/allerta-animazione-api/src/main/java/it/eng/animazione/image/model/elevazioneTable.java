/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;img_animazioni_elevazione&quot; database table.
 *
 * @author UTENTE
 * @see elevazione
 * @generated
 */
public class elevazioneTable extends BaseTable<elevazioneTable> {

	public static final elevazioneTable INSTANCE = new elevazioneTable();

	public final Column<elevazioneTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<elevazioneTable, String> im = createColumn(
		"im", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<elevazioneTable, String> text_LOC = createColumn(
		"text_LOC", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<elevazioneTable, Long> ts_UTC = createColumn(
		"timestamp", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<elevazioneTable, String> imgData = createColumn(
		"imgData", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private elevazioneTable() {
		super("img_animazioni_elevazione", elevazioneTable::new);
	}

}