package it.eng.allerter.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class UpgradeLogInternoProcessorUtente4 extends UpgradeProcess {

	
	@Override
	protected void doUpgrade() throws Exception {
				
		runSQL("alter table ALLERTER_LogInterno alter column risultato type text");
		
		
	}

}
