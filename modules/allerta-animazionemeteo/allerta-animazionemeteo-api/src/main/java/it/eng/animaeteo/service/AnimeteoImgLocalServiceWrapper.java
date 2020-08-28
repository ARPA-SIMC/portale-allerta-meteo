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
 * Provides a wrapper for {@link AnimeteoImgLocalService}.
 *
 * @author UTENTE
 * @see AnimeteoImgLocalService
 * @generated
 */
@ProviderType
public class AnimeteoImgLocalServiceWrapper
	implements AnimeteoImgLocalService,
			   ServiceWrapper<AnimeteoImgLocalService> {

	public AnimeteoImgLocalServiceWrapper(
		AnimeteoImgLocalService animeteoImgLocalService) {

		_animeteoImgLocalService = animeteoImgLocalService;
	}

	/**
	 * Adds the animeteo img to the database. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoImg the animeteo img
	 * @return the animeteo img that was added
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoImg addAnimeteoImg(
		it.eng.animaeteo.model.AnimeteoImg animeteoImg) {

		return _animeteoImgLocalService.addAnimeteoImg(animeteoImg);
	}

	/**
	 * Creates a new animeteo img with the primary key. Does not add the animeteo img to the database.
	 *
	 * @param id the primary key for the new animeteo img
	 * @return the new animeteo img
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoImg createAnimeteoImg(long id) {
		return _animeteoImgLocalService.createAnimeteoImg(id);
	}

	/**
	 * Deletes the animeteo img from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoImg the animeteo img
	 * @return the animeteo img that was removed
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoImg deleteAnimeteoImg(
		it.eng.animaeteo.model.AnimeteoImg animeteoImg) {

		return _animeteoImgLocalService.deleteAnimeteoImg(animeteoImg);
	}

	/**
	 * Deletes the animeteo img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img that was removed
	 * @throws PortalException if a animeteo img with the primary key could not be found
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoImg deleteAnimeteoImg(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoImgLocalService.deleteAnimeteoImg(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoImgLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _animeteoImgLocalService.dynamicQuery();
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

		return _animeteoImgLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _animeteoImgLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _animeteoImgLocalService.dynamicQuery(
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

		return _animeteoImgLocalService.dynamicQueryCount(dynamicQuery);
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

		return _animeteoImgLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public it.eng.animaeteo.model.AnimeteoImg fetchAnimeteoImg(long id) {
		return _animeteoImgLocalService.fetchAnimeteoImg(id);
	}

	@Override
	public java.util.List<it.eng.animaeteo.model.AnimeteoImg> findByType(
			String type)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _animeteoImgLocalService.findByType(type);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _animeteoImgLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the animeteo img with the primary key.
	 *
	 * @param id the primary key of the animeteo img
	 * @return the animeteo img
	 * @throws PortalException if a animeteo img with the primary key could not be found
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoImg getAnimeteoImg(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoImgLocalService.getAnimeteoImg(id);
	}

	/**
	 * Returns a range of all the animeteo imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo imgs
	 * @param end the upper bound of the range of animeteo imgs (not inclusive)
	 * @return the range of animeteo imgs
	 */
	@Override
	public java.util.List<it.eng.animaeteo.model.AnimeteoImg> getAnimeteoImgs(
		int start, int end) {

		return _animeteoImgLocalService.getAnimeteoImgs(start, end);
	}

	/**
	 * Returns the number of animeteo imgs.
	 *
	 * @return the number of animeteo imgs
	 */
	@Override
	public int getAnimeteoImgsCount() {
		return _animeteoImgLocalService.getAnimeteoImgsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _animeteoImgLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _animeteoImgLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _animeteoImgLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the animeteo img in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoImg the animeteo img
	 * @return the animeteo img that was updated
	 */
	@Override
	public it.eng.animaeteo.model.AnimeteoImg updateAnimeteoImg(
		it.eng.animaeteo.model.AnimeteoImg animeteoImg) {

		return _animeteoImgLocalService.updateAnimeteoImg(animeteoImg);
	}

	@Override
	public AnimeteoImgLocalService getWrappedService() {
		return _animeteoImgLocalService;
	}

	@Override
	public void setWrappedService(
		AnimeteoImgLocalService animeteoImgLocalService) {

		_animeteoImgLocalService = animeteoImgLocalService;
	}

	private AnimeteoImgLocalService _animeteoImgLocalService;

}