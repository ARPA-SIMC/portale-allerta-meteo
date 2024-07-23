/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package allerta.catasto.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SottocategoriaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SottocategoriaLocalService
 * @generated
 */
@ProviderType
public class SottocategoriaLocalServiceWrapper
	implements SottocategoriaLocalService,
			   ServiceWrapper<SottocategoriaLocalService> {

	public SottocategoriaLocalServiceWrapper(
		SottocategoriaLocalService sottocategoriaLocalService) {

		_sottocategoriaLocalService = sottocategoriaLocalService;
	}

	/**
	 * Adds the sottocategoria to the database. Also notifies the appropriate model listeners.
	 *
	 * @param sottocategoria the sottocategoria
	 * @return the sottocategoria that was added
	 */
	@Override
	public allerta.catasto.model.Sottocategoria addSottocategoria(
		allerta.catasto.model.Sottocategoria sottocategoria) {

		return _sottocategoriaLocalService.addSottocategoria(sottocategoria);
	}

	/**
	 * Creates a new sottocategoria with the primary key. Does not add the sottocategoria to the database.
	 *
	 * @param sottocategoriaPK the primary key for the new sottocategoria
	 * @return the new sottocategoria
	 */
	@Override
	public allerta.catasto.model.Sottocategoria createSottocategoria(
		allerta.catasto.service.persistence.SottocategoriaPK sottocategoriaPK) {

		return _sottocategoriaLocalService.createSottocategoria(
			sottocategoriaPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sottocategoriaLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the sottocategoria from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sottocategoria the sottocategoria
	 * @return the sottocategoria that was removed
	 */
	@Override
	public allerta.catasto.model.Sottocategoria deleteSottocategoria(
		allerta.catasto.model.Sottocategoria sottocategoria) {

		return _sottocategoriaLocalService.deleteSottocategoria(sottocategoria);
	}

	/**
	 * Deletes the sottocategoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria that was removed
	 * @throws PortalException if a sottocategoria with the primary key could not be found
	 */
	@Override
	public allerta.catasto.model.Sottocategoria deleteSottocategoria(
			allerta.catasto.service.persistence.SottocategoriaPK
				sottocategoriaPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sottocategoriaLocalService.deleteSottocategoria(
			sottocategoriaPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _sottocategoriaLocalService.dynamicQuery();
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

		return _sottocategoriaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.SottocategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _sottocategoriaLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.SottocategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _sottocategoriaLocalService.dynamicQuery(
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

		return _sottocategoriaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _sottocategoriaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public allerta.catasto.model.Sottocategoria fetchSottocategoria(
		allerta.catasto.service.persistence.SottocategoriaPK sottocategoriaPK) {

		return _sottocategoriaLocalService.fetchSottocategoria(
			sottocategoriaPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _sottocategoriaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _sottocategoriaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _sottocategoriaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sottocategoriaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the sottocategoria with the primary key.
	 *
	 * @param sottocategoriaPK the primary key of the sottocategoria
	 * @return the sottocategoria
	 * @throws PortalException if a sottocategoria with the primary key could not be found
	 */
	@Override
	public allerta.catasto.model.Sottocategoria getSottocategoria(
			allerta.catasto.service.persistence.SottocategoriaPK
				sottocategoriaPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _sottocategoriaLocalService.getSottocategoria(sottocategoriaPK);
	}

	/**
	 * Returns a range of all the sottocategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>allerta.catasto.model.impl.SottocategoriaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sottocategorias
	 * @param end the upper bound of the range of sottocategorias (not inclusive)
	 * @return the range of sottocategorias
	 */
	@Override
	public java.util.List<allerta.catasto.model.Sottocategoria>
		getSottocategorias(int start, int end) {

		return _sottocategoriaLocalService.getSottocategorias(start, end);
	}

	/**
	 * Returns the number of sottocategorias.
	 *
	 * @return the number of sottocategorias
	 */
	@Override
	public int getSottocategoriasCount() {
		return _sottocategoriaLocalService.getSottocategoriasCount();
	}

	/**
	 * Updates the sottocategoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param sottocategoria the sottocategoria
	 * @return the sottocategoria that was updated
	 */
	@Override
	public allerta.catasto.model.Sottocategoria updateSottocategoria(
		allerta.catasto.model.Sottocategoria sottocategoria) {

		return _sottocategoriaLocalService.updateSottocategoria(sottocategoria);
	}

	@Override
	public SottocategoriaLocalService getWrappedService() {
		return _sottocategoriaLocalService;
	}

	@Override
	public void setWrappedService(
		SottocategoriaLocalService sottocategoriaLocalService) {

		_sottocategoriaLocalService = sottocategoriaLocalService;
	}

	private SottocategoriaLocalService _sottocategoriaLocalService;

}