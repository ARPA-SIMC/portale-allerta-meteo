/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_AttivazioneFiume&quot; database table.
 *
 * @author GFAVINI
 * @see AttivazioneFiume
 * @generated
 */
public class AttivazioneFiumeTable extends BaseTable<AttivazioneFiumeTable> {

	public static final AttivazioneFiumeTable INSTANCE =
		new AttivazioneFiumeTable();

	public final Column<AttivazioneFiumeTable, String> fiumeId = createColumn(
		"fiumeId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<AttivazioneFiumeTable, Boolean> attivo = createColumn(
		"attivo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private AttivazioneFiumeTable() {
		super("BOLLETTINO_AttivazioneFiume", AttivazioneFiumeTable::new);
	}

}