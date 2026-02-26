package allerta.verifica.web.bean;

import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;

import org.osgi.service.component.annotations.Component;

@Component(
		  property = {
			"dispatch.task.executor.name=Crea verifiche allerta",
			"dispatch.task.executor.type=task-verifiche"
		  },
		  service = DispatchTaskExecutor.class
		)
public class CreaVerificheTask extends BaseDispatchTaskExecutor {

	@Override
	public String getName() {
		return "task-verifiche";
	}

	@Override
	public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput)
			throws Exception {
		
		int create = new VerificaAllertaBean(null).creaVerificheMancanti();
		
		dispatchTaskExecutorOutput.setOutput("Verifiche create: "+create);
	}

}
