package it.eng.allerta.animazione.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import it.eng.allerta.animazione.bean.AnimazioneBean;
import it.eng.allerta.utils.AllertaKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author CPPNDR74H
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=" +  AllertaKeys.AllertaCategory,
			"com.liferay.portlet.use-default-template=true",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Animazione Meteo", 
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaAnimazioneMeteoPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AllertaAnimazioneMeteoPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		AnimazioneBean animBean = new AnimazioneBean();
		
		String animType = ParamUtil.getString(renderRequest, "name", "ND");
		int id = ParamUtil.getInteger(renderRequest, "id");
		
		renderRequest.setAttribute("AnimazioneBean", animBean);
		renderRequest.setAttribute("AnimType", animType);
		renderRequest.setAttribute("id", id);
		
		super.render(renderRequest, renderResponse);
	}
	
}