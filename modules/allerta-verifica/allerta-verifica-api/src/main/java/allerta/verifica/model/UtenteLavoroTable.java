/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;VERIFICA_UtenteLavoro&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see UtenteLavoro
 * @generated
 */
public class UtenteLavoroTable extends BaseTable<UtenteLavoroTable> {

	public static final UtenteLavoroTable INSTANCE = new UtenteLavoroTable();

	public final Column<UtenteLavoroTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UtenteLavoroTable, Long> documento = createColumn(
		"documento", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UtenteLavoroTable, String> utente = createColumn(
		"utente", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UtenteLavoroTable, Date> ts = createColumn(
		"ts", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UtenteLavoroTable, String> attivita = createColumn(
		"attivita", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private UtenteLavoroTable() {
		super("VERIFICA_UtenteLavoro", UtenteLavoroTable::new);
	}

}