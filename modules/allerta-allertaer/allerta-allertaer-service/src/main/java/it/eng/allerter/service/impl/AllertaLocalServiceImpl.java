/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.allerter.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

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

import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.service.base.AllertaLocalServiceBaseImpl;

/**
 * The implementation of the allerta local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.allerter.service.AllertaLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaLocalServiceBaseImpl
 */
public class AllertaLocalServiceImpl extends AllertaLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.allerter.service.AllertaLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerter.service.AllertaLocalServiceUtil</code>.
	 */
	
	public long getIdApprovatore(long id) {
		return allertaFinder.getUtenteApprovatore(id);
	}
	
	public String nextIdAllerta(boolean allerta, int anno) {
		return allertaFinder.nextIdAllerta(allerta, anno);
	}
	
	public List<Allerta> getAllertasOrdered( int start, int end, OrderByComparator<Allerta> comparator) {
		return allertaFinder.getAllertasOrdered( start, end, comparator);
	}
	
	public void fileDeleteByApp(String file, String folderName, ServiceContext serviceContext) {
		
		long repositoryId = serviceContext.getScopeGroupId();
		//String mimeType = MimeTypesUtil.getContentType(file);
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
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
			AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder folder = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			ServiceContext dlServiceContext = serviceContext.getRequest()!=null?ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), serviceContext.getRequest()):serviceContext;
			InputStream is = new FileInputStream(file);
			FileEntry f = null;
			try {
				f = DLAppServiceUtil.getFileEntry(repositoryId, folder.getFolderId(), title);
				
				f = DLAppServiceUtil.updateFileEntry(f.getFileEntryId(), file.getName(), 
						mimeType, title, description, changeLog, 
						DLVersionNumberIncrease.AUTOMATIC, is, file.length(),
							dlServiceContext);
				
			} catch (NoSuchFileEntryException e) {
				 
				f = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(),			 
						file.getName(), mimeType,
						title, description, changeLog, is, file.length(), dlServiceContext);
			}
			

			Role guestRole = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), RoleConstants.GUEST);
			ResourcePermissionLocalServiceUtil.setResourcePermissions(serviceContext.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(f.getFileEntryId()), guestRole.getRoleId(), new String[] { "VIEW" });

			AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro("ALLERTA_RUOLI_MODIFICA_LINK");
			if (ap != null && ap.getValore() != null && !ap.getValore().equals("")) {
				String[] ruoli = ap.getValore().split(",");
				for (String s : ruoli) {
					long l = Long.parseLong(s);
					ResourcePermissionLocalServiceUtil.setResourcePermissions(serviceContext.getCompanyId(),
							DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
							String.valueOf(f.getFileEntryId()), l, new String[] { "VIEW", "UPDATE", "DELETE" });
				}
			}

		} catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("allertaBean", "fileUpload", e, "");
		}
	}

	
//	public void fileUploadByApp(File file, String folderName, String title,
//			String description, String mimeType, ServiceContext serviceContext) {
//		System.out.println("Exist=>" + file.exists());
//		long repositoryId = serviceContext.getScopeGroupId();
//		// String mimeType = MimeTypesUtil.getContentType(file);
//		// String title = file.getName();
//		// String description = "This file is added via programatically";
//		String changeLog = "hi";
//		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
//
//		try {
//			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
//			if (ap != null)
//				parentFolderId = Long.parseLong(ap.getValore());
//		} catch (Exception e) {
//		}
//
//		try {
//			Folder folder = DLAppServiceUtil.getFolder(serviceContext.getScopeGroupId(), parentFolderId, folderName);
//			InputStream is = new FileInputStream(file);
//			FileEntry f = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), file.getName(), mimeType,
//					title, description, changeLog, is, file.length(), serviceContext);
//
//			Role guestRole = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), RoleConstants.GUEST);
//			ResourcePermissionLocalServiceUtil.setResourcePermissions(serviceContext.getCompanyId(),
//					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
//					String.valueOf(f.getFileEntryId()), guestRole.getRoleId(), new String[] { "VIEW" });
//
//			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_RUOLI_MODIFICA_LINK");
//			if (ap != null && ap.getValore() != null && !ap.getValore().equals("")) {
//				String[] ruoli = ap.getValore().split(",");
//				for (String s : ruoli) {
//					long l = Long.parseLong(s);
//					ResourcePermissionLocalServiceUtil.setResourcePermissions(serviceContext.getCompanyId(),
//							DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
//							String.valueOf(f.getFileEntryId()), l, new String[] { "VIEW", "UPDATE", "DELETE" });
//				}
//			}
//
//		} catch (Exception e) {
//			_log.error(e);
//			logInternoLocalService.log("allertaBean", "fileUpload", e, "");
//		}
//	}

	
	public DLFolder getDLFolder(String folderName, ServiceContext serviceContext) {
		
		long groupId = serviceContext.getScopeGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro(AllertaKeys.AllertaParentFolderParamKey);
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			DLFolder dir = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);
			System.out.println("Folder Id==>" + dir.getFolderId());
			return dir;
		} catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("allertaBean", "getDLFolder", e, "");
			
			return null;
		}

	}


	public void spedisciNotifiche(String tipo, String sottotipo, long l, String emailSubject, String emailText,
			Allerta a) {

		try {
			File f = a.getReportAsFile();
			
			String nomeFile = f.getName();

			smsLocalService.inviaSMS(tipo, sottotipo, l);
			smsLocalService.inviaEmail(tipo, sottotipo, l, emailSubject, emailText, "no-reply@allertameteoer.it", f,
					nomeFile);
		} catch (Exception e) {
			_log.error(e);
			//logInternoLocalService.log("AllertaWorkflow", "spedisciNotifiche", e, "");
		}
	}
	
	public List<Allerta> getListaAllerte() {
		
		DynamicQuery dyn = allertaLocalService.dynamicQuery()
				.add(PropertyFactoryUtil.forName("stato").ne(WorkflowConstants.STATUS_APPROVED))
				.addOrder(OrderFactoryUtil.desc("createDate"));
				
		return allertaLocalService.dynamicQuery(dyn);
		
	}



	public Folder getFolder(long groupId, String folderName) {
		
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = allertaParametroLocalService.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder dir = DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
			System.out.println("Folder Id==>" + dir.getFolderId());
			return dir;
		} catch (Exception e) {
			//logInternoLocalService.log("allertaBean", "getFolder", e, "");
			_log.error(e);
			return null;
		}
		
	}
	
	private Log _log = LogFactoryUtil.getLog(AllertaLocalServiceImpl.class);
	
}