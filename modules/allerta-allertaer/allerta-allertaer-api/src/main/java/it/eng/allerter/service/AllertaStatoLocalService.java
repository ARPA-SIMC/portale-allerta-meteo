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

package it.eng.allerter.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.eng.allerter.model.AllertaStato;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for AllertaStato. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author GFAVINI
 * @see AllertaStatoLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AllertaStatoLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AllertaStatoLocalServiceUtil} to access the allerta stato local service. Add custom service methods to <code>it.eng.allerter.service.impl.AllertaStatoLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the allerta stato to the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AllertaStato addAllertaStato(AllertaStato allertaStato);

	/**
	 * Creates a new allerta stato with the primary key. Does not add the allerta stato to the database.
	 *
	 * @param allertaStatoId the primary key for the new allerta stato
	 * @return the new allerta stato
	 */
	@Transactional(enabled = false)
	public AllertaStato createAllertaStato(long allertaStatoId);

	/**
	 * Deletes the allerta stato from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AllertaStato deleteAllertaStato(AllertaStato allertaStato);

	/**
	 * Deletes the allerta stato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato that was removed
	 * @throws PortalException if a allerta stato with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AllertaStato deleteAllertaStato(long allertaStatoId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public AllertaStato fetchAllertaStato(long allertaStatoId);

	/**
	 * Returns the allerta stato matching the UUID and group.
	 *
	 * @param uuid the allerta stato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta stato, or <code>null</code> if a matching allerta stato could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AllertaStato fetchAllertaStatoByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the allerta stato with the primary key.
	 *
	 * @param allertaStatoId the primary key of the allerta stato
	 * @return the allerta stato
	 * @throws PortalException if a allerta stato with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AllertaStato getAllertaStato(long allertaStatoId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AllertaStato> getAllertaStatoByAllerta(long allertaId);

	/**
	 * Returns the allerta stato matching the UUID and group.
	 *
	 * @param uuid the allerta stato's UUID
	 * @param groupId the primary key of the group
	 * @return the matching allerta stato
	 * @throws PortalException if a matching allerta stato could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AllertaStato getAllertaStatoByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the allerta statos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaStatoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @return the range of allerta statos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AllertaStato> getAllertaStatos(int start, int end);

	/**
	 * Returns all the allerta statos matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta statos
	 * @param companyId the primary key of the company
	 * @return the matching allerta statos, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AllertaStato> getAllertaStatosByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of allerta statos matching the UUID and company.
	 *
	 * @param uuid the UUID of the allerta statos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of allerta statos
	 * @param end the upper bound of the range of allerta statos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching allerta statos, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AllertaStato> getAllertaStatosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AllertaStato> orderByComparator);

	/**
	 * Returns the number of allerta statos.
	 *
	 * @return the number of allerta statos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAllertaStatosCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the allerta stato in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param allertaStato the allerta stato
	 * @return the allerta stato that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AllertaStato updateAllertaStato(AllertaStato allertaStato);

}