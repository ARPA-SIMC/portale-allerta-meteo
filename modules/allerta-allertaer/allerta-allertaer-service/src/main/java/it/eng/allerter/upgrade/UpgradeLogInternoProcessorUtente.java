package it.eng.allerter.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class UpgradeLogInternoProcessorUtente extends UpgradeProcess {

	
	@Override
	protected void doUpgrade() throws Exception {
		
		runSQL("alter table ALLERTER_LogInterno drop constraint allerter_loginterno_pkey ");
		
		runSQL("alter table ALLERTER_LogInterno ADD PRIMARY KEY (logId) ");
		
		
		
	}

}
