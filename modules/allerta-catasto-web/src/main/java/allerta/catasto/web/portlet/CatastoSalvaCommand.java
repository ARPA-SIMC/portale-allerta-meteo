package allerta.catasto.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import allerta.catasto.bean.CatastoBean;
import allerta.catasto.web.constants.AllertaCatastoWebPortletKeys;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AllertaCatastoWebPortletKeys.ALLERTACATASTOWEB,
				"mvc.command.name=/allertaer/catasto/salva"
		},
		service = MVCActionCommand.class
		)
public class CatastoSalvaCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	
		
		boolean err = false;
		
		long id = -1;
		
		HttpServletRequest r = PortalUtil.getHttpServletRequest(actionRequest);
		id  =   Long.parseLong(PortalUtil.getOriginalServletRequest(r).getParameter("id"));
		CatastoBean bean = null;
		try {
			bean = new CatastoBean(id, r);
			bean.salva();

		} catch (Exception e) {
			
			log.error(e);
			
			err = true;
			
			//LogInternoLocalServiceUtil.log("allertaBean", "salvaAllerta", e, "");

			SessionErrors.add(actionRequest, e.getClass(), e.getMessage());
		}
		
		
		if(!err)
			SessionMessages.add(actionRequest, "saved");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Long plid = PortalUtil.getPlidFromPortletId( themeDisplay.getScopeGroupId(), AllertaCatastoWebPortletKeys.ALLERTACATASTOWEB);
		
		PortletURL compilaURL = 
							PortletURLFactoryUtil.create(
										actionRequest, 
										AllertaCatastoWebPortletKeys.ALLERTACATASTOWEB, 
										plid, 
										PortletRequest.RENDER_PHASE);
		
		Map<String, String[]> compilaParameters = new HashMap<String, String[]>(0);
		compilaParameters.put("mvcRenderCommandName", new String[]{"/allertaer/catasto/compila"});
		compilaParameters.put("id", new String[]{String.valueOf(bean.getId())});
		
		compilaURL.setParameters(compilaParameters);
		
		actionResponse.sendRedirect( compilaURL.toString());
		
	}


	
	private Log log = LogFactoryUtil.getLog(CatastoSalvaCommand.class);
	
	
}