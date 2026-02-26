/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rubrica_RubricaRuolo&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaRuolo
 * @generated
 */
public class RubricaRuoloTable extends BaseTable<RubricaRuoloTable> {

	public static final RubricaRuoloTable INSTANCE = new RubricaRuoloTable();

	public final Column<RubricaRuoloTable, Long> ID_RUOLO = createColumn(
		"ID_RUOLO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaRuoloTable, String> DESCRIZIONE = createColumn(
		"DESCRIZIONE", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<RubricaRuoloTable, Long> FK_RUOLO_LIFERAY =
		createColumn(
			"FK_RUOLO_LIFERAY", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private RubricaRuoloTable() {
		super("rubrica_RubricaRuolo", RubricaRuoloTable::new);
	}

}