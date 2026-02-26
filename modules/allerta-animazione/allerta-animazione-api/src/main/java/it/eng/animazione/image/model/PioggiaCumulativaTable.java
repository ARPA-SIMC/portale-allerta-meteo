/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;img_animazioni_PioggiaCumulativa&quot; database table.
 *
 * @author UTENTE
 * @see PioggiaCumulativa
 * @generated
 */
public class PioggiaCumulativaTable extends BaseTable<PioggiaCumulativaTable> {

	public static final PioggiaCumulativaTable INSTANCE =
		new PioggiaCumulativaTable();

	public final Column<PioggiaCumulativaTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PioggiaCumulativaTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PioggiaCumulativaTable, String> cumulazione =
		createColumn(
			"cumulazione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PioggiaCumulativaTable, Date> inzioCumulazione =
		createColumn(
			"inzioCumulazione", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<PioggiaCumulativaTable, Date> fineCumulazione =
		createColumn(
			"fineCumulazione", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<PioggiaCumulativaTable, String> imgData = createColumn(
		"imgData", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PioggiaCumulativaTable() {
		super("img_animazioni_PioggiaCumulativa", PioggiaCumulativaTable::new);
	}

}