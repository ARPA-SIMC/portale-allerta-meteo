package allerta.search.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import allerta.search.constants.AllertaSearchPortletKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name="+ AllertaSearchPortletKeys.COMMAND,
				"mvc.command.name=/allertaer/search/command"
		},
		service = MVCActionCommand.class
		)
public class CommandAction extends BaseMVCActionCommand  {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		
		HttpServletRequest r = PortalUtil.getHttpServletRequest(actionRequest);
		CommandContext cc = new CommandContext(PortalUtil.getOriginalServletRequest(r).getParameter("inputText"), "");

		try {
			cc.execute();
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, e.getClass(), e.getMessage());
		}
		actionRequest.getPortletSession().setAttribute("inputText", cc.input);
		actionRequest.getPortletSession().setAttribute("outputText", cc.output);
	}

}
