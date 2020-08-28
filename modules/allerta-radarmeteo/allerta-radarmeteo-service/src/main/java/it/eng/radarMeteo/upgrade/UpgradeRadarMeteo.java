package it.eng.radarMeteo.upgrade;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

@Component(
		immediate = true,
		service = UpgradeStepRegistrator.class
		)
public class UpgradeRadarMeteo implements UpgradeStepRegistrator{

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "1.0.0", new UpgradeRadarMeteoProcessor());
		registry.register("1.0.0", "1.0.1", new UpgradeRadarMeteoProcessor());
		registry.register("1.0.1", "1.0.2", new UpgradeRadarMeteoProcessor());
		registry.register("1.0.2", "1.0.3", new UpgradeRadarMeteoProcessor2());
		
	}

}
