/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RubricaUtenteSitoLocalService}.
 *
 * @author Pratola_L
 * @see RubricaUtenteSitoLocalService
 * @generated
 */
public class RubricaUtenteSitoLocalServiceWrapper
	implements RubricaUtenteSitoLocalService,
			   ServiceWrapper<RubricaUtenteSitoLocalService> {

	public RubricaUtenteSitoLocalServiceWrapper() {
		this(null);
	}

	public RubricaUtenteSitoLocalServiceWrapper(
		RubricaUtenteSitoLocalService rubricaUtenteSitoLocalService) {

		_rubricaUtenteSitoLocalService = rubricaUtenteSitoLocalService;
	}

	/**
	 * Adds the rubrica utente sito to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaUtenteSitoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaUtenteSito the rubrica utente sito
	 * @return the rubrica utente sito that was added
	 */
	@Override
	public it.eng.allerte.model.RubricaUtenteSito addRubricaUtenteSito(
		it.eng.allerte.model.RubricaUtenteSito rubricaUtenteSito) {

		return _rubricaUtenteSitoLocalService.addRubricaUtenteSito(
			rubricaUtenteSito);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaUtenteSitoLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new rubrica utente sito with the primary key. Does not add the rubrica utente sito to the database.
	 *
	 * @param ID_UTENTE the primary key for the new rubrica utente sito
	 * @return the new rubrica utente sito
	 */
	@Override
	public it.eng.allerte.model.RubricaUtenteSito createRubricaUtenteSito(
		long ID_UTENTE) {

		return _rubricaUtenteSitoLocalService.createRubricaUtenteSito(
			ID_UTENTE);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaUtenteSitoLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the rubrica utente sito with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaUtenteSitoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito that was removed
	 * @throws PortalException if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaUtenteSito deleteRubricaUtenteSito(
			long ID_UTENTE)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaUtenteSitoLocalService.deleteRubricaUtenteSito(
			ID_UTENTE);
	}

	/**
	 * Deletes the rubrica utente sito from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaUtenteSitoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaUtenteSito the rubrica utente sito
	 * @return the rubrica utente sito that was removed
	 */
	@Override
	public it.eng.allerte.model.RubricaUtenteSito deleteRubricaUtenteSito(
		it.eng.allerte.model.RubricaUtenteSito rubricaUtenteSito) {

		return _rubricaUtenteSitoLocalService.deleteRubricaUtenteSito(
			rubricaUtenteSito);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _rubricaUtenteSitoLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _rubricaUtenteSitoLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rubricaUtenteSitoLocalService.dynamicQuery();
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

		return _rubricaUtenteSitoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaUtenteSitoModelImpl</code>.
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

		return _rubricaUtenteSitoLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaUtenteSitoModelImpl</code>.
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

		return _rubricaUtenteSitoLocalService.dynamicQuery(
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

		return _rubricaUtenteSitoLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rubricaUtenteSitoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerte.model.RubricaUtenteSito fetchRubricaUtenteSito(
		long ID_UTENTE) {

		return _rubricaUtenteSitoLocalService.fetchRubricaUtenteSito(ID_UTENTE);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rubricaUtenteSitoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rubricaUtenteSitoLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaUtenteSitoLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaUtenteSitoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rubrica utente sito with the primary key.
	 *
	 * @param ID_UTENTE the primary key of the rubrica utente sito
	 * @return the rubrica utente sito
	 * @throws PortalException if a rubrica utente sito with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaUtenteSito getRubricaUtenteSito(
			long ID_UTENTE)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaUtenteSitoLocalService.getRubricaUtenteSito(ID_UTENTE);
	}

	/**
	 * Returns a range of all the rubrica utente sitos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaUtenteSitoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica utente sitos
	 * @param end the upper bound of the range of rubrica utente sitos (not inclusive)
	 * @return the range of rubrica utente sitos
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaUtenteSito>
		getRubricaUtenteSitos(int start, int end) {

		return _rubricaUtenteSitoLocalService.getRubricaUtenteSitos(start, end);
	}

	/**
	 * Returns the number of rubrica utente sitos.
	 *
	 * @return the number of rubrica utente sitos
	 */
	@Override
	public int getRubricaUtenteSitosCount() {
		return _rubricaUtenteSitoLocalService.getRubricaUtenteSitosCount();
	}

	/**
	 * Updates the rubrica utente sito in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaUtenteSitoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaUtenteSito the rubrica utente sito
	 * @return the rubrica utente sito that was updated
	 */
	@Override
	public it.eng.allerte.model.RubricaUtenteSito updateRubricaUtenteSito(
		it.eng.allerte.model.RubricaUtenteSito rubricaUtenteSito) {

		return _rubricaUtenteSitoLocalService.updateRubricaUtenteSito(
			rubricaUtenteSito);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _rubricaUtenteSitoLocalService.getBasePersistence();
	}

	@Override
	public RubricaUtenteSitoLocalService getWrappedService() {
		return _rubricaUtenteSitoLocalService;
	}

	@Override
	public void setWrappedService(
		RubricaUtenteSitoLocalService rubricaUtenteSitoLocalService) {

		_rubricaUtenteSitoLocalService = rubricaUtenteSitoLocalService;
	}

	private RubricaUtenteSitoLocalService _rubricaUtenteSitoLocalService;

}