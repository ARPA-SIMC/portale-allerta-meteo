/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;parer_ComponentiInvio&quot; database table.
 *
 * @author Pratola_L
 * @see ComponentiInvio
 * @generated
 */
public class ComponentiInvioTable extends BaseTable<ComponentiInvioTable> {

	public static final ComponentiInvioTable INSTANCE =
		new ComponentiInvioTable();

	public final Column<ComponentiInvioTable, Long> ID_INVIO = createColumn(
		"ID_INVIO", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<ComponentiInvioTable, Long> ID_COMPONENTE =
		createColumn(
			"ID_COMPONENTE", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	public final Column<ComponentiInvioTable, Long> ORDINE_PRESENTAZIONE =
		createColumn(
			"ORDINE_PRESENTAZIONE", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	public final Column<ComponentiInvioTable, String> TIPO_COMPONENTE =
		createColumn(
			"TIPO_COMPONENTE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<ComponentiInvioTable, String> TIPO_SUPPORTO_COMPONENTE =
		createColumn(
			"TIPO_SUPPORTO_COMPONENTE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<ComponentiInvioTable, String> NOME_COMPONENTE =
		createColumn(
			"NOME_COMPONENTE", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<ComponentiInvioTable, String> FORMATO_FILE_VERSATO =
		createColumn(
			"FORMATO_FILE_VERSATO", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	public final Column<ComponentiInvioTable, String> HASH_VERSATO =
		createColumn(
			"HASH_VERSATO", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<ComponentiInvioTable, String> URN_VERSATO =
		createColumn(
			"URN_VERSATO", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<ComponentiInvioTable, Long> ID_COMPONENTE_VERSATO =
		createColumn(
			"ID_COMPONENTE_VERSATO", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	private ComponentiInvioTable() {
		super("parer_ComponentiInvio", ComponentiInvioTable::new);
	}

}