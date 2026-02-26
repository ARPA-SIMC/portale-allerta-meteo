/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package it.eng.bollettino.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link IconaLocalService}.
 *
 * @author GFAVINI
 * @see IconaLocalService
 * @generated
 */
public class IconaLocalServiceWrapper
	implements IconaLocalService, ServiceWrapper<IconaLocalService> {

	public IconaLocalServiceWrapper() {
		this(null);
	}

	public IconaLocalServiceWrapper(IconaLocalService iconaLocalService) {
		_iconaLocalService = iconaLocalService;
	}

	/**
	 * Adds the icona to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IconaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param icona the icona
	 * @return the icona that was added
	 */
	@Override
	public it.eng.bollettino.model.Icona addIcona(
		it.eng.bollettino.model.Icona icona) {

		return _iconaLocalService.addIcona(icona);
	}

	/**
	 * Creates a new icona with the primary key. Does not add the icona to the database.
	 *
	 * @param id the primary key for the new icona
	 * @return the new icona
	 */
	@Override
	public it.eng.bollettino.model.Icona createIcona(long id) {
		return _iconaLocalService.createIcona(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _iconaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the icona from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IconaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param icona the icona
	 * @return the icona that was removed
	 */
	@Override
	public it.eng.bollettino.model.Icona deleteIcona(
		it.eng.bollettino.model.Icona icona) {

		return _iconaLocalService.deleteIcona(icona);
	}

	/**
	 * Deletes the icona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IconaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the icona
	 * @return the icona that was removed
	 * @throws PortalException if a icona with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Icona deleteIcona(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _iconaLocalService.deleteIcona(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _iconaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _iconaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _iconaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _iconaLocalService.dynamicQuery();
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

		return _iconaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.IconaModelImpl</code>.
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

		return _iconaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.IconaModelImpl</code>.
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

		return _iconaLocalService.dynamicQuery(
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

		return _iconaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _iconaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.eng.bollettino.model.Icona fetchIcona(long id) {
		return _iconaLocalService.fetchIcona(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _iconaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the icona with the primary key.
	 *
	 * @param id the primary key of the icona
	 * @return the icona
	 * @throws PortalException if a icona with the primary key could not be found
	 */
	@Override
	public it.eng.bollettino.model.Icona getIcona(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _iconaLocalService.getIcona(id);
	}

	/**
	 * Returns a range of all the iconas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.eng.bollettino.model.impl.IconaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of iconas
	 * @param end the upper bound of the range of iconas (not inclusive)
	 * @return the range of iconas
	 */
	@Override
	public java.util.List<it.eng.bollettino.model.Icona> getIconas(
		int start, int end) {

		return _iconaLocalService.getIconas(start, end);
	}

	/**
	 * Returns the number of iconas.
	 *
	 * @return the number of iconas
	 */
	@Override
	public int getIconasCount() {
		return _iconaLocalService.getIconasCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _iconaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _iconaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _iconaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the icona in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IconaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param icona the icona
	 * @return the icona that was updated
	 */
	@Override
	public it.eng.bollettino.model.Icona updateIcona(
		it.eng.bollettino.model.Icona icona) {

		return _iconaLocalService.updateIcona(icona);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _iconaLocalService.getBasePersistence();
	}

	@Override
	public IconaLocalService getWrappedService() {
		return _iconaLocalService;
	}

	@Override
	public void setWrappedService(IconaLocalService iconaLocalService) {
		_iconaLocalService = iconaLocalService;
	}

	private IconaLocalService _iconaLocalService;

}