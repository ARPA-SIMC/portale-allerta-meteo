/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.parer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ComponentiInvioLocalService}.
 *
 * @author Pratola_L
 * @see ComponentiInvioLocalService
 * @generated
 */
public class ComponentiInvioLocalServiceWrapper
	implements ComponentiInvioLocalService,
			   ServiceWrapper<ComponentiInvioLocalService> {

	public ComponentiInvioLocalServiceWrapper() {
		this(null);
	}

	public ComponentiInvioLocalServiceWrapper(
		ComponentiInvioLocalService componentiInvioLocalService) {

		_componentiInvioLocalService = componentiInvioLocalService;
	}

	/**
	 * Adds the componenti invio to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComponentiInvioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param componentiInvio the componenti invio
	 * @return the componenti invio that was added
	 */
	@Override
	public it.eng.parer.model.ComponentiInvio addComponentiInvio(
		it.eng.parer.model.ComponentiInvio componentiInvio) {

		return _componentiInvioLocalService.addComponentiInvio(componentiInvio);
	}

	/**
	 * Creates a new componenti invio with the primary key. Does not add the componenti invio to the database.
	 *
	 * @param componentiInvioPK the primary key for the new componenti invio
	 * @return the new componenti invio
	 */
	@Override
	public it.eng.parer.model.ComponentiInvio createComponentiInvio(
		it.eng.parer.service.persistence.ComponentiInvioPK componentiInvioPK) {

		return _componentiInvioLocalService.createComponentiInvio(
			componentiInvioPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentiInvioLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the componenti invio from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComponentiInvioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param componentiInvio the componenti invio
	 * @return the componenti invio that was removed
	 */
	@Override
	public it.eng.parer.model.ComponentiInvio deleteComponentiInvio(
		it.eng.parer.model.ComponentiInvio componentiInvio) {

		return _componentiInvioLocalService.deleteComponentiInvio(
			componentiInvio);
	}

	/**
	 * Deletes the componenti invio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComponentiInvioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param componentiInvioPK the primary key of the componenti invio
	 * @return the componenti invio that was removed
	 * @throws PortalException if a componenti invio with the primary key could not be found
	 */
	@Override
	public it.eng.parer.model.ComponentiInvio deleteComponentiInvio(
			it.eng.parer.service.persistence.ComponentiInvioPK
				componentiInvioPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentiInvioLocalService.deleteComponentiInvio(
			componentiInvioPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentiInvioLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _componentiInvioLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _componentiInvioLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _componentiInvioLocalService.dynamicQuery();
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

		return _componentiInvioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.ComponentiInvioModelImpl</code>.
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

		return _componentiInvioLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.ComponentiInvioModelImpl</code>.
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

		return _componentiInvioLocalService.dynamicQuery(
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

		return _componentiInvioLocalService.dynamicQueryCount(dynamicQuery);
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

		return _componentiInvioLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.parer.model.ComponentiInvio fetchComponentiInvio(
		it.eng.parer.service.persistence.ComponentiInvioPK componentiInvioPK) {

		return _componentiInvioLocalService.fetchComponentiInvio(
			componentiInvioPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _componentiInvioLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the componenti invio with the primary key.
	 *
	 * @param componentiInvioPK the primary key of the componenti invio
	 * @return the componenti invio
	 * @throws PortalException if a componenti invio with the primary key could not be found
	 */
	@Override
	public it.eng.parer.model.ComponentiInvio getComponentiInvio(
			it.eng.parer.service.persistence.ComponentiInvioPK
				componentiInvioPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentiInvioLocalService.getComponentiInvio(
			componentiInvioPK);
	}

	/**
	 * Returns a range of all the componenti invios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.parer.model.impl.ComponentiInvioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of componenti invios
	 * @param end the upper bound of the range of componenti invios (not inclusive)
	 * @return the range of componenti invios
	 */
	@Override
	public java.util.List<it.eng.parer.model.ComponentiInvio>
		getComponentiInvios(int start, int end) {

		return _componentiInvioLocalService.getComponentiInvios(start, end);
	}

	/**
	 * Returns the number of componenti invios.
	 *
	 * @return the number of componenti invios
	 */
	@Override
	public int getComponentiInviosCount() {
		return _componentiInvioLocalService.getComponentiInviosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _componentiInvioLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public it.eng.parer.model.ComponentiInvio getNuovoComponenteInvio() {
		return _componentiInvioLocalService.getNuovoComponenteInvio();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _componentiInvioLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentiInvioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the componenti invio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComponentiInvioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param componentiInvio the componenti invio
	 * @return the componenti invio that was updated
	 */
	@Override
	public it.eng.parer.model.ComponentiInvio updateComponentiInvio(
		it.eng.parer.model.ComponentiInvio componentiInvio) {

		return _componentiInvioLocalService.updateComponentiInvio(
			componentiInvio);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _componentiInvioLocalService.getBasePersistence();
	}

	@Override
	public ComponentiInvioLocalService getWrappedService() {
		return _componentiInvioLocalService;
	}

	@Override
	public void setWrappedService(
		ComponentiInvioLocalService componentiInvioLocalService) {

		_componentiInvioLocalService = componentiInvioLocalService;
	}

	private ComponentiInvioLocalService _componentiInvioLocalService;

}