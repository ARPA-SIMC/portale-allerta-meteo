/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_Idrometro&quot; database table.
 *
 * @author GFAVINI
 * @see Idrometro
 * @generated
 */
public class IdrometroTable extends BaseTable<IdrometroTable> {

	public static final IdrometroTable INSTANCE = new IdrometroTable();

	public final Column<IdrometroTable, String> stazioneId = createColumn(
		"stazioneId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<IdrometroTable, String> nomeBacino = createColumn(
		"nomeBacino", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IdrometroTable, String> nomeSottobacino = createColumn(
		"nomeSottobacino", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IdrometroTable, String> nomeRubrica = createColumn(
		"nomeRubrica", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<IdrometroTable, Double> sogliaSpike = createColumn(
		"sogliaSpike", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);

	private IdrometroTable() {
		super("BOLLETTINO_Idrometro", IdrometroTable::new);
	}

}