package it.eng.allerter.allerta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.workflow.WorkflowConstants;


public class DocumentModelBean {
	
		public class FilenameComparator implements Comparator<FolderToView> {

			@Override
			public int compare(FolderToView arg0, FolderToView arg1) {
				
				if (arg0==null) return -1;
				if (arg1==null) return 1;
				String s1 = arg0.getTitle();
				String s2 = arg1.getTitle();
				
				if (s1==null) return -1; else return s1.compareTo(s2);
			}
			
		}

	// serialVersionUID
		private static final long   serialVersionUID = 7459438254337818761L;
		private Log logger = LogFactoryUtil.getLog(DocumentModelBean.class);
	    private long   companyId;

	    
	    // ID DEL PORTALE (WEBALLERTE)
	    private static long groupId = 20181;
	    private long   folderid     = 0;
	    
	    private String TAVOLE ="tavole";
		private String PianiETavole ="PIANI COMUNALI";
		
		private List<FolderToView> mappeReticoloIdraulico;
	    
	    // MAPPE DEL RETICOLO IDRAULICO 
	    private static long ID_FOLDER_MAPPE_RETICOLO_IDRAULICO = 61505;
	    private String showMappeReticoloIdraulico; 
	    private List<FolderToView> baseDocuments = new ArrayList<FolderToView>();
	    private List<FolderToView> listTavoleDocuments = new ArrayList<FolderToView>();
	    
	    
	    // MAPPE DEI MEZZI E DELLE ATTREZZATURE 
	    private static long ID_FOLDER_MAPPE_DEI_MEZZI_E_ATTREZZATURE = 61514;
	    private String showMappeDeiMezziEattrezzature; 
	    private List<FolderToView> mappeDeiMezziEattrezzature;
	    
	     // MAPPE DEI PUNTI CRITICI
	    private static long ID_FOLDER_MAPPE_PUNTI_CRITICI =61508;
	    private String showMappePuntiCritici; 
	    private List<FolderToView> mappePuntiCritici;
	    
	    // AREE SUSCETTIBILI A FRANE  ( MAPPE DEL SISSESTO ) 
	    private static long ID_FOLDER_MAPPE_DISSESTO = 60322;
	    private String showMappeFraneDissesto; 
	    private List<FolderToView> mappeFraneDissesto;
	    
		// MAPPE DELLA PERICOLOSITA' E RISCHIO ALLUVIONI
	    private static long ID_FOLDER_MAPPE_PERICOLOSITA_E_RISCHIO_ALLUVIONI =61502;
	    private String showMappePericolositaErischioAlluvioni; 
	    private List<FolderToView> mappePericolositaErischioAlluvioni;
	    
	    private static long ID_FOLDER_MAPPE_RISCHIO_ALLUVIONI = 255684;
	    private List<FolderToView> mappeRischioAlluvioni;
	 
	    // Mappe della aree di emergenza e dei centri operativi 
	    private static long ID_FOLDER_MAPPE_AREE_EMERGENZA_E_CENTRI_OPERATIVI =61502;
	    private String showMappeEmergenzaEcentriOperativi; 
	 	private List<FolderToView> mappeEmergenzaEcentriOperativi;
	 	
	 	private ThemeDisplay themeDisplay;
	 	
	 	public DocumentModelBean(ThemeDisplay themeDisplay) {
	 		
	 		this.themeDisplay = themeDisplay;
	 	}
	    
	 		
		public void reset(String siteName) throws PortalException, SystemException {
			
			logger.info("@@@@@@@@@@@ RESET  DOCUMENT MODEL BEAN SITE NAME "+siteName);
			
			// preparo la lista delle avriabili 
			
			this.showMappeReticoloIdraulico="no";
			this.mappeReticoloIdraulico = new ArrayList<>();
			
			
			this.showMappeDeiMezziEattrezzature="no";
			this.mappeDeiMezziEattrezzature = new ArrayList<>();
			
			this.showMappePuntiCritici   = "no";	
			this.mappePuntiCritici   	 = new ArrayList<>();
			
			this.showMappeFraneDissesto ="no";
			this.mappeFraneDissesto     = new ArrayList<>();
			
			this.showMappePericolositaErischioAlluvioni 	 = "no";
			this.mappePericolositaErischioAlluvioni     	 = new ArrayList<>();
			
			
			this.showMappeEmergenzaEcentriOperativi="no"; 
			this.mappeEmergenzaEcentriOperativi=   new ArrayList<>();
			
		
			
		}
		
