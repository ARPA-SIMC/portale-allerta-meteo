package it.eng.radarMeteo.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;


public class UpgradeRadarMeteoProcessor2 extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
	

		if (hasColumn("rt_portlet_img", "data_")) {
			
			runSQL("alter table rt_portlet_img alter column data_ type text");
			
		}

	}

}
