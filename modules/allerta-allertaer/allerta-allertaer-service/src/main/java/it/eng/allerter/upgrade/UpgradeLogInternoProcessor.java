package it.eng.allerter.upgrade;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StreamUtil;

import it.eng.allerter.model.LogInterno;

public class UpgradeLogInternoProcessor extends UpgradeProcess {

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
		
		if (!hasTable("ALLERTER_LogInterno")) {
			
			String createSql = getTable(tables, "ALLERTER_LogInterno");

			runSQL(createSql);

		}
		
		
		if (!hasColumn("ALLERTER_LogInterno", "logId")) {
			
			runSQL("alter table ALLERTER_LogInterno add logId bigserial ");
			
			runSQL("alter table ALLERTER_LogInterno alter column logId type bigint");
			
			String sqlMax = "SELECT MAX(logId) AS MAXVALUE FROM ALLERTER_LogInterno";
			
			Statement statement = this.connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlMax);
			
			if (resultSet.next()) {
				
				long nextId = resultSet.getLong("MAXVALUE");
				
				nextId++;
				
				CounterLocalServiceUtil.reset(LogInterno.class.getName(), nextId);
				
				
			}
			
		}
				
		
		
	}

}
