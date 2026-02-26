/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.cache.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;CACHE_Dati&quot; database table.
 *
 * @author GFAVINI
 * @see Dati
 * @generated
 */
public class DatiTable extends BaseTable<DatiTable> {

	public static final DatiTable INSTANCE = new DatiTable();

	public final Column<DatiTable, String> idDati = createColumn(
		"idDati", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<DatiTable, String> dato = createColumn(
		"dato", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DatiTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DatiTable() {
		super("CACHE_Dati", DatiTable::new);
	}

}