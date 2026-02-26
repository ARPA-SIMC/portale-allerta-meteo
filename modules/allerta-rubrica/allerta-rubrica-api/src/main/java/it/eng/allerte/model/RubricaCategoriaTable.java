/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rubrica_RubricaCategoria&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaCategoria
 * @generated
 */
public class RubricaCategoriaTable extends BaseTable<RubricaCategoriaTable> {

	public static final RubricaCategoriaTable INSTANCE =
		new RubricaCategoriaTable();

	public final Column<RubricaCategoriaTable, Long> ID_CATEGORIA =
		createColumn(
			"ID_CATEGORIA", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaCategoriaTable, String> DESCRIZIONE =
		createColumn(
			"DESCRIZIONE", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RubricaCategoriaTable() {
		super("rubrica_RubricaCategoria", RubricaCategoriaTable::new);
	}

}