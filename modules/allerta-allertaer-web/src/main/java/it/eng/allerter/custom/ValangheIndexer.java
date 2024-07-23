package it.eng.allerter.custom;

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

import it.eng.allerter.model.AllertaValanghe;
import it.eng.allerter.service.AllertaValangheLocalService;

@Component(
		immediate = true, 
		service = Indexer.class
		)
public class ValangheIndexer extends BaseIndexer<AllertaValanghe> {

	public static final String PORTLET_ID = "AllertaValanghe-sb";

	@Override
	public String getClassName() {
		return AllertaValanghe.class.getName();
	}

	@Override
	protected void doDelete(AllertaValanghe object) throws Exception {
		AllertaValanghe a = (AllertaValanghe)object;
		deleteDocument(a.getCompanyId(), a.getAllertaValangheId());
	}

	@Override
	protected Document doGetDocument(AllertaValanghe object) throws Exception {
		// TODO Auto-generated method stub
		AllertaValanghe a = (AllertaValanghe)object;
		System.out.println("DOGETDOCUMENT AllertaValanghe "+a.getAllertaValangheId());
		Document document = getBaseModelDocument(PORTLET_ID, a);
		document.addDate(Field.MODIFIED_DATE, a.getModifiedDate());
		document.addText(Field.CONTENT, a.getDescrizioneFenomeni() + a.getNote() + a.getRiferimenti());
		document.addText(Field.TITLE,a.getTitolo());
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(a.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, a.getGroupId());
		
		return document;
	
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, 
			PortletRequest portletRequest, PortletResponse portletResponse) throws Exception {
		
		Summary s = createSummary(document);
		return s;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		
		AllertaValanghe a = AllertaValangheLocalService.getAllertaValanghe(classPK);
		
		doReindex(a);
		
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);
		
		reindexEntries(companyId);
	}
	
	private void reindexEntries(long companyId) throws Exception {

		 final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
				 AllertaValangheLocalService.getIndexableActionableDynamicQuery();

		        indexableActionableDynamicQuery.setCompanyId(companyId);

		        indexableActionableDynamicQuery.setPerformActionMethod(
		            new ActionableDynamicQuery.PerformActionMethod<AllertaValanghe>() {

		                @Override
		                public void performAction(AllertaValanghe entry) {

		                    try {
		                        Document document = getDocument(entry);
		                        indexableActionableDynamicQuery.addDocuments(document);
		                    }
		                    catch (PortalException pe) {
		                        if (_log.isWarnEnabled()) {
		                            _log.warn(
		                                "Unable to index entry " + entry.getAllertaValangheId(),
		                                pe);
		                        }
		                    }
		                }
		            });
		        indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		        indexableActionableDynamicQuery.performActions();
		
	}



	@Override
	protected void doReindex(AllertaValanghe object) throws Exception {
	
		Document d = getDocument(object);
		
		indexWriterHelper.updateDocument(getSearchEngineId(), 
				object.getCompanyId(), d, true);
	}
	
	@Reference
	private AllertaValangheLocalService AllertaValangheLocalService;

	@Reference
    protected IndexWriterHelper indexWriterHelper;

	
	private Log _log = LogFactoryUtil.getLog(ValangheIndexer.class);
	
	
}
