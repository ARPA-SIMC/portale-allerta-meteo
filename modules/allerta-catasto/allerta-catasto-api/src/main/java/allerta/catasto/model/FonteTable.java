/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;CATASTO_Fonte&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Fonte
 * @generated
 */
public class FonteTable extends BaseTable<FonteTable> {

	public static final FonteTable INSTANCE = new FonteTable();

	public final Column<FonteTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FonteTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FonteTable() {
		super("CATASTO_Fonte", FonteTable::new);
	}

}