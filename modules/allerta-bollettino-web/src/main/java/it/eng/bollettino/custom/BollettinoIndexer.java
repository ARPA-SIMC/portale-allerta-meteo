package it.eng.bollettino.custom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;

import it.eng.bollettino.model.Bollettino;
import it.eng.bollettino.service.BollettinoLocalService;

@Component(
		immediate = true, 
		service = Indexer.class
		)
public class BollettinoIndexer extends BaseIndexer<Bollettino> {
	
	public static final String PORTLET_ID = "Bollettino-sb";
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return Bollettino.class.getName();
	}
	
	@Override
	protected void doDelete(Bollettino object) throws Exception {
		// TODO Auto-generated method stub
		Bollettino a = (Bollettino)object;
		deleteDocument(a.getCompanyId(), a.getBollettinoId());
		
	}
	
	@Override
	protected Document doGetDocument(Bollettino object) throws Exception {
		
		// TODO Auto-generated method stub
				
		Bollettino a = (Bollettino)object;
		
		Document document = getBaseModelDocument(PORTLET_ID, a);
		document.addDate(Field.MODIFIED_DATE, a.getModifiedDate());
		document.addText(Field.CONTENT, a.getNoteMeteo());
		document.addText(Field.TITLE,"Bollettino "+a.getNumero());
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(a.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, a.getGroupId());
				
		return document;
	
	}
	
	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		
		return createSummary(document);
		
		
	}
	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		// TODO Auto-generated method stub
				
		try {
			Bollettino a = bollettinoLocalService.getBollettino(classPK);
			doReindex(a);
				
		} catch (Exception e) { 
			_log.error(e);
		}
	}
	
	@Override
	protected void doReindex(String[] ids) throws Exception {
				
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}
	
	@Override
	protected void doReindex(Bollettino object) throws Exception {
		
		Bollettino a = (Bollettino)object;
		Document d = getDocument(a);
		indexWriterHelper.updateDocument(getSearchEngineId(), 
				a.getCompanyId(), d, true);
	}
	
	private void reindexEntries(long companyId) throws Exception {
		// TODO Auto-generated method stub
		final Collection<Document> documents = new ArrayList<Document>();
		
		 final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
		            bollettinoLocalService.getIndexableActionableDynamicQuery();

		        indexableActionableDynamicQuery.setCompanyId(companyId);

		        indexableActionableDynamicQuery.setPerformActionMethod(
		            new ActionableDynamicQuery.PerformActionMethod<Bollettino>() {

		                @Override
		                public void performAction(Bollettino entry) {

		                    try {
		                        Document document = getDocument(entry);
		                        indexableActionableDynamicQuery.addDocuments(document);
		                    }
		                    catch (PortalException pe) {
		                        if (_log.isWarnEnabled()) {
		                            _log.warn(
		                                "Unable to index entry " + entry.getBollettinoId(),
		                                pe);
		                        }
		                    }
		                }
		            });
		        indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		        indexableActionableDynamicQuery.performActions();
		        
//	
//		actionableDynamicQuery.setCompanyId(companyId);
//		actionableDynamicQuery.performActions();
//		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId, documents,true);
	}
	
	@Reference
	private BollettinoLocalService bollettinoLocalService;

	@Reference
    protected IndexWriterHelper indexWriterHelper;

	
	private Log _log = LogFactoryUtil.getLog(BollettinoIndexer.class);
	
	/*
	
	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		return PORTLET_ID;
	}




*/
}
