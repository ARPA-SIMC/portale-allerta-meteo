/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;CATASTO_Sottocategoria&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Sottocategoria
 * @generated
 */
public class SottocategoriaTable extends BaseTable<SottocategoriaTable> {

	public static final SottocategoriaTable INSTANCE =
		new SottocategoriaTable();

	public final Column<SottocategoriaTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SottocategoriaTable, Long> idCategoria = createColumn(
		"idCategoria", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SottocategoriaTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private SottocategoriaTable() {
		super("CATASTO_Sottocategoria", SottocategoriaTable::new);
	}

}