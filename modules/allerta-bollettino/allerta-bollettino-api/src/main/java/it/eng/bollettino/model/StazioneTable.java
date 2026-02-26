/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;BOLLETTINO_Stazione&quot; database table.
 *
 * @author GFAVINI
 * @see Stazione
 * @generated
 */
public class StazioneTable extends BaseTable<StazioneTable> {

	public static final StazioneTable INSTANCE = new StazioneTable();

	public final Column<StazioneTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> id = createColumn(
		"id_", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<StazioneTable, String> ident = createColumn(
		"ident", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, Long> lon = createColumn(
		"lon", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, Long> lat = createColumn(
		"lat", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, Double> height = createColumn(
		"height", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> idBasin = createColumn(
		"idBasin", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> idSubbasin = createColumn(
		"idSubbasin", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> idCountry = createColumn(
		"idCountry", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> idProvince = createColumn(
		"idProvince", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> idRegion = createColumn(
		"idRegion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> idMunicipality = createColumn(
		"idMunicipality", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> idMacroarea = createColumn(
		"idMacroarea", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> nameBasin = createColumn(
		"nameBasin", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> nameSubbasin = createColumn(
		"nameSubbasin", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> nameCountry = createColumn(
		"nameCountry", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> nameProvince = createColumn(
		"nameProvince", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> nameRegion = createColumn(
		"nameRegion", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> nameMunicipality = createColumn(
		"nameMunicipality", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> nameMacroarea = createColumn(
		"nameMacroarea", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, String> network = createColumn(
		"network", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, Boolean> attivo = createColumn(
		"attivo", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, Boolean> incluso = createColumn(
		"incluso", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<StazioneTable, Integer> progressivo = createColumn(
		"progressivo", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private StazioneTable() {
		super("BOLLETTINO_Stazione", StazioneTable::new);
	}

}