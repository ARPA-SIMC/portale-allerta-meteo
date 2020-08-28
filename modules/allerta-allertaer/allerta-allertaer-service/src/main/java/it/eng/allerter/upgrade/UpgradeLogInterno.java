package it.eng.allerter.upgrade;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;


@Component(
		immediate = true,
		service = UpgradeStepRegistrator.class
		)
public class UpgradeLogInterno implements UpgradeStepRegistrator{

	@Override
	public void register(Registry registry) {
		
		registry.register("0.0.0", "1.0.0", new UpgradeLogInternoProcessor());
		registry.register("1.0.0", "1.0.1", new UpgradeLogInternoProcessor());
		registry.register("1.0.1", "1.0.2", new UpgradeLogInternoProcessorUtente());
		registry.register("1.0.2", "1.0.3", new UpgradeLogInternoProcessorUtente2());
		registry.register("1.0.3", "1.0.4", new UpgradeLogInternoProcessorUtente3());
		registry.register("1.0.4", "1.0.5", new UpgradeLogInternoProcessorUtente4());
		
	}

	
}
