/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.model.impl;


import java.io.File;
import java.util.List;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import aQute.bnd.annotation.ProviderType;
import it.eng.allerta.utils.AllertaKeys;
import it.eng.allerter.model.Allerta;
import it.eng.allerter.model.AllertaParametro;
import it.eng.allerter.model.AllertaStato;
import it.eng.allerter.service.AllertaParametroLocalServiceUtil;
import it.eng.allerter.service.AllertaStatoLocalServiceUtil;
import it.eng.allerter.service.LogInternoLocalServiceUtil;

/**
 * @author GFAVINI
 */
public class AllertaImpl extends AllertaBaseImpl {
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a allerta model instance should use the {@link it.eng.allerter.model.Allerta} interface instead.
	 */
	public AllertaImpl() {
	}
	
	public List<AllertaStato> getAllertaStato() {
		return AllertaStatoLocalServiceUtil.getAllertaStatoByAllerta(getAllertaId());
	}
	
	public String getUrl() {
	
		return getFileLink();
	}
	
	private String getFileLink() {
		
		long companyId = getCompanyId();
		long groupId = getGroupId();
		
		String folderName = "allerta-" + getAllertaId();
		String fileName = isTipoAllerta() ? "allerta" : "bollettino";
		
		long repositoryId = groupId;
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Company company = CompanyLocalServiceUtil.getCompany(companyId);
			
			String portalURL = PortalUtil.getPortalURL(
					company.getVirtualHostname(), PortalUtil.getPortalLocalPort(false), false);

			Folder folder = DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			for (FileEntry file : fileEntries) {
				
				
				String url = portalURL + "/documents/"
						+ groupId + "/" + file.getFolderId() + "/" + file.getTitle();
				System.out.println("Link=>" + url);
				if (file.getTitle().startsWith(fileName))
					return url;
			}
			return null;
		} catch (Exception e) {
			LogInternoLocalServiceUtil.log("allertaBean", "getFileLink", e, "");
			return null;
		}
	}

	public String getFileLinkRelative(String folderName, String fileName) {
		long repositoryId = getGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro(AllertaKeys.AllertaParentFolderParamKey);
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder folder = DLAppServiceUtil.getFolder(getGroupId(), parentFolderId, folderName);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			for (FileEntry file : fileEntries) {

				String url = "/documents/" + getGroupId() + "/" + file.getFolderId() + "/" + file.getTitle();
				System.out.println("Link=>" + url);
				if (file.getTitle().equals(fileName))
					return url;
			}
			return null;
		} catch (Exception e) {
			_log.error(e);
			LogInternoLocalServiceUtil.log("allertaBean", "getFileLinkRelative", e, "");
			return null;
		}
	}
	
	public FileEntry getFile(String folderName, String fileName) {
		
		long repositoryId = getGroupId();
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro("ALLERTA_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder folder = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			for (FileEntry file : fileEntries) {
				if (file.getTitle().equals(fileName))
					return file;
			}
			return null;
		} catch (Exception e) {
			_log.error(e);
			LogInternoLocalServiceUtil.log("allertaBean", "getFile", e, "");
			
			return null;
		}
	}
	
	public File getReportAsFile() {

		try {

			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

			try {
				AllertaParametro ap = AllertaParametroLocalServiceUtil.fetchAllertaParametro(AllertaKeys.AllertaParentFolderParamKey);
				if (ap != null)
					parentFolderId = Long.parseLong(ap.getValore());
			} catch (Exception e) {
			}

			Folder folder = DLAppServiceUtil.getFolder(20181, parentFolderId, "allerta-" + getAllertaId());
			List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(20181, folder.getFolderId());

			for (FileEntry f : fileEntries) {
				if (f.getTitle().startsWith("allerta") || f.getTitle().startsWith("bollettino")) {
					String nomeFile = f.getTitle();
					File ff = FileUtil.createTempFile(f.getContentStream());
					return ff;
				}
			}

			return null;

		} catch (Exception e) {
			_log.error(e);
			LogInternoLocalServiceUtil.log("AllertaWorkflow", "getReportAsFile", e, "");
			return null;
		}

	}

	private Log _log = LogFactoryUtil.getLog(AllertaImpl.class);
	
}