		public List<FolderToView> getPianiTavoleDocuments(String siteName) {
			
			
			searchFileInFolder(PianiETavole, themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, baseDocuments);
			
			return baseDocuments;
		}
		
		public List<FolderToView> getTavoleDocuments(String siteName) {
			
			
			searchFileInFolder(TAVOLE, themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, listTavoleDocuments);
			
			return listTavoleDocuments;
		}
		
		/*
		 *  GET RETICOLO IDRAULICO
		 */
		private void getFileMezziEdAttrezzature(String siteName){
			
			logger.info(" @@ GET FILE MEZZI ED ATTREZZATURE ");
			
			try {
				// CERCO I FILE PER  AREE SUSCETTIBILI A FRANE
				this.searchFileInFolder(siteName, groupId, ID_FOLDER_MAPPE_DEI_MEZZI_E_ATTREZZATURE, showMappeDeiMezziEattrezzature, mappeDeiMezziEattrezzature);
				
			} catch (SystemException e) {
				logger.info(" @@ CATTURATA ECCEZZIONE NEL PRELIEVO DELLE MAPPE @@"+ID_FOLDER_MAPPE_DEI_MEZZI_E_ATTREZZATURE);
			}
		}
		
		
		/*
		 *  GET RETICOLO IDRAULICO
		 */
		private void getFileEmergenzaEcentriOperativi(String siteName){
			
			logger.info(" @@ GET FILE EMERGENZA E CENTRI OPERATIVI  ");
			
			try {
				// CERCO I FILE PER  AREE SUSCETTIBILI A FRANE
				this.searchFileInFolder(siteName, groupId, ID_FOLDER_MAPPE_AREE_EMERGENZA_E_CENTRI_OPERATIVI, showMappeEmergenzaEcentriOperativi, mappeEmergenzaEcentriOperativi);
				
			} catch (SystemException e) {
				logger.info(" @@ CATTURATA ECCEZZIONE NEL PRELIEVO DELLE MAPPE @@"+ID_FOLDER_MAPPE_AREE_EMERGENZA_E_CENTRI_OPERATIVI);
			}
		}
		
		/*
		 *  GET RETICOLO IDRAULICO
		 */
		private void getFileForReticoloIdraulico(String siteName){
			
			logger.info(" @@ GET FILE PER RETICOLO IDRAULICO  ");
			
			try {
				// CERCO I FILE PER  AREE SUSCETTIBILI A FRANE
				this.searchFileInFolder(siteName, groupId, ID_FOLDER_MAPPE_RETICOLO_IDRAULICO, showMappeReticoloIdraulico, mappeReticoloIdraulico);
				
			} catch (SystemException e) {
				logger.info(" @@ CATTURATA ECCEZZIONE NEL PRELIEVO DELLE MAPPE @@"+ID_FOLDER_MAPPE_RETICOLO_IDRAULICO);
			}
		}
		
		/*
		 *  GET MAPPE DEI PUNTI CRITICI 
		 */
		private void getFileForPuntiCritici(String siteName){
			
			logger.info(" @@ GET FILE PER PUNTI CRITICI  ");
			
			try {
				// CERCO I FILE PER  AREE SUSCETTIBILI A FRANE
				this.searchFileInFolder(siteName, groupId, ID_FOLDER_MAPPE_PUNTI_CRITICI, showMappePuntiCritici, mappePuntiCritici);
				
			} catch (SystemException e) {
				logger.info(" @@ CATTURATA ECCEZZIONE NEL PRELIEVO DELLE MAPPE @@"+ID_FOLDER_MAPPE_PUNTI_CRITICI);
			}
		}
		
