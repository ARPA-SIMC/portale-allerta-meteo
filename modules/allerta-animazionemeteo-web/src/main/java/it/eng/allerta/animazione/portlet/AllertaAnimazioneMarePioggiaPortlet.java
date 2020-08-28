package it.eng.allerta.animazione.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.eng.allerta.animazione.bean.AnimazioneMarePioggiaBean;
import it.eng.allerta.utils.AllertaKeys;

@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=" +  AllertaKeys.AllertaCategory,
			"com.liferay.portlet.use-default-template=true",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Animazione Mare", 
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/animare.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaAnimazioneMarePioggaPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AllertaAnimazioneMarePioggiaPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		AnimazioneMarePioggiaBean animBean = new AnimazioneMarePioggiaBean();
		
		renderRequest.setAttribute("AnimazioneMarePioggiaBean", animBean);
	
		super.render(renderRequest, renderResponse);
	}

}
