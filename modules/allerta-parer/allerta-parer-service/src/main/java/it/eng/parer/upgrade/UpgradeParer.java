package it.eng.parer.upgrade;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

@Component(immediate = true,service = UpgradeStepRegistrator.class)
public class UpgradeParer implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		
		registry.register("0.0.0", "1.0.0", new UpgradeParerProcess());
		
	}

}
