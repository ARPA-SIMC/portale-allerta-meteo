/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RegolaAllarmeLocalService}.
 *
 * @author GFAVINI
 * @see RegolaAllarmeLocalService
 * @generated
 */
public class RegolaAllarmeLocalServiceWrapper
	implements RegolaAllarmeLocalService,
			   ServiceWrapper<RegolaAllarmeLocalService> {

	public RegolaAllarmeLocalServiceWrapper() {
		this(null);
	}

	public RegolaAllarmeLocalServiceWrapper(
		RegolaAllarmeLocalService regolaAllarmeLocalService) {

		_regolaAllarmeLocalService = regolaAllarmeLocalService;
	}

	/**
	 * Adds the regola allarme to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarme the regola allarme
	 * @return the regola allarme that was added
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarme addRegolaAllarme(
		it.eng.bollettino.model.RegolaAllarme regolaAllarme) {

		return _regolaAllarmeLocalService.addRegolaAllarme(regolaAllarme);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new regola allarme with the primary key. Does not add the regola allarme to the database.
	 *
	 * @param id the primary key for the new regola allarme
	 * @return the new regola allarme
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarme createRegolaAllarme(long id) {
		return _regolaAllarmeLocalService.createRegolaAllarme(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the regola allarme with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme that was removed
	 * @throws PortalException if a regola allarme with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarme deleteRegolaAllarme(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeLocalService.deleteRegolaAllarme(id);
	}

	/**
	 * Deletes the regola allarme from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarme the regola allarme
	 * @return the regola allarme that was removed
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarme deleteRegolaAllarme(
		it.eng.bollettino.model.RegolaAllarme regolaAllarme) {

		return _regolaAllarmeLocalService.deleteRegolaAllarme(regolaAllarme);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _regolaAllarmeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _regolaAllarmeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _regolaAllarmeLocalService.dynamicQuery();
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

		return _regolaAllarmeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeModelImpl</code>.
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

		return _regolaAllarmeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeModelImpl</code>.
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

		return _regolaAllarmeLocalService.dynamicQuery(
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

		return _regolaAllarmeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _regolaAllarmeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.RegolaAllarme fetchRegolaAllarme(long id) {
		return _regolaAllarmeLocalService.fetchRegolaAllarme(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _regolaAllarmeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _regolaAllarmeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _regolaAllarmeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the regola allarme with the primary key.
	 *
	 * @param id the primary key of the regola allarme
	 * @return the regola allarme
	 * @throws PortalException if a regola allarme with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarme getRegolaAllarme(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeLocalService.getRegolaAllarme(id);
	}

	/**
	 * Returns a range of all the regola allarmes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarmes
	 * @param end the upper bound of the range of regola allarmes (not inclusive)
	 * @return the range of regola allarmes
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.RegolaAllarme>
		getRegolaAllarmes(int start, int end) {

		return _regolaAllarmeLocalService.getRegolaAllarmes(start, end);
	}

	/**
	 * Returns the number of regola allarmes.
	 *
	 * @return the number of regola allarmes
	 */
	@Override
	public int getRegolaAllarmesCount() {
		return _regolaAllarmeLocalService.getRegolaAllarmesCount();
	}

	@Override
	public java.util.Map<String, Object> regoleAllarme() {
		return _regolaAllarmeLocalService.regoleAllarme();
	}

	/**
	 * Updates the regola allarme in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarme the regola allarme
	 * @return the regola allarme that was updated
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarme updateRegolaAllarme(
		it.eng.bollettino.model.RegolaAllarme regolaAllarme) {

		return _regolaAllarmeLocalService.updateRegolaAllarme(regolaAllarme);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _regolaAllarmeLocalService.getBasePersistence();
	}

	@Override
	public RegolaAllarmeLocalService getWrappedService() {
		return _regolaAllarmeLocalService;
	}

	@Override
	public void setWrappedService(
		RegolaAllarmeLocalService regolaAllarmeLocalService) {

		_regolaAllarmeLocalService = regolaAllarmeLocalService;
	}

	private RegolaAllarmeLocalService _regolaAllarmeLocalService;

}