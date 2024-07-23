package it.eng.allertaer.allertebollettini.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;

import aQute.bnd.annotation.metatype.Configurable;
import it.eng.allerta.utils.AllertaKeys;
import it.eng.allertaer.allertebollettini.beans.Link;
import it.eng.allertaer.allertebollettini.portlet.config.ReportPostEventoConfiguration;


@Component(
		immediate = true,
		configurationPid = "it.eng.allertaer.allertebollettini.portlet.configuration.ReportPostEvento",
		property = {
			"com.liferay.portlet.display-category=" + AllertaKeys.AllertaCategory,
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.init-param.add-process-action-success-action=false",
			"javax.portlet.init-param.add-process-action-error-action=false",
			"javax.portlet.display-name=Report Post evento", 
			"javax.portlet.init-param.view-template=/reports.jsp",
			"javax.portlet.name=" + AllertaKeys.AllertaReportPostEventoPortlet,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class AllertaReportPostEventoPortlet extends MVCPortlet {
	
	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String ddmStructureKey ="57635";

		//OrderDateComparator odb = new OrderDateComparator(false);
		
		OrderByComparator<JournalArticle> comparator = OrderByComparatorFactoryUtil.create("journalarticle", "displaydate", false);
		
		List<JournalArticle> articles = 
					_journalArticleService.getArticlesByStructureId(themeDisplay.getScopeGroupId(), ddmStructureKey, 0, 3, comparator);
		
		//System.out.println("articles trovati : "+ articles.size());
		
		List<Link> reports = new ArrayList<Link>();

		Iterator<JournalArticle> it = articles.iterator();
		
		JournalArticle attuale = null;
		
		while(it.hasNext()) {
			
			attuale = it.next();
			
			long classid = 20109L;
			long classpk = attuale.getResourcePrimKey();
			AssetEntry ae = AssetEntryLocalServiceUtil.fetchEntry(classid, classpk);
			
			if (ae==null) continue;
			
			String url = "/web/guest/archivio-report-post-evento/-/asset_publisher/HpRwtPMIzgmZ/content/id/" + ae.getEntryId();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy - HH:mm", Locale.ITALIAN);
			
			reports.add(new Link(url, attuale.getTitle("it_IT"), sdf.format( attuale.getCreateDate())));
		}
		
		renderRequest.setAttribute("reports", reports);
		renderRequest.setAttribute(ReportPostEventoConfiguration.class.getName(), _myConfiguration);
		
		super.render(renderRequest, renderResponse);
		
	}
	
	@Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _myConfiguration= Configurable.createConfigurable(ReportPostEventoConfiguration.class, properties);
    }
	
	@Reference
	private AssetEntryService _assetEntryService;
	
	@Reference
	private JournalArticleService _journalArticleService;
	
	private volatile ReportPostEventoConfiguration _myConfiguration;

}
