/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RegolaAllarmeCondizioneLocalService}.
 *
 * @author GFAVINI
 * @see RegolaAllarmeCondizioneLocalService
 * @generated
 */
public class RegolaAllarmeCondizioneLocalServiceWrapper
	implements RegolaAllarmeCondizioneLocalService,
			   ServiceWrapper<RegolaAllarmeCondizioneLocalService> {

	public RegolaAllarmeCondizioneLocalServiceWrapper() {
		this(null);
	}

	public RegolaAllarmeCondizioneLocalServiceWrapper(
		RegolaAllarmeCondizioneLocalService
			regolaAllarmeCondizioneLocalService) {

		_regolaAllarmeCondizioneLocalService =
			regolaAllarmeCondizioneLocalService;
	}

	/**
	 * Adds the regola allarme condizione to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeCondizioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 * @return the regola allarme condizione that was added
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeCondizione
		addRegolaAllarmeCondizione(
			it.eng.bollettino.model.RegolaAllarmeCondizione
				regolaAllarmeCondizione) {

		return _regolaAllarmeCondizioneLocalService.addRegolaAllarmeCondizione(
			regolaAllarmeCondizione);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeCondizioneLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new regola allarme condizione with the primary key. Does not add the regola allarme condizione to the database.
	 *
	 * @param id the primary key for the new regola allarme condizione
	 * @return the new regola allarme condizione
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeCondizione
		createRegolaAllarmeCondizione(long id) {

		return _regolaAllarmeCondizioneLocalService.
			createRegolaAllarmeCondizione(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeCondizioneLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the regola allarme condizione with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeCondizioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 * @throws PortalException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeCondizione
			deleteRegolaAllarmeCondizione(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeCondizioneLocalService.
			deleteRegolaAllarmeCondizione(id);
	}

	/**
	 * Deletes the regola allarme condizione from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeCondizioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 * @return the regola allarme condizione that was removed
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeCondizione
		deleteRegolaAllarmeCondizione(
			it.eng.bollettino.model.RegolaAllarmeCondizione
				regolaAllarmeCondizione) {

		return _regolaAllarmeCondizioneLocalService.
			deleteRegolaAllarmeCondizione(regolaAllarmeCondizione);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _regolaAllarmeCondizioneLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _regolaAllarmeCondizioneLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _regolaAllarmeCondizioneLocalService.dynamicQuery();
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

		return _regolaAllarmeCondizioneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl</code>.
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

		return _regolaAllarmeCondizioneLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl</code>.
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

		return _regolaAllarmeCondizioneLocalService.dynamicQuery(
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

		return _regolaAllarmeCondizioneLocalService.dynamicQueryCount(
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

		return _regolaAllarmeCondizioneLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.RegolaAllarmeCondizione
		fetchRegolaAllarmeCondizione(long id) {

		return _regolaAllarmeCondizioneLocalService.
			fetchRegolaAllarmeCondizione(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _regolaAllarmeCondizioneLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<it.eng.bollettino.model.RegolaAllarmeCondizione>
		getAllarmeCondizione(long idRegola) {

		return _regolaAllarmeCondizioneLocalService.getAllarmeCondizione(
			idRegola);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _regolaAllarmeCondizioneLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _regolaAllarmeCondizioneLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeCondizioneLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the regola allarme condizione with the primary key.
	 *
	 * @param id the primary key of the regola allarme condizione
	 * @return the regola allarme condizione
	 * @throws PortalException if a regola allarme condizione with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeCondizione
			getRegolaAllarmeCondizione(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _regolaAllarmeCondizioneLocalService.getRegolaAllarmeCondizione(
			id);
	}

	/**
	 * Returns a range of all the regola allarme condiziones.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.RegolaAllarmeCondizioneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of regola allarme condiziones
	 * @param end the upper bound of the range of regola allarme condiziones (not inclusive)
	 * @return the range of regola allarme condiziones
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.RegolaAllarmeCondizione>
		getRegolaAllarmeCondiziones(int start, int end) {

		return _regolaAllarmeCondizioneLocalService.getRegolaAllarmeCondiziones(
			start, end);
	}

	/**
	 * Returns the number of regola allarme condiziones.
	 *
	 * @return the number of regola allarme condiziones
	 */
	@Override
	public int getRegolaAllarmeCondizionesCount() {
		return _regolaAllarmeCondizioneLocalService.
			getRegolaAllarmeCondizionesCount();
	}

	/**
	 * Updates the regola allarme condizione in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RegolaAllarmeCondizioneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param regolaAllarmeCondizione the regola allarme condizione
	 * @return the regola allarme condizione that was updated
	 */
	@Override
	public it.eng.bollettino.model.RegolaAllarmeCondizione
		updateRegolaAllarmeCondizione(
			it.eng.bollettino.model.RegolaAllarmeCondizione
				regolaAllarmeCondizione) {

		return _regolaAllarmeCondizioneLocalService.
			updateRegolaAllarmeCondizione(regolaAllarmeCondizione);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _regolaAllarmeCondizioneLocalService.getBasePersistence();
	}

	@Override
	public RegolaAllarmeCondizioneLocalService getWrappedService() {
		return _regolaAllarmeCondizioneLocalService;
	}

	@Override
	public void setWrappedService(
		RegolaAllarmeCondizioneLocalService
			regolaAllarmeCondizioneLocalService) {

		_regolaAllarmeCondizioneLocalService =
			regolaAllarmeCondizioneLocalService;
	}

	private RegolaAllarmeCondizioneLocalService
		_regolaAllarmeCondizioneLocalService;

}