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

package it.eng.animazione.image.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for PioggiaCumulativa. This utility wraps
 * <code>it.eng.animazione.image.service.impl.PioggiaCumulativaLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author UTENTE
 * @see PioggiaCumulativaLocalService
 * @generated
 */
@ProviderType
public class PioggiaCumulativaLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.animazione.image.service.impl.PioggiaCumulativaLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the pioggia cumulativa to the database. Also notifies the appropriate model listeners.
	 *
	 * @param pioggiaCumulativa the pioggia cumulativa
	 * @return the pioggia cumulativa that was added
	 */
	public static it.eng.animazione.image.model.PioggiaCumulativa
		addPioggiaCumulativa(
			it.eng.animazione.image.model.PioggiaCumulativa pioggiaCumulativa) {

		return getService().addPioggiaCumulativa(pioggiaCumulativa);
	}

	/**
	 * Creates a new pioggia cumulativa with the primary key. Does not add the pioggia cumulativa to the database.
	 *
	 * @param id the primary key for the new pioggia cumulativa
	 * @return the new pioggia cumulativa
	 */
	public static it.eng.animazione.image.model.PioggiaCumulativa
		createPioggiaCumulativa(long id) {

		return getService().createPioggiaCumulativa(id);
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

	/**
	 * Deletes the pioggia cumulativa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa that was removed
	 * @throws PortalException if a pioggia cumulativa with the primary key could not be found
	 */
	public static it.eng.animazione.image.model.PioggiaCumulativa
			deletePioggiaCumulativa(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePioggiaCumulativa(id);
	}

	/**
	 * Deletes the pioggia cumulativa from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pioggiaCumulativa the pioggia cumulativa
	 * @return the pioggia cumulativa that was removed
	 */
	public static it.eng.animazione.image.model.PioggiaCumulativa
		deletePioggiaCumulativa(
			it.eng.animazione.image.model.PioggiaCumulativa pioggiaCumulativa) {

		return getService().deletePioggiaCumulativa(pioggiaCumulativa);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static it.eng.animazione.image.model.PioggiaCumulativa
		fetchPioggiaCumulativa(long id) {

		return getService().fetchPioggiaCumulativa(id);
	}

	public static java.util.List
		<it.eng.animazione.image.model.PioggiaCumulativa> findByCumulazione(
				String cumulazione)
			throws com.liferay.portal.kernel.exception.SystemException,
				   it.eng.animazione.image.exception.
					   NoSuchPioggiaCumulativaException {

		return getService().findByCumulazione(cumulazione);
	}

	public static it.eng.animazione.image.model.PioggiaCumulativa findByID(
			long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			   it.eng.animazione.image.exception.
				   NoSuchPioggiaCumulativaException {

		return getService().findByID(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the pioggia cumulativa with the primary key.
	 *
	 * @param id the primary key of the pioggia cumulativa
	 * @return the pioggia cumulativa
	 * @throws PortalException if a pioggia cumulativa with the primary key could not be found
	 */
	public static it.eng.animazione.image.model.PioggiaCumulativa
			getPioggiaCumulativa(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPioggiaCumulativa(id);
	}

	/**
	 * Returns a range of all the pioggia cumulativas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animazione.image.model.impl.PioggiaCumulativaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of pioggia cumulativas
	 * @param end the upper bound of the range of pioggia cumulativas (not inclusive)
	 * @return the range of pioggia cumulativas
	 */
	public static java.util.List
		<it.eng.animazione.image.model.PioggiaCumulativa> getPioggiaCumulativas(
			int start, int end) {

		return getService().getPioggiaCumulativas(start, end);
	}

	/**
	 * Returns the number of pioggia cumulativas.
	 *
	 * @return the number of pioggia cumulativas
	 */
	public static int getPioggiaCumulativasCount() {
		return getService().getPioggiaCumulativasCount();
	}

	/**
	 * Updates the pioggia cumulativa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param pioggiaCumulativa the pioggia cumulativa
	 * @return the pioggia cumulativa that was updated
	 */
	public static it.eng.animazione.image.model.PioggiaCumulativa
		updatePioggiaCumulativa(
			it.eng.animazione.image.model.PioggiaCumulativa pioggiaCumulativa) {

		return getService().updatePioggiaCumulativa(pioggiaCumulativa);
	}

	public static PioggiaCumulativaLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PioggiaCumulativaLocalService, PioggiaCumulativaLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PioggiaCumulativaLocalService.class);

		ServiceTracker
			<PioggiaCumulativaLocalService, PioggiaCumulativaLocalService>
				serviceTracker =
					new ServiceTracker
						<PioggiaCumulativaLocalService,
						 PioggiaCumulativaLocalService>(
							 bundle.getBundleContext(),
							 PioggiaCumulativaLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}