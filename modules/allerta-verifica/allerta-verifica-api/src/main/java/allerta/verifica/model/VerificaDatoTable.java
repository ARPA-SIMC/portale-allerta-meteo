/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.verifica.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;VERIFICA_VerificaDato&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see VerificaDato
 * @generated
 */
public class VerificaDatoTable extends BaseTable<VerificaDatoTable> {

	public static final VerificaDatoTable INSTANCE = new VerificaDatoTable();

	public final Column<VerificaDatoTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<VerificaDatoTable, Long> documento = createColumn(
		"documento", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerificaDatoTable, Date> giorno = createColumn(
		"giorno", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VerificaDatoTable, String> zona = createColumn(
		"zona", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerificaDatoTable, Long> evento = createColumn(
		"evento", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VerificaDatoTable, String> nomeDato = createColumn(
		"nomeDato", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerificaDatoTable, Integer> progressivo = createColumn(
		"progressivo", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<VerificaDatoTable, String> datoInserito = createColumn(
		"datoInserito", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VerificaDatoTable, String> datoCalcolato = createColumn(
		"datoCalcolato", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private VerificaDatoTable() {
		super("VERIFICA_VerificaDato", VerificaDatoTable::new);
	}

}