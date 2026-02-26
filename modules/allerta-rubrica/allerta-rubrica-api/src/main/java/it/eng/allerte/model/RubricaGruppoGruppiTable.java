/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rubrica_RubricaGruppoGruppi&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaGruppoGruppi
 * @generated
 */
public class RubricaGruppoGruppiTable
	extends BaseTable<RubricaGruppoGruppiTable> {

	public static final RubricaGruppoGruppiTable INSTANCE =
		new RubricaGruppoGruppiTable();

	public final Column<RubricaGruppoGruppiTable, Long> FK_GRUPPO_PADRE =
		createColumn(
			"FK_GRUPPO_PADRE", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaGruppoGruppiTable, Long> FK_GRUPPO_FIGLIO =
		createColumn(
			"FK_GRUPPO_FIGLIO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private RubricaGruppoGruppiTable() {
		super("rubrica_RubricaGruppoGruppi", RubricaGruppoGruppiTable::new);
	}

}