		/*
		 *  GET MAPPE DELLE ALLUVIONI  
		 */
		public List<FolderToView> getFileForAlluvioni(String siteName ) {
			
			logger.info(" @@ GET FILE PER ALLUVIONI ");
			
			this.mappePericolositaErischioAlluvioni = new ArrayList<>();
			
			try {
				// CERCO I FILE PER  AREE SUSCETTIBILI A FRANE
				this.searchFileInFolder(siteName, groupId, ID_FOLDER_MAPPE_PERICOLOSITA_E_RISCHIO_ALLUVIONI, showMappePericolositaErischioAlluvioni,mappePericolositaErischioAlluvioni);
				
			} catch (SystemException e) {
				logger.info(" @@ CATTURATA ECCEZZIONE NEL PRELIEVO DELLE MAPPE @@"+ID_FOLDER_MAPPE_PERICOLOSITA_E_RISCHIO_ALLUVIONI);
			}
			
			return mappePericolositaErischioAlluvioni;
		}
		
		public List<FolderToView> getFileForRischioAlluvioni(String siteName ) {
			
			logger.info(" @@ GET FILE PER ALLUVIONI ");
			
			this.mappeRischioAlluvioni = new ArrayList<>();
			
			try {
				// CERCO I FILE PER  AREE SUSCETTIBILI A FRANE
				this.searchFileInFolder(siteName, groupId, ID_FOLDER_MAPPE_RISCHIO_ALLUVIONI, showMappePericolositaErischioAlluvioni, mappeRischioAlluvioni);
				
			} catch (SystemException e) {
				logger.info(" @@ CATTURATA ECCEZZIONE NEL PRELIEVO DELLE MAPPE @@"+ID_FOLDER_MAPPE_RISCHIO_ALLUVIONI);
			}
			
			return mappeRischioAlluvioni;
		}
		
		/*
		 *  GET MAPPE DI DISSESTO 
		 */
		public List<FolderToView> getFileForMappeDissesto(String siteName ){
			
			logger.info(" @@ GET FILE PER MAPPE DEL DISSESTO (frane) ");
			
			this.mappeFraneDissesto = new ArrayList<>();
			
			try {
				// CERCO I FILE PER  AREE SUSCETTIBILI A FRANE
				this.searchFileInFolder(siteName, groupId, ID_FOLDER_MAPPE_DISSESTO, showMappeFraneDissesto, mappeFraneDissesto);
				
			} catch (SystemException e) {
				logger.info(" @@ CATTURATA ECCEZZIONE NEL PRELIEVO DELLE MAPPE @@"+ID_FOLDER_MAPPE_DISSESTO);
			}
			
			return mappeFraneDissesto;
		}
		
		private Long searchFileInFolder(String folderSearchName,long groupId,long folderBase,List<FolderToView> listFolder) throws SystemException{

//			logger.info(">>>  SEARCH FILE IN FOLDER START");

			List<DLFolder> dlFolders = DLFolderLocalServiceUtil.getFolders(groupId, folderBase);
			Long folderFounded = null;
			if(dlFolders.size()>0){
//				logger.info("@ NUMERO CARTELLE TROVATE "+dlFolders.size());

				Iterator<DLFolder> itProv   = dlFolders.iterator();
				DLFolder actualFolder;
				Boolean find=false;			

				String folderName;

				while(itProv.hasNext() && !find){

					actualFolder = itProv.next();
					folderName = actualFolder.getName();

					find = this.matchName(folderSearchName, folderName,groupId,actualFolder.getFolderId());

					if(find){
//						logger.info("@TROVATA LA CARTELLA delle tavole ");
						folderFounded = actualFolder.getFolderId();
						this.getFileInFolder(groupId, actualFolder.getFolderId(),"no", listFolder);
					}
				}
			}
			
			if (listFolder!=null && listFolder.size()>1) {
				listFolder.sort(new FilenameComparator());
			}
			
			return folderFounded;
		}
		
		
		private void searchFileInFolder(String siteName,long groupId,long folderBase,String show,List<FolderToView> listFolder) throws SystemException{
		
		   logger.info(">>>  SEARCH FILE IN FOLDER START per "+folderBase);
			
			List<DLFolder> dlFolders = DLFolderLocalServiceUtil.getFolders(groupId, folderBase);
			List<DLFolder> dlFoldersComune =null;
			
					
			if(dlFolders.size()>0){
				logger.info("@ NUMERO PROVINCE ( CARTELLE DI PRIMO LIVELLO ) TROVATE "+dlFolders.size());
				
				Iterator<DLFolder> itProv   = dlFolders.iterator();
				Iterator<DLFolder> itComune =null;;
				DLFolder actualFolder;
				Boolean find=false;			
				long folderId;
				String folderName;
				
				while(itProv.hasNext() && !find){
					
					
					actualFolder = itProv.next();
					folderName = actualFolder.getName();
					folderId     = actualFolder.getFolderId();
					
					find = this.matchName(siteName, folderName,groupId,actualFolder.getFolderId());
					
					if(find){	
						logger.info("@TROVATA LA CARTELLA COME PROVINCIA");
						 this.getFileInFolder(groupId, actualFolder.getFolderId(),show,listFolder);
			     	}
					else{
					
					// Prendiamo tutte le cartelle compresa se stessa per questo è impostata a true 
					
					dlFoldersComune = DLFolderLocalServiceUtil.getFolders(groupId,folderId , true);
					
					// SE CI SONO CARTELLE FIGLIE 
					if(dlFoldersComune!=null && dlFoldersComune.size()>0){
						 itComune=dlFoldersComune.iterator();
						 while(itComune.hasNext() && !find){
							    actualFolder = itComune.next();
							    folderName = actualFolder.getName();
								find = this.matchName(siteName, folderName,groupId,actualFolder.getFolderId());
								
								if(find){								
									 this.getFileInFolder(groupId, actualFolder.getFolderId(),show,listFolder);
							}
						}
					}
					}
				}
			}
			
			if (listFolder!=null && listFolder.size()>1) {
				listFolder.sort(new FilenameComparator());
			}
		}
		

