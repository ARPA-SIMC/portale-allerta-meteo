/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BollettinoIconaLocalService}.
 *
 * @author GFAVINI
 * @see BollettinoIconaLocalService
 * @generated
 */
public class BollettinoIconaLocalServiceWrapper
	implements BollettinoIconaLocalService,
			   ServiceWrapper<BollettinoIconaLocalService> {

	public BollettinoIconaLocalServiceWrapper() {
		this(null);
	}

	public BollettinoIconaLocalServiceWrapper(
		BollettinoIconaLocalService bollettinoIconaLocalService) {

		_bollettinoIconaLocalService = bollettinoIconaLocalService;
	}

	/**
	 * Adds the bollettino icona to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoIconaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettinoIcona the bollettino icona
	 * @return the bollettino icona that was added
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona addBollettinoIcona(
		it.eng.bollettino.model.BollettinoIcona bollettinoIcona) {

		return _bollettinoIconaLocalService.addBollettinoIcona(bollettinoIcona);
	}

	/**
	 * Creates a new bollettino icona with the primary key. Does not add the bollettino icona to the database.
	 *
	 * @param id the primary key for the new bollettino icona
	 * @return the new bollettino icona
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona createBollettinoIcona(
		long id) {

		return _bollettinoIconaLocalService.createBollettinoIcona(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoIconaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the bollettino icona from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoIconaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettinoIcona the bollettino icona
	 * @return the bollettino icona that was removed
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona deleteBollettinoIcona(
		it.eng.bollettino.model.BollettinoIcona bollettinoIcona) {

		return _bollettinoIconaLocalService.deleteBollettinoIcona(
			bollettinoIcona);
	}

	/**
	 * Deletes the bollettino icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoIconaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona that was removed
	 * @throws PortalException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona deleteBollettinoIcona(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoIconaLocalService.deleteBollettinoIcona(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoIconaLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bollettinoIconaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bollettinoIconaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bollettinoIconaLocalService.dynamicQuery();
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

		return _bollettinoIconaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoIconaModelImpl</code>.
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

		return _bollettinoIconaLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoIconaModelImpl</code>.
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

		return _bollettinoIconaLocalService.dynamicQuery(
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

		return _bollettinoIconaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bollettinoIconaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.BollettinoIcona fetchBollettinoIcona(
		long id) {

		return _bollettinoIconaLocalService.fetchBollettinoIcona(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bollettinoIconaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the bollettino icona with the primary key.
	 *
	 * @param id the primary key of the bollettino icona
	 * @return the bollettino icona
	 * @throws PortalException if a bollettino icona with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona getBollettinoIcona(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoIconaLocalService.getBollettinoIcona(id);
	}

	/**
	 * Returns a range of all the bollettino iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.BollettinoIconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bollettino iconas
	 * @param end the upper bound of the range of bollettino iconas (not inclusive)
	 * @return the range of bollettino iconas
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.BollettinoIcona>
		getBollettinoIconas(int start, int end) {

		return _bollettinoIconaLocalService.getBollettinoIconas(start, end);
	}

	/**
	 * Returns the number of bollettino iconas.
	 *
	 * @return the number of bollettino iconas
	 */
	@Override
	public int getBollettinoIconasCount() {
		return _bollettinoIconaLocalService.getBollettinoIconasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bollettinoIconaLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bollettinoIconaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bollettinoIconaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the bollettino icona in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BollettinoIconaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bollettinoIcona the bollettino icona
	 * @return the bollettino icona that was updated
	 */
	@Override
	public it.eng.bollettino.model.BollettinoIcona updateBollettinoIcona(
		it.eng.bollettino.model.BollettinoIcona bollettinoIcona) {

		return _bollettinoIconaLocalService.updateBollettinoIcona(
			bollettinoIcona);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bollettinoIconaLocalService.getBasePersistence();
	}

	@Override
	public BollettinoIconaLocalService getWrappedService() {
		return _bollettinoIconaLocalService;
	}

	@Override
	public void setWrappedService(
		BollettinoIconaLocalService bollettinoIconaLocalService) {

		_bollettinoIconaLocalService = bollettinoIconaLocalService;
	}

	private BollettinoIconaLocalService _bollettinoIconaLocalService;

}