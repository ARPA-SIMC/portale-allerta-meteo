package it.eng.radarMeteo.upgrade;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StreamUtil;


public class UpgradeRadarMeteoProcessor extends UpgradeProcess {

	private String getTable(String[] tables, String tableName) {

		for (String table : tables) {
			if (table.indexOf(tableName) > 0) {
				return table;
			}
		}

		return null;
	}

	@Override
	protected void doUpgrade() throws Exception {
		ClassLoader classLoader = this.getClass().getClassLoader();

		InputStream is = classLoader.getResourceAsStream("META-INF/sql/tables.sql");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		StreamUtil.transfer(is, baos);

		String sql = new String(baos.toByteArray());

		String[] tables = sql.split(";");

		if (!hasTable("rt_portlet_json")) {

			String createSql = getTable(tables, "rt_portlet_json");

			runSQL(createSql);

		}

		if (!hasTable("rt_portlet_img")) {

			String createSql = getTable(tables, "rt_portlet_img");

			runSQL(createSql);

		}

		if (!hasTable("rt_portlet_comuni_ws")) {

			String createSql = getTable(tables, "rt_portlet_comuni_ws");

			runSQL(createSql);

		}

		if (!hasTable("rt_portlet_comuni_bacini_ws")) {

			String createSql = getTable(tables, "rt_portlet_comuni_bacini_ws");

			runSQL(createSql);

		}
		

		if (hasColumn("rt_portlet_json", "data_")) {
			
			runSQL("alter table rt_portlet_json alter column data_ type text");
			
		}

	}

}
