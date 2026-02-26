/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;parer_Parametri&quot; database table.
 *
 * @author Pratola_L
 * @see Parametri
 * @generated
 */
public class ParametriTable extends BaseTable<ParametriTable> {

	public static final ParametriTable INSTANCE = new ParametriTable();

	public final Column<ParametriTable, String> chiave = createColumn(
		"chiave", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<ParametriTable, String> valore = createColumn(
		"valore", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ParametriTable() {
		super("parer_Parametri", ParametriTable::new);
	}

}