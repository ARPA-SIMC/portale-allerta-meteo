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

package it.eng.animaeteo.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnimeteoSmallImgLocalService}.
 *
 * @author UTENTE
 * @see AnimeteoSmallImgLocalService
 * @generated
 */
@ProviderType
public class AnimeteoSmallImgLocalServiceWrapper
	implements AnimeteoSmallImgLocalService,
			   ServiceWrapper<AnimeteoSmallImgLocalService> {

	public AnimeteoSmallImgLocalServiceWrapper(
		AnimeteoSmallImgLocalService animeteoSmallImgLocalService) {

		_animeteoSmallImgLocalService = animeteoSmallImgLocalService;
	}

	/**
	 * Adds the animeteo small img to the database. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was added
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg addAnimeteoSmallImg(
		it.eng.animaeteo.model.AnimeteoSmallImg animeteoSmallImg) {

		return _animeteoSmallImgLocalService.addAnimeteoSmallImg(
			animeteoSmallImg);
	}

	/**
	 * Creates a new animeteo small img with the primary key. Does not add the animeteo small img to the database.
	 *
	 * @param id the primary key for the new animeteo small img
	 * @return the new animeteo small img
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg createAnimeteoSmallImg(
		long id) {

		return _animeteoSmallImgLocalService.createAnimeteoSmallImg(id);
	}

	/**
	 * Deletes the animeteo small img from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was removed
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg deleteAnimeteoSmallImg(
		it.eng.animaeteo.model.AnimeteoSmallImg animeteoSmallImg) {

		return _animeteoSmallImgLocalService.deleteAnimeteoSmallImg(
			animeteoSmallImg);
	}

	/**
	 * Deletes the animeteo small img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img that was removed
	 * @throws PortalException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg deleteAnimeteoSmallImg(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoSmallImgLocalService.deleteAnimeteoSmallImg(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoSmallImgLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _animeteoSmallImgLocalService.dynamicQuery();
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

		return _animeteoSmallImgLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _animeteoSmallImgLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _animeteoSmallImgLocalService.dynamicQuery(
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

		return _animeteoSmallImgLocalService.dynamicQueryCount(dynamicQuery);
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

		return _animeteoSmallImgLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg fetchAnimeteoSmallImg(
		long id) {

		return _animeteoSmallImgLocalService.fetchAnimeteoSmallImg(id);
	}

	@Override
	public java.util.List<it.eng.animaeteo.model.AnimeteoSmallImg> findByType(
			String type)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _animeteoSmallImgLocalService.findByType(type);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _animeteoSmallImgLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the animeteo small img with the primary key.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img
	 * @throws PortalException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg getAnimeteoSmallImg(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoSmallImgLocalService.getAnimeteoSmallImg(id);
	}

	/**
	 * Returns a range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @return the range of animeteo small imgs
	 */
	@Override
	public java.util.List<it.eng.animaeteo.model.AnimeteoSmallImg>
		getAnimeteoSmallImgs(int start, int end) {

		return _animeteoSmallImgLocalService.getAnimeteoSmallImgs(start, end);
	}

	/**
	 * Returns the number of animeteo small imgs.
	 *
	 * @return the number of animeteo small imgs
	 */
	@Override
	public int getAnimeteoSmallImgsCount() {
		return _animeteoSmallImgLocalService.getAnimeteoSmallImgsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _animeteoSmallImgLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _animeteoSmallImgLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoSmallImgLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the animeteo small img in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was updated
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoSmallImg updateAnimeteoSmallImg(
		it.eng.animaeteo.model.AnimeteoSmallImg animeteoSmallImg) {

		return _animeteoSmallImgLocalService.updateAnimeteoSmallImg(
			animeteoSmallImg);
	}

	@Override
	public AnimeteoSmallImgLocalService getWrappedService() {
		return _animeteoSmallImgLocalService;
	}

	@Override
	public void setWrappedService(
		AnimeteoSmallImgLocalService animeteoSmallImgLocalService) {

		_animeteoSmallImgLocalService = animeteoSmallImgLocalService;
	}

	private AnimeteoSmallImgLocalService _animeteoSmallImgLocalService;

}