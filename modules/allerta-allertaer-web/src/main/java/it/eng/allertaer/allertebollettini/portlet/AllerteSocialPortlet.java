package it.eng.allertaer.allertebollettini.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.eng.allerta.utils.AllertaKeys;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Link Social", 
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/social.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaSocialPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AllerteSocialPortlet extends MVCPortlet {

}
