/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_Pluviometro&quot; database table.
 *
 * @author GFAVINI
 * @see Pluviometro
 * @generated
 */
public class PluviometroTable extends BaseTable<PluviometroTable> {

	public static final PluviometroTable INSTANCE = new PluviometroTable();

	public final Column<PluviometroTable, String> stazioneId = createColumn(
		"stazioneId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<PluviometroTable, String> nomeGruppo = createColumn(
		"nomeGruppo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PluviometroTable, String> nomeRubrica = createColumn(
		"nomeRubrica", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PluviometroTable() {
		super("BOLLETTINO_Pluviometro", PluviometroTable::new);
	}

}