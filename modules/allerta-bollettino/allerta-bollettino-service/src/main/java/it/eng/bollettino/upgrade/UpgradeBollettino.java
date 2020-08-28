package it.eng.bollettino.upgrade;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

@Component(
		immediate = true,
		service = UpgradeStepRegistrator.class
		)
public class UpgradeBollettino implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		
		registry.register("0.0.0", "1.0.0", new UpgradeBollettinoProcessor());
		registry.register("1.0.0", "1.0.1", new UpgradeBollettinoProcessor());
	}

}
