/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.AllertaValanghe;

import java.io.File;
import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for AllertaValanghe. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author GFAVINI
 * @see AllertaValangheLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AllertaValangheLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>it.eng.allerter.service.impl.AllertaValangheLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the allerta valanghe local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AllertaValangheLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the allerta valanghe to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaValangheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allertaValanghe the allerta valanghe
	 * @return the allerta valanghe that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AllertaValanghe addAllertaValanghe(AllertaValanghe allertaValanghe);

	/**
	 * Creates a new allerta valanghe with the primary key. Does not add the allerta valanghe to the database.
	 *
	 * @param allertaValangheId the primary key for the new allerta valanghe
	 * @return the new allerta valanghe
	 */
	@Transactional(enabled = false)
	public AllertaValanghe createAllertaValanghe(long allertaValangheId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the allerta valanghe from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaValangheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allertaValanghe the allerta valanghe
	 * @return the allerta valanghe that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AllertaValanghe deleteAllertaValanghe(
		AllertaValanghe allertaValanghe);

	/**
	 * Deletes the allerta valanghe with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaValangheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe that was removed
	 * @throws PortalException if a allerta valanghe with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AllertaValanghe deleteAllertaValanghe(long allertaValangheId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaValangheModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaValangheModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AllertaValanghe fetchAllertaValanghe(long allertaValangheId);

	/**
	 * Returns the allerta valanghe matching the UUID and group.
	 *
	 * @param uuid the allerta valanghe's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta valanghe, or <code>null</code> if a matching allerta valanghe could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AllertaValanghe fetchAllertaValangheByUuidAndGroupId(
		String uuid, long groupId);

	public void fileDeleteByApp(
		String file, String folderName, ServiceContext serviceContext);

	public void fileUploadByApp(
		File file, String folderName, String title, String description,
		String mimeType, ServiceContext serviceContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the allerta valanghe with the primary key.
	 *
	 * @param allertaValangheId the primary key of the allerta valanghe
	 * @return the allerta valanghe
	 * @throws PortalException if a allerta valanghe with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AllertaValanghe getAllertaValanghe(long allertaValangheId)
		throws PortalException;

	/**
	 * Returns the allerta valanghe matching the UUID and group.
	 *
	 * @param uuid the allerta valanghe's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta valanghe
	 * @throws PortalException if a matching allerta valanghe could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AllertaValanghe getAllertaValangheByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the allerta valanghes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaValangheModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @return the range of allerta valanghes
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AllertaValanghe> getAllertaValanghes(int start, int end);

	/**
	 * Returns all the allerta valanghes matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta valanghes
	 * @param companyId the primary key of the company
	 * @return the matching allerta valanghes, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AllertaValanghe> getAllertaValanghesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of allerta valanghes matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta valanghes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allerta valanghes
	 * @param end the upper bound of the range of allerta valanghes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allerta valanghes, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AllertaValanghe> getAllertaValanghesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaValanghe> orderByComparator);

	/**
	 * Returns the number of allerta valanghes.
	 *
	 * @return the number of allerta valanghes
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAllertaValanghesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AllertaValanghe> getAllertaValanghesOrdered(
		int start, int end, OrderByComparator<AllertaValanghe> comparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DLFolder getDLFolder(
		String folderName, ServiceContext serviceContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Folder getFolder(long groupId, String folderName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getIdApprovatore(long id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getInfoValanghe();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getInfoValangheDomani();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AllertaValanghe> getListaAllerteValanghe();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public String nextIdAllertaValanghe(boolean allerta, int anno);

	public void spedisciNotifiche(
		String tipo, String sottotipo, long l, String emailSubject,
		String emailText, AllertaValanghe av);

	/**
	 * Updates the allerta valanghe in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaValangheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allertaValanghe the allerta valanghe
	 * @return the allerta valanghe that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AllertaValanghe updateAllertaValanghe(
		AllertaValanghe allertaValanghe);

}