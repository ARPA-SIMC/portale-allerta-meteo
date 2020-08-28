package it.eng.allerta.backoffice.portlet;

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

import com.liferay.document.library.kernel.model.DLFileEntryType;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.WorkflowDefinitionLink;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowDefinition;
import com.liferay.portal.kernel.workflow.WorkflowDefinitionManagerUtil;

import it.eng.allerta.backoffice.constants.AllertaBackofficeKeys;

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
				"javax.portlet.display-name=Configura Cartella Documenti Comuni",
				"javax.portlet.expiration-cache=0", 
				"javax.portlet.init-param.template-path=/procedure/",
				"javax.portlet.init-param.view-template=/procedure/documents.jsp",
				"javax.portlet.name=" + AllertaBackofficeKeys.AllertaBOConfigureDocumentFolderComuniPortlet,
				"javax.portlet.resource-bundle=content.Language", 
				"javax.portlet.security-role-ref=power-user,user",
				"javax.portlet.supports.mime-type=text/html" 
		}, 
		service = Portlet.class
)
public class ConfigureDocumentFolderComuni extends MVCPortlet {
	
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
		             break;
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
			e.printStackTrace();
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
					
					
					List<WorkflowDefinitionLink> wflAssigned = null;
					
					try {
					
						 wflAssigned =	(List<WorkflowDefinitionLink>) WorkflowDefinitionLinkLocalServiceUtil
											.getWorkflowDefinitionLink(
													companyId, 
													site.getGroupId(), 
													DLFolderConstants.getClassName(), 
													currentFolder.getFolderId(), 
													f.getFileEntryTypeId(), 
													true);
					} catch (PortalException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					if( Validator.isNotNull(wflAssigned)) {
						
						for( WorkflowDefinitionLink wdef : wflAssigned) {
							
							if( wdef.getWorkflowDefinitionName().equals("Piani di protezione civile Comunali"))
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
	
	/*
	private void __configureDocumentsRootFolder(Group site, long userId, long companyId, Locale locale) {
		
		Folder rootfolder = null;
		Folder testfolder = null;
		
		try {
			rootfolder = DLAppServiceUtil.getFolder(site.getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "PIANI COMUNALI");
			testfolder = DLAppServiceUtil.getFolder(site.getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "TAVOLE");
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
		if( rootfolder != null) {
			
			 long repositoryId = site.getGroupId();
			
			 List<DLFolder> dlFolders = 
					 	DLFolderLocalServiceUtil.getFolders(repositoryId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
				
			if( dlFolders.size() > 0 ) {
					
				Iterator<DLFolder> subFolders = dlFolders.iterator();
				DLFolder currentFolder;
				
				Boolean find=false;
				
				String currentFolderName;
				
				while(subFolders.hasNext() && !find) {
					
					currentFolder = subFolders.next();
					currentFolderName = currentFolder.getName();
					
					if( currentFolderName.equals("TAVOLE") 
							|| currentFolderName.equals("PIANI COMUNALI")) {
						
						if( currentFolder.getRestrictionType() != DLFolderConstants.RESTRICTION_TYPE_FILE_ENTRY_TYPES_AND_WORKFLOW) {
						
							List<DLFileEntryType> fileEntryTypes = null;
							try {
								 fileEntryTypes = 
										DLFileEntryTypeLocalServiceUtil.getFolderFileEntryTypes(
												PortalUtil.getCurrentAndAncestorSiteGroupIds(site.getGroupId()), 
												currentFolder.getFolderId(), 
												false);
							} catch (PortalException e) {
								e.printStackTrace();
							}
							
							if( Validator.isNotNull(fileEntryTypes)) {
								
								DLFileEntryType f =
										(DLFileEntryType) fileEntryTypes
															.stream()
															.filter(
																	e-> e
																		.getName()
																		.equals( 
																			e.getName(locale).equals("TAVOLE") 
																				? "Tavole"
																				: "piano di protezione civile")
																	).toArray()[0];
								
								WorkflowDefinition wfl = getWorkflow( 
																companyId, 
																repositoryId, 
																currentFolder.getFolderId(), 
																f.getFileEntryTypeId());
											
							
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
								} catch (PortalException e1) {
									e1.printStackTrace();
								}
												
							}
						}
					}
				}
			}
		}
	}*/
}
