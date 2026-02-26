/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BacinoLocalService}.
 *
 * @author GFAVINI
 * @see BacinoLocalService
 * @generated
 */
public class BacinoLocalServiceWrapper
	implements BacinoLocalService, ServiceWrapper<BacinoLocalService> {

	public BacinoLocalServiceWrapper() {
		this(null);
	}

	public BacinoLocalServiceWrapper(BacinoLocalService bacinoLocalService) {
		_bacinoLocalService = bacinoLocalService;
	}

	/**
	 * Adds the bacino to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BacinoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bacino the bacino
	 * @return the bacino that was added
	 */
	@Override
	public it.eng.bollettino.model.Bacino addBacino(
		it.eng.bollettino.model.Bacino bacino) {

		return _bacinoLocalService.addBacino(bacino);
	}

	@Override
	public it.eng.bollettino.model.Bacino creaBacinoDefault(
			String id, String nome, int progressivo, String[] stazioni)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bacinoLocalService.creaBacinoDefault(
			id, nome, progressivo, stazioni);
	}

	/**
	 * Creates a new bacino with the primary key. Does not add the bacino to the database.
	 *
	 * @param id the primary key for the new bacino
	 * @return the new bacino
	 */
	@Override
	public it.eng.bollettino.model.Bacino createBacino(String id) {
		return _bacinoLocalService.createBacino(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bacinoLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the bacino from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BacinoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bacino the bacino
	 * @return the bacino that was removed
	 */
	@Override
	public it.eng.bollettino.model.Bacino deleteBacino(
		it.eng.bollettino.model.Bacino bacino) {

		return _bacinoLocalService.deleteBacino(bacino);
	}

	/**
	 * Deletes the bacino with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BacinoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the bacino
	 * @return the bacino that was removed
	 * @throws PortalException if a bacino with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Bacino deleteBacino(String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bacinoLocalService.deleteBacino(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bacinoLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bacinoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bacinoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bacinoLocalService.dynamicQuery();
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

		return _bacinoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BacinoModelImpl</code>.
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

		return _bacinoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BacinoModelImpl</code>.
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

		return _bacinoLocalService.dynamicQuery(
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

		return _bacinoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bacinoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.Bacino fetchBacino(String id) {
		return _bacinoLocalService.fetchBacino(id);
	}

	/**
	 * Returns the bacino with the primary key.
	 *
	 * @param id the primary key of the bacino
	 * @return the bacino
	 * @throws PortalException if a bacino with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Bacino getBacino(String id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bacinoLocalService.getBacino(id);
	}

	/**
	 * Returns a range of all the bacinos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BacinoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bacinos
	 * @param end the upper bound of the range of bacinos (not inclusive)
	 * @return the range of bacinos
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Bacino> getBacinos(
		int start, int end) {

		return _bacinoLocalService.getBacinos(start, end);
	}

	/**
	 * Returns the number of bacinos.
	 *
	 * @return the number of bacinos
	 */
	@Override
	public int getBacinosCount() {
		return _bacinoLocalService.getBacinosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bacinoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bacinoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the bacino in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BacinoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bacino the bacino
	 * @return the bacino that was updated
	 */
	@Override
	public it.eng.bollettino.model.Bacino updateBacino(
		it.eng.bollettino.model.Bacino bacino) {

		return _bacinoLocalService.updateBacino(bacino);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bacinoLocalService.getBasePersistence();
	}

	@Override
	public BacinoLocalService getWrappedService() {
		return _bacinoLocalService;
	}

	@Override
	public void setWrappedService(BacinoLocalService bacinoLocalService) {
		_bacinoLocalService = bacinoLocalService;
	}

	private BacinoLocalService _bacinoLocalService;

}