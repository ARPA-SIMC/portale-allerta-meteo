package it.eng.animazione.upgrade;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class UpgradeAnimazioneProcess extends UpgradeProcess{

	@Override
	protected void doUpgrade() throws Exception {
		// TODO Auto-generated method stub
		
		runSQL("alter table img_animazioni_altezzaonda alter column imgData type text");
		
		runSQL("alter table img_animazioni_pioggiacumulativa alter column imgData type text");
		
	}

}
