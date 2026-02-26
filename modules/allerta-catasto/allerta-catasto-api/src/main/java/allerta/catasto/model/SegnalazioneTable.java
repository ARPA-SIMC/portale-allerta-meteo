/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package allerta.catasto.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;CATASTO_Segnalazione&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Segnalazione
 * @generated
 */
public class SegnalazioneTable extends BaseTable<SegnalazioneTable> {

	public static final SegnalazioneTable INSTANCE = new SegnalazioneTable();

	public final Column<SegnalazioneTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SegnalazioneTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Long> documentoAssociato =
		createColumn(
			"documentoAssociato", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Date> dataEvento = createColumn(
		"dataEvento", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, String> enteSegnalante =
		createColumn(
			"enteSegnalante", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Long> fonte = createColumn(
		"fonte", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Long> categoria = createColumn(
		"categoria", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Long> sottocategoria = createColumn(
		"sottocategoria", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, String> riferimento = createColumn(
		"riferimento", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, String> descrizione = createColumn(
		"descrizione", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, String> note = createColumn(
		"note", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, String> area = createColumn(
		"area", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, String> provincia = createColumn(
		"provincia", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, String> comune = createColumn(
		"comune", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, String> indirizzo = createColumn(
		"indirizzo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, String> civico = createColumn(
		"civico", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Double> lat = createColumn(
		"lat", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Double> lon = createColumn(
		"lon", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Long> effetti = createColumn(
		"effetti", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SegnalazioneTable, Long> effettiSub = createColumn(
		"effettiSub", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private SegnalazioneTable() {
		super("CATASTO_Segnalazione", SegnalazioneTable::new);
	}

}