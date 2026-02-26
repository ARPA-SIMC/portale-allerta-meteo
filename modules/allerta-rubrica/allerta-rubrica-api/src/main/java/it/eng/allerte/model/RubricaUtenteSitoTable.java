/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rubrica_RubricaUtenteSito&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaUtenteSito
 * @generated
 */
public class RubricaUtenteSitoTable extends BaseTable<RubricaUtenteSitoTable> {

	public static final RubricaUtenteSitoTable INSTANCE =
		new RubricaUtenteSitoTable();

	public final Column<RubricaUtenteSitoTable, Long> ID_UTENTE = createColumn(
		"ID_UTENTE", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaUtenteSitoTable, Long> ID_SITO = createColumn(
		"ID_SITO", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private RubricaUtenteSitoTable() {
		super("rubrica_RubricaUtenteSito", RubricaUtenteSitoTable::new);
	}

}