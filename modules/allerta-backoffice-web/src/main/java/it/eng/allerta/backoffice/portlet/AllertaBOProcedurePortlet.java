package it.eng.allerta.backoffice.portlet;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleConstants;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.WorkflowDefinitionLink;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManagerUtil;

import it.eng.allerta.backoffice.constants.AllertaBackofficeKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author VLPMRC80B
 */
@Component(
		immediate = true, 
		property = { 
				"com.liferay.portlet.add-default-resource=true",
				"com.liferay.portlet.display-category=category.hidden", 
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.layout-cacheable=true", 
				"com.liferay.portlet.private-request-attributes=false",
				"com.liferay.portlet.private-session-attributes=false", 
				"com.liferay.portlet.render-weight=50",
				"com.liferay.portlet.use-default-template=true", 
				"javax.portlet.display-name=AllertaBackofficeWeb",
				"javax.portlet.expiration-cache=0", 
				"javax.portlet.init-param.template-path=/procedure/",
				"javax.portlet.init-param.view-template=/procedure/view.jsp",
				"javax.portlet.name=" + AllertaBackofficeKeys.AllertaBOProcedurePortlet,
				"javax.portlet.resource-bundle=content.Language", 
				"javax.portlet.security-role-ref=power-user,user",
				"javax.portlet.supports.mime-type=text/html" 
		}, 
		service = Portlet.class
)
public class AllertaBOProcedurePortlet extends MVCPortlet {

	@ProcessAction(name = "updateJournalAssets")
	public void updateJournalAssets(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		try {

			List<JournalArticle> articles = articleLocalService.getArticles();

			ServiceContext serviceContext = ServiceContextFactory.getInstance(JournalArticle.class.getName(),
					actionRequest);

			for (JournalArticle article : articles) {

				long pk = 0;

				if ((article.isDraft() || article.isPending())
						&& (article.getVersion() != JournalArticleConstants.VERSION_DEFAULT)) {

					pk = article.getPrimaryKey();

				} else {

					pk = article.getResourcePrimKey();

				}

				AssetEntry assetEntry = assetEntryLocalService.fetchEntry(JournalArticle.class.getName(), pk);

				if (assetEntry == null) {

					String title = article.getTitleMapAsXML();
					String description = article.getDescriptionMapAsXML();

					assetEntryLocalService.updateEntry(article.getUserId(), article.getGroupId(),
							article.getCreateDate(), article.getModifiedDate(), JournalArticle.class.getName(), pk,
							article.getUuid(), getClassTypeId(article), serviceContext.getAssetCategoryIds(),
							serviceContext.getAssetTagNames(), articleLocalService.isListable(article), false, null,
							null, null, article.getExpirationDate(), ContentTypes.TEXT_HTML, title, description,
							description, null, article.getLayoutUuid(), 0, 0, serviceContext.getAssetPriority());
				}

			}

		} catch (Exception e) {
			log.error(e);
		}

	}
	
	@ProcessAction(name = "configureDocumentsFolder")
	public void configureDocumentsFolder(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		long companyId = PortalUtil.getCompanyId(actionRequest);
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		List<Group> groups = GroupLocalServiceUtil.getGroups(companyId, GroupConstants.ANY_PARENT_GROUP_ID, true);
		
		WorkflowDefinition wfl = getWorkflow(companyId);
		
		List<Group> sites = new ArrayList<Group>();
		
		for (Group group: groups) {
		      if (group.getType() == 1 && group.isSite()) {
		             sites.add(group);
		             configureDocumentsFolder("TAVOLE", group, themeDisplay.getUserId(), companyId, themeDisplay.getLocale(), wfl);
		             configureDocumentsFolder("PIANI COMUNALI", group, themeDisplay.getUserId(), companyId, themeDisplay.getLocale(), wfl);
		             configureDocumentsFolder("ALTRI DOCUMENTI", group, themeDisplay.getUserId(), companyId, themeDisplay.getLocale(), wfl);
		      }
		}
	}
	
