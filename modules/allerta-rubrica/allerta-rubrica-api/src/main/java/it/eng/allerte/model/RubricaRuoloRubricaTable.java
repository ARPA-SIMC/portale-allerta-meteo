/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rubrica_RubricaRuoloRubrica&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaRuoloRubrica
 * @generated
 */
public class RubricaRuoloRubricaTable
	extends BaseTable<RubricaRuoloRubricaTable> {

	public static final RubricaRuoloRubricaTable INSTANCE =
		new RubricaRuoloRubricaTable();

	public final Column<RubricaRuoloRubricaTable, Long> ID_RUOLO = createColumn(
		"ID_RUOLO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaRuoloRubricaTable, String> DESCRIZIONE =
		createColumn(
			"DESCRIZIONE", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RubricaRuoloRubricaTable() {
		super("rubrica_RubricaRuoloRubrica", RubricaRuoloRubricaTable::new);
	}

}