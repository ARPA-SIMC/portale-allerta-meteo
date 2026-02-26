/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rubrica_RubricaRuoloPermessi&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessi
 * @generated
 */
public class RubricaRuoloPermessiTable
	extends BaseTable<RubricaRuoloPermessiTable> {

	public static final RubricaRuoloPermessiTable INSTANCE =
		new RubricaRuoloPermessiTable();

	public final Column<RubricaRuoloPermessiTable, Long> FK_ID_RUOLO =
		createColumn(
			"FK_ID_RUOLO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaRuoloPermessiTable, String> FK_ID_PERMESSO =
		createColumn(
			"FK_ID_PERMESSO", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);

	private RubricaRuoloPermessiTable() {
		super("rubrica_RubricaRuoloPermessi", RubricaRuoloPermessiTable::new);
	}

}