	@SuppressWarnings("unchecked")
	private WorkflowDefinition getWorkflow( long companyId) {
		
		WorkflowDefinition wfl = null;
		
		try {
			wfl = WorkflowDefinitionManagerUtil.getLatestWorkflowDefinition(companyId, "Piani di protezione civile Comunali");
			
					 /* gia assegnati alal Folder
					(List<WorkflowDefinitionLink>) WorkflowDefinitionLinkLocalServiceUtil.
														.getWorkflowDefinitionLink(
																companyId, 
																repositoryId, 
																DLFolderConstants.getClassName(), 
																folderId, 
																fileEntryTypeId, 
																true);*/
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		return wfl;
	
	}
	
	
	@SuppressWarnings("unchecked")
	private void configureDocumentsFolder(String folderName, Group site, long userId, long companyId, Locale locale, WorkflowDefinition wfl) {
		
		Folder rootfolder = null;
		try {
			rootfolder = DLAppServiceUtil.getFolder(site.getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);
		} catch (PortalException e) {
			//e.printStackTrace();
			
			log.debug("Comune " + site.getName() + " Non ha Root Folder impostata " );
		}
		
		if( Validator.isNotNull(rootfolder)) {
			
			DLFolder currentFolder = null;
			try {
				currentFolder = DLFolderLocalServiceUtil.getDLFolder(rootfolder.getFolderId());
			} catch (PortalException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			if( Validator.isNotNull(currentFolder)) {
				
				//if( currentFolder.getRestrictionType() != DLFolderConstants.RESTRICTION_TYPE_FILE_ENTRY_TYPES_AND_WORKFLOW) {
			
				List<DLFileEntryType> fileEntryTypes = null;
				
				try {
					 fileEntryTypes = 
							 DLFileEntryTypeLocalServiceUtil.getFileEntryTypes(
									 	PortalUtil.getCurrentAndAncestorSiteGroupIds( currentFolder.getGroupId())
							 );
							 /*
							DLFileEntryTypeLocalServiceUtil.getFolderFileEntryTypes(
									PortalUtil.getCurrentAndAncestorSiteGroupIds( currentFolder.getGroupId()), 
									rootfolder.getFolderId(), 
									true);*/
				} catch (PortalException e) {
					e.printStackTrace();
				}
				
				if( Validator.isNotNull(fileEntryTypes)) {
					
					final String fnane = currentFolder.getName();
					
					DLFileEntryType f =
							(DLFileEntryType) fileEntryTypes
												.stream()
												.filter(
														e-> e
															.getName(locale)
															.equals( 
																	fnane.equals("TAVOLE") 
																	? "Tavole"
																	: "piano di protezione civile")
														).toArray()[0];
					
					
					WorkflowDefinitionLink wflAssigned = null;
					
					try {
					
						 wflAssigned =	(WorkflowDefinitionLink) WorkflowDefinitionLinkLocalServiceUtil
											.getWorkflowDefinitionLink(
													companyId, 
													site.getGroupId(), 
													DLFolderConstants.getClassName(), 
													currentFolder.getFolderId(), 
													f.getFileEntryTypeId(), 
													true);
					} catch (PortalException e2) {
						// TODO Auto-generated catch block
						//e2.printStackTrace();
						log.debug("Comune " + site.getName() + " senza workflow " );
					}
					
					if( Validator.isNotNull(wflAssigned)) {
						
						if( wfl.getName().equals("Piani di protezione civile Comunali")) {
							
							log.debug("Comune " + site.getName() + " ha worflow impostato, salto " );
							return; //gia' assegnato il workflow alla cartella
						}
					}
				
					currentFolder.setRestrictionType(DLFolderConstants.RESTRICTION_TYPE_FILE_ENTRY_TYPES_AND_WORKFLOW);
					currentFolder.setDefaultFileEntryTypeId(f.getFileEntryTypeId());
					
					try {
						WorkflowDefinitionLinkLocalServiceUtil
											.addWorkflowDefinitionLink(
													userId, 
													companyId, 
													site.getGroupId(),
													DLFolderConstants.getClassName(),
													currentFolder.getFolderId(),
													f.getFileEntryTypeId(),
													wfl.getName(),
													wfl.getVersion());
						
						log.debug("Comune " + site.getName() + " impstato workflow " );
					} catch (PortalException e1) {
						e1.printStackTrace();
					}
					
					DLFolderLocalServiceUtil.addDLFileEntryTypeDLFolder(f.getFileEntryTypeId(), currentFolder);
					DLFolderLocalServiceUtil.updateDLFolder(currentFolder);
				}
				//}
			}
			
		}
		
	}

	private long getClassTypeId(JournalArticle article) throws PortalException {

		long classNameId = classNameLocalService.getClassNameId(JournalArticle.class);

		DDMStructure ddmStructure = ddmStructureLocalService.fetchStructure(article.getGroupId(), classNameId,
				article.getDDMStructureKey(), true);

		return ddmStructure.getStructureId();
	}

	@Reference
	private JournalArticleLocalService articleLocalService;

	@Reference
	private AssetEntryLocalService assetEntryLocalService;

	@Reference
	private ClassNameLocalService classNameLocalService;

	@Reference
	private DDMStructureLocalService ddmStructureLocalService;

	private Log log = LogFactoryUtil.getLog(AllertaBOProcedurePortlet.class);
}