/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service.impl;

import com.liferay.portal.aop.AopService;


import com.liferay.document.library.kernel.exception.NoSuchFileEntryException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.service.AllertaParametroLocalServiceUtil;
import it.eng.allerter.service.SMSLocalServiceUtil;
import it.eng.allerter.service.base.AllertaValangheLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author GFAVINI
 */
@Component(
	property = "model.class.name=it.eng.allerter.model.AllertaValanghe",
	service = AopService.class
)
public class AllertaValangheLocalServiceImpl
	extends AllertaValangheLocalServiceBaseImpl {
	


	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerter.service.AllertaValangheLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerter.service.AllertaValangheLocalServiceUtil</code>.
	 */
	
	private Log _log = LogFactoryUtil.getLog(AllertaValangheLocalServiceImpl.class);
	
	
	public Map<String, Object> getInfoValanghe() {
		return allertaValangheFinder.getInfoAllertaValanghe(0);
	}
	
	public Map<String, Object> getInfoValangheDomani() {
		return allertaValangheFinder.getInfoAllertaValanghe(1);
	}
	
	public long getIdApprovatore(long id) {
		return allertaValangheFinder.getUtenteApprovatore(id);
	}
	
	public String nextIdAllertaValanghe(boolean allerta, int anno) {
		return allertaValangheFinder.nextIdAllertaValanghe(allerta, anno);
	}
	
	public List<AllertaValanghe> getAllertaValanghesOrdered(int start, int end, OrderByComparator<AllertaValanghe> comparator) {
		return allertaValangheFinder.getAllertaValanghesOrdered(start, end, comparator);
	}
	
	public void fileDeleteByApp(String file, String folderName, ServiceContext serviceContext) {
		
		long repositoryId = serviceContext.getScopeGroupId();
		//String mimeType = MimeTypesUtil.getContentType(file);
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("VALANGHE_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder folder = DLAppServiceUtil.getFolder(serviceContext.getScopeGroupId(), parentFolderId, folderName);
			List<FileEntry> l = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			for (FileEntry fe : l) {
				if (fe.getTitle().startsWith(file))
					DLAppServiceUtil.deleteFileEntryByTitle(repositoryId, folder.getFolderId(), fe.getTitle());
			}
		} catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("allertaBean", "fileDelete", e, "");
			
		}
	}
	
	public void fileUploadByApp(File file, String folderName, String title, 
			String description, String mimeType, ServiceContext serviceContext) {
		
		System.out.println("Exist=>" + file.exists());
		long repositoryId = serviceContext.getScopeGroupId();
		
		// String mimeType = MimeTypesUtil.getContentType(file);
		// String title = file.getName();
		// String description = "This file is added via programatically";
		String changeLog = "hi";
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		
		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("VALANGHE_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}
		System.out.println("Parent folder=>" + parentFolderId);

		try {
			Folder folder = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			System.out.println("Folder=>" + folder.getFolderId());
			ServiceContext dlServiceContext = serviceContext.getRequest()!=null?ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), serviceContext.getRequest()):serviceContext;
			System.out.println("ServiceContext=>" + (dlServiceContext!=null));

			InputStream is = new FileInputStream(file);
			FileEntry f = null;
			try {
				f = DLAppServiceUtil.getFileEntry(repositoryId, folder.getFolderId(), title);
				System.out.println("File entry found=>"+f.getFileEntryId());

				f = DLAppServiceUtil.updateFileEntry(f.getFileEntryId(), file.getName(), 
						mimeType, title,title, description, changeLog, 
						DLVersionNumberIncrease.AUTOMATIC, is, file.length(),f.getDisplayDate(),f.getExpirationDate(),f.getReviewDate(),
							dlServiceContext);
				System.out.println("File entry updated");

			} catch (NoSuchFileEntryException e) {
				 
				f = DLAppServiceUtil.addFileEntry(folderName+"_"+title,repositoryId, folder.getFolderId(),			 
						file.getName(), mimeType,
						title, title, description, changeLog, file, null, null, null, dlServiceContext);
				System.out.println("File entry created=>"+f.getFileEntryId());

			}
			

			Role guestRole = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), RoleConstants.GUEST);
			ResourcePermissionLocalServiceUtil.setResourcePermissions(serviceContext.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(f.getFileEntryId()), guestRole.getRoleId(), new String[] { "VIEW" });

			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_RUOLI_MODIFICA_LINK");
			if (ap != null && ap.getValore() != null && !ap.getValore().equals("")) {
				String[] ruoli = ap.getValore().split(",");
				for (String s : ruoli) {
					long l = Long.parseLong(s);
					ResourcePermissionLocalServiceUtil.setResourcePermissions(serviceContext.getCompanyId(),
							DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
							String.valueOf(f.getFileEntryId()), l, new String[] { "VIEW", "UPDATE", "DELETE" });
				}
			}
			
			System.out.println("End of file creation");

		} catch (Exception e) {
			e.printStackTrace();
			//logInternoLocalService.log("allertaBean", "fileUpload", e, "");
		}
	}
	
	public DLFolder getDLFolder(String folderName, ServiceContext serviceContext) {		
		long groupId = serviceContext.getScopeGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro(AllertaKeys.AllertaValangheParentFolderParamKey);
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			DLFolder dir = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);
			_log.debug("Folder Id==>" + dir.getFolderId());
			return dir;
		} catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("allertaBean", "getDLFolder", e, "");
			
			return null;
		}
	}


	public void spedisciNotifiche(String tipo, String sottotipo, long l, String emailSubject, String emailText,	AllertaValanghe av) {
		try {
			File f = av.getReportAsFile();
			
			String nomeFile = f.getName();

			SMSLocalServiceUtil.inviaSMS(tipo, sottotipo, l);
			SMSLocalServiceUtil.inviaEmail(tipo, sottotipo, l, emailSubject, emailText, "no-reply@allertameteoer.it", f,
					nomeFile);
		} catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("AllertaWorkflow", "spedisciNotifiche", e, "");
		}
	}
	
	public List<AllertaValanghe> getListaAllerteValanghe() {		
		DynamicQuery dyn = allertaValangheLocalService.dynamicQuery()
				.add(PropertyFactoryUtil.forName("stato").ne(WorkflowConstants.STATUS_APPROVED))
				.addOrder(OrderFactoryUtil.desc("createDate"));
				
		return allertaValangheLocalService.dynamicQuery(dyn);		
	}



	public Folder getFolder(long groupId, String folderName) {		
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTAVALANGHE_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder dir = DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
			_log.debug("Folder Id==>" + dir.getFolderId());
			return dir;
		} catch (Exception e) {
			//logInternoLocalService.log("allertaBean", "getFolder", e, "");
			_log.error(e);
			return null;
		}		
	}
}