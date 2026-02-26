/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;parer_DocumentiCollegati&quot; database table.
 *
 * @author Pratola_L
 * @see DocumentiCollegati
 * @generated
 */
public class DocumentiCollegatiTable
	extends BaseTable<DocumentiCollegatiTable> {

	public static final DocumentiCollegatiTable INSTANCE =
		new DocumentiCollegatiTable();

	public final Column<DocumentiCollegatiTable, String> DOC_COLLEGATO_NUMERO =
		createColumn(
			"DOC_COLLEGATO_NUMERO", String.class, Types.VARCHAR,
			Column.FLAG_PRIMARY);

	public final Column<DocumentiCollegatiTable, Integer> DOC_COLLEGATO_ANNO =
		createColumn(
			"DOC_COLLEGATO_ANNO", Integer.class, Types.INTEGER,
			Column.FLAG_PRIMARY);

	public final Column<DocumentiCollegatiTable, String>
		DOC_COLLEGATO_TIPO_REGISTRO = createColumn(
			"DOC_COLLEGATO_TIPO_REGISTRO", String.class, Types.VARCHAR,
			Column.FLAG_PRIMARY);

	public final Column<DocumentiCollegatiTable, String>
		DESCRIZIONE_COLLEGAMENTO = createColumn(
			"DESCRIZIONE_COLLEGAMENTO", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<DocumentiCollegatiTable, Long> ID_INVIO = createColumn(
		"ID_INVIO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private DocumentiCollegatiTable() {
		super("parer_DocumentiCollegati", DocumentiCollegatiTable::new);
	}

}