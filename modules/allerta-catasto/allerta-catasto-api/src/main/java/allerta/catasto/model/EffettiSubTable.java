/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;CATASTO_EffettiSub&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see EffettiSub
 * @generated
 */
public class EffettiSubTable extends BaseTable<EffettiSubTable> {

	public static final EffettiSubTable INSTANCE = new EffettiSubTable();

	public final Column<EffettiSubTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EffettiSubTable, Long> idEffetti = createColumn(
		"idEffetti", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EffettiSubTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EffettiSubTable() {
		super("CATASTO_EffettiSub", EffettiSubTable::new);
	}

}