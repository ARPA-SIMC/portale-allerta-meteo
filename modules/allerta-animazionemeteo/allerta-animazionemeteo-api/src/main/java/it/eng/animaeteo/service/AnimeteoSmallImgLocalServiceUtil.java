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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AnimeteoSmallImg. This utility wraps
 * <code>it.eng.animaeteo.service.impl.AnimeteoSmallImgLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author UTENTE
 * @see AnimeteoSmallImgLocalService
 * @generated
 */
@ProviderType
public class AnimeteoSmallImgLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.animaeteo.service.impl.AnimeteoSmallImgLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the animeteo small img to the database. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was added
	 */
	public static it.eng.animaeteo.model.AnimeteoSmallImg addAnimeteoSmallImg(
		it.eng.animaeteo.model.AnimeteoSmallImg animeteoSmallImg) {

		return getService().addAnimeteoSmallImg(animeteoSmallImg);
	}

	/**
	 * Creates a new animeteo small img with the primary key. Does not add the animeteo small img to the database.
	 *
	 * @param id the primary key for the new animeteo small img
	 * @return the new animeteo small img
	 */
	public static it.eng.animaeteo.model.AnimeteoSmallImg
		createAnimeteoSmallImg(long id) {

		return getService().createAnimeteoSmallImg(id);
	}

	/**
	 * Deletes the animeteo small img from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was removed
	 */
	public static it.eng.animaeteo.model.AnimeteoSmallImg
		deleteAnimeteoSmallImg(
			it.eng.animaeteo.model.AnimeteoSmallImg animeteoSmallImg) {

		return getService().deleteAnimeteoSmallImg(animeteoSmallImg);
	}

	/**
	 * Deletes the animeteo small img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img that was removed
	 * @throws PortalException if a animeteo small img with the primary key could not be found
	 */
	public static it.eng.animaeteo.model.AnimeteoSmallImg
			deleteAnimeteoSmallImg(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAnimeteoSmallImg(id);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.eng.animaeteo.model.AnimeteoSmallImg fetchAnimeteoSmallImg(
		long id) {

		return getService().fetchAnimeteoSmallImg(id);
	}

	public static java.util.List<it.eng.animaeteo.model.AnimeteoSmallImg>
			findByType(String type)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByType(type);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the animeteo small img with the primary key.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img
	 * @throws PortalException if a animeteo small img with the primary key could not be found
	 */
	public static it.eng.animaeteo.model.AnimeteoSmallImg getAnimeteoSmallImg(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAnimeteoSmallImg(id);
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
	public static java.util.List<it.eng.animaeteo.model.AnimeteoSmallImg>
		getAnimeteoSmallImgs(int start, int end) {

		return getService().getAnimeteoSmallImgs(start, end);
	}

	/**
	 * Returns the number of animeteo small imgs.
	 *
	 * @return the number of animeteo small imgs
	 */
	public static int getAnimeteoSmallImgsCount() {
		return getService().getAnimeteoSmallImgsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the animeteo small img in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was updated
	 */
	public static it.eng.animaeteo.model.AnimeteoSmallImg
		updateAnimeteoSmallImg(
			it.eng.animaeteo.model.AnimeteoSmallImg animeteoSmallImg) {

		return getService().updateAnimeteoSmallImg(animeteoSmallImg);
	}

	public static AnimeteoSmallImgLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AnimeteoSmallImgLocalService, AnimeteoSmallImgLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AnimeteoSmallImgLocalService.class);

		ServiceTracker
			<AnimeteoSmallImgLocalService, AnimeteoSmallImgLocalService>
				serviceTracker =
					new ServiceTracker
						<AnimeteoSmallImgLocalService,
						 AnimeteoSmallImgLocalService>(
							 bundle.getBundleContext(),
							 AnimeteoSmallImgLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}