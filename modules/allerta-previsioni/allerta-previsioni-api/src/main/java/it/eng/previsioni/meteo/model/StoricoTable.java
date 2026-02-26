/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.previsioni.meteo.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;prev_meteo_Storico&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Storico
 * @generated
 */
public class StoricoTable extends BaseTable<StoricoTable> {

	public static final StoricoTable INSTANCE = new StoricoTable();

	public final Column<StoricoTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<StoricoTable, Integer> idZona = createColumn(
		"idZona", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<StoricoTable, String> nome = createColumn(
		"nome", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StoricoTable, String> sigla = createColumn(
		"sigla", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StoricoTable, String> tipo = createColumn(
		"tipo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StoricoTable, String> xml = createColumn(
		"xml", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private StoricoTable() {
		super("prev_meteo_Storico", StoricoTable::new);
	}

}