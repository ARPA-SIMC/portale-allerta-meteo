package it.eng.previsioni.meteo.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class UpgradePrevisioniProcess2 extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		
		if (hasColumn("prev_meteo_bollettino", "xml_content")) {
			
			runSQL("alter table prev_meteo_bollettino alter column xml_content type text");
			
		}
		
		if (hasColumn("prev_meteo_bollettino", "json")) {
			
			runSQL("alter table prev_meteo_bollettino alter column json type text");
			
		}
		
	}

}
