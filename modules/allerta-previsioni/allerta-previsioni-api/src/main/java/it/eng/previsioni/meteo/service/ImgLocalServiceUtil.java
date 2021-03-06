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

package it.eng.previsioni.meteo.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Img. This utility wraps
 * <code>it.eng.previsioni.meteo.service.impl.ImgLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ImgLocalService
 * @generated
 */
@ProviderType
public class ImgLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.previsioni.meteo.service.impl.ImgLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the img to the database. Also notifies the appropriate model listeners.
	 *
	 * @param img the img
	 * @return the img that was added
	 */
	public static it.eng.previsioni.meteo.model.Img addImg(
		it.eng.previsioni.meteo.model.Img img) {

		return getService().addImg(img);
	}

	/**
	 * Creates a new img with the primary key. Does not add the img to the database.
	 *
	 * @param id the primary key for the new img
	 * @return the new img
	 */
	public static it.eng.previsioni.meteo.model.Img createImg(long id) {
		return getService().createImg(id);
	}

	/**
	 * Deletes the img from the database. Also notifies the appropriate model listeners.
	 *
	 * @param img the img
	 * @return the img that was removed
	 */
	public static it.eng.previsioni.meteo.model.Img deleteImg(
		it.eng.previsioni.meteo.model.Img img) {

		return getService().deleteImg(img);
	}

	/**
	 * Deletes the img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the img
	 * @return the img that was removed
	 * @throws PortalException if a img with the primary key could not be found
	 */
	public static it.eng.previsioni.meteo.model.Img deleteImg(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteImg(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.previsioni.meteo.model.impl.ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.previsioni.meteo.model.impl.ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.eng.previsioni.meteo.model.Img fetchImg(long id) {
		return getService().fetchImg(id);
	}

	public static java.util.List<it.eng.previsioni.meteo.model.Img> findByDay(
			String day)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().findByDay(day);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<it.eng.previsioni.meteo.model.Img>
			getByDayProvincia(String day, String provincia)
		throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getByDayProvincia(day, provincia);
	}

	public static it.eng.previsioni.meteo.model.Img getByPartDayProvincia(
			String part, String day, String provincia)
		throws com.liferay.portal.kernel.exception.SystemException,
			   it.eng.previsioni.meteo.exception.NoSuchImgException {

		return getService().getByPartDayProvincia(part, day, provincia);
	}

	/**
	 * Returns the img with the primary key.
	 *
	 * @param id the primary key of the img
	 * @return the img
	 * @throws PortalException if a img with the primary key could not be found
	 */
	public static it.eng.previsioni.meteo.model.Img getImg(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getImg(id);
	}

	/**
	 * Returns a range of all the imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.previsioni.meteo.model.impl.ImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of imgs
	 * @param end the upper bound of the range of imgs (not inclusive)
	 * @return the range of imgs
	 */
	public static java.util.List<it.eng.previsioni.meteo.model.Img> getImgs(
		int start, int end) {

		return getService().getImgs(start, end);
	}

	/**
	 * Returns the number of imgs.
	 *
	 * @return the number of imgs
	 */
	public static int getImgsCount() {
		return getService().getImgsCount();
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
	 * Updates the img in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param img the img
	 * @return the img that was updated
	 */
	public static it.eng.previsioni.meteo.model.Img updateImg(
		it.eng.previsioni.meteo.model.Img img) {

		return getService().updateImg(img);
	}

	public static ImgLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ImgLocalService, ImgLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ImgLocalService.class);

		ServiceTracker<ImgLocalService, ImgLocalService> serviceTracker =
			new ServiceTracker<ImgLocalService, ImgLocalService>(
				bundle.getBundleContext(), ImgLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}