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

package it.eng.bollettino.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import it.eng.allerter.service.LogInternoLocalServiceUtil;
import it.eng.bollettino.model.Allarme;
import it.eng.bollettino.model.AttivazioneFiume;
import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.model.BollettinoParametro;
import it.eng.bollettino.service.AllarmeLocalServiceUtil;
import it.eng.bollettino.service.AttivazioneFiumeLocalServiceUtil;
import it.eng.bollettino.service.BollettinoLocalServiceUtil;
import it.eng.bollettino.service.BollettinoParametroLocalServiceUtil;
import it.eng.bollettino.service.base.BollettinoLocalServiceBaseImpl;

/**
 * The implementation of the bollettino local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.eng.bollettino.service.BollettinoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoLocalServiceBaseImpl
 */
public class BollettinoLocalServiceImpl extends BollettinoLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.eng.bollettino.service.BollettinoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.bollettino.service.BollettinoLocalServiceUtil</code>.
	 */
	
	public List<Object> getFiumiBollettino(long id) {
		
		return bollettinoFinder.getFiumiBollettino(id);
	}
	
	public void terminaMonitoraggio() {
		
		try {
			
			BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("GESTIONE_MONITORAGGIO");
			if (bp!=null) {
				bp.setValore("false");
				BollettinoParametroLocalServiceUtil.updateBollettinoParametro(bp);
			}
			
			//carica gli allarmi attivi per disattivarli
			DynamicQuery all = DynamicQueryFactoryUtil.forClass(Allarme.class, getClassLoader()).add(PropertyFactoryUtil.forName("dataFine").isNull());
			List<Allarme> allarmi = AllarmeLocalServiceUtil.dynamicQuery(all);
			
			Date d = new Date();
			
			for (Allarme a : allarmi) {
				a.setDataFine(d);
				AllarmeLocalServiceUtil.updateAllarme(a);
			}
			
			cessatiTuttiAllarmiFiumi();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public long getApprovatore(long idBollettino) {
		
		return bollettinoFinder.getUtenteApprovatore(idBollettino);
		
	}
	
	public double getSommaValori(String idStazione, String idVariabile, int quanti) {
		
		return bollettinoFinder.getSommaValori(idStazione, idVariabile, quanti);
	}
	
	public String nextIdMonitoraggio(int anno) {
		return bollettinoFinder.nextIdMonitoraggio(anno);
	}
	
	public void cessatiTuttiAllarmiFiumi() {
		
		try {
			List<AttivazioneFiume> fiumi = AttivazioneFiumeLocalServiceUtil
					.getAttivazioneFiumes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (AttivazioneFiume af : fiumi) {
				if (af.getAttivo()) cessatoAllarmeFiume(af);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cessatoAllarmeFiume(AttivazioneFiume fiume) {
		
		String basin = fiume.getFiumeId();
		
		try {
			fiume.setAttivo(false);
			AttivazioneFiumeLocalServiceUtil.updateAttivazioneFiume(fiume);
			
			String fromSMS = "33312345678";
            try {
				BollettinoParametro bp = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("SMS_FROM_ALLARME");
				if (bp!=null) fromSMS = bp.getValore();
				
			} catch (Exception e) {}
			
			String nonTecnici = basin + "-NT";
			/*Organization ug = OrganizationLocalServiceUtil.fetchOrganization(20154, nonTecnici);
			if (ug!=null) {
				//cambiamo il testo per i non tecnici
				String text = "Cessato allarme fiume " + basin;
				SMSLocalServiceUtil.creaSMSOrganization(fromSMS, text, "fine-superamento", nonTecnici, 0, ug.getOrganizationId());
				
				SMSLocalServiceUtil.inviaSMS("fine-superamento", nonTecnici, 0);
				
				String ff = "superamenti@allertameteoer.it";
				
				try {
					BollettinoParametro bp2 = BollettinoParametroLocalServiceUtil.fetchBollettinoParametro("EMAIL_FROM_ALLARME");
					if (bp2!=null) ff = bp2.getValore();
					
				} catch (Exception e) {}
	    		
	    		SMSLocalServiceUtil.inviaEmail("fine-superamento", nonTecnici, 0, "Cessato allarme "+basin, "Terminato superamento soglia sul fiume "+basin, ff);    		
	    		
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		
	}
	
	public List<Bollettino> getListaBollettiniMonitoraggio() {
		
		DynamicQuery dyn = bollettinoLocalService
								.dynamicQuery()
								.add(PropertyFactoryUtil.forName("stato").ne(WorkflowConstants.STATUS_APPROVED))
								.addOrder(OrderFactoryUtil.desc("createDate"));
				
		return bollettinoLocalService.dynamicQuery(dyn);
		
	}

	
	public Object eseguiQueryGenerica(String q) {
		return bollettinoFinder.eseguiQueryGenerica(q);
	}
	
	public List eseguiQueryGenericaLista(String q) {
		return bollettinoFinder.eseguiQueryGenericaLista(q);
	}
	
public void fileDeleteByApp(String file, String folderName, ServiceContext serviceContext) {
		
		fileDeleteByApp(serviceContext.getScopeGroupId(), file, folderName);
		
	}
	
	public void fileDeleteByApp(long scopeGroup, String file, String folderName) {
		long repositoryId = scopeGroup;
		
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}

		try {
			Folder folder = DLAppServiceUtil.getFolder(scopeGroup, parentFolderId, folderName);
			List<FileEntry> l = DLAppServiceUtil.getFileEntries(repositoryId, folder.getFolderId());
			for (FileEntry fe : l) {
				if (fe.getTitle().startsWith(file))
					DLAppServiceUtil.deleteFileEntryByTitle(repositoryId, folder.getFolderId(), fe.getTitle());
			}
			// DLAppServiceUtil.deleteFileEntryByTitle(repositoryId, folder.getFolderId(),
			// file);
		} catch (Exception e) {
			System.out.println("Exception");
			_log.error(e);
			//LogInternoLocalServiceUtil.log("BollettinoBean", "fileDeleteByApp", e, "");
		}
	}
	
	public void fileUploadByApp(File file, String folderName, String title,
			String description, String mimeType, ServiceContext serviceContext) {
		
		System.out.println("Exist=>" + file.exists());
		long repositoryId = serviceContext.getScopeGroupId();
		System.out.println("repositoryId=>" + serviceContext.getScopeGroupId());
		
		String changeLog = "hi";
		Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try {
			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("BOLLETTINO_PARENT_FOLDER_ID");
			if (ap != null)
				parentFolderId = Long.parseLong(ap.getValore());
		} catch (Exception e) {
		}
		
		Folder folder = null;
		try {
			
			folder = DLAppServiceUtil.getFolder(serviceContext.getScopeGroupId(), parentFolderId, folderName);
		} catch(Exception e) {
			
			System.out.println("Folder NULL create: " + parentFolderId + " " + serviceContext.getScopeGroupId());
			try {
				folder = DLAppServiceUtil.addFolder(serviceContext.getScopeGroupId(), parentFolderId, folderName, "bollettini", serviceContext);
			} catch (PortalException e1) {
				
			}
		}

		try {
			
			InputStream is = new FileInputStream(file);
			ServiceContext dlServiceContext = serviceContext.getRequest()!=null?ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), serviceContext.getRequest()):serviceContext;
			FileEntry f = DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), file.getName(), mimeType,
					title, description, changeLog, is, file.length(), dlServiceContext);

			Role guestRole = RoleLocalServiceUtil.getRole(serviceContext.getCompanyId(), RoleConstants.GUEST);
			ResourcePermissionLocalServiceUtil.setResourcePermissions(serviceContext.getCompanyId(),
					DLFileEntry.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, String.valueOf(f.getFileEntryId()),
					guestRole.getRoleId(), new String[] { "VIEW" });

			BollettinoParametro ap = BollettinoParametroLocalServiceUtil
					.fetchBollettinoParametro("BOLLETTINO_RUOLI_MODIFICA_LINK");
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
			//LogInternoLocalServiceUtil.log("BollettinoBean", "fileUploadByApp", e, "");
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(BollettinoLocalServiceImpl.class);
	
}