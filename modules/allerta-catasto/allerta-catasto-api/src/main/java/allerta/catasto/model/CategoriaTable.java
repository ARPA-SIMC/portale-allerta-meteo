/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;CATASTO_Categoria&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Categoria
 * @generated
 */
public class CategoriaTable extends BaseTable<CategoriaTable> {

	public static final CategoriaTable INSTANCE = new CategoriaTable();

	public final Column<CategoriaTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CategoriaTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CategoriaTable() {
		super("CATASTO_Categoria", CategoriaTable::new);
	}

}