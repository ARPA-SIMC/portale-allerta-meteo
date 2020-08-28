package it.eng.comune.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.eng.allerta.utils.AllertaKeys;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
			"com.liferay.portlet.use-default-template=true",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Home Comune Testa", 
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/comuneHead.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaComuneHeadPortlet,
			"javax.portlet.init-param.add-process-action-success-action=false",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"		
		},
		service = Portlet.class
	)
public class AllertaComuneHeadPortler extends MVCPortlet {

}