	   /*
	    *  FUNZIONE DI RICERCA CARTELLA IN BASE AL NOME 
	    */
	   private boolean matchName(String site,String folder,long groupId,long folderId){
		   
		   boolean match= false;
		   site = site.toLowerCase().trim().replace(" ", "").replaceAll("(?m)(:?\\d+) \\* x\\^(:?\\d+)", "$1x<sup>$2</sup>");;
		   folder = folder.toLowerCase().trim().replace(" ", "").replaceAll("(?m)(:?\\d+) \\* x\\^(:?\\d+)", "$1x<sup>$2</sup>");;
		   
		   if(site.equalsIgnoreCase(folder)){
			   logger.info("TROVATA UNA  CARTELLA CHE METCHA CON IL NOME DEL SITO"+folder);
			   match= true;
			   
			  
		   }
		   
		   return match;
	   }	

	   
	   private void getFileInFolder(long groupId,long folderId,String show,List<FolderToView> file){
		
		   String url = null;
		   List<DLFileEntry> fileEntryService = null;     
		   FolderToView folder;
		   
		   logger.info("@@@ CERCO I FILE NELLA CARTELLA  "+folderId +" con groupId"+groupId);
		 
		   try {  
		       fileEntryService = DLFileEntryLocalServiceUtil.getFileEntries(groupId,folderId); 
		       logger.info("Numero Di File trovati "+fileEntryService.size());
		       
		       if(fileEntryService.size()>0){   show="si";  }else{ show="no"; }
		       
		       for(DLFileEntry fileEntryObj : fileEntryService){  
		    	   
		    	   if( fileEntryObj.getStatus() == WorkflowConstants.STATUS_APPROVED) {
			    	   url    = formatUrl(fileEntryObj.getUuid(), Long.toString(groupId));
			    	   folder = new FolderToView(fileEntryObj.getUuid(), fileEntryObj.getTitle(),fileEntryObj.getDescription(), url);
			    	   file.add(folder);
			  		   logger.info(folder.toString());   
		    	   }
		       } 
		   }catch (SystemException e) {  
		       e.printStackTrace();  
		   }     
	   }
	   
	   
	   /*
	    *  FORMATTO URL PER LA PREVIEW DEL PDF 
	    */
	   private String formatUrl(String uuid,String groupId) {
		   
		   //LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
		   //String url = liferayFacesContext.getPortalURL()+"/c/document_library/get_file?uuid="+uuid+"&groupId="+groupId;
		   //return url;
		   return "/c/document_library/get_file?uuid="+uuid+"&groupId="+groupId;
	   }
	   
