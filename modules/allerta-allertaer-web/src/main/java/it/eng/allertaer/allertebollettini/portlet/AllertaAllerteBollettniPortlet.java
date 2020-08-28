package it.eng.allertaer.allertebollettini.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import it.eng.allerta.utils.AllertaKeys;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.init-param.add-process-action-error-action=false",
		"javax.portlet.display-name=Allerte e Bollettini", 
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AllertaKeys.AllertaAllerteBollettiniPortlet,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AllertaAllerteBollettniPortlet extends MVCPortlet {
	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		
		super.render(renderRequest, renderResponse);
	}
//	
//	private String getDDMStructureKeyByName(String structureName) {
//		
//		//long classNameId = classNameLocalService.getClassNameId(JournalArticle.class);
//
//		String ddmStructureKey = "";
//		
//        try {
//            List<DDMStructure> ddmStructures = ddmStructureLocalService.getDDMStructures(0, ddmStructureLocalService.getDDMStructuresCount());
//            
//            for (DDMStructure structure : ddmStructures) {
//                
//                    if (structure.getName(Locale.ITALIAN).equalsIgnoreCase(structureName)) {
//                        ddmStructureKey = structure.getStructureKey();                        
//                        continue;
//                    }
//                
//            }
//        } catch (SystemException e) {
//        	
//            e.printStackTrace();
//        }
//        
//        return ddmStructureKey;
//		
//	}
	@Reference
	public AssetCategoryLocalService _assetCategoryService;

//	@Reference
//	private ClassNameLocalService classNameLocalService;
//
//	@Reference
//	private DDMStructureLocalService ddmStructureLocalService;

}
