/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;ALLERTER_Feed&quot; database table.
 *
 * @author GFAVINI
 * @see Feed
 * @generated
 */
public class FeedTable extends BaseTable<FeedTable> {

	public static final FeedTable INSTANCE = new FeedTable();

	public final Column<FeedTable, String> feedId = createColumn(
		"feedId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<FeedTable, String> titolo = createColumn(
		"titolo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FeedTable, String> link = createColumn(
		"link", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FeedTable, String> autore = createColumn(
		"autore", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FeedTable, String> query = createColumn(
		"query", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FeedTable() {
		super("ALLERTER_Feed", FeedTable::new);
	}

}