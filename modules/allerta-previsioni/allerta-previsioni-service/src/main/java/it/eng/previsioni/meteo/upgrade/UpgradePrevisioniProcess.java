package it.eng.previsioni.meteo.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class UpgradePrevisioniProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		
		if (hasColumn("prev_meteo_img", "data_")) {
			
			runSQL("alter table prev_meteo_img alter column data_ type text");
			
		}
		
	}

}
