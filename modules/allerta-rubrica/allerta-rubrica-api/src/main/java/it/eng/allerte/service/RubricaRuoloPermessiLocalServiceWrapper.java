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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RubricaRuoloPermessiLocalService}.
 *
 * @author Pratola_L
 * @see RubricaRuoloPermessiLocalService
 * @generated
 */
@ProviderType
public class RubricaRuoloPermessiLocalServiceWrapper
	implements RubricaRuoloPermessiLocalService,
			   ServiceWrapper<RubricaRuoloPermessiLocalService> {

	public RubricaRuoloPermessiLocalServiceWrapper(
		RubricaRuoloPermessiLocalService rubricaRuoloPermessiLocalService) {

		_rubricaRuoloPermessiLocalService = rubricaRuoloPermessiLocalService;
	}

	/**
	 * Adds the rubrica ruolo permessi to the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessi the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was added
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloPermessi addRubricaRuoloPermessi(
		it.eng.allerte.model.RubricaRuoloPermessi rubricaRuoloPermessi) {

		return _rubricaRuoloPermessiLocalService.addRubricaRuoloPermessi(
			rubricaRuoloPermessi);
	}

	/**
	 * Creates a new rubrica ruolo permessi with the primary key. Does not add the rubrica ruolo permessi to the database.
	 *
	 * @param rubricaRuoloPermessiPK the primary key for the new rubrica ruolo permessi
	 * @return the new rubrica ruolo permessi
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloPermessi createRubricaRuoloPermessi(
		it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
			rubricaRuoloPermessiPK) {

		return _rubricaRuoloPermessiLocalService.createRubricaRuoloPermessi(
			rubricaRuoloPermessiPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloPermessiLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the rubrica ruolo permessi from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessi the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was removed
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloPermessi deleteRubricaRuoloPermessi(
		it.eng.allerte.model.RubricaRuoloPermessi rubricaRuoloPermessi) {

		return _rubricaRuoloPermessiLocalService.deleteRubricaRuoloPermessi(
			rubricaRuoloPermessi);
	}

	/**
	 * Deletes the rubrica ruolo permessi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was removed
	 * @throws PortalException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloPermessi deleteRubricaRuoloPermessi(
			it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
				rubricaRuoloPermessiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloPermessiLocalService.deleteRubricaRuoloPermessi(
			rubricaRuoloPermessiPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rubricaRuoloPermessiLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _rubricaRuoloPermessiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _rubricaRuoloPermessiLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _rubricaRuoloPermessiLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _rubricaRuoloPermessiLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _rubricaRuoloPermessiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerte.model.RubricaRuoloPermessi fetchRubricaRuoloPermessi(
		it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
			rubricaRuoloPermessiPK) {

		return _rubricaRuoloPermessiLocalService.fetchRubricaRuoloPermessi(
			rubricaRuoloPermessiPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rubricaRuoloPermessiLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rubricaRuoloPermessiLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaRuoloPermessiLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloPermessiLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the rubrica ruolo permessi with the primary key.
	 *
	 * @param rubricaRuoloPermessiPK the primary key of the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi
	 * @throws PortalException if a rubrica ruolo permessi with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloPermessi getRubricaRuoloPermessi(
			it.eng.allerte.service.persistence.RubricaRuoloPermessiPK
				rubricaRuoloPermessiPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloPermessiLocalService.getRubricaRuoloPermessi(
			rubricaRuoloPermessiPK);
	}

	/**
	 * Returns a range of all the rubrica ruolo permessis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloPermessiModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo permessis
	 * @param end the upper bound of the range of rubrica ruolo permessis (not inclusive)
	 * @return the range of rubrica ruolo permessis
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaRuoloPermessi>
		getRubricaRuoloPermessis(int start, int end) {

		return _rubricaRuoloPermessiLocalService.getRubricaRuoloPermessis(
			start, end);
	}

	/**
	 * Returns the number of rubrica ruolo permessis.
	 *
	 * @return the number of rubrica ruolo permessis
	 */
	@Override
	public int getRubricaRuoloPermessisCount() {
		return _rubricaRuoloPermessiLocalService.
			getRubricaRuoloPermessisCount();
	}

	/**
	 * Updates the rubrica ruolo permessi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param rubricaRuoloPermessi the rubrica ruolo permessi
	 * @return the rubrica ruolo permessi that was updated
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloPermessi updateRubricaRuoloPermessi(
		it.eng.allerte.model.RubricaRuoloPermessi rubricaRuoloPermessi) {

		return _rubricaRuoloPermessiLocalService.updateRubricaRuoloPermessi(
			rubricaRuoloPermessi);
	}

	@Override
	public RubricaRuoloPermessiLocalService getWrappedService() {
		return _rubricaRuoloPermessiLocalService;
	}

	@Override
	public void setWrappedService(
		RubricaRuoloPermessiLocalService rubricaRuoloPermessiLocalService) {

		_rubricaRuoloPermessiLocalService = rubricaRuoloPermessiLocalService;
	}

	private RubricaRuoloPermessiLocalService _rubricaRuoloPermessiLocalService;

}