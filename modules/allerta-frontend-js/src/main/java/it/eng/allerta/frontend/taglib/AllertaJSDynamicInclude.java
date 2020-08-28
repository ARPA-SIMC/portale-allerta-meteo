package it.eng.allerta.frontend.taglib;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.BaseJSPDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

@Component(
		immediate = true, 
		service = DynamicInclude.class
		)
public class AllertaJSDynamicInclude extends BaseJSPDynamicInclude{

	
	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		
		dynamicIncludeRegistry.register("/html/common/themes/bottom.jsp#post");
	}

	@Override
	protected String getJspPath() {
		// TODO Auto-generated method stub
		return "/include.jsp";
	}

	@Override
	protected Log getLog() {
		// TODO Auto-generated method stub
		return LogFactoryUtil.getLog(AllertaJSDynamicInclude.class);
	}

	@Reference(
			target = "(osgi.web.symbolicname=it.eng.allerta.frontend.js)",
			unbind = "-"
		)
		protected void setServletContext(ServletContext servletContext) {
			super.setServletContext(servletContext);
		}

}