		public final long getCompanyId() {
			return companyId;
		}

		public final void setCompanyId(long companyId) {
			this.companyId = companyId;
		}



		public final long getGroupId() {
			return groupId;
		}

		public final void setGroupId(long groupId) {
			this.groupId = groupId;
		}

		public final long getFolderid() {
			return folderid;
		}

		public final void setFolderid(long folderid) {
			this.folderid = folderid;
		}



		public final String getShowMappeFraneDissesto() {
			return showMappeFraneDissesto;
		}


		public final void setShowMappeFraneDissesto(String showMappeFraneDissesto) {
			this.showMappeFraneDissesto = showMappeFraneDissesto;
		}


		public final List<FolderToView> getMappeFraneDissesto() {
			
			return mappeFraneDissesto;
		}


		public final void setMappeFraneDissesto(List<FolderToView> mappeFraneDissesto) {
			this.mappeFraneDissesto = mappeFraneDissesto;
		}

		
		





		public final String getShowMappeReticoloIdraulico() {
			return showMappeReticoloIdraulico;
		}


		public final void setShowMappeReticoloIdraulico(String showMappeReticoloIdraulico) {
			this.showMappeReticoloIdraulico = showMappeReticoloIdraulico;
		}


		public final List<FolderToView> getMappeReticoloIdraulico() {
			return mappeReticoloIdraulico;
		}


		public final void setMappeReticoloIdraulico(List<FolderToView> mappeReticoloIdraulico) {
			this.mappeReticoloIdraulico = mappeReticoloIdraulico;
		}


		public final String getShowMappeDeiMezziEattrezzature() {
			return showMappeDeiMezziEattrezzature;
		}


		public final void setShowMappeDeiMezziEattrezzature(String showMappeDeiMezziEattrezzature) {
			this.showMappeDeiMezziEattrezzature = showMappeDeiMezziEattrezzature;
		}


		public final List<FolderToView> getMappeDeiMezziEattrezzature() {
			return mappeDeiMezziEattrezzature;
		}


		public final void setMappeDeiMezziEattrezzature(List<FolderToView> mappeDeiMezziEattrezzature) {
			this.mappeDeiMezziEattrezzature = mappeDeiMezziEattrezzature;
		}


		public final String getShowMappePericolositaErischioAlluvioni() {
			return showMappePericolositaErischioAlluvioni;
		}


		public final void setShowMappePericolositaErischioAlluvioni(String showMappePericolositaErischioAlluvioni) {
			this.showMappePericolositaErischioAlluvioni = showMappePericolositaErischioAlluvioni;
		}


		public final List<FolderToView> getMappePericolositaErischioAlluvioni() {
			return mappePericolositaErischioAlluvioni;
		}


		public final void setMappePericolositaErischioAlluvioni(List<FolderToView> mappePericolositaErischioAlluvioni) {
			this.mappePericolositaErischioAlluvioni = mappePericolositaErischioAlluvioni;
		}


		public final String getShowMappePuntiCritici() {
			return showMappePuntiCritici;
		}


		public final void setShowMappePuntiCritici(String showMappePuntiCritici) {
			this.showMappePuntiCritici = showMappePuntiCritici;
		}


		public final List<FolderToView> getMappePuntiCritici() {
			return mappePuntiCritici;
		}


		public final void setMappePuntiCritici(List<FolderToView> mappePuntiCritici) {
			this.mappePuntiCritici = mappePuntiCritici;
		}




		public final String getShowMappeEmergenzaEcentriOperativi() {
			return showMappeEmergenzaEcentriOperativi;
		}


		public final void setShowMappeEmergenzaEcentriOperativi(String showMappeEmergenzaEcentriOperativi) {
			this.showMappeEmergenzaEcentriOperativi = showMappeEmergenzaEcentriOperativi;
		}


		public final List<FolderToView> getMappeEmergenzaEcentriOperativi() {
			return mappeEmergenzaEcentriOperativi;
		}


		public final void setMappeEmergenzaEcentriOperativi(List<FolderToView> mappeEmergenzaEcentriOperativi) {
			this.mappeEmergenzaEcentriOperativi = mappeEmergenzaEcentriOperativi;
		}

}
