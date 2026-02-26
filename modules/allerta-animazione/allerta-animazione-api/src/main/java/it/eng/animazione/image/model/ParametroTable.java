/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.animazione.image.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;img_animazioni_Parametro&quot; database table.
 *
 * @author UTENTE
 * @see Parametro
 * @generated
 */
public class ParametroTable extends BaseTable<ParametroTable> {

	public static final ParametroTable INSTANCE = new ParametroTable();

	public final Column<ParametroTable, String> key = createColumn(
		"key_", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<ParametroTable, String> value = createColumn(
		"value", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ParametroTable() {
		super("img_animazioni_Parametro", ParametroTable::new);
	}

}