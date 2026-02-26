/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;rubrica_RubricaGruppoNominativi&quot; database table.
 *
 * @author Pratola_L
 * @see RubricaGruppoNominativi
 * @generated
 */
public class RubricaGruppoNominativiTable
	extends BaseTable<RubricaGruppoNominativiTable> {

	public static final RubricaGruppoNominativiTable INSTANCE =
		new RubricaGruppoNominativiTable();

	public final Column<RubricaGruppoNominativiTable, Long> FK_GRUPPO =
		createColumn(
			"FK_GRUPPO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaGruppoNominativiTable, Long> FK_NOMINATIVO =
		createColumn(
			"FK_NOMINATIVO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<RubricaGruppoNominativiTable, Long> FK_RUOLO =
		createColumn("FK_RUOLO", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	public final Column<RubricaGruppoNominativiTable, String> SPECIFICA_RUOLO =
		createColumn(
			"SPECIFICA_RUOLO", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private RubricaGruppoNominativiTable() {
		super(
			"rubrica_RubricaGruppoNominativi",
			RubricaGruppoNominativiTable::new);
	}

}