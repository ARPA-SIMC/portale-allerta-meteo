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

package it.eng.allerte.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
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

import it.eng.allerte.model.RubricaGruppo;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides the local service interface for RubricaGruppo. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Pratola_L
 * @see RubricaGruppoLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface RubricaGruppoLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RubricaGruppoLocalServiceUtil} to access the rubrica gruppo local service. Add custom service methods to <code>it.eng.allerte.service.impl.RubricaGruppoLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the rubrica gruppo to the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 * @return the rubrica gruppo that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public RubricaGruppo addRubricaGruppo(RubricaGruppo rubricaGruppo);

	public void aggiornaTuttoGruppo(Long gruppo);

	/**
	 * Creates a new rubrica gruppo with the primary key. Does not add the rubrica gruppo to the database.
	 *
	 * @param ID_GRUPPO the primary key for the new rubrica gruppo
	 * @return the new rubrica gruppo
	 */
	@Transactional(enabled = false)
	public RubricaGruppo createRubricaGruppo(long ID_GRUPPO);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the rubrica gruppo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo that was removed
	 * @throws PortalException if a rubrica gruppo with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public RubricaGruppo deleteRubricaGruppo(long ID_GRUPPO)
		throws PortalException;

	/**
	 * Deletes the rubrica gruppo from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 * @return the rubrica gruppo that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public RubricaGruppo deleteRubricaGruppo(RubricaGruppo rubricaGruppo);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public RubricaGruppo fetchRubricaGruppo(long ID_GRUPPO);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<Object[]> getGerarchia(Long site);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Object[]> getGroup(Long id);

	/**
	 * Il metodo restituisce le info sul gruppo a partire dal nome e per il sito proprietario
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RubricaGruppo getGroupForOwnerByName(Long ownerId, String groupName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<Object[]> getGruppiByName(
		Long site, String groupName, Long limit, Long offset);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ArrayList<Object[]> getGruppiByNameCategoria(
		Long site, String groupName, Long categoria, Long limit, Long offset);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Object[] getGruppiByOwnerAndName(Long idOwner, String groupName);

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
	 * Returns the rubrica gruppo with the primary key.
	 *
	 * @param ID_GRUPPO the primary key of the rubrica gruppo
	 * @return the rubrica gruppo
	 * @throws PortalException if a rubrica gruppo with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public RubricaGruppo getRubricaGruppo(long ID_GRUPPO)
		throws PortalException;

	/**
	 * Returns a range of all the rubrica gruppos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaGruppoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica gruppos
	 * @param end the upper bound of the range of rubrica gruppos (not inclusive)
	 * @return the range of rubrica gruppos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<RubricaGruppo> getRubricaGruppos(int start, int end);

	/**
	 * Returns the number of rubrica gruppos.
	 *
	 * @return the number of rubrica gruppos
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRubricaGrupposCount();

	/**
	 * Updates the rubrica gruppo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaGruppo the rubrica gruppo
	 * @return the rubrica gruppo that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public RubricaGruppo updateRubricaGruppo(RubricaGruppo rubricaGruppo);

}