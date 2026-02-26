/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BollettinoSensoreLocalService}.
 *
 * @author GFAVINI
 * @see BollettinoSensoreLocalService
 * @generated
 */
public class BollettinoSensoreLocalServiceWrapper
	implements BollettinoSensoreLocalService,
			   ServiceWrapper<BollettinoSensoreLocalService> {

	public BollettinoSensoreLocalServiceWrapper() {
		this(null);
	}

	public BollettinoSensoreLocalServiceWrapper(
		BollettinoSensoreLocalService bollettinoSensoreLocalService) {

		_bollettinoSensoreLocalService = bollettinoSensoreLocalService;
	}

	/**
	 * Adds the bollettino sensore to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoSensoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettinoSensore the bollettino sensore
	 * @return the bollettino sensore that was added
	 */
	@Override
	public it.eng.bollettino.model.BollettinoSensore addBollettinoSensore(
		it.eng.bollettino.model.BollettinoSensore bollettinoSensore) {

		return _bollettinoSensoreLocalService.addBollettinoSensore(
			bollettinoSensore);
	}

	/**
	 * Creates a new bollettino sensore with the primary key. Does not add the bollettino sensore to the database.
	 *
	 * @param id the primary key for the new bollettino sensore
	 * @return the new bollettino sensore
	 */
	@Override
	public it.eng.bollettino.model.BollettinoSensore createBollettinoSensore(
		long id) {

		return _bollettinoSensoreLocalService.createBollettinoSensore(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoSensoreLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the bollettino sensore from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoSensoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettinoSensore the bollettino sensore
	 * @return the bollettino sensore that was removed
	 */
	@Override
	public it.eng.bollettino.model.BollettinoSensore deleteBollettinoSensore(
		it.eng.bollettino.model.BollettinoSensore bollettinoSensore) {

		return _bollettinoSensoreLocalService.deleteBollettinoSensore(
			bollettinoSensore);
	}

	/**
	 * Deletes the bollettino sensore with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoSensoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the bollettino sensore
	 * @return the bollettino sensore that was removed
	 * @throws PortalException if a bollettino sensore with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.BollettinoSensore deleteBollettinoSensore(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoSensoreLocalService.deleteBollettinoSensore(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoSensoreLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bollettinoSensoreLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bollettinoSensoreLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bollettinoSensoreLocalService.dynamicQuery();
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

		return _bollettinoSensoreLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoSensoreModelImpl</code>.
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

		return _bollettinoSensoreLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoSensoreModelImpl</code>.
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

		return _bollettinoSensoreLocalService.dynamicQuery(
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

		return _bollettinoSensoreLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bollettinoSensoreLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.BollettinoSensore fetchBollettinoSensore(
		long id) {

		return _bollettinoSensoreLocalService.fetchBollettinoSensore(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bollettinoSensoreLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the bollettino sensore with the primary key.
	 *
	 * @param id the primary key of the bollettino sensore
	 * @return the bollettino sensore
	 * @throws PortalException if a bollettino sensore with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.BollettinoSensore getBollettinoSensore(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoSensoreLocalService.getBollettinoSensore(id);
	}

	/**
	 * Returns a range of all the bollettino sensores.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoSensoreModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino sensores
	 * @param end the upper bound of the range of bollettino sensores (not inclusive)
	 * @return the range of bollettino sensores
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.BollettinoSensore>
		getBollettinoSensores(int start, int end) {

		return _bollettinoSensoreLocalService.getBollettinoSensores(start, end);
	}

	/**
	 * Returns the number of bollettino sensores.
	 *
	 * @return the number of bollettino sensores
	 */
	@Override
	public int getBollettinoSensoresCount() {
		return _bollettinoSensoreLocalService.getBollettinoSensoresCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bollettinoSensoreLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoSensoreLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoSensoreLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the bollettino sensore in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoSensoreLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettinoSensore the bollettino sensore
	 * @return the bollettino sensore that was updated
	 */
	@Override
	public it.eng.bollettino.model.BollettinoSensore updateBollettinoSensore(
		it.eng.bollettino.model.BollettinoSensore bollettinoSensore) {

		return _bollettinoSensoreLocalService.updateBollettinoSensore(
			bollettinoSensore);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bollettinoSensoreLocalService.getBasePersistence();
	}

	@Override
	public BollettinoSensoreLocalService getWrappedService() {
		return _bollettinoSensoreLocalService;
	}

	@Override
	public void setWrappedService(
		BollettinoSensoreLocalService bollettinoSensoreLocalService) {

		_bollettinoSensoreLocalService = bollettinoSensoreLocalService;
	}

	private BollettinoSensoreLocalService _bollettinoSensoreLocalService;

}