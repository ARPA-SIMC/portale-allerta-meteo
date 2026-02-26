/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RubricaRuoloRubricaLocalService}.
 *
 * @author Pratola_L
 * @see RubricaRuoloRubricaLocalService
 * @generated
 */
public class RubricaRuoloRubricaLocalServiceWrapper
	implements RubricaRuoloRubricaLocalService,
			   ServiceWrapper<RubricaRuoloRubricaLocalService> {

	public RubricaRuoloRubricaLocalServiceWrapper() {
		this(null);
	}

	public RubricaRuoloRubricaLocalServiceWrapper(
		RubricaRuoloRubricaLocalService rubricaRuoloRubricaLocalService) {

		_rubricaRuoloRubricaLocalService = rubricaRuoloRubricaLocalService;
	}

	/**
	 * Adds the rubrica ruolo rubrica to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaRuoloRubricaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaRuoloRubrica the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica that was added
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloRubrica addRubricaRuoloRubrica(
		it.eng.allerte.model.RubricaRuoloRubrica rubricaRuoloRubrica) {

		return _rubricaRuoloRubricaLocalService.addRubricaRuoloRubrica(
			rubricaRuoloRubrica);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloRubricaLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new rubrica ruolo rubrica with the primary key. Does not add the rubrica ruolo rubrica to the database.
	 *
	 * @param ID_RUOLO the primary key for the new rubrica ruolo rubrica
	 * @return the new rubrica ruolo rubrica
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloRubrica createRubricaRuoloRubrica(
		long ID_RUOLO) {

		return _rubricaRuoloRubricaLocalService.createRubricaRuoloRubrica(
			ID_RUOLO);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloRubricaLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the rubrica ruolo rubrica with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaRuoloRubricaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica that was removed
	 * @throws PortalException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloRubrica deleteRubricaRuoloRubrica(
			long ID_RUOLO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloRubricaLocalService.deleteRubricaRuoloRubrica(
			ID_RUOLO);
	}

	/**
	 * Deletes the rubrica ruolo rubrica from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaRuoloRubricaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaRuoloRubrica the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica that was removed
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloRubrica deleteRubricaRuoloRubrica(
		it.eng.allerte.model.RubricaRuoloRubrica rubricaRuoloRubrica) {

		return _rubricaRuoloRubricaLocalService.deleteRubricaRuoloRubrica(
			rubricaRuoloRubrica);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _rubricaRuoloRubricaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _rubricaRuoloRubricaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rubricaRuoloRubricaLocalService.dynamicQuery();
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

		return _rubricaRuoloRubricaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloRubricaModelImpl</code>.
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

		return _rubricaRuoloRubricaLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloRubricaModelImpl</code>.
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

		return _rubricaRuoloRubricaLocalService.dynamicQuery(
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

		return _rubricaRuoloRubricaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rubricaRuoloRubricaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerte.model.RubricaRuoloRubrica fetchRubricaRuoloRubrica(
		long ID_RUOLO) {

		return _rubricaRuoloRubricaLocalService.fetchRubricaRuoloRubrica(
			ID_RUOLO);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rubricaRuoloRubricaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rubricaRuoloRubricaLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaRuoloRubricaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloRubricaLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the rubrica ruolo rubrica with the primary key.
	 *
	 * @param ID_RUOLO the primary key of the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica
	 * @throws PortalException if a rubrica ruolo rubrica with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloRubrica getRubricaRuoloRubrica(
			long ID_RUOLO)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaRuoloRubricaLocalService.getRubricaRuoloRubrica(
			ID_RUOLO);
	}

	/**
	 * Returns a range of all the rubrica ruolo rubricas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaRuoloRubricaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica ruolo rubricas
	 * @param end the upper bound of the range of rubrica ruolo rubricas (not inclusive)
	 * @return the range of rubrica ruolo rubricas
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaRuoloRubrica>
		getRubricaRuoloRubricas(int start, int end) {

		return _rubricaRuoloRubricaLocalService.getRubricaRuoloRubricas(
			start, end);
	}

	/**
	 * Returns the number of rubrica ruolo rubricas.
	 *
	 * @return the number of rubrica ruolo rubricas
	 */
	@Override
	public int getRubricaRuoloRubricasCount() {
		return _rubricaRuoloRubricaLocalService.getRubricaRuoloRubricasCount();
	}

	/**
	 * Updates the rubrica ruolo rubrica in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaRuoloRubricaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaRuoloRubrica the rubrica ruolo rubrica
	 * @return the rubrica ruolo rubrica that was updated
	 */
	@Override
	public it.eng.allerte.model.RubricaRuoloRubrica updateRubricaRuoloRubrica(
		it.eng.allerte.model.RubricaRuoloRubrica rubricaRuoloRubrica) {

		return _rubricaRuoloRubricaLocalService.updateRubricaRuoloRubrica(
			rubricaRuoloRubrica);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _rubricaRuoloRubricaLocalService.getBasePersistence();
	}

	@Override
	public RubricaRuoloRubricaLocalService getWrappedService() {
		return _rubricaRuoloRubricaLocalService;
	}

	@Override
	public void setWrappedService(
		RubricaRuoloRubricaLocalService rubricaRuoloRubricaLocalService) {

		_rubricaRuoloRubricaLocalService = rubricaRuoloRubricaLocalService;
	}

	private RubricaRuoloRubricaLocalService _rubricaRuoloRubricaLocalService;

}