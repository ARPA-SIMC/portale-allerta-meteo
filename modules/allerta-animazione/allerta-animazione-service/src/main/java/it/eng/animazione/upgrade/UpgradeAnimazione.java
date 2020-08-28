package it.eng.animazione.upgrade;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

@Component(
		immediate = true,
		service = UpgradeStepRegistrator.class
		)
public class UpgradeAnimazione implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		
		registry.register("0.0.0", "1.0.0", new UpgradeAnimazioneProcess());
		registry.register("1.0.0", "1.0.1", new UpgradeAnimazioneProcess());
		registry.register("1.0.1", "1.0.2", new UpgradeAnimazioneProcess2());
		
	}

}
