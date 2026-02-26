/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RubricaNominativoLocalService}.
 *
 * @author Pratola_L
 * @see RubricaNominativoLocalService
 * @generated
 */
public class RubricaNominativoLocalServiceWrapper
	implements RubricaNominativoLocalService,
			   ServiceWrapper<RubricaNominativoLocalService> {

	public RubricaNominativoLocalServiceWrapper() {
		this(null);
	}

	public RubricaNominativoLocalServiceWrapper(
		RubricaNominativoLocalService rubricaNominativoLocalService) {

		_rubricaNominativoLocalService = rubricaNominativoLocalService;
	}

	/**
	 * Adds the rubrica nominativo to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaNominativoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaNominativo the rubrica nominativo
	 * @return the rubrica nominativo that was added
	 */
	@Override
	public it.eng.allerte.model.RubricaNominativo addRubricaNominativo(
		it.eng.allerte.model.RubricaNominativo rubricaNominativo) {

		return _rubricaNominativoLocalService.addRubricaNominativo(
			rubricaNominativo);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaNominativoLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new rubrica nominativo with the primary key. Does not add the rubrica nominativo to the database.
	 *
	 * @param ID_NOMINATIVO the primary key for the new rubrica nominativo
	 * @return the new rubrica nominativo
	 */
	@Override
	public it.eng.allerte.model.RubricaNominativo createRubricaNominativo(
		long ID_NOMINATIVO) {

		return _rubricaNominativoLocalService.createRubricaNominativo(
			ID_NOMINATIVO);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaNominativoLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the rubrica nominativo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaNominativoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo that was removed
	 * @throws PortalException if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaNominativo deleteRubricaNominativo(
			long ID_NOMINATIVO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaNominativoLocalService.deleteRubricaNominativo(
			ID_NOMINATIVO);
	}

	/**
	 * Deletes the rubrica nominativo from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaNominativoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaNominativo the rubrica nominativo
	 * @return the rubrica nominativo that was removed
	 */
	@Override
	public it.eng.allerte.model.RubricaNominativo deleteRubricaNominativo(
		it.eng.allerte.model.RubricaNominativo rubricaNominativo) {

		return _rubricaNominativoLocalService.deleteRubricaNominativo(
			rubricaNominativo);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _rubricaNominativoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _rubricaNominativoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rubricaNominativoLocalService.dynamicQuery();
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

		return _rubricaNominativoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaNominativoModelImpl</code>.
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

		return _rubricaNominativoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaNominativoModelImpl</code>.
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

		return _rubricaNominativoLocalService.dynamicQuery(
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

		return _rubricaNominativoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rubricaNominativoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerte.model.RubricaNominativo fetchRubricaNominativo(
		long ID_NOMINATIVO) {

		return _rubricaNominativoLocalService.fetchRubricaNominativo(
			ID_NOMINATIVO);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rubricaNominativoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rubricaNominativoLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<Object[]> getNominativiByName(
		String name, Long limit, Long offset) {

		return _rubricaNominativoLocalService.getNominativiByName(
			name, limit, offset);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaNominativoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaNominativoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rubrica nominativo with the primary key.
	 *
	 * @param ID_NOMINATIVO the primary key of the rubrica nominativo
	 * @return the rubrica nominativo
	 * @throws PortalException if a rubrica nominativo with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaNominativo getRubricaNominativo(
			long ID_NOMINATIVO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaNominativoLocalService.getRubricaNominativo(
			ID_NOMINATIVO);
	}

	/**
	 * Returns a range of all the rubrica nominativos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaNominativoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica nominativos
	 * @param end the upper bound of the range of rubrica nominativos (not inclusive)
	 * @return the range of rubrica nominativos
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaNominativo>
		getRubricaNominativos(int start, int end) {

		return _rubricaNominativoLocalService.getRubricaNominativos(start, end);
	}

	/**
	 * Returns the number of rubrica nominativos.
	 *
	 * @return the number of rubrica nominativos
	 */
	@Override
	public int getRubricaNominativosCount() {
		return _rubricaNominativoLocalService.getRubricaNominativosCount();
	}

	/**
	 * Updates the rubrica nominativo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaNominativoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaNominativo the rubrica nominativo
	 * @return the rubrica nominativo that was updated
	 */
	@Override
	public it.eng.allerte.model.RubricaNominativo updateRubricaNominativo(
		it.eng.allerte.model.RubricaNominativo rubricaNominativo) {

		return _rubricaNominativoLocalService.updateRubricaNominativo(
			rubricaNominativo);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _rubricaNominativoLocalService.getBasePersistence();
	}

	@Override
	public RubricaNominativoLocalService getWrappedService() {
		return _rubricaNominativoLocalService;
	}

	@Override
	public void setWrappedService(
		RubricaNominativoLocalService rubricaNominativoLocalService) {

		_rubricaNominativoLocalService = rubricaNominativoLocalService;
	}

	private RubricaNominativoLocalService _rubricaNominativoLocalService;

}