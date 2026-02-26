/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.allerte.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RubricaCanaleLocalService}.
 *
 * @author Pratola_L
 * @see RubricaCanaleLocalService
 * @generated
 */
public class RubricaCanaleLocalServiceWrapper
	implements RubricaCanaleLocalService,
			   ServiceWrapper<RubricaCanaleLocalService> {

	public RubricaCanaleLocalServiceWrapper() {
		this(null);
	}

	public RubricaCanaleLocalServiceWrapper(
		RubricaCanaleLocalService rubricaCanaleLocalService) {

		_rubricaCanaleLocalService = rubricaCanaleLocalService;
	}

	/**
	 * Adds the rubrica canale to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaCanaleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaCanale the rubrica canale
	 * @return the rubrica canale that was added
	 */
	@Override
	public it.eng.allerte.model.RubricaCanale addRubricaCanale(
		it.eng.allerte.model.RubricaCanale rubricaCanale) {

		return _rubricaCanaleLocalService.addRubricaCanale(rubricaCanale);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaCanaleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new rubrica canale with the primary key. Does not add the rubrica canale to the database.
	 *
	 * @param ID_CANALE the primary key for the new rubrica canale
	 * @return the new rubrica canale
	 */
	@Override
	public it.eng.allerte.model.RubricaCanale createRubricaCanale(
		long ID_CANALE) {

		return _rubricaCanaleLocalService.createRubricaCanale(ID_CANALE);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaCanaleLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rubrica canale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaCanaleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale that was removed
	 * @throws PortalException if a rubrica canale with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaCanale deleteRubricaCanale(
			long ID_CANALE)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaCanaleLocalService.deleteRubricaCanale(ID_CANALE);
	}

	/**
	 * Deletes the rubrica canale from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaCanaleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaCanale the rubrica canale
	 * @return the rubrica canale that was removed
	 */
	@Override
	public it.eng.allerte.model.RubricaCanale deleteRubricaCanale(
		it.eng.allerte.model.RubricaCanale rubricaCanale) {

		return _rubricaCanaleLocalService.deleteRubricaCanale(rubricaCanale);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _rubricaCanaleLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _rubricaCanaleLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rubricaCanaleLocalService.dynamicQuery();
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

		return _rubricaCanaleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaCanaleModelImpl</code>.
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

		return _rubricaCanaleLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaCanaleModelImpl</code>.
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

		return _rubricaCanaleLocalService.dynamicQuery(
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

		return _rubricaCanaleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _rubricaCanaleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.allerte.model.RubricaCanale fetchRubricaCanale(
		long ID_CANALE) {

		return _rubricaCanaleLocalService.fetchRubricaCanale(ID_CANALE);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _rubricaCanaleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Il metodo ritorna la descrizione del canale
	 *
	 * @param idCanale
	 * @return
	 */
	@Override
	public String getDescrRubricaCanale(long idCanale) {
		return _rubricaCanaleLocalService.getDescrRubricaCanale(idCanale);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _rubricaCanaleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _rubricaCanaleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaCanaleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rubrica canale with the primary key.
	 *
	 * @param ID_CANALE the primary key of the rubrica canale
	 * @return the rubrica canale
	 * @throws PortalException if a rubrica canale with the primary key could not be found
	 */
	@Override
	public it.eng.allerte.model.RubricaCanale getRubricaCanale(long ID_CANALE)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _rubricaCanaleLocalService.getRubricaCanale(ID_CANALE);
	}

	/**
	 * Returns a range of all the rubrica canales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.allerte.model.impl.RubricaCanaleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rubrica canales
	 * @param end the upper bound of the range of rubrica canales (not inclusive)
	 * @return the range of rubrica canales
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaCanale> getRubricaCanales(
		int start, int end) {

		return _rubricaCanaleLocalService.getRubricaCanales(start, end);
	}

	/**
	 * Returns the number of rubrica canales.
	 *
	 * @return the number of rubrica canales
	 */
	@Override
	public int getRubricaCanalesCount() {
		return _rubricaCanaleLocalService.getRubricaCanalesCount();
	}

	/**
	 * Il metodo ritorna la lista dei tipi di canali della rubrica (cell, mail, telefono)
	 */
	@Override
	public java.util.List<it.eng.allerte.model.RubricaCanale>
		getRubricaCanali() {

		return _rubricaCanaleLocalService.getRubricaCanali();
	}

	/**
	 * Updates the rubrica canale in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RubricaCanaleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param rubricaCanale the rubrica canale
	 * @return the rubrica canale that was updated
	 */
	@Override
	public it.eng.allerte.model.RubricaCanale updateRubricaCanale(
		it.eng.allerte.model.RubricaCanale rubricaCanale) {

		return _rubricaCanaleLocalService.updateRubricaCanale(rubricaCanale);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _rubricaCanaleLocalService.getBasePersistence();
	}

	@Override
	public RubricaCanaleLocalService getWrappedService() {
		return _rubricaCanaleLocalService;
	}

	@Override
	public void setWrappedService(
		RubricaCanaleLocalService rubricaCanaleLocalService) {

		_rubricaCanaleLocalService = rubricaCanaleLocalService;
	}

	private RubricaCanaleLocalService _rubricaCanaleLocalService;

}