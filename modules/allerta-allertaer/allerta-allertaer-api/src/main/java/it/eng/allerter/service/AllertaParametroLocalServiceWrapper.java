/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerter.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AllertaParametroLocalService}.
 *
 * @author GFAVINI
 * @see AllertaParametroLocalService
 * @generated
 */
public class AllertaParametroLocalServiceWrapper
	implements AllertaParametroLocalService,
			   ServiceWrapper<AllertaParametroLocalService> {

	public AllertaParametroLocalServiceWrapper() {
		this(null);
	}

	public AllertaParametroLocalServiceWrapper(
		AllertaParametroLocalService allertaParametroLocalService) {

		_allertaParametroLocalService = allertaParametroLocalService;
	}

	/**
	 * Adds the allerta parametro to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaParametroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allertaParametro the allerta parametro
	 * @return the allerta parametro that was added
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro addAllertaParametro(
		it.eng.allerter.model.AllertaParametro allertaParametro) {

		return _allertaParametroLocalService.addAllertaParametro(
			allertaParametro);
	}

	/**
	 * Creates a new allerta parametro with the primary key. Does not add the allerta parametro to the database.
	 *
	 * @param parametroId the primary key for the new allerta parametro
	 * @return the new allerta parametro
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro createAllertaParametro(
		String parametroId) {

		return _allertaParametroLocalService.createAllertaParametro(
			parametroId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaParametroLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the allerta parametro from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaParametroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allertaParametro the allerta parametro
	 * @return the allerta parametro that was removed
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro deleteAllertaParametro(
		it.eng.allerter.model.AllertaParametro allertaParametro) {

		return _allertaParametroLocalService.deleteAllertaParametro(
			allertaParametro);
	}

	/**
	 * Deletes the allerta parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaParametroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro that was removed
	 * @throws PortalException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro deleteAllertaParametro(
			String parametroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaParametroLocalService.deleteAllertaParametro(
			parametroId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaParametroLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _allertaParametroLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _allertaParametroLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _allertaParametroLocalService.dynamicQuery();
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

		return _allertaParametroLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaParametroModelImpl</code>.
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

		return _allertaParametroLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaParametroModelImpl</code>.
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

		return _allertaParametroLocalService.dynamicQuery(
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

		return _allertaParametroLocalService.dynamicQueryCount(dynamicQuery);
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

		return _allertaParametroLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerter.model.AllertaParametro fetchAllertaParametro(
		String parametroId) {

		return _allertaParametroLocalService.fetchAllertaParametro(parametroId);
	}

	/**
	 * Returns the allerta parametro with the primary key.
	 *
	 * @param parametroId the primary key of the allerta parametro
	 * @return the allerta parametro
	 * @throws PortalException if a allerta parametro with the primary key could not be found
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro getAllertaParametro(
			String parametroId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaParametroLocalService.getAllertaParametro(parametroId);
	}

	/**
	 * Returns a range of all the allerta parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.AllertaParametroModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of allerta parametros
	 * @param end the upper bound of the range of allerta parametros (not inclusive)
	 * @return the range of allerta parametros
	 */
	@Override
	public java.util.List<it.eng.allerter.model.AllertaParametro>
		getAllertaParametros(int start, int end) {

		return _allertaParametroLocalService.getAllertaParametros(start, end);
	}

	/**
	 * Returns the number of allerta parametros.
	 *
	 * @return the number of allerta parametros
	 */
	@Override
	public int getAllertaParametrosCount() {
		return _allertaParametroLocalService.getAllertaParametrosCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _allertaParametroLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _allertaParametroLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the allerta parametro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AllertaParametroLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param allertaParametro the allerta parametro
	 * @return the allerta parametro that was updated
	 */
	@Override
	public it.eng.allerter.model.AllertaParametro updateAllertaParametro(
		it.eng.allerter.model.AllertaParametro allertaParametro) {

		return _allertaParametroLocalService.updateAllertaParametro(
			allertaParametro);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _allertaParametroLocalService.getBasePersistence();
	}

	@Override
	public AllertaParametroLocalService getWrappedService() {
		return _allertaParametroLocalService;
	}

	@Override
	public void setWrappedService(
		AllertaParametroLocalService allertaParametroLocalService) {

		_allertaParametroLocalService = allertaParametroLocalService;
	}

	private AllertaParametroLocalService _allertaParametroLocalService;

}